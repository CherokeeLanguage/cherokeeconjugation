package net.cherokeedictionary.verb.affixes.initialPrefixes

import net.cherokeedictionary.core.Verb
import net.cherokeedictionary.stemmer.DefinitionLine
import net.cherokeedictionary.stemmer.Stemmer
import net.cherokeedictionary.util.PartOfSpeech
import net.cherokeedictionary.verb.conjugation.Conjugate

class YiWiBleedingTest extends GroovyTestCase {
    static def bleeding = new Stemmer()
    static {
        bleeding.habitual = new DefinitionLine(syllabary: "ᎠᏔᏍᎩᏍᎪᎢ")
        bleeding.imperative = new DefinitionLine(syllabary: "ᎭᏔᏍᎩ")
        bleeding.infinitive = new DefinitionLine(syllabary: "ᎤᏔᏍᎩᏍᏗ")
        bleeding.present1st = new DefinitionLine(syllabary: "ᎦᏔᏍᎩᎠ")
        bleeding.present3rd = new DefinitionLine(syllabary: "ᎠᏔᏍᎩᎠ")
        bleeding.remotepast = new DefinitionLine(syllabary: "ᎤᏔᏍᎩᏒᎢ")
    }

    void testYiWiBleeding() {
        Verb verb = Conjugate.createVerbToConjugate("SG2", "", bleeding, "PRESENT", PartOfSpeech.VERB_INTRANSITIVE, false)

        verb.initialPrefixHolder.with {yi = true; wi=true}
        verb = Conjugate.conjugate(verb)
        assertTrue "ᏳᏩᏔᏍᎩᎠ" == verb.wholeWord
    }

    void testYiBleeding() {
        Verb verb = Conjugate.createVerbToConjugate("SG2", "", bleeding, "PRESENT", PartOfSpeech.VERB_INTRANSITIVE, false)

        verb.initialPrefixHolder.with {yi = true; wi=false}
        verb = Conjugate.conjugate(verb)
        assertTrue "ᏯᏔᏍᎩᎠ" == verb.wholeWord
    }

    void testWiBleeding() {
        Verb verb = Conjugate.createVerbToConjugate("SG2", "", bleeding, "PRESENT", PartOfSpeech.VERB_INTRANSITIVE, false)

        verb.initialPrefixHolder.with {yi = false; wi=true}
        verb = Conjugate.conjugate(verb)
        assertTrue "ᏩᏔᏍᎩᎠ" == verb.wholeWord

    }
}
