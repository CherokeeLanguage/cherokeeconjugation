package cherokee.dictionary.conjugation.affixes.suffixes

import cherokee.dictionary.conjugation.affixes.Affix
import cherokee.dictionary.conjugation.wordFormation.Word

class NonFinalSuffixG implements Affix {
    String g

    @Override
    String toSyllabary(Object baseReturnValue, Word word) {
        return null
    }

    @Override
    String toEnglish(Object baseReturnValue, Word word) {
        return null
    }

    String toString() {
        return g
    }
}
