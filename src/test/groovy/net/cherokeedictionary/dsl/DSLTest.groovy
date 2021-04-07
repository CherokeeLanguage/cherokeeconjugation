package net.cherokeedictionary.dsl

import net.cherokeedictionary.core.Verb
import net.cherokeedictionary.stem.DefinitionLine
import net.cherokeedictionary.stemmer.Stemmer
import net.cherokeedictionary.util.PrefixTableObject
import net.cherokeedictionary.util.PrefixTableSubject
import net.cherokeedictionary.util.Tense
import net.cherokeedictionary.verb.conjugation.Conjugate

show = { println it }
square_root = { Math.sqrt(it) }

def please(action) {
    [the: { what ->
        [of: { n -> action(what(n)) }]
    }]
}

// equivalent to: please(show).the(square_root).of(100)
//please show the square_root of 100

def gowatiha = new Stemmer()
gowatiha.habitual = new DefinitionLine(syllabary: "ᎠᎪᏩᏘᏍᎪᎢ")
gowatiha.imperative = new DefinitionLine(syllabary: "ᎯᎪᏩᏔ")
gowatiha.infinitive = new DefinitionLine(syllabary: "ᎤᎪᏩᏛᏗ")
gowatiha.present1st = new DefinitionLine(syllabary: "ᏥᎪᏩᏘᎭ")
gowatiha.present3rd = new DefinitionLine(syllabary: "ᎠᎪᏩᏘᎭ")
gowatiha.remotepast = new DefinitionLine(syllabary: "ᎤᎪᎲᎢ")

createVerb = {stemmer, subject, object, tense ->
    Verb verb = new Verb()
    verb.stemmer = stemmer
    verb.subject = subject
    verb.object = object
    verb.tense = tense
    return verb
}

def create( stemmer) {
    [ subobj: { subject ->
        [ to: { object ->
            [ inthe: { tense ->
                return createVerb(stemmer, subject, object, tense)
              }
            ]
          }
        ]
      }
    ]
}

def SG1 = PrefixTableSubject.SG1
def SG2 = PrefixTableObject.SG2
def PRESENT = Tense.PRESENT

Verb verb = create(gowatiha).subobj(SG1).to(SG2).inthe(PRESENT)

Verb verb1 = create gowatiha subobj SG1 to SG2 inthe PRESENT

assert verb.stemmer == verb1.stemmer
assert verb.tense == verb1.tense
assert verb.subject == verb1.subject
assert verb.object == verb1.object