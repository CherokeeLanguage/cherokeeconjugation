package net.cherokeedictionary.conjugation.intransitive

import net.cherokeedictionary.stemmer.DefinitionLine
import net.cherokeedictionary.stemmer.Stemmer
import net.cherokeedictionary.util.PartOfSpeech
import net.cherokeedictionary.util.PrefixTableSubject
import net.cherokeedictionary.verb.conjugation.Conjugate

class HeIsSeparatingIntransitivePartOfSpeechStringSpec extends GroovyTestCase {

	static def verbName = new Stemmer()

	static {
		verbName.habitual = new DefinitionLine(syllabary: "ᏓᎦᎴᏂᏍᎪᎢ")
		verbName.imperative = new DefinitionLine(syllabary: "ᏔᎦᎴᎾ")
		verbName.infinitive = new DefinitionLine(syllabary: "ᏧᎦᎴᏂᏗ")
		verbName.present1st = new DefinitionLine(syllabary: "ᏕᎦᎦᎴᏂᎠ")
		verbName.present3rd = new DefinitionLine(syllabary: "ᏓᎦᎴᏂᎠ")
		verbName.remotepast = new DefinitionLine(syllabary: "ᏚᎦᎴᏅᎥᎢ")
	}


	private String conj(String subject) {
		def verb = Conjugate.createVerbToConjugate(subject, "SG3AN", verbName,
		"PRESENT", PartOfSpeech.VERB_INTRANSITIVE.toString(), false)
		return Conjugate.conjugate(verb).wholeWord
	}

	void testSG1IntransitivePresent() {
		assert conj(String.valueOf(PrefixTableSubject.SG1.toString())) == "ᏕᎦᎦᎴᏂᎠ" // tio 19Nov26: regenerated post-d-morpheme fix (D23)
	}

	void testSG2IntransitivePresent() {
		assert conj(String.valueOf(PrefixTableSubject.SG2.toString())) == "ᏕᎭᎦᎴᏂᎠ" // tio 19Nov26: regenerated post-d-morpheme fix (D23) // tio 20Nov26: re-pinned post-DST h-branch fix (de-style keeps the e before h-glyphs, guide 61a/117a)
	}

	void testSG3IntransitivePresent() {
		assert conj(String.valueOf(PrefixTableSubject.SG3.toString())) == "ᏓᎦᎴᏂᎠ"
	}

	void testDL1INCLIntransitivePresent() {
		assert conj(String.valueOf(PrefixTableSubject.DL1INCL.toString())) == "ᏓᎾᎦᎴᏂᎠ" // tio 19Nov26: regenerated post-d-morpheme fix (D23)
	}

	void testDL1EXCLIntransitivePresent() {
		assert conj(String.valueOf(PrefixTableSubject.DL1EXCL.toString())) == "ᏓᏲᏍᏓᎦᎴᏂᎠ" // tio 19Nov26: regenerated post-d-morpheme fix (D23)
	}

	void testPL1INCLIntransitivePresent() {
		assert conj(String.valueOf(PrefixTableSubject.PL1INCL.toString())) == "ᏓᏓᎦᎴᏂᎠ" // tio 19Nov26: regenerated post-d-morpheme fix (D23)
	}

	void testPL1EXCLIntransitivePresent() {
		assert conj(String.valueOf(PrefixTableSubject.PL1EXCL.toString())) == "ᏓᏲᏣᎦᎴᏂᎠ" // tio 19Nov26: regenerated post-d-morpheme fix (D23)
	}

	void testDL2IntransitivePresent() {
		assert conj(String.valueOf(PrefixTableSubject.DL2.toString())) == "ᏕᏍᏓᎦᎴᏂᎠ" // tio 19Nov26: regenerated post-d-morpheme fix (D23)
	}

	void testPL2IntransitivePresent() {
		assert conj(String.valueOf(PrefixTableSubject.PL2.toString())) == "ᏓᏣᎦᎴᏂᎠ" // tio 19Nov26: regenerated post-d-morpheme fix (D23)
	}

	void testPL3IntransitivePresent() {
		assert conj(String.valueOf(PrefixTableSubject.PL3.toString())) == "ᏓᎾᎦᎴᏂᎠ" // tio 19Nov26: regenerated post-d-morpheme fix (D23)
	}

}