package net.cherokeedictionary.stem.lemma

def focus = "dv";
def concessiveImperative = "dina";
def orelse = "isi";
def but = "hv";
def andWhatIf = "na";
def orInterrogative = "ke";
def interrogative = "ju";
def interrogative2 = "sgo";
def onlyJustStill = "gwu";

def finalEndings = [focus, concessiveImperative, orelse, but, andWhatIf, orInterrogative, interrogative, interrogative2, onlyJustStill]

def futureImperative = "vi";
def present = "a";
def infinitive = "di";
def habitual = "oi";
def pluperfect = "oi";
def futureProgressive = "esdi";
def reportative = "ei";
def past = "vi";
def future = "i";
def preIncipient = "idi";

def tenseEndings = [futureImperative, present, infinitive, habitual, pluperfect, futureProgressive, reportative, past, future, preIncipient]

def progressive = "g";
def comeTo = "ihl";//ihis
def atIntervals = "e";
def around = "idol";
def dativeBenefactive = "el";
def completive = "ohn";
def unintentional = "dohdan";
def instrumentalCausative = "dan";
def repetitive = "ilo";

def nonFinalSuffixes = [progressive, comeTo, atIntervals, around, dativeBenefactive, completive, unintentional, instrumentalCausative, repetitive]

def testWord = "uwonisei"
def testWord2 = "uwonisiloei"//-ilo? -ilos
def testWord3 = "gawonisgvi"
def testWord4 = "gawonisilosgvi"//ilo -iloj before imperative -a --- if imperative then -a changes to -i when followed by another suffix
def testWord5 = "hiwonihi"
def testWord6 = "hiwonisiloja"

//def gawoniha = "gawoniha"
//def gawonihihia = "gawonihila"
//
//def returnValue = gawonihihia
//finalEndings.each {
//    if (returnValue.endsWith(it)) {
//        returnValue = returnValue.substring(0, returnValue.size() - it.size())
//    }
//}
//
//tenseEndings.each {
//    if (returnValue.endsWith(it)) {
//        returnValue = returnValue.substring(0, returnValue.size() - it.size())
//    }
//}
//
//nonFinalSuffixes.each {
//    if (returnValue.endsWith(it)) {
//        returnValue = returnValue.substring(0, returnValue.size() - it.size())
//    } else {
//        println it
//    }
//}
//
//println returnValue