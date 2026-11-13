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
        // --- Bridged verbs: root verified from the engine -- tio 12Nov26 ---
        bridge("to see", "gowati", [VerbCategory.NORMAL])
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

        // tio 12Nov26: To Bite FUTURE_IMPERATIVE_VOLATIVE sg3 row takes wa-
        // (book p.29 "Let him/her bite it" ᏩᏍᎦᎶᏨᎢ wasgaltsv'i). The guide's
        // w- section mandates w- for non-second-person "let" forms, but the
        // book itself is inconsistent: To See FIV sg3 prints a- ("Let him/her
        // see it" ᎠᎪᎲᎢ agohv'i, p.119) while its IMMEDIATE imperative sg3
        // prints wa- (ᏩᎪᏩᏔ). So wa- is verb-level here, registered per-verb
        // like the other bite cells. Keyed on the POST-syncope Stem III
        // (syncope runs before the compound lookup): ᏍᎦᎶᏨᎢ sgalts-v'i.
        VerbRegistry.registerCompoundOverride("SG3SG3IN", "ᏍᎦᎶᏨᎢ", "Ꮹ")
        VerbRegistry.registerCompoundOverride("SG3SG3AN", "ᏍᎦᎶᏨᎢ", "Ꮹ")

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
