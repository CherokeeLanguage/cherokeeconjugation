package cherokee.dictionary.verb.nonfinalsuffix

import cherokee.dictionary.utils.StringUtility
import cherokee.dictionary.hold.conjugate.Tense
import cherokee.dictionary.hold.wordFormation.Word
import com.cobradoc.cherokee.SyllabaryUtil
import org.codehaus.groovy.util.StringUtil

class NonFinalSuffixIlo extends GroovyTestCase {
    static def syllabaryUtil = new SyllabaryUtil();

    public Word makeWord(String rootLatin) {
        Word word = new Word()
        word.tense = Tense.REMOTE_PAST
        word.subject = "SG3"
        word.object = "SG3"

        word.rootLatin = rootLatin;
        word.rootSyllabary = syllabaryUtil.tsalagiToSyllabary(word.rootLatin)

        return word;
    }

    public String valueTest(Word word, tenseSuffixLatin, Tense tense) {
        if (tense == Tense.IMMEDIATE_COMMAND) {
            return word.pronounPrefix.latin + word.rootLatin + "iloja"
        } else if (StringUtility.startsWithVowelLatin(tenseSuffixLatin)) {
            return word.pronounPrefix.latin + word.rootLatin + "ilo?" + tenseSuffixLatin
        } else if (!StringUtility.startsWithVowelLatin(tenseSuffixLatin)) {
            return word.pronounPrefix.latin + word.rootLatin + "ilos" + tenseSuffixLatin
        }
    }

    public void testIloBeforeVowel() {
        def uwonisei = "uwonise?i" // uwonisilo?e?i
        def gawonisgvi = "gawonisgv?i" // gawonisilosgv?i
        def hiwonihi = "hiwonihi" //hiwonisiloja

        Word word = makeWord("wonis")

//        def tenseSuffixSyllabary = syllabaryUtil.tsalagiToSyllabary("ei")
//        def tenseSuffixLatin = syllabaryUtil.parseSyllabary(tenseSuffixSyllabary)

        println valueTest(word, "ei", Tense.REMOTE_PAST)
        println valueTest(word, "gvi", Tense.PRESENT)
        println valueTest(word, "hi", Tense.IMMEDIATE_COMMAND)

        //before vowels with glottal stop -- ilo
        //before consonants -- ilos
        //before imperative suffix -a -- iloj


    }
}
