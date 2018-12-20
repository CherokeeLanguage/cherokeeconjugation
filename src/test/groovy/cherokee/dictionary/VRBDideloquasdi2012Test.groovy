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

    public void testSpeaking() {
        rootProcessorForCompare("jiwoniha", "woniha")
        rootProcessorForCompare("jiwonisgoi", "wonisgoi")
        rootProcessorForCompare("jiwonisgvi", "wonisgvi")
        rootProcessorForCompare("jiwonisgesdi", "wonisgesdi")
        rootProcessorForCompare("hiwoniha", "woniha")
        rootProcessorForCompare("hiwonisgoi", "wonisgoi")
        rootProcessorForCompare("hiwonisgvi", "wonisgvi")
        rootProcessorForCompare("hiwonisgesdi", "wonisgesdi")
        rootProcessorForCompare("gawoniha", "woniha")
        rootProcessorForCompare("gawonisgoi", "wonisgoi")
        rootProcessorForCompare("gawonisgvi", "wonisgvi")
        rootProcessorForCompare("gawonisgesdi", "wonisgesdi")
        rootProcessorForCompare("aniwoniha", "woniha")
        rootProcessorForCompare("aniwonisgoi", "wonisgoi")
        rootProcessorForCompare("aniwonisgvi", "wonisgvi")
        rootProcessorForCompare("aniwonisgesdi", "wonisgesdi")
        rootProcessorForCompare("idiwoniha", "woniha")
        rootProcessorForCompare("idiwonisgoi", "wonisgoi")
        rootProcessorForCompare("idiwonisgvi", "wonisgvi")
        rootProcessorForCompare("idiwonisgesdi", "wonisgesdi")
        rootProcessorForCompare("iniwoniha", "woniha")
        rootProcessorForCompare("iniwonisgoi", "wonisgoi")
        rootProcessorForCompare("iniwonisgvi", "wonisgvi")
        rootProcessorForCompare("iniwonisgesdi", "wonisgesdi")
        rootProcessorForCompare("osdiwoniha", "woniha")
        rootProcessorForCompare("osdiwonisgoi", "wonisgoi")
        rootProcessorForCompare("osdiwonisgvi", "wonisgvi")
        rootProcessorForCompare("osdiwonisgesdi", "wonisgesdi")
        rootProcessorForCompare("ojiwoniha", "woniha")
        rootProcessorForCompare("ojiwonisgoi", "wonisgoi")
        rootProcessorForCompare("ojiwonisgvi", "wonisgvi")
        rootProcessorForCompare("ojiwonisgesdi", "wonisgesdi")
        rootProcessorForCompare("sdiwoniha", "woniha")
        rootProcessorForCompare("sdiwonisgoi", "wonisgoi")
        rootProcessorForCompare("sdiwonisgvi", "wonisgvi")
        rootProcessorForCompare("sdiwonisgesdi", "wonisgesdi")
        rootProcessorForCompare("ijiwoniha", "woniha")
        rootProcessorForCompare("ijiwonisgoi", "wonisgoi")
        rootProcessorForCompare("ijiwonisgvi", "wonisgvi")
        rootProcessorForCompare("ijiwonisgesdi", "wonisgesdi")
        rootProcessorForCompare("agiwonisvi", "wonisvi")
//        rootProcessorForCompare("dajiwonisi", "wonisi")
        rootProcessorForCompare("jiwonihi", "wonihi")
        rootProcessorForCompare("agiwonihisdi", "wonihisdi")
        rootProcessorForCompare("jawonisvi", "wonisvi")
//        rootProcessorForCompare("tiwonisi", "wonisi")
        rootProcessorForCompare("hiwonihi", "wonihi")
        rootProcessorForCompare("jawonihisdi", "wonihisdi")
//        rootProcessorForCompare("uwonisvi", "wonisvi")
//        rootProcessorForCompare("dagawonisi", "wonisi")
        rootProcessorForCompare("gawonihi", "wonihi")
//        rootProcessorForCompare("uwonihisdi", "wonihisdi")
//        rootProcessorForCompare("uniwonisvi", "wonisvi")
//        rootProcessorForCompare("dvniwonisi", "wonisi")
        rootProcessorForCompare("aniwonihi", "wonihi")
//        rootProcessorForCompare("uniwonihisdi", "wonihisdi")
        rootProcessorForCompare("igiwonisvi", "wonisvi")
//        rootProcessorForCompare("dadiwonisi", "wonisi")
        rootProcessorForCompare("idiwonihi", "wonihi")
        rootProcessorForCompare("igiwonihisdi", "wonihisdi")
        rootProcessorForCompare("giniwonisvi", "wonisvi")
//        rootProcessorForCompare("daniwonisi", "wonisi")
        rootProcessorForCompare("iniwonihi", "wonihi")
        rootProcessorForCompare("giniwonihisdi", "wonihisdi")
        rootProcessorForCompare("oginiwonisvi", "wonisvi")
//        rootProcessorForCompare("dayosdiwonisi", "wonisi")
        rootProcessorForCompare("osdiwonihi", "wonihi")
        rootProcessorForCompare("oginiwonihisdi", "wonihisdi")
        rootProcessorForCompare("ogiwonisvi", "wonisvi")
//        rootProcessorForCompare("dayojiwonisi", "wonisi")
        rootProcessorForCompare("ojiwonihi", "wonihi")
        rootProcessorForCompare("ogiwonihisdi", "wonihisdi")
        rootProcessorForCompare("sdiwonisvi", "wonisvi")
//        rootProcessorForCompare("dasdiwonisi", "wonisi")
        rootProcessorForCompare("sdiwonihi", "wonihi")
        rootProcessorForCompare("sdiwonihisdi", "wonihisdi")
        rootProcessorForCompare("ijiwonisvi", "wonisvi")
//        rootProcessorForCompare("dajiwonisi", "wonisi")
        rootProcessorForCompare("ijiwonihi", "wonihi")
        rootProcessorForCompare("ijiwonihisdi", "wonihisdi")
    }

    public void testAgwaduliha() {
        rootProcessorForCompare("agwaduliha", "aduliha")
        rootProcessorForCompare("agwadulihoi", "adulihoi")
        rootProcessorForCompare("agwadulihvi", "adulihvi")
        rootProcessorForCompare("agwadulia", "adulia")
        rootProcessorForCompare("agwadulidi", "adulidi")
        rootProcessorForCompare("jaduliha", "duliha")
        rootProcessorForCompare("jadulihoi", "dulihoi")
        rootProcessorForCompare("jadulihvi", "dulihvi")
        rootProcessorForCompare("jadulia", "dulia")
        rootProcessorForCompare("jadulidi", "dulidi")
//        rootProcessorForCompare("uduliha", "duliha")
//        rootProcessorForCompare("udulihoi", "dulihoi")
//        rootProcessorForCompare("udulihvi", "dulihvi")
//        rootProcessorForCompare("udulia", "dulia")
//        rootProcessorForCompare("udulidi", "dulidi")
//        rootProcessorForCompare("unaduliha", "aduliha")
//        rootProcessorForCompare("unadulihoi", "dulihoi")
//        rootProcessorForCompare("unadulihvi", "dulihvi")
//        rootProcessorForCompare("unadulia", "dulia")
//        rootProcessorForCompare("unadulidi", "dulidi")
        rootProcessorForCompare("igaduliha", "aduliha")
        rootProcessorForCompare("igadulihoi", "adulihoi")
        rootProcessorForCompare("igadulihvi", "adulihvi")
        rootProcessorForCompare("igadulia", "adulia")
        rootProcessorForCompare("igadulidi", "adulidi")
    }

    public void testGenerator() {
//        def f = new File("/Volumes/Zeus/projects/wholecedproject/cherokeeconjugation/src/test/groovy/cherokee/dictionary/VRB.txt").readLines()
        def f = """"""
        def indexed = "duli"
        f.eachLine {
            if (it.startsWith("#") || it.trim() == "") {

            } else {
                def split = it.split(" ")
                if (split.size() < 5) {

                } else {
                    def first = split[0].replaceAll("’", "")
                    def second = split[1].replaceAll("’", "")
                    def third = split[2].replaceAll("’", "")
                    def fourth = split[3].replaceAll("’", "")
                    def fifth = split[4].replaceAll("’", "")
                    println "rootProcessorForCompare(\"${first}\", \"${first.substring(first.indexOf(indexed))}\")"
                    println "rootProcessorForCompare(\"${second}\", \"${second.substring(second.indexOf(indexed))}\")"
                    println "rootProcessorForCompare(\"${third}\", \"${third.substring(third.indexOf(indexed))}\")"
                    println "rootProcessorForCompare(\"${fourth}\", \"${fourth.substring(fourth.indexOf(indexed))}\")"
                    println "rootProcessorForCompare(\"${fifth}\", \"${fifth.substring(fifth.indexOf(indexed))}\")"
                }
            }
        }
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
