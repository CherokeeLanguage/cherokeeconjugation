package net.cherokeedictionary.conjugation

def list = []

new File(".").eachFileRecurse { file ->
    if (file.name.endsWith('.groovy') && file.name != 'GetAllTenses.groovy') {
        file.eachLine { line ->
            if (line.contains('tenses: [')) {
                list << line.substring(line.indexOf("tenses:") + "tenses: [".size()).replaceAll(/]],/, "").replaceAll("\"", "")
//                println "${file.path}: ${line.substring(line.indexOf("tenses:") + "tenses: [".size())}"
            }
        }
    }
}

Set<String> newSet = new HashSet<String>()

list.each {
    if (it.contains(",")) {
        def spl = it.split(",")
        spl.each {
            newSet.add(it.trim())
        }
    } else {
        newSet.add(it.trim())
    }
}

newSet.each {
    println it
}


