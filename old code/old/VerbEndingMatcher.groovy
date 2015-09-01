package cherokee.dictionary.conjugation.old

import groovy.sql.Sql

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
SQL.eachRow("select * from likespreadsheets l where l.vfirstpresh like ? and l.syllabaryb like ? and (l.partofspeechc like 'v.i%' or l.partofspeechc like 'v.t%') and l.partofspeechc not like '%pref%' and l.partofspeechc not like '%suf%' and l.source = 'ced'", ["ᏥᏯ%", "Ꭰ%"]) {
    println it
}
vfirstpresh
vsecondimperm
vthirdinfo
entrya
vthirdpasti
vthirdpressyll