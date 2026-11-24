package net.cherokeedictionary.deconstruct

import groovy.json.JsonSlurper
import net.cherokeedictionary.conjugation.Deconstructor
import net.cherokeedictionary.conjugation.VerbConjugationFacade
import net.cherokeedictionary.conjugation.ConjugationRequest
import net.cherokeedictionary.util.Tense
import net.cherokeedictionary.verb.containers.FinalSuffixProcessor
import net.cherokeedictionary.verb.containers.NonFinalSuffixProcessor

// tio 19Nov26: interactive deconstruct scratch runner (DELETE when done, ops
// rule 1). Usage:
//   java -Dfile.encoding=UTF-8 -cp "$(cat cp.txt)" groovy.ui.GroovyMain TryDeconstruct.groovy req.json
// req.json (UTF-8): {"form": "ᎠᎪᏩᏘᎭ"}  -- writes interlinear lines (UTF-8)
// to result.txt. Glyphs must go through the JSON file, never CLI args
// (Windows console mangles them).

def sw = new StringWriter()
/*def reqFile = "tson.json"//args[0]
InputStream file = TryDeconstruct.getResourceAsStream(reqFile)
def req = new JsonSlurper().parse(file, 'UTF-8')

if (req.containsKey('form')) {
    Deconstructor.deconstruct(req.form as String).eachWithIndex { d, i ->
        sw << "--- analysis ${i + 1} ---\n"
        sw << d.toString() << "\n\n"
    }
} else {
    def facade = new VerbConjugationFacade(isDebug: false)
    facade.analyze(req.form as String).deconstructions.eachWithIndex { d, i ->
        sw << "--- analysis ${i + 1} ---\n"
        sw << d.toString() << "\n\n"
    }
}*/

def facade = new VerbConjugationFacade()

def see = new ConjugationRequest(
        subject: "SG1",
        object: "NONE",
        verbTense: "PRESENT",
        partOfSpeech: "VT",
        present1st: "ᏥᎪᏩᏘᎭ",
        present3rd: "ᎠᎪᏩᏘᎭ",
        remotepast: "ᎤᎪᎲᎢ",
        habitual: "ᎠᎪᏩᏘᏍᎪᎢ",
        imperative: "ᎠᎪᏩᏙ",
        infinitive: "ᎤᎪᏩᏘᏍᏗ",
        reflexive: "true"
)
def vSee = facade.conjugate(see)
println vSee.wholeWord
assert vSee.wholeWord == "ᎦᏓᎪᏩᏘᎭ"

see.reflexive = false
vSee = facade.conjugate(see)
println vSee.wholeWord
assert vSee.wholeWord == "ᏥᎪᏩᏘᎭ"

see.wi = true

vSee = facade.conjugate(see)
println vSee.wholeWord
assert vSee.wholeWord == "ᏫᏥᎪᏩᏘᎭ"


Deconstructor.deconstruct(vSee.wholeWord).eachWithIndex { d, i ->
    sw << "--- analysis ${i + 1} ---\n"
    sw << d.toString() << "\n\n"
}

new File('result.txt').setText(sw.toString(), 'UTF-8')
println "written ${sw.toString().size()} chars to result.txt"