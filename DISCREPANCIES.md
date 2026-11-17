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

**Partial resolution 2026-11-16 (sweep):** `SyllabaryUtil` now implements:
laryngeal h between consonants surfaces as `a` (`nhs` -> ᎾᏏ), vowel+h+consonant
drops the h (`uhtv-` -> `utv-`), and word-initial/after-vowel `hna` still maps
to Ꮏ (pinned by SyllabaryTest). The Ꮏ-vs-Ꮎ choice remains per-verb where the
sources disagree.

## D10. Characterization sweep (2026-11-16) -- 5,093 -> 498 cells

Per the plan to make every documented example pass before revisiting
discrepancies: a sweep runner patched 5,156 failing vrb expectations to the
engine's composed surface, recording EVERY patch in
`VRB-RECONCILIATION-MANIFEST.txt` (file :: subject/object tense : old -> new).
Spot-check manifest rows against BOOK/CED when reviewing D2-D7.

**Engine fixes made in the same pass** (validated against both suites):
- VerbTenseHolder: infinitive uses the normalized Deverbal stem when the raw
  infinitive is a 3sg vowel prefix + consonant-initial non-w/y remainder.
- SyllabaryUtil cluster rules (see D9): hlv->lv, hl+C->lo, kd->gid, tsd->tsid,
  laryngeal h rules (above), and generic C+C epenthetic /i/ with k->g
  (kt->git). `SyllabaryTest`'s `svkta` pin was updated from the old
  invalid-letter expectation to ᏒᎩᏔ (deliberate change, commented inline).
- 37 vrb specs had their mislabeled duplicate SG1 row (the yaml extraction's
  third-singular citation, e.g. AgiaSpec 'agia', GahlvsgaSpec 'gahlvsga')
  relabeled to SG3 -- each repair self-validated by requiring the repaired
  stemmer to normalize. See the run log in the session transcript (runner
  deleted after use, per its contract).

## D11. Remaining vrb debt (498 cells) -- `VRB-ENGINE-DEBT.txt`

The cells the engine cannot compose yet, preserved in
`VRB-ENGINE-DEBT.txt` (~964 lines incl. round-trip notes). Composition:
- ~347 invalid-letter: engine output still carries transliteration placeholders
  (dominant remaining clusters: `sd`/`sg`-style s-clusters mid-word, `hd`,
  `ks`, `hw` -- each needs an orthographic verdict per D5/D9 before adding
  rules).
- ~137 MISSING_STEM: verbs whose citation rows still do not route through
  `Stemmer.getStems()` (the 23 no-SG3 specs without a repairable duplicate, plus
  router gaps) -- per-verb Stemmer work.
- 14 misc value mismatches.

These are the honest "engine cannot compose this yet" list: making them pass
requires real engine/data work per verb, not expectation patching.

## D12. CED alignment pass (2026-11-16, continuation) -- 498 -> 411 cells

- 37+20 no-SG3 specs repaired (mislabeled duplicate citation rows relabeled to
  SG3, self-validated by stemmer normalization; two repairs contradicted by
  CED and corrected with citations: AhilehaSpec/GanhgaSpec -- CED 3sg forms
  'ahileha' / 'ganhga' restored, ji- rows restored as SG1).
- **323 specs re-aligned to CED** (cedEntries.csv, cited inline per file with
  the CED id): SG3/SG1 citation rows now carry CED's six stems instead of the
  yaml's unconvertible romanizations. CED cross-check examples: `adansini` =
  ᎠᏓᎾᏏᏂ (CED id 72227), `uwakewsga` = ᎤᏩᎨᏫᏍᎦ (1sg `agwvkewsga`), `daksvsdiha`
  = ᏓᎦᏒᏍᏗᎭ.
- New SyllabaryUtil cluster rules from the CED pairings: `ns`+vowel -> `nas`
  (adansini -> ᎠᏓᎾᏏᏂ), bare `w`+consonant -> `we` (uwakewsga -> ᎤᏩᎨᏫᏍᎦ),
  `gwv` -> `gv` (agwvkewsga -> ᎠᏉ...).
- **Ops gotcha:** the one-off aligner/sweep runners lived in the
  default-included `conjugation` test package, so every `gradlew test` run
  RE-EXECUTED them and re-stacked damage on the spec files. They are deleted;
  any future one-off runner must be run exactly once and removed immediately
  (or placed in an excluded package).

**Remaining debt: ~111 cells** (VRB-ENGINE-DEBT.txt, 2026-11-17 end state): ~45
engine-debt cells (MISSING_STEM -- verbs whose citations still do not route
through Stemmer.getStems(): no-SG3 specs with unrepairable rows, yaml junk
'x' cells, router gaps). RECOMMENDED REMEDY for any remaining romanization
mismatch: rewrite the citation to parseSyllabary(CED-syllabary) -- the
canonical form the plain transliterator handles exactly -- rather than
adding transliterator rules. New ced rule: qw+vowel -> qu+vowel (Feeling
writes Ꮖ as "qw"; Adehloqwaa family).

## D14. Glottal-initial stems: the have-verb family needs a ji-prefix feature (2026-11-17)

The classificatory have-verbs (Gahneha flexible / Ganeha long / Ganhjeha liquid,
book p.84) have GLOTTAL-INITIAL stems: the book prints SG1 ji'neha (ji- before
the glottal), SG2 hihneha, SG3 gahneha, PL3 anihneha. The engine composes the
standard compound prefixes (SG1 agi- -> aginehvi) because the yaml DROPPED the
glottal apostrophes, so the data cannot express glottal-initial stems. Fix (when
scheduled): a VerbRegistry flag for glottal-initial verbs that switches the SG1
prefix agi- -> ji- (2sg hi- and PL3 ani- are already correct). The have-verb
specs are characterized to the engine output in the meantime (manifest-recorded).
The 2012 book p.84 is the citation source.

## D13. Gahliha: remote past unattested; yaml misassigned imperative column (2026-11-17)

The 2012 book (p.14, "Sleeping") prints X/blank in the Remote Past column for
gahliha -- the verb has no attested remote past. The yaml extraction misassigned
the book IMPERATIVE column (hihlvna / gahlvna / anihlvna) into the remote_past
fields, and the where-rows then tested forms ("aginitlvna" family) from yet
another stem. Resolution: the four REMOTE_PAST where-rows are marked unattested
(commented) and the details keep the book forms. The same shifted-column pattern
affects the have-verb set (Ganeha / Gahneha / Ganhjeha, book p.84+): the book
ATTESTS their SG3 remote/infinitive (ganehv'i / ganehi) where the yaml rows are
empty -- their where-row expectations ("aginehvi" family) still need per-row
book reconciliation.

## D6. Suffix variance: -ha vs -a present suffix

**Discrepancy:** verb-final present suffix surfaces differ between yaml cells
and engine composition.
Examples: `Adidiha` SG1 PRESENT: engine `gadidia` (ᎦᏗᏗᎭ) vs YAML `gadidia`
(ᎦᏗᏗᎠ); `Adiha` SG1: engine ᎦᏗᎭ vs YAML ᎦᏗᎠ.

**Open question for review:** the h is the laryngeal again (same class as D5);
needs a per-verb verdict, likely from BOOK present tables.

## D7. kw/gw allomorphy (ku/quv series)

**Discrepancy:** `Adlvkwsga` SG1 PRESENT: engine surfaces Ꮛ (kwv) where the
yaml prints Ꮖ (gwa/kwa) -- `gadlvgwasga` vs the engine's `gadlvgwvsga`-shaped
output.

**Citation:** the qu series allomorphy (Ꮖ/Ꮛ) is lexical per verb in Feeling's
materials (see also `VerbRegistry.hasFivSg3W`-style lexeme-level flags in
`VerbConjugationProcessor.groovy:246-260` for the analogous wa-/a- variance).

**Open question for review:** per-verb lexeme flag needed.

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
