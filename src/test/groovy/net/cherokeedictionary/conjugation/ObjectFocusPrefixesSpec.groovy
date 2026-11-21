package net.cherokeedictionary.conjugation

import net.cherokeedictionary.conjugation.ConjugationRequest
import net.cherokeedictionary.conjugation.VerbConjugationFacade

import spock.lang.Specification

/**
 * A2: object-focus (unspecified-actor passive) prefixes -- guide hold1
 * I-E pp. 300-301, Paradigms Five ("to be seen") and Six ("to be hit"),
 * the same paradigm M-A §9.4 Table 9.3 calls Object Focus Pronominal
 * Prefixes. The focus prefix REPLACES the pronominal compound and is
 * keyed on the OBJECT person (the undergoer); the agent is unspecified.
 *
 * Known v1 approximations (DISCREPANCIES.md D26): the M-A h-alternation
 * for several prefixes is not modeled, and the P5 DL1INCL/PL1INCL rows
 * print the aspirated spellings (ᎡᎩᏂᏆᏩᏘᎭ / ᎡᎩᏆᏩᏘᎭ-class) where the
 * engine composes the plain Ꭺ- forms -- the guide's own romanization
 * (egini-gowhtiha) matches the composed shapes. -- tio 21Nov26
 */
class ObjectFocusPrefixesSpec extends Specification {
    private static String conj(Map stems, String object) {
        def facade = new VerbConjugationFacade(isDebug: false)
        return facade.conjugate(new ConjugationRequest([
            object: object, verbTense: "PRESENT", partOfSpeech: "VT",
            objectFocus: "true"] + stems)).wholeWord
    }

    private static final Map SEE = [
        present1st: "ᏥᎪᏩᏘᎭ", present3rd: "ᎠᎪᏩᏘᎭ", remotepast: "ᎤᎪᎲᎢ",
        habitual: "ᎠᎪᏩᏘᏍᎪᎢ", imperative: "ᎠᎪᏩᏙ", infinitive: "ᎤᎪᏩᏘᏍᏗ"]
    private static final Map HIT = [
        present1st: "ᏥᏴᏂᎭ", present3rd: "ᎬᏂᎭ", remotepast: "ᎤᏩᏂᎸᎢ",
        habitual: "ᎬᏂᎰᎢ", imperative: "ᎯᏴᏂᎦ", infinitive: "ᎤᏩᏂᏍᏗ"]

    def "guide Paradigm Five 'to be seen' (consonant stem, preConsonant forms)"() {
        expect:
        conj(SEE, object) == expected

        where:
        object    || expected
        "SG1"     || "ᎥᎩᎪᏩᏘᎭ"   // vgi-gowhtiha "I am being seen"
        "SG2"     || "ᎡᏣᎪᏩᏘᎭ"   // eja-
        "SG3AN"   || "ᎠᏥᎪᏩᏘᎭ"   // aji- ("He's being seen")
        "DL1INCL" || "ᎡᎩᏂᎪᏩᏘᎭ"  // egini- (book prints aspirated Ꮖ-)
        "PL1INCL" || "ᎡᎩᎪᏩᏘᎭ"   // egi-
        "DL2"     || "ᎡᏍᏗᎪᏩᏘᎭ"  // esdi-
        "PL2"     || "ᎡᏥᎪᏩᏘᎭ"   // eji-
    }

    def "guide Paradigm Six 'to be hit' (v-stem, fused preVowel forms)"() {
        expect:
        conj(HIT, object) == expected

        where:
        object    || expected
        "SG1"     || "ᎥᏋᏂᎭ"   // vgw-vhniha
        "SG2"     || "ᎡᏨᏂᎭ"   // ejv-
        "SG3AN"   || "ᎠᎬᏂᎭ"   // agv-
        "DL1INCL" || "ᎡᎩᏅᏂᎭ"  // eginv-
        "PL1INCL" || "ᎡᎬᏂᎭ"   // egv-
        "DL2"     || "ᎡᏍᏛᏂᎭ"  // esdv-
        "PL2"     || "ᎡᏨᏂᎭ"   // ejv-
    }

    def "unattested focus cells surface MISSING_ENTRY, never silent garbage"() {
        expect:
        conj(HIT, "SG3IN").startsWith("MISSING_ENTRY")
    }
}
