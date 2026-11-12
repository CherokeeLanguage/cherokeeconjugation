# Verb Category Audit — findings and verdicts

Compiled 12Nov26. Grounded in three sources:

1. **King verb lexicon** (`/mnt/c/projects/CED/cedproject/docs/king.xlsx - king.csv (2).csv`,
   2094 rows, 777 verb bases marked `vbst`) — roots + per-tense forms for the
   classificatory sets, in King's phonemic notation (`?` = glottal stop,
   `.` = vowel length, `/` = tone).
2. **Feeling guide excerpts** already transcribed into tests —
   `WiVerbTest.groovy` (Cherokee Reference Grammar pp. 244–245, examples 25–35).
3. **Verb-book fixtures** (`VerbBookFixtures.groovy`) — the classificatory
   "to have something flexible / liquid / long & rigid" pages.

## Core finding: most categories are lexical, not morphological

The engine's conjugation machinery (Set A/B selection, compound prefix tables,
laryngeal alteration, wi- handling) already covers the morphology of every
category we seeded. What the categories actually classify is **which root a
verb uses** — a lexicon/deconstruction concern. The practical consequence:

- `CategoricalRule` implementations should be written **only** for attested
  morphological differences (few), never to re-express root selection.
- The registry's real near-term value is **classification metadata for verb
  deconstruction/stemming**: knowing a verb is classificatory tells the
  stemmer which root family to expect.

## Category-by-category verdicts

### LIQUID_HANDLING / SOLID_HANDLING → classificatory verbs (lexical)

Cherokee classificatory verbs are **parallel root sets**: one "handling
concept" has a different root per object class (liquid / flexible / long &
rigid / alive). King's lexicon shows the pattern cleanly:

| concept               | liquid    | flexible   | long      | alive     |
|-----------------------|-----------|------------|-----------|-----------|
| holding               | /nhtseh   | /nheh      | (ka-set)  | ?ni/.y    |
| leaving behind        | hi.y      | ?ni/.y     |           |           |
| laying down           | hehv      |            | ?t        |           |
| putting in a container| l         | la?        | lha       | ya?       |

The conjugation of every class member is identical (same prefix tables); only
the root differs. The verb-book fixtures already exercise this ("to have
something flexible" `una'a/duna'a`, "liquid in a container" `uneha/duneha`,
"long & rigid" `uwaya/duwaya` — the alternating `d-` forms are the plural
prefix, already table-handled).

**Verdict:** no conjugation-transform rule. `LiquidHandlingRule` stays a
documented no-op until a morphological difference is attested. The category
should be attached per-root once roots are bridged, so the stemmer can pick
the right classificatory root family.

### POSITION / STATE (lying, sitting, standing, hang)

Attested behavior is the **wi-/w- orientation merge**, already implemented
and pinned: `WiVerbTest.testExample29_WiWithSittingVerb` — ᎤᏬᏝ (u-wohla,
"He's sitting") → ᏭᏬᏝ (wu-, back to speaker). Note the stem itself carries
the `wo` element (position-verb stem feature, per-verb lexical data).

**Verdict:** no new rule machinery; the wi- merge is global. Category is
deconstruction metadata (position stems are Set B with w-initial stems —
WI-29's stemmer corner case is the exact expression of that).

### MOTION

Same wi- orientation machinery; the guide states the semantic consequence
explicitly (WiVerbTest header, ex. 30): *"In the case of motion verbs, it
follows that the motion will be away from the speaker"* — ᎠᎢ → ᏩᎢ.
King's lexicon lists 29 motion verb bases (climbing ?lah, walking a.?,
crawling ata.hnsi/.ni.to, swimming ahyu?i.n, ...).

**Verdict:** morphology already handled. One **candidate future feature**:
auto-applying wi- to motion verbs from semantics — that is meaning
inference, NOT a conjugation rule; needs an explicit user decision (and a
place to declare direction) before ever being implemented. Registry stores
the classification today.

### FLIGHT

No dedicated verb-base rows surfaced in the scanned King excerpts; likely a
subset of MOTION semantics in the sources we have. **Pending evidence.**

### IRREGULAR

Not a "rule class" — per-verb overrides through `VerbRegistry.registerOverride`
(the override API exists and is checked first in `VerbConjugationProcessor`).
The engine's "to have" handling (fully short-circuited, empty root) is the
model: irregularity = override rows + short-circuits, verb by verb.

## Transliteration gap (blocks King-CSV seeding)

King's notation is phonemic (? / . / tone marks) and does not match the
engine's Durbin-style romanization that the stemmer consumes. Bridging King
roots into `VerbRegistry` requires a notation mapping — do not guess;
resolve attested pairs (e.g., King `?khah` "having something alive" vs the
engine's "to have (a living being)" fixture `agikaha`) when transliteration
is available. Until then, those seeds stay in `VerbRegistry.unresolvedNames`
(missing data stays visible).

## Next actions (in order)

1. **Deconstruction use:** wire `getCategories(verb.root)` into stemmer
   diagnostics so classified verbs report their category during root
   resolution (read-only, no conjugation impact).
2. **Classificatory roots:** as verb-book classificatory pages are transcribed
   into fixtures/lexicon, bridge each member root and tag it
   LIQUID_HANDLING / SOLID_HANDLING — turning the pending seeds into root-keyed
   metadata.
3. **User decision queue:** (a) auto-wi- for motion verbs — yes/no;
   (b) FLIGHT: drop the category or supply evidence.
4. Keep `LiquidHandlingRule` a no-op; delete it only if the audit ends with
   no liquid-specific morphology, to avoid a misleading stub.

— tio 12Nov26 (user-approved work session; audit compiled from repo-internal sources)
