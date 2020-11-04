package cherokee.dictionary.word.prefixes

import cherokee.conjugation.constants.Tense
import cherokee.conjugation.constants.VerbPrefixTableObject
import cherokee.conjugation.constants.VerbPrefixTableSubject
import cherokee.dictionary.testutils.BaseTest
import cherokee.dictionary.word.Verb
import com.cobradoc.cherokee.SyllabaryUtil

//these tests are only to check the prefix pieces and not the verb conjugation itself
//pp 252-254 Durbin Feeling Dictionary
class DiVerbTest extends BaseTest {

    public void atestVerbDi() {
        Verb verb = new Verb()
        verb.verbSubject = VerbPrefixTableSubject.SG1
        verb.verbObject = VerbPrefixTableObject.SG2
        verb.tense = Tense.PRESENT
        verb.initialPrefix.with {di = true}
        verb.verbRootLatinPhonetic = "woni"
        verb.verbRootSuffixLatinPhonetic = "h"
//        verb.finalSuffix.a = true// {a = true}
        verb.finalSuffix.with {a = true}
        verb.pronounPrefixLatin = "ga"
        verb.pronounPrefixSyllabary = SyllabaryUtil.tsalagiToSyllabary(verb.pronounPrefixLatin)
        verb.verbRootSyllabary = SyllabaryUtil.tsalagiToSyllabary(verb.verbRootLatinPhonetic)
        basicAssertion(verb, SyllabaryUtil.tsalagiToSyllabary("digawoniha"))

        verb.verbRootLatinPhonetic = "go"
        verb.pronounPrefixLatin = "u"
        verb.finalSuffix.with {a = false;ei = true}
        verb.verbRootSyllabary = SyllabaryUtil.tsalagiToSyllabary(verb.verbRootLatinPhonetic)
        verb.pronounPrefixSyllabary = SyllabaryUtil.tsalagiToSyllabary(verb.pronounPrefixLatin)
        basicAssertion(verb, SyllabaryUtil.tsalagiToSyllabary("jugohei"))

        verb.verbRootLatinPhonetic = "gowati"
        verb.pronounPrefixLatin = "a"
        verb.finalSuffix.with {a = true;ei = false}
        verb.verbRootSyllabary = SyllabaryUtil.tsalagiToSyllabary(verb.verbRootLatinPhonetic)
        verb.pronounPrefixSyllabary = SyllabaryUtil.tsalagiToSyllabary(verb.pronounPrefixLatin)
        basicAssertion(verb, SyllabaryUtil.tsalagiToSyllabary("digowatiha"))

        verb.verbRootLatinPhonetic = "gowati"
        verb.pronounPrefixLatin = "iji"
        verb.finalSuffix.with {a = true;ei = false}
        verb.verbRootSyllabary = SyllabaryUtil.tsalagiToSyllabary(verb.verbRootLatinPhonetic)
        verb.pronounPrefixSyllabary = SyllabaryUtil.tsalagiToSyllabary(verb.pronounPrefixLatin)
        basicAssertion(verb, SyllabaryUtil.tsalagiToSyllabary("dijigowatiha"))

        verb.verbRootLatinPhonetic = "go"
        verb.pronounPrefixLatin = "u"
        verb.finalSuffix.with {a = true;vi = false}
        verb.verbRootSyllabary = SyllabaryUtil.tsalagiToSyllabary(verb.verbRootLatinPhonetic)
        verb.pronounPrefixSyllabary = SyllabaryUtil.tsalagiToSyllabary(verb.pronounPrefixLatin)
//        basicAssertion(verb, SyllabaryUtil.tsalagiToSyllabary("dayugohvi"))

        verb.verbRootLatinPhonetic = "gowati"
        verb.pronounPrefixLatin = "u"
        verb.finalSuffix.with {a = false; vi = true}
        verb.verbRootSuffixLatinPhonetic = "sg"
        verb.verbRootSyllabary = SyllabaryUtil.tsalagiToSyllabary(verb.verbRootLatinPhonetic)
        verb.pronounPrefixSyllabary = SyllabaryUtil.tsalagiToSyllabary(verb.pronounPrefixLatin)
//        basicAssertion(verb, SyllabaryUtil.tsalagiToSyllabary("dvgowatisgvi"))

        verb.verbRootLatinPhonetic = "gowati"
        verb.pronounPrefixLatin = "ini"
        verb.finalSuffix.with {a = false;vi = true}
        verb.verbRootSuffixLatinPhonetic = "sg"
        verb.verbRootSyllabary = SyllabaryUtil.tsalagiToSyllabary(verb.verbRootLatinPhonetic)
        verb.pronounPrefixSyllabary = SyllabaryUtil.tsalagiToSyllabary(verb.pronounPrefixLatin)
//        basicAssertion(verb, SyllabaryUtil.tsalagiToSyllabary("danigowatisgvi"))

        verb.verbRootLatinPhonetic = "gowati"
        verb.pronounPrefixLatin = "ini"
        verb.finalSuffix.with {a = true;vi = false; di = true}
        verb.verbRootSuffixLatinPhonetic = "tv"
        verb.verbRootSyllabary = SyllabaryUtil.tsalagiToSyllabary(verb.verbRootLatinPhonetic)
        verb.pronounPrefixSyllabary = SyllabaryUtil.tsalagiToSyllabary(verb.pronounPrefixLatin)
//        basicAssertion(verb, SyllabaryUtil.tsalagiToSyllabary("nidayugowatvdi"))
    }
}
