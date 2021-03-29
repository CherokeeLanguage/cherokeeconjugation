package net.cherokeedcitionary.core

import net.cherokeedcitionary.util.Tense
import net.cherokeedcitionary.verbal.containers.VerbFinalSuffixHolderObject
import net.cherokeedcitionary.verbal.containers.VerbInitialPrefixHolderObject
import net.cherokeedcitionary.verbal.containers.VerbNonFinalSuffixHolderObject
import net.cherokeedcitionary.verbal.stemming.Stemmer
import net.cherokeedcitionary.verbal.suffixes.Present

/**
 * Initial prefix -> pronoun prefixes -> reflexive prefix -> root -> nonfinal suffix -> final suffix
 */
class Verb extends Word {
    Stemmer stemmer
    Tense tense

    String root
    String rootEnding

    String wholeWord

    VerbInitialPrefixHolderObject initialPrefixHolder = new VerbInitialPrefixHolderObject()
    String pronominalHolder = ""
    String reflexivePrefixHolder = "" // TODO: need to create this object

    VerbNonFinalSuffixHolderObject nonFinalSuffixHolder = new VerbNonFinalSuffixHolderObject()
    VerbFinalSuffixHolderObject finalSuffixHolder = new VerbFinalSuffixHolderObject()

    String getWholeWord() {
        if (!wholeWord) {
            return pronominalHolder + reflexivePrefixHolder + root + rootEnding + Present.FINALSUFFIX// + nonFinalSuffixHolder + finalSuffixHolder
        } else {
            return wholeWord
        }
    }
}
