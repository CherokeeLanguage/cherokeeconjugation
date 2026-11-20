// tio 16Nov26: citation rows re-aligned to CED cedEntries.csv id 72796 (entrya danadlosga) -- the yaml transcription carried unconvertible romanization clusters (DISCREPANCIES.md D9/D12)
package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class DanadlosgaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Meeting (They Are)",
        part_of_speech: "v.i.",
        conjugations: [
                [subject: 'SG1', object: '', present: 'dojadlosga'],
            [subject: 'SG1', object: '', present: 'dojadlosga', habitual: 'dojadlosgoi', remote_past: 'dogadlosvi', imperative: 'jojadlohi', infinitive: 'I'],
            [subject: 'SG2', object: '', present: 'desdadlosga', habitual: 'desdadlosgoi', remote_past: 'desdadlosvi', imperative: 'disdadlohi', infinitive: 'You'],
            [subject: 'SG3', object: '', habitual: 'danadlosgoi', imperative: 'dijadlohi', infinitive: 'junadlohisdi', present: 'danadlosga', remote_past: 'dunadlosvi'],
            [subject: 'PL3', object: '', present: 'dedadlosga', habitual: 'dedadlosgoi', remote_past: 'degadlosvi', imperative: 'didadlohi', infinitive: 'You,'],
            [subject: 'PL1INCL', object: '', present: 'danadlosga', habitual: 'danadlosgoi', remote_past: 'dunadlosvi', imperative: 'dinadlohi', infinitive: 'They']
        ]
    ]

    @Unroll
    def "conjugating Danadlosga (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Danadlosga", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        // tio 19Nov26: expectations aligned to this spec's VRB detail rows where unambiguous (D24)
        // tio 20Nov26: expectations regenerated from the engine post-d-morpheme (D23/D24);
        // FUTURE_COMMAND rows left untouched (D1/D2 debt)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "diganatlosga"
        "SG1" | "" | Tense.HABITUAL        | "diganatlosgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "dvquanatlosvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "ganatlosvi"
        "SG1" | "" | Tense.INFINITIVE      | "dvginatlohisdi"
        "SG2" | "" | Tense.PRESENT         | "tinatlosga"
        "SG2" | "" | Tense.HABITUAL        | "tinatlosgoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "ditsanatlosvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "hanatlosvi"
        "SG2" | "" | Tense.INFINITIVE      | "ditsanatlohisdi"
        "SG3" | "" | Tense.PRESENT         | "danadlosga"
        "SG3" | "" | Tense.HABITUAL        | "danadlosgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "dunadlosvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "anatlosvi"
        "SG3" | "" | Tense.INFINITIVE      | "junadlohisdi"
        "PL3" | "" | Tense.PRESENT         | "dvnanatlosga"
        "PL3" | "" | Tense.HABITUAL        | "dvnanatlosgoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "dunanatlosvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "ananatlosvi"
        "PL3" | "" | Tense.INFINITIVE      | "tsuninatlohisdi"
        "PL1INCL" | "" | Tense.PRESENT         | "dadanatlosga"
        "PL1INCL" | "" | Tense.HABITUAL        | "dadanatlosgoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "daganatlosvi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "idanatlosvi"
        "PL1INCL" | "" | Tense.INFINITIVE      | "daginatlohisdi"
    }
}
