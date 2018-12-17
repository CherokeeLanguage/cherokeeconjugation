package cherokee.dictionary.conjugation.wordFormation

import cherokee.dictionary.conjugation.conjugate.PartOfSpeech
import cherokee.dictionary.conjugation.conjugate.Tense

class Word {
    //if a verb what tense is it
    Tense tense

    //what part of speech is this word
    PartOfSpeech partOfSpeech

    //verbs have initial prefixes
    HashSet<Affix> initialPrefixes = new HashSet<Affix>()

    //verbs have pronoun prefixes
    Affix pronounPrefix = new Affix()

    //verbs have reflexive prefixes
    HashSet<Affix> reflexivePrefixes = new HashSet<Affix>()

    //all words have rootSyllabary -- the word or verb root
    String rootSyllabary

    //all words have rootLatin -- the word or verb root
    String rootLatin

    //verbs have non-final suffixes
    HashSet<Affix> nonFinalSuffixes = new HashSet<Affix>()

    //verbs have final suffixes
    HashSet<Affix> finalSuffixes = new HashSet<Affix>()
}
