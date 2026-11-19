package net.cherokeedictionary.conjugation.intransitive

import net.cherokeedictionary.stemmer.DefinitionLine
import net.cherokeedictionary.stemmer.Stemmer
import net.cherokeedictionary.util.PartOfSpeech
import net.cherokeedictionary.util.PrefixTableSubject
import net.cherokeedictionary.verb.conjugation.Conjugate

class HeIsPullingUpWeedsIntransitivePartOfSpeechStringSpec extends GroovyTestCase {

	static def verbName = new Stemmer()

	static {
		verbName.habitual = new DefinitionLine(syllabary: "ᎨᏄᎩᏍᎪᎢ")
		verbName.imperative = new DefinitionLine(syllabary: "ᎮᏄᎩ")
		verbName.infinitive = new DefinitionLine(syllabary: "ᎤᏪᏄᎩᏍᏗ")
		verbName.present1st = new DefinitionLine(syllabary: "ᎨᏄᎩᎠ")
		verbName.present3rd = new DefinitionLine(syllabary: "ᎨᏄᎩᎠ")
		verbName.remotepast = new DefinitionLine(syllabary: "ᎤᏪᏄᎩᏒᎢ")
	}


	private String conj(String subject) {
		def verb = Conjugate.createVerbToConjugate(subject, "SG3AN", verbName,
		"PRESENT", PartOfSpeech.VERB_INTRANSITIVE.toString(), false)
		return Conjugate.conjugate(verb).wholeWord
	}

	void testSG1IntransitivePresent() {
		assert conj(String.valueOf(PrefixTableSubject.SG1.toString())) == "ᎨᏄᎩᎠ"
	}

	void testSG2IntransitivePresent() {
		assert conj(String.valueOf(PrefixTableSubject.SG2.toString())) == "ᎮᏄᎩᎠ"
	}

	void testSG3IntransitivePresent() {
		assert conj(String.valueOf(PrefixTableSubject.SG3.toString())) == "ᎨᏄᎩᎠ"
	}

	void testDL1INCLIntransitivePresent() {
		assert conj(String.valueOf(PrefixTableSubject.DL1INCL.toString())) == "ᎢᏁᏄᎩᎠ"
	}

	void testDL1EXCLIntransitivePresent() {
		assert conj(String.valueOf(PrefixTableSubject.DL1EXCL.toString())) == "ᎣᏍᏕᏄᎩᎠ"
	}

	void testPL1INCLIntransitivePresent() {
		assert conj(String.valueOf(PrefixTableSubject.PL1INCL.toString())) == "ᎢᏕᏄᎩᎠ"
	}

	void testPL1EXCLIntransitivePresent() {
		assert conj(String.valueOf(PrefixTableSubject.PL1EXCL.toString())) == "ᎣᏤᏄᎩᎠ"
	}

	void testDL2IntransitivePresent() {
		assert conj(String.valueOf(PrefixTableSubject.DL2.toString())) == "ᏍᏕᏄᎩᎠ"
	}

	void testPL2IntransitivePresent() {
		assert conj(String.valueOf(PrefixTableSubject.PL2.toString())) == "ᎢᏤᏄᎩᎠ"
	}

	void testPL3IntransitivePresent() {
		assert conj(String.valueOf(PrefixTableSubject.PL3.toString())) == "ᎠᏁᏄᎩᎠ"
	}

}