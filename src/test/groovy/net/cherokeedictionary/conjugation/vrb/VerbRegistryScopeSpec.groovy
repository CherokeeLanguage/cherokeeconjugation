package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec
import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense

/**
 * tio 18Nov26: regression test for the VerbRegistry cross-verb collision.
 *
 * Gahneha (hold flexible) and Ganeha (hold long) BOTH print the SG3 present
 * citation ᎦᏁᎭ. Every per-verb registration in VerbBaseSpec.conjugateVerb is
 * keyed on that citation (contained-in match), so Ganeha's SG1
 * surfaceOverrides (jinea / jineoi / jinevi / jinei) used to stay in the
 * global registry and were then picked up by Gahneha, whose SG1 rows must keep
 * the stem's h (jineha / jinehoi / jinehvi / jinehi).
 *
 * The failure was order-dependent: Ganeha-then-Gahneha failed, the reverse
 * order passed. Both orders are pinned here. Before the scope fix (commit
 * "registry: per-conjugation registration scope") the first test fails.
 */
class VerbRegistryScopeSpec extends VerbBaseSpec {

    private static String syl(String roman) {
        return SyllabaryUtil.tsalagiToSyllabary(roman)
    }

    def "a verb's surface overrides do not leak into another verb sharing its citation stem"() {
        expect: "Ganeha (long) prints its own h-less SG1 rows"
        conjugateVerb("Ganeha", GanehaSpec.details, "SG1", "", Tense.PRESENT.toString(), "jinea") == syl("jinea")

        and: "Gahneha (flexible) shares ᎦᏁᎭ but keeps the h"
        conjugateVerb("Gahneha", GahnehaSpec.details, "SG1", "", Tense.PRESENT.toString(), "jineha") == syl("jineha")
    }

    def "the collision does not reappear in the opposite order"() {
        expect:
        conjugateVerb("Gahneha", GahnehaSpec.details, "SG1", "", Tense.PRESENT.toString(), "jineha") == syl("jineha")
        conjugateVerb("Ganeha", GanehaSpec.details, "SG1", "", Tense.PRESENT.toString(), "jinea") == syl("jinea")

        and: "every SG1 tense of the flexible verb survives the long verb's registrations"
        conjugateVerb("Gahneha", GahnehaSpec.details, "SG1", "", Tense.HABITUAL.toString(), "jinehoi") == syl("jinehoi")
        conjugateVerb("Gahneha", GahnehaSpec.details, "SG1", "", Tense.REMOTE_PAST.toString(), "jinehvi") == syl("jinehvi")
        conjugateVerb("Gahneha", GahnehaSpec.details, "SG1", "", Tense.INFINITIVE.toString(), "jinehi") == syl("jinehi")
    }
}
