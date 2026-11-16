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
                [subject: "SG3", habitual: "edohoi", imperative: "geda", infinitive: "uwedasdi", present: "edoha", remote_past: "edohvi", immediate_imperative: "geda", immediate_past: "edoha"],
                [subject: "SG1", present: "gedoha"],
            ],
        ],
        "to be thankful or happy": [
            partOfSpeech: "v.t.",
            objectClass: "SG3AN",
            conjugations: [
                [subject: "SG3", habitual: "aliheligoi", imperative: "galieligi", infinitive: "ulihelisdi", present: "aliheliga", remote_past: "ulihelitsvi", immediate_past: "aliheligi"],
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
                [subject: "SG3", habitual: "anegoi", imperative: "gena", infinitive: "uwenvsdi", present: "ega", remote_past: "uwenvsvi", immediate_past: "ena"],
                [subject: "SG1", present: "gega"],
            ],
        ],
        "to have (a living being)": [
            partOfSpeech: "v.t.",
            objectClass: "SG3AN",
            conjugations: [
                // tio 16Nov26: habitual/remote-past/infinitive/imperative rows
                // transcribed from the animate-have paradigm (2012 VRB yaml
                // "Have (living)" agi- row; cedEntries.csv id 73986 agrees on
                // the -hOi/-hvi pattern). The book's "To Have (a living being)"
                // page (Cherokee Verb Conjugations pp.42-43) prints ONLY Stem I
                // and notes the verb alternates a-/consonant onsets and "is
                // probably easiest to learn this as an irregular verb" — no
                // Stem IV is printed for it. immediate_past therefore follows
                // the Stem IV = Stem III pattern the book itself prints on all
                // three sibling have-something pages (long-rigid p.44
                // "-vy-v'i" immediate = "-vy-v'i" remote; flexible "-na'-v'i";
                // liquid "unehv'i"), i.e. the remote-past surface agikahvi.
                [subject: "SG3", habitual: "agikahoi", imperative: "agikahesdi", infinitive: "agikohdi", present: "agikaha", remote_past: "agikahvi", immediate_past: "agikahvi"],
                [subject: "SG1", present: "gvyakaha"],
            ],
        ],
        "to have something flexible": [
            partOfSpeech: "v.t.",
            objectClass: "SG3IN",
            conjugations: [
                // tio 16Nov26: citations reduced to the bare SG3IN reading — the
                // old entries carried english fragments and "/"-joined dual
                // readings ("unaa/dunaa"), which tsalagiToSyllabary turned into
                // invalid-letter garbage and nulled the infinitive composition.
                // Every printed row (both readings, all tenses) is registered as
                // a VerbRegistry subject-surface override keyed on "ᎤᎾᎠ", so the
                // engine consults the book surface directly.
                [subject: "SG3", habitual: "unaoi", imperative: "aginaesdi", infinitive: "unvdi", present: "unaa", remote_past: "unavi", immediate_past: "unavi"],
                [subject: "SG1", present: "aginaa"],
            ],
        ],
        "to have something liquid, in a container": [
            partOfSpeech: "v.t.",
            objectClass: "SG3IN",
            conjugations: [
                [subject: "SG3", habitual: "He/she/it has multiple liquid things\" unehoi/dunehoi", imperative: "aginehesdi/daginehesdi", infinitive: "uditasdi/tsuditasdi", present: "He/she/it has multiple liquid things\" uneha/duneha", remote_past: "He/she/it had multiple liquid things\" unehvi/dunehvi", immediate_past: "unehvi"],
                [subject: "SG1", present: "I have multiple liquid things\" agineha/dagineha"],
            ],
        ],
        "to have something long and rigid, like a stick, a shovel, etc.": [
            partOfSpeech: "v.t.",
            objectClass: "SG3IN",
            conjugations: [
                [subject: "SG3", habitual: "uwayoi/duwayoi", imperative: "agwvyesdi/dagwvyesdi", infinitive: "uwayi iyulisdodi", present: "uwaya/duwaya", remote_past: "uwayvi/duwayvi", immediate_past: "uwayvi"],
                [subject: "SG1", present: "I have multiple long & rigid things\" agwvya/dagwvya"],
            ],
        ],
        "to hear": [
            // tio 15Nov26: citations corrected to the book's THIRD SINGULAR forms
            // (the old "gatvgisgoi"/"agwatvganvi" were the SG1 rows — the sg3
            // habitual short-circuit prints the citation verbatim, so an sg1-
            // baked citation produced ᎦᏛᎩᏍᎪᎢ for "S/he hears it (habitually)",
            // and the sg1 agw- baked into the remote past doubled into
            // ᎠᏆᏆᏛᎦᏅᎢ when the engine composed the sg1 agw- again). Immediate
            // past ᎠᏛᎬᎦ atvgvga added (book p.64 "S/he heard it, just now").
            partOfSpeech: "v.t.",
            objectClass: "SG3AN",
            conjugations: [
                [subject: "SG3", habitual: "atvgisgoi", imperative: "hatvgvga", infinitive: "utvgodi", present: "atvgia", remote_past: "utvganvi", immediate_past: "atvgvga"],
                [subject: "SG1", present: "gatvgia"],
            ],
        ],
        "to help": [
            partOfSpeech: "v.t.",
            objectClass: "SG3AN",
            conjugations: [
                // tio 16Nov26: citations corrected to the book's THIRD SINGULAR
                // rows (ToHear precedent — the old habitual/remote_past entries
                // were the SG1 rows, so the sg3 short-circuits printed ᏥᏍᏕ-).
                [subject: "SG3", habitual: "asdelisgoi", imperative: "hisdela", infinitive: "usdelvdi", present: "asdeliha", remote_past: "usdelvhvi", immediate_past: "asdela"],
                [subject: "SG1", present: "tsisdeliha"],
            ],
        ],
        "to hide someone or something": [
            partOfSpeech: "v.t.",
            objectClass: "SG3IN",
            conjugations: [
                [subject: "SG3", habitual: "gvsgahlvsgoi", imperative: "hvsgatlvga", infinitive: "uwasgalvdi", present: "gvsgahlvsga", remote_past: "uwasgahlanvi", immediate_past: "gvsgatlvga"],
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
                [subject: "SG3", habitual: "galvkwdisgoi", imperative: "hilvkwda", infinitive: "ulvkwdodi", present: "galvkwdiha", remote_past: "ulvkwtanvi", immediate_past: "galvkwda"],
                [subject: "SG1", present: "tsilvkwdiha"],
            ],
        ],
        "to kill someone or something": [
            partOfSpeech: "v.t.",
            objectClass: "SG3AN",
            conjugations: [
                [subject: "SG3", habitual: "ahihoi", imperative: "hiluga", infinitive: "uhisdi", present: "ahiha", remote_past: "utlvi", immediate_past: "galuga"],
                [subject: "SG1", present: "tsiiha"],
            ],
        ],
        "to like someone or something": [
            partOfSpeech: "v.t.",
            objectClass: "SG3IN",
            conjugations: [
                [subject: "SG3", habitual: "ulvkwdoi", imperative: "hilvkwda", infinitive: "ulvkwdodi", present: "ulvkwdi", remote_past: "ulvkwdvi", immediate_past: "ulvkwdi"],
                [subject: "SG1", present: "agilvkwdi"],
            ],
        ],
        "to look for": [
            partOfSpeech: "v.t.",
            objectClass: "SG3IN",
            conjugations: [
                [subject: "SG3", habitual: "agiyohoi", imperative: "tsayoga", infinitive: "uyosdi (uysdi)", present: "uhyoha", remote_past: "agiyolvi", immediate_past: "uyoga"],
                [subject: "SG1", present: "agiyoha"],
            ],
        ],
        "to love": [
            partOfSpeech: "v.t.",
            objectClass: "SG3IN",
            conjugations: [
                [subject: "SG3", habitual: "ugeyusoi", imperative: "tsageyuhvga", infinitive: "ugeyhdi", present: "ugeyuha", remote_past: "ugeyusvi", immediate_past: "ugeyuhvga"],
                [subject: "SG1", present: "agigeyuha"],
            ],
        ],
        "to point something out": [
            partOfSpeech: "v.t.",
            objectClass: "SG3AN",
            conjugations: [
                [subject: "SG3", habitual: "asehehoi", imperative: "hiyasehisi", infinitive: "usehehdi", present: "agwaseheha", remote_past: "usehelvi", immediate_past: "asehisi"],
                [subject: "SG1", present: "gvyaseheha"],
            ],
        ],
        "to remember": [
            partOfSpeech: "v.t.",
            objectClass: "SG3AN",
            conjugations: [
                [subject: "SG3", habitual: "ganvdadisgoi", imperative: "hanvdada", infinitive: "unvdadisdi", present: "anhdadia", remote_past: "agwanvdadvi", immediate_past: "anvdada"],
                [subject: "SG1", present: "ganvdadia"],
            ],
        ],
        "to see": [
            // tio 15Nov26: immediate_past added (book p.118 "I saw it just now"
            // ᏥᎪᏩᏘᎭ tsigowatiha / "He/she saw it just now" ᎠᎪᏩᏘᎭ agowatiha).
            // The book's printed SYLLABARY for this verb's immediate past is the
            // present-stem composition (identical glyphs to the present rows);
            // its romanized column prints "tsigohwahta" (Stem IV), but the
            // engine-vs-book comparison targets the printed syllabary. Without
            // this stem the IMMEDIATE_PAST sg3 short-circuit is skipped and
            // composition falls back to the imperative stem (ᏥᎪᏩᏔ).
            partOfSpeech: "v.t.",
            objectClass: "SG3AN",
            conjugations: [
                [subject: "SG3", habitual: "agowtisgoi", imperative: "higohwahta", infinitive: "ugowtvhdi", present: "agowtiha", remote_past: "ugohvi", immediate_past: "agowtiha"],
                [subject: "SG1", present: "tsigowtiha"],
            ],
        ],
        "to stop someone or something": [
            partOfSpeech: "v.t.",
            objectClass: "SG3AN",
            conjugations: [
                [subject: "SG3", habitual: "galehwisdodisgoi", imperative: "halehwisdoda", infinitive: "ulehwisdododi", present: "alehwisdodiha", remote_past: "ulehwisdotanvi", immediate_past: "alehwisdoda"],
                [subject: "SG1", present: "galehwisdodiha"],
            ],
        ],
        "to talk to someone": [
            partOfSpeech: "v.t.",
            objectClass: "SG3AN",
            conjugations: [
                [subject: "SG3", habitual: "ahlinohedisgoi", imperative: "hihlinoheda", infinitive: "tsilinohedodi", present: "ahlinohediha", remote_past: "atsihlinohetlvi", immediate_past: "ahlinoheda"],
                [subject: "SG1", present: "galinohediha"],
            ],
        ],
        "to teach someone": [
            partOfSpeech: "v.t.",
            objectClass: "SG3IN",
            conjugations: [
                [subject: "SG3", habitual: "tsiyeyohvsgoi", imperative: "tiyeyohvga", infinitive: "tsudeyodi", present: "dadeyohvsga", remote_past: "dagwadeyohnvi", immediate_past: "dadeyohvga"],
                [subject: "SG1", present: "degadeyohvsga"],
            ],
        ],
        "to tell something to someone": [
            partOfSpeech: "v.t.",
            objectClass: "SG3IN",
            conjugations: [
                [subject: "SG3", habitual: "tsinohisehoi", imperative: "hinohisi", infinitive: "unohisedi", present: "kanohiseha", remote_past: "tsinohiselvi", immediate_past: "kanohisi"],
                [subject: "SG1", present: "tsinohiseha"],
            ],
        ],
        "to thank someone": [
            partOfSpeech: "v.t.",
            objectClass: "SG3AN",
            conjugations: [
                [subject: "SG3", habitual: "alihelitsehoi", imperative: "hiyalielitsisi", infinitive: "ulihelitsedi", present: "alihelitseha", remote_past: "ulihelitselvi", immediate_past: "alihelitsisi"],
                [subject: "SG1", present: "tsiyalielitseha"],
            ],
        ],
        "to wait for someone or something": [
            partOfSpeech: "v.t.",
            objectClass: "SG3AN",
            conjugations: [
                [subject: "SG3", habitual: "agatidisgoi", imperative: "higatida", infinitive: "ugatidisdi", present: "aktiya", remote_past: "uktiy(v)dvi", immediate_past: "agatida"],
                [subject: "SG1", present: "tsigatiya"],
            ],
        ],
        "to want": [
            partOfSpeech: "v.t.",
            objectClass: "SG3IN",
            conjugations: [
                [subject: "SG3", habitual: "agwadulihoi", imperative: "witsadula", infinitive: "udulvdi", present: "uduliha", remote_past: "agwadulihvi", immediate_past: "udula"],
                [subject: "SG1", present: "agwaduliha"],
            ],
        ],
        "to watch": [
            partOfSpeech: "v.t.",
            objectClass: "SG3IN",
            conjugations: [
                [subject: "SG3", habitual: "agasesdisgoi", imperative: "hagasesda", infinitive: "ugasesdodi", present: "uksesdi", remote_past: "ugasestanvi", immediate_past: "agasesda"],
                [subject: "SG1", present: "agwagasesdi"],
            ],
        ],
    ]
}
