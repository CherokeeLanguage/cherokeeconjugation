package net.cherokeedictionary.conjugation

import net.cherokeedictionary.stemmer.Stemmer
import net.cherokeedictionary.verb.conjugation.Conjugate


/*This code should be in every file*/

/**
 * tio 20Nov26: rewritten to the guide hold1 I-E paradigms (pp. 296-297,
 * P1 "to see oneself" present + P2 past) -- the previous assertions were the
 * pre-guide no-pronominal placeholders compared against pronounReflexiveRoot
 * (the file's own TODO said "fix this to match the reflexive examples").
 * Whole-word assertions: pronominal + ada(d)- + stem -- P1 ᎦᏓᎪᏩᏘᎭ
 * ga-da-gowtiha "I see myself", P2 ᎠᏆᏓᎪᎲᎢ agw-da-gohv'i "I saw myself".
 * The reflexive consumes the object slot (subject-only compounds, guide P1)
 * and forces Set A in the present (guide P5, class-B verbs) -- see
 * ConjugationHelper.determineSubjectObject/determineVerbSet and
 * ReflexivePrefix. -- tio 20Nov26
 */
class ConjugateReflexivePrefixPresentTense extends ConjugateBase {
    private static String conjRefl(String subject, Stemmer stemmer, String verbTense) {
        def v = Conjugate.conjugate(subject, "SG3AN", stemmer, verbTense, "v.t.", true)
        return v.wholeWord
    }

    void testReflexivePresentTense() {
        // P1 "to see oneself" (guide hold1 p. 296) -- all nine persons
        assertEquals "ᎦᏓᎪᏩᏘᎭ", conjRefl("SG1", gowatiha, "PRESENT")
        assertEquals "ᎭᏓᎪᏩᏘᎭ", conjRefl("SG2", gowatiha, "PRESENT")
        assertEquals "ᎠᏓᎪᏩᏘᎭ", conjRefl("SG3", gowatiha, "PRESENT")
        assertEquals "ᎢᎾᏓᎪᏩᏘᎭ", conjRefl("DL1INCL", gowatiha, "PRESENT")
        assertEquals "ᎢᏓᏓᎪᏩᏘᎭ", conjRefl("PL1INCL", gowatiha, "PRESENT")
        assertEquals "ᎣᏍᏓᏓᎪᏩᏘᎭ", conjRefl("DL1EXCL", gowatiha, "PRESENT")
        assertEquals "ᎣᏣᏓᎪᏩᏘᎭ", conjRefl("PL1EXCL", gowatiha, "PRESENT")
        assertEquals "ᏍᏓᏓᎪᏩᏘᎭ", conjRefl("DL2", gowatiha, "PRESENT")
        assertEquals "ᎢᏣᏓᎪᏩᏘᎭ", conjRefl("PL2", gowatiha, "PRESENT")
    }

    void testReflexiveRemotePastTense() {
        // P2 "to see oneself," past tense (guide hold1 pp. 296-297) -- Set B
        assertEquals "ᎠᏆᏓᎪᎲᎢ", conjRefl("SG1", gowatiha, "REMOTE_PAST")
        assertEquals "ᏣᏓᎪᎲᎢ", conjRefl("SG2", gowatiha, "REMOTE_PAST")
        assertEquals "ᎤᏓᎪᎲᎢ", conjRefl("SG3", gowatiha, "REMOTE_PAST")
        // guide P2 DL1INCL prints ᎦᎾᏓᎪᎲᎢ but romanizes gị²nạ²da² (gi-na-da) --
        // the Ꭶ/Ꭹ glyph variance; the engine's ᎩᏂ (gini-) compound composes
        // gi-na-da, pronunciation-identical. -- tio 20Nov26
        assertEquals "ᎩᎾᏓᎪᎲᎢ", conjRefl("DL1INCL", gowatiha, "REMOTE_PAST")
        assertEquals "ᎣᎦᏓᎪᎲᎢ", conjRefl("PL1EXCL", gowatiha, "REMOTE_PAST")
    }

    void testReflexiveHitParadigm() {
        // guide hold1 (1b)/(4b) "to hit oneself" -- the Ꭵ/Ꮹ artifact glyph of
        // the routed stem (ᎥᏂᎭ, ᎥᏂᎸᎢ) fuses with the adad- d: Ꮫ. -- tio 20Nov26
        assertEquals "ᎠᏓᏛᏂᎭ", conjRefl("SG3", gvhnixa, "PRESENT")
        assertEquals "ᎦᏓᏛᏂᎭ", conjRefl("SG1", gvhnixa, "PRESENT")
        assertEquals "ᎠᎾᏓᏛᏂᎭ", conjRefl("PL3", gvhnixa, "PRESENT")
        assertEquals "ᎤᏓᏛᏂᎸᎢ", conjRefl("SG3", gvhnixa, "REMOTE_PAST")
        assertEquals "ᎠᏆᏓᏛᏂᎸᎢ", conjRefl("SG1", gvhnixa, "REMOTE_PAST")
        assertEquals "ᎤᎾᏓᏛᏂᎸᎢ", conjRefl("PL3", gvhnixa, "REMOTE_PAST")
    }

    void testReflexiveForgetParadigm() {
        // guide hold1 P5/P6 "to forget oneself" -- a class-B-always verb that
        // takes SET A prefixes in the present when reflexive (P5) and Set B in
        // the past (P6); the Ꮹ artifact fuses to Ꮫ. -- tio 20Nov26
        assertEquals "ᎦᏓᏛᎨᏫᏍᎦ", conjRefl("SG1", uwanegesga, "PRESENT")
        assertEquals "ᎠᏓᏛᎨᏫᏍᎦ", conjRefl("SG3", uwanegesga, "PRESENT")
        assertEquals "ᎠᎾᏓᏛᎨᏫᏍᎦ", conjRefl("PL3", uwanegesga, "PRESENT")
        assertEquals "ᎠᏆᏓᏛᎨᏫᏒᎢ", conjRefl("SG1", uwanegesga, "REMOTE_PAST")
        assertEquals "ᎤᏓᏛᎨᏫᏒᎢ", conjRefl("SG3", uwanegesga, "REMOTE_PAST")
        assertEquals "ᎤᎾᏓᏛᎨᏫᏒᎢ", conjRefl("PL3", uwanegesga, "REMOTE_PAST")
    }
}
