package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class DaksvsdihaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Hes Making/Blowing Smoke (71)*",
        part_of_speech: "v.i.",
        conjugations: [
            [subject: 'SG1', object: '', present: 'dejigasvsdiha', habitual: 'dejigasvsdisgoi', remote_past: 'dagiksvstanvi', imperative: 'dijiksvsda', infinitive: 'digiksvsdohdi'],
            [subject: 'SG2', object: '', present: 'dehiksvsdiha', habitual: 'dehiksvsdisgoi', remote_past: 'dejaksvstanvi', imperative: 'tiksvsda', infinitive: 'dijaksvsdohdi'],
            [subject: 'SG3', object: '', present: 'daksvsdiha', habitual: 'daksvsdisgoi', remote_past: 'duksvstanvi', imperative: 'diksvsda', infinitive: 'juksvsdohdi'],
            [subject: 'PL3', object: '', present: 'daniksvsdiha', habitual: 'daniksvsdisgoi', remote_past: 'duniksvstanvi', imperative: 'diniksvsda', infinitive: 'juniksvsdohdi'],
            [subject: 'PL1INCL', object: '', present: 'dediksvsdiha', habitual: 'dediksvsdisgoi', remote_past: 'degiksvstanvi', imperative: 'didiksvsda', infinitive: 'digiksvsdohdi']
        ]
    ]

    @Unroll
    def "conjugating Daksvsdiha (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Daksvsdiha", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "dejigasvsdiha"
        "SG1" | "" | Tense.HABITUAL        | "dejigasvsdisgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "dagiksvstanvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "dijiksvsda"
        "SG1" | "" | Tense.INFINITIVE      | "digiksvsdohdi"
        "SG2" | "" | Tense.PRESENT         | "dehiksvsdiha"
        "SG2" | "" | Tense.HABITUAL        | "dehiksvsdisgoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "dejaksvstanvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "tiksvsda"
        "SG2" | "" | Tense.INFINITIVE      | "dijaksvsdohdi"
        "SG3" | "" | Tense.PRESENT         | "daksvsdiha"
        "SG3" | "" | Tense.HABITUAL        | "daksvsdisgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "duksvstanvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "diksvsda"
        "SG3" | "" | Tense.INFINITIVE      | "juksvsdohdi"
        "PL3" | "" | Tense.PRESENT         | "daniksvsdiha"
        "PL3" | "" | Tense.HABITUAL        | "daniksvsdisgoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "duniksvstanvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "diniksvsda"
        "PL3" | "" | Tense.INFINITIVE      | "juniksvsdohdi"
        "PL1INCL" | "" | Tense.PRESENT         | "dediksvsdiha"
        "PL1INCL" | "" | Tense.HABITUAL        | "dediksvsdisgoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "degiksvstanvi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "didiksvsda"
        "PL1INCL" | "" | Tense.INFINITIVE      | "digiksvsdohdi"
    }
}
