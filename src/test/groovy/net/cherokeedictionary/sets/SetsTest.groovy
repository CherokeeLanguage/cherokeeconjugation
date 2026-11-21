package net.cherokeedictionary.sets

import net.cherokeedictionary.conjugation.ConjugateBase
import net.cherokeedictionary.core.Verb
import net.cherokeedictionary.util.PartOfSpeech
import net.cherokeedictionary.util.Tense
import net.cherokeedictionary.verb.conjugation.Conjugate

//class SetsTest extends ConjugateBase {
//    void testSetATable() {
            Verb verb = Conjugate.createVerbToConjugate("SG2", "SG3AN", ConjugateBase.gowatiha, Tense.IMMEDIATE_COMMAND.toString(), PartOfSpeech.VERB_TRANSITIVE.toString(), false)
            verb = Conjugate.conjugate(verb)
            println verb.wholeWord
//    }
//
//    void testSetBTable() {}
//
//    void testSetAVITable() {}
//
//    void testSetBVITable() {}
//}
