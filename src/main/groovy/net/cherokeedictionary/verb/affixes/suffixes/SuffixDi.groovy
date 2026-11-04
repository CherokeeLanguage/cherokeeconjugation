package net.cherokeedictionary.verb.affixes.suffixes

import net.cherokeedictionary.core.Verb
import net.cherokeedictionary.verb.affixes.Affix

/**
 * Infinitive Suffixes: -di / -sdi
 * Used to form the infinitive ("to [verb]").
 */
class SuffixDi implements Affix {
    String di = "Ꮧ"

    @Override
    String toEnglish(String baseReturnValue, Verb word) {
        return null
    }

    @Override
    String toSyllabary(String baseReturnValue, Verb word) {
    	// Simple append logic for infinitive
        if (!baseReturnValue.endsWith(di)) {
            return baseReturnValue + di
        }
        return baseReturnValue
        return null
    }

    String toString() {
        return di
    }
}
