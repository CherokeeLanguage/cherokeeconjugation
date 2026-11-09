package net.cherokeedictionary.conjugation

import net.cherokeedictionary.stemmer.DefinitionLine
import net.cherokeedictionary.stemmer.Stemmer
import net.cherokeedictionary.transliteration.SyllabaryUtil;
import org.junit.Test

class CherokeeVerbConjugationTest {

    /**
     * Helper method stub representing the conjugation engine under test.
     */
    static String conj(String subject, String object, Stemmer stemmer, String verbTense, String partofspeech) {
        return  SyllabaryUtil.parseSyllabaryNormalized(ConjugateBase.conjStr(subject, object, stemmer, verbTense, partofspeech))
    }
/*
    @Test
    void testVerbConjugations() {

        // ==========================================
        // 1. TO BEND SOMETHING (Transitive / vt)
        // Index #1 (Page 41)
        // ==========================================
        Stemmer bendSomething = new Stemmer(
                rootValue: "hyvhgwidvv",
                habitual: new DefinitionLine(syllabary: "ᎠᎪᏩᏘᏍᎪᎢ"), // or corresponding syllabary from p. 41
                imperative: new DefinitionLine(syllabary: "ᎾᎯᎪᏩᏔ"),
                infinitive: new DefinitionLine(syllabary: "ᎤᎪᏩᏛᏗ"),
                present1st: new DefinitionLine(syllabary: "Ꮵ?yvhgwidvvsq-a"),
                present3rd: new DefinitionLine(syllabary: "ᎠᏂ-hyvhgwidvysg-a"),
                remotepast: new DefinitionLine(syllabary: "ᎤᎪᎲᎢ")
        )

        assert "a-hyvhgwidvvsq-a" == conj("SG3", "SG3IN", bendSomething, "PRESENT", "vt")
        assert "ji-?yvhgwidvvsq-a" == conj("SG1", "SG3IN", bendSomething, "PRESENT", "vt")

    }

    @Test
    void testVerbConjugations2() {
        // ==========================================
        // 2. TAKE A BITE (Transitive / vt)
        // Index #2 (Page 42) - Deaspirating vowel stem
        // ==========================================
        Stemmer takeABite = new Stemmer(
            rootValue: "atsde",
            habitual: new DefinitionLine(syllabary: "ᎠᏥᏍᏕᎠ"),
            imperative: new DefinitionLine(syllabary: "ᎯᎪᏩᏔ"),
            infinitive: new DefinitionLine(syllabary: "ᎤᏥᏍᏕᏗ"),
            present1st: new DefinitionLine(syllabary: "ᏥᏍᏕᎠ"),
            present3rd: new DefinitionLine(syllabary: "ᎠᏥᏍᏕᎠ"),
            remotepast: new DefinitionLine(syllabary: "ᎤᏥᏍᏕᎢ")
        )

        assert "atsde-a" == conj("SG3", "SG3IN", takeABite, "PRESENT", "vt")
        assert "g-ajisde-a" == conj("SG1", "SG3IN", takeABite, "PRESENT", "vt")
    }

    @Test
    void testVerbConjugations3() {

        // ==========================================
        // 3. TO BRING SOMETHING (LIVING) (Transitive / vt)
        // Index #3 (Page 43)
        // ==========================================
        Stemmer bringLiving = new Stemmer(
            rootValue: "atihnohih",
            habitual: new DefinitionLine(syllabary: "ᎠᏗᏂᏃᎯᎯᎭ"),
            imperative: new DefinitionLine(syllabary: "ᏩᏗᏂᏃᎯ"),
            infinitive: new DefinitionLine(syllabary: "ᎤᏗᏂᏃᎯᏍᏗ"),
            present1st: new DefinitionLine(syllabary: "ᏥᏯᏗᏂᏃᎯᎭ"),
            present3rd: new DefinitionLine(syllabary: "ᎠᏗᏂᏃᎯᎭ"),
            remotepast: new DefinitionLine(syllabary: "ᎤᏗᏂᏃᎯᎲᎢ")
        )

        assert "atinohiha" == conj("SG3", "SG3AN", bringLiving, "PRESENT", "vt")
        assert "jiyatinohiha" == conj("SG1", "SG3AN", bringLiving, "PRESENT", "vt")

    }*/
}