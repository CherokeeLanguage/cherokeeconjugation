package net.cherokeedictionary.conjugation.intransitive

import net.cherokeedictionary.stemmer.DefinitionLine
import net.cherokeedictionary.stemmer.Stemmer
import net.cherokeedictionary.util.PartOfSpeech
import net.cherokeedictionary.util.PrefixTableSubject
import net.cherokeedictionary.verb.conjugation.Conjugate

class OneHesLonesome2HesHomesickIntransitivePartOfSpeechStringSpec extends GroovyTestCase {

	static def verbName = new Stemmer()

	static {
		verbName.habitual = new DefinitionLine(syllabary: "ᎤᎯᏐᏓᏁᎰᎢ")
		verbName.imperative = new DefinitionLine(syllabary: "ᏣᎯᏐᏓᏏ")
		verbName.infinitive = new DefinitionLine(syllabary: "ᎤᎯᏐᏓᏁᏗ")
		verbName.present1st = new DefinitionLine(syllabary: "ᎠᎩᎯᏐᏓᏁᎭ, ᎠᎩᏐᏓᏁᎭ")
		verbName.present3rd = new DefinitionLine(syllabary: "ᎤᎯᏐᏓᏁᎭ")
		verbName.remotepast = new DefinitionLine(syllabary: "ᎤᎯᏐᏓᏁᎸᎢ")
	}


	private String conj(String subject) {
		def verb = Conjugate.createVerbToConjugate(subject, "SG3AN", verbName,
		"PRESENT", PartOfSpeech.VERB_INTRANSITIVE.toString(), false)
		return Conjugate.conjugate(verb).wholeWord
	}

	void testSG1IntransitivePresent() {
		assert conj(String.valueOf(PrefixTableSubject.SG1.toString())) == "ᎠᎩᎯᏐᏓᏁᎭ"
	}

	void testSG2IntransitivePresent() {
		assert conj(String.valueOf(PrefixTableSubject.SG2.toString())) == "ᏣᎯᏐᏓᏁᎭ"
	}

	void testSG3IntransitivePresent() {
		assert conj(String.valueOf(PrefixTableSubject.SG3.toString())) == "ᎤᎯᏐᏓᏁᎭ"
	}

	void testDL1INCLIntransitivePresent() {
		assert conj(String.valueOf(PrefixTableSubject.DL1INCL.toString())) == "ᎩᏂᎯᏐᏓᏁᎭ"
	}

	void testDL1EXCLIntransitivePresent() {
		assert conj(String.valueOf(PrefixTableSubject.DL1EXCL.toString())) == "ᎣᎩᏂᎯᏐᏓᏁᎭ"
	}

	void testPL1INCLIntransitivePresent() {
		assert conj(String.valueOf(PrefixTableSubject.PL1INCL.toString())) == "ᎢᎩᎯᏐᏓᏁᎭ"
	}

	void testPL1EXCLIntransitivePresent() {
		assert conj(String.valueOf(PrefixTableSubject.PL1EXCL.toString())) == "ᎣᎩᎯᏐᏓᏁᎭ"
	}

	void testDL2IntransitivePresent() {
		assert conj(String.valueOf(PrefixTableSubject.DL2.toString())) == "ᏍᏗᎯᏐᏓᏁᎭ"
	}

	void testPL2IntransitivePresent() {
		assert conj(String.valueOf(PrefixTableSubject.PL2.toString())) == "ᎢᏥᎯᏐᏓᏁᎭ"
	}

	void testPL3IntransitivePresent() {
		assert conj(String.valueOf(PrefixTableSubject.PL3.toString())) == "ᎤᏂᎯᏐᏓᏁᎭ"
	}

}