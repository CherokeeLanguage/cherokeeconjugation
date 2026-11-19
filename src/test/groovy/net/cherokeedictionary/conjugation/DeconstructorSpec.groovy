package net.cherokeedictionary.conjugation

import spock.lang.Specification

/**
 * Deconstruct backlog item (planned 2026-11-19): outside-in interlinear
 * breakdown of a conjugated verb surface form. Contract rulings:
 * return ALL analyses (ambiguity kept), POJO + interlinear toString,
 * no exceptions, never empty (UNPARSED annotation instead).
 * -- tio 19Nov26
 */
class DeconstructorSpec extends Specification {

    // ᎠᎪᏩᏘᎭ -- "he sees it" (SG3 present, agowtiha; Feeling Dictionary)
    def "glyph surface form yields parsed analyses with affix layers"() {
        when:
        def analyses = Deconstructor.deconstruct('ᎠᎪᏩᏘᎭ')

        then:
        !analyses.isEmpty()
        analyses.every { it instanceof Deconstruction }
        def pronominalHits = analyses.collectMany { it.affixes }.findAll { it.layer == 'PRONOMINAL_PREFIX' }
        !pronominalHits.isEmpty()
        // stem hypothesis present somewhere (the middle remainder)
        analyses.any { it.stemHypothesis }
        // interlinear rendering works
        analyses.every { it.toString() instanceof String }
    }

    // Same verb in roman (the agowtiha book-romanization form)
    def "roman input converts through the input gate"() {
        when:
        def analyses = Deconstructor.deconstruct('agowtiha')

        then:
        !analyses.isEmpty()
        analyses.any { it.parsed }
    }

    // Ꮵ- is the classic ambiguous head: SG1SG3AN (Ꮵ) plus ji/de fused forms
    def "j- surface produces multiple pronominal readings (ambiguity kept)"() {
        when:
        def analyses = Deconstructor.deconstruct('ᏥᎪᏩᏘᎭ')

        then:
        def hits = analyses.collectMany { it.affixes }
                .findAll { it.layer == 'PRONOMINAL_PREFIX' && it.surface == 'Ꮵ' }
        !hits.isEmpty()
        hits.any { it.meanings.size() > 1 }
        // at least one reading is the plain-English SG1SG3AN row
        hits.any { it.meanings.any { m -> m.contains('I -> Him/her') } }
    }

    def "initial prefix peel annotates de- pluralizer readings"() {
        when:
        // Ꮧ- head: de- pluralizer and di- instrumental candidates
        def analyses = Deconstructor.deconstruct('ᏗᎪᏩᏘᎭ')

        then:
        def initialHits = analyses.collectMany { it.affixes }
                .findAll { it.layer == 'INITIAL_PREFIX' && it.surface == 'Ꮧ' }
        !initialHits.isEmpty()
        initialHits.any { it.meanings.any { m -> m.contains('pluralizer') } }
        initialHits.any { it.meanings.any { m -> m.contains('instrumental') } }
    }

    def "final tail candidate is annotated on a vowel-tailed form"() {
        when:
        // Ꭲ tail is the past-family tense tail (also i- initial prefix --
        // both readings must survive as separate analyses)
        def analyses = Deconstructor.deconstruct('ᏥᎪᏩᏘᎭᎢ')

        then:
        def finalHits = analyses.collectMany { it.affixes }.findAll { it.layer == 'FINAL_SUFFIX' }
        !finalHits.isEmpty()
        finalHits.any { it.meanings.any { m -> m.contains('tense tail') } }
    }

    def "no exceptions and UNPARSED annotation on garbage input"() {
        when:
        def analyses = Deconstructor.deconstruct('zzzqqq')

        then:
        analyses.size() == 1
        !analyses[0].parsed
        analyses[0].affixes[0].layer == 'UNPARSED'
        analyses[0].toString().contains('UNPARSED')
    }

    def "null and empty input never throw and never return empty"() {
        expect:
        Deconstructor.deconstruct(null).size() == 1
        Deconstructor.deconstruct('').size() == 1
        Deconstructor.deconstruct('   ').size() == 1
    }

    def "facade analyze(String) convenience overload returns deconstructions"() {
        when:
        def context = new VerbConjugationFacade(isDebug: false).analyze('ᎠᎪᏩᏘᎭ')

        then:
        context != null
        !context.deconstructions.isEmpty()
        context.deconstructions.any { it.parsed }
        !context.auditTrail.isEmpty()
    }

    def "facade analyze(ConjugationRequest) with form field routes to deconstructor"() {
        when:
        def request = new ConjugationRequest(form: 'ᏥᎪᏩᏘᎭ')
        def context = new VerbConjugationFacade(isDebug: false).analyze(request)

        then:
        !context.deconstructions.isEmpty()
        context.deconstructions.any { d ->
            d.affixes.any { it.layer == 'PRONOMINAL_PREFIX' && it.surface == 'Ꮵ' }
        }
    }

    // User's HTML interlinear format (2026-11-19): nested
    // interlinear/orig/intlin/morph/trans divs, left-floated segments.
    // ᏥᎪᏩᏘᎭ = tsigowatiha: Ꮵ/tsi/SG1SG3AN reading + stem ᎪᏩᏘᎭ + -Ꭽ tail.
    def "toHtml renders the nested interlinear structure"() {
        when:
        def analyses = Deconstructor.deconstruct('ᏥᎪᏩᏘᎭ')
        def html = analyses.find { it.parsed }?.toHtml()

        then:
        html != null
        html.contains('<div class="interlinear">')
        html.contains('<div class="orig">ᏥᎪᏩᏘᎭ</div>')
        html.contains('<div class="morph">')
        html.contains('<div class="trans">')
        html.contains('style="float:left"')
        html.contains('Root')
        // roman reading of the full form
        html.contains('<div class="intlin">')
        html.contains('tsigowatiha')
    }

    // ᏫᏥᎪᏩᏘᎭ = witsigowatiha: initial wi- + pronominal Ꮵ (SG1SG3AN) + root
    // + h root ending + -a tail. Engine-consistent: wi- is composed by
    // PrefixProcessor, DL1INCL's compound prefix is ᎢᏂ, so ᏫᏥ is NOT a
    // pronominal unit. User-provided regression case (2026-11-19).
    def "witsigowatiha splits wi- initial, SG1SG3AN pronominal, root, ending, tail"() {
        when:
        def analyses = Deconstructor.deconstruct('ᏫᏥᎪᏩᏘᎭ')

        then:
        !analyses.isEmpty()
        def full = analyses.find { d ->
            d.parsed && d.rootEndingLatin == 'h' &&
                    d.affixes.any { it.layer == 'FINAL_SUFFIX' }
        }
        full != null
        full.affixes.find { it.layer == 'INITIAL_PREFIX' && it.surface == 'Ꮻ' && it.glosses == ['wi-'] } != null
        full.affixes.find { it.layer == 'PRONOMINAL_PREFIX' && it.surface == 'Ꮵ' && it.glosses.contains('SG1SG3AN') } != null
        // the aligned HTML shows all five cells
        def html = full.toHtml()
        html.contains('<div class="morph">wi</div>')
        html.contains('<div class="morph">tsi</div>')
        html.contains('<div class="morph">gowati</div>')
        html.contains('Root Ending')
        html.contains('<div class="morph">a</div>')
    }
}
