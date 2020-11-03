package cherokee.dictionary.verb.conjugation.originalconjugation.rules

import cherokee.dictionary.verb.conjugation.originalconjugation.PrefixTableObject
import cherokee.dictionary.verb.conjugation.originalconjugation.PrefixTableSubject
import cherokee.dictionary.verb.conjugation.originalconjugation.Tense
import cherokee.dictionary.verb.conjugation.originalconjugation.VerbSet

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