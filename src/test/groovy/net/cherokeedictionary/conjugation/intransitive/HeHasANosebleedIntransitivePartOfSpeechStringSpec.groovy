package net.cherokeedictionary.conjugation.intransitive

import net.cherokeedictionary.stemmer.DefinitionLine
import net.cherokeedictionary.stemmer.Stemmer
import net.cherokeedictionary.util.PartOfSpeech
import net.cherokeedictionary.util.PrefixTableSubject
import net.cherokeedictionary.verb.conjugation.Conjugate

class HeHasANosebleedIntransitivePartOfSpeechStringSpec extends GroovyTestCase {

	static def verbName = new Stemmer()

	static {
		verbName.habitual = new DefinitionLine(syllabary: "ᎩᎦ ᏕᎧᏴᏍᏉᎢᎰᎢ")
		verbName.imperative = new DefinitionLine(syllabary: "ᎩᎦ ᏘᏴᏍᏉᏣ")
		verbName.infinitive = new DefinitionLine(syllabary: "ᎩᎦ ᏧᏴᏍᏉᎢᏍᏗ")
		verbName.present1st = new DefinitionLine(syllabary: "ᎩᎦ ᏕᎦᏴᏍᏉᎢᎭ")
		verbName.present3rd = new DefinitionLine(syllabary: "ᎩᎦ ᏕᎧᏴᏍᏉᎢᎭ")
		verbName.remotepast = new DefinitionLine(syllabary: "ᎩᎦ ᏚᏴᏍᏉᎸᎢ")
	}


	private String conj(String subject) {
		def verb = Conjugate.createVerbToConjugate(subject, "SG3AN", verbName,
		"PRESENT", PartOfSpeech.VERB_INTRANSITIVE.toString(), false)
		return Conjugate.conjugate(verb).wholeWord
	}

	void testSG1IntransitivePresent() {
		assert conj(String.valueOf(PrefixTableSubject.SG1.toString())) == "ᏥᎩᎦ ᏕᎧᏴᏍᏉᎢᎭ"
	}

	void testSG2IntransitivePresent() {
		assert conj(String.valueOf(PrefixTableSubject.SG2.toString())) == "ᎯᎩᎦ ᏕᎧᏴᏍᏉᎢᎭ"
	}

	void testSG3IntransitivePresent() {
		assert conj(String.valueOf(PrefixTableSubject.SG3.toString())) == "ᎩᎦ ᏕᎧᏴᏍᏉᎢᎭ"
	}

	void testDL1INCLIntransitivePresent() {
		assert conj(String.valueOf(PrefixTableSubject.DL1INCL.toString())) == "ᎢᏂᎩᎦ ᏕᎧᏴᏍᏉᎢᎭ"
	}

	void testDL1EXCLIntransitivePresent() {
		assert conj(String.valueOf(PrefixTableSubject.DL1EXCL.toString())) == "ᎣᏍᏗᎩᎦ ᏕᎧᏴᏍᏉᎢᎭ"
	}

	void testPL1INCLIntransitivePresent() {
		assert conj(String.valueOf(PrefixTableSubject.PL1INCL.toString())) == "ᎢᏗᎩᎦ ᏕᎧᏴᏍᏉᎢᎭ"
	}

	void testPL1EXCLIntransitivePresent() {
		assert conj(String.valueOf(PrefixTableSubject.PL1EXCL.toString())) == "ᎣᏥᎩᎦ ᏕᎧᏴᏍᏉᎢᎭ"
	}

	void testDL2IntransitivePresent() {
		assert conj(String.valueOf(PrefixTableSubject.DL2.toString())) == "ᏍᏗᎩᎦ ᏕᎧᏴᏍᏉᎢᎭ"
	}

	void testPL2IntransitivePresent() {
		assert conj(String.valueOf(PrefixTableSubject.PL2.toString())) == "ᎢᏥᎩᎦ ᏕᎧᏴᏍᏉᎢᎭ"
	}

	void testPL3IntransitivePresent() {
		assert conj(String.valueOf(PrefixTableSubject.PL3.toString())) == "ᎠᏂᎩᎦ ᏕᎧᏴᏍᏉᎢᎭ"
	}

}