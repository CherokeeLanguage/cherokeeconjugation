package net.cherokeedictionary.conjugation

import net.cherokeedictionary.verb.conjugation.Conjugate
import net.cherokeedictionary.stemmer.Stemmer
import net.cherokeedictionary.stemmer.DefinitionLine
import net.cherokeedictionary.util.Tense
import net.cherokeedictionary.util.PrefixTableSubject
import net.cherokeedictionary.util.PrefixTableObject
import net.cherokeedictionary.core.Verb
import spock.lang.Specification

class ImmediatePastDebugSpec extends Specification {
    def "debug immediate past conjugation"() {
        given: "a verb with immediate past stem"
        def stemmer = new Stemmer()
        stemmer.immediatepast = new DefinitionLine(syllabary: "ᎨᏓ")
        stemmer.present3rd = new DefinitionLine(syllabary: "ᎡᏙᎭ")

        def verb = new Verb()
        verb.stemmer = stemmer
        verb.tense = Tense.IMMEDIATE_PAST
        verb.subject = PrefixTableSubject.SG1
        verb.object = PrefixTableObject.SG3IN
        
        when: "we conjugate"
        Conjugate.conjugate(verb)

        then: "we check the output"
        println "Output: " + verb.wholeWord
        println "Root: " + verb.root
        
        expect:
        verb.wholeWord != null
    }
}
