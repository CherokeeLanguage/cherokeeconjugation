package net.cherokeedictionary.verb.affixes

import net.cherokeedictionary.core.Verb
import net.cherokeedictionary.verb.affixes.initialPrefixes.PrefixDe
import net.cherokeedictionary.verb.affixes.initialPrefixes.PrefixDi
import net.cherokeedictionary.verb.affixes.initialPrefixes.PrefixE
import net.cherokeedictionary.verb.affixes.initialPrefixes.PrefixGa
import net.cherokeedictionary.verb.affixes.initialPrefixes.PrefixI
import net.cherokeedictionary.verb.affixes.initialPrefixes.PrefixJi
import net.cherokeedictionary.verb.affixes.initialPrefixes.PrefixNi
import net.cherokeedictionary.verb.affixes.initialPrefixes.PrefixWi
import net.cherokeedictionary.verb.affixes.initialPrefixes.PrefixYi

class PrefixProcessor {
    static String process(Verb verb) {
        def baseReturnValue = "";

        def pho = verb.initialPrefixHolder

        def yi = pho.yi
        def ji = pho.ji
        def wi = pho.wi
        def ni = pho.ni
        def de = pho.de
        def da = pho.da
        def di = pho.di
        def i = pho.i
        def ga = pho.ga
        def e = pho.e

        if (ga) {
            baseReturnValue = new PrefixGa().toSyllabary(baseReturnValue, verb);
        }

        if (e) {
            baseReturnValue = new PrefixE().toSyllabary(baseReturnValue, verb);
        }

        if (i) {
            baseReturnValue = new PrefixI().toSyllabary(baseReturnValue, verb);
        }

        if (di) {
            baseReturnValue = new PrefixDi().toSyllabary(baseReturnValue, verb);
        }

        if (de) {
//            baseReturnValue = new PrefixDe().toSyllabary(baseReturnValue, verb);
        }

        if (ni) {
            baseReturnValue = new PrefixNi().toSyllabary(baseReturnValue, verb);
        }

        if (wi) {
            baseReturnValue = new PrefixWi().toSyllabary(baseReturnValue, verb);
        }

        if (ji) {
            baseReturnValue = new PrefixJi().toSyllabary(baseReturnValue, verb)
        }

        //DONE 1 Apr 21
        if (yi) {
            println "yi"
            baseReturnValue = new PrefixYi().toSyllabary(baseReturnValue, verb);
        }

        if (baseReturnValue == '') {
            baseReturnValue = verb.pronounReflexiveRoot;
        }

        return baseReturnValue
    }
}
