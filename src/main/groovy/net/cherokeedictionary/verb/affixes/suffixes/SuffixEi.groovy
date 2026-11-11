package net.cherokeedictionary.verb.affixes.suffixes

import net.cherokeedictionary.core.Verb
import net.cherokeedictionary.verb.affixes.Affix

class SuffixEi implements Affix {
    String ei = "ᎡᎢ"

    @Override
    String toSyllabary(String baseReturnValue, Verb word) {
        if (!baseReturnValue) {
            return baseReturnValue
        }
        return baseReturnValue.endsWith(ei) ? baseReturnValue : baseReturnValue + ei
    }

    @Override
    String toEnglish(String baseReturnValue, Verb word) {
        return null
    }

    String toString() {
        return ei
    }
}
