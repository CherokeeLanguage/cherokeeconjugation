package net.cherokeedictionary.splitter;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

//import com.cherokeelessons.dict.client.ConsoleLogHandler2;
import net.cherokeedictionary.splitter.Affixes.AboutTo;
import net.cherokeedictionary.splitter.Affixes.Accidental;
import net.cherokeedictionary.splitter.Affixes.AffixResult;
import net.cherokeedictionary.splitter.Affixes.Again;
import net.cherokeedictionary.splitter.Affixes.AptTo;
import net.cherokeedictionary.splitter.Affixes.Around;
import net.cherokeedictionary.splitter.Affixes.But;
import net.cherokeedictionary.splitter.Affixes.Causative;
import net.cherokeedictionary.splitter.Affixes.ComeForDoing;
import net.cherokeedictionary.splitter.Affixes.Completely;
import net.cherokeedictionary.splitter.Affixes.InOnAt;
import net.cherokeedictionary.splitter.Affixes.IntendTo;
import net.cherokeedictionary.splitter.Affixes.Just;
import net.cherokeedictionary.splitter.Affixes.Place;
import net.cherokeedictionary.splitter.Affixes.Repeatedly;
import net.cherokeedictionary.splitter.Affixes.SoAnd;
import net.cherokeedictionary.splitter.Affixes.ToFor;
import net.cherokeedictionary.splitter.Affixes.ToForᏏ;
import net.cherokeedictionary.splitter.Affixes.Towards;
import net.cherokeedictionary.splitter.Affixes.Truly;
import net.cherokeedictionary.splitter.Affixes.Very;
import net.cherokeedictionary.splitter.Affixes.WentForDoing;
import net.cherokeedictionary.splitter.Affixes.YesNo;
import net.cherokeedictionary.splitter.Affixes.YesYes;
//import net.cherokeedictionary.splitter.Log;
import net.cherokeedictionary.splitter.Syllabary;
import net.cherokeedictionary.splitter.Syllabary.Vowel;

import org.apache.commons.lang3.StringUtils

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
		static munge = {
			if (syllabary.matches("Ꮣ[ᏯᏰᏱᏲᏳᏴ].*")){
				String tmp = StringUtils.left(syllabary, 2).substring(1);
				syllabary=syllabary.substring(2);
				String lat = Syllabary.chr2lat(tmp).substring(1);
				syllabary = Syllabary.lat2chr(lat)+syllabary;
				//was break munge; -- find out how this works with groovy
				munge();
			}
			if (syllabary.startsWith("Ꮣ")){
				syllabary=syllabary.substring(1);
				munge();
			}
			if (syllabary.startsWith("Ꮧ")){
				syllabary=syllabary.substring(1);
				munge();
			}
			if (syllabary.startsWith("Ꮫ")){
				syllabary="Ꭰ"+syllabary.substring(1);
				munge();
			}
		}

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
//			munge: {
				if (syllabary.matches("Ꮣ[ᏯᏰᏱᏲᏳᏴ].*")){
					String tmp = StringUtils.left(syllabary, 2).substring(1);
					syllabary=syllabary.substring(2);
					String lat = Syllabary.chr2lat(tmp).substring(1);
					syllabary = Syllabary.lat2chr(lat)+syllabary;
					//was break munge; -- find out how this works with groovy
//					break
				} else
				if (syllabary.startsWith("Ꮣ")){
					syllabary=syllabary.substring(1);
//					break munge;
				} else
				if (syllabary.startsWith("Ꮧ")){
					syllabary=syllabary.substring(1);
//					break munge;
				} else
				if (syllabary.startsWith("Ꮫ")){
					syllabary="Ꭰ"+syllabary.substring(1);
//					break munge;
				}
//			}
			match.stem=Syllabary.changeForm(syllabary, Vowel.Ꭵ)+"Ꭲ";
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
	public List<AffixResult> getMatches(String syllabary) {
		List<AffixResult> list = new ArrayList<Affixes.AffixResult>();
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
			Affixes s = SuffixGuesser.getSuffixMatcherGeneralAffix(affix);
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
			if (Affixes.getVowelSet(Vowel.Ꭵ).contains(StringUtils.right(tmp, 1))){
				Syllabary.changeForm(tmp, Vowel.Ꭰ);
			}
			list.addAll(getMatches(tmp));
		}
		return list;
	}

	private static Affixes getSuffixMatcherGeneralAffix(GeneralAffix affix) {
		switch (affix) {
		case Just:
			return new Just();
		case SoAnd:
			return new SoAnd();
		case Place:
			return new Place();
		case YesNo:
			return new YesNo();
		case YesYes:
			return new YesYes();
		case But:
			return new But();
		case Truly:
			return new Truly();
		case Very:
			return new Very();
		case Towards:
			return new Towards();
		case InOnAt:
			return new InOnAt();
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
			return new AboutTo();
		case Again:
			return new Again();
		case Around:
			return new Around();
		case VerbStemAffix.ByAccident:
			return new Accidental();
		case VerbStemAffix.CameFor:
			return new ComeForDoing();
		case Causative:
			// TODO: Causative, not past tense is special
			return new Causative();
		case Completely:
			return new Completely();
		case VerbStemAffix.OverAndOver:
			return new Repeatedly();
		case ToFor:
			return new ToFor();
		case VerbStemAffix.WentTo:
			return new WentForDoing();
		case IntendTo:
			return new IntendTo();
		case AptTo:
			return new AptTo();
		case ToForᏏ:
			return new ToForᏏ();
		}
		throw new RuntimeException(
				"SPECIFIED SUFFIX MATCHER IS NOT IMPLEMENTED.");
	}
}
