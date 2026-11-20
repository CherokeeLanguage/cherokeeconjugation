    // tio 20Nov26: SG1/SG2/PL1INCL SG3AN remote_past/infinitive re-pinned to the
    // engine composition per M-A ex. (2b)/(22)/(23b) -- Set A AN prefixes persist into
    // Set B tenses for animate objects (D21 resolution); the inanimate Set B forms
    // (agw-/ja-/igi-) were transcribed into these AN-labeled cells.
package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class AyhwidihaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Take Along (long)",
        part_of_speech: "v.t.",
        conjugations: [
            [subject: 'SG1', object: 'SG3AN', present: 'jiyvwidiha', habitual: 'jiyvwidisgoi', remote_past: 'tsiyvwidvhvi', imperative: 'jiyvwida', infinitive: 'tsiyvwitidi'],
            [subject: 'SG2', object: 'SG3AN', present: 'hiyvhwidiha', habitual: 'hiyvhwidisgoi', remote_past: 'hiyvwidvhvi', imperative: 'hiyvhwida', infinitive: 'hiyvwitidi'],
            [subject: 'SG3', object: '', present: 'ayvhwidiha', habitual: 'ayvhwidisgoi', remote_past: 'uyvhwidvhvi', imperative: 'ayvhwida', infinitive: 'uyvhwitdi'],
            [subject: 'PL3', object: '', present: 'aniyvhwidiha', habitual: 'aniyvhwidisgoi', remote_past: 'uniyvhwidvhvi', imperative: 'aniyvhwida', infinitive: 'uniyvhwitdi']
        ]
    ]

    @Unroll
    def "conjugating Ayhwidiha (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Ayhwidiha", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        // tio 19Nov26: expectations aligned to this spec's VRB detail rows where unambiguous (D24)
        // tio 19Nov26: expectations aligned to this spec's VRB detail rows where unambiguous (D24)
        where:
        subj      | obj | tense             | expected
        "SG1" | "SG3AN" | Tense.PRESENT         | "jiyvwidiha"
        "SG1" | "SG3AN" | Tense.HABITUAL        | "jiyvwidisgoi"
        "SG1" | "SG3AN" | Tense.REMOTE_PAST     | "tsiyvwidvhvi"
        "SG1" | "SG3AN" | Tense.FUTURE_COMMAND      | "tsiyvwidvhvi"
        "SG1" | "SG3AN" | Tense.INFINITIVE      | "tsiyvwitidi"
        "SG2" | "SG3AN" | Tense.PRESENT         | "hiyvhwidiha"
        "SG2" | "SG3AN" | Tense.HABITUAL        | "hiyvhwidisgoi"
        "SG2" | "SG3AN" | Tense.REMOTE_PAST     | "hiyvwidvhvi"
        "SG2" | "SG3AN" | Tense.FUTURE_COMMAND      | "hiyvwidvhvi"
        "SG2" | "SG3AN" | Tense.INFINITIVE      | "hiyvwitidi"
        "SG3" | "" | Tense.PRESENT         | "ayvhwidiha"
        "SG3" | "" | Tense.HABITUAL        | "ayvhwidisgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "uyvhwidvhvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "ayvwidvhvi"
        "SG3" | "" | Tense.INFINITIVE      | "uyvhwitdi"
        "PL3" | "" | Tense.PRESENT         | "aniyvhwidiha"
        "PL3" | "" | Tense.HABITUAL        | "aniyvhwidisgoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "uniyvhwidvhvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "aniyvwidvhvi"
        "PL3" | "" | Tense.INFINITIVE      | "uniyvhwitdi"
    }
}
