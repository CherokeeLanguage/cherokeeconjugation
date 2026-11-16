// tio 16Nov26: citation rows re-aligned to CED cedEntries.csv id 72721 (entrya ayostanohvsga) -- the yaml transcription carried unconvertible romanization clusters (DISCREPANCIES.md D9/D12)
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
                [subject: 'SG1', object: '', present: 'jiyostanohvsga'],
            [subject: 'SG1', object: 'SG3AN', present: 'jiyostanohvsga', habitual: 'jiyostanohvsgoi', remote_past: 'agiyostanohnvi', imperative: 'jiyostanohna', infinitive: 'agiyostanohvsdi'],
            [subject: 'SG2', object: 'SG3AN', present: 'hiyostanohvsga', habitual: 'hiyostanohvsgoi', remote_past: 'jayostanohnvi', imperative: 'hiyostanohna', infinitive: 'jayostanohvsdi'],
            [subject: 'SG3', object: '', habitual: 'ayostanohvsgoi', imperative: 'hiyostanohna', infinitive: 'uyostanohvsdi', present: 'ayostanohvsga', remote_past: 'uyostanohnvi'],
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
        "SG1" | "SG3AN" | Tense.PRESENT         | "tsiyostanohvsga"
        "SG1" | "SG3AN" | Tense.HABITUAL        | "tsiyostanohvsgoi"
        "SG1" | "SG3AN" | Tense.REMOTE_PAST     | "tsiyostanonvi"
        "SG1" | "SG3AN" | Tense.FUTURE_COMMAND      | "tsiyostanonvi"
        "SG1" | "SG3AN" | Tense.INFINITIVE      | "tsiyostanohvsdi"
        "SG2" | "SG3AN" | Tense.PRESENT         | "hiyostanohvsga"
        "SG2" | "SG3AN" | Tense.HABITUAL        | "hiyostanohvsgoi"
        "SG2" | "SG3AN" | Tense.REMOTE_PAST     | "yostanonvi"
        "SG2" | "SG3AN" | Tense.FUTURE_COMMAND      | "hiyostanonvi"
        "SG2" | "SG3AN" | Tense.INFINITIVE      | "yostanohvsdi"
        "SG3" | "SG3AN" | Tense.PRESENT         | "gayostanohvsga"
        "SG3" | "SG3AN" | Tense.HABITUAL        | "ayostanohvsgoi"
        "SG3" | "SG3AN" | Tense.REMOTE_PAST     | "uyostanonvi"
        "SG3" | "SG3AN" | Tense.FUTURE_COMMAND      | "ayostanonvi"
        "SG3" | "SG3AN" | Tense.INFINITIVE      | "uyostanohvsdi"
        "PL3" | "SG3AN" | Tense.PRESENT         | "aniyostanohvsga"
        "PL3" | "SG3AN" | Tense.HABITUAL        | "aniyostanohvsgoi"
        "PL3" | "SG3AN" | Tense.REMOTE_PAST     | "aniyostanonvi"
        "PL3" | "SG3AN" | Tense.FUTURE_COMMAND      | "aniyostanonvi"
        "PL3" | "SG3AN" | Tense.INFINITIVE      | "aniyostanohvsdi"
        "PL1INCL" | "SG3AN" | Tense.PRESENT         | "ediyostanohvsga"
        "PL1INCL" | "SG3AN" | Tense.HABITUAL        | "ediyostanohvsgoi"
        "PL1INCL" | "SG3AN" | Tense.REMOTE_PAST     | "yostanonvi"
        "PL1INCL" | "SG3AN" | Tense.FUTURE_COMMAND      | "ediyostanonvi"
        "PL1INCL" | "SG3AN" | Tense.INFINITIVE      | "yostanohvsdi"
    }
}
