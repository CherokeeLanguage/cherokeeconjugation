package net.cherokeedictionary.verb.suffixes

import net.cherokeedictionary.transliteration.SyllabaryUtil

class Present implements Suffixes {
    //"ᎢᎠ":"i", "ᎣᎠ":"o", "ᎥᎠ":"v", " ᎡᎠ":" e", "ᎠᎠ":"a", "ᎤᎠ":"u",
    static final def ROOTENDINGS = ["Ꭶ":"g", "Ꭽ":"h", "Ꮎ":"n", "Ꮃ":"l", "Ꮤ":"t", "Ꮣ":"d", "Ꮳ":"j", "Ꮿ":"y", "Ꭷ":"k", "Ꮜ":"s"]
    static final def FINALSUFFIX = 'a'

    @Override
    String getFinalSuffix() {
        return FINALSUFFIX
    }

    @Override
    Map getRootEndings() {
        return ROOTENDINGS
    }
}