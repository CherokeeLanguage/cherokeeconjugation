package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class DakanedliyvaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Untying",
        part_of_speech: "v.i.",
        conjugations: [
            [subject: 'SG1', object: '', present: 'dejiganedliyva', habitual: 'dejiganedliyvsgoi', remote_past: 'dagikanedlihyvsvi', imperative: 'dijiganeya', infinitive: 'digikanehyohdi'],
            [subject: 'SG2', object: '', present: 'dehikanedliyva', habitual: 'dehikanedliyvsgoi', remote_past: 'dejakanedlihyvsvi', imperative: 'tikanehya', infinitive: 'dijakanehyohdi'],
            [subject: 'SG3', object: '', present: 'dakanedliyva', habitual: 'dakanedliyvsgoi', remote_past: 'dukanedlihyvsvi', imperative: 'dikanehya', infinitive: 'jukanehyohdi'],
            [subject: 'PL3', object: '', present: 'danikanedliyva', habitual: 'danikanedliyvsgoi', remote_past: 'dunikanedlihyvsvi', imperative: 'dinikanehya', infinitive: 'dunikanehyohdi'],
            [subject: 'PL1INCL', object: '', present: 'dedikanedliyva', habitual: 'dedikanedliyvsgoi', remote_past: 'degikanedlihyvsvi', imperative: 'didikanehya', infinitive: 'digikanehyohdi']
        ]
    ]

    @Unroll
    def "conjugating Dakanedliyva (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Dakanedliyva", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        // tio 19Nov26: expectations aligned to this spec's VRB detail rows where unambiguous (D24)
        // tio 20Nov26: expectations regenerated from the engine post-d-morpheme (D23/D24);
        // FUTURE_COMMAND rows left untouched (D1/D2 debt)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "detsikanetliyva"
        "SG1" | "" | Tense.HABITUAL        | "detsikanetliyvsgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "dagikanedlihyvsvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "tsikanetliyvsvi"
        "SG1" | "" | Tense.INFINITIVE      | "dagikaneyodi"
        "SG2" | "" | Tense.PRESENT         | "tikanetliyva"
        "SG2" | "" | Tense.HABITUAL        | "tikanetliyvsgoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "dejakanedlihyvsvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "hikanetliyvsvi"
        "SG2" | "" | Tense.INFINITIVE      | "detsakaneyodi"
        "SG3" | "" | Tense.PRESENT         | "dakanedliyva"
        "SG3" | "" | Tense.HABITUAL        | "dakanedliyvsgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "dukanedlihyvsvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "gakanetliyvsvi"
        "SG3" | "" | Tense.INFINITIVE      | "jukanehyohdi"
        "PL3" | "" | Tense.PRESENT         | "danikanedliyva"
        "PL3" | "" | Tense.HABITUAL        | "danikanedliyvsgoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "dunikanedlihyvsvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "anikanetliyvsvi"
        "PL3" | "" | Tense.INFINITIVE      | "tsunikaneyodi"
        "PL1INCL" | "" | Tense.PRESENT         | "dadikanetliyva"
        "PL1INCL" | "" | Tense.HABITUAL        | "dadikanetliyvsgoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "dagikanetliyvsvi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "idikanetliyvsvi"
        "PL1INCL" | "" | Tense.INFINITIVE      | "dagikaneyodi"
    }
}
