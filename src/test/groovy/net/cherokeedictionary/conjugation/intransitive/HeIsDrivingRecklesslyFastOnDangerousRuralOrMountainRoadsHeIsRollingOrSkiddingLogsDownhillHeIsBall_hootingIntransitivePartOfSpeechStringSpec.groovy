package net.cherokeedictionary.conjugation.intransitive

import net.cherokeedictionary.stemmer.DefinitionLine
import net.cherokeedictionary.stemmer.Stemmer
import net.cherokeedictionary.util.PartOfSpeech
import net.cherokeedictionary.util.PrefixTableSubject
import net.cherokeedictionary.verb.conjugation.Conjugate

class HeIsDrivingRecklesslyFastOnDangerousRuralOrMountainRoadsHeIsRollingOrSkiddingLogsDownhillHeIsBall_hootingIntransitivePartOfSpeechStringSpec extends GroovyTestCase {

	static def verbName = new Stemmer()

	static {
		verbName.habitual = new DefinitionLine(syllabary: "ᏕᎦᏳᏲᎰᎾᏗᏍᎪᎢ")
		verbName.imperative = new DefinitionLine(syllabary: "ᏘᏳᏲᎰᎾᏓ")
		verbName.infinitive = new DefinitionLine(syllabary: "ᏧᏳᏲᎰᎾᏙᏗ")
		verbName.present1st = new DefinitionLine(syllabary: "ᏕᏥᏳᏲᎣᎾᏗᎭ")
		verbName.present3rd = new DefinitionLine(syllabary: "ᏕᎦᏳᏲᎰᎾᏗᎭ")
		verbName.remotepast = new DefinitionLine(syllabary: "ᏚᏳᏲᎰᎾᏔᏅᎢ")
	}


	private String conj(String subject) {
		def verb = Conjugate.createVerbToConjugate(subject, "SG3AN", verbName,
		"PRESENT", PartOfSpeech.VERB_INTRANSITIVE.toString(), false)
		return Conjugate.conjugate(verb).wholeWord
	}

	void testSG1IntransitivePresent() {
		assert conj(String.valueOf(PrefixTableSubject.SG1.toString())) == "ᏕᏥᏳᏲᎰᎾᏗᎭ" // tio 19Nov26: regenerated post-d-morpheme fix (D23)
	}

	void testSG2IntransitivePresent() {
		assert conj(String.valueOf(PrefixTableSubject.SG2.toString())) == "ᏘᏳᏲᎰᎾᏗᎭ" // tio 19Nov26: regenerated post-d-morpheme fix (D23)
	}

	void testSG3IntransitivePresent() {
		assert conj(String.valueOf(PrefixTableSubject.SG3.toString())) == "ᏕᎦᏳᏲᎰᎾᏗᎭ"
	}

	void testDL1INCLIntransitivePresent() {
		assert conj(String.valueOf(PrefixTableSubject.DL1INCL.toString())) == "ᏓᏂᏳᏲᎰᎾᏗᎭ" // tio 19Nov26: regenerated post-d-morpheme fix (D23)
	}

	void testDL1EXCLIntransitivePresent() {
		assert conj(String.valueOf(PrefixTableSubject.DL1EXCL.toString())) == "ᏓᏲᏍᏗᏳᏲᎰᎾᏗᎭ" // tio 19Nov26: regenerated post-d-morpheme fix (D23) // tio 19Nov26: regenerated post-d-morpheme fix (D23) // tio 19Nov26: regenerated post-d-morpheme fix (D23)
	}

	void testPL1INCLIntransitivePresent() {
		assert conj(String.valueOf(PrefixTableSubject.PL1INCL.toString())) == "ᏓᏗᏳᏲᎰᎾᏗᎭ" // tio 19Nov26: regenerated post-d-morpheme fix (D23)
	}

	void testPL1EXCLIntransitivePresent() {
		assert conj(String.valueOf(PrefixTableSubject.PL1EXCL.toString())) == "ᏓᏲᏥᏳᏲᎰᎾᏗᎭ" // tio 19Nov26: regenerated post-d-morpheme fix (D23)
	}

	void testDL2IntransitivePresent() {
		assert conj(String.valueOf(PrefixTableSubject.DL2.toString())) == "ᏕᏍᏗᏳᏲᎰᎾᏗᎭ" // tio 19Nov26: regenerated post-d-morpheme fix (D23)
	}

	void testPL2IntransitivePresent() {
		assert conj(String.valueOf(PrefixTableSubject.PL2.toString())) == "ᏓᏥᏳᏲᎰᎾᏗᎭ" // tio 19Nov26: regenerated post-d-morpheme fix (D23)
	}

	void testPL3IntransitivePresent() {
		assert conj(String.valueOf(PrefixTableSubject.PL3.toString())) == "ᏓᏂᏳᏲᎰᎾᏗᎭ" // tio 19Nov26: regenerated post-d-morpheme fix (D23)
	}

}