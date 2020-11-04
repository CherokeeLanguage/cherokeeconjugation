package cherokee.dictionary.affixes.prefixes.verb.initialprefixes

import cherokee.conjugation.constants.Tense
import cherokee.conjugation.util.StringUtility
import cherokee.dictionary.affixes.Affix
import cherokee.dictionary.word.Verb
import com.cobradoc.cherokee.SyllabaryUtil

class PrefixDe implements Affix {
    String de;


    String toSyllabary(String baseReturnValue, Verb word) {
        if (word.initialPrefix.de) {
            String data = word.pronounPrefixSyllabary + word.verbRootSyllabary

            def verbTense = word.tense

//        /de- consonants d- vowels except -i-
//        /de- + -i- = de-
//        /after y-, w-, n- de = di unless followed by a vowel
//        /de- = di- in infinitive and imperative when followed by a consonant
//        /de- = j- in infinitive and imperative when followed by a vowel other than a-
//        /when followed by a- de- becomes di-
//        ****if  de becomes di (above) and precedes -h- then it becomes t- (dehi + wi- = widehi = widihi = witi)
//        de = do future tense
//        /de = do before da- prefix
//        /de = do before di- prefix
//        Feeling Dictionary

            def latin = SyllabaryUtil.parseSyllabary(data)
            def startsWithH = latin.startsWith('h')
            baseReturnValue = baseReturnValue ?: data

            if (word.initialPrefix.da || word.initialPrefix.di) {
                baseReturnValue = "Ꮩ" + baseReturnValue
            } else {
                def charAtZero = baseReturnValue != '' ? baseReturnValue.charAt(0) : data.charAt(0);
                boolean isVowelBeginning = StringUtility.startsWithVowelSyllabary(baseReturnValue)

                if (isVowelBeginning) {
                    if (verbTense == Tense.INFINITIVE
                            || verbTense == Tense.FUTURE_COMMAND) {
                        baseReturnValue = StringUtility.getOptionsByVowel(charAtZero, baseReturnValue, ['Ꮧ', 'Ꮴ', 'Ꮵ', 'Ꮶ', 'Ꮷ', 'Ꮸ'])
                    } else {
                        baseReturnValue = StringUtility.getOptionsByVowel(charAtZero, baseReturnValue, ['Ꮣ', 'Ꮥ', 'Ꮥ', 'Ꮩ', 'Ꮪ', 'Ꮫ'])
                    }
                } else {
                    if (word.initialPrefix.yi
                            || word.initialPrefix.wi
                            || word.initialPrefix.ni
                            || verbTense == Tense.INFINITIVE
                            || verbTense == Tense.FUTURE_COMMAND) {
                        if (isVowelBeginning) {
                            baseReturnValue = StringUtility.getOptionsByVowel(charAtZero, baseReturnValue, ['Ꮣ', 'Ꮥ', 'Ꮥ', 'Ꮩ', 'Ꮪ', 'Ꮫ'])
                        } else {
                            baseReturnValue = "Ꮧ" + baseReturnValue
//                        baseReturnValue = "Ꮥ" + baseReturnValue
                        }
                    } else {
                        baseReturnValue = "Ꮥ" + baseReturnValue
                    }
                }

                if (baseReturnValue.startsWith("Ꮧ")) {
                    if (startsWithH) {
                        baseReturnValue = SyllabaryUtil.tsalagiToSyllabary('t' + latin.substring(1))
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
        return de
    }
}
