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

**IMPLEMENTED 2026-11-21 (A2b done).** The 1→2 rows (SG1SG2 Ꭼ/Ꭼy, SG1DL2
ᏍᏛ/ᏍᏛy, SG1PL2 ᎢᏨ/ᎢᏨy) were already filled; 13 previously-empty local keys
are now citation-exact from the guide: SG2DL1INCL/SG2PL1INCL (P3(11)/(12)),
DL1INCLSG2/DL1INCLDL2 (M-A dual sdvv), DL1INCLPL2 (P1(68)), PL1INCLSG2
(P1(73)), PL1INCLPL2/PL1EXCLPL2 (P1(79)), DL2PL1INCL (P1(92)),
DL2DL1INCL (P3(49)), PL2DL1INCL/PL2PL1INCL/PL2PL1EXCL (P1(103)/P3(53)/(56)).
Set B tenses reach them via the D20 empty-twin fallback. LocalPairPrefixesSpec
asserts 19 rows. **SG2SG1 variance RESOLVED (2026-11-21, user ruling — D28):**
the grammar guide wins (ᏍᎩᎪᏩᏘᎭ sgigowtiha, sgi- with -i- before consonants);
the verb book's ᏍᎪᏩᏘᎭ sgowtiha is the elided spoken variant (its own "short
vowel sgi'ow-" note) — documented, engine composes the guide form.

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

**ATTESTATION-MINING RESULTS (2026-11-21):** the existing A3 fills are
corpus-backed. ᎤᏂᎪᎲᎢ uni- (PL3 Set B) — attested in BOTH corpora (NT LUK
19:37/9:36/2:20/MAK 9:9 + CORPUS 4497/4943/5287/5718/11067). The duw-/
du-anv family — 123 ᏚᏩ/ᏚᏪ/ᏚᏫ forms incl. ᏚᏩᏂᎦᎸ duwahngalv "was cut off"
(ROM 11, PL3AN object, x9+) and 77 ᏚᏅ du-anv forms (MAK 11:8 ᏚᏅᏂᎦᎸᎮᎢ,
JHN 13:5). The dan- family — 23 ᏓᏅ forms (LUK 5:2 ᏓᏅᎩᎶᏍᎨ, REV 12:11
ᏓᏅᏅ). The fills stand.

**NEW CONFLICTS FOUND WHILE VALIDATING (2026-11-21 — D27, need your ruling,
not auto-patched):** composing guide P4(21)-(23) (forget, class-B-always,
PRESENT, PL3 subject) and M-A P8(6) against the engine surfaces a boundary-
fusion class the engine does not model yet:
1. **P4(22) PL3→SG3IN ᎤᏅᎨᏩᏍᎦ unv²-** — the engine's uni- (PL3SG3INB,
   your 20Nov26 ruling) composes ᎤᎾᏩ...; the guide prints un- with the
   stem's v FUSED at the boundary as Ꮕ (un+v → nv Ꮕ, the D16 convention)
   in the present, while the remote keeps uni- (126a ᎤᏂᎪᎲᎢ, attested).
   Candidate: PL3SG3INB preVowel = the nv-fused shape for v-initial stems.
2. **P4(21) PL3→SG3AN ᎠᏅᎨᏩᏍᎦ anv²-** — Set A ani- with the same nv fusion
   (and i-elision), for the ANIMATE object; the current PL3SG3ANB uni-
   ruling composes ᎤᎾ... The P4(21) row conflicts with the "uni- serves
   all 3rd objects" ruling for the PRESENT of class-B verbs specifically.
3. **P4(23) PL3→PL3AN ᏓᏅᎨᏩᏍᎦ danv²-** — the d- layer + the same fused
   an(v)-; engine composes ᏓᎾᏩ... (n+a where the guide fuses nv).
4. **M-A P8(6) SG3→PL3AN ᏚᏩᏂᎸᎢ duw-v-** — the engine's 'Ꮪw' preVowel
   fused against the stem artifact renders ᏚᏮ (wu) where M-A/guide print
   ᏚᏩ (wa = du+w+v with the artifact surfacing as -a-). Corpus-attested
   shape (ᏚᏩᏂᎦᎸ x9+). Candidate: fixPrefix(w, artifact) → Ꮹ (wa), not
   Ꮾ (wu).
All four are the SAME root class: prefix-final n/w + stem-initial v (the
sg3 artifact) needs the D16 nv / wa boundary fusion, plus an i-elision
before the fused Ꮕ.
The engine's existing PL3-object du- guard (D22) already models the duw-
family for SG3 subjects. What is unmodeled: PL3-subject + PL3AN-object in
Set B (candidates per the guide: d- + uni- or dan-), and the PL3ANB twins
generally. Unattested in our corpus — the attestation index can be mined for
ᏓᏅᏂ-/ᏚᏅᏂ-class forms as the tiebreak (same method as B1 below).

---

## B. Documented conflicts — evidence and what each needs

### B1. SG3SG3ANB (engine Ꭴw/Ꭴ uw- vs the attested ᎬᎨᏳᎢ gv- present forms)

**CORRECTED 2026-11-21 (user challenged the provenance):** an earlier
version of this section cited "[M-A] P4(5) ᎬᎨᏩᏍᎦ gvkewsga analyzed
'g- he--him'" — that analysis is NOT in the Montgomery OCR and the
citation was wrong; retracted. What the sources actually say:

- [Guide] P8(5) ᎤᏩᏂᎸᎢ uw- "he hit him, it" (PAST) — ONE form for both
  objects; Figure 4's 3 sg. row "uw- u-" covers only the 3sg-in/3pl-in
  columns (no animate Set B column exists in Figure 4). The engine's
  Ꭴw/Ꭴ entry matches this. The guide never prints g- for SG3SG3ANB.
- [M-A, line ~1831] mechanism note only: "Set B verbs almost always take
  the Set B prefixes, the sole exception being the small set of transitive
  Set B verbs that may take the ANIMATE OBJECT prefixes."
- [INDEX] ᎬᎨᏳᎢ gvvéyuha "he loves him" — PRESENT of a class-B verb with
  an animate object — 15+ attestations in BOTH corpora (NT 3JN 1:11/1:5/1:2,
  2TM 1:2, LUK 3:22, REV 3:9, JHN 21:15-17 + CORPUS 4176/4997/9761/10610/
  10613/11398...); the uw- candidate for this slot occurs 0x. The FORM is
  corpus-solid; the slot assignment is the open question.

**Two readings of ᎬᎨᏳᎢ**: (a) gv- is the SG3SG3ANB allomorph in the Set B
PRESENT of class-B verbs (tense-scoped alongside uw- for the past — the
corpus pattern fits: ᎤᏩ- 169 forms incl. past "he watched him"
ᎤᏩᎢᏎᎸᎯ x9+, and 0 g- forms in any past column); or (b) gv- is the
u- subject prefix's g-variant (guide (125b) ᎬᏩᎪᎲᎢ note: "u- changes to
-a- following gvw-" treats gv- as a 3rd-person Set B subject allomorph
family) with the animate marking carried another way.

**What is needed**: book eyes on the To Love / To Forget PRESENT SG3 rows
(ᎬᎨᏳᎢ-class vs ᎤᏩᎨᏳᎢ-class) to pick reading (a) or (b), then either a
tense-scoped g- allomorph rule or a documented-variance closure.

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

**REFUTED BY BOOK EVIDENCE (2026-11-20 — implementation attempt reverted).**
The positional rule was implemented (preConsonant Ꮸ) and broke ~90 suite
cells: the VRB itself prints Ꮳ before consonant-l stems — ᏓᏣᎶᎯ datsalohi
"you've brought him" (ta- da-layer + Ꮳ + consonant loh-) and the Want box
SG2 set (ᏣᏚᎵᎭ jaduliha is vowel-initial BUT siblings like ᏣᎴᎩᎭ confirm Ꮳ
elsewhere). Ꮸ appears only where the VRB/guide print it lexically. So
Ꮸ-vs-Ꮳ is PER-VERB SPELLING VARIANCE (like the D15/ga-gi class), not a
positional rule — the engine's uniform Ꮳ stays, and any verb the book
prints with Ꮸ needs a per-lexeme surface override. Decision needed from
you: leave uniform Ꮳ (current state) or survey which lexemes the book
prints with Ꮸ and override those.

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

**REFUTED BY BOOK EVIDENCE (2026-11-20 — implementation attempt reverted).**
The person-governed rule (SG1/SG2 = -soʼi, rest = -hoʼi) was implemented and
broke the suite: the "Brushing It" box (VRB, Ganea'a family) prints
-sgoʼi/-soʼi UNIFORMLY across all persons — SG3 janesoh**oʼi**-class rows
disproved the "rest = hoʼi" half. Combined with "Breaking It" the pattern
is STEM-SHAPE-governed (the INC stem's own final consonant + oʼi allomorphy,
D24 class A per-verb split), not person-governed. The engine's current
per-verb habitual column (book-printed forms in the specs) is correct.
Remaining open question (narrower): whether a generalizable stem-shape rule
exists at all, or the split stays per-verb data as it is today. Recommend:
leave per-verb (current state), close the person-rule candidate.

**SURVEY CLOSED THE QUESTION (2026-11-21 — full VRB habitual harvest, 1,786
HABITUAL rows over 345 verbs):** the tail is a per-VERB property, UNIFORM
across all persons — SG1/SG2 tail == SG3/PL3 tail for 344/345 verbs:
-sg class 218 (adadolisdisgoʼi), -h class 60 (adlohyihoʼi), -g class 38
(aliheligoi), -s class 6 (ahilisoi), other 21. The two split verbs are data
artifacts, not rules: Ganeha (jineoi vs aninehoi — the apostrophe-drop
convention makes jineʼoʼi a bare-oʼi "other" reading) and Uneguja
(aginegujoi vs unegutsoi — the ts/s-insertion family). **And the split is
NOT derivable from the stem shape either**: -sg, -h, and -g all follow
VOWEL-final INC stems (adadolisdi+sgoʼi, adayi+hoʼi, aliheli+goʼi), so the
choice among s-epenthesis/h/g after the same stem-final vowel is purely
lexical. Final ruling state: the habitual tail stays per-verb book data
(exactly what the engine's habitual column holds today); the person-rule
candidate is closed at scale, and no stem-shape rule exists to implement.
STEM-FREE habitual derivation remains blocked per-verb — consistent with
the citation-in error contract (MISSING_STEM_HABITUAL).

---

## C. Outstanding variations — consolidated list (this file is the review copy)

| # | Item | Status | Where |
|---|---|---|---|
| 1 | SG3SG3ANB g- vs Ꭴw vs u- | evidence-backed (ᎬᎨᏳᎢ x10 text) — needs your ruling | B1 above |
| 2 | SG2SG3INB Ꮸ/Ꮳ | positional rule REFUTED by book (ᏓᏣᎶᎯ) — per-verb variance; uniform Ꮳ stays unless you order the lexeme survey | B2 above |
| 3 | Ꮤ-vs-Ꮨ imperatives | needs your book eyes on the VRB boxes | B3 above |
| 4 | Habitual -soʼi/-hoʼi split | person rule REFUTED by book (Brushing box uniform -sgoʼi) — per-verb data stays; close the rule candidate | B4 above |
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
