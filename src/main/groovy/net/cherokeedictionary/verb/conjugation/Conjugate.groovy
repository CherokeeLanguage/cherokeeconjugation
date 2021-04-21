package net.cherokeedictionary.verb.conjugation

import net.cherokeedictionary.core.Verb
import net.cherokeedictionary.stemmer.Stemmer
import net.cherokeedictionary.util.CompoundPrefixes
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
    static def conjugate(final String subject,
                         final String object,
                         final Stemmer stemmer,
                         final String tense,//verb tense
                         final String tmpVerbType,
                         boolean isReflexive = false){// vi or vt
        def verbType
        if (tmpVerbType == 'v.i.' || tmpVerbType == 'vi') {
            verbType = PartOfSpeech.VERB_INTRANSITIVE
        } else {
            verbType = PartOfSpeech.VERB_TRANSITIVE
        }

        return conjugate(subject, object, stemmer, tense, verbType, isReflexive);
    }

    static def conjugate(final String subject,
                         final String object,
                         final Stemmer stemmer,
                         final String tense,//verb tense
                         final PartOfSpeech verbType,
                         final boolean isReflexive) { // vi or vt
        //todo: could this eventually be something that valueOf is overridden so if the value is blank it returns NONE?  Valueof cannot be overridden so idk
        PrefixTableObject pobj
        if (object && object != "") {
            pobj = PrefixTableObject.valueOf(object)
        } else {
            pobj = PrefixTableObject.NONE
        }

        Verb verb = new Verb()
        verb.subject = PrefixTableSubject.valueOf(subject)
        verb.object = pobj
        verb.stemmer = stemmer
        verb.tense = Tense.valueOf(tense)
        verb.partOfSpeech = verbType
        verb.reflexiveHolderObject.reflexive = isReflexive

        verb = conjugate(verb)
        return verb
    }

    static def conjugate(final Verb verb) {
        def compoundPrefix = null

        try {
            compoundPrefix = CompoundPrefixes."${verb.subject.toString()}${verb.object.toString()}"
        } catch (Exception e) {
        }

        if (compoundPrefix) {
            verb.pronounReflexiveRoot = VerbConjugationProcessor.process(verb);
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
