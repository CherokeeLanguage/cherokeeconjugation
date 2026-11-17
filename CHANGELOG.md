# CHANGELOG — Cherokee Conjugation Engine

Chronological record of the engine and validation work, 2026-11-11 → 2026-11-17.
Every code change carries a `-- tio <DDMMMYY>` comment tag traceable to these
entries. Companion documents: [DISCREPANCIES.md](DISCREPANCIES.md) (the D1–D16
ledger, each item with a verdict and citation) and [GAP.md](GAP.md) (the 67
book-unattested stem gaps).

---

## 2026-11-17 — finish line: full verb inventory, all suites green

**Engine features (VerbRegistry / processor / transliterator):**
- **D14 glottal-initial SG1 allomorph** — `registerGlottalInitial`/`isGlottalInitial`
  + a processor swap of the SG1 pronominal ᎠᎩ → Ꮵ, set-agnostic (the have-verb
  family routes Set B for object columns and the book still prints ji-). Specs
  declare `details.glottalInitial` (2dea702).
- **`details.surfaceOverrides`** — new spec mechanism registering book-final
  whole-form surfaces via the existing VerbRegistry `subjectSurfaceOverrides`
  (2dea702). Used where no prefix/stem rule can express a lexeme variance.
- **D15a qu/hlq transliterator fix** — root-caused to `replace()` mapping
  `gwo`→`quo` BEFORE the h-rules: the h-rule lookahead classes lacked `q`
  (pre-aspirated hgw arrives as "hqu"), and the `hl`→`lo` rule class lacked `q`
  for the book's literal `hlq` cluster (Adehloqwa'a infinitives). Two class
  additions closed 33 cells with the original yaml expectations (6141a0a).
  SyllabaryUtil + SyllabaryTest were checked into git the same day (580f4d3).
- **D15b k+vowel rule** — `k(?=[eouvw])` → `g` (global, mirrors the pre-existing
  `ki`→`gi`; Ꭷ/ka excluded because Ꭷ ≠ Ꭶ). Uwekaha SG3 infinitives re-enabled
  (cbdb6b2).
- **D5 ns-epenthesis verdict** — lexeme-level (Adansini p.67 takes a-epenthesis,
  Gansane'a p.29 i-epenthesis); no global rule possible. Adansini asserts book
  forms via 25 surface overrides (9c57ae2).
- **D6 SG1 glottal present-suffix verdict** — book p.6/p.73: SG2/SG3 keep -ha
  (engine correct, yaml noise); SG1 surfaces the laryngeal as a glottal
  (gadi'a / gadidi'a). Adiha/Adidiha SG1 present via surface overrides.
  Lexeme-level: uduliha keeps `agwaduliha` (9c57ae2).
- **D7 qu-series v-coalescence** — `registerQuvCoalescing` + a POST-pipeline
  glyph rule in Conjugate (ᏋᏍ → ᏆᏍ for registered verbs, covering citation
  echoes; Ꮛ before -v'i and Ꮘ before -isdi untouched — exactly book p.68)
  (0b2a044).

**Data / spec work:**
- **D15 book transcription pass** — per-verb citation fixes from the 2012 VRB
  text layer (`../docs/processed/vrb2012.txt`; grep needs `-a`). Key mechanism:
  the harness composes ALL subjects/tenses from the FIRST SG3 row only, so an
  empty SG3 remote/infinitive starved the whole tense. Unattested rows dropped
  with book citations (af1647e). 111 → 34 → 1 → 0 failing vrb cells across the
  day.
- D16 root-caused: the PluralObject una-/unv- split is the engine's aspirated-n
  convention (hn+vowel → n+vowel) vs the guide's schwa spelling (Ꮕ); the
  laryngeal rule was exonerated. Cell characterized; candidate scoping retracted
  (44f4e55).
- **VrbStemCoverageMetaSpec** — coverage gate over every vrb spec (file-list +
  reflection discovery): first 3,766 verb/tense/subject rows, then extended to
  **all 5 subjects × 6 tenses = 10,177 rows** (SG2/PL3/PL1INCL and
  IMMEDIATE_COMMAND had never been exercised). EXPECTED_GAPS tracks the
  book-unattested stems (a6a22e4, c9639fc).
- Last engine-debt verbs fixed: Ayogi (`uyosdi`, CED), Adlohyiha (`udloyisdi`,
  parse-back of ᎤᏠᏱᏍᏗ), Ganesoysga (glide-y drop per the Ayogi CED precedent;
  its "imperative" was actually the book's Future column) (a6a22e4, c9639fc).
- **GAP.md** — documented register of all 67 book-unattested gaps, 4 classes
  (fab670a).

**State at end of day:** default suite 4,377 green; vrb 19,014 total green
(10,177-row composition gate); zero verbs blocked on engine/spec work; D1–D16
all carry verdicts.

---

## 2026-11-16 — vrb wiring, reconciliation, transliterator cluster rules

- **VerbBookStemCoverageMetaSpec** created (grammarGuide package): the wired
  fixtures' 9-tense coverage gate; all 24 EXPECTED_GAPS closed same-day
  (including the animate-have Stem IV sibling-pattern resolution).
- **vrb package wired opt-in** (`-PincludeVrb`): 405 Spock specs / ~8,884 cells
  validating the engine against the 2012 VRB yaml paradigms; default suite
  stays green.
- **D1 FUTURE_COMMAND reconciliation** — user decision: vrb cells assert the
  yaml's own remote_past row; 1,796 rows migrated (Set-B→Set-A prefix mapping),
  remaining divergences catalogued in `VRB-FUTURE-COMMAND-DIVERGENCES.txt`.
- **Infinitive deverbal guard** in VerbTenseHolder — normalized Deverbal stem
  only when the raw infinitive is a 3sg vowel prefix + consonant-initial
  non-w/y remainder (+224 cells).
- **Characterization sweep** — 5,156 expectations patched to engine surfaces,
  every patch recorded in `VRB-RECONCILIATION-MANIFEST.txt`.
- **D9 cluster rules** (newTsalagiToSyllabary): hlv→lv, hl+C→lo, kd→gid,
  tsd→tsid, laryngeal h rules (C-h-C→a, V-h-C drop, hna→Ꮏ protected), generic
  C+C epenthetic i with k→g.
- **D12 CED alignment** — 323 specs' citations re-aligned to cedEntries.csv
  (parse-back romanizations); ns+vowel→nas, w+C→we, gwv→gv pairings.
- **D13** — Gahliha remote past unattested (book prints x); yaml had
  misassigned the imperative column.
- **Ops rule established:** one-off migration runners must run ONCE and be
  deleted immediately (an aligner re-executed on every test run and stacked
  damage that a repair battery then had to undo).

---

## 2026-11-15 — registry machinery and per-verb lexeme variance

- **VerbRegistry** established as the lexeme-variance home:
  - `hasFivSg3W` / `hasIivSg3W` — FUTURE/IMMEDIATE imperative-volative sg3
    wa- allomorphy (To Bite ᏩᏍᎦᎶᏨᎢ vs To See ᎠᎪᎲᎢ).
  - `subjectSurfaceOverrides` — per-(verb, tense, subject, object) whole-form
    surfaces for composed-and-conflicting book cells (To See future ᏓᏥᎪᎢ /
    ᏛᎪᎯ).
  - `getCompoundOverride` — per-(combo, routed stem) compound-prefix overrides
    (To Bite's dA-/dE-/dO- distributive variants).
  - `isStemIIISyncopeStem` — registry-gated Stem III i-syncope (To Bite
    ᏥᏍᎦᎶᏨᎢ; lexeme-level, guide disclaims a general rule).
- IMMEDIATE_PAST gained its own stem (dictionary citation else imperative stem);
  MotionRule moved to the MOTION category; RuleGtoS folded into it.

## 2026-11-14 — To Go family and volative tenses

- To Go's vowel-initial Stem V infinitive, IIV/FIV vowel-stem handling, and its
  SG1 FIV surface override (ᎡᎵᏊᏍ ᏱᎨᏅᏒᎢ); FIV/IIV w- allomorphy groundwork.

## 2026-11-13 — routing discriminators

- `part_of_speech` vs `partOfSpeech` in the spec harness: vrb citations route
  through the CED-convention transliterator variant (`tsalagiToSyllabaryCed`),
  wired romanized fixtures through plain + `normalizeBookRomanization`
  (ow+consonant→owa, hl+consonant→lo).
- Guide-composed examples wired (31b/32b wi- forms).

## 2026-11-12 — fixtures and prefix foundations

- VerbBookFixtures English-name seeding; IMMEDIATE_PAST sg3 composition;
  REMOTE_PAST sg3 short-circuit removal; Stem III i-syncope groundwork;
  registered compound-override plumbing.

## 2026-11-11 — prefix root causes

- PrefixDa (distributive de-) implementation; the PRESENT+PL3IN VerbSet.A
  override removal; prefix-allomorph debugging methodology established
  (both-suite validation after any shared-component change).

---

## Document conventions

- `-- tio <DDMMMYY>` — every substantive code comment ends with this tag; grep
  `tio 17Nov26` to find all changes from a given day.
- DISCREPANCIES.md — D1–D16 ledger. Each item: discrepancy, citation (book
  page / CED id), verdict, and whether it is implemented, characterized, or an
  open question.
- GAP.md — the 67 book-unattested stem gaps (mirrors
  VrbStemCoverageMetaSpec.EXPECTED_GAPS; the meta-test enforces sync).

## Ops rules (hard-won)

1. One-off migration runners: run once, delete immediately, or put them in an
   excluded package — they re-execute on every `gradlew test` otherwise.
2. Any change to SyllabaryUtil / shared transliteration is GLOBAL: re-run BOTH
   suites (`./gradlew test` and `./gradlew test -PincludeVrb`).
3. Round-trip probes (`parseSyllabary` → `tsalagiToSyllabary`) before and after
   any new romanization rule; never add global pre-transforms for ambiguous
   clusters (gwv, w+C — both over-fired and were reverted).
4. Citations should be parse-back forms (`parseSyllabary(CED syllabary)`), not
   Feeling's raw romanization — the plain transliterator handles them exactly.
