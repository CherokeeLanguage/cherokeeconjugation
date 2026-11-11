package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class GadeysdihaSpec extends VerbBaseSpec {
    static def details = [
        definition: "S/hes Turning It",
        part_of_speech: "v.i.",
        conjugations: [
            [subject: 'SG1', object: '', present: 'jideyasdiha', habitual: 'jideyasdisgoi', remote_past: 'akdeystanvi', imperative: 'jideyasda', infinitive: 'akdeysdohdi'],
            [subject: 'SG2', object: '', present: 'hideysdiha', habitual: 'hideysdisgoi', remote_past: 'tsdeystanvi', imperative: 'hideysda', infinitive: 'tsdeysdohdi'],
            [subject: 'SG3', object: '', present: 'gadeysdiha', habitual: 'gadeysdisgoi', remote_past: 'uwadeystanvi', imperative: 'gadeysda', infinitive: 'uwadeysdohdi'],
            [subject: 'PL3', object: '', present: 'anideysdiha', habitual: 'anideysdisgoi', remote_past: 'unideystanvi', imperative: 'anideysda', infinitive: 'unideysdohdi'],
            [subject: 'PL1INCL', object: '', present: 'idideysdiha', habitual: 'idideysdisgoi', remote_past: 'igadeystanvi', imperative: 'idideysda', infinitive: 'igideysdohdi']
        ]
    ]

    @Unroll
    def "conjugating Gadeysdiha (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Gadeysdiha", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "jideyasdiha"
        "SG1" | "" | Tense.HABITUAL        | "jideyasdisgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "akdeystanvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "jideyasda"
        "SG1" | "" | Tense.INFINITIVE      | "akdeysdohdi"
        "SG2" | "" | Tense.PRESENT         | "hideysdiha"
        "SG2" | "" | Tense.HABITUAL        | "hideysdisgoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "tsdeystanvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "hideysda"
        "SG2" | "" | Tense.INFINITIVE      | "tsdeysdohdi"
        "SG3" | "" | Tense.PRESENT         | "gadeysdiha"
        "SG3" | "" | Tense.HABITUAL        | "gadeysdisgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "uwadeystanvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "gadeysda"
        "SG3" | "" | Tense.INFINITIVE      | "uwadeysdohdi"
        "PL3" | "" | Tense.PRESENT         | "anideysdiha"
        "PL3" | "" | Tense.HABITUAL        | "anideysdisgoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "unideystanvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "anideysda"
        "PL3" | "" | Tense.INFINITIVE      | "unideysdohdi"
        "PL1INCL" | "" | Tense.PRESENT         | "idideysdiha"
        "PL1INCL" | "" | Tense.HABITUAL        | "idideysdisgoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "igadeystanvi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "idideysda"
        "PL1INCL" | "" | Tense.INFINITIVE      | "igideysdohdi"
    }
}
