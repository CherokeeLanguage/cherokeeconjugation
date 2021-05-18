package net.cherokeedictionary.verb.affixes.initialPrefixes

import net.cherokeedictionary.core.Verb
import net.cherokeedictionary.conjugation.ConjugateBase
import net.cherokeedictionary.verb.conjugation.Conjugate
import net.cherokeedictionary.util.PrefixTableObject
import net.cherokeedictionary.util.PrefixTableSubject
import net.cherokeedictionary.util.Tense

class WiVerbTest extends ConjugateBase {
    void testVerbWi() {
        Verb verb = new Verb()
        verb.subject = PrefixTableSubject.SG1
        verb.object = PrefixTableObject.SG2
        verb.tense = Tense.PRESENT
        verb.stemmer = gowatiha
        verb.initialPrefixHolder.with {wi = true}

        verb = Conjugate.conjugate(verb)

        assertTrue "ᏫᎬᎪᏩᏘᎭ" == verb.wholeWord
    }

    void testVerbYiWi() {
        Verb verb = new Verb()
        verb.subject = PrefixTableSubject.SG1
        verb.object = PrefixTableObject.SG2
        verb.tense = Tense.PRESENT
        verb.stemmer = gowatiha
        verb.initialPrefixHolder.with {wi = true}

        verb.initialPrefixHolder.yi = true

        verb = Conjugate.conjugate(verb)

        assertTrue "ᏳᏫᎬᎪᏩᏘᎭ" == verb.wholeWord

        verb.object = PrefixTableObject.SG3AN

        verb = Conjugate.conjugate(verb)

        assertTrue "ᏳᏫᏥᎪᏩᏘᎭ" == verb.wholeWord
    }
}
