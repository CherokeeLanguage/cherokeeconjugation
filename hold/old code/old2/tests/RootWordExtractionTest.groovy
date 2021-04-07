package cherokee.dictionary.conjugation

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
        //TODO: FAILS!!!!!
//        rootProcessorForCompare("ᎭᏔᏍᎩ", "ᎠᏔᏍᎩ")
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
        ConjugateBase.compareForAssertion(original,assertion)
    }
}
