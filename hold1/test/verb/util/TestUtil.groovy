package cherokee.dictionary.verb.util

import cherokee.dictionary.utils.PartOfSpeech
import cherokee.dictionary.hold.conjugate.Tense
import cherokee.dictionary.hold.processors.VerbPrefixFactory
import cherokee.dictionary.hold.wordFormation.Word
import com.cobradoc.cherokee.SyllabaryUtil

class TestUtil {
    public static Word createWord(rootLatin, tense = Tense.PRESENT, Closure pho) {
        def map = [:]
        map.partOfSpeech = PartOfSpeech.VERB_INTRANSITIVE
        map.rootLatin = rootLatin
        map.tense = tense
        map.subject = "SG1"
        map.object = "SG3IN"
        map.rootSyllabary = new SyllabaryUtil().tsalagiToSyllabary(rootLatin)
        map.prefixHolderObject = pho
        return createWord(map)
    }

    public static Word createWord(Map map) {
        Word word = new Word()
        word.partOfSpeech = map.partOfSpeech
        word.rootLatin = map.rootLatin
        word.tense = map.tense
        word.subject = map.subject
        word.object = map.object
        word.rootSyllabary = map.rootSyllabary
        word.prefixHolderObject.with map.prefixHolderObject

        return word
    }

    public static void basicAssertion(rootLatin, tense = Tense.PRESENT, assertion, Closure pho) {
        Word word = createWord(rootLatin, tense, pho)

        VerbPrefixFactory.process(word)

        GroovyTestCase.assertEquals("does not match", assertion, word.rootSyllabary)
    }
}
