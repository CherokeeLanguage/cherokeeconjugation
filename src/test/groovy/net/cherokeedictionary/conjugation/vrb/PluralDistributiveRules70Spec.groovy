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
        given: "A stemmer marked as plural distributive"
        def stemmer = new Stemmer()
        stemmer.present3rd = new DefinitionLine(syllabary: SyllabaryUtil.tsalagiToSyllabary(pres3rdLatin))
        stemmer.present1st = new DefinitionLine(syllabary: SyllabaryUtil.tsalagiToSyllabary(pres1stLatin))
        stemmer.isPluralDistributive = true

        when: "We conjugate the verb"
        Verb verb = Conjugate.conjugate(subj, "", stemmer, Tense.PRESENT.toString(), "v.i.", false)
        def actualSyllabary = verb.wholeWord ?: verb.pronounReflexiveRoot
        def normalizedActualLatin = SyllabaryUtil.parseSyllabary(actualSyllabary)
        def normalizedExpectedLatin = SyllabaryUtil.parseSyllabary(expectedSyllabary)

        then: "Both Syllabary and Latin should match expected"
        actualSyllabary == expectedSyllabary
        normalizedActualLatin == normalizedExpectedLatin

        where:
        verbName      | pres3rdLatin  | pres1stLatin   | subj      || expectedSyllabary | expectedLatin
        // Rule 70: Adanawsdiha (running/take off)
        "Adanawsdiha" | "adanawsdiha" | "gadanawsdiha" | "SG3"     || "ᎠᏓᎾᏮᏍᏗᎭ"        | "adanawvsdiha"
        "Adanawsdiha" | "adanawsdiha" | "gadanawsdiha" | "PL3"     || "ᏓᎾᏓᎾᏮᏍᏗᎭ"       | "danadanawvsdiha"
        "Adanawsdiha" | "adanawsdiha" | "gadanawsdiha" | "PL1INCL" || "ᏕᏓᏓᎾᏮᏍᏗᎭ"       | "dedadanawvsdiha"

        // Rule 70: Uyosiha (hungry)
        "Uyosiha"     | "uyosiha"     | "agiyosiha"    | "SG3"     || "ᎤᏲᏏᎭ"          | "uyosiha"
        "Uyosiha"     | "uyosiha"     | "agiyosiha"    | "PL3"     || "ᏚᏂᏲᏏᎭ"         | "duniyosiha"

        // Rule 70: Uwotla (sitting)
        "Uwotla"      | "uwotla"      | "agwotla"      | "SG3"     || "ᎤᏬᏝ"           | "uwotla"
        "Uwotla"      | "uwotla"      | "agwotla"      | "PL3"     || "ᏚᏃᏝ"           | "dunotla"
    }
}
