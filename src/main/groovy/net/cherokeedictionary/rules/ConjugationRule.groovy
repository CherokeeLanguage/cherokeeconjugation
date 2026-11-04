package net.cherokeedictionary.verb.rules

import net.cherokeedictionary.core.Verb

/**
 * Interface for conjugation rules. 
 * Implementations process a Verb object in a specific step of the conjugation pipeline.
 */
interface ConjugationRule {
    /**
     * Processes the verb, potentially modifying its properties or its wholeWord state.
     * @param verb The verb object being conjugated
     * @return The updated verb object
     */
//    Verb apply(Verb verb)
}
