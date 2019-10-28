package cherokee.dictionary.verb.conjugation.originalConjugation

import cherokee.dictionary.verb.conjugation.originalConjugation.Stemmer
import cherokee.dictionary.verb.conjugation.originalConjugation.VerbType


/**
 * Created by torr on 8/20/2015.
 */
class Conjugate {
    static def conjugate(final String subject,
                         final String object,
                         final Stemmer stemmer,
                         final String tense,//verb tense
                         final String tmpVerbType){// vi or vt
        def verbType
        if (tmpVerbType == 'v.i.' || tmpVerbType == 'vi') {
            verbType = VerbType.INTRANSITIVE
        } else {
            verbType = VerbType.TRANSITIVE
        }

        return conjugate(subject, object, stemmer, tense, verbType);
    }

    static def conjugate(final String subject,
                  final String object,
                  final Stemmer stemmer,
                  final String tense,//verb tense
                  final VerbType verbType) { // vi or vt
        VerbConjugationProcessor.process(subject, object, stemmer, tense, verbType);
    }
}
