// tio 16Nov26: citation rows re-aligned to CED cedEntries.csv id 72498 (entrya alehwisdohdiha) -- the yaml transcription carried unconvertible romanization clusters (DISCREPANCIES.md D9/D12)
package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class AlehwisdohdihaSpec extends VerbBaseSpec {
    static def details = [
        definition: "(He/She/It) Is Stopping (Him/Her/It)",
        part_of_speech: "v.t.",
        conjugations: [
                [subject: 'SG1', object: '', present: 'jiyalewisdohdiha, galewisdohdiha'],
            [subject: 'SG1', object: 'SG3AN', present: 'jiyalewisdohdiha', habitual: 'jiyalehwisdohdisgoi', remote_past: 'jiyalehwisdohtanvi', imperative: 'jiyalewisdohda', infinitive: 'jiyalehwisdohdohdi'],
            [subject: 'SG1', object: 'SG3IN', present: 'galehwisdohdiha', habitual: 'galehwisdohdisgoi', remote_past: 'agwalehwisdohtanvi', imperative: 'galehwisdohda', infinitive: 'agwalehwisdohdohdi'],
            [subject: 'SG2', object: 'SG3AN', present: 'hiyalehwisdohdiha', habitual: 'hiyalehwisdohdisgoi', remote_past: 'hiyalehwisdohtanvi', imperative: 'hiyalewisdohda', infinitive: 'hiyalehwisdohdohdi'],
            [subject: 'SG2', object: 'SG3IN', present: 'halehwisdohdiha', habitual: 'halehwisdohdisgoi', remote_past: 'jalehwisdohtanvi', imperative: 'halehwisdohda', infinitive: 'jalehiwsdohdohdi'],
            [subject: 'SG3', object: '', habitual: 'alehwisdohdisgoi', imperative: 'hiyalewisdohda, halehwisdohda', infinitive: 'ulehwisdohdohdi', present: 'alehwisdohdiha', remote_past: 'ulehwisdohtanvi'],
            [subject: 'PL3', object: 'SG3IN', present: 'analehwisdohdiha', habitual: 'analehwisdohdisgoi', remote_past: 'analehwisdohtanvi', imperative: 'analehwisdohda', infinitive: 'unalehwisdohdohdi'],
            [subject: 'PL1INCL', object: 'SG3IN', present: 'idalehwisdohdiha', habitual: 'idalehwisdohdisgoi', remote_past: 'igalehwisdohtanvi', imperative: 'idalehwisdohda', infinitive: 'igalehwisdohdohdi']
        ]
    ]

    @Unroll
    def "conjugating Alehwisdohdiha (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Alehwisdohdiha", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "SG3AN" | Tense.PRESENT         | "tsiyalewisdodiha"
        "SG1" | "SG3AN" | Tense.HABITUAL        | "tsiyalewisdodisgoi"
        "SG1" | "SG3AN" | Tense.REMOTE_PAST     | "tsiyalewisdotanvi"
        "SG1" | "SG3AN" | Tense.FUTURE_COMMAND      | "tsiyalewisdotanvi"
        "SG1" | "SG3AN" | Tense.INFINITIVE      | "tsiyalewisdododi"
        "SG1" | "SG3IN" | Tense.PRESENT         | "galewisdodiha"
        "SG1" | "SG3IN" | Tense.HABITUAL        | "galewisdodisgoi"
        "SG1" | "SG3IN" | Tense.REMOTE_PAST     | "aqualewisdotanvi"
        "SG1" | "SG3IN" | Tense.FUTURE_COMMAND      | "galewisdotanvi"
        "SG1" | "SG3IN" | Tense.INFINITIVE      | "aqualewisdododi"
        "SG2" | "SG3AN" | Tense.PRESENT         | "hiyalewisdodiha"
        "SG2" | "SG3AN" | Tense.HABITUAL        | "hiyalewisdodisgoi"
        "SG2" | "SG3AN" | Tense.REMOTE_PAST     | "alewisdotanvi"
        "SG2" | "SG3AN" | Tense.FUTURE_COMMAND      | "hiyalewisdotanvi"
        "SG2" | "SG3AN" | Tense.INFINITIVE      | "alewisdododi"
        "SG2" | "SG3IN" | Tense.PRESENT         | "halewisdodiha"
        "SG2" | "SG3IN" | Tense.HABITUAL        | "halewisdodisgoi"
        "SG2" | "SG3IN" | Tense.REMOTE_PAST     | "tsalewisdotanvi"
        "SG2" | "SG3IN" | Tense.FUTURE_COMMAND      | "halewisdotanvi"
        "SG2" | "SG3IN" | Tense.INFINITIVE      | "tsalewisdododi"
        "SG3" | "SG3IN" | Tense.PRESENT         | "alewisdodiha"
        "SG3" | "SG3IN" | Tense.HABITUAL        | "alewisdodisgoi"
        "SG3" | "SG3IN" | Tense.REMOTE_PAST     | "ulewisdotanvi"
        "SG3" | "SG3IN" | Tense.FUTURE_COMMAND      | "alewisdotanvi"
        "SG3" | "SG3IN" | Tense.INFINITIVE      | "ulewisdododi"
        "PL3" | "SG3IN" | Tense.PRESENT         | "analewisdodiha"
        "PL3" | "SG3IN" | Tense.HABITUAL        | "analewisdodisgoi"
        "PL3" | "SG3IN" | Tense.REMOTE_PAST     | "unalewisdotanvi"
        "PL3" | "SG3IN" | Tense.FUTURE_COMMAND      | "analewisdotanvi"
        "PL3" | "SG3IN" | Tense.INFINITIVE      | "unalewisdododi"
        "PL1INCL" | "SG3IN" | Tense.PRESENT         | "idalewisdodiha"
        "PL1INCL" | "SG3IN" | Tense.HABITUAL        | "idalewisdodisgoi"
        "PL1INCL" | "SG3IN" | Tense.REMOTE_PAST     | "igalewisdotanvi"
        "PL1INCL" | "SG3IN" | Tense.FUTURE_COMMAND      | "idalewisdotanvi"
        "PL1INCL" | "SG3IN" | Tense.INFINITIVE      | "igalewisdododi"
    }
}
