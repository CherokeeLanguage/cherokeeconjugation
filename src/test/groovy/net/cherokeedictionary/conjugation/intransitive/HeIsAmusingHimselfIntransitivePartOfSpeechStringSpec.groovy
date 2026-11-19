package net.cherokeedictionary.conjugation.intransitive

import net.cherokeedictionary.stemmer.DefinitionLine
import net.cherokeedictionary.stemmer.Stemmer
import net.cherokeedictionary.util.PartOfSpeech
import net.cherokeedictionary.util.PrefixTableSubject
import net.cherokeedictionary.verb.conjugation.Conjugate

class HeIsAmusingHimselfIntransitivePartOfSpeechStringSpec extends GroovyTestCase {

	static def verbName = new Stemmer()

	static {
		verbName.habitual = new DefinitionLine(syllabary: "ᎠᏍᏆᏂᎪᏒᎥᏍᎪᎢ")
		verbName.imperative = new DefinitionLine(syllabary: "ᎯᏍᏆᏂᎪᏒᎥᎦ")
		verbName.infinitive = new DefinitionLine(syllabary: "ᎤᏍᏆᏂᎪᏍᏗ")
		verbName.present1st = new DefinitionLine(syllabary: "ᏥᏍᏆᏂᎪᏒᎥᏍᎦ")
		verbName.present3rd = new DefinitionLine(syllabary: "ᎠᏍᏆᏂᎪᏒᎥᏍᎦ")
		verbName.remotepast = new DefinitionLine(syllabary: "ᎤᏍᏆᏂᎪᏒᏅᎢ")
	}


	private String conj(String subject) {
		def verb = Conjugate.createVerbToConjugate(subject, "SG3AN", verbName,
		"PRESENT", PartOfSpeech.VERB_INTRANSITIVE.toString(), false)
		return Conjugate.conjugate(verb).wholeWord
	}

	void testSG1IntransitivePresent() {
		assert conj(String.valueOf(PrefixTableSubject.SG1.toString())) == "ᏥᏍᏆᏂᎪᏒᎥᏍᎦ"
	}

	void testSG2IntransitivePresent() {
		assert conj(String.valueOf(PrefixTableSubject.SG2.toString())) == "ᎯᏍᏆᏂᎪᏒᎥᏍᎦ"
	}

	void testSG3IntransitivePresent() {
		assert conj(String.valueOf(PrefixTableSubject.SG3.toString())) == "ᎠᏍᏆᏂᎪᏒᎥᏍᎦ"
	}

	void testDL1INCLIntransitivePresent() {
		assert conj(String.valueOf(PrefixTableSubject.DL1INCL.toString())) == "ᎢᏂᏍᏆᏂᎪᏒᎥᏍᎦ"
	}

	void testDL1EXCLIntransitivePresent() {
		assert conj(String.valueOf(PrefixTableSubject.DL1EXCL.toString())) == "ᎣᏍᏗᏍᏆᏂᎪᏒᎥᏍᎦ"
	}

	void testPL1INCLIntransitivePresent() {
		assert conj(String.valueOf(PrefixTableSubject.PL1INCL.toString())) == "ᎢᏗᏍᏆᏂᎪᏒᎥᏍᎦ"
	}

	void testPL1EXCLIntransitivePresent() {
		assert conj(String.valueOf(PrefixTableSubject.PL1EXCL.toString())) == "ᎣᏥᏍᏆᏂᎪᏒᎥᏍᎦ"
	}

	void testDL2IntransitivePresent() {
		assert conj(String.valueOf(PrefixTableSubject.DL2.toString())) == "ᏍᏗᏍᏆᏂᎪᏒᎥᏍᎦ"
	}

	void testPL2IntransitivePresent() {
		assert conj(String.valueOf(PrefixTableSubject.PL2.toString())) == "ᎢᏥᏍᏆᏂᎪᏒᎥᏍᎦ"
	}

	void testPL3IntransitivePresent() {
		assert conj(String.valueOf(PrefixTableSubject.PL3.toString())) == "ᎠᏂᏍᏆᏂᎪᏒᎥᏍᎦ"
	}

}