package net.cherokeedictionary.core

import net.cherokeedictionary.stemmer.Stemmer
import net.cherokeedictionary.util.CompoundPrefix
import net.cherokeedictionary.util.PartOfSpeech
import net.cherokeedictionary.util.PrefixTableObject
import net.cherokeedictionary.util.Tense
import net.cherokeedictionary.util.VerbSet
import net.cherokeedictionary.verb.containers.VerbFinalSuffixHolderObject
import net.cherokeedictionary.verb.containers.VerbInitialPrefixHolderObject
import net.cherokeedictionary.verb.containers.VerbNonFinalSuffixHolderObject
import net.cherokeedictionary.verb.reflexive.ReflexiveHolderObject
import net.cherokeedictionary.verb.suffixes.Future
import net.cherokeedictionary.verb.suffixes.FutureImperativeVolative
import net.cherokeedictionary.verb.suffixes.FutureProgressive
import net.cherokeedictionary.verb.suffixes.Habitual
import net.cherokeedictionary.verb.suffixes.ImmediatePast
import net.cherokeedictionary.verb.suffixes.Infinitive
import net.cherokeedictionary.verb.suffixes.Present
import net.cherokeedictionary.verb.suffixes.ProgressivePast
import net.cherokeedictionary.verb.suffixes.RemotePast


class Verb extends Word {
    Stemmer stemmer
    Tense tense

    VerbSet verbset = VerbSet.A
    CompoundPrefix compoundPrefix

    String root
    String rootEnding

    //this is everything - all of the prefixes, roots, suffixes, everything
    String wholeWord

    /**
     * tio 12Nov26: optional attested variant of wholeWord, when a rule allows
     * two printed forms ("w- may be deleted after the negative y-", guide
     * example 28b). Populated by PrefixYi for the yi-+wi- combination; null
     * when no variant exists. wholeWord remains the canonical full form.
     */
    String variantWord

    //this holds the pronoun prefix, reflexive prefix, and root all morphed into one
    String pronounReflexiveRoot

    ReflexiveHolderObject reflexiveHolderObject = new ReflexiveHolderObject()
    String reflexivePrefix

    VerbInitialPrefixHolderObject initialPrefixHolder = new VerbInitialPrefixHolderObject()
    String pronominalHolder = ""
    String reflexivePrefixHolder = "" // TODO: need to create this object

    VerbNonFinalSuffixHolderObject nonFinalSuffixHolder = new VerbNonFinalSuffixHolderObject()
    VerbFinalSuffixHolderObject finalSuffixHolder = new VerbFinalSuffixHolderObject()

    /**
     * C7: the tense final suffix that follows the (non-final) suffix slot, from
     * the tense stem tables (verb book / grammar guide final-suffix table).
     * NonFinalSuffixDan uses this to choose its allomorph (dan before vowels,
     * dis before g, do- before the infinitive -di, d before the imperative -a).
     */
    String getTenseValue() {
        switch (tense) {
            case Tense.PRESENT:
                // present "-a" (with the non-final sg: sg+a -> ha)
                return new Present().getFinalSuffix()
            case Tense.REMOTE_PAST:
                return new RemotePast().getFinalSuffix()
            case Tense.FUTURE_COMMAND:
                // Future Imperative/Volative = Stem III + -v'i
                return new FutureImperativeVolative().getFinalSuffix()
            case Tense.COMPLETIVE_FUTURE:
            case Tense.COMPLETED_FUTURE:
            case Tense.FUTURE_EXPECTED:
                // declarative future "-i"
                return new Future().getFinalSuffix()
            case Tense.HABITUAL:
                return new Habitual().getFinalSuffix()
            case Tense.PROGRESSIVE_PAST:
                return new ProgressivePast().getFinalSuffix()
            case Tense.PROGRESSIVE_FUTURE:
                return new FutureProgressive().getFinalSuffix()
            case Tense.IMMEDIATE_PAST:
                // verb book Immediate Past: "-i" as printed (with "-a" variants)
                return new ImmediatePast().getFinalSuffix()
            case Tense.IMMEDIATE_COMMAND:
            case Tense.RECENT_PAST_IMPERATIVE:
                // grammar guide: "-a, present/recent past imperative"; the -i
                // imperative is a variant of -a
                return new net.cherokeedictionary.verb.suffixes.RecentPastImperative().getFinalSuffix()
            case Tense.INFINITIVE:
                return new Infinitive().getFinalSuffix()
        }

        return ""
    }

    @Override
    void setObject(PrefixTableObject object) {
        if (partOfSpeech == PartOfSpeech.VERB_INTRANSITIVE && object == PrefixTableObject.NONE) {
            object = PrefixTableObject.SG3AN
        }

        super.setObject(object)
    }

    @Override
    String toString() {
        return "Verb{" +
                "stemmer=" + stemmer +
                ", tense=" + tense +
                ", verbset=" + verbset +
                ", compoundPrefix=" + compoundPrefix +
                ", root='" + root + '\'' +
                ", rootEnding='" + rootEnding + '\'' +
                ", wholeWord='" + wholeWord + '\'' +
                ", pronounReflexiveRoot='" + pronounReflexiveRoot + '\'' +
                ", reflexiveHolderObject=" + reflexiveHolderObject +
                ", reflexivePrefix='" + reflexivePrefix + '\'' +
                ", initialPrefixHolder=" + initialPrefixHolder +
                ", pronominalHolder='" + pronominalHolder + '\'' +
                ", reflexivePrefixHolder='" + reflexivePrefixHolder + '\'' +
                ", nonFinalSuffixHolder=" + nonFinalSuffixHolder +
                ", finalSuffixHolder=" + finalSuffixHolder +
                '}';
    }
}
