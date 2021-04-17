package net.cherokeedictionary.verb.suffixes

class Habitual implements Suffixes {
    static final def ROOTENDINGS = ["ᎪᎢ":"g", "ᎰᎢ":"h", "ᏃᎢ":"n", "ᎶᎢ":"l", "ᏙᎢ":"t", "ᏙᎢ":"d", "ᏦᎢ":"j", "ᏲᎢ":"y", "ᎪᎢ":"k", "ᏐᎢ":"s"]
    static final def FINALSUFFIX = 'oi'
//Ꮝ
    @Override
    String getFinalSuffix() {
        return FINALSUFFIX
    }

    @Override
    Map getRootEndings() {
        return ROOTENDINGS
    }
}