package net.cherokeedictionary.conjugation

import net.cherokeedictionary.stemmer.DefinitionLine
import net.cherokeedictionary.stemmer.Stemmer
import net.cherokeedictionary.verb.conjugation.Conjugate

import spock.lang.Specification

/**
 * A2b: the combined LOCAL 2<->1 person pairs (M-A section 9.3 Table 9.2;
 * guide hold1 Paradigm One rows (1)/(7)/(9)/(14)/(20)/(22)/(68)/(73)/(79)/
 * (92)/(103) and the Paradigm Three see-verb rows (1)/(8)/(11)/(12)).
 * Several of these cells were declared-empty twins in CompoundPrefixes and
 * surfaced blank; they are now filled citation-exact from the guide, and
 * the Set B tenses reach them through the D20 empty-twin Set A fallback
 * (guide section I-B: Set B = Set A except the Figure 4 columns).
 * -- tio 21Nov26
 */
class LocalPairPrefixesSpec extends Specification {
    private static Stemmer see() {
        def st = new Stemmer()
        st.present3rd = new DefinitionLine(syllabary: "ᎠᎪᏩᏘᎭ")
        st.present1st = new DefinitionLine(syllabary: "ᏥᎪᏩᏘᎭ")
        st.remotepast = new DefinitionLine(syllabary: "ᎤᎪᎲᎢ")
        st.habitual = new DefinitionLine(syllabary: "ᎠᎪᏩᏘᏍᎪᎢ")
        st.imperative = new DefinitionLine(syllabary: "ᎠᎪᏩᏙ")
        st.infinitive = new DefinitionLine(syllabary: "ᎤᎪᏩᏘᏍᏗ")
        return st
    }

    private static String conj(String subject, String object, String tense = "PRESENT") {
        return Conjugate.conjugate(subject, object, see(), tense, "vt", false).wholeWord
    }

    def "1st-person subject -> 2nd-person object (y-insertion before vowel stems)"() {
        expect:
        conj(subject, object) == expected

        where:
        subject   | object || expected
        "SG1"     | "SG2"  || "ᎬᎪᏩᏘᎭ"    // guide P3(1) gv-gowtiha "I see you" (consonant stem: NO y)
        "SG1"     | "DL2"  || "ᏍᏛᎪᏩᏘᎭ"   // guide P3(4) sdv-
        "SG1"     | "PL2"  || "ᎢᏨᎪᏩᏘᎭ"   // guide P3(5) ijv-
        // 1st-dual/plural actors keep the same local forms (guide P1(68)/(73)/(79))
        "DL1INCL" | "SG2"  || "ᏍᏛᎪᏩᏘᎭ"   // M-A 9.2 dual sdvv
        "DL1INCL" | "DL2"  || "ᏍᏛᎪᏩᏘᎭ"
        "DL1INCL" | "PL2"  || "ᎢᏨᎪᏩᏘᎭ"   // guide P1(68) "he and I are tying you (pl) up"
        "PL1INCL" | "SG2"  || "ᎢᏨᎪᏩᏘᎭ"   // guide P1(73) "they and I are tying you up"
        "PL1INCL" | "PL2"  || "ᎢᏨᎪᏩᏘᎭ"   // guide P1(79)
        "PL1EXCL" | "PL2"  || "ᎢᏨᎪᏩᏘᎭ"   // guide P1(79) same ijv- row
    }

    def "2nd-person subject -> 1st-person object (sgw-/sgin-/isgi-)"() {
        expect:
        conj(subject, object) == expected

        where:
        subject   | object    || expected
        // guide P3(8) prints ᏍᎩᎪᏩᏘᎭ sgigowtiha, but the p.118 book box prints
        // ᏍᎪᏩᏘᎭ sgowtiha (the 12Nov26 ruling pinned bare Ꮝ) -- the SG2SG1
        // consonant allomorph is per-source variance, engine keeps the pin.
        "SG2"     | "SG1"     || "ᏍᎪᏩᏘᎭ"    // book p.118 sgowtiha
        "SG2"     | "DL1INCL" || "ᏍᎩᏂᎪᏩᏘᎭ"  // guide P3(11) sgin- "you see me and him"
        "SG2"     | "DL1EXCL" || "ᏍᎩᏂᎪᏩᏘᎭ"  // P1(20) same sgin- row
        "SG2"     | "PL1INCL" || "ᎢᏍᎩᎪᏩᏘᎭ"  // guide P3(12) isgi- "you see me and them"
        "SG2"     | "PL1EXCL" || "ᎢᏍᎩᎪᏩᏘᎭ"  // P1(22) same isgi- row
        // 2nd-dual/plural actors: guide P3(46)/(49)/(53)/(56), P1(92)/(103)
        "DL2"     | "SG1"     || "ᏍᎩᏂᎪᏩᏘᎭ"  // guide P3(46) "you (dl) see me" sgin-
        "DL2"     | "DL1INCL" || "ᏍᎩᏂᎪᏩᏘᎭ"  // guide P3(49)
        "DL2"     | "PL1INCL" || "ᎢᏍᎩᎪᏩᏘᎭ"  // guide P1(92) isgi-
        "PL2"     | "SG1"     || "ᎢᏍᎩᎪᏩᏘᎭ"  // guide P3(53) "you (pl) see me" isgi-
        "PL2"     | "DL1INCL" || "ᎢᏍᎩᎪᏩᏘᎭ"  // guide P1(103)
        "PL2"     | "PL1INCL" || "ᎢᏍᎩᎪᏩᏘᎭ"  // guide P3(56)
        "PL2"     | "PL1EXCL" || "ᎢᏍᎩᎪᏩᏘᎭ"  // guide P3(56) same isgi- row
    }

    def "local pairs in a Set B tense reach the forms through the D20 fallback"() {
        expect:  // guide P4-family: "I saw you" gv- in the remote past
        conj("SG1", "SG2", "REMOTE_PAST") == "ᎬᎪᎲᎢ"
        conj("SG2", "DL1INCL", "REMOTE_PAST") == "ᏍᎩᏂᎪᎲᎢ"
    }
}
