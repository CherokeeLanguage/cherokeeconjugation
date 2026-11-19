package net.cherokeedictionary.conjugation.intransitive

import net.cherokeedictionary.stemmer.DefinitionLine
import net.cherokeedictionary.stemmer.Stemmer
import net.cherokeedictionary.util.PartOfSpeech
import net.cherokeedictionary.util.PrefixTableSubject
import net.cherokeedictionary.verb.conjugation.Conjugate

class HeIsBecomingSkilledIntransitivePartOfSpeechStringSpec extends GroovyTestCase {

	static def verbName = new Stemmer()

	static {
		verbName.habitual = new DefinitionLine(syllabary: "ᎠᏏᎾᏌᏅᎪᎢ")
		verbName.imperative = new DefinitionLine(syllabary: "ᎯᏏᎾᏌᏅᎯ")
		verbName.infinitive = new DefinitionLine(syllabary: "ᎤᏏᎾᏌᏅᏗ")
		verbName.present1st = new DefinitionLine(syllabary: "ᏥᏏᎾᏌᏅᎦ")
		verbName.present3rd = new DefinitionLine(syllabary: "ᎠᏏᎾᏌᏅᎦ")
		verbName.remotepast = new DefinitionLine(syllabary: "ᎤᏏᎾᏌᏅᏨᎢ")
	}


	private String conj(String subject) {
		def verb = Conjugate.createVerbToConjugate(subject, "SG3AN", verbName,
		"PRESENT", PartOfSpeech.VERB_INTRANSITIVE.toString(), false)
		return Conjugate.conjugate(verb).wholeWord
	}

	void testSG1IntransitivePresent() {
		assert conj(String.valueOf(PrefixTableSubject.SG1.toString())) == "ᏥᏏᎾᏌᏅᎦ"
	}

	void testSG2IntransitivePresent() {
		assert conj(String.valueOf(PrefixTableSubject.SG2.toString())) == "ᎯᏏᎾᏌᏅᎦ"
	}

	void testSG3IntransitivePresent() {
		assert conj(String.valueOf(PrefixTableSubject.SG3.toString())) == "ᎠᏏᎾᏌᏅᎦ"
	}

	void testDL1INCLIntransitivePresent() {
		assert conj(String.valueOf(PrefixTableSubject.DL1INCL.toString())) == "ᎢᏂᏏᎾᏌᏅᎦ"
	}

	void testDL1EXCLIntransitivePresent() {
		assert conj(String.valueOf(PrefixTableSubject.DL1EXCL.toString())) == "ᎣᏍᏗᏏᎾᏌᏅᎦ"
	}

	void testPL1INCLIntransitivePresent() {
		assert conj(String.valueOf(PrefixTableSubject.PL1INCL.toString())) == "ᎢᏗᏏᎾᏌᏅᎦ"
	}

	void testPL1EXCLIntransitivePresent() {
		assert conj(String.valueOf(PrefixTableSubject.PL1EXCL.toString())) == "ᎣᏥᏏᎾᏌᏅᎦ"
	}

	void testDL2IntransitivePresent() {
		assert conj(String.valueOf(PrefixTableSubject.DL2.toString())) == "ᏍᏗᏏᎾᏌᏅᎦ"
	}

	void testPL2IntransitivePresent() {
		assert conj(String.valueOf(PrefixTableSubject.PL2.toString())) == "ᎢᏥᏏᎾᏌᏅᎦ"
	}

	void testPL3IntransitivePresent() {
		assert conj(String.valueOf(PrefixTableSubject.PL3.toString())) == "ᎠᏂᏏᎾᏌᏅᎦ"
	}

}