package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class AganawadihaSpec extends VerbBaseSpec {
    static def details = [
        definition: "S/hes Warming It",
        part_of_speech: "v.i.",
        conjugations: [
            [subject: 'SG1', object: '', present: 'jiganawodiha', habitual: 'jiganawodisgoi', remote_past: 'agiganawatanvi', imperative: 'jiganawada', infinitive: '/'],
            [subject: 'SG2', object: '', present: 'higanawadiha', habitual: 'higanawadisgoi', remote_past: 'jaganawatanvi', imperative: 'jaganawadohdi', infinitive: ''],
            [subject: 'SG3', object: '', present: 'aganawadiha', habitual: 'aganawadisgoi', remote_past: 'uganawatanvi', imperative: 'aganawada', infinitive: 'uganawadohdi'],
            [subject: 'PL3', object: '', present: 'aniganawadiha', habitual: 'aniganawadisgoi', remote_past: 'uniganawatanvi', imperative: 'aniganawada', infinitive: 'uniganawadohdi'],
            [subject: 'PL1INCL', object: '', present: 'idiganawadiha', habitual: 'idiganawadisgoi', remote_past: 'igiganawatanvi', imperative: 'idiganawada', infinitive: 'igiganawadohdi']
        ]
    ]

    @Unroll
    def "conjugating Aganawadiha (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Aganawadiha", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "tsiganawadiha"
        "SG1" | "" | Tense.HABITUAL        | "tsiganawadisgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "agiganawatanvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "tsiganawatanvi"
        // "SG1" | "" | Tense.INFINITIVE      | "/"
        "SG2" | "" | Tense.PRESENT         | "higanawadiha"
        "SG2" | "" | Tense.HABITUAL        | "higanawadisgoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "tsaganawatanvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "higanawatanvi"
        // "SG2" | "" | Tense.INFINITIVE      | "tsaganawadodi"
        "SG3" | "" | Tense.PRESENT         | "aganawadiha"
        "SG3" | "" | Tense.HABITUAL        | "aganawadisgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "uganawatanvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "aganawatanvi"
        "SG3" | "" | Tense.INFINITIVE      | "uganawadodi"
        "PL3" | "" | Tense.PRESENT         | "aniganawadiha"
        "PL3" | "" | Tense.HABITUAL        | "aniganawadisgoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "uniganawatanvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "aniganawatanvi"
        "PL3" | "" | Tense.INFINITIVE      | "uniganawadodi"
        "PL1INCL" | "" | Tense.PRESENT         | "idiganawadiha"
        "PL1INCL" | "" | Tense.HABITUAL        | "idiganawadisgoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "igiganawatanvi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "idiganawatanvi"
        "PL1INCL" | "" | Tense.INFINITIVE      | "igiganawadodi"
    }
}
