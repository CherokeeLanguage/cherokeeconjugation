package cherokee.dictionary.verb.conjugation.old

import cherokee.dictionary.conjugation.conjugate.PrefixTableObject
import cherokee.dictionary.conjugation.conjugate.PrefixTableSubject

/**
 * Created by torr on 8/20/2015.
 */
//println "<select id=\"subject\">"
//PrefixTableSubject.values().each {
//    println "<option id=\"${it}\">${it}</option>"
//}
//println "</select>"
//
//println "<select id=\"object\">"
//PrefixTableObject.values().each {
//    println "<option id=\"${it}\">${it}</option>"
//}
//println "</select>"
//




PrefixTableSubject.values().each {pts ->
    println "<tr>"
    PrefixTableObject.values().each {pto ->
        println "<td>\${conj(\"${pts}\", \"${pto}\", stemmer, verbTense, partofspeechc)}</td>"
    }
    println "</tr>"
}