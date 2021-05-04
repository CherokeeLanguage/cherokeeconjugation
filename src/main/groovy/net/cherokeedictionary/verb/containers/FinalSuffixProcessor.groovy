package net.cherokeedictionary.verb.containers

import net.cherokeedictionary.core.Verb
import net.cherokeedictionary.util.Tense

class FinalSuffixProcessor {
    public static String processFinalSuffixesRemove(data, VerbFinalSuffixHolderObject sho, Tense verbTense) {
        return data
    }

    public static String process(Verb verb) {
        def a = verb.finalSuffixHolder.a
        def di = verb.finalSuffixHolder.di
        def dina = verb.finalSuffixHolder.dina
        def dv = verb.finalSuffixHolder.dv
        def ei = verb.finalSuffixHolder.ei
        def esdi = verb.finalSuffixHolder.esdi
        def gwu = verb.finalSuffixHolder.gwu
        def hv = verb.finalSuffixHolder.hv
        def idi = verb.finalSuffixHolder.idi
        def isi = verb.finalSuffixHolder.isi
        def ju = verb.finalSuffixHolder.ju
        def ke = verb.finalSuffixHolder.ke
        def na = verb.finalSuffixHolder.na
        def oi = verb.finalSuffixHolder.oi
        def sgo = verb.finalSuffixHolder.sgo
        def vi = verb.finalSuffixHolder.vi

        def baseReturnValue = verb.wholeWord

        return baseReturnValue
    }

    //review because si and svi are not endings but vi after ni is svi and isi after ni is si
    def static lstEndings = ["esdi", "idi", "gwu", "si", "sgo", "ju", "ke" , "na", "hv", "isi", "dina", "dv", "svi", "vi", "oi", "ei", "di",  "a", "i"]
    def static finalEnding = ["g", "h", "t", "ts", "l", "y"]
    def vi = ["ᎥᎢ", "ᎬᎢ", "ᎲᎢ", "ᎸᎢ", "ᏅᎢ", "ᏋᎢ", "ᏒᎢ", "ᏛᎢ", "ᏢᎢ", "ᏨᎢ", "ᏮᎢ", "ᏴᎢ"]
    def ei = ["ᎡᎢ", "ᎨᎢ", "ᎮᎢ", "ᎴᎢ", "ᎺᎢ", "ᏁᎢ", "ᏇᎢ", "ᏎᎢ", "ᏕᎢ", "ᏞᎢ", "ᏤᎢ", "ᏪᎢ", "ᏰᎢ"]

/*
    public static HolderWord removeFinalSuffix(String str) {
        HolderWord hw = new HolderWord()
        hw.syllabary = str
        removeFinalSuffix(hw)
        return hw
    }

    public static void removeFinalSuffix(HolderWord hw) {
        def su = SyllabaryUtil
        String tsalagi = su.parseSyllabary(hw.syllabary)
        boolean endingAlready = false
        lstEndings.each { finals ->
            if (tsalagi.endsWith(finals) && !endingAlready) {
                endingAlready = true
                tsalagi = tsalagi.substring(0, tsalagi.lastIndexOf(finals))
                finalEnding.each {
                    if (tsalagi.endsWith(it)) {
                        hw.nonfinalEndingLatin = it
                        hw.syllabary = su.tsalagiToSyllabary(tsalagi.substring(0, tsalagi.size() - it.size()))
                        hw.finalEndingSyllabary = su.tsalagiToSyllabary(finals)
                        hw.finalEndingLatin = finals
                    }
                }

                if (!hw.nonfinalEndingLatin) {
                    hw.nonfinalEndingLatin = ""
                    hw.syllabary = su.tsalagiToSyllabary(tsalagi)
                    hw.finalEndingSyllabary = su.tsalagiToSyllabary(finals)
                    hw.finalEndingLatin = finals
                }
            }
        }

        // if there is nothing then return nothing and not nulls -- some conjugations don't have anything
        if (!hw.nonfinalEndingLatin && !hw.syllabary & !hw.finalEndingSyllabary && !hw.finalEndingLatin) {
            hw.nonfinalEndingLatin = ""
            hw.syllabary = ""
            hw.finalEndingSyllabary = ""
            hw.finalEndingLatin = ""
        }
    }*/
}
