package net.cherokeedcitionary.verbal

import net.cherokeedcitionary.util.PrefixObject
import net.cherokeedcitionary.util.PrefixSubject

/**
 * Created by torr on 8/17/2015.
 */
class VerbCompoundPrefix {
    PrefixSubject prefix1
    PrefixObject prefix2

    String toString() {
        StringBuilder sb = new StringBuilder();
        sb << "prefix1 = $prefix1;"
        sb << "prefix2 = $prefix2;"
    }
}
