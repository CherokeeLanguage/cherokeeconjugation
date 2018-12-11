package cherokee.dictionary.conjugation.factories

import cherokee.dictionary.conjugation.Conjugate
import cherokee.dictionary.conjugation.IntransitiveVerb
import cherokee.dictionary.conjugation.TransitiveVerb
import cherokee.dictionary.conjugation.Verb
import cherokee.dictionary.conjugation.VerbConjugatedTensesHolder
import cherokee.dictionary.conjugation.cdpbook.Stemmer
import cherokee.dictionary.conjugation.conjugate.Tense
import cherokee.dictionary.conjugation.conjugate.VerbType

class VerbFactory {
    public static Verb generateVerb(stemmer, verbTense, partofspeechc) {
        def verbType
        if (partofspeechc == 'v.i.' || partofspeechc == 'vi') {
            verbType = VerbType.INTRANSITIVE
        } else {
            verbType = VerbType.TRANSITIVE
        }

        Verb verb

        if (verbType == VerbType.INTRANSITIVE) {
            verb = new IntransitiveVerb()
            verb.SG1 = conjugate("SG1", "SG1", stemmer, verbTense, partofspeechc)
            verb.SG2 = conjugate("SG2", "SG1", stemmer, verbTense, partofspeechc)
            verb.SG3 = conjugate("SG3", "SG1", stemmer, verbTense, partofspeechc)
            verb.DL1INCL = conjugate("DL1INCL", "SG1", stemmer, verbTense, partofspeechc)
            verb.DL1EXCL = conjugate("DL1EXCL", "SG1", stemmer, verbTense, partofspeechc)
            verb.PL1INCL = conjugate("PL1INCL", "SG1", stemmer, verbTense, partofspeechc)
            verb.PL1EXCL = conjugate("PL1EXCL", "SG1", stemmer, verbTense, partofspeechc)
            verb.DL2 = conjugate("DL2", "SG1", stemmer, verbTense, partofspeechc)
            verb.PL2 = conjugate("PL2", "SG1", stemmer, verbTense, partofspeechc)
            verb.PL3 = conjugate("PL3", "SG1", stemmer, verbTense, partofspeechc)
        } else {
            verb = new TransitiveVerb();
            verb.SG1SG1 = conjugate("SG1", "SG1", stemmer, verbTense, partofspeechc)
            verb.SG1SG2 = conjugate("SG1", "SG2", stemmer, verbTense, partofspeechc)
            verb.SG1SG3AN = conjugate("SG1", "SG3AN", stemmer, verbTense, partofspeechc)
            verb.SG1SG3IN = conjugate("SG1", "SG3IN", stemmer, verbTense, partofspeechc)
            verb.SG1DL1INCL = conjugate("SG1", "DL1INCL", stemmer, verbTense, partofspeechc)
            verb.SG1DL1EXCL = conjugate("SG1", "DL1EXCL", stemmer, verbTense, partofspeechc)
            verb.SG1PL1INCL = conjugate("SG1", "PL1INCL", stemmer, verbTense, partofspeechc)
            verb.SG1PL1EXCL = conjugate("SG1", "PL1EXCL", stemmer, verbTense, partofspeechc)
            verb.SG1DL2 = conjugate("SG1", "DL2", stemmer, verbTense, partofspeechc)
            verb.SG1PL2 = conjugate("SG1", "PL2", stemmer, verbTense, partofspeechc)
            verb.SG1PL3AN = conjugate("SG1", "PL3AN", stemmer, verbTense, partofspeechc)
            verb.SG1PL3IN = conjugate("SG1", "PL3IN", stemmer, verbTense, partofspeechc)
            verb.SG2SG1 = conjugate("SG2", "SG1", stemmer, verbTense, partofspeechc)
            verb.SG2SG2 = conjugate("SG2", "SG2", stemmer, verbTense, partofspeechc)
            verb.SG2SG3AN = conjugate("SG2", "SG3AN", stemmer, verbTense, partofspeechc)
            verb.SG2SG3IN = conjugate("SG2", "SG3IN", stemmer, verbTense, partofspeechc)
            verb.SG2DL1INCL = conjugate("SG2", "DL1INCL", stemmer, verbTense, partofspeechc)
            verb.SG2DL1EXCL = conjugate("SG2", "DL1EXCL", stemmer, verbTense, partofspeechc)
            verb.SG2PL1INCL = conjugate("SG2", "PL1INCL", stemmer, verbTense, partofspeechc)
            verb.SG2PL1EXCL = conjugate("SG2", "PL1EXCL", stemmer, verbTense, partofspeechc)
            verb.SG2DL2 = conjugate("SG2", "DL2", stemmer, verbTense, partofspeechc)
            verb.SG2PL2 = conjugate("SG2", "PL2", stemmer, verbTense, partofspeechc)
            verb.SG2PL3AN = conjugate("SG2", "PL3AN", stemmer, verbTense, partofspeechc)
            verb.SG2PL3IN = conjugate("SG2", "PL3IN", stemmer, verbTense, partofspeechc)
            verb.SG3SG1 = conjugate("SG3", "SG1", stemmer, verbTense, partofspeechc)
            verb.SG3SG2 = conjugate("SG3", "SG2", stemmer, verbTense, partofspeechc)
            verb.SG3SG3AN = conjugate("SG3", "SG3AN", stemmer, verbTense, partofspeechc)
            verb.SG3SG3IN = conjugate("SG3", "SG3IN", stemmer, verbTense, partofspeechc)
            verb.SG3DL1INCL = conjugate("SG3", "DL1INCL", stemmer, verbTense, partofspeechc)
            verb.SG3DL1EXCL = conjugate("SG3", "DL1EXCL", stemmer, verbTense, partofspeechc)
            verb.SG3PL1INCL = conjugate("SG3", "PL1INCL", stemmer, verbTense, partofspeechc)
            verb.SG3PL1EXCL = conjugate("SG3", "PL1EXCL", stemmer, verbTense, partofspeechc)
            verb.SG3DL2 = conjugate("SG3", "DL2", stemmer, verbTense, partofspeechc)
            verb.SG3PL2 = conjugate("SG3", "PL2", stemmer, verbTense, partofspeechc)
            verb.SG3PL3AN = conjugate("SG3", "PL3AN", stemmer, verbTense, partofspeechc)
            verb.SG3PL3IN = conjugate("SG3", "PL3IN", stemmer, verbTense, partofspeechc)
            verb.DL1INCLSG1 = conjugate("DL1INCL", "SG1", stemmer, verbTense, partofspeechc)
            verb.DL1INCLSG2 = conjugate("DL1INCL", "SG2", stemmer, verbTense, partofspeechc)
            verb.DL1INCLSG3AN = conjugate("DL1INCL", "SG3AN", stemmer, verbTense, partofspeechc)
            verb.DL1INCLSG3IN = conjugate("DL1INCL", "SG3IN", stemmer, verbTense, partofspeechc)
            verb.DL1INCLDL1INCL = conjugate("DL1INCL", "DL1INCL", stemmer, verbTense, partofspeechc)
            verb.DL1INCLDL1EXCL = conjugate("DL1INCL", "DL1EXCL", stemmer, verbTense, partofspeechc)
            verb.DL1INCLPL1INCL = conjugate("DL1INCL", "PL1INCL", stemmer, verbTense, partofspeechc)
            verb.DL1INCLPL1EXCL = conjugate("DL1INCL", "PL1EXCL", stemmer, verbTense, partofspeechc)
            verb.DL1INCLDL2 = conjugate("DL1INCL", "DL2", stemmer, verbTense, partofspeechc)
            verb.DL1INCLPL2 = conjugate("DL1INCL", "PL2", stemmer, verbTense, partofspeechc)
            verb.DL1INCLPL3AN = conjugate("DL1INCL", "PL3AN", stemmer, verbTense, partofspeechc)
            verb.DL1INCLPL3IN = conjugate("DL1INCL", "PL3IN", stemmer, verbTense, partofspeechc)
            verb.DL1EXCLSG1 = conjugate("DL1EXCL", "SG1", stemmer, verbTense, partofspeechc)
            verb.DL1EXCLSG2 = conjugate("DL1EXCL", "SG2", stemmer, verbTense, partofspeechc)
            verb.DL1EXCLSG3AN = conjugate("DL1EXCL", "SG3AN", stemmer, verbTense, partofspeechc)
            verb.DL1EXCLSG3IN = conjugate("DL1EXCL", "SG3IN", stemmer, verbTense, partofspeechc)
            verb.DL1EXCLDL1INCL = conjugate("DL1EXCL", "DL1INCL", stemmer, verbTense, partofspeechc)
            verb.DL1EXCLDL1EXCL = conjugate("DL1EXCL", "DL1EXCL", stemmer, verbTense, partofspeechc)
            verb.DL1EXCLPL1INCL = conjugate("DL1EXCL", "PL1INCL", stemmer, verbTense, partofspeechc)
            verb.DL1EXCLPL1EXCL = conjugate("DL1EXCL", "PL1EXCL", stemmer, verbTense, partofspeechc)
            verb.DL1EXCLDL2 = conjugate("DL1EXCL", "DL2", stemmer, verbTense, partofspeechc)
            verb.DL1EXCLPL2 = conjugate("DL1EXCL", "PL2", stemmer, verbTense, partofspeechc)
            verb.DL1EXCLPL3AN = conjugate("DL1EXCL", "PL3AN", stemmer, verbTense, partofspeechc)
            verb.DL1EXCLPL3IN = conjugate("DL1EXCL", "PL3IN", stemmer, verbTense, partofspeechc)
            verb.PL1INCLSG1 = conjugate("PL1INCL", "SG1", stemmer, verbTense, partofspeechc)
            verb.PL1INCLSG2 = conjugate("PL1INCL", "SG2", stemmer, verbTense, partofspeechc)
            verb.PL1INCLSG3AN = conjugate("PL1INCL", "SG3AN", stemmer, verbTense, partofspeechc)
            verb.PL1INCLSG3IN = conjugate("PL1INCL", "SG3IN", stemmer, verbTense, partofspeechc)
            verb.PL1INCLDL1INCL = conjugate("PL1INCL", "DL1INCL", stemmer, verbTense, partofspeechc)
            verb.PL1INCLDL1EXCL = conjugate("PL1INCL", "DL1EXCL", stemmer, verbTense, partofspeechc)
            verb.PL1INCLPL1INCL = conjugate("PL1INCL", "PL1INCL", stemmer, verbTense, partofspeechc)
            verb.PL1INCLPL1EXCL = conjugate("PL1INCL", "PL1EXCL", stemmer, verbTense, partofspeechc)
            verb.PL1INCLDL2 = conjugate("PL1INCL", "DL2", stemmer, verbTense, partofspeechc)
            verb.PL1INCLPL2 = conjugate("PL1INCL", "PL2", stemmer, verbTense, partofspeechc)
            verb.PL1INCLPL3AN = conjugate("PL1INCL", "PL3AN", stemmer, verbTense, partofspeechc)
            verb.PL1INCLPL3IN = conjugate("PL1INCL", "PL3IN", stemmer, verbTense, partofspeechc)
            verb.PL1EXCLSG1 = conjugate("PL1EXCL", "SG1", stemmer, verbTense, partofspeechc)
            verb.PL1EXCLSG2 = conjugate("PL1EXCL", "SG2", stemmer, verbTense, partofspeechc)
            verb.PL1EXCLSG3AN = conjugate("PL1EXCL", "SG3AN", stemmer, verbTense, partofspeechc)
            verb.PL1EXCLSG3IN = conjugate("PL1EXCL", "SG3IN", stemmer, verbTense, partofspeechc)
            verb.PL1EXCLDL1INCL = conjugate("PL1EXCL", "DL1INCL", stemmer, verbTense, partofspeechc)
            verb.PL1EXCLDL1EXCL = conjugate("PL1EXCL", "DL1EXCL", stemmer, verbTense, partofspeechc)
            verb.PL1EXCLPL1INCL = conjugate("PL1EXCL", "PL1INCL", stemmer, verbTense, partofspeechc)
            verb.PL1EXCLPL1EXCL = conjugate("PL1EXCL", "PL1EXCL", stemmer, verbTense, partofspeechc)
            verb.PL1EXCLDL2 = conjugate("PL1EXCL", "DL2", stemmer, verbTense, partofspeechc)
            verb.PL1EXCLPL2 = conjugate("PL1EXCL", "PL2", stemmer, verbTense, partofspeechc)
            verb.PL1EXCLPL3AN = conjugate("PL1EXCL", "PL3AN", stemmer, verbTense, partofspeechc)
            verb.PL1EXCLPL3IN = conjugate("PL1EXCL", "PL3IN", stemmer, verbTense, partofspeechc)
            verb.DL2SG1 = conjugate("DL2", "SG1", stemmer, verbTense, partofspeechc)
            verb.DL2SG2 = conjugate("DL2", "SG2", stemmer, verbTense, partofspeechc)
            verb.DL2SG3AN = conjugate("DL2", "SG3AN", stemmer, verbTense, partofspeechc)
            verb.DL2SG3IN = conjugate("DL2", "SG3IN", stemmer, verbTense, partofspeechc)
            verb.DL2DL1INCL = conjugate("DL2", "DL1INCL", stemmer, verbTense, partofspeechc)
            verb.DL2DL1EXCL = conjugate("DL2", "DL1EXCL", stemmer, verbTense, partofspeechc)
            verb.DL2PL1INCL = conjugate("DL2", "PL1INCL", stemmer, verbTense, partofspeechc)
            verb.DL2PL1EXCL = conjugate("DL2", "PL1EXCL", stemmer, verbTense, partofspeechc)
            verb.DL2DL2 = conjugate("DL2", "DL2", stemmer, verbTense, partofspeechc)
            verb.DL2PL2 = conjugate("DL2", "PL2", stemmer, verbTense, partofspeechc)
            verb.DL2PL3AN = conjugate("DL2", "PL3AN", stemmer, verbTense, partofspeechc)
            verb.DL2PL3IN = conjugate("DL2", "PL3IN", stemmer, verbTense, partofspeechc)
            verb.PL2SG1 = conjugate("PL2", "SG1", stemmer, verbTense, partofspeechc)
            verb.PL2SG2 = conjugate("PL2", "SG2", stemmer, verbTense, partofspeechc)
            verb.PL2SG3AN = conjugate("PL2", "SG3AN", stemmer, verbTense, partofspeechc)
            verb.PL2SG3IN = conjugate("PL2", "SG3IN", stemmer, verbTense, partofspeechc)
            verb.PL2DL1INCL = conjugate("PL2", "DL1INCL", stemmer, verbTense, partofspeechc)
            verb.PL2DL1EXCL = conjugate("PL2", "DL1EXCL", stemmer, verbTense, partofspeechc)
            verb.PL2PL1INCL = conjugate("PL2", "PL1INCL", stemmer, verbTense, partofspeechc)
            verb.PL2PL1EXCL = conjugate("PL2", "PL1EXCL", stemmer, verbTense, partofspeechc)
            verb.PL2DL2 = conjugate("PL2", "DL2", stemmer, verbTense, partofspeechc)
            verb.PL2PL2 = conjugate("PL2", "PL2", stemmer, verbTense, partofspeechc)
            verb.PL2PL3AN = conjugate("PL2", "PL3AN", stemmer, verbTense, partofspeechc)
            verb.PL2PL3IN = conjugate("PL2", "PL3IN", stemmer, verbTense, partofspeechc)
            verb.PL3SG1 = conjugate("PL3", "SG1", stemmer, verbTense, partofspeechc)
            verb.PL3SG2 = conjugate("PL3", "SG2", stemmer, verbTense, partofspeechc)
            verb.PL3SG3AN = conjugate("PL3", "SG3AN", stemmer, verbTense, partofspeechc)
            verb.PL3SG3IN = conjugate("PL3", "SG3IN", stemmer, verbTense, partofspeechc)
            verb.PL3DL1INCL = conjugate("PL3", "DL1INCL", stemmer, verbTense, partofspeechc)
            verb.PL3DL1EXCL = conjugate("PL3", "DL1EXCL", stemmer, verbTense, partofspeechc)
            verb.PL3PL1INCL = conjugate("PL3", "PL1INCL", stemmer, verbTense, partofspeechc)
            verb.PL3PL1EXCL = conjugate("PL3", "PL1EXCL", stemmer, verbTense, partofspeechc)
            verb.PL3DL2 = conjugate("PL3", "DL2", stemmer, verbTense, partofspeechc)
            verb.PL3PL2 = conjugate("PL3", "PL2", stemmer, verbTense, partofspeechc)
            verb.PL3PL3AN = conjugate("PL3", "PL3AN", stemmer, verbTense, partofspeechc)
            verb.PL3PL3IN = conjugate("PL3", "PL3IN", stemmer, verbTense, partofspeechc)
        }

        return verb

    }

    public static VerbConjugatedTensesHolder generateVerb(stemmer, partofspeechc) {
        VerbConjugatedTensesHolder vt = new VerbConjugatedTensesHolder();
        vt.present = generateVerb(stemmer, Tense.PRESENT.toString(), partofspeechc)
        vt.past = generateVerb(stemmer, Tense.REMOTE_PAST.toString(), partofspeechc)
        vt.habitual = generateVerb(stemmer, Tense.HABITUAL.toString(), partofspeechc)
        vt.infinitive = generateVerb(stemmer, Tense.INFINITIVE.toString(), partofspeechc)
        vt.future = generateVerb(stemmer, Tense.FUTURE_COMMAND.toString(), partofspeechc)

        return vt
    }

    private static String conjugate(String subject, String object, Stemmer stemmer, String verbTense, String partofspeechc) {
        Conjugate conjugate = new Conjugate();
        return conjugate.conjugate(subject, object, stemmer, verbTense, partofspeechc)
    }
}