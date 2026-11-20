package net.cherokeedictionary.conjugation.intransitive

import net.cherokeedictionary.stemmer.DefinitionLine
import net.cherokeedictionary.stemmer.Stemmer
import net.cherokeedictionary.util.PartOfSpeech
import net.cherokeedictionary.util.PrefixTableSubject
import net.cherokeedictionary.verb.conjugation.Conjugate

class HesTiredIntransitivePartOfSpeechStringSpec extends GroovyTestCase {

	static def verbName = new Stemmer()

	static {
		verbName.habitual = new DefinitionLine(syllabary: "ᏚᏯᏪᎪᎢ")
		verbName.imperative = new DefinitionLine(syllabary: "ᏗᏣᏯᏪᎩ")
		verbName.infinitive = new DefinitionLine(syllabary: "ᏧᏯᏪᏍᏗ")
		verbName.present1st = new DefinitionLine(syllabary: "ᏓᎩᏯᏪᎦ")
		verbName.present3rd = new DefinitionLine(syllabary: "ᏚᏯᏪᎦ")
		verbName.remotepast = new DefinitionLine(syllabary: "ᏚᏯᏪᏨᎢ")
	}


	private String conj(String subject) {
		def verb = Conjugate.createVerbToConjugate(subject, "SG3AN", verbName,
		"PRESENT", PartOfSpeech.VERB_INTRANSITIVE.toString(), false)
		return Conjugate.conjugate(verb).wholeWord
	}

	void testSG1IntransitivePresent() {
		assert conj(String.valueOf(PrefixTableSubject.SG1.toString())) == "ᏓᎩᏯᏪᎦ" // tio 19Nov26: regenerated post-d-morpheme fix (D23)
	}

	void testSG2IntransitivePresent() {
		assert conj(String.valueOf(PrefixTableSubject.SG2.toString())) == "ᏗᏣᏯᏪᎦ" // tio 19Nov26: regenerated post-d-morpheme fix (D23)
	}

	void testSG3IntransitivePresent() {
		assert conj(String.valueOf(PrefixTableSubject.SG3.toString())) == "ᏚᏯᏪᎦ"
	}

	void testDL1INCLIntransitivePresent() {
		assert conj(String.valueOf(PrefixTableSubject.DL1INCL.toString())) == "ᏗᎩᏂᏯᏪᎦ" // tio 19Nov26: regenerated post-d-morpheme fix (D23)
	}

	void testDL1EXCLIntransitivePresent() {
		assert conj(String.valueOf(PrefixTableSubject.DL1EXCL.toString())) == "ᏓᏲᎩᏂᏯᏪᎦ"
	}

	void testPL1INCLIntransitivePresent() {
		assert conj(String.valueOf(PrefixTableSubject.PL1INCL.toString())) == "ᏓᎩᏯᏪᎦ"
	}

	void testPL1EXCLIntransitivePresent() {
		assert conj(String.valueOf(PrefixTableSubject.PL1EXCL.toString())) == "ᏓᏲᎩᏯᏪᎦ"
	}

	void testDL2IntransitivePresent() {
		assert conj(String.valueOf(PrefixTableSubject.DL2.toString())) == "ᏗᏍᏗᏯᏪᎦ" // tio 19Nov26: regenerated post-d-morpheme fix (D23)
	}

	void testPL2IntransitivePresent() {
		assert conj(String.valueOf(PrefixTableSubject.PL2.toString())) == "ᏓᏥᏯᏪᎦ"
	}

	void testPL3IntransitivePresent() {
		assert conj(String.valueOf(PrefixTableSubject.PL3.toString())) == "ᏚᏂᏯᏪᎦ"
	}

}