package cherokee.dictionary.conjugation.affixes.processors

import cherokee.dictionary.conjugation.HolderWord
import cherokee.dictionary.conjugation.affixes.NonFinalSuffixHolderObject
import cherokee.dictionary.conjugation.affixes.PrefixHolderObject
import cherokee.dictionary.conjugation.affixes.SuffixHolderObject
import cherokee.dictionary.conjugation.conjugate.Tense

class AffixProcessor {
    //this method is where the holder objects determine which affixes are added to the root object
    public static String processWordAdd(String data, PrefixHolderObject pho, NonFinalSuffixHolderObject nfsho, SuffixHolderObject fsho, Tense verbTense) {
        HolderWord hw = new HolderWord()
        hw.syllabary = data
        FinalSuffixProcessor.removeFinalSuffix(hw);

        data = PrefixProcessor.processPrefixes(data, pho, verbTense)
        data = NonFinalSuffixProcessor.processNonFinalSuffixes(data, nfsho, verbTense)
        data = FinalSuffixProcessor.processFinalSuffixes(data, fsho, verbTense)

        return data
    }

    //this method is where the affixes are removed leaving a root but a rudimentary definition of what the word means
    public static String processWordRemove(String data, PrefixHolderObject pho, NonFinalSuffixHolderObject nfsho, SuffixHolderObject fsho, Tense verbTense) {
        data = PrefixProcessor.processPrefixesRemove(data, pho, verbTense)
        data = NonFinalSuffixProcessor.processNonFinalSuffixesRemove(data, nfsho, verbTense)
        data = FinalSuffixProcessor.processFinalSuffixesRemove(data, fsho, verbTense)

        return data
    }
}
