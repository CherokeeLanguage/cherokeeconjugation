package net.cherokeedictionary.conjugation

class ConjugationRequest {
    String subject
    String object
    String verbTense
    String partOfSpeech
    
    // Principal parts / stem definition inputs
    String habitual
    String imperative
    String infinitive
    String present1st
    String present3rd
    String remotepast
    String immediatepast

    // tio 18Nov26: optional lexeme name (verbLexemes.json key) for verbs whose
    // lexical flags (glottalInitial, quvCoalescing, impersonal,
    // surfaceOverrides) must be registered for this conjugation. Needed
    // because the present3rd citation is NOT lexeme-unique (Gahneha and
    // Ganeha both print ᎦᏁᎭ), so the name is the only discriminator.
    // VerbConjugationFacade opens a per-conjugation VerbRegistry scope and
    // applies the lexeme's flags -- the same isolation the test harness gets
    // from VerbBaseSpec. -- tio 18Nov26
    String lexeme

    // Initial prefixes flags / values
    String yi
    String ji
    String wi
    String ni
    String de
    String da
    String di
    String i
    String ga
    String e

    Map<String, String> toParamMap() {
        [
            subject      : subject,
            object       : object,
            verbTense    : verbTense,
            partofspeechc: partOfSpeech,
            lexeme       : lexeme,
            habitual     : habitual,
            imperative   : imperative,
            infinitive   : infinitive,
            present1st   : present1st,
            present3rd   : present3rd,
            remotepast   : remotepast,
            immediatepast: immediatepast,
            yi           : yi,
            ji           : ji,
            wi           : wi,
            ni           : ni,
            de           : de,
            da           : da,
            di           : di,
            i            : i,
            ga           : ga,
            e            : e
        ].findAll { k, v -> v != null }
    }
}
