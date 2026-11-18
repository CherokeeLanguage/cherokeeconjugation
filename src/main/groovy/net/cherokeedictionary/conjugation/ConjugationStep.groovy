package net.cherokeedictionary.conjugation

interface ConjugationStep {
    void apply(ConjugationContext context)
    void deconstruct(ConjugationContext context)
}
