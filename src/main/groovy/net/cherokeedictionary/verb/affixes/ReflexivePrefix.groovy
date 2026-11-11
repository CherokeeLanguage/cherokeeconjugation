package net.cherokeedictionary.verb.affixes

import net.cherokeedictionary.core.Verb
import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.StringUtility
import net.cherokeedictionary.util.Tense

/**
 * D: reflexive prefix allomorphs (Feeling 1975 grammar, I-E pp.295-297):
 *
 *   "-adad- before a stem beginning with a vowel other than -a-, as -ad- before
 *    -a-, and as ada- before a stem beginning with a consonant"
 *
 *   (1b) ᎬᏂᎭ gvhniha      -> ᎠᏓᏛᏂᎭ adadvhniha   (v-stem, -adad-)
 *   (2b) ᎦᏢᎢᎭ gatlv'iha   -> ᎠᏓᏢᎢᎭ adatlv'iha   (t-stem, ada-)
 *   (3b) ᎠᎪᏩᏘᎭ agowtiha  -> ᎠᏓᎪᏩᏘᎭ adagowtiha (a-stem, -ad-: the stem a drops)
 *
 *   "When preceded by the Set B third person pronoun prefix u-, the initial
 *    -a- of -adad- is dropped":
 *   (4b) ᎤᏩᏂᎸᎢ uwahniv'i -> ᎤᏓᏛᏂᎸᎢ udadvhniv'i
 *   (P4) ᎠᏆᏓᏛᏂᎸᎢ agwadadvhniv'i ("I hit myself") — consonant-final prefixes
 *   (agw-, j-, ...) keep the -a-.
 *
 * In the engine the routed past stem carries the normalized uw artifact
 * (vowel + Ꮹ-series syllable: ᎥᏩᏂᎸᎢ), so for the past (Set B) the reflexive
 * surfaces as ᏓᏛ + rest (the prefix's own preConsonant provides u-/agw-:
 * Ꭴ+ᏓᏛᏂᎸᎢ = ᎤᏓᏛᏂᎸᎢ, ᎠᏆ+ᏓᏛᏂᎸᎢ = ᎠᏆᏓᏛᏂᎸᎢ); for the present (Set A) it surfaces
 * as ᎠᏓᏛ + rest (ᎠᏓᏛᏂᎭ). -- timo 10Nov26
 */
class ReflexivePrefix implements Affix {
    @Override
    String toSyllabary(String verbToConjugate, Verb verb) {
        if (verb.reflexiveHolderObject.isReflexive()) {
            if (verbToConjugate.startsWith("Ꭰ")) {
                // -ad- before -a- stems: the stem-initial a is consumed
                verb.reflexivePrefix = "ᎠᏓ"
                verbToConjugate = verb.reflexivePrefix + verbToConjugate.substring(1)
            } else if (StringUtility.startsWithVowelSyllabary(verbToConjugate)) {
                boolean isPastUwArtifact = verbToConjugate.startsWith("ᎤᏩ") || isWartifactAt(verbToConjugate, 1) || verb.tense == Tense.REMOTE_PAST
                if (isPastUwArtifact) {
                    // Set B past: the initial a of -adad- drops after u- (Feeling (4b)),
                    // and the normalized uw artifact (ᎤᏩ / vowel+Ꮹ) is consumed:
                    // surface ᏓᏛ + rest; the pronominal preConsonant (Ꭴ, ᎠᏆ, Ꮳ...)
                    // supplies the person. ᎤᏩᏂᎸᎢ/ᎥᏩᏂᎸᎢ -> ᏓᏛᏂᎸᎢ
                    int skip = verbToConjugate.startsWith("ᎤᏩ") ? 2
                            : (isWartifactAt(verbToConjugate, 1) ? 2 : 1)
                    verb.reflexivePrefix = "ᏓᏛ"
                    verbToConjugate = "ᏓᏛ" + verbToConjugate.substring(skip)
                } else {
                    // Set A: -adad- keeps its initial a: ᎥᏂᎭ -> ᎠᏓᏛᏂᎭ
                    def str = "d" + SyllabaryUtil.parseSyllabary(verbToConjugate.charAt(0) as String)
                    def rv = SyllabaryUtil.tsalagiToSyllabary(str)
                    verb.reflexivePrefix = "ᎠᏓ" + rv
                    verbToConjugate = "ᎠᏓ" + rv + verbToConjugate.substring(1)
                }
            } else {
                // ada- before consonant stems
                verb.reflexivePrefix = "ᎠᏓ"
                verbToConjugate = "ᎠᏓ" + verbToConjugate
            }
        }

        return verbToConjugate
    }

    /**
     * True when the syllable at the given index is one of the Ꮹ-series
     * (the w of the normalized uw artifact on vowel-stem past forms).
     */
    private static boolean isWartifactAt(String syllabary, int index) {
        if (!syllabary || syllabary.size() <= index) {
            return false
        }
        return ['Ꮹ', 'Ꮺ', 'Ꮻ', 'Ꮼ', 'Ꮽ', 'Ꮾ'].contains(String.valueOf(syllabary.charAt(index)))
    }

    @Override
    String toEnglish(String baseReturnValue, Verb verb) {
        return null
    }
}
