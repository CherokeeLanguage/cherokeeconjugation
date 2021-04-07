package net.cherokeedictionary.util

/**
 * Created by torr on 8/21/2015.
 */
class Morphemes {
    static def G = ["Ꭰ":"Ꭶ", "Ꭱ":"Ꭸ", "Ꭲ":"Ꭹ", "Ꭳ":"Ꭺ", "Ꭴ":"Ꭻ", "Ꭵ":"Ꭼ"]
    static def D = ["Ꭰ":"Ꮣ", "Ꭱ":"Ꮥ", "Ꭲ":"Ꮧ", "Ꭳ":"Ꮩ", "Ꭴ":"Ꮪ", "Ꭵ":"Ꮫ"]
    static def Y = ["Ꭰ":"Ꮿ", "Ꭱ":"Ᏸ", "Ꭲ":"Ᏹ", "Ꭳ":"Ᏺ", "Ꭴ":"Ᏻ", "Ꭵ":"Ᏼ"]
    static def N = ["Ꭰ":"Ꮎ", "Ꭱ":"Ꮑ", "Ꭲ":"Ꮒ", "Ꭳ":"Ꮓ", "Ꭴ":"Ꮔ", "Ꭵ":"Ꮕ"]
    static def GW = ["Ꭰ":"Ꮖ", "Ꭱ":"Ꮗ", "Ꭲ":"Ꮘ", "Ꭳ":"Ꮙ", "Ꭴ":"Ꮚ", "Ꭵ":"Ꮛ"]
    static def H = ["Ꭰ":"Ꭽ", "Ꭱ":"Ꭾ", "Ꭲ":"Ꭿ", "Ꭳ":"Ꮀ", "Ꭴ":"Ꮁ", "Ꭵ":"Ꮂ"]
    static def J = ["Ꭰ":"Ꮳ", "Ꭱ":"Ꮴ", "Ꭲ":"Ꮵ", "Ꭳ":"Ꮶ", "Ꭴ":"Ꮷ", "Ꭵ":"Ꮸ"]
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

        if (prefix == 'gw') {
            it = it.substring(2)
        } else {
            it = it.substring(1)
        }

        return [prefix, it]
    }
}
