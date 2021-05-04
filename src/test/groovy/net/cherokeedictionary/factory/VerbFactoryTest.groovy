package net.cherokeedictionary.factory

import net.cherokeedictionary.conjugation.ConjugateBase
<<<<<<< HEAD
import net.cherokeedictionary.core.Verb
import net.cherokeedictionary.verb.conjugation.Conjugate
=======
import net.cherokeedictionary.util.CompoundPrefixes
import net.cherokeedictionary.verb.affixes.PrefixProcessor
import net.cherokeedictionary.verb.conjugation.VerbConjugationProcessor
import net.cherokeedictionary.verb.containers.FinalSuffixProcessor
import net.cherokeedictionary.verb.containers.NonFinalSuffixProcessor
>>>>>>> 23dbc653988dcecbebacf29bbce64cb9fc978b93

class VerbFactoryTest extends ConjugateBase {
    void testVerbFactory() {
        def paramMap = [:]
        paramMap.habitual = 'ᎠᏔᏍᎩᏍᎪᎢ'
        paramMap.imperative = 'ᎭᏔᏍᎩ'
        paramMap.infinitive = 'ᎤᏔᏍᎩᏍᏗ'
        paramMap.present1st = 'ᎦᏔᏍᎩᎠ'
        paramMap.present3rd = 'ᎠᏔᏍᎩᎠ'
        paramMap.remotepast = 'ᎤᏔᏍᎩᏒᎢ'
        paramMap.partofspeechc = 'vi'
        paramMap.verbTense = 'PRESENT'
        paramMap.subject = "SG1"
        paramMap.object = "SG3AN"
//        paramMap.yi = params.yi == 'on'
//        paramMap.ji = false
//        paramMap.wi = false
//        paramMap.ni = params.ni == 'on'
//        paramMap.de = params.de == 'on'
//        paramMap.da = params.da == 'on'
//        paramMap.di = params.di == 'on'
//        paramMap.i = params.i == 'on'
//        paramMap.ga = params.ga == 'on'
//        paramMap.e = params.e == 'on'
        Verb display = VerbFactory.createVerbFromParameters(paramMap)
        println display
    }

    void testVerbFactory2() {
        def paramMap = [habitual:"ᎠᎪᏩᏘᏍᎪᎢ", imperative:"ᎯᎪᏩᏔ", infinitive:"ᎤᎪᏩᏛᏗ", present1st:"ᏥᎪᏩᏘᎭ", present3rd:"ᎠᎪᏩᏘᎭ", remotepast:"ᎤᎪᎲᎢ", partofspeechc:"vt", verbTense:"PRESENT", subject:"SG1", object:"", yi:false, ji:false, wi:false, ni:false, de:false, da:false, di:false, i:false, ga:false, e:false]
        def verb = VerbFactory.createVerbFromParameters(paramMap)
        println verb.subject
        println verb.object



        println verb
    }

    void testVerbFactoryYiGowatiha() {
        def paramMap = [:]
        paramMap.habitual = 'ᎠᏔᏍᎩᏍᎪᎢ'
        paramMap.imperative = 'ᎭᏔᏍᎩ'
        paramMap.infinitive = 'ᎤᏔᏍᎩᏍᏗ'
        paramMap.present1st = 'ᎦᏔᏍᎩᎠ'
        paramMap.present3rd = 'ᎠᏔᏍᎩᎠ'
        paramMap.remotepast = 'ᎤᏔᏍᎩᏒᎢ'
        paramMap.partofspeechc = 'vi'
        paramMap.verbTense = 'PRESENT'
        paramMap.subject = "SG1"
        paramMap.object = "SG3AN"
        paramMap.yi = true
//        paramMap.ji = false
//        paramMap.wi = false
//        paramMap.ni = params.ni == 'on'
//        paramMap.de = params.de == 'on'
//        paramMap.da = params.da == 'on'
//        paramMap.di = params.di == 'on'
//        paramMap.i = params.i == 'on'
//        paramMap.ga = params.ga == 'on'
//        paramMap.e = params.e == 'on'
        Verb display = VerbFactory.createVerbFromParameters(paramMap)
        display = Conjugate.conjugate(display)
        println display
    }
}
