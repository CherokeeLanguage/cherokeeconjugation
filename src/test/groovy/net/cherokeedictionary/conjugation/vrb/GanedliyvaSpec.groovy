// tio 16Nov26: citation rows re-aligned to CED cedEntries.csv id 73102 (entrya ganedliyva) -- the yaml transcription carried unconvertible romanization clusters (DISCREPANCIES.md D9/D12)
package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class GanedliyvaSpec extends VerbBaseSpec {
    static def details = [
        definition: "S/hes Changing It",
        part_of_speech: "v.i.",
        conjugations: [
                [subject: 'SG1', object: '', present: 'jinedliyva'],
            [subject: 'SG1', object: '', present: 'jinedliyva', habitual: 'jinedliyvsgoi', remote_past: 'aginedliyvsvi', imperative: 'jinedliyvna', infinitive: 'aginedliyvsdi'],
            [subject: 'SG2', object: '', present: 'hinedliyva', habitual: 'hinedliyvsgoi', remote_past: 'janedliyvsvi', imperative: 'hinedliyvna', infinitive: 'janedliyvsdi'],
            [subject: 'SG3', object: '', habitual: 'ganedliyvsgoi', imperative: 'hinedliyvna', infinitive: 'unedliyvsdi', present: 'ganedliyva', remote_past: 'unedliyvsvi'],
            [subject: 'PL3', object: '', present: 'aninedliyva', habitual: 'aninedliyvsgoi', remote_past: 'uninedliyvsvi', imperative: 'aninedliyvna', infinitive: 'uninedliyvsdi'],
            [subject: 'PL1INCL', object: '', present: 'idinedliyva', habitual: 'idinedliyvsgoi', remote_past: 'iginedliyvsvi', imperative: 'idinedliyvna', infinitive: 'iginedliyvsdi']
        ]
    ]

    @Unroll
    def "conjugating Ganedliyva (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Ganedliyva", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        // tio 19Nov26: expectations aligned to this spec's VRB detail rows where unambiguous (D24)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "jinedliyva"
        "SG1" | "" | Tense.HABITUAL        | "jinedliyvsgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "aginedliyvsvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "tsinetliyvsvi"
        "SG1" | "" | Tense.INFINITIVE      | "aginedliyvsdi"
        "SG2" | "" | Tense.PRESENT         | "hinedliyva"
        "SG2" | "" | Tense.HABITUAL        | "hinedliyvsgoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "janedliyvsvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "hinetliyvsvi"
        "SG2" | "" | Tense.INFINITIVE      | "janedliyvsdi"
        "SG3" | "" | Tense.PRESENT         | "ganedliyva"
        "SG3" | "" | Tense.HABITUAL        | "ganedliyvsgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "unedliyvsvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "ganetliyvsvi"
        "SG3" | "" | Tense.INFINITIVE      | "unedliyvsdi"
        "PL3" | "" | Tense.PRESENT         | "aninedliyva"
        "PL3" | "" | Tense.HABITUAL        | "aninedliyvsgoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "uninedliyvsvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "aninetliyvsvi"
        "PL3" | "" | Tense.INFINITIVE      | "uninedliyvsdi"
        "PL1INCL" | "" | Tense.PRESENT         | "idinedliyva"
        "PL1INCL" | "" | Tense.HABITUAL        | "idinedliyvsgoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "iginedliyvsvi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "idinetliyvsvi"
        "PL1INCL" | "" | Tense.INFINITIVE      | "iginedliyvsdi"
    }
}
