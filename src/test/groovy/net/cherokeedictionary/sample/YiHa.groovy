package net.cherokeedictionary.sample

class YiHa extends Morph {
    String prefix = "ha"
    int priority = 1

    @Override
    void apply(incomingStr) {
        def compareString = incomingStr.SH

        incomingStr.SH = compareString
    }
}
