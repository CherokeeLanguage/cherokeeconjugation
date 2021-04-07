package cherokee.dictionary


import SyllabaryUtil
import Test

class VRBDideloquasdi2012Test extends GroovyTestCase {
    public void testGawonih() {
        //page iv
        rootProcessorForCompare("jiwoniha", "woni", "h")
        rootProcessorForCompare("hiwoniha", "woni", "h")
        rootProcessorForCompare("gawoniha", "woni", "h")
        rootProcessorForCompare("aniwoniha", "woni", "h")
        rootProcessorForCompare("idiwoniha", "woni", "h")
        rootProcessorForCompare("iniwoniha", "woni", "h")
        rootProcessorForCompare("osdiwoniha", "woni", "h")
        rootProcessorForCompare("ojiwoniha", "woni", "h")
        rootProcessorForCompare("sdiwoniha", "woni", "h")
        rootProcessorForCompare("ijiwoniha", "woni", "h")
    }

    public void testAniwoniha() {
        rootProcessorForCompare("aniwoniha", "woni", "h")
    }

    public void testEga() {
        //page iv
        rootProcessorForCompare("gega", "e", "g")
        rootProcessorForCompare("hega", "e", "g")
        rootProcessorForCompare("ega", "e", "g")
        rootProcessorForCompare("gega", "e", "g")
        rootProcessorForCompare("anega", "e", "g")
        rootProcessorForCompare("idega", "e", "g")
        rootProcessorForCompare("inega", "e", "g")
        rootProcessorForCompare("osdega", "e", "g")
        rootProcessorForCompare("ojega", "e", "g")
        rootProcessorForCompare("sdega", "e", "g")
        rootProcessorForCompare("ijega", "e", "g")
    }

    public void testOli() {
        //page iv
        rootProcessorForCompare("goliga", "oli", "g")
        rootProcessorForCompare("holiga", "oli", "g")
        rootProcessorForCompare("goliga", "oli", "g")
        rootProcessorForCompare("anoliga", "oli", "g")
        rootProcessorForCompare("idoliga", "oli", "g")
        rootProcessorForCompare("inoliga", "oli", "g")
        rootProcessorForCompare("osdoliga", "oli", "g")
        rootProcessorForCompare("ojoliga", "oli", "g")
        rootProcessorForCompare("sdoliga", "oli", "g")
        rootProcessorForCompare("ijoliga", "oli", "g")
    }

    public void atestAgiha2() {
        rootProcessorForCompare("agiha", "h", "")
    }

    public void atestAgiha() {
        //page v
        rootProcessorForCompare("agiha", "h", "")
        rootProcessorForCompare("jaha", "h", "")
        rootProcessorForCompare("uha", "h", "")
        rootProcessorForCompare("uniha", "h", "")
        rootProcessorForCompare("igiha", "h", "")
        rootProcessorForCompare("giniha", "h", "")
        rootProcessorForCompare("oginiha", "h", "")
        rootProcessorForCompare("ogiha", "h", "")
        rootProcessorForCompare("sdiha", "h", "")
        rootProcessorForCompare("ijiha", "h", "")
    }

    public void testElihi() {
        //page v
        rootProcessorForCompare("agwelihia", "elihi", "")
        rootProcessorForCompare("jelihia", "elihi", "")
        rootProcessorForCompare("uwelihia", "elihi", "")
        rootProcessorForCompare("unelihia", "elihi", "")
        rootProcessorForCompare("igelihia", "elihi", "")
        rootProcessorForCompare("ginelihia", "elihi", "")
        rootProcessorForCompare("oginelihia", "elihi", "")
        rootProcessorForCompare("ogelihia", "elihi", "")
        rootProcessorForCompare("sdelihia", "elihi", "")
        rootProcessorForCompare("ijelihia", "elihi", "")
    }

    public void testAgwanvta() {
        rootProcessorForCompare("agwanvta", "anv", "t")
//        rootProcessorForCompare("janvta", "anv", "t")
//        rootProcessorForCompare("unvta", "nv", "t")
        rootProcessorForCompare("unanvta", "anv", "t")
        rootProcessorForCompare("iganvta", "anv", "t")
        rootProcessorForCompare("ginanvta", "anv", "t")
        rootProcessorForCompare("oginanvta", "anv", "t")
        rootProcessorForCompare("oganvta", "anv", "t")
        rootProcessorForCompare("sdanvta", "anv", "t")
        rootProcessorForCompare("ijanvta", "anv", "t")
    }

    public void atestJanvtaUnvta() {
        rootProcessorForCompare("janvta", "anv", "t")
        rootProcessorForCompare("unvta", "nv", "t")
    }

    public void testAgiwonisvi() {
        //vi
        rootProcessorForCompare("agiwonisvi", "woni", "")
        rootProcessorForCompare("jawonisvi", "woni", "")
//        rootProcessorForCompare("uwonisvi", "woni", "")
        rootProcessorForCompare("uniwonisvi", "woni", "")
        rootProcessorForCompare("igiwonisvi", "woni", "")
        rootProcessorForCompare("giniwonisvi", "woni", "")
        rootProcessorForCompare("igiwonisvi", "woni", "")
        rootProcessorForCompare("oginiwonisvi", "woni", "")
        rootProcessorForCompare("ogiwonisvi", "woni", "")
        rootProcessorForCompare("sdiwonisvi", "woni", "")
        rootProcessorForCompare("ijiwonisvi", "woni", "")
    }

    public void atestUwonisvi() {
        rootProcessorForCompare("uwonisvi", "woni", "")
    }

    public void testIgiwonisvi() {
        rootProcessorForCompare("ijiwonisvi", "woni", "")
    }

    public void testJiWonisvi() {
        rootProcessorForCompare("jiwonisvi", "woni", "")
        rootProcessorForCompare("hiwonisvi", "woni", "")
        rootProcessorForCompare("gawonisvi", "woni", "")
        rootProcessorForCompare("aniwonisvi", "woni", "")
        rootProcessorForCompare("idiwonisvi", "woni", "")
        rootProcessorForCompare("iniwonisvi", "woni", "")
        rootProcessorForCompare("osdiwonisvi", "woni", "")
        rootProcessorForCompare("ojiwonisvi", "woni", "")
        rootProcessorForCompare("sdiwonisvi", "woni", "")
        rootProcessorForCompare("ijiwonisvi", "woni", "")
    }

    //plural marker
    public void atestDajiwonisi() {
        rootProcessorForCompare("dajiwonisi", "woni", "")
        rootProcessorForCompare("tiwonisi", "woni", "")
        rootProcessorForCompare("dagawonisi", "woni", "")
        rootProcessorForCompare("dvniwonisi", "woni", "")
        rootProcessorForCompare("dadiwonisi", "woni", "")
        rootProcessorForCompare("daniwonisi", "woni", "")
        rootProcessorForCompare("dayosdiwonisi", "woni", "")
        rootProcessorForCompare("dayojiwonisi", "woni", "")
        rootProcessorForCompare("dasdiwonisi", "woni", "")
        rootProcessorForCompare("dajiwonisi", "woni", "")
    }

    def su = new SyllabaryUtil()

    private void rootProcessorForCompare(original, assertion, ending) {
        original = su.tsalagiToSyllabary(original)
        assertion = su.tsalagiToSyllabary(assertion)+ending
//        ConjugateBase.compareForAssertion(original,assertion)
//        ConjugateBase.processRootForCompare(original, assertion)
    }
}
