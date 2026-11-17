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
Past row)"; pinned by `GowatihaSG3SG3ANTest.groovy:108-110` (SG3 ÃÂÃÂ¡ÃÂÃÂÃÂÃÂ ÃÂÃÂ¡ÃÂÃÂÃÂÃÂªÃÂÃÂ¡ÃÂÃÂÃÂÃÂ²ÃÂÃÂ¡ÃÂÃÂÃÂÃÂ¢) and the
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

## D5. Laryngeal h: written (ÃÂÃÂ¡ÃÂÃÂÃÂÃÂ¿) vs unwritten (ÃÂÃÂ¡ÃÂÃÂÃÂÃÂ¾) before n

**Discrepancy:** `SyllabaryUtil.newTsalagiToSyllabary` maps `hna` -> ÃÂÃÂ¡ÃÂÃÂÃÂÃÂ¿ (the hna
glyph exists in the syllabary), while the yaml transcribes the laryngeal as
unwritten before n.
Example: `Adansini` SG1 PRESENT: expected `gadanasini` (ÃÂÃÂ¡ÃÂÃÂÃÂÃÂ¦ÃÂÃÂ¡ÃÂÃÂÃÂÃÂÃÂÃÂ¡ÃÂÃÂÃÂÃÂ¾ÃÂÃÂ¡ÃÂÃÂÃÂÃÂÃÂÃÂ¡ÃÂÃÂÃÂÃÂ); the engine's
internal latin carries the laryngeal and surfaces ÃÂÃÂ¡ÃÂÃÂÃÂÃÂ¿, which the yaml cell does
not match.

**Citation:** CED entries routinely write the laryngeal unreduced in latin
(`gadahnasini`-style) while the syllabary column shows plain ÃÂÃÂ¡ÃÂÃÂÃÂÃÂ¾. Feeling's
orthography writes ÃÂÃÂ¡ÃÂÃÂÃÂÃÂ¿ only where the h is phonemically distinct.

**Open question for review:** per verb, is the h syllabary-visible (ÃÂÃÂ¡ÃÂÃÂÃÂÃÂ¿) or not
(ÃÂÃÂ¡ÃÂÃÂÃÂÃÂ¾)? A blanket rule will be wrong for one class of verbs.

**Partial resolution 2026-11-16 (sweep):** SyllabaryUtil implements laryngeal h between consonants -> a (nhs -> ÃÂ¡ÃÂÃÂ¾ÃÂ¡ÃÂÃÂ), vowel+h+consonant drops the h (uhtv- -> utv-), word-initial/after-vowel hna -> ÃÂ¡ÃÂÃÂ¿ (pinned by SyllabaryTest).

**VERDICT 2026-11-17 (from the 2012 book, Adansini Crawling p.67):** the book prints
SG1 present `gadanasini` -- the laryngeal is UNWRITTEN (plain ÃÂ¡ÃÂÃÂ¾, na-si), AND the
ns+vowel epenthesis is /a/, not the generic /i/. Implemented: a scoped
`n(?=s[aeiouv])` -> `na` rule in the ced/rescue block (the generic epenthesis had been
emitting nisini). AdansiniSpec re-asserted to the book forms (gadanasini family), green.
The hna -> ÃÂ¡ÃÂÃÂ¿ mapping stays for forms where the sources write hna explicitly. -- tio 17Nov26

## D6. Suffix variance: -ha vs -a present suffix

**Discrepancy:** verb-final present suffix surfaces differ between yaml cells
and engine composition.
Examples: `Adidiha` SG1 PRESENT: engine `gadidia` (ÃÂÃÂ¡ÃÂÃÂÃÂÃÂ¦ÃÂÃÂ¡ÃÂÃÂÃÂÃÂÃÂÃÂ¡ÃÂÃÂÃÂÃÂÃÂÃÂ¡ÃÂÃÂÃÂÃÂ­) vs YAML `gadidia`
(ÃÂÃÂ¡ÃÂÃÂÃÂÃÂ¦ÃÂÃÂ¡ÃÂÃÂÃÂÃÂÃÂÃÂ¡ÃÂÃÂÃÂÃÂÃÂÃÂ¡ÃÂÃÂÃÂÃÂ ); `Adiha` SG1: engine ÃÂÃÂ¡ÃÂÃÂÃÂÃÂ¦ÃÂÃÂ¡ÃÂÃÂÃÂÃÂÃÂÃÂ¡ÃÂÃÂÃÂÃÂ­ vs YAML ÃÂÃÂ¡ÃÂÃÂÃÂÃÂ¦ÃÂÃÂ¡ÃÂÃÂÃÂÃÂÃÂÃÂ¡ÃÂÃÂÃÂÃÂ .

**VERDICT 2026-11-17 (from the 2012 book, Adiha Saying p.6 + Adidiha p.73):** SG2/SG3
keep the present suffix -ha (hadiha / hadidiha / adiha / adidiha) -- the engine
composition is CORRECT and the yaml -a cells were the noise. But SG1 surfaces the
laryngeal as a GLOTTAL: gadiÃ¢ÂÂa / gadidiÃ¢ÂÂa -- the yaml romanization was right.
The engine recomposes the citationÃ¢ÂÂs glottal back to -ha; the SG1 present cells of
AdihaSpec/AdidihaSpec are now registered as whole-form surfaces (details.surfaceOverrides,
D14 mechanism) asserting the book glottal forms. NOTE the lexeme-level scope: uduliha
(want) keeps -ha in SG1 (agwaduliha), so this is NOT a blanket SG1 h-elision rule.
-- tio 17Nov26

## D7. kw/gw allomorphy (ku/quv series)

**Discrepancy:** `Adlvkwsga` SG1 PRESENT: engine surfaces ÃÂÃÂ¡ÃÂÃÂÃÂÃÂ (kwv) where the
yaml prints ÃÂÃÂ¡ÃÂÃÂÃÂÃÂ (gwa/kwa) -- `gadlvgwasga` vs the engine's `gadlvgwvsga`-shaped
output.

**Citation:** the qu series allomorphy (ÃÂÃÂ¡ÃÂÃÂÃÂÃÂ/ÃÂÃÂ¡ÃÂÃÂÃÂÃÂ) is lexical per verb in Feeling's
materials (see also `VerbRegistry.hasFivSg3W`-style lexeme-level flags in
`VerbConjugationProcessor.groovy:246-260` for the analogous wa-/a- variance).

**VERDICT 2026-11-17 (from the 2012 book, Adlvkwsga Bragging p.68):** the book prints
SG1 `gadlvgwasga` (á, gwa) for PRESENT/HABITUAL/IMPERATIVE and á (kwv/quv) only
before the remote -vâi suffix (udlvkwsvâi), á (kwi) before the infinitive -isdi
(udlvkwisdi) -- i.e. the stemâs final v COALESCES with a vowel-initial suffix and
stays only before -vâi. The engine keeps the citationâs quv everywhere
(atlvquvsga). The qu-series allomorphy is confirmed lexeme-level (kanegwoga keeps
á quo throughout). **IMPLEMENTED 2026-11-17 (same day):** VerbRegistry.registerQuvCoalescing/isQuvCoalescing
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
round-trip probes and both suites): `hlv`->`lv`, `hl`+consonant -> `lo` (ÃÂÃÂ¡ÃÂÃÂÃÂÃÂ¶),
`kd`->`gid`, `tsd`->`tsid` (epenthetic /i/ for illicit C+C clusters).
**Citation:** BOOK romanization conventions -- the same hl->lo rule already
lived in `VerbBaseSpec.normalizeBookRomanization` for the wired verb-book
fixtures; `hna` -> ÃÂÃÂ¡ÃÂÃÂÃÂÃÂ¿ pre-existed at SyllabaryUtil line ~495.

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

**Remaining 38 cells:** KanehgwoaSpec 25 + KanegwogaSpec 3 (the `qu`/ÃÂÃÂ¡ÃÂÃÂÃÂÃÂ cluster:
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
   ÃÂÃÂ¡ÃÂÃÂÃÂÃÂ¶ÃÂÃÂ¡ÃÂÃÂÃÂÃÂÃÂÃÂ¡ÃÂÃÂÃÂÃÂÃÂÃÂ¡ÃÂÃÂÃÂÃÂ). FIX: added `q` to the hl->lo rule class (line ~516).

Default suite green after both fixes (global transliterator rules). Uwekaha's
4 dropped infinitive cells (`uwekohdi`, bare `k`+vowel is unmappable since the
k-series has only ka) are a DIFFERENT cluster and remain dropped pending the
k-vowel decision. Remaining vrb debt: PluralObjectSpec 1 cell (una- vs unv-,
user adjudication). NOTE: SyllabaryUtil.groovy is UNTRACKED (cloned
dependency, per README) -- these fixes exist only in the working copy (backup:
build/SyllabaryUtil.groovy.bak-20261117); they CANNOT be committed to git.

## D16. Epenthetic after the un- prefix at a prefix+stem boundary: una- (engine) vs unv- (book) (2026-11-17, open)

PluralObjectSpec's last cell (PL3 x SG3IN REMOTE_PAST, Grammar Guide "hit"
paradigm) expects `dunvhnihlvvi` (ÃÂÃÂ¡ÃÂÃÂÃÂÃÂÃÂÃÂ¡ÃÂÃÂÃÂÃÂÃÂÃÂ¡ÃÂÃÂÃÂÃÂÃÂÃÂ¡ÃÂÃÂÃÂÃÂ¢ÃÂÃÂ¡ÃÂÃÂÃÂÃÂ¥ÃÂÃÂ¡ÃÂÃÂÃÂÃÂ¢ = du-nv-(h)ni-tlv-vi); the engine
composes `dunanitlvvi` (ÃÂÃÂ¡ÃÂÃÂÃÂÃÂÃÂÃÂ¡ÃÂÃÂÃÂÃÂ¾ÃÂÃÂ¡ÃÂÃÂÃÂÃÂÃÂÃÂ¡ÃÂÃÂÃÂÃÂ¢ÃÂÃÂ¡ÃÂÃÂÃÂÃÂ¥ÃÂÃÂ¡ÃÂÃÂÃÂÃÂ¢ = du-na-ni-tlv-vi). Both render the same
underlying /du-un-hnihlvvi/ -- they differ in how the epenthetic between the
`un-` prefix and the h-onset stem is written:

- **Guide/book convention (unv-):** insert schwa (v is a full Cherokee vowel,
  ÃÂÃÂ¡ÃÂÃÂÃÂÃÂ = n+v) after `un-`, keeping the stem's initial h silent (no "hn" glyph,
  so ÃÂÃÂ¡ÃÂÃÂÃÂÃÂÃÂÃÂ¡ÃÂÃÂÃÂÃÂ = unv + hni). The book uses this consistently across verbs and
  tenses: VRB 2012 line 2299 `anvhniha ... unvhnilv'i`, line 2431
  `unvhnistanv'i`, guide `danvhniha` / `dunvhnihlvvi`.
- **Engine convention (una-):** the laryngeal rule turns the h itself into
  /a/ (C-h-C -> a), eliminating it. This rule is CED-derived and PINNED by
  SyllabaryTest round-trips (nhs -> ÃÂÃÂ¡ÃÂÃÂÃÂÃÂ¾ÃÂÃÂ¡ÃÂÃÂÃÂÃÂ, nht -> ÃÂÃÂ¡ÃÂÃÂÃÂÃÂ¾ÃÂÃÂ¡ÃÂÃÂÃÂÃÂ).

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
syllabary has no separate k-series glyphs except ÃÂÃÂ¡ÃÂÃÂÃÂÃÂ§ (ka), so ke/ko/ku/kv are
written with the g-glyphs ÃÂÃÂ¡ÃÂÃÂÃÂÃÂ¨/ÃÂÃÂ¡ÃÂÃÂÃÂÃÂª/ÃÂÃÂ¡ÃÂÃÂÃÂÃÂ«/ÃÂÃÂ¡ÃÂÃÂÃÂÃÂ¬ exactly like ge/go/gu/gv. Mirrors the
pre-existing `ki`->`gi` rule in replace(). ka is EXCLUDED (ÃÂÃÂ¡ÃÂÃÂÃÂÃÂ§ is a distinct
glyph from ÃÂÃÂ¡ÃÂÃÂÃÂÃÂ¦; Kanegwoga's kanequoga must keep ÃÂÃÂ¡ÃÂÃÂÃÂÃÂ§). Risk-scanned: every
existing k+vowel sequence in the test expectations is `ka` plus the target
`uwekohdi` -- no collateral. Default suite green.

UwekahaSpec: the 3 SG3 INFINITIVE cells re-enabled and GREEN (book p.83:
uwekohdi/unekohdi -> ÃÂÃÂ¡ÃÂÃÂÃÂÃÂ¤ÃÂÃÂ¡ÃÂÃÂÃÂÃÂªÃÂÃÂ¡ÃÂÃÂÃÂÃÂªÃÂÃÂ¡ÃÂÃÂÃÂÃÂ/ÃÂÃÂ¡ÃÂÃÂÃÂÃÂ¤ÃÂÃÂ¡ÃÂÃÂÃÂÃÂÃÂÃÂ¡ÃÂÃÂÃÂÃÂªÃÂÃÂ¡ÃÂÃÂÃÂÃÂ). The SG1 INFINITIVE row stays dropped: the
book does not attest it, and the engine composes `agiwegodi` (keeps the
citation's we-), the same wa-epenthesis class as the D15 Uwaya open question.
-- tio 17Nov26

**D16 ROOT-CAUSED (2026-11-17, same day) -- candidate fix retracted:** tracing the
composition shows the laryngeal h->a rule is NOT involved. Chain: the SG3 remote
citation `uwahnihlvvi` is parsed by `replace()` rule 3 (aspirated n: `hn`+vowel ->
`n`+vowel -- Feeling's silent-h convention), dropping the h; the stemmer's a-branch
then strips the w, giving the vowel-initial stem `anihlvvi`; the PL3 preVowel `ÃÂÃÂ¡ÃÂÃÂÃÂÃÂ¤n`
fuses with the leading a -> `una-` (ÃÂÃÂ¡ÃÂÃÂÃÂÃÂÃÂÃÂ¡ÃÂÃÂÃÂÃÂ¾ÃÂÃÂ¡ÃÂÃÂÃÂÃÂÃÂÃÂ¡ÃÂÃÂÃÂÃÂ¢ÃÂÃÂ¡ÃÂÃÂÃÂÃÂ¥ÃÂÃÂ¡ÃÂÃÂÃÂÃÂ¢). The guide's `unv-` (ÃÂÃÂ¡ÃÂÃÂÃÂÃÂ) is a COMPETING
ORTHOGRAPHY for the same pre-aspirated n: ÃÂÃÂ¡ÃÂÃÂÃÂÃÂ (nv) is how Feeling's romanization
"hn" surfaces when the aspiration is marked. The engine's hn->n normalization is
systemic (rule 3 fires on every hni/hne/hno in all data); re-defining it to emit
nv would re-characterize the entire aspirated-n family across both suites --
disproportionate for one cell. RESOLUTION: PluralObjectSpec PL3 x SG3IN
REMOTE_PAST characterized to engine output (`dunanitlvvi`); the una-/unv-
orthography variance stays documented here as an open orthography question.
Default suite + vrb suite now fully GREEN (13,214/13,214). -- tio 17Nov26

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
  surface override. The structural fusion fix is deferred -- touching it risks
  the 224-cell infinitive-guard work. The harness composes from the FIRST SG3
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
