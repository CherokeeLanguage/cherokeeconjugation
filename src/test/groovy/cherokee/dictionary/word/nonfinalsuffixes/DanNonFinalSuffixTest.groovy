package cherokee.dictionary.word.nonfinalsuffixes

import cherokee.conjugation.constants.Tense
import cherokee.conjugation.constants.VerbPrefixTableObject
import cherokee.conjugation.constants.VerbPrefixTableSubject
import cherokee.dictionary.testutils.BaseTest
import cherokee.conjugation.verbal.Verb
import com.cobradoc.cherokee.SyllabaryUtil

//these tests are only to check the prefix pieces and not the verb conjugation itself
//pp 255-256 Durbin Feeling Dictionary
class DanNonFinalSuffixTest extends BaseTest {
    public void testVerbNonFinalSuffixDan() {
        //DF pp284 #23
        //dan before vowels
        //uwonihisdanelei
        Verb verb = new Verb()
        verb.verbSubject = VerbPrefixTableSubject.SG1
        verb.verbObject = VerbPrefixTableObject.SG2
        //tense doesn't matter here
        verb.tense = Tense.PRESENT
        verb.verbRootLatinPhonetic = "wonihis"
        verb.verbRootSuffixLatinPhonetic = "el"
        verb.finalSuffix.with {ei = true}
        verb.nonFinalSuffix.with {dan = true}
        verb.pronounPrefixLatin = "u"
        verb.pronounPrefixSyllabary = SyllabaryUtil.tsalagiToSyllabary(verb.pronounPrefixLatin)
        verb.verbRootSyllabary = SyllabaryUtil.tsalagiToSyllabary(verb.verbRootLatinPhonetic)
        basicAssertion(verb, SyllabaryUtil.tsalagiToSyllabary("uwonihisdanelei"))

        //DF pp 284 #24
        //dis before g
        //gawonihisdisgvi
        //cannot be present tense
        verb.tense = Tense.REMOTE_PAST
        verb.pronounPrefixLatin = "ga"
        verb.verbRootSuffixLatinPhonetic = "g"
        verb.finalSuffix.with {vi = true;ei = false}
        verb.pronounPrefixSyllabary = SyllabaryUtil.tsalagiToSyllabary(verb.pronounPrefixLatin)
        verb.verbRootSyllabary = SyllabaryUtil.tsalagiToSyllabary(verb.verbRootLatinPhonetic)
        basicAssertion(verb, SyllabaryUtil.tsalagiToSyllabary("gawonihisdisgvi"))

        //DF pp284 - made up
        //present tense changes dis before g to dih and removes the g
        verb.tense = Tense.PRESENT
        basicAssertion(verb, SyllabaryUtil.tsalagiToSyllabary("gawonihisdihvi"))

        //DF pp 284 #25
        verb.tense = Tense.PRESENT
        //TODO: I don't understand the suffix being /g/ when it should be /h/ anyway
        verb.verbRootSuffixLatinPhonetic = "g"
        verb.finalSuffix.with {vi = false; a = true}
        basicAssertion(verb, SyllabaryUtil.tsalagiToSyllabary("gawonihisdiha"))
    }
}
