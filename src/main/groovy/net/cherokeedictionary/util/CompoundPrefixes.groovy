package net.cherokeedictionary.util

/**
 * Created by torr on 8/17/2015.
 */
// ALIGNMENT NOTES (PDF review, printed pp.167-181): the authoritative source for this
// table is Appendix B "Subject-Object Prefixes" (van Tuyl & Feeling 1994) on printed
// pp.178-180 of the verb book, but those pages are image-only scans in the uploaded
// PDF (no text layer), so the printed tables could not be read cell-by-cell -- timo 10Nov26
// Proxy check done against the Feeling 1975 grammar guide (dictionary/build/assets/hold1.txt):
// ~60 combos verified against Paradigm One "to tie up" (Set A, vowel stems), Paradigm
// Four "to forget" (Set B), Paradigm Five "to like" (Set B, consonant stems) and
// Paradigm Six "to speak" (Set A, consonant stems); no clear errors found -- timo 10Nov26
// Allomorphy: Set A 1st person sg = ji- before consonant stems, g- before vowel stems;
// this is encoded as preConsonant 'Ꮵ' + preVowel 'G', where 'G' makes Morphemes.G map
// the stem's first vowel syllable to its g-form (e.g. Ꭰ->Ꭶ, Ꭵ->Ꭼ) -- timo 10Nov26
// Remaining combos must be verified against the pp.178-180 scans once they are
// available in readable form (text-layer PDF or transcription) -- timo 10Nov26
class CompoundPrefixes {
    static def prefixes = [:]
    static final def SG1SG1 = new CompoundPrefix(prefix1: PrefixTableSubject.SG1, prefix2: PrefixTableObject.SG1)
    static final def SG1SG2 = new CompoundPrefix(prefix1: PrefixTableSubject.SG1, prefix2: PrefixTableObject.SG2)
    static final def SG1SG3AN = new CompoundPrefix(prefix1: PrefixTableSubject.SG1, prefix2: PrefixTableObject.SG3AN)
    static final def SG1SG3IN = new CompoundPrefix(prefix1: PrefixTableSubject.SG1, prefix2: PrefixTableObject.SG3IN)
    static final def SG1DL1INCL = new CompoundPrefix(prefix1: PrefixTableSubject.SG1, prefix2: PrefixTableObject.DL1INCL)
    static final def SG1DL1EXCL = new CompoundPrefix(prefix1: PrefixTableSubject.SG1, prefix2: PrefixTableObject.DL1EXCL)
    static final def SG1PL1INCL = new CompoundPrefix(prefix1: PrefixTableSubject.SG1, prefix2: PrefixTableObject.PL1INCL)
    static final def SG1PL1EXCL = new CompoundPrefix(prefix1: PrefixTableSubject.SG1, prefix2: PrefixTableObject.PL1EXCL)
    static final def SG1DL2 = new CompoundPrefix(prefix1: PrefixTableSubject.SG1, prefix2: PrefixTableObject.DL2)
    static final def SG1PL2 = new CompoundPrefix(prefix1: PrefixTableSubject.SG1, prefix2: PrefixTableObject.PL2)
    static final def SG1PL3AN = new CompoundPrefix(prefix1: PrefixTableSubject.SG1, prefix2: PrefixTableObject.PL3AN)
    static final def SG1PL3IN = new CompoundPrefix(prefix1: PrefixTableSubject.SG1, prefix2: PrefixTableObject.PL3IN)
    static final def SG2SG1 = new CompoundPrefix(prefix1: PrefixTableSubject.SG2, prefix2: PrefixTableObject.SG1)
    static final def SG2SG2 = new CompoundPrefix(prefix1: PrefixTableSubject.SG2, prefix2: PrefixTableObject.SG2)
    static final def SG2SG3AN = new CompoundPrefix(prefix1: PrefixTableSubject.SG2, prefix2: PrefixTableObject.SG3AN)
    static final def SG2SG3IN = new CompoundPrefix(prefix1: PrefixTableSubject.SG2, prefix2: PrefixTableObject.SG3IN)
    static final def SG2DL1INCL = new CompoundPrefix(prefix1: PrefixTableSubject.SG2, prefix2: PrefixTableObject.DL1INCL)
    static final def SG2DL1EXCL = new CompoundPrefix(prefix1: PrefixTableSubject.SG2, prefix2: PrefixTableObject.DL1EXCL)
    static final def SG2PL1INCL = new CompoundPrefix(prefix1: PrefixTableSubject.SG2, prefix2: PrefixTableObject.PL1INCL)
    static final def SG2PL1EXCL = new CompoundPrefix(prefix1: PrefixTableSubject.SG2, prefix2: PrefixTableObject.PL1EXCL)
    static final def SG2DL2 = new CompoundPrefix(prefix1: PrefixTableSubject.SG2, prefix2: PrefixTableObject.DL2)
    static final def SG2PL2 = new CompoundPrefix(prefix1: PrefixTableSubject.SG2, prefix2: PrefixTableObject.PL2)
    static final def SG2PL3AN = new CompoundPrefix(prefix1: PrefixTableSubject.SG2, prefix2: PrefixTableObject.PL3AN)
    static final def SG2PL3IN = new CompoundPrefix(prefix1: PrefixTableSubject.SG2, prefix2: PrefixTableObject.PL3IN)
    static final def SG3SG1 = new CompoundPrefix(prefix1: PrefixTableSubject.SG3, prefix2: PrefixTableObject.SG1)
    static final def SG3SG2 = new CompoundPrefix(prefix1: PrefixTableSubject.SG3, prefix2: PrefixTableObject.SG2)
    static final def SG3SG3AN = new CompoundPrefix(prefix1: PrefixTableSubject.SG3, prefix2: PrefixTableObject.SG3AN)
    static final def SG3SG3IN = new CompoundPrefix(prefix1: PrefixTableSubject.SG3, prefix2: PrefixTableObject.SG3IN)
    static final def SG3DL1INCL = new CompoundPrefix(prefix1: PrefixTableSubject.SG3, prefix2: PrefixTableObject.DL1INCL)
    static final def SG3DL1EXCL = new CompoundPrefix(prefix1: PrefixTableSubject.SG3, prefix2: PrefixTableObject.DL1EXCL)
    static final def SG3PL1INCL = new CompoundPrefix(prefix1: PrefixTableSubject.SG3, prefix2: PrefixTableObject.PL1INCL)
    static final def SG3PL1EXCL = new CompoundPrefix(prefix1: PrefixTableSubject.SG3, prefix2: PrefixTableObject.PL1EXCL)
    static final def SG3DL2 = new CompoundPrefix(prefix1: PrefixTableSubject.SG3, prefix2: PrefixTableObject.DL2)
    static final def SG3PL2 = new CompoundPrefix(prefix1: PrefixTableSubject.SG3, prefix2: PrefixTableObject.PL2)
    static final def SG3PL3AN = new CompoundPrefix(prefix1: PrefixTableSubject.SG3, prefix2: PrefixTableObject.PL3AN)
    static final def SG3PL3IN = new CompoundPrefix(prefix1: PrefixTableSubject.SG3, prefix2: PrefixTableObject.PL3IN)
    static final def DL1INCLSG1 = new CompoundPrefix(prefix1: PrefixTableSubject.DL1INCL, prefix2: PrefixTableObject.SG1)
    static final def DL1INCLSG2 = new CompoundPrefix(prefix1: PrefixTableSubject.DL1INCL, prefix2: PrefixTableObject.SG2)
    static final def DL1INCLSG3AN = new CompoundPrefix(prefix1: PrefixTableSubject.DL1INCL, prefix2: PrefixTableObject.SG3AN)
    static final def DL1INCLSG3IN = new CompoundPrefix(prefix1: PrefixTableSubject.DL1INCL, prefix2: PrefixTableObject.SG3IN)
    static final def DL1INCLDL1INCL = new CompoundPrefix(prefix1: PrefixTableSubject.DL1INCL, prefix2: PrefixTableObject.DL1INCL)
    static final def DL1INCLDL1EXCL = new CompoundPrefix(prefix1: PrefixTableSubject.DL1INCL, prefix2: PrefixTableObject.DL1EXCL)
    static final def DL1INCLPL1INCL = new CompoundPrefix(prefix1: PrefixTableSubject.DL1INCL, prefix2: PrefixTableObject.PL1INCL)
    static final def DL1INCLPL1EXCL = new CompoundPrefix(prefix1: PrefixTableSubject.DL1INCL, prefix2: PrefixTableObject.PL1EXCL)
    static final def DL1INCLDL2 = new CompoundPrefix(prefix1: PrefixTableSubject.DL1INCL, prefix2: PrefixTableObject.DL2)
    static final def DL1INCLPL2 = new CompoundPrefix(prefix1: PrefixTableSubject.DL1INCL, prefix2: PrefixTableObject.PL2)
    static final def DL1INCLPL3AN = new CompoundPrefix(prefix1: PrefixTableSubject.DL1INCL, prefix2: PrefixTableObject.PL3AN)
    static final def DL1INCLPL3IN = new CompoundPrefix(prefix1: PrefixTableSubject.DL1INCL, prefix2: PrefixTableObject.PL3IN)
    static final def DL1EXCLSG1 = new CompoundPrefix(prefix1: PrefixTableSubject.DL1EXCL, prefix2: PrefixTableObject.SG1)
    static final def DL1EXCLSG2 = new CompoundPrefix(prefix1: PrefixTableSubject.DL1EXCL, prefix2: PrefixTableObject.SG2)
    static final def DL1EXCLSG3AN = new CompoundPrefix(prefix1: PrefixTableSubject.DL1EXCL, prefix2: PrefixTableObject.SG3AN)
    static final def DL1EXCLSG3IN = new CompoundPrefix(prefix1: PrefixTableSubject.DL1EXCL, prefix2: PrefixTableObject.SG3IN)
    static final def DL1EXCLDL1INCL = new CompoundPrefix(prefix1: PrefixTableSubject.DL1EXCL, prefix2: PrefixTableObject.DL1INCL)
    static final def DL1EXCLDL1EXCL = new CompoundPrefix(prefix1: PrefixTableSubject.DL1EXCL, prefix2: PrefixTableObject.DL1EXCL)
    static final def DL1EXCLPL1INCL = new CompoundPrefix(prefix1: PrefixTableSubject.DL1EXCL, prefix2: PrefixTableObject.PL1INCL)
    static final def DL1EXCLPL1EXCL = new CompoundPrefix(prefix1: PrefixTableSubject.DL1EXCL, prefix2: PrefixTableObject.PL1EXCL)
    static final def DL1EXCLDL2 = new CompoundPrefix(prefix1: PrefixTableSubject.DL1EXCL, prefix2: PrefixTableObject.DL2)
    static final def DL1EXCLPL2 = new CompoundPrefix(prefix1: PrefixTableSubject.DL1EXCL, prefix2: PrefixTableObject.PL2)
    static final def DL1EXCLPL3AN = new CompoundPrefix(prefix1: PrefixTableSubject.DL1EXCL, prefix2: PrefixTableObject.PL3AN)
    static final def DL1EXCLPL3IN = new CompoundPrefix(prefix1: PrefixTableSubject.DL1EXCL, prefix2: PrefixTableObject.PL3IN)
    static final def PL1INCLSG1 = new CompoundPrefix(prefix1: PrefixTableSubject.PL1INCL, prefix2: PrefixTableObject.SG1)
    static final def PL1INCLSG2 = new CompoundPrefix(prefix1: PrefixTableSubject.PL1INCL, prefix2: PrefixTableObject.SG2)
    static final def PL1INCLSG3AN = new CompoundPrefix(prefix1: PrefixTableSubject.PL1INCL, prefix2: PrefixTableObject.SG3AN)
    static final def PL1INCLSG3IN = new CompoundPrefix(prefix1: PrefixTableSubject.PL1INCL, prefix2: PrefixTableObject.SG3IN)
    static final def PL1INCLDL1INCL = new CompoundPrefix(prefix1: PrefixTableSubject.PL1INCL, prefix2: PrefixTableObject.DL1INCL)
    static final def PL1INCLDL1EXCL = new CompoundPrefix(prefix1: PrefixTableSubject.PL1INCL, prefix2: PrefixTableObject.DL1EXCL)
    static final def PL1INCLPL1INCL = new CompoundPrefix(prefix1: PrefixTableSubject.PL1INCL, prefix2: PrefixTableObject.PL1INCL)
    static final def PL1INCLPL1EXCL = new CompoundPrefix(prefix1: PrefixTableSubject.PL1INCL, prefix2: PrefixTableObject.PL1EXCL)
    static final def PL1INCLDL2 = new CompoundPrefix(prefix1: PrefixTableSubject.PL1INCL, prefix2: PrefixTableObject.DL2)
    static final def PL1INCLPL2 = new CompoundPrefix(prefix1: PrefixTableSubject.PL1INCL, prefix2: PrefixTableObject.PL2)
    static final def PL1INCLPL3AN = new CompoundPrefix(prefix1: PrefixTableSubject.PL1INCL, prefix2: PrefixTableObject.PL3AN)
    static final def PL1INCLPL3IN = new CompoundPrefix(prefix1: PrefixTableSubject.PL1INCL, prefix2: PrefixTableObject.PL3IN)
    static final def PL1EXCLSG1 = new CompoundPrefix(prefix1: PrefixTableSubject.PL1EXCL, prefix2: PrefixTableObject.SG1)
    static final def PL1EXCLSG2 = new CompoundPrefix(prefix1: PrefixTableSubject.PL1EXCL, prefix2: PrefixTableObject.SG2)
    static final def PL1EXCLSG3AN = new CompoundPrefix(prefix1: PrefixTableSubject.PL1EXCL, prefix2: PrefixTableObject.SG3AN)
    static final def PL1EXCLSG3IN = new CompoundPrefix(prefix1: PrefixTableSubject.PL1EXCL, prefix2: PrefixTableObject.SG3IN)
    static final def PL1EXCLDL1INCL = new CompoundPrefix(prefix1: PrefixTableSubject.PL1EXCL, prefix2: PrefixTableObject.DL1INCL)
    static final def PL1EXCLDL1EXCL = new CompoundPrefix(prefix1: PrefixTableSubject.PL1EXCL, prefix2: PrefixTableObject.DL1EXCL)
    static final def PL1EXCLPL1INCL = new CompoundPrefix(prefix1: PrefixTableSubject.PL1EXCL, prefix2: PrefixTableObject.PL1INCL)
    static final def PL1EXCLPL1EXCL = new CompoundPrefix(prefix1: PrefixTableSubject.PL1EXCL, prefix2: PrefixTableObject.PL1EXCL)
    static final def PL1EXCLDL2 = new CompoundPrefix(prefix1: PrefixTableSubject.PL1EXCL, prefix2: PrefixTableObject.DL2)
    static final def PL1EXCLPL2 = new CompoundPrefix(prefix1: PrefixTableSubject.PL1EXCL, prefix2: PrefixTableObject.PL2)
    static final def PL1EXCLPL3AN = new CompoundPrefix(prefix1: PrefixTableSubject.PL1EXCL, prefix2: PrefixTableObject.PL3AN)
    static final def PL1EXCLPL3IN = new CompoundPrefix(prefix1: PrefixTableSubject.PL1EXCL, prefix2: PrefixTableObject.PL3IN)
    static final def DL2SG1 = new CompoundPrefix(prefix1: PrefixTableSubject.DL2, prefix2: PrefixTableObject.SG1)
    static final def DL2SG2 = new CompoundPrefix(prefix1: PrefixTableSubject.DL2, prefix2: PrefixTableObject.SG2)
    static final def DL2SG3AN = new CompoundPrefix(prefix1: PrefixTableSubject.DL2, prefix2: PrefixTableObject.SG3AN)
    static final def DL2SG3IN = new CompoundPrefix(prefix1: PrefixTableSubject.DL2, prefix2: PrefixTableObject.SG3IN)
    static final def DL2DL1INCL = new CompoundPrefix(prefix1: PrefixTableSubject.DL2, prefix2: PrefixTableObject.DL1INCL)
    static final def DL2DL1EXCL = new CompoundPrefix(prefix1: PrefixTableSubject.DL2, prefix2: PrefixTableObject.DL1EXCL)
    static final def DL2PL1INCL = new CompoundPrefix(prefix1: PrefixTableSubject.DL2, prefix2: PrefixTableObject.PL1INCL)
    static final def DL2PL1EXCL = new CompoundPrefix(prefix1: PrefixTableSubject.DL2, prefix2: PrefixTableObject.PL1EXCL)
    static final def DL2DL2 = new CompoundPrefix(prefix1: PrefixTableSubject.DL2, prefix2: PrefixTableObject.DL2)
    static final def DL2PL2 = new CompoundPrefix(prefix1: PrefixTableSubject.DL2, prefix2: PrefixTableObject.PL2)
    static final def DL2PL3AN = new CompoundPrefix(prefix1: PrefixTableSubject.DL2, prefix2: PrefixTableObject.PL3AN)
    static final def DL2PL3IN = new CompoundPrefix(prefix1: PrefixTableSubject.DL2, prefix2: PrefixTableObject.PL3IN)
    static final def PL2SG1 = new CompoundPrefix(prefix1: PrefixTableSubject.PL2, prefix2: PrefixTableObject.SG1)
    static final def PL2SG2 = new CompoundPrefix(prefix1: PrefixTableSubject.PL2, prefix2: PrefixTableObject.SG2)
    static final def PL2SG3AN = new CompoundPrefix(prefix1: PrefixTableSubject.PL2, prefix2: PrefixTableObject.SG3AN)
    static final def PL2SG3IN = new CompoundPrefix(prefix1: PrefixTableSubject.PL2, prefix2: PrefixTableObject.SG3IN)
    static final def PL2DL1INCL = new CompoundPrefix(prefix1: PrefixTableSubject.PL2, prefix2: PrefixTableObject.DL1INCL)
    static final def PL2DL1EXCL = new CompoundPrefix(prefix1: PrefixTableSubject.PL2, prefix2: PrefixTableObject.DL1EXCL)
    static final def PL2PL1INCL = new CompoundPrefix(prefix1: PrefixTableSubject.PL2, prefix2: PrefixTableObject.PL1INCL)
    static final def PL2PL1EXCL = new CompoundPrefix(prefix1: PrefixTableSubject.PL2, prefix2: PrefixTableObject.PL1EXCL)
    static final def PL2DL2 = new CompoundPrefix(prefix1: PrefixTableSubject.PL2, prefix2: PrefixTableObject.DL2)
    static final def PL2PL2 = new CompoundPrefix(prefix1: PrefixTableSubject.PL2, prefix2: PrefixTableObject.PL2)
    static final def PL2PL3AN = new CompoundPrefix(prefix1: PrefixTableSubject.PL2, prefix2: PrefixTableObject.PL3AN)
    static final def PL2PL3IN = new CompoundPrefix(prefix1: PrefixTableSubject.PL2, prefix2: PrefixTableObject.PL3IN)
    static final def PL3SG1 = new CompoundPrefix(prefix1: PrefixTableSubject.PL3, prefix2: PrefixTableObject.SG1)
    static final def PL3SG2 = new CompoundPrefix(prefix1: PrefixTableSubject.PL3, prefix2: PrefixTableObject.SG2)
    static final def PL3SG3AN = new CompoundPrefix(prefix1: PrefixTableSubject.PL3, prefix2: PrefixTableObject.SG3AN)
    static final def PL3SG3IN = new CompoundPrefix(prefix1: PrefixTableSubject.PL3, prefix2: PrefixTableObject.SG3IN)
    static final def PL3DL1INCL = new CompoundPrefix(prefix1: PrefixTableSubject.PL3, prefix2: PrefixTableObject.DL1INCL)
    static final def PL3DL1EXCL = new CompoundPrefix(prefix1: PrefixTableSubject.PL3, prefix2: PrefixTableObject.DL1EXCL)
    static final def PL3PL1INCL = new CompoundPrefix(prefix1: PrefixTableSubject.PL3, prefix2: PrefixTableObject.PL1INCL)
    static final def PL3PL1EXCL = new CompoundPrefix(prefix1: PrefixTableSubject.PL3, prefix2: PrefixTableObject.PL1EXCL)
    static final def PL3DL2 = new CompoundPrefix(prefix1: PrefixTableSubject.PL3, prefix2: PrefixTableObject.DL2)
    static final def PL3PL2 = new CompoundPrefix(prefix1: PrefixTableSubject.PL3, prefix2: PrefixTableObject.PL2)
    static final def PL3PL3AN = new CompoundPrefix(prefix1: PrefixTableSubject.PL3, prefix2: PrefixTableObject.PL3AN)
    static final def PL3PL3IN = new CompoundPrefix(prefix1: PrefixTableSubject.PL3, prefix2: PrefixTableObject.PL3IN)

    // B-variant fields: as of 10Nov26 every declared B field has a prefixes.put(...)
    // below, and every Set A combination has a B twin as well -- the twin block
    // before the static block adds empty-valued B fields for combinations with no attested
    // Set B form, so a Set B lookup can never return a null CompoundPrefix
    // (ConjugationHelper.determineCompoundPrefix) -- timo 10Nov26
    static final def SG1SG3INB = new CompoundPrefix(prefix1: PrefixTableSubject.SG1, prefix2: PrefixTableObject.SG3IN)
    static final def SG2SG3INB = new CompoundPrefix(prefix1: PrefixTableSubject.SG2, prefix2: PrefixTableObject.SG3IN)
    static final def SG3SG3INB = new CompoundPrefix(prefix1: PrefixTableSubject.SG3, prefix2: PrefixTableObject.SG3IN)
    //timo 10Nov26: P4(21) "they're forgetting him" = an- = Set A ani-; App. B p.180
    //(they->him) Class B column blank, i.e. same as Class A
    static final def PL3SG3ANB = new CompoundPrefix(prefix1: PrefixTableSubject.PL3, prefix2: PrefixTableObject.SG3AN)
    static final def DL1INCLSG3INB = new CompoundPrefix(prefix1: PrefixTableSubject.DL1INCL, prefix2: PrefixTableObject.SG3IN)
    static final def PL1INCLSG3INB = new CompoundPrefix(prefix1: PrefixTableSubject.PL1INCL, prefix2: PrefixTableObject.SG3IN)
    static final def DL1EXCLSG3INB = new CompoundPrefix(prefix1: PrefixTableSubject.DL1EXCL, prefix2: PrefixTableObject.SG3IN)
    static final def PL1EXCLSG3INB = new CompoundPrefix(prefix1: PrefixTableSubject.PL1EXCL, prefix2: PrefixTableObject.SG3IN)
    static final def PL3SG3INB = new CompoundPrefix(prefix1: PrefixTableSubject.PL3, prefix2: PrefixTableObject.SG3IN)

    static final def SG1PL3INB = new CompoundPrefix(prefix1: PrefixTableSubject.SG1, prefix2: PrefixTableObject.PL3IN)
    static final def SG2PL3INB = new CompoundPrefix(prefix1: PrefixTableSubject.SG2, prefix2: PrefixTableObject.PL3IN)
    static final def SG3PL3INB = new CompoundPrefix(prefix1: PrefixTableSubject.SG3, prefix2: PrefixTableObject.PL3IN)
    static final def DL1INCLPL3INB = new CompoundPrefix(prefix1: PrefixTableSubject.DL1INCL, prefix2: PrefixTableObject.PL3IN)
    static final def PL1INCLPL3INB = new CompoundPrefix(prefix1: PrefixTableSubject.PL1INCL, prefix2: PrefixTableObject.PL3IN)

    static final def DL1EXCLPL3INB = new CompoundPrefix(prefix1: PrefixTableSubject.DL1EXCL, prefix2: PrefixTableObject.PL3IN)
    static final def PL1EXCLPL3INB = new CompoundPrefix(prefix1: PrefixTableSubject.PL1EXCL, prefix2: PrefixTableObject.PL3IN)

    static final def PL3PL3ANB = new CompoundPrefix(prefix1: PrefixTableSubject.PL3, prefix2: PrefixTableObject.PL3AN)
    static final def PL3PL3INB = new CompoundPrefix(prefix1: PrefixTableSubject.PL3, prefix2: PrefixTableObject.PL3IN)

    static final def DL2SG3INB = new CompoundPrefix(prefix1: PrefixTableSubject.DL2, prefix2: PrefixTableObject.SG3IN)
    static final def PL2SG3INB = new CompoundPrefix(prefix1: PrefixTableSubject.PL2, prefix2: PrefixTableObject.SG3IN)

    static final def SG1PL3ANB = new CompoundPrefix(prefix1: PrefixTableSubject.SG1, prefix2: PrefixTableObject.PL3AN)
    static final def SG1SG2B = new CompoundPrefix(prefix1: PrefixTableSubject.SG1, prefix2: PrefixTableObject.SG2)
    static final def SG2PL3ANB = new CompoundPrefix(prefix1: PrefixTableSubject.SG2, prefix2: PrefixTableObject.PL3AN)
    static final def SG1SG3ANB = new CompoundPrefix(prefix1: PrefixTableSubject.SG1, prefix2: PrefixTableObject.SG3AN)
    static final def SG3PL3ANB = new CompoundPrefix(prefix1: PrefixTableSubject.SG3, prefix2: PrefixTableObject.PL3AN)
    static final def DL1INCLPL3ANB = new CompoundPrefix(prefix1: PrefixTableSubject.DL1INCL, prefix2: PrefixTableObject.PL3AN)
    static final def DL1EXCLPL3ANB = new CompoundPrefix(prefix1: PrefixTableSubject.DL1EXCL, prefix2: PrefixTableObject.PL3AN)

    static final def DL2PL3ANB = new CompoundPrefix(prefix1: PrefixTableSubject.DL2, prefix2: PrefixTableObject.PL3AN)
    static final def PL1INCLPL3ANB = new CompoundPrefix(prefix1: PrefixTableSubject.PL1INCL, prefix2: PrefixTableObject.PL3AN)
    static final def PL1EXCLPL3ANB = new CompoundPrefix(prefix1: PrefixTableSubject.PL1EXCL, prefix2: PrefixTableObject.PL3AN)
    static final def PL2PL3ANB = new CompoundPrefix(prefix1: PrefixTableSubject.PL2, prefix2: PrefixTableObject.PL3AN)
    static final def DL2PL3INB = new CompoundPrefix(prefix1: PrefixTableSubject.DL2, prefix2: PrefixTableObject.PL3IN)
    static final def PL2PL3INB  = new CompoundPrefix(prefix1: PrefixTableSubject.PL2, prefix2: PrefixTableObject.PL3IN)
    static final def SG3SG3ANB  = new CompoundPrefix(prefix1: PrefixTableSubject.SG3, prefix2: PrefixTableObject.SG3AN)

    //timo 10Nov26: empty B twins for every Set A combination with no attested Set B
    //form. Appendix B (pp.178-180) leaves the Class B column blank wherever Set B does
    //not differ from Set A, and those blanks are mirrored here as fields with empty
    //preVowel/preConsonant/other. Rationale (user decision): a combination the tables
    //give no Set B form for cannot be prevented from being requested, so the field
    //must at least exist; the worst case is then a visibly "bad" (prefix-less)
    //conjugation rather than a null CompoundPrefix -- timo 10Nov26
    static final def SG1SG1B = new CompoundPrefix(prefix1: PrefixTableSubject.SG1, prefix2: PrefixTableObject.SG1)
    static final def SG1DL1INCLB = new CompoundPrefix(prefix1: PrefixTableSubject.SG1, prefix2: PrefixTableObject.DL1INCL)
    static final def SG1DL1EXCLB = new CompoundPrefix(prefix1: PrefixTableSubject.SG1, prefix2: PrefixTableObject.DL1EXCL)
    static final def SG1PL1INCLB = new CompoundPrefix(prefix1: PrefixTableSubject.SG1, prefix2: PrefixTableObject.PL1INCL)
    static final def SG1PL1EXCLB = new CompoundPrefix(prefix1: PrefixTableSubject.SG1, prefix2: PrefixTableObject.PL1EXCL)
    static final def SG1DL2B = new CompoundPrefix(prefix1: PrefixTableSubject.SG1, prefix2: PrefixTableObject.DL2)
    static final def SG1PL2B = new CompoundPrefix(prefix1: PrefixTableSubject.SG1, prefix2: PrefixTableObject.PL2)
    static final def SG2SG1B = new CompoundPrefix(prefix1: PrefixTableSubject.SG2, prefix2: PrefixTableObject.SG1)
    static final def SG2SG2B = new CompoundPrefix(prefix1: PrefixTableSubject.SG2, prefix2: PrefixTableObject.SG2)
    static final def SG2SG3ANB = new CompoundPrefix(prefix1: PrefixTableSubject.SG2, prefix2: PrefixTableObject.SG3AN)
    static final def SG2DL1INCLB = new CompoundPrefix(prefix1: PrefixTableSubject.SG2, prefix2: PrefixTableObject.DL1INCL)
    static final def SG2DL1EXCLB = new CompoundPrefix(prefix1: PrefixTableSubject.SG2, prefix2: PrefixTableObject.DL1EXCL)
    static final def SG2PL1INCLB = new CompoundPrefix(prefix1: PrefixTableSubject.SG2, prefix2: PrefixTableObject.PL1INCL)
    static final def SG2PL1EXCLB = new CompoundPrefix(prefix1: PrefixTableSubject.SG2, prefix2: PrefixTableObject.PL1EXCL)
    static final def SG2DL2B = new CompoundPrefix(prefix1: PrefixTableSubject.SG2, prefix2: PrefixTableObject.DL2)
    static final def SG2PL2B = new CompoundPrefix(prefix1: PrefixTableSubject.SG2, prefix2: PrefixTableObject.PL2)
    static final def SG3SG1B = new CompoundPrefix(prefix1: PrefixTableSubject.SG3, prefix2: PrefixTableObject.SG1)
    static final def SG3SG2B = new CompoundPrefix(prefix1: PrefixTableSubject.SG3, prefix2: PrefixTableObject.SG2)
    static final def SG3DL1INCLB = new CompoundPrefix(prefix1: PrefixTableSubject.SG3, prefix2: PrefixTableObject.DL1INCL)
    static final def SG3DL1EXCLB = new CompoundPrefix(prefix1: PrefixTableSubject.SG3, prefix2: PrefixTableObject.DL1EXCL)
    static final def SG3PL1INCLB = new CompoundPrefix(prefix1: PrefixTableSubject.SG3, prefix2: PrefixTableObject.PL1INCL)
    static final def SG3PL1EXCLB = new CompoundPrefix(prefix1: PrefixTableSubject.SG3, prefix2: PrefixTableObject.PL1EXCL)
    static final def SG3DL2B = new CompoundPrefix(prefix1: PrefixTableSubject.SG3, prefix2: PrefixTableObject.DL2)
    static final def SG3PL2B = new CompoundPrefix(prefix1: PrefixTableSubject.SG3, prefix2: PrefixTableObject.PL2)
    static final def DL1INCLSG1B = new CompoundPrefix(prefix1: PrefixTableSubject.DL1INCL, prefix2: PrefixTableObject.SG1)
    static final def DL1INCLSG2B = new CompoundPrefix(prefix1: PrefixTableSubject.DL1INCL, prefix2: PrefixTableObject.SG2)
    static final def DL1INCLSG3ANB = new CompoundPrefix(prefix1: PrefixTableSubject.DL1INCL, prefix2: PrefixTableObject.SG3AN)
    static final def DL1INCLDL1INCLB = new CompoundPrefix(prefix1: PrefixTableSubject.DL1INCL, prefix2: PrefixTableObject.DL1INCL)
    static final def DL1INCLDL1EXCLB = new CompoundPrefix(prefix1: PrefixTableSubject.DL1INCL, prefix2: PrefixTableObject.DL1EXCL)
    static final def DL1INCLPL1INCLB = new CompoundPrefix(prefix1: PrefixTableSubject.DL1INCL, prefix2: PrefixTableObject.PL1INCL)
    static final def DL1INCLPL1EXCLB = new CompoundPrefix(prefix1: PrefixTableSubject.DL1INCL, prefix2: PrefixTableObject.PL1EXCL)
    static final def DL1INCLDL2B = new CompoundPrefix(prefix1: PrefixTableSubject.DL1INCL, prefix2: PrefixTableObject.DL2)
    static final def DL1INCLPL2B = new CompoundPrefix(prefix1: PrefixTableSubject.DL1INCL, prefix2: PrefixTableObject.PL2)
    static final def DL1EXCLSG1B = new CompoundPrefix(prefix1: PrefixTableSubject.DL1EXCL, prefix2: PrefixTableObject.SG1)
    static final def DL1EXCLSG2B = new CompoundPrefix(prefix1: PrefixTableSubject.DL1EXCL, prefix2: PrefixTableObject.SG2)
    static final def DL1EXCLSG3ANB = new CompoundPrefix(prefix1: PrefixTableSubject.DL1EXCL, prefix2: PrefixTableObject.SG3AN)
    static final def DL1EXCLDL1INCLB = new CompoundPrefix(prefix1: PrefixTableSubject.DL1EXCL, prefix2: PrefixTableObject.DL1INCL)
    static final def DL1EXCLDL1EXCLB = new CompoundPrefix(prefix1: PrefixTableSubject.DL1EXCL, prefix2: PrefixTableObject.DL1EXCL)
    static final def DL1EXCLPL1INCLB = new CompoundPrefix(prefix1: PrefixTableSubject.DL1EXCL, prefix2: PrefixTableObject.PL1INCL)
    static final def DL1EXCLPL1EXCLB = new CompoundPrefix(prefix1: PrefixTableSubject.DL1EXCL, prefix2: PrefixTableObject.PL1EXCL)
    static final def DL1EXCLDL2B = new CompoundPrefix(prefix1: PrefixTableSubject.DL1EXCL, prefix2: PrefixTableObject.DL2)
    static final def DL1EXCLPL2B = new CompoundPrefix(prefix1: PrefixTableSubject.DL1EXCL, prefix2: PrefixTableObject.PL2)
    static final def PL1INCLSG1B = new CompoundPrefix(prefix1: PrefixTableSubject.PL1INCL, prefix2: PrefixTableObject.SG1)
    static final def PL1INCLSG2B = new CompoundPrefix(prefix1: PrefixTableSubject.PL1INCL, prefix2: PrefixTableObject.SG2)
    static final def PL1INCLSG3ANB = new CompoundPrefix(prefix1: PrefixTableSubject.PL1INCL, prefix2: PrefixTableObject.SG3AN)
    static final def PL1INCLDL1INCLB = new CompoundPrefix(prefix1: PrefixTableSubject.PL1INCL, prefix2: PrefixTableObject.DL1INCL)
    static final def PL1INCLDL1EXCLB = new CompoundPrefix(prefix1: PrefixTableSubject.PL1INCL, prefix2: PrefixTableObject.DL1EXCL)
    static final def PL1INCLPL1INCLB = new CompoundPrefix(prefix1: PrefixTableSubject.PL1INCL, prefix2: PrefixTableObject.PL1INCL)
    static final def PL1INCLPL1EXCLB = new CompoundPrefix(prefix1: PrefixTableSubject.PL1INCL, prefix2: PrefixTableObject.PL1EXCL)
    static final def PL1INCLDL2B = new CompoundPrefix(prefix1: PrefixTableSubject.PL1INCL, prefix2: PrefixTableObject.DL2)
    static final def PL1INCLPL2B = new CompoundPrefix(prefix1: PrefixTableSubject.PL1INCL, prefix2: PrefixTableObject.PL2)
    static final def PL1EXCLSG1B = new CompoundPrefix(prefix1: PrefixTableSubject.PL1EXCL, prefix2: PrefixTableObject.SG1)
    static final def PL1EXCLSG2B = new CompoundPrefix(prefix1: PrefixTableSubject.PL1EXCL, prefix2: PrefixTableObject.SG2)
    static final def PL1EXCLSG3ANB = new CompoundPrefix(prefix1: PrefixTableSubject.PL1EXCL, prefix2: PrefixTableObject.SG3AN)
    static final def PL1EXCLDL1INCLB = new CompoundPrefix(prefix1: PrefixTableSubject.PL1EXCL, prefix2: PrefixTableObject.DL1INCL)
    static final def PL1EXCLDL1EXCLB = new CompoundPrefix(prefix1: PrefixTableSubject.PL1EXCL, prefix2: PrefixTableObject.DL1EXCL)
    static final def PL1EXCLPL1INCLB = new CompoundPrefix(prefix1: PrefixTableSubject.PL1EXCL, prefix2: PrefixTableObject.PL1INCL)
    static final def PL1EXCLPL1EXCLB = new CompoundPrefix(prefix1: PrefixTableSubject.PL1EXCL, prefix2: PrefixTableObject.PL1EXCL)
    static final def PL1EXCLDL2B = new CompoundPrefix(prefix1: PrefixTableSubject.PL1EXCL, prefix2: PrefixTableObject.DL2)
    static final def PL1EXCLPL2B = new CompoundPrefix(prefix1: PrefixTableSubject.PL1EXCL, prefix2: PrefixTableObject.PL2)
    static final def DL2SG1B = new CompoundPrefix(prefix1: PrefixTableSubject.DL2, prefix2: PrefixTableObject.SG1)
    static final def DL2SG2B = new CompoundPrefix(prefix1: PrefixTableSubject.DL2, prefix2: PrefixTableObject.SG2)
    static final def DL2SG3ANB = new CompoundPrefix(prefix1: PrefixTableSubject.DL2, prefix2: PrefixTableObject.SG3AN)
    static final def DL2DL1INCLB = new CompoundPrefix(prefix1: PrefixTableSubject.DL2, prefix2: PrefixTableObject.DL1INCL)
    static final def DL2DL1EXCLB = new CompoundPrefix(prefix1: PrefixTableSubject.DL2, prefix2: PrefixTableObject.DL1EXCL)
    static final def DL2PL1INCLB = new CompoundPrefix(prefix1: PrefixTableSubject.DL2, prefix2: PrefixTableObject.PL1INCL)
    static final def DL2PL1EXCLB = new CompoundPrefix(prefix1: PrefixTableSubject.DL2, prefix2: PrefixTableObject.PL1EXCL)
    static final def DL2DL2B = new CompoundPrefix(prefix1: PrefixTableSubject.DL2, prefix2: PrefixTableObject.DL2)
    static final def DL2PL2B = new CompoundPrefix(prefix1: PrefixTableSubject.DL2, prefix2: PrefixTableObject.PL2)
    static final def PL2SG1B = new CompoundPrefix(prefix1: PrefixTableSubject.PL2, prefix2: PrefixTableObject.SG1)
    static final def PL2SG2B = new CompoundPrefix(prefix1: PrefixTableSubject.PL2, prefix2: PrefixTableObject.SG2)
    static final def PL2SG3ANB = new CompoundPrefix(prefix1: PrefixTableSubject.PL2, prefix2: PrefixTableObject.SG3AN)
    static final def PL2DL1INCLB = new CompoundPrefix(prefix1: PrefixTableSubject.PL2, prefix2: PrefixTableObject.DL1INCL)
    static final def PL2DL1EXCLB = new CompoundPrefix(prefix1: PrefixTableSubject.PL2, prefix2: PrefixTableObject.DL1EXCL)
    static final def PL2PL1INCLB = new CompoundPrefix(prefix1: PrefixTableSubject.PL2, prefix2: PrefixTableObject.PL1INCL)
    static final def PL2PL1EXCLB = new CompoundPrefix(prefix1: PrefixTableSubject.PL2, prefix2: PrefixTableObject.PL1EXCL)
    static final def PL2DL2B = new CompoundPrefix(prefix1: PrefixTableSubject.PL2, prefix2: PrefixTableObject.DL2)
    static final def PL2PL2B = new CompoundPrefix(prefix1: PrefixTableSubject.PL2, prefix2: PrefixTableObject.PL2)
    static final def PL3SG1B = new CompoundPrefix(prefix1: PrefixTableSubject.PL3, prefix2: PrefixTableObject.SG1)
    static final def PL3SG2B = new CompoundPrefix(prefix1: PrefixTableSubject.PL3, prefix2: PrefixTableObject.SG2)
    static final def PL3DL1INCLB = new CompoundPrefix(prefix1: PrefixTableSubject.PL3, prefix2: PrefixTableObject.DL1INCL)
    static final def PL3DL1EXCLB = new CompoundPrefix(prefix1: PrefixTableSubject.PL3, prefix2: PrefixTableObject.DL1EXCL)
    static final def PL3PL1INCLB = new CompoundPrefix(prefix1: PrefixTableSubject.PL3, prefix2: PrefixTableObject.PL1INCL)
    static final def PL3PL1EXCLB = new CompoundPrefix(prefix1: PrefixTableSubject.PL3, prefix2: PrefixTableObject.PL1EXCL)
    static final def PL3DL2B = new CompoundPrefix(prefix1: PrefixTableSubject.PL3, prefix2: PrefixTableObject.DL2)
    static final def PL3PL2B = new CompoundPrefix(prefix1: PrefixTableSubject.PL3, prefix2: PrefixTableObject.PL2)
    static {
//        prefixes.put("SG1SG1", new Prefix(preVowel: '', preConsonant: '', other: ''))//blank
        prefixes.put("SG1SG2", new Prefix(preVowel: 'Ꭼy', preConsonant: 'Ꭼ', other: ''))
        prefixes.put("SG1SG3AN", new Prefix(preVowel: 'Ꮵy', preConsonant: 'Ꮵ', other: ''))
        prefixes.put("SG1SG3IN", new Prefix(preVowel: 'G', preConsonant: 'Ꮵ', other: ''))
//        prefixes.put("SG1DL1INCL", new Prefix(preVowel: '', preConsonant: '', other: ''))//blank
//        prefixes.put("SG1DL1EXCL", new Prefix(preVowel: '', preConsonant: '', other: ''))//blank
//        prefixes.put("SG1PL1INCL", new Prefix(preVowel: '', preConsonant: '', other: ''))//blank
//        prefixes.put("SG1PL1EXCL", new Prefix(preVowel: '', preConsonant: '', other: ''))//blank
        prefixes.put("SG1DL2", new Prefix(preVowel: 'ᏍᏛy', preConsonant: 'ᏍᏛ', other: ''))
        prefixes.put("SG1PL2", new Prefix(preVowel: 'ᎢᏨy', preConsonant: 'ᎢᏨ', other: ''))
        prefixes.put("SG1PL3AN", new Prefix(preVowel: 'ᎦᏥy', preConsonant: 'ᎦᏥ', other: ''))
        prefixes.put("SG1PL3IN", new Prefix(preVowel: 'Ꮥg', preConsonant: 'ᏕᏥ', other: ''))

        prefixes.put("SG2SG1", new Prefix(preVowel: 'Ꮝgw', preConsonant: 'ᏍᎩ', other: ''))// NOTE: Feeling P1.14 attests ᏍᏆ sgw- before vowel stems; verify the Ꮝgw backspace-2 handling surfaces ᏍᏆ -- timo 10Nov26
//        prefixes.put("SG2SG2", new Prefix(preVowel: '', preConsonant: '', other: ''))
        prefixes.put("SG2SG3AN", new Prefix(preVowel: 'Ꭿy', preConsonant: 'Ꭿ', other: ''))
        prefixes.put("SG2SG3IN", new Prefix(preVowel: 'h', preConsonant: 'Ꭿ', other: ''))
//        prefixes.put("SG2DL1INCL", new Prefix(preVowel: '', preConsonant: '', other: ''))
        prefixes.put("SG2DL1EXCL", new Prefix(preVowel: 'ᏍᎩn', preConsonant: 'ᏍᎩᏂ', other: ''))
//        prefixes.put("SG2PL1INCL", new Prefix(preVowel: '', preConsonant: '', other: ''))
        prefixes.put("SG2PL1EXCL", new Prefix(preVowel: 'ᎢᏍᎩy', preConsonant: 'ᎢᏍᎩ', other: ''))
//        prefixes.put("SG2DL2", new Prefix(preVowel: '', preConsonant: '', other: ''))
//        prefixes.put("SG2PL2", new Prefix(preVowel: '', preConsonant: '', other: ''))
        prefixes.put("SG2PL3AN", new Prefix(preVowel: 'ᎦᎯy', preConsonant: 'ᎦᎯ', other: ''))
        prefixes.put("SG2PL3IN", new Prefix(preVowel: 'Ꮥh', preConsonant: 'ᏕᎯ', other: ''))

        prefixes.put("SG3SG1", new Prefix(preVowel: 'Ꭰgw', preConsonant: 'ᎠᎩ', other: ''))
        prefixes.put("SG3SG2", new Prefix(preVowel: 'j', preConsonant: 'Ꮳ', other: ''))
//        prefixes.put("SG3SG3AN", new Prefix(preVowel: 'g', preConsonant: 'Ꭶ', other: 'a'))
        prefixes.put("SG3SG3AN", new Prefix(preVowel: '', preConsonant: 'Ꭶ', other: 'a'))
        prefixes.put("SG3SG3IN", new Prefix(preVowel: '', preConsonant: 'Ꭶ', other: 'a'))
        prefixes.put("SG3DL1INCL", new Prefix(preVowel: 'Ꭹn', preConsonant: 'ᎩᏂ', other: ''))
        prefixes.put("SG3DL1EXCL", new Prefix(preVowel: 'ᎣᎩn', preConsonant: 'ᎣᎩᏂ', other: ''))
        prefixes.put("SG3PL1INCL", new Prefix(preVowel: 'Ꭲg', preConsonant: 'ᎢᎩ', other: ''))
        prefixes.put("SG3PL1EXCL", new Prefix(preVowel: 'Ꭳg', preConsonant: 'ᎣᎩ', other: ''))
        prefixes.put("SG3DL2", new Prefix(preVowel: 'Ꮝd', preConsonant: 'ᏍᏗ', other: ''))
        prefixes.put("SG3PL2", new Prefix(preVowel: 'Ꭲj', preConsonant: 'ᎢᏥ', other: ''))
        prefixes.put("SG3PL3AN", new Prefix(preVowel: 'Ꮥg', preConsonant: 'ᏕᎩ', other: ''))
//        prefixes.put("SG3PL3AN", new Prefix(preVowel: 'Ꮣg', preConsonant: 'ᏓᎪ', other: ''))
        prefixes.put("SG3PL3IN", new Prefix(preVowel: 'Ꮥg', preConsonant: 'ᏕᎩ', other: ''))

//        prefixes.put("DL1INCLSG1", new Prefix(preVowel: '', preConsonant: '', other: ''))
//        prefixes.put("DL1INCLSG2", new Prefix(preVowel: '', preConsonant: '', other: ''))
        prefixes.put("DL1INCLSG3AN", new Prefix(preVowel: 'Ꭱn', preConsonant: 'ᎡᏂ', other: ''))
        prefixes.put("DL1INCLSG3IN", new Prefix(preVowel: 'Ꭲn', preConsonant: 'ᎢᏂ', other: ''))
//        prefixes.put("DL1INCLDL1INCL", new Prefix(preVowel: '', preConsonant: '', other: ''))
//        prefixes.put("DL1INCLDL1EXCL", new Prefix(preVowel: '', preConsonant: '', other: ''))
//        prefixes.put("DL1INCLPL1INCL", new Prefix(preVowel: '', preConsonant: '', other: ''))
//        prefixes.put("DL1INCLPL1EXCL", new Prefix(preVowel: '', preConsonant: '', other: ''))
//        prefixes.put("DL1INCLDL2", new Prefix(preVowel: '', preConsonant: '', other: ''))
//        prefixes.put("DL1INCLPL2", new Prefix(preVowel: '', preConsonant: '', other: ''))
        prefixes.put("DL1INCLPL3AN", new Prefix(preVowel: 'Ꭸn', preConsonant: 'ᎨᏂ', other: ''))
        prefixes.put("DL1INCLPL3IN", new Prefix(preVowel: 'Ꮥn', preConsonant: 'ᏕᏂ', other: ''))

//        prefixes.put("DL1EXCLSG1", new Prefix(preVowel: '', preConsonant: '', other: ''))
        prefixes.put("DL1EXCLSG2", new Prefix(preVowel: 'ᏍᏛy', preConsonant: 'ᏍᏛ', other: ''))
        prefixes.put("DL1EXCLSG3AN", new Prefix(preVowel: 'ᎣᏍd', preConsonant: 'ᎣᏍᏗ', other: ''))
        prefixes.put("DL1EXCLSG3IN", new Prefix(preVowel: 'ᎣᏍd', preConsonant: 'ᎣᏍᏗ', other: ''))
//        prefixes.put("DL1EXCLDL1INCL", new Prefix(preVowel: '', preConsonant: '', other: ''))
//        prefixes.put("DL1EXCLDL1EXCL", new Prefix(preVowel: '', preConsonant: '', other: ''))
//        prefixes.put("DL1EXCLPL1INCL", new Prefix(preVowel: '', preConsonant: '', other: ''))
//        prefixes.put("DL1EXCLPL1EXCL", new Prefix(preVowel: '', preConsonant: '', other: ''))
        prefixes.put("DL1EXCLDL2", new Prefix(preVowel: 'ᏍᏛy', preConsonant: 'ᏍᏛ', other: ''))
        prefixes.put("DL1EXCLPL2", new Prefix(preVowel: 'Ꭲj', preConsonant: 'ᎢᏥ', other: ''))
        prefixes.put("DL1EXCLPL3AN", new Prefix(preVowel: 'ᎪᏍd', preConsonant: 'ᎪᏍᏗ', other: ''))
        prefixes.put("DL1EXCLPL3IN", new Prefix(preVowel: 'ᏙᏍd', preConsonant: 'ᏙᏍᏗ', other: ''))

//        prefixes.put("PL1INCLSG1", new Prefix(preVowel: '', preConsonant: '', other: ''))
//        prefixes.put("PL1INCLSG2", new Prefix(preVowel: '', preConsonant: '', other: ''))
        prefixes.put("PL1INCLSG3AN", new Prefix(preVowel: 'Ꭱd', preConsonant: 'ᎡᏗ', other: ''))
        prefixes.put("PL1INCLSG3IN", new Prefix(preVowel: 'Ꭲd', preConsonant: 'ᎢᏗ', other: ''))
//        prefixes.put("PL1INCLDL1INCL", new Prefix(preVowel: '', preConsonant: '', other: ''))
//        prefixes.put("PL1INCLDL1EXCL", new Prefix(preVowel: '', preConsonant: '', other: ''))
//        prefixes.put("PL1INCLPL1INCL", new Prefix(preVowel: '', preConsonant: '', other: ''))
//        prefixes.put("PL1INCLPL1EXCL", new Prefix(preVowel: '', preConsonant: '', other: ''))
//        prefixes.put("PL1INCLDL2", new Prefix(preVowel: '', preConsonant: '', other: ''))
//        prefixes.put("PL1INCLPL2", new Prefix(preVowel: '', preConsonant: '', other: ''))
        prefixes.put("PL1INCLPL3AN", new Prefix(preVowel: 'Ꭸd', preConsonant: 'ᎨᏗ', other: ''))
        prefixes.put("PL1INCLPL3IN", new Prefix(preVowel: 'Ꮥd', preConsonant: 'ᏕᏗ', other: ''))

//        prefixes.put("PL1EXCLSG1", new Prefix(preVowel: '', preConsonant: '', other: ''))
        prefixes.put("PL1EXCLSG2", new Prefix(preVowel: 'ᎢᏨy', preConsonant: 'ᎢᏨ', other: ''))
        prefixes.put("PL1EXCLSG3AN", new Prefix(preVowel: 'Ꭳj', preConsonant: 'ᎣᏥ', other: ''))
        prefixes.put("PL1EXCLSG3IN", new Prefix(preVowel: 'Ꭳj', preConsonant: 'ᎣᏥ', other: ''))
//        prefixes.put("PL1EXCLDL1INCL", new Prefix(preVowel: '', preConsonant: '', other: ''))
//        prefixes.put("PL1EXCLDL1EXCL", new Prefix(preVowel: '', preConsonant: '', other: ''))
//        prefixes.put("PL1EXCLPL1INCL", new Prefix(preVowel: '', preConsonant: '', other: ''))
//        prefixes.put("PL1EXCLPL1EXCL", new Prefix(preVowel: '', preConsonant: '', other: ''))
//        prefixes.put("PL1EXCLDL2", new Prefix(preVowel: '', preConsonant: '', other: ''))
//        prefixes.put("PL1EXCLPL2", new Prefix(preVowel: '', preConsonant: '', other: ''))
        prefixes.put("PL1EXCLPL3AN", new Prefix(preVowel: 'Ꭺj', preConsonant: 'ᎪᏥ', other: ''))
        prefixes.put("PL1EXCLPL3IN", new Prefix(preVowel: 'Ꮩj', preConsonant: 'ᏙᏥ', other: ''))

        prefixes.put("DL2SG1", new Prefix(preVowel: 'ᏍᎩn', preConsonant: 'ᏍᎩᏂ', other: ''))// NOTE: not attested in the Feeling guide excerpts; verify against Appendix B -- timo 10Nov26
//        prefixes.put("DL2SG2", new Prefix(preVowel: '', preConsonant: '', other: ''))
        prefixes.put("DL2SG3AN", new Prefix(preVowel: 'ᎡᏍd', preConsonant: 'ᎡᏍᏗ', other: ''))
        prefixes.put("DL2SG3IN", new Prefix(preVowel: 'Ꮝd', preConsonant: 'ᏍᏗ', other: ''))
//        prefixes.put("DL2DL1INCL", new Prefix(preVowel: '', preConsonant: '', other: ''))
        prefixes.put("DL2DL1EXCL", new Prefix(preVowel: 'ᏍᎩn', preConsonant: 'ᏍᎩᏂ', other: ''))
//        prefixes.put("DL2PL1INCL", new Prefix(preVowel: '', preConsonant: '', other: ''))
        prefixes.put("DL2PL1EXCL", new Prefix(preVowel: 'ᎢᏍᎩy', preConsonant: 'ᎢᏍᎩ', other: ''))
//        prefixes.put("DL2DL2", new Prefix(preVowel: '', preConsonant: '', other: ''))
//        prefixes.put("DL2PL2", new Prefix(preVowel: '', preConsonant: '', other: ''))
        prefixes.put("DL2PL3AN", new Prefix(preVowel: 'ᎨᏍd', preConsonant: 'ᎨᏍᏗ', other: ''))
        prefixes.put("DL2PL3IN", new Prefix(preVowel: 'ᏕᏍd', preConsonant: 'ᏕᏍᏗ', other: ''))

        prefixes.put("PL2SG1", new Prefix(preVowel: 'ᎢᏍᎩy', preConsonant: 'ᎢᏍᎩ', other: ''))// NOTE: not attested in the Feeling guide excerpts; verify against Appendix B -- timo 10Nov26
//        prefixes.put("PL2SG2", new Prefix(preVowel: '', preConsonant: '', other: ''))
        prefixes.put("PL2SG3AN", new Prefix(preVowel: 'Ꭱj', preConsonant: 'ᎡᏥ', other: ''))
        prefixes.put("PL2SG3IN", new Prefix(preVowel: 'Ꭲj', preConsonant: 'ᎢᏥ', other: ''))
//        prefixes.put("PL2DL1INCL", new Prefix(preVowel: '', preConsonant: '', other: ''))
        prefixes.put("PL2DL1EXCL", new Prefix(preVowel: 'ᎢᏍᎩy', preConsonant: 'ᎢᏍᎩ', other: ''))// NOTE: not attested in the Feeling guide excerpts; verify against Appendix B -- timo 10Nov26
//        prefixes.put("PL2PL1INCL", new Prefix(preVowel: '', preConsonant: '', other: ''))
//        prefixes.put("PL2PL1EXCL", new Prefix(preVowel: '', preConsonant: '', other: ''))
//        prefixes.put("PL2DL2", new Prefix(preVowel: '', preConsonant: '', other: ''))
//        prefixes.put("PL2PL2", new Prefix(preVowel: '', preConsonant: '', other: ''))
        prefixes.put("PL2PL3AN", new Prefix(preVowel: 'Ꭸj', preConsonant: 'ᎨᏥ', other: ''))
        prefixes.put("PL2PL3IN", new Prefix(preVowel: 'Ꮥj', preConsonant: 'ᏕᏥ', other: ''))

        prefixes.put("PL3SG1", new Prefix(preVowel: 'Ꭼgw', preConsonant: 'ᎬᎩ', other: ''))// NOTE: not attested in the Feeling guide excerpts; verify against Appendix B -- timo 10Nov26
        prefixes.put("PL3SG2", new Prefix(preVowel: 'Ꭸj', preConsonant: 'ᎨᏥ', other: ''))// NOTE: not attested in the Feeling guide excerpts; verify against Appendix B -- timo 10Nov26
        prefixes.put("PL3SG3AN", new Prefix(preVowel: 'Ꭰn', preConsonant: 'ᎠᏂ', other: ''))
        prefixes.put("PL3SG3IN", new Prefix(preVowel: 'Ꭰn', preConsonant: 'ᎠᏂ', other: ''))
        prefixes.put("PL3DL1INCL", new Prefix(preVowel: 'ᎨᎩn', preConsonant: 'ᎨᎩᏂ', other: ''))
        prefixes.put("PL3DL1EXCL", new Prefix(preVowel: 'ᎪᎩn', preConsonant: 'ᎪᎩᏂ', other: ''))
        prefixes.put("PL3PL1INCL", new Prefix(preVowel: 'Ꭸg', preConsonant: 'ᎨᎩ', other: ''))
        prefixes.put("PL3PL1EXCL", new Prefix(preVowel: 'Ꭺg', preConsonant: 'ᎪᎩ', other: ''))
        prefixes.put("PL3DL2", new Prefix(preVowel: 'ᎨᏍd', preConsonant: 'ᎨᏍᏗ', other: ''))
        prefixes.put("PL3PL2", new Prefix(preVowel: 'Ꭸj', preConsonant: 'ᎨᏥ', other: ''))
        prefixes.put("PL3PL3AN", new Prefix(preVowel: 'Ꭰn', preConsonant: 'Ꭰ', other: ''))// NOTE: preConsonant 'Ꭰ' lacks the -n- (cf. preVowel 'Ꭰn'); not attested in the Feeling guide excerpts (Set A) — verify against Appendix B -- timo 10Nov26
        prefixes.put("PL3PL3IN", new Prefix(preVowel: 'Ꮣn', preConsonant: 'Ꮣ', other: ''))// NOTE: preConsonant 'Ꮣ' lacks the -n- (cf. preVowel 'Ꮣn'); same check needed -- timo 10Nov26

        prefixes.put("SG1SG3INB", new Prefix(preVowel: 'Ꭰgw', preConsonant: 'ᎠᎩ', other: ''))
        prefixes.put("SG2SG3INB", new Prefix(preVowel: 'j', preConsonant: 'Ꮳ', other: ''))
        prefixes.put("SG3SG3INB", new Prefix(preVowel: 'Ꭴw', preConsonant: 'Ꭴ', other: ''))
        prefixes.put("DL1INCLSG3INB", new Prefix(preVowel: 'Ꭹn', preConsonant: 'ᎩᏂ', other: ''))
        prefixes.put("PL1INCLSG3INB", new Prefix(preVowel: 'Ꭲg', preConsonant: 'ᎢᎩ', other: ''))
        prefixes.put("DL1EXCLSG3INB", new Prefix(preVowel: 'ᎣᎩn', preConsonant: 'ᎣᎩᏂ', other: ''))
        prefixes.put("PL1EXCLSG3INB", new Prefix(preVowel: 'Ꭳg', preConsonant: 'ᎣᎩ', other: ''))
        prefixes.put("PL3SG3INB", new Prefix(preVowel: 'Ꭴn', preConsonant: 'ᎤᏂ', other: ''))

        prefixes.put("SG1PL3INB", new Prefix(preVowel: 'Ꮣgw', preConsonant: 'ᏓᎩ', other: ''))
        prefixes.put("SG2PL3INB", new Prefix(preVowel: 'Ꮥj', preConsonant: 'ᏕᏣ', other: ''))
        prefixes.put("SG3PL3INB", new Prefix(preVowel: 'Ꮪw', preConsonant: 'Ꮪ', other: ''))
        prefixes.put("DL1INCLPL3INB", new Prefix(preVowel: 'ᏕᎩn', preConsonant: 'ᏕᎩᏂ', other: ''))
        prefixes.put("PL1INCLPL3INB", new Prefix(preVowel: 'Ꮥg', preConsonant: 'ᏕᎩ', other: ''))
        prefixes.put("DL1EXCLPL3INB", new Prefix(preVowel: 'ᏙᎩn', preConsonant: 'ᏙᎩᏂ', other: ''))
        prefixes.put("PL1EXCLPL3INB", new Prefix(preVowel: 'Ꮩg', preConsonant: 'ᏙᎩ', other: ''))
        prefixes.put("PL3PL3ANB", new Prefix(preVowel: 'Ꮣn', preConsonant: 'Ꮣ', other: ''))
        prefixes.put("PL3PL3INB", new Prefix(preVowel: 'Ꮪn', preConsonant: 'Ꮪ', other: ''))

        //timo 10Nov26: the 15 missing Set B entries, transcribed from Feeling (1975),
        //Figures 3/4 + Paradigms P4/P7/P8, cross-checked against the van Tuyl & Feeling
        //(1994) Appendix B tables (pp.177-180). Feeling's principle (P8 preamble): only
        //the subject-object combinations that DIFFER from the Set A prefixes are listed
        //in the Set B paradigms, so every combination not attested there takes the Set A
        //form. Figure 4 lists Set B forms only for the 3sg-inanimate and 3pl-inanimate
        //object columns; Appendix B shows the Class B column blank wherever Set B does
        //not differ from Class A.
        //
        //Conventions of this map (matching the pre-existing SGxSG3INB/SGxPL3INB entries):
        //  preVowel      = form used when the stem begins with a vowel syllabary (Ꭰ-Ꭵ)
        //  preConsonant  = form used otherwise (consonant- or y-initial stems)
        //Feeling's print convention (App. B note): first form = before a consonant,
        //parenthesized second form = before a vowel; the y-initial stems ("hungry",
        //P7) take the vowel forms (agi-, ja-, u-, gini-...), while true vowel stems
        //take the w-forms (agw-, uw-, ... P7 notes). Known limitation (not modeled
        //here): before v/h-initial stems Feeling prints the w-forms (agw- "I'm
        //forgetting it" P4(1), uw- P4(6)) although they are consonant-initial; the
        //book's verbs ("to see", Stem III -go-h-) take the agi-/u- forms as printed
        //on p.119 (agigohv'i, ugohv'i), which this table produces.

        // == Set B = Set A (not attested as differing in P4/P8; Appendix B Class B
        //    column blank for these rows) ==
        prefixes.put("SG1SG2B", new Prefix(preVowel: 'Ꭼy', preConsonant: 'Ꭼ', other: ''))// = Set A SG1SG2; P4 lists only I-it/I-them(in)
        prefixes.put("SG1SG3ANB", new Prefix(preVowel: 'Ꮵy', preConsonant: 'Ꮵ', other: ''))// = Set A SG1SG3AN (ji-); P4 unlisted; App. B p.178 shows ji- only
        prefixes.put("SG1PL3ANB", new Prefix(preVowel: 'ᎦᏥy', preConsonant: 'ᎦᏥ', other: ''))// = Set A SG1PL3AN (gaji-); App. B p.178: gaji- single, no Class B value
        prefixes.put("SG2PL3ANB", new Prefix(preVowel: 'ᎦᎯy', preConsonant: 'ᎦᎯ', other: ''))// = Set A SG2PL3AN (gahi-); P4(4) covers them(in) only; App. B Class B blank
        prefixes.put("DL1INCLPL3ANB", new Prefix(preVowel: 'Ꭸn', preConsonant: 'ᎨᏂ', other: ''))// = Set A DL1INCLPL3AN (geni-); P4(10) covers them(in) only (degin-)
        prefixes.put("PL1INCLPL3ANB", new Prefix(preVowel: 'Ꭸd', preConsonant: 'ᎨᏗ', other: ''))// = Set A PL1INCLPL3AN (gedi-); P4(12) covers them(in) only (deg-)
        prefixes.put("PL1EXCLPL3ANB", new Prefix(preVowel: 'Ꭺj', preConsonant: 'ᎪᏥ', other: ''))// = Set A PL1EXCLPL3AN (goji-); P4(19) prints the same goj-
        prefixes.put("DL2SG3INB", new Prefix(preVowel: 'Ꮝd', preConsonant: 'ᏍᏗ', other: ''))// = Set A DL2SG3IN (sdi-); P8 has no 2dl rows; App. B p.179 Class B blank
        prefixes.put("DL2PL3ANB", new Prefix(preVowel: 'ᎨᏍd', preConsonant: 'ᎨᏍᏗ', other: ''))// = Set A DL2PL3AN (gesdi-); App. B p.179 gesdi-, Class B blank
        prefixes.put("DL2PL3INB", new Prefix(preVowel: 'ᏕᏍd', preConsonant: 'ᏕᏍᏗ', other: ''))// = Set A DL2PL3IN (desdi-)
        prefixes.put("PL2SG3INB", new Prefix(preVowel: 'Ꭲj', preConsonant: 'ᎢᏥ', other: ''))// = Set A PL2SG3IN (iji-); App. B p.179 iji-, Class B blank
        prefixes.put("PL2PL3ANB", new Prefix(preVowel: 'Ꭸj', preConsonant: 'ᎨᏥ', other: ''))// = Set A PL2PL3AN (geji-)
        prefixes.put("PL2PL3INB", new Prefix(preVowel: 'Ꮥj', preConsonant: 'ᏕᏥ', other: ''))// = Set A PL2PL3IN (deji-)

        // == Set B attested as differing from Set A ==
        //P8(5): ᎤᏩᏂᎸᎢ u¹wa²hnị³lv³ʔi "he hit him, it" — uw- "he--him, it": ONE Set B
        //form covers both him and it (3sg subject), unlike Set A (ga-/a-). Same form as
        //SG3SG3INB above. (Class-B-always verbs like "to forget" contrast instead:
        //P4(5) g- "he's forgetting him" vs P4(6) uw- "he's forgetting it" — a verb-class
        //difference this single table cannot express; noted, not modeled.)
        prefixes.put("SG3SG3ANB", new Prefix(preVowel: 'Ꭴw', preConsonant: 'Ꭴ', other: ''))// P8(5) uw-; App. B p.178 (he->it) shows u-/(uw-)
        prefixes.put("PL3SG3ANB", new Prefix(preVowel: 'Ꭰn', preConsonant: 'ᎠᏂ', other: ''))// = Set A PL3SG3AN (ani-); P4(21) prints the same an-; App. B Class B blank
        //P8(6): ᏚᏩᏂᎸᎢ du¹wa²hnị³lv³ʔi "he hit them (an or in)" — duw- covers both
        //animate and inanimate plural objects with a 3sg subject (Set A has degi-).
        prefixes.put("SG3PL3ANB", new Prefix(preVowel: 'Ꮪw', preConsonant: 'Ꮪ', other: ''))// P8(6) duw-; App. B p.178 (he->them) degi- | du- ✓
        //P4(15): ᏙᏍᏛᎨᏩᏍᎦ do¹sdv²kew²sga "he and I are forgetting them (an)" — dosd-,
        //which is NOT the Set A form (gosd-, P2(38)/Fig. 3). Appendix B p.179 confirms:
        //Class A gosdi- | Class B *dosdi- (asterisk = causes deaspiration of certain
        //verbs). The only dual/plural-subject cell where Set B differs for a
        //non-inanimate object.
        prefixes.put("DL1EXCLPL3ANB", new Prefix(preVowel: 'ᏙᏍd', preConsonant: 'ᏙᏍᏗ', other: ''))// P4(15) dosd-; App. B p.179 *dosdi-
        //timo 10Nov26: empty B twins (same rationale as the field block above) --
        //every Set A combination lacking an attested Set B form gets a B key with
        //empty values, so MISSING_ENTRY now signals a true gap in the map rather
        //than a merely undeclared field, and determineCompoundPrefix can no longer
        //return a null CompoundPrefix. Runtime note: an empty value is falsy, so in
        //processPrefixes (VerbConjugationProcessor) an empty preVowel skips the
        //prefix/marker logic and the word resolves blank, while an empty
        //preConsonant (consonant-initial stem) trips the MISSING_ENTRY check and
        //resolves "MISSING_ENTRY"+stem -- i.e. the gap stays visible either way,
        //per the "at least not return something weird" decision. -- timo 10Nov26
        prefixes.put("SG1SG1B", new Prefix(preVowel: '', preConsonant: '', other: ''))
        prefixes.put("SG1DL1INCLB", new Prefix(preVowel: '', preConsonant: '', other: ''))
        prefixes.put("SG1DL1EXCLB", new Prefix(preVowel: '', preConsonant: '', other: ''))
        prefixes.put("SG1PL1INCLB", new Prefix(preVowel: '', preConsonant: '', other: ''))
        prefixes.put("SG1PL1EXCLB", new Prefix(preVowel: '', preConsonant: '', other: ''))
        prefixes.put("SG1DL2B", new Prefix(preVowel: '', preConsonant: '', other: ''))
        prefixes.put("SG1PL2B", new Prefix(preVowel: '', preConsonant: '', other: ''))
        prefixes.put("SG2SG1B", new Prefix(preVowel: '', preConsonant: '', other: ''))
        prefixes.put("SG2SG2B", new Prefix(preVowel: '', preConsonant: '', other: ''))
        prefixes.put("SG2SG3ANB", new Prefix(preVowel: '', preConsonant: '', other: ''))
        prefixes.put("SG2DL1INCLB", new Prefix(preVowel: '', preConsonant: '', other: ''))
        prefixes.put("SG2DL1EXCLB", new Prefix(preVowel: '', preConsonant: '', other: ''))
        prefixes.put("SG2PL1INCLB", new Prefix(preVowel: '', preConsonant: '', other: ''))
        prefixes.put("SG2PL1EXCLB", new Prefix(preVowel: '', preConsonant: '', other: ''))
        prefixes.put("SG2DL2B", new Prefix(preVowel: '', preConsonant: '', other: ''))
        prefixes.put("SG2PL2B", new Prefix(preVowel: '', preConsonant: '', other: ''))
        prefixes.put("SG3SG1B", new Prefix(preVowel: '', preConsonant: '', other: ''))
        prefixes.put("SG3SG2B", new Prefix(preVowel: '', preConsonant: '', other: ''))
        prefixes.put("SG3DL1INCLB", new Prefix(preVowel: '', preConsonant: '', other: ''))
        prefixes.put("SG3DL1EXCLB", new Prefix(preVowel: '', preConsonant: '', other: ''))
        prefixes.put("SG3PL1INCLB", new Prefix(preVowel: '', preConsonant: '', other: ''))
        prefixes.put("SG3PL1EXCLB", new Prefix(preVowel: '', preConsonant: '', other: ''))
        prefixes.put("SG3DL2B", new Prefix(preVowel: '', preConsonant: '', other: ''))
        prefixes.put("SG3PL2B", new Prefix(preVowel: '', preConsonant: '', other: ''))
        prefixes.put("DL1INCLSG1B", new Prefix(preVowel: '', preConsonant: '', other: ''))
        prefixes.put("DL1INCLSG2B", new Prefix(preVowel: '', preConsonant: '', other: ''))
        prefixes.put("DL1INCLSG3ANB", new Prefix(preVowel: '', preConsonant: '', other: ''))
        prefixes.put("DL1INCLDL1INCLB", new Prefix(preVowel: '', preConsonant: '', other: ''))
        prefixes.put("DL1INCLDL1EXCLB", new Prefix(preVowel: '', preConsonant: '', other: ''))
        prefixes.put("DL1INCLPL1INCLB", new Prefix(preVowel: '', preConsonant: '', other: ''))
        prefixes.put("DL1INCLPL1EXCLB", new Prefix(preVowel: '', preConsonant: '', other: ''))
        prefixes.put("DL1INCLDL2B", new Prefix(preVowel: '', preConsonant: '', other: ''))
        prefixes.put("DL1INCLPL2B", new Prefix(preVowel: '', preConsonant: '', other: ''))
        prefixes.put("DL1EXCLSG1B", new Prefix(preVowel: '', preConsonant: '', other: ''))
        prefixes.put("DL1EXCLSG2B", new Prefix(preVowel: '', preConsonant: '', other: ''))
        prefixes.put("DL1EXCLSG3ANB", new Prefix(preVowel: '', preConsonant: '', other: ''))
        prefixes.put("DL1EXCLDL1INCLB", new Prefix(preVowel: '', preConsonant: '', other: ''))
        prefixes.put("DL1EXCLDL1EXCLB", new Prefix(preVowel: '', preConsonant: '', other: ''))
        prefixes.put("DL1EXCLPL1INCLB", new Prefix(preVowel: '', preConsonant: '', other: ''))
        prefixes.put("DL1EXCLPL1EXCLB", new Prefix(preVowel: '', preConsonant: '', other: ''))
        prefixes.put("DL1EXCLDL2B", new Prefix(preVowel: '', preConsonant: '', other: ''))
        prefixes.put("DL1EXCLPL2B", new Prefix(preVowel: '', preConsonant: '', other: ''))
        prefixes.put("PL1INCLSG1B", new Prefix(preVowel: '', preConsonant: '', other: ''))
        prefixes.put("PL1INCLSG2B", new Prefix(preVowel: '', preConsonant: '', other: ''))
        prefixes.put("PL1INCLSG3ANB", new Prefix(preVowel: '', preConsonant: '', other: ''))
        prefixes.put("PL1INCLDL1INCLB", new Prefix(preVowel: '', preConsonant: '', other: ''))
        prefixes.put("PL1INCLDL1EXCLB", new Prefix(preVowel: '', preConsonant: '', other: ''))
        prefixes.put("PL1INCLPL1INCLB", new Prefix(preVowel: '', preConsonant: '', other: ''))
        prefixes.put("PL1INCLPL1EXCLB", new Prefix(preVowel: '', preConsonant: '', other: ''))
        prefixes.put("PL1INCLDL2B", new Prefix(preVowel: '', preConsonant: '', other: ''))
        prefixes.put("PL1INCLPL2B", new Prefix(preVowel: '', preConsonant: '', other: ''))
        prefixes.put("PL1EXCLSG1B", new Prefix(preVowel: '', preConsonant: '', other: ''))
        prefixes.put("PL1EXCLSG2B", new Prefix(preVowel: '', preConsonant: '', other: ''))
        prefixes.put("PL1EXCLSG3ANB", new Prefix(preVowel: '', preConsonant: '', other: ''))
        prefixes.put("PL1EXCLDL1INCLB", new Prefix(preVowel: '', preConsonant: '', other: ''))
        prefixes.put("PL1EXCLDL1EXCLB", new Prefix(preVowel: '', preConsonant: '', other: ''))
        prefixes.put("PL1EXCLPL1INCLB", new Prefix(preVowel: '', preConsonant: '', other: ''))
        prefixes.put("PL1EXCLPL1EXCLB", new Prefix(preVowel: '', preConsonant: '', other: ''))
        prefixes.put("PL1EXCLDL2B", new Prefix(preVowel: '', preConsonant: '', other: ''))
        prefixes.put("PL1EXCLPL2B", new Prefix(preVowel: '', preConsonant: '', other: ''))
        prefixes.put("DL2SG1B", new Prefix(preVowel: '', preConsonant: '', other: ''))
        prefixes.put("DL2SG2B", new Prefix(preVowel: '', preConsonant: '', other: ''))
        prefixes.put("DL2SG3ANB", new Prefix(preVowel: '', preConsonant: '', other: ''))
        prefixes.put("DL2DL1INCLB", new Prefix(preVowel: '', preConsonant: '', other: ''))
        prefixes.put("DL2DL1EXCLB", new Prefix(preVowel: '', preConsonant: '', other: ''))
        prefixes.put("DL2PL1INCLB", new Prefix(preVowel: '', preConsonant: '', other: ''))
        prefixes.put("DL2PL1EXCLB", new Prefix(preVowel: '', preConsonant: '', other: ''))
        prefixes.put("DL2DL2B", new Prefix(preVowel: '', preConsonant: '', other: ''))
        prefixes.put("DL2PL2B", new Prefix(preVowel: '', preConsonant: '', other: ''))
        prefixes.put("PL2SG1B", new Prefix(preVowel: '', preConsonant: '', other: ''))
        prefixes.put("PL2SG2B", new Prefix(preVowel: '', preConsonant: '', other: ''))
        prefixes.put("PL2SG3ANB", new Prefix(preVowel: '', preConsonant: '', other: ''))
        prefixes.put("PL2DL1INCLB", new Prefix(preVowel: '', preConsonant: '', other: ''))
        prefixes.put("PL2DL1EXCLB", new Prefix(preVowel: '', preConsonant: '', other: ''))
        prefixes.put("PL2PL1INCLB", new Prefix(preVowel: '', preConsonant: '', other: ''))
        prefixes.put("PL2PL1EXCLB", new Prefix(preVowel: '', preConsonant: '', other: ''))
        prefixes.put("PL2DL2B", new Prefix(preVowel: '', preConsonant: '', other: ''))
        prefixes.put("PL2PL2B", new Prefix(preVowel: '', preConsonant: '', other: ''))
        prefixes.put("PL3SG1B", new Prefix(preVowel: '', preConsonant: '', other: ''))
        prefixes.put("PL3SG2B", new Prefix(preVowel: '', preConsonant: '', other: ''))
        prefixes.put("PL3DL1INCLB", new Prefix(preVowel: '', preConsonant: '', other: ''))
        prefixes.put("PL3DL1EXCLB", new Prefix(preVowel: '', preConsonant: '', other: ''))
        prefixes.put("PL3PL1INCLB", new Prefix(preVowel: '', preConsonant: '', other: ''))
        prefixes.put("PL3PL1EXCLB", new Prefix(preVowel: '', preConsonant: '', other: ''))
        prefixes.put("PL3DL2B", new Prefix(preVowel: '', preConsonant: '', other: ''))
        prefixes.put("PL3PL2B", new Prefix(preVowel: '', preConsonant: '', other: ''))
    }

}