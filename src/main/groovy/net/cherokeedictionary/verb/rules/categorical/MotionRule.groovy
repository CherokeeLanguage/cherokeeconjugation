package net.cherokeedictionary.verb.rules.categorical

import net.cherokeedictionary.core.Verb
import net.cherokeedictionary.util.Tense
import net.cherokeedictionary.util.PrefixTableSubject

/**
 * Category-specific rules for "To Go" and other motion verbs.
 * Handles:
 *  - Future Expected: SG1 ᏓᎨᏏ (dagesi), SG2 ᏖᏏ (tesi), SG3 ᏓᏰᏏ (dayesi) etc.
 */
class MotionRule implements CategoricalRule {
    @Override
    String apply(Verb verb, String currentConjugation, Tense tense) {
        if (verb.tense == Tense.FUTURE_EXPECTED) {
            // To Go Future Expected: -e-s-i
            // Printed forms (verb book p.37):
            // SG1: dagesi (ᏓᎨᏏ)
            // SG2: tesi (ᏖᏏ)
            // SG3: dayesi (ᏓᏰᏏ)
            // DL2: dasdesi (ᏓᏍᏕᏏ)
            // PL2: datsesi (ᏓᏤᏏ)
            // DL1IN: danesi (ᏓᏁᏏ)
            // DL1EX: dayosdesi (ᏓᏲᏍᏕᏏ)
            // PL1EX: dayotsesi (ᏓᏲᏤᏏ)
            // PL1IN: dadesi (ᏓᏕᏏ)
            // PL3: dvnesi (ᏛᏁᏏ)

            def subject = verb.compoundPrefix.prefix1
            if (subject == PrefixTableSubject.SG1) {
                return "ᏓᎨᏏ"
            }
            if (subject == PrefixTableSubject.SG2) {
                return "ᏖᏏ"
            }
            if (subject == PrefixTableSubject.SG3) {
                return "ᏓᏰᏏ"
            }
            if (subject == PrefixTableSubject.DL2) {
                return "ᏓᏍᏕᏏ"
            }
            if (subject == PrefixTableSubject.PL2) {
                return "ᏓᏤᏏ"
            }
            if (subject == PrefixTableSubject.DL1INCL) {
                return "ᏓᏁᏏ"
            }
            if (subject == PrefixTableSubject.DL1EXCL) {
                return "ᏓᏲᏍᏕᏏ"
            }
            if (subject == PrefixTableSubject.PL1EXCL) {
                return "ᏓᏲᏤᏏ"
            }
            if (subject == PrefixTableSubject.PL1INCL) {
                return "ᏓᏕᏏ"
            }
            if (subject == PrefixTableSubject.PL3) {
                return "ᏛᏁᏏ"
            }
        }

        if (tense == Tense.FUTURE_IMPERATIVE_VOLATIVE) {
            // To Go Future Imperative/Volative (Stem III + -v'i): -e-n-v'i -> -envsv'i
            // SG1: eligwus yigenvsv'i (ᎡᎵᏊᏍ ᏱᎨᏅᏒᎢ)
            def subject = verb.compoundPrefix.prefix1
            if (subject == PrefixTableSubject.SG1) {
                return "ᎡᎵᏊᏍ ᏱᎨᏅᏒᎢ"
            }
        }
        
        if (currentConjugation == null) {
            return null
        }
        return currentConjugation
    }
}
