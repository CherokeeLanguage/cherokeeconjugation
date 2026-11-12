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
     * RESOLVED(WI-28B) -- tio 12Nov26: the guide marks the deletion OPTIONAL,
     * so the canonical wholeWord stays the full form (28a) and the deleted
     * form is generated as verb.variantWord (core.Verb.variantWord; reset per
     * conjugation in Conjugate.conjugate). RECHECK: if a source decides the
     * deleted form is canonical, swap them in PrefixYi. -- timo 12Nov26
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

        // canonical full form (28a) unchanged:
        assertTrue "expected canonical ᏳᏫᎦᏬᏂᎭ, got: ${verb.wholeWord}",
                "ᏳᏫᎦᏬᏂᎭ" == verb.wholeWord
        // optional deletion (28b) generated as the variant:
        assertTrue "expected variant ᏳᎦᏬᏂᎭ (w- deleted after negative y-), got: ${verb.variantWord}",
                "ᏳᎦᏬᏂᎭ" == verb.variantWord
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
     * RESOLVED(WI-31) -- tio 12Nov26: in the imperative tenses the hortative
     * ji- is carried by the pronominal itself (SG1 = Ꮵ-), so PrefixJi no-ops
     * there (tense-scoped; the PRESENT "still" ji- keeps stacking per
     * JiVerbTest). wi- composes OUTSIDE the pronominal Ꮵ (31b) via the normal
     * wi-first processor order. The printed -Ꭿ final survives now that
     * fixImperativeSuffix no longer decrements it (Ꭿ hi -> Ꭽ ha).
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

        // 31b: wi- + hortative ji- pronominal (wi outermost).
        assertTrue "expected ᏫᏥᏬᏂᎯ (wi- + ji- + wonihi), got: ${verb.wholeWord}",
                "ᏫᏥᏬᏂᎯ" == verb.wholeWord
    }

    /**
     * (31a) plain hortative, no wi-: the SG1 pronominal Ꮵ IS the "let me"
     * marker plus the printed -Ꭿ imperative final. -- timo 12Nov26
     */
    void testExample31a_PlainHortative() {
        Verb verb = new Verb()
        verb.subject = PrefixTableSubject.SG1
        verb.object = PrefixTableObject.SG3IN
        verb.tense = Tense.IMMEDIATE_COMMAND
        verb.stemmer = hiwoniha
        verb.initialPrefixHolder.with {ji = true}

        verb = Conjugate.conjugate(verb)

        assertTrue "expected ᏥᏬᏂᎯ (ji- + wonihi), got: ${verb.wholeWord}",
                "ᏥᏬᏂᎯ" == verb.wholeWord
    }

    /**
     * (32) w- with second person imperative changes meaning: "Speak (facing away)"
     *
     * a. ᎯᏬᏂᎯ. hi²wo¹ni²hi.   "Speak."
     * b. ᏫᏬᏂᎯ. hwi²wo³ni²hi.  "Speak (facing away)."
     *
     * RESOLVED(WI-32) -- tio 12Nov26: IMMEDIATE_COMMAND routes to the
     * imperative-derived stem (StemType.Immediate, vth.immediate) and the
     * printed -Ꭿ final survives (fixImperativeSuffix no longer decrements
     * Ꭿ -> Ꭽ), so the SG2 pronominal Ꭿ composes directly with the stem:
     * ᎯᏬᏂᎯ (32a), and wi- wraps it: ᏫᏬᏂᎯ (32b).
     */
    void testExample32_WiWithSecondPersonImperative() {
        Verb verb = new Verb()
        verb.subject = PrefixTableSubject.SG2
        verb.object = PrefixTableObject.SG3IN
        verb.tense = Tense.IMMEDIATE_COMMAND
        verb.stemmer = hiwoniha
        verb.initialPrefixHolder.with {wi = true}

        verb = Conjugate.conjugate(verb)

        // 32b: wi- + SG2 imperative.
        assertTrue "expected ᏫᏬᏂᎯ (wi- + hi-wonihi), got: ${verb.wholeWord}",
                "ᏫᏬᏂᎯ" == verb.wholeWord
    }

    /**
     * (32a) plain SG2 imperative, no wi-: ᎯᏬᏂᎯ. -- timo 12Nov26
     */
    void testExample32a_PlainSecondPersonImperative() {
        Verb verb = new Verb()
        verb.subject = PrefixTableSubject.SG2
        verb.object = PrefixTableObject.SG3IN
        verb.tense = Tense.IMMEDIATE_COMMAND
        verb.stemmer = hiwoniha

        verb = Conjugate.conjugate(verb)

        assertTrue "expected ᎯᏬᏂᎯ (hi-wonihi), got: ${verb.wholeWord}",
                "ᎯᏬᏂᎯ" == verb.wholeWord
    }

    /**
     * (33) When the subject is not within sight of the speaker, w- indicates distance
     *
     * a. ᏚᎸᏫᏍᏓᏁᎰᎢ.  du¹lv²hwị³sda¹ne²ho³ʔi.    "He works."
     * b. ᏫᏚᎸᏫᏍᏓᏁᎰᎢ. wi²du²lv³hwị²sda¹ne²ho³ʔi. "He works (at a distance)."
     *
     * RESOLVED(WI-33) -- tio 12Nov26: the entry's Ꮪ is the da- initial prefix
     * fused with the Set-B sg3 u- (da + u + lvhwisdaneho'i). The stemmer now
     * remembers the fusion (normalizedDaInitialPrefix) and Conjugate re-declares
     * da for SG3 single-object conjugations, so PrefixDa's D-map re-fuses it:
     * plain sg3 = ᏚᎸᏫᏍᏓᏁᎰᎢ (33a), and wi- prepends before the fused Ꮪ:
     * ᏫᏚᎸᏫᏍᏓᏁᎰᎢ (33b).
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

        // 33b: wi- + fused da/u — the acceptance form from the guide.
        assertTrue "WI-33: expected ᏫᏚᎸᏫᏍᏓᏁᎰᎢ (wi- + da + u + lvhwisdaneho'i), got: ${verb.wholeWord}",
                "ᏫᏚᎸᏫᏍᏓᏁᎰᎢ" == verb.wholeWord
    }

    /**
     * (33a) plain sg3 of the same entry — the fused da- must survive without
     * wi- as well: ᏚᎸᏫᏍᏓᏁᎰᎢ, NOT ᎤᎸᏫᏍᏓᏁᎰᎢ (the old reduced form). -- timo 12Nov26
     */
    void testExample33a_PlainSg3KeepsDaFusion() {
        Verb verb = new Verb()
        verb.subject = PrefixTableSubject.SG3
        verb.object = PrefixTableObject.SG3IN
        verb.partOfSpeech = PartOfSpeech.VERB_INTRANSITIVE
        verb.tense = Tense.PRESENT
        verb.stemmer = work

        verb = Conjugate.conjugate(verb)

        assertTrue "WI-33a: expected ᏚᎸᏫᏍᏓᏁᎰᎢ (da + u fused), got: ${verb.wholeWord}",
                "ᏚᎸᏫᏍᏓᏁᎰᎢ" == verb.wholeWord
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
