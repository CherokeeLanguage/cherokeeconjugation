package net.cherokeedictionary.king

import net.cherokeedictionary.stemmer.DefinitionLine
import net.cherokeedictionary.stemmer.Stemmer
import net.cherokeedictionary.verb.conjugation.Conjugate

/**
 * E: wire the King (King & Champion dictionary) rows into the conjugation
 * engine. A King row carries the dictionary lineups the Stemmer normalizes:
 *
 *   thirdPresSing -> present3rd    (the 3sg present "he/she/it ...")
 *   firstPresSing -> present1st    (the 1sg present, used for Set detection)
 *   imperative    -> imperative    (Stem IV)
 *   infintive     -> infinitive    (Stem V)
 *   perfective    -> remotepast    (Stem III, non-progressive past)
 *   imperf        -> habitual      (Stem II)
 *
 * Conjugation failures surface through the MISSING_STEM / MISSING_ENTRY
 * sentinels and stemmer.normalizationFailure (see Stemmer). -- timo 10Nov26
 */
class KingConjugator {

    /** Build the engine Stemmer from a King dictionary row. */
    static Stemmer toStemmer(King king) {
        def stemmer = new Stemmer()
        if (king.thirdPresSing) stemmer.present3rd = new DefinitionLine(syllabary: king.thirdPresSing)
        if (king.firstPresSing) stemmer.present1st = new DefinitionLine(syllabary: king.firstPresSing)
        if (king.imperative) stemmer.imperative = new DefinitionLine(syllabary: king.imperative)
        if (king.infintive) stemmer.infinitive = new DefinitionLine(syllabary: king.infintive)
        if (king.perfective) stemmer.remotepast = new DefinitionLine(syllabary: king.perfective)
        if (king.imperf) stemmer.habitual = new DefinitionLine(syllabary: king.imperf)
        return stemmer
    }

    /** Conjugate a King row: subject/object are the engine's table labels. */
    static def conjugate(King king, String subject, String object, String tense) {
        return conjugate(king, subject, object, tense, false)
    }

    static def conjugate(King king, String subject, String object, String tense, boolean isReflexive) {
        def stemmer = toStemmer(king)
        return Conjugate.conjugate(subject, object, stemmer, tense, king.useCase ?: "v.t.", isReflexive)
    }

    static def conjugate(King king) {
        // default: third person present ("he/she/it ...")
        return conjugate(king, "SG3", "SG3IN", "PRESENT")
    }
}
