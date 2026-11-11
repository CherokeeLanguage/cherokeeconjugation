package net.cherokeedictionary.verb.suffixes

/**
 * Immediate Past Tense (verb book Stem IV): the recent past, "just happened".
 *
 * Grammar guide: "-a" without the progressive "-g-" indicates that an action
 * "has just been completed... usually referred to as the recent past".
 *
 * The verb book prints the final suffix as "-i" for most verbs (e.g.
 * -alihelig-i, -nvg-i) and as "-a" for others (e.g. To Bite -sgal-a, To Go
 * -en-a, To Want -adul-a), so both variants are accepted.
 */
class ImmediatePast extends Future {
    // primary final suffix "-i" (inherited); the verb book also prints "-a"
    static final def FINAL_SUFFIX_VARIANTS = ['i', 'a']

    List<String> getFinalSuffixVariants() {
        return FINAL_SUFFIX_VARIANTS
    }
}
