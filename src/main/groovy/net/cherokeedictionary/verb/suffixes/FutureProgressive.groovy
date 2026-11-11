package net.cherokeedictionary.verb.suffixes

/**
 * Future progressive: final suffix "-esdi", "will be doing" (grammar guide
 * ex. 93: ᎦᏬᏂᏍᎨᏍᏗ "He will be speaking"). Formed without the use of da-.
 *
 * "-esdi may also be used to form imperatives in the future progressive"
 * (ex. 94 "Be speaking when I get there"), and with some verbs an imperative
 * can only be formed with -esdi - which is why the verb book's Future
 * Imperative/Volative sections also contain "-esdi" rows.
 *
 * The progressive "-g-" before "-esdi" is the non-final suffix handled by
 * net.cherokeedictionary.verb.affixes.nonFinalSuffixes.NonFinalSuffixG; the
 * net.cherokeedictionary.verb.affixes.suffixes.SuffixEsdi affix appends it.
 */
class FutureProgressive implements Suffixes {
    static final def ROOTENDINGS = ["Ꭶ":"g", "Ꭽ":"h", "Ꮎ":"n", "Ꮃ":"l", "Ꮤ":"t", "Ꮣ":"d", "Ꮳ":"j", "Ꮿ":"y", "Ꭷ":"k", "Ꮜ":"s",
                                    "ᎸᎢ":'l', "ᏅᎢ":'n', "ᏒᎢ":'s', "ᎬᎢ":'g', "ᎲᎢ":'h', "ᏨᎢ":'j', "ᏴᎢ":'y', "ᏛᎢ":'d', "ᏮᎢ":'w', "ᏋᎢ": "qu", "ᏢᎢ":"tl", "ᎥᎢ":""]
    static final def FINALSUFFIX = 'esdi'

    @Override
    String getFinalSuffix() {
        return FINALSUFFIX
    }

    @Override
    Map getRootEndings() {
        return ROOTENDINGS
    }
}
