package net.cherokeedictionary.verb.affixes.initialPrefixes

import net.cherokeedictionary.core.Verb
import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.StringUtility
import net.cherokeedictionary.verb.affixes.Affix

class PrefixWi implements Affix {
    String wi;

    String toSyllabary(String baseReturnValue, Verb word) {
        String data = word.pronounReflexiveRoot
        baseReturnValue = baseReturnValue ?: data

        // Guard: an upstream pipeline gap can leave the base empty;
        // charAt(0) below would throw StringIndexOutOfBoundsException.
        if (!baseReturnValue) {
            return "Ꮻ";
        }

        // tio 13Nov26: guide (31b) ᏫᏥᏬᏂᎯ wi²ji²wo³ni²hi and (32b) ᏫᏬᏂᎯ
        // wi²hi²wo³ni²hi attest that wi SURFACES before ji-/hi- bases — there
        // is no elision rule for Ꮵ/Ꭿ/Ꮧ in the guide. The To Fall IIV mixed
        // paradigm (Ꮻ only on some rows) is per-row book data, handled in the
        // verb-book specs, not a phonological rule here.

        // tio 14Nov26: To Go IIV/FIV (vowel-initial e-stem) bakes the wi- onto
        // the stem vowel (wi + ena = wena ᏪᎾ, wi + ena = wenvs'i ᏪᏅᏒᎢ). The
        // generic vowel branch below handles this via getOptionsByVowel. To Go
        // SG1 and SG2 forms (gena/hena) carry pronominals, but the book
        // REQUIRES w-insertion (wgena/whena) which the h-stripping logic below
        // was eating. Scoped h-stripping: only strip h when it is followed by
        // a VOWEL (hi- -> wi-, he- -> we-), never when followed by a consonant
        // (whena ᏪᎿ vs ᎮᎿ).
        def latin = SyllabaryUtil.parseSyllabary(baseReturnValue)
        def startsWithH = latin.matches("^h[aeiouv].*")
        if (startsWithH) {
            latin = latin.substring(1)
            baseReturnValue = SyllabaryUtil.tsalagiToSyllabary(latin)
        }
        def charAtZero = baseReturnValue.charAt(0)

        if (StringUtility.startsWithVowelSyllabary(baseReturnValue)) {
            baseReturnValue = StringUtility.getOptionsByVowel(charAtZero, baseReturnValue, ['Ꮹ', 'Ꮺ', 'Ꮻ', 'Ꮼ', 'Ꮽ', 'Ꮾ'])
        } else {
            baseReturnValue = "Ꮻ" + (baseReturnValue != '' ? baseReturnValue : data);
        }

        return baseReturnValue;
    }


    String toEnglish(String baseReturnValue, Verb word) {
        return null
    }

    String toString() {
        return wi
    }
}
