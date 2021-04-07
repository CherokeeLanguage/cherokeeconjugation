package cherokee.conjugation.dsl

import net.cherokeedcitionary.util.StringUtility

/*
if stem starts with a then -adad-
if starts with a then -ad-
if stem starts with consonant then -ada-
*/

def reflexive(Closure it) {
    def returnValue = ""
    if (it.startsWith("a")) {
        returnValue = "ad"+it
    } else if (StringUtility.startsWithVowelLatin(it)) {
        returnValue = "adad"+it
    } else {
        returnValue = "ada"+it
    }

    return returnValue
}

String stem = "gawoti" + "h"

println reflexive stem