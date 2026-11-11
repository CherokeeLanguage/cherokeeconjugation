package net.cherokeedictionary.proposed

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
