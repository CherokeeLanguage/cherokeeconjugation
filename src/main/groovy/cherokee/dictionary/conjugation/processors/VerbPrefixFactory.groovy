package cherokee.dictionary.conjugation.processors


import cherokee.dictionary.conjugation.affixes.PrefixHolderObject
import cherokee.dictionary.conjugation.affixes.prefixes.PrefixDe
import cherokee.dictionary.conjugation.affixes.prefixes.PrefixDi
import cherokee.dictionary.conjugation.affixes.prefixes.PrefixE
import cherokee.dictionary.conjugation.affixes.prefixes.PrefixGa
import cherokee.dictionary.conjugation.affixes.prefixes.PrefixI
import cherokee.dictionary.conjugation.affixes.prefixes.PrefixNi
import cherokee.dictionary.conjugation.affixes.prefixes.PrefixWi
import cherokee.dictionary.conjugation.affixes.prefixes.PrefixYi
import cherokee.dictionary.conjugation.conjugate.Tense
import cherokee.dictionary.conjugation.wordFormation.Word
import com.cobradoc.cherokee.SyllabaryUtil

class VerbPrefixFactory {
    public static void process(Word word) {
//        PronounProcessor.addPronounPrefix(word, word.getSubjectObject())
        def str = processPrefixes(word.pronounPrefix.syllabary + word.rootSyllabary, word.prefixHolderObject, word.tense)

        word.rootSyllabary = str
        word.rootLatin = new SyllabaryUtil().parseSyllabary(str)
    }

    public static String processPrefixes(data, PrefixHolderObject pho, Tense verbTense) {
        def baseReturnValue = "";
        def de = pho.de

        if (pho.ga) {
            baseReturnValue = new PrefixGa().toSyllabary(null, data, de, null);
        }

        if (pho.e) {
            baseReturnValue = new PrefixE().toSyllabary(null, data, de, null);
        }

        if (pho.i) {
            baseReturnValue = new PrefixI().toSyllabary(baseReturnValue, data, de, verbTense);
        }

        if (pho.di) {
            baseReturnValue = new PrefixDi().toSyllabary(baseReturnValue, data, de, verbTense);
        }

        if (pho.de) {
            baseReturnValue = new PrefixDe().toSyllabary(baseReturnValue, null, de, null);
        }

        if (pho.ni) {
            baseReturnValue = new PrefixNi().toSyllabary(baseReturnValue, data, de, verbTense);
        }

        if (pho.wi) {
            baseReturnValue = new PrefixWi().toSyllabary(baseReturnValue, data, de, verbTense);
        }

        if (pho.yi) {
            baseReturnValue = new PrefixYi().toSyllabary(baseReturnValue, data, de, verbTense);
        }

        if (baseReturnValue == '') {
            baseReturnValue = data;
        }

        return baseReturnValue
    }
}
