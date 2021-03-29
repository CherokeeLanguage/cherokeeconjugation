package cherokee.conjugation.verbal

import net.cherokeedcitionary.ConjugationEngine
import net.cherokeedcitionary.core.Verb
import net.cherokeedcitionary.core.Word
import net.cherokeedcitionary.util.PartOfSpeech
import net.cherokeedcitionary.verbal.stemming.Stemmer

//import cherokee.conjugation.verbal.containers.VerbPrefixTableObject
//import cherokee.conjugation.verbal.containers.VerbPrefixTableSubject
//import cherokee.conjugation.verbal.enums.Tense
//import cherokee.dictionary.processors.verb.VerbAffixFactory
//import cherokee.conjugation.verbal.Verb
//import cherokee.dictionary.verb.conjugation.originalconjugation.Conjugate
//import net.cherokeedictionary.transliteration.SyllabaryUtil

/**
 * Created by torr on 8/21/2015.
 */
class ConjugatePresentTense extends ConjugateBase {
    private def conj(subject, object, stemmer, tense, partOfSpeech) {
        String wholeWord = ""
        Verb vrb = ConjugationEngine.conjugate(PartOfSpeech.getByShortForm(partOfSpeech).toString(), stemmer, subject, object, tense)

        println vrb.toString()

        return vrb.getWholeWord()
    }

    //finished and good
    void testWantConjgationTransitivePresent() {
        def partofspeechc = "v.t."
        def verbTense = "PRESENT"

        assertTrue "ᎬᏯᏚᎵᎭ" == conj("SG1", "SG2", heWantsIt, verbTense, partofspeechc)
        assertTrue "ᏥᏯᏚᎵᎭ" == conj("SG1", "SG3AN", heWantsIt, verbTense, partofspeechc)
        assertTrue "ᎠᏆᏚᎵᎭ" == conj("SG1", "SG3IN", heWantsIt, verbTense, partofspeechc)
        assertTrue "", "ᎠᏆᏚᎵᎭ" == conj("SG1", "SG3IN", heWantsIt, verbTense, partofspeechc)

        assertTrue "", "ᏣᏚᎵᎭ" == conj("SG2", "SG3IN", heWantsIt, verbTense, partofspeechc)
        assertTrue "", "ᎤᏚᎵᎭ" == conj("SG3", "SG3IN", heWantsIt, verbTense, partofspeechc)
        assertTrue "", "ᎩᎾᏚᎵᎭ" == conj("DL1INCL", "SG3IN", heWantsIt, verbTense, partofspeechc)
        assertTrue "", "ᎣᎩᎾᏚᎵᎭ" == conj("DL1EXCL", "SG3IN", heWantsIt, verbTense, partofspeechc)
        assertTrue "", "ᏍᏓᏚᎵᎭ" == conj("DL2", "SG3IN", heWantsIt, verbTense, partofspeechc)
        assertTrue "", "ᎢᎦᏚᎵᎭ" == conj("PL1INCL", "SG3IN", heWantsIt, verbTense, partofspeechc)
        assertTrue "", "ᎣᎦᏚᎵᎭ" == conj("PL1EXCL", "SG3IN", heWantsIt, verbTense, partofspeechc)
        assertTrue "", "ᎢᏣᏚᎵᎭ" == conj("PL2", "SG3IN", heWantsIt, verbTense, partofspeechc)
        assertTrue "", "ᎤᎾᏚᎵᎭ" == conj("PL3", "SG3IN", heWantsIt, verbTense, partofspeechc)

        assertTrue "", "ᏓᏆᏚᎵᎭ" == conj("SG1", "PL3IN", heWantsIt, verbTense, partofspeechc)
        assertTrue "", "ᏚᏣᏚᎵᎭ" == conj("SG2", "PL3IN", heWantsIt, verbTense, partofspeechc)

        assertTrue "", "ᏚᏚᎵᎭ" == conj("SG3", "PL3IN", heWantsIt, verbTense, partofspeechc)
        assertTrue "", "ᏚᎩᎾᏚᎵᎭ" == conj("DL1INCL", "PL3IN", heWantsIt, verbTense, partofspeechc)

        assertTrue "", "ᏙᎩᎾᏚᎵᎭ" == conj("DL1EXCL", "PL3IN", heWantsIt, verbTense, partofspeechc)

        assertTrue "", "ᏕᏍᏓᏚᎵᎭ" == conj("DL2", "PL3IN", heWantsIt, verbTense, partofspeechc)
        assertTrue "", "ᏚᎦᏚᎵᎭ" == conj("PL1INCL", "PL3IN", heWantsIt, verbTense, partofspeechc)
        assertTrue "", "ᏙᎦᏚᎵᎭ" == conj("PL1EXCL", "PL3IN", heWantsIt, verbTense, partofspeechc)
        assertTrue "", "ᏕᏣᏚᎵᎭ" == conj("PL2", "PL3IN", heWantsIt, verbTense, partofspeechc)
        assertTrue "", "ᏚᎾᏚᎵᎭ" == conj("PL3", "PL3IN", heWantsIt, verbTense, partofspeechc)
    }

    public void testWantReflexive() {
        def partofspeechc = "v.t."
        def verbTense = "PRESENT"
        def subject = "SG1"
        def object = "SG3IN"
        def stemmer = heWantsIt

        /*
            conjugate the verb using some initial and medial prefixes.
            take conjugated version and then parse so that I can infer the translation value
        */

//        Conjugate conjugate = new Conjugate()
//        Verb verb = conjugate.conjugateToVerbObject(subject, object, stemmer, verbTense, partofspeechc)
//        verb.verbSubject = VerbPrefixTableSubject.SG1
//        verb.verbObject = VerbPrefixTableObject.SG3IN
//        verb.tense = Tense.PRESENT
//        verb.verbRootLatinPhonetic = "aduli"
//        verb.verbRootSuffixLatinPhonetic = "h"
//        verb.finalSuffix.with {a = true}
//        verb.initialPrefix.e = true
//        verb.pronounPrefixLatin = "agw"
//        assert verb.pronounPrefixLatin != null
//        verb.pronounPrefixSyllabary = SyllabaryUtil.tsalagiToSyllabary(verb.pronounPrefixLatin)
//        assert verb.verbRootLatinPhonetic != null
//        verb.verbRootSyllabary = SyllabaryUtil.tsalagiToSyllabary(verb.verbRootLatinPhonetic)
//        VerbAffixFactory.process(verb)
//        def f = new File("testFile.txt")
//        f.write(verb.toString(), "UTF-8")
//        println(verb.verbRootSyllabary)
    }

    //finished and good
    /**
     * Structured Approach - Durbin Feeling (Cherokee Verb OCR pdf) pp 13
     */
    public void testHearConjgationTransitivePresent() {
        def partofspeechc = "v.t."
        def verbTense = "PRESENT"

        assertTrue "", "ᏥᏯᏛᎩᎠ" == conj("SG1", "SG3AN", tohear, verbTense, partofspeechc)//jiyadvgia
        assertTrue "", "ᎯᏯᏛᎩᎠ" == conj("SG2", "SG3AN", tohear, verbTense, partofspeechc)//hiyadvgia
        assertTrue "", "ᎠᏛᎩᎠ" == conj("SG3", "SG3AN", tohear, verbTense, partofspeechc)//advgia
        assertTrue "", "ᎡᎾᏛᎩᎠ" == conj("DL1INCL", "SG3AN", tohear, verbTense, partofspeechc)//enadvgia
        assertTrue "", "ᎣᏍᏓᏛᎩᎠ" == conj("DL1EXCL", "SG3AN", tohear, verbTense, partofspeechc)//osdadvgia
        assertTrue "", "ᎡᏍᏓᏛᎩᎠ" == conj("DL2", "SG3AN", tohear, verbTense, partofspeechc)//esdadvgia
        assertTrue "", "ᎡᏓᏛᎩᎠ" == conj("PL1INCL", "SG3AN", tohear, verbTense, partofspeechc)//edadvgia
        assertTrue "", "ᎣᏣᏛᎩᎠ" == conj("PL1EXCL", "SG3AN", tohear, verbTense, partofspeechc)//ojadvgia
        assertTrue "", "ᎡᏣᏛᎩᎠ" == conj("PL2", "SG3AN", tohear, verbTense, partofspeechc)//ejadvgia
        assertTrue "", "ᎠᎾᏛᎩᎠ" == conj("PL3", "SG3AN", tohear, verbTense, partofspeechc)//anadvgia

        assertTrue "", "ᎦᏥᏯᏛᎩᎠ" == conj("SG1", "PL3AN", tohear, verbTense, partofspeechc)//gajiyadvgia
        assertTrue "", "ᎦᎯᏯᏛᎩᎠ" == conj("SG2", "PL3AN", tohear, verbTense, partofspeechc)//gahiyadvgia
        assertTrue "", "ᏕᎦᏛᎩᎠ" == conj("SG3", "PL3AN", tohear, verbTense, partofspeechc)//dadvgia
        assertTrue "", "ᎨᎾᏛᎩᎠ" == conj("DL1INCL", "PL3AN", tohear, verbTense, partofspeechc)//genadvgia
        assertTrue "", "ᎪᏍᏓᏛᎩᎠ" == conj("DL1EXCL", "PL3AN", tohear, verbTense, partofspeechc)//gosdadvgia
        assertTrue "", "ᎨᏍᏓᏛᎩᎠ" == conj("DL2", "PL3AN", tohear, verbTense, partofspeechc)//gedsadvgia
        assertTrue "", "ᎨᏓᏛᎩᎠ" == conj("PL1INCL", "PL3AN", tohear, verbTense, partofspeechc)//gedadvgia
        assertTrue "", "ᎪᏣᏛᎩᎠ" == conj("PL1EXCL", "PL3AN", tohear, verbTense, partofspeechc)//gojatvgia
        assertTrue "", "ᎨᏣᏛᎩᎠ" == conj("PL2", "PL3AN", tohear, verbTense, partofspeechc)//gejadvgia
        assertTrue "", "ᏓᎾᏛᎩᎠ" == conj("PL3", "PL3AN", tohear, verbTense, partofspeechc)//danadvgia
    }

    //finished and good
    public void testHiwonihaConjgationIntransitivePresent() {
        def partofspeechc = "v.i."
        def verbTense = "PRESENT"

        assertTrue "", "ᏥᏬᏂᎭ" == conj("SG1", "", hiwoniha, verbTense, partofspeechc)
        assertTrue "", "ᎯᏬᏂᎭ" == conj("SG2", "", hiwoniha, verbTense, partofspeechc)
        assertTrue "", "ᎦᏬᏂᎭ" == conj("SG3", "", hiwoniha, verbTense, partofspeechc)
        assertTrue "", "ᎢᏂᏬᏂᎭ" == conj("DL1INCL", "", hiwoniha, verbTense, partofspeechc)
        assertTrue "", "ᎣᏍᏗᏬᏂᎭ" == conj("DL1EXCL", "", hiwoniha, verbTense, partofspeechc)
        assertTrue "", "ᏍᏗᏬᏂᎭ" == conj("DL2", "", hiwoniha, verbTense, partofspeechc)
        assertTrue "", "ᎢᏗᏬᏂᎭ" == conj("PL1INCL", "", hiwoniha, verbTense, partofspeechc)
        assertTrue "", "ᎣᏥᏬᏂᎭ" == conj("PL1EXCL", "", hiwoniha, verbTense, partofspeechc)
        assertTrue "", "ᎢᏥᏬᏂᎭ" == conj("PL2", "", hiwoniha, verbTense, partofspeechc)
        assertTrue "", "ᎠᏂᏬᏂᎭ" == conj("PL3", "", hiwoniha, verbTense, partofspeechc)
    }

    //finished and good
    public void testAsuhvsgaConjgationIntransitivePresent() {
        def partofspeechc = "v.i."
        def verbTense = "PRESENT"

        assertTrue "", "ᎦᏑᎲᏍᎦ" == conj("SG1", "", tofish, verbTense, partofspeechc)
        assertTrue "", "ᎭᏑᎲᏍᎦ" == conj("SG2", "", tofish, verbTense, partofspeechc)
        //todo: need to find some way to make this happen by passing in only the verb root - there has got to be a pattern
        assertTrue "", "ᎠᏑᎲᏍᎦ" == tofish.present3rd.syllabary;//conj("SG3", "", tofish, verbTense, partofspeechc)
        assertTrue "", "ᎢᎾᏑᎲᏍᎦ" == conj("DL1INCL", "", tofish, verbTense, partofspeechc)
        assertTrue "", "ᎣᏍᏓᏑᎲᏍᎦ" == conj("DL1EXCL", "", tofish, verbTense, partofspeechc)
        assertTrue "", "ᏍᏓᏑᎲᏍᎦ" == conj("DL2", "", tofish, verbTense, partofspeechc)
        assertTrue "", "ᎢᏓᏑᎲᏍᎦ" == conj("PL1INCL", "", tofish, verbTense, partofspeechc)
        assertTrue "", "ᎣᏣᏑᎲᏍᎦ" == conj("PL1EXCL", "", tofish, verbTense, partofspeechc)
        assertTrue "", "ᎢᏣᏑᎲᏍᎦ" == conj("PL2", "", tofish, verbTense, partofspeechc)
        assertTrue "", "ᎠᎾᏑᎲᏍᎦ" == conj("PL3", "", tofish, verbTense, partofspeechc)
    }

    public void testHavePresent() {
        def partofspeechc = "v.t."
        def verbTense = "PRESENT"

        assertTrue "", "ᎠᎩᎭ" == conj("SG1", "SG3IN", tohave, verbTense, partofspeechc)
        assertTrue "", "ᏣᎭ" == conj("SG2", "SG3IN", tohave, verbTense, partofspeechc)
        assertTrue "", "ᎤᎭ" == conj("SG3", "SG3IN", tohave, verbTense, partofspeechc)
        assertTrue "", "ᎩᏂᎭ" == conj("DL1INCL", "SG3IN", tohave, verbTense, partofspeechc)
        assertTrue "", "ᎣᎩᏂᎭ" == conj("DL1EXCL", "SG3IN", tohave, verbTense, partofspeechc)
        assertTrue "", "ᏍᏗᎭ" == conj("DL2", "SG3IN", tohave, verbTense, partofspeechc)
        assertTrue "", "ᎢᎩᎭ" == conj("PL1INCL", "SG3IN", tohave, verbTense, partofspeechc)
        assertTrue "", "ᎣᎩᎭ" == conj("PL1EXCL", "SG3IN", tohave, verbTense, partofspeechc)
        assertTrue "", "ᎢᏥᎭ" == conj("PL2", "SG3IN", tohave, verbTense, partofspeechc)
        assertTrue "", "ᎤᏂᎭ" == conj("PL3", "SG3IN", tohave, verbTense, partofspeechc)
    }

    public void testGreetPresent() {
        def partofspeechc = "v.t."
        def verbTense = "PRESENT"

        assertTrue "", "ᏥᏲᎵᎭ" == conj("SG1", "SG3AN", togreet, verbTense, partofspeechc)
        assertTrue "", "ᎯᏲᎵᎭ" == conj("SG2", "SG3AN", togreet, verbTense, partofspeechc)
        assertTrue "", "ᎠᏲᎵᎭ" == conj("SG3", "SG3AN", togreet, verbTense, partofspeechc)
        assertTrue "", "ᎦᏲᎵᎭ" == conj("SG3", "SG3IN", togreet, verbTense, partofspeechc)
        assertTrue "", "ᎡᏂᏲᎵᎭ" == conj("DL1INCL", "SG3AN", togreet, verbTense, partofspeechc)
        assertTrue "", "ᎣᏍᏗᏲᎵᎭ" == conj("DL1EXCL", "SG3AN", togreet, verbTense, partofspeechc)
        assertTrue "", "ᎡᏍᏗᏲᎵᎭ" == conj("DL2", "SG3AN", togreet, verbTense, partofspeechc)
        assertTrue "", "ᎡᏗᏲᎵᎭ" == conj("PL1INCL", "SG3AN", togreet, verbTense, partofspeechc)
        assertTrue "", "ᎣᏥᏲᎵᎭ" == conj("PL1EXCL", "SG3AN", togreet, verbTense, partofspeechc)
        assertTrue "", "ᎡᏥᏲᎵᎭ" == conj("PL2", "SG3AN", togreet, verbTense, partofspeechc)
        assertTrue "", "ᎠᏂᏲᎵᎭ" == conj("PL3", "SG3AN", togreet, verbTense, partofspeechc)
    }

    //not good
    public void testKillPresent() {
        def partofspeechc = "v.t."
        def verbTense = "PRESENT"

//        println conj("SG1", "SG3AN", tokill, verbTense, partofspeechc)
//        println conj("SG2", "SG3AN", tokill, verbTense, partofspeechc)
//        println conj("SG3", "SG3AN", tokill, verbTense, partofspeechc)
//        println conj("DL1INCL", "SG3AN", tokill, verbTense, partofspeechc)
//        println conj("DL1EXCL", "SG3AN", tokill, verbTense, partofspeechc)
//        println conj("DL2", "SG3AN", tokill, verbTense, partofspeechc)
//        println conj("PL1INCL", "SG3AN", tokill, verbTense, partofspeechc)
//        println conj("PL1EXCL", "SG3AN", tokill, verbTense, partofspeechc)
//        println conj("PL2", "SG3AN", tokill, verbTense, partofspeechc)
//        println conj("PL3", "SG3AN", tokill, verbTense, partofspeechc)
//        println conj("SG1", "PL3AN", tokill, verbTense, partofspeechc)
//        println conj("SG2", "PL3AN", tokill, verbTense, partofspeechc)
//        println conj("SG3", "PL3AN", tokill, verbTense, partofspeechc)
//        println conj("DL1INCL", "PL3AN", tokill, verbTense, partofspeechc)
//        println conj("DL1EXCL", "PL3AN", tokill, verbTense, partofspeechc)
//        println conj("DL2", "PL3AN", tokill, verbTense, partofspeechc)
//        println conj("PL1INCL", "PL3AN", tokill, verbTense, partofspeechc)
//        println conj("PL1EXCL", "PL3AN", tokill, verbTense, partofspeechc)
//        println conj("PL2", "PL3AN", tokill, verbTense, partofspeechc)
//        println conj("PL3", "PL3AN", tokill, verbTense, partofspeechc)

//        sn3 and pl3 - pl3in & pl3an should be the same but they aren't. They have different /h/ /?/ substituions

        assertTrue "", "ᏥᎢᎭ" == conj("SG1", "SG3AN", tokill, verbTense, partofspeechc)
        assertTrue "", "ᎯᎢᎭ" == conj("SG2", "SG3AN", tokill, verbTense, partofspeechc)
        assertTrue "", "ᎠᎯᎭ" == conj("SG3", "SG3AN", tokill, verbTense, partofspeechc)
        assertTrue "", "ᎡᏂᎢᎭ" == conj("DL1INCL", "SG3AN", tokill, verbTense, partofspeechc)
        assertTrue "", "ᎣᏍᏗᎢᎭ" == conj("DL1EXCL", "SG3AN", tokill, verbTense, partofspeechc)
        assertTrue "", "ᎡᏍᏗᎢᎭ" == conj("DL2", "SG3AN", tokill, verbTense, partofspeechc)
        assertTrue "", "ᎡᏗᎢᎭ" == conj("PL1INCL", "SG3AN", tokill, verbTense, partofspeechc)
        assertTrue "", "ᎣᏥᎢᎭ" == conj("PL1EXCL", "SG3AN", tokill, verbTense, partofspeechc)
        assertTrue "", "ᎡᏥᎢᎭ" == conj("PL2", "SG3AN", tokill, verbTense, partofspeechc)
        assertTrue "", "ᎠᏂᎯᎠ" == conj("PL3", "SG3AN", tokill, verbTense, partofspeechc)

        assertTrue "", "ᎦᏥᎢᎭ" == conj("SG1", "PL3AN", tokill, verbTense, partofspeechc)
        assertTrue "", "ᎦᎯᎢᎭ" == conj("SG2", "PL3AN", tokill, verbTense, partofspeechc)

        //todo: if any are incorrect - it would be this one - the book says: ᏓᎪᎯᎠ -- pp15 Structured Approach
//        sn3 and pl3 - pl3in & pl3an should be the same but they aren't. They have different /h/ /?/ substituions
        assertTrue "", "ᏕᎩᎯᎠ" == conj("SG3", "PL3AN", tokill, verbTense, partofspeechc)
        assertTrue "", "ᏕᎩᎯᎠ" == conj("SG3", "PL3IN", tokill, verbTense, partofspeechc)

        assertTrue "", "ᎨᏂᎢᎭ" == conj("DL1INCL", "PL3AN", tokill, verbTense, partofspeechc)
        assertTrue "", "ᎪᏍᏗᎢᎭ" == conj("DL1EXCL", "PL3AN", tokill, verbTense, partofspeechc)
        assertTrue "", "ᎨᏍᏗᎢᎭ" == conj("DL2", "PL3AN", tokill, verbTense, partofspeechc)
        assertTrue "", "ᎨᏗᎢᎭ" == conj("PL1INCL", "PL3AN", tokill, verbTense, partofspeechc)
        assertTrue "", "ᎪᏥᎢᎭ" == conj("PL1EXCL", "PL3AN", tokill, verbTense, partofspeechc)
        assertTrue "", "ᎨᏥᎢᎭ" == conj("PL2", "PL3AN", tokill, verbTense, partofspeechc)
        assertTrue "", "ᏓᏂᎯᎠ" == conj("PL3", "PL3AN", tokill, verbTense, partofspeechc)
        assertTrue "", "ᏓᏂᎯᎠ" == conj("PL3", "PL3IN", tokill, verbTense, partofspeechc)
    }

    public void testToSeePresentDL2() {
        //sdigowatiha -- CED pp256 #128
        assertTrue "ᏍᏗᎪᏩᏘᎭ" == conj("SG3", "DL2", tosee, "PRESENT", "v.t.")

//        Verb verb = new Verb()
//        verb.verbSubject = VerbPrefixTableSubject.SG3
//        verb.verbObject = VerbPrefixTableObject.DL2
//        verb.tense = Tense.PRESENT
//        verb.verbRootLatinPhonetic = "gowati"
//        verb.verbRootSuffixLatinPhonetic = "h"
//        verb.finalSuffix.with {a = true}
//        verb.pronounPrefixLatin = "sdi"
//        verb.pronounPrefixSyllabary = SyllabaryUtil.tsalagiToSyllabary(verb.pronounPrefixLatin)
//        verb.verbRootSyllabary = SyllabaryUtil.tsalagiToSyllabary(verb.verbRootLatinPhonetic)
//
//        VerbAffixFactory.process(verb)
//        assertEquals(SyllabaryUtil.tsalagiToSyllabary("sdigowatiha"), verb.getWholeWordSyllabary())
    }
}