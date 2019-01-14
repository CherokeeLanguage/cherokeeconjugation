package cherokee.dictionary.conjugation.processors


import cherokee.dictionary.conjugation.affixes.PrefixHolderObject
import cherokee.dictionary.conjugation.affixes.prefixes.PrefixDa
import cherokee.dictionary.conjugation.affixes.prefixes.PrefixDe
import cherokee.dictionary.conjugation.affixes.prefixes.PrefixDi
import cherokee.dictionary.conjugation.affixes.prefixes.PrefixE
import cherokee.dictionary.conjugation.affixes.prefixes.PrefixGa
import cherokee.dictionary.conjugation.affixes.prefixes.PrefixI
import cherokee.dictionary.conjugation.affixes.prefixes.PrefixJi
import cherokee.dictionary.conjugation.affixes.prefixes.PrefixNi
import cherokee.dictionary.conjugation.affixes.prefixes.PrefixWi
import cherokee.dictionary.conjugation.affixes.prefixes.PrefixYi
import cherokee.dictionary.conjugation.conjugate.Tense
import cherokee.dictionary.conjugation.wordFormation.Word
import com.cobradoc.cherokee.SyllabaryUtil

class VerbPrefixFactory {
    public static void process(Word word) {
//        PronounProcessor.addPronounPrefix(word, word.getSubjectObject())
        def str = processPrefixes(word)

        word.rootSyllabary = str
        word.rootLatin = new SyllabaryUtil().parseSyllabary(str)
    }

    public static String processPrefixes(word) {
        def baseReturnValue = "";
        def data = word.pronounPrefix.syllabary + word.rootSyllabary
        def pho = word.prefixHolderObject
        def verbTense = word.tense
        def de = pho.de

//        word.pronounPrefix.syllabary + word.rootSyllabary, word.prefixHolderObject, word.tense

        if (pho.ga) {
            baseReturnValue = new PrefixGa().toSyllabary(null, word);
        }

        if (pho.e) {
            baseReturnValue = new PrefixE().toSyllabary(baseReturnValue, word);
        }

        if (pho.i) {
            baseReturnValue = new PrefixI().toSyllabary(baseReturnValue, word);
        }

        if (pho.di) {
            baseReturnValue = new PrefixDi().toSyllabary(baseReturnValue, word);
        }

        if (pho.da) {
            baseReturnValue = new PrefixDa().toSyllabary(baseReturnValue, word);
        }

        if (pho.de) {
            baseReturnValue = new PrefixDe().toSyllabary(baseReturnValue, word);
        }

        if (pho.ni) {
            baseReturnValue = new PrefixNi().toSyllabary(baseReturnValue, word);
        }

        if (pho.wi) {
            baseReturnValue = new PrefixWi().toSyllabary(baseReturnValue, word);
        }

        if (pho.yi) {
            baseReturnValue = new PrefixYi().toSyllabary(baseReturnValue, word);
        }

        if (pho.ji) {
            baseReturnValue = new PrefixJi().toSyllabary(baseReturnValue, word);
        }

        if (baseReturnValue == '') {
            baseReturnValue = data;
        }

        return baseReturnValue
    }
}
