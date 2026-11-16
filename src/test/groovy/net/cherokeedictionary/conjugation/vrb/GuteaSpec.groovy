// tio 16Nov26: citation rows re-aligned to CED cedEntries.csv id 73285 (entrya gutea) -- the yaml transcription carried unconvertible romanization clusters (DISCREPANCIES.md D9/D12)
package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class GuteaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Picking Him/It Up",
        part_of_speech: "v.t.",
        conjugations: [
                [subject: 'SG1', object: '', present: 'jiyutea, gutea'],
            [subject: 'SG1', object: 'SG3AN', present: 'jiyutea', habitual: 'jiyutesgoi', remote_past: 'jiyutesvi', imperative: 'jiyutagi', infinitive: 'jiyutesdi'],
            [subject: 'SG1', object: 'SG3IN', present: 'gutea', habitual: 'gutesgoi', remote_past: 'agwutesvi', imperative: 'gutagi', infinitive: 'agwutesdi'],
            [subject: 'SG2', object: 'SG3AN', present: 'hiyutea', habitual: 'hiyutesgoi', remote_past: 'hiyutesvi', imperative: 'hiyutagi', infinitive: 'hiyutesdi'],
            [subject: 'SG2', object: 'SG3IN', present: 'hutea', habitual: 'hutesgoi', remote_past: 'jutesvi', imperative: 'hutagi', infinitive: 'jutesdi'],
            [subject: 'SG3', object: '', habitual: 'gutesgoi', imperative: 'hyutagi, hutagi', infinitive: 'uwutesdi', present: 'gutea', remote_past: 'uwutesvi'],
            [subject: 'PL3', object: 'SG3IN', present: 'anutea', habitual: 'anutesgoi', remote_past: 'unutesvi', imperative: 'anutagi', infinitive: 'unutesdi'],
            [subject: 'PL1INCL', object: 'SG3IN', present: 'idutea', habitual: 'idutesgoi', remote_past: 'igutesvi', imperative: 'idutagi', infinitive: 'igutesdi']
        ]
    ]

    @Unroll
    def "conjugating Gutea (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Gutea", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "SG3AN" | Tense.PRESENT         | "tsiyutea"
        "SG1" | "SG3AN" | Tense.HABITUAL        | "tsiyutesgoi"
        "SG1" | "SG3AN" | Tense.REMOTE_PAST     | "tsiyutesvi"
        "SG1" | "SG3AN" | Tense.FUTURE_COMMAND      | "tsiyutesvi"
        "SG1" | "SG3AN" | Tense.INFINITIVE      | "tsiwutesdi"
        "SG1" | "SG3IN" | Tense.PRESENT         | "gutea"
        "SG1" | "SG3IN" | Tense.HABITUAL        | "gutesgoi"
        "SG1" | "SG3IN" | Tense.REMOTE_PAST     | "aquutesvi"
        "SG1" | "SG3IN" | Tense.FUTURE_COMMAND      | "gutesvi"
        "SG1" | "SG3IN" | Tense.INFINITIVE      | "agiwutesdi"
        "SG2" | "SG3AN" | Tense.PRESENT         | "hiyutea"
        "SG2" | "SG3AN" | Tense.HABITUAL        | "hiyutesgoi"
        "SG2" | "SG3AN" | Tense.REMOTE_PAST     | "utesvi"
        "SG2" | "SG3AN" | Tense.FUTURE_COMMAND      | "hiyutesvi"
        "SG2" | "SG3AN" | Tense.INFINITIVE      | "wutesdi"
        "SG2" | "SG3IN" | Tense.PRESENT         | "hutea"
        "SG2" | "SG3IN" | Tense.HABITUAL        | "hutesgoi"
        "SG2" | "SG3IN" | Tense.REMOTE_PAST     | "tsutesvi"
        "SG2" | "SG3IN" | Tense.FUTURE_COMMAND      | "hutesvi"
        "SG2" | "SG3IN" | Tense.INFINITIVE      | "tsawutesdi"
        "SG3" | "SG3IN" | Tense.PRESENT         | "gutea"
        "SG3" | "SG3IN" | Tense.HABITUAL        | "gutesgoi"
        "SG3" | "SG3IN" | Tense.REMOTE_PAST     | "uwutesvi"
        "SG3" | "SG3IN" | Tense.FUTURE_COMMAND      | "utesvi"
        "SG3" | "SG3IN" | Tense.INFINITIVE      | "uwutesdi"
        "PL3" | "SG3IN" | Tense.PRESENT         | "anutea"
        "PL3" | "SG3IN" | Tense.HABITUAL        | "anutesgoi"
        "PL3" | "SG3IN" | Tense.REMOTE_PAST     | "unutesvi"
        "PL3" | "SG3IN" | Tense.FUTURE_COMMAND      | "anutesvi"
        "PL3" | "SG3IN" | Tense.INFINITIVE      | "uniwutesdi"
        "PL1INCL" | "SG3IN" | Tense.PRESENT         | "idutea"
        "PL1INCL" | "SG3IN" | Tense.HABITUAL        | "idutesgoi"
        "PL1INCL" | "SG3IN" | Tense.REMOTE_PAST     | "igutesvi"
        "PL1INCL" | "SG3IN" | Tense.FUTURE_COMMAND      | "idutesvi"
        "PL1INCL" | "SG3IN" | Tense.INFINITIVE      | "igiwutesdi"
    }
}
