package cherokee.old.word

import cherokee.dictionary.affixes.prefixes.verb.VerbPrefixTableObject
import cherokee.dictionary.affixes.prefixes.verb.VerbPrefixTableSubject
import cherokee.dictionary.utils.PartOfSpeech
import cherokee.dictionary.verb.conjugation.originalConjugation.Tense
import com.cobradoc.cherokee.SyllabaryUtil

class WholeWord {
}

abstract class Word {
    //what part of speech is this word
    PartOfSpeech partOfSpeech
}

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
        return new SyllabaryUtil().parseSyllabary(getWholeWordSyllabary())
    }

    /**
     * returns the whole conjugated verb in Syllabary
     * @return
     */
    public String getWholeWordSyllabary() {
        def tmp = verbNonFinalSuffixPhonetic + verbRootSuffixLatinPhonetic  + finalSuffix.getTrueValue()
        return new SyllabaryUtil().tsalagiToSyllabary(wholePrefixLatin) + verbRootSyllabary + new SyllabaryUtil().tsalagiToSyllabary(tmp)
    }
}

abstract class HolderObjectBase {
    def map = [:]
    public boolean allFalse() {
        map.each {it ->
            if (it.value) {
                return false
            }
        }
    }

    //TODO: should there be more than one returned
    public List getTrueValues() {
        List<String> returnValue = []
        map.each {it ->
            if (it.value) {
                returnValue << it.key
            }
        }

        return returnValue
    }

//        @Override
//    void setProperty(String name, Object value) {
////        if (map.size() == 0) {
////            println "mapsize si 0"
////            setMap(["yi":false, "ji":false, "wi": false, "ni":false, "de":false, "da":false, "di":false, "i":false, "ga":false, "e":false])
////        }
//
//
//
//        if (map.containsKey(name)) {
//            setValue(name, value)
//        }
//    }

//    abstract void setValue(key, value)
}

//todo: can I add a listener annotation that will determine if a field is update and if it is then update a map?
class VerbInitialPrefixHolderObject extends HolderObjectBase {
    public VerbInitialPrefixHolderObject(Closure closure) {
        setMap(["yi":yi, "ji":ji, "wi": wi, "ni":ni, "de":de, "da":da, "di":di, "i":i, "ga":ga, "e":e])
    }

    def yi = false
    def ji = false
    def wi = false
    def ni = false
    def de = false
    def da = false
    def di = false
    def i = false
    def ga = false
    def e = false

    //pronounPrefixes can consist of syllabary alone or syllabary and a latin script - the sounds in cherokee since cherokee was oral for millennia before written 200 years ago
    // mean that the awkward computerization transliteration of ᎠᏂ before consonants and Ꭰn before vowels requires a split into ᎠᏂ for syllabary and nothing in latin
    // but Ꭰ for syllabary and n for latin - which will provide morphemes and at times ellison for some prefix rules



    @Override
    public String toString() {
        return "VerbInitialPrefixHolderObject{" +
                "yi=" + yi +
                ", ji=" + ji +
                ", wi=" + wi +
                ", ni=" + ni +
                ", de=" + de +
                ", da=" + da +
                ", di=" + di +
                ", i=" + i +
                ", ga=" + ga +
                ", e=" + e +
                '}';
    }
}

class VerbNonFinalSuffixHolderObject extends HolderObjectBase {
    boolean dan = false
    boolean dohdan = false
    boolean e  = false
    boolean el  = false
    boolean g  = false
    boolean idol  = false
    boolean ihi  = false
    boolean ilo   = false
    boolean ohn = false


    public String getTrueValue() {
        map = ["dan": dan, "dohdan": dohdan, "e": e, "el": el, "g": g, "idol": idol, "ihi": ihi, "ilo": ilo, "ohn": ohn]

        return getTrueValues().get(0)
    }

    @Override
    public String toString() {
        return "VerbNonFinalSuffixHolderObject{" +
                "dan=" + dan +
                ", dohdan=" + dohdan +
                ", e=" + e +
                ", el=" + el +
                ", g=" + g +
                ", idol=" + idol +
                ", ihi=" + ihi +
                ", ilo=" + ilo +
                ", ohn=" + ohn +
                '}';
    }
}

class VerbFinalSuffixHolderObject extends HolderObjectBase {
    def a = false
    def di = false
    def dina = false
    def dv = false
    def ei = false
    def esdi = false
    def gwu = false
    def hv = false
    def idi = false
    def isi = false
    def ju = false
    def ke = false
    def na = false
    def oi = false
    def sgo = false
    def vi = false

    public String getTrueValue() {
        map = ["a":a, "di":di, "dina":dina, "dv":dv, "ei":ei, "esdi":esdi, "gwu":gwu, "hv":hv, "idi":idi, "isi":isi, "ju":ju, "ke":ke, "na":na, "oi":oi, "sgo":sgo, "vi":vi]

        return getTrueValues().get(0)
    }

    @Override
    public String toString() {
        return "VerbFinalSuffixHolderObject{" +
                "a=" + a +
                ", di=" + di +
                ", dina=" + dina +
                ", dv=" + dv +
                ", ei=" + ei +
                ", esdi=" + esdi +
                ", gwu=" + gwu +
                ", hv=" + hv +
                ", idi=" + idi +
                ", isi=" + isi +
                ", ju=" + ju +
                ", ke=" + ke +
                ", na=" + na +
                ", oi=" + oi +
                ", sgo=" + sgo +
                ", vi=" + vi +
                '}';
    }
//
//    class VerbReflexivePrefixHolderObject extends HolderObjectBase {
//        def a = false
//        def di = false
//        def dina = false
//        def dv = false
//        def ei = false
//        def esdi = false
//        def gwu = false
//        def hv = false
//        def idi = false
//        def isi = false
//        def ju = false
//        def ke = false
//        def na = false
//        def oi = false
//        def sgo = false
//        def vi = false
//
//        public String getTrueValue() {
//            map = ["a":a, "di":di, "dina":dina, "dv":dv, "ei":ei, "esdi":esdi, "gwu":gwu, "hv":hv, "idi":idi, "isi":isi, "ju":ju, "ke":ke, "na":na, "oi":oi, "sgo":sgo, "vi":vi]
//
//            return getTrueValues().get(0)
//        }
//
//        @Override
//        public String toString() {
//            return "VerbFinalSuffixHolderObject{" +
//                    "a=" + a +
//                    ", di=" + di +
//                    ", dina=" + dina +
//                    ", dv=" + dv +
//                    ", ei=" + ei +
//                    ", esdi=" + esdi +
//                    ", gwu=" + gwu +
//                    ", hv=" + hv +
//                    ", idi=" + idi +
//                    ", isi=" + isi +
//                    ", ju=" + ju +
//                    ", ke=" + ke +
//                    ", na=" + na +
//                    ", oi=" + oi +
//                    ", sgo=" + sgo +
//                    ", vi=" + vi +
//                    '}';
//        }
}