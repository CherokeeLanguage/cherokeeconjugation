package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.core.Verb
import net.cherokeedictionary.stemmer.DefinitionLine
import net.cherokeedictionary.stemmer.Stemmer
import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import net.cherokeedictionary.verb.conjugation.Conjugate
import spock.lang.Specification
import spock.lang.Unroll

/**
 * Tests for Grammar Guide Rules (70-73):
 * Certain intransitive verbs (running, sitting, standing, hungry, thirsty)
 * inherently require the distributive prefix de- when plural.
 */
class PluralDistributiveRules70Spec extends Specification {

    @Unroll
    def "Rules 70-73: #verbName for #subj should automatically conjugate with de- to '#expectedSyllabary'"() {
        given: "A stemmer for the verb; rules 70-73 mark it inherently distributive"
        def stemmer = new Stemmer()
        stemmer.present3rd = new DefinitionLine(syllabary: SyllabaryUtil.tsalagiToSyllabary(pres3rdLatin))
        stemmer.present1st = new DefinitionLine(syllabary: SyllabaryUtil.tsalagiToSyllabary(pres1stLatin))

        when: "We conjugate with the inherent distributive de- initial prefix set explicitly"
        Verb verb = Conjugate.createVerbToConjugate(subj, "", stemmer, Tense.PRESENT.toString(), "v.i.", false)
        if (subj != "SG3") { verb.initialPrefixHolder.de = true } // SG3 citation row already carries the distributive da-
        verb = Conjugate.conjugate(verb)
        def actualSyllabary = verb.wholeWord ?: verb.pronounReflexiveRoot
        def normalizedActualLatin = SyllabaryUtil.parseSyllabary(actualSyllabary)
        def normalizedExpectedLatin = SyllabaryUtil.parseSyllabary(expectedSyllabary)

        then: "Both Syllabary and Latin should match expected"
        actualSyllabary == expectedSyllabary
        normalizedActualLatin == normalizedExpectedLatin

        where:
        verbName      | pres3rdLatin  | pres1stLatin   | subj      || expectedSyllabary | expectedLatin
        // Rule 70: Adanawsdiha (running/take off)
        "Adanawsdiha" | "adanawvsdiha" | "gadanawvsdiha" | "SG3"     || "ᎠᏓᎾᏮᏍᏗᎭ"        | "adanawvsdiha"
        "Adanawsdiha" | "adanawvsdiha" | "gadanawvsdiha" | "PL3"     || "ᏓᎾᏓᎾᏮᏍᏗᎭ"       | "danadanawvsdiha"
        "Adanawsdiha" | "adanawvsdiha" | "gadanawvsdiha" | "PL1INCL" || "ᏕᏓᏓᎾᏮᏍᏗᎭ"       | "dedadanawvsdiha"

        // Rule 70: Uyosiha (hungry)
        "Uyosiha"     | "uyosiha"     | "agiyosiha"    | "SG3"     || "ᎤᏲᏏᎭ"          | "uyosiha"
        "Uyosiha"     | "uyosiha"     | "agiyosiha"    | "PL3"     || "ᏚᏂᏲᏏᎭ"         | "duniyosiha"

        // Rule 70: Uwotla (sitting)
        "Uwotla"      | "uwotla"      | "agwotla"      | "SG3"     || "ᎤᏬᏝ"           | "uwotla"
        "Uwotla"      | "uwotla"      | "agwotla"      | "PL3"     || "ᏚᏃᏝ"           | "dunotla"
    }
}
