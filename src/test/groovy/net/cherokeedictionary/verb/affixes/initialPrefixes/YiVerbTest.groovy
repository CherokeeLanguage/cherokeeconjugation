package net.cherokeedictionary.verb.affixes.initialPrefixes

import net.cherokeedictionary.core.Verb
import net.cherokeedictionary.conjugation.ConjugateBase
import net.cherokeedictionary.verb.conjugation.Conjugate
import net.cherokeedictionary.util.PrefixTableObject
import net.cherokeedictionary.util.PrefixTableSubject
import net.cherokeedictionary.util.Tense

//these tests are only to check the prefix pieces and not the verb conjugation itself
//pp 252-254 Durbin Feeling Dictionary
class YiVerbTest extends ConjugateBase {
    void testVerbYi() {
        Verb verb = new Verb()
        verb.subject = PrefixTableSubject.SG1
        verb.object = PrefixTableObject.SG2
        verb.tense = Tense.PRESENT
        verb.stemmer = gowatiha
        verb.initialPrefixHolder.with {yi = true}

        verb = Conjugate.conjugate(verb)

        assertTrue "ᏱᎬᎪᏩᏘᎭ" == verb.wholeWord

        verb.object = PrefixTableObject.SG3AN
        verb = Conjugate.conjugate(verb)

        assertTrue "ᏱᏥᎪᏩᏘᎭ" == verb.wholeWord
    }
}
