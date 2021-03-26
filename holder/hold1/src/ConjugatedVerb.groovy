package cherokee.dictionary.hold

/**
 * Created by torr on 8/30/2015.
 */
class ConjugatedVerb {
    String prefix
    String verb

    public boolean isEmpty() {
        return prefix || verb
    }

    public String conjugated() {
        return "$prefix$verb"
    }
}
