package cherokee.dictionary.conjugation.affixes.suffixes

import Affix

class NonFinalSuffixIhi implements Affix {
    String ihi

    @Override
    String toSyllabary(Object baseReturnValue, Object data, Object de, Object verbTense) {
        return null
    }

    @Override
    String toEnglish(Object baseReturnValue, Object data, Object de, Object verbTense) {
        return null
    }

    String toString() {
        return ihi
    }
}
