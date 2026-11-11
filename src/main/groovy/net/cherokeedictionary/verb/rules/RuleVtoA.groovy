package net.cherokeedictionary.verb.rules

import net.cherokeedictionary.util.PrefixTableObject
import net.cherokeedictionary.util.PrefixTableSubject
import net.cherokeedictionary.util.Tense
import net.cherokeedictionary.util.VerbSet

/**
 * B4: stem-initial -v- changes to -a- in third person Set B forms.
 *
 * Feeling 1975 grammar, "Notes on Paradigm Four" (p.273):
 *   "In verbs which take the Set B prefixes, stem initial -v changes to -a
 *    in third person forms; note the forms ᎪᏋᎨᏩᏍᎦ agwvkewsga 'I'm forgetting
 *    it' and ᎤᏩᎨᏩᏍᎦ uwakewsga 'he's forgetting it'."
 *
 * Scope (from the paradigm examples):
 *   - Set B prefixes only (1st/2nd person forms keep the -v-, agwv-kewsga),
 *   - third person subject (SG3/PL3),
 *   - inanimate object (SG3IN/PL3IN): ᎬᎨᏩᏍᎦ gv-kewsga "he's forgetting him"
 *     (3rd subject, AN object) keeps the stem -v-, as does ᏚᎨᏅᎨᏩᏍᎦ
 *     du-nv-kewsga "they're forgetting them (an)".
 *   - The surface effect is Ꭵ -> Ꭰ on the normalized stem, applied before the
 *     pronominal prefix is merged (P4(6): uw- + a-stem inserts -w-, so
 *     u- + Ꭰkewsga -> ᎤᏩᎨᏩᏍᎦ via the normal preVowel machinery).
 *
 * -- timo 10Nov26
 */
class RuleVtoA implements PrefixRule {

    /**
     * Static convenience used by VerbConjugationProcessor before the prefix
     * branches run: returns the (possibly rewritten) stem, or null when the
     * rule does not apply.
     */
    static String apply(PrefixTableSubject pts, PrefixTableObject pto, VerbSet verbSet, String verbStem) {
        if (verbSet != VerbSet.B) {
            return null
        }
        if (pts != PrefixTableSubject.SG3 && pts != PrefixTableSubject.PL3) {
            return null
        }
        if (pto != PrefixTableObject.SG3IN && pto != PrefixTableObject.PL3IN) {
            return null
        }
        if (!verbStem || !verbStem.startsWith("Ꭵ")) {
            return null
        }
        return "Ꭰ" + verbStem.substring(1)
    }

    @Override
    def process(final PrefixTableSubject pts,
                final PrefixTableObject pto,
                final String prefix,
                final Tense tense,
                final boolean isLiquid,
                final String verbStem,
                final VerbSet verbSet) {
        def rewritten = apply(pts, pto, verbSet, verbStem)
        return rewritten ? prefix + rewritten : null
    }
}
