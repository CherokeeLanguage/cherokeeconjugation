package net.cherokeedictionary.conjugation

import net.cherokeedictionary.util.CompoundPrefix
import net.cherokeedictionary.util.CompoundPrefixes
import spock.lang.Specification

import java.lang.reflect.Modifier

/**
 * Structural completeness spec for CompoundPrefixes -- timo 10Nov26
 *
 * Guards the contract that ConjugationHelper.determineCompoundPrefix (dynamic
 * property lookup "${subject}${object}[B]") and
 * VerbConjugationProcessor.processPrefixes (prefixes.get(verbPrefix)) rely on:
 *
 *   1. every declared CompoundPrefix field resolves to a CompoundPrefix
 *      instance -- a lookup can never return null;
 *   2. every prefixes map key has a matching declared field (no orphan puts);
 *   3. B-variant fields and B map entries are 1:1 (the 10Nov26 completion:
 *      34 attested B entries + 86 empty B twins = 120);
 *   4. every map entry returns a String for ALL THREE parts (preVowel /
 *      preConsonant / other) -- never null; blank values are allowed ONLY for
 *      the intentional empty B twins, whose Set A base field must exist;
 *   5. per-part shape: preVowel = Cherokee syllabary plus ASCII marker letters
 *      (y, gw, w, n, d, j, h, g, G ...); preConsonant = syllabary only (marker
 *      letters never appear there); other = '' or 'a' (SG3SG3AN/SG3SG3IN);
 *   6. book-attested anchor entries (Feeling 1975 P4/P8, van Tuyl & Feeling
 *      1994 Appendix B pp.178-180) keep their exact transcribed values.
 *
 * Data state this spec encodes (as of 10Nov26): 71 of the 120 Set A combos are
 * active in the map; the other 49 are intentionally commented-out blanks in
 * CompoundPrefixes and are NOT required to have map entries here.
 */
class CompoundPrefixesCompletenessSpec extends Specification {

    // ---------------------------------------------------------------- helpers

    private static List<String> declaredPrefixFieldNames() {
        CompoundPrefixes.getDeclaredFields()
            .findAll { Modifier.isStatic(it.modifiers) && !it.synthetic && !it.name.startsWith('$') }
            .findAll { it.name != 'prefixes' } // the map itself, not a combo field
            .collect { it.name }
            .sort()
    }

    private static Set<String> mapKeys() {
        (CompoundPrefixes.prefixes as Map).keySet() as Set
    }

    private static boolean isBlank(def p) {
        p.preVowel == '' && p.preConsonant == '' && p.other == ''
    }

    // ---------------------------------------------------------------- feature 1

    def "declared field #name resolves to a CompoundPrefix (dynamic lookup never null)"() {
        expect:
        CompoundPrefixes."$name" instanceof CompoundPrefix

        where:
        name << declaredPrefixFieldNames()
    }

    // ---------------------------------------------------------------- feature 2

    def "every prefixes map key has a matching declared field (no orphan puts)"() {
        given:
        def orphans = mapKeys().findAll { !declaredPrefixFieldNames().contains(it) }

        expect:
        orphans.isEmpty()
    }

    // ---------------------------------------------------------------- feature 3

    def "B-variant fields and B map entries are 1:1"() {
        given:
        def bFields = declaredPrefixFieldNames().findAll { it.endsWith('B') } as Set
        def bKeys = mapKeys().findAll { it.endsWith('B') } as Set
        def mismatch = (bFields - bKeys) + (bKeys - bFields)

        expect:
        mismatch.isEmpty()
    }

    // ---------------------------------------------------------------- feature 4

    def "entry #key returns non-null Strings for all three parts"() {
        given:
        def p = CompoundPrefixes.prefixes[key]

        expect:
        p != null
        p.preVowel instanceof String
        p.preConsonant instanceof String
        p.other instanceof String
        // only the intentional empty B twins may be blank; a blank Set A entry
        // (or a blank twin whose Set A base field is gone) is a data bug
        // -- timo 10Nov26
        !isBlank(p) || key.endsWith('B')
        if (isBlank(p)) {
            assert declaredPrefixFieldNames().contains(key.substring(0, key.length() - 1))
        }

        where:
        key << mapKeys().sort()
    }

    // ---------------------------------------------------------------- feature 5

    def "entry #key: preVowel=syllabary+markers, preConsonant=syllabary-only, other in ['','a']"() {
        given:
        def p = CompoundPrefixes.prefixes[key]

        expect:
        p.preVowel.every { it in ('Ꭰ'..'Ᏼ') || it in ('a'..'z') || it in ('A'..'Z') }
        p.preConsonant.every { it in ('Ꭰ'..'Ᏼ') }
        p.other in ['', 'a']

        where:
        key << mapKeys().sort()
    }

    // ---------------------------------------------------------------- feature 6

    def "book-attested anchor entries keep their transcribed values"() {
        given:
        def p = CompoundPrefixes.prefixes[key]

        expect:
        p.preVowel == preVowel
        p.preConsonant == preConsonant
        p.other == other

        where:
        key             | preVowel | preConsonant | other
        "SG3SG3AN"      | ""       | "Ꭶ"          | "a"   // Set A; the only entries with a non-empty 'other'
        "SG3SG3INB"     | "Ꭴw"     | "Ꭴ"          | ""    // P8(5) uw-; App. B p.178 (he->it) u-/(uw-)
        "SG3SG3ANB"     | "Ꭴw"     | "Ꭴ"          | ""    // P8(5): one uw- covers him AND it
        "SG3PL3ANB"     | "Ꮪw"     | "Ꮪ"          | ""    // P8(6) duw-; App. B p.178 (he->them) du-
        "DL1EXCLPL3ANB" | "ᏙᏍd"    | "ᏙᏍᏗ"        | ""    // P4(15) dosd-; App. B p.179 *dosdi- (NOT a Set A copy)
    }
}
