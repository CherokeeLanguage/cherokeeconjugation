package net.cherokeedictionary.proposed

interface ConjugationStep {
    void apply(ConjugationContext context)
    void deconstruct(ConjugationContext context)
}
