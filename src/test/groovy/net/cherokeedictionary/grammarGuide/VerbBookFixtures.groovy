package net.cherokeedictionary.grammarGuide

class VerbBookFixtures {
    // tio 12Nov26: was `[\n]` which Groovy parses as an empty LIST — the Map cast
    // threw GroovyRuntimeException in <clinit> and every ToSeePresentSpec row died
    // with NoClassDefFoundError. Empty map literal must be [:].
    static final Map<String, Map> OVERRIDES = [:]

    static final Map<String, Map> FIXTURES = [
        "to be somewhere": [
            partOfSpeech: "v.t.",
            objectClass: "SG3IN",
            conjugations: [
                [subject: "SG3", habitual: "edohoi", imperative: "geda", infinitive: "uwedasdi", present: "edoha", remote_past: "edohvi"],
                [subject: "SG1", present: "gedoha"],
            ],
        ],
        "to be thankful or happy": [
            partOfSpeech: "v.t.",
            objectClass: "SG3AN",
            conjugations: [
                [subject: "SG3", habitual: "aliheligoi", imperative: "galieligi", infinitive: "ulihelisdi", present: "aliheliga", remote_past: "ulihelitsvi"],
                [subject: "SG1", present: "galieliga"],
            ],
        ],
        "to bite (when a human bites)": [
            // tio 12Nov26: SG3 habitual/remote_past previously carried the SG1
            // forms ("tsisgahlgoi" / "tsisgahltsvi"); the books Third Singular
            // rows are "asgahlogoi" (ᎠᏍᎦᎶᎪᎢ) and "usgalitsvi" (ᎤᏍᎦᎵᏨᎢ) —
            // see ToBitePresentHabitualSpec / ToBiteRemotePastSpec rows.
            // tio 12Nov26: the SG1 citation row must be the books First Singular
            // -> him/her form "tsisgahlga" (ᏥᏍᎦᎶᎦ), not "gvsgahlga" (the SG1->SG2
            // cell): the Stemmers a3rd() router keys off the 1sg citations
            // initial (Ꮵ... -> consonant stems, Ꭶ... -> vowel stems), and Ꭼ...
            // (gv-) matches neither, so the verb was vowel-stemmed and every
            // consonant-branch prefix allomorph was bypassed. Also added the
            // immediate_past stem "asgala" (ᎠᏍᎦᎳ, book p.29) — IMMEDIATE_PAST
            // had no stem before and could not compose at all.
            partOfSpeech: "v.t.",
            objectClass: "SG3AN",
            conjugations: [
                [subject: "SG3", habitual: "asgahlgoi", imperative: "hisgala", infinitive: "usgahlsdi", present: "asgahlga", remote_past: "usgalitsvi", immediate_past: "asgala"],
                [subject: "SG1", present: "tsisgahlga"],
            ],
        ],
        "to fall (a living being)": [
            // tio 12Nov26: SG3 rows corrected to the books Third Singular forms
            // (habitual ᎦᏅᎪᎢ ganvgoi and remote ᎤᏅᏨᎢ unvtsvi — the old values
            // "tsinvgoi"/"aginvtsvi" were 1st-person lexicon rows) and the
            // immediate-past stem ᎦᏅᎩ ganvgi added (book p.32 "S/he fell"
            // immediate column).
            // tio 12Nov26: distributive — the book prints de- on every
            // non-singular-subject row of every tense table (ᏕᏍᏗᏅᎦ, ᏙᏍᏗᏅᎦ,
            // ᏓᏂᏅᎦ, ᏚᏂᏅᏨᎢ, ...); PrefixDe supplies the D-map allomorphy.
            distributive: true,
            partOfSpeech: "v.i.",
            objectClass: "SG3IN",
            conjugations: [
                [subject: "SG3", habitual: "ganvgoi", imperative: "wiganvgi", infinitive: "unvisdi", present: "ganvga", remote_past: "unvtsvi", immediate_past: "ganvgi"],
                [subject: "SG1", present: "tsinvga"],
            ],
        ],
        "to go": [
            partOfSpeech: "v.t.",
            objectClass: "SG3IN",
            conjugations: [
                [subject: "SG3", habitual: "anegoi", imperative: "gena", infinitive: "uwenvsdi", present: "ega", remote_past: "uwenvsvi"],
                [subject: "SG1", present: "gega"],
            ],
        ],
        "to have (a living being)": [
            partOfSpeech: "v.t.",
            objectClass: "SG3AN",
            conjugations: [
                [subject: "SG3", present: "agikaha"],
                [subject: "SG1", present: "gvyakaha"],
            ],
        ],
        "to have something flexible": [
            partOfSpeech: "v.t.",
            objectClass: "SG3IN",
            conjugations: [
                [subject: "SG3", habitual: "He/she/it has multiple flexible things\" unaoi/dunaoi", imperative: "aginaesdi/daginaesdi", infinitive: "unvdi/tsunvdi", present: "unaa/dunaa", remote_past: "unavi/dunavi"],
                [subject: "SG1", present: "I have multiple flexible things\" aginaa/daginaa"],
            ],
        ],
        "to have something liquid, in a container": [
            partOfSpeech: "v.t.",
            objectClass: "SG3IN",
            conjugations: [
                [subject: "SG3", habitual: "He/she/it has multiple liquid things\" unehoi/dunehoi", imperative: "aginehesdi/daginehesdi", infinitive: "uditasdi/tsuditasdi", present: "He/she/it has multiple liquid things\" uneha/duneha", remote_past: "He/she/it had multiple liquid things\" unehvi/dunehvi"],
                [subject: "SG1", present: "I have multiple liquid things\" agineha/dagineha"],
            ],
        ],
        "to have something long and rigid, like a stick, a shovel, etc.": [
            partOfSpeech: "v.t.",
            objectClass: "SG3IN",
            conjugations: [
                [subject: "SG3", habitual: "uwayoi/duwayoi", imperative: "agwvyesdi/dagwvyesdi", infinitive: "uwayi iyulisdodi", present: "uwaya/duwaya", remote_past: "uwayvi/duwayvi"],
                [subject: "SG1", present: "I have multiple long & rigid things\" agwvya/dagwvya"],
            ],
        ],
        "to hear": [
            partOfSpeech: "v.t.",
            objectClass: "SG3AN",
            conjugations: [
                [subject: "SG3", habitual: "gatvgisgoi", imperative: "hatvgvga", infinitive: "utvgodi", present: "atvgia", remote_past: "agwatvganvi"],
                [subject: "SG1", present: "gatvgia"],
            ],
        ],
        "to help": [
            partOfSpeech: "v.t.",
            objectClass: "SG3AN",
            conjugations: [
                [subject: "SG3", habitual: "tsisdelisgoi", imperative: "hisdela", infinitive: "usdelvdi", present: "asdeliha", remote_past: "tsisdelvhvi"],
                [subject: "SG1", present: "tsisdeliha"],
            ],
        ],
        "to hide someone or something": [
            partOfSpeech: "v.t.",
            objectClass: "SG3IN",
            conjugations: [
                [subject: "SG3", habitual: "gvsgahlvsgoi", imperative: "hvsgatlvga", infinitive: "uwasgalvdi", present: "gvsgahlvsga", remote_past: "uwasgahlanvi"],
                [subject: "SG1", present: "gvsgahlvsga"],
            ],
        ],
        "to hit": [
            partOfSpeech: "v.t.",
            objectClass: "SG3IN",
            conjugations: [
                [subject: "SG3", habitual: "gvnihoi", imperative: "hvhnga", infinitive: "uwahnsdi", present: "gvhniha", remote_past: "agwvhnilvi", immediate_past: "vhniga"],
                [subject: "SG1", present: "gvniha"],
            ],
        ],
        "to honor someone or something": [
            partOfSpeech: "v.t.",
            objectClass: "SG3IN",
            conjugations: [
                [subject: "SG3", habitual: "galvkwdisgoi", imperative: "hilvkwda", infinitive: "ulvkwdodi", present: "galvkwdiha", remote_past: "ulvkwtanvi"],
                [subject: "SG1", present: "tsilvkwdiha"],
            ],
        ],
        "to kill someone or something": [
            partOfSpeech: "v.t.",
            objectClass: "SG3AN",
            conjugations: [
                [subject: "SG3", habitual: "ahihoi", imperative: "hiluga", infinitive: "uhisdi", present: "ahiha", remote_past: "utlvi"],
                [subject: "SG1", present: "tsiiha"],
            ],
        ],
        "to like someone or something": [
            partOfSpeech: "v.t.",
            objectClass: "SG3IN",
            conjugations: [
                [subject: "SG3", habitual: "ulvkwdoi", imperative: "hilvkwda", infinitive: "ulvkwdodi", present: "ulvkwdi", remote_past: "ulvkwdvi"],
                [subject: "SG1", present: "agilvkwdi"],
            ],
        ],
        "to look for": [
            partOfSpeech: "v.t.",
            objectClass: "SG3IN",
            conjugations: [
                [subject: "SG3", habitual: "agiyohoi", imperative: "tsayoga", infinitive: "uyosdi (uysdi)", present: "uhyoha", remote_past: "agiyolvi"],
                [subject: "SG1", present: "agiyoha"],
            ],
        ],
        "to love": [
            partOfSpeech: "v.t.",
            objectClass: "SG3IN",
            conjugations: [
                [subject: "SG3", habitual: "ugeyusoi", imperative: "tsageyuhvga", infinitive: "ugeyhdi", present: "ugeyuha", remote_past: "ugeyusvi"],
                [subject: "SG1", present: "agigeyuha"],
            ],
        ],
        "to point something out": [
            partOfSpeech: "v.t.",
            objectClass: "SG3AN",
            conjugations: [
                [subject: "SG3", habitual: "asehehoi", imperative: "hiyasehisi", infinitive: "usehehdi", present: "agwaseheha", remote_past: "usehelvi"],
                [subject: "SG1", present: "gvyaseheha"],
            ],
        ],
        "to remember": [
            partOfSpeech: "v.t.",
            objectClass: "SG3AN",
            conjugations: [
                [subject: "SG3", habitual: "ganvdadisgoi", imperative: "hanvdada", infinitive: "unvdadisdi", present: "anhdadia", remote_past: "agwanvdadvi"],
                [subject: "SG1", present: "ganvdadia"],
            ],
        ],
        "to see": [
            partOfSpeech: "v.t.",
            objectClass: "SG3AN",
            conjugations: [
                [subject: "SG3", habitual: "agowtisgoi", imperative: "higohwahta", infinitive: "ugowtvhdi", present: "agowtiha", remote_past: "ugohvi"],
                [subject: "SG1", present: "tsigowtiha"],
            ],
        ],
        "to stop someone or something": [
            partOfSpeech: "v.t.",
            objectClass: "SG3AN",
            conjugations: [
                [subject: "SG3", habitual: "galehwisdodisgoi", imperative: "halehwisdoda", infinitive: "ulehwisdododi", present: "alehwisdodiha", remote_past: "ulehwisdotanvi"],
                [subject: "SG1", present: "galehwisdodiha"],
            ],
        ],
        "to talk to someone": [
            partOfSpeech: "v.t.",
            objectClass: "SG3AN",
            conjugations: [
                [subject: "SG3", habitual: "ahlinohedisgoi", imperative: "hihlinoheda", infinitive: "tsilinohedodi", present: "ahlinohediha", remote_past: "atsihlinohetlvi"],
                [subject: "SG1", present: "galinohediha"],
            ],
        ],
        "to teach someone": [
            partOfSpeech: "v.t.",
            objectClass: "SG3IN",
            conjugations: [
                [subject: "SG3", habitual: "tsiyeyohvsgoi", imperative: "tiyeyohvga", infinitive: "tsudeyodi", present: "dadeyohvsga", remote_past: "dagwadeyohnvi"],
                [subject: "SG1", present: "degadeyohvsga"],
            ],
        ],
        "to tell something to someone": [
            partOfSpeech: "v.t.",
            objectClass: "SG3IN",
            conjugations: [
                [subject: "SG3", habitual: "tsinohisehoi", imperative: "hinohisi", infinitive: "unohisedi", present: "kanohiseha", remote_past: "tsinohiselvi"],
                [subject: "SG1", present: "tsinohiseha"],
            ],
        ],
        "to thank someone": [
            partOfSpeech: "v.t.",
            objectClass: "SG3AN",
            conjugations: [
                [subject: "SG3", habitual: "alihelitsehoi", imperative: "hiyalielitsisi", infinitive: "ulihelitsedi", present: "alihelitseha", remote_past: "ulihelitselvi"],
                [subject: "SG1", present: "tsiyalielitseha"],
            ],
        ],
        "to wait for someone or something": [
            partOfSpeech: "v.t.",
            objectClass: "SG3AN",
            conjugations: [
                [subject: "SG3", habitual: "agatidisgoi", imperative: "higatida", infinitive: "ugatidisdi", present: "aktiya", remote_past: "uktiy(v)dvi"],
                [subject: "SG1", present: "tsigatiya"],
            ],
        ],
        "to want": [
            partOfSpeech: "v.t.",
            objectClass: "SG3IN",
            conjugations: [
                [subject: "SG3", habitual: "agwadulihoi", imperative: "witsadula", infinitive: "udulvdi", present: "uduliha", remote_past: "agwadulihvi"],
                [subject: "SG1", present: "agwaduliha"],
            ],
        ],
        "to watch": [
            partOfSpeech: "v.t.",
            objectClass: "SG3IN",
            conjugations: [
                [subject: "SG3", habitual: "agasesdisgoi", imperative: "hagasesda", infinitive: "ugasesdodi", present: "uksesdi", remote_past: "ugasestanvi"],
                [subject: "SG1", present: "agwagasesdi"],
            ],
        ],
    ]
}
