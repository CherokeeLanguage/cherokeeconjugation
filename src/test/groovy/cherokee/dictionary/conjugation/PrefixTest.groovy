package cherokee.dictionary.conjugation

import cherokee.dictionary.conjugation.affixes.BasePrefixFactory
import cherokee.dictionary.conjugation.affixes.PrefixHolderObject
import cherokee.dictionary.conjugation.cdpbook.Stemmer
import cherokee.dictionary.conjugation.conjugate.Tense
import cherokee.dictionary.conjugation.stem.DefinitionLine

class PrefixTest extends GroovyTestCase {
    static def heSeesIt = new Stemmer()
    static {
        heSeesIt.habitual = new DefinitionLine(syllabary: "ᎠᎪᏩᏘᏍᎪᎢ")
        heSeesIt.imperative = new DefinitionLine(syllabary: "ᎯᎪᏩᏔ")
        heSeesIt.infinitive = new DefinitionLine(syllabary: "ᎤᎪᏩᏛᏗ")
        heSeesIt.present1st = new DefinitionLine(syllabary: "ᏥᎪᏩᏘᎭ")
        heSeesIt.present3rd = new DefinitionLine(syllabary: "ᎠᎪᏩᏘᎭ")
        heSeesIt.remotepast = new DefinitionLine(syllabary: "ᎤᎪᎲᎢ")
    }

    public void testPrefixes() {
        PrefixHolderObject pho = new PrefixHolderObject()


        Conjugate conjugate = new Conjugate()
        def SG1SG3AN = conjugate.conjugate("SG1", "SG3AN", heSeesIt, Tense.PRESENT.toString(), "v.t.")
        def SG3SG3AN = conjugate.conjugate("SG3", "SG3AN", heSeesIt, Tense.PRESENT.toString(), "v.t.")
        def SG2SG3AN = conjugate.conjugate("SG2", "SG3AN", heSeesIt, Tense.PRESENT.toString(), "v.t.")
        println SG1SG3AN
        println SG3SG3AN
        println SG2SG3AN


        def bpf = new BasePrefixFactory()
        assertEquals("FAILURE DID NOT MATCH", "ᏥᎪᏩᏘᎭ" , bpf.processPrefixes(SG1SG3AN, pho))
        assertEquals("FAILURE DID NOT MATCH", "ᎠᎪᏩᏘᎭ" , bpf.processPrefixes(SG3SG3AN, pho))
        assertEquals("FAILURE DID NOT MATCH", "ᎯᎪᏩᏘᎭ" , bpf.processPrefixes(SG2SG3AN, pho))

        pho.yi = true;
        assertEquals("FAILURE DID NOT MATCH", "ᏱᏥᎪᏩᏘᎭ" , bpf.processPrefixes(SG1SG3AN, pho))
        assertEquals("FAILURE DID NOT MATCH", "ᏯᎪᏩᏘᎭ" , bpf.processPrefixes(SG3SG3AN, pho))
        assertEquals("FAILURE DID NOT MATCH", "ᏱᎯᎪᏩᏘᎭ" , bpf.processPrefixes(SG2SG3AN, pho))

        pho.ga = true;
        assertEquals("FAILURE DID NOT MATCH", "ᏱᎦᏥᎪᏩᏘᎭ" , bpf.processPrefixes(SG1SG3AN, pho))
        assertEquals("FAILURE DID NOT MATCH", "ᏱᎬᎪᏩᏘᎭ" , bpf.processPrefixes(SG3SG3AN, pho))
        assertEquals("FAILURE DID NOT MATCH", "ᏱᎦᎯᎪᏩᏘᎭ" , bpf.processPrefixes(SG2SG3AN, pho))

        pho.ga = false;
        pho.ni = true;
        assertEquals("FAILURE DID NOT MATCH", "ᏱᏂᏥᎪᏩᏘᎭ" , bpf.processPrefixes(SG1SG3AN, pho))
        assertEquals("FAILURE DID NOT MATCH", "ᏱᎾᎪᏩᏘᎭ" , bpf.processPrefixes(SG3SG3AN, pho))
        assertEquals("FAILURE DID NOT MATCH", "ᏱᏂᎯᎪᏩᏘᎭ" , bpf.processPrefixes(SG2SG3AN, pho))

        pho.yi = false;
        pho.ga = false;
        pho.ni = false;
        pho.wi = true;
        assertEquals("FAILURE DID NOT MATCH", "ᏫᏥᎪᏩᏘᎭ" , bpf.processPrefixes(SG1SG3AN, pho))
        assertEquals("FAILURE DID NOT MATCH", "ᏩᎪᏩᏘᎭ" , bpf.processPrefixes(SG3SG3AN, pho))
        assertEquals("FAILURE DID NOT MATCH", "ᏫᎯᎪᏩᏘᎭ" , bpf.processPrefixes(SG2SG3AN, pho))

        pho.yi = true;
        pho.ga = false;
        pho.ni = false;
        pho.wi = true;
        assertEquals("FAILURE DID NOT MATCH", "ᏳᏫᏥᎪᏩᏘᎭ" , bpf.processPrefixes(SG1SG3AN, pho))
        assertEquals("FAILURE DID NOT MATCH", "ᏳᏩᎪᏩᏘᎭ" , bpf.processPrefixes(SG3SG3AN, pho))
        assertEquals("FAILURE DID NOT MATCH", "ᏳᏫᎯᎪᏩᏘᎭ" , bpf.processPrefixes(SG2SG3AN, pho))

        pho.yi = true;
        pho.ga = true;
        pho.ni = true;
        pho.wi = true;
        assertEquals("FAILURE DID NOT MATCH", "ᏳᏫᏂᎦᏥᎪᏩᏘᎭ" , bpf.processPrefixes(SG1SG3AN, pho))
        assertEquals("FAILURE DID NOT MATCH", "ᏳᏫᏂᎬᎪᏩᏘᎭ" , bpf.processPrefixes(SG3SG3AN, pho))
        assertEquals("FAILURE DID NOT MATCH", "ᏳᏫᏂᎦᎯᎪᏩᏘᎭ" , bpf.processPrefixes(SG2SG3AN, pho))


    }
}
