package cherokee.dictionary.conjugation.affixes.prefixes

import Affix

class PrefixGa implements Affix {
    String ga;

    @Override
    String toSyllabary(Object baseReturnValue, Object data, Object de, Object verbTense) {
        baseReturnValue = ""
        def charAtZero = data.charAt(0);
        def startsWithVowel = (charAtZero == 'Ꭰ' || charAtZero == 'Ꭱ' || charAtZero == 'Ꭲ' || charAtZero == 'Ꭳ' || charAtZero == 'Ꭴ' || charAtZero == 'Ꭵ')

        if (startsWithVowel) {
            if (charAtZero == 'Ꭰ') {
                baseReturnValue = 'Ꭼ' + data.substring(1);
            } else if (charAtZero == 'Ꭱ') {
                baseReturnValue = 'ᎦᏰ' + data.substring(1);
            } else if (charAtZero == 'Ꭲ') {
                baseReturnValue = 'ᎦᏱ' + data.substring(1);
            } else if (charAtZero == 'Ꭳ') {
                baseReturnValue = 'ᎦᏲ' + data.substring(1);
            } else if (charAtZero == 'Ꭴ') {
                baseReturnValue = 'ᎦᏳ' + data.substring(1);
            } else if (charAtZero == 'Ꭵ') {
                baseReturnValue = 'ᎦᏴ' + data.substring(1);
            }
        } else {
            baseReturnValue =  'Ꭶ' + data;
        }

        return baseReturnValue;
    }

    @Override
    String toEnglish(Object baseReturnValue, Object data, Object de, Object verbTense) {
        return null
    }

    String toString() {
        return ga
    }


}
