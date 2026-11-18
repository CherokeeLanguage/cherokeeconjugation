package net.cherokeedictionary.proposed

import net.cherokeedictionary.core.Verb

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
        def context = new ConjugationContext(request)
        context.buildBaseVerb()

        // Run steps in reverse for outside-in deconstruction intent
        for (step in pipelineSteps.reverse()) {
            if (isDebug) println "DEBUG: Deconstructing step: ${step.class.simpleName}"
            step.deconstruct(context)
        }

        return context
    }
}
