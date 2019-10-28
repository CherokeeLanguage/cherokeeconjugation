package cherokee.dictionary.word.prefixes

import cherokee.dictionary.affixes.prefixes.verb.VerbPrefixTableObject
import cherokee.dictionary.affixes.prefixes.verb.VerbPrefixTableSubject
import cherokee.dictionary.testUtils.BaseTest
import cherokee.dictionary.verb.conjugation.originalConjugation.Tense
import cherokee.dictionary.word.Verb
import com.cobradoc.cherokee.SyllabaryUtil

//these tests are only to check the prefix pieces and not the verb conjugation itself
//pp 242-244 Durbin Feeling Dictionary
class JiVerbTest extends BaseTest {

    /**
     * j- before a vowel, ji- before consonant, ju before w
     */
    public void atestVerbJi() {
        Verb verb = new Verb()
        verb.verbSubject = VerbPrefixTableSubject.SG1
        verb.verbObject = VerbPrefixTableObject.SG2
        verb.tense = Tense.PRESENT
        verb.initialPrefix.with {ji = true}
        verb.verbRootLatinPhonetic = "wo"
        verb.verbRootSuffixLatinPhonetic = "hl"
        verb.finalSuffix.with {a = true}
        verb.pronounPrefixLatin = "u"
        verb.pronounPrefixSyllabary = new SyllabaryUtil().tsalagiToSyllabary(verb.pronounPrefixLatin)
        verb.verbRootSyllabary = new SyllabaryUtil().tsalagiToSyllabary(verb.verbRootLatinPhonetic)
        basicAssertion(verb, new SyllabaryUtil().tsalagiToSyllabary("juwohla"))

        verb.verbRootLatinPhonetic = "woni"
        verb.verbRootSuffixLatinPhonetic = "h"
        verb.finalSuffix.map."a" = true
        verb.pronounPrefixLatin = "ga"
        verb.pronounPrefixSyllabary = new SyllabaryUtil().tsalagiToSyllabary(verb.pronounPrefixLatin)
        verb.verbRootSyllabary = new SyllabaryUtil().tsalagiToSyllabary(verb.verbRootLatinPhonetic)
        basicAssertion(verb, new SyllabaryUtil().tsalagiToSyllabary("jigawoniha"))
    }

    public void atestVerbJi2() {
        Verb verb = new Verb()
        verb.verbSubject = VerbPrefixTableSubject.SG1
        verb.verbObject = VerbPrefixTableObject.SG2
        verb.tense = Tense.PRESENT
        verb.initialPrefix.with {ji = true}
        verb.verbRootLatinPhonetic = "woni"
        verb.verbRootSuffixLatinPhonetic = "h"
        verb.finalSuffix.with {a = true}
        verb.pronounPrefixLatin = "ga"
        verb.pronounPrefixSyllabary = new SyllabaryUtil().tsalagiToSyllabary(verb.pronounPrefixLatin)
        verb.verbRootSyllabary = new SyllabaryUtil().tsalagiToSyllabary(verb.verbRootLatinPhonetic)
        basicAssertion(verb, new SyllabaryUtil().tsalagiToSyllabary("jigawoniha"))

        verb.verbRootLatinPhonetic = "gowati"
        verb.verbRootSuffixLatinPhonetic = "h"
        verb.finalSuffix.with {a = true}
        verb.pronounPrefixLatin = "ji"
        verb.pronounPrefixSyllabary = new SyllabaryUtil().tsalagiToSyllabary(verb.pronounPrefixLatin)
        verb.verbRootSyllabary = new SyllabaryUtil().tsalagiToSyllabary(verb.verbRootLatinPhonetic)
        basicAssertion(verb, new SyllabaryUtil().tsalagiToSyllabary("jijigowatiha"))

        verb.initialPrefix.with {ji = true; yi = true}
        verb.verbRootLatinPhonetic = "woni"
        verb.verbRootSuffixLatinPhonetic = "h"
        verb.finalSuffix.with {a = true}
        verb.pronounPrefixLatin = "ga"
        verb.pronounPrefixSyllabary = new SyllabaryUtil().tsalagiToSyllabary(verb.pronounPrefixLatin)
        verb.verbRootSyllabary = new SyllabaryUtil().tsalagiToSyllabary(verb.verbRootLatinPhonetic)
//        basicAssertion(verb, new SyllabaryUtil().tsalagiToSyllabary("nigawonisgvna jigi"))
    }
}
