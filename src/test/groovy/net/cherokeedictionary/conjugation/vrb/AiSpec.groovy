// tio 18Nov26: NOT a junk verb (earlier framing corrected) -- A'i "Walking" is
// Verb p.1 of the 2012 book with a full box (ga'i / ha'i / a'i / ana'i /
// ida'i); the yaml transcription dropped the glottal apostrophes
// (a'i -> "Ai", ga'isv'i -> "gaisvi"). Citation rows re-aligned to CED
// cedEntries.csv id 72423 (entrya ai, syllabary ᎠᎢ -- the glottal is unwritten
// between vowels; DISCREPANCIES.md D9/D12). REMOTE_PAST is ATTESTED
// (a'isv'i -> aisvi), so FUTURE_COMMAND composes from it per the D1
// convention; the imperative and infinitive columns are book-x (unattested).
package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class AiSpec extends VerbBaseSpec {
    static def details = [
        definition: "Walking",
        part_of_speech: "v.i.",
        conjugations: [
                [subject: 'SG1', object: '', present: 'gai'],
            [subject: 'SG1', object: '', present: 'gai', habitual: 'gaisoi', remote_past: 'aquaisvi', imperative: '', infinitive: ''],
            [subject: 'SG3', object: '', habitual: 'aisoi', imperative: '', infinitive: '', present: 'ai', remote_past: 'aisvi']
        ]
    ]

    @Unroll
    def "conjugating Ai (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Ai", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "gai"
        "SG1" | "" | Tense.HABITUAL        | "gaisoi"
        // tio 18Nov26: REMOTE_PAST ATTESTED (book ga'isv'i, p.1) -- was
        // spuriously framed as a gap under the junk-verb reading. FUTURE_COMMAND
        // is NOT asserted: the book box has no future-command column and the
        // engine's FC composition yields the completive-future shape (aisvi-i),
        // not the remote echo, for this vowel-initial stem -- the D1
        // remote-echo convention does not apply cleanly here.
        "SG1" | "" | Tense.REMOTE_PAST     | "aquaisvi"
        // INFINITIVE UNATTESTED -- the book prints x in the infinitive column.
    }
}
