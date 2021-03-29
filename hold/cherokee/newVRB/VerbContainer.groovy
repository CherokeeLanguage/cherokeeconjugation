package cherokee.newVRB

import Tense
import VerbPrefixTableObject
import VerbPrefixTableSubject
import Stemmer
import PartOfSpeech
import VerbInitialPrefixHolderObject
import VerbReflexivePrefixHolderObject

class VerbContainer {
    // Tense
    Tense tense

    //what part of speech is this word
    PartOfSpeech partOfSpeech

    // Stemmer
    Stemmer stems

    // Subject
    VerbPrefixTableSubject verbSubject

    // Object
    VerbPrefixTableObject verbObject

    // Initial Prefix(es)
    VerbInitialPrefixHolderObject initialPrefix = new VerbInitialPrefixHolderObject()

    // Pronoun Prefix
    //    VerbPronounPrefixHolderObject pronounPrefix = new VerbPronounPrefixHolderObject()

    // Reflexive Prefix
    VerbReflexivePrefixHolderObject reflexivePrefix = new VerbReflexivePrefixHolderObject()

    // root
    // root ending (h,l,s,d, etc)
    // non-final suffix
    // final suffix

}
