package net.cherokeedictionary.conjugation

import net.cherokeedictionary.stem.StemType
import net.cherokeedictionary.stemmer.Stemmer
import net.cherokeedictionary.util.Tense
import net.cherokeedictionary.verb.suffixes.Future
import net.cherokeedictionary.verb.suffixes.FutureExpected
import net.cherokeedictionary.verb.suffixes.FutureImperativeVolative
import net.cherokeedictionary.verb.suffixes.FutureProgressive
import net.cherokeedictionary.verb.suffixes.Habitual
import net.cherokeedictionary.verb.suffixes.ImmediatePast
import net.cherokeedictionary.verb.suffixes.Infinitive
import net.cherokeedictionary.verb.suffixes.Present
import net.cherokeedictionary.verb.suffixes.ProgressivePast
import net.cherokeedictionary.verb.suffixes.RecentPastImperative
import net.cherokeedictionary.verb.suffixes.RemotePast
import net.cherokeedictionary.verb.suffixes.Suffixes
import spock.lang.Specification
import spock.lang.Unroll

/**
 * Completeness check: every value of {@link Tense} must be backed by a
 * conjugation-engine suffix implementation, i.e.
 *
 *   - a {@link Suffixes} class (final suffix + root endings) in the
 *     net.cherokeedictionary.verb.suffixes package,
 *   - the final suffix(es) the grammar guide / verb book print for that tense,
 *   - a Stemmer stem mapping for the tenses that have a dictionary-derived
 *     stem (present Stem I, habitual Stem II, remote past Stem III, the
 *     immediate/recent-past Stem IV built from the imperative entry, and the
 *     deverbal/infinitive Stem V); the future-family tenses are derived
 *     stems and are intentionally excluded from the stem mapping.
 *
 * Verb-book / grammar-guide references (printed pp.167–176 summaries):
 *   PRESENT                -a                 (Stem I)
 *   REMOTE_PAST            -v'i               (Stem III)
 *   FUTURE_COMMAND         -v'i / -esdi       Future Imperative/Volative (Stem III + -v'i,
 *                                             usually identical to the Remote Past row)
 *   COMPLETIVE_FUTURE      -i                 declarative Future (Stem III; "NB: the Future
 *                                             is usually Stem III", To Go)
 *   COMPLETED_FUTURE       -i                 (same printed form; see Tense comment)
 *   HABITUAL               -o'i               Present Habitual (Stem II)
 *   PROGRESSIVE_PAST       -g- + -v'i         (grammar guide ex. 89, no verb-book section)
 *   PROGRESSIVE_FUTURE     -esdi              (grammar guide ex. 93, no verb-book section)
 *   IMMEDIATE_COMMAND      -a / -i            Immediate Imperative/Volative (Stem IV)
 *   IMMEDIATE_PAST         -i / -a            recent past (Stem IV)
 *   FUTURE_EXPECTED        -i                 To Go only, Stem II + de- prefix; not derivable
 *                                             from the dictionary stems (derived)
 *   INFINITIVE             -di                (Stem V)
 *   RECENT_PAST_IMPERATIVE -a / -i            grammar guide "-a, present, recent past imperative"
 */
@Unroll
class TenseSuffixCompletenessSpec extends Specification {

    /** Tense -> [Suffixes class, expected final suffix(es)]. */
    static final Map<Tense, List> TENSE_SUFFIXES = [
            (Tense.PRESENT)                : [Present, ['a']],
            (Tense.REMOTE_PAST)            : [RemotePast, ['vi']],
            (Tense.FUTURE_COMMAND)         : [FutureImperativeVolative, ['vi']],
            (Tense.COMPLETIVE_FUTURE)      : [Future, ['i']],
            (Tense.COMPLETED_FUTURE)       : [Future, ['i']],
            (Tense.HABITUAL)               : [Habitual, ['oi']],
            (Tense.PROGRESSIVE_PAST)       : [ProgressivePast, ['vi']],
            (Tense.PROGRESSIVE_FUTURE)     : [FutureProgressive, ['esdi']],
            (Tense.IMMEDIATE_COMMAND)      : [RecentPastImperative, ['i', 'a']],
            (Tense.IMMEDIATE_PAST)         : [ImmediatePast, ['i', 'a']],
            (Tense.FUTURE_EXPECTED)        : [FutureExpected, ['i']],
            (Tense.INFINITIVE)             : [Infinitive, ['di']],
            (Tense.RECENT_PAST_IMPERATIVE) : [RecentPastImperative, ['i', 'a']],
    ]

    /** Tenses backed by a dictionary-derived stem, -> the StemType that supplies it. */
    static final Map<Tense, StemType> STEMS = [
            (Tense.PRESENT)                : StemType.PresentContinous,
            (Tense.PROGRESSIVE_PAST)       : StemType.PresentContinous,   // -g- + -v'i
            (Tense.PROGRESSIVE_FUTURE)     : StemType.PresentContinous,   // -g- + -esdi
            (Tense.REMOTE_PAST)            : StemType.RemotePast,
            (Tense.COMPLETIVE_FUTURE)      : StemType.RemotePast,         // Stem III + -i
            (Tense.COMPLETED_FUTURE)       : StemType.RemotePast,         // Stem III + -i
            (Tense.FUTURE_COMMAND)         : StemType.RemotePast,         // Stem III + -v'i
            (Tense.HABITUAL)               : StemType.Habitual,
            (Tense.IMMEDIATE_COMMAND)      : StemType.Immediate,
            (Tense.IMMEDIATE_PAST)         : StemType.Immediate,
            (Tense.RECENT_PAST_IMPERATIVE) : StemType.Immediate,
            (Tense.INFINITIVE)             : StemType.Deverbal,
    ]

    /** The tenses whose stem is derived, not read from the dictionary. */
    static final Set<Tense> DERIVED_STEM_TENSES = [
            // FUTURE_EXPECTED (To Go only) is built from To Go's Stem II (-e-s-),
            // which the dictionary does not carry (its habitual entry is Stem I).
            Tense.FUTURE_EXPECTED,
    ] as Set

    def "every Tense value has a suffix implementation"() {
        expect: "the mapping covers all enum values, so a new Tense cannot be added without a suffix"
        (TENSE_SUFFIXES.keySet() as List) == Tense.values().toList()
    }

    def "#tense is implemented with final suffix(es) #finalSuffixes"() {
        given: "the suffix class registered for the tense"
        Class suffixClass = TENSE_SUFFIXES[tense][0]
        def suffix = suffixClass.newInstance()

        expect: "it implements the Suffixes contract with non-empty root endings"
        Suffixes.isAssignableFrom(suffixClass)
        suffix.rootEndings != null
        !suffix.rootEndings.isEmpty()

        and: "the primary final suffix is one of the printed forms"
        suffix.finalSuffix in finalSuffixes

        and: "every printed variant is exposed"
        def variants = suffix.metaClass.respondsTo(suffix, 'getFinalSuffixVariants')
                ? suffix.finalSuffixVariants : [suffix.finalSuffix]
        variants.size() == finalSuffixes.size()
        finalSuffixes.every { it in variants }

        where: "all engine tenses"
        tense << TENSE_SUFFIXES.keySet().toList()
        finalSuffixes = TENSE_SUFFIXES[tense][1]
    }

    def "#tense resolves its dictionary stem from #stemType"() {
        given: "a stemmer whose stem mapping is exercised directly"
        def stemmer = new Stemmer()

        expect: "the registered stem type feeds the tense, and no other stem type claims it"
        StemType.values().every { type ->
            stemmer.compareTypeAndTense(type, tense) == (type == stemType)
        }

        where: "tenses with a dictionary-derived stem"
        tense << STEMS.keySet().toList()
        stemType = STEMS[tense]
    }

    def "#tense has no dictionary stem and is derived (documented)"() {
        given: "a stemmer"
        def stemmer = new Stemmer()

        expect: "no stem type claims the tense"
        StemType.values().every { !stemmer.compareTypeAndTense(it, tense) }

        where: "FUTURE_EXPECTED needs To Go's Stem II (-e-s-), which the dictionary lacks"
        tense << DERIVED_STEM_TENSES.toList()
    }
}
