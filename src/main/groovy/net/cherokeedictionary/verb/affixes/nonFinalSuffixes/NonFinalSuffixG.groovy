package net.cherokeedictionary.verb.affixes.nonFinalSuffixes

import net.cherokeedictionary.core.Verb
import net.cherokeedictionary.verb.affixes.Affix

class NonFinalSuffixG implements Affix {
    String g

    @Override
    String toSyllabary(String baseReturnValue, Verb word) {
        return null
    }

    @Override
    String toEnglish(String baseReturnValue, Verb word) {
        return null
    }

    String toString() {
        return g
    }
}
