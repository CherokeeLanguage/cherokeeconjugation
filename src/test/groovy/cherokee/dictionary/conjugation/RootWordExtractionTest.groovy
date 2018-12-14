package cherokee.dictionary.conjugation

import cherokee.dictionary.conjugation.affixes.processors.FinalSuffixProcessor
import cherokee.dictionary.conjugation.affixes.processors.PrefixProcessor
import com.cobradoc.cherokee.SyllabaryUtil

class RootWordExtractionTest extends GroovyTestCase {
    //finalSuffix and pronounPrefix only
    public void testRootExtraction() {
        rootProcessorForCompare("ᏥᎪᏩᏘᎭ", "ᎪᏩᏘh")
        rootProcessorForCompare("ᎠᎪᏩᏘᎭ", "ᎪᏩᏘh")
        rootProcessorForCompare("ᎯᎪᏩᏘᎭ", "ᎪᏩᏘh")
        rootProcessorForCompare("ᏥᎪᏩᏘᎭ", "ᎪᏩᏘh")
        rootProcessorForCompare("ᎠᎪᏩᏘᎭ", "ᎪᏩᏘh")
        rootProcessorForCompare("ᎯᎪᏩᏘᎭ", "ᎪᏩᏘh")
        rootProcessorForCompare("ᏥᎪᏩᏘᎭ", "ᎪᏩᏘh")
        rootProcessorForCompare("ᎠᎪᏩᏘᎭ", "ᎪᏩᏘh")
        rootProcessorForCompare("ᎯᎪᏩᏘᎭ", "ᎪᏩᏘh")
        rootProcessorForCompare("ᏥᎪᏩᏘᎭ", "ᎪᏩᏘh")
        rootProcessorForCompare("ᎠᎪᏩᏘᎭ", "ᎪᏩᏘh")
        rootProcessorForCompare("ᎯᎪᏩᏘᎭ", "ᎪᏩᏘh")
        rootProcessorForCompare("ᏥᎪᏩᏘᎭ", "ᎪᏩᏘh")
        rootProcessorForCompare("ᎠᎪᏩᏘᎭ", "ᎪᏩᏘh")
        rootProcessorForCompare("ᎯᎪᏩᏘᎭ", "ᎪᏩᏘh")
        rootProcessorForCompare("ᏥᎪᏩᏘᎭ", "ᎪᏩᏘh")
        rootProcessorForCompare("ᎠᎪᏩᏘᎭ", "ᎪᏩᏘh")
        rootProcessorForCompare("ᎯᎪᏩᏘᎭ", "ᎪᏩᏘh")
        rootProcessorForCompare("ᎦᏔᏍᎩᎠ", "ᎠᏔᏍᎩ")
        rootProcessorForCompare("ᎭᏔᏍᎩ", "ᎠᏔᏍᎩ")
        rootProcessorForCompare("ᎤᏔᏍᎩᏒᎢ", "ᏔᏍᎩ")
        rootProcessorForCompare("ᎦᏔᏍᎩᎠ", "ᎠᏔᏍᎩ")
        rootProcessorForCompare("ᎦᏔᏍᎩᎠ", "ᎠᏔᏍᎩ")
        rootProcessorForCompare("ᎦᏔᏍᎩᎠ", "ᎠᏔᏍᎩ")
        rootProcessorForCompare("ᎦᏔᏍᎩᎠ", "ᎠᏔᏍᎩ")
        rootProcessorForCompare("ᏥᎪᏩᏘᎭ", "ᎪᏩᏘh")
        rootProcessorForCompare("ᎦᏔᏍᎩᎠ", "ᎠᏔᏍᎩ")
        rootProcessorForCompare("ᏥᎪᏩᏘᎭ", "ᎪᏩᏘh")
        rootProcessorForCompare("ᎦᏔᏍᎩᎠ", "ᎠᏔᏍᎩ")
        rootProcessorForCompare("ᏥᎪᏩᏘᎭ", "ᎪᏩᏘh")
        rootProcessorForCompare("ᎦᏔᏍᎩᎠ", "ᎠᏔᏍᎩ")
        rootProcessorForCompare("ᎦᏔᏍᎩᎠ", "ᎠᏔᏍᎩ")
        rootProcessorForCompare("ᏍᏗᎪᏩᏘᎭ", "ᎪᏩᏘh")
        rootProcessorForCompare("ᏍᏗᎪᏩᏘ", "ᎪᏩᏘ")
        rootProcessorForCompare("ᏍᏗᎪᏩᏘᎭ", "ᎪᏩᏘh")
        rootProcessorForCompare("ᏍᏗᎪᏩᏘ", "ᎪᏩᏘ")
        rootProcessorForCompare("ᏍᏗᎪᏩᏘᎭ", "ᎪᏩᏘh")
        rootProcessorForCompare("ᏍᏗᎪᏩᏘ", "ᎪᏩᏘ")

        //first person present -- bleed -- rrd
        rootProcessorForCompare("ᎦᏔᏍᎩᎠ", "ᎠᏔᏍᎩ")

        //third person present -- bleed -- rrd
        rootProcessorForCompare("ᎠᏔᏍᎩᎠ", "ᎠᏔᏍᎩ")
    }

    public void testSdigowa() {
        rootProcessorForCompare("ᏍᏗᎪᏩᏘ", "ᎪᏩᏘ")
    }

    public void testAgowatiha() {
        rootProcessorForCompare("ᎠᎪᏩᏘᎭ", "ᎪᏩᏘh")
    }

    private void rootProcessorForCompare(original, assertion) {
        HolderWord hw = new HolderWord()
        def su = new SyllabaryUtil()
        hw.syllabary = original
        FinalSuffixProcessor.removeFinalSuffix(hw)
        PrefixProcessor.removeAllPrefixes(hw)
        def syllabary = hw.syllabary
        def nonFinalSuffix = hw.nonfinalEndingLatin
        def finalEndingLatin = hw.finalEndingLatin
        def prefixLatin = hw.pho.pronounPrefixLatin

        def sb = new StringBuilder()

        if (prefixLatin && prefixLatin != 'null') {
            sb << prefixLatin
        }

        sb << su.parseSyllabary(syllabary)

        if (nonFinalSuffix && finalEndingLatin) {
            sb << nonFinalSuffix
            sb << finalEndingLatin
        } else if (finalEndingLatin) {
            sb << finalEndingLatin
        }


        println hw.syllabary + nonFinalSuffix +  " " + assertion
        assertEquals("original did not match converted", original, su.tsalagiToSyllabary(sb.toString()))
    }
}
