package cherokee.old.word.prefixes

import cherokee.dictionary.affixes.prefixes.verb.VerbPrefixTableObject
import cherokee.dictionary.affixes.prefixes.verb.VerbPrefixTableSubject
import cherokee.dictionary.testUtils.BaseTest
import cherokee.dictionary.verb.conjugation.originalConjugation.Tense
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
        verb.pronounPrefixSyllabary = new SyllabaryUtil().tsalagiToSyllabary(verb.pronounPrefixLatin)
        verb.verbRootSyllabary = new SyllabaryUtil().tsalagiToSyllabary(verb.verbRootLatinPhonetic)
        basicAssertion(verb, new SyllabaryUtil().tsalagiToSyllabary("digawoniha"))

        verb.verbRootLatinPhonetic = "go"
        verb.pronounPrefixLatin = "u"
        verb.finalSuffix.with {a = false;ei = true}
        verb.verbRootSyllabary = new SyllabaryUtil().tsalagiToSyllabary(verb.verbRootLatinPhonetic)
        verb.pronounPrefixSyllabary = new SyllabaryUtil().tsalagiToSyllabary(verb.pronounPrefixLatin)
        basicAssertion(verb, new SyllabaryUtil().tsalagiToSyllabary("jugohei"))

        verb.verbRootLatinPhonetic = "gowati"
        verb.pronounPrefixLatin = "a"
        verb.finalSuffix.with {a = true;ei = false}
        verb.verbRootSyllabary = new SyllabaryUtil().tsalagiToSyllabary(verb.verbRootLatinPhonetic)
        verb.pronounPrefixSyllabary = new SyllabaryUtil().tsalagiToSyllabary(verb.pronounPrefixLatin)
        basicAssertion(verb, new SyllabaryUtil().tsalagiToSyllabary("digowatiha"))

        verb.verbRootLatinPhonetic = "gowati"
        verb.pronounPrefixLatin = "iji"
        verb.finalSuffix.with {a = true;ei = false}
        verb.verbRootSyllabary = new SyllabaryUtil().tsalagiToSyllabary(verb.verbRootLatinPhonetic)
        verb.pronounPrefixSyllabary = new SyllabaryUtil().tsalagiToSyllabary(verb.pronounPrefixLatin)
        basicAssertion(verb, new SyllabaryUtil().tsalagiToSyllabary("dijigowatiha"))

        verb.verbRootLatinPhonetic = "go"
        verb.pronounPrefixLatin = "u"
        verb.finalSuffix.with {a = true;vi = false}
        verb.verbRootSyllabary = new SyllabaryUtil().tsalagiToSyllabary(verb.verbRootLatinPhonetic)
        verb.pronounPrefixSyllabary = new SyllabaryUtil().tsalagiToSyllabary(verb.pronounPrefixLatin)
//        basicAssertion(verb, new SyllabaryUtil().tsalagiToSyllabary("dayugohvi"))

        verb.verbRootLatinPhonetic = "gowati"
        verb.pronounPrefixLatin = "u"
        verb.finalSuffix.with {a = false; vi = true}
        verb.verbRootSuffixLatinPhonetic = "sg"
        verb.verbRootSyllabary = new SyllabaryUtil().tsalagiToSyllabary(verb.verbRootLatinPhonetic)
        verb.pronounPrefixSyllabary = new SyllabaryUtil().tsalagiToSyllabary(verb.pronounPrefixLatin)
//        basicAssertion(verb, new SyllabaryUtil().tsalagiToSyllabary("dvgowatisgvi"))

        verb.verbRootLatinPhonetic = "gowati"
        verb.pronounPrefixLatin = "ini"
        verb.finalSuffix.with {a = false;vi = true}
        verb.verbRootSuffixLatinPhonetic = "sg"
        verb.verbRootSyllabary = new SyllabaryUtil().tsalagiToSyllabary(verb.verbRootLatinPhonetic)
        verb.pronounPrefixSyllabary = new SyllabaryUtil().tsalagiToSyllabary(verb.pronounPrefixLatin)
//        basicAssertion(verb, new SyllabaryUtil().tsalagiToSyllabary("danigowatisgvi"))

        verb.verbRootLatinPhonetic = "gowati"
        verb.pronounPrefixLatin = "ini"
        verb.finalSuffix.with {a = true;vi = false; di = true}
        verb.verbRootSuffixLatinPhonetic = "tv"
        verb.verbRootSyllabary = new SyllabaryUtil().tsalagiToSyllabary(verb.verbRootLatinPhonetic)
        verb.pronounPrefixSyllabary = new SyllabaryUtil().tsalagiToSyllabary(verb.pronounPrefixLatin)
//        basicAssertion(verb, new SyllabaryUtil().tsalagiToSyllabary("nidayugowatvdi"))
    }
}
