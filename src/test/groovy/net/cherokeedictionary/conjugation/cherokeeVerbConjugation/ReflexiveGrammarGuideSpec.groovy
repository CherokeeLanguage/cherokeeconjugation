package net.cherokeedictionary.conjugation.cherokeeVerbConjugation

import net.cherokeedictionary.conjugation.VerbBaseSpec
import net.cherokeedictionary.core.Verb
import net.cherokeedictionary.stemmer.DefinitionLine
import net.cherokeedictionary.stemmer.Stemmer
import net.cherokeedictionary.verb.conjugation.Conjugate
import spock.lang.Ignore
import spock.lang.Unroll

/**
 * Grammar-guide reference spec: the Cherokee reflexive prefix -adad- / -ad- / ada-
 * (grammar guide hold1, Section I-E, pp. 296-300).
 *
 * Allomorphy (p. 296):
 *   -adad- before a stem beginning with a vowel other than -a-
 *   -ad-   before a stem beginning with -a- (the stem -a- deletes)
 *   ada-   before a stem beginning with a consonant
 *   The initial -a- of -adad- drops after the Set B third-person prefix u-.
 *
 * Covered here:
 *   Examples (1)-(4)  -- the three allomorphs plus the u- Set B form.
 *   Paradigms P1-P6    -- "to see oneself", "to hit oneself",
 *                         "to forget oneself" (present and past).
 *   Examples (5)-(9), (11), (12), (19), (20) -- reciprocal and non-reflexive
 *                         uses (asserted on the verb form the engine composes;
 *                         see the notes on the interrogative particle below).
 *   Examples (10) and (13) -- UNGRAMMATICAL per the guide. They are recorded
 *                         below as @Ignore features and are deliberately NOT
 *                         asserted. Reason: ungrammatical per grammar guide;
 *                         intentionally not asserted.
 *   Examples (14)-(18) -- sentence-level or agentive-noun constructions,
 *                         outside the conjugation engine's scope; recorded as
 *                         annotated, @Ignore documentation only.
 *
 * Printed-form variances are annotated at the affected rows rather than
 * "corrected" in the engine (the guide's own romanization agrees with the
 * engine in each case).
 *
 * Verb fixtures and their citation (SG3 present) forms:
 *   to see     ᎠᎪᏩᏘᎭ   (gowatiha)
 *   to hit     ᎬᏂᎭ     (gvhnixa)
 *   to tie up  ᎦᏢᎢᎭ    (tieUp)
 *   to forget  ᎤᏩᎨᏫᏍᎦ (uwanegesga)
 */
@Unroll
class ReflexiveGrammarGuideSpec extends VerbBaseSpec {

    // ── fixtures ────────────────────────────────────────────────────────────
    // SG3 citation + the principal parts the engine routes each tense through.
    static final Stemmer SEE = new Stemmer()
    static final Stemmer HIT = new Stemmer()
    static final Stemmer TIE = new Stemmer()
    static final Stemmer FORGET = new Stemmer()

    static {
        SEE.habitual = new DefinitionLine(syllabary: "ᎠᎪᏩᏘᏍᎪᎢ")
        SEE.imperative = new DefinitionLine(syllabary: "ᎯᎪᏩᏔ")
        SEE.infinitive = new DefinitionLine(syllabary: "ᎤᎪᏩᏛᏗ")
        SEE.present1st = new DefinitionLine(syllabary: "ᏥᎪᏩᏘᎭ")
        SEE.present3rd = new DefinitionLine(syllabary: "ᎠᎪᏩᏘᎭ")
        SEE.remotepast = new DefinitionLine(syllabary: "ᎤᎪᎲᎢ")

        HIT.habitual = new DefinitionLine(syllabary: "ᎬᏂᎰᎢ")
        HIT.imperative = new DefinitionLine(syllabary: "ᎯᏴᏂᎦ")
        HIT.infinitive = new DefinitionLine(syllabary: "ᎤᏩᏂᏍᏗ")
        HIT.present1st = new DefinitionLine(syllabary: "ᏥᏴᏂᎭ")
        HIT.present3rd = new DefinitionLine(syllabary: "ᎬᏂᎭ")
        HIT.remotepast = new DefinitionLine(syllabary: "ᎤᏩᏂᎸᎢ")

        TIE.habitual = new DefinitionLine(syllabary: "ᎦᏢᎢᎰᎢ")
        TIE.imperative = new DefinitionLine(syllabary: "ᎯᏢᎢᎦ")
        TIE.infinitive = new DefinitionLine(syllabary: "ᎤᏢᎢᏗ")
        TIE.present1st = new DefinitionLine(syllabary: "ᏥᏢᎢᎭ")
        TIE.present3rd = new DefinitionLine(syllabary: "ᎦᏢᎢᎭ")
        TIE.remotepast = new DefinitionLine(syllabary: "ᎤᏢᎢᎸᎢ")

        FORGET.habitual = new DefinitionLine(syllabary: "ᎤᏩᎨᏫᏍᎪᎢ")
        FORGET.imperative = new DefinitionLine(syllabary: "ᏫᎤᏩᎨᏩ")
        FORGET.infinitive = new DefinitionLine(syllabary: "ᎤᏩᎨᏫᏍᏗ")
        FORGET.present1st = new DefinitionLine(syllabary: "ᎠᏆᎨᏫᏍᎦ")
        FORGET.present3rd = new DefinitionLine(syllabary: "ᎤᏩᎨᏫᏍᎦ")
        FORGET.remotepast = new DefinitionLine(syllabary: "ᎤᏩᎨᏫᏒᎢ")
    }

    /**
     * Compose one cell through the standard reflexive path.
     *
     * The reflexive consumes the object slot (the guide's reflexive paradigms
     * are grammatically "self" object), so the request object is SG3AN and the
     * reflexive flag is on. {@code de} drives the reciprocal de- prefix for
     * examples (5)-(6).
     */
    static String compose(String subject, Stemmer stemmer, String tense,
                          boolean reflexive = true, boolean de = false) {
        // The reflexive consumes the object slot; the non-reflexive examples
        // are the bare verb forms (no object prefix), so use NONE there.
        String object = reflexive ? "SG3AN" : "NONE"
        Verb verb = Conjugate.createVerbToConjugate(
                subject, object, stemmer, tense, "v.t.", reflexive)
        if (de) {
            verb.initialPrefixHolder.de = true
        }
        return Conjugate.conjugate(verb).wholeWord
    }

    // ── Examples (1)-(4): the allomorphs ────────────────────────────────────

    @Unroll
    def "allomorphy example #example: #translation"() {
        expect:
        compose(subject, stemmer, tense, reflexive) == expected

        where:
        example | subject | stemmer | tense        | reflexive | expected       || translation
        "(1a)"  | "SG3"   | HIT     | "PRESENT"    | false     | "ᎬᏂᎭ"          || "He's hitting it."
        "(1b)"  | "SG3"   | HIT     | "PRESENT"    | true      | "ᎠᏓᏛᏂᎭ"       || "He's hitting himself."
        "(2a)"  | "SG3"   | TIE     | "PRESENT"    | false     | "ᎦᏢᎢᎭ"        || "He's tying it up."
        "(2b)"  | "SG3"   | TIE     | "PRESENT"    | true      | "ᎠᏓᏢᎢᎭ"       || "He's tying himself up."
        "(3a)"  | "SG3"   | SEE     | "PRESENT"    | false     | "ᎠᎪᏩᏘᎭ"       || "He sees it."
        "(3b)"  | "SG3"   | SEE     | "PRESENT"    | true      | "ᎠᏓᎪᏩᏘᎭ"      || "He sees himself."
        "(4a)"  | "SG3"   | HIT     | "REMOTE_PAST"| false     | "ᎤᏩᏂᎸᎢ"       || "He hit it."
        "(4b)"  | "SG3"   | HIT     | "REMOTE_PAST"| true      | "ᎤᏓᏛᏂᎸᎢ"      || "He hit himself."
    }

    // ── Paradigm One: "to see oneself" (present) ────────────────────────────

    @Unroll
    def "P1 see oneself present #subject = #expected"() {
        expect:
        compose(subject, SEE, "PRESENT") == expected

        where:
        subject  | expected
        "SG1"    | "ᎦᏓᎪᏩᏘᎭ"
        "SG2"    | "ᎭᏓᎪᏩᏘᎭ"
        "SG3"    | "ᎠᏓᎪᏩᏘᎭ"
        "DL1INCL"| "ᎢᎾᏓᎪᏩᏘᎭ"
        "PL1INCL"| "ᎢᏓᏓᎪᏩᏘᎭ"
        "DL1EXCL"| "ᎣᏍᏓᏓᎪᏩᏘᎭ"
        "PL1EXCL"| "ᎣᏣᏓᎪᏩᏘᎭ"
        "DL2"    | "ᏍᏓᏓᎪᏩᏘᎭ"
        "PL2"    | "ᎢᏣᏓᎪᏩᏘᎭ"
        "PL3"    | "ᎠᎾᏓᎪᏩᏘᎭ"
    }

    // ── Paradigm Two: "to see oneself" (past) ───────────────────────────────

    /**
     * Guide glyph variance at DL1INCL: the guide prints ᎦᎾᏓᎪᎲᎢ, but its own
     * romanization is gị²nạ²da²go²hv²³ʔi (gị = Ꭹ), and the engine composes
     * ᎩᎾᏓᎪᎲᎢ. Accepted as a guide typo; the engine form is asserted.
     */
    @Unroll
    def "P2 see oneself remote past #subject = #expected"() {
        expect:
        compose(subject, SEE, "REMOTE_PAST") == expected

        where:
        subject  | expected
        "SG1"    | "ᎠᏆᏓᎪᎲᎢ"
        "SG2"    | "ᏣᏓᎪᎲᎢ"
        "SG3"    | "ᎤᏓᎪᎲᎢ"
        "DL1INCL"| "ᎩᎾᏓᎪᎲᎢ"
        "PL1INCL"| "ᎢᎦᏓᎪᎲᎢ"
        "DL1EXCL"| "ᎣᎩᎾᏓᎪᎲᎢ"
        "PL1EXCL"| "ᎣᎦᏓᎪᎲᎢ"
        "DL2"    | "ᏍᏓᏓᎪᎲᎢ"
        "PL2"    | "ᎢᏣᏓᎪᎲᎢ"
        "PL3"    | "ᎤᎾᏓᎪᎲᎢ"
    }

    // ── Paradigm Three: "to hit oneself" (present) ──────────────────────────

    @Unroll
    def "P3 hit oneself present #subject = #expected"() {
        expect:
        compose(subject, HIT, "PRESENT") == expected

        where:
        subject  | expected
        "SG1"    | "ᎦᏓᏛᏂᎭ"
        "SG2"    | "ᎭᏓᏛᏂᎭ"
        "SG3"    | "ᎠᏓᏛᏂᎭ"
        "DL1INCL"| "ᎢᎾᏓᏛᏂᎭ"
        "PL1INCL"| "ᎢᏓᏓᏛᏂᎭ"
        "DL1EXCL"| "ᎣᏍᏓᏓᏛᏂᎭ"
        "PL1EXCL"| "ᎣᏣᏓᏛᏂᎭ"
        "DL2"    | "ᏍᏓᏓᏛᏂᎭ"
        "PL2"    | "ᎢᏣᏓᏛᏂᎭ"
        "PL3"    | "ᎠᎾᏓᏛᏂᎭ"
    }

    // ── Paradigm Four: "to hit oneself" (past) ──────────────────────────────

    /**
     * Same DL1INCL guide glyph variance as P2: guide prints ᎦᎾᏓᏛᏂᎸᎢ,
     * romanization is gị²nạ²da²dv²hnị³lv³ʔi, engine composes ᎩᎾᏓᏛᏂᎸᎢ.
     */
    @Unroll
    def "P4 hit oneself remote past #subject = #expected"() {
        expect:
        compose(subject, HIT, "REMOTE_PAST") == expected

        where:
        subject  | expected
        "SG1"    | "ᎠᏆᏓᏛᏂᎸᎢ"
        "SG2"    | "ᏣᏓᏛᏂᎸᎢ"
        "SG3"    | "ᎤᏓᏛᏂᎸᎢ"
        "DL1INCL"| "ᎩᎾᏓᏛᏂᎸᎢ"
        "PL1INCL"| "ᎢᎦᏓᏛᏂᎸᎢ"
        "DL1EXCL"| "ᎣᎩᎾᏓᏛᏂᎸᎢ"
        "PL1EXCL"| "ᎣᎦᏓᏛᏂᎸᎢ"
        "DL2"    | "ᏍᏓᏓᏛᏂᎸᎢ"
        "PL2"    | "ᎢᏣᏓᏛᏂᎸᎢ"
        "PL3"    | "ᎤᎾᏓᏛᏂᎸᎢ"
    }

    // ── Paradigm Five: "to forget oneself" (present) ────────────────────────

    /**
     * Guide lists eight persons here (no DL1EXCL / PL1EXCL).
     *
     * Guide glyph variance at DL1INCL: the guide prints ᎢᎾᏗᏛᎨᏫᏍᎦ, but its
     * romanization is i¹nạ²da²dv²kew²sga, and the engine composes
     * ᎢᎾᏓᏛᎨᏫᏍᎦ. Accepted as a guide typo; the engine form is asserted.
     *
     * "Forget" otherwise takes Set B prefixes; with the reflexive it follows
     * the Set A present pattern (guide p. 297-298).
     */
    @Unroll
    def "P5 forget oneself present #subject = #expected"() {
        expect:
        compose(subject, FORGET, "PRESENT") == expected

        where:
        subject  | expected
        "SG1"    | "ᎦᏓᏛᎨᏫᏍᎦ"
        "SG2"    | "ᎭᏓᏛᎨᏫᏍᎦ"
        "SG3"    | "ᎠᏓᏛᎨᏫᏍᎦ"
        "DL1INCL"| "ᎢᎾᏓᏛᎨᏫᏍᎦ"
        "PL1INCL"| "ᎢᏓᏓᏛᎨᏫᏍᎦ"
        "DL2"    | "ᏍᏓᏓᏛᎨᏫᏍᎦ"
        "PL2"    | "ᎢᏣᏓᏛᎨᏫᏍᎦ"
        "PL3"    | "ᎠᎾᏓᏛᎨᏫᏍᎦ"
    }

    // ── Paradigm Six: "to forget oneself" (past) ────────────────────────────

    /**
     * Guide lists eight persons here (no DL1EXCL / PL1EXCL).
     *
     * Guide typo at PL3: the guide prints ᎤᎾᏓᏛᎨᏒᎢ (missing Ꮻ), but its own
     * romanization is u¹nạ²da²dv²kew²sv²³ʔi, and the engine composes
     * ᎤᎾᏓᏛᎨᏫᏒᎢ. Accepted as a guide typo; the engine form is asserted.
     */
    @Unroll
    def "P6 forget oneself remote past #subject = #expected"() {
        expect:
        compose(subject, FORGET, "REMOTE_PAST") == expected

        where:
        subject  | expected
        "SG1"    | "ᎠᏆᏓᏛᎨᏫᏒᎢ"
        "SG2"    | "ᏣᏓᏛᎨᏫᏒᎢ"
        "SG3"    | "ᎤᏓᏛᎨᏫᏒᎢ"
        "DL1INCL"| "ᎩᎾᏓᏛᎨᏫᏒᎢ"
        "PL1INCL"| "ᎢᎦᏓᏛᎨᏫᏒᎢ"
        "DL2"    | "ᏍᏓᏓᏛᎨᏫᏒᎢ"
        "PL2"    | "ᎢᏣᏓᏛᎨᏫᏒᎢ"
        "PL3"    | "ᎤᎾᏓᏛᎨᏫᏒᎢ"
    }

    // ── The reciprocal: de- + -adad- ────────────────────────────────────────

    @Unroll
    def "reciprocal example #example: #translation"() {
        expect:
        compose(subject, stemmer, "PRESENT", true, de) == expected

        where:
        example | subject | stemmer | de    | expected        || translation
        "(5)"   | "PL3"   | HIT     | true  | "ᏓᎾᏓᏛᏂᎭ"     || "They are hitting each other."
        "(6)"   | "PL3"   | TIE     | true  | "ᏓᎾᏓᏢᎢᎭ"    || "They are tying each other up / themselves up."
        "(7)"   | "PL3"   | TIE     | false | "ᎠᎾᏓᏢᎢᎭ"    || "They are tying themselves (a single act)."
    }

    // ── Non-reflexive uses of -adad- ─────────────────────────────────────────

    /**
     * Examples (8), (9), (11): with no overt direct object, the reflexive
     * -adad- may be present or absent when an animate object is covertly
     * understood. The guide distinguishes the readings, but the surface forms
     * are exactly these.
     *
     * Example (12): non-reflexive habitual "Do you (habitually) see him?".
     * The engine composes the habitual verb form ᎯᎪᏩᏘᏍᎪᎢ; the guide's
     * sentence adds the interrogative particle -s? (Ꮝ?), which is a
     * sentence-level clitic and is not modelled by the conjugation engine.
     *
     * Examples (19) and (20): the guide marks these with the same
     * interrogative particle -s? (Ꮝ?). The engine assertions cover the verb
     * forms without that clitic: (19) ᎠᏓᎪᏩᏘᎭ (reflexive/non-reflexive) and
     * (20) ᎠᎪᏩᏘᎭ (non-reflexive).
     */
    @Unroll
    def "non-reflexive use #example: #translation"() {
        expect:
        compose(subject, SEE, tense, reflexive) == expected

        where:
        example | subject | tense     | reflexive | expected      || translation
        "(8)"   | "SG3"   | "PRESENT" | false     | "ᎠᎪᏩᏘᎭ"     || "He sees a man. (with overt object)"
        "(9)"   | "SG3"   | "PRESENT" | true      | "ᎠᏓᎪᏩᏘᎭ"    || "He sees (him)."
        "(11)"  | "SG3"   | "PRESENT" | false     | "ᎠᎪᏩᏘᎭ"     || "He sees him, it."
        "(12)"  | "SG2"   | "HABITUAL"| false     | "ᎯᎪᏩᏘᏍᎪᎢ"   || "Do you (habitually) see him? (-s? clitic omitted)"
        "(19)"  | "SG3"   | "PRESENT" | true      | "ᎠᏓᎪᏩᏘᎭ"    || "Does he see (him)? (-s? clitic omitted)"
        "(20)"  | "SG3"   | "PRESENT" | false     | "ᎠᎪᏩᏘᎭ"     || "Does he see him? (-s? clitic omitted)"
    }

    // ── Ungrammatical guide examples: annotated, NOT tested ─────────────────

    /**
     * (10) *ᎠᏎᎦᏯ ᎠᏓᎪᏩᏘᎭ "He sees a man."
     *
     * The guide marks (10) with an asterisk: with an overtly expressed direct
     * object, the non-reflexive -adad- is impossible -- the form is read as
     * "the man sees," not "he sees a man." Ungrammatical per grammar guide;
     * intentionally not asserted.
     */
    @Ignore("ungrammatical per grammar guide; intentionally not asserted")
    def "(10) overt object with non-reflexive -adad- is ungrammatical"() {
        expect:
        // Deliberately no assertion: (10) is recorded for traceability only.
        true
    }

    /**
     * (13) *ᎭᏓᎪᏩᏘᏍᎪᎢᏍ? "Do you (habitually) see him?"
     *
     * The guide marks (13) as ungrammatical: non-reflexive -adad- may not
     * occur with the habitual suffix. Ungrammatical per grammar guide;
     * intentionally not asserted.
     */
    @Ignore("ungrammatical per grammar guide; intentionally not asserted")
    def "(13) non-reflexive -adad- with habitual suffix is ungrammatical"() {
        expect:
        // Deliberately no assertion: (13) is recorded for traceability only.
        true
    }

    // ── Sentence-level / agentive uses: documented-only, out of engine scope ─

    /**
     * The remaining examples in the section are not verb-conjugation cells:
     *
     *   (14) Ali ᎤᏍᏉᏟ ᎬᏂᎦ Foreman. "Foreman just hit Ali in the stomach."
     *        (a full immediate-past sentence)
     *   (15) AliᏛ ᎥᎠᏓᏛᏂᎦ. "And Ali just hit back." (immediate past with the
     *        v- "back" prefix)
     *   (16) ᎠᏓᎯᎯ "killer" (inanimate agentive noun)
     *   (17) ᏗᏓᎯᎯ "killer" (animate agentive noun, de- > di-)
     *   (18) ᎩᏓ ᏗᎯᎯ "dog killer" (noun phrase with a specified object)
     *
     * These are recorded for completeness. They exercise sentence syntax,
     * the v- "back" prefix, and agentive derivation rather than the reflexive
     * conjugation paradigms, so they are annotated here but not asserted.
     */
    @Ignore("sentence-level / agentive derivations outside the conjugation engine scope")
    def "(14)-(18) immediate-past sentences and agentive nouns are documented-only"() {
        expect:
        true
    }
}
