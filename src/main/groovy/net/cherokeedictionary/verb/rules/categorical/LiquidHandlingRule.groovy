package net.cherokeedictionary.verb.rules.categorical

import net.cherokeedictionary.core.Verb
import net.cherokeedictionary.util.Tense

/**
 * Categorical rule for liquid handling verbs.
 *
 * tio 12Nov26: audit verdict (CATEGORY_AUDIT.md) — Cherokee classificatory
 * verbs are parallel ROOT SETS by object class (liquid/flexible/long/alive),
 * not morphological transforms; conjugation is identical across class members.
 * Stays a no-op until an attested liquid-specific morphology surfaces.
 * -- tio 11Nov26, verdict 12Nov26
 */
class LiquidHandlingRule implements CategoricalRule {
    @Override
    String apply(Verb verb, String currentConjugation, Tense tense) {
        // No-op by audit design; see CATEGORY_AUDIT.md "LIQUID_HANDLING".
        return currentConjugation
    }
}
