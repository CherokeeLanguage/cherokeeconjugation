package net.cherokeedictionary.proposed

import spock.lang.Specification

class VerbConjugationFacadeSpec extends Specification {

    def "should conjugate verb using ConjugationRequest and pipeline facade"() {
        given:
        def request = new ConjugationRequest(
            subject: "SG1",
            object: "NONE",
            verbTense: "PRESENT",
            partOfSpeech: "VT",
            present1st: "ᏥᏬᏂᎭ",
            present3rd: "ᎦᏬᏂᎭ",
            habitual: "ᎦᏬᏂᏍᎪᎢ",
            infinitive: "ᎤᏬᏂᎯᏍᏗ",
            imperative: "ᎯᏬᏂᎯ",
            remotepast: "ᎤᏬᏂᏒᎢ",
            yi: "true"
        )
        def facade = new VerbConjugationFacade()

        when:
        def verb = facade.conjugate(request)

        then:
        verb != null
        verb.initialPrefixHolder.yi == true
        verb.display != null
    }

    def "should support context audit trail and analysis stub"() {
        given:
        def request = new ConjugationRequest(
            subject: "SG3",
            object: "NONE",
            verbTense: "PRESENT",
            present3rd: "ᎦᏬᏂᎭ"
        )
        def facade = new VerbConjugationFacade()

        when:
        def context = facade.analyze(request)

        then:
        context != null
        context.auditTrail.size() > 0
    }
}
