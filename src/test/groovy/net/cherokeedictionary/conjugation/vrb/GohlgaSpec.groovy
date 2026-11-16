// tio 16Nov26: citation rows re-aligned to CED cedEntries.csv id 73242 (entrya gohlga) -- the yaml transcription carried unconvertible romanization clusters (DISCREPANCIES.md D9/D12)
package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class GohlgaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Recognizing Him (120)",
        part_of_speech: "v.t.",
        conjugations: [
                [subject: 'SG1', object: '', present: 'goliga'],
            [subject: 'SG1', object: 'SG3AN', present: 'jiyoliga', habitual: 'jiyoligoi', remote_past: 'jiyohlvi', imperative: 'jiyoligi', infinitive: 'jiyohlisdi'],
            [subject: 'SG2', object: 'SG3AN', present: 'hiyoliga', habitual: 'hiyoligoi', remote_past: 'hiyohljvi', imperative: 'hiyoligi', infinitive: 'hiyohlisdi'],
            [subject: 'SG3', object: '', habitual: 'gohlgoi', imperative: 'hohlgi', infinitive: 'uwohlisdi', present: 'gohlga', remote_past: 'uwohljvi'],
            [subject: 'PL3', object: 'SG3AN', present: 'anohlga', habitual: 'anohlgoi', remote_past: 'unohlvi', imperative: 'anohlgi', infinitive: 'unohlisdi'],
            [subject: 'PL1INCL', object: 'SG3AN', present: 'edohlga', habitual: 'edohlgoi', remote_past: 'edohlvi', imperative: 'edohlgi', infinitive: 'edohlisdi']
        ]
    ]

    @Unroll
    def "conjugating Gohlga (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Gohlga", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "SG3AN" | Tense.PRESENT         | "tsiyologa"
        "SG1" | "SG3AN" | Tense.HABITUAL        | "tsiyologoi"
        "SG1" | "SG3AN" | Tense.REMOTE_PAST     | "tsiyolotsvi"
        "SG1" | "SG3AN" | Tense.FUTURE_COMMAND      | "tsiyolotsvi"
        "SG1" | "SG3AN" | Tense.INFINITIVE      | "tsiwotlisdi"
        "SG2" | "SG3AN" | Tense.PRESENT         | "hiyologa"
        "SG2" | "SG3AN" | Tense.HABITUAL        | "hiyologoi"
        "SG2" | "SG3AN" | Tense.REMOTE_PAST     | "olotsvi"
        "SG2" | "SG3AN" | Tense.FUTURE_COMMAND      | "hiyolotsvi"
        "SG2" | "SG3AN" | Tense.INFINITIVE      | "wotlisdi"
        "SG3" | "SG3AN" | Tense.PRESENT         | "ologa"
        "SG3" | "SG3AN" | Tense.HABITUAL        | "gologoi"
        "SG3" | "SG3AN" | Tense.REMOTE_PAST     | "uwolotsvi"
        "SG3" | "SG3AN" | Tense.FUTURE_COMMAND      | "olotsvi"
        "SG3" | "SG3AN" | Tense.INFINITIVE      | "uwotlisdi"
        "PL3" | "SG3AN" | Tense.PRESENT         | "anologa"
        "PL3" | "SG3AN" | Tense.HABITUAL        | "anologoi"
        "PL3" | "SG3AN" | Tense.REMOTE_PAST     | "anolotsvi"
        "PL3" | "SG3AN" | Tense.FUTURE_COMMAND      | "anolotsvi"
        "PL3" | "SG3AN" | Tense.INFINITIVE      | "aniwotlisdi"
        "PL1INCL" | "SG3AN" | Tense.PRESENT         | "edologa"
        "PL1INCL" | "SG3AN" | Tense.HABITUAL        | "edologoi"
        "PL1INCL" | "SG3AN" | Tense.REMOTE_PAST     | "olotsvi"
        "PL1INCL" | "SG3AN" | Tense.FUTURE_COMMAND      | "edolotsvi"
        "PL1INCL" | "SG3AN" | Tense.INFINITIVE      | "wotlisdi"
    }
}
