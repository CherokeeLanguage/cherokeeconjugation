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
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "tsikanetliyva"
        "SG1" | "" | Tense.HABITUAL        | "tsikanetliyvsgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "agikanetliyvsvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "tsikanetliyvsvi"
        "SG1" | "" | Tense.INFINITIVE      | "agikaneyodi"
        "SG2" | "" | Tense.PRESENT         | "hikanetliyva"
        "SG2" | "" | Tense.HABITUAL        | "hikanetliyvsgoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "tsakanetliyvsvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "hikanetliyvsvi"
        "SG2" | "" | Tense.INFINITIVE      | "tsakaneyodi"
        "SG3" | "" | Tense.PRESENT         | "dakanetliyva"
        "SG3" | "" | Tense.HABITUAL        | "dakanetliyvsgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "ukanetliyvsvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "gakanetliyvsvi"
        "SG3" | "" | Tense.INFINITIVE      | "ukaneyodi"
        "PL3" | "" | Tense.PRESENT         | "anikanetliyva"
        "PL3" | "" | Tense.HABITUAL        | "anikanetliyvsgoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "unikanetliyvsvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "anikanetliyvsvi"
        "PL3" | "" | Tense.INFINITIVE      | "unikaneyodi"
        "PL1INCL" | "" | Tense.PRESENT         | "idikanetliyva"
        "PL1INCL" | "" | Tense.HABITUAL        | "idikanetliyvsgoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "igikanetliyvsvi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "idikanetliyvsvi"
        "PL1INCL" | "" | Tense.INFINITIVE      | "igikaneyodi"
    }
}
