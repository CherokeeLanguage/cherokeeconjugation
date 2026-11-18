# CHANGELOG — Cherokee Conjugation Engine

Chronological record of the engine and validation work, 2026-11-11 → 2026-11-18.
Every code change carries a `-- tio <DDMMMYY>` comment tag traceable to these
entries. Companion documents: [DISCREPANCIES.md](DISCREPANCIES.md) (the D1–D17
ledger, each item with a verdict and citation) and [GAP.md](GAP.md) (the
book-unattested stem gaps).

---

## 2026-11-18 — input gate: VerbInputNormalizer on the conjugation path

**User decisions.** The dictionary passes SYLLABARY only. Specs stay untouched
(CED-canonical). A future backlog item: pass in a verb that is broken down and
conjugated without the five stems (deconstruction is already a separate
backlog feature). For now, implement the input gate.

**What shipped.** `VerbInputNormalizer` (main, conjugation package):
- `normalizeRequestStem` — the GATE, invoked in
  `ConjugationContext.buildBaseVerb` for every stem: glyphs pass through
  byte-identical (the dictionary contract); roman input converts
  (all glottal apostrophes dropped — unwritten in the syllabary both between
  dual vowels and before consonants; the phonemic glottal-initial property
  lives in the `glottalInitial` lexeme flag, not the orthography, matching
  the stem-wiring convention the specs always applied), book repairs
  (ow→owa / hl→lo) then the CED-convention transliterator.
- `toSyll` + `normalizeBookRomanization` — the shared converter hoisted from
  the private copies in `VerbBaseSpec` (test) and `VerbLexemeFlagLoader`;
  both now delegate; behavior byte-identical, single home.
- Deliberately NOT normalized (need round-trip probes + rulings; roman-only
  concerns): d/t and g/k spirantization, tone diacritics, uw-/u- fusion (D15).

**Engine effect.** None on composition — the gate is a boundary conversion.
Glyph input (the dictionary) is unaffected; the 23,522 combined-suite tests
all green (7 new gate tests in `VerbInputNormalizerTest`). The normalization
decision (normalizing spec entries wholesale) is closed as "specs stay
as-is".

---

## 2026-11-18 — glottal-class audit: Aja'vsga found, infinitive wired; impersonal-grid discovery; D18

**Audit.** Cross-checked all 407 vrb specs against every `Verb :` entry in the
VRB processed-md with apostrophes normalized — every spec matches a VRB entry
(no hidden absent verbs). Then scanned specs for residual junk artifacts and
absence claims. Findings:

1. **AjavsgaSpec's "ABSENT from the 2012 book" claim was WRONG** (same class as
   the Nania correction): Aja'vsga is Verb p.57 with a FULL box whose
   infinitive column IS attested (agwajodi / jajodi / ujodi / unajodi /
   igajodi) — the yaml had dropped the glottal apostrophe. SG3 infinitive
   `ujodi` wired; all five INFINITIVE cells asserted; `Ajavsga|INFINITIVE`
   deleted from `EXPECTED_GAPS` (47 → 46). The spec's ts-shapes stay: CED id
   72429 carries ᎠᏣᎥᏍᎦ (atsavsga) where Feeling's book writes ja'-/jv —
   orthography variance, parse-back convention keeps CED.
2. **The impersonal cohort DOES appear in the VRB** — in a multi-verb weather
   grid (~line 4333+) whose `Verb :` headers are inside table cells, which is
   why the line-start extraction missed them. Their paradigm forms match the
   specs.
3. **D18 (DISCREPANCIES.md):** the grid prints Gutiha's infinitive as
   `uwutodi`; CED id 73286 carries `uwutohdi` (ᎤᏭᏙᏗ). Spec keeps the CED
   form (parse-back rule); documented, not auto-patched. No other variances
   surfaced in the grid.

All other "junk"-comment specs correctly cite book-x / no-column cells — no
further false-absence cases. GAP.md glottal-class count 13 → 12. Combined
suite green.

---

## 2026-11-18 — "yaml junk" class corrected: Nani'a / A'i exist in the VRB (glottal apostrophes dropped)

**User correction.** The "yaml junk entry" gap class claimed Nania was
"absent from the 2012 book (index and body)" and Ai/Ajavsga were junk rows.
Wrong: the verbs exist — the yaml transcription had dropped the glottal
apostrophes between dual vowels (Nani'a → "Nania", A'i → "Ai", nosdi'a →
"nosdia") and leaked header text ("There"/"Are") into stem fields. The
corrupted extraction is what looked like absence.

**Re-alignment.** NaniaSpec rewritten against the true box (VRB p.31):
Nani'a is a PRONOUN-LIMITED quantifier verb — plural-only rows nosdi'a
(DL1INCL) / noji'a (PL1INCL) / nisdi'a (DL2) / niji'a (PL2) / nani'a (PL3),
no SG1/SG2/SG3 rows; the SG3 citation row carries the PL3 form per CED id
73552 (ᎾᏂᎠ, glottal unwritten between vowels). Attested cells asserted
(SG3 PRESENT/HABITUAL, PL3 PRESENT, SG3 IMMEDIATE_COMMAND naniesdi — raw
composition prefixes a- onto the plural citation stem, so the PL3 PRESENT
bare-citation form and SG3 imperative are whole-form surfaceOverrides).
AiSpec corrected (VRB p.1): REMOTE_PAST is ATTESTED (ga'isv'i → aquaisvi) —
previously spuriously framed as blocked; FC is not asserted (no column in
the book; engine composes the completive shape for this vowel-initial stem).
Both lexemes' provenance notes and verbLexemes.json updated.

**Docs.** GAP.md class relabeled "Glottal-apostrophe yaml rows (cleaned)"
with the user verdict quoted; the "absent verb" reading is retired. Combined
suite green.

---


## 2026-11-18 — footnote-gap verbs closed: Ahili / Anidonaa / Anina imperatives wired

**Problem.** Three verbs' imperatives sat in `EXPECTED_GAPS` as
"book-attested-but-no-CED-anchor": the 2012 VRB prints the forms but CED marks
the imperative column `-----`, so no parse-back citation could be built and the
rows were never wired. Ahili additionally needed "vision-OCR of the book page"
per the earlier assessment.

**Discovery.** The processed-md text layer of the VRB
(`docs/processed/VRB Didehloqwasgi 2012.md`) already carries the attested
romanizations — **no OCR was needed**. Ahili's Ahi'li box (p.10) attests all
five imperative rows; Anidona'a (p.56 group) and Ani'na (p.71 group) each
attest four congregation imperative rows and are themselves the 3+ alternants
of the VRB pp.18 footnote pairs (/Danidoga/ two vs /anidona'a/ 3+ standing;
/Dunotla/ two vs /ani'na/ 3+ sitting) — no separate lexeme modeling required,
the existing AnidonaaSpec/AninaSpec already model those lexemes.

**Wiring.** All rows registered as whole-form `surfaceOverrides` (the D14/D15
pattern): raw composition mangled Ahili's glottal-initial allomorphy
(ji- + hi-luga → jihiluga vs book ji'i'luga; ga- echo on SG3), and the
congregation boxes have **no SG3 row at all**, so there is no SG3 imperative
stem to compose from. Ahili's SG3 stem `ahiluga` is wired into the spec
details for the coverage gate. The three lexemes also joined
`verbLexemes.json` (data↔spec sync, caught by `VerbLexemeFlagMetaSpec`).

**Gate.** `VrbStemCoverageMetaSpec.actualGaps` exempts tenses whose cells are
attested via surfaceOverrides while the SG3 row cites no stem
(`coveredByOverrides`) — data-complete, not a gap, and not gate-attempted.
Three `EXPECTED_GAPS` entries deleted (50 → 47). GAP.md imperative section
updated (no-anchor class 4 → 1). Combined suite 23,519 green.

---

## 2026-11-18 — lexeme-flag generalization: data-driven per-lexeme flags for library consumers

**Problem.** The per-verb lexeme flags (`glottalInitial`, `quvCoalescing`,
`impersonal`, `surfaceOverrides`) lived only in test-spec `details` maps and
were registered per-conjugation by `VerbBaseSpec.conjugateVerb` inside a
`withVerbScope`. A library consumer of `VerbConjugationFacade` got none of
them — the engine jar's global seeds (`VerbRegistryInitializer`) carry no
vrb-package flags — so the engine was not "done as a library" for these
properties.

**Design.** New resource `src/main/resources/data/verbLexemes.json`, keyed by
**lexeme name** (not citation): the present3rd citation is NOT lexeme-unique
(Gahneha and Ganeha both print `ᎦᏁᎭ`), so citation-keyed global seeding of
`surfaceOverrides` would re-create the collision the scope mechanism fixed;
the name is the only discriminator. Data covers 25 lexemes: 4 `glottalInitial`
(Ahyeha, Gahneha, Ganeha, Ganhjeha), 1 `quvCoalescing` (Adlvkwsga), 17
`impersonal` (the D17 cohort), 7 with `surfaceOverrides` (40 rows: Adansini's
full 25-cell book paradigm, Adiha/Adidiha D6 glottals, Asvga BOOK-ONLY FORM,
Uwaya D15 infinitive, Ganeha/Ganhjeha SG1 rows). Each entry carries a
provenance note (book page / CED id / D-item), keeping the
missing-data-visibility rule. JSON (not YAML) chosen to avoid a new
dependency: Groovy's bundled `JsonSlurper`.

**Engine.** `VerbLexemeFlagLoader` loads the data, converts citations/forms
through the same `toSyll` pipeline as `VerbBaseSpec` (`tsalagiToSyllabaryCed`
+ book-romanization normalization), and applies a lexeme's flags into the
current registration context. `ConjugationRequest` gained `lexeme`;
`VerbConjugationFacade.conjugate` opens a per-conjugation `withVerbScope` and
applies the named lexeme's flags when set — identical isolation to the test
harness. No other caller behavior changes.

**Tests.** New `vrb/VerbLexemeFlagMetaSpec` keeps data and specs in sync
(GAP.md convention): every flag-declaring spec must have a same-name entry
with matching citation, flags, and override set; every data entry must be
consumed by a spec (no orphans); the citation-sharing twins conjugate their
own SG1 surfaces through the lexeme path in BOTH orders; every lexeme's flags
register and answer in a fresh scope. Combined suite 23,492 green (was
23,413).

---

## 2026-11-18 — test infra: per-conjugation VerbRegistry scope (collision fix)

**Symptom.** In a bulk vrb run, `GahnehaSpec` (hold flexible) failed 10 SG1
cells, returning `jinea / jineoi / jinevi / jinei` — the rows of `GanehaSpec`
(hold long). `GahnehaSpec` passed 20/20 when run alone, and the failure
depended on class order (Ganeha-then-Gahneha failed, the reverse passed).

**Root cause.** Both verbs print the same SG3 present citation `ᎦᏁᎭ`. Every
lexical flag `VerbBaseSpec.conjugateVerb` registers (`glottalInitial`,
`quvCoalescing`, `impersonal`, `surfaceOverrides`) is keyed on that citation
and matched contained-in, and the registrations went into the **global**
`VerbRegistry`. Ganeha's SG1 `surfaceOverrides` therefore survived into
Gahneha's conjugations. Production had the same latent hazard for any two
lexemes sharing a present3rd citation.

**Fix.** `VerbRegistry` gained a per-conjugation registration scope:

- `withVerbScope { ... }` opens a `ThreadLocal` scope; registration methods
  write to the scope instead of the global sets/maps while it is open.
- Lookups consult the scope first, then the global seeds
  (`VerbRegistryInitializer`), so bootstrapped data stays visible.
- `VerbBaseSpec.conjugateVerb` wraps registration + composition in one scope,
  so a spec's data influences exactly one conjugation and cannot leak.
- Scope is nest-safe and thread-safe; `clearOverrides()` semantics unchanged.

**Tests.** New `vrb/VerbRegistryScopeSpec` pins both class orders using the real
`GahnehaSpec`/`GanehaSpec` details (fails before the fix with `ᏥᏁᎠ` vs
`ᏥᏁᎭ`). `VerbRegistryTest` adds mechanism tests: scope visibility, no leak
after close, scoped surface precedence, and nested-scope isolation.

**Verified.** `./gradlew test -PincludeVrb` → **23,413 tests (19,033 vrb), 0
failures, 0 errors**.

---

## 2026-11-18 — build ops: `./gradlew` works under WSL again

**Symptom.** Every build died with `The first result from the daemon was empty`
(or, with `--no-daemon`, the same message after "a single-use Daemon process
will be forked"). The daemon log showed it listening on
`[localhost/127.0.0.1]` and then `Cannot accept connection from remote address
/127.0.0.1` — it rejected its own client. Verification had been running through
a hand-rolled `javac`/`groovyc` + JUnitCore harness as a result.

**Root cause.** JDK8's `InetAddress.isReachable(50)` returns **false** for
`127.0.0.1` under WSL but **true** for `::1`. Gradle 6.8.3's
`InetAddresses.analyzeNetworkInterface()` only registers a loopback address when
that check passes, so `127.0.0.1` is dropped from `communicationAddresses`
(the daemon's accept-list) while `InetAddressFactory.findLocalBindingAddress()`
still binds to it via `InetAddress.getLoopbackAddress()`. The two disagree, so
`TcpIncomingConnector` rejects every connection. Confirmed with a standalone
probe: `127.0.0.1 -> isReachable=false`, `::1 -> isReachable=true`.

**Why the old workaround never worked.** `org.gradle.jvmargs` contained
`-Djava.net.preferIPv6Addresses=true`, but `JvmOptions.jvmArgs()` parses `-D`
args into *system properties*; only a fixed immutable set (`file.encoding`,
`user.*`, …) is emitted as real daemon JVM args. Arbitrary properties are
applied per-build *inside* the already-started daemon — too late for the
`InetAddressFactory` static init, and they never appear in `daemonOpts`.

**Fix.** `gradlew` now exports `JAVA_TOOL_OPTIONS=-Djava.net.preferIPv6Addresses=true`
on WSL only (`/proc/version` matches `microsoft`) and only when the flag is not
already present; `JAVA_TOOL_OPTIONS` is inherited by client, daemon and test
worker JVMs, so the daemon binds to and advertises `::1` and the accept-list
matches. `gradle.properties` keeps the memory args and documents why the flag
cannot live there.

**Verified with real Gradle (not the manual harness):** `./gradlew test` →
4,377 tests, 0 failures; `./gradlew test -PincludeVrb` → 23,408 tests (19,031
vrb), 0 failures / 0 errors. Warm daemon reuse and `--no-daemon` both work.

---

## 2026-11-17 — finish line: full verb inventory, all suites green

**Engine features (VerbRegistry / processor / transliterator):**

- **D17 impersonal-verb imperative refusal** — linguistic verdict: the 16
  weather/nature verbs' imperative is IMPERMISSIBLE (no agent to command), not
  unattested. Encoded as a lexical property: `details.impersonal` →
  `VerbRegistry.registerImpersonal` → Conjugate returns the `NO_IMPERATIVE`
  sentinel for IMMEDIATE_COMMAND (previously composed garbage). The coverage
  gate asserts the sentinel for all 16 and exempts them from EXPECTED_GAPS;
  GAP.md reclassified 67 → 51 gaps with the three-way cell taxonomy
  (attested / impermissible / unattested).
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
- **GAP.md** — documented register of the book-unattested gaps, with the
  three-way cell taxonomy (fab670a).

**State at end of day:** default suite 4,377 green; vrb suite fully green
(incl. the 10,177-row composition gate); zero verbs blocked on engine/spec
work; D1–D17 all carry verdicts.

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
- DISCREPANCIES.md — D1–D17 ledger. Each item: discrepancy, citation (book
  page / CED id), verdict, and whether it is implemented, characterized, or an
  open question.
- GAP.md — the book-unattested stem gaps (mirrors
  VrbStemCoverageMetaSpec.EXPECTED_GAPS; the meta-test enforces sync) plus the
  impersonal-verb cohort register.

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
5. In-place perl with `\x{...}` escapes on UTF-8 docs has corrupted encodings
   twice — prefer the Write/Edit tools for document files.

## 2026-11-18 — pre-backlog review: D18 resolved, D15 parked, Unaa stale gap closed

**D18 RESOLVED (user verdict):** the intrusive-h variance (VRB `uwutodi` vs
CED `uwutohdi`) makes no difference to conjugation — CED's own syllabary
ᎤᏭᏙᏗ carries no h glyph, so both compose identically; "the h can go."
Documented variance; GutihaSpec unchanged.

**D15 parked with a trigger condition (user verdict):** "keep parked; if
there are any future issues, we tackle them then" — trigger = any future
verb/cell surfacing the Ꭴw-fusion pattern.

**GAP.md no-anchor audit:** all 46 gaps verified against the VRB boxes.
Finding: `Unaa|INFINITIVE` was a STALE GAP — Una'a (Have flexible, p.83)
attests the infinitive column (aginvdi / janvdi / unvdi / uninvdi) and the
spec already asserted all five cells via the deverbal-infinitive derivation.
SG3 stem `unvdi` wired (+ SG3 imperative corrected from the SG2 copy artifact
to `unaesdi`); gap deleted (46 → 45). **The "No CED syllabary anchor" class
is now EMPTY** — every remaining gap is a genuine book-x / no-column cell.

