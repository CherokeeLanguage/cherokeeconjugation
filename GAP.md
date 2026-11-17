# GAP.md — vrb stem-coverage data gaps

**2026-11-17.** These are the 67 verb|tense entries the yaml data cannot attempt
because **the 2012 VRB itself does not attest the form** — not engine limitations.
The live list is `EXPECTED_GAPS` in
`src/test/groovy/net/cherokeedictionary/conjugation/vrb/VrbStemCoverageMetaSpec.groovy`;
the meta-test fails loudly if a gap closes (transcribe the stem, delete the entry)
or a new one appears. Every other verb|tense|subject combination in the inventory
(10,177 rows) composes a real word through the production engine.

## Gap classes

| Class | Count | Meaning |
|---|---|---|
| Impersonal verb, no imperative column | 20 | Weather/nature/impersonal "it is ..." verbs — the book's box has no imperative column at all |
| Book prints x / column absent | 37 | The book prints literal `x` in the remote-past or infinitive column, or the box has no such column |
| No CED syllabary anchor | 5 | The book attests a form but CED carries no imperative syllabary to derive a parse-back citation from |
| yaml junk entry | 5 | The verb is absent from (or corrupted in) the 2012 book — Nania wholesale; Ai/Ajavs ga-style junk rows |

## IMPERATIVE gaps (23) — IMMEDIATE_COMMAND

**Impersonal verbs (no imperative column in the book box):**
- Adaleniha (Beginning, p.76) · Agaliha (Shining, p.77) · Aganawosga (Warming, p.77)
- Agasga (Growing-impersonal) · Alidliha (Boiling, p.39) · Alsgwadia (Ending, p.76)
- Asvga (Smelling, p.75) · Galiga (Burning, p.75) · Ganesoysga (Hailing, p.78)
- Gutiha (Snowing, p.78) · Nigalstanvsga (Happening, p.75) · Uhyvdla (Cold, p.77)
- Ulogila (Cloudy, p.78) · Anagaliha (Lightning, p.78) · Ahyahtvhvsga (Frosting, p.11)
- Ahyvdagwaloa (Thundering, p.78)

**Book prints x in the imperative column:**
- Atihneha (Have With living, p.83 — also remote/future-command x)
- Ahileha (Have Vehicle, p.67 — also remote/future-command x)
- Ai (p.9-ish, imperative x)

**Book attests the form, but no CED syllabary anchor for a parse-back citation:**
- Ahili (Driving, p.10: imperative `ji'i'luga / hihi'luga / ahi'luga / anihi'luga / idihi'luga` — CED imperative is `-----`)
- Anidonaa (3+ Standing, inside the Gadoga box p.56: imperative `widanidogesdi`)
- Anina (3+ Sitting, inside the Uwotla box p.71)

## REMOTE_PAST / FUTURE_COMMAND gaps (16)

The book prints `x` in the remote column (FUTURE_COMMAND composes from the remote
row per the D1 convention, so an unattested remote blocks both):

- Eha (Lives, p.40) · Ganhga (Lying Down, p.65) · Gahliha (Sleeping, p.14)
- Gadoga (Standing, p.56) · Ganela (Living At, p.17) · Ahileha (Have Vehicle, p.67)
- Atihneha (Have With living, p.83) · Nania (absent from the book — junk yaml)

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
  (canonical `daganesosi` shape).
- Ahyeha's SG3 imperative (`ahyehesdi`, p.84) was transcribed 2026-11-17 and is NOT
  a gap — it composes through the D14 glottal-flag path.
- Closing any gap = transcribe the book's SG3 stem into the spec's SG3 row, then
  delete the entry from EXPECTED_GAPS. All 10,177 other rows are green.

-- tio 17Nov26
