package net.cherokeedictionary.conjugation

import net.cherokeedictionary.core.Verb
import net.cherokeedictionary.factory.VerbFactory
import net.cherokeedictionary.util.PartOfSpeech
import net.cherokeedictionary.util.PrefixTableObject
import net.cherokeedictionary.util.PrefixTableSubject
import net.cherokeedictionary.util.Tense
import net.cherokeedictionary.verb.conjugation.Conjugate

class GowatihaSG3SG3ANTest extends ConjugateBase {
    Verb verb = Conjugate.createVerbToConjugate("SG3", "SG3AN", gowatiha, "PRESENT", PartOfSpeech.VERB_TRANSITIVE.toString(), false)

    //test covers that SG3SG3AN and SG3SG3IN always puts the same thing no matter what the tense
    void testSG3SG3ANPresent() {
        verb = Conjugate.conjugate(verb)
        assertEquals("ᎠᎪᏩᏘᎭ", verb.wholeWord)
    }

    void testSG3SG3INPresent() {
        verb.object = PrefixTableObject.SG3IN
        verb = Conjugate.conjugate(verb)
        assertEquals("ᎦᎪᏩᏘᎭ", verb.wholeWord)
    }

    void testSG3SG3ANPast() {
        verb.tense = Tense.REMOTE_PAST
        verb = Conjugate.conjugate(verb)
        //timo 10Nov26: guide-correct update — remote past -v'i is non-progressive, so
        //Set B prefixes apply (Feeling P8 preamble); P8(5) prints ONE form uw- for
        //"he hit him, it" = "he hit it", i.e. SG3SG3ANB == SG3SG3INB = uw-/u-.
        //ᎤᎪᎲᎢ (ugohv'i) matches the verb book p.119 "He/she saw it".
        assertEquals("ᎤᎪᎲᎢ", verb.wholeWord)
    }

    void testSG3SG3INPast() {
        verb.object = PrefixTableObject.SG3IN
        verb.tense = Tense.REMOTE_PAST
        verb = Conjugate.conjugate(verb)
        assertEquals("ᎤᎪᎲᎢ", verb.wholeWord)
    }

    void testSG3SG3ANHabitual() {
        verb.tense = Tense.HABITUAL
        verb = Conjugate.conjugate(verb)
        assertEquals("ᎦᎪᏩᏘᏍᎪᎢ", verb.wholeWord)
    }

    void testSG3SG3INHabitual() {
        verb.object = PrefixTableObject.SG3IN
        verb.tense = Tense.HABITUAL
        verb = Conjugate.conjugate(verb)
        assertEquals("ᎦᎪᏩᏘᏍᎪᎢ", verb.wholeWord)
    }

    void testSG3SG3ANInfinitive() {
        verb.tense = Tense.INFINITIVE
        verb = Conjugate.conjugate(verb)
        assertEquals("ᎦᎪᏩᏛᏗ", verb.wholeWord)
    }

    void testSG3SG3INInfinitive() {
        verb.object = PrefixTableObject.SG3IN
        verb.tense = Tense.INFINITIVE
        verb = Conjugate.conjugate(verb)
        println verb.wholeWord
        assertEquals("ᎤᎪᏩᏛᏗ", verb.wholeWord)
    }

    void testSG3SG3ANCommand() {
        // Verb book (To See, Stem III): Future Imperative/Volative -goh-v'i = the
        // Remote Past form, so SG3SG3AN is ᎦᎪᎲᎢ (was ᎦᎪᏩᏘ, the old present-derived
        // command placeholder). -- timo 10Nov26
        verb.tense = Tense.FUTURE_COMMAND
        verb = Conjugate.conjugate(verb)
        assertEquals("ᎦᎪᎲᎢ", verb.wholeWord)
    }

    void testSG3SG3INCommand() {
        verb.object = PrefixTableObject.SG3IN
        verb.tense = Tense.FUTURE_COMMAND
        verb = Conjugate.conjugate(verb)

        println verb.wholeWord
        assertEquals("ᏓᎦᎪᎲᎢ", verb.wholeWord)
    }

    void testSG1SG3ANFutureCommand() {
        verb.subject = PrefixTableSubject.SG1
        verb.object = PrefixTableObject.SG3AN
        verb.tense = Tense.FUTURE_COMMAND
        verb = Conjugate.conjugate(verb)

        println verb.wholeWord
        //timo 10Nov26: guide-correct update — FUTURE_COMMAND (Future
        //Imperative/Volative) routes through the Set A table (determineVerbSet keeps
        //it Set A, matching the vrb/* specs), and Set A SG1SG3AN is ji- (Ꮵ): "I'm
        //going to see him" = ᏥᎪᎲᎢ. The Ꮣ- form belongs to the plural/inanimate
        //distributive (119b "I saw it/them" rows), not to a singular animate object.
        assertEquals("ᏥᎪᎲᎢ", verb.wholeWord)
    }

    /**
     * Remote Past Tense (Stem III), -goh-v’i
     * This form differs from future imperative/volative only by tone change.
     * “I saw it” agigohv’i ᎠᎩᎪᎲᎢ
     * “He/she saw it” ugohv’i ᎤᎪᎲᎢ
     * These are the SG3IN objects and not the SG3AN objects
     * pp 119 Cherokee Verb Conjugation Feeling, Kopris, et al
     */
    void testSG1SG3ANRemotePastInanimate() {
        verb.subject = PrefixTableSubject.SG1
        verb.object = PrefixTableObject.SG3IN
        verb.tense = Tense.REMOTE_PAST
        verb = Conjugate.conjugate(verb)

        //I saw it (the pencil)
        assertEquals("ᎠᎩᎪᎲᎢ", verb.wholeWord)

        verb.subject = PrefixTableSubject.SG3
        verb = Conjugate.conjugate(verb)

        //he saw it (the pencil)
        assertEquals("ᎤᎪᎲᎢ", verb.wholeWord)
    }

    void testSG1SG3ANRemotePastAnimate() {
        verb.subject = PrefixTableSubject.SG1
        verb.object = PrefixTableObject.SG3AN
        verb.tense = Tense.REMOTE_PAST
        verb = Conjugate.conjugate(verb)

        println verb.wholeWord
        assertEquals("ᏥᎪᎲᎢ", verb.wholeWord)

        verb.subject = PrefixTableSubject.SG3
        verb = Conjugate.conjugate(verb)

        println verb.wholeWord
        //timo 10Nov26: guide-correct update — P8(5) prints one Set B form (uw-) for
        //"he hit him, it"; SG3SG3ANB == SG3SG3INB, so this is ᎤᎪᎲᎢ (ugohv'i), the
        //verb book p.119 "He/she saw it" — not ᎦᎪᎲᎢ (the Set A present form).
        assertEquals("ᎤᎪᎲᎢ", verb.wholeWord)
    }
}
