package cherokee.dictionary.conjugation
import cherokee.dictionary.conjugation.conjugate.CompoundPrefix
import cherokee.dictionary.conjugation.conjugate.CompoundPrefixes
import cherokee.dictionary.conjugation.conjugate.Prefix
import cherokee.dictionary.conjugation.conjugate.Tense
import cherokee.dictionary.conjugation.conjugate.VerbSet

import static cherokee.dictionary.conjugation.conjugate.Tense.HABITUAL
import static cherokee.dictionary.conjugation.conjugate.Tense.PRESENT
import static cherokee.dictionary.conjugation.conjugate.Tense.REMOTE_PAST
import static cherokee.dictionary.conjugation.conjugate.VerbSet.B

/**
 * Created by torr on 8/20/2015.
 */
class Conjugate {
    public void log(prints) {
    boolean isDebug = false;
    if (isDebug) {
        println prints
    }
}

    //make these arrays so the code is smaller
    def processG(firstChar) {
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

    def processD(firstChar) {
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

    def processY(firstChar) {
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

    def processN(firstChar) {
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

    def processGW(firstChar) {
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

    def processH(firstChar) {
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

    def processJ(firstChar) {
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

    def processW(firstChar) {
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

    def fixPrefix(firstChar, prefix, it) {
        //groovy goodness - dynamic method call
        prefix = "process${prefix.toUpperCase()}"(firstChar)

        if (prefix == 'gw') {
            it = it.substring(2)
        } else {
            it = it.substring(1)
        }

        return [prefix, it]
    }

    def processPresentTense(//final PronominalPrefix pref,
                            final CompoundPrefix pref,
                            final VerbSet verbset,
                            String it ) {
        def returnPrefix = "";
        def vs = verbset == VerbSet.A ? "" : "B"

        if (it.startsWith("Ꭰ")
            || it.startsWith("Ꭱ")
            || it.startsWith("Ꭲ")
            || it.startsWith("Ꭳ")
            || it.startsWith("Ꭴ")
            || it.startsWith("Ꭵ")) {

            def verbPrefix ="${pref?.prefix1}${pref?.prefix2}${vs}" as String;

            //get the prefix from the table
            def tmpReturnPrefix = ((Prefix) CompoundPrefixes.prefixes.get(verbPrefix))?.preVowel
            if (tmpReturnPrefix) {
                //determine if last 1 or 2 characters need to be included in the conversion
                //if ends with gw then 2 - otherwise only 1
                def backspace = 1 //this is the count back that we need to get to the latin characters of the prefix
                if (tmpReturnPrefix.endsWith("gw")) {
                    backspace = 2
                }

                def prefixStart = tmpReturnPrefix.substring(0, tmpReturnPrefix.size() - backspace)
                log prefixStart

                def prefixEnd = tmpReturnPrefix.substring(tmpReturnPrefix.size() - backspace)
                log prefixEnd

                def fixedPrefix = fixPrefix(it.substring(0, 1), prefixEnd, it)
                log(fixedPrefix)

                returnPrefix = prefixStart + fixedPrefix[0]
                it = fixedPrefix[1]
            }
        } else {
            returnPrefix = ((Prefix) CompoundPrefixes.prefixes.get("${pref.prefix1}${pref.prefix2}${vs}" as String))?.preConsonant
        }

        if (!returnPrefix) {
            it = ""
        }

        return returnPrefix + it
    }

    def conjugate = { //final PronominalPrefix pref,
                      final CompoundPrefix pref,
                      final Tense tense,
                      VerbSet verbset,
                      String it ->
//        if (tense == Tense.REMOTE_PAST) {
//            verbset = VerbSet.B
//        }

        def returnValue = ""
        def presentTense = processPresentTense(pref, verbset, it)
        if (presentTense) {
            returnValue = presentTense
        }

        return returnValue
    }
}
