package net.cherokeedictionary.core

import net.cherokeedictionary.util.PartOfSpeech
import net.cherokeedictionary.util.PrefixTableObject
import net.cherokeedictionary.util.PrefixTableSubject

class Word {
    PartOfSpeech partOfSpeech
    PrefixTableSubject subject
    PrefixTableObject object

    // F: presentation surface for the conjugated word (set by the facade /
    // pipeline after conjugation; equals wholeWord once the engine has run).
    String display
}
