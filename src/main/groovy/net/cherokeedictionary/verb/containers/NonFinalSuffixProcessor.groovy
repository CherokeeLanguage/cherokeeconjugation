package net.cherokeedictionary.verb.containers

import net.cherokeedictionary.core.Verb
import net.cherokeedictionary.verb.affixes.nonFinalSuffixes.NonFinalSuffixDan

class NonFinalSuffixProcessor {
    public static String processNonFinalSuffixesRemove(data, Verb verb) {
        return data
    }
    public static String process(Verb verb) {
        def dan = verb.nonFinalSuffixHolder.dan
        def dohdan = verb.nonFinalSuffixHolder.dohdan
        def e = verb.nonFinalSuffixHolder.e
        def el = verb.nonFinalSuffixHolder.el
        def g = verb.nonFinalSuffixHolder.g
        def idol = verb.nonFinalSuffixHolder.idol
        def ihl = verb.nonFinalSuffixHolder.ihl
        def ilo = verb.nonFinalSuffixHolder.ilo
        def ohn = verb.nonFinalSuffixHolder.ohn

        String baseReturnValue = verb.wholeWord

        if (dan) {
            baseReturnValue = new NonFinalSuffixDan().toSyllabary(baseReturnValue, verb)
        }

        return baseReturnValue
    }
}
