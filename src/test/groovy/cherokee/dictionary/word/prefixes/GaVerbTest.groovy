package cherokee.dictionary.word.prefixes

import cherokee.conjugation.constants.Tense
import cherokee.conjugation.constants.VerbPrefixTableObject
import cherokee.conjugation.constants.VerbPrefixTableSubject
import cherokee.dictionary.testutils.BaseTest
import cherokee.conjugation.verbal.Verb
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
        verb.pronounPrefixSyllabary = SyllabaryUtil.tsalagiToSyllabary(verb.pronounPrefixLatin)
        verb.verbRootSyllabary = SyllabaryUtil.tsalagiToSyllabary(verb.verbRootLatinPhonetic)

        basicAssertion(verb, SyllabaryUtil.tsalagiToSyllabary("gaginigohvi"))

        verb.verbRootLatinPhonetic = "go"
        verb.pronounPrefixLatin = "ogini"
        verb.verbRootSyllabary = SyllabaryUtil.tsalagiToSyllabary(verb.verbRootLatinPhonetic)
        verb.pronounPrefixSyllabary = SyllabaryUtil.tsalagiToSyllabary(verb.pronounPrefixLatin)
        basicAssertion(verb, SyllabaryUtil.tsalagiToSyllabary("gayoginigohvi"))

        verb.verbRootLatinPhonetic = "go"
        verb.verbRootSyllabary = SyllabaryUtil.tsalagiToSyllabary(verb.verbRootLatinPhonetic)
        verb.pronounPrefixLatin = "agi"
        verb.pronounPrefixSyllabary = SyllabaryUtil.tsalagiToSyllabary(verb.pronounPrefixLatin)
        basicAssertion(verb, SyllabaryUtil.tsalagiToSyllabary("gvgigohvi"))
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

        verb.verbRootSyllabary = SyllabaryUtil.tsalagiToSyllabary(verb.verbRootLatinPhonetic)
        verb.pronounPrefixLatin = "ja"
        verb.pronounPrefixSyllabary = SyllabaryUtil.tsalagiToSyllabary(verb.pronounPrefixLatin)
        basicAssertion(verb, SyllabaryUtil.tsalagiToSyllabary("gejagohvi"))

        verb.verbRootLatinPhonetic = "go"
        verb.verbRootSyllabary = SyllabaryUtil.tsalagiToSyllabary(verb.verbRootLatinPhonetic)
        verb.pronounPrefixLatin = "sdi"
        verb.pronounPrefixSyllabary = SyllabaryUtil.tsalagiToSyllabary(verb.pronounPrefixLatin)
        basicAssertion(verb, SyllabaryUtil.tsalagiToSyllabary("gesdigohvi"))
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
        verb.verbRootSyllabary = SyllabaryUtil.tsalagiToSyllabary(verb.verbRootLatinPhonetic)
        verb.pronounPrefixLatin = "u"
        verb.pronounPrefixSyllabary = SyllabaryUtil.tsalagiToSyllabary(verb.pronounPrefixLatin)
        basicAssertion(verb, SyllabaryUtil.tsalagiToSyllabary("gvwagohvi"))

        verb.verbRootLatinPhonetic = "go"
        verb.verbRootSyllabary = SyllabaryUtil.tsalagiToSyllabary(verb.verbRootLatinPhonetic)
        verb.pronounPrefixLatin = "uni"
        verb.pronounPrefixSyllabary = SyllabaryUtil.tsalagiToSyllabary(verb.pronounPrefixLatin)
        basicAssertion(verb, SyllabaryUtil.tsalagiToSyllabary("gvwanigohvi"))
    }
}
