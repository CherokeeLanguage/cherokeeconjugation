package net.cherokeedcitionary.verbal.reflexive

import net.cherokeedcitionary.core.Verb
import net.cherokeedcitionary.util.StringUtility
import net.cherokeedcitionary.verbal.Affix

class Reflexive implements Affix {
    @Override
    String toSyllabary(String baseReturnValue, Verb word) {
        if (word.root.startsWith("a")) {
            word.reflexivePrefixHolder = "ad"
        } else if (StringUtility.startsWithVowelLatin(word.root)) {
            word.reflexivePrefixHolder = "adad"
        } else {
            word.reflexivePrefixHolder = "ada"
        }
    }

    @Override
    String toEnglish(String baseReturnValue, Verb word) {
        return null
    }
}
