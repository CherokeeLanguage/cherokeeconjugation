package net.cherokeedictionary.stem.lemma

import net.cherokeedictionary.conjugation.ConjugateBase
import net.cherokeedictionary.splitter.DoAnalysis
import net.cherokeedictionary.splitter.SuffixGuesser
import net.cherokeedictionary.stem.lemma.Lemmatizer
import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.CompoundPrefixes

//
//class AffixSplitterTest extends ConjugateBase  {
//    void testAffixSplitter() {
//        Lemmatizer afs = new Lemmatizer()

//        def sb = new StringBuilder()
//        sb << afs.processLine("ᏥᎪᏩᏘᎠ")
//        sb << afs.processLine("ᎤᎾᎳᏍᎦᎵᏗ")
//        sb << "\n\n"
//
//        sb << afs.processLine("ᏳᏟᎢᎶᏝ")
//        sb << "\n\n"
//        sb << afs.processLine("ᎠᏓᎴᏂᏍᎪ")
//        sb << "\n\n"
//        sb << afs.processLine("ᎠᎾᎳᏍᎦᎵᏍᎬᎢ")
//        sb << "\n\n"
//        sb << afs.processLine("ᏳᏫᏂᎦᏥᎪᏩᏘᎭ")

//        log(sb.toString())

//    }
//
//    void testYPrefix() {
        //he sees it
        def agowatiha = SyllabaryUtil.tsalagiToSyllabary("agowatiha")

        //he doesn't see it
        def hlaYagowatiha = SyllabaryUtil.tsalagiToSyllabary("hla yagowatiha")

        //I see it
        def jigowatiha = SyllabaryUtil.tsalagiToSyllabary("jigowatiha")

        //i don't see it
        def hlaYijigowatiha = SyllabaryUtil.tsalagiToSyllabary("hla yijigowatiha")

        //he sees it with his back turned (w- prefix)
        def wagowatiha = SyllabaryUtil.tsalagiToSyllabary("wagowatiha")

        //he doesn't see t with his back turned (w- prefix0
        def hlaYuwagowatiha = SyllabaryUtil.tsalagiToSyllabary("hla yuwagowatiha")

        //you see it
        def higowatiha = SyllabaryUtil.tsalagiToSyllabary("higowatiha")

        //you don't see it
        def hlaYigowatiha = SyllabaryUtil.tsalagiToSyllabary("hla yigowatiha")

        //he is speaking
        def gawoniha = SyllabaryUtil.tsalagiToSyllabary("gawoniha")

        //if he is speaking
        def yigawoniha = SyllabaryUtil.tsalagiToSyllabary("yigawoniha")

        //if he spoke
        def yuwonisa = SyllabaryUtil.tsalagiToSyllabary("yuwonisa")

//        def doanalysis = new DoAnalysis()
//        def lst = doanalysis.analyze(SyllabaryUtil.tsalagiToSyllabary("yijigowatiha") as String)
//
////        def sg = SuffixGuesser.INSTANCE
////        def lst = sg.getMatches(SyllabaryUtil.tsalagiToSyllabary("yijigowatiha") as String)
//        lst.each {
//            println it
//        }
//    }

class Aprefix {

}

class Aaffix {
    String syllabary
    String transliteratedValue
    List prefixList
    String root
    String rootEnding
    List suffixList
}

def getPronounPrefix(value) {
    def pronounPrefixOptions = []
    def returnValue = value
    def prefixSize = 0
    def continueParsing = true
    CompoundPrefixes.prefixes.each {key, val ->
        if (continueParsing) {
            def preVowel = SyllabaryUtil.parseSyllabaryWithPunctuationAndLatin(val.preVowel)
            def preConsonant = SyllabaryUtil.parseSyllabaryWithPunctuationAndLatin(val.preConsonant)
            if (preConsonant != "") {
                if (value.startsWith(preConsonant)) {
//                println "found before consonant"
//                println preConsonant
                    prefixSize = preConsonant.size()
                    pronounPrefixOptions << key
                    continueParsing = false
                } else if (value.startsWith(preVowel)) {
//                println preVowel
//                println "found before vowel"
                    pronounPrefixOptions << key
                    prefixSize = preVowel.size()
                    continueParsing = false
                }
            }
        }
    }
    returnValue = returnValue.substring(prefixSize)
    println returnValue

    return [returnValue, pronounPrefixOptions]
}

def splitAffix(verbToSplit) {
    def transliterated = SyllabaryUtil.parseSyllabary(verbToSplit)
    def tornDownValue = transliterated
    def aafix = new Aaffix()
    def prefixList = []
    aafix.syllabary = verbToSplit
    aafix.transliteratedValue = transliterated

    println transliterated

    //split hla

    //split y
    if (tornDownValue.startsWith("yi") || tornDownValue.startsWith("yuw") || tornDownValue.startsWith("y")) {
        prefixList << "negative/conditional"
        if (tornDownValue.startsWith("yi") || tornDownValue.startsWith("yuw")) {
            tornDownValue = transliterated.substring(2)
        } else if (tornDownValue.startsWith("y")) {
            tornDownValue = transliterated.substring(1)
        }
    }

    //split j/ts
    if (tornDownValue.startsWith("tsi") || tornDownValue.startsWith("tsuw") || tornDownValue.startsWith("ts")) {
        // have to check for pronominal prefixes too so this isn't accidentally categorized
        prefixList << "specific past time/negative imperative/again imperative"
        if (tornDownValue.startsWith("tsi") || tornDownValue.startsWith("tsuw")) {
            tornDownValue = transliterated.substring(2)
        } else if (tornDownValue.startsWith("ts")) {
            tornDownValue = transliterated.substring(1)
        }
    }

    //split w
    if (tornDownValue.startsWith("w")) {
        prefixList << "position or motion away from speaker"

        if (tornDownValue.startsWith("wi")) {
            tornDownValue  = tornDownValue.substring(2)
        } else if (tornDownValue.startsWith("w")) {
            tornDownValue  = tornDownValue.substring(1)
        }
    }

    //split n
    if (tornDownValue.startsWith("n")) {
        //if tornDownValue endswith 'na' then it's negative -- but if it doesn't start with n- but ends with -na then it's something else
        if (tornDownValue.endsWith("na")) {
            prefixList << "negative"
        } else {
            prefixList << "lateral position/already"
        }

        if (tornDownValue.startsWith("ni")) {
            tornDownValue  = tornDownValue.substring(2)
        } else if (tornDownValue.startsWith("n")) {
            tornDownValue  = tornDownValue.substring(1)
        }
    }

    //split de
    //split da
    //split da
    //split di
    //split i
    //split ga
    //split e

    prefixList.each {
        println it
    }

    aafix.prefixList = prefixList
    def pronPref = getPronounPrefix(tornDownValue)
    println pronPref[0]
    println pronPref[1]
}
//}

splitAffix(yuwonisa)
splitAffix(yigawoniha)
splitAffix(jigowatiha)
splitAffix(SyllabaryUtil.tsalagiToSyllabary("nagowatisgva"))
splitAffix(SyllabaryUtil.tsalagiToSyllabary("nagowatisgvna"))

//def pv = getPronounPrefix("tsigowatiha")
//println pv[0]
//println pv[1]

//need to check that the reflexive isn't next
//def pv2 = getPronounPrefix("tsadagowatiha")
//println pv2[0]
//println pv2[1]

