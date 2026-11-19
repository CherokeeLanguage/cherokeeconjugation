package net.cherokeedictionary.deconstruct

import groovy.json.JsonSlurper
import net.cherokeedictionary.conjugation.Deconstructor
import net.cherokeedictionary.conjugation.VerbConjugationFacade
import net.cherokeedictionary.conjugation.ConjugationRequest

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

Deconstructor.deconstruct("ᎠᎪᏩᏘᎭ").eachWithIndex { d, i ->
    sw << "--- analysis ${i + 1} ---\n"
    sw << d.toString() << "\n\n"
}

new File('result.txt').setText(sw.toString(), 'UTF-8')
println "written ${sw.toString().size()} chars to result.txt"