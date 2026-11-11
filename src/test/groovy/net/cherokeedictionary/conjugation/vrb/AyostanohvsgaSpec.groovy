package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class AyostanohvsgaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Destroying",
        part_of_speech: "v.t.",
        conjugations: [
            [subject: 'SG1', object: 'SG3AN', present: 'jiyostanohvsga', habitual: 'jiyostanohvsgoi', remote_past: 'agiyostanohnvi', imperative: 'jiyostanohna', infinitive: 'agiyostanohvsdi'],
            [subject: 'SG2', object: 'SG3AN', present: 'hiyostanohvsga', habitual: 'hiyostanohvsgoi', remote_past: 'jayostanohnvi', imperative: 'hiyostanohna', infinitive: 'jayostanohvsdi'],
            [subject: 'SG3', object: 'SG3AN', present: 'ayostanohvsga', habitual: 'ayostanohvsgoi', remote_past: 'uyostanohnvi', imperative: 'ayostanohna', infinitive: 'uyostanohvsdi'],
            [subject: 'PL3', object: 'SG3AN', present: 'aniyostanohvsga', habitual: 'aniyostanohvsgoi', remote_past: 'uniyostanohnvi', imperative: 'aniyostanohna', infinitive: 'uniyostanohvsdi'],
            [subject: 'PL1INCL', object: 'SG3AN', present: 'idiyostanohvsga', habitual: 'idiyostanohvsgoi', remote_past: 'igiyostanohnvi', imperative: 'idiyostanohna', infinitive: 'igiyostanohvsdi']
        ]
    ]

    @Unroll
    def "conjugating Ayostanohvsga (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Ayostanohvsga", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "SG3AN" | Tense.PRESENT         | "jiyostanohvsga"
        "SG1" | "SG3AN" | Tense.HABITUAL        | "jiyostanohvsgoi"
        "SG1" | "SG3AN" | Tense.REMOTE_PAST     | "agiyostanohnvi"
        "SG1" | "SG3AN" | Tense.FUTURE_COMMAND      | "jiyostanohna"
        "SG1" | "SG3AN" | Tense.INFINITIVE      | "agiyostanohvsdi"
        "SG2" | "SG3AN" | Tense.PRESENT         | "hiyostanohvsga"
        "SG2" | "SG3AN" | Tense.HABITUAL        | "hiyostanohvsgoi"
        "SG2" | "SG3AN" | Tense.REMOTE_PAST     | "jayostanohnvi"
        "SG2" | "SG3AN" | Tense.FUTURE_COMMAND      | "hiyostanohna"
        "SG2" | "SG3AN" | Tense.INFINITIVE      | "jayostanohvsdi"
        "SG3" | "SG3AN" | Tense.PRESENT         | "ayostanohvsga"
        "SG3" | "SG3AN" | Tense.HABITUAL        | "ayostanohvsgoi"
        "SG3" | "SG3AN" | Tense.REMOTE_PAST     | "uyostanohnvi"
        "SG3" | "SG3AN" | Tense.FUTURE_COMMAND      | "ayostanohna"
        "SG3" | "SG3AN" | Tense.INFINITIVE      | "uyostanohvsdi"
        "PL3" | "SG3AN" | Tense.PRESENT         | "aniyostanohvsga"
        "PL3" | "SG3AN" | Tense.HABITUAL        | "aniyostanohvsgoi"
        "PL3" | "SG3AN" | Tense.REMOTE_PAST     | "uniyostanohnvi"
        "PL3" | "SG3AN" | Tense.FUTURE_COMMAND      | "aniyostanohna"
        "PL3" | "SG3AN" | Tense.INFINITIVE      | "uniyostanohvsdi"
        "PL1INCL" | "SG3AN" | Tense.PRESENT         | "idiyostanohvsga"
        "PL1INCL" | "SG3AN" | Tense.HABITUAL        | "idiyostanohvsgoi"
        "PL1INCL" | "SG3AN" | Tense.REMOTE_PAST     | "igiyostanohnvi"
        "PL1INCL" | "SG3AN" | Tense.FUTURE_COMMAND      | "idiyostanohna"
        "PL1INCL" | "SG3AN" | Tense.INFINITIVE      | "igiyostanohvsdi"
    }
}
