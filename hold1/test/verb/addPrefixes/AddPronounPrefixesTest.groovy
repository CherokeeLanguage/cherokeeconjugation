package cherokee.dictionary.verb.addPrefixes

import cherokee.dictionary.utils.PartOfSpeech
import cherokee.dictionary.verb.conjugation.originalConjugation.Tense
import com.cobradoc.cherokee.SyllabaryUtil

class AddPronounPrefixesTest extends GroovyTestCase {
    def su = new SyllabaryUtil()
    public void testAddPronounPrefixesConsonant() {
        Word word = new Word()
        word.tense = Tense.PRESENT
        word.partOfSpeech = PartOfSpeech.VERB_INTRANSITIVE
        word.rootLatin = "woni"
        word.rootSyllabary = su.tsalagiToSyllabary(word.rootLatin)

        PronounProcessor.addPronounPrefix(word, "SG1SG3IN")
        assertTrue("ᏥᏬᏂ" == "${word.pronounPrefix.syllabary + word.rootSyllabary}")

        word.partOfSpeech = PartOfSpeech.VERB_TRANSITIVE
        word.rootLatin = "gowati"
        word.rootSyllabary = su.tsalagiToSyllabary(word.rootLatin)
        PronounProcessor.addPronounPrefix(word, "SG1SG3AN")
        assertTrue("ᏥᎪᏩᏘ" == (word.pronounPrefix.syllabary + word.rootSyllabary))
    }

    public void testAddPronounPrefixesVowel() {
        Word word = new Word()
        word.tense = Tense.PRESENT
        word.partOfSpeech = PartOfSpeech.VERB_INTRANSITIVE
        word.rootLatin = "oho"
        word.rootSyllabary = su.tsalagiToSyllabary(word.rootLatin)

        PronounProcessor.addPronounPrefix(word, "SG1SG3IN")
        assertTrue("ᎪᎰ" == (su.tsalagiToSyllabary(word.pronounPrefix.latin + word.rootLatin)))
    }
}