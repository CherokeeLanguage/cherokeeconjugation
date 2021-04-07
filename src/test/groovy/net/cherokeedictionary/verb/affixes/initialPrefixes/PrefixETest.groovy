package net.cherokeedictionary.verb.affixes.initialPrefixes

import net.cherokeedictionary.core.Verb
import net.cherokeedictionary.conjugation.ConjugateBase
import net.cherokeedictionary.verb.conjugation.Conjugate
import net.cherokeedictionary.util.PartOfSpeech
import net.cherokeedictionary.util.PrefixTableObject
import net.cherokeedictionary.util.PrefixTableSubject
import net.cherokeedictionary.util.Tense

//these tests are only to check the prefix pieces and not the verb conjugation itself
//pp 255-256 Durbin Feeling Dictionary
class PrefixETest extends ConjugateBase {
    void testPrefixE() {
        def partofspeechc = "v.t."
        def verbTense = "PRESENT"

        def verb = Conjugate.conjugate("SG1", "SG2", ConjugateBase.heWantsIt, verbTense, partofspeechc)
        verb.initialPrefixHolder.e = true

        assertTrue "ᎡᎬᏯᏚᎵᎭ" == new PrefixE().toSyllabary("", verb)

        verb.initialPrefixHolder.de = true

        assertTrue "ᏗᎬᏯᏚᎵᎭ" == new PrefixE().toSyllabary("", verb)
    }

    void testVerbE() {
        Verb verb = new Verb()
        verb.subject = PrefixTableSubject.SG1
        verb.object = PrefixTableObject.SG3AN
        verb.tense = Tense.PRESENT
        verb.stemmer = gowatiha
        verb.reflexiveHolderObject.reflexive = false
        verb.partOfSpeech = PartOfSpeech.VERB_TRANSITIVE

        verb.initialPrefixHolder.with {e = true}
        verb = Conjugate.conjugate(verb)

        assertTrue "ᎡᏥᎪᏩᏘᎭ" == new PrefixE().toSyllabary("", verb)

        verb.initialPrefixHolder.with {de = true}
        assertTrue "ᏗᏥᎪᏩᏘᎭ" == new PrefixE().toSyllabary("", verb)
    }
}
