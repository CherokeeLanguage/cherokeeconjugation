package net.cherokeedictionary.util

import net.cherokeedictionary.transliteration.SyllabaryUtil

class CompoundPrefixLookup extends GroovyTestCase {
    void testCompoundPrefixLookup() {
        def lookupString = SyllabaryUtil.parseSyllabary("ᎢᏍᎩ") + "y"
        println lookupString
        String phonetic = lookupString//SyllabaryUtil.parseSyllabary(lookupString)
        def endsWithVowel = false;
        if (phonetic.endsWith("v")) {
            endsWithVowel = true;
        }

        CompoundPrefixes.prefixes.entrySet().each {
            if (endsWithVowel) {
                if (SyllabaryUtil.parseSyllabaryWithPunctuationAndLatin(it.value.preConsonant) == phonetic) {
                    println it
                }
            } else {
                def preVowel = SyllabaryUtil.parseSyllabaryWithPunctuationAndLatin(it.value.preVowel)
//                println phonetic

                if (preVowel == phonetic) {
                    println it.key
                }
            }
        }
    }
}
