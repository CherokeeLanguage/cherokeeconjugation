package cherokee.dictionary.prefixes

import cherokee.dictionary.conjugation.conjugate.PartOfSpeech
import cherokee.dictionary.conjugation.conjugate.Tense
import cherokee.dictionary.conjugation.processors.VerbPrefixFactory
import cherokee.dictionary.conjugation.wordFormation.Word
import cherokee.dictionary.util.TestUtil
import com.cobradoc.cherokee.SyllabaryUtil

//all examples from CED grammar section
class DePrefixTest extends GroovyTestCase {
    //de- consonants d- vowels except -i-
    public void testNormal() {
        TestUtil.basicAssertion("jigowatiha", Tense.PRESENT, 'ᏕᏥᎪᏩᏘᎭ', {de = true})
        TestUtil.basicAssertion("agowatiha", Tense.PRESENT, 'ᏓᎪᏩᏘᎭ', {de = true})
    }

    //de- + -i- = de-
    public void testDeFollowedByI() {
        TestUtil.basicAssertion("inigowatiha", Tense.PRESENT, 'ᏕᏂᎪᏩᏘᎭ', {de = true})
    }

    //after y-, w-, n- de = di unless followed by a vowel
    public void testDeAfterYWNBeforeConsonant() {
        TestUtil.basicAssertion("jigowatiha", Tense.PRESENT, 'ᏱᏗᏥᎪᏩᏘᎭ', {de = true; yi = true})
        TestUtil.basicAssertion("sdigowatiha", Tense.PRESENT, 'ᏫᏗᏍᏗᎪᏩᏘᎭ', {de = true; wi = true})
        TestUtil.basicAssertion("sdigowatiha", Tense.PRESENT, 'ᏂᏗᏍᏗᎪᏩᏘᎭ', {de = true; ni = true})
        TestUtil.basicAssertion("ijigowatisgvi", Tense.REMOTE_PAST, 'ᏫᏕᏥᎪᏩᏘᏍᎬᎢ', {de = true; wi = true})
    }

    public void testInfinitiveImperative() {
        TestUtil.basicAssertion("sdigowatvdi", Tense.INFINITIVE, 'ᏗᏍᏗᎪᏩᏛᏗ', {de = true})
        TestUtil.basicAssertion("jaduga", Tense.FUTURE_COMMAND, 'ᏗᏣᏚᎦ', {de = true})
    }

    public void testDtoJ() {
        TestUtil.basicAssertion("ugowatvdi", Tense.INFINITIVE, 'ᏧᎪᏩᏛᏗ', {de = true})
        TestUtil.basicAssertion("enadinvsi", Tense.INFINITIVE, 'ᏤᎾᏗᏅᏏ', {de = true})
        TestUtil.basicAssertion("agigowatvdi", Tense.INFINITIVE, 'ᏗᎩᎪᏩᏛᏗ', {de = true})
    }

    //cf61 ced
    public void testDetoDibeforeHtoTi() {
        TestUtil.basicAssertion("higowatiha", Tense.PRESENT, 'ᏫᏘᎪᏩᏘᎭ', {wi = true; de = true})
    }

    public void testDetoDobeforeDa() {
        TestUtil.basicAssertion("jigoi", Tense.PRESENT, 'ᏙᏓᏥᎪᎢ', {da = true; de = true})
        TestUtil.basicAssertion("atli", Tense.PRESENT, 'ᏙᏛᏟ', {da = true; de =true})
    }

    public void testInanimateDiDo() {
        TestUtil.basicAssertion("gowatiha", Tense.PRESENT, 'ᏙᏗᎪᏩᏘᎭ', {de = true; di = true})
    }

    public void testInanimateDe() {
        TestUtil.basicAssertion("jigowatiha", Tense.PRESENT, 'ᏕᏥᎪᏩᏘᎭ', {de = true})
    }

    public void testInanimateDeGa() {
        TestUtil.basicAssertion("jiyalviha", Tense.PRESENT, 'ᏕᎦᏥᏯᎸᎢᎭ', {de = true; ga = true})
    }

    public void testInanimateDePlural() {
        TestUtil.basicAssertion("uniyosiha", Tense.PRESENT, 'ᏚᏂᏲᏏᎭ', {de = true})
    }
}
