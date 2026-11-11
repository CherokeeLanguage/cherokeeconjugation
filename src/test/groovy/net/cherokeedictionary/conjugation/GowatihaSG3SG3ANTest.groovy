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
        // timo 10Nov26: guide-correct update (vetoable). Book p.120 prints the sg3
        // habitual as ᎠᎪᏩᏘᏍᎪᎢ agowtisgo'i (a-) — the dictionary's raw habitual row
        // (ConjugateBase gowatiha.habitual) IS this form. Old expectation ᎦᎪᏩᏘᏍᎪᎢ
        // (ga-, composed from the present-tense table's SG3SG3AN preConsonant) is
        // not printed anywhere. Engine now short-circuits HABITUAL sg3 from the raw
        // habitual row (VerbConjugationProcessor.process, mirroring PRESENT);
        // RECHECK: sg3 habitual allomorphy is lexical, revert short-circuit if a
        // counter-example surfaces. -- timo 10Nov26
        assertEquals("ᎠᎪᏩᏘᏍᎪᎢ", verb.wholeWord)
    }

    void testSG3SG3INHabitual() {
        verb.object = PrefixTableObject.SG3IN
        verb.tense = Tense.HABITUAL
        verb = Conjugate.conjugate(verb)
        // timo 10Nov26: guide-correct update (vetoable). Same row as the AN test:
        // book p.120 prints ONE sg3 habitual, ᎠᎪᏩᏘᏍᎪᎢ agowtisgo'i, covering the
        // "him/her" (AN) and "it" (IN) readings alike. Old expectation ᎦᎪᏩᏘᏍᎪᎢ
        // (ga-) not attested. NOTE the open asymmetry: for PRESENT the transitive
        // SG3SG3IN cell still composes ga- (testSG3SG3INPresent ᎦᎪᏩᏘᎭ) while the
        // book prints ᎠᎪᏩᏘᎭ a- for "He/she sees it" (p.118) — left as-is because
        // present sg3 handling is user-owned; RECHECK together. -- timo 10Nov26
        assertEquals("ᎠᎪᏩᏘᏍᎪᎢ", verb.wholeWord)
    }

    void testSG3SG3ANInfinitive() {
        // timo 10Nov26: guide-correct update (vetoable). Set B infinitive for
        // SG3SG3AN is u-: the verb book lists no infinitive rows for To See, but
        // every book infinitive table with a 3rd singular prints u- (be somewhere
        // ᎤᏪᏓᏍᏗ uwedasdi, fall ᎤᏅᎢᏍᏗ unv'isdi, bite ᎤᏍᎦᎶᏍᏗ usgahlsdi); Feeling
        // guide p.8344 removes "the prefix u-" from dictionary infinitives; and
        // the user's own vrb data (AgowatihaSpec) has infinitive 'ugowatvhdi'.
        // Old expectation ᎦᎪᏩᏛᏗ (ga-) is not attested anywhere.
        verb.tense = Tense.INFINITIVE
        verb = Conjugate.conjugate(verb)
        assertEquals("ᎤᎪᏩᏛᏗ", verb.wholeWord)
    }

    void testSG3SG3INInfinitive() {
        verb.object = PrefixTableObject.SG3IN
        verb.tense = Tense.INFINITIVE
        verb = Conjugate.conjugate(verb)
        println verb.wholeWord
        assertEquals("ᎤᎪᏩᏛᏗ", verb.wholeWord)
    }

    void testSG3SG3ANCommand() {
        // Verb book (To See, p.119) prints the Future Imperative/Volative section
        // as four rows: ᎯᎪᎲᎢ / ᏍᏗᎪᎲᎢ / ᎢᏥᎪᎲᎢ / ᎠᎪᎲᎢ "Let him/her see it!" —
        // the 3rd-person row is a- (ᎠᎪᎲᎢ agohv'i), NOT ga-. Matches the row
        // transcribed in cherokeeVerbConjugation/ToSeeFutureImperativeVolativeSpec.
        // timo 10Nov26: this supersedes the earlier reading (ᎦᎪᎲᎢ, carried by the
        // present-tense ga- preConsonant). RECHECK: if the printed row is actually
        // ga-, revert processPrefixes' tense-scoped a- override instead. -- timo 10Nov26
        verb.tense = Tense.FUTURE_COMMAND
        verb = Conjugate.conjugate(verb)
        assertEquals("ᎠᎪᎲᎢ", verb.wholeWord)
    }

    void testSG3SG3INCommand() {
        verb.object = PrefixTableObject.SG3IN
        verb.tense = Tense.FUTURE_COMMAND
        verb = Conjugate.conjugate(verb)

        println verb.wholeWord
        // Verb book p.119 (see testSG3SG3ANCommand): the 3rd-person FIV row is
        // ᎠᎪᎲᎢ agohv'i for both SG3AN and SG3IN object readings — the earlier
        // da- reading (ᏓᎦᎪᎲᎢ) does not appear in the printed FIV section.
        // RECHECK: same caveat as the AN test above. -- timo 10Nov26
        assertEquals("ᎠᎪᎲᎢ", verb.wholeWord)
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
