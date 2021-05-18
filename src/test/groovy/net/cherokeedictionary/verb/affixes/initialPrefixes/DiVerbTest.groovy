package net.cherokeedictionary.verb.affixes.initialPrefixes

import net.cherokeedictionary.conjugation.ConjugateBase
import net.cherokeedictionary.core.Verb
import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.PrefixTableObject
import net.cherokeedictionary.util.PrefixTableSubject
import net.cherokeedictionary.util.Tense
import net.cherokeedictionary.verb.conjugation.Conjugate

//these tests are only to check the prefix pieces and not the verb conjugation itself
//pp 252-254 Durbin Feeling Dictionary
class DiVerbTest extends ConjugateBase {

    void testVerbDi() {
        Verb verb = new Verb()
        verb.subject = PrefixTableSubject.SG1
        verb.object = PrefixTableObject.SG3AN
        verb.tense = Tense.PRESENT
        verb.initialPrefixHolder.with {di = true}
        verb.stemmer = hiwoniha

        verb = Conjugate.conjugate(verb)

        assertTrue "ᏗᏥᏬᏂᎭ" == verb.wholeWord

//        verb.verbRootLatinPhonetic = "woni"
//        verb.verbRootSuffixLatinPhonetic = "h"
////        verb.finalSuffix.a = true// {a = true}
//        verb.finalSuffix.with {a = true}
//        verb.pronounPrefixLatin = "ga"
//        verb.pronounPrefixSyllabary = SyllabaryUtil.tsalagiToSyllabary(verb.pronounPrefixLatin)
//        verb.verbRootSyllabary = SyllabaryUtil.tsalagiToSyllabary(verb.verbRootLatinPhonetic)
//        basicAssertion(verb, SyllabaryUtil.tsalagiToSyllabary("digawoniha"))
//
//        verb.verbRootLatinPhonetic = "go"
//        verb.pronounPrefixLatin = "u"
//        verb.finalSuffix.with {a = false;ei = true}
//        verb.verbRootSyllabary = SyllabaryUtil.tsalagiToSyllabary(verb.verbRootLatinPhonetic)
//        verb.pronounPrefixSyllabary = SyllabaryUtil.tsalagiToSyllabary(verb.pronounPrefixLatin)
//        basicAssertion(verb, SyllabaryUtil.tsalagiToSyllabary("jugohei"))
//
//        verb.verbRootLatinPhonetic = "gowati"
//        verb.pronounPrefixLatin = "a"
//        verb.finalSuffix.with {a = true;ei = false}
//        verb.verbRootSyllabary = SyllabaryUtil.tsalagiToSyllabary(verb.verbRootLatinPhonetic)
//        verb.pronounPrefixSyllabary = SyllabaryUtil.tsalagiToSyllabary(verb.pronounPrefixLatin)
//        basicAssertion(verb, SyllabaryUtil.tsalagiToSyllabary("digowatiha"))
//
//        verb.verbRootLatinPhonetic = "gowati"
//        verb.pronounPrefixLatin = "iji"
//        verb.finalSuffix.with {a = true;ei = false}
//        verb.verbRootSyllabary = SyllabaryUtil.tsalagiToSyllabary(verb.verbRootLatinPhonetic)
//        verb.pronounPrefixSyllabary = SyllabaryUtil.tsalagiToSyllabary(verb.pronounPrefixLatin)
//        basicAssertion(verb, SyllabaryUtil.tsalagiToSyllabary("dijigowatiha"))
//
//        verb.verbRootLatinPhonetic = "go"
//        verb.pronounPrefixLatin = "u"
//        verb.finalSuffix.with {a = true;vi = false}
//        verb.verbRootSyllabary = SyllabaryUtil.tsalagiToSyllabary(verb.verbRootLatinPhonetic)
//        verb.pronounPrefixSyllabary = SyllabaryUtil.tsalagiToSyllabary(verb.pronounPrefixLatin)
////        basicAssertion(verb, SyllabaryUtil.tsalagiToSyllabary("dayugohvi"))
//
//        verb.verbRootLatinPhonetic = "gowati"
//        verb.pronounPrefixLatin = "u"
//        verb.finalSuffix.with {a = false; vi = true}
//        verb.verbRootSuffixLatinPhonetic = "sg"
//        verb.verbRootSyllabary = SyllabaryUtil.tsalagiToSyllabary(verb.verbRootLatinPhonetic)
//        verb.pronounPrefixSyllabary = SyllabaryUtil.tsalagiToSyllabary(verb.pronounPrefixLatin)
////        basicAssertion(verb, SyllabaryUtil.tsalagiToSyllabary("dvgowatisgvi"))
//
//        verb.verbRootLatinPhonetic = "gowati"
//        verb.pronounPrefixLatin = "ini"
//        verb.finalSuffix.with {a = false;vi = true}
//        verb.verbRootSuffixLatinPhonetic = "sg"
//        verb.verbRootSyllabary = SyllabaryUtil.tsalagiToSyllabary(verb.verbRootLatinPhonetic)
//        verb.pronounPrefixSyllabary = SyllabaryUtil.tsalagiToSyllabary(verb.pronounPrefixLatin)
////        basicAssertion(verb, SyllabaryUtil.tsalagiToSyllabary("danigowatisgvi"))
//
//        verb.verbRootLatinPhonetic = "gowati"
//        verb.pronounPrefixLatin = "ini"
//        verb.finalSuffix.with {a = true;vi = false; di = true}
//        verb.verbRootSuffixLatinPhonetic = "tv"
//        verb.verbRootSyllabary = SyllabaryUtil.tsalagiToSyllabary(verb.verbRootLatinPhonetic)
//        verb.pronounPrefixSyllabary = SyllabaryUtil.tsalagiToSyllabary(verb.pronounPrefixLatin)
//        basicAssertion(verb, SyllabaryUtil.tsalagiToSyllabary("nidayugowatvdi"))
    }
}
