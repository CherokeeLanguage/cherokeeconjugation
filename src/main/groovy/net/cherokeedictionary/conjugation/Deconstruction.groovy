package net.cherokeedictionary.conjugation

import net.cherokeedictionary.transliteration.SyllabaryUtil

/**
 * One consistent outside-in breakdown of a conjugated Cherokee verb surface
 * form. A single input form can produce MULTIPLE analyses (an affix surface
 * such as j- has several candidate pronominal readings); ambiguity is kept,
 * never pruned (user ruling 2026-11-19).
 *
 * Layers in {@link #affixes} run outside-in: INITIAL_PREFIX (0..2 hits),
 * PRONOMINAL_PREFIX (0..1 hit), NONFINAL_SUFFIX (0..1), FINAL_SUFFIX (0..1).
 * The untouched middle remainder is {@link #stemHypothesis} -- unverifiable
 * without lexicon data in v1 and annotated as such.
 *
 * @author tio -- tio 19Nov26
 */
class Deconstruction {
    /** The normalized surface form this analysis was produced from. */
    String inputSurface
    /** Ordered affix hits, outside-in. */
    List<AffixHit> affixes = []
    /** The residual middle segment labeled as the stem slot. */
    String stemHypothesis
    /**
     * Root-ending consonant carried at the latin level (2026-11-19): when a
     * peel leaves a trailing lone h/w/y/n that has no glyph of its own (the
     * h fused into the next glyph, e.g. Ꭽ = "h"+"a"), it is parked here so
     * the Root Ending cell still renders. -- tio 19Nov26
     */
    String rootEndingLatin
    /** False when no consistent segmentation was found (error contract: never an exception). */
    boolean parsed = false

    /** Cherokee root-ending consonants the engine's stems carry (h/w/y/n family). -- tio 19Nov26 */
    private static final Set<String> ROOT_ENDING_CONSONANTS = ['h', 'w', 'y', 'n'] as Set

    /**
     * Interlinear rendering, e.g.
     * "Ꮿ- [INITIAL_PREFIX: negative 'not'] | Ꮵ- [PRONOMINAL: I -> Him/her] |
     *  stem: ᎠᏂ | -Ꭽ [FINAL_SUFFIX: present]"
     */
    String toString() {
        def parts = []
        affixes.each { parts << it.toString() }
        if (stemHypothesis) {
            parts << "stem: ${stemHypothesis}"
        }
        if (!parsed && !affixes.any { it.layer == 'UNPARSED' }) {
            parts << "[UNPARSED]"
        }
        return parts.join(' | ')
    }

    /**
     * HTML interlinear rendering in the user's format (2026-11-19): nested
     * div.interlinear > div.orig (the syllabary form) + div.intlin (roman),
     * left-floated div.intlin segments each carrying div.orig, div.morph
     * (roman), div.trans (terse gloss), closing with div.freetrans.
     *
     * Morpheme boundaries are aligned at the LATIN level against the input
     * form's glyph->latin syllable map, so a boundary that falls INSIDE a
     * glyph (e.g. root-ending h + tense a fused in Ꭽ "ha") renders as two
     * segments sharing the glyph -- exactly the user's example
     * (ᎪᏩᏘ/gowati + h/h/Root Ending + Ꭽ/a/tense tail). When the segment
     * latin cannot reconstruct the form's romanization (residue etc.) the
     * renderer falls back to glyph-boundary segments.
     * -- tio 19Nov26
     */
    String toHtml() {
        // Ordered [label, latinText] segments, outside-in.
        def segs = []
        affixes.findAll { it.layer == 'INITIAL_PREFIX' || it.layer == 'PRONOMINAL_PREFIX' }.each { hit ->
            segs << [transOf(hit), latinOf(hit)]
        }
        if (stemHypothesis) {
            String stemLatin = SyllabaryUtil.parseSyllabary(stemHypothesis) ?: stemHypothesis
            if (stemLatin.size() > 1 && stemLatin[-1] in ROOT_ENDING_CONSONANTS) {
                segs << ['Root', stemLatin[0..<-1]]
                segs << ['Root Ending', stemLatin[-1]]
            } else {
                segs << ['Root', stemLatin]
                if (rootEndingLatin) {
                    segs << ['Root Ending', rootEndingLatin]
                }
            }
        }
        affixes.findAll { it.layer == 'NONFINAL_SUFFIX' || it.layer == 'FINAL_SUFFIX' }.each { hit ->
            segs << [transOf(hit), latinOf(hit)]
        }
        if (!segs) {
            segs << [parsed ? 'Root' : 'UNPARSED',
                     SyllabaryUtil.parseSyllabary(inputSurface) ?: inputSurface]
        }

        def pairs = glyphLatinPairs(inputSurface)
        String total = pairs.collect { it[1] }.join()
        String segLatin = segs.collect { it[1] }.join()

        def sb = new StringBuilder()
        sb << '<div class="interlinear">'
        sb << '<div class="orig">' << inputSurface << '</div>'
        sb << '<div class="intlin">'
        sb << '    <div class="orig">' << romanOf(inputSurface) << '</div>'
        if (total == segLatin) {
            alignedSegments(sb, pairs, segs)
        } else {
            // Fallback: no clean alignment -- render each segment's latin
            // with the glyphs it came from where available.
            segs.each { label, text -> sb << blockHtml('', text, label) }
        }
        sb << '</div>'
        sb << '<div class="freetrans"></div>'
        sb << '</div>'
        return sb.toString()
    }

    /** Walk the glyph->latin pairs, slicing segments at latin boundaries. -- tio 19Nov26 */
    private static void alignedSegments(StringBuilder sb, List pairs, List segs) {
        int gi = 0
        int li = 0
        segs.each { label, String text ->
            String orig = ''
            String morph = ''
            while (text.size() > 0 && gi < pairs.size()) {
                String g = pairs[gi][0]
                String v = pairs[gi][1]
                int take = Math.min(v.size() - li, text.size())
                morph += text.substring(0, take)
                text = text.substring(take)
                li += take
                if (li == v.size()) {
                    orig += g
                    gi++
                    li = 0
                }
            }
            // A segment that starts (and stays) mid-glyph shows its latin
            // fragment as orig (user's "h" Root-Ending cell); the completing
            // segment shows the glyph.
            if (!orig) { orig = morph }
            sb << blockHtml(orig, morph, label)
        }
    }

    /** Per-glyph latin values for the form (latin chars pass through). -- tio 19Nov26 */
    private static List glyphLatinPairs(String form) {
        def pairs = []
        form.each { ch ->
            String v = SyllabaryUtil.syllabaryMap[ch]
            pairs << [ch, v != null ? v : ch]
        }
        return pairs
    }

    /** Terse trans-cell label: glosses when present, meanings otherwise. -- tio 19Nov26 */
    private static String transOf(AffixHit hit) {
        return hit.glosses ? hit.glosses.join('<br>') :
                (hit.meanings ? hit.meanings.join('<br>') : hit.layer)
    }

    /** Latin text of one affix hit's surface (final hits carry "-x"). -- tio 19Nov26 */
    private static String latinOf(AffixHit hit) {
        return SyllabaryUtil.parseSyllabary(hit.surface.replaceAll('^-', '')) ?:
                hit.surface.replaceAll('^-', '')
    }

    private static String blockHtml(String orig, String morph, String label) {
        def sb = new StringBuilder()
        sb << '<div class="intlin" style="float:left">'
        sb << '<div class="orig">' << orig << '</div>'
        sb << '<div class="morph">' << morph << '</div>'
        sb << '<div class="trans">' << label << '</div>'
        sb << '</div>'
        return sb.toString()
    }

    /** Roman reading of a glyph string; latin input passes through. -- tio 19Nov26 */
    private static String romanOf(String glyphs) {
        if (!glyphs) { return '' }
        String stripped = glyphs.replaceAll('[-|]', '')
        if (!net.cherokeedictionary.conjugation.VerbInputNormalizer.hasGlyph(stripped)) {
            return stripped
        }
        String roman = SyllabaryUtil.parseSyllabary(stripped)
        return roman ?: stripped
    }
}

