package net.cherokeedictionary.verb.affixes

import net.cherokeedictionary.core.Verb

interface Affix {
    //TODO: refactor so just the verb is passed in -- and then the verb.pronounReflexiveRoot is updated
    //      also is there some better way to store the morphemes that make sense so in the end the wholeWord can just be pieced together?
    String toSyllabary(String baseReturnValue, Verb verb)

    String toEnglish(String baseReturnValue, Verb verb)
}