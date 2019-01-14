package cherokee.dictionary.prefixes

import cherokee.dictionary.conjugation.conjugate.Tense
import cherokee.dictionary.util.TestUtil

class YiPrefixTest extends GroovyTestCase {
    public void testYiVowel() {
        TestUtil.basicAssertion("agowatiha", Tense.PRESENT, 'ᏯᎪᏩᏘᎭ', {yi = true})
    }

    public void testYiConsonant() {
        TestUtil.basicAssertion("jiwatiha", Tense.PRESENT, 'ᏱᏥᏩᏘᎭ', {yi = true})
    }

    public void testYiandW() {
        TestUtil.basicAssertion("agowatiha", Tense.PRESENT, 'ᏳᏩᎪᏩᏘᎭ', {yi = true; wi = true})
    }

    public void testYmetathesisH() {
        TestUtil.basicAssertion("higowatiha", Tense.PRESENT, 'ᏱᎪᏩᏘᎭ', {yi = true})
    }

    public void testYiNohlaIffy() {
        TestUtil.basicAssertion("gawoniha", Tense.PRESENT, 'ᏱᎦᏬᏂᎭ', {yi = true})
    }
}
