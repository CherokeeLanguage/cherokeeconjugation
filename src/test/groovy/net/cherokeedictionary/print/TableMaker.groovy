package net.cherokeedictionary.print

import net.cherokeedictionary.core.Verb
import net.cherokeedictionary.util.CompoundPrefix
import net.cherokeedictionary.util.ConjugationHelper
import net.cherokeedictionary.util.ConjugationTableBuilder
import net.cherokeedictionary.util.PartOfSpeech
import net.cherokeedictionary.util.PrefixTableObject
import net.cherokeedictionary.util.PrefixTableSubject
import net.cherokeedictionary.util.Tense
import net.cherokeedictionary.verb.conjugation.Conjugate

class TableMaker {
    TableType tableType = TableType.MARKDOWN

    // verb currently being tabulated; HTML cells conjugate (subject, object)
    // pairs directly against it, mirroring the gsp conjugate(subj, obj) calls - tio 19Nov26
    private Verb currentVerb

//    private static final List<String> SUBJECT_CODES = new ArrayList(PrefixTableSubject.values().size())
//    private static final List<String> OBJECT_CODES = new ArrayList(PrefixTableObject.values().size())

    private static final List<PrefixTableSubject> SUBJECT_CODES = [
    "SG1", "SG2", "SG3",
    "DL1INCL", "DL1EXCL",
    "PL1INCL", "PL1EXCL",
    "DL2", "PL2", "PL3"
    ]

    private static final List<String> OBJECT_CODES = [
            "SG1", "SG2", "SG3AN", "SG3IN",
            "DL1INCL", "DL1EXCL",
            "PL1INCL", "PL1EXCL",
            "DL2", "PL2", "PL3AN", "PL3IN"
    ]

//    static {
//        PrefixTableSubject.values().each {
//            SUBJECT_CODES << it.readableName
//        }
//
//        PrefixTableObject.values().each {
//            OBJECT_CODES << it.readableName
//        }
//    }


    static void processLists() {
        PrefixTableSubject.values().each {
            SUBJECT_CODES << it.name()//readableName
        }

        PrefixTableObject.values().each {
            OBJECT_CODES << it.name()//readableName
        }
    }

    void generate(Verb verb) {
//        processLists()
//        println SUBJECT_CODES.size()
//        println OBJECT_CODES.size()

        def partOfSpeech = verb.partOfSpeech
        currentVerb = verb
        // Generates tables for all 14 tenses in Tense.values()
        def allTables = ConjugationTableBuilder.buildAllTenseTables { CompoundPrefix basePrefix, Tense tense ->
            // Your engine resolves whether this verb + tense uses Set A or Set B
            // and returns the resolved prefix code (e.g., "SG1SG3INB") and conjugated verb
            verb.subject = basePrefix.prefix1
            verb.object = basePrefix.prefix2
            verb.tense = tense

            def conjugated = Conjugate.conjugate(verb)

            def compoundPrefix = conjugated.compoundPrefix
            return [
                prefixCode: "${compoundPrefix.prefix1}${compoundPrefix.prefix2}",
                verb      : conjugated.wholeWord // or conjugated object
            ]
        }

        // Printing out the results grouped by Tense -> Number (Singular, Dual, Plural)
        allTables.each { Tense tense, Map<String, List<ConjugationTableBuilder.ConjugationRow>> numberTables ->
            currentVerb.tense = tense
            switch (tableType) {
                case TableType.LATEX:
                    generateLatex(numberTables, tense, partOfSpeech)
                    break
                case TableType.MARKDOWN:
                    generateMarkdown(numberTables, tense, partOfSpeech)
                    break
                default:
                    generateHTML(numberTables, tense, partOfSpeech)
            }
        }
    }

    void generateLatex(numberTables, tense, partOfSpeech) {
        println "\\section{He Sees Him, Her, It -- ${tense.readableName}}"

        numberTables.each { String numberGroup, List<ConjugationTableBuilder.ConjugationRow> rows ->
            println "\\subsection{${numberGroup}}"
            println "\\centering"
            println "\\begin{tabular}{lll}"
            rows.each { println "${it.english} & ${it.compoundPrefixCode} & \\cherokee ${it.conjugatedVerb} \\\\" }
            println "\\end{tabular}"
        }
    }

    void generateHTML(numberTables, tense, partOfSpeech) {
        def sb = new StringBuilder()
        sb << "<h3>${tense.readableName}</h3>\n"
        sb << """<table>
    <tr>
        <td>
            <div style="transform: rotate(90deg); -webkit-transform: rotate(90deg); -moz-transform: rotate(90deg); -ms-transform: rotate(90deg); position:relative; top: 5px; text-align:center; display:inline-block; width:20px; margin: 0; padding: 0; border-spacing: 0;">SUBJECT</div>
        </td>
        <td>
"""

        switch (partOfSpeech) {
            case PartOfSpeech.VERB_INTRANSITIVE:
                generateIntransitiveHTML(numberTables, sb)
                break
            case PartOfSpeech.VERB_TRANSITIVE:
                generateTransitiveHTML(numberTables, sb)
                break
            default:
                generateIntransitiveHTML(numberTables, sb)
                break
        }

        sb << """        </td>
    </tr>
</table>
<br/>"""

        println sb.toString()
    }

    void generateMarkdown(numberTables, tense, partOfSpeech) {

    }

    // tio 19Nov26: conjugates (subject, object) directly against currentVerb,
    // mirroring the gsp conjugate(subj, obj) calls. The old route searched
    // ConjugationTableBuilder rows by string-matching compoundPrefixCode, but
    // the mapper's curated lists omit same-person/reflexive and 1st->1st
    // combos, so those cells came back blank in the generated HTML.
    private String conjugateFor(String subjectCode, String objectCode) {
        // same routing as the gsp conjugate closure: VerbFactory builds a FRESH
        // verb per cell (engine state like initialPrefixHolder.da leaks across
        // conjugations of a reused Verb and corrupts the prefixes), blank
        // object -> NONE -> SG3IN coercion via determineSubjectObject, and
        // MISSING_ENTRY/MISSING_STEM sentinels render as blank cells - tio 19Nov26
        def pos = currentVerb.partOfSpeech == PartOfSpeech.VERB_INTRANSITIVE ? "vi" : "vt"
        Verb cellVerb = Conjugate.createVerbToConjugate(subjectCode, objectCode ?: "",
                currentVerb.stemmer, currentVerb.tense.name(), pos, false)

        def conjugated = Conjugate.conjugate(cellVerb)
        def word = conjugated.wholeWord?.toString() ?: ""
        return (word.startsWith("MISSING_ENTRY") || word.startsWith("MISSING_STEM")) ? "" : word
    }

    void generateIntransitiveHTML(numberTables, sb) {
        sb << "<table>\n"

        SUBJECT_CODES.each { String subj ->
            def verbForm = conjugateFor(subj, null)
            sb << """    <tr>
        <td>${subj}</td>
        <td>${escapeHtml(verbForm)}</td>
    </tr>
"""
        }

        sb << "</table>\n"
    }

    void generateTransitiveHTML(numberTables, sb) {
        sb << "<div style=\"text-align:center;\">OBJECT</div>\n"
        sb << "<table>\n"
        sb << "    <tr>\n        <td></td>\n"

        OBJECT_CODES.each { String obj ->
//            sb << "        <td>${PrefixTableObject."${obj}".readableName}</td>\n"
            sb << "        <td>${obj}</td>\n"
        }

        sb << "    </tr>\n"

        SUBJECT_CODES.each { String subj ->

//            sb << "    <tr>\n        <td>${PrefixTableSubject."${subj}".readableName}</td>\n"
            sb << "    <tr>\n        <td>${subj}</td>\n"

            OBJECT_CODES.each { String obj ->
                def verbForm = conjugateFor(subj, obj)
                sb << "        <td>${escapeHtml(verbForm)}</td>\n"
            }

            sb << "    </tr>\n"
        }

        sb << "</table>\n"
    }

    private String escapeHtml(String value) {
        if (!value) {
            return ""
        }

        return value
                .replace("&", "&amp;")
                .replace("<", "&lt;")
                .replace(">", "&gt;")
    }
}