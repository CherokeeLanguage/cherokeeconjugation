package cherokee.dictionary.affixes.verb.initialPrefixes

import cherokee.dictionary.affixes.prefixes.verb.VerbPrefixTableObject
import cherokee.dictionary.affixes.prefixes.verb.VerbPrefixTableSubject
import cherokee.dictionary.conjugation.ConjugateBase
import cherokee.dictionary.processors.verb.VerbAffixFactory
import cherokee.dictionary.verb.conjugation.originalConjugation.Tense
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
        verb.pronounPrefixSyllabary = new SyllabaryUtil().tsalagiToSyllabary(verb.pronounPrefixLatin)
        verb.verbRootSyllabary = new SyllabaryUtil().tsalagiToSyllabary(verb.verbRootLatinPhonetic)

        return verb
    }

    public void testPrefixEFalse() {
        //sdigowatiha -- CED pp256 #128
        Verb verb = generateBaseVerb()
        VerbAffixFactory.process(verb)
        assertEquals(new SyllabaryUtil().tsalagiToSyllabary("sdigowatiha"), verb.getWholeWordSyllabary())
    }

    public void testPrefixEStartsWithDe() {
        //desdigowatiha
        Verb verb = generateBaseVerb()
        verb.initialPrefix.with {de = true; e = false}
        VerbAffixFactory.process(verb)
        assertEquals(new SyllabaryUtil().tsalagiToSyllabary("desdigowatiha"), verb.getWholeWordSyllabary())

        //dodisdigowata
        verb.initialPrefix.with {de = true; e = true}
        VerbAffixFactory.process(verb)
        assertEquals(new SyllabaryUtil().tsalagiToSyllabary("dodisdigowatiha"), verb.getWholeWordSyllabary())
    }

    public void testPrefixENotStartsWithDe() {
        Verb verb = generateBaseVerb()

        //esdigowata -- CED pp256 #128
        verb.initialPrefix.with {e = true}
        VerbAffixFactory.process(verb)
        assertEquals(new SyllabaryUtil().tsalagiToSyllabary("esdigowatiha"), verb.getWholeWordSyllabary())
    }
}
