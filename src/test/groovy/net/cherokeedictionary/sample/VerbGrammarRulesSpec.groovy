package net.cherokeedictionary.sample

import net.cherokeedictionary.util.Tense
import spock.lang.Specification
import spock.lang.Unroll;

class VerbGrammarRulesSpec extends Specification {

    @Unroll
    def "De- prefix rule: preceding=#preceding, vowel=#isVowel, char=#vowelChar, pitch=#pitch, tense=#tense -> #expected"() {
        expect:
        VerbGrammarRules.applyDePrefixRules(preceding, isVowel, vowelChar, pitch, tense, false) == expected

        where:
        preceding | isVowel | vowelChar | pitch | tense              | expected
        "yi"      | false   | ""        | 1     | Tense.PRESENT      | "Ꮧ"
        "wi"      | true    | "Ꭰ"       | 3     | Tense.PRESENT      | "Ꮥ" // exception: pitch 3 vowel after y/w/n
        "none"    | true    | "Ꭲ"       | 1     | Tense.INFINITIVE   | "Ꮵ" // j- in infinitive before non-a vowel
        "none"    | true    | "Ꭰ"       | 1     | Tense.INFINITIVE   | "Ꮧ" // di- before a- in infinitive
        "none"    | false   | ""        | 1     | Tense.PRESENT      | "Ꮥ"
    }

    @Unroll
    def "Da- prefix rules: hInit=#hInit, vowelInit=#vowelInit, char=#vowelChar -> #expected"() {
        expect:
        VerbGrammarRules.applyDaPrefixRules(hInit, vowelInit, vowelChar) == expected

        where:
        hInit | vowelInit | vowelChar | expected
        true  | false     | ""        | "Ꮨ" // da- + h- -> t-
        false | true      | "Ꭰ"       | "Ꮫ" // da- + a- -> dv-
        false | true      | "Ꭲ"       | "Ꮧ" // da- + i- -> di-
        false | false     | ""        | "Ꮣ"
    }

    @Unroll
    def "I- prefix rule before ga: following=#following -> #expected"() {
        expect:
        VerbGrammarRules.applyIPrefixRules(following) == expected

        where:
        following | expected
        "ga"      | "Ꭵ"
        "ni"      | "Ꭲ"
    }
//
//    def "Integration test with VerbFactory and Tense"() {
//        setup:
//        def verb = VerbFactory.getVerb("v.t.", "he wants it", "ᎠᏓᏚᎵᎭ", "ᎤᏚᎵᎭ", "ᏓᎤᏚᎵᎭ", "ᎤᏚᎵᏍᏗ")
//
//        expect:
//        verb != null
//        verb.tense == null
//
//        when:
//        verb.tense = Tense.INFINITIVE
//
//        then:
//        verb.tense == Tense.INFINITIVE
//    }
}