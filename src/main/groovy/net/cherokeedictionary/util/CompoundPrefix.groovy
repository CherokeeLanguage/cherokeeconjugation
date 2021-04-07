package net.cherokeedictionary.util

/**
 * Created by torr on 8/17/2015.
 */
class CompoundPrefix {
    PrefixTableSubject subject
    PrefixTableObject object
    Prefix prefix

    String toString() {
        StringBuilder sb = new StringBuilder();
        sb << "prefix1 = $subject;"
        sb << "prefix2 = $object;"
    }
}
