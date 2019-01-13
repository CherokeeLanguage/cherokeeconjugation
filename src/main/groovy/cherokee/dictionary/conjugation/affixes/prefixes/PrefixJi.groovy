package cherokee.dictionary.conjugation.affixes.prefixes

import cherokee.dictionary.conjugation.affixes.Affix
import cherokee.dictionary.conjugation.wordFormation.Word

class PrefixJi implements Affix {
    String ji;

    @Override
    String toSyllabary(Object baseReturnValue, Word word) {
        String data = word.pronounPrefix.syllabary + word.rootSyllabary
        def de = word.prefixHolderObject.de
        def verbTense = word.tense

        def charAtZero = baseReturnValue != '' ? baseReturnValue.charAt(0) : data.charAt(0);
        boolean isVowelBeginning = (charAtZero == 'Ꭰ' || charAtZero == 'Ꭱ' || charAtZero == 'Ꭲ' || charAtZero == 'Ꭳ' || charAtZero == 'Ꭴ' || charAtZero == 'Ꭵ')
        //if yi -add n- or ni- then "-na jigi"
        if (word.prefixHolderObject.yi || word.prefixHolderObject.ga) {
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
                baseReturnValue = (word.prefixHolderObject.yi ? "Ꮒ" : "") + (baseReturnValue != '' ? baseReturnValue : data) + "Ꮎ ᏥᎩ";
            }
        } else {
            if (isVowelBeginning) {
                if (charAtZero == 'Ꭰ') {
                    baseReturnValue = 'Ꮳ' + (baseReturnValue != '' ? baseReturnValue.substring(1) : data.substring(1));
                } else if (charAtZero == 'Ꭱ') {
                    baseReturnValue = 'Ꮴ' + (baseReturnValue != '' ? baseReturnValue.substring(1) : data.substring(1));
                } else if (charAtZero == 'Ꭲ') {
                    baseReturnValue = 'Ꮵ' + (baseReturnValue != '' ? baseReturnValue.substring(1) : data.substring(1));
                } else if (charAtZero == 'Ꭳ') {
                    baseReturnValue = 'Ꮶ' + (baseReturnValue != '' ? baseReturnValue.substring(1) : data.substring(1));
                } else if (charAtZero == 'Ꭴ') {
                    baseReturnValue = 'Ꮷ' + (baseReturnValue != '' ? baseReturnValue.substring(1) : data.substring(1));
                } else if (charAtZero == 'Ꭵ') {
                    baseReturnValue = 'Ꮸ' + (baseReturnValue != '' ? baseReturnValue.substring(1) : data.substring(1));
                }
            } else {
                if (charAtZero == 'Ꮹ' || charAtZero == 'Ꮺ' || charAtZero == 'Ꮻ' || charAtZero == 'Ꮼ' || charAtZero == 'Ꮽ' || charAtZero == 'Ꮾ') {
                    baseReturnValue = "Ꮸ" + (baseReturnValue != '' ? baseReturnValue : data);
                } else {
                    baseReturnValue = "Ꮵ" + (baseReturnValue != '' ? baseReturnValue : data);
                }
            }
        }

        return baseReturnValue
    }

    @Override
    String toEnglish(Object baseReturnValue, Word word) {
        return null
    }

    String toString() {
        return ji
    }
}
