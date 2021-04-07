package net.cherokeedictionary.verb.affixes.initialPrefixes

import net.cherokeedictionary.core.Verb
import net.cherokeedictionary.util.StringUtility
import net.cherokeedictionary.verb.affixes.Affix

class PrefixNi implements Affix {
    String Ni;


    String toSyllabary(String baseReturnValue, Verb word) {
        if (word.initialPrefixHolder.ni) {
            String data = word.pronounReflexiveRoot
            baseReturnValue = baseReturnValue ?: data

            def charAtZero = baseReturnValue.charAt(0)

            if (StringUtility.startsWithVowelSyllabary(baseReturnValue)) {
                baseReturnValue = StringUtility.getOptionsByVowel(charAtZero, baseReturnValue, ['Ꮎ', 'Ꮑ', 'Ꮒ', 'Ꮓ', 'Ꮔ', 'Ꮕ'])
            } else {
                baseReturnValue = "Ꮒ" + baseReturnValue
            }
        }

        return baseReturnValue;
    }


    String toEnglish(String baseReturnValue, Verb word) {
        return null
    }

    String toString() {
        return Ni
    }
}
