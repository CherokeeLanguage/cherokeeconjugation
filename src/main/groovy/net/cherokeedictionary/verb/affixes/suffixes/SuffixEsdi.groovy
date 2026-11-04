package net.cherokeedictionary.verb.affixes.suffixes

import net.cherokeedictionary.core.Verb
import net.cherokeedictionary.verb.affixes.Affix

/**
 * Suffix: -esdi
 * Used in specific aspectual or future-oriented constructions.
 */
class SuffixEsdi implements Affix {
    String esdi = "ᎡᏍᏗ"

    @Override
    String toSyllabary(String baseReturnValue, Verb word) {
        if (!baseReturnValue.endsWith(esdi)) {
            return baseReturnValue + esdi
        }

        return baseReturnValue
    }

    @Override
    String toEnglish(String baseReturnValue, Verb word) {
        return null
    }

    String toString() {
        return esdi
    }
}
