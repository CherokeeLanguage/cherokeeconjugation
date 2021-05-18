package net.cherokeedictionary.splitter;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.apache.commons.lang3.StringUtils

public class Syllabary {
	
	public static final String UpperMark="\u0332";//combining underline
	public static final String Overline = "\u203e";
	public static final String UnderX = "\u0353";
	
	public static String chr2lat(String chr) {
		return _chr2lat.get(chr);
	}
	
	public static String lat2chr(String latin) {
		return _lat2chr.get(latin);
	}
	
	private static final Map<String, String> _chr2lat;
	private static final Map<String, String> _lat2chr;
	static {
		_lat2chr=_lat2chr();
		_chr2lat=_chr2lat();
	}
	
	private static Map<String, String> _chr2lat() {
		Map<String, String> syl2lat = new HashMap<String, String>();
		//Map<String, String> lat2chr = lat2chr();

		Iterator<String> ikey = _lat2chr.keySet().iterator();
		while (ikey.hasNext()) {
			String key = ikey.next();
			if (key.startsWith("hl")) {
				continue;
			}
			if (key.startsWith("ts")) {
				continue;
			}
			if (key.startsWith("ch")) {
				continue;
			}
			if (key.startsWith("qu")) {
				continue;
			}
			if (key.startsWith("k") && !key.startsWith("ka")) {
				continue;
			}
			syl2lat.put(_lat2chr.get(key), key);
		}
		return syl2lat;
	}

	private static Map<String, String> _lat2chr() {
		int ix = 0;
		String letter;
		String prefix;
		char chrStart = 'Ꭰ';
		String[] vowels = new String[6];

		Map<String, String> latin2syllabary = new HashMap<String, String>();

		vowels[0] = "a";
		vowels[1] = "e";
		vowels[2] = "i";
		vowels[3] = "o";
		vowels[4] = "u";
		vowels[5] = "v";

		for (ix = 0; ix < 6; ix++) {
			letter = Character.toString((char) (chrStart + ix));
			latin2syllabary.put(vowels[ix], letter);
		}

		latin2syllabary.put("ga", "Ꭶ");

		latin2syllabary.put("ka", "Ꭷ");

		prefix = "g";
		chrStart = 'Ꭸ';
		for (ix = 1; ix < 6; ix++) {
			letter = Character.toString((char) (chrStart + ix - 1));
			latin2syllabary.put(prefix + vowels[ix], letter);
		}

		prefix = "k";
		chrStart = 'Ꭸ';
		for (ix = 1; ix < 6; ix++) {
			letter = Character.toString((char) (chrStart + ix - 1));
			latin2syllabary.put(prefix + vowels[ix], letter);
		}

		prefix = "h";
		chrStart = 'Ꭽ';
		for (ix = 0; ix < 6; ix++) {
			letter = Character.toString((char) (chrStart + ix));
			latin2syllabary.put(prefix + vowels[ix], letter);
		}

		prefix = "l";
		chrStart = 'Ꮃ';
		for (ix = 0; ix < 6; ix++) {
			letter = Character.toString((char) (chrStart + ix));
			latin2syllabary.put(prefix + vowels[ix], letter);
		}

		prefix = "m";
		chrStart = 'Ꮉ';
		for (ix = 0; ix < 5; ix++) {
			letter = Character.toString((char) (chrStart + ix));
			latin2syllabary.put(prefix + vowels[ix], letter);
		}

		latin2syllabary.put("na", "Ꮎ");
		latin2syllabary.put("hna", "Ꮏ");
		latin2syllabary.put("nah", "Ꮐ");

		prefix = "n";
		chrStart = 'Ꮑ';
		for (ix = 1; ix < 6; ix++) {
			letter = Character.toString((char) (chrStart + ix - 1));
			latin2syllabary.put(prefix + vowels[ix], letter);
		}

		prefix = "qu";
		chrStart = 'Ꮖ';
		for (ix = 0; ix < 6; ix++) {
			letter = Character.toString((char) (chrStart + ix));
			latin2syllabary.put(prefix + vowels[ix], letter);
		}

		prefix = "gw";
		chrStart = 'Ꮖ';
		for (ix = 0; ix < 6; ix++) {
			letter = Character.toString((char) (chrStart + ix));
			latin2syllabary.put(prefix + vowels[ix], letter);
		}

		latin2syllabary.put("sa", "Ꮜ");
		latin2syllabary.put("s", "Ꮝ");

		prefix = "s";
		chrStart = 'Ꮞ';
		for (ix = 1; ix < 6; ix++) {
			letter = Character.toString((char) (chrStart + ix - 1));
			latin2syllabary.put(prefix + vowels[ix], letter);
		}

		latin2syllabary.put("da", "Ꮣ");
		latin2syllabary.put("ta", "Ꮤ");
		latin2syllabary.put("de", "Ꮥ");
		latin2syllabary.put("te", "Ꮦ");
		latin2syllabary.put("di", "Ꮧ");
		latin2syllabary.put("ti", "Ꮨ");
		latin2syllabary.put("do", "Ꮩ");
		latin2syllabary.put("to", "Ꮩ");
		latin2syllabary.put("du", "Ꮪ");
		latin2syllabary.put("tu", "Ꮪ");
		latin2syllabary.put("dv", "Ꮫ");
		latin2syllabary.put("tv", "Ꮫ");
		latin2syllabary.put("dla", "Ꮬ");

		prefix = "hl";
		chrStart = 'Ꮭ';
		for (ix = 0; ix < 6; ix++) {
			letter = Character.toString((char) (chrStart + ix));
			latin2syllabary.put(prefix + vowels[ix], letter);
		}

		prefix = "tl";
		chrStart = 'Ꮭ';
		for (ix = 0; ix < 6; ix++) {
			letter = Character.toString((char) (chrStart + ix));
			latin2syllabary.put(prefix + vowels[ix], letter);
		}

		prefix = "j";
		chrStart = 'Ꮳ';
		for (ix = 0; ix < 6; ix++) {
			letter = Character.toString((char) (chrStart + ix));
			latin2syllabary.put(prefix + vowels[ix], letter);
		}

		prefix = "ts";
		chrStart = 'Ꮳ';
		for (ix = 0; ix < 6; ix++) {
			letter = Character.toString((char) (chrStart + ix));
			latin2syllabary.put(prefix + vowels[ix], letter);
		}

		prefix = "ch";
		chrStart = 'Ꮳ';
		for (ix = 0; ix < 6; ix++) {
			letter = Character.toString((char) (chrStart + ix));
			latin2syllabary.put(prefix + vowels[ix], letter);
		}

		prefix = "w";
		chrStart = 'Ꮹ';
		for (ix = 0; ix < 6; ix++) {
			letter = Character.toString((char) (chrStart + ix));
			latin2syllabary.put(prefix + vowels[ix], letter);
		}

		prefix = "y";
		chrStart = 'Ꮿ';
		for (ix = 0; ix < 6; ix++) {
			letter = Character.toString((char) (chrStart + ix));
			latin2syllabary.put(prefix + vowels[ix], letter);
		}
		return latin2syllabary;
	}

	public static enum Vowel {
		Ꭰ("a"), Ꭱ("e"), Ꭲ("i"), Ꭳ("o"), Ꭴ("u"), Ꭵ("v");
		public final String latin;
		private Vowel(String latin) {
			this.latin=latin;
		}
	}
	
	public static String changeForm(String word, Vowel vowel) {
		if (StringUtils.isBlank(word)) {
			return word;
		}
		String ending = StringUtils.right(word, 1);
		String base = StringUtils.left(word, word.length()-1);
		String x3 = chr2lat(ending);
		if (x3.startsWith("hn") && !Vowel.Ꭰ.equals(vowel)){
			x3=StringUtils.substring(x3, 1);
		}
		if (x3.startsWith("dl") && !Vowel.Ꭰ.equals(vowel)){
			x3="t"+StringUtils.substring(x3, 1);
		}
		x3 = StringUtils.left(x3, x3.length()-1)+vowel.latin;
		return base + lat2chr(x3);
	}

//	public static String changeForm(String syllabary, String vowel) {
//		if (StringUtils.isBlank(syllabary)) {
//			return syllabary;
//		}
//		if (!"ᎠᎡᎢᎣᎤᎥ".contains(vowel)) {
//			throw new RuntimeException("NOT A VALID SYLLABARY VOWEL!");
//		}
//		String p1 = syllabary.substring(0, syllabary.length()-1);
//		String p2 = syllabary.substring(syllabary.length()-1, syllabary.length());
//		String x3 = chr2lat(p2);
//		x3=x3.substring(0, x3.length()-1)+chr2lat(vowel);
//		return p1 + lat2chr(x3);
//	}
}
