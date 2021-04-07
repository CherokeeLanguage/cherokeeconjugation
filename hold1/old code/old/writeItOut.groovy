import com.cobradoc.cherokee.SyllabaryUtil

/**
 * Created by torr on 8/29/2015.
 */
def su = new SyllabaryUtil();

def str = """assertTrue "", "${su.tsalagiToSyllabary("jiiha")}" == conj("SG1", "SG3AN", tokill, verbTense, partofspeechc)
assertTrue "", "${su.tsalagiToSyllabary("hiiha")}" == conj("SG2", "SG3AN", tokill, verbTense, partofspeechc)
assertTrue "", "${su.tsalagiToSyllabary("ahiha")}" == conj("SG3", "SG3AN", tokill, verbTense, partofspeechc)
assertTrue "", "${su.tsalagiToSyllabary("eniiha")}" == conj("DL1INCL", "SG3AN", tokill, verbTense, partofspeechc)
assertTrue "", "${su.tsalagiToSyllabary("osdiiha")}" == conj("DL1EXCL", "SG3AN", tokill, verbTense, partofspeechc)
assertTrue "", "${su.tsalagiToSyllabary("esdiiha")}" == conj("DL2", "SG3AN", tokill, verbTense, partofspeechc)
assertTrue "", "${su.tsalagiToSyllabary("ediiha")}" == conj("PL1INCL", "SG3AN", tokill, verbTense, partofspeechc)
assertTrue "", "${su.tsalagiToSyllabary("ojiiha")}" == conj("PL1EXCL", "SG3AN", tokill, verbTense, partofspeechc)
assertTrue "", "${su.tsalagiToSyllabary("ejiiha")}" == conj("PL2", "SG3AN", tokill, verbTense, partofspeechc)
assertTrue "", "${su.tsalagiToSyllabary("anihia")}" == conj("PL3", "SG3AN", tokill, verbTense, partofspeechc)
assertTrue "", "${su.tsalagiToSyllabary("gajiiha")}" == conj("SG1", "PL3AN", tokill, verbTense, partofspeechc)
assertTrue "", "${su.tsalagiToSyllabary("gahiiha")}" == conj("SG2", "PL3AN", tokill, verbTense, partofspeechc)
assertTrue "", "${su.tsalagiToSyllabary("dagohia")}" == conj("SG3", "PL3AN", tokill, verbTense, partofspeechc)
assertTrue "", "${su.tsalagiToSyllabary("geniiha")}" == conj("DL1INCL", "PL3AN", tokill, verbTense, partofspeechc)
assertTrue "", "${su.tsalagiToSyllabary("gosdiiha")}" == conj("DL1EXCL", "PL3AN", tokill, verbTense, partofspeechc)
assertTrue "", "${su.tsalagiToSyllabary("gesdiiha")}" == conj("DL2", "PL3AN", tokill, verbTense, partofspeechc)
assertTrue "", "${su.tsalagiToSyllabary("gediiha")}" == conj("PL1INCL", "PL3AN", tokill, verbTense, partofspeechc)
assertTrue "", "${su.tsalagiToSyllabary("gojiiha")}" == conj("PL1EXCL", "PL3AN", tokill, verbTense, partofspeechc)
assertTrue "", "${su.tsalagiToSyllabary("gejiiha")}" == conj("PL2", "PL3AN", tokill, verbTense, partofspeechc)
assertTrue "", "${su.tsalagiToSyllabary("danihia")}" == conj("PL3", "PL3AN", tokill, verbTense, partofspeechc)"""

str.eachLine {
    println "println " + it.substring(it.indexOf(" == conj") + 4)
}