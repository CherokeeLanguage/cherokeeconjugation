package net.cherokeedictionary.conjugation.intransitive

import net.cherokeedictionary.stemmer.DefinitionLine
import net.cherokeedictionary.stemmer.Stemmer
import net.cherokeedictionary.util.PartOfSpeech
import net.cherokeedictionary.util.PrefixTableSubject
import net.cherokeedictionary.verb.conjugation.Conjugate

class HeIsWorryingIntransitivePartOfSpeechStringSpec extends GroovyTestCase {

	static def verbName = new Stemmer()

	static {
		verbName.habitual = new DefinitionLine(syllabary: "ᎤᏓᏅᏖᏗᏍᎪᎢ")
		verbName.imperative = new DefinitionLine(syllabary: "ᏣᏓᏅᏖᏓ")
		verbName.infinitive = new DefinitionLine(syllabary: "ᎤᏓᏅᏖᏚᏗ")
		verbName.present1st = new DefinitionLine(syllabary: "ᎠᏆᏓᏅᏖᏗᎭ")
		verbName.present3rd = new DefinitionLine(syllabary: "ᎤᏓᏅᏖᏗᎭ")
		verbName.remotepast = new DefinitionLine(syllabary: "ᎤᏓᏅᏖᏓᏅᎢ")
	}


	private String conj(String subject) {
		def verb = Conjugate.createVerbToConjugate(subject, "SG3AN", verbName,
		"PRESENT", PartOfSpeech.VERB_INTRANSITIVE.toString(), false)
		return Conjugate.conjugate(verb).wholeWord
	}

	void testSG1IntransitivePresent() {
		assert conj(String.valueOf(PrefixTableSubject.SG1.toString())) == "ᎠᏆᏓᏅᏖᏗᎭ"
	}

	void testSG2IntransitivePresent() {
		assert conj(String.valueOf(PrefixTableSubject.SG2.toString())) == "ᏣᏓᏅᏖᏗᎭ"
	}

	void testSG3IntransitivePresent() {
		assert conj(String.valueOf(PrefixTableSubject.SG3.toString())) == "ᎤᏓᏅᏖᏗᎭ"
	}

	void testDL1INCLIntransitivePresent() {
		assert conj(String.valueOf(PrefixTableSubject.DL1INCL.toString())) == "ᎩᎾᏓᏅᏖᏗᎭ"
	}

	void testDL1EXCLIntransitivePresent() {
		assert conj(String.valueOf(PrefixTableSubject.DL1EXCL.toString())) == "ᎣᎩᎾᏓᏅᏖᏗᎭ"
	}

	void testPL1INCLIntransitivePresent() {
		assert conj(String.valueOf(PrefixTableSubject.PL1INCL.toString())) == "ᎢᎦᏓᏅᏖᏗᎭ"
	}

	void testPL1EXCLIntransitivePresent() {
		assert conj(String.valueOf(PrefixTableSubject.PL1EXCL.toString())) == "ᎣᎦᏓᏅᏖᏗᎭ"
	}

	void testDL2IntransitivePresent() {
		assert conj(String.valueOf(PrefixTableSubject.DL2.toString())) == "ᏍᏓᏓᏅᏖᏗᎭ"
	}

	void testPL2IntransitivePresent() {
		assert conj(String.valueOf(PrefixTableSubject.PL2.toString())) == "ᎢᏣᏓᏅᏖᏗᎭ"
	}

	void testPL3IntransitivePresent() {
		assert conj(String.valueOf(PrefixTableSubject.PL3.toString())) == "ᎤᎾᏓᏅᏖᏗᎭ"
	}

}