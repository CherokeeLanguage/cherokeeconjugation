package net.cherokeedictionary.conjugation.intransitive

import net.cherokeedictionary.stemmer.DefinitionLine
import net.cherokeedictionary.stemmer.Stemmer
import net.cherokeedictionary.util.PartOfSpeech
import net.cherokeedictionary.util.PrefixTableSubject
import net.cherokeedictionary.verb.conjugation.Conjugate

class HeIsHidingIntransitivePartOfSpeechStringSpec extends GroovyTestCase {

	static def verbName = new Stemmer()

	static {
		verbName.habitual = new DefinitionLine(syllabary: "ᎠᏗᏍᎦᎳᏍᎪᎢ")
		verbName.imperative = new DefinitionLine(syllabary: "ᎭᏗᏍᎦᎳᎦ")
		verbName.infinitive = new DefinitionLine(syllabary: "ᎤᏗᏍᎦᎳᏗ")
		verbName.present1st = new DefinitionLine(syllabary: "ᎦᏗᏍᎦᎳᏍᎦ")
		verbName.present3rd = new DefinitionLine(syllabary: "ᎠᏗᏍᎦᎳᏍᎦ")
		verbName.remotepast = new DefinitionLine(syllabary: "ᎤᏗᏍᎦᎸᏅᎢ")
	}


	private String conj(String subject) {
		def verb = Conjugate.createVerbToConjugate(subject, "SG3AN", verbName,
		"PRESENT", PartOfSpeech.VERB_INTRANSITIVE.toString(), false)
		return Conjugate.conjugate(verb).wholeWord
	}

	void testSG1IntransitivePresent() {
		assert conj(String.valueOf(PrefixTableSubject.SG1.toString())) == "ᎦᏗᏍᎦᎳᏍᎦ"
	}

	void testSG2IntransitivePresent() {
		assert conj(String.valueOf(PrefixTableSubject.SG2.toString())) == "ᎭᏗᏍᎦᎳᏍᎦ"
	}

	void testSG3IntransitivePresent() {
		assert conj(String.valueOf(PrefixTableSubject.SG3.toString())) == "ᎠᏗᏍᎦᎳᏍᎦ"
	}

	void testDL1INCLIntransitivePresent() {
		assert conj(String.valueOf(PrefixTableSubject.DL1INCL.toString())) == "ᎢᎾᏗᏍᎦᎳᏍᎦ"
	}

	void testDL1EXCLIntransitivePresent() {
		assert conj(String.valueOf(PrefixTableSubject.DL1EXCL.toString())) == "ᎣᏍᏓᏗᏍᎦᎳᏍᎦ"
	}

	void testPL1INCLIntransitivePresent() {
		assert conj(String.valueOf(PrefixTableSubject.PL1INCL.toString())) == "ᎢᏓᏗᏍᎦᎳᏍᎦ"
	}

	void testPL1EXCLIntransitivePresent() {
		assert conj(String.valueOf(PrefixTableSubject.PL1EXCL.toString())) == "ᎣᏣᏗᏍᎦᎳᏍᎦ"
	}

	void testDL2IntransitivePresent() {
		assert conj(String.valueOf(PrefixTableSubject.DL2.toString())) == "ᏍᏓᏗᏍᎦᎳᏍᎦ"
	}

	void testPL2IntransitivePresent() {
		assert conj(String.valueOf(PrefixTableSubject.PL2.toString())) == "ᎢᏣᏗᏍᎦᎳᏍᎦ"
	}

	void testPL3IntransitivePresent() {
		assert conj(String.valueOf(PrefixTableSubject.PL3.toString())) == "ᎠᎾᏗᏍᎦᎳᏍᎦ"
	}

}