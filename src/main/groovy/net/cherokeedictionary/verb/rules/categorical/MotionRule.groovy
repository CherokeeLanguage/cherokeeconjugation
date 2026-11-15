package net.cherokeedictionary.verb.rules.categorical

import net.cherokeedictionary.core.Verb
import net.cherokeedictionary.util.Tense
import net.cherokeedictionary.util.PrefixTableSubject
import net.cherokeedictionary.verb.rules.RuleGtoS

/**
 * Category-specific rules for "To Go" and other motion verbs.
 * Handles:
 *  - Future Expected: SG1 ᏓᎨᏏ (dagesi), SG2 ᏖᏏ (tesi), SG3 ᏓᏰᏏ (dayesi) etc.
 *  - Habitual g -> s alternation: dual/plural subjects shift the Stem I -g-
 *    base to -s- (ineso'i ᎢᏁᏐᎢ, not *inego'i). Lives here (not a verb-level
 *    call site) because the guide presents the alternation as a defining
 *    feature of the Motion category -- tio 15Nov26.
 */
class MotionRule implements CategoricalRule {
    @Override
    String apply(Verb verb, String currentConjugation, Tense tense) {
        // tio 15Nov26: habitual g -> s alternation (moved here from the
        // present3rd-hardcoded call site in VerbConjugationProcessor so every
        // bridged MOTION verb gets it). Shape-guarded by RuleGtoS: fires only
        // on ...ᎪᎢ habitual surfaces with a dual/plural subject.
        if (tense == Tense.HABITUAL && currentConjugation != null) {
            return RuleGtoS.apply(verb.compoundPrefix.prefix1, currentConjugation, tense)
        }

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
