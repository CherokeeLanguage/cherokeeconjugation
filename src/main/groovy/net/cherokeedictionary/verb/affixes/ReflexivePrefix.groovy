package net.cherokeedictionary.verb.affixes

import net.cherokeedictionary.core.Verb
import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.StringUtility
import net.cherokeedictionary.util.Tense

/**
 * D: reflexive prefix allomorphs (guide hold1 I-E pp. 295-298 P1-P6;
 * M-A section 9.7 -adaad-):
 *
 *   "-adad- before a stem beginning with a vowel other than -a-, as -ad- before
 *    -a-, and as ada- before a stem beginning with a consonant"
 *
 *   (1b) ᎬᏂᎭ gvhniha      -> ᎠᏓᏛᏂᎭ adadvhniha   (v-stem, -adad-, d-fused)
 *   (2b) ᎦᏢᎢᎭ gatlv'iha   -> ᎠᏓᏢᎢᎭ adatlv'iha   (t-stem, ada-)
 *   (3b) ᎠᎪᏩᏘᎭ agowtiha  -> ᎠᏓᎪᏩᏘᎭ adagowtiha (a-stem, -ad-: the stem a drops)
 *
 *   "When preceded by the Set B third person pronoun prefix u-, the initial
 *    -a- of -adad- is dropped": (4b) ᎤᏩᏂᎸᎢ -> ᎤᏓᏛᏂᎸᎢ (P4 SG3).
 *
 * IMPLEMENTATION (verified against P1-P6, all 9 persons, 20Nov26): the
 * reflexive is a STEM-LEVEL insertion -- the routed stem's baked sg3 marker
 * (Ꭴ/Ꭵ + optional Ꮹ-series artifact on vowel stems) is stripped, the
 * ada(d)- allomorph is inserted by the stem's own initial (ᎠᏓ + D-map-fused
 * first glyph for non-a vowel stems, ᎠᏓ + stem otherwise), and the result
 * is a VOWEL-INITIAL adastem. The standard pronominal machinery then does
 * all the merging: preVowel compounds (g-/h-/in-/id-/osd-/oj-/sd-/ij-) give
 * the P1 rows; the Set B preVowel compounds + standard a-drop/RuleUW give
 * the P2/P4 rows (agw+ada -> ᎠᏆᏓ, uw+ada -> ᎤᏓ, gin+ada -> ᎦᎾᏓ). The P5
 * verbset override (reflexive present = Set A even for class-B verbs) lives
 * in ConjugationHelper.determineVerbSet. -- tio 20Nov26
 */
class ReflexivePrefix implements Affix {
    @Override
    String toSyllabary(String verbToConjugate, Verb verb) {
        if (verb.reflexiveHolderObject.isReflexive()) {
            String stem = stripSg3Marker(verbToConjugate)
            if (stem.startsWith("Ꭰ")) {
                // -ad- before -a- stems: the stem-initial a is consumed
                verb.reflexivePrefix = "ᎠᏓ"
                verbToConjugate = "ᎠᏓ" + stem.substring(1)
            } else if (StringUtility.startsWithVowelSyllabary(stem)) {
                // non-a vowel stem: -adad-, the d fuses into the first glyph
                // (Ꭵ->Ꮫ): ᎥᏂᎭ -> ᎠᏓᏛᏂᎭ
                def str = "d" + SyllabaryUtil.parseSyllabary(stem.charAt(0) as String)
                def rv = SyllabaryUtil.tsalagiToSyllabary(str)
                verb.reflexivePrefix = "ᎠᏓ" + rv
                verbToConjugate = "ᎠᏓ" + rv + stem.substring(1)
            } else {
                // ada- before consonant stems
                verb.reflexivePrefix = "ᎠᏓ"
                verbToConjugate = "ᎠᏓ" + stem
            }
        }

        return verbToConjugate
    }

    /** Strips the baked sg3 citation marker (Ꭴ/Ꭵ + optional Ꮹ-series artifact). */
    private static String stripSg3Marker(String syllabary) {
        if (!syllabary) { return syllabary }
        String s = syllabary
        if (s.startsWith("Ꭴ") || s.startsWith("Ꭵ")) {
            s = s.substring(1)
            // vowel-initial stems carry the Ꮹ-series w-artifact (ᎤᏩᏂᎸᎢ)
            if (s && ['Ꮹ', 'Ꮺ', 'Ꮻ', 'Ꮼ', 'Ꮽ', 'Ꮾ'].contains(String.valueOf(s.charAt(0)))
                    && s.size() > 1
                    && StringUtility.startsWithVowelSyllabary(s.substring(1))) {
                s = s.substring(1)
            }
        }
        return s
    }

    @Override
    String toEnglish(String baseReturnValue, Verb verb) {
        return null
    }
}
