package cherokee.conjugation.verbal.containers

class VerbFinalSuffixHolderObject extends HolderObjectBase {
    def a = false
    def di = false
    def dina = false
    def dv = false
    def ei = false
    def esdi = false
    def gwu = false
    def hv = false
    def idi = false
    def isi = false
    def ju = false
    def ke = false
    def na = false
    def oi = false
    def sgo = false
    def vi = false

    public String getTrueValue() {
        map = ["a":a, "di":di, "dina":dina, "dv":dv, "ei":ei, "esdi":esdi, "gwu":gwu, "hv":hv, "idi":idi, "isi":isi, "ju":ju, "ke":ke, "na":na, "oi":oi, "sgo":sgo, "vi":vi]

        return getTrueValues().get(0)
    }

    @Override
    public String toString() {
        return "VerbFinalSuffixHolderObject{" +
                "a=" + a +
                ", di=" + di +
                ", dina=" + dina +
                ", dv=" + dv +
                ", ei=" + ei +
                ", esdi=" + esdi +
                ", gwu=" + gwu +
                ", hv=" + hv +
                ", idi=" + idi +
                ", isi=" + isi +
                ", ju=" + ju +
                ", ke=" + ke +
                ", na=" + na +
                ", oi=" + oi +
                ", sgo=" + sgo +
                ", vi=" + vi +
                '}';
    }
//
//    class VerbReflexivePrefixHolderObject extends HolderObjectBase {
//        def a = false
//        def di = false
//        def dina = false
//        def dv = false
//        def ei = false
//        def esdi = false
//        def gwu = false
//        def hv = false
//        def idi = false
//        def isi = false
//        def ju = false
//        def ke = false
//        def na = false
//        def oi = false
//        def sgo = false
//        def vi = false
//
//        public String getTrueValue() {
//            map = ["a":a, "di":di, "dina":dina, "dv":dv, "ei":ei, "esdi":esdi, "gwu":gwu, "hv":hv, "idi":idi, "isi":isi, "ju":ju, "ke":ke, "na":na, "oi":oi, "sgo":sgo, "vi":vi]
//
//            return getTrueValues().get(0)
//        }
//
//        @Override
//        public String toString() {
//            return "VerbFinalSuffixHolderObject{" +
//                    "a=" + a +
//                    ", di=" + di +
//                    ", dina=" + dina +
//                    ", dv=" + dv +
//                    ", ei=" + ei +
//                    ", esdi=" + esdi +
//                    ", gwu=" + gwu +
//                    ", hv=" + hv +
//                    ", idi=" + idi +
//                    ", isi=" + isi +
//                    ", ju=" + ju +
//                    ", ke=" + ke +
//                    ", na=" + na +
//                    ", oi=" + oi +
//                    ", sgo=" + sgo +
//                    ", vi=" + vi +
//                    '}';
//        }
}