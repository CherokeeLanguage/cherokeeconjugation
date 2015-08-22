package cherokee.dictionary.conjugation.conjugate

import cherokee.dictionary.conjugation.rules.RulesProcessor
import cherokee.dictionary.conjugation.stem.Stemmer
import cherokee.dictionary.conjugation.stem.VerbTenseHolder

/**
 * Created by torr on 8/21/2015.
 */
class TransitiveProcessor {
    public void log(prints) {
        boolean isDebug = false;
        if (isDebug) {
            println prints
        }
    }

    def processPrefixes(//final PronominalPrefix pref,
                            final CompoundPrefix pref,
                            final VerbSet verbset,
                            String it ) {
        def returnPrefix = "";

        def vs = verbset == VerbSet.A ? "" : "B"

        if (it.startsWith("Ꭰ")
            || it.startsWith("Ꭱ")
            || it.startsWith("Ꭲ")
            || it.startsWith("Ꭳ")
            || it.startsWith("Ꭴ")
            || it.startsWith("Ꭵ")) {
            def verbPrefix ="${pref?.prefix1}${pref?.prefix2}${vs}" as String;


            //get the prefix from the table
            def tmpReturnPrefix = ((Prefix) CompoundPrefixes.prefixes.get(verbPrefix))

            if (!tmpReturnPrefix) {
                tmpReturnPrefix = ((Prefix) CompoundPrefixes.prefixes.get(verbPrefix.substring(0, verbPrefix.size() - 1)))
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
                log prefixStart

                def prefixEnd = tmpReturnPrefix.substring(tmpReturnPrefix.size() - backspace)
                log prefixEnd

                def fixedPrefix = Morphemes.fixPrefix(it.substring(0, 1), prefixEnd, it)
                log(fixedPrefix)

                returnPrefix = prefixStart + fixedPrefix[0]
                it = fixedPrefix[1]
            }
        } else {
            def prefices = "${pref.prefix1}${pref.prefix2}${vs}" as String

            returnPrefix = ((Prefix) CompoundPrefixes.prefixes.get(prefices))?.preConsonant

            if (!returnPrefix) {
                prefices = prefices.substring(0, prefices.size() - 1)

                returnPrefix = ((Prefix) CompoundPrefixes.prefixes.get(prefices))?.preConsonant
            }
        }

        if (!returnPrefix) {
            it = ""
        }

        return returnPrefix + it
    }

    def processTransitive(final String subject,
                          final String object,
                          final Stemmer stemmer,
                          final String tense,//verb tense
                          final VerbType verbType) { // vi or vt)
        VerbTenseHolder vth = new VerbTenseHolder(stemmer: stemmer)
        vth.process()

        def verbTense = Tense.valueOf(tense);

        def verbset = VerbSet.A

        //if du,nu,u,wu in 3rd sing present then set b rest are a
        def tempPresent3rd = stemmer.present3rd.syllabary
        if (tempPresent3rd.startsWith("Ꮪ")
                || tempPresent3rd.startsWith("Ꮔ")
                || tempPresent3rd.startsWith("Ꭴ")
                || tempPresent3rd.startsWith("Ꮽ")) {
            verbset = VerbSet.B
        }

        String verbToConjugate = ""

        switch (verbTense) {
            case Tense.PRESENT:
                verbToConjugate = vth.present;
                break;
            case Tense.REMOTE_PAST:
                verbToConjugate = vth.remotePast
                break;
            case Tense.FUTURE_COMMAND:
                verbToConjugate = vth.futureCommand
                break;
            case Tense.HABITUAL:
                verbToConjugate = vth.habitual
                break;
            case Tense.INFINITIVE:
                verbToConjugate = vth.infinitive
                break;
        }

        def compoundPrefix

        try {
            if (verbset == VerbSet.B) {
                try {
                    compoundPrefix = CompoundPrefixes."${subject}${object}B"
                } catch (Exception e) {
                    compoundPrefix = CompoundPrefixes."${subject}${object}"
                }
            } else {
                compoundPrefix = CompoundPrefixes."${subject}${object}"
            }
        } catch (Exception e) {
            //todo: need to throw this exception back out if anything goes wrong
            //todo: create new exception class to be thrown so we get the message back out
            compoundPrefix = null;
            println "part5 ${compoundPrefix}"
            throw e;
        }

        if (!compoundPrefix) {
            return null;
        }

        def returnValue = ""
        def presentTense = processPrefixes(compoundPrefix, verbset, verbToConjugate)
        presentTense = new RulesProcessor().processRules(null, null, PrefixTableSubject.valueOf(subject), PrefixTableObject.valueOf(object), Tense.valueOf(tense), false, presentTense, verbset)

        if (presentTense) {
            returnValue = presentTense
        }

//        println "${compoundPrefix.prefix1}${compoundPrefix.prefix2}"

        return returnValue
    }
}
