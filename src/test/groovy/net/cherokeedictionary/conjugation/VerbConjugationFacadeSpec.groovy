package net.cherokeedictionary.conjugation

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

    // tio 21Nov26: A1 facade wiring -- request.reflexive reaches
    // createVerbToConjugate; guide hold1 P1 "I see myself" ᎦᏓᎪᏩᏘᎭ and
    // P5 "he forgets himself" ᎠᏓᏛᎨᏫᏍᎦ (class-B verb, Set A override). -- tio 21Nov26
    def "reflexive flag conjugates the guide hold1 fixtures"() {
        given:
        def facade = new VerbConjugationFacade()

        def see = new ConjugationRequest(
            subject: "SG1",
            object: "NONE",
            verbTense: "PRESENT",
            partOfSpeech: "VT",
            present1st: "ᏥᎪᏩᏘᎭ",
            present3rd: "ᎠᎪᏩᏘᎭ",
            remotepast: "ᎤᎪᎲᎢ",
            habitual: "ᎠᎪᏩᏘᏍᎪᎢ",
            imperative: "ᎠᎪᏩᏙ",
            infinitive: "ᎤᎪᏩᏘᏍᏗ",
            reflexive: "true"
        )
        def forget = new ConjugationRequest(
            subject: "SG3",
            object: "NONE",
            verbTense: "PRESENT",
            partOfSpeech: "VT",
            present1st: "ᎠᏆᎨᏫᏍᎦ",
            present3rd: "ᎤᏩᎨᏫᏍᎦ",
            remotepast: "ᎤᏩᎨᏫᏒᎢ",
            habitual: "ᎤᏩᎨᏫᏍᎪᎢ",
            imperative: "ᏫᎤᏩᎨᏩ",
            infinitive: "ᎤᏩᎨᏫᏍᏗ",
            reflexive: "true"
        )

        when:
        def vSee = facade.conjugate(see)
        def vForget = facade.conjugate(forget)

        then:
        vSee.wholeWord == "ᎦᏓᎪᏩᏘᎭ"
        vForget.wholeWord == "ᎠᏓᏛᎨᏫᏍᎦ"
    }
}
