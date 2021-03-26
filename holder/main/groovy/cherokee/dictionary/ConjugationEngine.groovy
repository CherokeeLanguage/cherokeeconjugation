package cherokee.dictionary

import cherokee.conjugation.util.PartOfSpeech
import cherokee.conjugation.verbal.enums.VerbType
import cherokee.conjugation.verbal.stemming.Stemmer
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
