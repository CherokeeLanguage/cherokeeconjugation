package net.cherokeedictionary.conjugation.intransitive

import net.cherokeedictionary.stemmer.DefinitionLine
import net.cherokeedictionary.stemmer.Stemmer
import net.cherokeedictionary.util.PartOfSpeech
import net.cherokeedictionary.util.PrefixTableSubject
import net.cherokeedictionary.verb.conjugation.Conjugate

class HeIsStretchingIntransitivePartOfSpeechStringSpec extends GroovyTestCase {

	static def verbName = new Stemmer()

	static {
		verbName.habitual = new DefinitionLine(syllabary: "ᏕᎫᏣᎾᎩᏍᎪᎢ")
		verbName.imperative = new DefinitionLine(syllabary: "ᏚᏣᎾᎩ")
		verbName.infinitive = new DefinitionLine(syllabary: "ᏧᏭᏣᎾᎩᏍᏗ")
		verbName.present1st = new DefinitionLine(syllabary: "ᏕᎫᏣᎾᎩᎠ")
		verbName.present3rd = new DefinitionLine(syllabary: "ᏕᎫᏣᎾᎩᎠ")
		verbName.remotepast = new DefinitionLine(syllabary: "ᏚᏭᏣᎾᎩᏒᎢ")
	}


	private String conj(String subject) {
		def verb = Conjugate.createVerbToConjugate(subject, "SG3AN", verbName,
		"PRESENT", PartOfSpeech.VERB_INTRANSITIVE.toString(), false)
		return Conjugate.conjugate(verb).wholeWord
	}

	void testSG1IntransitivePresent() {
		assert conj(String.valueOf(PrefixTableSubject.SG1.toString())) == "ᏕᎫᏣᎾᎩᎠ" // tio 19Nov26: regenerated post-d-morpheme fix (D23)
	}

	void testSG2IntransitivePresent() {
		assert conj(String.valueOf(PrefixTableSubject.SG2.toString())) == "ᏕᎱᏣᎾᎩᎠ" // tio 19Nov26: regenerated post-d-morpheme fix (D23) // tio 20Nov26: re-pinned post-DST h-branch fix (de-style keeps the e before h-glyphs, guide 61a/117a)
	}

	void testSG3IntransitivePresent() {
		assert conj(String.valueOf(PrefixTableSubject.SG3.toString())) == "ᏕᎫᏣᎾᎩᎠ"
	}

	void testDL1INCLIntransitivePresent() {
		assert conj(String.valueOf(PrefixTableSubject.DL1INCL.toString())) == "ᏓᏄᏣᎾᎩᎠ" // tio 19Nov26: regenerated post-d-morpheme fix (D23)
	}

	void testDL1EXCLIntransitivePresent() {
		assert conj(String.valueOf(PrefixTableSubject.DL1EXCL.toString())) == "ᏓᏲᏍᏚᏣᎾᎩᎠ" // tio 19Nov26: regenerated post-d-morpheme fix (D23)
	}

	void testPL1INCLIntransitivePresent() {
		assert conj(String.valueOf(PrefixTableSubject.PL1INCL.toString())) == "ᏓᏚᏣᎾᎩᎠ" // tio 19Nov26: regenerated post-d-morpheme fix (D23)
	}

	void testPL1EXCLIntransitivePresent() {
		assert conj(String.valueOf(PrefixTableSubject.PL1EXCL.toString())) == "ᏓᏲᏧᏣᎾᎩᎠ" // tio 19Nov26: regenerated post-d-morpheme fix (D23)
	}

	void testDL2IntransitivePresent() {
		assert conj(String.valueOf(PrefixTableSubject.DL2.toString())) == "ᏕᏍᏚᏣᎾᎩᎠ" // tio 19Nov26: regenerated post-d-morpheme fix (D23)
	}

	void testPL2IntransitivePresent() {
		assert conj(String.valueOf(PrefixTableSubject.PL2.toString())) == "ᏓᏧᏣᎾᎩᎠ" // tio 19Nov26: regenerated post-d-morpheme fix (D23)
	}

	void testPL3IntransitivePresent() {
		assert conj(String.valueOf(PrefixTableSubject.PL3.toString())) == "ᏓᏄᏣᎾᎩᎠ" // tio 19Nov26: regenerated post-d-morpheme fix (D23)
	}

}