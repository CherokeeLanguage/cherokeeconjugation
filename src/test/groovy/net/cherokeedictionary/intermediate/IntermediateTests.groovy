package net.cherokeedictionary.intermediate

import net.cherokeedictionary.conjugation.ConjugateBase
import net.cherokeedictionary.core.Verb
import net.cherokeedictionary.print.TableMaker
import net.cherokeedictionary.print.TableType
import net.cherokeedictionary.util.PartOfSpeech
import net.cherokeedictionary.verb.conjugation.Conjugate

class IntermediateTests extends ConjugateBase {
    Verb verb = Conjugate.createVerbToConjugate("SG3", "SG3AN", gowatiha, "PRESENT", PartOfSpeech.VERB_TRANSITIVE.toString(), false)

    void testSG3SG3ANPresent() {
        def tableMaker = new TableMaker()
        tableMaker.tableType = TableType.LATEX
        tableMaker.generate(verb)
    }
}