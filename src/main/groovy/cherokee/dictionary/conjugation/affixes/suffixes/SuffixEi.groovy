package cherokee.dictionary.conjugation.affixes.suffixes

import cherokee.dictionary.conjugation.affixes.Affix
import cherokee.dictionary.conjugation.wordFormation.Word

class SuffixEi implements Affix {
    String ei

    @Override
    String toSyllabary(Object baseReturnValue, Word word) {
        return null
    }

    @Override
    String toEnglish(Object baseReturnValue, Word word) {
        return null
    }

    String toString() {
        return ei
    }
}
