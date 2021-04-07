package cherokee.conjugation.verbal

import groovy.test.GroovyTestCase
import net.cherokeedcitionary.ConjugationEngine
import net.cherokeedcitionary.core.Verb
import net.cherokeedcitionary.core.Word
import net.cherokeedcitionary.util.PartOfSpeech
import net.cherokeedcitionary.util.PrefixObject
import net.cherokeedcitionary.util.PrefixSubject
import net.cherokeedcitionary.util.Tense
import net.cherokeedcitionary.verbal.stemming.DefinitionLine
import net.cherokeedcitionary.verbal.stemming.Stemmer

class TestConjugation extends ConjugateBase {
    void testPastConjugation() {
        def tmpWord = new Word()

        tmpWord.partOfSpeech = PartOfSpeech.VERB_TRANSITIVE
        tmpWord.subject = PrefixSubject.SG3
        tmpWord.object = PrefixObject.SG1

        println heWantsIt.getRoot(Tense.REMOTE_PAST)

        println ConjugationEngine.conjugate(tmpWord, heWantsIt, Tense.REMOTE_PAST).getWholeWord()
    }

    void testPresentConjugation() {
        def tmpWord = new Word()

        tmpWord.partOfSpeech = PartOfSpeech.VERB_TRANSITIVE
        tmpWord.subject = PrefixSubject.SG3
        tmpWord.object = PrefixObject.SG1

        println heWantsIt.getRoot(Tense.PRESENT)

        println ConjugationEngine.conjugate(tmpWord, heWantsIt, Tense.PRESENT).getWholeWord()
    }

    void testPresentConjugationAN() {
        def tmpWord = new Word()

        tmpWord.partOfSpeech = PartOfSpeech.VERB_TRANSITIVE
        tmpWord.subject = PrefixSubject.SG3
        tmpWord.object = PrefixObject.SG3AN

        println heWantsIt.getRoot(Tense.PRESENT)

        println ConjugationEngine.conjugate(tmpWord, heWantsIt, Tense.PRESENT).getWholeWord()
    }

    void testHittingIt() {
        def stemmer = new Stemmer()
        stemmer.present3rd = new DefinitionLine(syllabary:"ᎬᏂᎭ")
        stemmer.present1st = new DefinitionLine(syllabary:"ᏥᏴᏂᎭ")
        stemmer.remotepast = new DefinitionLine(syllabary:"ᎤᏩᏂᎸᎢ")
        stemmer.habitual = new DefinitionLine(syllabary:"ᎬᏂᎰᎢ")
        stemmer.imperative = new DefinitionLine(syllabary:"ᎯᏴᏂᎦ")
        stemmer.infinitive = new DefinitionLine(syllabary:"ᎤᏩᏂᏍᏗ")

        Verb verb = new Verb()
        verb.stemmer = stemmer
        verb.tense = Tense.PRESENT
        verb.root = stemmer.getRootWithEnding(verb.tense)[0]
        verb.rootEnding = stemmer.getRootWithEnding(verb.tense)[1]

        new net.cherokeedcitionary.verbal.reflexive.Reflexive().toSyllabary("", verb)

        assertEquals("adad", verb.reflexivePrefixHolder)
    }
}
