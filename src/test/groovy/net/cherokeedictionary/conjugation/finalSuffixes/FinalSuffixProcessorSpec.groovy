package net.cherokeedictionary.conjugation.finalSuffixes

import net.cherokeedictionary.core.Verb
import net.cherokeedictionary.util.Tense
import net.cherokeedictionary.verb.containers.FinalSuffixProcessor
import net.cherokeedictionary.verb.containers.VerbFinalSuffixHolderObject
import spock.lang.Specification

/**
 * Comprehensive specification testing the FinalSuffixProcessor implementation.
 * Tests use ACTUAL suffix syllabary values from their implementations.
 */
class FinalSuffixProcessorSpec extends Specification {

    /** Helper to create a test verb with given parameters */
    private Verb createTestVerb(String word = 'ᎦᏬᏂᎭ', Tense tense = Tense.PRESENT) {
        def v = new Verb()
        v.setWholeWord(word)
        v.setTense(tense)
        v.setRootEnding(null)
        v.setFinalSuffixHolder(new VerbFinalSuffixHolderObject())
        v.metaClass.getTenseValue = { '' }
        return v
    }

    // Correct suffix syllabary values from actual implementations:
    // gwu: Ꮚ | sgo: ᏍᎪᎢ | ju: Ꮷ | ke: Ꭸ | di: Ꮧ | dv: Ꮫ | esdi: ᎡᏍᏗ
    // a: Ꭰ | i: Ꭲ | dina: ᏗᎾ | na: Ꮎ | hv: Ꮂ | isi: ᎢᏏ | idi: ᎢᏗ
    // svi: ᏍᎢ | vi: ᎥᎢ | ei: ᎡᎢ | oi: ᎣᎢ

    def "gwu suffix appends Ꮚ"() {
        given:
        def verb = createTestVerb('ᎦᏬᏂᎭ')
        verb.finalSuffixHolder.gwu = true
        when: def result = FinalSuffixProcessor.process(verb)
        then: result == "ᎦᏬᏂᎭᏊ"
    }

    def "sgo suffix appends ᏍᎪᎢ"() {
        given:
        def verb = createTestVerb('ᎦᏬᏂᎭ')
        verb.finalSuffixHolder.sgo = true
        when: def result = FinalSuffixProcessor.process(verb)
        then: result == "ᎦᏬᏂᎭᏍᎪᎢ"
    }

    def "ju suffix appends Ꮷ"() {
        given:
        def verb = createTestVerb('ᎦᏬᏂᎭ')
        verb.finalSuffixHolder.ju = true
        when: def result = FinalSuffixProcessor.process(verb)
        then: result == "ᎦᏬᏂᎭᏧ"
    }

    def "ke suffix appends Ꭸ"() {
        given:
        def verb = createTestVerb('ᎦᏬᏂᎭ')
        verb.finalSuffixHolder.ke = true
        when: def result = FinalSuffixProcessor.process(verb)
        then: result == "ᎦᏬᏂᎭᎨ"  // NOT Ꭼ as previously assumed
    }

    def "di suffix appends Ꮧ"() {
        given:
        def verb = createTestVerb('ᎦᏬᏂᎭ')
        verb.finalSuffixHolder.di = true
        when: def result = FinalSuffixProcessor.process(verb)
        then: result == "ᎦᏬᏂᎭᏗ"
    }

    def "dv suffix appends Ꮫ"() {
        given:
        def verb = createTestVerb('ᎦᏬᏂᎭ')
        verb.finalSuffixHolder.dv = true
        when: def result = FinalSuffixProcessor.process(verb)
        then: result == "ᎦᏬᏂᎭᏛ"  // NOT Ꮠ as previously assumed
    }

    def "esdi suffix appends ᎡᏍᏗ"() {
        given:
        def verb = createTestVerb('ᎦᏬᏂᎭ')
        verb.finalSuffixHolder.esdi = true
        when: def result = FinalSuffixProcessor.process(verb)
        then: result == "ᎦᏬᏂᎭᎡᏍᏗ"  // NOT Ꮎ as previously assumed
    }

    def "a suffix appends Ꭰ"() {
        given:
        def verb = createTestVerb('ᎦᏬᏂᎭ')
        verb.finalSuffixHolder.a = true
        when: def result = FinalSuffixProcessor.process(verb)
        then: result == "ᎦᏬᏂᎭᎠ"
    }

    def "i suffix appends Ꭲ"() {
        given:
        def verb = createTestVerb('ᎦᏬᏂᎭ')
        verb.finalSuffixHolder.i = true
        when: def result = FinalSuffixProcessor.process(verb)
        then: result == "ᎦᏬᏂᎭᎢ"
    }

    def "dina suffix appends ᏗᎾ"() {
        given:
        def verb = createTestVerb('ᎦᏬᏂᎭ')
        verb.finalSuffixHolder.dina = true
        when: def result = FinalSuffixProcessor.process(verb)
        then: result == "ᎦᏬᏂᎭᏗᎾ"  // NOT ᏔᎵ as previously assumed
    }

    def "na suffix appends Ꮎ"() {
        given:
        def verb = createTestVerb('ᎦᏬᏂᎭ')
        verb.finalSuffixHolder.na = true
        when: def result = FinalSuffixProcessor.process(verb)
        then: result == "ᎦᏬᏂᎭᎾ"
    }

    def "hv suffix appends Ꮂ"() {
        given:
        def verb = createTestVerb('ᎦᏬᏂᎭ')
        verb.finalSuffixHolder.hv = true
        when: def result = FinalSuffixProcessor.process(verb)
        then: result == "ᎦᏬᏂᎭᎲ"  // NOT Ꮹ as previously assumed
    }

    def "isi suffix appends ᎢᏏ"() {
        given:
        def verb = createTestVerb('ᎦᏬᏂᎭ')
        verb.finalSuffixHolder.isi = true
        when: def result = FinalSuffixProcessor.process(verb)
        then: result == "ᎦᏬᏂᎭᎢᏏ"  // NOT Ꭿ as previously assumed
    }

    def "idi suffix appends ᎢᏗ"() {
        given:
        def verb = createTestVerb('ᎦᏬᏂᎭ')
        verb.finalSuffixHolder.idi = true
        when: def result = FinalSuffixProcessor.process(verb)
        then: result == "ᎦᏬᏂᎭᎢᏗ"
    }

    def "svi suffix appends ᏍᎢ"() {
        given:
        def verb = createTestVerb('ᎦᏬᏂᎭ')
        verb.finalSuffixHolder.svi = true
        when: def result = FinalSuffixProcessor.process(verb)
        then: result == "ᎦᏬᏂᎭᏍᎢ"
    }

    def "vi suffix appends ᎥᎢ"() {
        given:
        def verb = createTestVerb('ᎦᏬᏂᎭ')
        verb.finalSuffixHolder.vi = true
        when: def result = FinalSuffixProcessor.process(verb)
        then: result == "ᎦᏬᏂᎭᎥᎢ"
    }

    def "ei suffix appends ᎡᎢ"() {
        given:
        def verb = createTestVerb('ᎦᏬᏂᎭ')
        verb.finalSuffixHolder.ei = true
        when: def result = FinalSuffixProcessor.process(verb)
        then: result == "ᎦᏬᏂᎭᎡᎢ"
    }

    def "oi suffix appends ᎣᎢ"() {
        given:
        def verb = createTestVerb('ᎦᏬᏂᎭ')
        verb.finalSuffixHolder.oi = true
        when: def result = FinalSuffixProcessor.process(verb)
        then: result == "ᎦᏬᏂᎭᎣᎢ"
    }

    def "multiple suffixes stack correctly"() {
        given:
        def verb = createTestVerb('ᎦᏬᏂᎭ')
        verb.finalSuffixHolder.gwu = true
        verb.finalSuffixHolder.sgo = true
        verb.finalSuffixHolder.ke = true
        when: def result = FinalSuffixProcessor.process(verb)
        then: result == "ᎦᏬᏂᎭᏊᏍᎪᎢᎨ"  // ke is Ꭸ not Ꭼ
    }

    def "REMOTE_PAST + sgo drops trailing Ꭲ before appending sgo"() {
        given:
        def verb = createTestVerb('ᎦᏬᏂᏎᎢ', Tense.REMOTE_PAST)
        verb.finalSuffixHolder.sgo = true
        when: def result = FinalSuffixProcessor.process(verb)
        then: result == "ᎦᏬᏂᏎᏍᎪᎢ"
    }

    def "IMMEDIATE_PAST + ke drops trailing Ꭲ before appending ke"() {
        given:
        def verb = createTestVerb('ᎦᏬᏂᏒᎢ', Tense.IMMEDIATE_PAST)
        verb.finalSuffixHolder.ke = true
        when: def result = FinalSuffixProcessor.process(verb)
        then: result == "ᎦᏬᏂᏒᎨ"  // ke is Ꭸ not Ꭼ
    }

    /** Holder object property tests */
    def "holder object svi property defaults to false"() {
        given: def holder = new net.cherokeedictionary.verb.containers.VerbFinalSuffixHolderObject()
        when: def sviValue = holder.svi
        then: sviValue == false
    }

    def "holder object svi can be set to true"() {
        given: def holder = new net.cherokeedictionary.verb.containers.VerbFinalSuffixHolderObject(); holder.svi = true
        when: def sviValue = holder.svi
        then: sviValue == true
    }

    def "getTrueValue includes svi when set"() {
        given: def holder = new net.cherokeedictionary.verb.containers.VerbFinalSuffixHolderObject(); holder.svi = true
        when: def trueValue = holder.getTrueValue()
        then: trueValue == 'svi'
    }

    def "toString includes svi field"() {
        given: def holder = new net.cherokeedictionary.verb.containers.VerbFinalSuffixHolderObject(); holder.svi = true
        when: def str = holder.toString()
        then: str.contains("svi=true")
    }

    def "process returns input unchanged when no suffix flags set"() {
        given: def verb = createTestVerb('ᎦᏬᏂᎭ')
        when: def result = FinalSuffixProcessor.process(verb)
        then: result == "ᎦᏬᏂᎭ"
    }

    def "process handles missing stem gracefully"() {
        given: def verb = createTestVerb('MISSING_STEMᎦᏬᏂᎭ'); verb.finalSuffixHolder.gwu = true
        when: def result = FinalSuffixProcessor.process(verb)
        then: result != null
    }
}
