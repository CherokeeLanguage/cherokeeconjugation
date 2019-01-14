package cherokee.dictionary.conjugation.affixes.prefixes

import cherokee.dictionary.conjugation.affixes.Affix
import cherokee.dictionary.conjugation.conjugate.Tense
import cherokee.dictionary.conjugation.wordFormation.Word
import com.cobradoc.cherokee.SyllabaryUtil

class PrefixDe implements Affix {
    String de;

    @Override
    String toSyllabary(Object baseReturnValue, Word word) {
        String data = word.pronounPrefix.syllabary + word.rootSyllabary
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

        def latin = new SyllabaryUtil().parseSyllabary(data)
        def startsWithH = latin.startsWith('h')

        if (word.prefixHolderObject.da || word.prefixHolderObject.di) {
            baseReturnValue = "Ꮩ" + (baseReturnValue != '' ? baseReturnValue : data);
        } else {
            def charAtZero = baseReturnValue != '' ? baseReturnValue.charAt(0) : data.charAt(0);
            boolean isVowelBeginning = (charAtZero == 'Ꭰ' || charAtZero == 'Ꭱ' || charAtZero == 'Ꭲ' || charAtZero == 'Ꭳ' || charAtZero == 'Ꭴ' || charAtZero == 'Ꭵ')

            if (isVowelBeginning) {
                if (verbTense == Tense.INFINITIVE
                        || verbTense == Tense.FUTURE_COMMAND) {
                    if (charAtZero == 'Ꭰ') {
                        baseReturnValue = 'Ꮧ' + (baseReturnValue != '' ? baseReturnValue.substring(1) : data.substring(1));
                    } else if (charAtZero == 'Ꭱ') {
                        baseReturnValue = 'Ꮴ' + (baseReturnValue != '' ? baseReturnValue.substring(1) : data.substring(1));
                    } else if (charAtZero == 'Ꭲ') {
                        baseReturnValue = 'Ꮵ' + (baseReturnValue != '' ? baseReturnValue.substring(1) : data.substring(1));
                    } else if (charAtZero == 'Ꭳ') {
                        baseReturnValue = 'Ꮶ' + (baseReturnValue != '' ? baseReturnValue.substring(1) : data.substring(1));
                    } else if (charAtZero == 'Ꭴ') {
                        baseReturnValue = 'Ꮷ' + (baseReturnValue != '' ? baseReturnValue.substring(1) : data.substring(1));
                    } else if (charAtZero == 'Ꭵ') {
                        baseReturnValue = 'Ꮸ' + (baseReturnValue != '' ? baseReturnValue.substring(1) : data.substring(1));
                    }
                } else {
                    if (charAtZero == 'Ꭰ') {
                        baseReturnValue = 'Ꮣ' + (baseReturnValue != '' ? baseReturnValue.substring(1) : data.substring(1));
                    } else if (charAtZero == 'Ꭱ') {
                        baseReturnValue = 'Ꮥ' + (baseReturnValue != '' ? baseReturnValue.substring(1) : data.substring(1));
                    } else if (charAtZero == 'Ꭲ') {
                        baseReturnValue = 'Ꮥ' + (baseReturnValue != '' ? baseReturnValue.substring(1) : data.substring(1));
                    } else if (charAtZero == 'Ꭳ') {
                        baseReturnValue = 'Ꮩ' + (baseReturnValue != '' ? baseReturnValue.substring(1) : data.substring(1));
                    } else if (charAtZero == 'Ꭴ') {
                        baseReturnValue = 'Ꮪ' + (baseReturnValue != '' ? baseReturnValue.substring(1) : data.substring(1));
                    } else if (charAtZero == 'Ꭵ') {
                        baseReturnValue = 'Ꮫ' + (baseReturnValue != '' ? baseReturnValue.substring(1) : data.substring(1));
                    }
                }
            } else {
                if (word.prefixHolderObject.yi
                        || word.prefixHolderObject.wi
                        || word.prefixHolderObject.ni
                        || verbTense == Tense.INFINITIVE
                        || verbTense == Tense.FUTURE_COMMAND) {
                    if (isVowelBeginning) {
                        if (charAtZero == 'Ꭰ') {
                            baseReturnValue = 'Ꮣ' + (baseReturnValue != '' ? baseReturnValue.substring(1) : data.substring(1));
                        } else if (charAtZero == 'Ꭱ') {
                            baseReturnValue = 'Ꮥ' + (baseReturnValue != '' ? baseReturnValue.substring(1) : data.substring(1));
                        } else if (charAtZero == 'Ꭲ') {
                            baseReturnValue = 'Ꮧ' + (baseReturnValue != '' ? baseReturnValue.substring(1) : data.substring(1));
                        } else if (charAtZero == 'Ꭳ') {
                            baseReturnValue = 'Ꮩ' + (baseReturnValue != '' ? baseReturnValue.substring(1) : data.substring(1));
                        } else if (charAtZero == 'Ꭴ') {
                            baseReturnValue = 'Ꮪ' + (baseReturnValue != '' ? baseReturnValue.substring(1) : data.substring(1));
                        } else if (charAtZero == 'Ꭵ') {
                            baseReturnValue = 'Ꮫ' + (baseReturnValue != '' ? baseReturnValue.substring(1) : data.substring(1));
                        }
                    } else {
                        baseReturnValue = "Ꮧ" + (baseReturnValue != '' ? baseReturnValue : data);
//                        baseReturnValue = "Ꮥ" + (baseReturnValue != '' ? baseReturnValue : data);
                    }
                } else {
                    baseReturnValue = "Ꮥ" + (baseReturnValue != '' ? baseReturnValue : data);
                }
            }

            if (baseReturnValue.startsWith("Ꮧ")) {
                if (startsWithH) {
                    baseReturnValue = new SyllabaryUtil().tsalagiToSyllabary('t' + latin.substring(1))
                }
            }
        }


        return baseReturnValue;
    }

    @Override
    String toEnglish(Object baseReturnValue, Word word) {
        return null
    }

    String toString() {
        return de
    }
}
