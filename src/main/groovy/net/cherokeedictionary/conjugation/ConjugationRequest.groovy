package net.cherokeedictionary.conjugation

class ConjugationRequest {
    String subject
    String object
    String verbTense
    String partOfSpeech
    
    // Principal parts / stem definition inputs.
    //
    // tio 20Nov26: STEM-FREE (citation-in) MODE -- the verb-in/stem-free
    // backlog item. A caller may supply ONLY present3rd (the SG3 citation
    // form) and still conjugate the tenses the engine can derive from it:
    //   PRESENT, IMMEDIATE_COMMAND, FUTURE_COMMAND, FUTURE_EXPECTED,
    //   COMPLETIVE_FUTURE, PROGRESSIVE_PAST, PROGRESSIVE_FUTURE
    // The lexically distinct stems CANNOT be derived from the citation and
    // surface the MISSING_STEM_* sentinel text in the word per the error
    // contract ("if composition fails then it fails", no exceptions):
    //   HABITUAL (the -sgo'i/-ho'i split is per-verb, D24 class A),
    //   REMOTE_PAST (CMP stem: agowatiha -> ugohv'i l-shift is lexical),
    //   INFINITIVE, IMMEDIATE_PAST.
    // Supply those stems when they are needed. See
    // CitationOnlyConjugationSpec for the behavior contract. -- tio 20Nov26
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

    // tio 19Nov26: deconstruct input -- a fully conjugated verb surface form
    // for the analyze() path. When set, VerbConjugationFacade.analyze runs
    // the outside-in Deconstructor instead of the conjugation pipeline.
    String form

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
            form         : form,
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
