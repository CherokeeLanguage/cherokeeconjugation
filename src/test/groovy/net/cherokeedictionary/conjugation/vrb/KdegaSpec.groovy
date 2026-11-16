// tio 16Nov26: citation rows re-aligned to CED cedEntries.csv id 73508 (entrya kdega) -- the yaml transcription carried unconvertible romanization clusters (DISCREPANCIES.md D9/D12)
package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class KdegaSpec extends VerbBaseSpec {
    static def details = [
        definition: "S/hes Parting With Him/Her in Death",
        part_of_speech: "v.t.",
        conjugations: [
                [subject: 'SG1', object: '', present: 'jiyvdega'],
            [subject: 'SG1', object: 'SG3AN', present: 'jiyvdega', habitual: 'jiyvdegoi', remote_past: 'akdejvi', imperative: 'jiyvdegi', infinitive: 'akdeisdi'],
            [subject: 'SG2', object: 'SG3AN', present: 'hiyvdega', habitual: 'hiyvdegoi', remote_past: 'tsdejvi', imperative: 'hiyvdegi', infinitive: 'tsdeisdi'],
            [subject: 'SG3', object: '', habitual: 'kdegoi', imperative: 'hiyvdegi', infinitive: 'uwhdeisdi', present: 'kdega', remote_past: 'uwhdejvi'],
            [subject: 'PL3', object: 'SG3AN', present: 'andega', habitual: 'andegoi', remote_past: 'undejvi', imperative: 'andegi', infinitive: 'undeisdi'],
            [subject: 'PL1INCL', object: 'SG3AN', present: 'idvdega', habitual: 'idvdegoi', remote_past: 'ikdegjvi', imperative: 'idvdegi', infinitive: 'ikdeisdi']
        ]
    ]

    @Unroll
    def "conjugating Kdega (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Kdega", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "SG3AN" | Tense.PRESENT         | "tsigidega"
        "SG1" | "SG3AN" | Tense.HABITUAL        | "tsigidegoi"
        "SG1" | "SG3AN" | Tense.REMOTE_PAST     | "tsiyuwedetsvi"
        "SG1" | "SG3AN" | Tense.FUTURE_COMMAND      | "tsiyuwedetsvi"
        "SG1" | "SG3AN" | Tense.INFINITIVE      | "tsiwedeisdi"
        "SG2" | "SG3AN" | Tense.PRESENT         | "higidega"
        "SG2" | "SG3AN" | Tense.HABITUAL        | "higidegoi"
        "SG2" | "SG3AN" | Tense.REMOTE_PAST     | "uwedetsvi"
        "SG2" | "SG3AN" | Tense.FUTURE_COMMAND      | "hiyuwedetsvi"
        "SG2" | "SG3AN" | Tense.INFINITIVE      | "wedeisdi"
        "SG3" | "SG3AN" | Tense.PRESENT         | "gagidega"
        "SG3" | "SG3AN" | Tense.HABITUAL        | "gidegoi"
        "SG3" | "SG3AN" | Tense.REMOTE_PAST     | "uwuwedetsvi"
        "SG3" | "SG3AN" | Tense.FUTURE_COMMAND      | "uwedetsvi"
        "SG3" | "SG3AN" | Tense.INFINITIVE      | "uwedeisdi"
        "PL3" | "SG3AN" | Tense.PRESENT         | "anigidega"
        "PL3" | "SG3AN" | Tense.HABITUAL        | "anigidegoi"
        "PL3" | "SG3AN" | Tense.REMOTE_PAST     | "anuwedetsvi"
        "PL3" | "SG3AN" | Tense.FUTURE_COMMAND      | "anuwedetsvi"
        "PL3" | "SG3AN" | Tense.INFINITIVE      | "aniwedeisdi"
        "PL1INCL" | "SG3AN" | Tense.PRESENT         | "edigidega"
        "PL1INCL" | "SG3AN" | Tense.HABITUAL        | "edigidegoi"
        "PL1INCL" | "SG3AN" | Tense.REMOTE_PAST     | "uwedetsvi"
        "PL1INCL" | "SG3AN" | Tense.FUTURE_COMMAND      | "eduwedetsvi"
        "PL1INCL" | "SG3AN" | Tense.INFINITIVE      | "wedeisdi"
    }
}
