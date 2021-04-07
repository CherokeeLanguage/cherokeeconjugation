package net.cherokeedcitionary.verbal.suffixes

class Present implements Suffixes {
    static final def ROOTENDINGS = ["Ꭽ":'h']
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
