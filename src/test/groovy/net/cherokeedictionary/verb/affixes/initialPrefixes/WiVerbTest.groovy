package net.cherokeedictionary.verb.affixes.initialPrefixes

import net.cherokeedictionary.core.Verb
import net.cherokeedictionary.conjugation.ConjugateBase
import net.cherokeedictionary.stemmer.DefinitionLine
import net.cherokeedictionary.stemmer.Stemmer
import net.cherokeedictionary.verb.conjugation.Conjugate
import net.cherokeedictionary.util.PartOfSpeech
import net.cherokeedictionary.util.PrefixTableObject
import net.cherokeedictionary.util.PrefixTableSubject
import net.cherokeedictionary.util.Tense

/**
 * Rule: w-, position or motion away from speaker
 *
 * form: w- before vowels, wi- before consonants; cf. (25-26).
 * When it precedes h-, metathesis occurs, as in (27).
 * In some forms, w- may be deleted after the negative y-; note (28).
 * function: w- is employed optionally to indicate that the subject of the verb
 * is facing away from the speaker. In the case of motion verbs, it follows that
 * the motion will be away from the speaker.
 *
 * Source: Durbin Feeling, Cherokee Reference Grammar, pp. 244-245.
 */
class WiVerbTest extends ConjugateBase {
    static def uwohla = new Stemmer()       // "he's sitting" - (29)
    static def walk = new Stemmer()         // "he's walking" - (30)
    static def work = new Stemmer()         // "he works" - (33)

    static {
        uwohla.present3rd = new DefinitionLine(syllabary: "ᎤᏬᏝ")

        walk.present3rd = new DefinitionLine(syllabary: "ᎠᎢ")

        work.present3rd = new DefinitionLine(syllabary: "ᏚᎸᏫᏍᏓᏁᎰᎢ")
    }

    /**
     * (25a) baseline: ᎠᎪᏩᏘᎭ. a²gowhti³ha. "He sees it."
     */
    void testExample25a_BaselineGowatihaSG3() {
        Verb verb = new Verb()
        verb.subject = PrefixTableSubject.SG3
        verb.object = PrefixTableObject.SG3AN
        verb.tense = Tense.PRESENT
        verb.stemmer = gowatiha

        verb = Conjugate.conjugate(verb)

        assertTrue "ᎠᎪᏩᏘᎭ" == verb.wholeWord
    }

    /**
     * (25b) w- merges with vowel-initial stems: a- + w- -> wa-
     *       ᏩᎪᏩᏘᎭ. wạ²gowh³tị²ha. "He sees it (with his back turned to the speaker)."
     */
    void testExample25b_WiBeforeVowelMergesToWa() {
        Verb verb = new Verb()
        verb.subject = PrefixTableSubject.SG3
        verb.object = PrefixTableObject.SG3AN
        verb.tense = Tense.PRESENT
        verb.stemmer = gowatiha
        verb.initialPrefixHolder.with {wi = true}

        verb = Conjugate.conjugate(verb)

        assertTrue "ᏩᎪᏩᏘᎭ" == verb.wholeWord
    }

    /**
     * (26b) w- before consonant-initial stems is prefixed as wi- (Ꮻ)
     * Tested with the SG1 form ᏥᏬᏂᎭ (ji-woniha), a consonant-initial base:
     * ᏥᏬᏂᎭ -> ᏫᏥᏬᏂᎭ. The grammar's own example (ᏣᏕᎦ -> ᏫᏣᏕᎦ, tsadega
     * "you're throwing it") follows the same w- before consonants rule.
     */
    void testExample26b_WiBeforeConsonantPrefixesWi() {
        Verb verb = new Verb()
        verb.subject = PrefixTableSubject.SG1
        verb.object = PrefixTableObject.SG3IN
        verb.tense = Tense.PRESENT
        verb.stemmer = hiwoniha
        verb.initialPrefixHolder.with {wi = true}

        verb = Conjugate.conjugate(verb)

        assertTrue "ᏫᏥᏬᏂᎭ" == verb.wholeWord
    }

    /**
     * (27a) baseline: ᎯᎪᏩᏘᎭ. hi²gowhti³ha. "You see it."
     */
    void testExample27a_BaselineGowatihaSG2() {
        Verb verb = new Verb()
        verb.subject = PrefixTableSubject.SG2
        verb.object = PrefixTableObject.SG3IN
        verb.tense = Tense.PRESENT
        verb.stemmer = gowatiha

        verb = Conjugate.conjugate(verb)

        assertTrue "ᎯᎪᏩᏘᎭ" == verb.wholeWord
    }

    /**
     * (27b) When wi- precedes h-, metathesis occurs (h- is dropped):
     *       ᎯᎪᏩᏘᎭ -> ᏫᎪᏩᏘᎭ. hwi²gowh³ti²ha. "You see it (looking away
     *       from the speaker)."
     */
    void testExample27b_WiDropsHWhenPrecedingH() {
        Verb verb = new Verb()
        verb.subject = PrefixTableSubject.SG2
        verb.object = PrefixTableObject.SG3IN
        verb.tense = Tense.PRESENT
        verb.stemmer = gowatiha
        verb.initialPrefixHolder.with {wi = true}

        verb = Conjugate.conjugate(verb)

        // h- is dropped before wi- : ᎯᎪᏩᏘᎭ -> ᏫᎪᏩᏘᎭ (not *ᏫᎯᎪᏩᏘᎭ)
        assertTrue "ᏫᎪᏩᏘᎭ" == verb.wholeWord
    }

    /**
     * (28a) full form: negative y- -> yu-, then wi- :
     *       ᏳᏫᎦᏬᏂᎭ. yụ²wi²gạ²wo³ni²ha. "He isn't speaking (with his back turned)."
     */
    void testExample28a_YiNegativeWithWiFullForm() {
        Verb verb = new Verb()
        verb.subject = PrefixTableSubject.SG3
        verb.object = PrefixTableObject.SG3IN
        verb.partOfSpeech = PartOfSpeech.VERB_INTRANSITIVE
        verb.tense = Tense.PRESENT
        verb.stemmer = hiwoniha
        verb.initialPrefixHolder.with {wi = true}
        verb.initialPrefixHolder.with {yi = true}

        verb = Conjugate.conjugate(verb)

        // yu- + wi- : ᎦᏬᏂᎭ -> ᏳᏫᎦᏬᏂᎭ
        assertTrue "ᏳᏫᎦᏬᏂᎭ" == verb.wholeWord
    }

    /**
     * (28b) the negative y- becomes yu- with w- optionally deleted:
     *       ᏳᎦᏬᏂᎭ. yu²gạ²wo³ni²ha. "He isn't speaking (with his back turned)."
     *
     * KNOWN-GAP(WI-28B): PrefixYi/PrefixProcessor only generate the full form (28a).
     * ACCEPTANCE: when implemented, assert the optionally-deleted form "ᏳᎦᏬᏂᎭ"
     */
    void testExample28b_WiOptionallyDeletedAfterYiNegative() {
        Verb verb = new Verb()
        verb.subject = PrefixTableSubject.SG3
        verb.object = PrefixTableObject.SG3IN
        verb.partOfSpeech = PartOfSpeech.VERB_INTRANSITIVE
        verb.tense = Tense.PRESENT
        verb.stemmer = hiwoniha
        verb.initialPrefixHolder.with {wi = true}
        verb.initialPrefixHolder.with {yi = true}

        verb = Conjugate.conjugate(verb)

        // GAP GUARD: pins the current limitation (only the full form is generated).
        // When WI-28B (optional w- deletion after y-) is implemented upstream,
        // this assertion FAILS -- remove the guard and assert "ᏳᎦᏬᏂᎭ".
        assertTrue "KNOWN-GAP(WI-28B) RESOLVED: the optional w- deletion form is now generated " +
                    "-- remove this guard and add coverage for 'ᏳᎦᏬᏂᎭ'",
                "ᏳᏫᎦᏬᏂᎭ" == verb.wholeWord
    }

    /**
     * (29) motion/position verbs: subject sitting with back to speaker
     *      (u- + w- merges to wu-)
     *
     * a. ᎤᏬᏝ. u¹wo²hla.   "He's sitting."
     * b. ᏳᏬᏝ. wụ²wo³hla.  "He's sitting (with his back to the speaker)."
     *
     * RESOLVED(WI-29) -- tio 12Nov26: Stemmer normalization now treats Ꭴ +
     * Ꮺ/Ꮻ/Ꮼ/Ꮽ/Ꮾ entries as the Set-B u- pronominal + w-initial consonant stem
     * (-wohla), so the root resolves and the wi- merge surfaces ᏭᏬᏝ (wu-
     * replaces the u-). ACCEPTANCE asserts "ᏭᏬᏝ" (canonical wu glyph) --
     * Feeling's grammar prints ᏳᏬᏝ, but the romanization wụ²wo³hla confirms
     * 'wu'; the Ᏻ glyph is an OCR artifact of Ꮽ.
     */
    void testExample29_WiWithSittingVerb() {
        Verb verb = new Verb()
        verb.subject = PrefixTableSubject.SG3
        verb.object = PrefixTableObject.SG3IN
        verb.partOfSpeech = PartOfSpeech.VERB_INTRANSITIVE
        verb.tense = Tense.PRESENT
        verb.stemmer = uwohla
        verb.initialPrefixHolder.with {wi = true}

        verb = Conjugate.conjugate(verb)

        // tio 12Nov26: WI-29 RESOLVED -- Stemmer normalization now handles the
        // Set-B Ꭴ + w-stem corner case (ᎤᏬᏝ = u- + -wohla), so the root is no
        // longer empty and the wi- merge surfaces ᏭᏬᏝ (wu- replaces the sg3 u-).
        // GAP GUARD removed per the gap-guard protocol; assert the canonical form.
        assertTrue "WI-29: expected ᏭᏬᏝ (wu- + -wohla), got: ${verb.wholeWord}",
                "ᏭᏬᏝ" == verb.wholeWord
    }

    /**
     * (30) motion verbs: walking away from speaker
     *
     * a. ᎠᎢ. a³ʔi.   "He's walking."
     * b. ᏩᎢ. wa³ʔi.  "He's walking (away from the speaker)."
     *    (The grammar text prints ᎳᎢ, but the romanization wa³ʔi confirms
     *    w- + a- -> wa- : ᏩᎢ; Ꮃ appears to be an OCR artifact of Ꮹ.)
     */
    void testExample30_WiWithWalkingVerb() {
        Verb verb = new Verb()
        verb.subject = PrefixTableSubject.SG3
        verb.object = PrefixTableObject.SG3IN
        verb.partOfSpeech = PartOfSpeech.VERB_INTRANSITIVE
        verb.tense = Tense.PRESENT
        verb.stemmer = walk
        verb.initialPrefixHolder.with {wi = true}

        verb = Conjugate.conjugate(verb)

        assertTrue "ᏩᎢ" == verb.wholeWord
    }

    /**
     * (31) w- must be used with non-second person forms with the meaning "let"
     *
     * a. ᏥᏬᏂᎯ.  ji²wo³ni²hi.   "Let me speak."
     * b. ᏫᏥᏬᏂᎯ. wi²ji²wo³ni²hi. "Let me speak."
     *
     * KNOWN-GAP(WI-31): the hortative "let" ending (-Ꭿ) and the ji- + wi-
     * ordering (wi- outermost, cf. ᏫᏥ...) are not wired into the
     * IMMEDIATE_COMMAND / ji- prefix processing pipeline yet.
     * ACCEPTANCE: conj(SG1, SG3IN, hiwoniha, IMMEDIATE_COMMAND, ji + wi) == "ᏫᏥᏬᏂᎯ"
     */
    void testExample31_WiWithLetMeSpeak() {
        Verb verb = new Verb()
        verb.subject = PrefixTableSubject.SG1
        verb.object = PrefixTableObject.SG3IN
        verb.tense = Tense.IMMEDIATE_COMMAND
        verb.stemmer = hiwoniha
        verb.initialPrefixHolder.with {wi = true}
        verb.initialPrefixHolder.with {ji = true}

        verb = Conjugate.conjugate(verb)

        // GAP GUARD: pins the current inability to produce the hortative form.
        // When WI-31 (hortative -Ꭿ + ji/wi ordering) is implemented, this
        // assertion FAILS -- remove the guard and assert "ᏫᏥᏬᏂᎯ".
        assertTrue "KNOWN-GAP(WI-31) RESOLVED: the hortative 'let me' form is now generated " +
                    "-- remove this guard and assert 'ᏫᏥᏬᏂᎯ'",
                "ᏫᏥᏬᏂᎯ" != verb.wholeWord
    }

    /**
     * (32) w- with second person imperative changes meaning: "Speak (facing away)"
     *
     * a. ᎯᏬᏂᎯ. hi²wo¹ni²hi.   "Speak."
     * b. ᏫᏬᏂᎯ. hwi²wo³ni²hi.  "Speak (facing away)."
     *
     * KNOWN-GAP(WI-32): Tense.IMMEDIATE_COMMAND is not wired into the
     * conjugation switch in VerbConjugationProcessor yet, so the imperative
     * stem (ᎯᏬᏂᎯ) cannot be conjugated + prefixed.
     * ACCEPTANCE: conj(SG2, SG3IN, hiwoniha, IMMEDIATE_COMMAND, wi) == "ᏫᏬᏂᎯ"
     */
    void testExample32_WiWithSecondPersonImperative() {
        Verb verb = new Verb()
        verb.subject = PrefixTableSubject.SG2
        verb.object = PrefixTableObject.SG3IN
        verb.tense = Tense.IMMEDIATE_COMMAND
        verb.stemmer = hiwoniha
        verb.initialPrefixHolder.with {wi = true}

        verb = Conjugate.conjugate(verb)

        // GAP GUARD: pins the current inability to produce the imperative form.
        // When WI-32 (IMMEDIATE_COMMAND wiring) is implemented, this assertion
        // FAILS -- remove the guard and assert "ᏫᏬᏂᎯ".
        assertTrue "KNOWN-GAP(WI-32) RESOLVED: the SG2 imperative form is now generated " +
                    "-- remove this guard and assert 'ᏫᏬᏂᎯ'",
                "ᏫᏬᏂᎯ" != verb.wholeWord
    }

    /**
     * (33) When the subject is not within sight of the speaker, w- indicates distance
     *
     * a. ᏚᎸᏫᏍᏓᏁᎰᎢ.  du¹lv²hwị³sda¹ne²ho³ʔi.    "He works."
     * b. ᏫᏚᎸᏫᏍᏓᏁᎰᎢ. wi²du²lv³hwị²sda¹ne²ho³ʔi. "He works (at a distance)."
     *
     * KNOWN-GAP(WI-33): the Set-B SG3 du- pronominal handling currently reduces
     * the du- prefix to u- upstream of PrefixWi (engine result: ᏭᎸᏫᏍᏓᏁᎰᎢ
     * instead of ᏫᏚᎸᏫᏍᏓᏁᎰᎢ).
     * ACCEPTANCE: conj(SG3, SG3IN, work, PRESENT, vi, wi) == "ᏫᏚᎸᏫᏍᏓᏁᎰᎢ"
     */
    void testExample33_WiIndicatesDistance() {
        Verb verb = new Verb()
        verb.subject = PrefixTableSubject.SG3
        verb.object = PrefixTableObject.SG3IN
        verb.partOfSpeech = PartOfSpeech.VERB_INTRANSITIVE
        verb.tense = Tense.PRESENT
        verb.stemmer = work
        verb.initialPrefixHolder.with {wi = true}

        verb = Conjugate.conjugate(verb)

        // GAP GUARD: pins the current broken state (du- reduced to u- upstream).
        // When WI-33 (du- pronominal preservation) is fixed, this assertion
        // FAILS -- remove the guard and assert "ᏫᏚᎸᏫᏍᏓᏁᎰᎢ".
        assertTrue "KNOWN-GAP(WI-33) RESOLVED: du- is no longer reduced to u- " +
                    "-- remove this guard and assert 'ᏫᏚᎸᏫᏍᏓᏁᎰᎢ'",
                "ᏭᎸᏫᏍᏓᏁᎰᎢ" == verb.wholeWord
    }

    /**
     * (34-35) With the dative-benefactive suffix, w- indicates dative meaning
     *
     * 34.  ᏕᎪᏪᎵᎠ.   de²go³hwe²lịʔa.        "He's writing them."
     * 35a. ᏕᎪᏪᎳᏁᎭ.  de²go³hwe²la³nẹ²ha.    "He's writing them for him."
     * 35b. ᏫᏗᎪᏪᎳᏁᎭ. wi²di²go²hwe³la¹nẹ²ha. "He's writing them to him."
     *
     * KNOWN-GAP(WI-35): the dative-benefactive suffix (-ᏁᎭ) and associated stem
     * changes are not implemented in the suffix machinery yet.
     * ACCEPTANCE: conj(SG3, SG3AN, writeTo, PRESENT, vt, dative suffix) == "ᏫᏗᎪᏪᎳᏁᎭ"
     */
    void testExample35_WiWithDativeBenefactive() {
        // AUDIT-ONLY (tracked by the gradle gapAudit task): there is no
        // runnable conjugation here yet -- a whole suffix mechanism plus a
        // dative stem would have to exist before any guard could flip.
        println "KNOWN-GAP(WI-35): dative-benefactive suffix (-ᏁᎭ) pipeling not implemented"
    }

    /** yi- + wi- combination on a transitive verb (cf. 28) */
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
}
