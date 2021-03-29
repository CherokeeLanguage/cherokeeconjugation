package cherokee.conjugation.stemming

import Tense

class StemEntry {
    String syllabary = ""
    Tense stemtype = Tense.OTHER

    StemEntry(String syllabary, Tense stemType) {
        this.syllabary = syllabary
        this.stemtype = stemType
    }

    StemEntry(StemEntry entry) {
        this.syllabary = entry.syllabary
        this.stemtype = entry.stemtype
    }

}