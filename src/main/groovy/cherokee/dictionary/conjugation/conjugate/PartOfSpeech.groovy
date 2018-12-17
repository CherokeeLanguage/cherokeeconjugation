package cherokee.dictionary.conjugation.conjugate

enum PartOfSpeech {
    NOUN('n.'),
    VERB_INTRANSITIVE('v.i.'),
    VERB_TRANSITIVE('v.t.'),
    ADJECTIVE('adj.'),
    ADVERB('adv.');

    String shortForm;

    private PartOfSpeech(def shortForm) {
        this.shortForm = shortForm
    }
}