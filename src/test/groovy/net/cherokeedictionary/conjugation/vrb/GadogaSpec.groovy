// tio 16Nov26: citations re-written to canonical parse-back romanization of the CED syllabary (cedEntries.csv id 72993) -- the yaml orthography (gwv=Ꮙ, bare w, l+C) is unmappable by the plain transliterator (DISCREPANCIES.md D9/D12)
// tio 16Nov26: citation rows re-aligned to CED cedEntries.csv id 72993 (entrya gadoga) -- the yaml transcription carried unconvertible romanization clusters (DISCREPANCIES.md D9/D12)
package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class GadogaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Standing",
        part_of_speech: "v.i.",
        conjugations: [
                [subject: 'SG1', object: '', present: 'tsidoga'],
            [subject: 'SG3', object: '', habitual: 'gadogoi', imperative: 'hidogesdi', infinitive: '', present: 'gadoga', remote_past: ''],
            [subject: 'PL3', object: '', present: 'danidoga', habitual: '/', remote_past: 'anidonaa', imperative: 'danidogoi', infinitive: '/'],
            [subject: 'PL1INCL', object: '', present: 'dedidoga', habitual: '/', remote_past: 'ididonaa', imperative: 'dedidogoi', infinitive: '/']
        ]
    ]

    @Unroll
    def "conjugating Gadoga (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Gadoga", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "tsidoga"
        "SG1" | "" | Tense.HABITUAL        | "tsidogoi"
        // tio 17Nov26: REMOTE_PAST UNATTESTED -- the 2012 book (Standing, Gadoga) prints x in the
        // remote column for every subject row; the yaml 'x' junk values (and PL3/PL1INCL rows
        // carrying the alternate 3+-standing present forms anidona'a/ididona'a) are dropped.
        // "SG1" | "" | Tense.REMOTE_PAST     | "x"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "tsido"
        // "SG1" | "" | Tense.INFINITIVE      | "X"
        "PL3" | "" | Tense.PRESENT         | "anidoga"
        // "PL3" | "" | Tense.HABITUAL        | "/"
        // "PL3" | "" | Tense.REMOTE_PAST     | "anidonaa"  // unattested (book prints x; anidona'a is the 3+-standing PRESENT alternate)
        "PL3" | "" | Tense.FUTURE_COMMAND      | "anido"
        // "PL3" | "" | Tense.INFINITIVE      | "/"
        "PL1INCL" | "" | Tense.PRESENT         | "ididoga"
        // "PL1INCL" | "" | Tense.HABITUAL        | "/"
        // "PL1INCL" | "" | Tense.REMOTE_PAST     | "ididonaa"  // unattested (book prints x; ididona'a is the 3+-standing PRESENT alternate)
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "idido"
        // "PL1INCL" | "" | Tense.INFINITIVE      | "/"
    }
}
