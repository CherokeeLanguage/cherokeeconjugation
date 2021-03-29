package net.cherokeedcitionary.verbal.rules

import net.cherokeedcitionary.util.PrefixObject
import net.cherokeedcitionary.util.PrefixSubject
import net.cherokeedcitionary.util.Tense
import net.cherokeedcitionary.util.VerbSet

/**
 * Created by torr on 8/21/2015.
 */
public interface PrefixRule {
    def process(final PrefixSubject pts,
                final PrefixObject pto,
                final String prefix,
                final Tense tense,
                final boolean isLiquid,
                final String verbStem,
                final VerbSet verbSet);
}