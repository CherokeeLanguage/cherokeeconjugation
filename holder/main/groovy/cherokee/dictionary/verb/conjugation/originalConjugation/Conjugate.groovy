package cherokee.dictionary.verb.conjugation.originalconjugation

import cherokee.conjugation.verbal.enums.VerbType
import cherokee.conjugation.verbal.stemming.Stemmer

/**
 * Created by torr on 8/20/2015.
 */
class Conjugate {
    static def conjugate(final String subject,
                         final String object,
                         final Stemmer stemmer,
                         final String tense,//verb tense
                         final String tmpVerbType){// vi or vt
        return conjugate(subject, object, stemmer, tense, getVerbType(tmpVerbType));
    }

    static def conjugate(final String subject,
                  final String object,
                  final Stemmer stemmer,
                  final String tense,//verb tense
                  final VerbType verbType) { // vi or vt
        VerbConjugationProcessor.process(subject, object, stemmer, tense, verbType);
    }

    static def conjugateToVerbObject(final String subject,
                                     final String object,
                                     final Stemmer stemmer,
                                     final String tense,//verb tense
                                     final String tmpVerbType) { // vi or vt

        VerbConjugationProcessor.processVerb(subject, object, stemmer, tense, tmpVerbType);
    }

    static def getVerbType(tmpVerbType) {
        def verbType
        if (tmpVerbType == 'v.i.' || tmpVerbType == 'vi') {
            verbType = VerbType.INTRANSITIVE
        } else {
            verbType = VerbType.TRANSITIVE
        }

        return verbType
    }

}
