package cherokee.dictionary.conjugation.affixes.processors

import cherokee.dictionary.conjugation.HolderWord
import cherokee.dictionary.conjugation.affixes.PrefixHolderObject
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

        //sort from largest to smallest in order to get the biggest data prefixes first
        vowelPrefixSetLatin = vowelPrefixSetLatin.sort { -it.value.size() }
        consonantPrefixSetLatin = consonantPrefixSetLatin.sort { -it.value.size() }

        //going to run these specifically because if we don't then they'll get merged unintentionally
        vowelPrefixSetLatin.remove("h")
        vowelPrefixSetLatin.remove("j")
        vowelPrefixSetLatin.remove("g")
//        println vowelPrefixSetLatin.join(", ")
//        println consonantPrefixSetLatin.join(", ")
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
        String dataLatin = su.parseSyllabary(data.syllabary)

        boolean startsWithVowel = false;
        String latV = ""
        String latC = ""
        boolean startsWithConsonant = false;

        vowelPrefixSetLatin.each {
            if (dataLatin.startsWith(it)) {
                latV = dataLatin.substring(it.size())
                startsWithVowel = true
            }
        }

        consonantPrefixSetLatin.each {
            if (dataLatin.startsWith(it)) {
                latC = dataLatin.substring(it.size())
                startsWithConsonant = true;
            }
        }

        //check consonants then vowels then look for the three individual letters we removed at the top
        if (startsWithConsonant) {
            data.syllabary = su.tsalagiToSyllabary(latC)
            def tmp = dataLatin.substring(0, dataLatin.indexOf(latC))
            def tmp2 = su.tsalagiToSyllabary(tmp)
            //a byproduct of the syllabary util is a data is invalid meaning a character wasn't able to be transliterated to syllabary (like an h, j, k, or other single latin character
            data.pho.pronounPrefixSyllabary = tmp2.indexOf("data is invalid") ? "" : tmp2
            data.pho.pronounPrefixLatin = tmp
        } else if (startsWithVowel) {
            data.syllabary = su.tsalagiToSyllabary(latV)
            def tmp = dataLatin.substring(0, dataLatin.indexOf(latV))
            def tmp2 = su.tsalagiToSyllabary(tmp)
            data.pho.pronounPrefixSyllabary = tmp2.indexOf("data is invalid") ? "" : tmp2
            data.pho.pronounPrefixLatin = tmp
        } else if (dataLatin.startsWith("h")) {
            dataLatin = dataLatin.substring(1)
            data.syllabary = su.tsalagiToSyllabary(dataLatin)
            data.pho.pronounPrefixLatin = "h"
        } else if (dataLatin.startsWith("j")) {
            dataLatin = dataLatin.substring(1)
            data.syllabary = su.tsalagiToSyllabary(dataLatin)
            data.pho.pronounPrefixLatin = "j"
        } else if (dataLatin.startsWith("g")) {
            dataLatin = dataLatin.substring(1)
            data.syllabary = su.tsalagiToSyllabary(dataLatin)
            data.pho.pronounPrefixLatin = "g"
        }

        if (dataLatin.startsWith("a")
                || dataLatin.startsWith("e")
                || dataLatin.startsWith("i")
                || dataLatin.startsWith("o")
                || dataLatin.startsWith("u")
                || dataLatin.startsWith("v")) {
            data.pho.pronounPrefixLatin = dataLatin.substring(0, 1)
            data.pho.pronounPrefixSyllabary = su.tsalagiToSyllabary(data.pho.pronounPrefixLatin)
            dataLatin = dataLatin.substring(1)
            data.syllabary = su.tsalagiToSyllabary(dataLatin)
        }
    }
}
