# ENGINE-COMPLETENESS.md — what is left to implement, with sources

Compiled 2026-11-20 per user request. Sources cited per item:
[Guide] = grammar guide (docs/processed/hold1.md / hold2.md), [M-A] = Montgomery-Anderson
Cherokee Reference Grammar (docs/processed/Montgomery_Markup CRG Proofs.md),
[VRB] = Cherokee Verb Conjugations 2012 (docs/processed/VRB Didehloqwasgi 2012.md),
[INDEX] = attestationIndex.tsv (NT + news corpus mining, this repo).
-- tio 20Nov26

---

## A. Paradigms with NO engine data (real implementation work)

### A1. Reflexive — [Guide] §I-E, pp. 296-298, complete paradigms

The guide documents the reflexive prefix **-adad-**, placed AFTER the pronominal
prefix and DIRECTLY BEFORE the stem, with three allomorphs:

- `ada-` before a **consonant-initial** stem (P1 "to see oneself": ᎦᏓᎪᏩᏘᎭ
  gạ²da²gowh¹tị³ha "I see myself", ᎠᏓᎪᏩᏘᎭ "he sees himself", ...)
- `-ad-` before an **a-initial** stem (ex. (1b) ᎠᏓᏛᏂᎭ a¹da²dv²hnị³ha
  "he's hitting himself" — hmm, P3 shows -adad- before the v-stem; the
  -ad- form is stated for a-stems in prose)
- `-adad-` before a **vowel-initial (non-a)** stem (P3 "to hit oneself":
  ᎦᏓᏛᏂᎭ gạ²da²dv¹nị³ha)

Two structural rules the guide states explicitly:

1. **Set B u- drops the reflexive's initial a-**: ex. (4a) ᎤᏩᏂᎸᎢ
   u¹wa²hnị³lv³ʔi — the uwa- sequence (u- + adad- with a-drop + w-insertion).
2. **Reflexive forces Set A prefixes in the present** even for class-B-always
   verbs: Paradigm Five "to forget oneself" prints Set A in the present and
   Set B in the non-progressive past (P6), "like verbs such as hit and tie up".

**Full paradigms given** (all 9 persons, P1-P6): see myself present + past,
hit myself present + past, forget myself present + past. These are direct
test fixtures. [M-A] §9.7/§14.3.3 documents the same prefix (middle voice).

**Engine state**: the API accepts `isReflexive` (Conjugate.createVerbToConjugate
arg 6, VerbFactory always passes false) and `verb.reflexiveHolderObject`
exists — but there is NO reflexive prefix data; the reflexive cells
(SG1SG1-class) are declared-empty in CompoundPrefixes and surface blank.

**Implementation shape**: the reflexive is a STEM-LEVEL insertion between the
pronominal and the stem (not a CompoundPrefixes entry): insert ada(d)- per the
allomorphy, apply the u- a-drop, and override verbset for the present of
class-B verbs. The guide's P1-P6 grids become the fixture set.

### A2. Object-focus prefixes — [M-A] §9.4, Table 9.3 (p. 256)

**Table 9.3 (complete)** — prefixes marking the OBJECT as the undergoer
(valency-decreasing, "passive-like"):

| Person reference | Singular | Dual | Plural |
|---|---|---|---|
| First person object | vvɡi- [vvɡw] | ooɡinii- | ooɡii- |
| Second person object | eeja- | eesdii- * | eejii- * |
| First & second object | | eeɡinii- * | eeɡii- * |
| Third person object | aji- [aɡ] * | ɡeejii- [ɡeeɡ] * | ɡeejii- [ɡeeɡ] * |

(* = triggers /h/ alternation per M-A.) Worked examples (20a-e):
ᏛᎩᏕᎸ dvv̀ɡideelv "I was given (long)", ᎨᏥᏍᎦᎸᏨ ɡeejiisɡahljv "they had been
bitten" (3O.PL), ᎡᏣᎪᎵᏰᎦᏍ eèjaɡooliyéeɡas "are you going to be examined?" (2O),
ᎡᎩᏅᏂᎭ eèɡinvv̀níha "you and I are being hit" (2O.DL), ᎡᎬᏂᎭ eèɡvv̀níha.

**Which of these are implemented: NONE.** The engine has no object-focus
prefix data; these six prefixes exist nowhere in CompoundPrefixes. They would
slot in as a new prefix family (like the DST/DST2 work) plus a request path
for "object-focus" as a paradigm choice.

### A2b. Combined LOCAL prefixes — [M-A] §9.3, Table 9.2 (p. 253) — discovered while reviewing

**The 2↔1 local person pairs are also entirely missing.** The engine returns
blank/empty twins for SG1SG2, SG2SG1, SG1DL2, SG2DL1... — but M-A Table 9.2
documents them fully:

| Person reference | Both singular | Dual | Plural |
|---|---|---|---|
| 2nd subject / 1st object | sɡi- [sɡw] | sɡinii- * | iisɡii- [iisɡiiy] * |
| 1st subject / 2nd object | ɡvv- [ɡvvy] * | (ii)sdvv- [sdvvy] * | iijvv- [iijvvy] * |

Examples: ᏍᎩᏂᎦᏘᏯ sɡiniiɡaàtiíya "you are waiting for us two" (three readings),
ᏢᏨᎦᏘᏯ iìjvvɡaàtiíya "I am waiting for you all" (five readings — number applies
to either or both persons). [Guide] P(13)-(16) prints the same sgw-/gvw- rows.
These plural prefixes carry 3-5 possible glosses each — the occurrence-aware
harness and the all-analyses deconstruction rule apply.

### A3. PL3-object / PL3AN-object Set B columns — rules from the documented sources

Current state: PL3SG3ANB := Ꭴn/ᎤᏂ (uni-, user ruling bd01227, guide P7(15));
PL3PL3ANB and the PL3-object columns are Set A stand-ins / unmodeled.

**What the sources print for plural-object forms:**

- [Guide] P4(21)-(23), class-B-always "forget", PRESENT:
  (21) ᎠᏅᎨᏩᏍᎦ anv²kew²sga "they're forgetting HIM" — an- (an + v-stem)
  (22) ᎤᏅᎨᏩᏍᎦ unv²kew²sga "they're forgetting IT" — un-
  (23) ᏓᏅᎨᏩᏍᎦ danv²kew²sga "they're forgetting THEM (an)" — **dan-** =
       d- (plural-object marker) + an-
- [M-A] P8(6) ᏚᏩᏂᎸᎢ du¹wa²hnị³lv³ʔi "he hit THEM (an or in)" with a **3sg
  subject** — duw- covers both animate and inanimate plural objects
  (Set A has degi-).
- [Guide] (126a) ᎤᏂᎪᎲᎢ u¹ni²go²hv²³ʔi "they saw it" — uni- (PL3 Set B).

So the documented plural-object rules: the **d-/duw- plural-object layer**
(the CMF-style d- prepronominal) attaches for plural-animate objects, and
3rd-person subjects merge the subject marker with it (an-/un-/dan-, duw-).
The engine's existing PL3-object du- guard (D22) already models the duw-
family for SG3 subjects. What is unmodeled: PL3-subject + PL3AN-object in
Set B (candidates per the guide: d- + uni- or dan-), and the PL3ANB twins
generally. Unattested in our corpus — the attestation index can be mined for
ᏓᏅᏂ-/ᏚᏅᏂ-class forms as the tiebreak (same method as B1 below).

---

## B. Documented conflicts — evidence and what each needs

### B1. SG3SG3ANB (guide g- vs engine Ꭴw vs CED u-/uya-)

**The evidence now includes running text.** [INDEX] mining:

- ᎬᎨᏳᎢ gvvé-yu-ha "he loves HIM" (3AN object, Set B verb in the present,
  **g-** marker): NT 3JN 1:11, 3JN 1:5, 3JN 1:2, 2TM 1:2, LUK 3:22 + CORPUS
  4176/4997/9761/10610/10613 — **attested in BOTH corpora**.
- [M-A] P4(5) ᎬᎨᏩᏍᎦ gvkewsga "he's forgetting HIM" analyzed "g- 'he--him'"
  vs (6) ᎤᏩᎨᏩᏍᎦ uw- "he's forgetting IT".
- The g- forms of love (ᎬᎨᏳᎢ family) occur ~10x in the text; the u-/uya-
  SG3AN candidates (ᎤᏩᎨᏩᏍᎦ etc.) occur 0x in the mined sample.

**What is needed to solve it**: a ruling that [M-A] P4(5) + the ᎬᎨᏳᎢ
attestations (g- for SG3+SG3AN) outrank the CED u-/uya- transcription rows —
then SG3SG3ANB := g- (with the same vowel-merge behavior the Ꭶ- allomorph
shows). The ᎤᏩᎨᏫ/uwa- forms in the text are the uw- "he--it" family (M-A
P4(6)), confirming the AN/IT contrast for 3rd-person subjects. This is now
evidence-backed enough to decide.

### B2. SG2SG3INB Ꮸ-vs-Ꮳ — positional allomorphy, examples to look up

The evidence says this is NOT a conflict but a preVowel/preConsonant split:

- [Guide] P4(3) ᏨᎨᏩᏍᎦ jvkewsga "you're forgetting it" — Ꮸ before the
  CONSONANT stem kew-; P8(3) ᏨᏂᎸᎢ jvhnilvi "you hit it" — same.
- [VRB] Forget box SG2 row (VRB line ~1346): `jvkewsga` — Ꮸ again.
- [VRB] Want box SG2 row: `jaduliha` — Ꮳ before the VOWEL stem aduuli-.

**Rule candidate**: SG2 Set B = jv-/Ꮸ before consonant-initial stems, ja-/Ꮳ
before vowel-initial stems — exactly the preVowel/preConsonant encoding the
table already uses. The current entry (preVowel 'j', preConsonant 'Ꮳ')
differs only in the preConsonant glyph: Ꮳ -> Ꮸ. Look up in the tables:
[Guide] P4(3)/P8(3); [VRB] Forget SG2 row (jvkewsga ✓ Ꮸ) vs Want SG2 row
(jaduliha ✓ Ꮳ). If you confirm, the fix is one glyph + the have-verb
ᏣᎭ-family cells re-checked (their stems are vowel-initial, so they keep Ꮳ).

### B3. Ꮤ-vs-Ꮨ (imperatives of da-initial verbs) — examples to look up

Recorded in D22: for da-verbs whose imperative triggers the da + h- contraction,
[Guide] pp. 247-248 rule 61-62 gives **t- (Ꮨ)** (da + higowhtiha -> ᏘᎪᏩᏘᎭ),
while the book sometimes prints **Ꮤ** for the same cells ("ᏔᎴᏲᎦ" recorded
during the D22 scan). The engine renders Ꮨ. I could not re-locate the Ꮤ forms
in the extracted VRB text today (the boxes for Barking/Kneeling are not in the
line-start extraction -- see CHANGELOG ops rule 6: search table-embedded
`Verb :` headers). To verify: open the VRB boxes for the da-initial verbs
whose imperatives the engine prints with Ꮨ (the D22 list: Barking, Kneeling
and the ᏓᏑ-class) and check whether the imperative glyph is Ꮤ or Ꮨ. If Ꮤ:
that is a da+we/aspiration spelling variant needing a PrefixDa branch or a
documented-variance pin.

### B4. Habitual -sgoʼi/-hoʼi split — the book prints BOTH, row by row

[VRB] "Breaking It" box (VRB line 2020, Ayosdi 'Breaking It'), habitual column:

| person | book habitual |
|---|---|
| SG1 | jiyosdis**o'i** |
| SG2 | hiyosdis**o'i** |
| SG3 | ayosdih**o'i** |
| PL3 | aniyosdih**o'i** |
| PL1INCL | idiyosdih**o'i** |

The split is PERSON-GOVERNED, not per-verb: SG1/SG2 take **-soʼi**, SG3/PL3/
PL1INCL take **-hoʼi** — in the same box, same verb. The engine composes
-hoʼi for all persons. What the documentation says: [M-A] §4.3.1 habitual
suffix has the -sgoʼi/-oʼi variants but does not state the person rule; the
VRB boxes across the corpus show the same SG1/SG2-vs-rest split (the D24
class-A survey). **Candidate rule**: habitual = pronominal + INC stem +
(sg) + oʼi, where the sg- epenthesis appears only for 1st/2nd-person
subjects — verify against 5-10 more VRB habitual columns before implementing;
if confirmed, this also unblocks STEM-FREE habitual derivation (the C6
h+sg machinery already exists).

---

## C. Outstanding variations — consolidated list (this file is the review copy)

| # | Item | Status | Where |
|---|---|---|---|
| 1 | SG3SG3ANB g- vs Ꭴw vs u- | evidence-backed (ᎬᎨᏳᎢ x10 text) — needs your ruling | B1 above |
| 2 | SG2SG3INB Ꮸ/Ꮳ | positional allomorphy — needs your confirmation | B2 above |
| 3 | Ꮤ-vs-Ꮨ imperatives | needs your book eyes on the VRB boxes | B3 above |
| 4 | Habitual -soʼi/-hoʼi person split | VRB row-by-row evidence — verify rule, then implement | B4 above |
| 5 | PL3AN/PL3-object Set B columns | candidates dan-/duw-; unattested | A3 above |
| 6 | D15 Ꭴw-fusion structural fix | parked (trigger: any new verb surfacing it) | DISCREPANCIES D15 |
| 7 | PL3AN-object B twins keep Set A forms | unattested columns | CompoundPrefixes comment |
| 8 | Gansanea jinasanea vs tsinisanea | documented variance, CED-canonical kept | D5 / GansaneaSpec |
| 9 | tsi/ji parse-back variance | CED-canonical kept; deconstruct shows both | D21 note |

---

## Deconstruct + postfixes: understanding sentence tails in the corpora (your last point)

You are right that the corpora are full of verb forms carrying **postfixes
and sentence-level tails that are not conjugation** — [M-A] ch. 7.8 and the
[Guide] list them: -gwu "also, too", -ju "just", -sgo "perhaps", -ke, -na
"contrastive", -hv question, -di conditional, -dina "plural around", -si,
-isi, the question postfix =s (Ꮝ), the delimiter, focus and contrastive
postfixes. The Deconstructor's FINAL_SUFFIX_MEANINGS table already labels
most of these (gwu, ju, sgo, ke, na, hv, dina, dv, di, si, isi, svi/vi, oi,
ei) — v1-approximate.

**Proposed pass (deconstruct-the-corpus)**: run the Deconstructor over every
token form in the attestation index (29,805 forms), and for each form:

1. record the peel (pronominal + stem hypothesis + final-suffix reading) —
   forms whose peel reaches a clean stem are VERB-FORM candidates;
2. attach the corpus citations (the index already has them) to each affix
   reading — this is the affix-citation store you asked for;
3. the peeled postfix distribution (how often -gwu/-ju/=s occur, on which
   stems) gives the frequency data to prioritize which postfixes the
   conjugation engine's output should support as optional tails;
4. the residue class (forms that do not peel) is the measured list of
   corpus structures the deconstructor cannot yet handle — the D19 backlog
   becomes data-driven.

This directly serves the verification loop: conjugate -> match text (done,
phase 1) -> deconstruct the matched text forms -> re-compose (round-trip) ->
cite every affix along the way. -- tio 20Nov26
