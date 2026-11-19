package net.cherokeedictionary.conjugation.intransitive

import net.cherokeedictionary.stemmer.DefinitionLine
import net.cherokeedictionary.stemmer.Stemmer
import net.cherokeedictionary.util.PartOfSpeech
import net.cherokeedictionary.util.PrefixTableSubject
import net.cherokeedictionary.verb.conjugation.Conjugate

class HesDodgingIntransitivePartOfSpeechStringSpec extends GroovyTestCase {

	static def verbName = new Stemmer()

	static {
		verbName.habitual = new DefinitionLine(syllabary: "ᏓᏓᏅᏗᏗᏍᎪᎢ")
		verbName.imperative = new DefinitionLine(syllabary: "ᏔᏓᏅᏗᏍᏓ")
		verbName.infinitive = new DefinitionLine(syllabary: "ᏧᏓᏅᏗᏍᏙᏗ")
		verbName.present1st = new DefinitionLine(syllabary: "ᏕᎦᏓᏅᏗᏍᏗᎭ")
		verbName.present3rd = new DefinitionLine(syllabary: "ᏓᏓᏅᏗᏍᏗᎭ")
		verbName.remotepast = new DefinitionLine(syllabary: "ᏚᏓᏅᏗᏍᏔᏅᎢ")
	}


	private String conj(String subject) {
		def verb = Conjugate.createVerbToConjugate(subject, "SG3AN", verbName,
		"PRESENT", PartOfSpeech.VERB_INTRANSITIVE.toString(), false)
		return Conjugate.conjugate(verb).wholeWord
	}

	void testSG1IntransitivePresent() {
		assert conj(String.valueOf(PrefixTableSubject.SG1.toString())) == "ᎦᏓᏅᏗᏍᏗᎭ"
	}

	void testSG2IntransitivePresent() {
		assert conj(String.valueOf(PrefixTableSubject.SG2.toString())) == "ᎭᏓᏅᏗᏍᏗᎭ"
	}

	void testSG3IntransitivePresent() {
		assert conj(String.valueOf(PrefixTableSubject.SG3.toString())) == "ᏓᏓᏅᏗᏍᏗᎭ"
	}

	void testDL1INCLIntransitivePresent() {
		assert conj(String.valueOf(PrefixTableSubject.DL1INCL.toString())) == "ᎢᎾᏓᏅᏗᏍᏗᎭ"
	}

	void testDL1EXCLIntransitivePresent() {
		assert conj(String.valueOf(PrefixTableSubject.DL1EXCL.toString())) == "ᎣᏍᏓᏓᏅᏗᏍᏗᎭ"
	}

	void testPL1INCLIntransitivePresent() {
		assert conj(String.valueOf(PrefixTableSubject.PL1INCL.toString())) == "ᎢᏓᏓᏅᏗᏍᏗᎭ"
	}

	void testPL1EXCLIntransitivePresent() {
		assert conj(String.valueOf(PrefixTableSubject.PL1EXCL.toString())) == "ᎣᏣᏓᏅᏗᏍᏗᎭ"
	}

	void testDL2IntransitivePresent() {
		assert conj(String.valueOf(PrefixTableSubject.DL2.toString())) == "ᏍᏓᏓᏅᏗᏍᏗᎭ"
	}

	void testPL2IntransitivePresent() {
		assert conj(String.valueOf(PrefixTableSubject.PL2.toString())) == "ᎢᏣᏓᏅᏗᏍᏗᎭ"
	}

	void testPL3IntransitivePresent() {
		assert conj(String.valueOf(PrefixTableSubject.PL3.toString())) == "ᎠᎾᏓᏅᏗᏍᏗᎭ"
	}

}