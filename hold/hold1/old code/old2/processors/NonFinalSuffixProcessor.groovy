package cherokee.dictionary.hold.affixes.processors

import NonFinalSuffixHolderObject
import cherokee.dictionary.conjugation.affixes.suffixes.NonFinalSuffixDan
import cherokee.dictionary.conjugation.conjugate.Tense

class NonFinalSuffixProcessor {
    public static String processNonFinalSuffixesRemove(data, NonFinalSuffixHolderObject nfsho, Tense verbTense) {
        return data
    }
    public static String processNonFinalSuffixes(data, NonFinalSuffixHolderObject nfsho, Tense verbTense) {
        def dan = nfsho.dan
        def dohdan = nfsho.dohdan
        def e = nfsho.e
        def el = nfsho.el
        def g = nfsho.g
        def idol = nfsho.idol
        def ihi = nfsho.ihi
        def ilo = nfsho.ilo
        def ohn = nfsho.ohn

        def baseReturnValue = data;

        if (dan) {
            baseReturnValue = new NonFinalSuffixDan().toSyllabary(baseReturnValue, data, null, verbTense)
        }

        return baseReturnValue
    }


}
