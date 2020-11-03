package cherokee.dictionary.verb.conjugation.originalconjugation

import cherokee.dictionary.affixes.prefixes.verb.VerbPrefixTableObject
import cherokee.dictionary.affixes.prefixes.verb.VerbPrefixTableSubject
import cherokee.dictionary.utils.Morphemes
import cherokee.dictionary.utils.PartOfSpeech
import cherokee.dictionary.verb.conjugation.originalconjugation.rules.RuleLaryngealAlteration
import cherokee.dictionary.verb.conjugation.originalconjugation.rules.RuleUW
import cherokee.dictionary.word.Verb
import cherokee.dictionary.word.VerbFinalSuffixHolderObject
import com.cobradoc.cherokee.SyllabaryUtil


/**
 * Created by torr on 8/23/2015.
 */
class VerbConjugationProcessor {
    public void log(prints) {
        boolean isDebug = false;
        if (isDebug) {
            println prints
        }
    }

    static def processPrefixes(//final PronominalPrefix pref,
                        final CompoundPrefix pref,
                        final VerbSet verbset,
                        final Tense tense,
                        String it ) {
        def returnPrefix = "";

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
                returnValue = returnPrefix + it;
            }
        }

        if (!returnPrefix) {
            returnValue = ""
        }

        return returnValue
    }



    //returns a String object of the entire verb conjugated with pronoun prefix
    static def process(final String subject,
                String object,
                final Stemmer stemmer,
                final String tense,
                final VerbType verbType) {
        VerbTenseHolder vth = new VerbTenseHolder(stemmer: stemmer)
        vth.process()
        def verbTense = Tense.valueOf(tense);
        //todo: find prefix for plurals (e.G. d-) -- probably detect if verb starts with /d-/ if it does then add a /d-/
        // - should wait until other prefixes are put together in whole? timo 22Sep15

        //this column matches - so intransitive specific code was removed in favor of using existing code and keys
        if (verbType == VerbType.INTRANSITIVE) {
            object = "SG3IN"
        }

        def combinedSubjectObject = "${subject}${object}"//object ? "${subject}${object}" : "${subject}"

        if (combinedSubjectObject == "SG3SG3AN") {
            return stemmer.present3rd.syllabary;
        }

        if (verbType == VerbType.INTRANSITIVE && combinedSubjectObject == "SG3SG3IN" && tense == verbTense.PRESENT) {
            return stemmer.present3rd.syllabary;
        }

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

        println "compound prefix ${compoundPrefix}"
        println "verbset ${verbset}"
        println "tense ${tense.toString()}"
        println "verbToConjugate ${SyllabaryUtil.parseSyllabary(verbToConjugate)}"

        def returnValue = ""
        def prefices = processPrefixes(compoundPrefix, verbset, Tense.valueOf(tense), verbToConjugate)
        def prefixOnly = processPrefixesOnly(compoundPrefix, verbset, Tense.valueOf(tense), verbToConjugate)

        println "prefixOnly ${SyllabaryUtil.parseSyllabary(prefixOnly)}"
//        println "presentTense ${SyllabaryUtil.parseSyllabary(prefices)}"

        if (prefices) {
            returnValue = prefices
        }

        return returnValue
    }

    static def processPrefixesOnly(//final PronominalPrefix pref,
                                   final CompoundPrefix pref,
                                   final VerbSet verbset,
                                   final Tense tense,
                                   String it ) {
        def returnPrefix = "";

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
                returnValue = returnPrefix;// + it;
            }
        }

        if (!returnPrefix) {
            returnValue = ""
        }

        return returnValue
    }

    //returns a Verb object
    static def processVerb(final String subject,
                       String object,
                       final Stemmer stemmer,
                       final String tense,
                       final String verbType) {
        Verb verb = new Verb();
        verb.tense = Tense.valueOf(tense)
        verb.partOfSpeech = verbType//PartOfSpeech.valueOf(verbType == VerbType.INTRANSITIVE ? "v.i." : "v.t.")

        verb.verbSubject = VerbPrefixTableSubject.valueOf(subject)
        verb.verbObject = VerbPrefixTableObject.valueOf(object)

        VerbTenseHolder vth = new VerbTenseHolder(stemmer: stemmer)
        vth.process()
        def verbTense = Tense.valueOf(tense);
        //todo: find prefix for plurals (e.G. d-) -- probably detect if verb starts with /d-/ if it does then add a /d-/
        // - should wait until other prefixes are put together in whole? timo 22Sep15

        //this column matches - so intransitive specific code was removed in favor of using existing code and keys
        if (verbType == VerbType.INTRANSITIVE) {
            object = "SG3IN"
        }

        def combinedSubjectObject = "${subject}${object}"//object ? "${subject}${object}" : "${subject}"

        if (combinedSubjectObject == "SG3SG3AN") {
            return stemmer.present3rd.syllabary;
        }

        if (verbType == VerbType.INTRANSITIVE && combinedSubjectObject == "SG3SG3IN" && tense == verbTense.PRESENT) {
            return stemmer.present3rd.syllabary;
        }

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

        VerbFinalSuffixHolderObject vsh = new VerbFinalSuffixHolderObject()
        switch (verbTense) {
            case Tense.PRESENT:
                verbToConjugate = vth.present;
                vsh.a = true

                break;
            case Tense.REMOTE_PAST:
                verbToConjugate = vth.remotePast
                //remote past always starts with B - Durbin Feeling book pp21
                verbset = VerbSet.B
                vsh.vi = true

                break;
            case Tense.FUTURE_COMMAND:
                verbToConjugate = vth.futureCommand
                vsh.isi = true

                break;
            case Tense.HABITUAL:
                verbToConjugate = vth.habitual
                vsh.oi = true

                break;
            case Tense.INFINITIVE:
                verbToConjugate = vth.infinitive
                vsh.di = true

                break;
        }

        verb.finalSuffix = vsh

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

        def pronounPrefixLatin = SyllabaryUtil.parseSyllabary(processPrefixesOnly(compoundPrefix, verbset, Tense.valueOf(tense), verbToConjugate))

        //todo: fix what's going on with the verb syllabary and latin phonetic stuff
        String str = SyllabaryUtil.parseSyllabary(verbToConjugate)
        verb.verbRootSuffixLatinPhonetic = verb.finalSuffix.getTrueValue()
        verb.verbRootLatinPhonetic = str.substring(0, str.indexOf(verb.finalSuffix.getTrueValue()) - 1)
        verb.pronounPrefixLatin = pronounPrefixLatin

        return verb
    }
}
