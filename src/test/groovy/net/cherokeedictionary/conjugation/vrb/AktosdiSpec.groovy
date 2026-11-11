package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class AktosdiSpec extends VerbBaseSpec {
    static def details = [
        definition: "Watching",
        part_of_speech: "v.t.",
        conjugations: [
            [subject: 'SG1', object: 'SG3AN', present: 'jigatosdi', habitual: 'jigatosdisgoi', remote_past: 'jigatostanvi', imperative: 'jiyaktosda', infinitive: 'jigatosdohdi'],
            [subject: 'SG1', object: 'SG3IN', present: 'agwaktosdi', habitual: 'agwaktosdisgoi', remote_past: 'agwaktostanvi', imperative: 'agwaktosda', infinitive: 'agwaktosdohdi'],
            [subject: 'SG2', object: 'SG3AN', present: 'higatosdi', habitual: 'higatosdisgoi', remote_past: 'higatostanvi', imperative: 'haktosda', infinitive: 'higatosdohdi'],
            [subject: 'SG2', object: 'SG3IN', present: 'jaktosdi', habitual: 'jaktosdisgoi', remote_past: 'jaktostanvi', imperative: 'jaktosda', infinitive: '(not'],
            [subject: 'PL3', object: 'SG3IN', present: 'anaktosdi', habitual: 'anaktosdisgoi', remote_past: 'unaktostanvi', imperative: 'anaktosda', infinitive: 'unaktosdohdi'],
            [subject: 'PL1INCL', object: 'SG3IN', present: 'idigatosdi', habitual: 'idigatosdisgoi', remote_past: 'igaktostanvi', imperative: 'idaktosda', infinitive: 'igaktosdohdi']
        ]
    ]

    @Unroll
    def "conjugating Aktosdi (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Aktosdi", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "SG3AN" | Tense.PRESENT         | "jigatosdi"
        "SG1" | "SG3AN" | Tense.HABITUAL        | "jigatosdisgoi"
        "SG1" | "SG3AN" | Tense.REMOTE_PAST     | "jigatostanvi"
        "SG1" | "SG3AN" | Tense.FUTURE_COMMAND      | "jiyaktosda"
        "SG1" | "SG3AN" | Tense.INFINITIVE      | "jigatosdohdi"
        "SG1" | "SG3IN" | Tense.PRESENT         | "agwaktosdi"
        "SG1" | "SG3IN" | Tense.HABITUAL        | "agwaktosdisgoi"
        "SG1" | "SG3IN" | Tense.REMOTE_PAST     | "agwaktostanvi"
        "SG1" | "SG3IN" | Tense.FUTURE_COMMAND      | "agwaktosda"
        "SG1" | "SG3IN" | Tense.INFINITIVE      | "agwaktosdohdi"
        "SG2" | "SG3AN" | Tense.PRESENT         | "higatosdi"
        "SG2" | "SG3AN" | Tense.HABITUAL        | "higatosdisgoi"
        "SG2" | "SG3AN" | Tense.REMOTE_PAST     | "higatostanvi"
        "SG2" | "SG3AN" | Tense.FUTURE_COMMAND      | "haktosda"
        "SG2" | "SG3AN" | Tense.INFINITIVE      | "higatosdohdi"
        "SG2" | "SG3IN" | Tense.PRESENT         | "jaktosdi"
        "SG2" | "SG3IN" | Tense.HABITUAL        | "jaktosdisgoi"
        "SG2" | "SG3IN" | Tense.REMOTE_PAST     | "jaktostanvi"
        "SG2" | "SG3IN" | Tense.FUTURE_COMMAND      | "jaktosda"
        // "SG2" | "SG3IN" | Tense.INFINITIVE      | "(not"
        "PL3" | "SG3IN" | Tense.PRESENT         | "anaktosdi"
        "PL3" | "SG3IN" | Tense.HABITUAL        | "anaktosdisgoi"
        "PL3" | "SG3IN" | Tense.REMOTE_PAST     | "unaktostanvi"
        "PL3" | "SG3IN" | Tense.FUTURE_COMMAND      | "anaktosda"
        "PL3" | "SG3IN" | Tense.INFINITIVE      | "unaktosdohdi"
        "PL1INCL" | "SG3IN" | Tense.PRESENT         | "idigatosdi"
        "PL1INCL" | "SG3IN" | Tense.HABITUAL        | "idigatosdisgoi"
        "PL1INCL" | "SG3IN" | Tense.REMOTE_PAST     | "igaktostanvi"
        "PL1INCL" | "SG3IN" | Tense.FUTURE_COMMAND      | "idaktosda"
        "PL1INCL" | "SG3IN" | Tense.INFINITIVE      | "igaktosdohdi"
    }
}
