package net.cherokeedictionary.conjugation.attestation

import spock.lang.Specification

/**
 * Attestation registry contract -- Phase 1 of the reliability roadmap
 * (user request 2026-11-20). The index is built from the Cherokee New
 * Testament + the modern news/story corpus; the sample citations below come
 * straight from the corpus files. -- tio 20Nov26
 */
class AttestationRegistrySpec extends Specification {

    def "index loads with a substantial form count"() {
        expect:
        AttestationRegistry.formCount() > 25000
    }

    def "NT-attested forms carry book chapter:verse citations"() {
        when:
        // ᎠᎩᎪᎲᎩ 'saw it' -- remote past of 'see', NT Revelation; ᎤᏙᎯᏳᎯᏯ 'verily'
        def cits = AttestationRegistry.citations('ᎠᎩᎪᎲᎩ')

        then:
        cits != null
        cits.containsKey('NT')
        cits['NT'].contains('REV 22:8')
        AttestationRegistry.isAttested('ᎠᎩᎪᎲᎩ')
        AttestationRegistry.isAttested('ᎤᏙᎯᏳᎯᏯ')
        AttestationRegistry.citations('ᎤᏙᎯᏳᎯᏯ')['NT'].contains('1JN 5:20')
    }

    def "corpus-attested forms carry corpus id citations"() {
        when:
        def cits = AttestationRegistry.citations('ᏚᏳᎪᏛ')

        then:
        cits != null
        cits.containsKey('CORPUS')
        cits['CORPUS'][0].startsWith('corpus:')
        AttestationRegistry.isAttested('ᏚᏳᎪᏛ')
    }

    def "unattested form returns null citations and false attested"() {
        expect:
        AttestationRegistry.citations('ᎤᏂᏬᏂᏍᎬᏯᏗᏛᏉ') == null
        !AttestationRegistry.isAttested('ᎤᏂᏬᏂᏍᎬᏯᏗᏛᏉ')
        !AttestationRegistry.isAttested('')
        !AttestationRegistry.isAttested(null)
    }

    def "citation map is a defensive copy"() {
        when:
        def cits = AttestationRegistry.citations('ᎤᏙᎯᏳᎯᏯ')
        cits['NT'].add('TAMPERED')

        then:
        AttestationRegistry.citations('ᎤᏙᎯᏳᎯᏯ')['NT'].contains('TAMPERED') == false
    }
}
