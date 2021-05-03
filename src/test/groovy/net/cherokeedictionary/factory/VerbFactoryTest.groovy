package net.cherokeedictionary.factory

import net.cherokeedictionary.conjugation.ConjugateBase
import net.cherokeedictionary.core.Verb
import net.cherokeedictionary.verb.conjugation.Conjugate

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
