// tio 16Nov26: citation rows re-aligned to CED cedEntries.csv id 73269 (entrya gudalea) -- the yaml transcription carried unconvertible romanization clusters (DISCREPANCIES.md D9/D12)
package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class GudaleaSpec extends VerbBaseSpec {
    static def details = [
        definition: "S/hes Unhitching/Unplugging/Unhooking It",
        part_of_speech: "v.t.",
        conjugations: [
                [subject: 'SG1', object: '', present: 'jiyudalea, gudalea'],
            [subject: 'SG1', object: 'SG3AN', present: 'jiyudalea', habitual: 'jiyudalesgoi', remote_past: 'jiyudalesvi', imperative: 'Jiyudalagi', infinitive: 'jiyudalesdi'],
            [subject: 'SG1', object: 'SG3IN', present: 'gudalea', habitual: 'gudalesgoi', remote_past: 'agwudalesvi', imperative: 'gudalagi', infinitive: 'agwudalesdi'],
            [subject: 'SG2', object: 'SG3AN', present: 'hiyudalea', habitual: 'hiyudalesgoi', remote_past: 'hiyudalesvi', imperative: 'Hiyudalagi', infinitive: 'hiyudalesdi'],
            [subject: 'SG2', object: 'SG3IN', present: 'hudalea', habitual: 'hudalesgoi', remote_past: 'judalesvi', imperative: 'hudalagi', infinitive: 'judalesdi'],
            [subject: 'SG3', object: '', habitual: 'gudalesgoi', imperative: 'hiyudalagi, hudalagi', infinitive: 'uwudalesdi', present: 'gudalea', remote_past: 'uwudalesvi'],
            [subject: 'PL3', object: 'SG3IN', present: 'anudalea', habitual: 'anudalesgoi', remote_past: 'unudalesvi', imperative: 'anudalagi', infinitive: 'unudalesdi'],
            [subject: 'PL1INCL', object: 'SG3IN', present: 'idudalea', habitual: 'idudalesgoi', remote_past: 'igudalesvi', imperative: 'idudalagi', infinitive: 'igudalesdi']
        ]
    ]

    @Unroll
    def "conjugating Gudalea (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Gudalea", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "SG3AN" | Tense.PRESENT         | "tsiyudalea"
        "SG1" | "SG3AN" | Tense.HABITUAL        | "tsiyudalesgoi"
        "SG1" | "SG3AN" | Tense.REMOTE_PAST     | "tsiyudalesvi"
        "SG1" | "SG3AN" | Tense.FUTURE_COMMAND      | "tsiyudalesvi"
        "SG1" | "SG3AN" | Tense.INFINITIVE      | "tsiwudalesdi"
        "SG1" | "SG3IN" | Tense.PRESENT         | "gudalea"
        "SG1" | "SG3IN" | Tense.HABITUAL        | "gudalesgoi"
        "SG1" | "SG3IN" | Tense.REMOTE_PAST     | "aquudalesvi"
        "SG1" | "SG3IN" | Tense.FUTURE_COMMAND      | "gudalesvi"
        "SG1" | "SG3IN" | Tense.INFINITIVE      | "agiwudalesdi"
        "SG2" | "SG3AN" | Tense.PRESENT         | "hiyudalea"
        "SG2" | "SG3AN" | Tense.HABITUAL        | "hiyudalesgoi"
        "SG2" | "SG3AN" | Tense.REMOTE_PAST     | "udalesvi"
        "SG2" | "SG3AN" | Tense.FUTURE_COMMAND      | "hiyudalesvi"
        "SG2" | "SG3AN" | Tense.INFINITIVE      | "wudalesdi"
        "SG2" | "SG3IN" | Tense.PRESENT         | "hudalea"
        "SG2" | "SG3IN" | Tense.HABITUAL        | "hudalesgoi"
        "SG2" | "SG3IN" | Tense.REMOTE_PAST     | "tsudalesvi"
        "SG2" | "SG3IN" | Tense.FUTURE_COMMAND      | "hudalesvi"
        "SG2" | "SG3IN" | Tense.INFINITIVE      | "tsawudalesdi"
        "SG3" | "SG3IN" | Tense.PRESENT         | "gudalea"
        "SG3" | "SG3IN" | Tense.HABITUAL        | "gudalesgoi"
        "SG3" | "SG3IN" | Tense.REMOTE_PAST     | "uwudalesvi"
        "SG3" | "SG3IN" | Tense.FUTURE_COMMAND      | "udalesvi"
        "SG3" | "SG3IN" | Tense.INFINITIVE      | "uwudalesdi"
        "PL3" | "SG3IN" | Tense.PRESENT         | "anudalea"
        "PL3" | "SG3IN" | Tense.HABITUAL        | "anudalesgoi"
        "PL3" | "SG3IN" | Tense.REMOTE_PAST     | "unudalesvi"
        "PL3" | "SG3IN" | Tense.FUTURE_COMMAND      | "anudalesvi"
        "PL3" | "SG3IN" | Tense.INFINITIVE      | "uniwudalesdi"
        "PL1INCL" | "SG3IN" | Tense.PRESENT         | "idudalea"
        "PL1INCL" | "SG3IN" | Tense.HABITUAL        | "idudalesgoi"
        "PL1INCL" | "SG3IN" | Tense.REMOTE_PAST     | "igudalesvi"
        "PL1INCL" | "SG3IN" | Tense.FUTURE_COMMAND      | "idudalesvi"
        "PL1INCL" | "SG3IN" | Tense.INFINITIVE      | "igiwudalesdi"
    }
}
