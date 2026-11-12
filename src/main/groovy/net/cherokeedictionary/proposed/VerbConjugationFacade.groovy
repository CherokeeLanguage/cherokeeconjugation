package net.cherokeedictionary.proposed

import net.cherokeedictionary.core.Verb

class VerbConjugationFacade {
    private final List<ConjugationStep> pipelineSteps = [
        new StubInitialPrefixStep(),
        new StubRuleApplicationStep()
    ]

    Verb conjugate(ConjugationRequest request) {
        println "DEBUG: Starting conjugation for subject: ${request.subject}, object: ${request.object}, tense: ${request.verbTense}"
        def context = new ConjugationContext(request)
        context.buildBaseVerb()

        for (step in pipelineSteps) {
            println "DEBUG: Applying step: ${step.class.simpleName}"
            step.apply(context)
        }

        // F: expose the conjugated surface (StubRuleApplicationStep runs the
        // engine pipeline; wholeWord is the result).
        if (context.verb) {
            println "DEBUG: Conjugation successful. Result: ${context.verb.wholeWord}"
            context.verb.display = context.verb.wholeWord
        } else {
            println "DEBUG: Conjugation failed: context.verb is null."
        }

        return context.verb
    }

    ConjugationContext analyze(ConjugationRequest request) {
        println "DEBUG: Analyzing subject: ${request.subject}, object: ${request.object}, tense: ${request.verbTense}"
        def context = new ConjugationContext(request)
        context.buildBaseVerb()

        // Run steps in reverse for outside-in deconstruction intent
        for (step in pipelineSteps.reverse()) {
            println "DEBUG: Deconstructing step: ${step.class.simpleName}"
            step.deconstruct(context)
        }

        return context
    }
}
