// one-off (ops rule 1): Phase-1 attestation matrix runner.
// Enumerates all wired vrb verbs via their compiled spec classes' static
// `details`, composes the subject x object x tense grid through the same
// harness the tests use (VerbBaseSpec.conjugateVerb), and matches each
// composed form against AttestationRegistry. Emits:
//   build/tmp/scratch/attestation-report.tsv  (one row per cell)
//   build/tmp/scratch/attestation-summary.txt (stats by tense/subject/source)
import net.cherokeedictionary.conjugation.attestation.AttestationRegistry
import net.cherokeedictionary.conjugation.VerbBaseSpec

def SPEC_DIR = "src/test/groovy/net/cherokeedictionary/conjugation/vrb"
def TENSES = ["PRESENT", "HABITUAL", "REMOTE_PAST", "IMMEDIATE_COMMAND",
              "FUTURE_COMMAND", "INFINITIVE", "COMPLETIVE_FUTURE", "COMPLETED_FUTURE",
              "PROGRESSIVE_PAST", "PROGRESSIVE_FUTURE", "IMMEDIATE_PAST",
              "FUTURE_EXPECTED", "RECENT_PAST_IMPERATIVE", "FUTURE_IMPERATIVE_VOLATIVE"]
def SUBJECTS = ["SG1", "SG2", "SG3", "PL3", "PL1INCL"]
def OBJECTS = ["", "SG3AN", "SG3IN"]

// discover spec class names from the source tree (same convention as the meta-specs)
def specNames = []
new File(SPEC_DIR).listFiles().findAll { it.name.endsWith("Spec.groovy") }.each { f ->
    def m = f.getText("UTF-8") =~ /class\s+(\w+)\s+extends\s+VerbBaseSpec/
    if (m.find()) { specNames << m.group(1) }
}
println "wired verbs discovered: ${specNames.size()}"

def report = new StringBuilder()
def summary = [:]
long total = 0, attested = 0, ntMatch = 0, corpusMatch = 0, composed = 0

report.append("verb\tsubject\tobject\ttense\tcomposed\tattested\tsources\tcitations\n")

specNames.sort().each { name ->
    Class specClass
    try {
        specClass = Class.forName("net.cherokeedictionary.conjugation.vrb.${name}", true,
                new GroovyClassLoader(getClass().classLoader))
    } catch (Throwable t) { return }
    def details
    try {
        def fDet = specClass.getDeclaredField("details"); fDet.accessible = true
        details = fDet.get(null)
    } catch (Throwable t) { return }
    if (details == null) { return }

    SUBJECTS.each { subj ->
        OBJECTS.each { obj ->
            TENSES.each { tense ->
                total++
                String word = null
                try {
                    def r = VerbBaseSpec.conjugateVerb(name, details, subj, obj, tense, "")
                    word = r
                } catch (Throwable t) {
                    word = "ERROR:${t.class.simpleName}"
                }
                boolean anyAttested = false
                String cites = ""
                if (word != null && word.contains("MISSING") == false && word.contains("not a valid letter") == false) {
                    composed++
                    def cits = AttestationRegistry.citations(word)
                    if (cits != null) {
                        anyAttested = true
                        attested++
                        if (cits.containsKey('NT')) ntMatch++
                        if (cits.containsKey('CORPUS')) corpusMatch++
                        cites = cits.collect { k, v -> "${k}:${v.join('/')}" }.join(' | ')
                    }
                }
                def k = "tense=${tense}"
                summary[k] = summary[k] == null ? [0, 0] : summary[k]
                summary[k][0]++
                if (anyAttested) { summary[k][1]++ }
                report.append([name, subj, obj ?: '-', tense,
                               word ?: 'NULL', anyAttested ? 'Y' : 'N',
                               anyAttested ? (AttestationRegistry.citations(word)?.keySet()?.join('+') ?: '') : '',
                               cites].join('\t')).append('\n')
            }
        }
    }
}

new File("build/tmp/scratch/attestation-report.tsv").setText(report.toString(), "UTF-8")

def out = new StringBuilder()
out.append("=== Phase-1 attestation matrix report (tio 20Nov26)\n")
out.append("wired verbs: ${specNames.size()}\n")
out.append("total cells: ${total}\n")
out.append("composed (non-sentinel): ${composed}\n")
out.append("attested (exact match in NT or CORPUS): ${attested}\n")
out.append("  matched in NT: ${ntMatch}\n")
out.append("  matched in CORPUS: ${corpusMatch}\n")
out.append("  matched in both sources: ${attested - (ntMatch + corpusMatch - (total - total))}\n")
out.append("\nby tense (attested/composed):\n")
summary.sort { it.key }.each { k, v ->
    out.append(String.format("  %-28s %6d / %6d  (%.1f%%)%n", k, v[1], v[0], v[0] ? 100.0 * v[1] / v[0] : 0))
}
new File("build/tmp/scratch/attestation-summary.txt").setText(out.toString(), "UTF-8")
println out.toString()
