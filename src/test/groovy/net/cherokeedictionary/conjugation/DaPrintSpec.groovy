package net.cherokeedictionary.conjugation

import net.cherokeedictionary.stemmer.DefinitionLine
import net.cherokeedictionary.stemmer.Stemmer
import net.cherokeedictionary.util.PartOfSpeech
import net.cherokeedictionary.verb.conjugation.Conjugate
import groovy.util.GroovyTestCase

class DaPrintSpec extends GroovyTestCase {
    void testPrint() {
        def bark = new Stemmer()
        [habitual:"ᏓᏑᏫᏍᎪᎢ",imperative:"ᏔᏑᏫ",infinitive:"ᏧᏑᏫᏍᏗ",present1st:"ᏕᎦᏑᏫᏍᎦ",present3rd:"ᏓᏑᏫᏍᎦ",remotepast:"ᏚᏑᏫᏒᎢ"].each { k,v -> bark."$k" = new DefinitionLine(syllabary: v) }
        println "stems: " + bark.stems.collect { "${it.stemtype}=${it.syllabary}" }
        println "flags: da=" + bark.normalizedDaInitialPrefix + " de=" + bark.normalizedDeStyle + " openU=" + bark.normalizedDaOpenU + " fuseA=" + bark.normalizedDaFuseA
        def verb = Conjugate.createVerbToConjugate("SG3", "SG3AN", bark, "REMOTE_PAST", PartOfSpeech.VERB_INTRANSITIVE.toString(), false)
        def c = Conjugate.conjugate(verb)
        println "remote SG3: root=" + c.pronounReflexiveRoot + " whole=" + c.wholeWord + " compound=" + (c.compoundPrefix?.class?.simpleName)
    }
}
