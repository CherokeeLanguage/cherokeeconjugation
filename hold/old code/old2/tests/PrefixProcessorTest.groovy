package cherokee.dictionary.conjugation

import PrefixProcessor
import Stemmer
import DefinitionLine
import StemType
import SyllabaryUtil

class PrefixProcessorTest extends GroovyTestCase {
    static def DNM = "FAILURE DID NOT MATCH"

    public void testCompoundPrefixes() {
        prefixProcessorForCompare("ᏥᎪᏩᏘᎭ", "ᎪᏩᏘᎭ")
        prefixProcessorForCompare("ᎠᎪᏩᏘᎭ", "ᎪᏩᏘᎭ")
        prefixProcessorForCompare("ᎯᎪᏩᏘᎭ", "ᎪᏩᏘᎭ")
        prefixProcessorForCompare("ᏥᎪᏩᏘᎭ", "ᎪᏩᏘᎭ")
        prefixProcessorForCompare("ᎠᎪᏩᏘᎭ", "ᎪᏩᏘᎭ")
        prefixProcessorForCompare("ᎯᎪᏩᏘᎭ", "ᎪᏩᏘᎭ")
        prefixProcessorForCompare("ᏥᎪᏩᏘᎭ", "ᎪᏩᏘᎭ")
        prefixProcessorForCompare("ᎠᎪᏩᏘᎭ", "ᎪᏩᏘᎭ")
        prefixProcessorForCompare("ᎯᎪᏩᏘᎭ", "ᎪᏩᏘᎭ")
        prefixProcessorForCompare("ᏥᎪᏩᏘᎭ", "ᎪᏩᏘᎭ")
        prefixProcessorForCompare("ᎠᎪᏩᏘᎭ", "ᎪᏩᏘᎭ")
        prefixProcessorForCompare("ᎯᎪᏩᏘᎭ", "ᎪᏩᏘᎭ")
        prefixProcessorForCompare("ᏥᎪᏩᏘᎭ", "ᎪᏩᏘᎭ")
        prefixProcessorForCompare("ᎠᎪᏩᏘᎭ", "ᎪᏩᏘᎭ")
        prefixProcessorForCompare("ᎯᎪᏩᏘᎭ", "ᎪᏩᏘᎭ")
        prefixProcessorForCompare("ᏥᎪᏩᏘᎭ", "ᎪᏩᏘᎭ")
        prefixProcessorForCompare("ᎠᎪᏩᏘᎭ", "ᎪᏩᏘᎭ")
        prefixProcessorForCompare("ᎯᎪᏩᏘᎭ", "ᎪᏩᏘᎭ")
        prefixProcessorForCompare("ᎦᏔᏍᎩᎠ", "ᎠᏔᏍᎩᎠ")
        //TODO: FAILS ON HA EVERY TIME!!!!!
//        prefixProcessorForCompare("ᎭᏔᏍᎩ", "ᎠᏔᏍᎩ")
        prefixProcessorForCompare("ᎤᏔᏍᎩᏒᎢ", "ᏔᏍᎩᏒᎢ")
        prefixProcessorForCompare("ᎦᏔᏍᎩᎠ", "ᎠᏔᏍᎩᎠ")
        prefixProcessorForCompare("ᎦᏔᏍᎩᎠ", "ᎠᏔᏍᎩᎠ")
        prefixProcessorForCompare("ᎦᏔᏍᎩᎠ", "ᎠᏔᏍᎩᎠ")
        prefixProcessorForCompare("ᎦᏔᏍᎩᎠ", "ᎠᏔᏍᎩᎠ")
        prefixProcessorForCompare("ᏥᎪᏩᏘᎭ", "ᎪᏩᏘᎭ")
        prefixProcessorForCompare("ᎦᏔᏍᎩᎠ", "ᎠᏔᏍᎩᎠ")
        prefixProcessorForCompare("ᏥᎪᏩᏘᎭ", "ᎪᏩᏘᎭ")
        prefixProcessorForCompare("ᎦᏔᏍᎩᎠ", "ᎠᏔᏍᎩᎠ")
        prefixProcessorForCompare("ᏥᎪᏩᏘᎭ", "ᎪᏩᏘᎭ")
        prefixProcessorForCompare("ᎦᏔᏍᎩᎠ", "ᎠᏔᏍᎩᎠ")
        prefixProcessorForCompare("ᎦᏔᏍᎩᎠ", "ᎠᏔᏍᎩᎠ")
        prefixProcessorForCompare("ᏍᏗᎪᏩᏘᎭ", "ᎪᏩᏘᎭ")
        prefixProcessorForCompare("ᏍᏗᎪᏩᏘ", "ᎪᏩᏘ")
        prefixProcessorForCompare("ᏍᏗᎪᏩᏘᎭ", "ᎪᏩᏘᎭ")
        prefixProcessorForCompare("ᏍᏗᎪᏩᏘ", "ᎪᏩᏘ")
        prefixProcessorForCompare("ᏍᏗᎪᏩᏘᎭ", "ᎪᏩᏘᎭ")
        prefixProcessorForCompare("ᏍᏗᎪᏩᏘ", "ᎪᏩᏘ")

        //first person present -- bleed -- rrd
        prefixProcessorForCompare("ᎦᏔᏍᎩᎠ", "ᎠᏔᏍᎩᎠ")

        //third person present -- bleed -- rrd
        prefixProcessorForCompare("ᎠᏔᏍᎩᎠ", "ᏔᏍᎩᎠ")
    }

    public void testFinal() {
        def su = new SyllabaryUtil()

        Stemmer st = new Stemmer()
        DefinitionLine dl = new DefinitionLine()
        dl.syllabary = su.tsalagiToSyllabary("jiwoniha")
        st.present1st = dl
        println st.getStem(StemType.PresentContinous)
    }

    private static String prefixProcessorForCompare(String original, String assertion) {
        HolderWord hw = new HolderWord()
        hw.syllabary = original
        PrefixProcessor.removeAllPrefixes(hw)
        if (hw.pho.pronounPrefixSyllabary) {
            junit.framework.TestCase.assertEquals(DNM, original, "${hw.pho.pronounPrefixSyllabary}${assertion}")
        } else if (hw.pho.pronounPrefixLatin) {
            def su = new SyllabaryUtil()
            def tmp = su.parseSyllabary(assertion)
            //this shows that if we took the latin prefix - possibly a single letter and added the root we just found
            //we'd get the original word
//            tmp = hw.pho.pronounPrefixLatin + tmp
//            println su.tsalagiToSyllabary(tmp)
            groovy.util.GroovyTestCase.assertEquals(DNM, su.tsalagiToSyllabary(tmp), "${hw.pho.pronounPrefixSyllabary}${assertion}")
        }
    }
}
