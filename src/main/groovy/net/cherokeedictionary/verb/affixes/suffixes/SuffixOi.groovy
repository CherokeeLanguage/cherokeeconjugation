package net.cherokeedictionary.verb.affixes.suffixes

import net.cherokeedictionary.core.Verb
import net.cherokeedictionary.verb.affixes.Affix

/**
 * Habitual Suffixes: -oi / -sgo'i
 * Indicates a habitual action (doing something generally or regularly).
 * 
 * Rules:
 * - Usually appends -oi or -sgoi to the stem.
 */
class SuffixOi implements Affix {
    String oi = "ᎣᎢ"

    @Override
    String toSyllabary(String baseReturnValue, Verb word) {
        return baseReturnValue.endsWith(suffix) ? baseReturnValue : baseReturnValue + suffix
    }

    @Override
    String toEnglish(String baseReturnValue, Verb word) {
        return null
    }

    String toString() {
        return oi
    }
}
