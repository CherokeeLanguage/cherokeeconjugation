package cherokee.dictionary.conjugation.rules

import cherokee.dictionary.conjugation.conjugate.Prefix
import cherokee.dictionary.conjugation.conjugate.PrefixTableObject
import cherokee.dictionary.conjugation.conjugate.PrefixTableSubject
import cherokee.dictionary.conjugation.conjugate.Tense
import cherokee.dictionary.conjugation.conjugate.VerbSet

/**
 * Created by torr on 8/21/2015.
 * 3SG Set B (uw) with a- stem contracts to 'u' so 'uwa' = 'u'
 */
class RuleUW implements PrefixRule {
    @Override
    def process(final Prefix prefix1,
                final Prefix prefix2,
                final PrefixTableSubject pts,
                final PrefixTableObject pto,
                final Tense tense,
                final boolean isLiquid,
                final String verbStem,
                final VerbSet verbSet) {
        def processedValue = verbStem;

        if (verbSet == VerbSet.B
            && pto== PrefixTableObject.SG3IN
            && pts == PrefixTableSubject.SG3) {
            if (verbStem.startsWith("ᎤᏩ")) {
                processedValue = "Ꭴ${verbStem.substring(2)}"
            }
        }

        return processedValue;
    }
}
