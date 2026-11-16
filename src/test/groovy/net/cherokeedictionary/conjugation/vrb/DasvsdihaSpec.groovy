// tio 16Nov26: citation rows re-aligned to CED cedEntries.csv id 72811 (entrya dasvsdiha) -- the yaml transcription carried unconvertible romanization clusters (DISCREPANCIES.md D9/D12)
package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class DasvsdihaSpec extends VerbBaseSpec {
    static def details = [
        definition: "S/hes Scheduling a Time / Planning It",
        part_of_speech: "v.i.",
        conjugations: [
                [subject: 'SG1', object: '', present: 'dejisvsdiha'],
            [subject: 'SG1', object: '', present: 'dejisvsdiha', habitual: 'dejisvsdisgoi', remote_past: 'daksvstanvi', imperative: 'dijisvsda', infinitive: 'diksvsdohdi'],
            [subject: 'SG2', object: '', present: 'dehisvsdiha', habitual: 'dehisvsdisgoi', remote_past: 'detsvstanvi', imperative: 'tisvsda', infinitive: 'ditsvsdohdi'],
            [subject: 'SG3', object: '', habitual: 'dasvsdisgoi', imperative: 'tisvsda', infinitive: 'jusvsdohdi', present: 'dasvsdiha', remote_past: 'dusvstanvi'],
            [subject: 'PL3', object: '', present: 'danisvsdiha', habitual: 'danisvsdisgoi', remote_past: 'dunisvstanvi', imperative: 'dinisvsda', infinitive: 'junisvsdohdi'],
            [subject: 'PL1INCL', object: '', present: 'dedisvsdiha', habitual: 'dedisvsdisgoi', remote_past: 'degisvstanvi', imperative: 'didisvsda', infinitive: 'digisvsdohdi']
        ]
    ]

    @Unroll
    def "conjugating Dasvsdiha (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Dasvsdiha", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "tsisvsdiha"
        "SG1" | "" | Tense.HABITUAL        | "tsisvsdisgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "agisvstanvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "tsisvstanvi"
        "SG1" | "" | Tense.INFINITIVE      | "agisvsdodi"
        "SG2" | "" | Tense.PRESENT         | "hisvsdiha"
        "SG2" | "" | Tense.HABITUAL        | "hisvsdisgoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "tsasvstanvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "hisvstanvi"
        "SG2" | "" | Tense.INFINITIVE      | "tsasvsdodi"
        "SG3" | "" | Tense.PRESENT         | "dasvsdiha"
        "SG3" | "" | Tense.HABITUAL        | "dasvsdisgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "usvstanvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "gasvstanvi"
        "SG3" | "" | Tense.INFINITIVE      | "usvsdodi"
        "PL3" | "" | Tense.PRESENT         | "anisvsdiha"
        "PL3" | "" | Tense.HABITUAL        | "anisvsdisgoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "unisvstanvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "anisvstanvi"
        "PL3" | "" | Tense.INFINITIVE      | "unisvsdodi"
        "PL1INCL" | "" | Tense.PRESENT         | "idisvsdiha"
        "PL1INCL" | "" | Tense.HABITUAL        | "idisvsdisgoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "igisvstanvi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "idisvstanvi"
        "PL1INCL" | "" | Tense.INFINITIVE      | "igisvsdodi"
    }
}
