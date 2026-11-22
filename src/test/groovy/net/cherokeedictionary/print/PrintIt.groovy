package net.cherokeedictionary.print

import net.cherokeedictionary.conjugation.ConjugateBase
import net.cherokeedictionary.core.Verb
import net.cherokeedictionary.print.TableMaker
import net.cherokeedictionary.print.TableType
import net.cherokeedictionary.stemmer.DefinitionLine
import net.cherokeedictionary.stemmer.Stemmer
import net.cherokeedictionary.util.PartOfSpeech
import net.cherokeedictionary.util.PrefixTableSubject
import net.cherokeedictionary.verb.conjugation.Conjugate
import spock.lang.Ignore



Verb verb = Conjugate.createVerbToConjugate("SG3", "SG3AN", ConjugateBase.gowatiha, "PRESENT", PartOfSpeech.VERB_TRANSITIVE.toString(), false)
//def tableMaker = new TableMaker()
//tableMaker.tableType = TableType.LATEX
//tableMaker.generate(verb)


/*def verbName = new Stemmer()
verbName.habitual = new DefinitionLine(syllabary: "ᏭᏕᎵᎪᎢ")
verbName.imperative = new DefinitionLine(syllabary: "ᏫᏣᏕᎵᎩ")
verbName.infinitive = new DefinitionLine(syllabary: "ᏭᏕᎵᏍᏗ")
verbName.present1st = new DefinitionLine(syllabary: "ᏩᏆᏕᎵᎦ")
verbName.present3rd = new DefinitionLine(syllabary: "ᏭᏕᎵᎦ")
verbName.remotepast = new DefinitionLine(syllabary: "ᏭᏕᎵᏨᎢ")

verb = Conjugate.createVerbToConjugate("SG2", "SG3AN", verbName, "PRESENT", PartOfSpeech.VERB_INTRANSITIVE.toString(), false)*/
println Conjugate.conjugate(verb).wholeWord

def tableMaker = new TableMaker()
tableMaker.tableType = TableType.LATEX
tableMaker.generate(verb)


def verbName = new Stemmer()

verbName.habitual = new DefinitionLine(syllabary: "ᎦᎴᏴᏍᎪᎢ")
verbName.imperative = new DefinitionLine(syllabary: "ᎯᎴᏴᎯ")
verbName.infinitive = new DefinitionLine(syllabary: "ᎤᎴᏴᎯᏍᏗ")
verbName.present1st = new DefinitionLine(syllabary: "ᏥᎴᏴᏍᎦ")
verbName.present3rd = new DefinitionLine(syllabary: "ᎦᎴᏴᏍᎦ")
verbName.remotepast = new DefinitionLine(syllabary: "ᎤᎴᏴᏒᎢ")

verb = Conjugate.createVerbToConjugate("SG3", "SG3AN", verbName, "PRESENT", PartOfSpeech.VERB_INTRANSITIVE.toString(), false)
println Conjugate.conjugate(verb).wholeWord

tableMaker.generate(verb)
