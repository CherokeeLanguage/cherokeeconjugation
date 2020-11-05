package cherokee.dictionary.affixes

import cherokee.conjugation.verbal.Verb

interface Affix {
    String toSyllabary(String baseReturnValue, Verb word)
    String toEnglish(String baseReturnValue, Verb word)
}