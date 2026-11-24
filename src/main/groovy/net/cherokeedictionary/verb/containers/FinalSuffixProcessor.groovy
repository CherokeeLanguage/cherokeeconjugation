package net.cherokeedictionary.verb.containers

import net.cherokeedictionary.core.Verb
import net.cherokeedictionary.util.Tense
import net.cherokeedictionary.verb.affixes.suffixes.*

class FinalSuffixProcessor {
    public static String processFinalSuffixesRemove(data, VerbFinalSuffixHolderObject sho, Tense verbTense) {
        return data
    }

    // The past-family tenses end in the final Ꭲ (the -i / -v'i of the remote
    // past and future). When a position-13 particle is appended to them, the
    // final Ꭲ drops (e.g. remote past -v'i + ke -> -vke).
    /**
     * These tenses end their Stem in a vowel + i that optionally drops before
     * the position-13 particles -sgo, -ju, -ke (grammar guide Figure 1,
     * p.282 "Notes on the co-occurrence of suffixes"). Covered forms:
     *   -v'i, past (remote past)
     *   -e'i, reportative
     *   -o'i, pluperfect / habitual (position-10 suffix -oi)
     *   -v'i, future imperative / volative
     *   -v'i, future expected / completive / completed future
     *   -i, progressive past / immediate past
     *
     * See (130): ᎤᏬᏂᏎᎢᏍ? u-wo-ni-se-ʔi-s "Did he speak?" (-i retained)
     *             ᎤᏬᏂᏎᏍ? u-wo-ni-se-s         "Did he speak?" (-i dropped before -sgo)
     */
    private static boolean isPastFamily(Tense tense) {
        return tense in [Tense.REMOTE_PAST, Tense.COMPLETIVE_FUTURE, Tense.COMPLETED_FUTURE,
                         Tense.FUTURE_EXPECTED, Tense.FUTURE_COMMAND,
                         Tense.FUTURE_IMPERATIVE_VOLATIVE, Tense.PROGRESSIVE_PAST,
                         Tense.IMMEDIATE_PAST, Tense.HABITUAL]
    }

    /**
     * C5: rebuilt from the commented-out logic. Appends the requested final
     * suffixes in the grammar order (gwu -> sgo -> position-13 particles),
     * with the past-family i-drop before sgo/ju/ke.
     */
    public static String process(Verb verb) {
        def holder = verb.finalSuffixHolder
        String baseReturnValue = verb.wholeWord

        if (!baseReturnValue || baseReturnValue.startsWith("MISSING_ENTRY") || baseReturnValue.startsWith("MISSING_STEM")) {
            return baseReturnValue
        }

        if (holder.gwu) {
            baseReturnValue = new SuffixGwu().toSyllabary(baseReturnValue, verb)
        }
        if (holder.sgo) {
            baseReturnValue = applyIDrop(baseReturnValue, verb)
            baseReturnValue = new SuffixSgo().toSyllabary(baseReturnValue, verb)
        }
        if (holder.ju) {
            baseReturnValue = applyIDrop(baseReturnValue, verb)
            baseReturnValue = new SuffixJu().toSyllabary(baseReturnValue, verb)
        }
        if (holder.ke) {
            baseReturnValue = applyIDrop(baseReturnValue, verb)
            baseReturnValue = new SuffixKe().toSyllabary(baseReturnValue, verb)
        }
        if (holder.di) {
            baseReturnValue = new SuffixDi().toSyllabary(baseReturnValue, verb)
        }
        if (holder.dv) {
            baseReturnValue = new SuffixDv().toSyllabary(baseReturnValue, verb)
        }
        if (holder.esdi) {
            baseReturnValue = new SuffixEsdi().toSyllabary(baseReturnValue, verb)
        }
        if (holder.a) {
            baseReturnValue = new SuffixA().toSyllabary(baseReturnValue, verb)
        }
        if (holder.i) {
            baseReturnValue = new SuffixI().toSyllabary(baseReturnValue, verb)
        }
        if (holder.dina) {
            baseReturnValue = new SuffixDina().toSyllabary(baseReturnValue, verb)
        }
        if (holder.na) {
            baseReturnValue = new SuffixNa().toSyllabary(baseReturnValue, verb)
        }
        if (holder.hv) {
            baseReturnValue = new SuffixHv().toSyllabary(baseReturnValue, verb)
        }
        if (holder.isi) {
            baseReturnValue = new SuffixIsi().toSyllabary(baseReturnValue, verb)
        }
        if (holder.idi) {
            baseReturnValue = new SuffixIdi().toSyllabary(baseReturnValue, verb)
        }
        if (holder.vi) {
            baseReturnValue = new SuffixVi().toSyllabary(baseReturnValue, verb)
        }
        if (holder.ei) {
            baseReturnValue = new SuffixEi().toSyllabary(baseReturnValue, verb)
        }
        if (holder.oi) {
            baseReturnValue = new SuffixOi().toSyllabary(baseReturnValue, verb)
        }
        if (holder.svi) {
            baseReturnValue = new SuffixSvi().toSyllabary(baseReturnValue, verb)
        }

        return baseReturnValue
    }

    /**
     * The past-family final Ꭲ drops before sgo/ju/ke
     * (remote past -v'i + ke -> -vke). Guards keep the drop from firing when
     * the base already ends in the particle's own initial vowel.
     */
    private static String applyIDrop(String baseReturnValue, Verb verb) {
        if (isPastFamily(verb.tense)
                && baseReturnValue.endsWith("Ꭲ")
                && !baseReturnValue.endsWith("ᏍᎢ")) {
            return baseReturnValue.substring(0, baseReturnValue.size() - 1)
        }
        return baseReturnValue
    }

    //review because si and svi are not endings but vi after ni is svi and isi after ni is si
    def static lstEndings = ["esdi", "idi", "gwu", "si", "sgo", "ju", "ke" , "na", "hv", "isi", "dina", "dv", "oi", "svi", "vi", "ei", "di",  "a", "i"]
    def static finalEnding = ["g", "h", "t", "ts", "l", "y"]
    def vi = ["ᎥᎢ", "ᎬᎢ", "ᎲᎢ", "ᎸᎢ", "ᏅᎢ", "ᏋᎢ", "ᏒᎢ", "ᏛᎢ", "ᏢᎢ", "ᏨᎢ", "ᏮᎢ", "ᏴᎢ"]
    def ei = ["ᎡᎢ", "ᎨᎢ", "ᎮᎢ", "ᎴᎢ", "ᎺᎢ", "ᏁᎢ", "ᏇᎢ", "ᏎᎢ", "ᏕᎢ", "ᏞᎢ", "ᏤᎢ", "ᏪᎢ", "ᏰᎢ"]
    
    /**
     * Suffix order for documentation (Feeling 1975, Figure 1, grammar guide p.282):
     * 
     * Position-9 family (tense-formant): idi, i
     * Position-10: oi (habitual)
     * Position-11: e (progressive) - NON-FINAL suffix handled separately
     * Position-12+: 
     *   gwu (also/too)
     *   sgo (perhaps)
     *   ju (just/recently)
     *   ke (question/emphasis)
     *   di (conditional)
     *   dv (focus)
     *   esdi (infinitive)
     *   a (assertive)
     *   i (factual)
     *   dina (plural around)
     *   na (contrastive)
     *   hv (interrogative)
     *   isi (exhaustive)
     *   idi (pre-incipient)
     *   svi (vowel-finalization after nasal)
     *   vi (completive form)
     *   ei (inchoative/resultative)
     */
}
