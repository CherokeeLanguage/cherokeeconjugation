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
        def data = word.pronounPrefix.syllabary + word.rootSyllabary
        if (data.startsWith("Ꭰ")) {//da + a = dv
            baseReturnValue = "Ꮫ" + (baseReturnValue != '' ? baseReturnValue : data).substring(1);
        } else {
            return baseReturnValue = "Ꮣ" + (baseReturnValue != '' ? baseReturnValue : data);
        }
    }

    @Override
    String toEnglish(Object baseReturnValue, Word word) {
        return null
    }
}
