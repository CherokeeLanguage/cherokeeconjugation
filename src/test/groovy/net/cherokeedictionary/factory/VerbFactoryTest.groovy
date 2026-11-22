package net.cherokeedictionary.factory

import net.cherokeedictionary.conjugation.ConjugateBase
import net.cherokeedictionary.conjugation.VerbConjugationFacade
import net.cherokeedictionary.core.Verb

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
        
        def facade = new VerbConjugationFacade()
        Verb display = facade.conjugate(paramMap)
    }

    void testVerbFactory2() {
        def paramMap = [habitual:"ᎠᎪᏩᏘᏍᎪᎢ", imperative:"ᎯᎪᏩᏔ", infinitive:"ᎤᎪᏩᏛᏗ", present1st:"ᏥᎪᏩᏘᎭ", present3rd:"ᎠᎪᏩᏘᎭ", remotepast:"ᎤᎪᎲᎢ", partofspeechc:"vt", verbTense:"PRESENT", subject:"SG1", object:"", yi:"false", ji:"false", wi:"false", ni:"false", de:"false", da:"false", di:"false", i:"false", ga:"false", e:"false"]
        def facade = new VerbConjugationFacade()
        def verb = facade.conjugate(paramMap)
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
        paramMap.yi = "true"
        
        def facade = new VerbConjugationFacade()
        Verb display = facade.conjugate(paramMap)
    }
}
