package net.cherokeedictionary.verb.affixes.initialPrefixes

import net.cherokeedictionary.core.Verb
import net.cherokeedictionary.conjugation.ConjugateBase
import net.cherokeedictionary.verb.conjugation.Conjugate
import net.cherokeedictionary.util.PrefixTableObject
import net.cherokeedictionary.util.PrefixTableSubject
import net.cherokeedictionary.util.Tense


//these tests are only to check the prefix pieces and not the verb conjugation itself
//pp 242-244 Durbin Feeling Dictionary
class JiVerbTest extends ConjugateBase {
    /**
     * j- before a vowel, ji- before consonant, ju before w
     */
    void testVerbJi() {
        Verb verb = new Verb()
        verb.subject = PrefixTableSubject.SG1
        verb.object = PrefixTableObject.SG3AN
        verb.tense = Tense.PRESENT
        verb.initialPrefixHolder.with {ji = true}
        verb.stemmer = hiwoniha

        verb = Conjugate.conjugate(verb)

        assertTrue "ᏥᏥᏬᏂᎭ" == verb.wholeWord

        verb.initialPrefixHolder.with {yi = true}

        verb = Conjugate.conjugate(verb)

        assertTrue "ᏂᏥᏬᏂᎭᎾ ᏥᎩ" == verb.wholeWord
    }
//
//    public void atestVerbJi2() {
//        Verb verb = new Verb()
//        verb.verbSubject = VerbPrefixTableSubject.SG1
//        verb.verbObject = VerbPrefixTableObject.SG2
//        verb.tense = Tense.PRESENT
//        verb.initialPrefix.with {ji = true}
//        verb.verbRootLatinPhonetic = "woni"
//        verb.verbRootSuffixLatinPhonetic = "h"
//        verb.finalSuffix.with {a = true}
//        verb.pronounPrefixLatin = "ga"
//        verb.pronounPrefixSyllabary = new SyllabaryUtil().tsalagiToSyllabary(verb.pronounPrefixLatin)
//        verb.verbRootSyllabary = new SyllabaryUtil().tsalagiToSyllabary(verb.verbRootLatinPhonetic)
//        basicAssertion(verb, new SyllabaryUtil().tsalagiToSyllabary("jigawoniha"))
//
//        verb.verbRootLatinPhonetic = "gowati"
//        verb.verbRootSuffixLatinPhonetic = "h"
//        verb.finalSuffix.with {a = true}
//        verb.pronounPrefixLatin = "ji"
//        verb.pronounPrefixSyllabary = new SyllabaryUtil().tsalagiToSyllabary(verb.pronounPrefixLatin)
//        verb.verbRootSyllabary = new SyllabaryUtil().tsalagiToSyllabary(verb.verbRootLatinPhonetic)
//        basicAssertion(verb, new SyllabaryUtil().tsalagiToSyllabary("jijigowatiha"))
//
//        verb.initialPrefix.with {ji = true; yi = true}
//        verb.verbRootLatinPhonetic = "woni"
//        verb.verbRootSuffixLatinPhonetic = "h"
//        verb.finalSuffix.with {a = true}
//        verb.pronounPrefixLatin = "ga"
//        verb.pronounPrefixSyllabary = new SyllabaryUtil().tsalagiToSyllabary(verb.pronounPrefixLatin)
//        verb.verbRootSyllabary = new SyllabaryUtil().tsalagiToSyllabary(verb.verbRootLatinPhonetic)
////        basicAssertion(verb, new SyllabaryUtil().tsalagiToSyllabary("nigawonisgvna jigi"))
//    }
}
