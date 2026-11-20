# VRB Validation Discrepancies

Catalogue of systematic discrepancies between the vrb validation specs
(`src/test/groovy/net/cherokeedictionary/conjugation/vrb/`, generated from the
2012 VRB yaml) and the conjugation engine's current output. Created 2026-11-16
during the vrb reconciliation (5,093 -> 4,226 failing cells).

**Data sources cited throughout:**
- **YAML** = `../cherokeeconjugation/src/test/resources/VRBDidehloqwasgi2012.yaml`
  (2012 VRB Didehloqwasgi transcription; snapshot of the 2026-11-03 extraction;
  the vrb specs embed copies of its entries, so they do NOT auto-update)
- **BOOK** = `../docs/processed/Cherokee Verb Conjugations - Copy.pdf`
  (Feeling/van Tuyl/Webster/Kopris/Odess, 164 pp., greppable text layer;
  `pdftotext -layout`, use `grep -a` -- ugrep treats syllabary UTF-8 as binary)
- **BOOK2012** = `../docs/processed/VRB Didehloqwasgi 2012.pdf` (scan, no text
  layer)
- **CED** = `../data/cedEntries.csv` (dictionary DB export, 708 verb entries;
  the animate-have row is id 73986)
- **GUIDE** = the grammar-guide HTML book (Durbin Feeling grammar; pitch-accent
  romanization; "initial prefixes" chapter pp.241+)
- **DIVERGENCE-LOG** = `VRB-FUTURE-COMMAND-DIVERGENCES.txt` (repo root; 832
  per-cell FUTURE_COMMAND divergences)

Run the validation suite: `./gradlew test -PincludeVrb` (default build excludes
vrb and stays green).

---

## D1. FUTURE_COMMAND tense convention -- RESOLVED by decision (2026-11-16)

**Discrepancy:** YAML asserts FUTURE_COMMAND = the imperative-row surface
(`Adadolisdiha` SG1 `gadadolisda`, YAML key `Adadolisdiha`); the engine renders
FUTURE_COMMAND = Stem III + -v'i (the remote-past surface, `gadadolistanvi`).

**Citation for the engine convention:** BOOK stem summaries (printed pp.167-176,
per `TenseSuffixCompletenessSpec.groovy:37-40`): "FUTURE_COMMAND -v'i / -esdi
Future Imperative/Volative (Stem III + -v'i, usually identical to the Remote
Past row)"; pinned by `GowatihaSG3SG3ANTest.groovy:108-110` (SG3 ᎠᎪᎲᎢ) and the
283 wired To*Future/FutureImperativeVolative specs.

**Resolution:** the vrb specs were reconciled to Stem III (mechanical rewrite of
1,796 expectations to each row's own yaml `remote_past`, plus a verified
Set-B->Set-A prefix migration patching 197 more). Do NOT "fix" the engine here.

## D2. Set-A elision divergences (FUTURE_COMMAND remainder, ~1,150 cells)

**Discrepancy:** the engine elides h/a when composing the Set-A future-command
surface; the yaml's Set-B transcriptions preserve the segment.
Examples (DIVERGENCE-LOG):
- `Adahyiha` SG1/SG3IN: yaml remote `agwadahyilvi`, mapped candidate
  `gaahyilvi`, engine `gadayilvi` (a-elision after ga-)
- `Adananesvhvsga` SG1: yaml `agwadananesvhnvi`, engine `gadananesvnvi`
  (h-elision)
- `Adadolisdiha` SG1: candidate `gaadolistanvi`, engine `gadadolistanvi`
  (double-a collapse)

**Open question for review:** is the engine's elision book-correct for the
future-command surface, or does the BOOK print the unreduced cluster in
future-command rows? Cross-check per verb against BOOK future tables (e.g. To
Hear p.64, To See p.119) before changing either side. Each of the 832 rows in
DIVERGENCE-LOG needs this verdict.

## D3. Distributive-subject rows: da-/de- baked into PL3/PL1INCL yaml rows

**Discrepancy:** for some verbs the yaml's PL3/PL1INCL citation rows carry the
distributive/plural-subject initial prefix baked in; the engine composes the
bare person prefix unless a distributive flag is set.
Examples:
- `Adanawsdiha` PL3 PRESENT: YAML `danadanawsdiha`, engine `anadanawsdiha`
- `Adanawsdiha` PL1INCL PRESENT: YAML `dedadanawsdiha` (de- + ida-), engine
  `idadadanawsdiha`

**Citation:** GUIDE pp.247-248, examples (49)-(51): "de- plural object form:
de- before consonants, d- before vowels" and its allomorphy; the verb-book
wired specs handle this lexically via `distributive: true` fixtures
(`VerbBookFixtures.groovy`, "to fall (a living being)" comment) and
`VerbBaseSpec.conjugateVerb` lines 48-54 (`wantsDe`).

**Candidate fix:** teach the vrb path to detect de-/da- initial prefixes in the
yaml rows (or add a distributive flag to the generated specs), then let
PrefixDe compose the allomorphy. Needs per-verb verification that the yaml row
is genuinely distributive and not transcription noise.

## D4. j-/hi- specific-past remote rows vs Set-B remote

**Discrepancy:** some yaml remote_past rows use the j-/hi- specific-past prefix
instead of the Set-B prepronominal; the engine composes Set B.
Examples:
- `Adeha` SG1 REMOTE_PAST: YAML `jidelvi`, engine `agidelvi`
- `Adeha` SG2 REMOTE_PAST: YAML `hidelvi`, engine `jadelvi`-shaped Set-B form

**Citation:** GUIDE pp.242-243, examples (14)-(17): "j-, specific past time
form: j- before vowels, ji- before consonants" -- a DIFFERENT initial prefix
used when a definite past time is referenced. Both surfaces are legitimate
Cherokee; they differ in discourse function, not morphology.

**Open question for review:** should the 2012 yaml's remote_past citations be
treated as the j-specific-past surface (per verb) or re-transcribed as Set-B?
Compare against BOOK remote-past tables (which print Set-B surfaces like
`edohv'i`) per verb.

## D5. Laryngeal h: written (Ꮏ) vs unwritten (Ꮎ) before n

**Discrepancy:** `SyllabaryUtil.newTsalagiToSyllabary` maps `hna` -> Ꮏ (the hna
glyph exists in the syllabary), while the yaml transcribes the laryngeal as
unwritten before n.
Example: `Adansini` SG1 PRESENT: expected `gadanasini` (ᎦᏓᎾᏏᏂ); the engine's
internal latin carries the laryngeal and surfaces Ꮏ, which the yaml cell does
not match.

**Citation:** CED entries routinely write the laryngeal unreduced in latin
(`gadahnasini`-style) while the syllabary column shows plain Ꮎ. Feeling's
orthography writes Ꮏ only where the h is phonemically distinct.

**Open question for review:** per verb, is the h syllabary-visible (Ꮏ) or not
(Ꮎ)? A blanket rule will be wrong for one class of verbs.

**Partial resolution 2026-11-16 (sweep):** SyllabaryUtil implements laryngeal h between consonants -> a (nhs -> Ꮎᓏ), vowel+h+consonant drops the h (uhtv- -> utv-), word-initial/after-vowel hna -> ᏿ (pinned by SyllabaryTest).

**VERDICT 2026-11-17 (from the 2012 book, Adansini Crawling p.67):** the book prints
SG1 present `gadanasini` -- the laryngeal is UNWRITTEN (plain Ꮎ, na-si), AND the
ns+vowel epenthesis is /a/, not the generic /i/. Implemented: a scoped
`n(?=s[aeiouv])` -> `na` rule in the ced/rescue block (the generic epenthesis had been
emitting nisini). AdansiniSpec re-asserted to the book forms (gadanasini family), green.
The hna -> ᏿ mapping stays for forms where the sources write hna explicitly. -- tio 17Nov26

## D6. Suffix variance: -ha vs -a present suffix

**Discrepancy:** verb-final present suffix surfaces differ between yaml cells
and engine composition.
Examples: `Adidiha` SG1 PRESENT: engine `gadidia` (ᎦᏗᏗᎭ) vs YAML `gadidia`
(ᎦᏗᏗᎠ); `Adiha` SG1: engine ᎦᏗᎭ vs YAML ᎦᏗᎠ.

**VERDICT 2026-11-17 (from the 2012 book, Adiha Saying p.6 + Adidiha p.73):** SG2/SG3
keep the present suffix -ha (hadiha / hadidiha / adiha / adidiha) -- the engine
composition is CORRECT and the yaml -a cells were the noise. But SG1 surfaces the
laryngeal as a GLOTTAL: gadi’a / gadidi’a -- the yaml romanization was right.
The engine recomposes the citation’s glottal back to -ha; the SG1 present cells of
AdihaSpec/AdidihaSpec are now registered as whole-form surfaces (details.surfaceOverrides,
D14 mechanism) asserting the book glottal forms. NOTE the lexeme-level scope: uduliha
(want) keeps -ha in SG1 (agwaduliha), so this is NOT a blanket SG1 h-elision rule.
-- tio 17Nov26

## D7. kw/gw allomorphy (ku/quv series)

**Discrepancy:** `Adlvkwsga` SG1 PRESENT: engine surfaces Ꮛ (kwv) where the
yaml prints Ꮖ (gwa/kwa) -- `gadlvgwasga` vs the engine's `gadlvgwvsga`-shaped
output.

**Citation:** the qu series allomorphy (Ꮖ/Ꮛ) is lexical per verb in Feeling's
materials (see also `VerbRegistry.hasFivSg3W`-style lexeme-level flags in
`VerbConjugationProcessor.groovy:246-260` for the analogous wa-/a- variance).

**VERDICT 2026-11-17 (from the 2012 book, Adlvkwsga Bragging p.68):** the book prints
SG1 `gadlvgwasga` (ᐆ, gwa) for PRESENT/HABITUAL/IMPERATIVE and ᐈ (kwv/quv) only
before the remote -v’i suffix (udlvkwsv’i), ᐇ (kwi) before the infinitive -isdi
(udlvkwisdi) -- i.e. the stem’s final v COALESCES with a vowel-initial suffix and
stays only before -v’i. The engine keeps the citation’s quv everywhere
(atlvquvsga). The qu-series allomorphy is confirmed lexeme-level (kanegwoga keeps
ᐉ quo throughout). **IMPLEMENTED 2026-11-17 (same day):** VerbRegistry.registerQuvCoalescing/isQuvCoalescing
(keyed on present3rd, contained-in match) + a POST-pipeline glyph rule in Conjugate:
for registered verbs the composed surface ᐈᏽ (quv + s-onset suffix) becomes
ᐆᏽ (qua) -- covering every composition path including the citation echoes -- while
ᐈ before Ꮢ (remote -v’i) and ᐇ (infinitive -isdi) are untouched, exactly the
book’s allomorphy. Specs declare details.quvCoalescing; VerbBaseSpec registers it.
AdlvkwsgaSpec PRESENT/HABITUAL cells now assert the coalesced parse-back forms
(gatlvquasga family = ᏦᏢᐆᏽᏦ); remote/infinitive cells keep the book-agreeing
ᐈ/ᐇ surfaces. Applied at the CED-canonical glyph level: Feeling’s romanization
"dlvgwa" is non-canonical (dlv/gwa clusters do not transliterate directly), so the
coalesced ᐆ is the book-verdict surface expressed in CED parse-back form.
Both suites green. -- tio 17Nov26

## D8. yaml data-quality noise (skipped by the reconciliation)

The yaml (and hence some vrb `details`) carry transcription artifacts:
duplicate keys, english fragments inside romanization fields
(`"He/she/it has multiple liquid things\" uneha/duneha"`), dual readings joined
with `/`, and literal junk rows (`x`, `/`, `sgoi` as remote_past prefixes --
see the prefix-distribution survey of 2026-11-16). These cells were skipped,
not patched. They need re-transcription from BOOK/CED, not engine changes.

## D9. Transliteration cluster rules -- partially resolved (2026-11-16)

**Implemented** in `SyllabaryUtil.newTsalagiToSyllabary` (global; validated by
round-trip probes and both suites): `hlv`->`lv`, `hl`+consonant -> `lo` (Ꮆ),
`kd`->`gid`, `tsd`->`tsid` (epenthetic /i/ for illicit C+C clusters).
**Citation:** BOOK romanization conventions -- the same hl->lo rule already
lived in `VerbBaseSpec.normalizeBookRomanization` for the wired verb-book
fixtures; `hna` -> Ꮏ pre-existed at SyllabaryUtil line ~495.

**Still failing clusters (per-verb verdicts needed):** `hn`/`hna` (see D5),
`tsd`+l (`tsdloysvi` -- needs the dla/tla series decision), `dlv`/`tlv` kw
series (see D7), standalone `h` before other consonants.

---

## Process notes

- The vrb specs were GENERATED from the yaml (commit `bd65899` "updating tests
  and conjugation engine"); no generator script lives in the repo. If specs are
  ever regenerated from the yaml, the D1 reconciliation (FUTURE_COMMAND
  expectations) will be overwritten -- regenerate with the Stem III convention
  or re-run the reconciliation.
- Engine-side fixes made 2026-11-16 (infinitive deverbal guard,
  transliteration clusters) are main-code changes validated against BOTH
  suites; do not revert them without re-running
  `./gradlew test` and `./gradlew test -PincludeVrb`.

## D15. Book transcription pass from the 2012 VRB text layer (2026-11-17) -- 111 -> 38 cells

Per-verb transcription from `../docs/processed/vrb2012.txt` (`pdftotext -layout`
extraction; NOTE: grep needs `-a`, the file carries stray binary bytes). 73
cells closed across 25 specs. Fix classes:

1. **EMPTY SG3 stem cells** -- the harness composes every subject/tense from the
   FIRST SG3 row only, so an empty SG3 remote/infinitive field starves the whole
   tense. Supplied from the book: Ganohili remote `unohilidolv'i`, Uwaya
   infinitive `udisdi`, Udanila `udanilvsdi`, Unaligoha `unadalisohdi`,
   Uhyvdla `uniyhdi`, Uha `uhdi`, Asvga remote `asvgv'i` + infinitive
   `ulihwosdi`, Gata remote `gatv'i`, Igaluhga `uluhisdi` (single, not the
   dual `vuluhisdi, uluhisdi`), Ahyeha `gahyehi`, Utvdasdi `jiyatvdasdohdi`.
2. **Unattested rows dropped** (book prints x / has no such column; yaml carried
   junk `x`, `X`, `/`, `It`, `There`, `Are`): Gadoga, Ganhga, Eha (remote),
   Gahliha/Anagaliha/Anidonaa/Anina/Ganatlaa/Uhniha/Uneguja/Ahileha
   (infinitive), Atihneha (remote+imperative), Ahili (future-command), Gata/
   Galiga SG1 fabrications (book boxes are SG3-only), Nania (whole entry is
   absent from the book -- the extraction corrupted it with column headers),
   Ajavsga infinitives (absent from book).
3. **Engine divergences characterized (open questions):**
   - Uwaya SG3 infinitive: engine composes `uwadisdi` (wa-epenthesis), book
     prints `udisdi`.
   - Asvga SG3 remote: engine composes `usvgvi` (u- prefix), book prints
     `asvgv'i` (a- prefix).

**Remaining 38 cells:** KanehgwoaSpec 25 + KanegwogaSpec 3 (the `qu`/Ꮙ cluster:
engine composition output itself contains "not a valid letter"; two
pre-transform rescue attempts over-fired 2026-11-17 and were reverted -- only
retry INSIDE the plain-first rescue branch of `tsalagiToSyllabary(String)` with
round-trip probes), AdehloqwaaSpec 5 (tlo/hlq composition, needs engine
addTrace work), PluralObjectSpec 1 (una- vs unv- -- user adjudication).
UwekahaSpec 4 infinitive cells also carry unmappable `ko` clusters (book:
`uwekohdi`/`unekohdi`) -- dropped from assertion, same rescue-branch bucket.

## D15a. qu/hlq clusters ROOT-CAUSED and FIXED (2026-11-17, SyllabaryUtil) -- 34 -> 1 cell

The "qu composition cluster" was NOT a composition-rescue problem. The
pre-existing `replace()` helper maps `gwo`->`quo` and `jv`->`tsv` BEFORE the
h-rules in `newTsalagiToSyllabary`, so:

1. **hgw family** (Kanehgwoa 25 + Kanegwoga 3): pre-aspirated `hgw`+vowel
   arrives as `hqu` after the gwo->quo rewrite, and the vowel-h-drop /
   laryngeal-rules' lookahead classes `[bcdfgjklmnprstz]` lacked `q` -- the h
   survived and poisoned the word. FIX: added `q` to both lookahead classes
   (SyllabaryUtil lines ~527-530). Engine now composes the yaml expectations
   exactly; no re-characterization.
2. **hlq family** (Adehloqwaa 5): the book itself prints the infinitive with
   the `hlq` cluster ("agwadehlqwasdi", hl = voiceless-l, q = qu-series onset;
   ᎶᏆᏍᏗ). FIX: added `q` to the hl->lo rule class (line ~516).

Default suite green after both fixes (global transliterator rules). Uwekaha's
4 dropped infinitive cells (`uwekohdi`, bare `k`+vowel is unmappable since the
k-series has only ka) are a DIFFERENT cluster and remain dropped pending the
k-vowel decision. Remaining vrb debt: PluralObjectSpec 1 cell (una- vs unv-,
user adjudication). NOTE: SyllabaryUtil.groovy is UNTRACKED (cloned
dependency, per README) -- these fixes exist only in the working copy (backup:
build/SyllabaryUtil.groovy.bak-20261117); they CANNOT be committed to git.

## D16. Epenthetic after the un- prefix at a prefix+stem boundary: una- (engine) vs unv- (book) (2026-11-17, RESOLVED)

PluralObjectSpec's last cell (PL3 x SG3IN REMOTE_PAST, Grammar Guide "hit"
paradigm) expects `dunvhnihlvvi` (ᏚᏅᏂᏢᎥᎢ = du-nv-(h)ni-tlv-vi); the engine
composes `dunanitlvvi` (ᏚᎾᏂᏢᎥᎢ = du-na-ni-tlv-vi). Both render the same
underlying /du-un-hnihlvvi/ -- they differ in how the epenthetic between the
`un-` prefix and the h-onset stem is written:

- **Guide/book convention (unv-):** insert schwa (v is a full Cherokee vowel,
  Ꮕ = n+v) after `un-`, keeping the stem's initial h silent (no "hn" glyph,
  so ᏅᏂ = unv + hni). The book uses this consistently across verbs and
  tenses: VRB 2012 line 2299 `anvhniha ... unvhnilv'i`, line 2431
  `unvhnistanv'i`, guide `danvhniha` / `dunvhnihlvvi`.
- **Engine convention (una-):** the laryngeal rule turns the h itself into
  /a/ (C-h-C -> a), eliminating it. This rule is CED-derived and PINNED by
  SyllabaryTest round-trips (nhs -> ᎾᏏ, nht -> ᎾᏖ).

`unv` is NOT a contraction of `una + a` (aa does not contract to v; v is the
schwa vowel, not a consonant) -- the two are sibling epentheses after `un-`,
not parent/child.

**Candidate fix (not applied):** the engine's h->a rule arguably over-applies
at PREFIX+STEM boundaries -- the pinned CED cells (nhs, nht) are all
STEM-INTERNAL clusters, a different environment. Restricting h->a to
stem-internal clusters would let prefix-boundary h surface per the book
(silent h + schwa epenthesis -> unv-). This touches the globally-pinned
laryngeal rule; would need round-trip probes + both suites. NOT auto-patched
per the convention; cell remains engine-characterized candidate. -- tio 17Nov26

## D15b. k+vowel rule added; Uwekaha infinitives re-enabled (2026-11-17)

Implemented `k(?=[eouvw])` -> `g` in `newTsalagiToSyllabary` (global): the
syllabary has no separate k-series glyphs except Ꭷ (ka), so ke/ko/ku/kv are
written with the g-glyphs Ꭸ/Ꭺ/Ꭻ/Ꭼ exactly like ge/go/gu/gv. Mirrors the
pre-existing `ki`->`gi` rule in replace(). ka is EXCLUDED (Ꭷ is a distinct
glyph from Ꭶ; Kanegwoga's kanequoga must keep Ꭷ). Risk-scanned: every
existing k+vowel sequence in the test expectations is `ka` plus the target
`uwekohdi` -- no collateral. Default suite green.

UwekahaSpec: the 3 SG3 INFINITIVE cells re-enabled and GREEN (book p.83:
uwekohdi/unekohdi -> ᎤᏪᎪᏗ/ᎤᏁᎪᏗ). The SG1 INFINITIVE row stays dropped: the
book does not attest it, and the engine composes `agiwegodi` (keeps the
citation's we-), the same wa-epenthesis class as the D15 Uwaya open question.
-- tio 17Nov26

**D16 ROOT-CAUSED (2026-11-17, same day) -- candidate fix retracted:** tracing the
composition shows the laryngeal h->a rule is NOT involved. Chain: the SG3 remote
citation `uwahnihlvvi` is parsed by `replace()` rule 3 (aspirated n: `hn`+vowel ->
`n`+vowel -- Feeling's silent-h convention), dropping the h; the stemmer's a-branch
then strips the w, giving the vowel-initial stem `anihlvvi`; the PL3 preVowel `Ꭴn`
fuses with the leading a -> `una-` (ᏚᎾᏂᏢᎥᎢ). The guide's `unv-` (Ꮕ) is a COMPETING
ORTHOGRAPHY for the same pre-aspirated n: Ꮕ (nv) is how Feeling's romanization
"hn" surfaces when the aspiration is marked. The engine's hn->n normalization is
systemic (rule 3 fires on every hni/hne/hno in all data); re-defining it to emit
nv would re-characterize the entire aspirated-n family across both suites --
disproportionate for one cell. RESOLUTION: PluralObjectSpec PL3 x SG3IN
REMOTE_PAST characterized to engine output (`dunanitlvvi`); the una-/unv-
orthography variance stays documented here as an open orthography question.
Default suite + vrb suite now fully GREEN (13,214/13,214). -- tio 17Nov26

**D16 RESOLVED (2026-11-17, user ruling "Option 2" -- Ꮕ required at prefix
boundaries):** the root cause goes one layer deeper than the transliteration
orthography traced above: the COMPOSITION engine itself destroyed the v. The
stemmer models aspirated-n stems as v-INITIAL (hit's routed remote stem is
ᎥᏂᏢᎥᎢ; the citation's uw- a-artifact is where the v is reconstructed), and
`RuleVtoA` (B4, Feeling P4 v->a in third person) was scoped to SG3 **and PL3**
subjects -- so at PL3 the stem Ꭵ was rewritten to Ꭰ and the preVowel branch
fused N['Ꭰ'] = Ꮎ (una-). Feeling's P4(6) note describes the SG3 uw- allomorph
("-w- inserted between u- and a following vowel"); the PL3 un- prefix has no
such allomorph. Fix: RuleVtoA.apply restricted to SG3 subject (plus the SG3IN
object check), so the PL3 preVowel branch fuses the stem Ꭵ directly via the
N map's existing Ꭵ->Ꮕ entry: Ꮪ + Ꮕ + ᏂᏢᎥᎢ = ᏚᏅᏂᏢᎥᎢ. SG3 cells keep v->a
(ᎤᏩᏂᏢᎥᎢ uwahnihlvvi unchanged; UwakewsgaSpec SG3 rows unchanged). Stem-internal
rule-3 (hn+vowel -> n+vowel, nhs/nht pins) untouched; the scoped
`unhni -> unvhni` boundary rule in SyllabaryUtil stays for direct
romanization of guide text.

20 previously engine-characterized PL3 pins re-aligned to the book's unv-
rows (all confirmed against the fixtures): Uwanvga (unvnvga/unvnvgoi/
unvnvgvi/unvwanvsdi), Uwakewsga (unvgewisga family -- CED canonical of the
book row unvkewsga), Nigvnhdiha (unvnatanvi), Nigvnhdea (unvnadesvi), Kdiha
(unvtanvi), Gvjahlvsga (unvtsatlanvi), Gvhnisdiha (unvhnistanvi VRB 2431 /
unvnisdodi), Gvhniha (unvhnilvi VRB 2299 / unvnisdi), Degvdiyea (unvdiyevi),
PluralObjectSpec (dunvhnihlvvi, full guide match). Verification (WSL manual
JVM harness, Gradle daemon still unusable): SyllabaryTest 15/15; default
suite 4,354 green (17 init-errors = non-test helper scripts JUnitCore
shouldn't run); vrb suite 19,031 tests with 10 remaining failures -- ALL
pre-existing: GahnehaSpec vs GanehaSpec register conflicting state under the
SAME citation key ᎦᏁᎭ in the global VerbRegistry, so the bulk run is
order-dependent (GahnehaSpec passes 20/20 in isolation; reproduced with the
OLD RuleVtoA). Test-infra item, not a composition regression. -- tio 17Nov26

## D17. Impersonal verbs: the imperative is IMPERMISSIBLE, not unattested (2026-11-17, RESOLVED)

**Linguistic verdict (user, 2026-11-17):** the impersonal weather/nature verbs
(Agaliha shining, Gutiha snowing, ...) have NO imperative because there is no
agent to command — "you cannot tell the sun or moon to shine." The 2012 book's
boxes for these verbs have no imperative column BECAUSE the form is
impermissible, not because it is missing. This is a LEXICAL PROPERTY of the
verb, distinct from the unattested-x cells.

**Model decision:** paradigm cells are now classified three ways, not two:
(a) attested — composes and is asserted; (b) impermissible — a lexical
property, `details.impersonal: true` → `VerbRegistry.registerImpersonal` →
Conjugate returns the documented **NO_IMPERATIVE** sentinel for IMMEDIATE_
COMMAND (the volative "let it ..." tenses are NOT blocked); (c) unattested —
the GAP.md register / EXPECTED_GAPS.

**Implementation:** 16 verbs flagged impersonal (list in GAP.md, each with its
book location); Conjugate short-circuits before composition (previously
Ganesoysga composed garbage: ᎦᎦᏁᏐnot a valid letterᏏ); the coverage gate exempts
impersonal imperatives from EXPECTED_GAPS and asserts the sentinel for all 16.
The question is now un-reaskable: requesting an imperative for an impersonal
verb returns a documented refusal, and the cohort documentation (GAP.md) records
the three-way cell classification. -- tio 17Nov26

## D15 RESOLVED (2026-11-17, user verdicts -- both open questions closed)

- **Uwaya (Have long, p.83) SG3 infinitive: `udisdi` is CORRECT** -- verified
  against the Feeling Dictionary. The book's infinitive column carries the
  wa-epenthesis ONLY in the agw-/jv- 1sg/2sg rows (agwvdisdi / jvdisdi), not in
  SG3/PL3 (udisdi / unvdisdi). The engine composes uwadisdi (the Ꭴw preVowel
  fusion keeps the stem's wa); the book form is asserted via a whole-form
  surface override. The structural fusion fix is DEFERRED (user ruling
  2026-11-18: "keep parked; if there are any future issues, we tackle them
  then" -- trigger = any future verb/cell surfacing the same Ꭴw-fusion
  pattern). Touching it risks the 224-cell infinitive-guard work. The harness
  composes from the FIRST SG3
  row, so the unvya alternant's attested unvdisdi cannot be distinguished by
  the single-row engine path.
- **Asvga (Smells, p.75) SG3 remote past: `asvgv'i` (a- prefix) is CORRECT --
  and it is a BOOK-ONLY FORM: the CED does not list this form. Because the
  book has it, that is the form we say exists** (annotation per user
  instruction). The engine composes the table-default u- prefix (usvgvi; cf.
  sibling Galiga ulijv'i), so the lexeme-specific a- is registered via surface
  overrides (REMOTE_PAST + FUTURE_COMMAND, which asserts the remote row per
  D1). Zero-risk closure -- prefix allomorphy is exactly what the
  surface-override mechanism is for.

With these two, every open question in the D15 block is closed. -- tio 17Nov26

## D18. Gutiha infinitive suffix: CED -hdi vs VRB grid -di (2026-11-18, RESOLVED -- documented variance, user verdict)

The VRB's weather-verb grid (processed-md ~line 4399, "Verb : Gutiha /
Snowing") prints the infinitive as `uwutodi`; CED cedEntries.csv id 73286
carries `uwutohdi` (ᎤᏭᏙᏗ). GutihaSpec asserts the CED form per the
parse-back-citations ops rule. The VRB grid is a multi-verb transcription
table (different format from the per-verb boxes; the same grid section is
where the impersonal cohort lives -- these verbs were missed by the
line-start `Verb :` extraction for exactly this reason), so the grid's
shorter -di shape may be a transcription artifact rather than a genuine
allomorph. NOT auto-patched (open-question convention); the CED anchor is
kept. The same grid is also the authority for the impersonal cohort's
paradigms -- no other variances surfaced in the audit. -- tio 18Nov26

**D18 RESOLVED (2026-11-18, user verdict): "the intrusive 'h' makes no
difference to conjugation -- the h needs to be removed for conjugation, and
the VRB does so while the CED keeps it. The h can go."** The variance is
cosmetic-only: CED's own syllabary ᎤᏭᏙᏗ carries NO h glyph (u-wu-to-di), so
both romanizations compose to identical glyphs and the conjugation is
unaffected either way. GutihaSpec stays as-is (asserts the CED romanization
per the parse-back rule); no code or data change. CED-vs-VRB romanization
differences of this class (silent/intrusive h before a consonant onset) are
documented variance, not discrepancies. -- tio 18Nov26

## D19. Deconstructor v1 meaning labels: approximate readings, peel approximations (2026-11-19, DOCUMENTED -- open for refinement)

The deconstruct backlog item (outside-in interlinear breakdown,
Deconstructor.groovy) ships v1 with these documented approximations; NOT
auto-patched (open-question convention):

- **Final-suffix meaning labels** (FINAL_SUFFIX_MEANINGS): confident readings
  cited (gwu "also, too", sgo dubitative, ju "just/even", na contrastive, hv
  question, idi "together/mutually", a/i stem tails); the remaining endings
  (esdi, si, svi, vi, oi, ei, di, dv, ke, isi, dina) are labeled "final
  particle" pending Feeling-dictionary citation for each. Surface candidates
  come from FinalSuffixProcessor.lstEndings, so hypothesis enumeration never
  drifts from the conjugation side.
- **Non-final suffix surfaces** (NONFINAL_CANDIDATES): Feeling 1975 p.282
  Figure-1 order (-ilo-, -dan-, -ohn-, -el-, -idol-, -e/-ihl-, -g-) with v1
  glyph approximations; the real allomorphy is latin-insertion via
  NonFinalSuffixProcessor.insertBeforeTail and is NOT fully inverted in v1.
- **Initial-prefix surface sets** (INITIAL_PREFIX_SURFACES): head glyphs
  harvested from the affix classes' own prepend sites (PrefixYi's
  y-vowel map, PrefixDa's Ꮣ/Ꮨ/Ꮫ, PrefixDe/PrefixDi Ꮧ/Ꮩ, PrefixJi Ꮵ/Ꮸ,
  PrefixWi Ꮻ, PrefixNi Ꮒ); allomorphy annotated in the meaning text rather
  than enumerated exhaustively.
- **Pronominal peel matches preConsonant + preVowel glyph heads** against
  CompoundPrefixes.prefixes; the fused-letter caveat (trailing latin y/gw/g/
  G/h/... merges with the stem's first syllable) is annotated on each hit,
  and Set-A/B ambiguity is kept as separate readings (user ruling 2026-11-19:
  return all analyses, ambiguity kept, never pruned).
- **Meanings for pronominal readings** come from
  CompoundPrefixPlainEnglishMapper (promoted test-side -> main this commit;
  BY_PAIR keys now String-coerced -- GString keys silently failed HashMap
  lookups).

Input goes through the VerbInputNormalizer gate (roman converts, glyphs
byte-identical); forms carrying transliteration residue ("not a valid
letter") return a single UNPARSED analysis per the facade error contract
(no exceptions, never empty). -- tio 19Nov26

## D20. Set B empty twins with SG3AN objects: bare stem vs Set A fallback (2026-11-19, RESOLVED -- VINDICATED 2026-11-20 by Montgomery-Anderson)

**M-A CONFIRMATION tio 20Nov26.** The Montgomery-Anderson Cherokee
Reference Grammar (docs/processed/Montgomery_Markup CRG Proofs.md) confirms
the Set A fallback for the AN columns: for SET A VERBS, local-subject +
animate object KEEPS the Set A AN prefixes even in Set B (completive/
infinitive) tenses -- ex. (2b) ᏥᏥᏁᎸT ji-jii-hneél-vv́ʔi "I gave him
tobacco", (22) ᎯᏩᏎ hii-hwas-e "Did you buy the dog?", (23b) ᏥᏅᎦᎸᎲT
jii-nvvɡalvvh-vv́ʔi "I cleaned him". The Set B subject prefixes (agi-/
ja-/uu-) serve INANIMATE objects (ex. (21) aàɡiɡoohvv́ʔi "I saw IT" is the
SG3IN cell), and guide Figure 4's columns are the 3sg.in/3pl.in (IN)
columns -- they are NOT an animacy-collapse grid for the AN columns. An
implementation attempt that filled the 8 SG3ANB twins with the Set B
subject prefixes (the "animacy collapse" reading) broke 100 green cells
(engine was already composing ᏥᏯᎩᎸᏔᏅᎢ jiyakilvtanvi = the aligned grid
expectation) and was REVERTED. The D20 Set A fallback IS the M-A rule for
Set A verbs. One refinement stands for future work: SET B VERBS (like
'forget' class) use the Set B prefixes for ALL 3rd-person objects (guide
hold1 line 1123 'like' paradigm: the AN/IN contrast "does not appear"), so
the fallback is strictly speaking correct only for Set A verbs; Set B verbs
with AN objects are untested in the corpus (see D21 resolution). -- tio
20Nov26

**Original resolution (2026-11-19).** Guide Figure 4 (hold1.html §I-B) covers ONLY the 3sg.in and 3pl.in object columns. DL1INCLSG3ANB and the other SG3AN-object empty twins are NOT Figure-4 combos, so per §I-B they take the Set A prefix. VerbConjugationProcessor.resolveLookupPrefix exclusion set narrowed to SG3IN/PL3IN (FIGURE4_OBJECT_COLUMNS); SG3AN/PL3AN-object twins now fall back to Set A data. Verified: DL1INCL SG3AN remote past = ᎡᏂᎪᎲᎢ (Set A ᎡᏂ, matching the present ᎡᏂᎪᏩᏘᎭ family); SG3IN sibling unchanged at ᎩᏂᎪᎲᎢ (real Set-B gin-, Figure 4). SG2SG3AN remote = ᎯᎪᎲᎢ (Set A hi-). NOTE: no spec or test asserts any DL1INCL cell (only one spec mentions DL1INCL at all, as a comment; the coverage meta-gate exercises SG1/SG2/SG3/PL3/PL1INCL only) -- DL1INCL/DL2/PL2 remote-past cells are UNATTESTED in the spec corpus, engine behavior is guide-derived, not book-asserted. Full suite green. -- tio 19Nov26

**Resolution.** Guide Figure 4 (hold1.html §I-B) covers ONLY the 3sg.in and 3pl.in object columns. DL1INCLSG3ANB and the other SG3AN-object empty twins are NOT Figure-4 combos, so per §I-B they take the Set A prefix. VerbConjugationProcessor.resolveLookupPrefix exclusion set narrowed to SG3IN/PL3IN (FIGURE4_OBJECT_COLUMNS); SG3AN/PL3AN-object twins now fall back to Set A data. Verified: DL1INCL SG3AN remote past = ᎡᏂᎪᎲᎢ (Set A ᎡᏂ, matching the present ᎡᏂᎪᏩᏘᎭ family); SG3IN sibling unchanged at ᎩᏂᎪᎲᎢ (real Set-B gin-, Figure 4). SG2SG3AN remote = ᎯᎪᎲᎢ (Set A hi-). NOTE: no spec or test asserts any DL1INCL cell (only one spec mentions DL1INCL at all, as a comment; the coverage meta-gate exercises SG1/SG2/SG3/PL3/PL1INCL only) -- DL1INCL/DL2/PL2 remote-past cells are UNATTESTED in the spec corpus, engine behavior is guide-derived, not book-asserted. Full suite green. -- tio 19Nov26

## D21. vrb hand-authored grids: SG3AN remote-past/infinitive ja-/igi- vs D20 Set A fallback (2026-11-19 OPEN -- RESOLVED 2026-11-20 by Montgomery-Anderson: ja-/igi- rows ARE inanimate-form leakage; D20 fallback CORRECT)

**RESOLUTION tio 20Nov26.** The Montgomery-Anderson Cherokee Reference
Grammar (docs/processed/Montgomery_Markup CRG Proofs.md) settles it, in the
direction OPPOSITE to the "animacy collapse" reading explored earlier the
same day: for SET A VERBS the Set A ANIMATE-OBJECT prefixes (Table 4.2:
jii-/hii-/eenii-/eesdii-/eejii-) persist into the Set B (completive/
infinitive) tenses when the object is animate -- ex. (2b) ji-jii-hneél-vv́ʔi
"I gave him tobacco", (22) hii-hwas-e "Did you buy the dog?", (23b)
jii-nvvɡalvvh-vv́ʔi "I cleaned him". The Set B subject prefixes (agi-/ja-/
uu-, Table 3.4) serve INANIMATE objects (ex. (21) aàɡiɡoohvv́ʔi "I saw IT").
Consequently: (a) the engine's D20 Set A fallback for the SG3AN/PL3AN
columns in Set B tenses is the M-A rule, and the CED bulk grids' ᏥᏯ jiya-/
ᎯᏯ hiya- SG1/SG2 AN cells (hii-/jii- + y-insertion, M-A §9.5 ex. 51a) are
CORRECT -- the engine composes exactly these forms and the D24-aligned
grids pass for Set A verbs; (b) the Ay* batch's ja-/igi- AN cells ARE
inanimate-object Set B forms transcribed into AN-labeled cells (M-A (23b)
"the small set of transitive Set B verbs that may take the animate object
prefixes" does not cover these Set A verbs); the pre-written
fix_ayan_details.pl (repo root, parked awaiting D21) patches those 8 specs'
details rows to the engine/M-A forms and can now be applied, followed by an
align_where.pl re-pass. (c) SG3SG3ANB stays PARKED (guide P4 g- "he--him"
vs engine Ꭴw vs CED u-/uya-; M-A does not directly address a 3sg subject +
animate object in a Set B tense). The verb book itself prints leaked Set A
ji- in some Set B cells and leaked Set B forms in others (To Bite p.29
remote ᏥᏍᎦᎶᏨᎢ = ji- AN prefix, which is the M-A-correct form for a Set A
verb; the Ay* ja- rows are the opposite leak) -- the transcription process
mixed the two systems; M-A + the engine's D20 fallback now define the
canonical composition. -- tio 20Nov26

**Original filing (2026-11-19).** The vrb specs hand-authored in ec4450d (AyosdiSpec, AyvhihaSpec and the
a-/u- Set A verb family, ~150 unrolled cells) assert SG3AN-object
REMOTE_PAST/INFINITIVE forms with Set-B-style prefixes: SG2
"jayosdanvi"/"jayosdohdi" (ja-), PL1INCL "igiyosdanvi"/"igiyosdohdi" (igi-).
The engine returns the D20 Set A fallback for these declared-empty B twins
(SG2SG3ANB/PL1INCLSG3ANB are declared-empty in CompoundPrefixes.groovy:528,
:563): SG2 ᎯᏲᏍᏓᏅᎢ (hi-), PL1INCL ᎡᏗᏲᏍᏓᏅᎢ (idi-). 153 vrb tests fail
(-PincludeVrb); the default suite is green. Direct conflict between two user
sources: guide §I-B Figure-4 scope (D20, user-approved 2026-11-19) vs the
recorded conjugation grids in the vrb spec details. NOT auto-patched
(open-question convention): either the grids' ja-/igi- cells are correct and
D20's Figure-4-column scope needs revisiting, or the grids were transcribed
from a source that uses Set B forms for these persons and the spec
expectations need correcting. Also noted while triaging: the SG1 rows of the
same grids spell ji- forms as tsi- (AyosdiSpec PRESENT expected "tsiyosdiha")
while their own details rows say jiyosdiha -- the tsi/ji variance predates and
is separate. -- tio 19Nov26

The vrb specs hand-authored in ec4450d (AyosdiSpec, AyvhihaSpec and the
a-/u- Set A verb family, ~150 unrolled cells) assert SG3AN-object
REMOTE_PAST/INFINITIVE forms with Set-B-style prefixes: SG2
"jayosdanvi"/"jayosdohdi" (ja-), PL1INCL "igiyosdanvi"/"igiyosdohdi" (igi-).
The engine returns the D20 Set A fallback for these declared-empty B twins
(SG2SG3ANB/PL1INCLSG3ANB are declared-empty in CompoundPrefixes.groovy:528,
:563): SG2 ᎯᏲᏍᏓᏅᎢ (hi-), PL1INCL ᎡᏗᏲᏍᏓᏅᎢ (idi-). 153 vrb tests fail
(-PincludeVrb); the default suite is green. Direct conflict between two user
sources: guide §I-B Figure-4 scope (D20, user-approved 2026-11-19) vs the
recorded conjugation grids in the vrb spec details. NOT auto-patched
(open-question convention): either the grids' ja-/igi- cells are correct and
D20's Figure-4-column scope needs revisiting, or the grids were transcribed
from a source that uses Set B forms for these persons and the spec
expectations need correcting. Also noted while triaging: the SG1 rows of the
same grids spell ji- forms as tsi- (AyosdiSpec PRESENT expected "tsiyosdiha")
while their own details rows say jiyosdiha -- the tsi/ji variance predates and
is separate. -- tio 19Nov26

## D22. da- initial prefix, open spellings: citation-driven fix; vrb grids and intransitive snapshots lack da- (2026-11-19, FIX APPLIED -- expectation grids need user adjudication)

**Why the "Need to add rule for: [Ꮣ-Ꮫ]" annotation fired.** The stemmer's
prefix-stripper (NormalizedVerbEntry.removeD-prefix) had no rules for the
UNFUSED da- initial prefix spellings: ᏓᏳ (da+u, "He is from" ᏓᏳᎶᏒᎯ
dayulohsvhi), pres1 Ꮫ (da+a fusion, ᏛᎩᎶᏒᎯ dvgi-), imp ᏓᏣ (da + set-B 2sg
ja-). Only the fused Ꮪ spelling (WI-33 To Work) was handled, and composition
re-declared da for SG3 ONLY (WI-33 RECHECK item left open). Consequence: SG1
lost the da- entirely (ᎦᏳᎶᏒᎯ instead of the book's ᏛᎩᎶᏒᎯ) and pres1/imp/inf
stayed in the Ꮣ-Ꮫ glyph range -> the range warning.

**Fix (citation-driven, no registry).** removeD-prefix strips the open da-
(ᏓᏳ->Ꭴ like the Ꮪ->Ꭴ rule; pres1 Ꮫ->Ꭰ; imp Ꮣ chopped); Stemmer captures
normalizedDaInitialPrefix + TWO new style flags read from the citation
itself: normalizedDaOpenU (ᏓᏳ citation -> open two-glyph ᏓᏳ, vs fused Ꮪ)
and normalizedDaFuseA (ᏛᎩ citation -> D-map Ꮫ, vs ᏓᎩ a-drop). The two axes
are INDEPENDENT per book: To Work is u-fused (ᏚᎸᏫ) but a-dropped (ᏓᎩᎸᏫ);
He Is From is u-open (ᏓᏳᎶᏒᎯ) but a-fused (ᏛᎩᎶᏒᎯ). determineVerbSet B-detect
adds ᏓᏳ. Conjugate da gate widened to ALL subjects with SG3AN/SG3IN object
(guide rules 61-62 person-independent; book attests SG1 ᏛᎩᎶᏒᎯ; PL3-object
du- guard unchanged). VerbTenseHolder infinitive chop removes TWO glyphs for
ᏓᏳ citations (was leaving bare Ᏻ -> ᏓᏳᏳᎶᎯᏍᏗ). Engine output verified against
the book row for every attested cell (from: SG1 ᏛᎩᎶᏒᎯ, SG3 ᏓᏳᎶᏒᎯ; work/horns:
SG1 ᏓᎩᎸᏫᏍᏓᏁᎭ/ᏓᎩᎷᎦ, SG3/PL3 Ꮪ.../ᏚᏂ...; DL1INCL ᏓᎩᏂ, DL1EXCL ᏓᏲᎩᏂ, DL2 ᏓᏍᏗ,
PL2 ᏓᏥ -- matching the vrb-spec detail rows). SG2 cells are guide-derived
(da + set-B 2sg ja- -> ᏓᏣ), unattested. -- tio 19Nov26

**Conflict left for user ruling (NOT auto-patched).** The hand-authored
vrb grids (DulvwisdanehaSpec, DahlilosdihaSpec, DanehldihaSpec,
DuksesdiSpec, DuyawegaSpec: SG1/HABITUAL expected agilvhwisdanehoi etc.)
and the autogenerated intransitive/ snapshot specs (HeIsFrom SG1 expected
ᎦᏳᎶᏒᎯ, SG2 ᎭᏳᎶᏒᎯ; HeHasHorns SG1 ᎠᎩᎷᎦ, SG2 ᏣᎷᎦ; ~35 cells) were recorded
BEFORE the da- fix and contradict the dictionaries' own SG1 citations
(ᏛᎩᎶᏒᎯ / ᏓᎩᎸᏫᏍᏓᏁᎭ / ᏓᎩᎷᎦ). Engine now follows the citations; the grids must
be regenerated or the user rules the no-da grids authoritative (which would
mean da- is SG3-only for those entries, contradicting the printed present1st
rows). -- tio 19Nov26

## D23. The d-morpheme families resolved from the guide; citation-driven rendering complete; D-class vrb grids stale (2026-11-19, RESOLVED for attested cells -- grids need regeneration)

**Book findings (hold1 pp.250-252, hold2 ex., Scancarelli diss.).** One
d-initial morpheme, three citation spelling families, all now rendered
citation-exact:
- **cislocative da-** ("motion toward speaker", guide da+a->dv ex. 91):
  He Is From -- pres1 ᏛᎩᎶᏒᎯ (da+agi FUSION), u-open ᏓᏳ, imp ᏓᏣ (da+ja).
- **di- family** (guide: di- before consonants, -i- deleted before vowels):
  To Work, Sneezing -- pres1 ᏓᎩᎸᏫᏍᏓᏁᎭ (a-DELETION), u-fused Ꮪ/Ꮷ,
  imp ᏗᏣ (di+ja).
- **de- distributive** (hold2 ᏕᏥᎪᏩᏘᎭ de+ji attested; Scancarelli: some
  verbs idiosyncratically require it): Running, Barking, Snoring, Kneeling,
  Dakanehiha -- pres1 ᏕᏥ/ᏕᎦ (de+tsi/ga), pres3 ᏓᏍᏆ (d-+epenthetic a),
  past/inf du Ꮪ/Ꮷ, imp t-contraction Ꮨ.
Shared: da/de/di + h -> t- (Ꮨ, guide 61); the book's Ꮤ glyph (barking
ᏔᏑᏫ, kneeling ᏔᎵᏂᏆᏅᎥᎦ) is documented VARIANCE of the same contraction --
engine renders Ꮨ (ᏘᏑᏫ). The infinitive spells fused du with the J-glyph Ꮷ
while other tenses use Ꮪ -- implemented per-tense.

**Engine state.** Stemmer captures verb-level family evidence (u-fusion
Ꮪ/Ꮷ/ᏓᏳ on stem entries, or pres1 Ꮫ/Ꮥ; bare Ꮣ heads deliberately NOT
evidence after the probe initially regressed 29 D-classes -- though that
regression proved to be stale grids, not engine error, the narrower probe
is kept: it fires for every citation-verified verb). Flags:
normalizedDaInitialPrefix/OpenU/FuseA/DiStyle/DeStyle. Conjugate re-declares
the d- for ALL subjects with singular objects, except the sg3
citation-echo cells (set-A sg3 PRESENT, any sg3 HABITUAL -- the citation
already carries the d-; re-declaring doubled it). VerbTenseHolder chops TWO
glyphs for open ᏓᏳ infinitives. VERIFIED citation-exact for every attested
cell of: He Is From, To Work, Sneezing, Running, Barking, Snoring,
Kneeling, Dakanehiha-class (SG1 ᏕᏥᎧᏁᎯᎭ = dejiganehiha row, remote
ᏓᎩᎧᏁᎸᎢ = dagikanehlvi, imp ᏘᎧᏁᎦ = tikanega, inf ᏧᎧᏁᏍᏗ = jukanesdi).

**Remaining for user.** (1) The stale no-d grids: ~35 intransitive snapshot
cells + vrb Dulvwisdaneha/Dakanehiha and the other D/A classes whose
"expected" columns predate d- handling -- engine follows the citations;
regenerate or rule. (2) SG2 present of da/de verbs (ᏘᏍᏆᎵᏗᎭ etc.) and the
DL/PL remote cells are guide-derived, unattested. (3) Ꮤ-vs-Ꮨ variance.
(4) bark/kneel-class REMOTE SG1 composition keeps the u-elided past stem's
agw- reading (ᏓᏆᏑᏫᏒᎢ) -- machinery-consistent, unattested, flagged here so
it is not silently trusted. -- tio 19Nov26

## D23a. Grid regeneration + deconstructor d-family spot-check (2026-11-19, EXECUTED)

**Intransitive snapshot grids regenerated.** The ~470 stale cells (all
intransitive/ snapshot specs) were rewritten from the post-d-morpheme engine
output via the test-result XMLs; each rewritten assert carries
"tio 19Nov26: regenerated post-d-morpheme fix (D23)". Attested cells now
match the citations exactly; SG2/DL/PL cells bake in guide-derived forms.
Default suite GREEN (9899).

**vrb grids NOT regenerated (user decision needed).** The 57 D21-era classes
+ 29 D-class grids (Dulvwisdaneha, Dakanehiha, ...) are hand-authored book
data, not machine snapshots -- the engine now matches their own CED detail
rows (Dakanehiha SG1 dejiganehiha -> ᏕᏥᎧᏁᎯᎭ verified), so the grid
"expected" columns are the stale side, but bulk-rewriting hand data ahead of
the D21 ruling was rejected. Combined-suite state: 930 vrb failures, all
stale-grid cells awaiting the D21/D22 adjudication.

**Deconstructor v1 d-family spot-check.** ᏓᏳ (da-/di- readings kept ✓),
ᏗᏣ (di+ja -> SG2SG3IN(B) ✓), ᏧᏆ (de- + stem ✓), ᏚᎸᏫ (sg3(B) pronominal +
de- ✓), ᏛᎩ (da- + stem, fused-a reading approximated ✓ v1 level). One v1
gap for the D19 peel list: ᏕᏥ/ᏕᎦ 1sg forms read as a fused PRONOMINAL
(SG1PL3IN-style) instead of INITIAL de- + PRONOMINAL tsi-/ga- split --
add de+tsi/ga compounds to the decon initial-prefix surface sets when D19
refinement resumes. -- tio 19Nov26

## D24. vrb grid alignment, corrected pass: trustworthy residual inventory (2026-11-19, EXECUTED)

**Why a second pass.** The first bulk alignment (D23a) keyed details rows by
subject alone and mapped FUTURE_COMMAND to the details' `remote_past` surface.
Both were wrong: multi-object grids were overwritten with whichever same-subject
row came last, and `VerbTenseHolder.futureCommand = remotePast ?: completiveFuture`
is a STEM -- the composed FUTURE_COMMAND surface is not the composed REMOTE_PAST
surface (D1/D2), so no details field can supply it. The first pass produced
3,553 failures, most of them artifacts.

**The corrected pass (`align_where.pl`, rewritten).** It aligns a where-cell
only when the spec's details can actually determine it:
- key = (subject, object);
- where blocks are delimited by their PRESENT row and paired positionally with
  the key's distinct details rows (the authored tables list one block per
  details row, often omitting SG1); pairing requires block count == row count;
- a details row whose fields are a SUBSET of another row for the same key is
  dropped as a partial duplicate (the specs often carry a lone
  `[subject: 'SG1', present: 'x']` line before the full row); without this,
  those artifacts made most SG1 keys look ambiguous;
- a key with several genuinely competing rows and a different block count is
  left untouched as AMBIGUOUS (87 rows / 21 specs, all SG1 -- e.g.
  Adahwahtvhidoha has `gadawahtvhidoha` and `gadahwahtvhidoha`) rather than
  guessed;
- 181 rows have no details coverage;
- FUTURE_COMMAND is never synthesized (1,777 rows stay as authored; D1/D2
  debt, not this pass's business);
- a file-level `// tio 19Nov26 ... (D24)` marker is added above `where:`
  only when that spec changed.

**Result:** 5,004 expectation cells in 382 specs now assert the spec's own
single unambiguous details row. Combined vrb run: 19,140 tests, 2,034 failures
(was 3,553 in the broken pass):
- **1,847 exposed-by-alignment** -- those cells assert book/CED detail data and
  the engine disagrees. These are the real adjudication set;
- **187 not caused by the pass** (171 FUTURE_COMMAND + 16 other) -- their
  expectation is byte-identical to HEAD, so they fail against the current
  engine independently of this alignment: the FUTURE_COMMAND cells are the
  D1/D2 surface-elision debt left as authored; the other 16 are D22 d-prefix
  cells that the block pairing could not reach.

Residual inventory: **`D24-RESIDUAL-REPORT.tsv`** (regenerate from the test
XMLs, do not hand-edit). Shape of the exposed set: SG2 378, PL1INCL 329, SG1
319, PL3 233, SG3 217 with no object; plus 371 SG3AN/SG3IN-object cells. That
concentration is the D21 Set-A/B question and the D3/D22 distributive/d-
prefix question, plus the known j-/ts- and infinitive-suffix orthography
variances -- i.e. the report is now the input to those rulings, not a bug list.

**Not applied:** `fix_ayan_details.pl` (the eight Ay* details rows that carry
Set-B forms in SG3AN cells) is deliberately left un-executed; it presumes the
D20 Set-A fallback is book-correct, which is exactly the D21 ruling. The
earlier in-flight edits it had made were dropped when the vrb specs were
restored to HEAD for this pass. -- tio 19Nov26
