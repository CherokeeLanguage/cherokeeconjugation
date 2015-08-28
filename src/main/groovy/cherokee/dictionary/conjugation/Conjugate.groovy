package cherokee.dictionary.conjugation

import cherokee.dictionary.conjugation.conjugate.VerbType
import cherokee.dictionary.conjugation.stem.Stemmer

/**
 * Created by torr on 8/20/2015.
 */
class Conjugate {
    def conjugate(final String subject,
                  final String object,
                  final Stemmer stemmer,
                  final String tense,//verb tense
                  final String tmpVerbType){// vi or vt
        def verbType
        if (tmpVerbType == 'v.i.') {
            verbType = VerbType.INTRANSITIVE
        } else {
            verbType = VerbType.TRANSITIVE
        }

        return conjugate(subject, object, stemmer, tense, verbType);
    }

    def conjugate(final String subject,
                  final String object,
                  final Stemmer stemmer,
                  final String tense,//verb tense
                  final VerbType verbType) { // vi or vt
        VerbConjugationProcessor vcp = new VerbConjugationProcessor();
        vcp.process(subject, object, stemmer, tense, verbType);
    }
}
