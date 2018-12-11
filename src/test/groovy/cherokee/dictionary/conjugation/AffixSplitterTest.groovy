package cherokee.dictionary.conjugation

import cherokee.dictionary.conjugation.stem.AffixSplitter

public class AffixSplitterTest extends GroovyTestCase {
    public void testAffixSplitter() {
        AffixSplitter afs = new AffixSplitter()
        println afs.processLine("ᎤᎾᎳᏍᎦᎵᏗ ᏳᏟᎢᎶᏝ ᎠᏓᎴᏂᏍᎪ ᎠᎾᎳᏍᎦᎵᏍᎬᎢ.")
    }
}

