package cherokee.dictionary.verb.wordBreakdown
import cherokee.dictionary.utils.PartOfSpeech
import cherokee.dictionary.hold.conjugate.Tense
import cherokee.dictionary.hold.processors.VerbPrefixFactory
import cherokee.dictionary.hold.wordFormation.Word
import com.cobradoc.cherokee.SyllabaryUtil

class BreakdownTest extends GroovyTestCase {
    public void testBreakdown() {
        Word word = new Word()
        word.partOfSpeech = PartOfSpeech.VERB_INTRANSITIVE
        word.rootLatin = "higowatiha"
        word.tense = Tense.REMOTE_PAST
        word.subject = "SG1"
        word.rootSyllabary = new SyllabaryUtil().tsalagiToSyllabary(word.rootLatin)
        word.prefixHolderObject.with {
//            yi = true
//            ji = true
//            ni = true
//            ga = true
            da = true
            de = true
            di = true
//            i = true
//            wi = true
        }

        VerbPrefixFactory.process(word)

        println "root " + word.rootSyllabary
        println "prefixes " + word.wholePrefixes.syllabary
    }


}
