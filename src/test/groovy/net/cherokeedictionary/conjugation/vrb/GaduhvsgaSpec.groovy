package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class GaduhvsgaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Baking (93)",
        part_of_speech: "v.i.",
        conjugations: [
            [subject: 'SG1', object: '', present: 'jiduhvsga', habitual: 'jiduhvsgoi', remote_past: 'agiwaduhnvi', imperative: 'jiduhvga', infinitive: 'agiwatdi'],
            [subject: 'SG2', object: '', present: 'hiduhvsga', habitual: 'hiduhvsgoi', remote_past: 'jawaduhnvi', imperative: 'hiduhvga', infinitive: 'jawatdi'],
            [subject: 'SG3', object: '', present: 'gaduhvsga', habitual: 'gaduhvsgoi', remote_past: 'uwaduhnvi', imperative: 'gaduhvga', infinitive: 'uwatdi'],
            [subject: 'PL3', object: '', present: 'aniduhvsga', habitual: 'aniduhvsgoi', remote_past: 'uniwaduhnvi', imperative: 'aniduhvga', infinitive: 'uniwatdi'],
            [subject: 'PL1INCL', object: '', present: 'ididuhvsga', habitual: 'ididuhvsgoi', remote_past: 'igiwaduhnvi', imperative: 'ididuhvga', infinitive: 'igiwatdi']
        ]
    ]

    @Unroll
    def "conjugating Gaduhvsga (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Gaduhvsga", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "jiduhvsga"
        "SG1" | "" | Tense.HABITUAL        | "jiduhvsgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "agiwaduhnvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "jiduhvga"
        "SG1" | "" | Tense.INFINITIVE      | "agiwatdi"
        "SG2" | "" | Tense.PRESENT         | "hiduhvsga"
        "SG2" | "" | Tense.HABITUAL        | "hiduhvsgoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "jawaduhnvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "hiduhvga"
        "SG2" | "" | Tense.INFINITIVE      | "jawatdi"
        "SG3" | "" | Tense.PRESENT         | "gaduhvsga"
        "SG3" | "" | Tense.HABITUAL        | "gaduhvsgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "uwaduhnvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "gaduhvga"
        "SG3" | "" | Tense.INFINITIVE      | "uwatdi"
        "PL3" | "" | Tense.PRESENT         | "aniduhvsga"
        "PL3" | "" | Tense.HABITUAL        | "aniduhvsgoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "uniwaduhnvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "aniduhvga"
        "PL3" | "" | Tense.INFINITIVE      | "uniwatdi"
        "PL1INCL" | "" | Tense.PRESENT         | "ididuhvsga"
        "PL1INCL" | "" | Tense.HABITUAL        | "ididuhvsgoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "igiwaduhnvi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "ididuhvga"
        "PL1INCL" | "" | Tense.INFINITIVE      | "igiwatdi"
    }
}
