package net.cherokeedictionary.util

import net.cherokeedictionary.stemmer.Stemmer

/**
 * take an entry and return the values to make a new stemmer object for use in testing
 */


Stemmer tmp = new Stemmer()
SQLClass.SQL.eachRow("select source, partofspeechc, entrya, syllabaryb, definitiond, vfirstpresg, vfirstpresh, vsecondimperm, vsecondimpersylln, vthirdinfo, vthirdinfsyllp, vthirdpasti, vthirdpastsyllj, vthirdpresk, vthirdpressylll from likespreadsheets where entrytranslit = 'gawoniha' and source = 'ced' and partofspeechc like 'v%'; ") {
    println "here"
    println it.partofspeechc
    println "tmp.habitual = new DefinitionLine(syllabary: \"${it.vthirdpressylll}\")"
    println "tmp.imperative = new DefinitionLine(syllabary: \"${it.vsecondimpersylln}\")"
    println "tmp.infinitive = new DefinitionLine(syllabary: \"${it.vthirdinfsyllp}\")"
    println "tmp.present1st = new DefinitionLine(syllabary: \"${it.vfirstpresh}\")"
    println "tmp.present3rd = new DefinitionLine(syllabary: \"${it.syllabaryb}\")"
    println "tmp.remotepast = new DefinitionLine(syllabary: \"${it.vthirdpastsyllj}\")"
}