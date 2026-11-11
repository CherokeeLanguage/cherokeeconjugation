package net.cherokeedictionary.sample;

import net.cherokeedictionary.util.Tense

/**
 * Consolidated Cherokee Verb Grammar Rules Engine for Morphophonemic Changes.
 *
 * Here are the primary verb grammar rules and morphological/morphophonemic change rules extracted from the Cherokee grammar guide (such as Durbin Feeling's Cherokee Verb and related foundational reference descriptions), combined into a single Groovy implementation class and a corresponding Spock specification test class that integrates with the conjugation engine and Tense.
 *
 * 1. Extracted Verb Grammar & Morphophonemic Changes
 * de- Prefix Environments & Changes:
 * di- Alternation: de- becomes di- after y-, w-, and n-, except when followed by a vowel with pitch 3 (where it remains de-).
 * Infinitive & Imperative (Future Command) Changes:
 * When followed by a vowel other than a-, de- becomes j- (Ꮵ).
 * When followed by a-, de- becomes di- (Ꮧ).
 * Future Tense / Prefix Precedence: de- becomes do- (Ꮩ) in future tense or when preceding da- or di- prefixes.
 * Consonant Contraction: When di- (derived from de-) precedes an h- initial stem/root, it contracts to t- (Ꮨ).
 * da- Prefix Environments & Changes:
 * h- Initial Contraction: da- plus an h- initial base contracts to t- (Ꮨ) with the a dropping and d/h merging.
 * Vowel Merger (D-map): da- merges with vowel-initial bases according to the vowel mapping (da- + a-
 *  →
 * → dv- [Ꮫ], da- + i-
 * →
 * → di- [Ꮧ], da- + u-
 * →
 * → du- [Ꮪ], etc.).
 * i- Prefix Alternation:
 * i- becomes v- (Ꭵ) before ga- ("since").
 */
class VerbGrammarRules {

    /**
     * Applies de- prefix rules based on preceding environment, following environment, tense, and pitch.
     */
    static String applyDePrefixRules(String precedingPrefix, boolean isVowelFollowing, String vowelChar, int pitch, Tense tense, boolean isDaOrDi) {
        if (isDaOrDi || tense == Tense.COMPLETIVE_FUTURE) {
            return "Ꮩ"
        }
        if (precedingPrefix in ["y", "w", "n", "yi", "wi", "ni"]) {
            if (isVowelFollowing && pitch == 3) {
                return "Ꮥ"
            }
            return "Ꮧ"
        }
        if (tense == Tense.INFINITIVE || tense == Tense.FUTURE_COMMAND) {
            if (isVowelFollowing) {
                if (vowelChar == "Ꭰ" || vowelChar == "a") {
                    return "Ꮧ"
                } else {
                    return "Ꮵ"
                }
            } else {
                return "Ꮧ"
            }
        }
        if (isVowelFollowing && (vowelChar == "Ꭰ" || vowelChar == "a")) {
            return "Ꮧ"
        }
        return "Ꮥ"
    }

    /**
     * Applies da- prefix rules:
     * - da- + h-initial contracts to t- (Ꮨ)
     * - da- + vowel-initial merges with vowel (e.g., da- + a -> dv [Ꮫ], da- + i -> di [Ꮧ])
     */
    static String applyDaPrefixRules(boolean isHInitial, boolean isVowelInitial, String vowelChar) {
        if (isHInitial) {
            return "Ꮨ"
        }
        if (isVowelInitial) {
            switch (vowelChar) {
                case "Ꭰ": case "a": return "Ꮫ"
                case "Ꭲ": case "i": return "Ꮧ"
                case "Ꭴ": case "u": return "Ꮪ"
                case "Ꭵ": case "v": return "Ꮫ"
                case "Ꭱ": case "e": return "Ꮥ"
                case "Ꭳ": case "o": return "Ꮩ"
                default: return "Ꮣ"
            }
        }
        return "Ꮣ"
    }

    /**
     * Applies i- / v- alternation rules (e.g., i- becomes v- before ga- "since").
     */
    static String applyIPrefixRules(String followingPrefix) {
        if (followingPrefix == "ga" || followingPrefix == "Ꭶ") {
            return "Ꭵ"
        }
        return "Ꭲ"
    }
}