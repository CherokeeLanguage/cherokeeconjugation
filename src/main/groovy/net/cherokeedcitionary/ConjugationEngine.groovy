package net.cherokeedcitionary

import net.cherokeedcitionary.core.Verb
import net.cherokeedcitionary.core.Word
import net.cherokeedcitionary.util.PartOfSpeech
import net.cherokeedcitionary.util.PrefixObject
import net.cherokeedcitionary.util.PrefixSubject
import net.cherokeedcitionary.util.Tense
import net.cherokeedcitionary.verbal.processor.VerbConjugationProcessor
import net.cherokeedcitionary.verbal.stemming.Stemmer

class ConjugationEngine {
    public static conjugate(String partOfSpeech, Stemmer stemmer, String subject, String object, String tense) {
        def word = new Word()
        word.partOfSpeech = PartOfSpeech.valueOf(partOfSpeech)
        word.subject = PrefixSubject.valueOf(subject)
        word.object = PrefixObject.valueOf(object)
        return conjugate(word, stemmer, tense)
    }

    /**
     * Take text and provide the pieces.  Process as noun/adj or verb
     *
     * @param text
     * @param partOfSpeech
     * @param stemmer
     * @param subject
     * @param object
     * @param tense
     */
    public static conjugate(Word word, stemmer, tense) {
        if (word.partOfSpeech == PartOfSpeech.VERB_INTRANSITIVE || word.partOfSpeech == PartOfSpeech.VERB_TRANSITIVE) {
            Verb verb = new Verb(partOfSpeech: word.partOfSpeech, subject: word.subject, object: word.object, stemmer: stemmer, tense: tense)
            VerbConjugationProcessor.process(verb)
            return verb
        } else {

        }
    }

    /**
     * Takes syllabary and breaks it down into it's parts which can then be deconstructed into a meaningful value
     *
     * @param syllabary
     */
    public static breakdown(String syllabary) {

    }
}
