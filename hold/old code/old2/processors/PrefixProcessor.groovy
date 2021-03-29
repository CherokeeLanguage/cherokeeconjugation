package cherokee.dictionary.conjugation.affixes.processors

import cherokee.dictionary.conjugation.HolderWord
import PrefixHolderObject
import cherokee.dictionary.conjugation.affixes.prefixes.PrefixDe
import cherokee.dictionary.conjugation.affixes.prefixes.PrefixDi
import cherokee.dictionary.conjugation.affixes.prefixes.PrefixE
import cherokee.dictionary.conjugation.affixes.prefixes.PrefixGa
import cherokee.dictionary.conjugation.affixes.prefixes.PrefixI
import cherokee.dictionary.conjugation.affixes.prefixes.PrefixNi
import cherokee.dictionary.conjugation.affixes.prefixes.PrefixWi
import cherokee.dictionary.conjugation.affixes.prefixes.PrefixYi
import cherokee.dictionary.conjugation.conjugate.CompoundPrefixes
import cherokee.dictionary.conjugation.conjugate.Tense
import com.cobradoc.cherokee.SyllabaryUtil

import java.util.regex.Matcher
import java.util.regex.Pattern

class PrefixProcessor {
    private static def su = new SyllabaryUtil()
    private static final latinPronounPreVowelPrefixEndings = ['y', 'g','w','d','n', 'j', 'h']
    private static def vowelPrefixList = []
    private static def consonantPrefixList = []

    private static def consonantPrefixSetLatin = [] as Set
    private static def vowelPrefixSetLatin = [] as Set
    private static def allPrefixes = [:]
    private static Pattern p = Pattern.compile(/([a-z]{1,3})/)
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
//        vowelPrefixSetLatin.remove("g")
//        vowelPrefixSetLatin.remove("u")
//        println vowelPrefixSetLatin.join(", ")
//        println consonantPrefixSetLatin.join(",")
        allPrefixes.remove("h")
        allPrefixes.remove("j")
        allPrefixes.remove("g")
        allPrefixes.remove("u")
//        println allPrefixes.keySet().join(",")
    }

    public static String processPrefixesRemove(data, PrefixHolderObject pho, Tense verbTense) {
        return data
    }

    public static String processPrefixes(data, PrefixHolderObject pho, Tense verbTense) {
        def baseReturnValue = "";

        def yi = pho.yi
        def ji = pho.ji
        def wi = pho.wi
        def ni = pho.ni
        def de = pho.de
        def da = pho.da
        def di = pho.di
        def i = pho.i
        def ga = pho.ga
        def e = pho.e

        if (ga) {
            baseReturnValue = new PrefixGa().toSyllabary(null, data, de, null);
        }

        if (e) {
            baseReturnValue = new PrefixE().toSyllabary(null, data, de, null);
        }

        if (i) {
            baseReturnValue = new PrefixI().toSyllabary(baseReturnValue, data, de, verbTense);
        }

        if (di) {
            baseReturnValue = new PrefixDi().toSyllabary(baseReturnValue, data, de, verbTense);
        }

        if (de) {
            baseReturnValue = new PrefixDe().toSyllabary(baseReturnValue, null, de, null);
        }

        if (ni) {
            baseReturnValue = new PrefixNi().toSyllabary(baseReturnValue, data, de, verbTense);
        }

        if (wi) {
            baseReturnValue = new PrefixWi().toSyllabary(baseReturnValue, data, de, verbTense);
        }

        if (yi) {
            baseReturnValue = new PrefixYi().toSyllabary(baseReturnValue, data, de, verbTense);
        }

        if (baseReturnValue == '') {
            baseReturnValue = data;
        }

        return baseReturnValue
    }

    public static void removeAllPrefixes(HolderWord hw) {
        removePronounPrefix(hw)
    }

    private static void removePronounPrefix(HolderWord data) {
        String dataLatin = su.parseSyllabary(data.syllabary ? data.syllabary : '')
        dataLatin = dataLatin.replaceAll("ts", "j")
        dataLatin = dataLatin.replaceAll("qu", "gw")
        dataLatin = dataLatin.replaceAll("kw", "gw")

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
            data.syllabary = su.tsalagiToSyllabary(dataLatin)
            data.pho.pronounPrefixLatin = "h"
        } else if (dataLatin.startsWith("j") && !latC.startsWith("j")) {
            dataLatin = dataLatin.substring(1)
            data.syllabary = su.tsalagiToSyllabary(dataLatin)
            data.pho.pronounPrefixLatin = "j"
        } else if (dataLatin.startsWith("g") && !prefixToRemove.contains("in") && !prefixToRemove.contains("e") && !latC.startsWith("g")) {
            dataLatin = dataLatin.substring(1)
            data.syllabary = su.tsalagiToSyllabary(dataLatin)
            data.pho.pronounPrefixLatin = "g"
        } else if (dataLatin.startsWith("u") && (latV && latV.size() == 1 && !latV.startsWith("u"))) {
            dataLatin = dataLatin.substring(1)
            data.syllabary = su.tsalagiToSyllabary(dataLatin)
            data.pho.pronounPrefixLatin = "u"
            data.pho.pronounPrefixSyllabary = su.tsalagiToSyllabary("u")
        } else {
            dataLatin = dataLatin.substring(prefixToRemove.size())
            data.pho.pronounPrefixSyllabary = su.tsalagiToSyllabary(prefixToRemove)
            data.pho.pronounPrefixLatin = prefixToRemove
            data.syllabary = dataLatin ? su.tsalagiToSyllabary(dataLatin) : ''
        }
    }
}
