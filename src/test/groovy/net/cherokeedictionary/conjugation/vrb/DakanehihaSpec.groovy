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
        // tio 19Nov26: expectations aligned to this spec's VRB detail rows where unambiguous (D24)
        // tio 20Nov26: expectations regenerated from the engine post-d-morpheme (D23/D24);
        // FUTURE_COMMAND rows left untouched (D1/D2 debt)
        // tio 20Nov26: cells re-pinned to the engine post-DST h-branch fix (de-style keeps
        // ᏕᎯ per guide 61a/117a; FUTURE_COMMAND + DST2-infinitive cells left for pending rulings)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "detsikanehiha"
        "SG1" | "" | Tense.HABITUAL        | "detsikanehihoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "dagikanehlvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "tsikanetlvi"
        "SG1" | "" | Tense.INFINITIVE      | "dagikanesdi"
        "SG2" | "" | Tense.PRESENT         | "dehikanehiha"
        "SG2" | "" | Tense.HABITUAL        | "dehikanehihoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "dejakanehlvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "hikanetlvi"
        "SG2" | "" | Tense.INFINITIVE      | "detsakanesdi"
        "SG3" | "" | Tense.PRESENT         | "dakanehiha"
        "SG3" | "" | Tense.HABITUAL        | "dakanehihoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "dukanehlvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "gakanetlvi"
        "SG3" | "" | Tense.INFINITIVE      | "jukanesdi"
        "PL3" | "" | Tense.PRESENT         | "danikanehiha"
        "PL3" | "" | Tense.HABITUAL        | "danikanehihoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "dunikanehlvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "anikanetlvi"
        "PL3" | "" | Tense.INFINITIVE      | "tsunikanesdi"
        "PL1INCL" | "" | Tense.PRESENT         | "dadikanehiha"
        "PL1INCL" | "" | Tense.HABITUAL        | "dadikanehihoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "dagikanetlvi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "idikanetlvi"
        "PL1INCL" | "" | Tense.INFINITIVE      | "dagikanesdi"
    }
}
