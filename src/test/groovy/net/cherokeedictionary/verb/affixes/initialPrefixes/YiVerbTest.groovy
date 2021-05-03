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
    Verb createBaseVerb() {
        Verb verb = new Verb()
        verb.subject = PrefixTableSubject.SG1
        verb.object = PrefixTableObject.SG3AN
        verb.tense = Tense.PRESENT

        return verb
    }

    void testVerbYigawoniha() {
        Verb verb = createBaseVerb()
        verb.stemmer = hiwoniha
        verb.initialPrefixHolder.with {yi = true}

        verb.subject = PrefixTableSubject.SG3

        verb = Conjugate.conjugate(verb)

        assertTrue "ᏱᎦᏬᏂᎭ" == verb.wholeWord
    }

    void testVerbYigowatiha() {
        Verb verb = createBaseVerb()
        verb.stemmer = gowatiha
        verb.initialPrefixHolder.with {yi = true}

        verb = Conjugate.conjugate(verb)

        assertTrue "ᏱᏥᎪᏩᏘᎭ" == verb.wholeWord
    }

    void testYiWgowatiha() {
        Verb verb = createBaseVerb()
        verb.stemmer = gowatiha
        verb.initialPrefixHolder.with {yi = true; wi=true}

        verb = Conjugate.conjugate(verb)
        assertTrue "ᏳᏫᏥᎪᏩᏘᎭ" == verb.wholeWord
    }

    void testYiWagowatiha() {
        Verb verb = createBaseVerb()
        verb.stemmer = gowatiha
        verb.initialPrefixHolder.with {yi = true; wi=true}

        verb.subject = PrefixTableSubject.SG3


        verb = Conjugate.conjugate(verb)
        assertTrue "ᏳᏩᎪᏩᏘᎭ" == verb.wholeWord
    }

    void testYvgowatiha() {
        Verb verb = createBaseVerb()
        verb.stemmer = gowatiha
        verb.initialPrefixHolder.with {yi = true}

        verb.subject = PrefixTableSubject.SG3


        verb = Conjugate.conjugate(verb)
        assertTrue "ᏯᎪᏩᏘᎭ" == verb.wholeWord
    }

    void testYvhigowatiha() {
        Verb verb = createBaseVerb()
        verb.stemmer = gowatiha
        verb.initialPrefixHolder.with {yi = true}

        verb.subject = PrefixTableSubject.SG2


        verb = Conjugate.conjugate(verb)
        println verb.wholeWord

//        assertTrue "ᏯᎪᏩᏘᎭ" == verb.wholeWord
    }
}
