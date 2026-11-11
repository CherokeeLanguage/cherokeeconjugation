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
            [subject: 'SG1', object: '', present: 'gatosadia', habitual: 'gatosadisgoi', remote_past: 'agwatosadvi', imperative: 'gatosada', infinitive: 'aktosadisdi'],
            [subject: 'SG2', object: '', present: 'hatosadia', habitual: 'hatosadisgoi', remote_past: 'jatosadvi', imperative: 'hatosada', infinitive: 'jatosadisdi'],
            [subject: 'SG3', object: '', present: 'ktosadia', habitual: 'ktosadisgoi', remote_past: 'utosadvi', imperative: 'wiktosada', infinitive: 'uwatosadisdi'],
            [subject: 'SG3', object: '', present: 'anatosadia', habitual: 'anatosadisgoi', remote_past: 'unatosadvi', imperative: 'wanatosada', infinitive: 'unatosadisdi']
        ]
    ]

    @Unroll
    def "conjugating Ktosadia (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Ktosadia", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "gatosadia"
        "SG1" | "" | Tense.HABITUAL        | "gatosadisgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "agwatosadvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "gatosada"
        "SG1" | "" | Tense.INFINITIVE      | "aktosadisdi"
        "SG2" | "" | Tense.PRESENT         | "hatosadia"
        "SG2" | "" | Tense.HABITUAL        | "hatosadisgoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "jatosadvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "hatosada"
        "SG2" | "" | Tense.INFINITIVE      | "jatosadisdi"
        "SG3" | "" | Tense.PRESENT         | "ktosadia"
        "SG3" | "" | Tense.HABITUAL        | "ktosadisgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "utosadvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "wiktosada"
        "SG3" | "" | Tense.INFINITIVE      | "uwatosadisdi"
        "SG3" | "" | Tense.PRESENT         | "anatosadia"
        "SG3" | "" | Tense.HABITUAL        | "anatosadisgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "unatosadvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "wanatosada"
        "SG3" | "" | Tense.INFINITIVE      | "unatosadisdi"
    }
}
