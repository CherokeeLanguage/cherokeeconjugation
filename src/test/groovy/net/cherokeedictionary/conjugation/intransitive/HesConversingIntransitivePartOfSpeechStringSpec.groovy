package net.cherokeedictionary.conjugation.intransitive

import net.cherokeedictionary.stemmer.DefinitionLine
import net.cherokeedictionary.stemmer.Stemmer
import net.cherokeedictionary.util.PartOfSpeech
import net.cherokeedictionary.util.PrefixTableSubject
import net.cherokeedictionary.verb.conjugation.Conjugate

class HesConversingIntransitivePartOfSpeechStringSpec extends GroovyTestCase {

	static def verbName = new Stemmer()

	static {
		verbName.habitual = new DefinitionLine(syllabary: "ᏓᏟᏃᎮᏍᎪᎢ")
		verbName.imperative = new DefinitionLine(syllabary: "ᏔᏟᏃᎲᎳ")
		verbName.infinitive = new DefinitionLine(syllabary: "ᏧᏟᏃᎮᏗ")
		verbName.present1st = new DefinitionLine(syllabary: "ᏕᎦᎵᏃᎮᎭ")
		verbName.present3rd = new DefinitionLine(syllabary: "ᏓᏟᏃᎮᎭ")
		verbName.remotepast = new DefinitionLine(syllabary: "ᏚᏟᏃᎮᎸᎢ")
	}


	private String conj(String subject) {
		def verb = Conjugate.createVerbToConjugate(subject, "SG3AN", verbName,
		"PRESENT", PartOfSpeech.VERB_INTRANSITIVE.toString(), false)
		return Conjugate.conjugate(verb).wholeWord
	}

	void testSG1IntransitivePresent() {
		assert conj(String.valueOf(PrefixTableSubject.SG1.toString())) == "ᏕᎦᏟᏃᎮᎭ" // tio 19Nov26: regenerated post-d-morpheme fix (D23)
	}

	void testSG2IntransitivePresent() {
		assert conj(String.valueOf(PrefixTableSubject.SG2.toString())) == "ᏕᎭᏟᏃᎮᎭ" // tio 19Nov26: regenerated post-d-morpheme fix (D23) // tio 20Nov26: re-pinned post-DST h-branch fix (de-style keeps the e before h-glyphs, guide 61a/117a)
	}

	void testSG3IntransitivePresent() {
		assert conj(String.valueOf(PrefixTableSubject.SG3.toString())) == "ᏓᏟᏃᎮᎭ"
	}

	void testDL1INCLIntransitivePresent() {
		assert conj(String.valueOf(PrefixTableSubject.DL1INCL.toString())) == "ᏓᎾᏟᏃᎮᎭ" // tio 19Nov26: regenerated post-d-morpheme fix (D23)
	}

	void testDL1EXCLIntransitivePresent() {
		assert conj(String.valueOf(PrefixTableSubject.DL1EXCL.toString())) == "ᏓᏲᏍᏓᏟᏃᎮᎭ" // tio 19Nov26: regenerated post-d-morpheme fix (D23)
	}

	void testPL1INCLIntransitivePresent() {
		assert conj(String.valueOf(PrefixTableSubject.PL1INCL.toString())) == "ᏓᏓᏟᏃᎮᎭ" // tio 19Nov26: regenerated post-d-morpheme fix (D23)
	}

	void testPL1EXCLIntransitivePresent() {
		assert conj(String.valueOf(PrefixTableSubject.PL1EXCL.toString())) == "ᏓᏲᏣᏟᏃᎮᎭ" // tio 19Nov26: regenerated post-d-morpheme fix (D23)
	}

	void testDL2IntransitivePresent() {
		assert conj(String.valueOf(PrefixTableSubject.DL2.toString())) == "ᏕᏍᏓᏟᏃᎮᎭ" // tio 19Nov26: regenerated post-d-morpheme fix (D23)
	}

	void testPL2IntransitivePresent() {
		assert conj(String.valueOf(PrefixTableSubject.PL2.toString())) == "ᏓᏣᏟᏃᎮᎭ" // tio 19Nov26: regenerated post-d-morpheme fix (D23)
	}

	void testPL3IntransitivePresent() {
		assert conj(String.valueOf(PrefixTableSubject.PL3.toString())) == "ᏓᎾᏟᏃᎮᎭ" // tio 19Nov26: regenerated post-d-morpheme fix (D23)
	}

}