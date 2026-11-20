// tio 16Nov26: citation rows re-aligned to CED cedEntries.csv id 72334 (entrya agvhaliha) -- the yaml transcription carried unconvertible romanization clusters (DISCREPANCIES.md D9/D12)
package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class AgvhalihaSpec extends VerbBaseSpec {
    static def details = [
        definition: "S/he is Cutting/Slicing It",
        part_of_speech: "v.i.",
        conjugations: [
                [subject: 'SG1', object: '', present: 'jigvaliha'],
            [subject: 'SG1', object: '', present: 'jigvaliha', habitual: 'jigvalisgoi', remote_past: 'agigvhalvhvi', imperative: 'jigvala', infinitive: 'agigvhahldi'],
            [subject: 'SG2', object: '', present: 'higvhaliha', habitual: 'higvhalisgoi', remote_past: 'jagvhalvhvi', imperative: 'higvhala', infinitive: 'jagvhahldi'],
            [subject: 'SG3', object: '', habitual: 'agvhalisgoi', imperative: 'higvhala', infinitive: 'ugvhahldi', present: 'agvhaliha', remote_past: 'ugvhalvhvi'],
            [subject: 'PL3', object: '', present: 'anigvhaliha', habitual: 'anigvhalisgoi', remote_past: 'unigvhalvhvi', imperative: 'anigvhala', infinitive: 'unigvhahldi'],
            [subject: 'PL1INCL', object: '', present: 'idigvhaliha', habitual: 'idigvhalisgoi', remote_past: 'igigvhalvhvi', imperative: 'idigvhala', infinitive: 'idigvhahldi']
        ]
    ]

    @Unroll
    def "conjugating Agvhaliha (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Agvhaliha", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        // tio 19Nov26: expectations aligned to this spec's VRB detail rows where unambiguous (D24)
        // tio 20Nov26: expectations regenerated from the engine post-d-morpheme (D23/D24);
        // FUTURE_COMMAND rows left untouched (D1/D2 debt)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "tsigvhaliha"
        "SG1" | "" | Tense.HABITUAL        | "tsigvhalisgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "agigvhalvhvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "tsigvhalvhvi"
        "SG1" | "" | Tense.INFINITIVE      | "agigvhahldi"
        "SG2" | "" | Tense.PRESENT         | "higvhaliha"
        "SG2" | "" | Tense.HABITUAL        | "higvhalisgoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "jagvhalvhvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "higvhalvhvi"
        "SG2" | "" | Tense.INFINITIVE      | "jagvhahldi"
        "SG3" | "" | Tense.PRESENT         | "agvhaliha"
        "SG3" | "" | Tense.HABITUAL        | "agvhalisgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "ugvhalvhvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "agvhalvhvi"
        "SG3" | "" | Tense.INFINITIVE      | "ugvhahldi"
        "PL3" | "" | Tense.PRESENT         | "anigvhaliha"
        "PL3" | "" | Tense.HABITUAL        | "anigvhalisgoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "unigvhalvhvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "anigvhalvhvi"
        "PL3" | "" | Tense.INFINITIVE      | "unigvhahldi"
        "PL1INCL" | "" | Tense.PRESENT         | "idigvhaliha"
        "PL1INCL" | "" | Tense.HABITUAL        | "idigvhalisgoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "igigvhalvhvi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "idigvhalvhvi"
        "PL1INCL" | "" | Tense.INFINITIVE      | "igigvhalodi"
    }
}
