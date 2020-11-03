package cherokee.dictionary.affixes.prefixes.verb.initialprefixes

import cherokee.dictionary.affixes.Affix
import cherokee.dictionary.utils.StringUtility
import cherokee.dictionary.word.Verb
import com.cobradoc.cherokee.SyllabaryUtil

class PrefixYi implements Affix {
    String yi;


    String toSyllabary(String baseReturnValue, Verb word) {
        if (word.initialPrefix.yi) {
            String data = word.pronounPrefixSyllabary + word.verbRootSyllabary
            baseReturnValue = baseReturnValue ?: data

            if (!word.initialPrefix.ji) {
                def latin = new SyllabaryUtil().parseSyllabary(data)
                def startsWithH = latin.startsWith('h')
                if (startsWithH) {
                    latin = latin.substring(1)
                    baseReturnValue = new SyllabaryUtil().tsalagiToSyllabary(latin)
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
