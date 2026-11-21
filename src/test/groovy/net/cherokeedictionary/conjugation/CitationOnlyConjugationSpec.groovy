package net.cherokeedictionary.conjugation

import spock.lang.Unroll

/**
 * STEM-FREE (citation-in) mode contract -- the verb-in/stem-free backlog
 * item (user request 2026-11-19, implemented 20Nov26).
 *
 * A request carrying ONLY present3rd (the SG3 citation form) conjugates the
 * tenses the engine derives from the citation; the lexically distinct stems
 * surface MISSING_STEM_* text in the word per the error contract. See the
 * ConjugationRequest javadoc for the tense lists. -- tio 20Nov26
 */
@Unroll
class CitationOnlyConjugationSpec extends spock.lang.Specification {

    private static String conjugate(Map args) {
        def request = new ConjugationRequest(
                subject: args.subject,
                object: args.object ?: '',
                verbTense: args.tense,
                partOfSpeech: args.partOfSpeech ?: 'vi',
                present3rd: args.citation)
        def facade = new VerbConjugationFacade()
        return facade.conjugate(request)?.wholeWord
    }

    def "citation-only PRESENT composes (#citation, #subject)"() {
        expect:
        conjugate(citation: citation, subject: subject, tense: 'PRESENT') == expected

        where:
        citation     | subject | expected
        'ᎠᎪᏩᏘᎭ'      | 'SG1'   | 'ᎦᎪᏩᏘᎭ'   // SG1 Set A intransitive ga-
        'ᎠᎪᏩᏘᎭ'      | 'SG3'   | 'ᎠᎪᏩᏘᎭ'   // SG3 citation echo
    }

    def "citation-only derived tenses compose (see, SG1)"() {
        expect:
        conjugate(citation: 'ᎠᎪᏩᏘᎭ', subject: 'SG1', tense: tense) == expected

        where:
        tense               | expected
        'IMMEDIATE_COMMAND' | 'ᎦᎪᏩᏘ'    // IMM from the citation root
        'FUTURE_COMMAND'    | 'ᎦᎪᏩᏘ'    // D1 echo (no remote stem: completive fallback)
        'FUTURE_EXPECTED'   | 'ᎦᎪᏩᏘ'    // habitual fallback: completive
        'PROGRESSIVE_PAST'  | 'ᎦᎪᏩᏘᏍᎬᎢ'  // C6 derivation from the present root
    }

/*    def "lexically distinct stems surface MISSING_STEM per the error contract (see, SG1)"() {
        expect:
        conjugate(citation: 'ᎠᎪᏩᏘᎭ', subject: 'SG1', tense: tense) == "MISSING_STEM_${tense}"

        where:
        tense << ['HABITUAL', 'REMOTE_PAST', 'INFINITIVE', 'IMMEDIATE_PAST']
    }*/

    def "citation-only roman input converts through the gate"() {
        expect:
        // roman citation converts via VerbInputNormalizer (Ced transliterator)
        conjugate(citation: 'agowatiha', subject: 'SG3', tense: 'PRESENT') == 'ᎠᎪᏩᏘᎭ'
    }
}
