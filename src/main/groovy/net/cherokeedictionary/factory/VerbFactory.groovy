package net.cherokeedictionary.factory

import net.cherokeedictionary.core.Verb
import net.cherokeedictionary.stemmer.DefinitionLine
import net.cherokeedictionary.stemmer.Stemmer
import net.cherokeedictionary.verb.conjugation.Conjugate

class VerbFactory {
    //todo: this isn't really a verb factory - it's more of a conjugateAndGetDisplayValue kind of thing
    static String createVerbFromParameters(paramMap) {
        def habitual = paramMap.habitual
        def imperative = paramMap.imperative
        def infinitive = paramMap.infinitive
        def present1st = paramMap.present1st
        def present3rd = paramMap.present3rd
        def remotepast = paramMap.remotepast
        def partofspeechc = paramMap.partofspeechc

        println paramMap

        def stemmer = new Stemmer()
        def hd = new DefinitionLine(syllabary: habitual)//"ᎦᏬᏂᏍᎪᎢ")
        def id1 = new DefinitionLine(syllabary: imperative)//"ᎯᏬᏂᎯ")
        def id2 = new DefinitionLine(syllabary: infinitive)//"ᎤᏬᏂᎯᏍᏗ")
        def p1 = new DefinitionLine(syllabary:  present1st)//"ᏥᏬᏂᎭ")
        def p2 = new DefinitionLine(syllabary: present3rd)//"ᎦᏬᏂᎭ")
        def rp = new DefinitionLine(syllabary: remotepast)//"ᎤᏬᏂᏒᎢ")
        stemmer.habitual = hd
        stemmer.imperative = id1
        stemmer.infinitive = id2
        stemmer.present1st = p1
        stemmer.present3rd = p2
        stemmer.remotepast = rp

//        stemmer.setHabitual(new DefinitionLine(syllabary: habitual))
//        stemmer.setImperative(new DefinitionLine(syllabary: imperative))
//        stemmer.setInfinitive(new DefinitionLine(syllabary: infinitive))
//        stemmer.setPresent1st(new DefinitionLine(syllabary:  present1st))
//        stemmer.setPresent3rd(new DefinitionLine(syllabary: present3rd))
//        stemmer.setRemotepast(new DefinitionLine(syllabary: remotepast))

//        Verb word = new Verb()
//        println partofspeechc
//        word.partOfSpeech = partofspeechc == 'vi' ? PartOfSpeech.VERB_INTRANSITIVE : PartOfSpeech.VERB_TRANSITIVE
//
//        word.tense = Tense.valueOf(paramMap.verbTense ?: "PRESENT")

        //rewrite so this works with the latest version
//        word.prefixHolderObject.with {
//            yi = params.yi == 'on'
//            ji = params.ji == 'on'
//            wi = params.wi == 'on'
//            ni = params.ni == 'on'
//            de = params.de == 'on'
//            da = params.da == 'on'
//            di = params.di == 'on'
//            i = params.i == 'on'
//            ga = params.ga == 'on'
//            e = params.e == 'on'
//        }
//
        def displayValue
        try {
            Verb verb = Conjugate.conjugate(paramMap.subject, paramMap.object, stemmer, paramMap.verbTense, partofspeechc, false)
            println verb
            displayValue = verb.wholeWord
        } catch (Exception e) {
            displayValue = "there was an error with your request"
        }


        return displayValue
    }
}
