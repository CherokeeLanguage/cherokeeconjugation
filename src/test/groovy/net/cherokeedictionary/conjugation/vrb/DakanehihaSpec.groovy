// tio 16Nov26: citation rows re-aligned to CED cedEntries.csv id 72763 (entrya dakanehiha) -- the yaml transcription carried unconvertible romanization clusters (DISCREPANCIES.md D9/D12)
package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class DakanehihaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Tying",
        part_of_speech: "v.i.",
        conjugations: [
                [subject: 'SG1', object: '', present: 'dejiganehiha'],
            [subject: 'SG1', object: '', present: 'dejiganehiha', habitual: 'dejiganehihoi', remote_past: 'dagikanehlvi', imperative: 'dijiganega', infinitive: 'digijihlusdi'],
            [subject: 'SG2', object: '', present: 'dehikanehiha', habitual: 'deihikanehihoi', remote_past: 'dejakanehlvi', imperative: 'tikanega', infinitive: 'dijajihlusdi'],
            [subject: 'SG3', object: '', habitual: 'dakanehihoi', imperative: 'tikanega', infinitive: 'jukanesdi', present: 'dakanehiha', remote_past: 'dukanehlvi'],
            [subject: 'PL3', object: '', present: 'danikanehiha', habitual: 'danikanehihoi', remote_past: 'dunikanehlvi', imperative: 'dinikanega', infinitive: 'junijihlusdi'],
            [subject: 'PL1INCL', object: '', present: 'dedikanehiha', habitual: 'dedikanehihoi', remote_past: 'degikanehlvi', imperative: 'didikanega', infinitive: 'digijihlusdi']
        ]
    ]

    @Unroll
    def "conjugating Dakanehiha (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Dakanehiha", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "tsikanehiha"
        "SG1" | "" | Tense.HABITUAL        | "tsikanehihoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "agikanetlvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "tsikanetlvi"
        "SG1" | "" | Tense.INFINITIVE      | "agikanesdi"
        "SG2" | "" | Tense.PRESENT         | "hikanehiha"
        "SG2" | "" | Tense.HABITUAL        | "hikanehihoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "tsakanetlvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "hikanetlvi"
        "SG2" | "" | Tense.INFINITIVE      | "tsakanesdi"
        "SG3" | "" | Tense.PRESENT         | "dakanehiha"
        "SG3" | "" | Tense.HABITUAL        | "dakanehihoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "ukanetlvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "gakanetlvi"
        "SG3" | "" | Tense.INFINITIVE      | "ukanesdi"
        "PL3" | "" | Tense.PRESENT         | "anikanehiha"
        "PL3" | "" | Tense.HABITUAL        | "anikanehihoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "unikanetlvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "anikanetlvi"
        "PL3" | "" | Tense.INFINITIVE      | "unikanesdi"
        "PL1INCL" | "" | Tense.PRESENT         | "idikanehiha"
        "PL1INCL" | "" | Tense.HABITUAL        | "idikanehihoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "igikanetlvi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "idikanetlvi"
        "PL1INCL" | "" | Tense.INFINITIVE      | "igikanesdi"
    }
}
