package net.cherokeedictionary.king

class Tsalagi {
    String entrya = ""
    String syllabaryb = ""
    String partofspeechc = ""
    String definitiond = ""
    String nounadjplurale = ""
    String nounadjpluralsyllf = ""
    String vfirstpresg = ""
    String vfirstpresh = ""
    String vthirdpasti = ""
    String vthirdpastsyllj = ""
    String vthirdpresk = ""
    String vthirdpressylll = ""
    String vsecondimperm = ""
    String vsecondimpersylln = ""
    String vthirdinfo = ""
    String vthirdinfsyllp = ""
    String sentenceq = ""
    String sentencesyllr = ""
    String sentenceenglishs = ""
    String crossreferencet = ""

    String nounadjpluraltranslit = ""
    String entrytranslit = ""
    String vfirstprestranslit = ""
    String vthirdpasttranslit = ""
    String vthirdprestranslit = ""
    String vsecondimpertranslit = ""
    String vthirdinftranslit = ""
    String sentencetranslit = ""

    String entrytone = ""
    String nounadjpluraltone = ""
    String vfirstprestone = ""
    String vthirdpasttone = ""
    String vthirdprestone = ""
    String vsecondimpertone = ""
    String vthirdinftone = ""

    String source = ""
    String definitionlarge = ""
    String etymology = ""
    String notes = ""
    String category = ""
}

def convert = {toConvert ->
    toConvert = toConvert
            .replaceAll("\\?", "")
            .replaceAll("\\.", "")
            .replaceAll("/", "")
            .replaceAll("0", "")
            .replaceAll("hs", "s")
            .replaceAll("kw", "gw")
            .replaceAll("uh", "u")
            .replaceAll("kh", "k")
            .replaceAll("to", "do")
            .replaceAll("th", "t")
            .replaceAll("hna", "na")
            .replaceAll("-", "")
            .replaceAll("ke", "ge")
            .replaceAll("ki", "gi")
            .replaceAll("ko", "go")
            .replaceAll("ku", "gu")
            .replaceAll("kv", "gv")
            .replaceAll("hl", "l")
            .replaceAll("tiha", "diha")
            .replaceAll("ehl", "el")
            .replaceAll("sk", "sg")

//                    .replaceAll("ka", "ga")

//                    .replaceAll("k", "g")
//                    .replaceAll("kh", "k")
//                    .replaceAll("t", "d")
//                    .replaceAll("th", "t")
//                    .replaceAll("hs", "s")
//                    .replaceAll("hl", "l")
//                    .replaceAll("dh", "t")
//                    .replaceAll("wuo", "woo")
//                    .replaceAll("ws", "was")
//                    .replaceAll("hn", "n")
//                    .replaceAll("hm", "m")
//                    .replaceAll("hd", "d")
//                    .replaceAll("ht", "t")
//                    .replaceAll("nh", "nv")
//                    .replaceAll("ua", "u")
//                    .replaceAll("dt", "dit")
//                    .replaceAll("dita", "diha")
//                    .replaceAll("kt", "gat")
//                    .replaceAll("aat", "at")
//                    .replaceAll("aad", "ad")
//                    .replaceAll("hy", "y")
//                    .replaceAll("ds", "ts")
//                    .replaceAll("gt", "gat")
//                    .replaceAll("hgh", "g")
//                    .replaceAll("gaa", "ga")
//                    .replaceAll("lha", "hla")

//                .replaceAll("ls", "lis")
//                .replaceAll("ls", "las")

    if (toConvert.startsWith("ua")) {
        toConvert = "a" + toConvert.substring(2)
    }

    if (toConvert.endsWith("ka")) {
        toConvert = toConvert.substring(0, toConvert.length() - 2) + "ga"
    }

    if (toConvert.endsWith("ti")) {
        toConvert = toConvert.substring(0, toConvert.length() - 2) + "di"
    }

    //SyllabaryUtil.replace(toConvert, true)
    return toConvert
}


def replaceAsterisk = {king, entry, tmpOutput ->
    if (king."$entry".contains("*")) {
        tmpOutput << king.nounRoot.substring(0, king.nounRoot.size() - 1)
        tmpOutput << king."$entry".substring(1)
    } else {
        tmpOutput << king.nounRoot
        tmpOutput << king."$entry"
    }
}

//select * from king where present like '%*%' or imperf like '%*%' or perfective like '%*%' or imperative like '%*%' or infintive like '%*%';
def kingMain = { king ->
    def tmpOutput = new StringBuilder()
    tmpOutput << king.thirdPresSing

    replaceAsterisk(king, "present", tmpOutput)

    tmpOutput << "a"
    tmpOutput = convert(tmpOutput.toString())
    return tmpOutput
}

def kingFirstPresSing = { king ->
    def tmpOutput = new StringBuilder()
    tmpOutput << king.firstPresSing

    replaceAsterisk(king, "present", tmpOutput)

    tmpOutput << "a"
    tmpOutput = convert(tmpOutput.toString())
    return tmpOutput
}

def kingPerfective = { king ->
    def tmpOutput = new StringBuilder()
    tmpOutput << king.thirdPresSing

    replaceAsterisk(king, "perfective", tmpOutput)

    tmpOutput << "vi"
    tmpOutput = convert(tmpOutput.toString())
    return tmpOutput
}

def kingImperative = { king ->
    def tmpOutput = new StringBuilder()
    tmpOutput << king.thirdPresSing

    replaceAsterisk(king, "imperative", tmpOutput)

    //tmpOutput << "a"
    tmpOutput = convert(tmpOutput.toString())
    return tmpOutput
}

def kingInfinitive = { king ->
    def tmpOutput = new StringBuilder()
    tmpOutput << king.thirdPresSing

    replaceAsterisk(king, "infintive", tmpOutput)

    tmpOutput << "i"
    tmpOutput = convert(tmpOutput.toString())
    return tmpOutput
}

def kingImperf = { king ->
    def tmpOutput = new StringBuilder()
    tmpOutput << king.thirdPresSing

    replaceAsterisk(king, "imperf", tmpOutput)

    tmpOutput << "oi"
    tmpOutput = convert(tmpOutput.toString())
    return tmpOutput
}


def str = """# id, version, imperative, third_pres_sing, noun_root, first_pres_sing, prepronom_prefix, imperf, notes, definition, infintive, use_case, present, perfective
96\t1\t?ka\t0\tahlini/.kwanv?v\tk\tte\thsk\t\tkneeling\t*t\tvbst\thsk\t*n
"""

def tmp = str.readLines()[1]

def king = KingFactory.mapToKing(tmp.split("\t"))


//select * from king where present like '%*%' or imperf like '%*%' or perfective like '%*%' or imperative like '%*%' or infintive like '%*%';

def tmpOutput = kingPerfective(king)

println tmpOutput

def tsalagi = new Tsalagi()

println "| Row Label / Field | Column 1 | Column 2 | Column 3 |"
println "| :--- | :--- | :--- | :--- |"
println "| **King** | ${tmpOutput} | | |"
println "| **root** | ${king.nounRoot} | | |"
println "| **normalized root** | ${convert(king.nounRoot)} | ${convert(king.nounRoot)} | |"
println "| **useCase** | ${king.useCase} | | ${tsalagi.partofspeechc} |"
println "| **definition** | ${king.definition} | | ${tsalagi.definitiond} |"
println "| **present** | ${king.present} | ${kingMain(king)} | ${tsalagi.vfirstpresg} |"
println "| **past** | ${king.perfective} | ${kingPerfective(king)} | ${tsalagi.vthirdpasti} |"
println "| **imperative** | ${king.imperative} | ${kingImperative(king)} | ${tsalagi.vsecondimperm} |"
println "| **infintive** | ${king.infintive} | ${kingInfinitive(king)} | ${tsalagi.vthirdinfo} |"
println "| **firstPresSing** | | ${kingFirstPresSing(king)} | ${tsalagi.vfirstpresg} |"
println "| **thirdPresSing** | | ${kingMain(king)} | ${tsalagi.entrya} |"
println "| **imperf** | ${king.imperf} | ${kingImperf(king)} | ${tsalagi.vthirdpresk} |"
