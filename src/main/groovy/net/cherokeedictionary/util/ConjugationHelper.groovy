package net.cherokeedictionary.util

import net.cherokeedictionary.core.Verb

class ConjugationHelper {
    public static void determinePartOfSpeech(Verb verb, partOfSpeech) {
        verb.partOfSpeech = (partOfSpeech == 'v.i.' || partOfSpeech == 'vi')
                                ? PartOfSpeech.VERB_INTRANSITIVE
                                : PartOfSpeech.VERB_TRANSITIVE
    }

    public static void determineSubjectObject(Verb verb, String subject, String object) {
        //todo: could this eventually be something that valueOf is overridden so if the value is blank it returns NONE?  Valueof cannot be overridden so idk
        PrefixTableObject pobj = object ? PrefixTableObject.valueOf(object) : PrefixTableObject.NONE

        // Guard against null/blank subject to avoid Enum.valueOf NPE
        def effectiveSubject = (subject && subject.trim()) ? subject.trim() : "SG3"
        verb.subject = PrefixTableSubject.valueOf(effectiveSubject)
        verb.object = pobj

        if (verb.object == PrefixTableObject.NONE
                || verb.partOfSpeech == PartOfSpeech.VERB_INTRANSITIVE
                || verb.tense == Tense.INFINITIVE) {
            verb.object = PrefixTableObject.SG3IN
        }
    }

    public static void determineTense(Verb verb, tense) {
        // Default tense to PRESENT when missing/blank
        def effectiveTense = (tense && tense.trim()) ? tense.trim() : "PRESENT"
        verb.tense = Tense.valueOf(effectiveTense)
    }

    public static void determineVerbSet(Verb verb) {
        def verbset = VerbSet.A

        // Plural objects with distributive prefixes are inherently Set B
        if (verb.object == PrefixTableObject.PL3AN
                || verb.object == PrefixTableObject.PL3IN) {
            verbset = VerbSet.B
        }

        //if du,nu,u,wu in 3rd sing present then Set B rest are Set A
        def tempPresent3rd = verb.stemmer.present3rd.syllabary
        if (tempPresent3rd.startsWith("Ꮪ")
                || tempPresent3rd.startsWith("Ꮔ")
                || tempPresent3rd.startsWith("Ꭴ")
                || tempPresent3rd.startsWith("Ꮽ")) {
            verbset = VerbSet.B
        }

        if (verb.tense == Tense.INFINITIVE || verb.tense == Tense.REMOTE_PAST) {
            //remote past always starts with B - Durbin Feeling book pp21
            verbset = VerbSet.B
        }

        verb.verbset = verbset
    }

    public static void determineCompoundPrefix(Verb verb) {
        def compoundPrefix = null

        try {
            if (verb.verbset == VerbSet.B) {
                // Attempt to get compound prefix for Set B, falling back to Set A if not found
                compoundPrefix = CompoundPrefixes."${verb.subject}${verb.object}B"
            } else {
                compoundPrefix = CompoundPrefixes."${verb.subject}${verb.object}"
            }
        } catch (Exception e) {
            //todo: need to throw this exception back out if anything goes wrong
            //todo: create new exception class to be thrown so we get the message back out
            throw e;
        }

        verb.compoundPrefix = compoundPrefix
    }
}
