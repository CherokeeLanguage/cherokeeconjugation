package net.cherokeedcitionary.verbal.processor

import net.cherokeedcitionary.core.Verb
import net.cherokeedcitionary.util.Morphemes
import net.cherokeedcitionary.util.PartOfSpeech
import net.cherokeedcitionary.util.PrefixObject
import net.cherokeedcitionary.util.Tense
import net.cherokeedcitionary.util.VerbSet
import net.cherokeedcitionary.verbal.Prefix
import net.cherokeedcitionary.verbal.VerbCompoundPrefix
import net.cherokeedcitionary.verbal.VerbCompoundPrefixes
import net.cherokeedcitionary.verbal.rules.RuleLaryngealAlteration
import net.cherokeedcitionary.verbal.rules.RuleUW
import net.cherokeedcitionary.verbal.stemming.VerbTenseHolder
import net.cherokeedictionary.transliteration.SyllabaryUtil

/**
 * Created by torr on 8/23/2015.
 */
class VerbConjugationProcessor {
    public void log(prints) {
        boolean isDebug = false;
        if (isDebug) {
            println prints
        }
    }

    static void process()

    //returns a String object of the entire verb conjugated with pronoun prefix
    static void processNew(Verb word) {
        VerbTenseHolder vth = new VerbTenseHolder(stemmer: word.stemmer)
        vth.process()
        def verbTense = word.tense
        //todo: find prefix for plurals (e.G. d-) -- probably detect if verb starts with /d-/ if it does then add a /d-/
        // - should wait until other prefixes are put together in whole? timo 22Sep15

        //this column matches - so intransitive specific code was removed in favor of using existing code and keys
        if (word.partOfSpeech == PartOfSpeech.VERB_INTRANSITIVE) {
            word.object = PrefixObject.SG3IN
        }

        def combinedSubjectObject = "${String.valueOf(word.subject)}${String.valueOf(word.object)}" //object ? "${subject}${object}" : "${subject}"

        if (combinedSubjectObject == "SG3SG3AN") {
            word.wholeWord = word.stemmer.present3rd.syllabary
//            return word.stemmer.present3rd.syllabary;
        }

        if (word.partOfSpeech == PartOfSpeech.VERB_INTRANSITIVE && combinedSubjectObject == "SG3SG3IN" && word.tense == verbTense.PRESENT) {
            word.wholeWord = word.stemmer.present3rd.syllabary
//            return word.stemmer.present3rd.syllabary;
        }

        def verbset = VerbSet.A

        //if du,nu,u,wu in 3rd sing present then set b rest are a
        def tempPresent3rd = word.stemmer.present3rd.syllabary
        if (tempPresent3rd.startsWith("Ꮪ")
                || tempPresent3rd.startsWith("Ꮔ")
                || tempPresent3rd.startsWith("Ꭴ")
                || tempPresent3rd.startsWith("Ꮽ")) {
            verbset = VerbSet.B
        }

        String verbToConjugate = ""

        switch (verbTense) {
            case Tense.PRESENT:
                verbToConjugate = vth.present;
                break;
            case Tense.REMOTE_PAST:
                verbToConjugate = vth.remotePast
                //remote past always starts with B - Durbin Feeling book pp21
                verbset = VerbSet.B
                break;
            case Tense.FUTURE_COMMAND:
                verbToConjugate = vth.futureCommand
                break;
            case Tense.HABITUAL:
                verbToConjugate = vth.habitual
                break;
            case Tense.INFINITIVE:
                verbToConjugate = vth.infinitive
                break;
        }

        def compoundPrefix

        try {
            if (verbset == VerbSet.B) {
                try {
                    compoundPrefix = VerbCompoundPrefixes."${combinedSubjectObject}B"
                } catch (Exception e) {
                    compoundPrefix = VerbCompoundPrefixes."${combinedSubjectObject}"
                }
            } else {
                compoundPrefix = VerbCompoundPrefixes."${combinedSubjectObject}"
            }
        } catch (Exception e) {
            //todo: need to throw this exception back out if anything goes wrong
            //todo: create new exception class to be thrown so we get the message back out
            compoundPrefix = null;
            throw e;
        }

        if (!compoundPrefix) {
            word.pronominalHolder = null
        }

//        println "compound prefix ${compoundPrefix}"
//        println "verbset ${verbset}"
//        println "tense ${word.tense.toString()}"
//        println "verbToConjugate ${SyllabaryUtil.parseSyllabary(verbToConjugate)}"

        String[] rootWithEnding = word.stemmer.getRootWithEnding(word.tense)
        word.root = rootWithEnding[0]
        word.rootEnding = rootWithEnding[1]

        // add the reflexive prefix and morph
        // add pronominals and morph
        VerbPronominalPrefixProcessor.processPrefixes(word, compoundPrefix, verbset, verbToConjugate)

        //add final suffixes and morph
        //add non-final suffixes and morph
        //root and morph ending
    }
}
