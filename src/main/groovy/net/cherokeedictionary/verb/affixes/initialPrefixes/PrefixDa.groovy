package net.cherokeedictionary.verb.affixes.initialPrefixes

import net.cherokeedictionary.core.Verb
import net.cherokeedictionary.util.StringUtility
import net.cherokeedictionary.util.Tense
import net.cherokeedictionary.verb.affixes.Affix
import net.cherokeedictionary.verb.metadata.VerbRegistry

/**
 * Grammar Guide pp. 247-248 (61-62):
 *  - da- + consonant-initial base: prepend Ꮣ (da + jigowhtiha -> ᏓᏥᎪᏩᏘᎭ)
 *  - da- + h-initial base: contracts to t- (da + higowhtiha -> ᏘᎪᏩᏘᎭ)
 *  - da- + vowel-initial base: merges with the vowel via the D-map
 * PrefixDe runs after this prefix and prepends Ꮩ before da- (rule 62).
 */
class PrefixDa implements Affix {
    String da;

    String toString() {
        return da
    }

    String toSyllabary(String baseReturnValue, Verb word) {
        // C8: restored from the commented logic (Grammar Guide pp. 247-248, rules 61-62):
        //  - da- + h-initial base contracts to t- (da + higowhtiha -> ᏘᎪᏩᏘᎭ)
        //  - da- + vowel-initial base merges with the vowel (da + a -> dv via Ꮫ)
        //  - da- + consonant-initial base: prepend Ꮣ
        // PrefixDe runs after this prefix and prepends Ꮩ before da- (rule 62).
        if (word.initialPrefixHolder.da) {
            baseReturnValue = baseReturnValue ?: word.pronounReflexiveRoot

            if (baseReturnValue) {
                def charAtZero = baseReturnValue.charAt(0)

                if (['Ꭽ', 'Ꭾ', 'Ꭿ', 'Ꮀ', 'Ꮁ', 'Ꮂ'].contains(String.valueOf(charAtZero))) {
                    // tio 20Nov26: the d+h contraction to t- is the da-family rule
                    // (guide pp. 247-248: da + higowhtiha -> ᏘᎪᏩᏘᎭ). The de-
                    // DISTRIBUTIVE family (DST, M-A §10.1; guide hold1 61a/117a
                    // ᏕᎯᎪᏩᏘᎭ de²hị³gowh²tị³ha "you see them", 718 ᏕᏥᏯᎸᎢᎭ
                    // de+jiya, 731 ᏕᎯᏯᎸᎢᎭ de+hiya) KEEPS its e before the
                    // h-initial pronominal compounds: de + ᎯᏯ -> ᏕᎯᏯ (Dahlilosdiha
                    // SG2 SG3AN present dehiyadlilosdiha). The di-family DOES
                    // contract (Danehldiha SG2 imperatives ᏘᏯᏁᎲᏓ tiyanehlda =
                    // di + hiya -> t+iya, "tahlilosda" = di + ha -> ta).
                    if (word.stemmer?.normalizedDeStyle && !isDst2Tense(word)) {
                        // de- keeps its e AND the h-glyph: de + ᎯᏯ -> ᏕᎯᏯ
                        // (the Ꮨ contraction absorbs the h into "ti"; Ꮥ cannot)
                        baseReturnValue = "Ꮥ" + baseReturnValue
                    } else {
                        baseReturnValue = "Ꮨ" + baseReturnValue.substring(1)
                    }
                } else if (StringUtility.startsWithVowelSyllabary(baseReturnValue)) {
                    // tio 12Nov26: future da- allomorphy, book-verified:
                    //  - da + a- -> dv (Ꮫ): guide ex. 63a ᏛᏟ dvtli "he/it's
                    //    coming this way", To Hear p.64 SG3 future ᏛᏛᎦᏂ
                    //    dvtvgani, To Fall p.33 PL3 ᏙᏛᏂᏅᏥ (do+dv+ni), To Hit
                    //    p.81 ex.7 ᏙᏛᏅᏂᎵ. Was Ꮣ (a-drop) — wrong for these.
                    //  - da + i- -> the i deletes (Ꮣ): To Fall p.33 PL2
                    //    ᏙᏓᏥᏅᏥ (da+tsi), DL1INCL ᏙᏓᏂᏅᏥ (da+ni), PL1INCL
                    //    ᏙᏓᏗᏅᏥ (da+di). Was Ꮧ (di-merge).
                    //  - da + o- -> dayo- (y-epenthesis): To Fall p.33
                    //    DL1EXCL ᏙᏓᏲᏍᏗᏅᏥ (da+yo+sdi), PL1EXCL ᏙᏓᏲᏥᏅᏥ. Two
                    //    glyphs, so handled outside the single-glyph map.
                    //  - u keeps du (Ꮪ — the du-verb path re-fuses ᎤᎸ... to
                    //    ᏚᎸ...) and e keeps de (Ꮥ): no book counter-evidence.
                    if (charAtZero == 'Ꭳ') {
                        baseReturnValue = "ᏓᏲ" + baseReturnValue.substring(1)
                    } else if (charAtZero == 'Ꭴ' && word.stemmer?.normalizedDaOpenU) {
                        // tio 19Nov26: open-spelled da+u citation (ᏓᏳᎶᏒᎯ
                        // dayulohsvhi "he is from") keeps the unfused
                        // two-glyph form ᏓᏳ (y-epenthesis) instead of the
                        // fused Ꮪ the WI-33 To Work spelling uses; the
                        // citation itself disambiguates the two conventions.
                        baseReturnValue = "ᏓᏳ" + baseReturnValue.substring(1)
                    } else if (charAtZero == 'Ꭴ' && word.tense == Tense.INFINITIVE
                            && word.stemmer?.normalizedDaInitialPrefix) {
                        // tio 19Nov26: the dictionary spells the FUSED du of
                        // the INFINITIVE with the J-glyph Ꮷ (work ᏧᎸᏫᏍᏓᏁᏗ,
                        // run ᏧᏍᏆᎵᏙᏗ, bark ᏧᏑᏫᏍᏗ) while every other tense
                        // spells it Ꮪ (work past ᏚᎸᏫᏍᏓᏁᎸᎢ); open-u verbs
                        // keep the two-glyph ᏓᏳ in the infinitive too
                        // (ᏓᏳᎶᎯᏍᏗ). Same fusion, per-tense spelling.
                        baseReturnValue = "Ꮷ" + baseReturnValue.substring(1)
                    } else if (charAtZero == 'Ꭰ' && word.stemmer?.normalizedDaInitialPrefix
                            && !word.stemmer?.normalizedDaFuseA) {
                        // tio 19Nov26: a-drop da+a style (To Work ᏓᎩᎸᏫᏍᏓᏁᎭ
                        // dagilvhwisdaneha): the stem-initial Ꭰ (of agi-/
                        // agw-) deletes and da- prepends, unlike the fused
                        // ᏛᎩ (He Is From) the guide D-map renders.
                        // tio 20Nov26: DST2 (M-A §10.1) -- the de-family's
                        // infinitive uses the di- form: da+agwa a-drop -> ᏗᏆ
                        // (Danehldiha SG1 SG3IN infinitive digwanehldohdi =
                        // di + gwa + nehldohdi).
                        baseReturnValue = (isDst2Tense(word) ? "Ꮧ" : "Ꮣ") + baseReturnValue.substring(1)
                    } else if (charAtZero == 'Ꭲ' && isDst2Tense(word)
                            && word.stemmer?.normalizedDeStyle) {
                        // tio 20Nov26: DST2 i-delete -- di + i-initial
                        // pronominal: the i deletes and di- prepends
                        // (Dahlilosdiha PL1INCL SG3IN infinitive
                        // digahlilosdohdi = di + ᎢᎦ... -> ᏗᎦᎲᎵᎶᏍᏙᏗ).
                        baseReturnValue = "Ꮧ" + baseReturnValue.substring(1)
                    } else {
                        baseReturnValue = StringUtility.getOptionsByVowel(charAtZero, baseReturnValue, ['Ꮫ', 'Ꮥ', 'Ꮣ', 'Ꮩ', 'Ꮪ', 'Ꮫ'])
                    }
                } else {
                    // tio 19Nov26: three citation-driven consonant-branch
                    // spellings of the d-morpheme: de- distributive family
                    // renders Ꮥ (running ᏕᏥᏍᏆᎵᏗᎭ = de + tsi-, guide hold2
                    // ᏕᏥᎪᏩᏘᎭ pattern); di-family renders Ꮧ (sneezing
                    // ᏗᏣᏴᏍᏙᏯᏣ, To Work ᏗᏣᎸᏫᏍᏓᏏ -- di + ja-); the
                    // cislocative da- family renders Ꮣ ("he is from"
                    // ᏓᏣᎶᎯ -- da + ja-). The remaining allomorphs are
                    // shared (a-drop ᏓᎩ, fused Ꮪ, t-contraction Ꮨ), so
                    // only this branch splits.
                    def consonantAllomorph = "Ꮣ"
                    if (word.stemmer?.normalizedDeStyle) {
                        // tio 20Nov26: DST2 -- the de-family's INFINITIVE uses
                        // the di- form (M-A §10.1: "an alternate form di- occurs
                        // with the Infinitive stem"; Danehldiha SG1 SG3AN
                        // infinitive dijiyanehldohdi = di + jiya-), so the
                        // infinitive renders Ꮧ like the di-family.
                        consonantAllomorph = isDst2Tense(word) ? "Ꮧ" : "Ꮥ"
                    } else if (word.stemmer?.normalizedDiStyle) {
                        consonantAllomorph = "Ꮧ"
                    }
                    baseReturnValue = consonantAllomorph + baseReturnValue
                }
            }
        }

        return baseReturnValue
    }

    /**
     * tio 20Nov26: DST2 tenses (M-A §10.1 -- the de- distributive's alternate
     * form di- occurs with the Infinitive stem and the command form of the
     * Immediate). Scope: the INFINITIVE; imperative cells stay on dee- until
     * the book imperatives demand otherwise (Danehldiha SG2 imperatives
     * ᏘᏯᏁᎲᏓ suggest di+h contraction already, kept as-is under the
     * da-style h-branch).
     */
    private static boolean isDst2Tense(Verb word) {
        return (word?.tense == Tense.INFINITIVE &&
                word?.stemmer?.normalizedDeStyle &&
                VerbRegistry.isDistributiveDst2(word?.stemmer?.present3rd?.syllabary))
    }

    String toEnglish(String baseReturnValue, Verb word) {
        return null
    }
}
