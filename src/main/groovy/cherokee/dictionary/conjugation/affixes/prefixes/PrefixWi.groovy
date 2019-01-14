package cherokee.dictionary.conjugation.affixes.prefixes

import cherokee.dictionary.conjugation.affixes.Affix
import cherokee.dictionary.conjugation.util.StringUtility
import cherokee.dictionary.conjugation.wordFormation.Word
import com.cobradoc.cherokee.SyllabaryUtil

class PrefixWi implements Affix {
    String wi;

    @Override
    String toSyllabary(String baseReturnValue, Word word) {
        String data = word.pronounPrefix.syllabary + word.rootSyllabary
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

        return baseReturnValue;
    }

    @Override
    String toEnglish(String baseReturnValue, Word word) {
        return null
    }

    String toString() {
        return wi
    }
}
