package net.cherokeedictionary.verb.affixes.nonFinalSuffixes

import net.cherokeedictionary.core.Verb
import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.StringUtility
import net.cherokeedictionary.util.Tense
import net.cherokeedictionary.verb.affixes.Affix

class NonFinalSuffixDan implements Affix {
    String dan;

    String toString() {
        return dan
    }

    String toSyllabary(String baseReturnValue, Verb word) {
        def nonFinalSuffix = ""

        if (word.nonFinalSuffixHolder.dan) {

            //dan before vowels
            //dis before g
            //present tense dis before g = dih
            //dan plus di (inifinitive suffix) = dohdi
            //  dan before imperative -a = d

            def data = word.getTenseValue()
            if (StringUtility.startsWithVowelLatin(data)) {
                if (word.tense == Tense.IMMEDIATE_COMMAND) {
                    nonFinalSuffix = 'd'
                } else {
                    nonFinalSuffix = 'dan'
                }
            } else {
                if (data.startsWith("g")) {
                    if (word.tense == Tense.PRESENT) {
                        nonFinalSuffix = "dih"
                        word.rootEnding = data.substring(1)
                    } else {
                        nonFinalSuffix = "dis"
                    }
                } else if (data.startsWith("di")) {
                    nonFinalSuffix = "do"
                } else {
                    println "nothing happening"
                }
            }

//            def data = word.pronounPrefixSyllabary + word.rootSyllabary
//            baseReturnValue = baseReturnValue ?: data
//            def charAtZero = baseReturnValue.charAt(0)
//            def isVowelBeginning = StringUtility.startsWithVowelSyllabary(baseReturnValue)
//
//            if (data.startsWith("Ꭰ")) {//da + a = dv
//                baseReturnValue = "Ꮫ" + baseReturnValue.substring(1);
//            } else {
//                return baseReturnValue = "Ꮣ" + baseReturnValue
//            }

            def phoneticWholeWord = SyllabaryUtil.parseSyllabary(word.wholeWord)
            nonFinalSuffix = SyllabaryUtil.tsalagiToSyllabary(phoneticWholeWord.substring(0, phoneticWholeWord.lastIndexOf(word.rootEnding)) + nonFinalSuffix + data)
        }

        return nonFinalSuffix ?: word.wholeWord
    }

    String toEnglish(String baseReturnValue, Verb word) {
        return null
    }
}
