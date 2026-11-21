package net.cherokeedictionary.util

import net.cherokeedictionary.core.Verb

class ConjugationHelper {
    public static void determinePartOfSpeech(Verb verb, partOfSpeech) {
        // tio 19Nov26: accept every spelling the API callers use -- the
        // dictionary's 'v.i.', the legacy 'vi', the enum name
        // PartOfSpeech.VERB_INTRANSITIVE.toString(), and a bare
        // 'intransitive'. "VERB_INTRANSITIVE" previously fell through to
        // VERB_TRANSITIVE, so a caller-supplied object (e.g. SG3AN) survived
        // and transitive compound prefixes were composed for intransitive
        // verbs (SG1 ᏥᏯᏓᏩᏛᎯᏙᎭ / SG3 ᎠᎦᏓᏩᏛᎯᏙᎭ instead of Ꭶ-/Ꭰ-).
        def pos = partOfSpeech?.toString()?.trim()?.toLowerCase()?.replace('_', '')
        verb.partOfSpeech = (pos in ['v.i.', 'vi', 'verbintransitive', 'intransitive'])
                                ? PartOfSpeech.VERB_INTRANSITIVE
                                : PartOfSpeech.VERB_TRANSITIVE
    }

//    public static void determineSubjectObject(Verb verb, String subject, String object) {
//        verb.subject = PrefixTableSubject.valueOf(subject.trim())
//        verb.object = object ? PrefixTableObject.valueOf(object.trim()) : PrefixTableObject.NONE
//
//        if (verb.object == PrefixTableObject.NONE
//                || verb.partOfSpeech == PartOfSpeech.VERB_INTRANSITIVE
//                || verb.tense == Tense.INFINITIVE) {
//            verb.object = PrefixTableObject.SG3IN
//        }
//    }

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

        // tio 20Nov26: the reflexive consumes the object slot (guide hold1 P1/P2,
        // pp. 296-297: "I see myself" = ᎦᏓᎪᏩᏘᎭ ga-da- with the SUBJECT-only
        // compound; M-A §9.7 (30a) agi-adaad- the same). The adastem is
        // vowel-initial (ᎠᏓ...), so the preVowel subject compounds (SG1SG3IN
        // 'G', SG2SG3IN 'h', DL1INCL 'Ꭲn', ...) produce the paradigm rows
        // directly: g+ada = ᎦᏓᎪ, h+ada = ᎭᏓᎪ, in+ada = ᎢᎾᏓᎪ...
        if (verb.reflexiveHolderObject.isReflexive()) {
            verb.object = PrefixTableObject.SG3IN
        }
    }

    /**
     * Verb-book tense names -> engine Tense names. The verb-book specs pass the
     * printed tense labels verbatim (To Bite p.29 etc.); the engine enum uses
     * the grammar-guide stand-in names for the same forms:
     *   FUTURE                        "I will bite it" -i, Stem III ("NB: the
     *                                 Future is usually Stem III") -> COMPLETIVE_FUTURE
     *   PRESENT_HABITUAL              "I bite it (habitually)" -o'i (Stem II) -> HABITUAL
     *   IMMEDIATE_IMPERATIVE_VOLATIVE "bite it right now!" -a/-i (Stem IV) -> IMMEDIATE_COMMAND
     * tio 13Nov26
     */
    static final Map<String, String> VERB_BOOK_TENSE_ALIASES = [
        "FUTURE"                        : "COMPLETIVE_FUTURE",
        "PRESENT_HABITUAL"              : "HABITUAL",
        "IMMEDIATE_IMPERATIVE_VOLATIVE" : "IMMEDIATE_COMMAND",
    ]

    public static void determineTense(Verb verb, tense) {
        // Default tense to PRESENT when missing/blank
        def effectiveTense = (tense && tense.trim()) ? tense.trim() : "PRESENT"
        effectiveTense = VERB_BOOK_TENSE_ALIASES.getOrDefault(effectiveTense, effectiveTense)
        verb.tense = Tense.valueOf(effectiveTense)
    }

    public static void determineVerbSet(Verb verb) {
        def verbset = VerbSet.A

        // timo 10Nov26: the old "Plural objects with distributive prefixes are
        // inherently Set B" rule (which forced VerbSet.B for every PL3AN/PL3IN
        // object) is removed. The guide is clear that a verb's set is a property
        // of the VERB, not the object: Set A verbs keep Set A prefixes with
        // plural objects — P1(11) gaji- "I'm tying them (an)", P1(45) deg-
        // "he's tying them", P1(70) gosd- "he and I are tying them (an)",
        // P3(24) da- "he sees them", Fig. 3 (deg-/degi- column). Set B verbs
        // (e.g. "to forget", P4(7) degv-) continue to route to their B entries
        // through the present3rd check below.

        // if du,nu,u,wu in 3rd sing present then Set B rest are Set A
        // tio 19Nov26: ᏓᏳ added -- the open-spelled da+u citation
        // (ᏓᏳᎶᏒᎯ dayulohsvhi "he is from") hides the set-B sg3 u- behind
        // the da- initial prefix; only the fused Ꮪ spelling was detected.
        def tempPresent3rd = verb.stemmer?.present3rd?.syllabary
        if (tempPresent3rd && (tempPresent3rd.startsWith("Ꮪ")
                || tempPresent3rd.startsWith("Ꮔ")
                || tempPresent3rd.startsWith("Ꭴ")
                || tempPresent3rd.startsWith("Ꮽ")
                || tempPresent3rd.startsWith("ᏓᏳ"))) {
            verbset = VerbSet.B
        }

        if (verb.tense == Tense.INFINITIVE || verb.tense == Tense.REMOTE_PAST) {
            //remote past always starts with B - Durbin Feeling book pp21
            verbset = VerbSet.B
        }

        // tio 20Nov26: guide hold1 P5 "to forget oneself" -- class-B-always
        // verbs take SET A prefixes in the present when the reflexive is used
        // ("verbs like forget follow the same pattern as those verbs which take
        // Set A prefixes in the present tense"), Set B in the non-progressive
        // past (P6).
        if (verb.reflexiveHolderObject.isReflexive() && verb.tense == Tense.PRESENT) {
            verbset = VerbSet.A
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
