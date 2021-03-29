package cherokee.conjugation.verbal

import RemotePast
import Tense
import Stemmer
import net.cherokeedictionary.transliteration.SyllabaryUtil

//this also needs to set syllabary where applicable - or adjust the Verb object so that it will generate syllabary later
class VerbFactory {
    public static Verb createVerb(Stemmer stem, Tense tense) {
        Verb v = new Verb()

        getRoot(stem, tense, v)

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
        //todo: fix this so that it strips the a then the h is the rootsuffix
        int lastLetterIndex = vstem.size() - 1
        String root = vstem.substring(0, lastLetterIndex)
        def lastLetter = "" + vstem.charAt(lastLetterIndex)

        if (lastLetter == 'a') {
            verb.finalSuffix.a = true;
            verb.verbRootLatinPhonetic = root
            verb.verbRootSuffixLatinPhonetic = lastLetter
        } else {
            println "last letter is $lastLetter"
        }
    }
}
