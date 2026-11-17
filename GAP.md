# GAP.md — vrb stem-coverage data gaps

**2026-11-17.** These are the 50 verb|tense entries the yaml data cannot attempt
because **the 2012 VRB itself does not attest the form** — not engine limitations.
The live list is `EXPECTED_GAPS` in
`src/test/groovy/net/cherokeedictionary/conjugation/vrb/VrbStemCoverageMetaSpec.groovy`;
the meta-test fails loudly if a gap closes (transcribe the stem, delete the entry)
or a new one appears. Every other verb|tense|subject combination in the inventory
composes a real word through the production engine.

## NOT gaps: the no-imperative cohort (17 verbs)

The 17 verbs here have **no imperative because the form is IMPERMISSIBLE** —
there is no agent to command ("you cannot tell the sun or moon to shine" —
linguistic verdict 2026-11-17; Ahliilidoha added to this cohort same day, user
verdict: its imperative is absent ON PURPOSE). Their book boxes have no
imperative column *because the form does not exist*, not because it is missing.
This is a **lexical property** of the verb, encoded as `details.impersonal: true`
in each spec → `VerbRegistry.registerImpersonal` → Conjugate returns the
`NO_IMPERATIVE` sentinel for IMMEDIATE_COMMAND (asserted by the meta-gate's
sentinel test, so the question cannot recur):

Adaleniha (Beginning, p.76) · Agaliha (Moon/Sun Shining, p.77) · Aganawosga
(Warming, p.77) · Agasga (Growing, p.23) · Ahliilidoha (Taking Time, p.76) ·
Ahyahtvhvsga (Frosting, p.11) · Ahyvdagwaloa (Thundering, p.78) · Alidliha
(Boiling, p.39) · Alsgwadia (Ending, p.76) · Anagaliha (Lightning, p.78) ·
Asvga (Smelling, p.75) · Galiga (Burning, p.75) · Ganesoysga (Hailing, p.78) ·
Gutiha (Snowing, p.78) · Nigalstanvsga (Happening, p.75) · Uhyvdla (Cold, p.77) ·
Ulogila (Cloudy, p.78)

The full verb cohort's paradigm cells therefore fall into THREE classes, not two:
**(a) attested** (composes and is asserted), **(b) impermissible** (lexical
property — `NO_IMPERATIVE` sentinel, 17 verbs), **(c) unattested** (the book
prints x / has no column — the gaps below).

## Gap classes

| Class | Count | Meaning |
|---|---|---|
| Book prints x / column absent | 33 | The book prints literal `x` in the remote-past or infinitive column, or the box has no such column |
| No CED syllabary anchor / footnote-governed alternants | 4 | The book attests a form but CED carries no anchor to derive a parse-back citation from, or the form is footnote-governed (two-vs-3+ alternant pairs) |
| yaml junk entry | 13 | The verb is absent from (or corrupted in) the 2012 book — Nania wholesale; Ai/Ajavsga-style junk rows |

## IMPERATIVE gaps (6) — IMMEDIATE_COMMAND

**Book prints x in the imperative column (correct — no attested form):**
- Atihneha (Have With living, p.83 — also remote/future-command x)
- Ahileha (Have Vehicle, p.67 — also remote/future-command x)
- Ai (p.9-ish, imperative x)

**Book ATTESTS the imperative, but no CED anchor / footnote-governed alternants
(user-adjudicated 2026-11-17):**
- Ahili (Driving, p.10: the BOOK attests `ji'i'luga / hihi'luga / ahi'luga /
  anihi'luga / idihi'luga` — but CED marks the imperative empty (`-----`), so a
  CED-derived parse-back citation cannot be built; the book has the value)
- Anidonaa (Standing: VRB pp.18 footnote — */Danidoga/* if only two are
  standing, */anidona/* if three or more. The imperative (`widanidogesdi`,
  inside the Gadoga box p.56) belongs to the two-vs-3+ alternant pair, not a
  single stem)
- Anina (Sitting: VRB pp.18 footnote — */Dunotla/* if only two are sitting,
  */ani'na/* if three or more. The imperative lives inside the Uwotla box p.71)

## REMOTE_PAST / FUTURE_COMMAND gaps (16)

The book prints `x` in the remote column (FUTURE_COMMAND composes from the remote
row per the D1 convention, so an unattested remote blocks both):

- Eha (Lives, p.40) · Ganhga (Lying Down, p.65) · Gahliha (Sleeping, p.14)
- Gadoga (Standing, p.56) · Ganela (Living At, p.17) · Ahileha (Have Vehicle, p.67)
- Atihneha (Have With living, p.83) · Nania (VRB p.46)

## INFINITIVE gaps (28)

The book prints `x` in the infinitive column, or the box has no infinitive column:

- Ai · Ajavsga · Anagaliha · Anidonaa · Anina · Galiga · Ganatlaa (Have a Pet, p.74)
- Ganohili (Flying, p.27) · Gata (Hanging, p.75) · Ganesoysga (Hailing, p.78)
- Ganela · Ganhga · Gadoga · Eha · Nania · Udvnvisdi (Getting Ready-impersonal)
- Uhnalvha · Uhniha (In Bed, p.59) · Ujaa · Ukvhada (Foggy, p.78) · Ulogila
- Ulsihga (Dark, p.78) · Unaa (Have Flexible, p.83) · Uneguja (Mean, p.40)
- Unhta · Uwohiyuha · Uwotla (Sitting, p.71) · Wakti (Going, p.11)

## Notes

- Ganesoysga's `daganesoysi`, which the yaml carried as an imperative, is the book's
  **Future** column (p.78) — corrected in GanesoysgaSpec with the glide-y drop
  (canonical `daganesosi` shape). Its imperative is impermissible (impersonal).
- Ahyeha's SG3 imperative (`ahyehesdi`, p.84) was transcribed 2026-11-17 and is NOT
  a gap — it composes through the D14 glottal-flag path.
- Closing any gap = transcribe the book's SG3 stem into the spec's SG3 row, then
  delete the entry from EXPECTED_GAPS. All other rows are green.

-- tio 17Nov26
