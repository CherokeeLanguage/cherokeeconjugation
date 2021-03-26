package cherokee.dictionary.processors.verb

import cherokee.dictionary.affixes.Affix
import cherokee.dictionary.affixes.prefixes.verb.initialprefixes.PrefixDa
import cherokee.dictionary.affixes.prefixes.verb.initialprefixes.PrefixDe
import cherokee.dictionary.affixes.prefixes.verb.initialprefixes.PrefixDi
import cherokee.dictionary.affixes.prefixes.verb.initialprefixes.PrefixE
import cherokee.dictionary.affixes.prefixes.verb.initialprefixes.PrefixGa
import cherokee.dictionary.affixes.prefixes.verb.initialprefixes.PrefixI
import cherokee.dictionary.affixes.prefixes.verb.initialprefixes.PrefixJi
import cherokee.dictionary.affixes.prefixes.verb.initialprefixes.PrefixNi
import cherokee.dictionary.affixes.prefixes.verb.initialprefixes.PrefixWi
import cherokee.dictionary.affixes.prefixes.verb.initialprefixes.PrefixYi
import cherokee.dictionary.affixes.suffixes.verb.nonfinalsuffixes.NonFinalSuffixDan
import cherokee.conjugation.verbal.Verb
import net.cherokeedictionary.transliteration.SyllabaryUtil

class VerbAffixFactory {
    private static LinkedList<Affix> initialprefixes = new LinkedList<Affix>();

    static {
        initialprefixes << new PrefixGa()
        initialprefixes << new PrefixE()
        initialprefixes << new PrefixI()
        initialprefixes << new PrefixDi()
        initialprefixes << new PrefixDa()
        initialprefixes << new PrefixDe()
        initialprefixes << new PrefixNi()
        initialprefixes << new PrefixWi()
        initialprefixes << new PrefixYi()
        initialprefixes << new PrefixJi()
    }

    public static void process(Verb word) {
        if (!word.initialPrefix.allFalse()) {
            processinitialprefixes(word)
        } else {
            word.wholePrefixLatin = word.pronounPrefixLatin
        }

        processNonFinalSuffixes(word)
        processFinalSuffixes(word)

        word.verbRootLatinPhonetic = word.verbRootSyllabary != null ? SyllabaryUtil.parseSyllabary(word.verbRootSyllabary) : ""
    }

    public static void processinitialprefixes(word) {
        def baseReturnValue = null;
        def data = word.verbRootSyllabary
        def pho = word.initialPrefix

        //TODO: Figure out why return is null when it should be something else
        //      this is how I want the prefixes to all be run
//        initialprefixes.each {
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

    private static void processNonFinalSuffixes(Verb word) {
        def nonFinalSuffixValue = ""

        if (word.nonFinalSuffix.dan) {
            word.verbNonFinalSuffixPhonetic = new NonFinalSuffixDan().toSyllabary(null, word)
        }
    }

    private static void processFinalSuffixes(Verb word) {}
}
