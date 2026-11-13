package net.cherokeedictionary.grammarGuide
import spock.lang.Specification
class PrintSpec extends Specification {
    def "print"() {
        expect:
        println "HELLO WORLD"
        true
    }
}
