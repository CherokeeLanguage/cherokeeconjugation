package net.cherokeedictionary.factory

import net.cherokeedictionary.conjugation.ConjugateBase
import net.cherokeedictionary.core.Verb
import net.cherokeedictionary.factory.VerbFactory
import net.cherokeedictionary.util.Tense
import net.cherokeedictionary.verb.conjugation.Conjugate

class RootBreakdown extends ConjugateBase {
    void testVerbFactory() {
        def paramMap = [:]

//        syllabaryb, vfirstpresh, vsecondimpersylln, vthirdinfsyllp, vthirdpastsyllj, vthirdpressylll
//        ᎠᎵᏔᏬᎠ	ᎦᎵᏔᏬᎠ	ᎭᎵᏔᏬᏣ	ᎤᎵᏔᏬᏍᏗ	ᎤᎵᏔᏬᎥᎢ	ᎠᎵᏔᏬᏍᎪᎢ

        paramMap.habitual = 'ᎠᎵᏔᏬᏍᎪᎢ'
        paramMap.imperative = 'ᎭᎵᏔᏬᏣ'
        paramMap.infinitive = 'ᎤᎵᏔᏬᏍᏗ'
        paramMap.present1st = 'ᎦᎵᏔᏬᎠ'
        paramMap.present3rd = 'ᎠᎵᏔᏬᎠ'
        paramMap.remotepast = 'ᎤᎵᏔᏬᎥᎢ'
        paramMap.partofspeechc = 'vt'
        paramMap.verbTense = 'PRESENT'
        paramMap.subject = "SG1"
        paramMap.object = "SG3AN"

        Verb display = VerbFactory.createVerbFromParameters(paramMap)

        println "HABITUAL: " + paramMap.habitual + " stem: " + display.stemmer.getStem(Tense.HABITUAL)
        println "IMMEDIATE_COMMAND: " + paramMap.imperative + " stem: " + display.stemmer.getStem(Tense.IMMEDIATE_COMMAND)
        println "INFINITIVE: " + paramMap.infinitive + " stem: " + display.stemmer.getStem(Tense.INFINITIVE)
        println "REMOTE PAST: " + paramMap.remotepast + " stem: " + display.stemmer.getStem(Tense.REMOTE_PAST)
        println "PRESENT TENSE: " + paramMap.present1st + " stem: " + display.stemmer.getStem(Tense.PRESENT)
        println display
    }


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
/*
    void testVerbFactory2() {
        def paramMap = [habitual:"ᎠᎪᏩᏘᏍᎪᎢ", imperative:"ᎯᎪᏩᏔ", infinitive:"ᎤᎪᏩᏛᏗ", present1st:"ᏥᎪᏩᏘᎭ", present3rd:"ᎠᎪᏩᏘᎭ", remotepast:"ᎤᎪᎲᎢ", partofspeechc:"vt", verbTense:"PRESENT", subject:"SG1", object:"", yi:false, ji:false, wi:false, ni:false, de:false, da:false, di:false, i:false, ga:false, e:false]
        def verb = VerbFactory.createVerbFromParameters(paramMap)

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
    }*/
}
