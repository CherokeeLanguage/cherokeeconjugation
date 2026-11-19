package net.cherokeedictionary.conjugation.intransitive

import net.cherokeedictionary.stemmer.DefinitionLine
import net.cherokeedictionary.stemmer.Stemmer
import net.cherokeedictionary.util.PartOfSpeech
import net.cherokeedictionary.util.PrefixTableSubject
import net.cherokeedictionary.verb.conjugation.Conjugate

class HeIsGettingReadyIntransitivePartOfSpeechStringSpec extends GroovyTestCase {

	static def verbName = new Stemmer()

	static {
		verbName.habitual = new DefinitionLine(syllabary: "ᎠᏛᏅᎢᏍᏗᏍᎪᎢ")
		verbName.imperative = new DefinitionLine(syllabary: "ᎭᏛᏅᎢᏍᏓ")
		verbName.infinitive = new DefinitionLine(syllabary: "ᎤᏛᏅᎢᏍᏙᏗ")
		verbName.present1st = new DefinitionLine(syllabary: "ᎦᏛᏅᎢᏍᏗᎭ")
		verbName.present3rd = new DefinitionLine(syllabary: "ᎠᏛᏅᎢᏍᏗᎭ")
		verbName.remotepast = new DefinitionLine(syllabary: "ᎤᏛᏅᎢᏍᏓᏅᎢ")
	}


	private String conj(String subject) {
		def verb = Conjugate.createVerbToConjugate(subject, "SG3AN", verbName,
		"PRESENT", PartOfSpeech.VERB_INTRANSITIVE.toString(), false)
		return Conjugate.conjugate(verb).wholeWord
	}

	void testSG1IntransitivePresent() {
		assert conj(String.valueOf(PrefixTableSubject.SG1.toString())) == "ᎦᏛᏅᎢᏍᏗᎭ"
	}

	void testSG2IntransitivePresent() {
		assert conj(String.valueOf(PrefixTableSubject.SG2.toString())) == "ᎭᏛᏅᎢᏍᏗᎭ"
	}

	void testSG3IntransitivePresent() {
		assert conj(String.valueOf(PrefixTableSubject.SG3.toString())) == "ᎠᏛᏅᎢᏍᏗᎭ"
	}

	void testDL1INCLIntransitivePresent() {
		assert conj(String.valueOf(PrefixTableSubject.DL1INCL.toString())) == "ᎢᎾᏛᏅᎢᏍᏗᎭ"
	}

	void testDL1EXCLIntransitivePresent() {
		assert conj(String.valueOf(PrefixTableSubject.DL1EXCL.toString())) == "ᎣᏍᏓᏛᏅᎢᏍᏗᎭ"
	}

	void testPL1INCLIntransitivePresent() {
		assert conj(String.valueOf(PrefixTableSubject.PL1INCL.toString())) == "ᎢᏓᏛᏅᎢᏍᏗᎭ"
	}

	void testPL1EXCLIntransitivePresent() {
		assert conj(String.valueOf(PrefixTableSubject.PL1EXCL.toString())) == "ᎣᏣᏛᏅᎢᏍᏗᎭ"
	}

	void testDL2IntransitivePresent() {
		assert conj(String.valueOf(PrefixTableSubject.DL2.toString())) == "ᏍᏓᏛᏅᎢᏍᏗᎭ"
	}

	void testPL2IntransitivePresent() {
		assert conj(String.valueOf(PrefixTableSubject.PL2.toString())) == "ᎢᏣᏛᏅᎢᏍᏗᎭ"
	}

	void testPL3IntransitivePresent() {
		assert conj(String.valueOf(PrefixTableSubject.PL3.toString())) == "ᎠᎾᏛᏅᎢᏍᏗᎭ"
	}

}