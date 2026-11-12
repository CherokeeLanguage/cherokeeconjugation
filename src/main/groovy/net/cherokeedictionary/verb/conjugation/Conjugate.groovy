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
import net.cherokeedictionary.verb.conjugation.VerbConjugationProcessor
import net.cherokeedictionary.verb.containers.FinalSuffixProcessor
import net.cherokeedictionary.verb.containers.NonFinalSuffixProcessor

/**
 * Created by torr on 8/20/2015.
 */
class Conjugate {
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
        } else {
            verb.pronounReflexiveRoot = "      "
            verb.wholeWord = "       "
        }

        return verb
    }
}
