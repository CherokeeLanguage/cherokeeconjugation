package net.cherokeedictionary.conjugation

import net.cherokeedictionary.stemmer.DefinitionLine
import net.cherokeedictionary.stemmer.Stemmer
import net.cherokeedictionary.verb.conjugation.Conjugate

import spock.lang.Specification

/**
 * D29: the da-family SG2 imperative -- the dictionary's imperative citation
 * IS the printed addressee row, and for da-initial verbs it already carries
 * the book's contracted d+h -> ta form (guide rule 61, p. 247-248: "the
 * prefix vowel drops and the combination of d- plus -h- yields t-"; the t
 * keeps the h-syllable's vowel: ta Ꮤ for h+a stems, ti Ꮨ for h+i stems --
 * married ᏘᎦᏨᏍᏗᎭ present vs Barking ᏔᏑᏫ, Kneeling ᏔᎵᏂᏆᏅᎥᎦ, Defecating
 * ᏔᏗᎦ imperatives). Composing da + hi + stem through the prefix machinery
 * loses the contraction (the routed h-glyph Ꭽ conflates hi+ga vs hi+a-stem,
 * DISCREPANCIES D29), so the citation is echoed for the SG2 command row when
 * the verb is da-family and the citation begins with a t-glyph (29
 * intransitive citations surveyed). Non-SG2 rows compose da + stem
 * unchanged (SG3 ᏓᏑᏫ). -- tio 21Nov26
 */
class D29PrefixesSpec extends Specification {
    private static Stemmer stemmer(String p3, String p1, String imp) {
        def st = new Stemmer()
        st.present3rd = new DefinitionLine(syllabary: p3)
        st.present1st = new DefinitionLine(syllabary: p1)
        st.imperative = new DefinitionLine(syllabary: imp)
        return st
    }

    private static String conj(String subject, Stemmer st, String tense) {
        return Conjugate.conjugate(subject, "SG3IN", st, tense, "vi", false).wholeWord
    }

    def "SG2 imperative echoes the contracted da-family citation"() {
        expect:
        conj("SG2", stemmer(p3, p1, imp), "IMMEDIATE_COMMAND") == expected

        where:
        p3         | p1         | imp          || expected
        "ᏓᏑᏫᏍᎦ"    | "ᏕᎦᏑᏫᏍᎦ"   | "ᏔᏑᏫ"        || "ᏔᏑᏫ"          // Barking
        "ᏓᎵᏂᏆᏅᎥᏍᎦ" | "ᏕᎦᎵᏂᏆᏅᎥᏍᎦ" | "ᏔᎵᏂᏆᏅᎥᎦ"    || "ᏔᎵᏂᏆᏅᎥᎦ"      // Kneeling
        "ᏓᏗᎦᎭ"     | "ᏕᎦᏗᎦᎭ"    | "ᏔᏗᎦ"        || "ᏔᏗᎦ"          // Defecating
    }

    def "present-tense SG2 of da-verbs composes the ti- form, no echo"() {
        expect:  // married: d+hi+ga -> ti-ga (guide 61 consonant case)
        conj("SG2", stemmer("ᏓᎦᏨᏍᏗᎭ", "ᏛᏆᏨᏍᏗᎭ", "ᏔᎦᏨᏍᏗ"), "PRESENT") == "ᏘᎦᏨᏍᏗᎭ"
    }

    def "non-SG2 imperative rows compose da + stem unchanged"() {
        expect:
        conj("SG3", stemmer("ᏓᏑᏫᏍᎦ", "ᏕᎦᏑᏫᏍᎦ", "ᏔᏑᏫ"), "IMMEDIATE_COMMAND") == "ᏓᏑᏫ"
    }

    def "non-da verbs keep the composed imperative"() {
        expect:  // see: SG2 = hi + stem, no da-layer to contract
        conj("SG2", stemmer("ᎠᎪᏩᏘᎭ", "ᏥᎪᏩᏘᎭ", "ᎯᎪᏩᏔ"), "IMMEDIATE_COMMAND") == "ᎯᎪᏩᏔ"
    }
}
