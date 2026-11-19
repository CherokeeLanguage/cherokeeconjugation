package net.cherokeedictionary.conjugation

import net.cherokeedictionary.core.Verb

/**
 * The primary one-in-one-out API: conjugate(ConjugationRequest) -> Verb.
 *
 * ERROR CONTRACT (user ruling 2026-11-18: "if composition fails then it
 * fails" -- no exceptions, matching 11 years of existing behavior):
 *   - Missing stems are NOT an error. ConjugationContext.buildBaseVerb maps
 *     only the non-null request stems, and the engine's Stemmer derives the
 *     missing tenses from the cited ones where possible (e.g. FUTURE_COMMAND
 *     from the remote row per the D1 convention).
 *   - When a required stem is genuinely absent and cannot be derived, the
 *     failure surfaces AS TEXT IN THE OUTPUT WORD -- "MISSING_ENTRY..." (see
 *     VerbConjugationProcessor) or transliteration residue like "not a valid
 *     letter" -- never an exception and never a null return. Callers that
 *     need to detect failure should check the returned surface for those
 *     markers (the vrb coverage gate does exactly this).
 * -- tio 18Nov26
 */
class VerbConjugationFacade {
    boolean isDebug = true;

    private final List<ConjugationStep> pipelineSteps = [
        new StubInitialPrefixStep(),
        new StubRuleApplicationStep()
    ]

    Verb conjugate(ConjugationRequest request) {
        if (isDebug) println "DEBUG: Starting conjugation for subject: ${request.subject}, object: ${request.object}, tense: ${request.verbTense}"
        // tio 18Nov26: lexeme-flag application (lexeme-flag generalization).
        // When the request names a lexeme (verbLexemes.json key), open a
        // per-conjugation VerbRegistry scope and apply that lexeme's flags --
        // the library-consumer path for glottalInitial / quvCoalescing /
        // impersonal / surfaceOverrides, identical to how VerbBaseSpec scopes
        // the test specs. A closed scope restores the pre-scope behavior for
        // every other caller. Unknown lexeme names are ignored silently here;
        // the meta-spec asserts data/spec agreement.
        if (request.lexeme) {
            return net.cherokeedictionary.verb.metadata.VerbRegistry.withVerbScope {
                net.cherokeedictionary.verb.metadata.VerbLexemeFlagLoader.apply(request.lexeme)
                conjugateInPipeline(request)
            }
        }
        return conjugateInPipeline(request)
    }

    private Verb conjugateInPipeline(ConjugationRequest request) {
        def context = new ConjugationContext(request)
        context.buildBaseVerb()

        for (step in pipelineSteps) {
            if (isDebug) println "DEBUG: Applying step: ${step.class.simpleName}"
            step.apply(context)
        }

        // F: expose the conjugated surface (StubRuleApplicationStep runs the
        // engine pipeline; wholeWord is the result).
        if (context.verb) {
            if (isDebug) println "DEBUG: Conjugation successful. Result: ${context.verb.wholeWord}"
            context.verb.display = context.verb.wholeWord
        } else {
            if (isDebug) println "DEBUG: Conjugation failed: context.verb is null."
        }

        return context.verb
    }

    ConjugationContext analyze(ConjugationRequest request) {
        if (isDebug) println "DEBUG: Analyzing subject: ${request.subject}, object: ${request.object}, tense: ${request.verbTense}"

        // tio 19Nov26: DECONSTRUCT PATH -- when the request carries a surface
        // form, run the outside-in Deconstructor (all analyses, ambiguity
        // kept) and skip the conjugation pipeline entirely; error contract
        // preserved (no exceptions, never empty). When no form is given the
        // legacy reverse-step behavior applies unchanged.
        if (request.form) {
            def context = new ConjugationContext(request)
            context.deconstructions = Deconstructor.deconstruct(request.form)
            context.log("Deconstructed form outside in: ${context.deconstructions.size()} analysis(es)")
            return context
        }

        def context = new ConjugationContext(request)
        context.buildBaseVerb()

        // Run steps in reverse for outside-in deconstruction intent
        for (step in pipelineSteps.reverse()) {
            if (isDebug) println "DEBUG: Deconstructing step: ${step.class.simpleName}"
            step.deconstruct(context)
        }

        return context
    }

    /**
     * Convenience overload (deconstruct backlog, 2026-11-19): deconstruct a
     * fully conjugated surface form straight from a string.
     * -- tio 19Nov26
     */
    ConjugationContext analyze(String form) {
        def request = new ConjugationRequest(form: form)
        return analyze(request)
    }
}
