// tio 16Nov26: citation rows re-aligned to CED cedEntries.csv id 73869 (entrya ulidasdiha) -- the yaml transcription carried unconvertible romanization clusters (DISCREPANCIES.md D9/D12)
package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class UlidasdihaSpec extends VerbBaseSpec {
    static def details = [
        definition: "S/hes Making a Mistake",
        part_of_speech: "v.i.",
        conjugations: [
                [subject: 'SG1', object: '', present: 'agilidasdiha'],
            [subject: 'SG1', object: '', present: 'agilidasdiha', habitual: 'agilidasdisgoi', remote_past: 'agilidastanvi', imperative: 'agilidasda', infinitive: 'agilidasdohdi'],
            [subject: 'SG2', object: '', present: 'jalidasdiha', habitual: 'jalidasdisgoi', remote_past: 'jalidastanvi', imperative: 'jalidasda', infinitive: 'jalidasdohdi'],
            [subject: 'SG3', object: '', habitual: 'ulidasdisgoi', imperative: 'jalidasda', infinitive: 'ulidasdohdi', present: 'ulidasdiha', remote_past: 'ulidastanvi'],
            [subject: 'PL3', object: '', present: 'uniladasdiha', habitual: 'unilidasdisgoi', remote_past: 'unilidastanvi', imperative: 'unilidasda', infinitive: 'unilidasdohdi'],
            [subject: 'PL1INCL', object: '', present: 'igiladasdiha', habitual: 'igilidasdisgoi', remote_past: 'igilidastanvi', imperative: 'igilidasda', infinitive: 'igilidasdohdi']
        ]
    ]

    @Unroll
    def "conjugating Ulidasdiha (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Ulidasdiha", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "agilidasdiha"
        "SG1" | "" | Tense.HABITUAL        | "agilidasdisgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "agilidastanvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "agilidastanvi"
        "SG1" | "" | Tense.INFINITIVE      | "agilidasdodi"
        "SG2" | "" | Tense.PRESENT         | "tsalidasdiha"
        "SG2" | "" | Tense.HABITUAL        | "tsalidasdisgoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "tsalidastanvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "tsalidastanvi"
        "SG2" | "" | Tense.INFINITIVE      | "tsalidasdodi"
        "SG3" | "" | Tense.PRESENT         | "ulidasdiha"
        "SG3" | "" | Tense.HABITUAL        | "ulidasdisgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "ulidastanvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "ulidastanvi"
        "SG3" | "" | Tense.INFINITIVE      | "ulidasdodi"
        "PL3" | "" | Tense.PRESENT         | "unilidasdiha"
        "PL3" | "" | Tense.HABITUAL        | "unilidasdisgoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "unilidastanvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "unilidastanvi"
        "PL3" | "" | Tense.INFINITIVE      | "unilidasdodi"
        "PL1INCL" | "" | Tense.PRESENT         | "igilidasdiha"
        "PL1INCL" | "" | Tense.HABITUAL        | "igilidasdisgoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "igilidastanvi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "igilidastanvi"
        "PL1INCL" | "" | Tense.INFINITIVE      | "igilidasdodi"
    }
}
