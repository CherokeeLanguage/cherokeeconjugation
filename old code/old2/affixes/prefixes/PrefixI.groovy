package cherokee.dictionary.conjugation.affixes.prefixes

import Affix
import cherokee.dictionary.conjugation.conjugate.Tense

class PrefixI implements Affix {
    String i;

    @Override
    String toSyllabary(Object baseReturnValue, Object data, Object de, Object verbTense) {
        def charAtZero = baseReturnValue != '' ? baseReturnValue.charAt(0) : data.charAt(0);
        def startsWithVowel = (charAtZero == 'Ꭰ' || charAtZero == 'Ꭱ' || charAtZero == 'Ꭲ' || charAtZero == 'Ꭳ' || charAtZero == 'Ꭴ' || charAtZero == 'Ꭵ')

        if (startsWithVowel) {
            if (charAtZero == 'Ꭰ') {
                baseReturnValue = 'Ꭲ' + (baseReturnValue != '' ? baseReturnValue.substring(1) : data.substring(1));
            } else if (charAtZero == 'Ꭱ') {
                baseReturnValue = 'Ꭲ' + (baseReturnValue != '' ? baseReturnValue.substring(1) : data.substring(1));
            } else if (charAtZero == 'Ꭲ') {
                baseReturnValue = 'Ꭲ' + (baseReturnValue != '' ? baseReturnValue.substring(1) : data.substring(1));
            } else if (charAtZero == 'Ꭳ') {
                baseReturnValue = 'Ꭲ' + (baseReturnValue != '' ? baseReturnValue.substring(1) : data.substring(1));
            } else if (charAtZero == 'Ꭴ') {
                baseReturnValue = 'Ꭲ' + (baseReturnValue != '' ? baseReturnValue.substring(1) : data.substring(1));
            } else if (charAtZero == 'Ꭵ') {
                baseReturnValue = 'Ꭲ' + (baseReturnValue != '' ? baseReturnValue.substring(1) : data.substring(1));
            }
        } else {
            if (de) {
                baseReturnValue = 'Ꮩ' + (baseReturnValue != '' ? baseReturnValue : data);
            } else if (charAtZero == 'Ꭶ' || verbTense == Tense.REMOTE_PAST) {
                baseReturnValue = 'Ꭵ' + (baseReturnValue != '' ? baseReturnValue : data);
            } else {
                baseReturnValue = 'Ꭲ' + (baseReturnValue != '' ? baseReturnValue : data);
            }
        }

        return baseReturnValue;
    }

    @Override
    String toEnglish(Object baseReturnValue, Object data, Object de, Object verbTense) {
        return null
    }

    String toString() {
        return i
    }
}
