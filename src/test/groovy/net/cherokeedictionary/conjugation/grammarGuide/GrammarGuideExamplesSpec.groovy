package net.cherokeedictionary.conjugation.grammarGuide;

import spock.lang.Specification;
import spock.lang.Unroll;

/**
 * Spock Specs for verb conjugation examples, paradigms, and sentences pulled from the Cherokee grammar guide (hold1.html and hold2.html).
 * These will be used to test the affixes given in the grammar guide when we're ready to test those.
 */
@Unroll
class GrammarGuideExamplesSpec extends Specification {

    def "Section I-A: y-, negative, conditional examples"() {
        expect:
        cherokee == expectedCherokee
        english == expectedEnglish

        where:
        number | cherokee              | romanization             | english
        "1a"   | "ᎠᎪᏩᏘᎭ"             | "a¹gowh²tị³ha"            | "He sees it."
        "1b"   | "Ꮭ ᏯᎪᏩᏘᎭ"           | "hla³ yạ²gowh³tị²ha"      | "He doesn't see it."
        "2a"   | "ᏥᎪᏩᏘᎭ"             | "jị²gowh¹ti³ha"          | "I see it."
        "2b"   | "Ꮭ ᏱᏥᎪᏩᏘᎭ"         | "hla³ yị²jị²gowh³²tị³ha"  | "I don't see it."
        "3a"   | "ᏩᎪᏩᏘᎭ"             | "wạ²gowh³tị²ha"          | "He sees it (with his back turned)."
        "3b"   | "Ꮭ ᏳᏩᎪᏩᏘᎭ"         | "hla³ yụ²wạ²gowh³tị²ha"   | "He doesn't see it (with his back turned)."
        "4a"   | "ᎯᎪᏩᏘᎭ"             | "hị²gowh²tị³ha"          | "You see it."
        "4b"   | "Ꮭ ᏱᎪᏩᏘᎭ"           | "hla³ hyị²gowh³tị²ha"     | "You don't see it."
        "5a"   | "ᎦᏬᏂᎭ"               | "gạ²wo³nị²ha"            | "He is speaking."
        "5b"   | "ᏱᎦᏬᏂᎭ"             | "yị²gạ²wo³²ni⁴ha"        | "if he is speaking"
        "6"    | "ᏱᎦᏬᏂᎭ, Ꮭ ᏯᏆᏅᏔ"   | "yị²gạ²wo³²ni⁴ha, hla³ yạ²gwanh³ta" | "If he is speaking, I don't know it."
        "7"    | "ᏳᏬᏂᏌ"             | "yu²wo³²ni⁴sa"           | "if he spoke"
    }

    def "Section I-A: j-, relative examples"() {
        expect:
        cherokee == expectedCherokee
        english == expectedEnglish

        where:
        number | cherokee              | romanization             | english
        "8a"   | "ᎠᏍᎦᏯ ᎤᏬᏝ"         | "ạ²sgạ²ya u¹wo²³hla"      | "A man is sitting."
        "8b"   | "ᎠᏍᎦᏯ ᏧᏬᏝ"         | "ạ²sgạ²ya ju¹wo⁴hla"      | "the man who is sitting"
        "9a"   | "ᎠᏍᎦᎠᏯ ᎦᏬᏂᎭ"       | "ạ²sgạ²ya gạ²wo³nị²ha"     | "A man is speaking."
        "9b"   | "ᎠᏍᎦᎠᏯ ᏥᎦᏬᏂᎭ"     | "ạ²sgạ²ya jị²gạ²wo³ni⁴ha"  | "the man who is speaking"
        "10a"  | "ᎠᏍᎦᏯ ᎦᏬᏂᎭ"         | "ạ²sgạ²ya gạ²wo³nị²ha"     | "A man is speaking."
        "10b"  | "ᎠᏍᎦᏯ ᏥᎦᏬᏂᎭ"       | "ạ²sgạ²ya jị²gạ²wo³ni⁴ha"  | "the man who is speaking"
        "11a"  | "ᎦᏟ ᏥᎪᏩᏘᎭ"         | "gi²hli ji²gowh¹tị³ha"    | "I see a dog."
        "11b"  | "ᎦᏟ ᏥᏥᎪᏩᏘᎭ"       | "gi²hli jị²ji²gowh¹tị⁴ha"  | "the dog that I see"
        "12a"  | "ᎠᏍᎦᏯ Ꮭ ᏱᎦᏬᏂᎭ"     | "ạ²sgạ²ya hla³ yị²gạ²wo³²nị²ha" | "A man isn't speaking."
        "12b"  | "ᎠᏍᎦᏯ ᏂᎦᏬᏂᏍᎬᎾ ᏥᎩ" | "ạ²sgạ²ya nị²gạ²wo³²ni²sgv⁴na ji⁴gi" | "the man who isn't speaking"
        "13a"  | "ᎪᏯᎩ ᎬᏩᎪᎲᎢ ᏥᎩ"   | "go¹hi³gi gv²wạ²go²hv⁴ʔi ji⁴gi" | "the one he hasn't seen in a long time"
    }

    def "Section I-A: j-, specific past time examples"() {
        expect:
        cherokee == expectedCherokee
        english == expectedEnglish

        where:
        number | cherokee              | romanization             | english
        "14a"  | "ᎤᏬᏂᏒᎢ"             | "u¹wo³ni²sv²³ʔi"         | "He spoke."
        "14b"  | "ᏒᎯ ᏧᏬᏂᏒᎢ"         | "sv²hi ju¹wo³ni²sv²³ʔi"   | "He spoke yesterday."
        "15a"  | "ᏣᏬᏂᏒᎢ"             | "jạ²wo³ni²sv²³ʔi"         | "You spoke."
        "15b"  | "ᏒᎯ ᏥᏣᏬᏂᏒᎢ"       | "sv²hi jị²jạ²wo³ni²sv²³ʔi" | "You spoke yesterday."
        "16"   | "ᎦᏙ ᎤᏛᏁᎴᏒᎢ?"         | "gạ²do² u¹dv³ne²le³sv²ʔi?" | "What did he do yesterday?"
        "17"   | "ᏧᏬᏂᏒᎢ"             | "ju¹wo³ni²sv²³ʔi"         | "He spoke."
        "18"   | "ᎦᏙ ᎤᏛᏁᎴᎢ ᏒᎢ?"       | "gạ²do² u¹dv³ne²le³ʔi sv²hi?" | "What did he do yesterday?"
        "19"   | "ᎤᏬᏂᏎᎢ"             | "u¹wo³ni²se³ʔi"           | "He spoke (reportedly)."
    }

    def "Section I-A: j-, negative imperative examples"() {
        expect:
        cherokee == expectedCherokee
        english == expectedEnglish

        where:
        number | cherokee              | romanization             | english
        "20a"  | "ᎢᏅᏂᎦ"               | "e²nv³ni¹ga"             | "Let's you and I hit him."
        "20b"  | "ᏞᏍᏗ ᏤᏅᏂᎵ"         | "hle¹sdi jẹ³nv²ni¹li"     | "Let's you and I not hit him."
        "21a"  | "ᏗᏣᏚᎦ"             | "dị²jạ²du³²ga"           | "Throw them."
        "21b"  | "ᏞᏍᏗ ᏥᏙᏣᏕᏏ"       | "hle¹sdi jị²do²³jạ³de³si" | "Don't throw them."
    }

    def "Section I-A: j-, 'again'- imperative examples"() {
        expect:
        cherokee == expectedCherokee
        english == expectedEnglish

        where:
        number | cherokee              | romanization             | english
        "22a"  | "ᎡᏅᏂᎦ"               | "e²nv³ni¹ga"             | "Let's you and I hit him."
        "22b"  | "ᏥᎡᏅᏂᎦ"             | "jị³ʔe²nv²ni³²ga"        | "Let's you and I hit him again."
        "22c"  | "ᏤᏅᏂᎦ"             | "jẹ³nv²ni³²ga"           | "Let's you and I hit him again."
        "23a"  | "ᏣᏚᎦ"               | "jạ²du¹ga"               | "Throw it."
        "23b"  | "ᏥᏣᏚᎦ"             | "ji²³jạ³du³²ga"          | "Throw it again."
        "24"   | "ᏤᏍᏗ ᏥᏣᏕᏏ"         | "hle¹sdi ji²³jạ³de³si"    | "Don't throw it"
    }

    def "Section I-A: w-, position or motion away from speaker examples"() {
        expect:
        cherokee == expectedCherokee
        english == expectedEnglish

        where:
        number | cherokee              | romanization             | english
        "25a"  | "ᎠᎪᏩᏘᎭ"             | "a¹gowh²tị³ha"            | "He sees it."
        "25b"  | "ᏩᎪᏩᏘᎭ"             | "wạ²gowh³tị²ha"          | "He sees it (with his back turned to the speaker)."
        "26a"  | "ᏣᏕᎦ"               | "jạ²de³ga"               | "You're throwing it."
        "26b"  | "ᏫᏣᏕᎦ"             | "wị²jạ²de³²ga"           | "You're throwing it (away from speaker)"
        "27a"  | "ᎯᎪᏩᏘᎭ"             | "hị²gowh²tị³ha"          | "You see it."
        "27b"  | "ᏫᎪᏩᏘᎭ"             | "hwị²gowh³tị²ha"         | "You see it (looking away from the speaker)."
        "28a"  | "ᏳᏫᎦᏬᏂᎭ"           | "yụ²wị²gạ²wo³²nị²ha"     | "He isn't speaking (with his back turned)."
        "28b"  | "ᏳᎪᏬᎭ"             | "yu²gạ²wo³²nị²ha"        | "He isn't speaking (with his back turned)."
        "29a"  | "ᎤᏬᏝ"               | "u¹wo²³hla"              | "He's sitting."
        "29b"  | "ᏳᏬᏝ"               | "wụ²wo³hla"              | "He's sitting (with his back to the speaker)."
        "30a"  | "ᎠᎢ"                 | "a³ʔi"                   | "He's walking."
        "30b"  | "ᎳᎢ"                 | "wa³ʔi"                  | "He's walking (away from the speaker)."
        "31a"  | "ᏥᏬᏂᎯ"             | "jị²wo³²ni²hi"           | "Let me speak."
        "31b"  | "ᏫᏥᏬᏂᎯ"           | "wị²jị²wo³²ni²hi"        | "Let me speak."
        "32a"  | "ᎯᏬᏂᎯ"             | "hị²wo¹ni²³hi"           | "Speak."
        "32b"  | "ᏫᏬᏂᎯ"             | "hwị²wo³²ni²hi"          | "Speak (facing away)."
        "33a"  | "ᏚᎸᏫᏍᏓᏁᎰᎢ"         | "du¹lv²³hwị³sda¹ne²ho³ʔi" | "He works."
        "33b"  | "ᏫᏚᎵᎳᏍᏓᏁᎰᎢ"       | "wị²du²³lv³hwị²sda¹ne²ho³ʔi" | "He works (at a distance)."
        "34"   | "ᏕᎪᏪᎵᎠ"             | "de²go³hwe²³lịʔa"        | "He's writing them."
        "35a"  | "ᏕᎪᏪᎳᏁᎭ"           | "de²go³hwe²³la³²nẹ²ha"   | "He's writing them for him."
        "35b"  | "ᏫᏗᎪᏪᎳᏁᎭ"         | "wị²dị²go²hwe³la¹nẹ²ha"   | "He's writing them to him."
    }

    def "Section I-A: n-, lateral position / 'already' / negative / specified action examples"() {
        expect:
        cherokee == expectedCherokee
        english == expectedEnglish

        where:
        number | cherokee              | romanization             | english
        "36a"  | "ᎠᎪᏩᏘᎭ"             | "a¹gowh²tị³ha"            | "He sees it."
        "36b"  | "ᎾᎪᏩᏘᎭ"             | "nạ²gowh³tị²ha"          | "He sees it (from a lateral position)."
        "37a"  | "ᎦᏬᏂᎭ"               | "gạ²wo³nị²ha"            | "He's speaking,"
        "37b"  | "ᏂᎦᏬᏂᎭ"             | "nị²gạ²wo³²nị²ha"        | "He's speaking (laterally)."
        "38a"  | "ᎯᎪᏩᏘᎭ"             | "hị²gowh²tị³ha"          | "You see it."
        "38b"  | "ᏂᎪᏩᏘᎭ"             | "hnị²gowh³tị²ha"         | "You see it (laterally)."
        "39a"  | "ᎤᎦᎿᏅᎢ"             | "u¹ga²hnạ²nv²³ʔi"        | "It rained."
        "39b"  | "ᏄᎦᎿᏃᎢ"             | "nu²ga³hnạ²no⁴ʔi"        | "It had already rained."
        "40"   | "ᏄᎦᎿᏃᎢ ᏩᎩᎷᏣ"       | "nu²ga³hnạ²no⁴ʔi wạ³gịʔ²luh²ja" | "It had already rained when I arrived there."
        "41"   | "ᏄᏬᏂᏐᎢ ᏫᏥᎷᎪᎢ"     | "nu²wo³²ni²so⁴ʔi wị²jịʔ³luh²go³ʔi" | "I arrive (habitually) there after he has already spoken."
        "42"   | "ᏂᎦᏬᏂᏍᎨᏍᏗ"         | "nị²gạ²wo³²ni²sge⁴sdi"   | "He will already be speaking (at some specified future time)."
        "43a"  | "ᎤᏲᏏᏍᎬᎢ"           | "u¹yo³si²sgv²³ʔi"        | "He was hungry."
        "43b"  | "ᏄᏲᏏᏍᎬᎾ"           | "nu²yo³²si²sgv⁴na"       | "He's without hunger."
        "44a"  | "ᎠᎪᏩᏘᏍᎬᎢ"         | "a¹gowh²ti²³sgv³ʔi"      | "He was seeing it."
        "44b"  | "ᏂᎪᏩᏘᏍᎬᎾ"         | "nạ²gowh³ti²sgv⁴na"      | "He's without seeing it."
        "45"   | "ᎦᏙ ᎠᏛᏁᎭ?"           | "gạ²do² a¹dv³nẹ²haʔ"      | "What's he doing?"
        "46"   | "ᎦᎪ ᎾᏛᏁᎭ?"           | "ga³go² na¹dv³nẹ²haʔ"    | "Who's doing it?"
        "47"   | "ᏂᏓᏳᎪᏩᏛᏗ ᎤᏚᎵᎭ"   | "nị²dạ²yu³gowh²tvh³di u¹du²lị³ha" | "He wants to see it (looking this way)."
        "48"   | "ᏪᏌ ᏂᎦᏪᎠ"           | "we²³sa nị²gạ²wẹ²ʔa"     | "A cat is meowing."
    }

    def "Section I-A: de-, plural object examples"() {
        expect:
        cherokee == expectedCherokee
        english == expectedEnglish

        where:
        number | cherokee              | romanization             | english
        "49a"  | "ᏥᎪᏩᏘᎭ"             | "jị²gowh¹tị³ha"          | "I see it."
        "49b"  | "ᏕᏥᎪᏩᏘᎭ"           | "de²jị³gowh¹tị³ha"       | "I see them."
        "50a"  | "ᎠᎪᏩᏘᎭ"             | "a¹gowh²tị³ha"            | "He sees it."
        "50b"  | "ᏓᎪᏩᏘᎭ"             | "da¹gowh²tị³ha"            | "He sees them."
        "51a"  | "ᎢᏂᎪᏩᏘᎭ"             | "i¹ni²gowh²tị³ha"        | "You and I see it."
        "51b"  | "ᏕᏂᎪᏩᏘᎭ"             | "de³ni²gowh²tị³ha"       | "You and I see them."
        "52a"  | "Ꮭ ᏱᏥᎪᏩᏘᎭ"         | "hla³ yị²jị²gowh³²tị³ha"  | "I don't see it."
        "52b"  | "Ꮭ ᏱᏗᏥᎪᏩᏘᎭ"       | "hla³ yị²dị²jị²gowh³²tị³ha" | "I don't see them."
        "53a"  | "ᏫᏍᏗᎪᏩᏘᎭ"           | "wị²sdi²³gowh³tị²ha"     | "You (dl) see it (facing away)."
        "53b"  | "ᏫᏗᏍᏗᎪᏩᏘᎭ"         | "wị²dị²sdi²³gowh³tị²ha"  | "You (dl) see them (facing away)."
        "54a"  | "ᏍᏗᎪᏩᏘᎭ"           | "nị²sdi²³gowh³tị²ha"     | "You (dl) see it (facing sideways)."
        "54b"  | "ᏂᏗᏍᏗᎪᏩᏘᎭ"         | "nị²dị²sdi²³gowh³tị²ha"  | "You (dl) see them (facing sideways)."
        "55a"  | "ᏕᏥᎪᏩᏘᏍᎬᎢ"         | "de²jị³gowh¹ti²³sgv³ʔi"  | "I was seeing them."
        "55b"  | "ᏫᏕᏥᎪᏩᏘᏍᎬᎢ"       | "wị²de²jị³gowh¹ti²³sgv³ʔi" | "I was seeing them (facing away)."
        "56a"  | "ᏍᏗᎪᏩᏛᏗ ᎤᏚᎵᎭᏲ"     | "sdi²gowh²tvh³di u¹du²lị³ha" | "He wants you (dl) to see it."
        "56b"  | "ᏗᏍᏗᎪᏩᏛᏗ ᎤᏚᎵᎭ"   | "dị²sdi²gowh²tvh³di u¹du²lị³ha" | "He wants you (dl) to see them."
        "57a"  | "ᏣᏚᎦ"               | "jạ²du¹ga"               | "Throw it."
        "57b"  | "ᏗᏣᏚᎦ"             | "dị²jạ²du³²ga"           | "Throw them."
        "58a"  | "ᎤᎪᏩᏛᏗ ᎤᏚᎵᎭ"       | "u²gowh²tvh³di u¹du²lị³ha" | "He wants to see it."
        "58b"  | "ᏧᎪᏩᏛᏗ ᎤᏚᎵᎭ"       | "ju²gowh²tvh³di u¹du²lị³ha" | "He wants to see them."
        "59a"  | "ᎡᎾᏗᏅᏏ"             | "e²nạ³diʔ²nṿ²si"         | "Let's you and I throw it for him."
        "59b"  | "ᏤᎾᏗᏅᏏ"             | "je²nạ³diʔ²nṿ²si"         | "Let's you and I throw them for him."
        "60a"  | "ᎠᎩᎪᏩᏛᏗᎢ ᎤᏚᎵᎭ"   | "ạ²gị²gowh²tvh³di u¹du²lị³ha" | "He wants me to see it."
        "60b"  | "ᏗᎩᎪᏩᏛᏗ ᎤᏚᎵᎭ"     | "di²gị²gowh²tvh³di u¹du²lị³ha" | "He wants me to see them."
        "61a"  | "ᏕᎯᎪᏩᏘᎭ"             | "de²hị³gowh²tị³ha"       | "You see them."
        "61b"  | "ᏫᏘᎪᏩᏘᎭ"             | "wị²tị²gowh³tị²ha"       | "You see them (facing away)."
    }

    def "Section I-F: Verb 'to be' examples and sentences"() {
        expect:
        cherokee == expectedCherokee
        english == expectedEnglish

        where:
        number | cherokee              | romanization             | english
        "F1"   | "Ꮎ ᎠᏍᎦᏯ ᎤᏔᎾ"         | "na ạ²sgạ²ya u²³tạ²na"    | "The man is big."
        "F2"   | "Ꮎ ᎠᏍᎦᏯ ᎤᏔᎾ ᏥᎩ ᎣᎩᎾᎵᎢ" | "na ạ²sgạ²ya u²³tạ²na ji⁴gi o²gị²na²li⁴ʔi" | "The man who is big is my friend."
        "F3"   | "Ꮭ ᎠᏍᎦᏯ ᏱᎩ"         | "hla ạ²sgạ²ya yị²gi"     | "It's not a man."
        "F4"   | "ᏚᎾᏙᎥᏃ ᎯᎠ ᎢᎩ"         | "du¹nạ²do³ʔv⁴hno hị²ʔa i²³gi" | "And their names are these."
        "F5"   | "ᎠᎨᏯ ᎨᏒᎢ"           | "ạ²ge²³hya ge¹sv²³ʔi"    | "It was a woman."
        "F6"   | "ᎣᏍᏓ ᎨᏒᎢ"             | "o⁴sda ge¹sv²³ʔi"        | "It was good."
        "F7"   | "ᎣᏍᏓ ᎨᏎᎢ"             | "o⁴sda ge¹se³ʔi"         | "It was good (reportedly)."
        "F8"   | "ᎠᎨᏳᏣ ᎨᏎᏍᏗ"       | "ạ²ge²hyu⁴ja ge¹se³sdi"  | "It will be a girl."
        "F9"   | "ᎣᏍᏓ ᎨᏎᏍᏗ"         | "o⁴sda ge¹se³sdi"        | "It will be good."
        "F10"  | "ᎠᎨᏯ ᎨᏒᎢ ᏥᎩᏬᏂᏍᎥᎢ" | "ạ²ge²³hya ge¹sv²³ʔi jị²gạ²wo³ni²sgv⁴ʔi" | "It was a woman who was speaking."
        "F11"  | "ᎠᎨᏯ ᎨᏒᎢ ᏧᏬᏂᏒᎢ"   | "ạ²ge²³hya ge¹sv²³ʔi ju¹wo³ni²sv⁴ʔi" | "It was a woman who spoke."
        "F12"  | "ᎠᎨᏯ ᎦᏐᎢ"           | "ạ²ge²³hya ge¹so³ʔi"     | "It's a woman (habitually)."
        "F13"  | "ᏣᏂ ᎤᎪᏗ ᎤᏔᎾ ᏏᏅ ᏣᎵ ᎨᏒᎢ" | "ja²³ni u¹go³²di u¹tạ²na si²³hnv ja²³li ge¹sv⁴ʔi" | "John is bigger than Charley."
    }

    def "Section II-A & II-B: Noun prefixes and suffixes examples"() {
        expect:
        cherokee == expectedCherokee
        english == expectedEnglish

        where:
        number | cherokee              | romanization             | english
        "II-1a" | "ᎧᏁᏌᎢ"             | "kạ²ne¹sạ³ʔi"            | "box"
        "II-1b" | "ᏗᎧᏁᏌᎢ"             | "dị²kạ²ne²sạ³ʔi"        | "boxes"
        "II-2a" | "ᎤᏪᏥ"               | "ụ²we²³ji"               | "egg"
        "II-2b" | "ᏧᏬᏥ"               | "jụ²we²³ji"               | "eggs"
        "II-3a" | "ᎤᏓᏁᎲᎢ"             | "u¹dạ²ne²hv⁴ʔi"          | "puddle"
        "II-3b" | "ᏚᏓᏁᎲᎢ"             | "du¹dạ²ne¹hv⁴ʔi"         | "puddles"
        "II-4a" | "ᎧᏁᏌᎢ ᏥᎪᏩᏘᎭ"       | "kạ²ne¹sạ³ʔi jị²gowh¹tị³ha" | "I see a box."
        "II-4b" | "ᏗᎧᏁᏌᎢ ᏕᏥᎪᏩᏘᎭ"     | "dị²kạ²ne¹sạ³ʔi de²³jị³gowh¹tị³ha" | "I see boxes."
        "II-5a" | "ᎫᎫ ᏥᎪᏩᏘᎭ"         | "gu¹gu jị²gowh¹tị³ha"    | "I see a bottle."
        "II-5b" | "ᎫᎫ ᏕᏥᎪᏩᏘᎭ"       | "gu¹gu de²³jị³gowh¹tị³ha"  | "I see bottles."
        "II-6"  | "ᏕᎬᏃᏌᏍᎦ"             | "de²³gv³no²sạ³sga"       | "He's sweeping them."
        "II-7"  | "ᏗᎬᏃᏌᏍᎩ"             | "dị²gv²no²³sạ²sgi"       | "sweeper (of plural objects)"
        "II-8"  | "ᎠᏍᎦᏯ"             | "ạ²sgạ²ya"               | "man"
        "II-9"  | "ᎠᎨᏯ"               | "ạ²ge²³hya"              | "woman"
        "II-10" | "ᎠᏧᏣ"               | "ạ²chu⁴ja"               | "boy"
        "II-11a"| "ᎠᎦᎾᎦᏘ"             | "ạ²gạʔ³nạ²kti"           | "doctor"
        "II-11b"| "ᎦᎾᎦᏘ"             | "gạʔ³nạ²kti"             | "doctor"
        "II-11c"| "ᎠᏂᎦᎾᎦᏘ"           | "ạ²ni²gạʔ³nạ²kti"        | "doctors"
        "II-12" | "ᎠᏂᏍᎦᏯ"             | "ạ²ni²sgạ²ya"             | "men"
        "II-13a"| "ᎤᏪᏥ"               | "ụ²we²³ji"               | "his offspring"
        "II-13b"| "ᎤᏁᏥ"               | "u²ne²³ji"               | "their offspring"
        "II-14" | "ᏥᏍᎦᏯ"             | "ji¹sgạ²ya"              | "I'm a man."
        "II-15" | "ᎧᏁᏌᎢ"             | "kạ²ne¹sạ³ʔi"            | "It's a box."
        "II-16" | "ᏏᏲ ᎯᏧᏣ"           | "sị²yo hị²chu⁴ja"         | "Hello, boy."
    }
}
