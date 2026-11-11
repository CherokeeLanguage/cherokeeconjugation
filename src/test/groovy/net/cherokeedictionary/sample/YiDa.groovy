package net.cherokeedictionary.sample

class YiDa extends Morph {
    static String prefix = "da"
    int priority = 0

    @Override
    void apply(incomingStr) {
        def compareString = incomingStr.SH
        if (compareString.startsWith("i")) {
            compareString = "dv" + compareString.substring(1)
        } else {
            compareString = "da" + compareString
        }

        incomingStr.SH = compareString
    }
}