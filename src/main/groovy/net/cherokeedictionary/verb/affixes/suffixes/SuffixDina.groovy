package net.cherokeedictionary.verb.affixes.suffixes

import net.cherokeedictionary.core.Verb
import net.cherokeedictionary.verb.affixes.Affix

class SuffixDina implements Affix {
    String dina = "ᏗᎾ"

    @Override
    String toSyllabary(String baseReturnValue, Verb word) {
        return baseReturnValue.endsWith(dina) ? baseReturnValue : baseReturnValue + dina
    }

    @Override
    String toEnglish(String baseReturnValue, Verb word) {
        return null
    }

    String toString() {
        return dina
    }
}
