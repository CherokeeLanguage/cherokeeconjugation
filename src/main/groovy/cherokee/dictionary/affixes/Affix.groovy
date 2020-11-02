package cherokee.dictionary.affixes

import cherokee.dictionary.word.Verb
import cherokee.dictionary.word.Word

interface Affix {
    String toSyllabary(String baseReturnValue, Verb word)
    String toEnglish(String baseReturnValue, Verb Word)
}