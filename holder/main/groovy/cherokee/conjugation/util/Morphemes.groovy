package cherokee.conjugation.util

/**
 * Created by torr on 8/21/2015.
 */
class Morphemes {
    static def g = ["Ꭰ":"Ꭶ", "Ꭱ":"Ꭸ", "Ꭲ":"Ꭹ", "Ꭳ":"Ꭺ", "Ꭴ":"Ꭻ", "Ꭵ":"Ꭼ"]
    static def d = ["Ꭰ":"Ꮣ", "Ꭱ":"Ꮥ", "Ꭲ":"Ꮧ", "Ꭳ":"Ꮩ", "Ꭴ":"Ꮪ", "Ꭵ":"Ꮫ"]
    static def y = ["Ꭰ":"Ꮿ", "Ꭱ":"Ᏸ", "Ꭲ":"Ᏹ", "Ꭳ":"Ᏺ", "Ꭴ":"Ᏻ", "Ꭵ":"Ᏼ"]
    static def n = ["Ꭰ":"Ꮎ", "Ꭱ":"Ꮑ", "Ꭲ":"Ꮒ", "Ꭳ":"Ꮓ", "Ꭴ":"Ꮔ", "Ꭵ":"Ꮕ"]
    static def gw = ["Ꭰ":"Ꮖ", "Ꭱ":"Ꮗ", "Ꭲ":"Ꮘ", "Ꭳ":"Ꮙ", "Ꭴ":"Ꮚ", "Ꭵ":"Ꮛ"]
    static def h = ["Ꭰ":"Ꭽ", "Ꭱ":"Ꭾ", "Ꭲ":"Ꭿ", "Ꭳ":"Ꮀ", "Ꭴ":"Ꮁ", "Ꭵ":"Ꮂ"]
    static def j = ["Ꭰ":"Ꮳ", "Ꭱ":"Ꮴ", "Ꭲ":"Ꮵ", "Ꭳ":"Ꮶ", "Ꭴ":"Ꮷ", "Ꭵ":"Ꮸ"]
    static def w = ["Ꭰ":"Ꮹ", "Ꭱ":"Ꮺ", "Ꭲ":"Ꮻ", "Ꭳ":"Ꮼ", "Ꭴ":"Ꮽ", "Ꭵ":"Ꮾ"]
    
    //make these arrays so the code is smaller
    static def processG(firstChar) {
        return g.get(firstChar)
    }

    static def processD(firstChar) {
        return d.get(firstChar)
    }

    static def processY(firstChar) {
        return y.get(firstChar)
    }

    static def processN(firstChar) {
        return n.get(firstChar)
    }

    static def processGW(firstChar) {
        return gw.get(firstChar)
    }

    static def processH(firstChar) {
        return h.get(firstChar)
    }

    static def processJ(firstChar) {
        return j.get(firstChar)
    }

    static def processW(firstChar) {
        return w.get(firstChar)
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
