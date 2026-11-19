package net.cherokeedictionary.conjugation

import net.cherokeedictionary.verb.conjugation.Conjugate
import net.cherokeedictionary.stemmer.DefinitionLine
import net.cherokeedictionary.stemmer.Stemmer
import net.cherokeedictionary.util.PartOfSpeech
import groovy.util.GroovyTestCase

/**
 * Open-spelled da- initial prefix, "He is from ..." (book row: habitual
 * ᏓᏳᎶᏒᎯ, imperative ᏓᏣᎶᎯ, infinitive ᏓᏳᎶᎯᏍᏗ, present1st ᏛᎩᎶᏒᎯ,
 * present3rd ᏓᏳᎶᏒᎯ, remotepast ᏓᏳᎶᎡᏍᏛᎢ). Before the fix the da- was
 * misread as the set-A sg3 a- (removeᏕprefix Ꮣ->Ꭰ), SG1 lost the da-
 * (ᎦᏳᎶᏒᎯ instead of ᏛᎩᎶᏒᎯ = da+agi), and the prefix-stripper printed
 * "Need to add rule for: [Ꮣ-Ꮫ]" because pres1/imp/inf still began in the
 * da- glyph range. Fix: strip the open da- (ᏓᏳ -> Ꭴ, Ꮫ -> Ꭰ, imp Ꮣ
 * chopped), flag it (Stemmer.normalizedDaInitialPrefix + normalizedDaOpenU),
 * route set-B detection through ᏓᏳ, re-declare da for ALL subjects with a
 * singular object (guide rules 61-62 are person-independent; the book row
 * attests SG1 ᏛᎩᎶᏒᎯ), and let PrefixDa re-fuse the OPEN spelling ᏓᏳ the
 * citation itself uses. -- tio 19Nov26
 */
class DaInitialPrefixOpenUSpec extends GroovyTestCase {

    static def verbName = new Stemmer()

    static {
        verbName.habitual = new DefinitionLine(syllabary: "ᏓᏳᎶᏒᎯ")
        verbName.imperative = new DefinitionLine(syllabary: "ᏓᏣᎶᎯ")
        verbName.infinitive = new DefinitionLine(syllabary: "ᏓᏳᎶᎯᏍᏗ")
        verbName.present1st = new DefinitionLine(syllabary: "ᏛᎩᎶᏒᎯ")
        verbName.present3rd = new DefinitionLine(syllabary: "ᏓᏳᎶᏒᎯ")
        verbName.remotepast = new DefinitionLine(syllabary: "ᏓᏳᎶᎡᏍᏛᎢ")
    }

    private String conj(String subject, String tense = "PRESENT") {
        def verb = Conjugate.createVerbToConjugate(subject, "SG3AN", verbName,
            tense, PartOfSpeech.VERB_INTRANSITIVE.toString(), false)
        return Conjugate.conjugate(verb).wholeWord
    }

    void testNormalizationFlags() {
        assert verbName.normalizedDaInitialPrefix
        assert verbName.normalizedDaOpenU
    }

    void testSg1PresentDaAgiFusion() {
        assert conj("SG1") == "ᏛᎩᎶᏒᎯ"   // da+agi -> dv-gi
    }

    void testSg3PresentOpenDayu() {
        assert conj("SG3") == "ᏓᏳᎶᏒᎯ"   // da+u, NOT fused ᏚᎶᏒᎯ
    }

    void testSg1RemotePast() {
        assert conj("SG1", "REMOTE_PAST") == "ᏛᎩᎶᎡᏍᏛᎢ"
    }

    void testSg3RemotePast() {
        assert conj("SG3", "REMOTE_PAST") == "ᏓᏳᎶᎡᏍᏛᎢ"
    }

    void testSg3Habitual() {
        assert conj("SG3", "HABITUAL") == "ᏓᏳᎶᏒᎯ"
    }

    void testSg3Infinitive() {
        assert conj("SG3", "INFINITIVE") == "ᏓᏳᎶᎯᏍᏗ"
    }

    void testSg2ImperativeDaJa() {
        assert conj("SG2", "IMMEDIATE_COMMAND") == "ᏓᏣᎶᎯ"   // da+ja (set-B 2sg imp)
    }
}
