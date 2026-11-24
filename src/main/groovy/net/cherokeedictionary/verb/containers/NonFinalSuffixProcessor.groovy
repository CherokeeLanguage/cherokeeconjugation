package net.cherokeedictionary.verb.containers

import net.cherokeedictionary.core.Verb
import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import net.cherokeedictionary.verb.affixes.nonFinalSuffixes.*

/**
 * C6: non-final suffix machinery, wired in the grammar's order (Feeling 1975,
 * Figure 1, p.282: "shows the relative order in which the non-final and final
 * suffixes occur following the verb stem"):
 *
 *   1 -gi-/-e-/-y-, reversive      -> NonFinalSuffixGi
 *   2 -is-, duplicative / "become" -> NonFinalSuffixIs
 *   3 -ilo-, repetitive            -> NonFinalSuffixIlo
 *   4 -dan-, instrumental-causative / -dohdan-, unintentional
 *   5 -ohn-, completive            -> NonFinalSuffixOhn
 *   6 -el-, dative-benefactive     -> NonFinalSuffixEl
 *   7 -idol- "around"              -> NonFinalSuffixIdol
 *   8 -e- "at intervals" / -ihl- "come to"
 *   9 -g-, progressive             -> NonFinalSuffixG
 *   9 -idi-, pre-incipient         -> NonFinalSuffixIdi
 *   9 -i-, future                  -> NonFinalSuffixI
 *
 * Each suffix fires only when its flag is set on verb.nonFinalSuffixHolder;
 * with no flags set the word passes through unchanged (the historical
 * behavior, which nothing currently breaks).
 */
class NonFinalSuffixProcessor {
    public static String processNonFinalSuffixesRemove(data, Verb verb) {
        return data
    }

    public static String process(Verb verb) {
        String baseReturnValue = verb.wholeWord

        if (!baseReturnValue || baseReturnValue.startsWith("MISSING_ENTRY") || baseReturnValue.startsWith("MISSING_STEM")) {
            return ""//baseReturnValue
        }

        def holder = verb.nonFinalSuffixHolder

        // Grammar order (Figure 1): gi -> is -> ilo -> dan/dohdan -> ohn -> el -> idol -> e/ihl -> g/idi/i
        // gi/is/idi/i are NOT-IMPLEMENTED-YET stubs (positions 1, 2, 9); the
        // stubs pass the word through unchanged, so these only fire when the
        // flags are set AND the suffixes are implemented. KNOWN-GAP(NONFINAL-GI)
        // KNOWN-GAP(NONFINAL-IS) KNOWN-GAP(NONFINAL-IDI) KNOWN-GAP(NONFINAL-I)
        if (holder.gi) {
            baseReturnValue = new NonFinalSuffixGi().toSyllabary(baseReturnValue, verb)
        }
        if (holder.is) {
            baseReturnValue = new NonFinalSuffixIs().toSyllabary(baseReturnValue, verb)
        }
        if (holder.ilo) {
            baseReturnValue = new NonFinalSuffixIlo().toSyllabary(baseReturnValue, verb)
        }
        if (holder.dohdan) {
            baseReturnValue = new NonFinalSuffixDohdan().toSyllabary(baseReturnValue, verb)
        }
        if (holder.dan) {
            baseReturnValue = new NonFinalSuffixDan().toSyllabary(baseReturnValue, verb)
        }
        if (holder.ohn) {
            baseReturnValue = new NonFinalSuffixOhn().toSyllabary(baseReturnValue, verb)
        }
        if (holder.el) {
            baseReturnValue = new NonFinalSuffixEl().toSyllabary(baseReturnValue, verb)
        }
        if (holder.idol) {
            baseReturnValue = new NonFinalSuffixIdol().toSyllabary(baseReturnValue, verb)
        }
        if (holder.e) {
            baseReturnValue = new NonFinalSuffixE().toSyllabary(baseReturnValue, verb)
        }
        if (holder.ihl) {
            baseReturnValue = new NonFinalSuffixIhi().toSyllabary(baseReturnValue, verb)
        }
        if (holder.g) {
            baseReturnValue = new NonFinalSuffixG().toSyllabary(baseReturnValue, verb)
        }
        if (holder.idi) {
            baseReturnValue = new NonFinalSuffixIdi().toSyllabary(baseReturnValue, verb)
        }
        if (holder.i) {
            baseReturnValue = new NonFinalSuffixI().toSyllabary(baseReturnValue, verb)
        }

        return baseReturnValue ?: verb.wholeWord
    }

    /**
     * Shared helper: insert a non-final suffix (given in latin) between the
     * root and the tense tail (root ending + final suffix), e.g.
     * gawoni-h- + ilo + -a. The tail is identified from verb.rootEnding and
     * the tense's final suffix (getTenseValue), accepting the -i/-a variants
     * the verb book prints for the recent past. When the tail cannot be
     * matched (irregular surfaces), the word passes through unchanged.
     *
     * NOTE: Feeling (p.285) notes that -dan- "is attached to the infinitive
     * stem of verbs" — the fully faithful form needs the deverbal stem
     * (wonihis-, vs the present stem wonih-). Until verb-level deverbal data
     * is routed through the holders, this insertion works off the routed tense
     * stem; results are approximate for -his-/-is- class stems. -- timo 10Nov26
     */
    static String insertBeforeTail(Verb verb, String allomorphLatin) {
        String stem = verb.wholeWord
        if (!stem) {
            return stem
        }
        def latin = SyllabaryUtil.parseSyllabary(stem)
        String ending = (verb.rootEnding ?: "").toLowerCase()
        String tenseSuffix = (verb.getTenseValue() ?: "").toLowerCase()

        def tails = []
        if (tenseSuffix) {
            tails << ending + tenseSuffix
        }
        // recent past / imperative print both -i and -a (ImmediatePast variants)
        if (verb.tense == Tense.IMMEDIATE_PAST
                || verb.tense == Tense.IMMEDIATE_COMMAND
                || verb.tense == Tense.RECENT_PAST_IMPERATIVE) {
            if (tenseSuffix == "i") {
                tails << ending + "a"
            } else if (tenseSuffix == "a") {
                tails << ending + "i"
            }
        }
        if (ending) {
            tails << ending
        }

        for (String tail : tails) {
            if (tail && latin.endsWith(tail)) {
                def base = latin.substring(0, latin.size() - tail.size())
                return SyllabaryUtil.tsalagiToSyllabary(base + allomorphLatin + tail)
            }
        }

        return stem
    }

    /**
     * Insert a non-final suffix AFTER any prefix/reversive elements but before
     * the main stem. Used for position-2 suffixes like -is- (duplicative).
     * 
     * Pattern: [prefix][reversive]-is-[stem][-tail]
     */
    static String insertAfterPrefix(Verb verb, String allomorphLatin) {
        String stem = verb.wholeWord
        if (!stem) {
            return stem
        }

        // Try to detect if there's a reversive prefix at the start
        // Reversive typically starts with g/y/e before consonants
        boolean hasReversiveAtStart = stem.matches("^[gGyYeE].*?[^\\s]")
        
        if (hasReversiveAtStart && stem.size() > 2) {
            // Find where the reversive ends (rough heuristic: look for syllable boundary)
            int insertPoint = findInsertionPointAfterReversive(stem)
            if (insertPoint > 0) {
                def stemLatin = SyllabaryUtil.parseSyllabary(stem)
                def insertPointLatin = SyllabaryUtil.chr2lat(stem.substring(0, insertPoint)).length()
                
                def before = stemLatin.substring(0, insertPointLatin)
                def after = stemLatin.substring(insertPointLatin)
                
                return SyllabaryUtil.tsalagiToSyllabary(before + allomorphLatin + after)
            }
        }

        // Fallback to regular insertion
        return insertBeforeTail(verb, allomorphLatin)
    }

    /**
     * Helper: estimate where a reversive prefix ends so we can insert after it.
     * Very rough heuristic - look for the second syllable as reversive marker end.
     */
    private static int findInsertionPointAfterReversive(String syllabary) {
        // Count characters until we hit what looks like the stem proper
        // This is approximate; real implementation would need better morphology parsing
        if (syllabary.size() < 3) return 1
        
        // Look for pattern where reversive (-gi/-gis/-y) might end
        // Heuristic: reverse usually 2-3 chars before stem begins
        try {
            def lat = SyllabaryUtil.parseSyllabary(syllabary)
            // Simple: take first ~2-3 latin letters as potential reversive
            int estimatedReversiveEnd = Math.min(lat.length(), 3)
            
            // Convert back to syllabary position
            return SyllabaryUtil.lat2chr(lat.substring(0, Math.max(1, estimatedReversiveEnd))).length()
        } catch (Exception e) {
            return 1
        }
    }

    /**
     * Insert a non-final suffix before tense-final material, used for position-9
     * suffixes like -idi- (pre-incipient) and -i- (future). These compete with
     * each other and with built-in tense systems.
     * 
     * Pattern: [non-final-suffixes]-idi/[i]-[stem][-tense-final]
     */
    static String insertBeforeTense(Verb verb, String allomorphLatin) {
        String stem = verb.wholeWord
        if (!stem) {
            return stem
        }

        def latin = SyllabaryUtil.parseSyllabary(stem)
        String tenseSuffix = (verb.getTenseValue() ?: "").toLowerCase()
        String rootEnding = (verb.rootEnding ?: "").toLowerCase()

        // Try to find tense-final suffix to insert before
        if (tenseSuffix && latin.endsWith(tenseSuffix)) {
            def base = latin.substring(0, latin.size() - tenseSuffix.size())
            return SyllabaryUtil.tsalagiToSyllabary(base + allomorphLatin + tenseSuffix)
        }

        // If no clear tense suffix, try root ending
        if (rootEnding && latin.endsWith(rootEnding)) {
            def base = latin.substring(0, latin.size() - rootEnding.size())
            return SyllabaryUtil.tsalagiToSyllabary(base + allomorphLatin + rootEnding)
        }

        // Fallback: append before any final material
        if (latin.size() > 2) {
            // Insert near the end but before final syllables
            def insertPos = Math.max(2, latin.size() - 2)
            def before = latin.substring(0, insertPos)
            def after = latin.substring(insertPos)
            return SyllabaryUtil.tsalagiToSyllabary(before + allomorphLatin + after)
        }

        return stem
    }

    /**
     * True when the character immediately after the insertion point (the first
     * character of the tail) is a latin vowel.
     */
    static boolean tailStartsWithVowel(Verb verb) {
        String ending = (verb.rootEnding ?: "").toLowerCase()
        return ending ? net.cherokeedictionary.util.StringUtility.startsWithVowelLatin(ending) : false
    }
}
