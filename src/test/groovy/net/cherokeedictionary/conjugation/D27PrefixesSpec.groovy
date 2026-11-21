package net.cherokeedictionary.conjugation

import net.cherokeedictionary.stemmer.DefinitionLine
import net.cherokeedictionary.stemmer.Stemmer
import net.cherokeedictionary.verb.conjugation.Conjugate

import spock.lang.Specification

/**
 * D27: the prefix-boundary fusion class (guide P4(21)-(23), P8(5)/(6)).
 *
 * (1) n + the stem's sg3 w/v artifact fuses to nv (Ꮕ) with the prefix's
 *     i elided -- PL3 an-/uni-/dan- + wa-stem (N map; corpus ᎤᏅᎨᏫᏒᎯ MAK
 *     8:14, ᎤᏅᏂᏍᏗᏱ LUK 20:10, ᏓᏅᎩᎶᏍᎨ LUK 5:2).
 * (2) the PRESENT-SCOPED ANIMATE-OBJECT rule -- PL3 subject + SG3AN/PL3AN
 *     object takes the Set A animate column in the present for EVERY verb
 *     (13-verb book survey), while PL3->IT keeps uni- for class-B verbs;
 *     non-present Set B keeps uni- (the 20Nov26 ruling).
 * (3) the uw-/duw- A-EPENTHESIS (lexeme-gated, hit registered): uw + hni ->
 *     uwa (ᎤᏩᏂᎸᎢ), duw -> duwa (ᏚᏩᏂᎸᎢ); real v-initial stems cluster wv
 *     (Kdega ᎤᏮᏕᏨᎢ, Uwanvga ᎤᏮᏆᏅᏍᏗ). The duw+a -> du contraction is
 *     TENSE-SCOPED: present contracts (ᏚᎨᏳᎭ dugeyuha), non-present keeps
 *     duwa- (P8(6), corpus ᏚᏩᏂᎦᎸ x7+).
 * -- tio 21Nov26
 */
class D27PrefixesSpec extends Specification {
    private static Stemmer hit() {
        def st = new Stemmer()
        st.present3rd = new DefinitionLine(syllabary: "ᎬᏂᎭ")
        st.present1st = new DefinitionLine(syllabary: "ᏥᏴᏂᎭ")
        st.remotepast = new DefinitionLine(syllabary: "ᎤᏩᏂᎸᎢ")
        st.imperative = new DefinitionLine(syllabary: "ᎯᏴᏂᎦ")
        st.infinitive = new DefinitionLine(syllabary: "ᎤᏩᏂᏍᏗ")
        st.habitual = new DefinitionLine(syllabary: "ᎬᏂᎰᎢ")
        return st
    }
    private static Stemmer forget() {
        def st = new Stemmer()
        st.present3rd = new DefinitionLine(syllabary: "ᎤᏩᎨᏫᏍᎦ")
        st.present1st = new DefinitionLine(syllabary: "ᎠᏆᎨᏫᏍᎦ")
        st.remotepast = new DefinitionLine(syllabary: "ᎤᏩᎨᏫᏒᎢ")
        st.imperative = new DefinitionLine(syllabary: "ᏫᎤᏩᎨᏩ")
        st.infinitive = new DefinitionLine(syllabary: "ᎤᏩᎨᏫᏍᏗ")
        st.habitual = new DefinitionLine(syllabary: "ᎤᏩᎨᏫᏍᎪᎢ")
        return st
    }
    private static Stemmer love() {
        def st = new Stemmer()
        st.present3rd = new DefinitionLine(syllabary: "ᎤᎨᏳᎭ")
        st.present1st = new DefinitionLine(syllabary: "ᎠᎩᎨᏳᎭ")
        st.remotepast = new DefinitionLine(syllabary: "ᎤᎨᏳᏒᎢ")
        st.habitual = new DefinitionLine(syllabary: "ᎤᎨᏳᏍᎪᎢ")
        st.imperative = new DefinitionLine(syllabary: "ᎯᎨᏳᏓ")
        st.infinitive = new DefinitionLine(syllabary: "ᎤᎨᏳᏍᏗ")
        return st
    }

    private static String conj(String subject, String object, String tense, Stemmer stemmer) {
        return Conjugate.conjugate(subject, object, stemmer, tense, "vt", false).wholeWord
    }

    private static Stemmer stemmerByName(String name) {
        return "hit".equals(name) ? hit() : "forget".equals(name) ? forget() : love()
    }

    def "n + w-artifact fuses to nv (Ꮕ) with i-elision"() {
        expect:
        conj(subject, object, tense, stemmerByName(verb)) == expected

        where:
        subject | object  | tense       | verb    || expected
        "PL3"   | "SG3AN" | "PRESENT"   | "hit"   || "ᎠᏅᏂᎭ"       // book anvhniha
        "PL3"   | "SG3AN" | "PRESENT"   | "forget"|| "ᎠᏅᎨᏫᏍᎦ"     // guide P4(21) an+v
        "PL3"   | "SG3IN" | "PRESENT"   | "forget"|| "ᎤᏅᎨᏫᏍᎦ"     // guide P4(22) un+v
        "PL3"   | "PL3AN" | "PRESENT"   | "forget"|| "ᏓᏅᎨᏫᏍᎦ"     // guide P4(23) dan+v
    }

    def "present-scoped animate-object rule: PL3->him Set A, PL3->it class-B uni-"() {
        expect:
        conj(subject, object, tense, stemmerByName(verb)) == expected

        where:
        subject | object  | tense     | verb   || expected
        "PL3"   | "SG3IN" | "PRESENT" | "love" || "ᎤᏂᎨᏳᎭ"       // book unigeyuha (uni-, i kept)
        "PL3"   | "SG3AN" | "PRESENT" | "love" || "ᎠᏂᎨᏳᎭ"       // survey default ani-
        "SG3"   | "SG3AN" | "PRESENT" | "love" || "ᎤᎨᏳᎭ"       // To Love box: u- covers him AND it (Set B kept)
    }

    def "uw-/duw- a-epenthesis (hit) vs wv cluster (Kdega-family shape)"() {
        expect:
        conj(subject, object, tense, stemmerByName(verb)) == expected

        where:
        subject | object  | tense        | verb  || expected
        "SG3"   | "SG3AN" | "REMOTE_PAST"| "hit" || "ᎤᏩᏂᎸᎢ"      // P8(5) uw- covers him AND it
        "SG3"   | "PL3AN" | "REMOTE_PAST"| "hit" || "ᏚᏩᏂᎸᎢ"      // P8(6) duwa- (non-present keeps wa)
    }

    def "gw cluster keeps gwv (no strip, no epenthesis on the gw tail)"() {
        expect:  // guide P8(1) ᎠᏋᏂᎸᎢ agwvhnilvi -- gw + v-stem = the Ꮛ cluster
        conj("SG1", "SG3IN", "REMOTE_PAST", hit()) == "ᎠᏋᏂᎸᎢ"
    }
}
