package cherokee.dictionary.conjugation

import com.cobradoc.cherokee.SyllabaryUtil

/**
 * Created by torr on 8/18/2015.
 */

def parse = {
    def su = new SyllabaryUtil()
    println "${it} -- ${su.tsalagiToSyllabary(it)}"
}

parse "wa"
parse "we"
parse "wi"
parse "wo"
parse "wu"
parse "wv"