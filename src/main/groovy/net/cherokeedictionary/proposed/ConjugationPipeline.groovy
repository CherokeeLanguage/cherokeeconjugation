package net.cherokeedictionary.proposed

import net.cherokeedictionary.verb.conjugation.Conjugate

class StubInitialPrefixStep implements ConjugationStep {
    @Override
    void apply(ConjugationContext context) {
        context.log("Applied initial prefixes (stubbed or delegated to existing engine)")
    }

    @Override
    void deconstruct(ConjugationContext context) {
        context.log("Deconstructed initial prefixes from outside in (stubbed)")
    }
}

class StubRuleApplicationStep implements ConjugationStep {
    @Override
    void apply(ConjugationContext context) {
        context.log("Applied core conjugation and morphological rules (delegated)")
        if (context.verb) {
            Conjugate.conjugate(context.verb)
        }
    }

    @Override
    void deconstruct(ConjugationContext context) {
        context.log("Deconstructed core morphological rules (stubbed)")
    }
}
