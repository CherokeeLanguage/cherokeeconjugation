package net.cherokeedcitionary.verbal.rules

import net.cherokeedcitionary.util.PrefixObject
import net.cherokeedcitionary.util.PrefixSubject
import net.cherokeedcitionary.util.Tense
import net.cherokeedcitionary.util.VerbSet


/**
 * Created by torr on 8/21/2015.
 * 3SG Set B (uw) with a- stem contracts to 'u' so 'uwa' = 'u'
 */
class RuleUW implements PrefixRule {
    @Override
    def process(final PrefixSubject pts,
                final PrefixObject pto,
                final String prefix,
                final Tense tense,
                final boolean isLiquid,
                final String verbStem,
                final VerbSet verbSet) {
        def processedValue;

        def tmpValue = prefix + verbStem;

        //todo: find out if this is all /uwa/ starts or not - b/c /duwa/ is clearly /du/ according to ᏚᏚᎵᎭ

        if (verbSet == VerbSet.B
            && pto != null && pto == PrefixObject.SG3IN
            && pts == PrefixSubject.SG3) {

            //todo: should change this so that the stem starts with = a vowel instead of 'uwa'
            if (tmpValue.startsWith("ᎤᏩ")) {
                //if the verb starts with the two syllables (uwa) then we want to remove both and add the 'u' only
                // this won't change when we add more prefixes
                //todo: remember to process the prefixes in order from closest to root and stem out ward
                processedValue = "Ꭴ$verbStem"
            }
        } else if (pto != null && pto == PrefixObject.PL3IN) {
            if (tmpValue.startsWith("ᎤᏩ")) {
                processedValue = "Ꭴ$verbStem"
            } else if(tmpValue.startsWith("ᏚᏩ")) {
                processedValue = "Ꮪ$verbStem"
            }
        }

        return processedValue;
    }
}
