package net.cherokeedictionary.verb.affixes.suffixes

import net.cherokeedictionary.core.Verb
import net.cherokeedictionary.verb.affixes.Affix

class SuffixNa implements Affix {
    String na

    @Override
    String toSyllabary(String baseReturnValue, Verb word) {
        return null
    }

    @Override
    String toEnglish(String baseReturnValue, Verb word) {
        return null
    }

    String toString() {
        return na
    }
}
