package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.core.Verb
import net.cherokeedictionary.stemmer.DefinitionLine
import net.cherokeedictionary.stemmer.Stemmer
import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import net.cherokeedictionary.verb.conjugation.Conjugate
import spock.lang.Specification

class SandboxSpec extends Specification {

    def "Debug conjugation trace for a problematic verb"() {
        given: "A specific verb setup"
        def stemmer = new Stemmer()
        // Example: Gawoniha - Speaking
        stemmer.present3rd = new DefinitionLine(syllabary: SyllabaryUtil.tsalagiToSyllabary("gawoniha"))
        
        when: "We conjugate"
        // Adjust these to target the problematic verb/tense you want to debug
        def verb = Conjugate.conjugate("SG3", "SG3IN", stemmer, Tense.PRESENT.toString(), "v.i.", false)
        
        then: "Print the trace"
        println "--- SANDBOX TRACE ---"
        println verb.getTraceReport()
        println "Result: ${verb.wholeWord}"
        true
    }
}
