package net.cherokeedictionary.verb.affixes

import net.cherokeedictionary.core.Verb
import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.StringUtility

class ReflexivePrefix implements Affix {
    @Override
    String toSyllabary(String verbToConjugate, Verb verb) {
        if (verb.reflexiveHolderObject.isReflexive()) {
            if (verbToConjugate.startsWith("Ꭰ")) {
                verb.reflexivePrefix = "ᎠᏓ"
                verbToConjugate = verb.reflexivePrefix + verbToConjugate.substring(1)
            } else if (StringUtility.startsWithVowelSyllabary(verbToConjugate)) {
                def str = "d" + SyllabaryUtil.parseSyllabary(verbToConjugate.charAt(0) as String)
                def rv = SyllabaryUtil.tsalagiToSyllabary(str)
                verb.reflexivePrefix = "ᎠᏓ" + rv
                verbToConjugate = "ᎠᏓ" + rv + verbToConjugate.substring(1)
            } else {
                verb.reflexivePrefix = "ᎠᏓ"
                verbToConjugate = "ᎠᏓ" + verbToConjugate
            }
        }

        return verbToConjugate
    }

    @Override
    String toEnglish(String baseReturnValue, Verb verb) {
        return null
    }
}
