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
 *   - SG3 subject only, with inanimate object (SG3IN): ᎤᏩᎨᏩᏍᎦ uwakewsga
 *     "he's forgetting it". The PL3 cells do NOT take this change: un- fuses
 *     the stem's v into the boundary as Ꮕ (nv) per the book's unv- convention
 *     (D16 -- ᏚᏅᏂᏢᎥᎢ dunvhnihlvvi, unvkewsvi).
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
        // tio 17Nov26: SG3 ONLY (D16). The changed-v environment is the sg3 uw-
        // allomorph: P4(6) "-w- is inserted between u- and a following vowel" —
        // uw- + v-stem needs the v->a to build ᎤᏩᎨᏩᏍᎦ uwakewsga. The PL3 un-
        // prefix has no such allomorph: the book composes un- + v-stem by fusing
        // the stem's v directly into the boundary as Ꮕ (nv = n + schwa) at every
        // Set B tense — VRB 2012 line 2299 `unvhnilv'i`, line 2431
        // `unvhnistanv'i`, guide `danvhniha` / `dunvhnihlvvi` (hit), VRB forget
        // PL3 row `unvkewsga` / `unvkewsvi` (UwakewsgaSpec fixture). Routing the
        // PL3 cells through v->a turned the boundary into the una- epenthesis
        // (ᏚᎾᏂᏢᎥᎢ) instead of the book's unv- (ᏚᏅᏂᏢᎥᎢ). PL3 keeps the stem
        // Ꭵ so Morphemes.fixPrefix fuses via the N map's Ꭵ->Ꮕ entry.
        // DISCREPANCIES.md D16 -- timo 17Nov26
        if (pts != PrefixTableSubject.SG3) {
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
