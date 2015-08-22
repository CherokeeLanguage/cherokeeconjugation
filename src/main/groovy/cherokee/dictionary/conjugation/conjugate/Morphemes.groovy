package cherokee.dictionary.conjugation.conjugate

/**
 * Created by torr on 8/21/2015.
 */
class Morphemes {
    //make these arrays so the code is smaller
    static def processG(firstChar) {
        def prefix
        switch(firstChar) {
            case "Ꭰ":
                prefix = "Ꭶ"
                break;
            case "Ꭱ":
                prefix = "Ꭸ"
                break;
            case "Ꭲ":
                prefix = "Ꭹ"
                break;
            case "Ꭳ":
                prefix = "Ꭺ"
                break;
            case "Ꭴ":
                prefix = "Ꭻ"
                break;
            case "Ꭵ":
                prefix = "Ꭼ"
                break;
        }

        return prefix
    }

    static def processD(firstChar) {
        def prefix
        switch(firstChar) {
            case "Ꭰ":
                prefix = "Ꮣ"
                break;
            case "Ꭱ":
                prefix = "Ꮥ"
                break;
            case "Ꭲ":
                prefix = "Ꮧ"
                break;
            case "Ꭳ":
                prefix = "Ꮩ"
                break;
            case "Ꭴ":
                prefix = "Ꮪ"
                break;
            case "Ꭵ":
                prefix = "Ꮫ"
                break;
        }
        return prefix
    }

    static def processY(firstChar) {
        def prefix
        switch(firstChar) {
            case "Ꭰ":
                prefix = "Ꮿ"
                break;
            case "Ꭱ":
                prefix = "Ᏸ"
                break;
            case "Ꭲ":
                prefix = "Ᏹ"
                break;
            case "Ꭳ":
                prefix = "Ᏺ"
                break;
            case "Ꭴ":
                prefix = "Ᏻ"
                break;
            case "Ꭵ":
                prefix = "Ᏼ"
                break;
        }

        return prefix
    }

    static def processN(firstChar) {
        def prefix
        switch(firstChar) {
            case "Ꭰ":
                prefix = "Ꮎ"
                break;
            case "Ꭱ":
                prefix = "Ꮑ"
                break;
            case "Ꭲ":
                prefix = "Ꮒ"
                break;
            case "Ꭳ":
                prefix = "Ꮓ"
                break;
            case "Ꭴ":
                prefix = "Ꮔ"
                break;
            case "Ꭵ":
                prefix = "Ꮕ"
                break;
        }

        return prefix
    }

    static def processGW(firstChar) {
        def prefix
        switch(firstChar) {
            case "Ꭰ":
                prefix = "Ꮖ"
                break;
            case "Ꭱ":
                prefix = "Ꮗ"
                break;
            case "Ꭲ":
                prefix = "Ꮘ"
                break;
            case "Ꭳ":
                prefix = "Ꮙ"
                break;
            case "Ꭴ":
                prefix = "Ꮚ"
                break;
            case "Ꭵ":
                prefix = "Ꮛ"
                break;
        }

        return prefix
    }

    static def processH(firstChar) {
        def prefix
        switch(firstChar) {
            case "Ꭰ":
                prefix = "Ꭽ"
                break;
            case "Ꭱ":
                prefix = "Ꭾ"
                break;
            case "Ꭲ":
                prefix = "Ꭿ"
                break;
            case "Ꭳ":
                prefix = "Ꮀ"
                break;
            case "Ꭴ":
                prefix = "Ꮁ"
                break;
            case "Ꭵ":
                prefix = "Ꮂ"
                break;
        }

        return prefix
    }

    static def processJ(firstChar) {
        def prefix
        switch(firstChar) {
            case "Ꭰ":
                prefix = "Ꮳ"
                break;
            case "Ꭱ":
                prefix = "Ꮴ"
                break;
            case "Ꭲ":
                prefix = "Ꮵ"
                break;
            case "Ꭳ":
                prefix = "Ꮶ"
                break;
            case "Ꭴ":
                prefix = "Ꮷ"
                break;
            case "Ꭵ":
                prefix = "Ꮸ"
                break;
        }

        return prefix
    }

    static def processW(firstChar) {
        def prefix
        switch(firstChar) {
            case "Ꭰ":
                prefix = "Ꮹ"
                break;
            case "Ꭱ":
                prefix = "Ꮺ"
                break;
            case "Ꭲ":
                prefix = "Ꮻ"
                break;
            case "Ꭳ":
                prefix = "Ꮼ"
                break;
            case "Ꭴ":
                prefix = "Ꮽ"
                break;
            case "Ꭵ":
                prefix = "Ꮾ"
                break;
        }

        return prefix
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
