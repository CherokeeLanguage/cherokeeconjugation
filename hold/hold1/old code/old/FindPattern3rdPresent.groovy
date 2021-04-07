import groovy.sql.Sql

/**
 * Created by torr on 8/25/2015.
 * this is to find a pattern between all of the 3rd person present tenses to determine any syllabary patterns for why the first syllabary
 */
def SQL = Sql.newInstance( 'jdbc:mysql://localhost/cherokeedictionary?useUnicode=yes&characterEncoding=UTF-8', 'root', 'tk0203', 'org.gjt.mm.mysql.Driver' )
def a = [] as Set
def ga = [] as Set

SQL.eachRow("select l.vfirstpresh, l.syllabaryb, l.definitiond, l.partofspeechc from likespreadsheets l where (l.partofspeechc like 'v.i%' or l.partofspeechc like 'v.t%') and (l.partofspeechc not like '%pref%' and l.partofspeechc not like '%suf%') and l.source = 'ced'") {
    try {
        if (it.syllabaryb.startsWith("Ꭰ") && it.vfirstpresh && it.vfirstpresh.size() > 2) {
            a << "${it.syllabaryb.substring(0, 3)} -- ${it.vfirstpresh.substring(0, 3)}"
        } else if (it.syllabaryb.startsWith("Ꭶ") && it.vfirstpresh) {
            ga << "${it.syllabaryb.substring(0, 3)} -- ${it.vfirstpresh.substring(0, 3)}"
        }
    } catch (Exception e) {
        println it.vfirstpresh
        println e.getMessage()
    }
}

a.each {
    println it
}

ga.each {
    println it
}