package net.cherokeedictionary.conjugation
import spock.lang.Specification
import net.cherokeedictionary.util.PrefixTableSubject
import net.cherokeedictionary.util.PrefixTableObject

class EnumProbeSpec extends Specification {
    def "check enums"() {
        expect:
        println "SG1: " + PrefixTableSubject.valueOf("SG1")
        println "SG3IN: " + PrefixTableObject.valueOf("SG3IN")
        println "PL3IN: " + PrefixTableObject.valueOf("PL3IN")
        true
    }
}
