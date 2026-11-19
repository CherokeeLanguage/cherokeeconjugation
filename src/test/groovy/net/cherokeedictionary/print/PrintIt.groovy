package net.cherokeedictionary.print

import net.cherokeedictionary.conjugation.ConjugateBase
import net.cherokeedictionary.core.Verb
import net.cherokeedictionary.print.TableMaker
import net.cherokeedictionary.print.TableType
import net.cherokeedictionary.util.PartOfSpeech
import net.cherokeedictionary.verb.conjugation.Conjugate

Verb verb = Conjugate.createVerbToConjugate("SG3", "SG3AN", ConjugateBase.gowatiha, "PRESENT", PartOfSpeech.VERB_TRANSITIVE.toString(), false)
def tableMaker = new TableMaker()
tableMaker.tableType = TableType.HTML
//tableMaker.generate(verb)

verb.subject = "DL1EXCL"
verb.object = "SG2"
verb.tense = "REMOTE_PAST"

def conjugated = Conjugate.conjugate(verb)
//def compoundPrefix = conjugated.compoundPrefix

println conjugated.wholeWord

