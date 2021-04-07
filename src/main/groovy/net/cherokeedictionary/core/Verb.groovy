package net.cherokeedictionary.core

import net.cherokeedictionary.stemmer.Stemmer
import net.cherokeedictionary.util.CompoundPrefix
import net.cherokeedictionary.util.Tense
import net.cherokeedictionary.util.VerbSet
import net.cherokeedictionary.verb.containers.VerbFinalSuffixHolderObject
import net.cherokeedictionary.verb.containers.VerbInitialPrefixHolderObject
import net.cherokeedictionary.verb.containers.VerbNonFinalSuffixHolderObject
import net.cherokeedictionary.verb.reflexive.ReflexiveHolderObject
import net.cherokeedictionary.verb.suffixes.Present


class Verb extends Word {
    Stemmer stemmer
    Tense tense

    VerbSet verbset
    CompoundPrefix compoundPrefix

    String root
    String rootEnding

    //this is everything - all of the prefixes, roots, suffixes, everything
    String wholeWord

    //this holds the pronoun prefix, reflexive prefix, and root all morphed into one
    String pronounReflexiveRoot

    ReflexiveHolderObject reflexiveHolderObject = new ReflexiveHolderObject()
    String reflexivePrefix

    VerbInitialPrefixHolderObject initialPrefixHolder = new VerbInitialPrefixHolderObject()
    String pronominalHolder = ""
    String reflexivePrefixHolder = "" // TODO: need to create this object

    VerbNonFinalSuffixHolderObject nonFinalSuffixHolder = new VerbNonFinalSuffixHolderObject()
    VerbFinalSuffixHolderObject finalSuffixHolder = new VerbFinalSuffixHolderObject()

    String getTenseValue() {
        switch (tense) {
            case Tense.PRESENT:
                return Present.FINALSUFFIX
        }

        return ""
    }

    @Override
    String toString() {
        return "Verb{" +
                "stemmer=" + stemmer +
                ", tense=" + tense +
                ", verbset=" + verbset +
                ", compoundPrefix=" + compoundPrefix +
                ", root='" + root + '\'' +
                ", rootEnding='" + rootEnding + '\'' +
                ", wholeWord='" + wholeWord + '\'' +
                ", pronounReflexiveRoot='" + pronounReflexiveRoot + '\'' +
                ", reflexiveHolderObject=" + reflexiveHolderObject +
                ", reflexivePrefix='" + reflexivePrefix + '\'' +
                ", initialPrefixHolder=" + initialPrefixHolder +
                ", pronominalHolder='" + pronominalHolder + '\'' +
                ", reflexivePrefixHolder='" + reflexivePrefixHolder + '\'' +
                ", nonFinalSuffixHolder=" + nonFinalSuffixHolder +
                ", finalSuffixHolder=" + finalSuffixHolder +
                '}';
    }
}
