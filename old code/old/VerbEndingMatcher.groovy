package cherokee.dictionary.conjugation.old

import groovy.sql.Sql
import translation.SQLClass

/**
 * Created by torr on 8/18/2015.
 *
 * Compare v3rdPressyll with v1stpressyll
 * if the first entry (comma delimited) last syllable doesn't match the other
 * e.g. 'a' vs 'ha' then print out the syllabary for 1st and 3rd to compare
 *
 *
 */

def SQL = Sql.newInstance( 'jdbc:mysql://localhost/cherokeedictionary?useUnicode=yes&characterEncoding=UTF-8', 'root', 'tk0203', 'org.gjt.mm.mysql.Driver' )
SQL.eachRow("select l.vfirstpresh, l.syllabaryb, l.definitiond, l.partofspeechc, l. from likespreadsheets l where (l.partofspeechc like 'v.i%' or l.partofspeechc like 'v.t%') and l.partofspeechc not like '%pref%' and l.partofspeechc not like '%suf%' and l.source = 'ced'") {
    def first = it.vfirstpresh
    def third = it.syllabaryb

    def trimmedFirst
    def trimmedThird

    //check for commas
    if (first.contains(",")) {
        trimmedFirst = first.substring(0, first.indexOf(",")).trim()
    } else {
        trimmedFirst = first.trim()
    }

    if (third.contains(",")) {
        trimmedThird = third.substring(0, third.indexOf(",")).trim()
    } else {
        trimmedThird = third.trim()
    }

    if (trimmedFirst && trimmedThird && !trimmedFirst.contains("-") && !trimmedThird.contains("-")) {
        def lastCharFirst = trimmedFirst.substring(trimmedFirst.size() - 1)
        def lastCharThird = trimmedThird.substring(trimmedThird.size() - 1)

        if (lastCharFirst != lastCharThird) {
            println "$first - $third == ${it.definitiond}"
        }
    }
}
