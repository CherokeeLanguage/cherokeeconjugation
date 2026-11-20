package net.cherokeedictionary.conjugation.intransitive

import net.cherokeedictionary.stemmer.DefinitionLine
import net.cherokeedictionary.stemmer.Stemmer
import net.cherokeedictionary.util.PartOfSpeech
import net.cherokeedictionary.util.PrefixTableSubject
import net.cherokeedictionary.verb.conjugation.Conjugate

class HeIsDifferentFromIntransitivePartOfSpeechStringSpec extends GroovyTestCase {

	static def verbName = new Stemmer()

	static {
		verbName.habitual = new DefinitionLine(syllabary: "ᏓᏓᎴᎪᎢ")
		verbName.imperative = new DefinitionLine(syllabary: "ᏔᏓᎴᎩ")
		verbName.infinitive = new DefinitionLine(syllabary: "ᏧᏓᎴᎢᏍᏗ")
		verbName.present1st = new DefinitionLine(syllabary: "ᏕᎦᏓᎴᎦ")
		verbName.present3rd = new DefinitionLine(syllabary: "ᏓᏓᎴᎦ")
		verbName.remotepast = new DefinitionLine(syllabary: "ᏚᏓᎴᏨᎢ")
	}


	private String conj(String subject) {
		def verb = Conjugate.createVerbToConjugate(subject, "SG3AN", verbName,
		"PRESENT", PartOfSpeech.VERB_INTRANSITIVE.toString(), false)
		return Conjugate.conjugate(verb).wholeWord
	}

	void testSG1IntransitivePresent() {
		assert conj(String.valueOf(PrefixTableSubject.SG1.toString())) == "ᏕᎦᏓᎴᎦ" // tio 19Nov26: regenerated post-d-morpheme fix (D23)
	}

	void testSG2IntransitivePresent() {
		assert conj(String.valueOf(PrefixTableSubject.SG2.toString())) == "ᏘᏓᎴᎦ" // tio 19Nov26: regenerated post-d-morpheme fix (D23)
	}

	void testSG3IntransitivePresent() {
		assert conj(String.valueOf(PrefixTableSubject.SG3.toString())) == "ᏓᏓᎴᎦ"
	}

	void testDL1INCLIntransitivePresent() {
		assert conj(String.valueOf(PrefixTableSubject.DL1INCL.toString())) == "ᏓᎾᏓᎴᎦ" // tio 19Nov26: regenerated post-d-morpheme fix (D23)
	}

	void testDL1EXCLIntransitivePresent() {
		assert conj(String.valueOf(PrefixTableSubject.DL1EXCL.toString())) == "ᏓᏲᏍᏓᏓᎴᎦ" // tio 19Nov26: regenerated post-d-morpheme fix (D23)
	}

	void testPL1INCLIntransitivePresent() {
		assert conj(String.valueOf(PrefixTableSubject.PL1INCL.toString())) == "ᏓᏓᏓᎴᎦ" // tio 19Nov26: regenerated post-d-morpheme fix (D23)
	}

	void testPL1EXCLIntransitivePresent() {
		assert conj(String.valueOf(PrefixTableSubject.PL1EXCL.toString())) == "ᏓᏲᏣᏓᎴᎦ" // tio 19Nov26: regenerated post-d-morpheme fix (D23)
	}

	void testDL2IntransitivePresent() {
		assert conj(String.valueOf(PrefixTableSubject.DL2.toString())) == "ᏕᏍᏓᏓᎴᎦ" // tio 19Nov26: regenerated post-d-morpheme fix (D23)
	}

	void testPL2IntransitivePresent() {
		assert conj(String.valueOf(PrefixTableSubject.PL2.toString())) == "ᏓᏣᏓᎴᎦ" // tio 19Nov26: regenerated post-d-morpheme fix (D23)
	}

	void testPL3IntransitivePresent() {
		assert conj(String.valueOf(PrefixTableSubject.PL3.toString())) == "ᏓᎾᏓᎴᎦ" // tio 19Nov26: regenerated post-d-morpheme fix (D23)
	}

}