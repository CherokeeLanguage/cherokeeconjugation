package net.cherokeedictionary.verb.suffixes

/**
 * Declarative future: final suffix "-i" (grammar guide, final-suffix slot 9: "-i-, future").
 *
 * Covers Tense.COMPLETIVE_FUTURE and Tense.COMPLETED_FUTURE. Per the verb book
 * ("NB: the Future is usually Stem III"), the Future is built on the Remote Past
 * stem (Stem III): -alihelitsel-v'i -> -alihelitsel-i, so the routed base form is
 * the Remote Past shape (root extraction strips -v'i, i.e. "vi"). A minority of
 * verbs take -esdi instead (To Be Somewhere -edoh-esdi, To Have (Long and Rigid)
 * -vy-esdi) — those are handled by FutureProgressive.
 *
 * Root endings merge the two families the existing suffix classes use:
 *   - plain consonant syllables (Present family: Ꭶ, Ꭽ, Ꮎ, ...),
 *   - consonant + Ꭲ compounds (RemotePast/Imperative family: ᎸᎢ, ᏅᎢ, ᏒᎢ, ...),
 *     the family that actually occurs on Stem III bases. -- timo 10Nov26
 */
class Future implements Suffixes {
    static final def ROOTENDINGS = ["Ꭶ":"g", "Ꭽ":"h", "Ꮎ":"n", "Ꮃ":"l", "Ꮤ":"t", "Ꮣ":"d", "Ꮳ":"j", "Ꮿ":"y", "Ꭷ":"k", "Ꮜ":"s",
                                    "ᎸᎢ":'l', "ᏅᎢ":'n', "ᏒᎢ":'s', "ᎬᎢ":'g', "ᎲᎢ":'h', "ᏨᎢ":'j', "ᏴᎢ":'y', "ᏛᎢ":'d', "ᏮᎢ":'w', "ᏋᎢ": "qu", "ᏢᎢ":"tl", "ᎥᎢ":""]
    static final def FINALSUFFIX = 'i'

    @Override
    String getFinalSuffix() {
        return FINALSUFFIX
    }

    @Override
    Map getRootEndings() {
        return ROOTENDINGS
    }
}
