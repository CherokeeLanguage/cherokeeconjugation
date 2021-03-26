package cherokee.dictionary.conjugation.old

import cherokee.dictionary.conjugation.conjugate.CompoundPrefix
import cherokee.dictionary.conjugation.conjugate.CompoundPrefixes
import cherokee.dictionary.conjugation.conjugate.Prefix
import cherokee.dictionary.conjugation.conjugate.PrefixTableObject
import cherokee.dictionary.conjugation.conjugate.PrefixTableSubject

import static cherokee.dictionary.conjugation.conjugate.VerbSet.A

/**
 * Created by torr on 8/18/2015.
 * this takes all of the subjects and objects and creates a matrix to do look ups with in order to get the pronominal prefix
 */

def defined = []
def prefices = []
def conjugate = []

PrefixTableSubject.values().each { subject ->
    PrefixTableObject.values().each { object ->
//        println "${subject} - ${object}"
        defined << "static def ${subject}${object} = new CompoundPrefix(prefix1: PrefixTableSubject.${subject}, prefix2: PrefixTableObject.${object})"
        prefices << "prefixes.put(\"${subject}${object}\", new Prefix(preVowel: '', preConsonant: '', other: ''))"
        conjugate << "conjugate(CompoundPrefixes.${subject}${object}, verbTense, A, verbForm)"
    }
}

/*defined.each {
    println it
}

prefices.each {
    println it
}*/

conjugate.each {
    println it
}