package cherokee.dictionary.conjugation

import cherokee.dictionary.conjugation.cdpbook.Stemmer

/**
 * Created by torr on 8/30/2015.
 */
def conj(String subject, String object, Stemmer stemmer, String verbTense, String partofspeechc){
    Conjugate conjugate = new Conjugate()
    return conjugate.conjugate(subject, object, stemmer, verbTense, partofspeechc)
}

//ᏓᎪᎯᎠ
println conj("SG3", "PL3AN", ConjugateBase.tokill, "PRESENT", "v.t.")