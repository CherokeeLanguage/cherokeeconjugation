package cherokee.dictionary.verb.conjugation.originalconjugation.rules

import cherokee.conjugation.constants.Tense
import cherokee.conjugation.constants.VerbPrefixTableObject
import cherokee.conjugation.constants.VerbPrefixTableSubject
import cherokee.conjugation.constants.VerbSet

/**
 * Created by torr on 8/21/2015.
 */
class RulesProcessor {
    static def rules = new ArrayList<PrefixRule>();
    static {
        rules << new RuleUW();
    }

    def processRules(final VerbPrefixTableSubject pts,
                     final VerbPrefixTableObject pto,
                     final Tense tense,
                     final boolean isLiquid,
                     final String verbStem,
                     final VerbSet verbSet) {
        def returnValue = verbStem
        rules.each {
            returnValue = it.process(pts, pto, tense, isLiquid, returnValue, verbSet)
        }

        return returnValue;
    }
}
