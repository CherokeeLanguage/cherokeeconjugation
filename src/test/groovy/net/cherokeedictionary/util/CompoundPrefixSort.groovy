package net.cherokeedictionary.util

/**
 * iterate over the compound prefixes and then sort them by length so the start of a word is parsed in descending order
 * print that out as a map for javascript
 */

import net.cherokeedictionary.transliteration.SyllabaryUtil

def vowels = new HashMap()
def consonants = new HashMap()

CompoundPrefixes.prefixes.each {key, val ->
    if (val.preVowel && val.preConsonant) {
        vowels.put(SyllabaryUtil.parseSyllabaryWithPunctuationAndLatin(val.preVowel), key);
        consonants.put(SyllabaryUtil.parseSyllabaryWithPunctuationAndLatin(val.preConsonant), key);
    } else {
        if (val.preVowel && !val.preConsonant) {
            println key + " vowel is not empty but consonant is"
        } else if (val.preConsonant && !val.preVowel) {
            println key + " consonant is not empty but vowel is"
        }
    }
}


// https://stackoverflow.com/questions/25899929/in-java-sort-hash-map-by-its-key-length
Map<String, Integer> treeMap = new TreeMap<String, Integer>(
    new Comparator<String>() {
        @Override
        public int compare(String s1, String s2) {
            if (s1.length() > s2.length()) {
                return -1;
            } else if (s1.length() < s2.length()) {
                return 1;
            } else {
                return s1.compareTo(s2);
            }
        }
    });

treeMap.putAll(vowels)

treeMap.each {
    println "VowelPrefixes.set(\"${it.key.toLowerCase()}\", \"${it.value}\");"
}

treeMap.clear();
treeMap.putAll(consonants);

treeMap.each {
    println "ConsonantPrefixes.set(\"${it.key.toLowerCase()}\", \"${it.value}\");"
}