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
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "tsinogia"
        "SG1" | "" | Tense.HABITUAL        | "tsinogisgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "aginogisvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "tsinogisvi"
        "SG1" | "" | Tense.INFINITIVE      | "aginogisdi"
        "SG2" | "" | Tense.PRESENT         | "hinogia"
        "SG2" | "" | Tense.HABITUAL        | "hinogisgoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "tsanogisvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "hinogisvi"
        "SG2" | "" | Tense.INFINITIVE      | "tsanogisdi"
        "SG3" | "" | Tense.PRESENT         | "dekanogia"
        "SG3" | "" | Tense.HABITUAL        | "dekanogisgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "unogisvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "ganogisvi"
        "SG3" | "" | Tense.INFINITIVE      | "unogisdi"
        "PL3" | "" | Tense.PRESENT         | "aninogia"
        "PL3" | "" | Tense.HABITUAL        | "aninogisgoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "uninogisvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "aninogisvi"
        "PL3" | "" | Tense.INFINITIVE      | "uninogisdi"
        "PL1INCL" | "" | Tense.PRESENT         | "idinogia"
        "PL1INCL" | "" | Tense.HABITUAL        | "idinogisgoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "iginogisvi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "idinogisvi"
        "PL1INCL" | "" | Tense.INFINITIVE      | "iginogisdi"
    }
}
