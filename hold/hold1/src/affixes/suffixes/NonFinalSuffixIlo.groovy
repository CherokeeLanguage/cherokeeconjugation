package cherokee.dictionary.hold.affixes.suffixes


import cherokee.dictionary.hold.affixes.Affix
import cherokee.dictionary.hold.wordFormation.Word

class NonFinalSuffixIlo implements Affix{
    String ilo

    @Override
    String toSyllabary(String baseReturnValue, Word word) {
        String data = word.pronounPrefix.syllabary + word.rootSyllabary
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
    String toEnglish(String baseReturnValue, Word word) {
        return null
    }


    @Override
    public String toString() {
        return ilo
    }
}
