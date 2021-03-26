package cherokee.dictionary.verb.conjugation.old

import com.cobradoc.cherokee.SyllabaryUtil

/**
 * Created by torr on 8/18/2015.
 */

def parse = {
    def su = new SyllabaryUtil()
    println "${it} -- ${su.tsalagiToSyllabary(it)}"
}

parse "gasuhvsga"
parse "hasuhvsga"
parse "asuhvsga"
parse "inasuhvsga"
parse "osdasuhvsga"
parse "sdasuhvsga"
parse "idasuhvsga"
parse "ojasuhvsga"
parse "ijasuhvsga"
parse "anasuhvsga"
