package net.cherokeedictionary.factory

import net.cherokeedictionary.core.Verb
import net.cherokeedictionary.stemmer.DefinitionLine
import net.cherokeedictionary.stemmer.Stemmer
import net.cherokeedictionary.util.PartOfSpeech
import net.cherokeedictionary.util.PrefixTableObject
import net.cherokeedictionary.util.PrefixTableSubject
import net.cherokeedictionary.util.Tense
import net.cherokeedictionary.verb.conjugation.Conjugate

class VerbFactory {
    //todo: this isn't really a verb factory - it's more of a conjugateAndGetDisplayValue kind of thing
    static Verb createVerbFromParameters(paramMap) {
        def habitual = paramMap.habitual
        def imperative = paramMap.imperative
        def infinitive = paramMap.infinitive
        def present1st = paramMap.present1st
        def present3rd = paramMap.present3rd
        def remotepast = paramMap.remotepast
        def partofspeechc = paramMap.partofspeechc

        def stemmer = new Stemmer()
        stemmer.habitual = new DefinitionLine(syllabary: habitual)//"ᎦᏬᏂᏍᎪᎢ")
        stemmer.imperative = new DefinitionLine(syllabary: imperative)//"ᎯᏬᏂᎯ")
        stemmer.infinitive = new DefinitionLine(syllabary: infinitive)//"ᎤᏬᏂᎯᏍᏗ")
        stemmer.present1st = new DefinitionLine(syllabary:  present1st)//"ᏥᏬᏂᎭ")
        stemmer.present3rd = new DefinitionLine(syllabary: present3rd)//"ᎦᏬᏂᎭ")
        stemmer.remotepast = new DefinitionLine(syllabary: remotepast)//"ᎤᏬᏂᏒᎢ")

        Verb verb = new Verb()
        verb.initialPrefixHolder.yi = paramMap.yi
        verb.initialPrefixHolder.ji = paramMap.ji
        verb.initialPrefixHolder.wi = paramMap.wi
        verb.initialPrefixHolder.ni = paramMap.ni
        verb.initialPrefixHolder.de = paramMap.de
        verb.initialPrefixHolder.da = paramMap.da
        verb.initialPrefixHolder.di = paramMap.dis
        verb.initialPrefixHolder.i = paramMap.i
        verb.initialPrefixHolder.ga = paramMap.ga
        verb.initialPrefixHolder.e = paramMap.e

        if (partofspeechc == 'v.i.' || partofspeechc == 'vi') {
            partofspeechc = PartOfSpeech.VERB_INTRANSITIVE
        } else {
            partofspeechc = PartOfSpeech.VERB_TRANSITIVE
        }

        verb.subject = paramMap.subject ?:PrefixTableSubject.valueOf(paramMap.subject)
        verb.object = paramMap.object ?: PrefixTableObject.valueOf(paramMap.object)

        verb.partOfSpeech = partofspeechc
        verb.stemmer = stemmer
        verb.tense = Tense.valueOf(paramMap.verbTense)

        return verb
    }

    static Verb createVerbFromParametersAndConjugate(paramMap) {
        Verb verb = createVerbFromParameters(paramMap)
        verb = Conjugate.conjugate(verb)

        return verb
    }
}
