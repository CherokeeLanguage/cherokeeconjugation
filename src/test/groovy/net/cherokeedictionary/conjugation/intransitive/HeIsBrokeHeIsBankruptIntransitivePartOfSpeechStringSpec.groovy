package net.cherokeedictionary.conjugation.intransitive

import net.cherokeedictionary.stemmer.DefinitionLine
import net.cherokeedictionary.stemmer.Stemmer
import net.cherokeedictionary.util.PartOfSpeech
import net.cherokeedictionary.util.PrefixTableSubject
import net.cherokeedictionary.verb.conjugation.Conjugate

class HeIsBrokeHeIsBankruptIntransitivePartOfSpeechStringSpec extends GroovyTestCase {

	static def verbName = new Stemmer()

	static {
		verbName.habitual = new DefinitionLine(syllabary: "ᏚᎵᏍᏆᎵᏒᏍᎪᎢ")
		verbName.imperative = new DefinitionLine(syllabary: "ᏗᏣᎵᏍᏆᎵᏒᎠᎦ")
		verbName.infinitive = new DefinitionLine(syllabary: "ᏧᎵᏍᏆᎵᏒᏍᏗ")
		verbName.present1st = new DefinitionLine(syllabary: "ᏓᏆᎵᏍᏆᎵᏒᎢᎠ")
		verbName.present3rd = new DefinitionLine(syllabary: "ᏚᎵᏍᏆᎵᏒᎯᎠ")
		verbName.remotepast = new DefinitionLine(syllabary: "ᏚᎵᏍᏆᎵᏒᏒᎢ")
	}


	private String conj(String subject) {
		def verb = Conjugate.createVerbToConjugate(subject, "SG3AN", verbName,
		"PRESENT", PartOfSpeech.VERB_INTRANSITIVE.toString(), false)
		return Conjugate.conjugate(verb).wholeWord
	}

	void testSG1IntransitivePresent() {
		assert conj(String.valueOf(PrefixTableSubject.SG1.toString())) == "ᎠᏆᎵᏍᏆᎵᏒᎯᎠ"
	}

	void testSG2IntransitivePresent() {
		assert conj(String.valueOf(PrefixTableSubject.SG2.toString())) == "ᏣᎵᏍᏆᎵᏒᎯᎠ"
	}

	void testSG3IntransitivePresent() {
		assert conj(String.valueOf(PrefixTableSubject.SG3.toString())) == "ᏚᎵᏍᏆᎵᏒᎯᎠ"
	}

	void testDL1INCLIntransitivePresent() {
		assert conj(String.valueOf(PrefixTableSubject.DL1INCL.toString())) == "ᏓᎩᎾᎵᏍᏆᎵᏒᎯᎠ"
	}

	void testDL1EXCLIntransitivePresent() {
		assert conj(String.valueOf(PrefixTableSubject.DL1EXCL.toString())) == "ᏓᏲᎩᎾᎵᏍᏆᎵᏒᎯᎠ"
	}

	void testPL1INCLIntransitivePresent() {
		assert conj(String.valueOf(PrefixTableSubject.PL1INCL.toString())) == "ᏓᎦᎵᏍᏆᎵᏒᎯᎠ"
	}

	void testPL1EXCLIntransitivePresent() {
		assert conj(String.valueOf(PrefixTableSubject.PL1EXCL.toString())) == "ᏓᏲᎦᎵᏍᏆᎵᏒᎯᎠ"
	}

	void testDL2IntransitivePresent() {
		assert conj(String.valueOf(PrefixTableSubject.DL2.toString())) == "ᏓᏍᏓᎵᏍᏆᎵᏒᎯᎠ"
	}

	void testPL2IntransitivePresent() {
		assert conj(String.valueOf(PrefixTableSubject.PL2.toString())) == "ᏓᏣᎵᏍᏆᎵᏒᎯᎠ"
	}

	void testPL3IntransitivePresent() {
		assert conj(String.valueOf(PrefixTableSubject.PL3.toString())) == "ᏚᎾᎵᏍᏆᎵᏒᎯᎠ"
	}

}