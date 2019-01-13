package cherokee.dictionary.conjugation.affixes.prefixes

import cherokee.dictionary.conjugation.affixes.Affix
import cherokee.dictionary.conjugation.wordFormation.Word

class PrefixWi implements Affix {
    String wi;

    @Override
    String toSyllabary(Object baseReturnValue, Word word) {
        String data = word.pronounPrefix.syllabary + word.rootSyllabary
        def de = word.prefixHolderObject.de
        def verbTense = word.tense

        def charAtZero = baseReturnValue != '' ? baseReturnValue.charAt(0) : data.charAt(0);
        boolean isVowelBeginning = (charAtZero == 'Ꭰ' || charAtZero == 'Ꭱ' || charAtZero == 'Ꭲ' || charAtZero == 'Ꭳ' || charAtZero == 'Ꭴ' || charAtZero == 'Ꭵ')

        if (isVowelBeginning) {
            if (charAtZero == 'Ꭰ') {
                baseReturnValue = 'Ꮹ' + (baseReturnValue != '' ? baseReturnValue.substring(1) : data.substring(1));
            } else if (charAtZero == 'Ꭱ') {
                baseReturnValue = 'Ꮺ' + (baseReturnValue != '' ? baseReturnValue.substring(1) : data.substring(1));
            } else if (charAtZero == 'Ꭲ') {
                baseReturnValue = 'Ꮻ' + (baseReturnValue != '' ? baseReturnValue.substring(1) : data.substring(1));
            } else if (charAtZero == 'Ꭳ') {
                baseReturnValue = 'Ꮼ' + (baseReturnValue != '' ? baseReturnValue.substring(1) : data.substring(1));
            } else if (charAtZero == 'Ꭴ') {
                baseReturnValue = 'Ꮽ' + (baseReturnValue != '' ? baseReturnValue.substring(1) : data.substring(1));
            } else if (charAtZero == 'Ꭵ') {
                baseReturnValue = 'Ꮾ' + (baseReturnValue != '' ? baseReturnValue.substring(1) : data.substring(1));
            }
        } else {
            baseReturnValue = "Ꮻ" + (baseReturnValue != '' ? baseReturnValue : data);
        }

        return baseReturnValue;
    }

    @Override
    String toEnglish(Object baseReturnValue, Word word) {
        return null
    }

    String toString() {
        return wi
    }
}
