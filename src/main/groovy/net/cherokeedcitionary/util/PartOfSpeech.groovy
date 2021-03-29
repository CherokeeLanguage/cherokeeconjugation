package net.cherokeedcitionary.util

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

    //Lookup table
    private static final Map<String, PartOfSpeech> lookup = new HashMap<>();

    static {
        for(PartOfSpeech env : PartOfSpeech.values()) {
            lookup.put(env.shortForm, env);
        }
    }

    static PartOfSpeech getByShortForm(String shortForm) {
        return lookup.get(shortForm);
    }
}