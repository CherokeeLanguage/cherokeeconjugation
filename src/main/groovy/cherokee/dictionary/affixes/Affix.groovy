package cherokee.dictionary.affixes

import cherokee.dictionary.word.Word

interface Affix {
    String toSyllabary(String baseReturnValue, Word word)
    String toEnglish(String baseReturnValue, Word Word)
}