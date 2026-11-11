package net.cherokeedictionary.proposed

import net.cherokeedictionary.core.Verb
import net.cherokeedictionary.stemmer.DefinitionLine
import net.cherokeedictionary.stemmer.Stemmer
import net.cherokeedictionary.verb.conjugation.Conjugate

class ConjugationContext {
    Verb verb
    ConjugationRequest request
    List<String> auditTrail = []

    ConjugationContext(ConjugationRequest request) {
        this.request = request
    }

    void buildBaseVerb() {
        def stemmer = new Stemmer()
        if (request.habitual) stemmer.habitual = new DefinitionLine(syllabary: request.habitual)
        if (request.imperative) stemmer.imperative = new DefinitionLine(syllabary: request.imperative)
        if (request.infinitive) stemmer.infinitive = new DefinitionLine(syllabary: request.infinitive)
        if (request.present1st) stemmer.present1st = new DefinitionLine(syllabary: request.present1st)
        if (request.present3rd) stemmer.present3rd = new DefinitionLine(syllabary: request.present3rd)
        if (request.remotepast) stemmer.remotepast = new DefinitionLine(syllabary: request.remotepast)
        if (request.immediatepast) stemmer.immediatepast = new DefinitionLine(syllabary: request.immediatepast)

        verb = Conjugate.createVerbToConjugate(
            request.subject, 
            request.object, 
            stemmer, 
            request.verbTense, 
            request.partOfSpeech, 
            false
        )

        if (verb && verb.initialPrefixHolder) {
            // F: the holder flags are booleans -- coerce the request's string
            // flags ("true"/"false") instead of assigning them verbatim.
            verb.initialPrefixHolder.yi = toFlag(request.yi)
            verb.initialPrefixHolder.ji = toFlag(request.ji)
            verb.initialPrefixHolder.wi = toFlag(request.wi)
            verb.initialPrefixHolder.ni = toFlag(request.ni)
            verb.initialPrefixHolder.de = toFlag(request.de)
            verb.initialPrefixHolder.da = toFlag(request.da)
            verb.initialPrefixHolder.di = toFlag(request.di)
            verb.initialPrefixHolder.i = toFlag(request.i)
            verb.initialPrefixHolder.ga = toFlag(request.ga)
            verb.initialPrefixHolder.e = toFlag(request.e)
        }
    }

    private static boolean toFlag(String value) {
        if (value == null) {
            return false
        }
        if (value instanceof String) {
            return value.equalsIgnoreCase("true") || value == "1" || value.equalsIgnoreCase("yes")
        }
        return value as boolean
    }

    void log(String message) {
        auditTrail.add(message)
    }
}
