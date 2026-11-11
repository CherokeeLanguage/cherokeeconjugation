package net.cherokeedictionary.proposed

import net.cherokeedictionary.core.Verb

class VerbConjugationFacade {
    private final List<ConjugationStep> pipelineSteps = [
        new StubInitialPrefixStep(),
        new StubRuleApplicationStep()
    ]

    Verb conjugate(ConjugationRequest request) {
        def context = new ConjugationContext(request)
        context.buildBaseVerb()

        for (step in pipelineSteps) {
            step.apply(context)
        }

        // F: expose the conjugated surface (StubRuleApplicationStep runs the
        // engine pipeline; wholeWord is the result).
        if (context.verb) {
            context.verb.display = context.verb.wholeWord
        }

        return context.verb
    }

    ConjugationContext analyze(ConjugationRequest request) {
        def context = new ConjugationContext(request)
        context.buildBaseVerb()

        // Run steps in reverse for outside-in deconstruction intent
        for (step in pipelineSteps.reverse()) {
            step.deconstruct(context)
        }

        return context
    }
}
