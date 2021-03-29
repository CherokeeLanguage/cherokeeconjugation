package cherokee.conjugation.verbal;

import Tense;
import VerbPrefixTableObject;
import VerbPrefixTableSubject
import net.cherokeedictionary.transliteration.SyllabaryUtil

class Verb extends Word {
    VerbPrefixTableSubject verbSubject
    VerbPrefixTableObject verbObject

    VerbInitialPrefixHolderObject initialPrefix = new VerbInitialPrefixHolderObject()
//    VerbPronounPrefixHolderObject pronounPrefix = new VerbPronounPrefixHolderObject()
//    VerbReflexivePrefixHolderObject reflexivePrefix = new VerbReflexivePrefixHolderObject()

    String initialPrefixSyllabary
    String initialPrefixLatin

    String pronounPrefixSyllabary
    String pronounPrefixLatin

    String wholePrefixSyllabary
    String wholePrefixLatin

    String verbRootLatinPhonetic  //?
    String verbRootSyllabary   //?

    String verbRootSuffixLatinPhonetic // for examples like wohiha - where wonih is the root but /h/ is this part

    String verbNonFinalSuffixPhonetic
    String verbNonFinalSuffixSyllabary

    VerbNonFinalSuffixHolderObject nonFinalSuffix = new VerbNonFinalSuffixHolderObject()
    VerbFinalSuffixHolderObject finalSuffix = new VerbFinalSuffixHolderObject()

    Tense tense

    String wholeVerbSyll
    String wholeVerbLatinPhonetic

    /**
     * returns the whole conjugated verb in Latin/Phonetic
     * @return
     */
    public String getWholeWordPhonetic() {
        return SyllabaryUtil.parseSyllabary(getWholeWordSyllabary())
    }

    /**
     * returns the whole conjugated verb in Syllabary
     * @return
     */
    public String getWholeWordSyllabary() {
        def tmp = (verbNonFinalSuffixPhonetic ?: "") + verbRootSuffixLatinPhonetic  + finalSuffix.getTrueValue()
        return SyllabaryUtil.tsalagiToSyllabary(wholePrefixLatin ?: "") + verbRootSyllabary + SyllabaryUtil.tsalagiToSyllabary(tmp)
    }

    @Override
    public String toString() {
        return "Verb{" +
                "verbSubject=" + verbSubject +
                ", \nverbObject=" + verbObject +
                ", \ninitialPrefix=" + initialPrefix +
                ", \ninitialPrefixSyllabary='" + initialPrefixSyllabary + '\'' +
                ", \ninitialPrefixLatin='" + initialPrefixLatin + '\'' +
                ", \npronounPrefixSyllabary='" + pronounPrefixSyllabary + '\'' +
                ", \npronounPrefixLatin='" + pronounPrefixLatin + '\'' +
                ", \nwholePrefixSyllabary='" + wholePrefixSyllabary + '\'' +
                ", \n wholePrefixLatin='" + wholePrefixLatin + '\'' +
                ", \n verbRootLatinPhonetic='" + verbRootLatinPhonetic + '\'' +
                ", \n verbRootSyllabary='" + verbRootSyllabary + '\'' +
                ", \n verbRootSuffixLatinPhonetic='" + verbRootSuffixLatinPhonetic + '\'' +
                ", \n verbNonFinalSuffixPhonetic='" + verbNonFinalSuffixPhonetic + '\'' +
                ", \n verbNonFinalSuffixSyllabary='" + verbNonFinalSuffixSyllabary + '\'' +
                ", \n nonFinalSuffix=" + nonFinalSuffix +
                ", \n finalSuffix=" + finalSuffix +
                ", \n tense=" + tense +
                ", \n wholeVerbSyll='" + wholeVerbSyll + '\'' +
                ", \n wholeVerbLatinPhonetic='" + wholeVerbLatinPhonetic + '\'' +
                '}';
    }
}