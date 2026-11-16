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
        "SG1" | "" | Tense.PRESENT         | "tsinogisdiha"
        "SG1" | "" | Tense.HABITUAL        | "tsinogisdisgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "aginogistanvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "tsinogistanvi"
        "SG1" | "" | Tense.INFINITIVE      | "aginogisdodi"
        "SG2" | "" | Tense.PRESENT         | "hinogisdiha"
        "SG2" | "" | Tense.HABITUAL        | "hinogisdisgoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "tsanogistanvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "hinogistanvi"
        "SG2" | "" | Tense.INFINITIVE      | "tsanogisdodi"
        "SG3" | "" | Tense.PRESENT         | "dekanogisdiha"
        "SG3" | "" | Tense.HABITUAL        | "dekanogisdisgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "unogistanvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "ganogistanvi"
        "SG3" | "" | Tense.INFINITIVE      | "unogisdodi"
        "PL3" | "" | Tense.PRESENT         | "aninogisdiha"
        "PL3" | "" | Tense.HABITUAL        | "aninogisdisgoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "uninogistanvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "aninogistanvi"
        "PL3" | "" | Tense.INFINITIVE      | "uninogisdodi"
        "PL1INCL" | "" | Tense.PRESENT         | "idinogisdiha"
        "PL1INCL" | "" | Tense.HABITUAL        | "idinogisdisgoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "iginogistanvi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "idinogistanvi"
        "PL1INCL" | "" | Tense.INFINITIVE      | "iginogisdodi"
    }
}
