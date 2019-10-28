package cherokee.dictionary.word.prefixes

import cherokee.dictionary.affixes.prefixes.verb.VerbPrefixTableObject
import cherokee.dictionary.affixes.prefixes.verb.VerbPrefixTableSubject
import cherokee.dictionary.testUtils.BaseTest
import cherokee.dictionary.verb.conjugation.originalConjugation.Tense
import cherokee.dictionary.word.Verb
import com.cobradoc.cherokee.SyllabaryUtil

//these tests are only to check the prefix pieces and not the verb conjugation itself
//pp 255-256 Durbin Feeling Dictionary
class GaVerbTest extends BaseTest {
//    ginigohvi
//    gaginigohvi
//
//    oginigohvi
//    gayoginigohvi
//
//    agigohvi
//    gvgigohvi
    public void atestVerbGa() {
        Verb verb = new Verb()
        verb.verbSubject = VerbPrefixTableSubject.SG1
        verb.verbObject = VerbPrefixTableObject.SG2
        verb.tense = Tense.PRESENT
        verb.initialPrefix.with {ga = true}
        verb.verbRootLatinPhonetic = "go"
        verb.verbRootSuffixLatinPhonetic = "h"
        verb.finalSuffix.with {vi = true}

        verb.pronounPrefixLatin = "gini"
        verb.pronounPrefixSyllabary = new SyllabaryUtil().tsalagiToSyllabary(verb.pronounPrefixLatin)
        verb.verbRootSyllabary = new SyllabaryUtil().tsalagiToSyllabary(verb.verbRootLatinPhonetic)

        basicAssertion(verb, new SyllabaryUtil().tsalagiToSyllabary("gaginigohvi"))

        verb.verbRootLatinPhonetic = "go"
        verb.pronounPrefixLatin = "ogini"
        verb.verbRootSyllabary = new SyllabaryUtil().tsalagiToSyllabary(verb.verbRootLatinPhonetic)
        verb.pronounPrefixSyllabary = new SyllabaryUtil().tsalagiToSyllabary(verb.pronounPrefixLatin)
        basicAssertion(verb, new SyllabaryUtil().tsalagiToSyllabary("gayoginigohvi"))

        verb.verbRootLatinPhonetic = "go"
        verb.verbRootSyllabary = new SyllabaryUtil().tsalagiToSyllabary(verb.verbRootLatinPhonetic)
        verb.pronounPrefixLatin = "agi"
        verb.pronounPrefixSyllabary = new SyllabaryUtil().tsalagiToSyllabary(verb.pronounPrefixLatin)
        basicAssertion(verb, new SyllabaryUtil().tsalagiToSyllabary("gvgigohvi"))
    }

//    jagohvi
//    gejagohvi
//
//    sdigohvi
//    gesdigohvi
    public void atestVerbGaGe() {
        Verb verb = new Verb()
        verb.verbSubject = VerbPrefixTableSubject.SG2
        verb.verbObject = VerbPrefixTableObject.SG2
        verb.tense = Tense.PRESENT
        verb.initialPrefix.with {ga = true}
        verb.verbRootLatinPhonetic = "go"
        verb.verbRootSuffixLatinPhonetic = "h"
        verb.finalSuffix.with {vi = true}

        verb.verbRootSyllabary = new SyllabaryUtil().tsalagiToSyllabary(verb.verbRootLatinPhonetic)
        verb.pronounPrefixLatin = "ja"
        verb.pronounPrefixSyllabary = new SyllabaryUtil().tsalagiToSyllabary(verb.pronounPrefixLatin)
        basicAssertion(verb, new SyllabaryUtil().tsalagiToSyllabary("gejagohvi"))

        verb.verbRootLatinPhonetic = "go"
        verb.verbRootSyllabary = new SyllabaryUtil().tsalagiToSyllabary(verb.verbRootLatinPhonetic)
        verb.pronounPrefixLatin = "sdi"
        verb.pronounPrefixSyllabary = new SyllabaryUtil().tsalagiToSyllabary(verb.pronounPrefixLatin)
        basicAssertion(verb, new SyllabaryUtil().tsalagiToSyllabary("gesdigohvi"))
    }

//    ugohvi
//    gvwagohvi
//
//    unigohvi
//    gvwanigohvi
    public void atestVerbGaGvw() {
        Verb verb = new Verb()
        verb.verbSubject = VerbPrefixTableSubject.SG3
        verb.verbObject = VerbPrefixTableObject.SG2
        verb.tense = Tense.PRESENT
        verb.initialPrefix.with {ga = true}
        verb.verbRootLatinPhonetic = "go"
        verb.verbRootSuffixLatinPhonetic = "h"
        verb.finalSuffix.with {vi = true}

        //u- after gvw becomes gvwa -- pp255 Durbin Feeling Dictionary
        verb.verbRootSyllabary = new SyllabaryUtil().tsalagiToSyllabary(verb.verbRootLatinPhonetic)
        verb.pronounPrefixLatin = "u"
        verb.pronounPrefixSyllabary = new SyllabaryUtil().tsalagiToSyllabary(verb.pronounPrefixLatin)
        basicAssertion(verb, new SyllabaryUtil().tsalagiToSyllabary("gvwagohvi"))

        verb.verbRootLatinPhonetic = "go"
        verb.verbRootSyllabary = new SyllabaryUtil().tsalagiToSyllabary(verb.verbRootLatinPhonetic)
        verb.pronounPrefixLatin = "uni"
        verb.pronounPrefixSyllabary = new SyllabaryUtil().tsalagiToSyllabary(verb.pronounPrefixLatin)
        basicAssertion(verb, new SyllabaryUtil().tsalagiToSyllabary("gvwanigohvi"))
    }
}
