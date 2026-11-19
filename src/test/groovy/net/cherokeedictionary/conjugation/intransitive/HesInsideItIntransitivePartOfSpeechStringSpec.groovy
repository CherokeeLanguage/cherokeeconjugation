package net.cherokeedictionary.conjugation.intransitive

import net.cherokeedictionary.stemmer.DefinitionLine
import net.cherokeedictionary.stemmer.Stemmer
import net.cherokeedictionary.util.PartOfSpeech
import net.cherokeedictionary.util.PrefixTableSubject
import net.cherokeedictionary.verb.conjugation.Conjugate

class HesInsideItIntransitivePartOfSpeechStringSpec extends GroovyTestCase {

	static def verbName = new Stemmer()

	static {
		verbName.habitual = new DefinitionLine(syllabary: "ᎤᏣᎣᎢ")
		verbName.imperative = new DefinitionLine(syllabary: "ᏣᏣᎡᏍᏗ")
		verbName.infinitive = new DefinitionLine(syllabary: "-")
		verbName.present1st = new DefinitionLine(syllabary: "ᎠᏆᏣᎠ")
		verbName.present3rd = new DefinitionLine(syllabary: "ᎤᏣᎠ")
		verbName.remotepast = new DefinitionLine(syllabary: "ᎤᏣᎥᎢ")
	}


	private String conj(String subject) {
		def verb = Conjugate.createVerbToConjugate(subject, "SG3AN", verbName,
		"PRESENT", PartOfSpeech.VERB_INTRANSITIVE.toString(), false)
		return Conjugate.conjugate(verb).wholeWord
	}

	void testSG1IntransitivePresent() {
		assert conj(String.valueOf(PrefixTableSubject.SG1.toString())) == "ᎠᏆᏣᎠ"
	}

	void testSG2IntransitivePresent() {
		assert conj(String.valueOf(PrefixTableSubject.SG2.toString())) == "ᏣᏣᎠ"
	}

	void testSG3IntransitivePresent() {
		assert conj(String.valueOf(PrefixTableSubject.SG3.toString())) == "ᎤᏣᎠ"
	}

	void testDL1INCLIntransitivePresent() {
		assert conj(String.valueOf(PrefixTableSubject.DL1INCL.toString())) == "ᎩᎾᏣᎠ"
	}

	void testDL1EXCLIntransitivePresent() {
		assert conj(String.valueOf(PrefixTableSubject.DL1EXCL.toString())) == "ᎣᎩᎾᏣᎠ"
	}

	void testPL1INCLIntransitivePresent() {
		assert conj(String.valueOf(PrefixTableSubject.PL1INCL.toString())) == "ᎢᎦᏣᎠ"
	}

	void testPL1EXCLIntransitivePresent() {
		assert conj(String.valueOf(PrefixTableSubject.PL1EXCL.toString())) == "ᎣᎦᏣᎠ"
	}

	void testDL2IntransitivePresent() {
		assert conj(String.valueOf(PrefixTableSubject.DL2.toString())) == "ᏍᏓᏣᎠ"
	}

	void testPL2IntransitivePresent() {
		assert conj(String.valueOf(PrefixTableSubject.PL2.toString())) == "ᎢᏣᏣᎠ"
	}

	void testPL3IntransitivePresent() {
		assert conj(String.valueOf(PrefixTableSubject.PL3.toString())) == "ᎤᎾᏣᎠ"
	}

}