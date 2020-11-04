package cherokee.dictionary.affixes.verb.initialprefixes

import cherokee.conjugation.constants.Tense
import cherokee.conjugation.constants.VerbPrefixTableObject
import cherokee.conjugation.constants.VerbPrefixTableSubject
import cherokee.dictionary.conjugation.ConjugateBase
import cherokee.dictionary.processors.verb.VerbAffixFactory
import cherokee.dictionary.word.Verb
import com.cobradoc.cherokee.SyllabaryUtil

class PrefixETest extends ConjugateBase {
    private Verb generateBaseVerb() {
        Verb verb = new Verb()
        verb.verbSubject = VerbPrefixTableSubject.SG3
        verb.verbObject = VerbPrefixTableObject.DL2
        verb.tense = Tense.PRESENT
        verb.verbRootLatinPhonetic = "gowati"
        verb.verbRootSuffixLatinPhonetic = "h"
        verb.finalSuffix.with {a = true}
        verb.initialPrefix.e = false
        verb.pronounPrefixLatin = "sdi"
        verb.pronounPrefixSyllabary = SyllabaryUtil.tsalagiToSyllabary(verb.pronounPrefixLatin)
        verb.verbRootSyllabary = SyllabaryUtil.tsalagiToSyllabary(verb.verbRootLatinPhonetic)

        return verb
    }

    public void testPrefixEFalse() {
        //sdigowatiha -- CED pp256 #128
        Verb verb = generateBaseVerb()
        VerbAffixFactory.process(verb)
        assertEquals(SyllabaryUtil.tsalagiToSyllabary("sdigowatiha"), verb.getWholeWordSyllabary())
    }

    public void testPrefixEStartsWithDe() {
        //desdigowatiha
        Verb verb = generateBaseVerb()
        verb.initialPrefix.with {de = true; e = false}
        VerbAffixFactory.process(verb)
        assertEquals(SyllabaryUtil.tsalagiToSyllabary("desdigowatiha"), verb.getWholeWordSyllabary())

        //dodisdigowata
        verb.initialPrefix.with {de = true; e = true}
        VerbAffixFactory.process(verb)
//        assertEquals(SyllabaryUtil.tsalagiToSyllabary("dodisdigowatiha"), verb.getWholeWordSyllabary())
    }

    public void testPrefixENotStartsWithDe() {
        Verb verb = generateBaseVerb()

        //esdigowata -- CED pp256 #128
        verb.initialPrefix.with {e = true}
        VerbAffixFactory.process(verb)
        assertEquals(SyllabaryUtil.tsalagiToSyllabary("esdigowatiha"), verb.getWholeWordSyllabary())
    }
}
