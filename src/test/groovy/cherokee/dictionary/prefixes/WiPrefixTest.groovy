package cherokee.dictionary.prefixes

import cherokee.dictionary.conjugation.conjugate.Tense
import cherokee.dictionary.util.TestUtil

class WiPrefixTest extends GroovyTestCase {
    //cf 25-26 CED
    public void testNormalWi() {
        TestUtil.basicAssertion("agowatiha", Tense.PRESENT, 'ᏩᎪᏩᏘᎭ', {wi = true})
        TestUtil.basicAssertion("jadega", Tense.PRESENT, 'ᏫᏣᏕᎦ', {wi = true})
    }

    //cf 27 CED
    public void testPrecedeH() {
        TestUtil.basicAssertion("higowatiha", Tense.PRESENT, 'ᏫᎪᏩᏘᎭ', {wi = true})
    }

    //cf 28 CED
    public void testOptionalDeletionOfWAfterY() {
        //also acceptable is ᏳᎦᏬᏂᎭ - where yu tells us that wi- was there but yi- would mean that no w- would've been present
        TestUtil.basicAssertion("gawoniha", Tense.PRESENT, 'ᏳᏫᎦᏬᏂᎭ', {wi = true; yi = true})
    }

    //cf29-30 CED
    public void testMotion() {
        TestUtil.basicAssertion("uwohla", Tense.PRESENT, 'ᏭᏬᏝ', {wi = true})
        TestUtil.basicAssertion("ai", Tense.PRESENT, 'ᏩᎢ', {wi = true})
    }

    //cf31 CED
    public void testNonSecondPersonLet() {
        TestUtil.basicAssertion("jiwonihi", Tense.PRESENT, 'ᏫᏥᏬᏂᎯ', {wi = true})
    }

    //cf32 CED
    public void testSecondPersonImperative() {
        TestUtil.basicAssertion("hiwonihi", Tense.FUTURE_COMMAND, 'ᏫᏬᏂᎯ', {wi = true})
    }

    //cf 33 CED
    public void testSubjectNotInSightDistance() {
        TestUtil.basicAssertion("dulvwisdanehoi", Tense.PRESENT, 'ᏫᏚᎸᏫᏍᏓᏁᎰᎢ', {wi = true})
    }

    //cf34-35 CED
    public void testDativeBenefactiveSuffix() {
        TestUtil.basicAssertion("gowelaneha", Tense.PRESENT, 'ᏫᏗᎪᏪᎳᏁᎭ', {wi = true; de = true})
    }
}
