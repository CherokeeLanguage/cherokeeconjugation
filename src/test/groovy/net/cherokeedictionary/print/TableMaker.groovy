package net.cherokeedictionary.print

import net.cherokeedictionary.core.Verb
import net.cherokeedictionary.util.CompoundPrefix
import net.cherokeedictionary.util.ConjugationTableBuilder
import net.cherokeedictionary.util.PartOfSpeech
import net.cherokeedictionary.util.PrefixTableObject
import net.cherokeedictionary.util.PrefixTableSubject
import net.cherokeedictionary.util.Tense
import net.cherokeedictionary.verb.conjugation.Conjugate

class TableMaker {
    TableType tableType = TableType.MARKDOWN

    // verb currently being tabulated; cells conjugate (subject, object)
    // pairs directly against it, mirroring the gsp conjugate(subj, obj) calls - tio 19Nov26
    private Verb currentVerb

    private static final List<String> SUBJECT_CODES = [
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

    static void processLists() {
        PrefixTableSubject.values().each {
            SUBJECT_CODES << it.name()
        }

        PrefixTableObject.values().each {
            OBJECT_CODES << it.name()
        }
    }

    void generate(Verb verb) {
        def partOfSpeech = verb.partOfSpeech
        currentVerb = verb

        // Print document wrapper header if generating standalone HTML or LaTeX
        printDocumentHeader()

        def allTables = ConjugationTableBuilder.buildAllTenseTables { CompoundPrefix basePrefix, Tense tense ->
            verb.subject = basePrefix.prefix1
            verb.object = basePrefix.prefix2
            verb.tense = tense

            def conjugated = Conjugate.conjugate(verb)
            def compoundPrefix = conjugated.compoundPrefix
            return [
                    prefixCode: "${compoundPrefix.prefix1}${compoundPrefix.prefix2}",
                    verb      : conjugated.wholeWord
            ]
        }

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
                    break
            }
        }

        printDocumentFooter()
    }

    private void printDocumentHeader() {
        if (tableType == TableType.HTML) {
            println """<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<style>
  .paradigm-section { margin-bottom: 2em; page-break-inside: avoid; }
  .paradigm-grid {
    display: inline-grid;
    grid-template-columns: 2.2em auto;
    grid-template-rows: auto auto;
    align-items: center;
    gap: 0.35em 0.5em;
  }
  .object-label { grid-column: 2; grid-row: 1; text-align: center; font-weight: bold; }
  .subject-label { grid-column: 1; grid-row: 2; display: flex; align-items: center; justify-content: center; }
  .subject-label span { display: inline-block; transform: rotate(-90deg); white-space: nowrap; font-weight: bold; }
  .table-slot { grid-column: 2; grid-row: 2; }
  .table-slot table { border-collapse: collapse; }
  .table-slot th, .table-slot td { border: 1px solid #999; padding: 4px 6px; text-align: center; }
</style>
</head>
<body>"""
        } else if (tableType == TableType.LATEX) {
            println """% Requires: \\usepackage{graphicx,multirow,booktabs,geometry}
% \\geometry{landscape, margin=0.5in}"""
        }
    }

    private void printDocumentFooter() {
        if (tableType == TableType.HTML) {
            println "</body>\n</html>"
        }
    }

    // =========================================================================
    // LATEX OUTPUT
    // Col 1: Rotated SUBJECT (\multirow)
    // Col 2: Row subject label (blank in header so SG1 shifts right one column)
    // Cols 3..14: 12 OBJECT columns under \multicolumn{12}{c}{\textbf{OBJECT}}
    // =========================================================================
    void generateLatex(numberTables, Tense tense, PartOfSpeech partOfSpeech) {
        def sb = new StringBuilder()
        // Reserve enough vertical space so heading + table stay together,
        // and allow 2 heading+table blocks per landscape page
        sb << "\\Needspace{3.8in}\n"
        sb << "\\subsection*{${escapeLatex(tense.readableName)}}\n"
        sb << "\\nopagebreak\n"
        sb << "\\begin{center}\n"
        sb << "{\\small\n"
        sb << "\\setlength{\\tabcolsep}{3pt}\n"

        if (partOfSpeech == PartOfSpeech.VERB_TRANSITIVE) {
            // Caps width at \textwidth and height at 0.36\textheight so 2 fit per page
            sb << "\\adjustbox{max width=\\textwidth, max height=0.36\\textheight}{%\n"
            sb << "\\begin{tabular}{@{}c|l|${'c' * OBJECT_CODES.size()}@{}}\n"
            sb << "\\toprule\n"
            sb << " & & \\multicolumn{${OBJECT_CODES.size()}}{c}{\\textbf{OBJECT}} \\\\\n"
            sb << "\\cmidrule(lr){3-${OBJECT_CODES.size() + 2}}\n"
            sb << " & & " + OBJECT_CODES.collect { "\\textbf{${escapeLatex(it)}}" }.join(" & ") + " \\\\\n"
            sb << "\\midrule\n"

            int totalDataRows = SUBJECT_CODES.size()
            SUBJECT_CODES.eachWithIndex { String subj, int idx ->
                String subjectCol = (idx == 0)
                        ? "\\multirow{${totalDataRows}}{*}{\\rotatebox{90}{\\textbf{SUBJECT}}}"
                        : ""
                List<String> cells = OBJECT_CODES.collect { String obj ->
                    def form = conjugateFor(subj, obj)
                    form ? "\\cherokee{${escapeLatex(form)}}" : ""
                }
                sb << "${subjectCol} & \\textbf{${escapeLatex(subj)}} & ${cells.join(' & ')} \\\\\n"
            }
            sb << "\\bottomrule\n"
            sb << "\\end{tabular}%\n"
            sb << "}\n"
        } else {
            sb << "\\adjustbox{max width=\\textwidth, max height=0.36\\textheight}{%\n"
            sb << "\\begin{tabular}{@{}c|l|c@{}}\n"
            sb << "\\toprule\n"
            sb << " & \\textbf{Person} & \\textbf{Form} \\\\\n"
            sb << "\\midrule\n"
            int totalDataRows = SUBJECT_CODES.size()
            SUBJECT_CODES.eachWithIndex { String subj, int idx ->
                String subjectCol = (idx == 0)
                        ? "\\multirow{${totalDataRows}}{*}{\\rotatebox{90}{\\textbf{SUBJECT}}}"
                        : ""
                def form = conjugateFor(subj, null)
                String rendered = form ? "\\cherokee{${escapeLatex(form)}}" : ""
                sb << "${subjectCol} & \\textbf{${escapeLatex(subj)}} & ${rendered} \\\\\n"
            }
            sb << "\\bottomrule\n"
            sb << "\\end{tabular}%\n"
            sb << "}\n"
        }

        sb << "}\n"
        sb << "\\end{center}\n"
        sb << "\\vspace{0.25em}\n\n"
        println sb.toString()
    }

    // =========================================================================
    // HTML OUTPUT (Single-level table inside CSS Grid wrapper — no nested <table>)
    // =========================================================================
    void generateHTML(numberTables, Tense tense, PartOfSpeech partOfSpeech) {
        def sb = new StringBuilder()
        sb << "<div class=\"paradigm-section\">\n"
        sb << "  <h3>${escapeHtml(tense.readableName)}</h3>\n"
        sb << "  <div class=\"paradigm-grid\">\n"

        if (partOfSpeech == PartOfSpeech.VERB_TRANSITIVE) {
            sb << "    <div class=\"object-label\">OBJECT</div>\n"
            sb << "    <div class=\"subject-label\"><span>SUBJECT</span></div>\n"
            sb << "    <div class=\"table-slot\">\n"
            generateTransitiveHTML(numberTables, sb)
            sb << "    </div>\n"
        } else {
            sb << "    <div class=\"subject-label\"><span>SUBJECT</span></div>\n"
            sb << "    <div class=\"table-slot\">\n"
            generateIntransitiveHTML(numberTables, sb)
            sb << "    </div>\n"
        }

        sb << "  </div>\n"
        sb << "</div>\n"
        println sb.toString()
    }

    void generateIntransitiveHTML(numberTables, StringBuilder sb) {
        sb << "      <table>\n"
        SUBJECT_CODES.each { String subj ->
            def verbForm = conjugateFor(subj, null)
            sb << "        <tr><th>${escapeHtml(subj)}</th><td>${escapeHtml(verbForm)}</td></tr>\n"
        }
        sb << "      </table>\n"
    }

    void generateTransitiveHTML(numberTables, StringBuilder sb) {
        sb << "      <table>\n"
        // Top-left corner cell is blank so SG1 sits in column 2 (right of row headers)
        sb << "        <tr>\n          <th></th>\n"
        OBJECT_CODES.each { String obj ->
            sb << "          <th>${escapeHtml(obj)}</th>\n"
        }
        sb << "        </tr>\n"

        SUBJECT_CODES.each { String subj ->
            sb << "        <tr>\n          <th>${escapeHtml(subj)}</th>\n"
            OBJECT_CODES.each { String obj ->
                def verbForm = conjugateFor(subj, obj)
                sb << "          <td>${escapeHtml(verbForm)}</td>\n"
            }
            sb << "        </tr>\n"
        }
        sb << "      </table>\n"
    }

    // =========================================================================
    // MARKDOWN OUTPUT (Pandoc-compatible flat pipe table)
    // =========================================================================
    void generateMarkdown(numberTables, Tense tense, PartOfSpeech partOfSpeech) {
        def sb = new StringBuilder()
        sb << "### ${tense.readableName}\n\n"

        if (partOfSpeech == PartOfSpeech.VERB_TRANSITIVE) {
            sb << "**OBJECT →**\n\n"
            // Header row: corner cell "SUBJECT \\ OBJECT", followed by SG1..PL3IN
            def headers = ["SUBJECT \\ OBJECT"] + OBJECT_CODES
            sb << "| " + headers.join(" | ") + " |\n"
            sb << "| " + headers.collect { "---" }.join(" | ") + " |\n"

            SUBJECT_CODES.each { String subj ->
                def row = [subj] + OBJECT_CODES.collect { String obj ->
                    conjugateFor(subj, obj)
                }
                sb << "| " + row.join(" | ") + " |\n"
            }
        } else {
            sb << "| SUBJECT | Form |\n"
            sb << "| --- | --- |\n"
            SUBJECT_CODES.each { String subj ->
                sb << "| ${subj} | ${conjugateFor(subj, null)} |\n"
            }
        }

        sb << "\n"
        println sb.toString()
    }

    private String conjugateFor(String subjectCode, String objectCode) {
        def pos = currentVerb.partOfSpeech == PartOfSpeech.VERB_INTRANSITIVE ? "vi" : "vt"
        Verb cellVerb = Conjugate.createVerbToConjugate(subjectCode, objectCode ?: "",
                currentVerb.stemmer, currentVerb.tense.name(), pos, false)

        def conjugated = Conjugate.conjugate(cellVerb)
        def word = conjugated.wholeWord?.toString() ?: ""
        return (word.startsWith("MISSING_ENTRY") || word.startsWith("MISSING_STEM")) ? "" : word
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

    private String escapeLatex(String value) {
        if (!value) {
            return ""
        }
        return value
                .replace("\\", "\\textbackslash{}")
                .replace("&", "\\&")
                .replace("%", "\\%")
                .replace("\$", "\\\$")
                .replace("#", "\\#")
                .replace("_", "\\_")
    }
}