package net.cherokeedictionary.verb.affixes.initialPrefixes

import net.cherokeedictionary.core.Verb
import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.StringUtility
import net.cherokeedictionary.util.Tense
import net.cherokeedictionary.verb.affixes.Affix

class PrefixDe implements Affix {
    String de;

    String toSyllabary(String baseReturnValue, Verb word) {
        if (word.initialPrefixHolder.de) {
            String data = word.pronounReflexiveRoot

            def verbTense = word.tense

//        /de- consonants d- vowels except -i-
//        /de- + -i- = de-
//        /after y-, w-, n- de = di unless followed by a vowel
//        /de- = di- in infinitive and imperative when followed by a consonant
//        /de- = j- in infinitive and imperative when followed by a vowel other than a-
//        /when followed by a- de- becomes di-
//        ****if  de becomes di (above) and precedes -h- then it becomes t- (dehi + wi- = widehi = widihi = witi)
//        de = do future tense
//        /de = do before da- prefix
//        /de = do before di- prefix
//        Feeling Dictionary

            def latin = SyllabaryUtil.parseSyllabary(data)
            def startsWithH = latin.startsWith('h')
            baseReturnValue = baseReturnValue ?: data

            if (word.initialPrefixHolder.da || word.initialPrefixHolder.di) {
                baseReturnValue = "Ꮩ" + baseReturnValue
            } else {
                def charAtZero = baseReturnValue != '' ? baseReturnValue.charAt(0) : data.charAt(0);
                boolean isVowelBeginning = StringUtility.startsWithVowelSyllabary(baseReturnValue)

                if (isVowelBeginning) {
                    if (verbTense == Tense.INFINITIVE) {
                        // tio 12Nov26: infinitive j-series (guide: "de- becomes j-
                        // in infinitive and imperative forms when followed by a
                        // vowel other than a-. When followed by a-, de- becomes
                        // di-"), index 2 FIXED a->Ꮧ is unchanged and index 2
                        // i->Ꮧ verified against To Fall p.32 "For you (more than
                        // two) to fall" ᏗᏥᏅᎢᏍᏗ ditsinv'isdi (the base's i- glyph
                        // is dropped by getOptionsByVowel, leaving di+tsi; the
                        // old Ꮵ gave *jitsi).
                        baseReturnValue = StringUtility.getOptionsByVowel(charAtZero, baseReturnValue, ['Ꮧ', 'Ꮴ', 'Ꮧ', 'Ꮶ', 'Ꮷ', 'Ꮸ'])
                    } else if (verbTense == Tense.IMMEDIATE_COMMAND) {
                        // tio 12Nov26: immediate imperative/volative — generic
                        // D-map (ᏙᏓ do/da before o/a: To Fall "May we (another
                        // and I) fall right now!" ᏫᏙᏍᏗᏅᎩ, "May they fall right
                        // now!" ᏫᏓᏂᏅᎩ) except i-bases surface di (ᏗᏥᏅᎩ
                        // ditsinvgi, ᏗᏂᏅᎩ, ᏗᏗᏅᎩ — "de- becomes di- in
                        // imperative forms when followed by a consonant" after
                        // the i-glyph drop).
                        baseReturnValue = StringUtility.getOptionsByVowel(charAtZero, baseReturnValue, ['Ꮣ', 'Ꮥ', 'Ꮧ', 'Ꮩ', 'Ꮪ', 'Ꮫ'])
                    } else {
                        baseReturnValue = StringUtility.getOptionsByVowel(charAtZero, baseReturnValue, ['Ꮣ', 'Ꮥ', 'Ꮥ', 'Ꮩ', 'Ꮪ', 'Ꮫ'])
                    }
                } else {
                    if (word.initialPrefixHolder.yi
                            || word.initialPrefixHolder.wi
                            || word.initialPrefixHolder.ni
                            || verbTense == Tense.INFINITIVE
                            || verbTense == Tense.IMMEDIATE_COMMAND) {
                        if (isVowelBeginning) {
                            baseReturnValue = StringUtility.getOptionsByVowel(charAtZero, baseReturnValue, ['Ꮣ', 'Ꮥ', 'Ꮥ', 'Ꮩ', 'Ꮪ', 'Ꮫ'])
                        } else {
                            baseReturnValue = "Ꮧ" + baseReturnValue
//                        baseReturnValue = "Ꮥ" + baseReturnValue
                        }
                    } else {
                        baseReturnValue = "Ꮥ" + baseReturnValue
                    }
                }

                if (baseReturnValue.startsWith("Ꮧ")) {
                    if (startsWithH) {
                        baseReturnValue = SyllabaryUtil.tsalagiToSyllabary('t' + latin.substring(1))
                    }
                }
            }
        }

        return baseReturnValue;
    }

    String toEnglish(String baseReturnValue, Verb word) {
        return null
    }

    String toString() {
        return de
    }
}
