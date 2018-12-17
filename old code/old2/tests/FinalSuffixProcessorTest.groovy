package cherokee.dictionary.conjugation

import FinalSuffixProcessor

class FinalSuffixProcessorTest extends GroovyTestCase {
    static def DNM = "FAILURE DID NOT MATCH"

    public void testPresentRemoval() {
        junit.framework.TestCase.assertEquals(DNM, "ᏥᎪᏩᏘh", finalSuffixProcessorForCompare(FinalSuffixProcessor.removeFinalSuffix("ᏥᎪᏩᏘᎭ")))
        junit.framework.TestCase.assertEquals(DNM, "ᎠᎪᏩᏘh", finalSuffixProcessorForCompare(FinalSuffixProcessor.removeFinalSuffix("ᎠᎪᏩᏘᎭ")))
        junit.framework.TestCase.assertEquals(DNM, "ᎯᎪᏩᏘh", finalSuffixProcessorForCompare(FinalSuffixProcessor.removeFinalSuffix("ᎯᎪᏩᏘᎭ")))
        junit.framework.TestCase.assertEquals(DNM, "ᏥᎪᏩᏘh", finalSuffixProcessorForCompare(FinalSuffixProcessor.removeFinalSuffix("ᏥᎪᏩᏘᎭ")))
        junit.framework.TestCase.assertEquals(DNM, "ᎠᎪᏩᏘh", finalSuffixProcessorForCompare(FinalSuffixProcessor.removeFinalSuffix("ᎠᎪᏩᏘᎭ")))
        junit.framework.TestCase.assertEquals(DNM, "ᎯᎪᏩᏘh", finalSuffixProcessorForCompare(FinalSuffixProcessor.removeFinalSuffix("ᎯᎪᏩᏘᎭ")))
        junit.framework.TestCase.assertEquals(DNM, "ᏥᎪᏩᏘh", finalSuffixProcessorForCompare(FinalSuffixProcessor.removeFinalSuffix("ᏥᎪᏩᏘᎭ")))
        junit.framework.TestCase.assertEquals(DNM, "ᎠᎪᏩᏘh", finalSuffixProcessorForCompare(FinalSuffixProcessor.removeFinalSuffix("ᎠᎪᏩᏘᎭ")))
        junit.framework.TestCase.assertEquals(DNM, "ᎯᎪᏩᏘh", finalSuffixProcessorForCompare(FinalSuffixProcessor.removeFinalSuffix("ᎯᎪᏩᏘᎭ")))
        junit.framework.TestCase.assertEquals(DNM, "ᏥᎪᏩᏘh", finalSuffixProcessorForCompare(FinalSuffixProcessor.removeFinalSuffix("ᏥᎪᏩᏘᎭ")))
        junit.framework.TestCase.assertEquals(DNM, "ᎠᎪᏩᏘh", finalSuffixProcessorForCompare(FinalSuffixProcessor.removeFinalSuffix("ᎠᎪᏩᏘᎭ")))
        junit.framework.TestCase.assertEquals(DNM, "ᎯᎪᏩᏘh", finalSuffixProcessorForCompare(FinalSuffixProcessor.removeFinalSuffix("ᎯᎪᏩᏘᎭ")))
        junit.framework.TestCase.assertEquals(DNM, "ᏥᎪᏩᏘh", finalSuffixProcessorForCompare(FinalSuffixProcessor.removeFinalSuffix("ᏥᎪᏩᏘᎭ")))
        junit.framework.TestCase.assertEquals(DNM, "ᎠᎪᏩᏘh", finalSuffixProcessorForCompare(FinalSuffixProcessor.removeFinalSuffix("ᎠᎪᏩᏘᎭ")))
        junit.framework.TestCase.assertEquals(DNM, "ᎯᎪᏩᏘh", finalSuffixProcessorForCompare(FinalSuffixProcessor.removeFinalSuffix("ᎯᎪᏩᏘᎭ")))
        junit.framework.TestCase.assertEquals(DNM, "ᏥᎪᏩᏘh", finalSuffixProcessorForCompare(FinalSuffixProcessor.removeFinalSuffix("ᏥᎪᏩᏘᎭ")))
        junit.framework.TestCase.assertEquals(DNM, "ᎠᎪᏩᏘh", finalSuffixProcessorForCompare(FinalSuffixProcessor.removeFinalSuffix("ᎠᎪᏩᏘᎭ")))
        junit.framework.TestCase.assertEquals(DNM, "ᎯᎪᏩᏘh", finalSuffixProcessorForCompare(FinalSuffixProcessor.removeFinalSuffix("ᎯᎪᏩᏘᎭ")))
        junit.framework.TestCase.assertEquals(DNM, "ᏥᎪᏩᏘh", finalSuffixProcessorForCompare(FinalSuffixProcessor.removeFinalSuffix("ᏥᎪᏩᏘᎭ")))
        junit.framework.TestCase.assertEquals(DNM, "ᎠᎪᏩᏘh", finalSuffixProcessorForCompare(FinalSuffixProcessor.removeFinalSuffix("ᎠᎪᏩᏘᎭ")))
        junit.framework.TestCase.assertEquals(DNM, "ᎯᎪᏩᏘh", finalSuffixProcessorForCompare(FinalSuffixProcessor.removeFinalSuffix("ᎯᎪᏩᏘᎭ")))
        junit.framework.TestCase.assertEquals(DNM, "ᎦᏔᏍᎩ", finalSuffixProcessorForCompare(FinalSuffixProcessor.removeFinalSuffix("ᎦᏔᏍᎩᎠ")))
        junit.framework.TestCase.assertEquals(DNM, "ᎭᏔᏍg", finalSuffixProcessorForCompare(FinalSuffixProcessor.removeFinalSuffix("ᎭᏔᏍᎩ")))
        junit.framework.TestCase.assertEquals(DNM, "ᎤᏔᏍᎩᏍ", finalSuffixProcessorForCompare(FinalSuffixProcessor.removeFinalSuffix("ᎤᏔᏍᎩᏒᎢ")))
        junit.framework.TestCase.assertEquals(DNM, "ᎦᏔᏍᎩ", finalSuffixProcessorForCompare(FinalSuffixProcessor.removeFinalSuffix("ᎦᏔᏍᎩᎠ")))
        junit.framework.TestCase.assertEquals(DNM, "ᎦᏔᏍᎩ", finalSuffixProcessorForCompare(FinalSuffixProcessor.removeFinalSuffix("ᎦᏔᏍᎩᎠ")))
        junit.framework.TestCase.assertEquals(DNM, "ᎦᏔᏍᎩ", finalSuffixProcessorForCompare(FinalSuffixProcessor.removeFinalSuffix("ᎦᏔᏍᎩᎠ")))
        junit.framework.TestCase.assertEquals(DNM, "ᎦᏔᏍᎩ", finalSuffixProcessorForCompare(FinalSuffixProcessor.removeFinalSuffix("ᎦᏔᏍᎩᎠ")))
        junit.framework.TestCase.assertEquals(DNM, "ᏥᎪᏩᏘh", finalSuffixProcessorForCompare(FinalSuffixProcessor.removeFinalSuffix("ᏥᎪᏩᏘᎭ")))
        junit.framework.TestCase.assertEquals(DNM, "ᎦᏔᏍᎩ", finalSuffixProcessorForCompare(FinalSuffixProcessor.removeFinalSuffix("ᎦᏔᏍᎩᎠ")))
        junit.framework.TestCase.assertEquals(DNM, "ᏥᎪᏩᏘh", finalSuffixProcessorForCompare(FinalSuffixProcessor.removeFinalSuffix("ᏥᎪᏩᏘᎭ")))
        junit.framework.TestCase.assertEquals(DNM, "ᎦᏔᏍᎩ", finalSuffixProcessorForCompare(FinalSuffixProcessor.removeFinalSuffix("ᎦᏔᏍᎩᎠ")))
        junit.framework.TestCase.assertEquals(DNM, "ᏥᎪᏩᏘh", finalSuffixProcessorForCompare(FinalSuffixProcessor.removeFinalSuffix("ᏥᎪᏩᏘᎭ")))
        junit.framework.TestCase.assertEquals(DNM, "ᎦᏔᏍᎩ", finalSuffixProcessorForCompare(FinalSuffixProcessor.removeFinalSuffix("ᎦᏔᏍᎩᎠ")))
        junit.framework.TestCase.assertEquals(DNM, "ᎦᏔᏍᎩ", finalSuffixProcessorForCompare(FinalSuffixProcessor.removeFinalSuffix("ᎦᏔᏍᎩᎠ")))
        junit.framework.TestCase.assertEquals(DNM, "ᏍᏗᎪᏩᏘh", finalSuffixProcessorForCompare(FinalSuffixProcessor.removeFinalSuffix("ᏍᏗᎪᏩᏘᎭ")))
        junit.framework.TestCase.assertEquals(DNM, "ᏍᏗᎪᏩt", finalSuffixProcessorForCompare(FinalSuffixProcessor.removeFinalSuffix("ᏍᏗᎪᏩᏘ")))
        junit.framework.TestCase.assertEquals(DNM, "ᏍᏗᎪᏩᏘh", finalSuffixProcessorForCompare(FinalSuffixProcessor.removeFinalSuffix("ᏍᏗᎪᏩᏘᎭ")))
        junit.framework.TestCase.assertEquals(DNM, "ᏍᏗᎪᏩt", finalSuffixProcessorForCompare(FinalSuffixProcessor.removeFinalSuffix("ᏍᏗᎪᏩᏘ")))
        junit.framework.TestCase.assertEquals(DNM, "ᏍᏗᎪᏩᏘh", finalSuffixProcessorForCompare(FinalSuffixProcessor.removeFinalSuffix("ᏍᏗᎪᏩᏘᎭ")))
        junit.framework.TestCase.assertEquals(DNM, "ᏍᏗᎪᏩt", finalSuffixProcessorForCompare(FinalSuffixProcessor.removeFinalSuffix("ᏍᏗᎪᏩᏘ")))

        //first person present -- bleed -- rrd
        junit.framework.TestCase.assertEquals(DNM, "ᎦᏔᏍᎩ", finalSuffixProcessorForCompare(FinalSuffixProcessor.removeFinalSuffix("ᎦᏔᏍᎩᎠ")))

        //third person present -- bleed -- rrd
        junit.framework.TestCase.assertEquals(DNM, "ᎠᏔᏍᎩ", finalSuffixProcessorForCompare(FinalSuffixProcessor.removeFinalSuffix("ᎠᏔᏍᎩᎠ")))
    }

    public void testPastRemoval() {

        // past -- nosebleed -- ced
        junit.framework.TestCase.assertEquals(DNM, "ᏚᏴᏍᏉl", finalSuffixProcessorForCompare(FinalSuffixProcessor.removeFinalSuffix("ᏚᏴᏍᏉᎸᎢ")))
    }

    public void testHabitualRemoval() {
        // habitual -- nosebleed -- ced
        junit.framework.TestCase.assertEquals(DNM, "ᏕᎧᏴᏍᏉᎢh", finalSuffixProcessorForCompare(FinalSuffixProcessor.removeFinalSuffix("ᏕᎧᏴᏍᏉᎢᎰᎢ")))
    }

    public void testImperativeRemoval() {
        // imperative -- nosebleed -- ced
        junit.framework.TestCase.assertEquals(DNM, "ᏘᏴᏍᏉts", finalSuffixProcessorForCompare(FinalSuffixProcessor.removeFinalSuffix("ᏘᏴᏍᏉᏣ")))
    }

    public void testEmptyConjugations() {
        junit.framework.TestCase.assertEquals(DNM, "", finalSuffixProcessorForCompare(FinalSuffixProcessor.removeFinalSuffix(ConjugateBase.tohave.infinitive.syllabary)))
        junit.framework.TestCase.assertEquals(DNM, "", finalSuffixProcessorForCompare(FinalSuffixProcessor.removeFinalSuffix(ConjugateBase.wearShoes.infinitive.syllabary)))
    }

    public void testInfinitiveRemoval() {
        // infinitive -- nosebleed -- ced
        junit.framework.TestCase.assertEquals(DNM, "ᏧᏴᏍᏉᎢᏍ", finalSuffixProcessorForCompare(FinalSuffixProcessor.removeFinalSuffix("ᏧᏴᏍᏉᎢᏍᏗ")))

        junit.framework.TestCase.assertEquals(DNM, "ᎤᏚᎸ", finalSuffixProcessorForCompare(FinalSuffixProcessor.removeFinalSuffix(ConjugateBase.heWantsIt.infinitive.syllabary)))
        junit.framework.TestCase.assertEquals(DNM, "ᎤᏬᏂᎯᏍ", finalSuffixProcessorForCompare(FinalSuffixProcessor.removeFinalSuffix(ConjugateBase.hiwoniha.infinitive.syllabary)))
        junit.framework.TestCase.assertEquals(DNM, "ᎤᏁᏁ", finalSuffixProcessorForCompare(FinalSuffixProcessor.removeFinalSuffix(ConjugateBase.ganeneha.infinitive.syllabary)))
        junit.framework.TestCase.assertEquals(DNM, "ᎤᏲᎵᏍ", finalSuffixProcessorForCompare(FinalSuffixProcessor.removeFinalSuffix(ConjugateBase.togreet.infinitive.syllabary)))
        junit.framework.TestCase.assertEquals(DNM, "ᎤᏛᎪ", finalSuffixProcessorForCompare(FinalSuffixProcessor.removeFinalSuffix(ConjugateBase.tohear.infinitive.syllabary)))
        junit.framework.TestCase.assertEquals(DNM, "ᎤᏑ", finalSuffixProcessorForCompare(FinalSuffixProcessor.removeFinalSuffix(ConjugateBase.tofish.infinitive.syllabary)))
        //ends in esdi
        junit.framework.TestCase.assertEquals(DNM, "ᎤᏩy", finalSuffixProcessorForCompare(FinalSuffixProcessor.removeFinalSuffix(ConjugateBase.toeatLiving.infinitive.syllabary)))
        junit.framework.TestCase.assertEquals(DNM, "ᎤᏥᏕᏍ", finalSuffixProcessorForCompare(FinalSuffixProcessor.removeFinalSuffix(ConjugateBase.takeABite.infinitive.syllabary)))
        junit.framework.TestCase.assertEquals(DNM, "ᎤᎯᏍ", finalSuffixProcessorForCompare(FinalSuffixProcessor.removeFinalSuffix(ConjugateBase.tokill.infinitive.syllabary)))
    }

    private static String finalSuffixProcessorForCompare(HolderWord hw) {
        return hw.syllabary + hw.nonfinalEndingLatin
    }
}
