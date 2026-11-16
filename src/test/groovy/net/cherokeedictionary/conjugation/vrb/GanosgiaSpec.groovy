// tio 16Nov26: citation rows re-aligned to CED cedEntries.csv id 73147 (entrya ganosgia) -- the yaml transcription carried unconvertible romanization clusters (DISCREPANCIES.md D9/D12)
package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class GanosgiaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Stealing",
        part_of_speech: "v.i.",
        conjugations: [
                [subject: 'SG1', object: '', present: 'jinosgia'],
            [subject: 'SG1', object: '', present: 'jinosgia', habitual: 'jinosgisgoi', remote_past: 'aginosgisvi', imperative: 'jinosgi', infinitive: 'aginosgisdi'],
            [subject: 'SG2', object: '', present: 'hinosgia', habitual: 'hinosgisgoi', remote_past: 'janosgisvi', imperative: 'hinosgi', infinitive: 'janosgisdi'],
            [subject: 'SG3', object: '', habitual: 'ganosgisgoi', imperative: 'hinosgi', infinitive: 'unosgisdi', present: 'ganosgia', remote_past: 'unosgisvi'],
            [subject: 'PL3', object: '', present: 'aninosgia', habitual: 'aninosgisgoi', remote_past: 'uninosgisvi', imperative: 'aninosgi', infinitive: 'uninosgisdi'],
            [subject: 'PL1INCL', object: '', present: 'idinosgia', habitual: 'idinosgisgoi', remote_past: 'iginosgisvi', imperative: 'idinosgi', infinitive: 'iginosgisdi']
        ]
    ]

    @Unroll
    def "conjugating Ganosgia (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Ganosgia", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "tsinosgia"
        "SG1" | "" | Tense.HABITUAL        | "tsinosgisgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "aginosgisvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "tsinosgisvi"
        "SG1" | "" | Tense.INFINITIVE      | "aginosgisdi"
        "SG2" | "" | Tense.PRESENT         | "hinosgia"
        "SG2" | "" | Tense.HABITUAL        | "hinosgisgoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "tsanosgisvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "hinosgisvi"
        "SG2" | "" | Tense.INFINITIVE      | "tsanosgisdi"
        "SG3" | "" | Tense.PRESENT         | "ganosgia"
        "SG3" | "" | Tense.HABITUAL        | "ganosgisgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "unosgisvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "ganosgisvi"
        "SG3" | "" | Tense.INFINITIVE      | "unosgisdi"
        "PL3" | "" | Tense.PRESENT         | "aninosgia"
        "PL3" | "" | Tense.HABITUAL        | "aninosgisgoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "uninosgisvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "aninosgisvi"
        "PL3" | "" | Tense.INFINITIVE      | "uninosgisdi"
        "PL1INCL" | "" | Tense.PRESENT         | "idinosgia"
        "PL1INCL" | "" | Tense.HABITUAL        | "idinosgisgoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "iginosgisvi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "idinosgisvi"
        "PL1INCL" | "" | Tense.INFINITIVE      | "iginosgisdi"
    }
}
