package cherokee.dictionary.verb.conjugation.originalconjugation.rules

import cherokee.dictionary.verb.conjugation.originalconjugation.PrefixTableObject
import cherokee.dictionary.verb.conjugation.originalconjugation.PrefixTableSubject
import cherokee.dictionary.verb.conjugation.originalconjugation.Tense
import cherokee.dictionary.verb.conjugation.originalconjugation.VerbSet


/**
 * Created by torr on 8/21/2015.
 */
class RulesProcessor {
    static def rules = new ArrayList<PrefixRule>();
    static {
        rules << new RuleUW();
    }

    def processRules(final PrefixTableSubject pts,
                     final PrefixTableObject pto,
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
