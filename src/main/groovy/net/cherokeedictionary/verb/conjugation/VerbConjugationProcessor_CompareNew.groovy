package net.cherokeedictionary.verb.conjugation

import net.cherokeedictionary.stem.StemEntry
import net.cherokeedictionary.stem.StemType

import net.cherokeedictionary.core.Verb
import net.cherokeedictionary.util.*
import net.cherokeedictionary.verb.affixes.ReflexivePrefix
import net.cherokeedictionary.verb.rules.RuleLaryngealAlteration
import net.cherokeedictionary.verb.rules.RuleUW

/**
 * This is a copy of VerbConjugationProcessor
 * This version has some changes from some refactoring that broke some tests
 * There are changes in this class that are beneficial, but they'll have to be explored one at a time
 *
 * TODO torr on 4Nov26
 */
class VerbConjugationProcessor_CompareNew {
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

        if (it && StringUtility.startsWithVowelSyllabary(it)) {
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
            verb.addTrace("Applied UW Rule. Pronominal: ${returnPrefix}, Root: ${it} -> ${returnValue}")
            if (!returnValue) {
                verb.pronominalHolder = returnPrefix
                verb.root = it
                returnValue = returnPrefix + it
            }
        } else {
            // Handle prefixes based on da- and de- flags
            // Prioritize da- if explicitly set, otherwise use de-
            if (verb.initialPrefixHolder.da) {
/*
                // Da- prefix logic: If da- is true, use the actual Da- syllabary from CompoundPrefixes.
                // This requires looking up the correct Da- prefix based on subject and object.
                // For now, attempting a generic Da- prefix based on available info.
                // This part may need significant refinement based on specific Da- rules.
                // Let's try to find the compound prefix for 'da-' + subject/object
                def daPrefix = CompoundPrefixes.get("DA" + combinedSubjectObject) // Assuming a lookup for DA prefix combinations
                if (daPrefix) {
                    returnPrefix = daPrefix.preConsonant // or preVowel depending on context
                } else {
                    // Fallback or default Da- handling if specific combo not found
                    returnPrefix = "da-" // Placeholder if specific da- prefix not found
                }
                */
                // The 'da-' prefix itself needs to be handled. For now, let's use a placeholder.
                // A more robust solution would involve a dedicated prefix rule or lookup.
                returnPrefix = "da-" // Placeholder - actual implementation needs more logic

            } else if (verb.initialPrefixHolder.de) {
                // De- prefix logic
                returnPrefix = ((Prefix) CompoundPrefixes.prefixes.get(verbPrefix))?.preConsonant
            } else {
                // Default consonant prefix lookup
                returnPrefix = ((Prefix) CompoundPrefixes.prefixes.get(verbPrefix))?.preConsonant
            }

            if (!returnPrefix) {
                //remove the 'B'? why is this here?
                verbPrefix = verbPrefix.substring(0, verbPrefix.size() - 1)

                returnPrefix = ((Prefix) CompoundPrefixes.prefixes.get(verbPrefix))?.preConsonant
            }

            //Montgomery-Anderson pp 208 -- 'No Set B prefixes trigger it [Laryngeal alternation].
            if (verbset != VerbSet.B) {
                //this will return something if it can - if not then the returnValue will be null and should be checked against
                returnValue = new RuleLaryngealAlteration().process(pref.prefix1, pref.prefix2, returnPrefix, tense, false, it, verbset)
                verb.addTrace("Applied Laryngeal Alternation Rule. Pronominal: ${returnPrefix}, Root: ${it} -> ${returnValue}")
            }

            if (!returnValue && returnPrefix != null && it != null) {
                verb.pronominalHolder = returnPrefix
                verb.root = it
                returnValue = returnPrefix + it;
            }
        }

//        println "returnValue = ${returnValue}"
//        println "returnPrefix = ${returnPrefix}"

        if (returnPrefix == null) {
            returnValue = ""
        }

        return returnValue
    }

    static def process(Verb verb) {
        VerbTenseHolder vth = new VerbTenseHolder(stemmer: verb.stemmer)
        vth.process()

        if (verb.compoundPrefix == CompoundPrefixes.SG3SG3AN
                && !verb.reflexiveHolderObject.isReflexive()
                && verb.tense == Tense.PRESENT) {
            return verb.stemmer.present3rd.syllabary;
        }

        if (verb.partOfSpeech == PartOfSpeech.VERB_INTRANSITIVE
                && verb.compoundPrefix == CompoundPrefixes.SG3SG3IN
                && verb.tense == Tense.PRESENT
                && !verb.reflexiveHolderObject.isReflexive()) {
            return verb.stemmer.present3rd.syllabary;
        }

        // Rules 70-73 from Grammar Guide: Inherent and Plural Distributive prefixes
        if (verb.stemmer?.isDistributive) {
            verb.initialPrefixHolder.de = true
        }

        if (verb.stemmer?.isPluralDistributive) {
            def s = verb.subject.toString()
            if (s.startsWith("PL") || s.startsWith("DL")) {
                verb.initialPrefixHolder.de = true
            }
        }

        // Compositional Object de- trigger:
        // Any PL3AN/PL3IN object triggers the distributive/plural-object 'de-' prefix.
        if (verb.object == PrefixTableObject.PL3AN
                || verb.object == PrefixTableObject.PL3IN) {
            // Plural objects with PL3 subject use the plural distributive prefix 'da-' instead of 'de-'
            if (verb.subject == PrefixTableSubject.PL3) {
                verb.initialPrefixHolder.da = true
                verb.initialPrefixHolder.de = false
            } else {
                // For other subjects with PL3AN/PL3IN objects, 'de-' is used.
                // However, da- also needs to be considered for these cases.
                verb.initialPrefixHolder.de = true
                // If 'da-' is also explicitly requested (e.g., from test flags), prioritize it.
                if (verb.initialPrefixHolder.da) {
                    verb.initialPrefixHolder.de = false
                }
            }
        }

        String verbToConjugate = ""

        switch (verb.tense) {
            case Tense.PRESENT:
                verbToConjugate = vth.present;
                break;
            case Tense.REMOTE_PAST:
                verbToConjugate = vth.remotePast
                break;
            case Tense.FUTURE_COMMAND:
                // FUTURE_COMMAND is derived from the imperative stem, not completiveFuture
                // (present stem minus last syllable), as was previously coded.
                verbToConjugate = vth.immediate // Use the imperative stem here
                break;
            case Tense.IMMEDIATE_COMMAND:
                // IMMEDIATE_COMMAND also uses the imperative stem
                verbToConjugate = vth.immediate
                break;
            case Tense.HABITUAL:
                verbToConjugate = vth.habitual
                break;
            case Tense.INFINITIVE:
                // For infinitive, if 'de-' prefix is present, use deverbal stem, else use infinitive stem
                // The Stemmer generates Deverbal stems. We need to access the correct one from the StemEntry list.
                List<StemEntry> stems = verb.stemmer.getStems()
                StemEntry deverbalStemEntry = stems.find { it.stemtype == StemType.Deverbal }
                if (verb.initialPrefixHolder.de && deverbalStemEntry != null) {
                    verbToConjugate = deverbalStemEntry.prefix + deverbalStemEntry.syllabary
                } else {
                    verbToConjugate = vth.infinitive
                }

                break;
        }

        def returnValue = ""

        verbToConjugate = new ReflexivePrefix().toSyllabary(verbToConjugate, verb)

        if (!verb.reflexiveHolderObject.isReflexive()) {
            verbToConjugate = processPrefixes(verb, verbToConjugate)
            def lst = verb.stemmer.getRootWithEnding(verb.tense)
            //TODO: write more tests to cover this and make sure the values are correct
            verb.root = lst[0]
            verb.rootEnding = lst[1]
        }

        if (verb.tense == Tense.REMOTE_PAST) {
            verb.finalSuffixHolder.vi = true
        }

        if (verbToConjugate) {
            returnValue = verbToConjugate
        }

        return returnValue
    }
}
