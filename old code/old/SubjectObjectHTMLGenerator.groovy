package cherokee.dictionary.conjugation.old

import cherokee.dictionary.conjugation.conjugate.PrefixTableObject
import cherokee.dictionary.conjugation.conjugate.PrefixTableSubject

/**
 * Created by torr on 8/20/2015.
 */
println "<select id=\"subject\">"
PrefixTableSubject.values().each {
    println "<option id=\"${it}\">${it}</option>"
}
println "</select>"

println "<select id=\"object\">"
PrefixTableObject.values().each {
    println "<option id=\"${it}\">${it}</option>"
}
println "</select>"
