package cherokee.dictionary.conjugation.affixes.prefixes

import cherokee.dictionary.conjugation.affixes.Affix
import cherokee.dictionary.conjugation.wordFormation.Word

class PrefixYi implements Affix {
    String yi;

    @Override
    String toSyllabary(Object baseReturnValue, Word word) {
        String data = word.pronounPrefix.syllabary + word.rootSyllabary
        def de = word.prefixHolderObject.de
        def verbTense = word.tense

        if (!word.prefixHolderObject.ji) {
            def charAtZero = baseReturnValue != '' ? baseReturnValue.charAt(0) : data.charAt(0);
            boolean isVowelBeginning = (charAtZero == 'Ꭰ' || charAtZero == 'Ꭱ' || charAtZero == 'Ꭲ' || charAtZero == 'Ꭳ' || charAtZero == 'Ꭴ' || charAtZero == 'Ꭵ')

            if (isVowelBeginning) {
                if (charAtZero == 'Ꭰ') {
                    baseReturnValue = 'Ꮿ' + (baseReturnValue != '' ? baseReturnValue.substring(1) : data.substring(1));
                } else if (charAtZero == 'Ꭱ') {
                    baseReturnValue = 'Ᏸ' + (baseReturnValue != '' ? baseReturnValue.substring(1) : data.substring(1));
                } else if (charAtZero == 'Ꭲ') {
                    baseReturnValue = 'Ᏹ' + (baseReturnValue != '' ? baseReturnValue.substring(1) : data.substring(1));
                } else if (charAtZero == 'Ꭳ') {
                    baseReturnValue = 'Ᏺ' + (baseReturnValue != '' ? baseReturnValue.substring(1) : data.substring(1));
                } else if (charAtZero == 'Ꭴ') {
                    baseReturnValue = 'Ᏻ' + (baseReturnValue != '' ? baseReturnValue.substring(1) : data.substring(1));
                } else if (charAtZero == 'Ꭵ') {
                    baseReturnValue = 'Ᏼ' + (baseReturnValue != '' ? baseReturnValue.substring(1) : data.substring(1));
                }
            } else {
                if (charAtZero == 'Ꮹ' || charAtZero == 'Ꮺ' || charAtZero == 'Ꮻ' || charAtZero == 'Ꮼ' || charAtZero == 'Ꮽ' || charAtZero == 'Ꮾ') {
                    baseReturnValue = "Ᏻ" + (baseReturnValue != '' ? baseReturnValue : data);
                } else {
                    baseReturnValue = "Ᏹ" + (baseReturnValue != '' ? baseReturnValue : data);
                }
            }
        }

        return baseReturnValue;
    }

    @Override
    String toEnglish(Object baseReturnValue, Word word) {
        return null
    }

    String toString() {
        return yi
    }


}