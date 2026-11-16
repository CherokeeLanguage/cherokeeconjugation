// tio 16Nov26: citation rows re-aligned to CED cedEntries.csv id 73748 (entrya udlanvdadeha) -- the yaml transcription carried unconvertible romanization clusters (DISCREPANCIES.md D9/D12)
package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class UdlanvdadehaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Has Time (161)",
        part_of_speech: "v.i.",
        conjugations: [
                [subject: 'SG1', object: '', present: 'agwadlanvdadeha'],
            [subject: 'SG1', object: '', present: 'agwadlanvdadeha', habitual: 'agwadlanvdadehoi', remote_past: 'agwadlanvdadelvi', imperative: 'agwadlanvdadisi', infinitive: 'agwadlanvdadehdi'],
            [subject: 'SG2', object: '', present: 'jadlanvdadeha', habitual: 'jadlanvdadehoi', remote_past: 'jadlanvdadelvi', imperative: 'jadlanvdadisi', infinitive: 'jadlanvdadehdi'],
            [subject: 'SG3', object: '', habitual: 'udlanvdadehoi', imperative: 'jadlanvdadisi', infinitive: 'udlanvdadehdi', present: 'udlanvdadeha', remote_past: 'udlanvdadelvi'],
            [subject: 'PL3', object: '', present: 'unadlanvdadeha', habitual: 'unadlanvdadehoi', remote_past: 'unadlanvdadelvi', imperative: 'unadlanvdadisi', infinitive: 'unadlanvdadehdi'],
            [subject: 'PL1INCL', object: '', present: 'igadlanvdadeha', habitual: 'igadlanvdadehoi', remote_past: 'igadlanvdadelvi', imperative: 'igadlanvdadisi', infinitive: 'igadlanvdadehdi']
        ]
    ]

    @Unroll
    def "conjugating Udlanvdadeha (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Udlanvdadeha", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "aquadlanvdadeha"
        "SG1" | "" | Tense.HABITUAL        | "aquadlanvdadehoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "aquadlanvdadelvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "aquadlanvdadelvi"
        "SG1" | "" | Tense.INFINITIVE      | "aquadlanvdadedi"
        "SG2" | "" | Tense.PRESENT         | "tsadlanvdadeha"
        "SG2" | "" | Tense.HABITUAL        | "tsadlanvdadehoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "tsadlanvdadelvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "tsadlanvdadelvi"
        "SG2" | "" | Tense.INFINITIVE      | "tsadlanvdadedi"
        "SG3" | "" | Tense.PRESENT         | "udlanvdadeha"
        "SG3" | "" | Tense.HABITUAL        | "udlanvdadehoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "udlanvdadelvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "udlanvdadelvi"
        "SG3" | "" | Tense.INFINITIVE      | "udlanvdadedi"
        "PL3" | "" | Tense.PRESENT         | "unadlanvdadeha"
        "PL3" | "" | Tense.HABITUAL        | "unadlanvdadehoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "unadlanvdadelvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "unadlanvdadelvi"
        "PL3" | "" | Tense.INFINITIVE      | "unadlanvdadedi"
        "PL1INCL" | "" | Tense.PRESENT         | "igadlanvdadeha"
        "PL1INCL" | "" | Tense.HABITUAL        | "igadlanvdadehoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "igadlanvdadelvi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "igadlanvdadelvi"
        "PL1INCL" | "" | Tense.INFINITIVE      | "igadlanvdadedi"
    }
}
