package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class UlvkwdiSpec extends VerbBaseSpec {
    static def details = [
        definition: "Like (It)",
        part_of_speech: "v.t.",
        conjugations: [
            [subject: 'SG1', object: 'SG3AN', present: 'jilvgwodi', habitual: 'jilvgwodoi', remote_past: 'jilvgwotanvi', imperative: 'jilvgwoda', infinitive: 'jilvgwodohdi'],
            [subject: 'SG1', object: 'SG3IN', present: 'agilvkwdi', habitual: 'agilvkwdoi', remote_past: 'agilvkwtanvi', imperative: 'jilvkwda', infinitive: 'agilvkwdohdi'],
            [subject: 'SG2', object: 'SG3AN', present: 'hilvgwodi', habitual: 'hilvgwodoi', remote_past: 'hilvgwotanvi', imperative: 'hilvgwoda', infinitive: 'hilvgwodohdi'],
            [subject: 'SG2', object: 'SG3IN', present: 'jalvkwdi', habitual: 'jalvkwdoi', remote_past: 'jalvkwtanvi', imperative: 'hilvkwda', infinitive: 'jalvkwdohdi'],
            [subject: 'SG3', object: 'SG3IN', present: 'ulvkwdi', habitual: 'ulvkwdoi', remote_past: 'ulvkwtanvi', imperative: 'ulvkwda', infinitive: 'ulvkwdohdi'],
            [subject: 'PL3', object: 'SG3IN', present: 'unilvkwdi', habitual: 'unilvkwdoi', remote_past: 'unilvkwtanvi', imperative: 'unilvkwda', infinitive: 'unilvkwdohdi'],
            [subject: 'PL1INCL', object: 'SG3IN', present: 'igilvkwdi', habitual: 'igilvkwdoi', remote_past: 'igilvkwtanvi', imperative: 'igilvkwda', infinitive: 'igilvkwdohdi']
        ]
    ]

    @Unroll
    def "conjugating Ulvkwdi (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Ulvkwdi", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "SG3AN" | Tense.PRESENT         | "jilvgwodi"
        "SG1" | "SG3AN" | Tense.HABITUAL        | "jilvgwodoi"
        "SG1" | "SG3AN" | Tense.REMOTE_PAST     | "jilvgwotanvi"
        "SG1" | "SG3AN" | Tense.FUTURE_COMMAND      | "jilvgwoda"
        "SG1" | "SG3AN" | Tense.INFINITIVE      | "jilvgwodohdi"
        "SG1" | "SG3IN" | Tense.PRESENT         | "agilvkwdi"
        "SG1" | "SG3IN" | Tense.HABITUAL        | "agilvkwdoi"
        "SG1" | "SG3IN" | Tense.REMOTE_PAST     | "agilvkwtanvi"
        "SG1" | "SG3IN" | Tense.FUTURE_COMMAND      | "jilvkwda"
        "SG1" | "SG3IN" | Tense.INFINITIVE      | "agilvkwdohdi"
        "SG2" | "SG3AN" | Tense.PRESENT         | "hilvgwodi"
        "SG2" | "SG3AN" | Tense.HABITUAL        | "hilvgwodoi"
        "SG2" | "SG3AN" | Tense.REMOTE_PAST     | "hilvgwotanvi"
        "SG2" | "SG3AN" | Tense.FUTURE_COMMAND      | "hilvgwoda"
        "SG2" | "SG3AN" | Tense.INFINITIVE      | "hilvgwodohdi"
        "SG2" | "SG3IN" | Tense.PRESENT         | "jalvkwdi"
        "SG2" | "SG3IN" | Tense.HABITUAL        | "jalvkwdoi"
        "SG2" | "SG3IN" | Tense.REMOTE_PAST     | "jalvkwtanvi"
        "SG2" | "SG3IN" | Tense.FUTURE_COMMAND      | "hilvkwda"
        "SG2" | "SG3IN" | Tense.INFINITIVE      | "jalvkwdohdi"
        "SG3" | "SG3IN" | Tense.PRESENT         | "ulvkwdi"
        "SG3" | "SG3IN" | Tense.HABITUAL        | "ulvkwdoi"
        "SG3" | "SG3IN" | Tense.REMOTE_PAST     | "ulvkwtanvi"
        "SG3" | "SG3IN" | Tense.FUTURE_COMMAND      | "ulvkwda"
        "SG3" | "SG3IN" | Tense.INFINITIVE      | "ulvkwdohdi"
        "PL3" | "SG3IN" | Tense.PRESENT         | "unilvkwdi"
        "PL3" | "SG3IN" | Tense.HABITUAL        | "unilvkwdoi"
        "PL3" | "SG3IN" | Tense.REMOTE_PAST     | "unilvkwtanvi"
        "PL3" | "SG3IN" | Tense.FUTURE_COMMAND      | "unilvkwda"
        "PL3" | "SG3IN" | Tense.INFINITIVE      | "unilvkwdohdi"
        "PL1INCL" | "SG3IN" | Tense.PRESENT         | "igilvkwdi"
        "PL1INCL" | "SG3IN" | Tense.HABITUAL        | "igilvkwdoi"
        "PL1INCL" | "SG3IN" | Tense.REMOTE_PAST     | "igilvkwtanvi"
        "PL1INCL" | "SG3IN" | Tense.FUTURE_COMMAND      | "igilvkwda"
        "PL1INCL" | "SG3IN" | Tense.INFINITIVE      | "igilvkwdohdi"
    }
}
