package cherokee.dictionary.conjugation.affixes

interface Affix {
    public String toSyllabary(baseReturnValue, data, de, verbTense);
    public String toEnglish(baseReturnValue, data, de, verbTense);
}