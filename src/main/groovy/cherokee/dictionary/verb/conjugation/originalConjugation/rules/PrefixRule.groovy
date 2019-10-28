package cherokee.dictionary.verb.conjugation.originalConjugation.rules

import cherokee.dictionary.verb.conjugation.originalConjugation.PrefixTableObject
import cherokee.dictionary.verb.conjugation.originalConjugation.PrefixTableSubject
import cherokee.dictionary.verb.conjugation.originalConjugation.Tense
import cherokee.dictionary.verb.conjugation.originalConjugation.VerbSet

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