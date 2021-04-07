package net.cherokeedictionary.util

//println CompoundPrefixes.prefixes.get("PL1INCLSG3INB")

def parseNameSubjectObject = {
    def tmp = it.substring("static final def ".size(), it.indexOf(" ="))
    def subject = it.substring(it.indexOf("PrefixTableSubject.") + "PrefixTableSubject.".size(), it.indexOf(", object:"))
    def object = it.substring(it.indexOf("PrefixTableObject.") + "PrefixTableObject.".size(), it.indexOf(")"))
//    println subject
//    println object
    return [tmp, subject, object]
}

def str = new File("./stemmer.txt").readLines()
str.each {
    if ("" != it) {
        def nameSubjectObject = parseNameSubjectObject(it)

        def prefix = CompoundPrefixes.prefixes.get(nameSubjectObject[0])

        if (prefix) {
            prefix = prefix.toString()
            def tmp=  "${nameSubjectObject[0]} - ${nameSubjectObject[1]} - ${nameSubjectObject[2]} ${prefix}"
            def tmprefix = prefix.substring("prefixes.put(".size(), prefix.lastIndexOf(")"))
//            println tmprefix
            println "static final def ${nameSubjectObject[0]} = new CompoundPrefix(subject: PrefixTableSubject.${nameSubjectObject[1]}, object: PrefixTableObject.${nameSubjectObject[2]}, prefix:${tmprefix})"
        } else {
            println prefix
            println "${nameSubjectObject[0]} - ${nameSubjectObject[1]} - ${nameSubjectObject[2]}"
        }
    }
}

