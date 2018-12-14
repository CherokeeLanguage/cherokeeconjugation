package cherokee.dictionary.conjugation

import cherokee.dictionary.conjugation.affixes.processors.FinalSuffixProcessor

class FinalSuffixProcessorTest extends GroovyTestCase {
    static def DNM = "FAILURE DID NOT MATCH"

    public void testPresentRemoval() {
        assertEquals(DNM, "ᏥᎪᏩᏘh", finalSuffixProcessorForCompare(FinalSuffixProcessor.removeFinalSuffix("ᏥᎪᏩᏘᎭ")))
        assertEquals(DNM, "ᎠᎪᏩᏘh", finalSuffixProcessorForCompare(FinalSuffixProcessor.removeFinalSuffix("ᎠᎪᏩᏘᎭ")))
        assertEquals(DNM, "ᎯᎪᏩᏘh", finalSuffixProcessorForCompare(FinalSuffixProcessor.removeFinalSuffix("ᎯᎪᏩᏘᎭ")))
        assertEquals(DNM, "ᏥᎪᏩᏘh", finalSuffixProcessorForCompare(FinalSuffixProcessor.removeFinalSuffix("ᏥᎪᏩᏘᎭ")))
        assertEquals(DNM, "ᎠᎪᏩᏘh", finalSuffixProcessorForCompare(FinalSuffixProcessor.removeFinalSuffix("ᎠᎪᏩᏘᎭ")))
        assertEquals(DNM, "ᎯᎪᏩᏘh", finalSuffixProcessorForCompare(FinalSuffixProcessor.removeFinalSuffix("ᎯᎪᏩᏘᎭ")))
        assertEquals(DNM, "ᏥᎪᏩᏘh", finalSuffixProcessorForCompare(FinalSuffixProcessor.removeFinalSuffix("ᏥᎪᏩᏘᎭ")))
        assertEquals(DNM, "ᎠᎪᏩᏘh", finalSuffixProcessorForCompare(FinalSuffixProcessor.removeFinalSuffix("ᎠᎪᏩᏘᎭ")))
        assertEquals(DNM, "ᎯᎪᏩᏘh", finalSuffixProcessorForCompare(FinalSuffixProcessor.removeFinalSuffix("ᎯᎪᏩᏘᎭ")))
        assertEquals(DNM, "ᏥᎪᏩᏘh", finalSuffixProcessorForCompare(FinalSuffixProcessor.removeFinalSuffix("ᏥᎪᏩᏘᎭ")))
        assertEquals(DNM, "ᎠᎪᏩᏘh", finalSuffixProcessorForCompare(FinalSuffixProcessor.removeFinalSuffix("ᎠᎪᏩᏘᎭ")))
        assertEquals(DNM, "ᎯᎪᏩᏘh", finalSuffixProcessorForCompare(FinalSuffixProcessor.removeFinalSuffix("ᎯᎪᏩᏘᎭ")))
        assertEquals(DNM, "ᏥᎪᏩᏘh", finalSuffixProcessorForCompare(FinalSuffixProcessor.removeFinalSuffix("ᏥᎪᏩᏘᎭ")))
        assertEquals(DNM, "ᎠᎪᏩᏘh", finalSuffixProcessorForCompare(FinalSuffixProcessor.removeFinalSuffix("ᎠᎪᏩᏘᎭ")))
        assertEquals(DNM, "ᎯᎪᏩᏘh", finalSuffixProcessorForCompare(FinalSuffixProcessor.removeFinalSuffix("ᎯᎪᏩᏘᎭ")))
        assertEquals(DNM, "ᏥᎪᏩᏘh", finalSuffixProcessorForCompare(FinalSuffixProcessor.removeFinalSuffix("ᏥᎪᏩᏘᎭ")))
        assertEquals(DNM, "ᎠᎪᏩᏘh", finalSuffixProcessorForCompare(FinalSuffixProcessor.removeFinalSuffix("ᎠᎪᏩᏘᎭ")))
        assertEquals(DNM, "ᎯᎪᏩᏘh", finalSuffixProcessorForCompare(FinalSuffixProcessor.removeFinalSuffix("ᎯᎪᏩᏘᎭ")))
        assertEquals(DNM, "ᏥᎪᏩᏘh", finalSuffixProcessorForCompare(FinalSuffixProcessor.removeFinalSuffix("ᏥᎪᏩᏘᎭ")))
        assertEquals(DNM, "ᎠᎪᏩᏘh", finalSuffixProcessorForCompare(FinalSuffixProcessor.removeFinalSuffix("ᎠᎪᏩᏘᎭ")))
        assertEquals(DNM, "ᎯᎪᏩᏘh", finalSuffixProcessorForCompare(FinalSuffixProcessor.removeFinalSuffix("ᎯᎪᏩᏘᎭ")))
        assertEquals(DNM, "ᎦᏔᏍᎩ", finalSuffixProcessorForCompare(FinalSuffixProcessor.removeFinalSuffix("ᎦᏔᏍᎩᎠ")))
        assertEquals(DNM, "ᎭᏔᏍg", finalSuffixProcessorForCompare(FinalSuffixProcessor.removeFinalSuffix("ᎭᏔᏍᎩ")))
        assertEquals(DNM, "ᎤᏔᏍᎩᏍ", finalSuffixProcessorForCompare(FinalSuffixProcessor.removeFinalSuffix("ᎤᏔᏍᎩᏒᎢ")))
        assertEquals(DNM, "ᎦᏔᏍᎩ", finalSuffixProcessorForCompare(FinalSuffixProcessor.removeFinalSuffix("ᎦᏔᏍᎩᎠ")))
        assertEquals(DNM, "ᎦᏔᏍᎩ", finalSuffixProcessorForCompare(FinalSuffixProcessor.removeFinalSuffix("ᎦᏔᏍᎩᎠ")))
        assertEquals(DNM, "ᎦᏔᏍᎩ", finalSuffixProcessorForCompare(FinalSuffixProcessor.removeFinalSuffix("ᎦᏔᏍᎩᎠ")))
        assertEquals(DNM, "ᎦᏔᏍᎩ", finalSuffixProcessorForCompare(FinalSuffixProcessor.removeFinalSuffix("ᎦᏔᏍᎩᎠ")))
        assertEquals(DNM, "ᏥᎪᏩᏘh", finalSuffixProcessorForCompare(FinalSuffixProcessor.removeFinalSuffix("ᏥᎪᏩᏘᎭ")))
        assertEquals(DNM, "ᎦᏔᏍᎩ", finalSuffixProcessorForCompare(FinalSuffixProcessor.removeFinalSuffix("ᎦᏔᏍᎩᎠ")))
        assertEquals(DNM, "ᏥᎪᏩᏘh", finalSuffixProcessorForCompare(FinalSuffixProcessor.removeFinalSuffix("ᏥᎪᏩᏘᎭ")))
        assertEquals(DNM, "ᎦᏔᏍᎩ", finalSuffixProcessorForCompare(FinalSuffixProcessor.removeFinalSuffix("ᎦᏔᏍᎩᎠ")))
        assertEquals(DNM, "ᏥᎪᏩᏘh", finalSuffixProcessorForCompare(FinalSuffixProcessor.removeFinalSuffix("ᏥᎪᏩᏘᎭ")))
        assertEquals(DNM, "ᎦᏔᏍᎩ", finalSuffixProcessorForCompare(FinalSuffixProcessor.removeFinalSuffix("ᎦᏔᏍᎩᎠ")))
        assertEquals(DNM, "ᎦᏔᏍᎩ", finalSuffixProcessorForCompare(FinalSuffixProcessor.removeFinalSuffix("ᎦᏔᏍᎩᎠ")))
        assertEquals(DNM, "ᏍᏗᎪᏩᏘh", finalSuffixProcessorForCompare(FinalSuffixProcessor.removeFinalSuffix("ᏍᏗᎪᏩᏘᎭ")))
        assertEquals(DNM, "ᏍᏗᎪᏩt", finalSuffixProcessorForCompare(FinalSuffixProcessor.removeFinalSuffix("ᏍᏗᎪᏩᏘ")))
        assertEquals(DNM, "ᏍᏗᎪᏩᏘh", finalSuffixProcessorForCompare(FinalSuffixProcessor.removeFinalSuffix("ᏍᏗᎪᏩᏘᎭ")))
        assertEquals(DNM, "ᏍᏗᎪᏩt", finalSuffixProcessorForCompare(FinalSuffixProcessor.removeFinalSuffix("ᏍᏗᎪᏩᏘ")))
        assertEquals(DNM, "ᏍᏗᎪᏩᏘh", finalSuffixProcessorForCompare(FinalSuffixProcessor.removeFinalSuffix("ᏍᏗᎪᏩᏘᎭ")))
        assertEquals(DNM, "ᏍᏗᎪᏩt", finalSuffixProcessorForCompare(FinalSuffixProcessor.removeFinalSuffix("ᏍᏗᎪᏩᏘ")))

        //first person present -- bleed -- rrd
        assertEquals(DNM, "ᎦᏔᏍᎩ", finalSuffixProcessorForCompare(FinalSuffixProcessor.removeFinalSuffix("ᎦᏔᏍᎩᎠ")))

        //third person present -- bleed -- rrd
        assertEquals(DNM, "ᎠᏔᏍᎩ", finalSuffixProcessorForCompare(FinalSuffixProcessor.removeFinalSuffix("ᎠᏔᏍᎩᎠ")))
    }

    public void testPastRemoval() {

        // past -- nosebleed -- ced
        assertEquals(DNM, "ᏚᏴᏍᏉl", finalSuffixProcessorForCompare(FinalSuffixProcessor.removeFinalSuffix("ᏚᏴᏍᏉᎸᎢ")))
    }

    public void testHabitualRemoval() {
        // habitual -- nosebleed -- ced
        assertEquals(DNM, "ᏕᎧᏴᏍᏉᎢh", finalSuffixProcessorForCompare(FinalSuffixProcessor.removeFinalSuffix("ᏕᎧᏴᏍᏉᎢᎰᎢ")))
    }

    public void testImperativeRemoval() {
        // imperative -- nosebleed -- ced
        assertEquals(DNM, "ᏘᏴᏍᏉts", finalSuffixProcessorForCompare(FinalSuffixProcessor.removeFinalSuffix("ᏘᏴᏍᏉᏣ")))
    }

    public void testEmptyConjugations() {
        assertEquals(DNM, "", finalSuffixProcessorForCompare(FinalSuffixProcessor.removeFinalSuffix(ConjugateBase.tohave.infinitive.syllabary)))
        assertEquals(DNM, "", finalSuffixProcessorForCompare(FinalSuffixProcessor.removeFinalSuffix(ConjugateBase.wearShoes.infinitive.syllabary)))
    }

    public void testInfinitiveRemoval() {
        // infinitive -- nosebleed -- ced
        assertEquals(DNM, "ᏧᏴᏍᏉᎢᏍ", finalSuffixProcessorForCompare(FinalSuffixProcessor.removeFinalSuffix("ᏧᏴᏍᏉᎢᏍᏗ")))

        assertEquals(DNM, "ᎤᏚᎸ", finalSuffixProcessorForCompare(FinalSuffixProcessor.removeFinalSuffix(ConjugateBase.heWantsIt.infinitive.syllabary)))
        assertEquals(DNM, "ᎤᏬᏂᎯᏍ", finalSuffixProcessorForCompare(FinalSuffixProcessor.removeFinalSuffix(ConjugateBase.hiwoniha.infinitive.syllabary)))
        assertEquals(DNM, "ᎤᏁᏁ", finalSuffixProcessorForCompare(FinalSuffixProcessor.removeFinalSuffix(ConjugateBase.ganeneha.infinitive.syllabary)))
        assertEquals(DNM, "ᎤᏲᎵᏍ", finalSuffixProcessorForCompare(FinalSuffixProcessor.removeFinalSuffix(ConjugateBase.togreet.infinitive.syllabary)))
        assertEquals(DNM, "ᎤᏛᎪ", finalSuffixProcessorForCompare(FinalSuffixProcessor.removeFinalSuffix(ConjugateBase.tohear.infinitive.syllabary)))
        assertEquals(DNM, "ᎤᏑ", finalSuffixProcessorForCompare(FinalSuffixProcessor.removeFinalSuffix(ConjugateBase.tofish.infinitive.syllabary)))
        //ends in esdi
        assertEquals(DNM, "ᎤᏩy", finalSuffixProcessorForCompare(FinalSuffixProcessor.removeFinalSuffix(ConjugateBase.toeatLiving.infinitive.syllabary)))
        assertEquals(DNM, "ᎤᏥᏕᏍ", finalSuffixProcessorForCompare(FinalSuffixProcessor.removeFinalSuffix(ConjugateBase.takeABite.infinitive.syllabary)))
        assertEquals(DNM, "ᎤᎯᏍ", finalSuffixProcessorForCompare(FinalSuffixProcessor.removeFinalSuffix(ConjugateBase.tokill.infinitive.syllabary)))
    }

    private static String finalSuffixProcessorForCompare(HolderWord hw) {
        return hw.syllabary + hw.nonfinalEndingLatin
    }
}
