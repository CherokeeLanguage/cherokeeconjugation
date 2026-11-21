package net.cherokeedictionary.util

/**
 * A2: OBJECT-FOCUS (unspecified-actor passive) pronominal prefixes --
 * guide hold1 I-E pp. 300-301, Paradigms Five/Six + Figure One; the same
 * paradigm M-A §9.4 calls "Object Focus Pronominal Prefixes" (Table 9.3)
 * ("the only grammatical person referenced is the object ... similar to an
 * English passive").
 *
 * Figure One encoding: in each box the form before a following VOWEL is
 * shown above the form before a following CONSONANT:
 *   1sg vgw-/vgi-, 2sg ej-/eja-, DL1incl egin-/egini-, DL1excl ogin-/ogini-,
 *   PL1incl eg-/egi-, PL1excl og-/ogi-, DL2 esd-/esdi-, PL2 ej-/eji-.
 * The vowel-stem forms are the fused shapes (prefix + w + stem-initial v):
 * P6 "to be hit" v-stem rows -- ᎥᏋᏂᎭ vgwvhniha (1sg), ᎡᏨᏂᎭ ejvhniha (2sg),
 * ᎠᎬᏂᎭ agvhniha (3sg), ᎡᎩᏅᏂᎭ eginvhniha (DL1incl), ᎡᎬᏂᎭ egvhniha (PL1incl),
 * ᎡᏍᏛᏂᎭ esdvhniha (DL2), ᎡᏨᏂᎭ ejvhniha (PL2). The 3rd-person rows (not in
 * Figure One -- the unspecified agent is not indexed) come from the
 * paradigms: ᎠᏥᎪᏩᏘᎭ aji- (3sg, P5) / ᎠᎬᏂᎭ agv- (P6); M-A Table 9.3 adds
 * geejii- (3pl, ex. 20b ᎨᏥᏍᎦᎸᏨ geejiisgahljv "they had been bitten").
 *
 * Values are GLYPH strings (pre-composed), not the latin fusion encodings
 * CompoundPrefixes uses -- the focus prefix REPLACES the pronominal compound
 * and is prepended directly to the artifact-stripped stem (see
 * VerbConjugationProcessor.processPrefixes). M-A marks several prefixes
 * (eesdii, eejii, eeginii, eegii, aji, geejii) as triggering h-alternation
 * with h-initial stems -- NOT modeled in v1;
 * documented as approximate in DISCREPANCIES. -- tio 21Nov26
 */
class ObjectFocusPrefixes {
    static final Map<String, Prefix> prefixes = [
        // 1st-person object (the undergoer)
        "SG1"     : new Prefix(preVowel: "ᎥᏋ", preConsonant: "ᎥᎩ", other: ''),    // vgw- / vgi-
        "DL1INCL" : new Prefix(preVowel: "ᎡᎩᏅ", preConsonant: "ᎡᎩᏂ", other: ''),  // egin- / egini-
        "DL1EXCL" : new Prefix(preVowel: "ᎣᎩᏅ", preConsonant: "ᎣᎩᏂ", other: ''),  // ogin- / ogini- (Figure One)
        "PL1INCL" : new Prefix(preVowel: "ᎡᎬ", preConsonant: "ᎡᎩ", other: ''),    // eg- / egi-
        "PL1EXCL" : new Prefix(preVowel: "ᎣᎬ", preConsonant: "ᎣᎩ", other: ''),    // og- / ogi- (Figure One)
        // 2nd-person object
        "SG2"     : new Prefix(preVowel: "ᎡᏨ", preConsonant: "ᎡᏣ", other: ''),    // ej- / eja-
        "DL2"     : new Prefix(preVowel: "ᎡᏍᏛ", preConsonant: "ᎡᏍᏗ", other: ''),  // esd- / esdi-
        "PL2"     : new Prefix(preVowel: "ᎡᏨ", preConsonant: "ᎡᏥ", other: ''),    // ej- / eji-
        // 3rd-person object (animate -- the paradigms' "he's being seen/hit")
        "SG3AN"   : new Prefix(preVowel: "ᎠᎬ", preConsonant: "ᎠᏥ", other: ''),    // ag- / aji-
        "PL3AN"   : new Prefix(preVowel: null, preConsonant: "ᎨᏥ", other: ''),    // geejii- (M-A 20b; no vowel-stem form attested)
    ]
}
