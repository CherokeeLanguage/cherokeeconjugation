package cherokee.dictionary.conjugation.affixes.prefixes

import cherokee.dictionary.conjugation.affixes.Affix

class PrefixNi implements Affix {
    String Ni;

    @Override
    String toSyllabary(Object baseReturnValue, Object data, Object de, Object verbTense) {
        def charAtZero = baseReturnValue != '' ? baseReturnValue.charAt(0) : data.charAt(0);
        boolean isVowelBeginning = (charAtZero == 'Ꭰ' || charAtZero == 'Ꭱ' || charAtZero == 'Ꭲ' || charAtZero == 'Ꭳ' || charAtZero == 'Ꭴ' || charAtZero == 'Ꭵ')

        if (isVowelBeginning) {
            if (charAtZero == 'Ꭰ') {
                baseReturnValue = 'Ꮎ' + (baseReturnValue != '' ? baseReturnValue.substring(1) : data.substring(1));
            } else if (charAtZero == 'Ꭱ') {
                baseReturnValue = 'Ꮑ' + (baseReturnValue != '' ? baseReturnValue.substring(1) : data.substring(1));
            } else if (charAtZero == 'Ꭲ') {
                baseReturnValue = 'Ꮒ' + (baseReturnValue != '' ? baseReturnValue.substring(1) : data.substring(1));
            } else if (charAtZero == 'Ꭳ') {
                baseReturnValue = 'Ꮓ' + (baseReturnValue != '' ? baseReturnValue.substring(1) : data.substring(1));
            } else if (charAtZero == 'Ꭴ') {
                baseReturnValue = 'Ꮔ' + (baseReturnValue != '' ? baseReturnValue.substring(1) : data.substring(1));
            } else if (charAtZero == 'Ꭵ') {
                baseReturnValue = 'Ꮕ' + (baseReturnValue != '' ? baseReturnValue.substring(1) : data.substring(1));
            }
        } else {
            baseReturnValue =  "Ꮒ" + (baseReturnValue != '' ? baseReturnValue : data);
        }

        return baseReturnValue;
    }

    @Override
    String toEnglish(Object baseReturnValue, Object data, Object de, Object verbTense) {
        return null
    }

    String toString() {
        return Ni
    }
}
