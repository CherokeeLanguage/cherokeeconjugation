package net.cherokeedcitionary.verbal.processor

import net.cherokeedcitionary.core.Verb
import net.cherokeedcitionary.util.Morphemes
import net.cherokeedcitionary.util.VerbSet
import net.cherokeedcitionary.verbal.Prefix
import net.cherokeedcitionary.verbal.VerbCompoundPrefix
import net.cherokeedcitionary.verbal.VerbCompoundPrefixes
import net.cherokeedcitionary.verbal.rules.RuleLaryngealAlteration
import net.cherokeedcitionary.verbal.rules.RuleUW

class VerbPronominalPrefixProcessor {
    //TODO: rewrite this for both before and after reflexive prefixes
    static void processPrefixes(final Verb verb,
                               final VerbCompoundPrefix pref,
                               final VerbSet verbset,
                               String it ) {
        def returnPrefix = "";

        println "it is " + it

        def vs = verbset == VerbSet.A ? "" : "B"
        def verbPrefix = pref?.prefix2 ? "${pref?.prefix1}${pref?.prefix2}${vs}" as String : "${pref?.prefix1}${vs}" as String;

        def returnValue

        if (it != null && (it.startsWith("Ꭰ")
                || it.startsWith("Ꭱ")
                || it.startsWith("Ꭲ")
                || it.startsWith("Ꭳ")
                || it.startsWith("Ꭴ")
                || it.startsWith("Ꭵ"))) {

            //get the prefix from the table
            def tmpReturnPrefix = ((Prefix) VerbCompoundPrefixes.prefixes.get(verbPrefix))

            if (!tmpReturnPrefix) {
                tmpReturnPrefix = ((Prefix) VerbCompoundPrefixes.prefixes.get(verbPrefix.substring(0, verbPrefix.size() - 1)))
            }

            tmpReturnPrefix = tmpReturnPrefix?.preVowel

            if (tmpReturnPrefix) {
                //determine if last 1 or 2 characters need to be included in the conversion
                //if ends with gw then 2 - otherwise only 1
                def backspace = 1 //this is the count back that we need to get to the latin characters of the prefix
                if (tmpReturnPrefix.endsWith("gw")) {
                    backspace = 2
                }

                def prefixStart = tmpReturnPrefix.substring(0, tmpReturnPrefix.size() - backspace)
//                log prefixStart

                def prefixEnd = tmpReturnPrefix.substring(tmpReturnPrefix.size() - backspace)
//                log prefixEnd

                def fixedPrefix = Morphemes.fixPrefix(it.substring(0, 1), prefixEnd, it)
//                log(fixedPrefix)

                returnPrefix = prefixStart + fixedPrefix[0]
                it = fixedPrefix[1]
            }

            //TODO: isLiquid determinator - would this be by context?  or just a general certain verbs are regarding
            // liquids so we just check for those verbs?
            returnValue = new RuleUW().process(pref.prefix1, pref.prefix2, returnPrefix, verb.tense, false, it, verbset)
            if (!returnValue) {
                returnValue = returnPrefix + it
            }
        } else {
            returnPrefix = ((Prefix) VerbCompoundPrefixes.prefixes.get(verbPrefix))?.preConsonant

            if (!returnPrefix) {
                //remove the 'B'? why is this here?
                verbPrefix = verbPrefix.substring(0, verbPrefix.size() - 1)

                returnPrefix = ((Prefix) VerbCompoundPrefixes.prefixes.get(verbPrefix))?.preConsonant
            }

            //Montgomery-Anderson pp 208 -- 'No Set B prefixes trigger it [Laryngeal alternation].
            if (verbset != VerbSet.B) {
                //this will return something if it can - if not then the returnValue will be null and should be checked against
                returnValue = new RuleLaryngealAlteration().process(pref.prefix1, pref.prefix2, returnPrefix, verb.tense, false, it, verbset)
            }

            /*if (!returnValue && returnPrefix != null && it != null) {
                println "it is " + it
                println "returnPrefix  " + returnPrefix
//                returnValue = returnPrefix + it;
            }*/
        }

//        println "verb prefix " + returnPrefix
//        println "returnValue " + returnValue

//        if (!returnPrefix) {
//            println "returnPrefix " + returnPrefix
            verb.pronominalHolder = returnPrefix
//        }
    }
}
