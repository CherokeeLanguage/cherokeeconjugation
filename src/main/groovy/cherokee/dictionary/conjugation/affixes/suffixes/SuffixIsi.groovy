package cherokee.dictionary.conjugation.affixes.suffixes

import cherokee.dictionary.conjugation.affixes.Affix

class SuffixIsi implements Affix {
    String isi

    @Override
    String toSyllabary(Object baseReturnValue, Object data, Object de, Object verbTense) {
        return null
    }

    @Override
    String toEnglish(Object baseReturnValue, Object data, Object de, Object verbTense) {
        return null
    }

    String toString() {
        return isi
    }
}
