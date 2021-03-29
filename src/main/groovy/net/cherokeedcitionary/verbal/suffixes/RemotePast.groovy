package net.cherokeedcitionary.verbal.suffixes

class RemotePast implements Suffixes {
    static final def ROOTENDINGS = ["ᎸᎢ":'l', "ᏅᎢ":'n', "ᏒᎢ":'s', "ᎬᎢ":'g', "ᎲᎢ":'h', "ᏨᎢ":'j', "ᏴᎢ":'y', "ᏛᎢ":'d', "ᏮᎢ":'w', "ᏋᎢ": "qu", "ᏢᎢ":"tl", "ᎥᎢ":""]
    static final def FINALSUFFIX = 'vi'

    @Override
    String getFinalSuffix() {
        return FINALSUFFIX
    }

    @Override
    Map getRootEndings() {
        return ROOTENDINGS
    }
}
