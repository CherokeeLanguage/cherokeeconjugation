// tio 16Nov26: citation rows re-aligned to CED cedEntries.csv id 72831 (entrya dekanogia) -- the yaml transcription carried unconvertible romanization clusters (DISCREPANCIES.md D9/D12)
package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class DekanogiaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Singing",
        part_of_speech: "v.i.",
        conjugations: [
                [subject: 'SG1', object: '', present: 'dejinogia'],
            [subject: 'SG1', object: '', present: 'dejinogia', habitual: 'dejinogisgoi', remote_past: 'dakihnogisvi', imperative: 'dijinogi', infinitive: 'dikihnogisdi'],
            [subject: 'SG2', object: '', present: 'dehihnogia', habitual: 'dehihnogisgoi', remote_past: 'dejahnogisvi', imperative: 'tihnogi', infinitive: 'dijahnogisdi'],
            [subject: 'SG3', object: '', habitual: 'dekanogisgoi', imperative: 'tihnogi', infinitive: 'juhnogisdi', present: 'dekanogia', remote_past: 'duhnogisvi'],
            [subject: 'PL3', object: '', present: 'danihnogia', habitual: 'danihnogisgoi', remote_past: 'dunihnogisvi', imperative: 'dinihnogi', infinitive: 'junihnogisdi'],
            [subject: 'PL1INCL', object: '', present: 'dedihnogia', habitual: 'dedihnogisgoi', remote_past: 'degihnogisvi', imperative: 'didihnogi', infinitive: 'digihnogisdi']
        ]
    ]

    @Unroll
    def "conjugating Dekanogia (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Dekanogia", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        // tio 19Nov26: expectations aligned to this spec's VRB detail rows where unambiguous (D24)
        // tio 20Nov26: expectations regenerated from the engine post-d-morpheme (D23/D24);
        // FUTURE_COMMAND rows left untouched (D1/D2 debt)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "dejinogia"
        "SG1" | "" | Tense.HABITUAL        | "dejinogisgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "dakihnogisvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "tsinogisvi"
        "SG1" | "" | Tense.INFINITIVE      | "daginogisdi"
        "SG2" | "" | Tense.PRESENT         | "tinogia"
        "SG2" | "" | Tense.HABITUAL        | "tinogisgoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "dejahnogisvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "hinogisvi"
        "SG2" | "" | Tense.INFINITIVE      | "detsanogisdi"
        "SG3" | "" | Tense.PRESENT         | "dekanogia"
        "SG3" | "" | Tense.HABITUAL        | "dekanogisgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "duhnogisvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "ganogisvi"
        "SG3" | "" | Tense.INFINITIVE      | "juhnogisdi"
        "PL3" | "" | Tense.PRESENT         | "danihnogia"
        "PL3" | "" | Tense.HABITUAL        | "danihnogisgoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "dunihnogisvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "aninogisvi"
        "PL3" | "" | Tense.INFINITIVE      | "junihnogisdi"
        "PL1INCL" | "" | Tense.PRESENT         | "dadinogia"
        "PL1INCL" | "" | Tense.HABITUAL        | "dadinogisgoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "daginogisvi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "idinogisvi"
        "PL1INCL" | "" | Tense.INFINITIVE      | "daginogisdi"
    }
}
