package cherokee.dictionary.conjugation.conjugate

/**
 * Created by torr on 8/17/2015.
 */
class CompoundPrefix {
    PrefixTableSubject prefix1
    PrefixTableObject prefix2

    String toString() {
        StringBuilder sb = new StringBuilder();
        sb << "prefix1 = $prefix1;"
        sb << "prefix2 = $prefix2;"
    }
}
