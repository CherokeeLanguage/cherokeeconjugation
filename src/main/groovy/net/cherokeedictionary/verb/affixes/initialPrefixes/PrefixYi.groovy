package net.cherokeedictionary.verb.affixes.initialPrefixes

import net.cherokeedictionary.core.Verb
import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.StringUtility
import net.cherokeedictionary.verb.affixes.Affix

class PrefixYi implements Affix {
    String yi;

    String toSyllabary(String baseReturnValue, Verb word) {
        if (word.initialPrefixHolder.yi) {
            String data = word.pronounReflexiveRoot
            baseReturnValue = baseReturnValue ?: data

            if (!word.initialPrefixHolder.ji) {
                def latin = SyllabaryUtil.parseSyllabary(data)
                def startsWithH = latin.startsWith('h')
                if (startsWithH) {
                    latin = latin.substring(1)
                    baseReturnValue = SyllabaryUtil.tsalagiToSyllabary(latin)
                }

                def charAtZero = baseReturnValue.charAt(0)

                if (StringUtility.startsWithVowelSyllabary(baseReturnValue)) {
                    baseReturnValue = StringUtility.getOptionsByVowel(charAtZero, baseReturnValue, ['Ꮿ', 'Ᏸ', 'Ᏹ', 'Ᏺ', 'Ᏻ', 'Ᏼ'])
                } else {
                    if (charAtZero == 'Ꮹ'
                            || charAtZero == 'Ꮺ'
                            || charAtZero == 'Ꮻ'
                            || charAtZero == 'Ꮼ'
                            || charAtZero == 'Ꮽ'
                            || charAtZero == 'Ꮾ') {
                        baseReturnValue = "Ᏻ" + baseReturnValue
                    } else {
                        baseReturnValue = "Ᏹ" + baseReturnValue
                    }
                }
            }
        }

        return baseReturnValue;
    }

    String toEnglish(String baseReturnValue, Verb word) {
        return null
    }

    String toString() {
        return yi
    }
}
