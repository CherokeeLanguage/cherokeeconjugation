package cherokee.dictionary.conjugation.old

import cherokee.dictionary.conjugation.conjugate.CompoundPrefix
import cherokee.dictionary.conjugation.conjugate.CompoundPrefixes
import cherokee.dictionary.conjugation.conjugate.Prefix
import cherokee.dictionary.conjugation.conjugate.PrefixTableObject
import cherokee.dictionary.conjugation.conjugate.PrefixTableSubject
import cherokee.dictionary.conjugation.conjugate.Tense
import cherokee.dictionary.conjugation.conjugate.VerbSet

import static cherokee.dictionary.conjugation.conjugate.Tense.*
import static cherokee.dictionary.conjugation.conjugate.VerbSet.*
import cherokee.dictionary.conjugation.stem.VerbTenseHolder
import cherokee.dictionary.conjugation.stem.DefinitionLine
import cherokee.dictionary.conjugation.cdpbook.Stemmer

/**
 * Created by torr on 8/16/2015.
 * //TODO: run this code and compare to the cherokee verb study ocr pdf -- 16Aug15
 */
def helovesher = new Stemmer()

//he loves her
helovesher.habitual = new DefinitionLine(syllabary: "ᎤᎨᏳᏐᎢ")
helovesher.imperative = new DefinitionLine(syllabary: "ᎯᎨᏳᏎᏍᏗ")
helovesher.infinitive = new DefinitionLine(syllabary: "ᎤᎨᏳᏗ")
helovesher.present1st = new DefinitionLine(syllabary: "ᏥᎨᏳᎠ")
helovesher.present3rd = new DefinitionLine(syllabary: "ᎤᎨᏳᎭ")
helovesher.remotepast = new DefinitionLine(syllabary: "ᎤᎨᏳᏒᎢ")

//hat
def putOnAHat = new Stemmer()
putOnAHat.habitual = new DefinitionLine(syllabary: "ᎠᎵᏍᏇᏚᎲᏍᎪᎢ")
putOnAHat.imperative = new DefinitionLine(syllabary: "ᎭᎵᏍᏇᏚᎲᎦ")
putOnAHat.infinitive = new DefinitionLine(syllabary: "ᎤᎵᏍᏇᏚᏍᏗ")
putOnAHat.present1st = new DefinitionLine(syllabary: "ᎦᎵᏍᏇᏚᎲᏍᎦ")
putOnAHat.present3rd = new DefinitionLine(syllabary: "ᎠᎵᏍᏇᏚᎲᎦ")
putOnAHat.remotepast = new DefinitionLine(syllabary: "ᎤᎵᏍᏇᏚᏅᎢ")

//wants
def wants = new Stemmer()
wants.habitual = new DefinitionLine(syllabary: "ᎤᏚᎵᏍᎪᎢ")
wants.imperative = new DefinitionLine(syllabary: "ᏣᏚᎳ")
wants.infinitive = new DefinitionLine(syllabary: "ᎤᏚᎸᏗ")
wants.present1st = new DefinitionLine(syllabary: "ᎠᏆᏚᎵᎭ")
wants.present3rd = new DefinitionLine(syllabary: "ᎤᏚᎵᎭ")
wants.remotepast = new DefinitionLine(syllabary: "ᎤᏚᎸᎲᎢ")

VerbTenseHolder heLovesHerVTH = new VerbTenseHolder(stemmer: helovesher)
heLovesHerVTH.process()

VerbTenseHolder putOnAHatVTH = new VerbTenseHolder(stemmer: putOnAHat)
putOnAHatVTH.process()

VerbTenseHolder wantsVTH = new VerbTenseHolder(stemmer: wants)
wantsVTH.process()

public void log(prints) {
    boolean isDebug = false;
    if (isDebug) {
        println prints
    }
}

//make these arrays so the code is smaller
def processG(firstChar) {
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
}

def processD(firstChar) {
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
}

def processY(firstChar) {
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
}

def processN(firstChar) {
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
}

def processGW(firstChar) {
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
}

def processH(firstChar) {
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
}

def processJ(firstChar) {
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
}

def processW(firstChar) {
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

        def verbPrefix ="${pref.prefix1}${pref.prefix2}${vs}" as String;

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
        returnPrefix = ((Prefix) CompoundPrefixes.prefixes.get("${pref.prefix1}${pref.prefix2}${vs}" as String)).preConsonant
    }

    if (!returnPrefix) {
        it = ""
    }

    return returnPrefix + it
}

def conjugate = { //final PronominalPrefix pref,
                  final CompoundPrefix pref,
                  final Tense tense,
                  final VerbSet verbset,
                  String it ->
    switch(tense) {
        case PRESENT:
        case HABITUAL:
            def returnValue = ""
            def presentTense = processPresentTense(pref, verbset, it)
            if (presentTense) {
                returnValue = "${pref.prefix1} - ${pref.prefix2} -- ${presentTense}"
            }

            return returnValue
            break;
        case REMOTE_PAST:
            def returnValue = ""
            def presentTense = processPresentTense(pref, B, it)
            if (presentTense) {
                returnValue = "${pref.prefix1} - ${pref.prefix2} -- ${presentTense}"
            }

            return returnValue
            break;
    }
}

def conjugateAll = {Tense verbTense, String verbForm ->
    println ""
    println verbTense
//    println conjugate(CompoundPrefixes.SG1SG2, verbTense, A, verbForm)
//    println conjugate(CompoundPrefixes.SG1SG3AN, verbTense, A, verbForm)
//    println conjugate(CompoundPrefixes.SG1SG3IN, verbTense, A, verbForm)
//    println conjugate(CompoundPrefixes.SG1Dl2, verbTense, A, verbForm)
//    println conjugate(CompoundPrefixes.SG1PL2, verbTense, A, verbForm)
//    println conjugate(CompoundPrefixes.SG1PL3AN, verbTense, A, verbForm)
//    println conjugate(CompoundPrefixes.SG1PL3IN, verbTense, A, verbForm)
//
//    println conjugate(CompoundPrefixes.SG2SG1, verbTense, A, verbForm)
//    println conjugate(CompoundPrefixes.SG2SG2, verbTense, A, verbForm)
//    println conjugate(CompoundPrefixes.SG2SG3AN, verbTense, A, verbForm)
//    println conjugate(CompoundPrefixes.SG2SG3IN, verbTense, A, verbForm)
//    println conjugate(CompoundPrefixes.SG2DL1INCL, verbTense, A, verbForm)
//    println conjugate(CompoundPrefixes.SG2DL1EXCL, verbTense, A, verbForm)
//    println conjugate(CompoundPrefixes.SG2PL1INCL, verbTense, A, verbForm)
//    println conjugate(CompoundPrefixes.SG2PL1EXCl, verbTense, A, verbForm)
//    println conjugate(CompoundPrefixes.SG2Dl2, verbTense, A, verbForm)
//    println conjugate(CompoundPrefixes.SG2PL2, verbTense, A, verbForm)
//    println conjugate(CompoundPrefixes.SG2PL3AN, verbTense, A, verbForm)
//    println conjugate(CompoundPrefixes.SG2PL3IN, verbTense, A, verbForm)
//
//    println conjugate(CompoundPrefixes.SG3SG1, verbTense, A, verbForm)
//    println conjugate(CompoundPrefixes.SG3SG2, verbTense, A, verbForm)
//    println conjugate(CompoundPrefixes.SG3SG3AN, verbTense, A, verbForm)
//    println conjugate(CompoundPrefixes.SG3SG3IN, verbTense, A, verbForm)
//    println conjugate(CompoundPrefixes.SG3DL1INCL, verbTense, A, verbForm)
//    println conjugate(CompoundPrefixes.SG3DL1EXCL, verbTense, A, verbForm)
//    println conjugate(CompoundPrefixes.SG3PL1INCL, verbTense, A, verbForm)
//    println conjugate(CompoundPrefixes.SG3PL1EXCl, verbTense, A, verbForm)
//    println conjugate(CompoundPrefixes.SG3Dl2, verbTense, A, verbForm)
//    println conjugate(CompoundPrefixes.SG3PL2, verbTense, A, verbForm)
//    println conjugate(CompoundPrefixes.SG3PL3AN, verbTense, A, verbForm)
//    println conjugate(CompoundPrefixes.SG3PL3IN, verbTense, A, verbForm)
//
//    println conjugate(CompoundPrefixes.DLINCL1SG1, verbTense, A, verbForm)
//    println conjugate(CompoundPrefixes.DLINCL1SG2, verbTense, A, verbForm)
//    println conjugate(CompoundPrefixes.DLINCL1SG3AN, verbTense, A, verbForm)
//    println conjugate(CompoundPrefixes.DLINCL1SG3IN, verbTense, A, verbForm)
//    println conjugate(CompoundPrefixes.DLINCL1DL1INCL, verbTense, A, verbForm)
//    println conjugate(CompoundPrefixes.DLINCL1DL1EXCL, verbTense, A, verbForm)
//    println conjugate(CompoundPrefixes.DLINCL1PL1INCL, verbTense, A, verbForm)
//    println conjugate(CompoundPrefixes.DLINCL1PL1EXCl, verbTense, A, verbForm)
//    println conjugate(CompoundPrefixes.DLINCL1Dl2, verbTense, A, verbForm)
//    println conjugate(CompoundPrefixes.DLINCL1PL2, verbTense, A, verbForm)
//    println conjugate(CompoundPrefixes.DLINCL1PL3AN, verbTense, A, verbForm)
//    println conjugate(CompoundPrefixes.DLINCL1PL3IN, verbTense, A, verbForm)
//    println conjugate(CompoundPrefixes.DLEXCL1SG1, verbTense, A, verbForm)
//    println conjugate(CompoundPrefixes.DLEXCL1SG2, verbTense, A, verbForm)
//    println conjugate(CompoundPrefixes.DLEXCL1SG3AN, verbTense, A, verbForm)
//    println conjugate(CompoundPrefixes.DLEXCL1SG3IN, verbTense, A, verbForm)
//    println conjugate(CompoundPrefixes.DLEXCL1DL1INCL, verbTense, A, verbForm)
//    println conjugate(CompoundPrefixes.DLEXCL1DL1EXCL, verbTense, A, verbForm)
//    println conjugate(CompoundPrefixes.DLEXCL1PL1INCL, verbTense, A, verbForm)
//    println conjugate(CompoundPrefixes.DLEXCL1PL1EXCl, verbTense, A, verbForm)
//    println conjugate(CompoundPrefixes.DLEXCL1Dl2, verbTense, A, verbForm)
//    println conjugate(CompoundPrefixes.DLEXCL1PL2, verbTense, A, verbForm)
//    println conjugate(CompoundPrefixes.DLEXCL1PL3AN, verbTense, A, verbForm)
//    println conjugate(CompoundPrefixes.DLEXCL1PL3IN, verbTense, A, verbForm)
//    println conjugate(CompoundPrefixes.PLINCL1SG1, verbTense, A, verbForm)
//    println conjugate(CompoundPrefixes.PLINCL1SG2, verbTense, A, verbForm)
//    println conjugate(CompoundPrefixes.PLINCL1SG3AN, verbTense, A, verbForm)
//    println conjugate(CompoundPrefixes.PLINCL1SG3IN, verbTense, A, verbForm)
//    println conjugate(CompoundPrefixes.PLINCL1DL1INCL, verbTense, A, verbForm)
//    println conjugate(CompoundPrefixes.PLINCL1DL1EXCL, verbTense, A, verbForm)
//    println conjugate(CompoundPrefixes.PLINCL1PL1INCL, verbTense, A, verbForm)
//    println conjugate(CompoundPrefixes.PLINCL1PL1EXCl, verbTense, A, verbForm)
//    println conjugate(CompoundPrefixes.PLINCL1Dl2, verbTense, A, verbForm)
//    println conjugate(CompoundPrefixes.PLINCL1PL2, verbTense, A, verbForm)
//    println conjugate(CompoundPrefixes.PLINCL1PL3AN, verbTense, A, verbForm)
//    println conjugate(CompoundPrefixes.PLINCL1PL3IN, verbTense, A, verbForm)
//    println conjugate(CompoundPrefixes.PLEXCL1SG1, verbTense, A, verbForm)
//    println conjugate(CompoundPrefixes.PLEXCL1SG2, verbTense, A, verbForm)
//    println conjugate(CompoundPrefixes.PLEXCL1SG3AN, verbTense, A, verbForm)
//    println conjugate(CompoundPrefixes.PLEXCL1SG3IN, verbTense, A, verbForm)
//    println conjugate(CompoundPrefixes.PLEXCL1DL1INCL, verbTense, A, verbForm)
//    println conjugate(CompoundPrefixes.PLEXCL1DL1EXCL, verbTense, A, verbForm)
//    println conjugate(CompoundPrefixes.PLEXCL1PL1INCL, verbTense, A, verbForm)
//    println conjugate(CompoundPrefixes.PLEXCL1PL1EXCl, verbTense, A, verbForm)
//    println conjugate(CompoundPrefixes.PLEXCL1Dl2, verbTense, A, verbForm)
//    println conjugate(CompoundPrefixes.PLEXCL1PL2, verbTense, A, verbForm)
//    println conjugate(CompoundPrefixes.PLEXCL1PL3AN, verbTense, A, verbForm)
//    println conjugate(CompoundPrefixes.PLEXCL1PL3IN, verbTense, A, verbForm)
//    println conjugate(CompoundPrefixes.DL2SG1, verbTense, A, verbForm)
//    println conjugate(CompoundPrefixes.DL2SG2, verbTense, A, verbForm)
//    println conjugate(CompoundPrefixes.DL2SG3AN, verbTense, A, verbForm)
//    println conjugate(CompoundPrefixes.DL2SG3IN, verbTense, A, verbForm)
//    println conjugate(CompoundPrefixes.DL2DL1INCL, verbTense, A, verbForm)
//    println conjugate(CompoundPrefixes.DL2DL1EXCL, verbTense, A, verbForm)
//    println conjugate(CompoundPrefixes.DL2PL1INCL, verbTense, A, verbForm)
//    println conjugate(CompoundPrefixes.DL2PL1EXCl, verbTense, A, verbForm)
//    println conjugate(CompoundPrefixes.DL2Dl2, verbTense, A, verbForm)
//    println conjugate(CompoundPrefixes.DL2PL2, verbTense, A, verbForm)
//    println conjugate(CompoundPrefixes.DL2PL3AN, verbTense, A, verbForm)
//    println conjugate(CompoundPrefixes.DL2PL3IN, verbTense, A, verbForm)
//    println conjugate(CompoundPrefixes.PL2SG1, verbTense, A, verbForm)
//    println conjugate(CompoundPrefixes.PL2SG2, verbTense, A, verbForm)
//    println conjugate(CompoundPrefixes.PL2SG3AN, verbTense, A, verbForm)
//    println conjugate(CompoundPrefixes.PL2SG3IN, verbTense, A, verbForm)
//    println conjugate(CompoundPrefixes.PL2DL1INCL, verbTense, A, verbForm)
//    println conjugate(CompoundPrefixes.PL2DL1EXCL, verbTense, A, verbForm)
//    println conjugate(CompoundPrefixes.PL2PL1INCL, verbTense, A, verbForm)
//    println conjugate(CompoundPrefixes.PL2PL1EXCl, verbTense, A, verbForm)
//    println conjugate(CompoundPrefixes.PL2Dl2, verbTense, A, verbForm)
//    println conjugate(CompoundPrefixes.PL2PL2, verbTense, A, verbForm)
//    println conjugate(CompoundPrefixes.PL2PL3AN, verbTense, A, verbForm)
//    println conjugate(CompoundPrefixes.PL2PL3IN, verbTense, A, verbForm)
//    println conjugate(CompoundPrefixes.PL3SG1, verbTense, A, verbForm)
//    println conjugate(CompoundPrefixes.PL3SG2, verbTense, A, verbForm)
//    println conjugate(CompoundPrefixes.PL3SG3AN, verbTense, A, verbForm)
//    println conjugate(CompoundPrefixes.PL3SG3IN, verbTense, A, verbForm)
//    println conjugate(CompoundPrefixes.PL3DL1INCL, verbTense, A, verbForm)
//    println conjugate(CompoundPrefixes.PL3DL1EXCL, verbTense, A, verbForm)
//    println conjugate(CompoundPrefixes.PL3PL1INCL, verbTense, A, verbForm)
//    println conjugate(CompoundPrefixes.PL3PL1EXCl, verbTense, A, verbForm)
//    println conjugate(CompoundPrefixes.PL3Dl2, verbTense, A, verbForm)
//    println conjugate(CompoundPrefixes.PL3PL2, verbTense, A, verbForm)
//    println conjugate(CompoundPrefixes.PL3PL3AN, verbTense, A, verbForm)
//    println conjugate(CompoundPrefixes.PL3PL3IN, verbTense, A, verbForm)

    println "B"
    println conjugate(CompoundPrefixes.SG1SG3INB, verbTense, B, verbForm)
    println conjugate(CompoundPrefixes.SG2SG3INB, verbTense, B, verbForm)
    println conjugate(CompoundPrefixes.SG3SG3INB, verbTense, B, verbForm)
    println conjugate(CompoundPrefixes.DLINCL13SGINB, verbTense, B, verbForm)
    println conjugate(CompoundPrefixes.PLINCL13SGINB, verbTense, B, verbForm)
    println conjugate(CompoundPrefixes.DL1EXCL3SGINB, verbTense, B, verbForm)
    println conjugate(CompoundPrefixes.PLEXCL13SGINB, verbTense, B, verbForm)
    println conjugate(CompoundPrefixes.PL3SG3INB, verbTense, B, verbForm)
    println conjugate(CompoundPrefixes.SG1PL3INB, verbTense, B, verbForm)
    println conjugate(CompoundPrefixes.SG2PL3INB, verbTense, B, verbForm)
    println conjugate(CompoundPrefixes.SG3PL3INB, verbTense, B, verbForm)
    println conjugate(CompoundPrefixes.DLINCL13PLINB, verbTense, B, verbForm)
    println conjugate(CompoundPrefixes.PLINCL13PLINB, verbTense, B, verbForm)
    println conjugate(CompoundPrefixes.DL1EXCL3PLINB, verbTense, B, verbForm)
    println conjugate(CompoundPrefixes.PLEXCL13PLINB, verbTense, B, verbForm)
    println conjugate(CompoundPrefixes.PL3PL3INB, verbTense, B, verbForm)
}

//conjugateAll(PRESENT, heLovesHerVTH.present)
//conjugateAll(PRESENT, putOnAHatVTH.present)
conjugateAll(PRESENT, wantsVTH.present)
//conjugateAll(REMOTE_PAST, wantsVTH.present)
//conjugateAll(COMPLETIVE_FUTURE, completiveFuture)
//conjugateAll(FUTURE_COMMAND, completiveFuture)
//conjugateAll(PROGRESSIVE_PAST, progressivePast)
//conjugateAll(REMOTE_PAST, remotePast)
//conjugateAll(HABITUAL, habitual)
//conjugateAll(PROGRESSIVE_FUTURE, progressiveFuture)
//conjugateAll(IMMEDIATE_COMMAND, immediateCommand)
//conjugateAll(INFINITIVE, infinitive)
