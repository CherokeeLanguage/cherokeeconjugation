package net.cherokeedictionary.verb.affixes.nonFinalSuffixes


import net.cherokeedictionary.core.Verb
import net.cherokeedictionary.verb.affixes.Affix

class NonFinalSuffixIlo implements Affix{
    String ilo

    @Override
    String toSyllabary(String baseReturnValue, Verb word) {

        String data = word.pronounReflexiveRoot
        baseReturnValue = baseReturnValue ?: data



//        if (!word.prefixHolderObject.ji) {
//            def latin = new SyllabaryUtil().parseSyllabary(data)
//            def startsWithH = latin.startsWith('h')
//            if (startsWithH) {
//                latin = latin.substring(1)
//                baseReturnValue = new SyllabaryUtil().tsalagiToSyllabary(latin)
//            }
//            def charAtZero = baseReturnValue.charAt(0)
//
//            if (StringUtility.startsWithVowelSyllabary(baseReturnValue)) {
//                baseReturnValue = StringUtility.getOptionsByVowel(charAtZero, baseReturnValue, ['Ꮿ', 'Ᏸ', 'Ᏹ', 'Ᏺ', 'Ᏻ', 'Ᏼ'])
//            } else {
//                if (charAtZero == 'Ꮹ'
//                        || charAtZero == 'Ꮺ'
//                        || charAtZero == 'Ꮻ'
//                        || charAtZero == 'Ꮼ'
//                        || charAtZero == 'Ꮽ'
//                        || charAtZero == 'Ꮾ') {
//                    baseReturnValue = "Ᏻ" + baseReturnValue
//                } else {
//                    baseReturnValue = "Ᏹ" + baseReturnValue
//                }
//            }
//        }

        return baseReturnValue;
    }

    @Override
    String toEnglish(String baseReturnValue, Verb word) {
        return null
    }


    @Override
    public String toString() {
        return ilo
    }
}
