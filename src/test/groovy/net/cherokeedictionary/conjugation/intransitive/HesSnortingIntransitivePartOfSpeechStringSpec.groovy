package net.cherokeedictionary.conjugation.intransitive

import net.cherokeedictionary.stemmer.DefinitionLine
import net.cherokeedictionary.stemmer.Stemmer
import net.cherokeedictionary.util.PartOfSpeech
import net.cherokeedictionary.util.PrefixTableSubject
import net.cherokeedictionary.verb.conjugation.Conjugate

class HesSnortingIntransitivePartOfSpeechStringSpec extends GroovyTestCase {

	static def verbName = new Stemmer()

	static {
		verbName.habitual = new DefinitionLine(syllabary: "ᎠᏟᏴᏌᎾᏩᏍᏗᏍᎪᎢ")
		verbName.imperative = new DefinitionLine(syllabary: "ᎭᏟᏴᏌᎾᏩᏍᏓ")
		verbName.infinitive = new DefinitionLine(syllabary: "ᎤᏟᏴᏌᎾᏩᏍᏙᏗ")
		verbName.present1st = new DefinitionLine(syllabary: "ᎦᎵᏴᏌᎾᏩᏍᏗᎭ")
		verbName.present3rd = new DefinitionLine(syllabary: "ᎠᏟᏴᏌᎾᏩᏍᏗᎭ")
		verbName.remotepast = new DefinitionLine(syllabary: "ᎤᏟᏴᏌᎾᏩᏍᏔᏅᎢ")
	}


	private String conj(String subject) {
		def verb = Conjugate.createVerbToConjugate(subject, "SG3AN", verbName,
		"PRESENT", PartOfSpeech.VERB_INTRANSITIVE.toString(), false)
		return Conjugate.conjugate(verb).wholeWord
	}

	void testSG1IntransitivePresent() {
		assert conj(String.valueOf(PrefixTableSubject.SG1.toString())) == "ᎦᏟᏴᏌᎾᏩᏍᏗᎭ"
	}

	void testSG2IntransitivePresent() {
		assert conj(String.valueOf(PrefixTableSubject.SG2.toString())) == "ᎭᏟᏴᏌᎾᏩᏍᏗᎭ"
	}

	void testSG3IntransitivePresent() {
		assert conj(String.valueOf(PrefixTableSubject.SG3.toString())) == "ᎠᏟᏴᏌᎾᏩᏍᏗᎭ"
	}

	void testDL1INCLIntransitivePresent() {
		assert conj(String.valueOf(PrefixTableSubject.DL1INCL.toString())) == "ᎢᎾᏟᏴᏌᎾᏩᏍᏗᎭ"
	}

	void testDL1EXCLIntransitivePresent() {
		assert conj(String.valueOf(PrefixTableSubject.DL1EXCL.toString())) == "ᎣᏍᏓᏟᏴᏌᎾᏩᏍᏗᎭ"
	}

	void testPL1INCLIntransitivePresent() {
		assert conj(String.valueOf(PrefixTableSubject.PL1INCL.toString())) == "ᎢᏓᏟᏴᏌᎾᏩᏍᏗᎭ"
	}

	void testPL1EXCLIntransitivePresent() {
		assert conj(String.valueOf(PrefixTableSubject.PL1EXCL.toString())) == "ᎣᏣᏟᏴᏌᎾᏩᏍᏗᎭ"
	}

	void testDL2IntransitivePresent() {
		assert conj(String.valueOf(PrefixTableSubject.DL2.toString())) == "ᏍᏓᏟᏴᏌᎾᏩᏍᏗᎭ"
	}

	void testPL2IntransitivePresent() {
		assert conj(String.valueOf(PrefixTableSubject.PL2.toString())) == "ᎢᏣᏟᏴᏌᎾᏩᏍᏗᎭ"
	}

	void testPL3IntransitivePresent() {
		assert conj(String.valueOf(PrefixTableSubject.PL3.toString())) == "ᎠᎾᏟᏴᏌᎾᏩᏍᏗᎭ"
	}

}