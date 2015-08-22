package cherokee.dictionary.conjugation

import cherokee.dictionary.conjugation.conjugate.CompoundPrefixes
import cherokee.dictionary.conjugation.stem.DefinitionLine
import cherokee.dictionary.conjugation.stem.Stemmer

/**
 * Created by torr on 8/21/2015.
 */
class ConjugateTest extends GroovyTestCase {
    def conj(subject, object, stemmer, verbTense, partofspeechc){
        Conjugate conjugate = new Conjugate()
        return conjugate.conjugate(subject, object, stemmer, verbTense, partofspeechc)
    }

    public void testWantConjgationTransitivePresent() {
        def heWantsIt = new Stemmer()
        heWantsIt.habitual = new DefinitionLine(syllabary: "ᎤᏚᎵᏍᎪᎢ")
        heWantsIt.imperative = new DefinitionLine(syllabary: "ᏣᏚᎳ")
        heWantsIt.infinitive = new DefinitionLine(syllabary: "ᎤᏚᎸᏗ")
        heWantsIt.present1st = new DefinitionLine(syllabary:  "ᎠᏆᏚᎵᎭ")
        heWantsIt.present3rd = new DefinitionLine(syllabary: "ᎤᏚᎵᎭ")
        heWantsIt.remotepast = new DefinitionLine(syllabary: "ᎤᏚᎸᎲᎢ")

        def partofspeechc = "v.t."
        def verbTense = "PRESENT"

        assertTrue "ᎬᏯᏚᎵᎭ" == conj("SG1", "SG2", heWantsIt, verbTense, partofspeechc)
        assertTrue "ᏥᏯᏚᎵᎭ" == conj("SG1", "SG3AN", heWantsIt, verbTense, partofspeechc)
        assertTrue "ᎠᏆᏚᎵᎭ" == conj("SG1", "SG3IN", heWantsIt, verbTense, partofspeechc)
        assertTrue "ᎤᏚᎵᎭ" == conj("SG3", "SG3IN", heWantsIt, verbTense, partofspeechc)
    }

    public void testHiwonihaConjgationTransitivePresent() {
        def partofspeechc = "v.i."
        def verbTense = "PRESENT"

        def hiwoniha = new Stemmer()
        hiwoniha.habitual = new DefinitionLine(syllabary: "ᎦᏬᏂᏍᎪᎢ")
        hiwoniha.imperative = new DefinitionLine(syllabary: "ᎯᏬᏂᎯ")
        hiwoniha.infinitive = new DefinitionLine(syllabary: "ᎤᏬᏂᎯᏍᏗ")
        hiwoniha.present1st = new DefinitionLine(syllabary:  "ᏥᏬᏂᎭ")
        hiwoniha.present3rd = new DefinitionLine(syllabary: "ᎦᏬᏂᎭ")
        hiwoniha.remotepast = new DefinitionLine(syllabary: "ᎤᏬᏂᏒᎢ")

        println conj("SG1", "", hiwoniha, verbTense, partofspeechc)
        println conj("SG1", "", hiwoniha, verbTense, partofspeechc)
        println conj("SG2", "", hiwoniha, verbTense, partofspeechc)
        println conj("SG3", "", hiwoniha, verbTense, partofspeechc)
        println conj("DL1INCL", "", hiwoniha, verbTense, partofspeechc)
    }

    //todo: fire up intransitive verbs
    //todo: fix the intransitive dropdowns and the transitive dropdowns
//    Set B verbs:
//    If stem starts with consonant or with a, then u.
//    Else if stem starts with v, then uwa- and drop v.
//    else if stem starts with uw-
}