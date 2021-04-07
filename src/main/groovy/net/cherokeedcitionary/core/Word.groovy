package net.cherokeedcitionary.core

import net.cherokeedcitionary.util.PartOfSpeech
import net.cherokeedcitionary.util.PrefixObject
import net.cherokeedcitionary.util.PrefixSubject
import net.cherokeedcitionary.util.Tense
import net.cherokeedcitionary.verbal.stemming.Stemmer

class Word {
    PartOfSpeech partOfSpeech
    PrefixSubject subject
    PrefixObject object
}
