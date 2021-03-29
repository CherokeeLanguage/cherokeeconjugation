package cherokee.dictionary.hold.processors

import cherokee.dictionary.hold.conjugate.CompoundPrefixes
import cherokee.dictionary.utils.StringUtility
import cherokee.dictionary.hold.wordFormation.Affix
import cherokee.dictionary.hold.wordFormation.Word
import com.cobradoc.cherokee.SyllabaryUtil

import java.util.regex.Matcher
import java.util.regex.Pattern

class PronounProcessor {
    private static final def vowelPrefixList = []
    private static final def consonantPrefixList = []

    private static final def consonantPrefixSetLatin = [] as Set
    private static final def vowelPrefixSetLatin = [] as Set
    private static final def allPrefixes = [:]
    private static final Pattern p = Pattern.compile(/([a-z]{1,3})/)
    private static final su = new SyllabaryUtil()

    static {
        CompoundPrefixes.prefixes.each {
            def preVowel = it.value.preVowel
            def preConsonant = it.value.preConsonant
            def preVowelLatin
            def preConsonantLatin

            if (preVowel) {
                if (!vowelPrefixList.contains(preVowel)) {
                    vowelPrefixList << preVowel
                }

                Matcher m = p.matcher(preVowel)
                while (m.find()) {

                    //find the group with the latin chars
                    String tmp = m.group(0)

                    // replace those latin chars in the text with nothing
                    String text = preVowel.replaceAll(tmp, "")

                    //turn the remaining syllabary into latin and append the latin chars we just removed
                    String wholeTranslit = su.parseSyllabary(text) + tmp
//                    println preVowel + " -- " + wholeTranslit
                    //add those to the set
                    vowelPrefixSetLatin << wholeTranslit
                }
            }

            if (preConsonant) {
                if (!consonantPrefixList.contains(preConsonant)) {
                    consonantPrefixList << preConsonant
                    consonantPrefixSetLatin << su.parseSyllabary(preConsonant)
                }
            }
        }

        vowelPrefixSetLatin.each {
            it = it.replaceAll("ts", "j")
            it = it.replaceAll("qu", "gw")
            it = it.replaceAll("kw", "gw")
            allPrefixes.put(it, "vowel")
        }

        consonantPrefixSetLatin.each {
            it = it.replaceAll("ts", "j")
            it = it.replaceAll("qu", "gw")
            it = it.replaceAll("kw", "gw")
            allPrefixes.put(it, "consonant")
        }

        allPrefixes = allPrefixes.sort {-it.key.size() }

        //sort from largest to smallest in order to get the biggest data prefixes first
        vowelPrefixSetLatin = vowelPrefixSetLatin.sort { -it.value.size() }
        consonantPrefixSetLatin = consonantPrefixSetLatin.sort { -it.value.size() }

        //going to run these specifically because if we don't then they'll get merged unintentionally
//        vowelPrefixSetLatin.remove("h")
//        vowelPrefixSetLatin.remove("j")
//        vowelPrefixSetLatin.remove("G")
//        vowelPrefixSetLatin.remove("u")
//        println vowelPrefixSetLatin.join(", ")
//        println consonantPrefixSetLatin.join(",")
        allPrefixes.remove("h")
        allPrefixes.remove("j")
        allPrefixes.remove("G")
        allPrefixes.remove("u")
//        println allPrefixes.keySet().join(",")
    }

    //take a word and compound prefix and add the appropriate pronoun to the root of a word
    public static void addPronounPrefix(Word word, String compoundPrefix) {
        Affix pronounPrefix = new Affix()
        if (StringUtility.startsWithVowelLatin(word.rootLatin)) {
            pronounPrefix.syllabary = CompoundPrefixes.prefixes."${compoundPrefix}".preVowel
        } else {
            pronounPrefix.syllabary = CompoundPrefixes.prefixes."${compoundPrefix}".preConsonant
        }

        Pattern pattern = Pattern.compile(/([a-z]{1,3})/)
        Matcher m = pattern.matcher(pronounPrefix.syllabary)
        String match = ""
        while(m.find()) {
            match = m.group(0)
        }

        pronounPrefix.syllabary = pronounPrefix.syllabary.substring(0, (pronounPrefix.syllabary.size() - match.size()))
        pronounPrefix.latin = match

        word.pronounPrefix = pronounPrefix
    }

    //take a word and remove the pronoun prefixes
    public static void removePronounPrefix(Word word, String wholeWord) {
        String dataLatin = su.parseSyllabary(wholeWord)
        dataLatin = su.reverseReplace(dataLatin)

        boolean startsWithVowel = false;
        String latV = ""
        String latC = ""
        String prefixToRemove
        boolean startsWithConsonant = false;

        boolean foundMatch = false
        allPrefixes.each {
            def key = it.key
            if (dataLatin.startsWith(key) && !foundMatch) {
                foundMatch = true
                startsWithVowel = it.value == "vowel"
                startsWithConsonant = it.value == "consonant"
                if (startsWithVowel) {
                    latV = key
                }

                if (startsWithConsonant) {
                    latC = key
                }
            }
        }

        prefixToRemove = latV ? latV : latC

        if (dataLatin.startsWith("h") && !latC.startsWith("h")) {
            dataLatin = dataLatin.substring(1)
            word.rootSyllabary = su.tsalagiToSyllabary(dataLatin)
            word.pronounPrefix.latin = "h"
        } else if (dataLatin.startsWith("j") && !latC.startsWith("j")) {
            dataLatin = dataLatin.substring(1)
            word.rootSyllabary = su.tsalagiToSyllabary(dataLatin)
            word.pronounPrefix.latin = "j"
        } else if (dataLatin.startsWith("G") && !prefixToRemove.contains("in") && !prefixToRemove.contains("e")) {
            if (dataLatin.startsWith("gaw")) {
                dataLatin = dataLatin.substring(2)
                word.rootSyllabary = su.tsalagiToSyllabary(dataLatin)
                word.pronounPrefix.latin = "ga"
            } else {
                dataLatin = dataLatin.substring(1)
                word.rootSyllabary = su.tsalagiToSyllabary(dataLatin)
                word.pronounPrefix.latin = "G"
            }
        } else if (dataLatin.startsWith("u")) {//&& (latV && latV.size() == 1 && !latV.startsWith("u"))
            //if we add a u + a then we remove the a and keep the u
            dataLatin = dataLatin.substring(1)
            word.rootSyllabary = su.tsalagiToSyllabary("a" + dataLatin)
            word.pronounPrefix.latin = ""
            word.pronounPrefix.syllabary = ""
        } else {
            dataLatin = dataLatin.substring(prefixToRemove.size())
            word.pronounPrefix.syllabary = su.tsalagiToSyllabary(prefixToRemove)
            word.pronounPrefix.latin = prefixToRemove
            word.rootSyllabary = dataLatin ? su.tsalagiToSyllabary(dataLatin) : ''
        }
    }
}
