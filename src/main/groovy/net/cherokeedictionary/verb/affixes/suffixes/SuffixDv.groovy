package net.cherokeedictionary.verb.affixes.suffixes

import net.cherokeedictionary.core.Verb
import net.cherokeedictionary.verb.affixes.Affix

/**
 * Completive Suffix: -dv
 * Indicates the completive aspect of an action.
 */
class SuffixDv implements Affix {
    String dv = "Ꮫ"

    @Override
    String toSyllabary(String baseReturnValue, Verb word) {
	if (!baseReturnValue.endsWith(dv)) {
            return baseReturnValue + dv
        }
	
        return baseReturnValue
    }

    @Override
    String toEnglish(String baseReturnValue, Verb word) {
        return null
    }

    String toString() {
        return dv
    }
}
