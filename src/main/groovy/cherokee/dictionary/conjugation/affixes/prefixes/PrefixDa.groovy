package cherokee.dictionary.conjugation.affixes.prefixes

import cherokee.dictionary.conjugation.affixes.Affix
import cherokee.dictionary.conjugation.wordFormation.Word

class PrefixDa implements Affix {
    String da;

    String toString() {
        return da
    }

    @Override
    String toSyllabary(Object baseReturnValue, Word word) {
        return null
    }

    @Override
    String toEnglish(Object baseReturnValue, Word word) {
        return null
    }
}
