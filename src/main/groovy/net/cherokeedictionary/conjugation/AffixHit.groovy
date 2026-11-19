package net.cherokeedictionary.conjugation

/**
 * One recognized affix slot in a {@link Deconstruction} analysis.
 *
 * @author tio -- tio 19Nov26
 */
class AffixHit {
    /** The surface text this hit consumed (syllabary glyphs for prefixes, latin for suffixes). */
    String surface
    /** Layer label: INITIAL_PREFIX, PRONOMINAL_PREFIX, STEM, NONFINAL_SUFFIX, FINAL_SUFFIX, UNPARSED. */
    String layer
    /** Every candidate reading for this affix -- ambiguity is kept, never pruned (user ruling 2026-11-19). */
    List<String> meanings = []
    /** Terse per-reading labels for the interlinear trans cells (e.g. "SG1SG3AN", "ji-"). -- tio 19Nov26 */
    List<String> glosses = []

    String toString() {
        if (!meanings) {
            return "${surface} [${layer}]"
        }
        return "${surface} [${layer}: ${meanings.join(' / ')}]"
    }
}
