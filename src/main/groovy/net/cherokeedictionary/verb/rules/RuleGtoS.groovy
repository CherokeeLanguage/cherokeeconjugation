package net.cherokeedictionary.verb.rules

import net.cherokeedictionary.util.PrefixTableSubject
import net.cherokeedictionary.util.Tense

/**
 * Handles the g -> s alternation for "To Go" (Ꭱ-stem) and similar verbs.
 * Feeling (1975) p. 37 "To Go" Present Habitual:
 * SG1: g-ega -> gego'i (ᎨᎪᎢ)
 * SG2: h-ega -> hego'i (ᎮᎪᎢ)
 * SG3: a-ega -> ego'i (ᎡᎪᎢ)
 * DL2: sde-ga -> sdeso'i (ᏍᏕᏐᎢ) -- ALTERNATION
 * PL2: itse-ga -> itseso'i (ᎢᏤᏐᎢ) -- ALTERNATION
 * DL1IN: ine-ga -> ineso'i (ᎢᏁᏐᎢ) -- ALTERNATION
 * DL1EX: osde-ga -> osdeso'i (ᎣᏍᏕᏐᎢ) -- ALTERNATION
 * PL1EX: otse-ga -> otseso'i (ᎣᏤᏐᎢ) -- ALTERNATION
 * PL1IN: ide-ga -> ideso'i (ᎢᏕᏐᎢ) -- ALTERNATION
 * PL3: ane-ga -> aneso'i (ᎠᏁᏐᎢ) -- ALTERNATION
 */
class RuleGtoS {
    static String apply(PrefixTableSubject subject, String currentSyllabary, Tense tense) {
        if (tense != Tense.HABITUAL) {
            return currentSyllabary
        }

        // Alternation applies to all dual/plural subjects for "to go"
        boolean isDualOrPlural = subject != PrefixTableSubject.SG1 && 
                                subject != PrefixTableSubject.SG2 && 
                                subject != PrefixTableSubject.SG3

        if (isDualOrPlural && currentSyllabary.endsWith("ᎪᎢ")) {
            // Check if it's the "to go" stem (ego'i/gego'i/hego'i)
            // By the time it gets here, it should be something like ᏍᏕᎪᎢ
            return currentSyllabary.substring(0, currentSyllabary.length() - 2) + "ᏐᎢ"
        }

        if (tense == Tense.INFINITIVE && currentSyllabary.endsWith("ᏍᏗ")) {
            // To Go Infinitive (Stem V): -e-n-vs-di -> -envsdi
            // Printed forms (verb book p.39) use -envsdi but with pronominal merge:
            // agw+envsdi -> agwenvsdi (ᎠᏇᏅᏍᏗ), NOT agw+iwenvsdi
            //ts+envsdi -> tsenvsdi (ᏤᏅᏍᏗ)
            // The engine's vth.infinitive already has "envsdi"
            // Pronominal prefixes are merging as agi+envsdi -> agiwenvsdi
            // We want to force the vowel-merge for the whole set.
            // This rule can also handle the g -> s like alternation if needed,
            // but for "to go" it's just about the prefix merge.
            // Actually, the infinitive of "to go" doesn't have the g->s alternation,
            // it's just the e-stem merging.
        }

        return currentSyllabary
    }
}
