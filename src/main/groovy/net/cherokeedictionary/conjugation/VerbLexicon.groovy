package net.cherokeedictionary.conjugation

import groovy.json.JsonSlurper
import net.cherokeedictionary.util.PrefixTableObject
import net.cherokeedictionary.util.PrefixTableSubject
import net.cherokeedictionary.util.Tense

class VerbLexicon {
    private static final Map lexicon = new JsonSlurper().parse(
        this.class.getResourceAsStream('/data/lexicon.json')
    )

    static Map<String, List> getLexicon() {
        return lexicon
    }

    static List<Map> findMatches(String syllabary) {
        List<Map> results = []
        lexicon.each { verbName, tenseMap ->
            tenseMap.each { tense, rows ->
                rows.each { row ->
                    if (row.syllabary == syllabary) {
                        results << [verb: verbName, tense: tense, pronoun: row.pronoun]
                    }
                }
            }
        }
        return results
    }

    // timo 12Nov26: accessor the cherokeeVerbConjugation specs use to pull the
    // ten verb-book rows for one verb/tense pair out of lexicon.json.
    static List<Map> getConjugations(String verbName, String tense) {
        def rows = lexicon.get(verbName)?.get(tense)
        return rows == null ? [] : rows
    }
}

