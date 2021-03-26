package cherokee.dictionary.verb.conjugation.originalconjugation.rules

import cherokee.conjugation.verbal.containers.VerbPrefixTableObject
import cherokee.conjugation.verbal.containers.VerbPrefixTableSubject
import cherokee.conjugation.verbal.enums.Tense
import cherokee.conjugation.verbal.enums.VerbSet

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