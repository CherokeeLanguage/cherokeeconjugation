package net.cherokeedictionary.verb.containers

class VerbNonFinalSuffixHolderObject extends HolderObjectBase {
    // gi / is / idi / i exist as placeholder classes but are NOT FULLY IMPLEMENTED YET
    // (Feeling Figure 1, p.282 positions 1, 2, 8, 9); the flags exist so the wiring 
    // is ready when the allomorphy is implemented. KNOWN-GAP(NONFINAL-GI) NONFINAL-IS
    // NONFINAL-IDI NONFINAL-I
    // Note: Classes exist in src/main/groovy/net/cherokeedictionary/verb/affixes/nonFinalSuffixes/
    // but each contains TODO comments indicating incomplete implementation.
    boolean gi = false
    boolean is = false
    boolean idi = false
    boolean i = false
    boolean dan = false
    boolean dohdan = false
    boolean e  = false
    boolean el  = false
    boolean g  = false
    boolean idol  = false
    boolean ihl  = false
    boolean ilo   = false
    boolean ohn = false

    public String getTrueValue() {
        map = ["gi": gi, "is": is, "idi": idi, "i": i, "dan": dan, "dohdan": dohdan, "e": e, "el": el, "g": g, "idol": idol, "ihl": ihl, "ilo": ilo, "ohn": ohn]

        return getTrueValues().get(0)
    }

    @Override
    public String toString() {
        return "VerbNonFinalSuffixHolderObject{" +
                "gi=" + gi +
                ", is=" + is +
                ", idi=" + idi +
                ", i=" + i +
                ", dan=" + dan +
                ", dohdan=" + dohdan +
                ", e=" + e +
                ", el=" + el +
                ", g=" + g +
                ", idol=" + idol +
                ", ihl=" + ihl +
                ", ilo=" + ilo +
                ", ohn=" + ohn +
                '}';
    }
}