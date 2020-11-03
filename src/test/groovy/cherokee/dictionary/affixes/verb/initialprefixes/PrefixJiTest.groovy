package cherokee.dictionary.affixes.verb.initialprefixes

import cherokee.dictionary.affixes.prefixes.verb.VerbPrefixTableObject
import cherokee.dictionary.affixes.prefixes.verb.VerbPrefixTableSubject
import cherokee.dictionary.conjugation.ConjugateBase
import cherokee.dictionary.hold.stem.AffixSplitter
import cherokee.dictionary.hold.stem.StemType
import cherokee.dictionary.processors.verb.VerbAffixFactory
import cherokee.dictionary.utils.PartOfSpeech
import cherokee.dictionary.verb.conjugation.originalconjugation.Conjugate
import cherokee.dictionary.verb.conjugation.originalconjugation.Tense
import cherokee.dictionary.word.Verb
import com.cobradoc.cherokee.SyllabaryUtil

class PrefixJiTest extends ConjugateBase {
    private Verb generateBaseVerb() {
        Verb verb = new Verb()
//        verb.verbSubject = VerbPrefixTableSubject.SG3
//        verb.verbObject = VerbPrefixTableObject.SG2
//        verb.tense = Tense.PRESENT
        verb.verbRootLatinPhonetic = "woni"
        verb.verbRootSuffixLatinPhonetic = "h"
        verb.finalSuffix.with {a = true}
        verb.initialPrefix.e = false
//        verb.pronounPrefixLatin = "hi"
        verb.pronounPrefixSyllabary = new SyllabaryUtil().tsalagiToSyllabary(verb.pronounPrefixLatin)
        verb.verbRootSyllabary = new SyllabaryUtil().tsalagiToSyllabary(verb.verbRootLatinPhonetic)

        return verb
    }

    //ced -- pp 243 #14 & 15
    public void testGawonihaBase() {
        Verb verb = generateBaseVerb()
        VerbAffixFactory.process(verb)

        assertEquals("ᎯᏬᏂᎯ", verb.getWholeWordSyllabary())
//        hiwoniha
    }

    public void testGawonihaJi() {
        Conjugate conjugate = new Conjugate()
        Verb verb = conjugate.conjugateToVerbObject("SG3", "SG3IN", hiwoniha, Tense.REMOTE_PAST.toString(), PartOfSpeech.VERB_INTRANSITIVE.toString())

        VerbAffixFactory.process(verb)

        println verb.toString()

//        AffixSplitter affixSplitter = new AffixSplitter()
//        String hiwonihaStr = SyllabaryUtil.parseSyllabary(hiwoniha.getStem(StemType.RemotePast))

//        println verb.getWholeWordPhonetic()

//        println SyllabaryUtil.parseSyllabary(conj())
//        Verb verb = generateBaseVerb()
//
//        verb.verbSubject = VerbPrefixTableSubject.SG3
//        verb.verbObject = VerbPrefixTableObject.SG3AN
//        verb.tense = Tense.REMOTE_PAST
//        verb.finalSuffix.vi = true
//        verb.finalSuffix.a = false
//        verb.verbRootSuffixLatinPhonetic = 's'
//        verb.pronounPrefixLatin = 'u'
//
////        verb.initialPrefix.ji = true
//
//        VerbAffixFactory.process(verb)
//
//        println verb.getWholeWordPhonetic()
    }
}