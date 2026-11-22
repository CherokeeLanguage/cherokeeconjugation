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

    // tio 21Nov26: reflexive flag (A1) -- "he sees himself" ᎠᏓᎪᏩᏘᎭ class
    // forms (guide hold1 I-E pp. 296-298). The reflexive consumes the object
    // slot (subject-only compounds) and forces Set A in the present for
    // class-B verbs (guide P5). -- tio 21Nov26
    String reflexive

    // tio 21Nov26: object-focus / unspecified-actor passive flag (A2) --
    // "I am being seen" ᎥᎩᎪᏩᏘᎭ class forms (guide hold1 pp. 300-301,
    // Paradigms Five/Six + Figure One; M-A §9.4 Table 9.3). The OBJECT
    // field names the undergoer ("he is being hit" = object SG3AN); the
    // agent is unspecified and the focus prefix replaces the pronominal.
    // -- tio 21Nov26
    String objectFocus

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
            reflexive    : reflexive,
            objectFocus  : objectFocus,
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

    static ConjugationRequest fromMap(Map<String, String> map) {
        new ConjugationRequest(
            subject: map.subject,
            object: map.object,
            verbTense: map.verbTense,
            partOfSpeech: map.partofspeechc,
            lexeme: map.lexeme,
            reflexive: map.reflexive,
            objectFocus: map.objectFocus,
            form: map.form,
            habitual: map.habitual,
            imperative: map.imperative,
            infinitive: map.infinitive,
            present1st: map.present1st,
            present3rd: map.present3rd,
            remotepast: map.remotepast,
            immediatepast: map.immediatepast,
            yi: map.yi,
            ji: map.ji,
            wi: map.wi,
            ni: map.ni,
            de: map.de,
            da: map.da,
            di: map.di,
            i: map.i,
            ga: map.ga,
            e: map.e
        )
    }
}
