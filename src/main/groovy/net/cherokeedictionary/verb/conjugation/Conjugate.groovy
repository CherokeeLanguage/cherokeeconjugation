package net.cherokeedictionary.verb.conjugation

import net.cherokeedictionary.core.Verb
import net.cherokeedictionary.stemmer.Stemmer
import net.cherokeedictionary.util.CompoundPrefixes
import net.cherokeedictionary.util.ConjugationHelper
import net.cherokeedictionary.util.PartOfSpeech
import net.cherokeedictionary.util.PrefixTableObject
import net.cherokeedictionary.util.PrefixTableSubject
import net.cherokeedictionary.util.Tense
import net.cherokeedictionary.verb.affixes.PrefixProcessor
import net.cherokeedictionary.verb.conjugation.VerbConjugationProcessor
import net.cherokeedictionary.verb.containers.FinalSuffixProcessor
import net.cherokeedictionary.verb.containers.NonFinalSuffixProcessor

/**
 * Created by torr on 8/20/2015.
 */
class Conjugate {
    static def createVerbToConjugate(final String subject,
                                     final String object,
                                     final Stemmer stemmer,
                                     final String tense,//verb tense
                                     final String partOfSpeech,
                                     final boolean isReflexive) {
        Verb verb = new Verb()
        verb.stemmer = stemmer
        verb.reflexiveHolderObject.reflexive = isReflexive

        ConjugationHelper.determinePartOfSpeech(verb, partOfSpeech)
        ConjugationHelper.determineSubjectObject(verb, subject, object)
        ConjugationHelper.determineTense(verb, tense)

        return verb
    }

    static Verb conjugate(final String subject,
                         final String object,
                         final Stemmer stemmer,
                         final String tense,
                         final String partOfSpeech,
                         final boolean isReflexive) { // vi or vt
        return conjugate(createVerbToConjugate(subject, object, stemmer, tense, partOfSpeech, isReflexive))
    }

    static Verb conjugate(final Verb verb) {
        ConjugationHelper.determineVerbSet(verb)
        ConjugationHelper.determineCompoundPrefix(verb)

        if (verb.compoundPrefix) {
            verb.pronounReflexiveRoot = VerbConjugationProcessor.process(verb)
            verb.wholeWord = PrefixProcessor.process(verb)
            verb.wholeWord = NonFinalSuffixProcessor.process(verb)
            verb.wholeWord = FinalSuffixProcessor.process(verb)
        } else {
            verb.pronounReflexiveRoot = "      "
            verb.wholeWord = "       "
        }

        return verb
    }
}
