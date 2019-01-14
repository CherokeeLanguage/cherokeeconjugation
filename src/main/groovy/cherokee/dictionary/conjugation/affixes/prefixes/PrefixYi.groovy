package cherokee.dictionary.conjugation.affixes.prefixes

import cherokee.dictionary.conjugation.affixes.Affix
import cherokee.dictionary.conjugation.util.StringUtility
import cherokee.dictionary.conjugation.wordFormation.Word
import com.cobradoc.cherokee.SyllabaryUtil
import org.codehaus.groovy.util.StringUtil

class PrefixYi implements Affix {
    String yi;

    @Override
    String toSyllabary(String baseReturnValue, Word word) {
        String data = word.pronounPrefix.syllabary + word.rootSyllabary
        baseReturnValue = baseReturnValue ?: data

        if (!word.prefixHolderObject.ji) {
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

        return baseReturnValue;
    }

    @Override
    String toEnglish(String baseReturnValue, Word word) {
        return null
    }

    String toString() {
        return yi
    }


}
