package cherokee.dictionary.affixes.prefixes.verb

import cherokee.dictionary.verb.conjugation.originalConjugation.PrefixTableObject
import cherokee.dictionary.verb.conjugation.originalConjugation.PrefixTableSubject

/**
 * Created by torr on 8/17/2015.
 */
class VerbCompoundPrefix {
    VerbPrefixTableSubject prefix1
    VerbPrefixTableObject prefix2

    String toString() {
        StringBuilder sb = new StringBuilder();
        sb << "prefix1 = $prefix1;"
        sb << "prefix2 = $prefix2;"
    }
}
