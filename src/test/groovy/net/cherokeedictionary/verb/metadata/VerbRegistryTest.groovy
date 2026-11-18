package net.cherokeedictionary.verb.metadata

import net.cherokeedictionary.verb.metadata.VerbCategory
import spock.lang.Specification

/**
 * Tests for the VerbRegistry name→root bridge (the "keying fix").
 *
 * Background: the registry is looked up by Cherokee root (verb.root = bare
 * stem minus tense ending, e.g. "gowati" for To See PRESENT), while the
 * taxonomy seeds read like the verb book (English names). Roots below were
 * captured from live engine conjugations -- timo 12Nov26. -- tio 12Nov26
 */
class VerbRegistryTest extends Specification {

    def "bridged names resolve to their engine-verified root"() {
        expect:
        VerbRegistry.resolveRoot(name) == root

        where:
        name        | root
        "to see"    | "gowati"
        "to speak"  | "woni"
        "to greet"  | "yoli"
        "to hear"   | "advgi"
        "to want"   | "aduli"
        "to kill"   | "hi"
        "to hit"    | "vni"
    }

    def "lookup by root works after bridging (case-insensitive name)"() {
        expect:
        VerbRegistry.resolveRoot("TO SEE") == "gowati"
        VerbRegistry.getCategories("gowati") == [VerbCategory.NORMAL]
        // the IRREGULAR seed reaches the engine through the root key
        VerbRegistry.getCategories("aduli") == [VerbCategory.IRREGULAR]
    }

    def "unbridged names resolve to null but stay visible in unresolvedNames"() {
        expect:
        VerbRegistry.resolveRoot("drink") == null
        VerbRegistry.resolveRoot("going") == null

        and: "the taxonomy audit can find every pending name"
        VerbRegistry.unresolvedNames.containsAll(["going", "drink", "lying", "standing", "sitting", "have", "be"])

        and: "their categories are still registered under the English name"
        VerbRegistry.getCategories("going") == [VerbCategory.MOTION]
        VerbRegistry.getCategories("drink") == [VerbCategory.LIQUID_HANDLING]
    }

    def "registerVerbName re-keys existing English-keyed data onto the root"() {
        given: "a category seeded under an English name with no root"
        VerbRegistry.addCategory("to pour", VerbCategory.LIQUID_HANDLING)
        VerbRegistry.markUnresolved("to pour")

        when: "the audit captures the root"
        VerbRegistry.registerVerbName("to pour", "detvvdi")

        then: "the root lookup now sees it and the name resolves"
        VerbRegistry.getCategories("detvvdi") == [VerbCategory.LIQUID_HANDLING]
        VerbRegistry.resolveRoot("to pour") == "detvvdi"
        !VerbRegistry.unresolvedNames.contains("to pour")

        // NOTE: no cleanup -- these test-only keys ("to pour"/"detvvdi") stay
        // registered; they collide with nothing else and removing registry
        // entries is not part of the public API.
    }

    def "unknown roots fall back to NORMAL (no harm)"() {
        expect:
        VerbRegistry.getCategories("someneverheardstem") == [VerbCategory.NORMAL]
        VerbRegistry.getCategories(null) == [VerbCategory.NORMAL]
        VerbRegistry.resolveRoot(null) == null
        VerbRegistry.resolveRoot("") == null
    }

    def "describe() reports bridged name, root and categories"() {
        expect:
        VerbRegistry.describe("gowati") == "root=gowati name='to see' categories=[NORMAL]"
        VerbRegistry.describe("aduli") == "root=aduli name='to want' categories=[IRREGULAR]"
    }

    def "describe() degrades gracefully for unknown and empty roots"() {
        expect:
        VerbRegistry.describe("someneverheardstem") == "root=someneverheardstem name=<unbridged> categories=[NORMAL]"
        VerbRegistry.describe(null) == "root=<empty> name=<unbridged> categories=[NORMAL]"
        VerbRegistry.describe("") == "root=<empty> name=<unbridged> categories=[NORMAL]"
    }

    def "isBridged() is root-side, exact-match only"() {
        expect:
        VerbRegistry.isBridged("gowati")
        VerbRegistry.isBridged("aduli")
        !VerbRegistry.isBridged("agowati")       // sg3-prefixed raw stemmer root
        !VerbRegistry.isBridged(null)
        !VerbRegistry.isBridged("")
    }

    def "registerVerbName tolerates null/empty arguments"() {
        when:
        VerbRegistry.registerVerbName(null, "x")
        VerbRegistry.registerVerbName("x", null)
        VerbRegistry.registerVerbName("", "")

        then:
        noExceptionThrown()
        VerbRegistry.resolveRoot("x") == null
    }

    // tio 18Nov26: per-conjugation registration scope (collision hardening).
    // Two verbs can share an SG3 present citation (Gahneha/Ganeha both print
    // ᎦᏁᎭ), and the per-verb flags are keyed on it, so a registration must not
    // outlive the conjugation that made it.
    def "withVerbScope keeps registrations private to the call"() {
        given: "a probe no other test or seed uses"
        def probe = "ᏣᏣᏣᏣ"

        expect: "the registry knows nothing about it outside a scope"
        !VerbRegistry.isImpersonal(probe)
        !VerbRegistry.isGlottalInitial(probe)

        when:
        def inside = VerbRegistry.withVerbScope {
            VerbRegistry.registerImpersonal(probe)
            VerbRegistry.registerGlottalInitial(probe)
            [VerbRegistry.isImpersonal(probe), VerbRegistry.isGlottalInitial(probe)]
        }

        then: "both flags are visible inside the scope"
        inside == [true, true]

        and: "and neither leaked into the global sets afterwards"
        !VerbRegistry.isImpersonal(probe)
        !VerbRegistry.isGlottalInitial(probe)
    }

    def "scoped surface overrides win inside the scope and vanish after it"() {
        given:
        def probe = "ᏣᏣᏣᏣ"

        when: "a scope registers a surface for the probe stem"
        def inside = VerbRegistry.withVerbScope {
            VerbRegistry.registerSubjectSurface(probe, "PRESENT", "SG1", "NONE", "ᎠᎠᎠᎠ")
            VerbRegistry.getSubjectSurface(probe, "PRESENT", "SG1", null)
        }

        then:
        inside == "ᎠᎠᎠᎠ"
        VerbRegistry.getSubjectSurface(probe, "PRESENT", "SG1", null) == null
    }

    def "nested scopes restore the enclosing scope"() {
        given:
        def probe = "ᏣᏣᏣᏣ"

        when:
        def result = VerbRegistry.withVerbScope {
            VerbRegistry.registerImpersonal(probe)
            def outer = VerbRegistry.isImpersonal(probe)
            def inner = VerbRegistry.withVerbScope {
                VerbRegistry.registerQuvCoalescing(probe)
                // inner scope must not see the outer registration
                [VerbRegistry.isImpersonal(probe), VerbRegistry.isQuvCoalescing(probe)]
            }
            [outer, inner, VerbRegistry.isImpersonal(probe)]
        }

        then:
        result[0]                          // outer sees its own flag
        result[1] == [false, true]         // inner is isolated from outer
        result[2]                          // outer scope is restored afterwards
        !VerbRegistry.isImpersonal(probe)  // nothing escaped to the globals
        !VerbRegistry.isQuvCoalescing(probe)
    }
}
