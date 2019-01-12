package cherokee.dictionary.wordBreakdown

import cherokee.dictionary.conjugation.affixes.PrefixHolderObject
import cherokee.dictionary.conjugation.conjugate.CompoundPrefixes
import cherokee.dictionary.conjugation.conjugate.PartOfSpeech
import cherokee.dictionary.conjugation.conjugate.Tense
import cherokee.dictionary.conjugation.processors.PronounProcessor
import cherokee.dictionary.conjugation.processors.VerbPrefixFactory
import cherokee.dictionary.conjugation.wordFormation.Word
import com.cobradoc.cherokee.SyllabaryUtil

class BreakdownTest extends GroovyTestCase {
    public void testBreakdown() {
        Word word = new Word()
        word.partOfSpeech = PartOfSpeech.VERB_INTRANSITIVE
        word.rootLatin = "jiwoni"
        word.tense = Tense.REMOTE_PAST
        word.subject = "SG1"
        word.rootSyllabary = new SyllabaryUtil().tsalagiToSyllabary("jiwoni")
        word.prefixHolderObject.with {
            yi = true
            ni = true
            ga = true
            de = true
            i = true
        }

        VerbPrefixFactory.process(word)

        println "root " + word.rootSyllabary
        println "prefixes " + word.wholePrefixes.syllabary
    }
}
