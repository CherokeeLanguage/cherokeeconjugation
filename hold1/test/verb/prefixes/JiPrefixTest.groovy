package cherokee.dictionary.verb.prefixes

import cherokee.dictionary.hold.conjugate.Tense
import cherokee.dictionary.verb.util.TestUtil
import com.cobradoc.cherokee.SyllabaryUtil

class JiPrefixTest extends GroovyTestCase {
    public void testJbeforeVowel() {
        TestUtil.basicAssertion("uwohla", Tense.PRESENT, 'ᏧᏬᏝ', {ji = true})
    }

    public void testJbeforeConsonant() {
        TestUtil.basicAssertion("gawoniha", Tense.PRESENT, 'ᏥᎦᏬᏂᎭ', {ji = true})
    }

    public void testRelativeClause() {
        TestUtil.basicAssertion("jigawoniha", Tense.PRESENT, 'ᏥᏥᎦᏬᏂᎭ', {ji = true})
    }

    public void testNegative() {
        //todo: this should actually be nigawonisgvna jigi but the suffixes aren't complete
        TestUtil.basicAssertion("gawoniha", Tense.PRESENT, 'ᏂᎦᏬᏂᎭᎾ ᏥᎩ', {ji = true; yi = true})
    }

    public void testNegativeGa() {
        TestUtil.basicAssertion("awagohvi", Tense.REMOTE_PAST, 'ᎬᏩᎪᎲᎢ ᏥᎩ', {ji = true; ga = true})
    }

    public void testPastTime() {
        TestUtil.basicAssertion("uwonisvi", Tense.REMOTE_PAST, 'ᏧᏬᏂᏒᎢ', {ji = true})
    }

    //cf 18-19 CED
    public void testEiReportativePastTense() {
        TestUtil.basicAssertion("udvnelei", Tense.REMOTE_PAST, new SyllabaryUtil().tsalagiToSyllabary('udvnelei'), {ji = true})
        TestUtil.basicAssertion("uwonisei", Tense.REMOTE_PAST, new SyllabaryUtil().tsalagiToSyllabary('uwonisei'), {ji = true})
    }

    //cf20-21 ced -- also requires de and suffixes
    public void testNegativeImperative() {
//        TestUtil.basicAssertion("envniga", Tense.FUTURE_COMMAND, 'ᏤᏅᏂᎵ', {ji = true; de = true})
//        TestUtil.basicAssertion("dijaduga", Tense.FUTURE_COMMAND, 'ᏥᏙᏣᏕᏏ', {ji = true; de = true})
    }

    public void testAgainImperative() {
        TestUtil.basicAssertion("envniga", Tense.REMOTE_PAST, 'ᏤᏅᏂᎦ', {ji = true})
        TestUtil.basicAssertion("jaduga", Tense.REMOTE_PAST, 'ᏥᏣᏚᎦ', {ji = true})
    }
}
