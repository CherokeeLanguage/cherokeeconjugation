package net.cherokeedictionary.verb.conjugation

import net.cherokeedictionary.core.Verb
import net.cherokeedictionary.stem.StemEntry
import net.cherokeedictionary.stem.StemType
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
                //timo 10Nov26: a missing Set B compound prefix must be seen during
                //conjugation, not silently patched with the Set A entry. For the
                //3sg/3pl-inanimate object columns the Set A allomorphs are wrong for
                //Set B (Feeling guide, P8: past -v'i is non-progressive, so Set B
                //prefixes apply); for the other columns Set B legitimately reuses the
                //Set A forms, but a gap in the table must still be visible. Old
                //fall-down-to-Set-A fallback, commented out for now:
                //tmpReturnPrefix = ((Prefix) CompoundPrefixes.prefixes.get(verbPrefix.substring(0, verbPrefix.size() - 1)))
                if (verbPrefix.endsWith("B")) {
                    return "MISSING_ENTRY" + it
                }
            }

            tmpReturnPrefix = tmpReturnPrefix?.preVowel

            if (tmpReturnPrefix) {
                //timo 10Nov26: Grammar guide (Feeling 1975): -y- is inserted only
                //between the prefix and a stem-initial vowel — "the insertion of -y-
                //between the final vowel of the prefix and the initial vowel of the
                //stem does not take place" before consonant-initial stems (P3 "to see";
                //same rule in P5 "to like"). The marker rule below (processY etc.) is
                //applied to the first syllable of the routed form, so it is guide-correct
                //only when that form is the normalized stem: vowel-initial stems keep a
                //leading vowel syllable (Stemmer.generateVowelStems) and consonant-initial
                //stems are prefix-less (Stemmer.generateConsonentStems), so they take the
                //preConsonant branch with no -y-. Un-normalized forms (e.g. the raw
                //dictionary entry with its baked 3sg prefix, ᎤᎪᎲᎢ) must never reach this
                //branch, and Set A entries must never stand in for Set B lookups.
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
            // Handle prefixes based on da- and de- flags
            // Prioritize da- if explicitly set, otherwise use de-
//            if (verb.initialPrefixHolder.da) {
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

//            } else if (verb.initialPrefixHolder.de) {
//                // De- prefix logic
//                returnPrefix = ((Prefix) CompoundPrefixes.prefixes.get(verbPrefix))?.preConsonant
//            } else {
//                // Default consonant prefix lookup
//                returnPrefix = ((Prefix) CompoundPrefixes.prefixes.get(verbPrefix))?.preConsonant
//            }

            returnPrefix = ((Prefix) CompoundPrefixes.prefixes.get(verbPrefix))?.preConsonant

            if (!returnPrefix) {
                //timo 10Nov26: same MISSING_ENTRY policy as the preVowel branch above —
                //a missing Set B entry must be visible, not patched with the Set A
                //preConsonant form. Old fall-down-to-Set-A fallback, commented out for now:
                //verbPrefix = verbPrefix.substring(0, verbPrefix.size() - 1)
                //returnPrefix = ((Prefix) CompoundPrefixes.prefixes.get(verbPrefix))?.preConsonant
                if (verbPrefix.endsWith("B")) {
                    return "MISSING_ENTRY" + (it ?: "")
                }
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
//        if (verb.stemmer?.isDistributive) {
//            verb.initialPrefixHolder.de = true
//        }

//        if (verb.stemmer?.isPluralDistributive) {
//            def s = verb.subject.toString()
//            if (s.startsWith("PL") || s.startsWith("DL")) {
//                verb.initialPrefixHolder.de = true
//            }
//        }

        // Compositional Object de- trigger:
        // Any PL3AN/PL3IN object triggers the distributive/plural-object 'de-' prefix.
/*        if (verb.object == PrefixTableObject.PL3AN
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
        }*/

        String verbToConjugate = ""

        switch (verb.tense) {
            case Tense.PRESENT:
                verbToConjugate = vth.present;
                break;
            case Tense.REMOTE_PAST:
                verbToConjugate = vth.remotePast
                break;
            case Tense.FUTURE_COMMAND:
                // Future Imperative/Volative = Stem III + -v'i (verb book summaries),
                // usually identical to the Remote Past row; futureCommand is the Remote
                // Past entry (falls back to completiveFuture when missing)
                verbToConjugate = vth.futureCommand
                break;
            case Tense.COMPLETIVE_FUTURE:
            case Tense.COMPLETED_FUTURE:
                // declarative Future "-i": the verb book derives it from Stem III
                // ("NB: the Future is usually Stem III") — completiveFuture is the
                // Remote Past form with -v'i replaced by -i (VerbTenseHolder)
                verbToConjugate = vth.completiveFuture
                break;
            case Tense.FUTURE_EXPECTED:
                // verb book: To Go only, Future (Expected) = Stem II (-e-s-) + -i with
                // the de-/da- (es-) initial prefix: dagesi, tesi, dayesi. To Go's
                // habitual entry is Stem I (-e-g-), so the correct Stem II base is not
                // available from the dictionary; the Stem III-derived future form is
                // used as a placeholder until verb-level Stem II data exists. -- timo 10Nov26
                verbToConjugate = vth.completiveFuture
                break;
            case Tense.PROGRESSIVE_PAST:
                verbToConjugate = vth.progressivePast
                break;
            case Tense.PROGRESSIVE_FUTURE:
                verbToConjugate = vth.progressiveFuture
                break;
            case Tense.IMMEDIATE_PAST:
            case Tense.RECENT_PAST_IMPERATIVE:
            case Tense.IMMEDIATE_COMMAND:
                // immediate/recent-past forms build on the imperative entry (Stem IV);
                // IMMEDIATE_COMMAND also uses the imperative stem
                verbToConjugate = vth.immediate ?: vth.immediateCommand
                break;
            case Tense.HABITUAL:
                verbToConjugate = vth.habitual
                break;
            case Tense.INFINITIVE:
                // For infinitive, if 'de-' prefix is present, use deverbal stem, else use infinitive stem
                // The Stemmer generates Deverbal stems. We need to access the correct one from the StemEntry list.
//                List<StemEntry> stems = verb.stemmer.getStems()
//                StemEntry deverbalStemEntry = stems.find { it.stemtype == StemType.Deverbal }
//                if (verb.initialPrefixHolder.de && deverbalStemEntry != null) {
//                    verbToConjugate = deverbalStemEntry.prefix + deverbalStemEntry.syllabary
//                } else {
//                    verbToConjugate = vth.infinitive
//                }
                verbToConjugate = vth.infinitive
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

        if (verbToConjugate) {
            returnValue = verbToConjugate
        }

        return returnValue
    }
}
