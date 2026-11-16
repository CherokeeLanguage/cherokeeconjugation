// tio 16Nov26: citation rows re-aligned to CED cedEntries.csv id 72497 (entrya alehwisdiha) -- the yaml transcription carried unconvertible romanization clusters (DISCREPANCIES.md D9/D12)
package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class AlehwisdihaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Stopping (He/It Is)",
        part_of_speech: "v.i.",
        conjugations: [
                [subject: 'SG1', object: '', present: 'galewisdiha'],
            [subject: 'SG1', object: '', present: 'galewisdiha', habitual: 'galewisdisgoi', remote_past: 'agwalehwistanvi', imperative: 'galewisda', infinitive: 'agwalehwisdohdi'],
            [subject: 'SG2', object: '', present: 'halehwisdiha', habitual: 'halehwisdisgoi', remote_past: 'jalehwistanvi', imperative: 'halehwisda', infinitive: 'jalehwisdohdi'],
            [subject: 'SG3', object: '', habitual: 'alehwisdisgoi', imperative: 'halehwisda', infinitive: 'ulehwisdohdi', present: 'alehwisdiha', remote_past: 'ulehwistanvi'],
            [subject: 'PL3', object: '', present: 'analehwisdiha', habitual: 'analehwisdisgoi', remote_past: 'unalehwistanvi', imperative: 'analehwisda', infinitive: 'unalehwisdohdi'],
            [subject: 'PL1INCL', object: '', present: 'idalehwisdiha', habitual: 'idalehwisdisgoi', remote_past: 'igalehwistanvi', imperative: 'idalehwisda', infinitive: 'igalehwisdohdi']
        ]
    ]

    @Unroll
    def "conjugating Alehwisdiha (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Alehwisdiha", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "galewisdiha"
        "SG1" | "" | Tense.HABITUAL        | "galewisdisgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "aqualewistanvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "galewistanvi"
        "SG1" | "" | Tense.INFINITIVE      | "aqualewisdodi"
        "SG2" | "" | Tense.PRESENT         | "halewisdiha"
        "SG2" | "" | Tense.HABITUAL        | "halewisdisgoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "tsalewistanvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "halewistanvi"
        "SG2" | "" | Tense.INFINITIVE      | "tsalewisdodi"
        "SG3" | "" | Tense.PRESENT         | "alewisdiha"
        "SG3" | "" | Tense.HABITUAL        | "alewisdisgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "ulewistanvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "alewistanvi"
        "SG3" | "" | Tense.INFINITIVE      | "ulewisdodi"
        "PL3" | "" | Tense.PRESENT         | "analewisdiha"
        "PL3" | "" | Tense.HABITUAL        | "analewisdisgoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "unalewistanvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "analewistanvi"
        "PL3" | "" | Tense.INFINITIVE      | "unalewisdodi"
        "PL1INCL" | "" | Tense.PRESENT         | "idalewisdiha"
        "PL1INCL" | "" | Tense.HABITUAL        | "idalewisdisgoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "igalewistanvi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "idalewistanvi"
        "PL1INCL" | "" | Tense.INFINITIVE      | "igalewisdodi"
    }
}
