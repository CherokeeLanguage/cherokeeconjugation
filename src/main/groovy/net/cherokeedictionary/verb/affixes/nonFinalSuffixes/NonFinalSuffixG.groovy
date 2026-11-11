package net.cherokeedictionary.verb.affixes.nonFinalSuffixes

import net.cherokeedictionary.core.Verb
import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.verb.affixes.Affix

/**
 * C6: the non-final progressive suffix "-sg-".
 *
 * Grammar guide (Feeling 1975, non-final suffix slot; ex. 89/93): the
 * progressive tenses insert -sg- before the tense final suffix:
 *
 *   present            stem + sg + a     -> ...-ha    (s drops, g -> h)
 *   present habitual   stem + sg + o'i   -> ...-sgo'i (ᏍᎪᎢ)
 *   past progressive   stem + sg + v'i   -> ...-sgv'i (ᏍᎬᎢ)
 *   future progressive stem + sg + esdi  -> ...-sgesdi (ᏍᎨᏍᏗ)
 *
 * The surfaced form merges with a preceding stem-final -h-: h + sg -> sg
 * (gawonih + sg + v'i -> gawonisgv'i ᎦᏬᏂᏍᎬᎢ), which is why the present's
 * -sg+a surfaces as -ha.
 */
class NonFinalSuffixG implements Affix {
    String g

    @Override
    String toSyllabary(String baseReturnValue, Verb word) {
        if (!word?.nonFinalSuffixHolder?.g) {
            return baseReturnValue
        }
        def applied = applyG(baseReturnValue, word)
        return applied ?: baseReturnValue
    }

    /**
     * Static helper: insert the progressive -sg- into a latin root+ending base,
     * merging with a stem-final -h- (h + sg -> sg). Used both by the affix path
     * and by VerbTenseHolder when it derives the progressive stems from the
     * present stem.
     */
    static String applyGLatin(String latinBase) {
        if (!latinBase) {
            return latinBase
        }
        if (latinBase.endsWith("h")) {
            return latinBase.substring(0, latinBase.size() - 1) + "sg"
        }
        return latinBase + "sg"
    }

    static String applyG(String baseReturnValue, Verb word) {
        if (!baseReturnValue) {
            return baseReturnValue
        }
        def latin = SyllabaryUtil.parseSyllabary(baseReturnValue)
        def merged = applyGLatin(latin)
        return merged == latin ? baseReturnValue : SyllabaryUtil.tsalagiToSyllabary(merged)
    }

    @Override
    String toEnglish(String baseReturnValue, Verb word) {
        return null
    }

    String toString() {
        return g
    }
}
