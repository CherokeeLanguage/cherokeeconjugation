package cherokee.dictionary

import cherokee.dictionary.verb.conjugation.originalConjugation.Conjugate

import cherokee.dictionary.utils.PartOfSpeech
import cherokee.dictionary.verb.conjugation.originalConjugation.Stemmer
import cherokee.dictionary.verb.conjugation.originalConjugation.VerbType

class ConjugationEngine {
    public static conjugate(String text, PartOfSpeech partOfSpeech, Stemmer stemmer, String subject, String object, String tense) {
        if (partOfSpeech == PartOfSpeech.VERB_INTRANSITIVE || partOfSpeech == PartOfSpeech.VERB_TRANSITIVE) {
            VerbType verbType = partOfSpeech == PartOfSpeech.VERB_INTRANSITIVE ? VerbType.INTRANSITIVE : VerbType.TRANSITIVE

            Conjugate.conjugate(subject, object, stemmer, tense, verbType)
        } else {

        }
    }
}
