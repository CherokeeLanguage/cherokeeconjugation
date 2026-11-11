package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class AlehwisdohdihaSpec extends VerbBaseSpec {
    static def details = [
        definition: "(He/She/It) Is Stopping (Him/Her/It)",
        part_of_speech: "v.t.",
        conjugations: [
            [subject: 'SG1', object: 'SG3AN', present: 'jiyalewisdohdiha', habitual: 'jiyalehwisdohdisgoi', remote_past: 'jiyalehwisdohtanvi', imperative: 'jiyalewisdohda', infinitive: 'jiyalehwisdohdohdi'],
            [subject: 'SG1', object: 'SG3IN', present: 'galehwisdohdiha', habitual: 'galehwisdohdisgoi', remote_past: 'agwalehwisdohtanvi', imperative: 'galehwisdohda', infinitive: 'agwalehwisdohdohdi'],
            [subject: 'SG2', object: 'SG3AN', present: 'hiyalehwisdohdiha', habitual: 'hiyalehwisdohdisgoi', remote_past: 'hiyalehwisdohtanvi', imperative: 'hiyalewisdohda', infinitive: 'hiyalehwisdohdohdi'],
            [subject: 'SG2', object: 'SG3IN', present: 'halehwisdohdiha', habitual: 'halehwisdohdisgoi', remote_past: 'jalehwisdohtanvi', imperative: 'halehwisdohda', infinitive: 'jalehiwsdohdohdi'],
            [subject: 'SG3', object: 'SG3IN', present: 'alehwisdohdiha', habitual: 'alehwisdohdisgoi', remote_past: 'ulehwisdohtanvi', imperative: 'alehwisdohda', infinitive: 'ulehwisdohdohdi'],
            [subject: 'PL3', object: 'SG3IN', present: 'analehwisdohdiha', habitual: 'analehwisdohdisgoi', remote_past: 'analehwisdohtanvi', imperative: 'analehwisdohda', infinitive: 'unalehwisdohdohdi'],
            [subject: 'PL1INCL', object: 'SG3IN', present: 'idalehwisdohdiha', habitual: 'idalehwisdohdisgoi', remote_past: 'igalehwisdohtanvi', imperative: 'idalehwisdohda', infinitive: 'igalehwisdohdohdi']
        ]
    ]

    @Unroll
    def "conjugating Alehwisdohdiha (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Alehwisdohdiha", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "SG3AN" | Tense.PRESENT         | "jiyalewisdohdiha"
        "SG1" | "SG3AN" | Tense.HABITUAL        | "jiyalehwisdohdisgoi"
        "SG1" | "SG3AN" | Tense.REMOTE_PAST     | "jiyalehwisdohtanvi"
        "SG1" | "SG3AN" | Tense.FUTURE_COMMAND      | "jiyalewisdohda"
        "SG1" | "SG3AN" | Tense.INFINITIVE      | "jiyalehwisdohdohdi"
        "SG1" | "SG3IN" | Tense.PRESENT         | "galehwisdohdiha"
        "SG1" | "SG3IN" | Tense.HABITUAL        | "galehwisdohdisgoi"
        "SG1" | "SG3IN" | Tense.REMOTE_PAST     | "agwalehwisdohtanvi"
        "SG1" | "SG3IN" | Tense.FUTURE_COMMAND      | "galehwisdohda"
        "SG1" | "SG3IN" | Tense.INFINITIVE      | "agwalehwisdohdohdi"
        "SG2" | "SG3AN" | Tense.PRESENT         | "hiyalehwisdohdiha"
        "SG2" | "SG3AN" | Tense.HABITUAL        | "hiyalehwisdohdisgoi"
        "SG2" | "SG3AN" | Tense.REMOTE_PAST     | "hiyalehwisdohtanvi"
        "SG2" | "SG3AN" | Tense.FUTURE_COMMAND      | "hiyalewisdohda"
        "SG2" | "SG3AN" | Tense.INFINITIVE      | "hiyalehwisdohdohdi"
        "SG2" | "SG3IN" | Tense.PRESENT         | "halehwisdohdiha"
        "SG2" | "SG3IN" | Tense.HABITUAL        | "halehwisdohdisgoi"
        "SG2" | "SG3IN" | Tense.REMOTE_PAST     | "jalehwisdohtanvi"
        "SG2" | "SG3IN" | Tense.FUTURE_COMMAND      | "halehwisdohda"
        "SG2" | "SG3IN" | Tense.INFINITIVE      | "jalehiwsdohdohdi"
        "SG3" | "SG3IN" | Tense.PRESENT         | "alehwisdohdiha"
        "SG3" | "SG3IN" | Tense.HABITUAL        | "alehwisdohdisgoi"
        "SG3" | "SG3IN" | Tense.REMOTE_PAST     | "ulehwisdohtanvi"
        "SG3" | "SG3IN" | Tense.FUTURE_COMMAND      | "alehwisdohda"
        "SG3" | "SG3IN" | Tense.INFINITIVE      | "ulehwisdohdohdi"
        "PL3" | "SG3IN" | Tense.PRESENT         | "analehwisdohdiha"
        "PL3" | "SG3IN" | Tense.HABITUAL        | "analehwisdohdisgoi"
        "PL3" | "SG3IN" | Tense.REMOTE_PAST     | "analehwisdohtanvi"
        "PL3" | "SG3IN" | Tense.FUTURE_COMMAND      | "analehwisdohda"
        "PL3" | "SG3IN" | Tense.INFINITIVE      | "unalehwisdohdohdi"
        "PL1INCL" | "SG3IN" | Tense.PRESENT         | "idalehwisdohdiha"
        "PL1INCL" | "SG3IN" | Tense.HABITUAL        | "idalehwisdohdisgoi"
        "PL1INCL" | "SG3IN" | Tense.REMOTE_PAST     | "igalehwisdohtanvi"
        "PL1INCL" | "SG3IN" | Tense.FUTURE_COMMAND      | "idalehwisdohda"
        "PL1INCL" | "SG3IN" | Tense.INFINITIVE      | "igalehwisdohdohdi"
    }
}
