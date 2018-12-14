package cherokee.dictionary.conjugation.affixes.prefixes

import cherokee.dictionary.conjugation.affixes.Affix

class PrefixDe implements Affix {
    String de;

    @Override
    String toSyllabary(Object baseReturnValue, Object data, Object de, Object verbTense) {
        if (baseReturnValue.startsWith('Ꮧ')) {
            baseReturnValue = 'Ꮩ' + baseReturnValue;
        } else {
//            baseReturnValue = 'Ꭱ' + baseReturnValue;
        }

        return baseReturnValue;
    }

    @Override
    String toEnglish(Object baseReturnValue, Object data, Object de, Object verbTense) {
        return null
    }

    String toString() {
        return de
    }
}
