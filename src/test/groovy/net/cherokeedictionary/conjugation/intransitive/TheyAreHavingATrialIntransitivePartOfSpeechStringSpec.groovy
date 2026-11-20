package net.cherokeedictionary.conjugation.intransitive

import net.cherokeedictionary.stemmer.DefinitionLine
import net.cherokeedictionary.stemmer.Stemmer
import net.cherokeedictionary.util.PartOfSpeech
import net.cherokeedictionary.util.PrefixTableSubject
import net.cherokeedictionary.verb.conjugation.Conjugate

class TheyAreHavingATrialIntransitivePartOfSpeechStringSpec extends GroovyTestCase {

	static def verbName = new Stemmer()

	static {
		verbName.habitual = new DefinitionLine(syllabary: "ᏓᎾᏓᎯᎵᏙᎰᎢ")
		verbName.imperative = new DefinitionLine(syllabary: "ᏗᏣᏓᎯᎵᏓ")
		verbName.infinitive = new DefinitionLine(syllabary: "ᏧᎾᏓᎯᎵᏓᏍᏗ")
		verbName.present1st = new DefinitionLine(syllabary: "ᏙᏣᏓᎯᎵᏙᎭ")
		verbName.present3rd = new DefinitionLine(syllabary: "ᏓᎾᏓᎯᎵᏙᎭ")
		verbName.remotepast = new DefinitionLine(syllabary: "ᏚᎾᏓᎯᎵᏙᎸᎢ")
	}


	private String conj(String subject) {
		def verb = Conjugate.createVerbToConjugate(subject, "SG3AN", verbName,
		"PRESENT", PartOfSpeech.VERB_INTRANSITIVE.toString(), false)
		return Conjugate.conjugate(verb).wholeWord
	}

	void testSG1IntransitivePresent() {
		assert conj(String.valueOf(PrefixTableSubject.SG1.toString())) == "ᏗᎦᎾᏓᎯᎵᏙᎭ" // tio 19Nov26: regenerated post-d-morpheme fix (D23)
	}

	void testSG2IntransitivePresent() {
		assert conj(String.valueOf(PrefixTableSubject.SG2.toString())) == "ᏘᎾᏓᎯᎵᏙᎭ" // tio 19Nov26: regenerated post-d-morpheme fix (D23)
	}

	void testSG3IntransitivePresent() {
		assert conj(String.valueOf(PrefixTableSubject.SG3.toString())) == "ᏓᎾᏓᎯᎵᏙᎭ"
	}

	void testDL1INCLIntransitivePresent() {
		assert conj(String.valueOf(PrefixTableSubject.DL1INCL.toString())) == "ᏓᎾᎾᏓᎯᎵᏙᎭ" // tio 19Nov26: regenerated post-d-morpheme fix (D23)
	}

	void testDL1EXCLIntransitivePresent() {
		assert conj(String.valueOf(PrefixTableSubject.DL1EXCL.toString())) == "ᏓᏲᏍᏓᎾᏓᎯᎵᏙᎭ" // tio 19Nov26: regenerated post-d-morpheme fix (D23) // tio 19Nov26: regenerated post-d-morpheme fix (D23) // tio 19Nov26: regenerated post-d-morpheme fix (D23)
	}

	void testPL1INCLIntransitivePresent() {
		assert conj(String.valueOf(PrefixTableSubject.PL1INCL.toString())) == "ᏓᏓᎾᏓᎯᎵᏙᎭ" // tio 19Nov26: regenerated post-d-morpheme fix (D23)
	}

	void testPL1EXCLIntransitivePresent() {
		assert conj(String.valueOf(PrefixTableSubject.PL1EXCL.toString())) == "ᏓᏲᏣᎾᏓᎯᎵᏙᎭ" // tio 19Nov26: regenerated post-d-morpheme fix (D23)
	}

	void testDL2IntransitivePresent() {
		assert conj(String.valueOf(PrefixTableSubject.DL2.toString())) == "ᏗᏍᏓᎾᏓᎯᎵᏙᎭ" // tio 19Nov26: regenerated post-d-morpheme fix (D23)
	}

	void testPL2IntransitivePresent() {
		assert conj(String.valueOf(PrefixTableSubject.PL2.toString())) == "ᏓᏣᎾᏓᎯᎵᏙᎭ" // tio 19Nov26: regenerated post-d-morpheme fix (D23)
	}

	void testPL3IntransitivePresent() {
		assert conj(String.valueOf(PrefixTableSubject.PL3.toString())) == "ᏛᎾᎾᏓᎯᎵᏙᎭ" // tio 19Nov26: regenerated post-d-morpheme fix (D23)
	}

}