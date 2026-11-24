# Cherokee Verb Conjugation Engine — Product Backlog

**Created**: 2026-11-23  
**Status**: Core engine functional — validation phase pending  
**Priority Framework**: P0 = Critical, P1 = High, P2 = Medium, P3 = Low/Stretch

---

## Section A: Search & Query Interface (P0)

### A1. Build Simple CLI Wrapper
**ID**: CLI-001  
**Priority**: P0  
**Estimated Effort**: 1 day  
**Description**: Create command-line interface for quick conjugation queries without building full API infrastructure.

**Acceptance Criteria**:
- [ ] Command: `conjugate [verb] [subject] [tense]` works
- [ ] Output is readable and formatted
- [ ] Error messages are clear for invalid inputs
- [ ] Can batch process multiple requests

**Example Usage**:
```bash
./gradlew run --args="--verb speak --subject SG3 --tense PRESENT"
# Or interactive mode
./gradlew run --interactive
```

**Dependencies**: None  
**Notes**: This is minimal viable interface; not a full application.

---

### A2. Implement Verb Lookup Service
**ID**: LOOKUP-001  
**Priority**: P0  
**Estimated Effort**: 2 days  
**Description**: Create service layer for searching verbs by English gloss or meaning.

**API Design**:
```groovy
class VerbLookupService {
    List<SemanticVerbEntry> findByMeaning(String query)
    SemanticVerbEntry getCitationForm(String verbClass)
    Map<String, String> getParadigmCitations(String verbId)
}
```

**Acceptance Criteria**:
- [ ] Searches VRB database by English gloss
- [ ] Returns matching verb entries with citations
- [ ] Handles fuzzy/inexact matches gracefully
- [ ] Supports multi-word search terms

**Dependencies**: Verb registry must be populated  
**Notes**: Will power search functionality in A3

---

### A3. Create Web/API Layer
**ID**: API-001  
**Priority**: P1  
**Estimated Effort**: 3-5 days  
**Description**: Build REST/GraphQL API for programmatic access to conjugation engine.

**Endpoints**:
- `GET /verbs?gloss={term}` — search verbs
- `POST /conjugate` — conjugate verb form
  ```json
  {"verb": "speak", "subject": "SG3", "tense": "PRESENT"}
  ```
- `GET /conjugate` — conjugate via query params
- `POST /deconstruct` — analyze syllabary form
  ```json
  {"form": "ᎦᏬᏂᎭ"}
  ```
- `GET /paradigm/{verbId}` — get full paradigm

**Acceptance Criteria**:
- [ ] All endpoints documented (Swagger/OpenAPI)
- [ ] Response formats consistent
- [ ] Error responses standardized
- [ ] Rate limiting implemented
- [ ] CORS enabled for web clients

**Dependencies**: CLI wrapper (A1), Verb lookup (A2)  
**Notes**: Can start simple, iterate based on usage

---

### A4. Dictionary Application Integration
**ID**: INT-001  
**Priority**: P1  
**Estimated Effort**: 2 days  
**Description**: Integrate with Cherokee Dictionary project for seamless word lookup → conjugation flow.

**Requirements**:
- [ ] Add conjugation button/link to dictionary entries
- [ ] Show paradigm context when viewing verbs
- [ ] Display conjugated forms in dictionary searches
- [ ] Handle edge cases (unattested forms) gracefully

**Dependencies**: API layer (A3)  
**Notes**: Requires coordination with CED team

---

---

## Section B: Deconstruction & Round-Trip Testing (P1)

### B1. Verify Deconstruction → Reconstruction Round-Trip
**ID**: ROUNDTRIP-001  
**Priority**: P1  
**Estimated Effort**: 2 days  
**Description**: Validate that deconstructed forms can be re-conjugated identically.

**Test Plan**:
1. Take N random conjugated forms from attestation index
2. Run through deconstructor → get stem + affix breakdown
3. Re-compose using those components
4. Compare output to original

**Acceptance Criteria**:
- [ ] 95%+ round-trip accuracy across test set
- [ ] Clear reporting of failures with analysis
- [ ] Edge cases identified (homophones, ambiguous parses)
- [ ] Documentation of known limitations

**Dependencies**: Test harness exists  
**Notes**: Critical for confidence in engine correctness

---

### B2. Corpus Token Deconstruction Pipeline
**ID**: CORPUS-DECON-001  
**Priority**: P1  
**Estimated Effort**: 3 days  
**Description**: Build pipeline to process entire attestation corpus, deconstructing every token.

**Requirements**:
- [ ] Batch process 29,805+ attested forms
- [ ] Track success/failure rates
- [ ] Generate statistics on suffix/prefix distribution
- [ ] Export results in machine-readable format (JSON/TSV)

**Output Format**:
```json
{
  "surfaceForm": "ᎦᏬᏂᎭᏊ",
  "lemma": "woni",
  "prefixes": ["SG3"],
  "stem": "woni",
  "suffixes": ["gwu"],
  "citations": [...]
}
```

**Dependencies**: Deconstruction logic working  
**Notes**: Will inform validation and feature prioritization

---

### B3. Ambiguity Resolution Framework
**ID**: AMBIG-001  
**Priority**: P2  
**Estimated Effort**: 3-4 days  
**Description**: Systematically identify and resolve ambiguous parses.

**Approach**:
- [ ] Flag forms with multiple valid deconstructions
- [ ] Use attestation frequency to prefer most common parse
- [ ] Document cases requiring manual resolution
- [ ] Provide confidence scores for each parse

**Examples of Known Ambiguities**:
- Final -i could be factual marker OR future tense marker
- Some prefix combinations have multiple readings
- Suffix boundaries not always clear

**Dependencies**: Round-trip testing (B1)  
**Notes**: Important for production reliability

---

---

## Section C: Grammar Coverage Gaps (P2)

### C1. Object-Focus Prefixes (Passive-like)
**ID**: PASSIVE-001  
**Priority**: P2  
**Estimated Effort**: 5-7 days  
**Description**: Implement object-focus prefix family per ENGINE-COMPLETENESS.md section A2.

**Prefixes to Implement**:
| Person Reference | Singular | Dual | Plural |
|------------------|----------|------|--------|
| First person object | vvɡi- [vvɡw] | ooɡinii- | ooɡii- |
| Second person object | eeja- | eesdii-* | eejii-* |
| First & second object | - | eeɡinii-* | eeɡii-* |
| Third person object | aji- [aɡ]* | ɡeejii-* | ɡeejii-* |

(* marks trigger /h/ alternation)

**Sources**:
- Montgomery-Anderson §9.4, Table 9.3 (p. 256)
- Grammar Guide examples

**Acceptance Criteria**:
- [ ] All 6 prefixes implemented
- [ ] /h/ alternation rule applied where noted
- [ ] At least 3 worked examples tested
- [ ] Added to CompoundPrefixes registry

**Notes**: Explicitly marked as NOT DONE in current status per user request

---

### C2. Complete Local Person Pairs
**ID**: LOCAL-001  
**Priority**: P2  
**Estimated Effort**: 2-3 days  
**Description**: Finish implementing missing local person columns per ENGINE-COMPLETENESS.md A2b.

**Current Status**: SG1SG2, DL1INCLSG2 done; need to verify SG2SG1, DL1SG2, etc.

**Checklist**:
- [ ] SG1SG2 variants verified ✓ (done)
- [ ] SG2SG1 variants verified ✓ (done)
- [ ] DL1DL2 complete
- [ ] PL1PL2 complete
- [ ] All person combinations covered

**Sources**:
- M-A Table 9.2
- Grammar Guide P(13)-(16)
- Atttested corpus data

**Notes**: Already partially done per D28 notes

---

### C3. PL3-Object Set B Columns
**ID**: SETB-001  
**Priority**: P2  
**Estimated Effort**: 3-4 days  
**Description**: Implement PL3-object and PL3AN-object columns in Set B paradigms.

**Candidates**:
- dan- (plural object animate)
- du-/duan- (plural object inanimate)
- uni- variant with nv-fusion

**Sources**:
- Grammar Guide P4(21)-(23) forget examples
- M-A P8(6) duw-v- pattern
- Attestation index mining for dan-/duw- families

**Challenges**:
- Need corpus evidence for some patterns
- Boundary fusion rules (nv vs n+a) need testing

**Notes**: Low-priority, unattested in corpus currently

---

### C4. Habitual Suffix Stem-Shape Rule
**ID**: HABITUAL-001  
**Priority**: P2  
**Estimated Effort**: 2-3 days  
**Description**: Investigate if habitual suffix has derivable stem-shape rule or remains per-verb data.

**Current State**: Per-verb book data working; -sgoʼi/-hoʼi split found to be lexical, not systematic.

**Research Tasks**:
- [ ] Survey all VRB habitual columns (~345 verbs)
- [ ] Check if -sg, -h, -g patterns follow any stem-final property
- [ ] Determine if generalizable rule exists
- [ ] Update documentation accordingly

**Sources**:
- VRB "Breaking It" and "Brushing It" boxes (D24/B4)
- D28 survey findings note per-verb behavior

**Notes**: May close with "no rule exists" finding

---

---

## Section D: Validation & Testing (P2)

### D1. Full Test Suite Execution
**ID**: TESTS-001  
**Priority**: P2  
**Estimated Effort**: 1 day  
**Description**: Run complete test suite and fix any failures.

**Current State**: 
- 29,193 total tests
- 7 failures (all in FinalSuffixProcessorSpec)
- 3 ignored (reflexive guide examples)
- 99% success rate

**Tasks**:
- [ ] Resolve FinalSuffixProcessorSpec failures (tests being rewritten)
- [ ] Verify no new failures introduced
- [ ] Ensure passing state is captured

**Acceptance Criteria**:
- [ ] 100% passing (or documented exceptions)
- [ ] No regressions from baseline
- [ ] CI configuration ensures ongoing tests pass

---

### D2. Attestation Index Matching
**ID**: ATTEST-001  
**Priority**: P2  
**Estimated Effort**: 2 days  
**Description**: Verify engine can generate all attested forms in the index.

**Process**:
1. Extract surface forms from attestation index
2. Run through engine with various subject/tense combos
3. Match generated forms against attested ones
4. Report mismatches and analyze causes

**Expected Issues**:
- Some forms may require per-verb overrides
- Irregular stems may be missing from registry
- Combination edge cases

**Notes**: Validates engine coverage against real data

---

### D3. Performance Baseline
**ID**: PERF-001  
**Priority**: P3  
**Estimated Effort**: 1 day  
**Description**: Establish performance metrics for batch processing.

**Metrics to Measure**:
- Time to conjugate single verb form
- Time per 100 forms
- Time per 1,000 forms
- Memory usage during batch operation

**Benchmark Target**:
- Single conjugation < 10ms
- 1,000 forms < 30 seconds

**Acceptance Criteria**:
- [ ] Baseline numbers established
- [ ] Any critical slowness identified
- [ ] Optimization opportunities documented

---

---

## Section E: Integration Examples (P3)

### E1. Add Integration Examples for Suffixes
**ID**: INTEGRATION-EX-001  
**Priority**: P3  
**Estimated Effort**: 3-4 days  
**Description**: Comprehensive example set showing each suffix category in action.

**Required Examples**:

#### Final Suffixes (18+ examples):
- gwu (also/too): "ᎠᎩᏬᏂᏏᎶᏣᏊ" — "He also speaks to me"
- sgo (perhaps): "ᎢᎸᏍᎪᎢ" — "Perhaps he's coming"
- ju (just): "ᏓᎴᏅᏛᏧ" — "We just finished"
- ke (emphasis/question): "ᎠᏒᏗᏨᎬ" — "Are you really doing it?"
- di (conditional): "ᎾᎢᏳᏃᏗ" — "If it happens..."
- svi (vowel-finalization): "ᎠᏑᏩᏍᏢᏍᎢ" — special nasal form
- vi (completive): "ᏫᏣᏁᏟᏴᏏᎥᎢ" — "You're finishing it"
- ei (inchoative): "ᎣᏏᏉᏱᏲᎡᎢ" — "It begins to become clear"
- oi (habitual): "ᎣᏏᏳᎾᏙᎯᏯᎢ" — "They habitually gather"
- [Plus 8 more individual examples]

#### Non-Final Suffixes (12+ examples):
- gi (reversive): "ᏌᏯᏙᏔ" — "Unweave it" (undo weave)
- is (duplicative): "ᏗᎶᏍᏓᏅ" — "Do repeatedly"
- idi (pre-incipient): "ᏗᏁᎦᏙᎵᏍᏗ" — "About to stand"
- i (future): "ᎦᏬᏂᏏ" — "Will speak"
- [Plus 8 more non-final examples]

#### Stacked Combinations (5+ examples):
- Reversive + future: "ᏌᏯᏍᏗ" — "Will undo"
- Around + progressive: "ᏗᎪᏪᎵᏗᏕᎦ" — "Going around writing"
- [Plus 3 more combination examples]

**Acceptance Criteria**:
- [ ] At least 3 examples per major suffix type
- [ ] Full morphological breakdown for each
- [ ] Source references (Grammar Guide page, VRB page)
- [ ] Passes deconstruction/reconstruction round-trip
- [ ] Written into docs/IntegrationExamples.md

**Dependencies**: All suffix implementations complete  
**Notes**: High value for documentation and understanding

---

---

## Section F: Infrastructure & Tooling (P3)

### F1. CI/CD Pipeline Configuration
**ID**: CI-001  
**Priority**: P2  
**Estimated Effort**: 1 day  
**Description**: Configure continuous integration for automatic testing.

**Setup**:
- [ ] GitHub Actions workflow
- [ ] Auto-run tests on push/PR
- [ ] Fail build if > X% tests fail
- [ ] Generate test coverage report

**Files Needed**:
- `.github/workflows/test.yml`
- Code coverage tool setup

**Notes**: Standard practice for any active project

---

### F2. Code Generation Scripts
**ID**: GEN-001  
**Priority**: P3  
**Estimated Effort**: 2 days  
**Description**: Create scripts to auto-generate boilerplate code.

**Automation Targets**:
- [ ] New suffix class scaffold
- [ ] New prefix class scaffold
- [ ] Spec file templates
- [ ] Paradigm citation extraction

**Benefits**:
- Reduce repetitive coding
- Enforce naming conventions
- Speed up implementation

**Notes**: Nice-to-have for development velocity

---

### F3. Interactive REPL
**ID**: REPL-001  
**Priority**: P3  
**Estimated Effort**: 2 days  
**Description**: Build interactive console for experimenting with conjugation.

**Features**:
- [ ] Line-by-line input prompt
- [ ] History buffer
- [ ] Tab completion for verbs
- [ ] Quick paradigm view ("p speak")
- [ ] Save/load sessions

**Tech Stack**: JLine or similar Groovy-friendly REPL library

---

---

## Appendix: References

### Documents Referenced:
- `ENGINE-COMPLETENESS.md` — Detailed gap analysis
- `VRB-RECONCILIATION-MANIFEST.txt` — Suffix list source
- `GAP.md` — Stem coverage gaps
- `IMPLEMENTATION-SUMMARY.md` — Current state summary
- `docs/NonFinalSuffixes.md` — Non-final suffix reference

### Sources Cited:
- Feeling, Thomas (1975). *A Grammar of the Cherokee Language*
- Cherokee Nation (2012). *Cherokee Verb Conjugations* (VRB)
- Montgomery-Anderson (2008). *A Cherokee Reference Grammar*
- Grammar Guide (current CED grammar documentation)

### Priority Definitions:
- **P0**: Blocking production launch
- **P1**: Significant feature work
- **P2**: Nice-to-have improvements
- **P3**: Stretch goals / nice additions

---

## Legend

| Icon | Meaning |
|------|---------|
| ✅ | Planned/Done |
| 🟡 | In Progress |
| ❌ | Not Started |
| ⚠️ | Blocked/Unknown |

---

**Backlog Maintainer**: tio  
**Last Updated**: 2026-11-23  
**Version**: v1.0 (initial backlog)
