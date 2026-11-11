package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class GalonuhehaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Cheating",
        part_of_speech: "v.i.",
        conjugations: [
            [subject: 'SG1', object: '', present: 'jilonueha', habitual: 'jilonuesgoi', remote_past: 'agilonuhehlvi', imperative: 'jilonuvla', infinitive: 'agilonuhehdi'],
            [subject: 'SG2', object: '', present: 'hilonuheha', habitual: 'hilonuhesgoi', remote_past: 'jalonuhehlvi', imperative: 'hilonuhvla', infinitive: 'jalonuhehdi'],
            [subject: 'SG3', object: '', present: 'galonuheha', habitual: 'galonuhesgoi', remote_past: 'ulonuhehlvi', imperative: 'galonuhvla', infinitive: 'ulonuhehdi'],
            [subject: 'PL3', object: '', present: 'anilonuheha', habitual: 'anilonuhesgoi', remote_past: 'unilonuhehlvi', imperative: 'anilonuhvla', infinitive: 'unilonuhehdi'],
            [subject: 'PL1INCL', object: '', present: 'idilonuheha', habitual: 'idilonuhesgoi', remote_past: 'igilonuhehlvi', imperative: 'idilonuhvla', infinitive: 'igilonuhehdi']
        ]
    ]

    @Unroll
    def "conjugating Galonuheha (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Galonuheha", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "jilonueha"
        "SG1" | "" | Tense.HABITUAL        | "jilonuesgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "agilonuhehlvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "jilonuvla"
        "SG1" | "" | Tense.INFINITIVE      | "agilonuhehdi"
        "SG2" | "" | Tense.PRESENT         | "hilonuheha"
        "SG2" | "" | Tense.HABITUAL        | "hilonuhesgoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "jalonuhehlvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "hilonuhvla"
        "SG2" | "" | Tense.INFINITIVE      | "jalonuhehdi"
        "SG3" | "" | Tense.PRESENT         | "galonuheha"
        "SG3" | "" | Tense.HABITUAL        | "galonuhesgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "ulonuhehlvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "galonuhvla"
        "SG3" | "" | Tense.INFINITIVE      | "ulonuhehdi"
        "PL3" | "" | Tense.PRESENT         | "anilonuheha"
        "PL3" | "" | Tense.HABITUAL        | "anilonuhesgoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "unilonuhehlvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "anilonuhvla"
        "PL3" | "" | Tense.INFINITIVE      | "unilonuhehdi"
        "PL1INCL" | "" | Tense.PRESENT         | "idilonuheha"
        "PL1INCL" | "" | Tense.HABITUAL        | "idilonuhesgoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "igilonuhehlvi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "idilonuhvla"
        "PL1INCL" | "" | Tense.INFINITIVE      | "igilonuhehdi"
    }
}
