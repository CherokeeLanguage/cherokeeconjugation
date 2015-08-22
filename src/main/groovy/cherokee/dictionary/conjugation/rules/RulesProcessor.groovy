package cherokee.dictionary.conjugation.rules

import cherokee.dictionary.conjugation.conjugate.Prefix
import cherokee.dictionary.conjugation.conjugate.PrefixTableObject
import cherokee.dictionary.conjugation.conjugate.PrefixTableSubject
import cherokee.dictionary.conjugation.conjugate.Tense
import cherokee.dictionary.conjugation.conjugate.VerbSet

/**
 * Created by torr on 8/21/2015.
 */
class RulesProcessor {
    static def rules = new ArrayList<PrefixRule>();
    static {
        rules << new RuleUW();
    }

    def processRules(final Prefix prefix1,
                     final Prefix prefix2,
                     final PrefixTableSubject pts,
                     final PrefixTableObject pto,
                     final Tense tense,
                     final boolean isLiquid,
                     final String verbStem,
                     final VerbSet verbSet) {
        def returnValue = verbStem
        rules.each {
            returnValue = it.process(prefix1, prefix2, pts, pto, tense, isLiquid, returnValue, verbSet)
        }

        return returnValue;
    }
}
