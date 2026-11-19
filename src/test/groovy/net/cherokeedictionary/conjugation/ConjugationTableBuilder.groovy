package net.cherokeedictionary.util

import net.cherokeedictionary.conjugation.CompoundPrefixPlainEnglish
import net.cherokeedictionary.conjugation.CompoundPrefixPlainEnglishMapper

class ConjugationTableBuilder {

    static class ConjugationRow {
        String english
        String compoundPrefixCode   // e.g., "SG1SG3IN" or "SG1SG3INB"
        def conjugatedVerb

        @Override
        String toString() {
            return "${english} - ${compoundPrefixCode} - ${conjugatedVerb}"
        }
    }

    /**
     * Builds Singular, Dual, and Plural conjugation tables across all Tenses
     * (or a provided subset of known tenses).
     *
     * @param tenses     List of Tenses to generate (defaults to Tense.values())
     * @param conjugator Closure receiving (CompoundPrefix basePrefix, Tense tense)
     *                   and returning an object/map with [prefixCode, verb]
     */
    static Map<Tense, Map<String, List<ConjugationRow>>> buildAllTenseTables(
            List<Tense> tenses = Tense.values() as List<Tense>,
            Closure conjugator
    ) {
        return tenses.collectEntries { Tense tense ->
            [(tense): buildTablesForTense(tense, conjugator)]
        }
    }

    /**
     * Builds the Singular, Dual, and Plural tables for a single Tense.
     */
    static Map<String, List<ConjugationRow>> buildTablesForTense(
            Tense tense,
            Closure conjugator
    ) {
        return [
                Singular: buildGroup(CompoundPrefixPlainEnglishMapper.SINGULAR, tense, conjugator),
                Dual    : buildGroup(CompoundPrefixPlainEnglishMapper.DUAL, tense, conjugator),
                Plural  : buildGroup(CompoundPrefixPlainEnglishMapper.PLURAL, tense, conjugator)
        ]
    }

    private static List<ConjugationRow> buildGroup(
            List<CompoundPrefixPlainEnglish> entries,
            Tense tense,
            Closure conjugator
    ) {
        entries.collect { CompoundPrefixPlainEnglish entry ->
            def result = conjugator.call(entry.compoundPrefix, tense)

            new ConjugationRow(
                    english: entry.english,
                    compoundPrefixCode: result.prefixCode,
                    conjugatedVerb: result.verb
            )
        }
    }
}
