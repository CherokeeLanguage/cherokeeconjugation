package cherokee.conjugation.verbal

import VerbPrefixTableObject
import VerbPrefixTableSubject

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
