package cherokee.dictionary.conjugation.affixes

import cherokee.dictionary.conjugation.wordFormation.Word

interface Affix {
    public String toSyllabary(String baseReturnValue, Word word);
    public String toEnglish(String baseReturnValue, Word word);
}