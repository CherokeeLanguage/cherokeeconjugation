package cherokee.dictionary.conjugation.affixes.suffixes

import cherokee.dictionary.conjugation.affixes.Affix

class NonFinalSuffixIlo implements Affix{
    String ilo

    @Override
    String toSyllabary(Object baseReturnValue, Object data, Object de, Object verbTense) {

        return null
    }

    @Override
    String toEnglish(Object baseReturnValue, Object data, Object de, Object verbTense) {
        return null
    }


    @Override
    public String toString() {
        return ilo
    }
}
