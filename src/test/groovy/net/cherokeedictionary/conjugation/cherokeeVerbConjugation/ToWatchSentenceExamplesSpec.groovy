package net.cherokeedictionary.conjugation.cherokeeVerbConjugation

import spock.lang.Specification
import spock.lang.Unroll

/**
 * Verb-book reference spec: "To Watch" — EXAMPLES.
 *
 * Source: Cherokee Verb Conjugations (Durbin Feeling verb book), pp.162-164
 * (printed page numbers of the full 164-page document).
 *
 * Twenty-six example sentences, each printed as:
 *   english - the English sentence
 *   a       - the romanized Cherokee sentence
 *   b       - the syllabary Cherokee sentence
 *
 * The sentences are preserved verbatim for later deconstruction work; the
 * "forms" field lists conjugated forms of this verb that each sentence
 * exercises, detected by substring match of the verb-book row forms in the
 * romanized (a) or syllabary (b) line — a heuristic aid, not a replacement
 * for manual analysis; an empty list means no match was found.
 *
 * Conventions: romanized forms are transcribed as printed; typographic apostrophes
 * (U+2019) are normalized to ASCII apostrophes (').
 */
@Unroll
class ToWatchSentenceExamplesSpec extends Specification {

    static final String VERB = "to watch"
    static final String SOURCE_PAGE = "pp.162-164"

    /** All twenty-six example sentences exactly as printed in the verb book. */
    static final List<Map> EXAMPLES = [
            [number: 1,
             english: "Joe, you stay here and watch the car!",
             a: "tsowi, ahani hedohesdi ale tsagasesdi dagwalelu",
             b: "ᏦᏫ, ᎠᎭᏂ ᎮᏙᎮᏍᏗ ᎠᎴ ᏣᎦᏎᏍᏗ ᏓᏆᎴᎷ",
             forms: ["tsagasesdi (Present Tense, Second Singular)", "tsagasesdi (Present Tense, Third Singular)", "agasesdi (Present Tense, Third Singular)"]],
            [number: 2,
             english: "Mary, God is always watching you.",
             a: "meli, unelanvhi nigohilv tsagasesdo'i",
             b: "ᎺᎵ, ᎤᏁᎳᏅᎯ ᏂᎪᎯᎸ ᏣᎦᏎᏍᏙᎢ",
             forms: []],
            [number: 3,
             english: "Dad wants you two boys to watch that movie intently.",
             a: "edoda uduli nihi sditali sditsutsa sdaksestodi na adayvladvsgi",
             b: "ᎡᏙᏓ ᎤᏚᎵ ᏂᎯ ᏍᏗᏔᎵ ᏍᏗᏧᏣ ᏍᏓᎦᏎᏍᏙᏗ Ꮎ ᎠᏓᏴᎳᏛᏍᎩ",
             forms: []],
            [number: 4,
             english: "That snake is poisonous. You two boys watch it!",
             a: "na inada adahihi. sditali sditsutsa sdagasesdesdi.",
             b: "Ꮎ ᎢᎾᏓ ᎠᏓᎯᎯ. ᏍᏗᏔᎵ ᏍᏗᏧᏣ ᏍᏓᎦᏎᏍᏕᏍᏗ.",
             forms: []],
            [number: 5,
             english: "When you watch a pot, it won't boil.",
             a: "yitsagasesdi ama alilidoti, hla yvgvlidla",
             b: "ᏱᏣᎦᏎᏍᏗ ᎠᎹ ᎠᎵᎵᏙᏘ, Ꮭ ᏴᎬᎵᏜ",
             forms: ["tsagasesdi (Present Tense, Second Singular)", "tsagasesdi (Present Tense, Third Singular)", "agasesdi (Present Tense, Third Singular)", "itsagasesdi (Present Tense, Third Singular)", "itsagasesdi (Present Tense, Second Plural)"]],
            [number: 6,
             english: "John, yesterday you watched that car for him.",
             a: "tsani, svhi tsigesv tsagasestanv na dagwalelu utseli'i",
             b: "ᏣᏂ, ᏒᎯ ᏥᎨᏒ ᏣᎦᏎᏍᏔᏅ Ꮎ ᏓᏆᎴᎷ ᎤᏤᎵᎢ",
             forms: []],
            [number: 7,
             english: "When my son is outside, I always watch him.",
             a: "iyuno doyi yedoha, agwetsi atsutsa nigohilv tsiyagasesdo'i",
             b: "ᎢᏳᏃ ᏙᏱ ᏰᏙᎭ, ᎠᏇᏥ ᎠᏧᏣ ᏂᎪᎯᎸ ᏥᏯᎦᏎᏍᏙᎢ",
             forms: []],
            [number: 8,
             english: "When Joe is playing basketball, I want all you girls (more than two) to watch him.",
             a: "adatinvdoti sgwahlesdi yidanelohvsga tsowi, agwaduli nigada itsigeyutsa itsiluhisdi etsagadosdodi'i",
             b: "ᎠᏓᏘᏅᏙᏘ ᏍᏆᏞᏍᏗ ᏱᏓᏁᎶᎲᏍᎦ ᏦᏫ, ᎠᏆᏚᎵ ᏂᎦᏓ ᎢᏥᎨᏳᏣ ᎢᏥᎷᎯᏍᏗ ᎡᏣᎦᏙᏍᏩᏗᎢ",
             forms: []],
            [number: 9,
             english: "Joe, watch that football game (right now)!!",
             a: "tsowi, hagasesda na sgwalesdi dananelohvsgv'i",
             b: "ᏦᏫ, ᎭᎦᏎᏍᏓ Ꮎ ᏍᏆᎴᏍᏗ ᏓᎾᏁᎶᎲᏍᎬᎢ",
             forms: ["hagasesda (Immediate Imperative/Volative)", "agasesda (Immediate Past Tense)"]],
            [number: 10,
             english: "Mom is always watching me.",
             a: "etsi nigohilv agwagasesdo'i",
             b: "ᎡᏥ ᏂᎪᎯᎸ ᎠᏆᎦᏎᏍᏙᎢ",
             forms: []],
            [number: 11,
             english: "You girls watch for the car, right now!",
             a: "itsigeyutsa itsagasesda na dagwalelu",
             b: "ᎢᏥᎨᏳᏣ ᎢᏣᎦᏎᏍᏓ Ꮎ ᏓᏆᎴᎷ",
             forms: ["itsagasesda (Immediate Imperative/Volative)", "agasesda (Immediate Past Tense)"]],
            [number: 12,
             english: "That girl is always watching me.",
             a: "na ageyutsa nigohilv agwagasesdo'i",
             b: "Ꮎ ᎠᎨᏳᏣ ᏂᎪᎯᎸ ᎠᏆᎦᏎᏍᏙᎢ",
             forms: []],
            [number: 13,
             english: "Girls, when you walk in the woods, watch out for snakes!",
             a: "itsigeyutsa inige itsedohv itsagasesdesdi inada",
             b: "ᎢᏥᎨᏳᏣ ᎢᏂᎨ ᎢᏤᏙᎲ ᎢᏣᎦᏎᏍᏕᏍᏗ ᎢᎾᏓ",
             forms: []],
            [number: 14,
             english: "You boys always watch out for danger!",
             a: "nihi itsitsutsa nigohilv itsagasesdi ganayegv'i!",
             b: "ᏂᎯ ᎢᏥᏧᏣ ᏂᎪᎯᎸ ᎢᏣᎦᏎᏍᏗ ᎦᎾᏰᎬᎢ!",
             forms: ["tsagasesdi (Present Tense, Second Singular)", "tsagasesdi (Present Tense, Third Singular)", "agasesdi (Present Tense, Third Singular)", "itsagasesdi (Present Tense, Third Singular)", "itsagasesdi (Present Tense, Second Plural)"]],
            [number: 15,
             english: "Yesterday, I was watching the baby.",
             a: "svhi tsigesv usdi tsiyagasesdv'i",
             b: "ᏒᎯ ᏥᎨᏒ ᎤᏍᏗ ᏥᏯᎦᏎᏍᏛᎢ",
             forms: []],
            [number: 16,
             english: "Mary, do you always watch the clock?",
             a: "meli, nigohilv'is tsagasesdo watsi?",
             b: "ᎺᎵ, ᏂᎪᎯᎸᎢᏍ ᎦᏣᏎᏍᏙ ᏩᏥ?",
             forms: []],
            [number: 17,
             english: "I like to watch television.",
             a: "agilvgwodi agwagadosdodi'i (to watch for pleasure)",
             b: "ᎠᎩᎸᏉᏗ ᎠᏆᎦᏙᏍᏙᏗᎢ",
             c: "agilvgwodi agwagasesdodi'i (to watch out for something or someone, as one might watch a baby, for example)",
             d: "ᎠᎩᎸᏉᏗ ᎠᏆᎦᏎᏍᏙᏗᎢ",
             forms: []],
            [number: 18,
             english: "Mary wants for me to watch her baby.",
             a: "meli uduli tsiyagasesdanedi'i",
             b: "ᎺᎵ ᎤᏚᎵ ᏥᏯᎦᏎᏍᏓᏁᏗᎢ",
             forms: ["agasesda (Immediate Past Tense)"]],
            [number: 19,
             english: "You girls watch for the car, right now!",
             a: "itsigeyutsa itsagasesda na dagwalelu!",
             b: "ᎢᏥᎨᏳᏣ ᎢᏣᎦᏎᏍᏓ Ꮎ ᏓᏆᎴᎷ!",
             forms: ["itsagasesda (Immediate Imperative/Volative)", "agasesda (Immediate Past Tense)"]],
            [number: 20,
             english: "That girl is always watching me.",
             a: "na ageyutsa nigohilv agwagasesdo'i",
             b: "Ꮎ ᎠᎨᏳᏣ ᏂᎪᎯᎸ ᎠᏆᎦᏎᏍᏙᎢ",
             forms: []],
            [number: 21,
             english: "Girls, when you walk in the woods, watch out for snakes!",
             a: "itsigeyutsa, inage itsedohv itsagasesdesdi inada",
             b: "ᎢᏥᎨᏳᏣ, ᎢᎾᎨ ᎢᏤᏙᎲ ᎢᏣᎦᏎᏍᏕᏍᏗ ᎢᎾᏓ",
             forms: []],
            [number: 22,
             english: "You boys always watch out for danger!",
             a: "nihi itsitsutsa nigohilv itsagasesdi ganayegv'i!",
             b: "ᏂᎯ ᎢᏥᏧᏣ ᏂᎪᎯᎸ ᎢᏣᎦᏎᏍᏗ ᎦᎾᏰᎬᎢ!",
             forms: ["tsagasesdi (Present Tense, Second Singular)", "tsagasesdi (Present Tense, Third Singular)", "agasesdi (Present Tense, Third Singular)", "itsagasesdi (Present Tense, Third Singular)", "itsagasesdi (Present Tense, Second Plural)"]],
            [number: 23,
             english: "Yesterday I was watching the baby.",
             a: "svhi tsigesv usdi tsiyagasesdv'i",
             b: "ᏒᎯ ᏥᎨᏒ ᎤᏍᏗ ᏥᏯᎦᏎᏍᏛᎢ",
             forms: []],
            [number: 24,
             english: "Mary, do you always watch the clock?",
             a: "meli, nigohilv'is tsagasesdo watsi?",
             b: "ᎺᎵ, ᏂᎪᎯᎸᎢᏍ ᏣᎦᏎᏍᏙ ᏩᏥ?",
             forms: []],
            [number: 25,
             english: "I like to watch television.",
             a: "agilvgwodi adayvladvsgi? agwagadosdodi'i",
             b: "ᎠᎩᎸᏉᏗ ᎠᏓᏴᎳᏛᏍᎩ ᎠᏆᎦᏩᏍᏙᏗᎢ",
             forms: []],
            [number: 26,
             english: "Mary wants for me to watch her baby.",
             a: "meli uduli tsiyagasesdanedi'i",
             b: "ᎺᎵ ᎤᏚᎵ ᏥᏯᎦᏎᏍᏓᏁᏗᎢ",
             forms: ["agasesda (Immediate Past Tense)"]],
    ]

    def "example #row.number is recorded with all three lines intact"() {
        expect: "english sentence, romanized line and syllabary line are all preserved"
        row.english && row.a && row.b

        and: "the verb forms it exercises are documented for later deconstruction"
        row.forms != null

        where: "all twenty-six verb-book examples"
        row << EXAMPLES
    }

    def "example #row.number: syllabary and romanized lines are non-trivial"() {
        expect:
        row.a.length() > 10
        row.b.length() > 5

        where: "all twenty-six verb-book examples"
        row << EXAMPLES
    }

    def "the example collection is complete (twenty-six examples)"() {
        expect:
        EXAMPLES*.number == [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26]
    }
}
