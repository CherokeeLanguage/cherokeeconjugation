package cherokee.dictionary.conjugation.hold

import groovy.sql.Sql

def lst = ["dadahnesea",
           "dadanilvga",
           "dadeyohvsga",
           "dadlohyiha",
           "dagvwahldiha",
           "dahlilosdiha",
           "dahltadega",
           "dahnawaiyva",
           "dahnawoa",
           "dahvtvsga",
           "dahyvgia",
           "dakanehiha",
           "dakanehyiha",
           "dakanowadidoha",
           "daksvsdiha",
           "daktilega",
           "daktinvdea",
           "daktinvtvsga",
           "daktliha",
           "dakwayovsga",
           "dalasuhlvsga",
           "dalasulaiyva",
           "dalasulea",
           "dalehdiha",
           "daliyesulea",
           "daliyesulia",
           "daliyogia",
           "daliyohia",
           "daliyosiha",
           "dalsosdiha",
           "danadlosga",
           "danehldiha",
           "danelohvsga",
           "daniyelisga",
           "dasdayohiha",
           "dasdlusga",
           "dasdudlia",
           "dasehiha",
           "dasginadia",
           "dasihtvniha",
           "dasvsdiha",
           "datesga",
           "dayosga",
           "degalvdvnisdiha",
           "deganadiwsga",
           "deganojahlvsga",
           "degasohga",
           "degetvsga",
           "degosisiha",
           "degukdiha",
           "degvdiyea",
           "degvtohia",
           "dekalihgwadega",
           "dekanogia",
           "dekanugosga",
           "dekgiloa",
           "dudlosga",
           "dudoa",
           "duktinvta",
           "dulasuhla",
           "duliyoha",
           "dusgalesdiha",
           "duyosga",
           "nigvnhdiha",
           "nuwanhdi",
           "wadia",
           "wahvsga",
           "wakti",
           "wigakahvsga",
           "wiganehvsga",
           "wiganvvsga",
           "wudeliga"]

def SQL = Sql.newInstance( 'jdbc:mysql://localhost/cherokeedictionary?useUnicode=yes&characterEncoding=UTF-8', 'root', 'tk0203', 'org.gjt.mm.mysql.Driver' )
def lst2 = []
lst.each {
    SQL.eachRow("select * from likespreadsheets where entrya like ? limit 1", [it]) {
        /*println "it.syllabaryb ${it.syllabaryb}"//present3rd
    println "it.vfirstpresh ${it.vfirstpresh}"//present1st
    println "it.vsecondimpersylln ${it.vsecondimpersylln}"//imperative
    println "it.vthirdinfsyllp ${it.vthirdinfsyllp}"//infinitive
    println "it.vthirdpastsyllj ${it.vthirdpastsyllj}"//remotepast
    println "it.vthirdpressylll ${it.vthirdpressylll}"//habitual*/
        if (it.partofspeechc == 'v.t.') {
            lst2.add("static def ${it.entrya} = new Stemmer()")
            println "${it.entrya}.habitual = new DefinitionLine(syllabary: \"${it.vthirdpressylll}\")"
            println "${it.entrya}.imperative = new DefinitionLine(syllabary: \"${it.vsecondimpersylln}\")"
            println "${it.entrya}.infinitive = new DefinitionLine(syllabary: \"${it.vthirdinfsyllp}\")"
            println "${it.entrya}.present1st = new DefinitionLine(syllabary: \"${it.vfirstpresh}\")"
            println "${it.entrya}.present3rd = new DefinitionLine(syllabary: \"${it.syllabaryb}\")"
            println "${it.entrya}.remotepast = new DefinitionLine(syllabary: \"${it.vthirdpastsyllj}\")"
        }
    }
}

lst2.each {
    println it
}