package net.cherokeedictionary.king

class KingFactory {
    static King mapToKing(def row) {
        def king = new King()
        king.id = row[0]
        king.version = row[1].trim()
        king.imperative = row[2].trim()
        king.thirdPresSing = row[3].trim()
        king.nounRoot = row[4].trim()
        king.firstPresSing = row[5].trim()
        king.prepronomPrefix = row[6].trim()
        king.imperf = row[7].trim()
        king.notes = row[8].trim()
        king.definition = row[9].trim()
        king.infintive = row[10].trim()
        king.useCase = row[11].trim()
        king.present = row[12].trim()
        king.perfective = row[13].trim()

        return king
    }
}