package net.cherokeedcitionary.verbal.containers

class VerbNonFinalSuffixHolderObject extends HolderObjectBase {
    boolean dan = false
    boolean dohdan = false
    boolean e  = false
    boolean el  = false
    boolean g  = false
    boolean idol  = false
    boolean ihi  = false
    boolean ilo   = false
    boolean ohn = false

    public String getTrueValue() {
        map = ["dan": dan, "dohdan": dohdan, "e": e, "el": el, "g": g, "idol": idol, "ihi": ihi, "ilo": ilo, "ohn": ohn]

        return getTrueValues().get(0)
    }

    @Override
    public String toString() {
        return "VerbNonFinalSuffixHolderObject{" +
                "dan=" + dan +
                ", dohdan=" + dohdan +
                ", e=" + e +
                ", el=" + el +
                ", g=" + g +
                ", idol=" + idol +
                ", ihi=" + ihi +
                ", ilo=" + ilo +
                ", ohn=" + ohn +
                '}';
    }
}