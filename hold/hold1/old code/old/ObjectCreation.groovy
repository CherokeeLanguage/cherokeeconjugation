package cherokee.dictionary.verb.conjugation.old


/**
 * Created by torr on 8/20/2015.
 * this class took the PrefixTableObject (PTO) and PrefixTableSubject (PTS) and created some boilerplate javascript to deal with the html dropdowns
 */

enum PTO {
    SG1,
    SG2,
    SG3AN,
    SG3IN,
    DL1INCL,
    DL1EXCL,
    PL1INCL,
    PL1EXCL,
    DL2,
    PL2,
    PL3AN,
    PL3IN
}

enum PTS {
    SG1,
    SG2,
    SG3,
    DL1INCL,
    DL1EXCL,
    PL1INCL,
    PL1EXCL,
    DL2,
    PL2,
    PL3
}

PTS.values().each {
    StringBuilder sb = new StringBuilder();
    sb << " else if (this.value == \"${it}\") {\n" +
            "\t\$('#object').empty();\n" +
            "\tresetObject();\n"
            PTO.values().each {
                sb << "\t\$('#object option[value=\"${it}\"]').remove();\n"
            }
            sb << "}"
    println sb
}