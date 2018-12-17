package cherokee.dictionary

import cherokee.dictionary.conjugation.wordFormation.PronounProcessor
import cherokee.dictionary.conjugation.wordFormation.Word
import com.cobradoc.cherokee.SyllabaryUtil

class VRBDideloquasdi2012Test extends GroovyTestCase {
    def su = new SyllabaryUtil()

    public void testGawonih() {
        //page iv
        rootProcessorForCompare("jiwoniha", "woniha")
        rootProcessorForCompare("hiwoniha", "woniha")
        rootProcessorForCompare("gawoniha", "woniha")
        rootProcessorForCompare("aniwoniha", "woniha")
        rootProcessorForCompare("idiwoniha", "woniha")
        rootProcessorForCompare("iniwoniha", "woniha")
        rootProcessorForCompare("osdiwoniha", "woniha")
        rootProcessorForCompare("ojiwoniha", "woniha")
        rootProcessorForCompare("sdiwoniha", "woniha")
        rootProcessorForCompare("ijiwoniha", "woniha")
    }

    public void testAniwoniha() {
        rootProcessorForCompare("aniwoniha", "woniha")
    }

    public void testEga() {
        //page iv
//        rootProcessorForCompare("gega", "ega")
        rootProcessorForCompare("hega", "ega")
        rootProcessorForCompare("ega", "ega")
//        rootProcessorForCompare("gega", "ega")
        rootProcessorForCompare("anega", "ega")
        rootProcessorForCompare("idega", "ega")
        rootProcessorForCompare("inega", "ega")
        rootProcessorForCompare("osdega", "ega")
        rootProcessorForCompare("ojega", "ega")
        rootProcessorForCompare("sdega", "ega")
        rootProcessorForCompare("ijega", "ega")
    }

    public void testOli() {
        //page iv
        rootProcessorForCompare("goliga", "oliga")
        rootProcessorForCompare("holiga", "oliga")
        rootProcessorForCompare("goliga", "oliga")
        rootProcessorForCompare("anoliga", "oliga")
        rootProcessorForCompare("idoliga", "oliga")
        rootProcessorForCompare("inoliga", "oliga")
        rootProcessorForCompare("osdoliga", "oliga")
        rootProcessorForCompare("ojoliga", "oliga")
        rootProcessorForCompare("sdoliga", "oliga")
        rootProcessorForCompare("ijoliga", "oliga")
    }

    public void testAgiha() {
        //page v
        rootProcessorForCompare("agiha", "ha")
        rootProcessorForCompare("jaha", "ha")
//        rootProcessorForCompare("uha", "ha")
//        rootProcessorForCompare("uniha", "ha")
        rootProcessorForCompare("igiha", "ha")
        rootProcessorForCompare("giniha", "ha")
        rootProcessorForCompare("oginiha", "ha")
        rootProcessorForCompare("ogiha", "ha")
        rootProcessorForCompare("sdiha", "ha")
        rootProcessorForCompare("ijiha", "ha")
    }

    public void testElihi() {
        //page v
        rootProcessorForCompare("agwelihia", "elihia")
        rootProcessorForCompare("jelihia", "elihia")
//        rootProcessorForCompare("uwelihia", "elihia")
//        rootProcessorForCompare("unelihia", "elihia")
        rootProcessorForCompare("igelihia", "elihia")
        rootProcessorForCompare("ginelihia", "elihia")
        rootProcessorForCompare("oginelihia", "elihia")
        rootProcessorForCompare("ogelihia", "elihia")
        rootProcessorForCompare("sdelihia", "elihia")
        rootProcessorForCompare("ijelihia", "elihia")
    }

    public void testAgwanvta() {
        rootProcessorForCompare("agwanvta", "anvta")
//        rootProcessorForCompare("janvta", "anvta")
        rootProcessorForCompare("unvta", "anvta")
//        rootProcessorForCompare("unanvta", "anvta")
        rootProcessorForCompare("iganvta", "anvta")
        rootProcessorForCompare("ginanvta", "anvta")
        rootProcessorForCompare("oginanvta", "anvta")
        rootProcessorForCompare("oganvta", "anvta")
        rootProcessorForCompare("sdanvta", "anvta")
        rootProcessorForCompare("ijanvta", "anvta")
    }

    public void testAgiwonisvi() {
        //vi
        rootProcessorForCompare("agiwonisvi", "wonisvi")
        rootProcessorForCompare("jawonisvi", "wonisvi")
//        rootProcessorForCompare("uwonisvi", "wonisvi")
//        rootProcessorForCompare("uniwonisvi", "wonisvi")
        rootProcessorForCompare("igiwonisvi", "wonisvi")
        rootProcessorForCompare("giniwonisvi", "wonisvi")
        rootProcessorForCompare("igiwonisvi", "wonisvi")
        rootProcessorForCompare("oginiwonisvi", "wonisvi")
        rootProcessorForCompare("ogiwonisvi", "wonisvi")
        rootProcessorForCompare("sdiwonisvi", "wonisvi")
        rootProcessorForCompare("ijiwonisvi", "wonisvi")
    }

    public void atestFailures() {
        rootProcessorForCompare("uwonisvi", "wonisvi")
        rootProcessorForCompare("unanvta", "anvta")
        rootProcessorForCompare("janvta", "anvta")
        rootProcessorForCompare("unvta", "anvta")
        rootProcessorForCompare("gega", "ega")
        rootProcessorForCompare("gega", "ega")
        rootProcessorForCompare("uwelihia", "elihia")
        rootProcessorForCompare("uniwonisvi", "wonisvi")
        rootProcessorForCompare("unelihia", "elihia")
        rootProcessorForCompare("uha", "ha")
        rootProcessorForCompare("uniha", "ha")
        rootProcessorForCompare("uwonisvi", "wonisvi")
    }

    public void testIgiwonisvi() {
        rootProcessorForCompare("ijiwonisvi", "wonisvi")
    }

    public void testJiWonisvi() {
        rootProcessorForCompare("jiwonisvi", "wonisvi")
        rootProcessorForCompare("hiwonisvi", "wonisvi")
        rootProcessorForCompare("gawonisvi", "wonisvi")
        rootProcessorForCompare("aniwonisvi", "wonisvi")
        rootProcessorForCompare("idiwonisvi", "wonisvi")
        rootProcessorForCompare("iniwonisvi", "wonisvi")
        rootProcessorForCompare("osdiwonisvi", "wonisvi")
        rootProcessorForCompare("ojiwonisvi", "wonisvi")
        rootProcessorForCompare("sdiwonisvi", "wonisvi")
        rootProcessorForCompare("ijiwonisvi", "wonisvi")
    }

    //plural marker
    public void atestDajiwonisi() {
        rootProcessorForCompare("dajiwonisi", "wonisi")
        rootProcessorForCompare("tiwonisi", "wonisi")
        rootProcessorForCompare("dagawonisi", "wonisi")
        rootProcessorForCompare("dvniwonisi", "wonisi")
        rootProcessorForCompare("dadiwonisi", "wonisi")
        rootProcessorForCompare("daniwonisi", "wonisi")
        rootProcessorForCompare("dayosdiwonisi", "wonisi")
        rootProcessorForCompare("dayojiwonisi", "wonisi")
        rootProcessorForCompare("dasdiwonisi", "wonisi")
        rootProcessorForCompare("dajiwonisi", "wonisi")
    }

    private void rootProcessorForCompare(original, assertion) {
        original = su.tsalagiToSyllabary(original)
        assertion = su.tsalagiToSyllabary(assertion)

        Word word = new Word()
        PronounProcessor.removePronounPrefix(word, original)
        assertTrue(word.rootSyllabary == assertion)
//        ConjugateBase.compareForAssertion(original,assertion)
//        ConjugateBase.processRootForCompare(original, assertion)
    }
}
