package net.cherokeedictionary.grammarGuide
import spock.lang.Specification
class PrintPathSpec extends Specification {
    def "print"() {
        expect:
        def path = VerbBookEngineHarness.protectionDomain.codeSource.location.path
        println "PATH: ${path}"
    }
}
