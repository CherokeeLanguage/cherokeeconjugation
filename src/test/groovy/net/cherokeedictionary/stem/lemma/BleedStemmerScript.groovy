package net.cherokeedictionary.stem.lemma

import net.cherokeedictionary.stemmer.DefinitionLine
import net.cherokeedictionary.stemmer.Stemmer
import net.cherokeedictionary.util.CompoundPrefixes
import net.cherokeedictionary.util.PrefixTableObject
import net.cherokeedictionary.util.PrefixTableSubject
import net.cherokeedictionary.util.Tense
import net.cherokeedictionary.verb.conjugation.Conjugate

def verbName = new Stemmer()
verbName.habitual = new DefinitionLine(syllabary: "ᎠᏔᏍᎩᏍᎪᎢ")
verbName.imperative = new DefinitionLine(syllabary: "ᎭᏔᏍᎩ")
verbName.infinitive = new DefinitionLine(syllabary: "ᎤᏔᏍᎩᏍᏗ")
verbName.present1st = new DefinitionLine(syllabary: "ᎦᏔᏍᎩᎠ")
verbName.present3rd = new DefinitionLine(syllabary: "ᎠᏔᏍᎩᎠ")
verbName.remotepast = new DefinitionLine(syllabary: "ᎤᏔᏍᎩᏒᎢ")

PrefixTableSubject.values().each {pts ->
    PrefixTableObject.values().each {pto ->
        def conjugated = Conjugate.conjugate(pts.toString(), pto.toString(), verbName, Tense.INFINITIVE.toString(), "vi")
        println conjugated.pronounReflexiveRoot
    }
}