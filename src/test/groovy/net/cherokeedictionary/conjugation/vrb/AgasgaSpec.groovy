package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class AgasgaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Raining (It is)",
        part_of_speech: "v.i.",
        conjugations: [
            [subject: 'SG3', object: '', present: 'agasga', habitual: 'agasgoi', remote_past: 'ugahnanvi', imperative: 'dvgahvnani', infinitive: 'uganhdi']
        ]
    ]

    @Unroll
    def "conjugating Agasga (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Agasga", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG3" | "" | Tense.PRESENT         | "agasga"
        "SG3" | "" | Tense.HABITUAL        | "agasgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "ugahnanvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "dvgahvnani"
        "SG3" | "" | Tense.INFINITIVE      | "uganhdi"
    }
}
