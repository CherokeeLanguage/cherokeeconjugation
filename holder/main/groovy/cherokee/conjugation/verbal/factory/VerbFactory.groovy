package cherokee.conjugation.verbal.factory


import cherokee.conjugation.verbal.suffixes.RemotePast
import cherokee.conjugation.verbal.enums.Tense
import cherokee.conjugation.verbal.Verb
import cherokee.conjugation.verbal.stemming.Stemmer
import net.cherokeedictionary.transliteration.SyllabaryUtil

//this also needs to set syllabary where applicable - or adjust the Verb object so that it will generate syllabary later
class VerbFactory {
    public static Verb createVerb(Stemmer stem, Tense tense) {
        Verb v = new Verb()

        getRoot(stem, tense, v)

        return v
    }

    public static Verb createVerb(String cherokeeSyllabary, Tense tense) {
        Verb v = new Verb()

        return v
    }

    public static void getRoot(Stemmer stem, Tense type, Verb verb) {
        String vstem = SyllabaryUtil.parseSyllabary(stem.getStem(type))

        if (type == Tense.REMOTE_PAST) {
            processPast(vstem, verb)
        } else if (type == Tense.PRESENT) {
            processPresent(vstem, verb)
        }
    }

    private static void processPast(String vstem, Verb verb) {
        String root = vstem.substring(0, vstem.indexOf("vi"))
        def lastNumber = root.size() - 1
        def lastChar = root.charAt(lastNumber)

        if (RemotePast.ROOTENDINGS.contains("" + lastChar)) {
            root = root.substring(0, lastNumber)
            verb.finalSuffix.vi = true
        }

        verb.verbRootLatinPhonetic = root
        verb.verbRootSuffixLatinPhonetic = lastChar as String
    }

    private static void processPresent(vstem, verb) {
        int lastLetterIndex = vstem.size() - 1
        String root = vstem.substring(0, lastLetterIndex)
        def lastLetter = "" + vstem.charAt(lastLetterIndex)
        def lastRootLetterIndex = root.size()-1

        if (lastLetter == 'a') {
            verb.finalSuffix.a = true;
            verb.verbRootLatinPhonetic = root.substring(0, lastRootLetterIndex)
            verb.verbRootSuffixLatinPhonetic = root.substring(lastRootLetterIndex)
        } else {
            println "last letter is $lastLetter"
        }
    }
}
