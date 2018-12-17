package cherokee.dictionary.conjugation.affixes.suffixes

import Affix

class NonFinalSuffixOhn implements Affix {
    String ohn

    @Override
    String toSyllabary(Object baseReturnValue, Object data, Object de, Object verbTense) {
        return null
    }

    @Override
    String toEnglish(Object baseReturnValue, Object data, Object de, Object verbTense) {
        return null
    }

    String toString() {
        return ohn
    }
}
