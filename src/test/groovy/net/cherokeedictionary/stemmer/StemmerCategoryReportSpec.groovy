package net.cherokeedictionary.stemmer

import net.cherokeedictionary.util.Tense
import spock.lang.Specification

/**
 * Pins the read-only category diagnostic on the stemmer (audit next action #1,
 * CATEGORY_AUDIT.md): deconstruction surfaces VerbRegistry classification
 * without touching any conjugation path. Roots below were captured from live
 * engine conjugations (see VerbRegistryInitializer.bridge). -- tio 12Nov26
 */
class StemmerCategoryReportSpec extends Specification {

    def "a classified verb reports its bridged name and categories"() {
        given: "To See: present3rd ᎠᎪᏩᏘᎭ, root gowati (engine-verified)"
        def stemmer = new Stemmer()
        stemmer.present3rd = new DefinitionLine(syllabary: "ᎠᎪᏩᏘᎭ")

        when:
        def report = stemmer.getCategoryReport(Tense.PRESENT)

        then:
        report.contains("root=gowati")
        report.contains("name='to see'")
        report.contains("categories=[NORMAL]")
        // the raw dictionary root carries the sg3 pronominal; the strip is visible
        report.contains("(via sg3-stripped 'agowati')")
    }

    def "an unbridged verb still reports, flagged as unclassified"() {
        given: "To Fish: present3rd ᎠᏑᎲᏍᎦ, engine root asuhvs (not bridged)"
        def stemmer = new Stemmer()
        stemmer.present3rd = new DefinitionLine(syllabary: "ᎠᏑᎲᏍᎦ")

        when:
        def report = stemmer.getCategoryReport(Tense.PRESENT)

        then:
        report.contains("root=asuhvs")
        report.contains("name=<unbridged>")
        report.contains("categories=[NORMAL]")
    }

    def "an empty stemmer degrades to <empty> instead of throwing"() {
        given: "no stems at all"
        def stemmer = new Stemmer()

        expect:
        stemmer.getCategoryReport(Tense.PRESENT) == "root=<empty> name=<unbridged> categories=[NORMAL]"
    }
}
