package cherokee.dictionary.conjugation.affixes.processors

import cherokee.dictionary.conjugation.HolderWord
import SuffixHolderObject
import cherokee.dictionary.conjugation.conjugate.Tense
import com.cobradoc.cherokee.SyllabaryUtil

class FinalSuffixProcessor {
    public static String processFinalSuffixesRemove(data, SuffixHolderObject sho, Tense verbTense) {
        return data
    }

    public static String processFinalSuffixes(data, SuffixHolderObject sho, Tense verbTense) {
        def a = sho.a
        def di = sho.di
        def dina = sho.dina
        def dv = sho.dv
        def ei = sho.ei
        def esdi = sho.esdi
        def gwu = sho.gwu
        def hv = sho.hv
        def idi = sho.idi
        def isi = sho.isi
        def ju = sho.ju
        def ke = sho.ke
        def na = sho.na
        def oi = sho.oi
        def sgo = sho.sgo
        def vi = sho.vi

        def baseReturnValue = data;

        return baseReturnValue
    }

    //review because si and svi are not endings but vi after ni is svi and isi after ni is si
    def static lstEndings = ["esdi", "idi", "gwu", "si", "sgo", "ju", "ke" , "na", "hv", "isi", "dina", "dv", "svi", "vi", "oi", "ei", "di",  "a", "i"]
    def static finalEnding = ["g", "h", "t", "ts", "l", "y"]
    def vi = ["ᎥᎢ", "ᎬᎢ", "ᎲᎢ", "ᎸᎢ", "ᏅᎢ", "ᏋᎢ", "ᏒᎢ", "ᏛᎢ", "ᏢᎢ", "ᏨᎢ", "ᏮᎢ", "ᏴᎢ"]
    def ei = ["ᎡᎢ", "ᎨᎢ", "ᎮᎢ", "ᎴᎢ", "ᎺᎢ", "ᏁᎢ", "ᏇᎢ", "ᏎᎢ", "ᏕᎢ", "ᏞᎢ", "ᏤᎢ", "ᏪᎢ", "ᏰᎢ"]


    public static HolderWord removeFinalSuffix(String str) {
        HolderWord hw = new HolderWord()
        hw.syllabary = str
        removeFinalSuffix(hw)
        return hw
    }

    public static void removeFinalSuffix(HolderWord hw) {
        def su = new SyllabaryUtil()
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
    }
}
