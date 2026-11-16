// tio 16Nov26: citation rows re-aligned to CED cedEntries.csv id 72802 (entrya daniyelisga) -- the yaml transcription carried unconvertible romanization clusters (DISCREPANCIES.md D9/D12)
package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class DaniyelisgaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Adjourning",
        part_of_speech: "v.i.",
        conjugations: [
                [subject: 'SG1', object: '', present: 'dojiyelisga'],
            [subject: 'SG1', object: '', present: 'dosdiyelisga', habitual: 'dosdiyelisgoi', remote_past: 'doginiyelisvi', imperative: 'josdiyelihi', infinitive: 'joginiyelihisdi'],
            [subject: 'SG2', object: '', present: 'dojiyelisga', habitual: 'dojiyelisgoi', remote_past: 'dogiyelisvi', imperative: 'jojiyelihi', infinitive: 'jogiyelihisdi'],
            [subject: 'SG3', object: '', habitual: 'daniyelisgoi', imperative: 'dijiyelihi', infinitive: 'juniyelihisdi', present: 'daniyelisga', remote_past: 'duniyelisvi'],
            [subject: 'PL3', object: '', present: 'desdiyelisga', habitual: 'desdiyelisgoi', remote_past: 'desdiyelisvi', imperative: 'disdiyelihi', infinitive: 'disdiyelihisdi'],
            [subject: 'PL1INCL', object: '', present: 'dejiyelisga', habitual: 'dejiyelisgoi', remote_past: 'dejiyelisvi', imperative: 'dijiyelihi', infinitive: 'dijiyelihisdi']
        ]
    ]

    @Unroll
    def "conjugating Daniyelisga (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Daniyelisga", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "ganiyelisga"
        "SG1" | "" | Tense.HABITUAL        | "ganiyelisgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "aquaniyelisvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "ganiyelisvi"
        "SG1" | "" | Tense.INFINITIVE      | "aginiyelihisdi"
        "SG2" | "" | Tense.PRESENT         | "haniyelisga"
        "SG2" | "" | Tense.HABITUAL        | "haniyelisgoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "tsaniyelisvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "haniyelisvi"
        "SG2" | "" | Tense.INFINITIVE      | "tsaniyelihisdi"
        "SG3" | "" | Tense.PRESENT         | "daniyelisga"
        "SG3" | "" | Tense.HABITUAL        | "daniyelisgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "uniyelisvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "aniyelisvi"
        "SG3" | "" | Tense.INFINITIVE      | "uniyelihisdi"
        "PL3" | "" | Tense.PRESENT         | "ananiyelisga"
        "PL3" | "" | Tense.HABITUAL        | "ananiyelisgoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "unaniyelisvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "ananiyelisvi"
        "PL3" | "" | Tense.INFINITIVE      | "uniniyelihisdi"
        "PL1INCL" | "" | Tense.PRESENT         | "idaniyelisga"
        "PL1INCL" | "" | Tense.HABITUAL        | "idaniyelisgoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "iganiyelisvi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "idaniyelisvi"
        "PL1INCL" | "" | Tense.INFINITIVE      | "iginiyelihisdi"
    }
}
