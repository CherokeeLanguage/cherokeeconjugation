package cherokee.dictionary.word.prefixes

import cherokee.conjugation.constants.Tense
import cherokee.conjugation.constants.VerbPrefixTableObject
import cherokee.conjugation.constants.VerbPrefixTableSubject
import cherokee.dictionary.testutils.BaseTest
import cherokee.dictionary.word.Verb
import com.cobradoc.cherokee.SyllabaryUtil

//these tests are only to check the prefix pieces and not the verb conjugation itself
//pp 255-256 Durbin Feeling Dictionary
class EVerbTest extends BaseTest {
    public void atestVerbE() {
        Verb verb = new Verb()
        verb.verbSubject = VerbPrefixTableSubject.SG1
        verb.verbObject = VerbPrefixTableObject.SG2
        verb.tense = Tense.PRESENT
        verb.initialPrefix.with {e = true}
        verb.verbRootLatinPhonetic = "gowati"
        verb.verbRootSuffixLatinPhonetic = "h"
        verb.finalSuffix.with {a = true}

        verb.pronounPrefixLatin = "sdi"
        verb.pronounPrefixSyllabary = SyllabaryUtil.tsalagiToSyllabary(verb.pronounPrefixLatin)
        verb.verbRootSyllabary = SyllabaryUtil.tsalagiToSyllabary(verb.verbRootLatinPhonetic)

        basicAssertion(verb, SyllabaryUtil.tsalagiToSyllabary("esdigowatiha"))

        verb.initialPrefix.with {e = true; de = true}
        verb.verbRootLatinPhonetic = "gowati"
        verb.pronounPrefixLatin = "sdi"
        verb.verbRootSyllabary = SyllabaryUtil.tsalagiToSyllabary(verb.verbRootLatinPhonetic)
        verb.pronounPrefixSyllabary = SyllabaryUtil.tsalagiToSyllabary(verb.pronounPrefixLatin)
//        basicAssertion(verb, SyllabaryUtil.tsalagiToSyllabary("dodisdigowatiha"))
    }
}
