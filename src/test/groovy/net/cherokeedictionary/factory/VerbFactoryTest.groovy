package net.cherokeedictionary.factory

import net.cherokeedictionary.conjugation.ConjugateBase

class VerbFactoryTest extends ConjugateBase {
    void testVerbFactory() {
        def paramMap = [habitual:'ᎠᏔᏍᎩᏍᎪᎢ', imperative:'ᎭᏔᏍᎩ', infinitive:'ᎤᏔᏍᎩᏍᏗ', present1st:'ᎦᏔᏍᎩᎠ', present3rd:'ᎠᏔᏍᎩᎠ', remotepast:'ᎤᏔᏍᎩᏒᎢ', partofspeechc:'vi', verbTense:'PRESENT', subject:'SG1', object:null]
        def display = VerbFactory.createVerbFromParameters(paramMap)
        println display
    }

}
