// tio 16Nov26: citation rows re-aligned to CED cedEntries.csv id 73534 (entrya ktosadia) -- the yaml transcription carried unconvertible romanization clusters (DISCREPANCIES.md D9/D12)
package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class KtosadiaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Hang Up (long)",
        part_of_speech: "v.i.",
        conjugations: [
                [subject: 'SG1', object: '', present: 'gatosadia'],
            [subject: 'SG1', object: '', present: 'gatosadia', habitual: 'gatosadisgoi', remote_past: 'agwatosadvi', imperative: 'gatosada', infinitive: 'aktosadisdi'],
            [subject: 'SG2', object: '', present: 'hatosadia', habitual: 'hatosadisgoi', remote_past: 'jatosadvi', imperative: 'hatosada', infinitive: 'jatosadisdi'],
            [subject: 'SG3', object: '', habitual: 'ktosadisgoi', imperative: 'hatosada', infinitive: 'uwhtosadisdi', present: 'ktosadia', remote_past: 'uwhtosadvi'],
            [subject: 'SG3', object: '', present: 'anatosadia', habitual: 'anatosadisgoi', remote_past: 'unatosadvi', imperative: 'wanatosada', infinitive: 'unatosadisdi']
        ]
    ]

    @Unroll
    def "conjugating Ktosadia (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Ktosadia", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "tsigidosadia"
        "SG1" | "" | Tense.HABITUAL        | "tsigidosadisgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "aquuwedosadvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "guwedosadvi"
        "SG1" | "" | Tense.INFINITIVE      | "agiwedosadisdi"
        "SG2" | "" | Tense.PRESENT         | "higidosadia"
        "SG2" | "" | Tense.HABITUAL        | "higidosadisgoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "tsuwedosadvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "huwedosadvi"
        "SG2" | "" | Tense.INFINITIVE      | "tsawedosadisdi"
        "SG3" | "" | Tense.PRESENT         | "gidosadia"
        "SG3" | "" | Tense.HABITUAL        | "gidosadisgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "uwuwedosadvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "uwedosadvi"
        "SG3" | "" | Tense.INFINITIVE      | "uwedosadisdi"
        "SG3" | "" | Tense.PRESENT         | "gidosadia"
        "SG3" | "" | Tense.HABITUAL        | "gidosadisgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "uwuwedosadvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "uwedosadvi"
        "SG3" | "" | Tense.INFINITIVE      | "uwedosadisdi"
    }
}
