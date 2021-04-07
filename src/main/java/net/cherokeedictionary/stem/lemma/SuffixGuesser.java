package net.cherokeedictionary.stem.lemma;

import net.cherokeedictionary.stem.Syllabary;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

import net.cherokeedictionary.stem.lemma.Affixes.AffixResult;

//import java.util.List;
//import java.util.logging.Logger;
//
//import com.cherokeelessons.dict.client.ConsoleLogHandler2;
//import com.cherokeelessons.dict.engine.Affixes.AboutTo;
//import com.cherokeelessons.dict.engine.Affixes.Accidental;
//import com.cherokeelessons.dict.engine.Affixes.AffixResult;
//import com.cherokeelessons.dict.engine.Affixes.Again;
//import com.cherokeelessons.dict.engine.Affixes.AptTo;
//import com.cherokeelessons.dict.engine.Affixes.Around;
//import com.cherokeelessons.dict.engine.Affixes.But;
//import com.cherokeelessons.dict.engine.Affixes.Causative;
//import com.cherokeelessons.dict.engine.Affixes.ComeForDoing;
//import com.cherokeelessons.dict.engine.Affixes.Completely;
//import com.cherokeelessons.dict.engine.Affixes.InOnAt;
//import com.cherokeelessons.dict.engine.Affixes.IntendTo;
//import com.cherokeelessons.dict.engine.Affixes.Just;
//import com.cherokeelessons.dict.engine.Affixes.Place;
//import com.cherokeelessons.dict.engine.Affixes.Repeatedly;
//import com.cherokeelessons.dict.engine.Affixes.SoAnd;
//import com.cherokeelessons.dict.engine.Affixes.ToFor;
//import com.cherokeelessons.dict.engine.Affixes.ToForᏏ;
//import com.cherokeelessons.dict.engine.Affixes.Towards;
//import com.cherokeelessons.dict.engine.Affixes.Truly;
//import com.cherokeelessons.dict.engine.Affixes.Very;
//import com.cherokeelessons.dict.engine.Affixes.WentForDoing;
//import com.cherokeelessons.dict.engine.Affixes.YesNo;
//import com.cherokeelessons.dict.engine.Affixes.YesYes;
//import com.cherokeelessons.dict.shared.Log;
//import com.cherokeelessons.dict.shared.Syllabary;
//import com.cherokeelessons.dict.shared.Syllabary.Vowel;
//
//import commons.lang3.StringUtils;

public enum SuffixGuesser {

	INSTANCE;

	public static enum Stem {
		Present, Past, Progressive, Immediate, Deverbal
	}
	
//	private final Logger logger = Log.getGwtLogger(new ConsoleLogHandler2(), this.getClass().getSimpleName());

	private SuffixGuesser() {
	}

	public static class Without extends Affixes {
		@Override
		public AffixResult match(String syllabary) {
			if (syllabary.startsWith("Ᏹ")) {
				syllabary = syllabary.substring(1);
			}
			AffixResult match = super.match(syllabary);
			if (match.isMatch) {
				String prefix = StringUtils.left(match.stem, 1);
				prefix = Syllabary.chr2lat(prefix).substring(1);
				prefix = Syllabary.lat2chr(prefix);
				if (prefix.equals("Ꭲ")){
					prefix="";
				}
				match.stem=prefix+match.stem.substring(1);
			}
			return match;
		}

		public Without() {
			completiveStem = true;
			addSet("Ꭵ", "Ꮎ");
		}
	}
	
	/**
	 * Simple future tense matcher, will not match all prefixed versions! 
	 * @author mjoyner
	 *
	 */
	public static class Future extends Affixes {
		@Override
		public AffixResult match(String syllabary) {
			AffixResult match = super.match(syllabary);
			if (!match.isMatch) {
				return match;
			}
			StringBuilder prefix=new StringBuilder();
			if (syllabary.startsWith("Ᏹ")) {
				syllabary = syllabary.substring(1);
				prefix.append("Ᏹ");
			}
			if (syllabary.startsWith("Ꮒ")) {
				syllabary = syllabary.substring(1);
				prefix.append("Ꮒ");
			}
			if (!syllabary.matches("Ꮩ?[ᏓᏗᏛ].*")) {
				return new AffixResult();
			}
			if (syllabary.startsWith("Ꮩ")){
				syllabary=syllabary.substring(1);
				prefix.append("Ꮩ");
			}
			prefix.append("Ꮣ/Ꭲ");
			match.suffix=prefix.toString();
			munge: {
				if (syllabary.matches("Ꮣ[ᏯᏰᏱᏲᏳᏴ].*")){
					String tmp = StringUtils.left(syllabary, 2).substring(1);
					syllabary=syllabary.substring(2);
					String lat = Syllabary.chr2lat(tmp).substring(1);
					syllabary = Syllabary.lat2chr(lat)+syllabary;
					break munge;
				}
				if (syllabary.startsWith("Ꮣ")){
					syllabary=syllabary.substring(1);
					break munge;
				}
				if (syllabary.startsWith("Ꮧ")){
					syllabary=syllabary.substring(1);
					break munge;
				}
				if (syllabary.startsWith("Ꮫ")){
					syllabary="Ꭰ"+syllabary.substring(1);
					break munge;
				}
			}
			match.stem=Syllabary.changeForm(syllabary, Syllabary.Vowel.Ꭵ)+"Ꭲ";
			return match;
		}
		public Future() {
			completiveStem = true;
			addSet("", "Ꭲ");
		}
	}

	public static class Tool extends Affixes {
		public Tool() {
			completiveStem = false;
			addSet("", "ᏍᏙᏗ");
		}
	}

	/**
	 * Recursively scans for endings in any order... The 1840's stuff doesn't
	 * seem to follow the Disseration's description of affix usage...
	 * 
	 * @param syllabary
	 * @return
	 */
	public List<Affixes.AffixResult> getMatches(String syllabary) {
		List<Affixes.AffixResult> list = new ArrayList<Affixes.AffixResult>();
		Future futureForm = new Future();
		AffixResult future = futureForm.match(syllabary);
		if (future.isMatch) {
			future.desc = future.stem+"-Future";
			list.add(future);
			/*
			 * Should be only one valid stem for a future match.
			 */
			list.addAll(getMatches(future.stem));
			return list;
		}
		Without withoutEnding = new Without();
		AffixResult without = withoutEnding.match(syllabary);
		if (without.isMatch) {
			without.desc = without.stem+"-WithOut";
			without.suffix = "Ꮒ/" + without.suffix;
			list.add(without);
			// should only be one stem for a "without" match!
			without.stem=removeᏂprefix(without.stem);
			list.addAll(getMatches(without.stem));
			return list;
		}
		for (VerbStemAffix affix : VerbStemAffix.values()) {
			Affixes s = SuffixGuesser.getSuffixMatcher(affix);
			AffixResult matchResult = s.match(syllabary);
			if (matchResult.isMatch) {
				matchResult.desc = matchResult.stem+"-"+affix.name();
				list.add(matchResult);
				list.addAll(getMatches(matchResult.stem));
			}
		}
		for (GeneralAffix affix : GeneralAffix.values()) {
			Affixes s = SuffixGuesser.getSuffixMatcher(affix);
			AffixResult matchResult = s.match(syllabary);
			if (matchResult.isMatch) {
				matchResult.desc = matchResult.stem+"-"+affix.name();
				list.add(matchResult);
				list.addAll(getMatches(matchResult.stem));
			}
		}
		if (syllabary.endsWith("Ꭽ")){
			String tmp = StringUtils.left(syllabary, syllabary.length()-1);
			AffixResult match = new AffixResult();
			match.isMatch=true;
			match.stem=tmp;
			match.suffix="Ꭽ";
			match.desc=match.stem+"-only";
			list.add(match);
			if (Affixes.getVowelSet(Syllabary.Vowel.Ꭵ).contains(StringUtils.right(tmp, 1))){
				Syllabary.changeForm(tmp, Syllabary.Vowel.Ꭰ);
			}
			list.addAll(getMatches(tmp));
		}
		return list;
	}

	private static Affixes getSuffixMatcher(GeneralAffix affix) {
		switch (affix) {
		case Just:
			return new Affixes.Just();
		case SoAnd:
			return new Affixes.SoAnd();
		case Place:
			return new Affixes.Place();
		case YesNo:
			return new Affixes.YesNo();
		case YesYes:
			return new Affixes.YesYes();
		case But:
			return new Affixes.But();
		case Truly:
			return new Affixes.Truly();
		case Very:
			return new Affixes.Very();
		case Towards:
			return new Affixes.Towards();
		case InOnAt:
			return new Affixes.InOnAt();
		}
		throw new RuntimeException(
				"SPECIFIED SUFFIX MATCHER IS NOT IMPLEMENTED.");
	}

	private String removeᏂprefix(String word) {
		String pre = StringUtils.left(word, 1);
		word = word.substring(1);
		if (pre.equals("Ꮎ") || pre.equals("Ꮏ")) {
			pre = "Ꭰ";
		}
		if (pre.equals("Ꮑ")) {
			pre = "Ꭱ";
		}
		if (pre.equals("Ꮒ")) {
			pre = "";
		}
		if (pre.equals("Ꮓ")) {
			pre = "Ꭳ";
		}
		if (pre.equals("Ꮔ")) {
			pre = "Ꭴ";
		}
		if (pre.equals("Ꮕ")) {
			pre = "Ꭵ";
		}
		return pre + word;
	}

	public static Affixes getSuffixMatcher(VerbStemAffix affix) {
		switch (affix) {
		case AboutTo:
			return new Affixes.AboutTo();
		case Again:
			return new Affixes.Again();
		case Around:
			return new Affixes.Around();
		case ByAccident:
			return new Affixes.Accidental();
		case CameFor:
			return new Affixes.ComeForDoing();
		case Causative:
			// TODO: Causative, not past tense is special
			return new Affixes.Causative();
		case Completely:
			return new Affixes.Completely();
		case OverAndOver:
			return new Affixes.Repeatedly();
		case ToFor:
			return new Affixes.ToFor();
		case WentTo:
			return new Affixes.WentForDoing();
		case IntendTo:
			return new Affixes.IntendTo();
		case AptTo:
			return new Affixes.AptTo();
		case ToForᏏ:
			return new Affixes.ToForᏏ();
		}
		throw new RuntimeException(
				"SPECIFIED SUFFIX MATCHER IS NOT IMPLEMENTED.");
	}
}
