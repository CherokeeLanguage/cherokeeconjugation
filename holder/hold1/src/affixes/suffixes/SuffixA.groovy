package cherokee.dictionary.hold.affixes.suffixes

import cherokee.dictionary.hold.affixes.Affix
import cherokee.dictionary.hold.wordFormation.Word

class SuffixA implements Affix {
    String a

    @Override
    String toSyllabary(String baseReturnValue, Word word) {
        return null
    }

    @Override
    String toEnglish(String baseReturnValue, Word word) {
        return null
    }

    String toString() {
        return a
    }
}
