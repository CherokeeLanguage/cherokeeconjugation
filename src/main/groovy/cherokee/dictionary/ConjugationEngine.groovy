package cherokee.dictionary

import cherokee.conjugation.constants.VerbType
import cherokee.conjugation.stemming.Stemmer
import cherokee.conjugation.util.PartOfSpeech
import cherokee.dictionary.verb.conjugation.originalconjugation.Conjugate

class ConjugationEngine {
    public static conjugate(String text, PartOfSpeech partOfSpeech, Stemmer stemmer, String subject, String object, String tense) {
        if (partOfSpeech == PartOfSpeech.VERB_INTRANSITIVE || partOfSpeech == PartOfSpeech.VERB_TRANSITIVE) {
            VerbType verbType = partOfSpeech == PartOfSpeech.VERB_INTRANSITIVE ? VerbType.INTRANSITIVE : VerbType.TRANSITIVE

            Conjugate.conjugate(subject, object, stemmer, tense, verbType)
        } else {

        }
    }
}
