package cherokee.dictionary.conjugation

import cherokee.dictionary.conjugation.conjugate.PrefixTableObject
import cherokee.dictionary.conjugation.conjugate.PrefixTableSubject
import cherokee.dictionary.conjugation.conjugate.Tense
import cherokee.dictionary.conjugation.conjugate.VerbSet
import cherokee.dictionary.conjugation.rules.RuleUW

/**
 * Created by torr on 8/21/2015.
 */
class PrefixRuleTest extends GroovyTestCase {
    public void testRuleUW() {
        RuleUW ruleUW = new RuleUW();

        assertTrue "ᎤᏚᎵᎭ" == ruleUW.process ( null, null, PrefixTableSubject.SG3, PrefixTableObject.SG3IN, Tense.PRESENT, false, "ᎤᏩᏚᎵᎭ", VerbSet.B )
    }
}