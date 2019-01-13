package cherokee.dictionary.conjugation.affixes.suffixes

import cherokee.dictionary.conjugation.affixes.Affix
import cherokee.dictionary.conjugation.wordFormation.Word

class NonFinalSuffixIlo implements Affix{
    String ilo

    @Override
    String toSyllabary(Object baseReturnValue, Word word) {

        return null
    }

    @Override
    String toEnglish(Object baseReturnValue, Word word) {
        return null
    }


    @Override
    public String toString() {
        return ilo
    }
}
