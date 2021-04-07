package net.cherokeedictionary.verb.rules

import net.cherokeedictionary.util.PrefixTableObject
import net.cherokeedictionary.util.PrefixTableSubject
import net.cherokeedictionary.util.Tense
import net.cherokeedictionary.util.VerbSet


/**
 * Created by torr on 8/21/2015.
 */
public interface PrefixRule {
    def process(final PrefixTableSubject pts,
                final PrefixTableObject pto,
                final String prefix,
                final Tense tense,
                final boolean isLiquid,
                final String verbStem,
                final VerbSet verbSet);
}