package net.cherokeedictionary.conjugation

import net.cherokeedictionary.core.Verb
import net.cherokeedictionary.factory.VerbFactory
import net.cherokeedictionary.util.PartOfSpeech
import net.cherokeedictionary.util.PrefixTableObject
import net.cherokeedictionary.util.Tense
import net.cherokeedictionary.verb.conjugation.Conjugate

class GowatihaSG3SG3ANTest extends ConjugateBase {
    Verb verb = Conjugate.createVerbToConjugate("SG3", "SG3AN", gowatiha, "PRESENT", PartOfSpeech.VERB_TRANSITIVE, false)

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
        assertEquals("ᎦᎪᎲᎢ", verb.wholeWord)
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
        assertEquals("ᎦᎪᏩᏛᏗ", verb.wholeWord)
    }

    void testSG3SG3ANCommand() {
        verb.tense = Tense.FUTURE_COMMAND
        verb = Conjugate.conjugate(verb)
        assertEquals("ᎦᎪᏩᏘ", verb.wholeWord)
    }

    void testSG3SG3INCommand() {
        verb.object = PrefixTableObject.SG3IN
        verb.tense = Tense.FUTURE_COMMAND
        verb = Conjugate.conjugate(verb)
        assertEquals("ᎦᎪᏩᏘ", verb.wholeWord)
    }
}
