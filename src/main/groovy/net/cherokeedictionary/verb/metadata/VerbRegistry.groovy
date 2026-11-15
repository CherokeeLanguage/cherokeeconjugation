package net.cherokeedictionary.verb.metadata

import net.cherokeedictionary.core.Verb
import net.cherokeedictionary.util.Tense
import net.cherokeedictionary.verb.rules.categorical.CategoricalRule
import net.cherokeedictionary.verb.rules.categorical.RuleFactory

/**
 * Registry for Verb specific overrides and categorizations.
 * 
 * Each verb can have multiple categories (mixin approach).
 * Default category is NORMAL if none are assigned.
 */
class VerbRegistry {
    static {
        VerbRegistryInitializer.init() // -- tio 11Nov26
    }
    // Map of root to list of categories
    private static final Map<String, List<VerbCategory>> verbCategories = [:]

    // Map of root to specific conjugation overrides
    private static final Map<String, Map<String, String>> verbOverrides = [:]

    // tio 12Nov26: per-verb compound-prefix overrides. Key = "<verbPrefix>|<routed
    // stem syllabary>" (e.g. "SG3DL1INCL|ᏍᎦᎶᎦ"), value = the preConsonant cell
    // to use instead of CompoundPrefixes. Needed because the verb book prints
    // verb-specific prefix cells for some person combos: the To Bite tables
    // (p.29) exercise the dA-/dE-/dO- DISTRIBUTIVE variant the guide paradigms
    // omit ("forms in which de- indicates plurality of the action of the verb
    // are not given in this paradigm nor in subsequent paradigms", guide Notes
    // on Paradigm Two), plus a few outright cell differences (SG2->SG1 ᏍᎩ vs
    // see's Ꮝ, PL2->SG3AN ᎡᏍᏗ vs ᎡᏥ). The routed stem in the key makes the
    // override tense-precise and verb-specific (stems are lexeme-unique), so
    // To See's guide-cited cells are untouched.
    private static final Map<String, String> compoundPrefixOverrides = [:]

    // tio 12Nov26: verbs whose -its/-is-class Stem III syncopates its i before
    // the ts+v'i / ts+i tail in composed past/future forms. Keyed by the routed
    // stem PREFIX (e.g. "ᏍᎦᎵ" for To Bite: stems ᏍᎦᎵᏨᎢ / ᏍᎦᎵᏥ), since roots are
    // tense-stem-dependent (RECHECK note above) but the Stem III is shared by
    // remote/future/FIV. Lexeme-level, NOT a global rule: "to be happy"
    // keeps its stem-final li before the identical tail (guide preface
    // disclaims the vowel-dropping rule). The sg3 + sg3-object REMOTE_PAST
    // citation row is excluded at the call site — it keeps the i for every verb.
    private static final Set<String> stemIIISyncopeStems = []

    // tio 12Nov26: the bridge. Categories/overrides are LOOKED UP by Cherokee
    // root (VerbConjugationProcessor sets verb.root = bare stem minus tense
    // ending, e.g. "gowati" for To See PRESENT), but the taxonomy seeds read
    // like the verb book (English names). nameIndex maps the English name to
    // its engine-verified root(s); registering a name re-keys anything already
    // filed under that English name onto the root so both views work.
    private static final Map<String, String> nameIndex = [:]

    // tio 12Nov26: English names seeded without a verified root. Kept visible
    // (project rule: missing data stays visible) until the category audit
    // supplies engine-verified roots -- never silently dropped.
    private static final List<String> unresolvedNames = []

    static void addCategory(String root, VerbCategory category) {
        if (!verbCategories.containsKey(root)) {
            verbCategories[root] = []
        }
        if (!verbCategories[root].contains(category)) {
            verbCategories[root].add(category)
        }
    }

    /** Indexes an English verb name to an engine-verified root and re-keys its data. -- tio 12Nov26 */
    static void registerVerbName(String englishName, String root) {
        if (!englishName || !root) return
        nameIndex[englishName.toLowerCase()] = root
        unresolvedNames.removeAll { it.equalsIgnoreCase(englishName) }
        // re-key anything seeded under the English name onto the root
        List<VerbCategory> cats = verbCategories[englishName]
        cats?.each { addCategory(root, it) }
        Map<String, String> overrides = verbOverrides[englishName]
        overrides?.each { tense, form -> registerOverride(root, tense, form) }
    }

    /** English name → Cherokee root, or null when not bridged. -- tio 12Nov26 */
    static String resolveRoot(String englishName) {
        return englishName ? nameIndex[englishName.toLowerCase()] : null
    }

    /**
     * True when this Cherokee root is bridged (has a verified English name).
     * Used by the stemmer's category report to accept an sg3-stripped root
     * variant ONLY on positive match -- never by blind stripping (the sg3
     * allomorph Ꭰ can be stem-initial, e.g. To Fish "asuhvs"). -- tio 12Nov26
     */
    static boolean isBridged(String root) {
        return root != null && nameIndex.containsValue(root)
    }

    /** Flags an English seed whose root is not yet engine-verified. -- tio 12Nov26 */
    static void markUnresolved(String englishName) {
        if (englishName && !unresolvedNames.contains(englishName)) {
            unresolvedNames << englishName
        }
    }

    /**
     * Read-only diagnostics: what the registry knows about a root. Used by the
     * stemmer's category report (Stemmer.getCategoryReport) so deconstruction
     * surfaces classification without touching any conjugation path.
     * -- tio 12Nov26
     */
    static String describe(String root) {
        List<VerbCategory> cats = getCategories(root)
        String name = nameIndex.find { it.value == root }?.key
        String shownRoot = root ? root : "<empty>"
        String shownName = name ? "'${name}'" : "<unbridged>"
        return "root=${shownRoot} name=${shownName} categories=${cats}"
    }

    /** Names still lacking a verified root; visible for the category audit. -- tio 12Nov26 */
    static List<String> getUnresolvedNames() {
        return new ArrayList(unresolvedNames)
    }

    static List<VerbCategory> getCategories(String root) {
        return verbCategories.getOrDefault(root, [VerbCategory.NORMAL])
    }

    static void registerOverride(String root, String tense, String conjugation) {
        if (!verbOverrides.containsKey(root)) {
            verbOverrides[root] = [:]
        }
        verbOverrides[root][tense] = conjugation
    }

    static String getOverride(String root, String tense) {
        if (root == null) return null
        return verbOverrides.get(root)?.get(tense)
    }

    /** Registers a per-verb compound-prefix cell override. -- tio 12Nov26 */
    static void registerCompoundOverride(String verbPrefix, String stem, String preConsonant) {
        compoundPrefixOverrides.put("${verbPrefix}|${stem}" as String, preConsonant)
    }

    /**
     * Per-verb compound-prefix cell override for this person combo + routed stem,
     * or null when the shared CompoundPrefixes cell applies. -- tio 12Nov26
     */
    static String getCompoundOverride(String verbPrefix, String stem) {
        if (!verbPrefix || !stem) return null
        return compoundPrefixOverrides.get("${verbPrefix}|${stem}" as String)
    }

    /** Registers a routed-stem prefix whose i syncopates in past/future forms. -- tio 12Nov26 */
    static void registerStemIIISyncope(String stemPrefix) {
        stemIIISyncopeStems.add(stemPrefix)
    }

    /** True when this routed stem belongs to an -its/-is-class Stem III. -- tio 12Nov26 */
    static boolean isStemIIISyncopeStem(String stem) {
        if (!stem) return false
        return stemIIISyncopeStems.find { stem.startsWith(it) } != null
    }

    // tio 15Nov26: verbs whose FUTURE_IMPERATIVE_VOLATIVE sg3 "let him/her" row
    // takes wa- instead of the default a-. Lexeme-level allomorphy: the guide's
    // w- section mandates w- for non-second-person "let" forms, but the book is
    // inconsistent — To See FIV sg3 prints a- (ᎠᎪᎲᎢ agohv'i, p.119) while To
    // Bite prints wa- (ᏩᏍᎦᎶᏨᎢ wasgaltsv'i, p.29). Keyed on the bare present
    // stem (e.g. To Bite ᏍᎦᎶᎦ, matched as a suffix of the present3rd citation
    // row ᎠᏍᎦᎶᎦ — see hasFivSg3W) so the flag survives Stem III surface
    // changes (syncope runs before this lookup — see processPrefixes) and
    // covers both SG3AN and SG3IN objects with one registration.
    private static final Set<String> fivSg3WStems = []

    /** Registers a verb (by present3rd stem) whose FIV sg3 row prints wa-. -- tio 15Nov26 */
    static void registerFivSg3W(String present3rd) {
        if (present3rd) fivSg3WStems.add(present3rd)
    }

    /** True when this verb's FUTURE_IMPERATIVE_VOLATIVE sg3 row prints wa-. -- tio 15Nov26 */
    static boolean hasFivSg3W(String present3rd) {
        if (!present3rd) return false
        // The bare present stem is matched INSIDE the present3rd citation row:
        // consonant stems may carry a baked sg3 Ꭰ- prefix (To Bite "asgahlga"
        // ᎠᏍᎦᎶᎦ) AND/OR a tense suffix after the stem (To See "agowtiha"
        // ᎠᎪᏩᏘᎭ = Ꭰ + ᎪᏩᏘ + -Ꭽ), so neither a whole-citation nor a
        // suffix match survives both shapes.
        return fivSg3WStems.find { present3rd.contains(it) } != null
    }

    // tio 15Nov26: IMMEDIATE imperative/volative sibling of the FIV flag. The
    // guide mandates w- for ALL non-second-person "let ... right now!" forms,
    // and the book confirms per verb — To See IIV sg3 "Let him/her see it
    // right now!" ᏩᎪᏩᏔ wagohwahta (p.119) — but the composed surface varies
    // lexeme-level: To Fall takes wi- (ᏫᎦᏅᎩ wiganvgi, from its sg3 citation
    // row) where To See takes wa-. Only verbs needing an explicit wa- override
    // are registered here; wi- from the citation needs no flag. See needs it
    // because its FIV sg3 is a- (ᎠᎪᎲᎢ) while its IIV sg3 is wa- — the two
    // volative tenses disagree, so one flag cannot cover both.
    private static final Set<String> iivSg3WStems = []

    /** Registers a verb (by present3rd stem) whose IIV sg3 row prints wa-. -- tio 15Nov26 */
    static void registerIivSg3W(String present3rd) {
        if (present3rd) iivSg3WStems.add(present3rd)
    }

    /** True when this verb's IMMEDIATE imperative/volative sg3 row prints wa-. -- tio 15Nov26 */
    static boolean hasIivSg3W(String present3rd) {
        if (!present3rd) return false
        // contained-in match, same rationale as hasFivSg3W above
        return iivSg3WStems.find { present3rd.contains(it) } != null
    }

    // tio 15Nov26: per-(verb, tense, subject) whole-form surface overrides.
    // The book prints lexeme-specific composed surfaces that no prefix/stem
    // composition derives AND that conflict between verbs: To See's future
    // SG1 is ᏓᏥᎪᎢ datsigo'i (Stem III -h- lenites to glottal ' before the
    // future -i) while its SG3 is ᏛᎪᎯ dvgohi (h kept; da + the sg3 a-
    // pronominal merges to dv-) — and bite's sg3 future composes BARE
    // (ᏓᏍᎦᎶᏥ, no a-), so no allomorph-scoped rule fits both. Keyed on the
    // present3rd stem (verb.root is not yet assigned when the processor
    // consults this), the engine Tense name, and the PrefixTableSubject name.
    private static final Map<String, String> subjectSurfaceOverrides = [:]

    /** Registers a whole-form surface for (present3rd stem, tense, subject). -- tio 15Nov26 */
    static void registerSubjectSurface(String present3rdStem, String tense, String subject, String form) {
        if (present3rdStem && tense && subject && form) {
            subjectSurfaceOverrides.put("${present3rdStem}|${tense}|${subject}" as String, form)
        }
    }

    /** Whole-form surface for this verb/tense/subject, or null to compose normally. -- tio 15Nov26 */
    static String getSubjectSurface(String present3rd, String tense, String subject) {
        if (!present3rd || !tense || !subject) return null
        // contained-in stem match, same rationale as hasFivSg3W above (the
        // citation row may carry a baked sg3 prefix and/or a tense suffix).
        return subjectSurfaceOverrides.find { key, val ->
            def parts = key.split("\\|")
            present3rd.contains(parts[0]) && parts[1] == tense && parts[2] == subject
        }?.value
    }

    // tio 15Nov26: verbs whose book prints ONE sg3 PRESENT row covering both
    // object readings (To See p.118 "He/she sees him/her" AND "He/she sees it"
    // are both ᎠᎪᏩᏘᎭ; To Bite "S/he is biting him/her"/"it" both ᎠᏍᎦᎶᎦ). For
    // these the present3rd citation IS the sg3AN row too, so the PRESENT sg3
    // short-circuit returns it for SG3SG3AN. Verbs NOT registered here (To
    // Hear p.64: "S/he hears him/her" ᎠᎦᏛᎩᎠ vs "it" ᎠᏛᎩᎠ) compose the ga-
    // compound instead — keyed on the present3rd stem, contained-in matched.
    private static final Set<String> unifiedSg3PresentStems = []

    /** Registers a verb whose single sg3 present row covers both object readings. -- tio 15Nov26 */
    static void registerUnifiedSg3PresentRow(String present3rd) {
        if (present3rd) unifiedSg3PresentStems.add(present3rd)
    }

    /** True when the sg3 present citation covers the SG3AN object reading too. -- tio 15Nov26 */
    static boolean hasUnifiedSg3PresentRow(String present3rd) {
        if (!present3rd) return false
        return unifiedSg3PresentStems.find { present3rd.contains(it) } != null
    }

    // tio 15Nov26: the generic IIV/FIV w-insertion triggers (vowel-initial
    // composed imperative forms) are lexeme-gated. The a-branch normalization
    // bakes a leading Ꭰ into hear-like stems, and the triggers then fired for
    // EVERY such row, mangling the book's h-/w- cells (To Hear IIV sg2
    // ᎭᏛᎬᎦ came out ᏩᏛᎬᎦ). Empirically no wired verb needs them (fall, bite,
    // see, go, somewhere, hear all compose correctly without), so the registry
    // is empty and both triggers stay inert until a future verb registers.
    private static final Set<String> wiInsertionStems = []

    /** Registers a verb whose composed vowel-initial imperative rows take wi-. -- tio 15Nov26 */
    static void registerWiInsertionTrigger(String present3rd) {
        if (present3rd) wiInsertionStems.add(present3rd)
    }

    /** True when this verb's composed imperative forms take the wi- initial prefix. -- tio 15Nov26 */
    static boolean hasWiInsertionTrigger(String present3rd) {
        if (!present3rd) return false
        return wiInsertionStems.find { present3rd.contains(it) } != null
    }

    // Iterates through categories and applies rules
    static String applyCategoricalRules(Verb verb, String conjugation, Tense tense) {
        if (verb == null) {
            return conjugation
        }
        
        String result = conjugation
        def rootsToTry = [verb.root]
        if (verb.root == null && verb.verbset == net.cherokeedictionary.util.VerbSet.A) {
            // fallback for MotionRule and others that might be hardcoded to English name
            // until all roots are properly indexed.
            if (verb.stemmer?.present3rd?.syllabary?.startsWith("Ꭱ")) {
                rootsToTry << "e"
            }
        }
        if (verb.stemmer?.present3rd?.syllabary == "ᎡᎦ") {
             rootsToTry << "e"
        }

        for (String root : rootsToTry) {
            if (root == null) continue
            for (VerbCategory category : getCategories(root)) {
                CategoricalRule rule = RuleFactory.getRule(category)
                if (rule) {
                    result = rule.apply(verb, result, tense)
                }
            }
        }
        return result
    }
}
