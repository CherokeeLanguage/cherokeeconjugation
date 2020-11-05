package cherokee.dictionary.verb.conjugation.originalconjugation.rules

import cherokee.conjugation.constants.Tense
import cherokee.conjugation.constants.VerbPrefixTableObject
import cherokee.conjugation.constants.VerbPrefixTableSubject
import cherokee.conjugation.constants.VerbSet


/**
 * Created by torr on 8/21/2015.
 */
public interface PrefixRule {
    def process(final VerbPrefixTableSubject pts,
                final VerbPrefixTableObject pto,
                final String prefix,
                final Tense tense,
                final boolean isLiquid,
                final String verbStem,
                final VerbSet verbSet);
}