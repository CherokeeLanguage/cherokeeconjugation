package net.cherokeedictionary.util

/**
 * Created by torr on 8/21/2015.
 */
class Morphemes {
    static def G = ["Ꭰ":"Ꭶ", "Ꭱ":"Ꭸ", "Ꭲ":"Ꭹ", "Ꭳ":"Ꭺ", "Ꭴ":"Ꭻ", "Ꭵ":"Ꭼ"]
    static def D = ["Ꭰ":"Ꮣ", "Ꭱ":"Ꮥ", "Ꭲ":"Ꮧ", "Ꭳ":"Ꮩ", "Ꭴ":"Ꮪ", "Ꭵ":"Ꮫ"]
    static def Y = ["Ꭰ":"Ꮿ", "Ꭱ":"Ᏸ", "Ꭲ":"Ᏹ", "Ꭳ":"Ᏺ", "Ꭴ":"Ᏻ", "Ꭵ":"Ᏼ"]
    // tio 21Nov26: D27 boundary fusion -- n + the stem's sg3 w artifact
    // (Ꮹ-series) fuses to nv (Ꮕ) exactly as n + Ꭵ does (guide P4(21)-(23)
    // an/un/dan + wa-stem -> anv/unv/danv; corpus ᎤᏅᎨᏫᏒᎯ MAK 8:14,
    // ᎤᏅᏂᏍᏗᏱ LUK 20:10, ᏓᏅᎩᎶᏍᎨ LUK 5:2). The artifact glyph is consumed
    // by fixPrefix (it.substring(1)).
    static def N = ["Ꭰ":"Ꮎ", "Ꭱ":"Ꮑ", "Ꭲ":"Ꮒ", "Ꭳ":"Ꮓ", "Ꭴ":"Ꮔ", "Ꭵ":"Ꮕ",
                    "Ꮹ":"Ꮕ", "Ꮺ":"Ꮕ", "Ꮻ":"Ꮕ", "Ꮼ":"Ꮕ", "Ꮽ":"Ꮕ", "Ꮾ":"Ꮕ"]
    static def GW = ["Ꭰ":"Ꮖ", "Ꭱ":"Ꮗ", "Ꭲ":"Ꮘ", "Ꭳ":"Ꮙ", "Ꭴ":"Ꮚ", "Ꭵ":"Ꮛ"]
    static def H = ["Ꭰ":"Ꭽ", "Ꭱ":"Ꭾ", "Ꭲ":"Ꭿ", "Ꭳ":"Ꮀ", "Ꭴ":"Ꮁ", "Ꭵ":"Ꮂ"]
    static def J = ["Ꭰ":"Ꮳ", "Ꭱ":"Ꮴ", "Ꭲ":"Ꮵ", "Ꭳ":"Ꮶ", "Ꭴ":"Ꮷ", "Ꭵ":"Ꮸ"]
    // tio 21Nov26: Ꭵ->Ꮾ (wv) RESTORED -- the book attests uw+v-stem = wv for
    // real v-initial stems (Kdega ᎤᏮᏕᏨᎢ uwvdetsvi, Uwanvga ᎤᏮᏆᏅᏍᏗ); the
    // P8(5)/(6) duwa-/uwa- forms route through RuleVtoA (artifact-a) + the
    // fixPrefix wa fusion instead, not this map.
    static def W = ["Ꭰ":"Ꮹ", "Ꭱ":"Ꮺ", "Ꭲ":"Ꮻ", "Ꭳ":"Ꮼ", "Ꭴ":"Ꮽ", "Ꭵ":"Ꮾ"]
    
    //make these arrays so the code is smaller
    static def processG(firstChar) {
        return G.get(firstChar)
    }

    static def processD(firstChar) {
        return D.get(firstChar)
    }

    static def processY(firstChar) {
        return Y.get(firstChar)
    }

    static def processN(firstChar) {
        return N.get(firstChar)
    }

    static def processGW(firstChar) {
        return GW.get(firstChar)
    }

    static def processH(firstChar) {
        return H.get(firstChar)
    }

    static def processJ(firstChar) {
        return J.get(firstChar)
    }

    static def processW(firstChar) {
        return W.get(firstChar)
    }

    public static def fixPrefix(firstChar, prefix, it) {
        //groovy goodness - dynamic method call
        prefix = "process${prefix.toUpperCase()}"(firstChar)

        it = it.substring(1)

        return [prefix, it]
    }
}
