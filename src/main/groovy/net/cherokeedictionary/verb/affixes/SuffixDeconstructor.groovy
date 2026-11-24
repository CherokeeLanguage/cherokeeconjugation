package net.cherokeedictionary.verb.affixes

import net.cherokeedictionary.core.Verb
import net.cherokeedictionary.verb.affixes.suffixes.*
import groovy.transform.CompileStatic

/**
 * Orchestrator for suffix deconstruction.
 * 
 * Processes suffixes from end of word toward stem (outside-in).
 * Handles multiple suffix types and their order appropriately.
 */
@CompileStatic
class SuffixDeconstructor {

    // Initialize all suffix instances with deconstruction methods
    private final SuffixI suffixI = new SuffixI()
    private final SuffixHv suffixHv = new SuffixHv()
    private final SuffixGwu suffixGwu = new SuffixGwu()
    private final SuffixEsdi suffixEsdi = new SuffixEsdi()
    private final SuffixJu suffixJu = new SuffixJu()
    private final SuffixNa suffixNa = new SuffixNa()
    private final SuffixKe suffixKe = new SuffixKe()
    private final SuffixA suffixA = new SuffixA()
    private final SuffixOi suffixOi = new SuffixOi()
    private final SuffixVi suffixVi = new SuffixVi()
    
    // Additional suffix processors
    private final SuffixSgo suffixSgo = new SuffixSgo()
    private final SuffixDina suffixDina = new SuffixDina()
    private final SuffixDi suffixDi = new SuffixDi()
    private final SuffixIsi suffixIsi = new SuffixIsi()
    private final SuffixIdi suffixIdi = new SuffixIdi()
    private final SuffixSvi suffixSvi = new SuffixSvi()
    private final SuffixEi suffixEi = new SuffixEi()
    private final SuffixDv suffixDv = new SuffixDv()

    /**
     * Process all suffixes from end of word
     * 
     * @param remaining The verb form after initial prefix removal
     * @param verb Optional Verb object with metadata
     * @param morphemes List to append extracted morphemes to
     * @return Remaining stem after suffix removal
     */
    String processAllSuffixes(String remaining, Verb verb, List<Morpheme> morphemes) {
        if (!remaining || remaining.length() < 2) {
            return remaining
        }

        boolean changed = true
        int maxIterations = 15  // Increased for more suffix types
        int iteration = 0

        // Keep processing until no more suffixes are found or max iterations reached
        while (changed && iteration < maxIterations && remaining.length() >= 2) {
            changed = false
            iteration++

            // Try multi-character suffixes first (longest matches before shorter)

            // === MULTI-CHARACTER SUFFIXES (Longest First) ===
            
            // 1. Try ᏳᏍᏗ (immediate future) - 3 characters
            SuffixResult gwuResult = suffixGwu.deconstructFromSyllabary(remaining, verb)
            if (gwuResult.suffixRemoved && "IMMEDIATE_FUTURE" == gwuResult.type) {
                addMorpheme(morphemes, "SUFFIX", "IMMEDIATE_FUTURE", gwuResult)
                remaining = gwuResult.result
                println("  → Found SUFFIX: IMMEDIATE_FUTURE (${gwuResult.detectedSuffix})")
                println("    Remaining: ${remaining}\n")
                changed = true
                continue
            }

            // 2. Try ᎡᏍᏗ (future-oriented) - 3 characters
            SuffixResult esdiResult = suffixEsdi.deconstructFromSyllabary(remaining, verb)
            if (esdiResult.suffixRemoved) {
                addMorpheme(morphemes, "SUFFIX", "FUTURE_ORIENTED", esdiResult)
                remaining = esdiResult.result
                println("  → Found SUFFIX: FUTURE_ORIENTED (${esdiResult.detectedSuffix})")
                println("    Remaining: ${remaining}\n")
                changed = true
                continue
            }

            // 3. Try ᏍᎪᎢ (completive) - 3 characters
            SuffixResult sgoResult = suffixSgo.deconstructFromSyllabary(remaining, verb)
            if (sgoResult.suffixRemoved) {
                addMorpheme(morphemes, "SUFFIX", "COMPLETIVE_ASPECT", sgoResult)
                remaining = sgoResult.result
                println("  → Found SUFFIX: COMPLETIVE (${sgoResult.detectedSuffix})")
                println("    Remaining: ${remaining}\n")
                changed = true
                continue
            }

            // 4. Try ᎣᎢ (habitual) - 2 characters
            SuffixResult oiResult = suffixOi.deconstructFromSyllabary(remaining, verb)
            if (oiResult.suffixRemoved && "HABITUAL_ASPECT" == oiResult.type) {
                addMorpheme(morphemes, "SUFFIX", "HABITUAL_ASPECT", oiResult)
                remaining = oiResult.result
                println("  → Found SUFFIX: HABITUAL (${oiResult.detectedSuffix})")
                println("    Remaining: ${remaining}\n")
                changed = true
                continue
            }

            // 5. Try ᎥᎢ (habitual/aspectual) - 2 characters
            SuffixResult viResult = suffixVi.deconstructFromSyllabary(remaining, verb)
            if (viResult.suffixRemoved && ("HABITUAL_OR_ASPECTUAL" == viResult.type)) {
                addMorpheme(morphemes, "SUFFIX", "HABITUAL_OR_ASPECTUAL", viResult)
                remaining = viResult.result
                println("  → Found SUFFIX: HABITUAL/ASPECTUAL (${viResult.detectedSuffix})")
                println("    Remaining: ${remaining}\n")
                changed = true
                continue
            }

            // 6. Try ᎢᏏ (habitual/aspectual) - 2 characters
            SuffixResult isiResult = suffixIsi.deconstructFromSyllabary(remaining, verb)
            if (isiResult.suffixRemoved && ("HABITUAL_OR_ASPECTUAL" == isiResult.type)) {
                addMorpheme(morphemes, "SUFFIX", "HABITUAL_OR_ASPECTUAL", isiResult)
                remaining = isiResult.result
                println("  → Found SUFFIX: HABITUAL_VARIANT (${isiResult.detectedSuffix})")
                println("    Remaining: ${remaining}\n")
                changed = true
                continue
            }

            // 7. Try ᎢᏗ (infinitive variant) - 2 characters
            SuffixResult idiResult = suffixIdi.deconstructFromSyllabary(remaining, verb)
            if (idiResult.suffixRemoved) {
                addMorpheme(morphemes, "SUFFIX", "INFINITIVE_VARIANT", idiResult)
                remaining = idiResult.result
                println("  → Found SUFFIX: INFINITIVE_VARIANT (${idiResult.detectedSuffix})")
                println("    Remaining: ${remaining}\n")
                changed = true
                continue
            }

            // 8. Try ᎡᎢ (aspectual/modal) - 2 characters
            SuffixResult eiResult = suffixEi.deconstructFromSyllabary(remaining, verb)
            if (eiResult.suffixRemoved) {
                addMorpheme(morphemes, "SUFFIX", "ASPECTUAL_MODAL", eiResult)
                remaining = eiResult.result
                println("  → Found SUFFIX: ASPECTUAL_MODAL (${eiResult.detectedSuffix})")
                println("    Remaining: ${remaining}\n")
                changed = true
                continue
            }

            // 9. Try ᏍᎢ (vowel-finalization after nasal) - 2 characters
            SuffixResult sviResult = suffixSvi.deconstructFromSyllabary(remaining, verb)
            if (sviResult.suffixRemoved) {
                addMorpheme(morphemes, "SUFFIX", "VOWEL_FINALIZATION_NASAL", sviResult)
                remaining = sviResult.result
                println("  → Found SUFFIX: VOWEL_FINALIZATION_NASAL (${sviResult.detectedSuffix})")
                println("    Remaining: ${remaining}\n")
                changed = true
                continue
            }

            // 10. Try ᏗᎾ (plural/distributive) - 2 characters
            SuffixResult dinaResult = suffixDina.deconstructFromSyllabary(remaining, verb)
            if (dinaResult.suffixRemoved) {
                addMorpheme(morphemes, "SUFFIX", "PLURAL_DISTRIBUTIVE", dinaResult)
                remaining = dinaResult.result
                println("  → Found SUFFIX: PLURAL_DISTRIBUTIVE (${dinaResult.detectedSuffix})")
                println("    Remaining: ${remaining}\n")
                changed = true
                continue
            }

            // Now try single-character suffixes
            // 11. Try Ꭲ (habitual present) - 1 character
            SuffixResult iResult = suffixI.deconstructFromSyllabary(remaining, verb)
            if (iResult.suffixRemoved) {
                addMorpheme(morphemes, "SUFFIX", "HABITUAL_PRESENT", iResult)
                remaining = iResult.result
                println("  → Found SUFFIX: HABITUAL_PRESENT (${iResult.detectedSuffix})")
                println("    Remaining: ${remaining}\n")
                changed = true
                continue
            }

            // 12. Try Ꮫ (completive aspect) - 1 character
            SuffixResult dvResult = suffixDv.deconstructFromSyllabary(remaining, verb)
            if (dvResult.suffixRemoved) {
                addMorpheme(morphemes, "SUFFIX", "COMPLETIVE_ASPECT", dvResult)
                remaining = dvResult.result
                println("  → Found SUFFIX: COMPLETIVE (${dvResult.detectedSuffix})")
                println("    Remaining: ${remaining}\n")
                changed = true
                continue
            }

            // 13. Try Ꮚ (remote past marker) - 1 character
            SuffixResult gwuSingleResult = suffixGwu.deconstructFromSyllabary(remaining, verb)
            if (gwuSingleResult.suffixRemoved && "REMOTE_PAST" == gwuSingleResult.type) {
                addMorpheme(morphemes, "SUFFIX", "REMOTE_PAST", gwuSingleResult)
                remaining = gwuSingleResult.result
                println("  → Found SUFFIX: REMOTE_PAST (${gwuSingleResult.detectedSuffix})")
                println("    Remaining: ${remaining}\n")
                changed = true
                continue
            }

            // 14. Try Ꮧ (infinitive marker) - 1 character
            SuffixResult diResult = suffixDi.deconstructFromSyllabary(remaining, verb)
            if (diResult.suffixRemoved) {
                addMorpheme(morphemes, "SUFFIX", "INFINITIVE_MARKER", diResult)
                remaining = diResult.result
                println("  → Found SUFFIX: INFINITIVE_MARKER (${diResult.detectedSuffix})")
                println("    Remaining: ${remaining}\n")
                changed = true
                continue
            }

            // 15. Try other single-character suffixes (Ꮂ, Ꮷ, Ꮎ, Ꭸ, Ꭰ)
            def otherResults = [
                suffixHv: suffixHv.deconstructFromSyllabary(remaining, verb),
                suffixJu: suffixJu.deconstructFromSyllabary(remaining, verb),
                suffixNa: suffixNa.deconstructFromSyllabary(remaining, verb),
                suffixKe: suffixKe.deconstructFromSyllabary(remaining, verb),
                suffixA: suffixA.deconstructFromSyllabary(remaining, verb)
            ]

            otherResults.each { suffixInstance, res ->
                if (res.suffixRemoved && !changed) {
                    addMorpheme(morphemes, "SUFFIX", res.type ?: "UNKNOWN_SUFFIX", res)
                    remaining = res.result
                    println("  → Found SUFFIX: ${res.type} (${res.detectedSuffix})")
                    println("    Remaining: ${remaining}\n")
                    changed = true
                }
            }
        }

        return remaining
    }

    private void addMorpheme(List<Morpheme> morphemes, String type, String value, SuffixResult result) {
        BigDecimal confidence = 0.9
        if (result.type in ["VOWEL_FINALIZATION_NASAL", "INFINITIVE_VARIANT", "UNKNOWN_SUFFIX"]) {
            confidence = 0.8
        }
        
        Morpheme morpheme = new Morpheme(
            type: type,
            value: value,
            detectedValue: result.detectedSuffix,
            position: morphemes.size(),
            confidence: confidence
        )
        morphemes << morpheme
    }
}
