package cherokee.dictionary.processors.verb

import cherokee.dictionary.affixes.Affix
import cherokee.dictionary.affixes.prefixes.verb.initialPrefixes.PrefixDa
import cherokee.dictionary.affixes.prefixes.verb.initialPrefixes.PrefixDe
import cherokee.dictionary.affixes.prefixes.verb.initialPrefixes.PrefixDi
import cherokee.dictionary.affixes.prefixes.verb.initialPrefixes.PrefixE
import cherokee.dictionary.affixes.prefixes.verb.initialPrefixes.PrefixGa
import cherokee.dictionary.affixes.prefixes.verb.initialPrefixes.PrefixI
import cherokee.dictionary.affixes.prefixes.verb.initialPrefixes.PrefixJi
import cherokee.dictionary.affixes.prefixes.verb.initialPrefixes.PrefixNi
import cherokee.dictionary.affixes.prefixes.verb.initialPrefixes.PrefixWi
import cherokee.dictionary.affixes.prefixes.verb.initialPrefixes.PrefixYi
import cherokee.dictionary.affixes.suffixes.verb.nonFinalSuffixes.NonFinalSuffixDan
import cherokee.dictionary.word.Verb
import cherokee.dictionary.word.Word
import com.cobradoc.cherokee.SyllabaryUtil

class VerbAffixFactory {
    private static LinkedList<Affix> initialPrefixes = new LinkedList<Affix>();

    static {
        initialPrefixes << new PrefixGa()
        initialPrefixes << new PrefixE()
        initialPrefixes << new PrefixI()
        initialPrefixes << new PrefixDi()
        initialPrefixes << new PrefixDa()
        initialPrefixes << new PrefixDe()
        initialPrefixes << new PrefixNi()
        initialPrefixes << new PrefixWi()
        initialPrefixes << new PrefixYi()
        initialPrefixes << new PrefixJi()
    }

    public static void process(Verb word) {
        if (!word.initialPrefix.allFalse()) {
            println "inside all false"
            processInitialPrefixes(word)
        } else {
            word.wholePrefixLatin = word.pronounPrefixLatin
        }

        processNonFinalSuffixes(word)
        processFinalSuffixes(word)

//        word.verbRootSyllabary = str
        word.verbRootLatinPhonetic = word.verbRootSyllabary != null ? new SyllabaryUtil().parseSyllabary(word.verbRootSyllabary) : ""
    }

    public static void processInitialPrefixes(word) {
        def baseReturnValue = null;
        def data = word.verbRootSyllabary
        def pho = word.initialPrefix

        //TODO: Figure out why return is null when it should be something else
        //      this is how I want the prefixes to all be run
//        initialPrefixes.each {
//            println it.getClass()
//            baseReturnValue = it.toSyllabary(baseReturnValue, word)
//            println baseReturnValue
//        }

        if (pho.ga) {
            baseReturnValue = new PrefixGa().toSyllabary(null, word);
        }

        if (pho.i) {
            baseReturnValue = new PrefixI().toSyllabary(baseReturnValue, word);
        }

        if (pho.di) {
            baseReturnValue = new PrefixDi().toSyllabary(baseReturnValue, word);
        }

        if (pho.da) {
            baseReturnValue = new PrefixDa().toSyllabary(baseReturnValue, word);
        }

        if (pho.de) {
            baseReturnValue = new PrefixDe().toSyllabary(baseReturnValue, word);
        }

        if (pho.e) {
            baseReturnValue = new PrefixE().toSyllabary(baseReturnValue, word);
        }

        if (pho.ni) {
            baseReturnValue = new PrefixNi().toSyllabary(baseReturnValue, word);
        }

        if (pho.wi) {
            baseReturnValue = new PrefixWi().toSyllabary(baseReturnValue, word);
        }

        if (pho.yi) {
            baseReturnValue = new PrefixYi().toSyllabary(baseReturnValue, word);
        }

        if (pho.ji) {
            baseReturnValue = new PrefixJi().toSyllabary(baseReturnValue, word);
        }

        if (baseReturnValue == '') {
            baseReturnValue = data;
        }

        word.wholePrefixLatin = ""
        word.verbRootSyllabary = baseReturnValue
    }

    private static void processNonFinalSuffixes(Word word) {
        def nonFinalSuffixValue = ""

        if (word.nonFinalSuffix.dan) {
            word.verbNonFinalSuffixPhonetic = new NonFinalSuffixDan().toSyllabary(null, word)
        }
    }

    private static void processFinalSuffixes(Word word) {}
}
