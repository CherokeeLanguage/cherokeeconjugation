package cherokee.dictionary.verb.conjugation.hold

import cherokee.dictionary.conjugation.Conjugate
import cherokee.dictionary.conjugation.ConjugateBase
import cherokee.dictionary.conjugation.cdpbook.Stemmer

/**
 * Created by torr on 8/30/2015.
 */
def conj(String subject, String object, Stemmer stemmer, String verbTense, String partofspeechc){
    Conjugate conjugate = new Conjugate()
    return conjugate.conjugate(subject, object, stemmer, verbTense, partofspeechc)
}

println conj("SG3", "SG1", ConjugateBase.wearShoes, "PRESENT", "v.t.")

