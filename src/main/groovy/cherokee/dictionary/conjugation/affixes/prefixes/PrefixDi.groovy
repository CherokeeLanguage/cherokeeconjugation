package cherokee.dictionary.conjugation.affixes.prefixes

import cherokee.dictionary.conjugation.affixes.Affix
import cherokee.dictionary.conjugation.conjugate.Tense
import cherokee.dictionary.conjugation.wordFormation.Word

class PrefixDi implements Affix {
    String di;

    @Override
    String toSyllabary(Object baseReturnValue, Word word) {
        String data = word.pronounPrefix.syllabary + word.rootSyllabary
        def verbTense = word.tense

        def charAtZero = baseReturnValue != '' ? baseReturnValue.charAt(0) : data.charAt(0);
        boolean isVowelBeginning = (charAtZero == 'Ꭰ' || charAtZero == 'Ꭱ' || charAtZero == 'Ꭲ' || charAtZero == 'Ꭳ' || charAtZero == 'Ꭴ' || charAtZero == 'Ꭵ')

        if (verbTense == Tense.REMOTE_PAST) {
            if (isVowelBeginning) {
                if (charAtZero == 'Ꭰ') {
                    baseReturnValue = (baseReturnValue != '' ? baseReturnValue.substring(1) : data.substring(1));
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
            } /*else {
                baseReturnValue =  "Ꮣ" + (baseReturnValue != '' ? baseReturnValue : data);
            }*/

            baseReturnValue =  "Ꮣ" + (baseReturnValue != '' ? baseReturnValue : data);
        } else {
            if (isVowelBeginning) {
                if (charAtZero == 'Ꭰ') {
                    baseReturnValue = 'Ꮧ' + (baseReturnValue != '' ? baseReturnValue.substring(1) : data.substring(1));
                } else if (charAtZero == 'Ꭱ') {
                    baseReturnValue = 'Ꮴ' + (baseReturnValue != '' ? baseReturnValue.substring(1) : data.substring(1));
                } else if (charAtZero == 'Ꭲ') {
                    baseReturnValue = 'Ꮧ' + (baseReturnValue != '' ? baseReturnValue.substring(1) : data.substring(1));
                } else if (charAtZero == 'Ꭳ') {
                    baseReturnValue = 'Ꮶ' + (baseReturnValue != '' ? baseReturnValue.substring(1) : data.substring(1));
                } else if (charAtZero == 'Ꭴ') {
                    baseReturnValue = 'Ꮷ' + (baseReturnValue != '' ? baseReturnValue.substring(1) : data.substring(1));
                } else if (charAtZero == 'Ꭵ') {
                    baseReturnValue = 'Ꮸ' + (baseReturnValue != '' ? baseReturnValue.substring(1) : data.substring(1));
                }
            } else {
                baseReturnValue =  "Ꮧ" + (baseReturnValue != '' ? baseReturnValue : data);
            }
        }

        return baseReturnValue;
    }

    @Override
    String toEnglish(Object baseReturnValue, Word word) {
        return null
    }

    String toString() {
        return di
    }
}
