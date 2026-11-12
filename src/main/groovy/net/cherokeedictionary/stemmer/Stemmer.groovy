package net.cherokeedictionary.stemmer


import net.cherokeedictionary.stem.NormalizedVerbEntry
import net.cherokeedictionary.stem.StemEntry
import net.cherokeedictionary.stem.StemType
import net.cherokeedictionary.stem.Syllabary
import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import net.cherokeedictionary.verb.metadata.VerbRegistry
import net.cherokeedictionary.verb.suffixes.Future
import net.cherokeedictionary.verb.suffixes.FutureExpected
import net.cherokeedictionary.verb.suffixes.FutureImperativeVolative
import net.cherokeedictionary.verb.suffixes.FutureProgressive
import net.cherokeedictionary.verb.suffixes.Habitual
import net.cherokeedictionary.verb.suffixes.ImmediatePast
import net.cherokeedictionary.verb.suffixes.Infinitive
import net.cherokeedictionary.verb.suffixes.Present
import net.cherokeedictionary.verb.suffixes.ProgressivePast
import net.cherokeedictionary.verb.suffixes.RecentPastImperative
import net.cherokeedictionary.verb.suffixes.RemotePast
import org.apache.commons.lang3.StringUtils

/**
 * Created by torr on 8/16/2015.
 */
public class Stemmer {
    public DefinitionLine present3rd = null;
    public DefinitionLine present1st = null;
    public DefinitionLine remotepast = null;
    public DefinitionLine immediatepast = null;
    public DefinitionLine habitual = null;
    public DefinitionLine imperative = null;
    public DefinitionLine infinitive = null;
    public String rootValue = ""

    /**
     * E: when getStems() finds no normalization method for the dictionary
     * entry, the failure is recorded here (instead of silently returning an
     * empty stem list) so callers can surface it. Empty when normalization
     * succeeded or when the entry has no data at all.
     */
    public String normalizationFailure = "";

    /**
     * tio 12Nov26: WI-33 — set by getStems() when the dictionary entry showed
     * the sg3 da-+u- fusion (present3rd starting with Ꮪ, e.g. To Work
     * ᏚᎸᏫᏍᏓᏁᎰᎢ dulvhwisdaneho'i): removeᏕprefix rewrites Ꮪ → Ꭴ, and the fused
     * da- initial prefix must be re-declared at composition time so it
     * surfaces again (ᎤᎸ... → ᏚᎸ...; ᏫᏚᎸ... with wi-). Read by
     * Conjugate.conjugate, gated to SG3 single-object conjugations —
     * PL3-object du- forms carry their own d- in the compound-prefix table
     * ("He/she likes them" ᏚᎸᏉᏗ), and declaring da there would double it.
     */
    public boolean normalizedDaInitialPrefix = false;

    /**
     * tio 12Nov26: WI-35 — the printed sg3-subject dative-benefactive present
     * surface, when the verb has one attested (el flag set). Montgomery-Anderson
     * Table 14.1 (Cherokee Reference Grammar, p.400): the applicative attaches
     * to the Completive stem and its Present Continuous form is -eéha, so the
     * -ᏁᎭ tail is the Completive stem's own final -n plus the APL vowel — not a
     * freely insertable suffix. Pulte/Feeling's -el- rules (guide pp.286:
     * -el-/-eh-/-eha) cover -s- stems (speak wonihis-e-ha (41)), but vowel/other
     * stems surface verb-specific shapes (write -oohweélaan- + -eéha =
     * ᎪᏪᎳᏁᎭ; cf. give a-hne-ha (42), buy a-hwahis-e-ha (43)). Reading:
     * ᎪᏪᎳᏁᎭ = g + ohweélaan + eéha → printed gohwela-neha (guide ex. 35a).
     * Composed: PL3-object cells prepend the plural-object Ꮥ (35a ᏕᎪᏪᎳᏁᎭ);
     * with wi- the de- surfaces as Ꮧ after w- (Feeling rule: "after w-, de =
     * di"), giving 35b ᏫᏗᎪᏪᎳᏁᎭ. Null when unattested — verbs without it keep
     * the generic NonFinalSuffixEl machinery.
     */
    public DefinitionLine dativePresent = null;

    public static final String SG3_ALLOMORPH_A = "A"
    public static final String SG3_ALLOMORPH_G = "G"
    public static final String SG3_ALLOMORPH_U = "U"
    public static final String SG3_ALLOMORPH_OTHER = "OTHER"

    public String sg3Allomorph() {
        if (present3rd == null || present3rd.syllabary == null || present3rd.syllabary.isEmpty()) {
            return SG3_ALLOMORPH_OTHER
        }
        String s = present3rd.syllabary
        if (s.startsWith('Ꭰ')) return SG3_ALLOMORPH_A
        if (s.startsWith('Ꭶ') || s.startsWith('Ꭷ')) return SG3_ALLOMORPH_G
        if (s.startsWith('Ꭴ') || s.startsWith('Ꮪ')) return SG3_ALLOMORPH_U
        return SG3_ALLOMORPH_OTHER
    }

    String getRoot(Tense type) {
        return getRootWithEnding(type)[0]
    }

    /**
     * Read-only deconstruction diagnostic: reports what the VerbRegistry knows
     * about this stemmer's root (bridged English name, categories). Never
     * mutates state and never participates in conjugation.
     *
     * tio 12Nov26: dictionary present3rd rows carry the sg3 pronominal
     * (ᎠᎪᏩᏘᎭ = a- + gowatiha → root "agowati") while the registry is keyed
     * by the engine's composed-and-stripped root ("gowati"). This report tries
     * the raw root first; only if it is unbridged AND stripping the entry's
     * own sg3 allomorph (sg3Allomorph()) yields a POSITIVELY bridged root does
     * it report the stripped variant (visible in the report). Blind stripping
     * is forbidden -- Ꭰ can be stem-initial (To Fish "asuhvs"). Full
     * prefix-stripping deconstruction remains the eventual proper fix.
     * Missing stems degrade to "<empty>".
     */
    String getCategoryReport(Tense type) {
        String root
        try {
            root = getRoot(type)
        } catch (Exception ignored) {
            // deconstruction diagnostics must never throw into caller code
            root = null
        }
        if (!root) {
            return VerbRegistry.describe(null)
        }
        if (!VerbRegistry.isBridged(root)) {
            String variant = sg3StrippedRoot(root)
            if (variant && VerbRegistry.isBridged(variant)) {
                return VerbRegistry.describe(variant) + " (via sg3-stripped '${root}')"
            }
        }
        return VerbRegistry.describe(root)
    }

    /** sg3-pronominal candidate variant of a raw stemmer root, or null. -- tio 12Nov26 */
    String sg3StrippedRoot(String root) {
        switch (sg3Allomorph()) {
            case SG3_ALLOMORPH_A:
                return root.startsWith("a") ? root.substring(1) : null
            case SG3_ALLOMORPH_G:
                if (root.startsWith("ga")) return root.substring(2)
                if (root.startsWith("ka")) return root.substring(2)
                return null
            case SG3_ALLOMORPH_U:
                if (root.startsWith("u")) return root.substring(1)
                if (root.startsWith("du")) return root.substring(2)
                return null
            default:
                return null
        }
    }

    String[] getRootWithEnding(Tense type) {
        String stem = SyllabaryUtil.parseSyllabary(getStem(type))
        String root = ""

        def suffix

        //TODO: finish breaking these apart by the rest of the conjugations and then checking for completeness.
        //      also decide what to do with the split and how to put it into the word
        switch (type) {
            case Tense.REMOTE_PAST:
                suffix = new RemotePast()
                break

            case Tense.PROGRESSIVE_PAST:
                // past progressive: non-final -g- (NonFinalSuffixG) + the past suffix -v'i
                suffix = new ProgressivePast()
                break

            case Tense.HABITUAL:
                suffix = new Habitual()
                break
            case Tense.FUTURE_COMMAND:
                // Future Imperative/Volative: -v'i, "Speak (later)" (grammar guide ex. 112b)
                suffix = new FutureImperativeVolative()
                break
            case Tense.PROGRESSIVE_FUTURE:
                // future progressive: -esdi, "will be doing" (grammar guide ex. 93)
                suffix = new FutureProgressive()
                break
            case Tense.COMPLETIVE_FUTURE:
            case Tense.COMPLETED_FUTURE:
            case Tense.FUTURE_EXPECTED:
                // declarative future: -i (FUTURE_EXPECTED additionally takes the de- initial prefix, Stem II)
                suffix = new Future()
                break
            case Tense.IMMEDIATE_PAST:
                // verb book Immediate Past (Stem IV): recent past, "-i" as printed (with "-a" variants)
                suffix = new ImmediatePast()
                break
            case Tense.IMMEDIATE_COMMAND:
            case Tense.RECENT_PAST_IMPERATIVE:
                // grammar guide: "-a, present, recent past imperative"; the "-i" imperative is a variant of "-a"
                suffix = new RecentPastImperative()
                break
            case Tense.INFINITIVE:
                suffix = new Infinitive()
                break
            case Tense.PRESENT:
            default:
                suffix = new Present()
                break
        }

        def lastChar = null
        // Some tense classes print more than one final suffix (the recent past is
        // printed "-i" or "-a"); prefer the variant that actually terminates the stem.
        def finalSuffixes = suffix.hasProperty('finalSuffixVariants') ? suffix.finalSuffixVariants : [suffix.finalSuffix]
        int idx = -1
        String used = null
        if (finalSuffixes.size() == 1) {
            used = finalSuffixes[0]
            idx = stem.lastIndexOf(used)
        } else {
            for (String variant : finalSuffixes) {
                if (stem.endsWith(variant)) { used = variant; idx = stem.size() - variant.size(); break }
            }
        }
        if (stem.size() > 0 && idx >= 0) {
            // the word minus the ending
            root = stem.substring(0, idx)
            if (!root) {
                // E: the whole stem matched the final suffix (e.g. ᎠᎢ "he's
                // walking"); there is no root to extract -- report the failure
                // instead of crashing on charAt(-1).
                return [null, null]
            }
            // get the last letter to determine which end of the word it is
            lastChar = String.valueOf(root.charAt(root.size() - 1))

            // see if the last character is in the value list
            if (suffix.getRootEndings().containsValue(lastChar)) {
                // if it is then the root is now minus the last character
                root = root.substring(0, root.size() - 1)

//            // printing the result so we know what the root plus the final root ending is before we add other parts to the verb
//            println "what it be " + root + lastChar
            }
        } else {
            root = null
        }

        return [root, lastChar]
    }

    String getStem(Tense tense) {
        def returnValue = ""
        getStems().each {
            if (compareTypeAndTense(it.stemtype, tense)) {
//            if (it.stemtype == type) {
                returnValue = it.syllabary
            }
        }

        return returnValue
    }

    // Stem mappings per the verb book's grammatical introduction (printed pp.167–176):
    //   - Stem I (PresentContinous):  Present; also the base for the progressive tenses
    //     (grammar guide: non-final -g- + -v'i / -esdi).
    //   - Stem II (Habitual):         Present Habitual ("the Present Habitual is usually
    //     Stem II", To Go NB).
    //   - Stem III (RemotePast):      Remote Past, the declarative Future and Future
    //     Imperative/Volative — "NB: the Future is usually Stem III" (To Go), and every
    //     printed Future Imperative/Volative row is Stem III + -v'i (usually identical to
    //     the Remote Past row) or Stem III + -esdi.
    //   - Stem IV (Immediate):        Immediate Past, Immediate Imperative/Volative and the
    //     recent-past imperative (same stem; the book prints them under Stem IV).
    //   - Stem V (Deverbal):          Infinitive.
    //   FUTURE_EXPECTED has no dictionary stem: the book prints it only for To Go, built
    //   from To Go's Stem II (-e-s-), while To Go's habitual entry is Stem I (-e-g-), so
    //   it cannot be derived from the five dictionary stems (documented limitation;
    //   VerbTenseHolder routes it to the Stem III-derived future form). -- timo 10Nov26

    boolean compareTypeAndTense(StemType type, Tense tense) {
        return (type == StemType.PresentContinous
                && (tense == Tense.PRESENT
                    || tense == Tense.PROGRESSIVE_PAST
                    || tense == Tense.PROGRESSIVE_FUTURE)
                || (type == StemType.RemotePast
                    && (tense == Tense.REMOTE_PAST
                        || tense == Tense.COMPLETIVE_FUTURE
                        || tense == Tense.COMPLETED_FUTURE
                        || tense == Tense.FUTURE_COMMAND))
                || (type == StemType.Immediate
                    && (tense == Tense.IMMEDIATE_COMMAND
                        || tense == Tense.IMMEDIATE_PAST
                        || tense == Tense.RECENT_PAST_IMPERATIVE))
                || (type == StemType.Habitual && tense == Tense.HABITUAL)
                || (type == StemType.Deverbal && tense == Tense.INFINITIVE))
    }

    List<StemEntry> getStems() {
        NormalizedVerbEntry e = new NormalizedVerbEntry();

        if (present3rd != null && present3rd.syllabary != null) {
            e.pres3 = StringUtils.strip(present3rd.syllabary);
            if (e.pres3.contains(",")) {
                e.pres3 = StringUtils.substringBefore(e.pres3, ",");
                e.pres3 = StringUtils.strip(e.pres3);
            }
        } else {
            e.pres3 = ""
        }
        if (present1st && present1st.syllabary) {
            e.pres1 = StringUtils.strip(present1st.syllabary);
            if (e.pres1.contains(",")) {
                e.pres1 = StringUtils.substringAfterLast(e.pres1, ",");
                e.pres1 = StringUtils.strip(e.pres1);
            }
        } else {
            e.pres1 = ""
        }

        if (remotepast && remotepast.syllabary) {
            e.past = StringUtils.strip(remotepast.syllabary);
            if (e.past.contains(",")) {
                e.past = StringUtils.substringBefore(e.past, ",");
                e.past = StringUtils.strip(e.past);
            }
        } else {
            e.past = ""
        }

        if (immediatepast && immediatepast.syllabary) {
            e.imm = StringUtils.strip(immediatepast.syllabary);
            if (e.imm.contains(",")) {
                e.imm = StringUtils.substringBefore(e.imm, ",");
                e.imm = StringUtils.strip(e.imm);
            }
        } else {
            e.imm = ""
        }

        if (habitual && habitual.syllabary) {
            e.habit = StringUtils.strip(habitual.syllabary);
            if (e.habit.contains(",")) {
                e.habit = StringUtils.substringBefore(e.habit, ",");
                e.habit = StringUtils.strip(e.habit);
            }
        } else {
            e.habit = ""
        }

        if (imperative && imperative.syllabary) {
            e.imp = StringUtils.strip(imperative.syllabary);
            if (e.imp.contains(",")) {
                e.imp = StringUtils.substringAfterLast(e.imp, ",");
                e.imp = StringUtils.strip(e.imp);
            }
            e.imp = fixImperativeSuffix(e.imp);
        } else {
            e.imp = ""
        }

        if (infinitive && infinitive.syllabary) {
            e.inf = StringUtils.strip(infinitive?.syllabary);
            if (e?.inf?.contains(",")) {
                e.inf = StringUtils.substringBefore(e.inf, ",");
                e.inf = StringUtils.strip(e.inf);
            }
        }  else {
            e.inf = ""
        }

        /*
     * Strip direct object if easy to identify
     */
        NormalizedVerbEntry.removeDirectObject(e);
        /*
     * Strip Ꮻ- prefix if easy to identify
     */
        NormalizedVerbEntry.removeᏫprefix(e);
        /*
     * Strip Ꮒ- prefix if easy to identify
     */
        NormalizedVerbEntry.removeᏂprefix(e);
        /*
     * String Ꮥ- prefix if easy to identify
     */
        // tio 12Nov26: WI-33 — when the sg3 entry begins with the da-+u- fusion
        // glyph Ꮪ (removeᏕprefix rewrites it to Ꭴ), remember the fused da- so
        // composition can re-declare it. pres3-scoped for now; RECHECK whether
        // habit/imm-fused entries need the same flag.
        boolean pres3DaFused = e.pres3.startsWith("Ꮪ")
        NormalizedVerbEntry.removeᏕprefix(e);
        if (pres3DaFused && e.pres3.startsWith("Ꭴ")) {
            normalizedDaInitialPrefix = true
        }
        /*
     * String Ꭲ- (again) prefix if easy to identify
     */
        NormalizedVerbEntry.removeᎢprefix(e);

        /*
		 * Convert animate to inanimate.
		 */
        reformatAsInanimate(e);

        List<StemEntry> a3rd = a3rd(e);
        if (a3rd) {
            normalizationFailure = ""
            return a3rd;
        }

        List<StemEntry> ga3rd = ga3rd(e);
        if (ga3rd) {
            normalizationFailure = ""
            return ga3rd;
        }

        List<StemEntry> ka3rd = ka3rd(e);
        if (ka3rd) {
            normalizationFailure = ""
            return ka3rd;
        }

//        println "e.pres3: ${e.pres3.substring(0, 1)} -- ${e.pres3}"
//        println "e.pres1: ${e.pres1.substring(0, 1)} -- ${e.pres1}"

        if (e.pres3.startsWith("Ꭴ") && e.pres1.startsWith("ᎠᏆ")) {
//            println "starts with agw && u"
            return generateVowelStems("Ꭰ", e);
        }
        if (e.pres3.startsWith("Ꭼ") && e.past.startsWith("ᎤᏩ")) {
			e.past=discardPrefix(e.past);
			e.inf=discardPrefix(e.inf);
            return generateVowelStems("Ꭵ", e);
        }
        if (e.pres3.startsWith("Ꭶ") && e.past.startsWith("ᎤᏩ")) {
			e.past=discardPrefix(e.past);
			e.inf=discardPrefix(e.inf);
            return generateVowelStems("Ꭰ", e);
        }
        if (e.pres3.startsWith("Ꭴ") && e.pres1.startsWith("ᎠᎩ")) {
            return generateConsonentStems(e);
        }
        if (e.pres3.startsWith("Ꭴ") && e.pres1.startsWith("ᎠᎧ")) {
            return generateVowelStems("Ꭵ", e);
        }

        if (e.pres3.startsWith("ᎤᏮ") && e.pres1.startsWith("ᎠᏋ")) {

			e.pres3=discardPrefix(e.pres3);
			e.past=discardPrefix(e.past);
			e.habit=discardPrefix(e.habit);
			e.imp=discardPrefix(e.inf);
            return generateVowelStems("Ꭵ", e);
        }
        if (e.pres3.startsWith("ᎤᏪ") && e.pres1.startsWith("ᎠᏇ")) {
			e.pres3=discardPrefix(e.pres3);
			e.past=discardPrefix(e.past);
			e.habit=discardPrefix(e.habit);
			e.imp=discardPrefix(e.inf);
			return generateVowelStems("Ꭱ", e);
		}
		if (e.pres3.startsWith("ᎤᏬ") && e.pres1.startsWith("ᎠᏉ")) {
			e.pres3=discardPrefix(e.pres3);
			e.past=discardPrefix(e.past);
			e.habit=discardPrefix(e.habit);
			e.imp=discardPrefix(e.inf);
			return generateVowelStems("Ꭳ", e);
		}
		if (e.pres3.startsWith("Ꮽ") && e.pres1.startsWith("ᏩᏆ")) {
			e.pres3=discardPrefix(e.pres3);
			e.past=discardPrefix(e.past);
			e.habit=discardPrefix(e.habit);
			e.imp=discardPrefix(e.inf);
            return generateVowelStems("Ꭰ", e);
        }

        if (e.pres3.startsWith("Ꭸ") && e.past.startsWith("ᎤᏪ")) {
			e.past=discardPrefix(e.past);
			e.inf=discardPrefix(e.inf);
            return generateVowelStems("Ꭱ", e);
        }

        if (e.pres3.startsWith("Ꭺ") && e.past.startsWith("ᎤᏬ")) {
			e.past=discardPrefix(e.past);
			e.inf=discardPrefix(e.inf);
            return generateVowelStems("Ꭳ", e);
        }

        if (e.pres3.startsWith("Ꭻ") && e.past.startsWith("ᎤᏭ")) {
			e.past=discardPrefix(e.past);
			e.inf=discardPrefix(e.inf);
            return generateVowelStems("Ꭴ", e);
        }

        if (e.pres3.startsWith("Ꭼ") && e.past.startsWith("ᎤᏮ")) {
			e.past=discardPrefix(e.past);
			e.inf=discardPrefix(e.inf);
            return generateVowelStems("Ꭵ", e);
        }
        if (e.pres3.startsWith("Ꭱ") && e.imp.startsWith("Ꭾ")) {
			e.past=discardPrefix(e.past);
			e.inf=discardPrefix(e.inf);
            return generateVowelStems("Ꭱ", e);
        }
        /*
     * eh! "Ꭲ-/Ꭿ-" stemmed verbs don't parse nicely!
     */
        if (e.pres3.startsWith("Ꭹ") && e.past.startsWith("ᎤᏫ")) {
            List<StemEntry> list = new ArrayList<StemEntry>();
            list.add(new StemEntry(newPrefix("Ꭲ", e.pres3), StemType.PresentContinous));
			list.add(new StemEntry(newPrefix("Ꭿ",discardPrefix(e.past)), StemType.RemotePast));
            list.add(new StemEntry(newPrefix("Ꭲ", e.habit), StemType.Habitual));
            if (e.imp.startsWith("Ꮂ")) {
                list.add(new StemEntry(newPrefix("Ꭵ", e.imp), StemType.Immediate));
            } else {
                //App.err("Normalize Corner Case Needed: " + e.getEntries().toString());
            }
			list.add(new StemEntry(newPrefix("Ꭿ",discardPrefix(e.inf)), StemType.Deverbal));
            return list;
        }

        // tio 12Nov26: WI-29 corner case -- Set-B sg3 intransitive Ꭴ + w-stem entries.
        // Ꭴ followed by Ꮺ/Ꮻ/Ꮼ/Ꮽ/Ꮾ (we/wi/wo/wu/wv) marks a w-INITIAL consonant stem:
        // the Ꭴ is the Set-B u- pronominal prefix (u + wohla = ᎤᏬᏝ "he's sitting";
        // the romanization wụ²wo³hla confirms the wi- form is wu- + -wohla, so the
        // stem is -ᏬᏝ). Strip the Ꭴ and consonant-stem the remainder; composition
        // then re-adds u- (or wu- via PrefixWi) without doubling. The ᎤᏩ case (the
        // uw artifact of an a-vowel stem, RuleUW ᎤᏩ -> Ꭴ) is NOT this and keeps its
        // dedicated patterns below.
        if (e.pres3.matches("^Ꭴ[ᏪᏫᏬᏭᏮ].*")) {
            return generateConsonentStems(e);
        }

        if (e.pres3.startsWith("Ꭴ") && !e.pres3.matches("^Ꭴ[Ꮹ-Ꮾ].*")) {
            return generateConsonentStems(e);
        }

        if (e.pres3.startsWith("Ꭶ") && !e.past.matches("^Ꭴ[Ꮹ-Ꮾ].*")) {
            return generateConsonentStems(e);
        }

        /*
     * corner case for ᎬᏙᎠ / ktoa and similar entries
     * (Ꭶ + Ꮩ => ᎬᏙ and no 1st person or past entry)
     */
        if (e.pres3.startsWith("Ꭼ") && e.imp.startsWith("Ꭽ")) {
            return generateVowelStems("Ꭰ", e);
        }
        /*
     * corner case for ᎬᎿ similar entries where they
     * have no past entry)
     */
        if (e.pres3.startsWith("Ꭼ") && e.imp.startsWith("Ꮂ")) {
            return generateVowelStems("Ꭵ", e);
        }
        /*
     * "Ꭼ" + !"ᎤᏮ" is an odd corner case and should always be processed
     * close to last...
     */
        if (e.pres3.startsWith("Ꭼ") && e.past.startsWith("Ꭴ")) {
            return generateVowelStems("Ꭵ", e);
        }

        if (e.pres3.startsWith("ᎤᏩ") && e.pres1.startsWith("ᎠᏋ")) {
            e.pres3=discardPrefix(e.pres3);
            e.past=discardPrefix(e.past);
            e.habit=discardPrefix(e.habit);
            e.imp=discardPrefix(e.inf);
            return generateVowelStems("Ꭵ", e);
        }


//        .info("No normalization method for: " + e.getEntries().toString());
        // E: Fallback normalization - if no patterns match, treat raw stems as the base.
        List<StemEntry> list = new ArrayList<StemEntry>();
        if (!e.pres3.isEmpty()) list.add(new StemEntry(e.pres3, StemType.PresentContinous));
        if (!e.past.isEmpty()) list.add(new StemEntry(e.past, StemType.RemotePast));
        if (!e.imm.isEmpty()) list.add(new StemEntry(e.imm, StemType.Immediate));
        if (!e.habit.isEmpty()) list.add(new StemEntry(e.habit, StemType.Habitual));
        if (!e.imp.isEmpty()) list.add(new StemEntry(e.imp, StemType.Immediate));
        if (!e.inf.isEmpty()) list.add(new StemEntry(e.inf, StemType.Deverbal));

        if (!list.isEmpty()) {
            normalizationFailure = ""
            return list
        }

        def parts = [e.pres3, e.pres1, e.past, e.imm, e.habit, e.imp, e.inf].findAll { it }
        normalizationFailure = parts
                ? "no normalization method for entry: " + parts.join(" / ")
                : "empty stemmer entry (no dictionary lines to normalize)"
        return new ArrayList<StemEntry>();
    }

    private void reformatAsInanimate(NormalizedVerbEntry e) {
        if (e.pres3.matches(".[ᏯᏰᏱᏲᏳᏴ].*")){
            //a "y" consonent stem or vowel+"y" stem? abort ...
            return;
        }

        if (e.pres1.matches("Ꮵ[ᏯᏰᏱᏲᏳᏴ].*")){
            String yx = StringUtils.substring(e.pres1, 1, 2);
            yx = Syllabary.chr2lat(yx);
            yx=StringUtils.substring(yx, 1);
            yx = Syllabary.lat2chr("G"+yx);
            e.pres1=yx+StringUtils.substring(e.pres1, 2);
        }

        if (e.imp.matches("Ꭿ[ᏯᏰᏱᏲᏳᏴ].*")){
            String yx = StringUtils.substring(e.imp, 1, 2);
            yx = Syllabary.chr2lat(yx);
            yx=StringUtils.substring(yx, 1);
            yx = Syllabary.lat2chr("h"+yx);
            //timo 10Nov26: bug fix — this reassembled from e.pres1 instead of
            //e.imp, so the imperative's remaining syllables were replaced by the
            //1st-person present's tail whenever the two entries diverged.
            e.imp=yx+StringUtils.substring(e.imp, 2);
        }
    }

    List<StemEntry> a3rd(e) {
        /*
         * Ꭰ
         */
//        a_3rd: {
            if (!e.pres3.startsWith("Ꭰ")){
                return null;
            }
            if (!e.pres3.matches("Ꭰ[ᏯᏰᏱᏲᏳᏴ].*") && e.pres1.matches("Ꮵ[ᏯᏰᏱᏲᏳᏴ].*")){
                return generateVowelStems("Ꭰ", e);
            }
            if (e.pres1.startsWith("Ꮵ")) {
                return generateConsonentStems(e);
            }
            if (e.pres1.startsWith("Ꭶ")) {
                return generateVowelStems("Ꭰ", e);
            }
            if (!e.past.startsWith("ᎤᏩ")) {
                if (e.pres3.equals("ᎠᎦᏍᎦ")){
//                    new JsonConverter().toJson(generateVowelStems("Ꭰ", e));
                }
                return generateVowelStems("Ꭰ", e);
            }
//        }
    }

     List<StemEntry> ga3rd(e) {
        /*
		 * Ꭶ
		 */
//        ga_3rd: {
            if (!e.pres3.startsWith("Ꭶ")){
//                break ga_3rd;
//                ga3rd(e);
                return null;
            }
            if (!e.pres3.matches("Ꭶ[ᏯᏰᏱᏲᏳᏴ].*") && e.pres1.matches("Ꮵ[ᏯᏰᏱᏲᏳᏴ].*")){
                return generateVowelStems("Ꭰ", e);
            }
            if (e.pres1.startsWith("Ꮵ")) {
                return generateConsonentStems(e);
            }
            if (e.pres1.startsWith("Ꭶ")) {
                return generateVowelStems("Ꭰ", e);
            }
//        }
    }

    List<StemEntry> ka3rd(e) {
        if (!e.pres3.startsWith("Ꭷ")) {
//            ka3rd(e);
            return null;
        }
        if (!e.pres3.matches("Ꭷ[ᏯᏰᏱᏲᏳᏴ].*") && e.pres1.matches("Ꮵ[ᏯᏰᏱᏲᏳᏴ].*")){
            return generateVowelStems("Ꭰ", e);
        }
        if (e.pres1.startsWith("Ꮵ")) {
            return generateConsonentStems(e);
        }
        if (e.pres1.startsWith("Ꭶ")) {
            return generateVowelStems("Ꭰ", e);
        }
        if (e.imp.startsWith("Ꭿ")) {
            return generateConsonentStems(e);
        }

        if (e.past.startsWith("Ꭴ") && !e.past.matches("^[Ꮹ-Ꮾ].*")) {
            return generateConsonentStems(e);
        }

        if (StringUtils.isEmpty(e.past)
                && StringUtils.isEmpty(e.imp) && StringUtils.isEmpty(e.inf)) {
            return generateConsonentStems(e);
        }
    }

    List<StemEntry> generateVowelStems(String vowel, NormalizedVerbEntry e) {
        if (e.imp.startsWith("Ꮻ")) {
			e.imp=discardPrefix(e.imp);
        }
        if (e.imm != null && e.imm.startsWith("Ꮻ")) {
			e.imm=discardPrefix(e.imm);
        }
        List<StemEntry> list = new ArrayList<StemEntry>();
        list.add(new StemEntry(newPrefix(vowel, e.pres3), StemType.PresentContinous));
        list.add(new StemEntry(newPrefix(vowel, e.past), StemType.RemotePast));
        list.add(new StemEntry(newPrefix(vowel, e.imm), StemType.Immediate));
        list.add(new StemEntry(newPrefix(vowel, e.habit), StemType.Habitual));
        list.add(new StemEntry(newPrefix(vowel, e.imp), StemType.Immediate));
        list.add(new StemEntry(newPrefix(vowel, e.inf), StemType.Deverbal));
        return list;
    }

    List<StemEntry> generateConsonentStems(NormalizedVerbEntry e) {
        if (e.imp.startsWith("Ꮻ")) {
			e.imp=discardPrefix(e.imp);
        }
        if (e.imm != null && e.imm.startsWith("Ꮻ")) {
			e.imm=discardPrefix(e.imm);
        }
        List<StemEntry> list = new ArrayList<StemEntry>();
		list.add(new StemEntry(discardPrefix(e.pres3), StemType.PresentContinous));
		list.add(new StemEntry(discardPrefix(e.past), StemType.RemotePast));
		list.add(new StemEntry(discardPrefix(e.imm), StemType.Immediate));
		list.add(new StemEntry(discardPrefix(e.habit), StemType.Habitual));
		list.add(new StemEntry(discardPrefix(e.imp), StemType.Immediate));
		list.add(new StemEntry(discardPrefix(e.inf), StemType.Deverbal));
        return list;
    }

    private static String fixImperativeSuffix(String imp) {
        if (StringUtils.isBlank(imp)) {
            return "";
        }
        // tio 12Nov26: WI-31/32 — keep the imperative row's printed final. The
        // old code decremented a non-(-a) final to its -a twin (Ꭿ hi -> Ꭽ ha,
        // Ꭹ gi -> Ꭶ ga, Ꮧ di -> Ꮣ da), treating the -i imperative as a variant
        // of -a. But the guide's own examples print the -Ꭿ surface form (ex. 31
        // ᏥᏬᏂᎯ, ex. 32 ᎯᏬᏂᎯ) and composition prepends the pronominal to the
        // routed stem as-is, so the printed final must survive: ᎯᏬᏂᎯ = Ꭿ- +
        // ᏬᏂᎯ, NOT ᎯᏬᏂᎭ. The verb book is ground truth for printed rows; the
        // -a/-i choice is the book's, not the engine's. RECHECK: if a source
        // canonicalizes -i imperative rows to -a, do it at the data layer with
        // a documented rule, never silently here.
        return imp;
    }

	static String discardPrefix(String text) {
        return newPrefix("", text);
    }

    static String newPrefix(String prefix, String text) {
        if (StringUtils.isBlank(text)) {
            return "";
        }
        return prefix + StringUtils.substring(text, 1);
    }
}