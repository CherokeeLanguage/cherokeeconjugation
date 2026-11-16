// tio 16Nov26: citation rows re-aligned to CED cedEntries.csv id 72527 (entrya alsgia) -- the yaml transcription carried unconvertible romanization clusters (DISCREPANCIES.md D9/D12)
package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class AlsgiaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Dancing",
        part_of_speech: "v.i.",
        conjugations: [
                [subject: 'SG1', object: '', present: 'galisgia'],
            [subject: 'SG1', object: '', present: 'galisgia', habitual: 'galisgisgoi', remote_past: 'agwalsgisvi', imperative: 'galisgi', infinitive: 'agwalsgisdi'],
            [subject: 'SG2', object: '', present: 'halsgia', habitual: 'halsgisgoi', remote_past: 'jalsgisvi', imperative: 'halsgi', infinitive: 'jalsgisdi'],
            [subject: 'SG3', object: '', habitual: 'alsgisgoi', imperative: 'halsgi', infinitive: 'ulsgisdi', present: 'alsgia', remote_past: 'ulsgisvi'],
            [subject: 'PL3', object: '', present: 'analsgia', habitual: 'analsgisgoi', remote_past: 'unalsgisvi', imperative: 'analsgi', infinitive: 'unalsgisdi'],
            [subject: 'PL1INCL', object: '', present: 'idalsgia', habitual: 'idalsgisgoi', remote_past: 'igalsgisvi', imperative: 'idalsgi', infinitive: 'igalsgisdi']
        ]
    ]

    @Unroll
    def "conjugating Alsgia (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Alsgia", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "galisgia"
        "SG1" | "" | Tense.HABITUAL        | "galisgisgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "aqualisgisvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "galisgisvi"
        "SG1" | "" | Tense.INFINITIVE      | "aqualisgisdi"
        "SG2" | "" | Tense.PRESENT         | "halisgia"
        "SG2" | "" | Tense.HABITUAL        | "halisgisgoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "tsalisgisvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "halisgisvi"
        "SG2" | "" | Tense.INFINITIVE      | "tsalisgisdi"
        "SG3" | "" | Tense.PRESENT         | "alisgia"
        "SG3" | "" | Tense.HABITUAL        | "alisgisgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "ulisgisvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "alisgisvi"
        "SG3" | "" | Tense.INFINITIVE      | "ulisgisdi"
        "PL3" | "" | Tense.PRESENT         | "analisgia"
        "PL3" | "" | Tense.HABITUAL        | "analisgisgoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "unalisgisvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "analisgisvi"
        "PL3" | "" | Tense.INFINITIVE      | "unalisgisdi"
        "PL1INCL" | "" | Tense.PRESENT         | "idalisgia"
        "PL1INCL" | "" | Tense.HABITUAL        | "idalisgisgoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "igalisgisvi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "idalisgisvi"
        "PL1INCL" | "" | Tense.INFINITIVE      | "igalisgisdi"
    }
}
