package cherokee.dictionary.conjugation.affixes

import cherokee.dictionary.conjugation.wordFormation.Word

interface Affix {
    public String toSyllabary(baseReturnValue, Word word);
    public String toEnglish(baseReturnValue, Word word);
}