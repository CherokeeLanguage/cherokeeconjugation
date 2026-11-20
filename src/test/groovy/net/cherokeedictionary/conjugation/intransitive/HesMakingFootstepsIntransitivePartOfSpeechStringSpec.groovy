package net.cherokeedictionary.conjugation.intransitive

import net.cherokeedictionary.stemmer.DefinitionLine
import net.cherokeedictionary.stemmer.Stemmer
import net.cherokeedictionary.util.PartOfSpeech
import net.cherokeedictionary.util.PrefixTableSubject
import net.cherokeedictionary.verb.conjugation.Conjugate

class HesMakingFootstepsIntransitivePartOfSpeechStringSpec extends GroovyTestCase {

	static def verbName = new Stemmer()

	static {
		verbName.habitual = new DefinitionLine(syllabary: "ᏚᏍᏓᏃᏴᎪᎢ")
		verbName.imperative = new DefinitionLine(syllabary: "ᏗᏣᏍᏓᏃᏴᎳ")
		verbName.infinitive = new DefinitionLine(syllabary: "ᏧᏍᏓᏃᏴᏟᏍᏗ")
		verbName.present1st = new DefinitionLine(syllabary: "ᏓᏆᏍᏓᏃᏴᎦ")
		verbName.present3rd = new DefinitionLine(syllabary: "ᏚᏍᏓᏃᏴᎦ")
		verbName.remotepast = new DefinitionLine(syllabary: "ᏚᏍᏓᏃᏴᎬᎢ")
	}


	private String conj(String subject) {
		def verb = Conjugate.createVerbToConjugate(subject, "SG3AN", verbName,
		"PRESENT", PartOfSpeech.VERB_INTRANSITIVE.toString(), false)
		return Conjugate.conjugate(verb).wholeWord
	}

	void testSG1IntransitivePresent() {
		assert conj(String.valueOf(PrefixTableSubject.SG1.toString())) == "ᏓᏆᏍᏓᏃᏴᎦ" // tio 19Nov26: regenerated post-d-morpheme fix (D23)
	}

	void testSG2IntransitivePresent() {
		assert conj(String.valueOf(PrefixTableSubject.SG2.toString())) == "ᏗᏣᏍᏓᏃᏴᎦ" // tio 19Nov26: regenerated post-d-morpheme fix (D23)
	}

	void testSG3IntransitivePresent() {
		assert conj(String.valueOf(PrefixTableSubject.SG3.toString())) == "ᏚᏍᏓᏃᏴᎦ"
	}

	void testDL1INCLIntransitivePresent() {
		assert conj(String.valueOf(PrefixTableSubject.DL1INCL.toString())) == "ᏗᎩᎾᏍᏓᏃᏴᎦ" // tio 19Nov26: regenerated post-d-morpheme fix (D23)
	}

	void testDL1EXCLIntransitivePresent() {
		assert conj(String.valueOf(PrefixTableSubject.DL1EXCL.toString())) == "ᏓᏲᎩᎾᏍᏓᏃᏴᎦ"
	}

	void testPL1INCLIntransitivePresent() {
		assert conj(String.valueOf(PrefixTableSubject.PL1INCL.toString())) == "ᏓᎦᏍᏓᏃᏴᎦ"
	}

	void testPL1EXCLIntransitivePresent() {
		assert conj(String.valueOf(PrefixTableSubject.PL1EXCL.toString())) == "ᏓᏲᎦᏍᏓᏃᏴᎦ"
	}

	void testDL2IntransitivePresent() {
		assert conj(String.valueOf(PrefixTableSubject.DL2.toString())) == "ᏗᏍᏓᏍᏓᏃᏴᎦ" // tio 19Nov26: regenerated post-d-morpheme fix (D23)
	}

	void testPL2IntransitivePresent() {
		assert conj(String.valueOf(PrefixTableSubject.PL2.toString())) == "ᏓᏣᏍᏓᏃᏴᎦ"
	}

	void testPL3IntransitivePresent() {
		assert conj(String.valueOf(PrefixTableSubject.PL3.toString())) == "ᏚᎾᏍᏓᏃᏴᎦ"
	}

}