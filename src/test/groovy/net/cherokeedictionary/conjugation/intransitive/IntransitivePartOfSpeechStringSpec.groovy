package net.cherokeedictionary.conjugation.intransitive

import net.cherokeedictionary.verb.conjugation.Conjugate
import net.cherokeedictionary.stemmer.DefinitionLine
import net.cherokeedictionary.stemmer.Stemmer
import net.cherokeedictionary.util.PartOfSpeech
import net.cherokeedictionary.util.PrefixTableSubject

/**
 * Repro for the intransitive part-of-speech string bug: passing
 * PartOfSpeech.VERB_INTRANSITIVE.toString() ("VERB_INTRANSITIVE") was
 * classified as TRANSITIVE by ConjugationHelper.determinePartOfSpeech,
 * which only recognized 'v.i.'/'vi'. The SG3AN object argument then
 * survived and transitive compound-prefix rows were used
 * (SG1 -> ᏥᏯᏓᏩᏛᎯᏙᎭ, SG3 -> ᎠᎦᏓᏩᏛᎯᏙᎭ). -- tio 19Nov26
 */
class IntransitivePartOfSpeechStringSpec extends GroovyTestCase {

    static def verbName = new Stemmer()

    static {
        verbName.habitual = new DefinitionLine(syllabary: "ᎠᏓᏩᏛᎯᏙᎰᎢ")
        verbName.imperative = new DefinitionLine(syllabary: "ᎭᏓᏩᏛᎯᏓ")
        verbName.infinitive = new DefinitionLine(syllabary: "ᎤᏓᏩᏛᎯᏓᏍᏗ")
        verbName.present1st = new DefinitionLine(syllabary: "ᎦᏓᏩᏛᎯᏙᎭ")
        verbName.present3rd = new DefinitionLine(syllabary: "ᎠᏓᏩᏛᎯᏙᎭ")
        verbName.remotepast = new DefinitionLine(syllabary: "ᎤᏓᏩᏛᎯᏙᎸᎢ")
    }

    private String conj(String subject) {
        def verb = Conjugate.createVerbToConjugate(subject, "SG3AN", verbName,
            "PRESENT", PartOfSpeech.VERB_INTRANSITIVE.toString(), false)
        return Conjugate.conjugate(verb).wholeWord
    }

    void testSg3IntransitivePresent() {
        assert conj(String.valueOf(PrefixTableSubject.SG3)) == "ᎠᏓᏩᏛᎯᏙᎭ"
    }

    void testSg1IntransitivePresent() {
        assert conj(String.valueOf(PrefixTableSubject.SG1)) == "ᎦᏓᏩᏛᎯᏙᎭ"
    }

    void testSG2IntransitivePresent() {
        assert conj(String.valueOf(PrefixTableSubject.SG2)) == "ᎭᏓᏩᏛᎯᏙᎭ"
    }

    void test1DLINCLIntransitivePresent() {
        assert conj(String.valueOf(PrefixTableSubject.DL1INCL)) == "ᎢᎾᏓᏩᏛᎯᏙᎭ"
    }

    void test1DLEXCLIntransitivePresent() {
        assert conj(String.valueOf(PrefixTableSubject.DL1EXCL)) == "ᎣᏍᏓᏓᏩᏛᎯᏙᎭ"
    }

    void test1PLINCLIntransitivePresent() {
        assert conj(String.valueOf(PrefixTableSubject.PL1INCL)) == "ᎢᏓᏓᏩᏛᎯᏙᎭ"
    }

    void test1PLECLIntransitivePresent() {
        assert conj(String.valueOf(PrefixTableSubject.PL1EXCL)) == "ᎣᏣᏓᏩᏛᎯᏙᎭ"
    }

    void test2DLIntransitivePresent() {
        assert conj(String.valueOf(PrefixTableSubject.DL2)) == "ᏍᏓᏓᏩᏛᎯᏙᎭ"
    }

    void test2PLIntransitivePresent() {
        assert conj(String.valueOf(PrefixTableSubject.PL2)) == "ᎢᏣᏓᏩᏛᎯᏙᎭ"
    }

    void test3PLIntransitivePresent() {
        assert conj(String.valueOf(PrefixTableSubject.PL3)) == "ᎠᎾᏓᏩᏛᎯᏙᎭ"
    }

    void testOtherAcceptedSpellings() {
        // the same verb must stay intransitive through every accepted spelling
        ["v.i.", "vi", "VERB_INTRANSITIVE", "intransitive"].each { pos ->
            def verb = Conjugate.createVerbToConjugate("SG1", "SG3AN", verbName,
                "PRESENT", pos, false)
            assert Conjugate.conjugate(verb).wholeWord == "ᎦᏓᏩᏛᎯᏙᎭ",
                "partOfSpeech='${pos}' not treated as intransitive"
        }
    }
}
