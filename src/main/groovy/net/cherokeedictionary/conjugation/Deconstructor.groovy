package net.cherokeedictionary.conjugation

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.CompoundPrefixes
import net.cherokeedictionary.verb.containers.FinalSuffixProcessor

/**
 * Outside-in interlinear breakdown of a conjugated verb surface form
 * (deconstruct backlog item, planned 2026-11-19).
 *
 * v1 is a pure morphological PEEL, not lexeme-guided and not
 * reconstruct-by-conjugation: the input is sliced from the outside in
 * (final suffix -> non-final suffix -> initial prefixes -> pronominal
 * prefix) and every consistent segmentation is returned. Each affix hit
 * carries ALL of its candidate readings (e.g. the j- surfaces annotate
 * every pronominal meaning that shares the glyph); the untouched middle
 * remainder is labeled as the stem hypothesis.
 *
 * Hypothesis lists are pulled from the REAL tables so the two never drift:
 * final endings from {@link FinalSuffixProcessor#lstEndings}, pronominal
 * surfaces from {@link CompoundPrefixes#prefixes}, initial prefixes from the
 * request flag set (yi/ji/wi/ni/de/da/di/i/ga/e).
 *
 * ERROR CONTRACT (matches the facade ruling 2026-11-18): no exceptions,
 * never a null/empty return -- an unparseable form yields a single analysis
 * whose UNPARSED hit annotates the failure. Roman input converts through
 * the VerbInputNormalizer gate; glottal apostrophes are dropped there
 * (the no-yaml-junk ruling) before any failure is declared.
 *
 * v1-approximate: the non-final suffix candidates and the final-suffix
 * meaning labels are documented in DISCREPANCIES.md (deconstruct D-notes).
 * -- tio 19Nov26
 */
class Deconstructor {

    /** Hard cap so pathological inputs cannot explode the enumeration. -- tio 19Nov26 */
    static final int MAX_ANALYSES = 128
    /** Initial-prefix peel depth cap (0, 1 or 2 stacked initial prefixes). -- tio 19Nov26 */
    static final int MAX_INITIAL_DEPTH = 2

    private static final String L_INITIAL = 'INITIAL_PREFIX'
    private static final String L_PRONOMINAL = 'PRONOMINAL_PREFIX'
    private static final String L_STEM = 'STEM'
    private static final String L_NONFINAL = 'NONFINAL_SUFFIX'
    private static final String L_FINAL = 'FINAL_SUFFIX'
    private static final String L_UNPARSED = 'UNPARSED'

    /**
     * Initial (prepronominal) prefix surface candidates: name -> [surface
     * glyphs]. Surfaces are the head glyphs the affix classes actually
     * prepend (PrefixDa/PrefixDe/PrefixYi et al.); allomorphy is annotated
     * in the meaning text. -- tio 19Nov26
     */
    static final Map<String, List<String>> INITIAL_PREFIX_SURFACES = [
        'yi': ['Ꮿ', 'Ᏸ', 'Ᏹ', 'Ᏺ', 'Ᏻ', 'Ᏼ'],
        'ji': ['Ꮵ', 'Ꮸ'],
        'wi': ['Ꮻ', 'Ꮼ', 'Ꮺ', 'Ꮽ', 'Ꮾ'],
        'ni': ['Ꮒ', 'Ꮓ', 'Ꮔ'],
        'de': ['Ꮧ', 'Ꮩ', 'Ꮪ', 'Ꮷ', 'Ꮸ'],
        'da': ['Ꮣ', 'Ꮨ', 'Ꮫ', 'Ꮩ'],
        'di': ['Ꮧ', 'Ꮣ', 'Ꮵ'],
        'i' : ['Ꭲ'],
        'ga': ['Ꭶ'],
        'e' : ['Ꭱ', 'Ꭷ'],
    ].asImmutable()

    /**
     * Candidate readings per initial prefix (Feeling Dictionary grammar
     * pages / the affix classes' own rule comments). -- tio 19Nov26
     */
    static final Map<String, String> INITIAL_PREFIX_MEANINGS = [
        'yi': "negative 'not' / nominalizer (yi-, yu- variant)",
        'ji': "'just, still' (ji-)",
        'wi': "'around, in the direction of' (wi-)",
        'ni': "'one who is / circumstantial' (ni-)",
        'de': "pluralizer (de-, di-/do/j- allomorphy per Feeling Dictionary)",
        'da': "distributive/multiple (da-; t- before h- stems, dv before vowels -- guide pp.247-248)",
        'di': "instrumental 'by means of' (di-)",
        'i' : "nominalizer 'that which' (i-)",
        'ga': "'since' (ga-, Feeling pp.255-256)",
        'e' : "e- (guide prefix, allomorphic)",
    ].asImmutable()

    /**
     * Non-final suffix candidates (Feeling 1975 p.282 Figure 1 order) --
     * v1 best-effort surface approximations, documented in DISCREPANCIES.md.
     * -- tio 19Nov26
     */
    static final List<AffixHit> NONFINAL_CANDIDATES = [
        new AffixHit(surface: 'ᎢᎶ', layer: L_NONFINAL, meanings: ['-ilo- repetitive'], glosses: ['ilo-']),
        new AffixHit(surface: 'ᏓᏂ', layer: L_NONFINAL, meanings: ['-dan- instrumental-causative / -dohdan- unintentional'], glosses: ['dan-']),
        new AffixHit(surface: 'ᎣᏂ', layer: L_NONFINAL, meanings: ['-ohn- completive'], glosses: ['ohn-']),
        new AffixHit(surface: 'ᎡᎸ', layer: L_NONFINAL, meanings: ['-el- dative-benefactive'], glosses: ['el-']),
        new AffixHit(surface: 'ᎢᏙᎸ', layer: L_NONFINAL, meanings: ['-idol- "around"'], glosses: ['idol-']),
        new AffixHit(surface: 'Ꭲ', layer: L_NONFINAL, meanings: ['-e- "at intervals" / -ihl- "come to" (surface Ꭲ is ambiguous)'], glosses: ['e-/ihl-']),
        new AffixHit(surface: 'Ꭹ', layer: L_NONFINAL, meanings: ['-g- progressive'], glosses: ['g-']),
    ].asImmutable()

    /**
     * Final-suffix readings keyed by the latin ending (FinalSuffixProcessor
     * lstEndings). Confident readings cited; the rest labeled "final
     * particle" -- v1-approximate, DISCREPANCIES.md. -- tio 19Nov26
     */
    static final Map<String, String> FINAL_SUFFIX_MEANINGS = [
        'gwu' : "'also, too' (gwu)",
        'sgo' : "dubitative 'perhaps' (sgo)",
        'ju'  : "'just, even' (ju)",
        'ke'  : "final particle -ke",
        'na'  : "contrastive (na)",
        'hv'  : "question/hortative (hv)",
        'dina': "plural 'around' (dina)",
        'dv'  : "final particle -dv",
        'esdi': "final particle -esdi",
        'idi' : "'together, mutually' (idi)",
        'si'  : "final particle -si",
        'isi' : "final particle -isi",
        'svi' : "final particle -svi (vi after ni)",
        'vi'  : "final particle -vi",
        'oi'  : "final particle -oi",
        'ei'  : "final particle -ei",
        'di'  : "linking/conditional (di)",
        'a'   : "stem tail -a (tense tail)",
        'i'   : "stem tail -i (past-family tense tail)",
    ].asImmutable()

    /**
     * The entry point: all consistent outside-in analyses of the surface
     * form. Glyph input passes through; roman converts via the
     * VerbInputNormalizer gate. Never throws, never returns empty.
     * -- tio 19Nov26
     */
    static List<Deconstruction> deconstruct(String raw) {
        if (raw == null || raw.trim().isEmpty()) {
            return [unparsed(raw ?: '')]
        }
        // tio 19Nov26: INPUT GATE -- same normalization the conjugation path
        // uses, so roman forms convert (apostrophes dropped per the
        // no-yaml-junk ruling) and glyphs pass byte-identical.
        String form = VerbInputNormalizer.normalizeRequestStem(raw.trim())
        if (!form) {
            return [unparsed(raw)]
        }
        // tio 19Nov26: transliteration residue ("not a valid letter") is the
        // suite's established failure-marker convention (facade error
        // contract) -- a form carrying residue is not a real verb surface,
        // so it is UNPARSED rather than force-peeled.
        String latin = SyllabaryUtil.parseSyllabary(form)
        if (!latin || form.contains('not a valid letter') || latin.contains('not a valid letter')) {
            return [unparsed(form)]
        }

        def analyses = []

        // Layer 1 (outermost): final suffix candidates, longest first, plus
        // the "no final suffix" candidate.
        def endings = (FinalSuffixProcessor.lstEndings as Set).toList()
                .sort { -it.size() }
        finalCandidates(latin, endings).each { cand ->
            String baseLatin = cand.base
            // Layer 2: non-final suffix (0 or 1 hit in v1).
            nonfinalCandidates(baseLatin).each { nf ->
                String strippedLatin = nf ? baseLatin.substring(0, baseLatin.size() - nf.surface.size()) : baseLatin
                AffixHit nfHit = nf ? cloneHit(nf, nf.surface) : null

                String baseGlyph = SyllabaryUtil.tsalagiToSyllabary(strippedLatin)
                // tio 19Nov26: a peel whose remainder does not transliterate
                // cleanly is not automatically dead -- the common cause is a
                // TRAILING LONE ROOT-ENDING CONSONANT (h/w/y/n) fused into the
                // next glyph (gowatih + a = ᎪᏩᏘᎭ). Convert the stem part and
                // park the consonant on the analysis as rootEndingLatin so
                // the Root Ending cell still renders.
                String carriedEnding = null
                if (!baseGlyph || baseGlyph.contains('not a valid letter')) {
                    def m = (strippedLatin =~ /(.*[aeiouv])([hwyn])$/)
                    if (m.matches()) {
                        String stemPart = m[0][1]
                        String g2 = SyllabaryUtil.tsalagiToSyllabary(stemPart)
                        if (g2 && !g2.contains('not a valid letter')) {
                            baseGlyph = g2
                            carriedEnding = m[0][2]
                        }
                    }
                }
                if (!baseGlyph || baseGlyph.contains('not a valid letter')) {
                    return
                }
                // Layers 3+4: initial prefixes (0..2) then pronominal match.
                peelInitial(baseGlyph, [], analyses, nfHit, cand.hit, carriedEnding)
            }
        }

        // tio 19Nov26: analyses carry the FULL normalized form as their
        // input surface -- the HTML renderer aligns segments against the
        // whole form's glyph->latin map, so the outer orig cell must show
        // everything, not the post-peel remainder.
        analyses.each { d -> d.inputSurface = form }

        def deduped = []
        def seen = [] as Set
        analyses.each { d ->
            String sig = d.toString()
            if (!seen.contains(sig) && deduped.size() < MAX_ANALYSES) {
                seen << sig
                deduped << d
            }
        }
        return deduped ?: [unparsed(form)]
    }

    private static void peelInitial(String base, List<AffixHit> peeled,
                                    List<Deconstruction> out,
                                    AffixHit nonfinalHit, AffixHit finalHit,
                                    String rootEndingLatin = null) {
        // Pronominal match + stem remainder for whatever has been peeled so far.
        pronominalMatches(base).each { hit ->
            Deconstruction d = new Deconstruction(parsed: true, rootEndingLatin: rootEndingLatin)
            peeled.each { d.affixes << it }
            d.affixes << hit
            d.stemHypothesis = base.substring(hit.surface.size())
            if (nonfinalHit) { d.affixes << nonfinalHit }
            if (finalHit) { d.affixes << finalHit }
            out << d
        }
        // Pronominal-unmatched branch: the whole remainder is the stem slot.
        if (peeled.size() > 0) {
            Deconstruction d = new Deconstruction(parsed: true, rootEndingLatin: rootEndingLatin)
            peeled.each { d.affixes << it }
            d.stemHypothesis = base
            if (nonfinalHit) { d.affixes << nonfinalHit }
            if (finalHit) { d.affixes << finalHit }
            out << d
        }
        // Deeper initial-prefix peels.
        if (peeled.size() < MAX_INITIAL_DEPTH) {
            initialPrefixCandidates(base).each { hit ->
                String rest = base.substring(hit.surface.size())
                peelInitial(rest, peeled + [hit], out, nonfinalHit, finalHit, rootEndingLatin)
            }
        }
    }

    /** All initial-prefix hits matching at the head of the glyph base. -- tio 19Nov26 */
    private static List<AffixHit> initialPrefixCandidates(String base) {
        def out = []
        INITIAL_PREFIX_SURFACES.each { name, glyphs ->
            glyphs.each { g ->
                if (base.startsWith(g) && g.size() < base.size()) {
                    out << new AffixHit(surface: g, layer: L_INITIAL,
                            meanings: [INITIAL_PREFIX_MEANINGS[name]],
                            glosses: [name + '-'])
                }
            }
        }
        // Longest surface first so peeling prefers the longer candidate.
        return out.sort { -it.surface.size() }
    }

    /**
     * All pronominal-prefix readings for the head of the glyph base:
     * every CompoundPrefixes.prefixes entry whose preConsonant form (or the
     * glyph head of its preVowel form) matches. Ambiguity across Set A/B
     * keys is kept as separate meanings. -- tio 19Nov26
     */
    private static List<AffixHit> pronominalMatches(String base) {
        // tio 19Nov26: one AffixHit per head surface, carrying ALL candidate
        // readings (user ruling: ambiguity is kept INSIDE the hit, not spread
        // across duplicate hits). glosses carry the terse pair codes
        // ("SG1SG3AN", "SG1SG3AN (B)") for the interlinear trans cells.
        def bySurface = [:]
        CompoundPrefixes.prefixes.each { key, p ->
            def heads = []
            if (p.preConsonant) { heads << p.preConsonant }
            if (p.preVowel) {
                String head = p.preVowel.replaceAll('[A-Za-z]+$', '')
                if (head && head != p.preConsonant) { heads << head }
            }
            heads.each { head ->
                if (head.size() < base.size() && base.startsWith(head)) {
                    String meaning = pronominalMeaning(key, p)
                    String gloss = key.endsWith('B') ?
                            key.substring(0, key.size() - 1) + ' (B)' : key
                    if (!bySurface.containsKey(head)) {
                        bySurface[head] = [meanings: [], glosses: []]
                    }
                    if (!bySurface[head].meanings.contains(meaning)) {
                        bySurface[head].meanings << meaning
                        bySurface[head].glosses << gloss
                    }
                }
            }
        }
        return bySurface.collect { surface, mg ->
            new AffixHit(surface: surface, layer: L_PRONOMINAL,
                    meanings: mg.meanings, glosses: mg.glosses)
        }.sort { -it.surface.size() }
    }

    /** English reading for one prefixes-map key ("SG1SG2" / "SG1SG2B"). -- tio 19Nov26 */
    private static String pronominalMeaning(String key, Object prefix) {
        String pairKey = key.endsWith('B') ? key.substring(0, key.size() - 1) : key
        String english = null
        try {
            def compound = CompoundPrefixes."$pairKey"
            if (compound != null) {
                def plain = CompoundPrefixPlainEnglishMapper.lookup(compound)
                english = plain?.english
            }
        } catch (Exception ignored) {
            english = null
        }
        if (!english) {
            english = pairKey
        }
        if (key.endsWith('B')) {
            english += " (Set B: d/ts/s-initial stems)"
        }
        // Fused-letter preVowel forms carry a trailing latin letter that
        // merges with the stem's first syllable (Morphemes.fixPrefix).
        String fused = (prefix.preVowel ?: '').replaceAll('^.*?([A-Za-z]+)$', '$1')
        if (prefix.preVowel && fused != prefix.preVowel) {
            english += " [fused letter '${fused}' merges with the stem's first syllable]"
        }
        return english
    }

    private static List<Map> finalCandidates(String latin, List<String> endings) {
        def out = [ [end: null, base: latin] ]
        endings.each { e ->
            if (e && latin.endsWith(e) && latin.size() > e.size()) {
                out << [end: e, base: latin.substring(0, latin.size() - e.size())]
            }
        }
        return out.collect { m ->
            def hit = m.end ? new AffixHit(surface: '-' + m.end, layer: L_FINAL,
                    meanings: [FINAL_SUFFIX_MEANINGS[m.end] ?: "final particle -${m.end}"],
                    glosses: ['-' + m.end]) : null
            [hit: hit, base: m.base]
        }
    }

    private static List<AffixHit> nonfinalCandidates(String latin) {
        def out = [null]
        NONFINAL_CANDIDATES.each { c ->
            String glyph = SyllabaryUtil.tsalagiToSyllabary(c.surface)
            String latinForm = glyph ? SyllabaryUtil.parseSyllabary(glyph) : c.surface
            if (latinForm && latin.endsWith(latinForm) && latin.size() > latinForm.size()) {
                out << cloneHit(c, c.surface)
            }
        }
        return out
    }

    private static AffixHit cloneHit(AffixHit src, String surface) {
        return new AffixHit(surface: surface, layer: src.layer, meanings: new ArrayList(src.meanings))
    }

    private static Deconstruction unparsed(String surface) {
        return new Deconstruction(
                inputSurface: surface,
                parsed: false,
                affixes: [new AffixHit(surface: surface, layer: L_UNPARSED,
                        meanings: ['no consistent outside-in segmentation found'])])
    }
}
