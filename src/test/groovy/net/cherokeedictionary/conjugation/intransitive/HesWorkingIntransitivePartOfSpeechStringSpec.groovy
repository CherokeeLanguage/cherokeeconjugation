package net.cherokeedictionary.conjugation.intransitive

import net.cherokeedictionary.stemmer.DefinitionLine
import net.cherokeedictionary.stemmer.Stemmer
import net.cherokeedictionary.util.PartOfSpeech
import net.cherokeedictionary.util.PrefixTableSubject
import net.cherokeedictionary.verb.conjugation.Conjugate

class HesWorkingIntransitivePartOfSpeechStringSpec extends GroovyTestCase {

	static def verbName = new Stemmer()

	static {
		verbName.habitual = new DefinitionLine(syllabary: "ᏚᎸᏫᏍᏓᏁᎰᎢ")
		verbName.imperative = new DefinitionLine(syllabary: "ᏗᏣᎸᏫᏍᏓᏏ")
		verbName.infinitive = new DefinitionLine(syllabary: "ᏧᎸᏫᏍᏓᏁᏗ")
		verbName.present1st = new DefinitionLine(syllabary: "ᏓᎩᎸᏫᏍᏓᏁᎭ")
		verbName.present3rd = new DefinitionLine(syllabary: "ᏚᎸᏫᏍᏓᏁᎭ")
		verbName.remotepast = new DefinitionLine(syllabary: "ᏚᎸᏫᏍᏓᏁᎸᎢ")
	}


	private String conj(String subject) {
		def verb = Conjugate.createVerbToConjugate(subject, "SG3AN", verbName,
		"PRESENT", PartOfSpeech.VERB_INTRANSITIVE.toString(), false)
		return Conjugate.conjugate(verb).wholeWord
	}

	void testSG1IntransitivePresent() {
		assert conj(String.valueOf(PrefixTableSubject.SG1.toString())) == "ᏓᎩᎸᏫᏍᏓᏁᎭ" // tio 19Nov26: regenerated post-d-morpheme fix (D23)
	}

	void testSG2IntransitivePresent() {
		assert conj(String.valueOf(PrefixTableSubject.SG2.toString())) == "ᏗᏣᎸᏫᏍᏓᏁᎭ" // tio 19Nov26: regenerated post-d-morpheme fix (D23)
	}

	void testSG3IntransitivePresent() {
		assert conj(String.valueOf(PrefixTableSubject.SG3.toString())) == "ᏚᎸᏫᏍᏓᏁᎭ"
	}

	void testDL1INCLIntransitivePresent() {
		assert conj(String.valueOf(PrefixTableSubject.DL1INCL.toString())) == "ᏗᎩᏂᎸᏫᏍᏓᏁᎭ" // tio 19Nov26: regenerated post-d-morpheme fix (D23)
	}

	void testDL1EXCLIntransitivePresent() {
		assert conj(String.valueOf(PrefixTableSubject.DL1EXCL.toString())) == "ᏓᏲᎩᏂᎸᏫᏍᏓᏁᎭ"
	}

	void testPL1INCLIntransitivePresent() {
		assert conj(String.valueOf(PrefixTableSubject.PL1INCL.toString())) == "ᏓᎩᎸᏫᏍᏓᏁᎭ"
	}

	void testPL1EXCLIntransitivePresent() {
		assert conj(String.valueOf(PrefixTableSubject.PL1EXCL.toString())) == "ᏓᏲᎩᎸᏫᏍᏓᏁᎭ"
	}

	void testDL2IntransitivePresent() {
		assert conj(String.valueOf(PrefixTableSubject.DL2.toString())) == "ᏗᏍᏗᎸᏫᏍᏓᏁᎭ" // tio 19Nov26: regenerated post-d-morpheme fix (D23)
	}

	void testPL2IntransitivePresent() {
		assert conj(String.valueOf(PrefixTableSubject.PL2.toString())) == "ᏓᏥᎸᏫᏍᏓᏁᎭ"
	}

	void testPL3IntransitivePresent() {
		assert conj(String.valueOf(PrefixTableSubject.PL3.toString())) == "ᏚᏂᎸᏫᏍᏓᏁᎭ"
	}

}