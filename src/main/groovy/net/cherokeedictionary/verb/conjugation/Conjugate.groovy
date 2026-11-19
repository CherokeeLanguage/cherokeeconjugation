package net.cherokeedictionary.verb.conjugation

import net.cherokeedictionary.core.Verb
import net.cherokeedictionary.stemmer.Stemmer
import net.cherokeedictionary.util.CompoundPrefixes
import net.cherokeedictionary.util.ConjugationHelper
import net.cherokeedictionary.util.PartOfSpeech
import net.cherokeedictionary.util.PrefixTableObject
import net.cherokeedictionary.util.PrefixTableSubject
import net.cherokeedictionary.util.Tense
import net.cherokeedictionary.verb.affixes.PrefixProcessor
import net.cherokeedictionary.verb.metadata.VerbRegistry
import net.cherokeedictionary.verb.conjugation.VerbConjugationProcessor
import net.cherokeedictionary.verb.containers.FinalSuffixProcessor
import net.cherokeedictionary.verb.containers.NonFinalSuffixProcessor

/**
 * Created by torr on 8/20/2015.
 */
class Conjugate {
    static boolean isDebug = false

    static def createVerbToConjugate(final String subject,
                                     final String object,
                                     final Stemmer stemmer,
                                     final String tense,//verb tense
                                     final String partOfSpeech,
                                     final boolean isReflexive) {
        Verb verb = new Verb()
        verb.stemmer = stemmer
        verb.reflexiveHolderObject.reflexive = isReflexive

        ConjugationHelper.determinePartOfSpeech(verb, partOfSpeech)
        ConjugationHelper.determineSubjectObject(verb, subject, object)
        ConjugationHelper.determineTense(verb, tense)

        return verb
    }

    static Verb conjugate(final String subject,
                         final String object,
                         final Stemmer stemmer,
                         final String tense,
                         final String partOfSpeech,
                         final boolean isReflexive) { // vi or vt
        return conjugate(createVerbToConjugate(subject, object, stemmer, tense, partOfSpeech, isReflexive))
    }

    static Verb conjugate(final Verb verb) {
        ConjugationHelper.determineVerbSet(verb)
        ConjugationHelper.determineCompoundPrefix(verb)

        // tio 17Nov26: IMPERSONAL verbs have NO imperative -- there is no agent to
        // command. You cannot tell the sun or moon to shine (user's verdict on the
        // Agaliha class, 2026-11-17): the imperative is linguistically IMPERMISSIBLE,
        // not merely unattested, so it is a lexical property of the verb rather than
        // a data gap. Registered lexically (VerbRegistry.registerImpersonal via
        // VerbBaseSpec details.impersonal); requesting an imperative/volative form
        // returns the documented NO_IMPERATIVE sentinel instead of composing
        // garbage (previously ᎦᎦᏁᏐnot a valid letterᏏ for Ganesoysga). The
        // volative tenses ("let it hail") are NOT blocked -- only the true
        // imperative. -- tio 17Nov26
        if (verb.tense == Tense.IMMEDIATE_COMMAND
                && VerbRegistry.isImpersonal(verb.stemmer?.present3rd?.syllabary)) {
            verb.wholeWord = "NO_IMPERATIVE"
            verb.pronounReflexiveRoot = "NO_IMPERATIVE"
            return verb
        }

        if (isDebug) println "DEBUG: conjugating verb=${verb.root} tense=${verb.tense} set=${verb.verbset} prefix=${verb.compoundPrefix}"

        // tio 12Nov26: reset per-conjugation so a reused Verb never carries a
        // stale variantWord from an earlier conjugation (WI-28B).
        verb.variantWord = null

        if (verb.compoundPrefix) {
            verb.pronounReflexiveRoot = VerbConjugationProcessor.process(verb)

            // tio 12Nov26: WI-33 — the stemmer's Ꮪ→Ꭴ normalization means the
            // dictionary entry fused the da- initial prefix with the Set-B sg3
            // u- (To Work ᏚᎸᏫᏍᏓᏁᎰᎢ = da + u + lvhwisdaneho'i). Re-declare da so
            // PrefixDa's D-map re-fuses it (ᎤᎸ... → ᏚᎸ...; Ꮻ + ᏚᎸ... = ᏫᏚᎸ...
            // with wi-, guide ex. 33b). Gated to SG3 with a single sg3 object:
            // PL3-object du- forms ("He/she likes them" ᏚᎸᏉᏗ) carry their own
            // d- in the compound-prefix table and would be doubled. RECHECK:
            // whether da- extends to other persons of these verbs once more
            // book rows are attested.
            if (verb.stemmer?.normalizedDaInitialPrefix
                    && verb.subject == PrefixTableSubject.SG3
                    && (verb.object == PrefixTableObject.SG3AN
                        || verb.object == PrefixTableObject.SG3IN)) {
                verb.initialPrefixHolder.da = true
            }

            verb.wholeWord = PrefixProcessor.process(verb)
            verb.wholeWord = NonFinalSuffixProcessor.process(verb)
            verb.wholeWord = FinalSuffixProcessor.process(verb)

            // tio 17Nov26: D7 qu-series v-coalescing (VerbRegistry.isQuvCoalescing,
            // 2012 book Adlvkwsga p.68) -- applied POST-pipeline so it covers every
            // composition path, including the PRESENT/REMOTE citation echoes: the
            // coalesced pair ᏋᏍ (quv + s-onset suffix) surfaces ᏆᏍ (qua), while
            // Ꮛ before Ꮢ (remote -v'i) and Ꮘ (infinitive -isdi) are untouched --
            // exactly the book's allomorphy. -- tio 17Nov26
            if (VerbRegistry.isQuvCoalescing(verb.stemmer?.present3rd?.syllabary)
                    && verb.wholeWord) {
                verb.wholeWord = verb.wholeWord.replaceAll("Ꮛ(?=Ꮝ)", "Ꮖ")
            }
        } else {
            verb.pronounReflexiveRoot = "      "
            verb.wholeWord = "       "
        }

        return verb
    }
}
