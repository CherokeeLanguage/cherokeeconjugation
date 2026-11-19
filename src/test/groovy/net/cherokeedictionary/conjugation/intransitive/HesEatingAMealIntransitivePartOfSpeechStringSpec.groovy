package net.cherokeedictionary.conjugation.intransitive

import net.cherokeedictionary.stemmer.DefinitionLine
import net.cherokeedictionary.stemmer.Stemmer
import net.cherokeedictionary.util.PartOfSpeech
import net.cherokeedictionary.util.PrefixTableSubject
import net.cherokeedictionary.verb.conjugation.Conjugate

class HesEatingAMealIntransitivePartOfSpeechStringSpec extends GroovyTestCase {

	static def verbName = new Stemmer()

	static {
		verbName.habitual = new DefinitionLine(syllabary: "ᎠᎵᏍᏓᏴᎲᏍᎪᎢ")
		verbName.imperative = new DefinitionLine(syllabary: "ᎭᎵᏍᏓᏴᎲᎦ")
		verbName.infinitive = new DefinitionLine(syllabary: "ᎤᎵᏍᏓᏴᏗ")
		verbName.present1st = new DefinitionLine(syllabary: "ᎦᎵᏍᏓᏴᎲᏍᎦ")
		verbName.present3rd = new DefinitionLine(syllabary: "ᎠᎵᏍᏓᏴᎲᏍᎦ")
		verbName.remotepast = new DefinitionLine(syllabary: "ᎤᎵᏍᏓᏴᏅᎢ")
	}


	private String conj(String subject) {
		def verb = Conjugate.createVerbToConjugate(subject, "SG3AN", verbName,
		"PRESENT", PartOfSpeech.VERB_INTRANSITIVE.toString(), false)
		return Conjugate.conjugate(verb).wholeWord
	}

	void testSG1IntransitivePresent() {
		assert conj(String.valueOf(PrefixTableSubject.SG1.toString())) == "ᎦᎵᏍᏓᏴᎲᏍᎦ"
	}

	void testSG2IntransitivePresent() {
		assert conj(String.valueOf(PrefixTableSubject.SG2.toString())) == "ᎭᎵᏍᏓᏴᎲᏍᎦ"
	}

	void testSG3IntransitivePresent() {
		assert conj(String.valueOf(PrefixTableSubject.SG3.toString())) == "ᎠᎵᏍᏓᏴᎲᏍᎦ"
	}

	void testDL1INCLIntransitivePresent() {
		assert conj(String.valueOf(PrefixTableSubject.DL1INCL.toString())) == "ᎢᎾᎵᏍᏓᏴᎲᏍᎦ"
	}

	void testDL1EXCLIntransitivePresent() {
		assert conj(String.valueOf(PrefixTableSubject.DL1EXCL.toString())) == "ᎣᏍᏓᎵᏍᏓᏴᎲᏍᎦ"
	}

	void testPL1INCLIntransitivePresent() {
		assert conj(String.valueOf(PrefixTableSubject.PL1INCL.toString())) == "ᎢᏓᎵᏍᏓᏴᎲᏍᎦ"
	}

	void testPL1EXCLIntransitivePresent() {
		assert conj(String.valueOf(PrefixTableSubject.PL1EXCL.toString())) == "ᎣᏣᎵᏍᏓᏴᎲᏍᎦ"
	}

	void testDL2IntransitivePresent() {
		assert conj(String.valueOf(PrefixTableSubject.DL2.toString())) == "ᏍᏓᎵᏍᏓᏴᎲᏍᎦ"
	}

	void testPL2IntransitivePresent() {
		assert conj(String.valueOf(PrefixTableSubject.PL2.toString())) == "ᎢᏣᎵᏍᏓᏴᎲᏍᎦ"
	}

	void testPL3IntransitivePresent() {
		assert conj(String.valueOf(PrefixTableSubject.PL3.toString())) == "ᎠᎾᎵᏍᏓᏴᎲᏍᎦ"
	}

}