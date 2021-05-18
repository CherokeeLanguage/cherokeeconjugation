package net.cherokeedictionary.verb.conjugation

import net.cherokeedictionary.core.Verb
import net.cherokeedictionary.util.*
import net.cherokeedictionary.verb.affixes.ReflexivePrefix
import net.cherokeedictionary.verb.rules.RuleLaryngealAlteration
import net.cherokeedictionary.verb.rules.RuleUW

/**
 * Created by torr on 8/23/2015.
 */
class VerbConjugationProcessor {
    static void log(prints) {
        boolean isDebug = false;
        if (isDebug) {
            println prints
        }
    }

    static def processPrefixes(//final PronominalPrefix pref,
                               final Verb verb,
                               String it ) {
        def returnPrefix = "";

        final CompoundPrefix pref = verb.compoundPrefix
        final VerbSet verbset = verb.verbset
        final Tense tense = verb.tense

        def vs = verbset == VerbSet.A ? "" : "B"
        def verbPrefix = pref?.prefix2 ? "${pref?.prefix1}${pref?.prefix2}${vs}" as String : "${pref?.prefix1}${vs}" as String;

        def returnValue

        if (it != null && StringUtility.startsWithVowelSyllabary(it)) {
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
//                log prefixStart

                def prefixEnd = tmpReturnPrefix.substring(tmpReturnPrefix.size() - backspace)
//                log prefixEnd

                def fixedPrefix = Morphemes.fixPrefix(it.substring(0, 1), prefixEnd, it)
//                log(fixedPrefix)

                returnPrefix = prefixStart + fixedPrefix[0]
                it = fixedPrefix[1]
            }

            returnValue = new RuleUW().process(pref.prefix1, pref.prefix2, returnPrefix, tense, false, it, verbset)
            if (!returnValue) {
                returnValue = returnPrefix + it
            }
        } else {
            returnPrefix = ((Prefix) CompoundPrefixes.prefixes.get(verbPrefix))?.preConsonant

            if (!returnPrefix) {
                //remove the 'B'? why is this here?
                verbPrefix = verbPrefix.substring(0, verbPrefix.size() - 1)

                returnPrefix = ((Prefix) CompoundPrefixes.prefixes.get(verbPrefix))?.preConsonant
            }

            //Montgomery-Anderson pp 208 -- 'No Set B prefixes trigger it [Laryngeal alternation].
            if (verbset != VerbSet.B) {
                //this will return something if it can - if not then the returnValue will be null and should be checked against
                returnValue = new RuleLaryngealAlteration().process(pref.prefix1, pref.prefix2, returnPrefix, tense, false, it, verbset)
            }

            if (!returnValue && returnPrefix != null && it != null) {
                verb.pronominalHolder = returnPrefix
                verb.root = it
                returnValue = returnPrefix + it;
            }
        }

        if (!returnPrefix) {
            returnValue = ""
        }

        return returnValue
    }

    static def process(Verb verb) {
        VerbTenseHolder vth = new VerbTenseHolder(stemmer: verb.stemmer)
        vth.process()
//        def verbTense = Tense.valueOf(tense);
        //todo: find prefix for plurals (e.G. d-) -- probably detect if verb starts with /d-/ if it does then add a /d-/
        // - should wait until other prefixes are put together in whole? timo 22Sep15

        //this column matches - so intransitive specific code was removed in favor of using existing code and keys
        if (verb.partOfSpeech == PartOfSpeech.VERB_INTRANSITIVE) {
            verb.object = PrefixTableObject.valueOf("SG3IN")
        }

        def combinedSubjectObject = "${verb.subject}${verb.object}"

//        if (combinedSubjectObject == "SG3SG3AN" && verb.tense == Tense.PRESENT && !verb.reflexiveHolderObject.isReflexive()) {
//            return verb.stemmer.present3rd.syllabary;
//        }

        if (combinedSubjectObject == "SG3SG3AN" && verb.tense == Tense.PRESENT && !verb.reflexiveHolderObject.isReflexive()) {
            return verb.stemmer.present3rd.syllabary;
        }

        def verbset = VerbSet.A

        //if du,nu,u,wu in 3rd sing present then set b rest are a
        def tempPresent3rd = verb.stemmer.present3rd.syllabary
        if (tempPresent3rd.startsWith("Ꮪ")
                || tempPresent3rd.startsWith("Ꮔ")
                || tempPresent3rd.startsWith("Ꭴ")
                || tempPresent3rd.startsWith("Ꮽ")) {
            verbset = VerbSet.B
        }

        String verbToConjugate = ""

        switch (verb.tense) {
            case Tense.PRESENT:
                verbToConjugate = vth.present;
                break;
            case Tense.REMOTE_PAST:
                verbToConjugate = vth.remotePast
                //remote past always starts with B - Durbin Feeling book pp21
                verbset = VerbSet.B
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
                    compoundPrefix = CompoundPrefixes."${combinedSubjectObject}B"
                } catch (Exception e) {
                    compoundPrefix = CompoundPrefixes."${combinedSubjectObject}"
                }
            } else {
                compoundPrefix = CompoundPrefixes."${combinedSubjectObject}"
            }
        } catch (Exception e) {
            //todo: need to throw this exception back out if anything goes wrong
            //todo: create new exception class to be thrown so we get the message back out
            compoundPrefix = null;
            throw e;
        }

        if (!compoundPrefix) {
            return null;
        }

        def returnValue = ""

        verb.compoundPrefix = compoundPrefix
        verb.verbset = verbset

        verbToConjugate = new ReflexivePrefix().toSyllabary(verbToConjugate, verb)
        if (!verb.reflexiveHolderObject.isReflexive()) {
            verbToConjugate = processPrefixes(verb, verbToConjugate)
            def lst = verb.stemmer.getRootWithEnding(verb.tense)
            //TODO: write more tests to cover this and make sure the values are correct
            verb.root = lst[0]
            verb.rootEnding = lst[1]
        }

        if (verbToConjugate) {
            returnValue = verbToConjugate
        }

        return returnValue
    }
}
