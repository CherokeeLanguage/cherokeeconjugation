package net.cherokeedictionary.factory

import net.cherokeedictionary.conjugation.ConjugateBase
import net.cherokeedictionary.util.CompoundPrefixes
import net.cherokeedictionary.verb.affixes.PrefixProcessor
import net.cherokeedictionary.verb.conjugation.VerbConjugationProcessor
import net.cherokeedictionary.verb.containers.FinalSuffixProcessor
import net.cherokeedictionary.verb.containers.NonFinalSuffixProcessor

class VerbFactoryTest extends ConjugateBase {
    void testVerbFactory() {
        def paramMap = [habitual:'ᎠᏔᏍᎩᏍᎪᎢ', imperative:'ᎭᏔᏍᎩ', infinitive:'ᎤᏔᏍᎩᏍᏗ', present1st:'ᎦᏔᏍᎩᎠ', present3rd:'ᎠᏔᏍᎩᎠ', remotepast:'ᎤᏔᏍᎩᏒᎢ', partofspeechc:'vi', verbTense:'PRESENT', subject:'SG1', object:null]
        def display = VerbFactory.createVerbFromParameters(paramMap)
        println display
    }

    void testVerbFactory2() {
        def paramMap = [habitual:"ᎠᎪᏩᏘᏍᎪᎢ", imperative:"ᎯᎪᏩᏔ", infinitive:"ᎤᎪᏩᏛᏗ", present1st:"ᏥᎪᏩᏘᎭ", present3rd:"ᎠᎪᏩᏘᎭ", remotepast:"ᎤᎪᎲᎢ", partofspeechc:"vt", verbTense:"PRESENT", subject:"SG1", object:"", yi:false, ji:false, wi:false, ni:false, de:false, da:false, di:false, i:false, ga:false, e:false]
        def verb = VerbFactory.createVerbFromParameters(paramMap)
        println verb.subject
        println verb.object



        println verb
    }
}
