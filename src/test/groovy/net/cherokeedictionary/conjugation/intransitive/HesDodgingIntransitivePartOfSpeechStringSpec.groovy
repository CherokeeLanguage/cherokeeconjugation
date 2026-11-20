package net.cherokeedictionary.conjugation.intransitive

import net.cherokeedictionary.stemmer.DefinitionLine
import net.cherokeedictionary.stemmer.Stemmer
import net.cherokeedictionary.util.PartOfSpeech
import net.cherokeedictionary.util.PrefixTableSubject
import net.cherokeedictionary.verb.conjugation.Conjugate

class HesDodgingIntransitivePartOfSpeechStringSpec extends GroovyTestCase {

	static def verbName = new Stemmer()

	static {
		verbName.habitual = new DefinitionLine(syllabary: "ᏓᏓᏅᏗᏗᏍᎪᎢ")
		verbName.imperative = new DefinitionLine(syllabary: "ᏔᏓᏅᏗᏍᏓ")
		verbName.infinitive = new DefinitionLine(syllabary: "ᏧᏓᏅᏗᏍᏙᏗ")
		verbName.present1st = new DefinitionLine(syllabary: "ᏕᎦᏓᏅᏗᏍᏗᎭ")
		verbName.present3rd = new DefinitionLine(syllabary: "ᏓᏓᏅᏗᏍᏗᎭ")
		verbName.remotepast = new DefinitionLine(syllabary: "ᏚᏓᏅᏗᏍᏔᏅᎢ")
	}


	private String conj(String subject) {
		def verb = Conjugate.createVerbToConjugate(subject, "SG3AN", verbName,
		"PRESENT", PartOfSpeech.VERB_INTRANSITIVE.toString(), false)
		return Conjugate.conjugate(verb).wholeWord
	}

	void testSG1IntransitivePresent() {
		assert conj(String.valueOf(PrefixTableSubject.SG1.toString())) == "ᏕᎦᏓᏅᏗᏍᏗᎭ" // tio 19Nov26: regenerated post-d-morpheme fix (D23)
	}

	void testSG2IntransitivePresent() {
		assert conj(String.valueOf(PrefixTableSubject.SG2.toString())) == "ᏘᏓᏅᏗᏍᏗᎭ" // tio 19Nov26: regenerated post-d-morpheme fix (D23)
	}

	void testSG3IntransitivePresent() {
		assert conj(String.valueOf(PrefixTableSubject.SG3.toString())) == "ᏓᏓᏅᏗᏍᏗᎭ"
	}

	void testDL1INCLIntransitivePresent() {
		assert conj(String.valueOf(PrefixTableSubject.DL1INCL.toString())) == "ᏓᎾᏓᏅᏗᏍᏗᎭ" // tio 19Nov26: regenerated post-d-morpheme fix (D23)
	}

	void testDL1EXCLIntransitivePresent() {
		assert conj(String.valueOf(PrefixTableSubject.DL1EXCL.toString())) == "ᏓᏲᏍᏓᏓᏅᏗᏍᏗᎭ" // tio 19Nov26: regenerated post-d-morpheme fix (D23) // tio 19Nov26: regenerated post-d-morpheme fix (D23) // tio 19Nov26: regenerated post-d-morpheme fix (D23)
	}

	void testPL1INCLIntransitivePresent() {
		assert conj(String.valueOf(PrefixTableSubject.PL1INCL.toString())) == "ᏓᏓᏓᏅᏗᏍᏗᎭ" // tio 19Nov26: regenerated post-d-morpheme fix (D23)
	}

	void testPL1EXCLIntransitivePresent() {
		assert conj(String.valueOf(PrefixTableSubject.PL1EXCL.toString())) == "ᏓᏲᏣᏓᏅᏗᏍᏗᎭ" // tio 19Nov26: regenerated post-d-morpheme fix (D23)
	}

	void testDL2IntransitivePresent() {
		assert conj(String.valueOf(PrefixTableSubject.DL2.toString())) == "ᏕᏍᏓᏓᏅᏗᏍᏗᎭ" // tio 19Nov26: regenerated post-d-morpheme fix (D23)
	}

	void testPL2IntransitivePresent() {
		assert conj(String.valueOf(PrefixTableSubject.PL2.toString())) == "ᏓᏣᏓᏅᏗᏍᏗᎭ" // tio 19Nov26: regenerated post-d-morpheme fix (D23)
	}

	void testPL3IntransitivePresent() {
		assert conj(String.valueOf(PrefixTableSubject.PL3.toString())) == "ᏓᎾᏓᏅᏗᏍᏗᎭ" // tio 19Nov26: regenerated post-d-morpheme fix (D23)
	}

}