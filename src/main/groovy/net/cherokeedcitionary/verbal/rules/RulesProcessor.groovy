package net.cherokeedcitionary.verbal.rules

import net.cherokeedcitionary.util.PrefixObject
import net.cherokeedcitionary.util.PrefixSubject
import net.cherokeedcitionary.util.Tense
import net.cherokeedcitionary.util.VerbSet


/**
 * Created by torr on 8/21/2015.
 */
class RulesProcessor {
    static def rules = new ArrayList<PrefixRule>();
    static {
        rules << new RuleUW();
    }

    def processRules(final PrefixSubject pts,
                     final PrefixObject pto,
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
