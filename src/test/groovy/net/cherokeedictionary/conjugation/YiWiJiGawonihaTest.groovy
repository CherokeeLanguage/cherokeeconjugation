package net.cherokeedictionary.conjugation

import net.cherokeedictionary.util.PartOfSpeech
import net.cherokeedictionary.util.PrefixTableSubject
import net.cherokeedictionary.verb.conjugation.Conjugate


class YiWiJiGawonhihaTest extends ConjugateBase {
    void testGawotiha() {

        def verb = Conjugate.createVerbToConjugate("SG2", "SG3AN", hiwoniha, "PRESENT", PartOfSpeech.VERB_TRANSITIVE.toString(), false)
        assertTrue "ᎯᏬᏂᎭ" == Conjugate.conjugate(verb).wholeWord

        verb.initialPrefixHolder.wi = true

        assertTrue "ᏫᏬᏂᎭ" == Conjugate.conjugate(verb).wholeWord

        verb.initialPrefixHolder.wi = false
        verb.initialPrefixHolder.ji = true

        assertTrue "ᏥᎯᏬᏂᎭ" == Conjugate.conjugate(verb).wholeWord

        verb.initialPrefixHolder.wi = true
        verb.initialPrefixHolder.ji = true

        assertTrue "ᏨᏫᏬᏂᎭ" == Conjugate.conjugate(verb).wholeWord

        verb.initialPrefixHolder.wi = false
        verb.initialPrefixHolder.ji = false
        verb.initialPrefixHolder.yi = true

        assertTrue "ᏱᏬᏂᎭ" == Conjugate.conjugate(verb).wholeWord

        verb = Conjugate.createVerbToConjugate("SG3", "SG3AN", gowatiha, "PRESENT", PartOfSpeech.VERB_TRANSITIVE.toString(), false)

        //a¹gowh²tị³ha.	"He sees it."
        verb.initialPrefixHolder.yi = false
        assertTrue "ᎠᎪᏩᏘᎭ" == Conjugate.conjugate(verb).wholeWord

        //b.	Ꮭ ᏯᎪᏩᏘᎭ.
        //hla³ yạ²gowh³tị²ha.	"He doesn't see it."
        verb.initialPrefixHolder.yi = true
        assertTrue "ᏯᎪᏩᏘᎭ" == Conjugate.conjugate(verb).wholeWord

        //(2)	a.	ᏥᎪᏩᏘᎭ.
        //        jị²gowh¹ti³ha.	"I see it."
        verb.initialPrefixHolder.yi = false
        verb.subject = PrefixTableSubject.SG1
        assertTrue "ᏥᎪᏩᏘᎭ" == Conjugate.conjugate(verb).wholeWord

        //b.	Ꮭ ᏱᏥᎪᏩᏘᎭ.
        //hla³ yị²jị²gowh³²tị³ha.	"I don't see it."
        verb.initialPrefixHolder.yi = true
        verb.subject = PrefixTableSubject.SG1
        assertTrue "ᏱᏥᎪᏩᏘᎭ" == Conjugate.conjugate(verb).wholeWord

//        (3)	a.	ᏩᎪᏩᏘᎭ.
//        wạ²gowh³tị²ha.	"He sees it (with his back turned)."
        verb.initialPrefixHolder.yi = false
        verb.initialPrefixHolder.wi = true
        verb.subject = PrefixTableSubject.SG3
        assertTrue "ᏩᎪᏩᏘᎭ" == Conjugate.conjugate(verb).wholeWord

//        b.	Ꮭ ᏳᏩᎪᏩᏘᎭ.
//        hla³ yụ²wạ²gowh³tị²ha.	"He doesn't see it (with his back turned)."
//        When y- directly precedes h- , metathesis occurs as in (4).
        verb.initialPrefixHolder.yi = true
        verb.initialPrefixHolder.wi = true
        verb.subject = PrefixTableSubject.SG3
        assertTrue "ᏳᏩᎪᏩᏘᎭ" == Conjugate.conjugate(verb).wholeWord

//        ᎯᎪᏩᏘᎭ.
//        hị²gowh²tị³ha.	"You see it."
        verb.initialPrefixHolder.yi = false
        verb.initialPrefixHolder.wi = false
        verb.subject = PrefixTableSubject.SG2
        assertTrue "ᎯᎪᏩᏘᎭ" == Conjugate.conjugate(verb).wholeWord

//        b.	Ꮭ ᏱᎪᏩᏘᎭ.
//        hla³ hyị²gowh³tị²ha.	"You don't see it."
        verb.initialPrefixHolder.yi = true
        verb.initialPrefixHolder.wi = false
        verb.subject = PrefixTableSubject.SG2
        assertTrue "ᏱᎪᏩᏘᎭ" == Conjugate.conjugate(verb).wholeWord


//        ᎦᏬᏂᎭ.
//        gạ²wo³nị²ha.	"He is speaking."
        verb.initialPrefixHolder.yi = false
        verb.stemmer = hiwoniha
        verb.subject = PrefixTableSubject.SG3
        assertTrue "ᎦᏬᏂᎭ" == Conjugate.conjugate(verb).wholeWord

//        b.	ᏱᎦᏬᏂᎭ.
//        yị²gạ²wo³²ni⁴ha.	"if he is speaking"
        verb.initialPrefixHolder.yi = true
        verb.subject = PrefixTableSubject.SG3
        assertTrue "ᏱᎦᏬᏂᎭ" == Conjugate.conjugate(verb).wholeWord
    }
}