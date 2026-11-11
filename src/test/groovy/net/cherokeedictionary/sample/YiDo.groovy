package net.cherokeedictionary.sample

class YiDo extends Morph {
    static String prefix = "do"
    int priority = 2

    @Override
    void apply(incomingStr) {
        println incomingStr.SH
        def compareString = incomingStr.SH

        if (compareString.startsWith(YiDa.prefix)) {
            compareString = prefix + compareString.substring(YiDa.prefix.size())
        }

        incomingStr.SH = compareString
    }
}