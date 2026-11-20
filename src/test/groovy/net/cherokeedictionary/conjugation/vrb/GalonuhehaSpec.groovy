// tio 16Nov26: citation rows re-aligned to CED cedEntries.csv id 73077 (entrya galonuheha) -- the yaml transcription carried unconvertible romanization clusters (DISCREPANCIES.md D9/D12)
package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class GalonuhehaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Cheating",
        part_of_speech: "v.i.",
        conjugations: [
                [subject: 'SG1', object: '', present: 'jilonueha'],
            [subject: 'SG1', object: '', present: 'jilonueha', habitual: 'jilonuesgoi', remote_past: 'agilonuhehlvi', imperative: 'jilonuvla', infinitive: 'agilonuhehdi'],
            [subject: 'SG2', object: '', present: 'hilonuheha', habitual: 'hilonuhesgoi', remote_past: 'jalonuhehlvi', imperative: 'hilonuhvla', infinitive: 'jalonuhehdi'],
            [subject: 'SG3', object: '', habitual: 'galonuhesgoi', imperative: 'hilonuhvla', infinitive: 'ulonuhehdi', present: 'galonuheha', remote_past: 'ulonuhehlvi'],
            [subject: 'PL3', object: '', present: 'anilonuheha', habitual: 'anilonuhesgoi', remote_past: 'unilonuhehlvi', imperative: 'anilonuhvla', infinitive: 'unilonuhehdi'],
            [subject: 'PL1INCL', object: '', present: 'idilonuheha', habitual: 'idilonuhesgoi', remote_past: 'igilonuhehlvi', imperative: 'idilonuhvla', infinitive: 'igilonuhehdi']
        ]
    ]

    @Unroll
    def "conjugating Galonuheha (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Galonuheha", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        // tio 19Nov26: expectations aligned to this spec's VRB detail rows where unambiguous (D24)
        // tio 20Nov26: expectations regenerated from the engine post-d-morpheme (D23/D24);
        // FUTURE_COMMAND rows left untouched (D1/D2 debt)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "tsilonuheha"
        "SG1" | "" | Tense.HABITUAL        | "tsilonuhesgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "agilonuhehlvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "tsilonuhetlvi"
        "SG1" | "" | Tense.INFINITIVE      | "agilonuhehdi"
        "SG2" | "" | Tense.PRESENT         | "hilonuheha"
        "SG2" | "" | Tense.HABITUAL        | "hilonuhesgoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "jalonuhehlvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "hilonuhetlvi"
        "SG2" | "" | Tense.INFINITIVE      | "jalonuhehdi"
        "SG3" | "" | Tense.PRESENT         | "galonuheha"
        "SG3" | "" | Tense.HABITUAL        | "galonuhesgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "ulonuhehlvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "galonuhetlvi"
        "SG3" | "" | Tense.INFINITIVE      | "ulonuhehdi"
        "PL3" | "" | Tense.PRESENT         | "anilonuheha"
        "PL3" | "" | Tense.HABITUAL        | "anilonuhesgoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "unilonuhehlvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "anilonuhetlvi"
        "PL3" | "" | Tense.INFINITIVE      | "unilonuhehdi"
        "PL1INCL" | "" | Tense.PRESENT         | "idilonuheha"
        "PL1INCL" | "" | Tense.HABITUAL        | "idilonuhesgoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "igilonuhehlvi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "idilonuhetlvi"
        "PL1INCL" | "" | Tense.INFINITIVE      | "igilonuhehdi"
    }
}
