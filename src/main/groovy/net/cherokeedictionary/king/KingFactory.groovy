package net.cherokeedictionary.king

class KingFactory {
    static King mapToKing(def row) {
        def king = new King()
        king.id = row[0].trim()
        king.version = row[1].trim()
        king.nounRoot = row[2].trim()
        king.useCase = row[3].trim()
        king.present = row[4].trim()
        king.imperf = row[5].trim()
        king.perfective = row[6].trim()
        king.imperative = row[7].trim()
        king.infintive = row[8].trim()
        king.definition = row[9].trim()
        king.firstPresSing = row[10].trim()
        king.thirdPresSing = row[11].trim()
        king.prepronomPrefix = row[12].trim()
        king.notes = row[13].trim()

        return king
    }
}