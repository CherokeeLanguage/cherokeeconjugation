package cherokee.dictionary.conjugation.affixes.suffixes

import Affix

class NonFinalSuffixG implements Affix {
    String g

    @Override
    String toSyllabary(Object baseReturnValue, Object data, Object de, Object verbTense) {
        return null
    }

    @Override
    String toEnglish(Object baseReturnValue, Object data, Object de, Object verbTense) {
        return null
    }

    String toString() {
        return g
    }
}
