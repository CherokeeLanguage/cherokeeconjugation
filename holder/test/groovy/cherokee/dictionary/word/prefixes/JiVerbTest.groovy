package cherokee.dictionary.word.prefixes

import cherokee.conjugation.verbal.containers.VerbPrefixTableObject
import cherokee.conjugation.verbal.containers.VerbPrefixTableSubject
import cherokee.conjugation.verbal.enums.Tense
import cherokee.dictionary.testutils.BaseTest
import cherokee.conjugation.verbal.Verb
import net.cherokeedictionary.transliteration.SyllabaryUtil

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
        verb.pronounPrefixSyllabary = SyllabaryUtil.tsalagiToSyllabary(verb.pronounPrefixLatin)
        verb.verbRootSyllabary = SyllabaryUtil.tsalagiToSyllabary(verb.verbRootLatinPhonetic)
        basicAssertion(verb, SyllabaryUtil.tsalagiToSyllabary("juwohla"))

        verb.verbRootLatinPhonetic = "woni"
        verb.verbRootSuffixLatinPhonetic = "h"
        verb.finalSuffix.map."a" = true
        verb.pronounPrefixLatin = "ga"
        verb.pronounPrefixSyllabary = SyllabaryUtil.tsalagiToSyllabary(verb.pronounPrefixLatin)
        verb.verbRootSyllabary = SyllabaryUtil.tsalagiToSyllabary(verb.verbRootLatinPhonetic)
        basicAssertion(verb, SyllabaryUtil.tsalagiToSyllabary("jigawoniha"))
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
        verb.pronounPrefixSyllabary = SyllabaryUtil.tsalagiToSyllabary(verb.pronounPrefixLatin)
        verb.verbRootSyllabary = SyllabaryUtil.tsalagiToSyllabary(verb.verbRootLatinPhonetic)
        basicAssertion(verb, SyllabaryUtil.tsalagiToSyllabary("jigawoniha"))

        verb.verbRootLatinPhonetic = "gowati"
        verb.verbRootSuffixLatinPhonetic = "h"
        verb.finalSuffix.with {a = true}
        verb.pronounPrefixLatin = "ji"
        verb.pronounPrefixSyllabary = SyllabaryUtil.tsalagiToSyllabary(verb.pronounPrefixLatin)
        verb.verbRootSyllabary = SyllabaryUtil.tsalagiToSyllabary(verb.verbRootLatinPhonetic)
        basicAssertion(verb, SyllabaryUtil.tsalagiToSyllabary("jijigowatiha"))

        verb.initialPrefix.with {ji = true; yi = true}
        verb.verbRootLatinPhonetic = "woni"
        verb.verbRootSuffixLatinPhonetic = "h"
        verb.finalSuffix.with {a = true}
        verb.pronounPrefixLatin = "ga"
        verb.pronounPrefixSyllabary = SyllabaryUtil.tsalagiToSyllabary(verb.pronounPrefixLatin)
        verb.verbRootSyllabary = SyllabaryUtil.tsalagiToSyllabary(verb.verbRootLatinPhonetic)
//        basicAssertion(verb, SyllabaryUtil.tsalagiToSyllabary("nigawonisgvna jigi"))
    }
}
