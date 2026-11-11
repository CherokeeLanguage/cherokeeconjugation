package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class DekanogisdihaSpec extends VerbBaseSpec {
    static def details = [
        definition: "S/hes Playing Music",
        part_of_speech: "v.i.",
        conjugations: [
            [subject: 'SG1', object: '', present: 'dejinogisdiha', habitual: 'dejinogisdisgoi', remote_past: 'dakinogistanvi', imperative: 'dijinogisda', infinitive: 'dikihnogisdohdi'],
            [subject: 'SG2', object: '', present: 'dehihnogisdiha', habitual: 'dehihnogisdisgoi', remote_past: 'dechanogistanvi', imperative: 'tihnogisda', infinitive: 'dichanogisdohdi'],
            [subject: 'SG3', object: '', present: 'dekanogisdiha', habitual: 'dekanogisdisgoi', remote_past: 'duhnogistanvi', imperative: 'dikanogisda', infinitive: 'juhnogisdohdi'],
            [subject: 'PL3', object: '', present: 'danihnogisdiha', habitual: 'danihnogisdisgoi', remote_past: 'dunihnogistanvi', imperative: 'dinihnogisda', infinitive: 'junihnogisdohdi'],
            [subject: 'PL1INCL', object: '', present: 'dedihnogisdiha', habitual: 'dedihnogisdisgoi', remote_past: 'degihnogistanvi', imperative: 'didihnogisda', infinitive: 'digihnogisdohdi']
        ]
    ]

    @Unroll
    def "conjugating Dekanogisdiha (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Dekanogisdiha", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "dejinogisdiha"
        "SG1" | "" | Tense.HABITUAL        | "dejinogisdisgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "dakinogistanvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "dijinogisda"
        "SG1" | "" | Tense.INFINITIVE      | "dikihnogisdohdi"
        "SG2" | "" | Tense.PRESENT         | "dehihnogisdiha"
        "SG2" | "" | Tense.HABITUAL        | "dehihnogisdisgoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "dechanogistanvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "tihnogisda"
        "SG2" | "" | Tense.INFINITIVE      | "dichanogisdohdi"
        "SG3" | "" | Tense.PRESENT         | "dekanogisdiha"
        "SG3" | "" | Tense.HABITUAL        | "dekanogisdisgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "duhnogistanvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "dikanogisda"
        "SG3" | "" | Tense.INFINITIVE      | "juhnogisdohdi"
        "PL3" | "" | Tense.PRESENT         | "danihnogisdiha"
        "PL3" | "" | Tense.HABITUAL        | "danihnogisdisgoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "dunihnogistanvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "dinihnogisda"
        "PL3" | "" | Tense.INFINITIVE      | "junihnogisdohdi"
        "PL1INCL" | "" | Tense.PRESENT         | "dedihnogisdiha"
        "PL1INCL" | "" | Tense.HABITUAL        | "dedihnogisdisgoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "degihnogistanvi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "didihnogisda"
        "PL1INCL" | "" | Tense.INFINITIVE      | "digihnogisdohdi"
    }
}
