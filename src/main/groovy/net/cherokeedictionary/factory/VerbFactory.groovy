package net.cherokeedictionary.factory

import net.cherokeedictionary.core.Verb
import net.cherokeedictionary.stemmer.DefinitionLine
import net.cherokeedictionary.stemmer.Stemmer
import net.cherokeedictionary.util.PartOfSpeech
import net.cherokeedictionary.util.PrefixTableSubject
import net.cherokeedictionary.util.Tense
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

//        println paramMap

        def stemmer = new Stemmer()
        stemmer.habitual = new DefinitionLine(syllabary: habitual)//"ᎦᏬᏂᏍᎪᎢ")
        stemmer.imperative = new DefinitionLine(syllabary: imperative)//"ᎯᏬᏂᎯ")
        stemmer.infinitive = new DefinitionLine(syllabary: infinitive)//"ᎤᏬᏂᎯᏍᏗ")
        stemmer.present1st = new DefinitionLine(syllabary:  present1st)//"ᏥᏬᏂᎭ")
        stemmer.present3rd = new DefinitionLine(syllabary: present3rd)//"ᎦᏬᏂᎭ")
        stemmer.remotepast = new DefinitionLine(syllabary: remotepast)//"ᎤᏬᏂᏒᎢ")
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

        if (partofspeechc == 'v.i.' || partofspeechc == 'vi') {
            partofspeechc = PartOfSpeech.VERB_INTRANSITIVE
        } else {
            partofspeechc = PartOfSpeech.VERB_TRANSITIVE
        }

        def displayValue

            Verb verb = Conjugate.createVerbToConjugate(paramMap.subject, paramMap.object, stemmer, paramMap.verbTense, partofspeechc, false)
            verb.initialPrefixHolder.yi = paramMap.yi
            verb.initialPrefixHolder.ji = paramMap.ji
            verb.initialPrefixHolder.wi = paramMap.wi
            verb.initialPrefixHolder.ni = paramMap.ni
            verb.initialPrefixHolder.de = paramMap.de
            verb.initialPrefixHolder.da = paramMap.da
            verb.initialPrefixHolder.di = paramMap.di
            verb.initialPrefixHolder.i = paramMap.i
            verb.initialPrefixHolder.ga = paramMap.ga
            verb.initialPrefixHolder.e = paramMap.e
        try {
            verb = Conjugate.conjugate(verb);
            displayValue = verb.wholeWord
        } catch (Exception e) {
            displayValue = "there was an error with your request"
        }


        return displayValue
    }
}
