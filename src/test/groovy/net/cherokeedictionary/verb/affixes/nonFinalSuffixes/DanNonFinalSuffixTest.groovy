package net.cherokeedictionary.verb.affixes.nonFinalSuffixes

import net.cherokeedictionary.core.Verb
import net.cherokeedictionary.conjugation.ConjugateBase
import net.cherokeedictionary.util.PrefixTableObject
import net.cherokeedictionary.util.PrefixTableSubject
import net.cherokeedictionary.util.Tense
import net.cherokeedictionary.verb.conjugation.Conjugate

//these tests are only to check the prefix pieces and not the verb conjugation itself
//pp 252-254 Durbin Feeling Dictionary
class DanNonFinalSuffixTest extends ConjugateBase {
    public void AtestVerbDan() {
        Verb verb = new Verb()
        verb.subject = PrefixTableSubject.SG1
        verb.object = PrefixTableObject.SG2
        verb.tense = Tense.PRESENT
        verb.stemmer = gowatiha
        verb.nonFinalSuffixHolder.dan = true//with {dan = true}

        verb = Conjugate.conjugate(verb)

        assertTrue "ᎬᎪᏩᏘᏓᎾ" == verb.wholeWord

        verb.object = PrefixTableObject.SG3AN
        verb = Conjugate.conjugate(verb)

        assertTrue "ᏥᎪᏩᏘᏓᎾ" == verb.wholeWord

//        verb.initialPrefixHolder.di = true
//        verb = Conjugate.conjugate(verb)
//
//        log(verb)
//
//        assertTrue "ᏥᎪᏩᏘᏓᎾ" == verb.wholeWord
    }
}
