package cherokee.dictionary.conjugation.rules

import cherokee.dictionary.conjugation.conjugate.Prefix
import cherokee.dictionary.conjugation.conjugate.PrefixTableObject
import cherokee.dictionary.conjugation.conjugate.PrefixTableSubject
import cherokee.dictionary.conjugation.conjugate.Tense
import cherokee.dictionary.conjugation.conjugate.VerbSet

/**
 * Created by torr on 8/21/2015.
 */
public interface PrefixRule {
    def process(final Prefix prefix1,
                final Prefix prefix2,
                final PrefixTableSubject pts,
                final PrefixTableObject pto,
                final Tense tense,
                final boolean isLiquid,
                final String verbStem,
                final VerbSet verbSet);
}