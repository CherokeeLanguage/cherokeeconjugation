package net.cherokeedictionary.stem.lemma

import net.cherokeedictionary.conjugation.ConjugateBase
import net.cherokeedictionary.stem.lemma.Lemmatizer

class AffixSplitterTest extends ConjugateBase  {
    void testAffixSplitter() {
        Lemmatizer afs = new Lemmatizer()

        def sb = new StringBuilder()
        sb << afs.processLine("ᏥᎪᏩᏘᎭ")

//        sb << afs.processLine("ᎠᎾᎳᏍᎦᎵᏍᎬᎢ")
        log(sb.toString())
//        sb << "\n\n"
        /*
        sb << afs.processLine("ᏳᏟᎢᎶᏝ")
        sb << "\n\n"
        sb << afs.processLine("ᎠᏓᎴᏂᏍᎪ")
        sb << "\n\n"
        sb << afs.processLine("ᎠᎾᎳᏍᎦᎵᏍᎬᎢ")
        sb << "\n\n"
        sb << afs.processLine("ᏳᏫᏂᎦᏥᎪᏩᏘᎭ")*/

//        log(sb.toString())

    }
}

