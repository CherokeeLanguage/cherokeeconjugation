package cherokee.dictionary.affixes.prefixes.verb.initialPrefixes

import cherokee.dictionary.affixes.Affix
import cherokee.dictionary.utils.StringUtility
import cherokee.dictionary.word.Verb
import cherokee.dictionary.word.Word
import com.cobradoc.cherokee.SyllabaryUtil

class PrefixWi implements Affix {
    String wi;


    String toSyllabary(String baseReturnValue, Verb word) {
        if (word.initialPrefix.wi) {
            String data = word.pronounPrefixSyllabary + word.rootSyllabary
            baseReturnValue = baseReturnValue ?: data

            def latin = new SyllabaryUtil().parseSyllabary(baseReturnValue)
            def startsWithH = latin.startsWith('h')
            if (startsWithH) {
                latin = latin.substring(1)
                baseReturnValue = new SyllabaryUtil().tsalagiToSyllabary(latin)
            }
            def charAtZero = baseReturnValue.charAt(0)

            if (StringUtility.startsWithVowelSyllabary(baseReturnValue)) {
                baseReturnValue = StringUtility.getOptionsByVowel(charAtZero, baseReturnValue, ['Ꮹ', 'Ꮺ', 'Ꮻ', 'Ꮼ', 'Ꮽ', 'Ꮾ'])
            } else {
                baseReturnValue = "Ꮻ" + (baseReturnValue != '' ? baseReturnValue : data);
            }
        }

        return baseReturnValue;
    }


    String toEnglish(String baseReturnValue, Verb word) {
        return null
    }

    String toString() {
        return wi
    }
}
