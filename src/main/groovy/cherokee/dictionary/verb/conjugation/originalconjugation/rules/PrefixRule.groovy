package cherokee.dictionary.verb.conjugation.originalconjugation.rules

import cherokee.conjugation.constants.PrefixTableObject
import cherokee.conjugation.constants.PrefixTableSubject
import cherokee.conjugation.constants.Tense
import cherokee.conjugation.constants.VerbSet


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