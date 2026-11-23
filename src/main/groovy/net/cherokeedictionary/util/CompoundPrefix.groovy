package net.cherokeedictionary.util

/**
 * Created by torr on 8/17/2015.
 */
class CompoundPrefix {
    PrefixTableSubject prefix1
    PrefixTableObject prefix2


    @Override
    public String toString() {
        return "${prefix1}${prefix2}"
    }
}
