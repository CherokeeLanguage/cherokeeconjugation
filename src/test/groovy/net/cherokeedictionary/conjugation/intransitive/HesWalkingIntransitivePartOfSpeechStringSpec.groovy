package net.cherokeedictionary.conjugation.intransitive

import net.cherokeedictionary.stemmer.DefinitionLine
import net.cherokeedictionary.stemmer.Stemmer
import net.cherokeedictionary.util.PartOfSpeech
import net.cherokeedictionary.util.PrefixTableSubject
import net.cherokeedictionary.verb.conjugation.Conjugate

class HesWalkingIntransitivePartOfSpeechStringSpec extends GroovyTestCase {

	static def verbName = new Stemmer()

	static {
		verbName.habitual = new DefinitionLine(syllabary: "ᎠᎢᏐᎢ")
		verbName.imperative = new DefinitionLine(syllabary: "-")
		verbName.infinitive = new DefinitionLine(syllabary: "-")
		verbName.present1st = new DefinitionLine(syllabary: "ᎦᎢ")
		verbName.present3rd = new DefinitionLine(syllabary: "ᎠᎢ")
		verbName.remotepast = new DefinitionLine(syllabary: "ᎠᎢᏒᎢ")
	}


	private String conj(String subject) {
		def verb = Conjugate.createVerbToConjugate(subject, "SG3AN", verbName,
		"PRESENT", PartOfSpeech.VERB_INTRANSITIVE.toString(), false)
		return Conjugate.conjugate(verb).wholeWord
	}

	void testSG1IntransitivePresent() {
		assert conj(String.valueOf(PrefixTableSubject.SG1.toString())) == "ᎦᎢ"
	}

	void testSG2IntransitivePresent() {
		assert conj(String.valueOf(PrefixTableSubject.SG2.toString())) == "ᎭᎢ"
	}

	void testSG3IntransitivePresent() {
		assert conj(String.valueOf(PrefixTableSubject.SG3.toString())) == "ᎠᎢ"
	}

	void testDL1INCLIntransitivePresent() {
		assert conj(String.valueOf(PrefixTableSubject.DL1INCL.toString())) == "ᎢᎾᎢ"
	}

	void testDL1EXCLIntransitivePresent() {
		assert conj(String.valueOf(PrefixTableSubject.DL1EXCL.toString())) == "ᎣᏍᏓᎢ"
	}

	void testPL1INCLIntransitivePresent() {
		assert conj(String.valueOf(PrefixTableSubject.PL1INCL.toString())) == "ᎢᏓᎢ"
	}

	void testPL1EXCLIntransitivePresent() {
		assert conj(String.valueOf(PrefixTableSubject.PL1EXCL.toString())) == "ᎣᏣᎢ"
	}

	void testDL2IntransitivePresent() {
		assert conj(String.valueOf(PrefixTableSubject.DL2.toString())) == "ᏍᏓᎢ"
	}

	void testPL2IntransitivePresent() {
		assert conj(String.valueOf(PrefixTableSubject.PL2.toString())) == "ᎢᏣᎢ"
	}

	void testPL3IntransitivePresent() {
		assert conj(String.valueOf(PrefixTableSubject.PL3.toString())) == "ᎠᎾᎢ"
	}

}