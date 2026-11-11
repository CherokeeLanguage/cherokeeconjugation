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
 *   3 -ilo-, repetitive            -> NonFinalSuffixIlo
 *   4 -dan-, instrumental-causative / -dohdan-, unintentional
 *   5 -ohn-, completive            -> NonFinalSuffixOhn
 *   6 -el-, dative-benefactive     -> NonFinalSuffixEl
 *   7 -idol- "around"              -> NonFinalSuffixIdol
 *   8 -e- "at intervals" / -ihl- "come to"
 *   9 -g-, progressive             -> NonFinalSuffixG
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
            return baseReturnValue
        }

        def holder = verb.nonFinalSuffixHolder

        // Grammar order (Figure 1): ilo -> dan/dohdan -> ohn -> el -> idol -> e/ihl -> g
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
     * True when the character immediately after the insertion point (the first
     * character of the tail) is a latin vowel.
     */
    static boolean tailStartsWithVowel(Verb verb) {
        String ending = (verb.rootEnding ?: "").toLowerCase()
        return ending ? net.cherokeedictionary.util.StringUtility.startsWithVowelLatin(ending) : false
    }
}
