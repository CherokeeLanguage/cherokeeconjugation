package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class WagiaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Get (neutral)",
        part_of_speech: "v.i.",
        conjugations: [
            [subject: 'SG3', object: '', present: 'wijigia', habitual: 'wijisgoi', remote_past: 'wagigisvi', imperative: 'wijigi', infinitive: 'wagigisdi'],
            [subject: 'SG2', object: '', present: 'hwigia', habitual: 'hwigisgoi', remote_past: 'wijagisvi', imperative: 'hwigi', infinitive: 'wijagisdi'],
            [subject: 'SG3', object: '', present: 'wagia', habitual: 'wagisgoi', remote_past: 'wugisvi', imperative: 'wagi', infinitive: 'wugisdi'],
            [subject: 'SG3', object: '', present: 'wanigia', habitual: 'wanigisgoi', remote_past: 'wunigisvi', imperative: 'wanigi', infinitive: 'wunigisdi']
        ]
    ]

    @Unroll
    def "conjugating Wagia (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Wagia", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG3" | "" | Tense.PRESENT         | "witsigia"
        "SG3" | "" | Tense.HABITUAL        | "witsisgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "uwagigisvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "gawagigisvi"
        "SG3" | "" | Tense.INFINITIVE      | "ugigisdi"
        "SG2" | "" | Tense.PRESENT         | "hitsigia"
        "SG2" | "" | Tense.HABITUAL        | "hitsisgoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "tsawagigisvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "hiwagigisvi"
        "SG2" | "" | Tense.INFINITIVE      | "tsagigisdi"
        "SG3" | "" | Tense.PRESENT         | "witsigia"
        "SG3" | "" | Tense.HABITUAL        | "witsisgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "uwagigisvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "gawagigisvi"
        "SG3" | "" | Tense.INFINITIVE      | "ugigisdi"
        "SG3" | "" | Tense.PRESENT         | "witsigia"
        "SG3" | "" | Tense.HABITUAL        | "witsisgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "uwagigisvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "gawagigisvi"
        "SG3" | "" | Tense.INFINITIVE      | "ugigisdi"
    }
}
