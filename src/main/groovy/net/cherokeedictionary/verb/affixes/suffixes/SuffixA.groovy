package net.cherokeedictionary.verb.affixes.suffixes

import net.cherokeedictionary.core.Verb
import net.cherokeedictionary.verb.affixes.Affix

class SuffixA implements Affix {
    String suffix = "Ꭰ"

    @Override
    String toSyllabary(String baseReturnValue, Verb word) {
    	//does the end of the value need to change based on the suffix - so uu = uw kind of thing?
        return baseReturnValue.endsWith(suffix) ? baseReturnValue : baseReturnValue + suffix
    }

    @Override
    String toEnglish(String baseReturnValue, Verb word) {
        return null
    }

    String toString() {
        return suffix
    }
}
