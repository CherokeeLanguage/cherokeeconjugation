package net.cherokeedictionary.verb.metadata

/**
 * Registry initializer to be called at system boot.
 * Populates categories and overrides. -- tio 11Nov26
 *
 * tio 12Nov26: lookups happen by Cherokee root (verb.root = bare stem minus
 * tense ending, engine-computed; e.g. "gowati" for To See PRESENT). Seeds are
 * split by whether the root is verified:
 *
 *  - bridge(name, root, cats): root captured from a live engine conjugation
 *    (RootTrace, tio 12Nov26) -- data is re-keyed onto the root and the name
 *    resolves via VerbRegistry.resolveRoot.
 *  - pending(name, cats): English name only; registered under the name AND
 *    listed in VerbRegistry.unresolvedNames so the category audit can supply
 *    roots later. Missing data stays visible; nothing is silently dropped.
 *
 * RECHECK: roots are tense-stem-dependent (REMOTE_PAST of To See is "gohv",
 * not "gowati"). Today only PRESENT roots are bridged; cross-tense root
 * variants need seeding when overrides fire on non-present tenses.
 *
 * Audit findings for the pending categories: see CATEGORY_AUDIT.md in this
 * package (classificatory sets are lexical, wi- orientation already global).
 * -- tio 12Nov26
 */
class VerbRegistryInitializer {
    static void init() {
        println "DEBUG: VerbRegistryInitializer init()"
        VerbRegistry.clearOverrides() // Reset on init to avoid stale registrations
        bridge("to see", "gowati", [VerbCategory.NORMAL])
        bridge("to go", "e", [VerbCategory.MOTION])
        // tio 14Nov26: To Go Future Imperative/Volative SG1 override
        VerbRegistry.registerOverride("e", "FUTURE_IMPERATIVE_VOLATIVE", "ᎡᎵᏊᏍ ᏱᎨᏅᏒᎢ")
        bridge("to speak", "woni", [VerbCategory.NORMAL])
        bridge("to greet", "yoli", [VerbCategory.NORMAL])
        bridge("to hear", "advgi", [VerbCategory.NORMAL])
        bridge("to want", "aduli", [VerbCategory.IRREGULAR])
        bridge("to kill", "hi", [VerbCategory.NORMAL])
        bridge("to hit", "vni", [VerbCategory.NORMAL])
        // NOTE: "to have" is special-cased in the engine (empty root, fully
        // short-circuited); not bridgeable until root is non-empty.

        // tio 12Nov26: To Bite (book p.29) compound-prefix cells. The bite tables
        // print the dA-/dE-/dO- DISTRIBUTIVE variant the guide paradigms omit
        // (guide Notes on Paradigm Two: "forms in which de- indicates plurality
        // of the action of the verb are not given in this paradigm nor in
        // subsequent paradigms"; both variants occur, the book prints the
        // distributive one here), plus two outright cell differences. Keyed by
        // (combo, routed present stem ᏍᎦᎶᎦ "sgahlga") so To See's guide-cited
        // cells are untouched. Rows cited: book p.29 present-tense column.
        //  - SG2->SG1: "You (sing.) are biting me" ᏍᎩᏍᎦᎶᎦ (see: Ꮝ ᏍᎪᏩᏘᎭ -- the
        //    gi- object prefix is kept before the s-stem; see merges it into the
        //    g-stem Ꭺ).
        //  - SG2->PL3AN: "You (sing.) are biting them" ᏕᎯᏍᎦᎶᎦ (see: ᎦᎯ).
        //  - SG3->DL1INCL "…you and me" ᏕᎩᏂ (see: ᎩᏂ); SG3->DL1EXCL "…someone
        //    else and me" ᏙᎩᏂ (see: ᎣᎩᏂ); SG3->PL1INCL "…another (or others), me
        //    and you" ᏕᎩ (see: ᎢᎩ); SG3->PL1EXCL "…others and me" ᏙᎩ (see: ᎣᎩ);
        //    SG3->DL2 "…you (two)" ᏕᏍᏗ (see: ᏍᏗ); SG3->PL2 "…you (more than
        //    two)" ᏕᏥ (see: ᎢᏥ).
        //  - DL2->DL1EXCL ᏕᏍᎩᏂ (see: ᏍᎩᏂ); DL2->PL1EXCL ᏕᏍᎩ (see: ᎢᏍᎩ);
        //    DL2->PL3AN "…them" ᏕᏍᏗ (see: ᎨᏍᏗ).
        //  - PL2->SG3AN "You (more than two) are biting him/her" ᎡᏍᏗ (see: ᎡᏥ);
        //    PL2->DL1EXCL ᏕᏍᎩ (see: ᎢᏍᎩ); PL2->PL3AN ᏕᏥ (see: ᎨᏥ).
        //  - DL1EXCL->SG3IN "We (another and I) are biting it" ᏙᏍᏗ (see: ᎣᏍᏗ);
        //    DL1EXCL->DL2 "…you (two)" ᏕᏍᏛ (see: ᎪᏥ); DL1EXCL->PL2 "…you (more
        //    than two)" ᏕᏨ (see: ᎢᏨ); DL1EXCL->PL3AN "…them" ᏙᏍᏗ (see: ᎪᏍᏗ).
        //  - PL1EXCL->PL3AN "We (others and I) are biting them" ᏙᏥ (see: ᎪᏥ).
        //  - PL3 subject: book prefixes de-/da- on every 1st/2nd-person-object
        //    cell and on the animate 3rd-person cell: SG1 ᏕᎬᎩ, SG2 ᏕᎨᏣ,
        //    SG3AN ᏓᏂ (see: ᎠᏂ), DL1INCL ᏕᎨᎩᏂ, DL1EXCL ᏕᎪᎩᏂ, PL1INCL ᏕᎨᎩ,
        //    PL1EXCL ᏕᎪᎩ, DL2 ᏕᎨᏍᏗ, PL2 ᏕᎨᏥ. (PL3->SG3IN ᎠᏂ needs no
        //    override -- the book prints the non-distributive form there.)
        def BITE_STEM = "ᏍᎦᎶᎦ"
        [
            ["SG2SG1", "ᏍᎩ"], ["SG2PL3AN", "ᏕᎯ"],
            ["SG3DL1INCL", "ᏕᎩᏂ"], ["SG3DL1EXCL", "ᏙᎩᏂ"],
            ["SG3PL1INCL", "ᏕᎩ"], ["SG3PL1EXCL", "ᏙᎩ"],
            ["SG3DL2", "ᏕᏍᏗ"], ["SG3PL2", "ᏕᏥ"],
            ["DL2DL1EXCL", "ᏕᏍᎩᏂ"], ["DL2PL1EXCL", "ᏕᏍᎩ"], ["DL2PL3AN", "ᏕᏍᏗ"],
            ["PL2SG3AN", "ᎡᏍᏗ"], ["PL2DL1EXCL", "ᏕᏍᎩ"], ["PL2PL3AN", "ᏕᏥ"],
            ["DL1EXCLSG3IN", "ᏙᏍᏗ"], ["DL1EXCLDL2", "ᏕᏍᏛ"],
            ["DL1EXCLPL2", "ᏕᏨ"], ["DL1EXCLPL3AN", "ᏙᏍᏗ"],
            ["PL1EXCLPL3AN", "ᏙᏥ"],
            // (PL1INCL needs no override: the book's "them" row ᎨᏗᏍᎦᎶᎦ gedisgahlga
            // matches the shared table's PL1INCLPL3AN cell, and its "those
            // (things)" row ᏕᏗ is the table's PL1INCLPL3IN cell. -- tio 13Nov26)
            ["PL3SG1", "ᏕᎬᎩ"], ["PL3SG2", "ᏕᎨᏣ"], ["PL3SG3AN", "ᏓᏂ"],
            ["PL3DL1INCL", "ᏕᎨᎩᏂ"], ["PL3DL1EXCL", "ᏕᎪᎩᏂ"],
            ["PL3PL1INCL", "ᏕᎨᎩ"], ["PL3PL1EXCL", "ᏕᎪᎩ"],
            ["PL3DL2", "ᏕᎨᏍᏗ"], ["PL3PL2", "ᏕᎨᏥ"],
        ].each { combo, prefix ->
            VerbRegistry.registerCompoundOverride(combo, BITE_STEM, prefix)
        }

        // tio 12Nov26: To Bite Stem III i-syncope. The bite stem is -sgalits-
        // (dictionary row ᎤᏍᎦᎵᏨᎢ usgalitsv'i); in every COMPOSED past/future form
        // the book elides the stem's i before the ts+v'i/ts+i tail (SG1 remote
        // ᏥᏍᎦᎶᏨᎢ, future ᏓᏥᏍᎦᎶᏥ, FIV ᎯᏍᎦᎶᏨᎢ) while the sg3 citation row keeps it.
        // Lexeme-level allomorphy (guide preface: the vowel-dropping rules are
        // undetermined), registered by routed Stem III prefix; all bite past/
        // future stems start ᏍᎦᎵ (sgal-). See VerbRegistry.stemIIISyncopeStems.
        VerbRegistry.registerStemIIISyncope("ᏍᎦᎵ")

        // tio 12Nov26/15Nov26: To Bite FUTURE_IMPERATIVE_VOLATIVE sg3 row takes wa-
        // (book p.29 "Let him/her bite it" ᏩᏍᎦᎶᏨᎢ wasgaltsv'i). The guide's
        // w- section mandates w- for non-second-person "let" forms, but the
        // book itself is inconsistent: To See FIV sg3 prints a- ("Let him/her
        // see it" ᎠᎪᎲᎢ agohv'i, p.119) while its IMMEDIATE imperative sg3
        // prints wa- (ᏩᎪᏩᏔ). So wa- is verb-level here, registered per-verb
        // like the other bite cells. tio 15Nov26: previously two compound
        // overrides keyed on the POST-syncope Stem III (ᏍᎦᎶᏨᎢ sgalts-v'i);
        // now a verb-level registry flag keyed on present3rd (ᏍᎦᎶᎦ), which
        // survives syncope/stem-routing changes and covers SG3AN + SG3IN.
        VerbRegistry.registerFivSg3W(BITE_STEM)

        // tio 15Nov26: To See IMMEDIATE imperative/volative sg3 row takes wa-
        // (book p.119 "Let him/her see it right now!" ᏩᎪᏩᏔ wagohwahta), while
        // its FUTURE imperative/volative sg3 row takes a- (ᎠᎪᎲᎢ agohv'i) —
        // verb-level allomorphy the shared table cannot express. Keyed on the
        // bare present stem ᎪᏩᏘ (gowati), matched as a suffix of the
        // present3rd citation row ᎠᎪᏩᏘᎭ. See VerbRegistry.iivSg3WStems for
        // the wi-/wa- lexeme variance vs To Fall.
        VerbRegistry.registerIivSg3W("ᎪᏩᏘ")
        // tio 15Nov26: see and bite print ONE sg3 present row covering both
        // object readings (see ᎠᎪᏩᏘᎭ, bite ᎠᏍᎦᎶᎦ) — the PRESENT sg3AN
        // short-circuit returns the citation for them. To Hear composes ga-
        // instead (ᎠᎦᏛᎩᎠ) and is deliberately NOT registered.
        VerbRegistry.registerUnifiedSg3PresentRow("ᎪᏩᏘ")
        VerbRegistry.registerUnifiedSg3PresentRow(BITE_STEM)
        // tio 15Nov26: greet and kill likewise print ONE sg3 present row —
        // their sg3 citations ᎠᏲᎵᎭ / ᎠᎯᎭ ARE the sg3AN rows (ConjugatePresent-
        // Tense legacy assertions, "finished and good"); their vowel-initial
        // stems route the preVowel branch where the new non-unified composition
        // must not fire for them.
        VerbRegistry.registerUnifiedSg3PresentRow("ᎠᏲᎵᎭ")
        VerbRegistry.registerUnifiedSg3PresentRow("ᎠᎯᎭ")

        // tio 15Nov26: To See declarative Future (book p.119) — the two rows
        // are lexeme-specific surfaces (see VerbRegistry.subjectSurfaceOverrides).
        // SG1 "I will see it" ᏓᏥᎪᎢ datsigo'i; SG3 "He/she will see it" ᏛᎪᎯ dvgohi.
        VerbRegistry.registerSubjectSurface("ᎪᏩᏘ", "COMPLETIVE_FUTURE", "SG1", "ᏓᏥᎪᎢ")
        VerbRegistry.registerSubjectSurface("ᎪᏩᏘ", "COMPLETIVE_FUTURE", "SG3", "ᏛᎪᎯ")

        // tio 15Nov26: To Hear IMMEDIATE imperative/volative sg3 row takes wa-
        // (book p.64 "Let him/her hear it right now!" ᏩᏛᎬᎦ watvgvga), while
        // its FUTURE imperative/volative sg3 row takes a- (ᎠᏛᎦᏅᎢ atvganv'i).
        // tio 15Nov26: To Be Somewhere IMMEDIATE imperative/volative (book p.21).
        // The table prints verb-specific positional allomorphs for the stems:
        // SG1 geda, SG2 heda, SG3 weda (ᏪᏓ).
        // These are registered against the PRESENT stem "edoha" for lookup.
        VerbRegistry.registerSubjectSurface("edoha", "IMMEDIATE_COMMAND", "SG1", "ᎨᏓ")
        VerbRegistry.registerSubjectSurface("edoha", "IMMEDIATE_COMMAND", "SG2", "ᎮᏓ")
        VerbRegistry.registerSubjectSurface("edoha", "IMMEDIATE_COMMAND", "SG3", "ᏪᏓ")
        VerbRegistry.registerSubjectSurface("edoha", "IMMEDIATE_COMMAND", "DL2", "ᏍᏕᏓ")
        VerbRegistry.registerSubjectSurface("edoha", "IMMEDIATE_COMMAND", "PL2", "ᎢᏤᏓ")
        VerbRegistry.registerSubjectSurface("edoha", "IMMEDIATE_COMMAND", "DL1INCL", "ᎢᏁᏓ")
        VerbRegistry.registerSubjectSurface("edoha", "IMMEDIATE_COMMAND", "DL1EXCL", "ᏬᏍᏕᏓ")
        VerbRegistry.registerSubjectSurface("edoha", "IMMEDIATE_COMMAND", "PL1EXCL", "ᏬᏤᏓ")
        VerbRegistry.registerSubjectSurface("edoha", "IMMEDIATE_COMMAND", "PL1INCL", "ᎢᏕᏓ")
        VerbRegistry.registerSubjectSurface("edoha", "IMMEDIATE_COMMAND", "PL3", "ᏩᏁᏓ")

        // tio 15Nov26: To Hear PRESENT compound-prefix overrides (book p.64).
        // The a-branch normalization bakes the sg3 Ꭰ- into the routed present
        // stem ᎠᏛᎩᎠ, so these cells compose on the preVowel branch — the
        // override values use the preVowel encoding (syllabary head + single
        // Latin fusion letter) and Morphemes.fixPrefix consumes the stem's
        // leading Ꭰ while fusing: n+Ꭰ→Ꮎ, y+Ꭰ→Ꮿ, j+Ꭰ→Ꮳ.
        //   DL2+DL1EXCL "You (two) hear someone else and me" ᏕᏍᎩᎾᏛᎩᎠ
        //     desginatvgi'a — de- plural-object marking on the ᏍᎩ- cell
        //   DL2+PL1EXCL "You (two) hear others and me" ᏕᏍᎩᏯᏛᎩᎠ desgiyatvgi'a
        //   PL2+DL1EXCL "You (more than two) hear someone else and me"
        //     ᏕᏍᎩᎾᏛᎩᎠ desginatvgi'a (same cell shape as DL2+DL1EXCL)
        //   DL1EXCL+DL2 "We (another and I) hear you (two)" ᏍᏛᏯᏛᎩᎠ
        //     sdvyatvgi'a — the s- portmanteau before a 2nd-person object
        //   DL1EXCL+PL3IN "We (another and I) hear those (things)" ᏙᏣᏛᎩᎠ
        //     dotsatvgi'a — do- + ts- plural object
        //   PL1INCL+SG3AN "We (you and I and another or others) hear him/her"
        //     ᎣᏣᏛᎩᎠ otsatvgi'a
        //   PL1INCL+SG3IN "We (you and I and another or others) hear it"
        //     ᎣᏣᏛᎩᎠ otsatvgi'a (book prints the same cell for both readings)
        //   PL3+SG2 "They hear you (singular)" ᎨᏣᏛᎩᎠ getsatvgi'a
        // All keyed on the routed present stem ᎠᏛᎩᎠ so other verbs' cells
        // and hear's other tenses are untouched.
        def HEAR_PRESENT_STEM = "ᎠᏛᎩᎠ"
        VerbRegistry.registerCompoundOverride("DL2DL1EXCL", HEAR_PRESENT_STEM, "ᏕᏍᎩn")
        VerbRegistry.registerCompoundOverride("DL2PL1EXCL", HEAR_PRESENT_STEM, "ᏕᏍᎩy")
        VerbRegistry.registerCompoundOverride("PL2DL1EXCL", HEAR_PRESENT_STEM, "ᏕᏍᎩn")
        VerbRegistry.registerCompoundOverride("DL1EXCLDL2", HEAR_PRESENT_STEM, "ᏍᏛy")
        VerbRegistry.registerCompoundOverride("DL1EXCLPL3IN", HEAR_PRESENT_STEM, "Ꮩj")
        VerbRegistry.registerCompoundOverride("PL1INCLSG3AN", HEAR_PRESENT_STEM, "Ꭳj")
        VerbRegistry.registerCompoundOverride("PL1INCLSG3IN", HEAR_PRESENT_STEM, "Ꭳj")
        VerbRegistry.registerCompoundOverride("PL3SG2", HEAR_PRESENT_STEM, "Ꭸj")

        // tio 15Nov26: To Hear INFINITIVE SG1 "For me to hear it" ᎠᏆᏛᎪᏗ
        // agwatvgodi (book p.64) — Set B sg1 takes the w-form agw- before the
        // tv- initial stem (P7: "before v/h-initial stems Feeling prints the
        // w-forms"). The shared SG1SG3INB cell only carries the plain ᎠᎩ-
        // preConsonant, and the routed infinitive stem ᏛᎪᏗ is consonant-
        // initial so the preVowel Ꭰgw- twin never applies. Keyed on the routed
        // infinitive stem (ᏛᎪᏗ occurs only in the infinitive; the remote past
        // composes its agw- correctly through RuleUW on its own stem).
        VerbRegistry.registerCompoundOverride("SG1SG3INB", "ᏛᎪᏗ", "ᎠᏆ")

        // --- Categorization based on verb taxonomy audit -- tio 11Nov26 ---
        // pending: root not yet captured from the engine -- tio 12Nov26

        // Motion verbs
        ["arriving", "coming", "climbing", "crawling", "driving", "entering", "exiting",
         "going", "running", "walking", "swimming"].each { pending(it, VerbCategory.MOTION) }

        // Liquid Handling
        ["drink", "spilling", "pouring"].each { pending(it, VerbCategory.LIQUID_HANDLING) }

        // Solid Handling (Flexible/Neutral)
        ["bake", "cook", "cut", "slicing", "fry", "wash"].each { pending(it, VerbCategory.SOLID_HANDLING) }

        // State/Position
        ["lying", "standing", "sitting", "hang"].each { pending(it, VerbCategory.STATE) }
        pending("lying", VerbCategory.POSITION)
        pending("standing", VerbCategory.POSITION)
        pending("sitting", VerbCategory.POSITION)

        // Irregular verbs (as identified in guide/tests)
        ["have", "be"].each { pending(it, VerbCategory.IRREGULAR) }
        // ("go" and "want" were double-seeded IRREGULAR here; "want" is bridged
        //  above, "go" is pending as MOTION from the motion list -- tio 12Nov26)

        // tio 14Nov26: To Go Future Expected stem -es- (book p.37)
        VerbRegistry.registerOverride("e", "FUTURE_EXPECTED", "es")
    }

    /** Seed under the English name, then re-key onto the verified root. -- tio 12Nov26 */
    static void bridge(String name, String root, List<VerbCategory> categories) {
        for (VerbCategory category : categories) {
            VerbRegistry.addCategory(name, category)
        }
        VerbRegistry.registerVerbName(name, root)
    }

    /** Seed under the English name only; surfaced via VerbRegistry.unresolvedNames. -- tio 12Nov26 */
    static void pending(String name, VerbCategory category) {
        VerbRegistry.addCategory(name, category)
        VerbRegistry.markUnresolved(name)
    }
}
