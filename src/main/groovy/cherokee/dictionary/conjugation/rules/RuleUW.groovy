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
            && pto != null && pto== PrefixTableObject.SG3IN
            && pts == PrefixTableSubject.SG3) {
            //todo: should change this so that the stem starts with = a vowel instead of 'uwa'
            if (verbStem.startsWith("ᎤᏩ")) {
                //if the verb starts with the two syllables (uwa) then we want to remove both and add the 'u' only
                // this won't change when we add more prefixes
                //todo: remember to process the prefixes in order from closest to root and stem out ward
                processedValue = "Ꭴ${verbStem.substring(2)}"
            }
        }

        return processedValue;
    }
}
