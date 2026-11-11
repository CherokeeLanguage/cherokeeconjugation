package net.cherokeedictionary.proposed

import net.cherokeedictionary.stemmer.Stemmer
import net.cherokeedictionary.stemmer.DefinitionLine

class RobustStemmerService {
    /**
     * Stubbed robust stemmer service that provides extension points
     * for deconstructing surface forms or preparing stems without disturbing existing engine.
     */
    Stemmer parseAndNormalize(Map<String, String> rawParts) {
        def stemmer = new Stemmer()
        if (rawParts.habitual) stemmer.habitual = new DefinitionLine(syllabary: rawParts.habitual)
        if (rawParts.imperative) stemmer.imperative = new DefinitionLine(syllabary: rawParts.imperative)
        if (rawParts.infinitive) stemmer.infinitive = new DefinitionLine(syllabary: rawParts.infinitive)
        if (rawParts.present1st) stemmer.present1st = new DefinitionLine(syllabary: rawParts.present1st)
        if (rawParts.present3rd) stemmer.present3rd = new DefinitionLine(syllabary: rawParts.present3rd)
        if (rawParts.remotepast) stemmer.remotepast = new DefinitionLine(syllabary: rawParts.remotepast)
        return stemmer
    }

    List<String> deconstructOutsideIn(String surfaceForm) {
        // Stub for future outside-in deconstruction implementation
        [surfaceForm]
    }
}
