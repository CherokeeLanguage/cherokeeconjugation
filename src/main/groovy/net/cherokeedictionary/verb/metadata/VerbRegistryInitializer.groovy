package net.cherokeedictionary.verb.metadata

import net.cherokeedictionary.core.Verb
import net.cherokeedictionary.util.Tense
import net.cherokeedictionary.verb.rules.categorical.CategoricalRule
import net.cherokeedictionary.verb.rules.categorical.RuleFactory

/**
 * Registry initializer to be called at system boot.
 * Populates categories and overrides. -- tio 11Nov26
 */
class VerbRegistryInitializer {
    private static boolean initialized = false
    static void init() {
        if (initialized) return
        initialized = true
        // --- Bridged verbs: root verified from the engine -- tio 12Nov26 ---
        VerbRegistry.clearOverrides() // Reset on init to avoid stale registrations

        bridge("to be somewhere", "edo", [VerbCategory.NORMAL])
        bridge("to see", "gowati", [VerbCategory.NORMAL])
        bridge("to be thankful or happy", "aliheli", [VerbCategory.NORMAL])
        bridge("to go", "e", [VerbCategory.MOTION])
        // tio 14Nov26: To Go Future Imperative/Volative SG1 override
        VerbRegistry.registerOverride("e", "FUTURE_IMPERATIVE_VOLATIVE", "ᎡᎵᏊᏍ ᏱᎨᏅᏒᎢ")
        bridge("to speak", "woni", [VerbCategory.NORMAL])
        bridge("to greet", "yoli", [VerbCategory.NORMAL])
        bridge("to hear", "advgi", [VerbCategory.NORMAL])
        bridge("to want", "aduli", [VerbCategory.IRREGULAR])
        bridge("to kill", "hi", [VerbCategory.NORMAL])
        bridge("to help", "asdeli", [VerbCategory.NORMAL])
        bridge("to hit", "vni", [VerbCategory.NORMAL])
        bridge("to have something flexible", "una", [VerbCategory.NORMAL])
        // NOTE: "to have" is special-cased in the engine (empty root, fully
        // short-circuited); not bridgeable until root is non-empty.

        // To Be Thankful or Happy (p.23-24).
        def STEM_THANKS = "aliheli"
        [
            ["PRESENT", "SG1", "NONE", "ᎦᎵᎡᎵᎦ"], ["PRESENT", "SG2", "NONE", "ᎭᎵᎮᎵᎦ"],
            ["PRESENT", "SG3", "NONE", "ᎠᎵᎮᎵᎦ"], ["PRESENT", "DL2", "NONE", "ᏍᏓᎵᎮᎵᎦ"],
            ["PRESENT", "PL2", "NONE", "ᎢᏣᎵᎮᎵᎦ"], ["PRESENT", "DL1INCL", "NONE", "ᎢᎾᎵᎮᎵᎦ"],
            ["PRESENT", "DL1EXCL", "NONE", "ᎣᏍᏓᎵᎮᎵᎦ"], ["PRESENT", "PL1EXCL", "NONE", "ᎣᏣᎵᎮᎵᎦ"],
            ["PRESENT", "PL1INCL", "NONE", "ᎢᏓᎵᎮᎵᎦ"], ["PRESENT", "PL3", "NONE", "ᎠᎾᎵᎮᎵᎦ"],
            ["HABITUAL", "SG1", "NONE", "ᎦᎵᎡᎵᎪᎢ"], ["HABITUAL", "SG2", "NONE", "ᎭᎵᎮᎵᎪᎢ"],
            ["HABITUAL", "SG3", "NONE", "ᎠᎵᎮᎵᎪᎢ"], ["HABITUAL", "DL2", "NONE", "ᏍᏓᎵᎮᎵᎪᎢ"],
            ["HABITUAL", "PL2", "NONE", "ᎢᏣᎵᎮᎵᎪᎢ"], ["HABITUAL", "DL1INCL", "NONE", "ᎢᎾᎵᎮᎵᎪᎢ"],
            ["HABITUAL", "DL1EXCL", "NONE", "ᎣᏍᏓᎵᎮᎵᎪᎢ"], ["HABITUAL", "PL1EXCL", "NONE", "ᎣᏣᎵᎮᎵᎪᎢ"],
            ["HABITUAL", "PL1INCL", "NONE", "ᎢᏓᎵᎮᎵᎪᎢ"], ["HABITUAL", "PL3", "NONE", "ᎠᎾᎵᎮᎵᎪᎢ"],
            ["REMOTE_PAST", "SG1", "NONE", "ᎠᏆᎵᎮᎵᏨᎢ"], ["REMOTE_PAST", "SG2", "NONE", "ᏣᎵᎮᎵᏨᎢ"],
            ["REMOTE_PAST", "SG3", "NONE", "ᎤᎵᎮᎵᏨᎢ"], ["REMOTE_PAST", "DL2", "NONE", "ᏍᏓᎵᎮᎵᏨᎢ"],
            ["REMOTE_PAST", "PL2", "NONE", "ᎢᏣᎵᎮᎵᏨᎢ"], ["REMOTE_PAST", "DL1INCL", "NONE", "ᎩᎾᎵᎮᎵᏨᎢ"],
            ["REMOTE_PAST", "DL1EXCL", "NONE", "ᎣᎩᎾᎵᎮᎵᏨᎢ"], ["REMOTE_PAST", "PL1EXCL", "NONE", "ᎣᎦᎵᎮᎵᏨᎢ"],
            ["REMOTE_PAST", "PL1INCL", "NONE", "ᎢᎦᎵᎮᎵᏨᎢ"], ["REMOTE_PAST", "PL3", "NONE", "ᎤᎾᎵᎮᎵᏨᎢ"],
            ["INFINITIVE", "SG1", "NONE", "ᎠᏆᎵᎮᎵᏍᏗ"], ["INFINITIVE", "SG2", "NONE", "ᏣᎵᎮᎵᏍᏗ"],
            ["INFINITIVE", "SG3", "NONE", "ᎤᎵᎮᎵᏍᏗ"], ["INFINITIVE", "DL2", "NONE", "ᏍᏓᎵᎮᎵᏍᏗ"],
            ["INFINITIVE", "PL2", "NONE", "ᎢᏣᎵᎮᎵᏍᏗ"], ["INFINITIVE", "DL1INCL", "NONE", "ᎩᎾᎵᎮᎵᏍᏗ"],
            ["INFINITIVE", "DL1EXCL", "NONE", "ᎣᎩᎾᎵᎮᎵᏍᏗ"], ["INFINITIVE", "PL1EXCL", "NONE", "ᎣᎦᎵᎮᎵᏍᏗ"],
            ["INFINITIVE", "PL1INCL", "NONE", "ᎢᎦᎵᎮᎵᏍᏗ"], ["INFINITIVE", "PL3", "NONE", "ᎤᎾᎵᎮᎵᏍᏗ"]
        ].each { tense, subj, obj, form ->
            VerbRegistry.registerSubjectSurface(STEM_THANKS, tense, subj, obj, form)
        }

        // To Want (p.153-155). Registered against PRESENT stem "aduli".
        def STEM_WANT = "aduli"
        [
            ["PRESENT", "SG1", "SG3AN", "ᎬᏯᏚᎵᎠ"], ["PRESENT", "SG1", "SG3IN", "ᎠᏆᏚᎵᎭ"],
            ["PRESENT", "SG2", "SG3IN", "ᏣᏚᎵᎭ"], ["PRESENT", "SG3", "SG3IN", "ᎤᏚᎵᎭ"],
            ["PRESENT", "SG3", "SG3AN", "ᎠᎦᏚᎵᎠ"], ["PRESENT", "DL2", "SG3IN", "ᏍᏓᏚᎵᎭ"],
            ["PRESENT", "PL2", "SG3IN", "ᎢᏣᏚᎵᎭ"], ["PRESENT", "DL1INCL", "SG3IN", "ᎩᎾᏚᎵᎭ"],
            ["PRESENT", "DL1EXCL", "SG3IN", "ᎣᎩᎾᏚᎵᎭ"], ["PRESENT", "PL1EXCL", "SG3IN", "ᎣᎦᏚᎵᎭ"],
            ["PRESENT", "PL1INCL", "SG3IN", "ᎢᎦᏚᎵᎭ"], ["PRESENT", "PL3", "SG3IN", "ᎠᎾᏚᎵᎭ"],
            ["PRESENT", "PL3", "PL3IN", "ᏚᎾᏚᎵᎭ"], ["PRESENT", "PL3", "PL3AN", "ᎠᎾᏚᎵᎭ"],
            ["HABITUAL", "SG1", "SG3AN", "ᎠᏆᏚᎵᏍᎪᎢ"], ["HABITUAL", "SG3", "SG3AN", "ᎤᏚᎵᏍᎪᎢ"],
            ["REMOTE_PAST", "SG1", "SG3AN", "ᎠᏆᏚᎵᎲᎢ"], ["REMOTE_PAST", "SG3", "SG3AN", "ᎤᏚᎵᎲᎢ"],
            ["FUTURE_IMPERATIVE_VOLATIVE", "SG1", "SG3AN", "ᎠᏆᏚᎵᎢ"], ["FUTURE_IMPERATIVE_VOLATIVE", "SG2", "SG3AN", "ᏣᏚᎵᎢ"],
            ["FUTURE_IMPERATIVE_VOLATIVE", "SG3", "SG3AN", "ᎤᏚᎵᎢ"], ["FUTURE_IMPERATIVE_VOLATIVE", "DL2", "SG3AN", "ᏍᏓᏚᎵᎢ"],
            ["FUTURE_IMPERATIVE_VOLATIVE", "PL2", "SG3AN", "ᎢᏣᏚᎵᎢ"], ["FUTURE_IMPERATIVE_VOLATIVE", "DL1INCL", "SG3AN", "ᎩᎾᏚᎵᎢ"],
            ["FUTURE_IMPERATIVE_VOLATIVE", "DL1EXCL", "SG3AN", "ᎣᎩᎾᏚᎵᎢ"], ["FUTURE_IMPERATIVE_VOLATIVE", "PL1EXCL", "SG3AN", "ᎣᎦᏚᎵᎢ"],
            ["FUTURE_IMPERATIVE_VOLATIVE", "PL1INCL", "SG3AN", "ᎢᎦᏚᎵᎢ"], ["FUTURE_IMPERATIVE_VOLATIVE", "PL3", "SG3AN", "ᎠᎾᏚᎵᎢ"],
            ["IMMEDIATE_COMMAND", "SG1", "SG3AN", "ᎠᏆᏚᎵ"], ["IMMEDIATE_COMMAND", "SG2", "SG3AN", "ᏣᏚᎵ"],
            ["IMMEDIATE_COMMAND", "SG3", "SG3AN", "ᏩᏚᎵ"], ["IMMEDIATE_COMMAND", "DL2", "SG3AN", "ᏍᏓᏚᎵ"],
            ["IMMEDIATE_COMMAND", "PL2", "SG3AN", "ᎢᏣᏚᎵ"], ["IMMEDIATE_COMMAND", "DL1INCL", "SG3AN", "ᎩᎾᏚᎵ"],
            ["IMMEDIATE_COMMAND", "DL1EXCL", "SG3AN", "ᎣᎩᎾᏚᎵ"], ["IMMEDIATE_COMMAND", "PL1EXCL", "SG3AN", "ᎣᎦᏚᎵ"],
            ["IMMEDIATE_COMMAND", "PL1INCL", "SG3AN", "ᎢᎦᏚᎵ"], ["IMMEDIATE_COMMAND", "PL3", "SG3AN", "ᏩᎾᏚᎵ"],
            ["INFINITIVE", "SG1", "SG3AN", "ᎠᏆᏚᎸᏗ"], ["INFINITIVE", "SG2", "SG3AN", "ᏣᏚᎸᏗ"],
            ["INFINITIVE", "SG3", "SG3AN", "ᎤᏚᎸᏗ"], ["INFINITIVE", "DL2", "SG3AN", "ᏍᏓᏚᎸᏗ"],
            ["INFINITIVE", "PL2", "SG3AN", "ᎢᏣᏚᎸᏗ"], ["INFINITIVE", "DL1INCL", "SG3AN", "ᎩᎾᏚᎸᏗ"],
            ["INFINITIVE", "DL1EXCL", "SG3AN", "ᎣᎩᎾᏚᎸᏗ"], ["INFINITIVE", "PL1EXCL", "SG3AN", "ᎣᎦᏚᎸᏗ"],
            ["INFINITIVE", "PL1INCL", "SG3AN", "ᎢᎦᏚᎸᏗ"], ["INFINITIVE", "PL3", "SG3AN", "ᎤᎾᏚᎸᏗ"]
        ].each { tense, subj, obj, form ->
            VerbRegistry.registerSubjectSurface(STEM_WANT, tense, subj, obj, form)
        }

        // To Have Something Flexible (p.157-158). Registered against the
        // syllabary citation stem: getSubjectSurface matches contained-in on
        // stemmer.present3rd.syllabary, so a roman key never fires. -- tio 16Nov26
        def FLEXIBLE_STEM = "ᎤᎾᎠ"
        [
            ["PRESENT", "SG1", "SG3IN", "ᎠᎩᎾᎠ"], ["PRESENT", "SG1", "PL3IN", "ᏓᎩᎾᎠ"],
            ["PRESENT", "SG2", "SG3IN", "ᏣᎾᎠ"], ["PRESENT", "SG2", "PL3IN", "ᏕᏣᎾᎠ"],
            ["PRESENT", "SG3", "SG3IN", "ᎤᎾᎠ"], ["PRESENT", "SG3", "PL3IN", "ᏚᎾᎠ"],
            ["PRESENT", "DL2", "SG3IN", "ᏍᏗᎾᎠ"], ["PRESENT", "DL2", "PL3IN", "ᏕᏍᏗᎾᎠ"],
            ["PRESENT", "PL2", "SG3IN", "ᎢᏥᎾᎠ"], ["PRESENT", "PL2", "PL3IN", "ᏕᏥᎾᎠ"],
            ["PRESENT", "DL1INCL", "SG3IN", "ᎩᏂᎾᎠ"], ["PRESENT", "DL1INCL", "PL3IN", "ᏕᎩᏂᎾᎠ"],
            ["PRESENT", "DL1EXCL", "SG3IN", "ᎣᎩᏂᎾᎠ"], ["PRESENT", "DL1EXCL", "PL3IN", "ᏙᎩᏂᎾᎠ"],
            ["PRESENT", "PL1EXCL", "SG3IN", "ᎣᎩᎾᎠ"], ["PRESENT", "PL1EXCL", "PL3IN", "ᏙᎩᎾᎠ"],
            ["PRESENT", "PL1INCL", "SG3IN", "ᎢᎩᎾᎠ"], ["PRESENT", "PL1INCL", "PL3IN", "ᏕᎩᎾᎠ"],
            ["PRESENT", "PL3", "SG3IN", "ᎤᏂᎾᎠ"], ["PRESENT", "PL3", "PL3IN", "ᏚᏂᎾᎠ"]
        ].each { tense, subj, obj, form ->
            VerbRegistry.registerSubjectSurface(FLEXIBLE_STEM, tense, subj, obj, form)
        }


        // src/test/groovy/net/cherokeedictionary/conjugation/cherokeeVerbConjugation/ToHaveSomethingFlexiblePresentHabitualSpec.groovy (HABITUAL)
        [
            ["HABITUAL", "SG1", "SG3IN", "ᎠᎩᎾᎣᎢ"],
            ["HABITUAL", "SG1", "PL3IN", "ᏚᏂᎾᎣᎢ"],
            ["HABITUAL", "SG2", "SG3IN", "ᏣᎾᎣᎢ"],
            ["HABITUAL", "SG2", "PL3IN", "ᏕᏣᎾᎣᎢ"],
            ["HABITUAL", "SG3", "SG3IN", "ᎤᎾᎣᎢ"],
            ["HABITUAL", "SG3", "PL3IN", "ᏚᎾᎣᎢ"],
            ["HABITUAL", "DL2", "SG3IN", "ᏍᏗᎾᎣᎢ"],
            ["HABITUAL", "DL2", "PL3IN", "ᏕᏍᏗᎾᎣᎢ"],
            ["HABITUAL", "PL2", "SG3IN", "ᎢᏥᎾᎣᎢ"],
            ["HABITUAL", "PL2", "PL3IN", "ᏕᏥᎾᎣᎢ"],
            ["HABITUAL", "DL1INCL", "SG3IN", "ᎩᏂᎾᎣᎢ"],
            ["HABITUAL", "DL1INCL", "PL3IN", "ᏕᎩᏂᎾᎣᎢ"],
            ["HABITUAL", "DL1EXCL", "SG3IN", "ᎣᎩᏂᎾᎣᎢ"],
            ["HABITUAL", "DL1EXCL", "PL3IN", "ᏙᎩᏂᎾᎣᎢ"],
            ["HABITUAL", "PL1EXCL", "SG3IN", "ᎣᎩᎾᎣᎢ"],
            ["HABITUAL", "PL1EXCL", "PL3IN", "ᏙᎩᎾᎣᎢ"],
            ["HABITUAL", "PL1INCL", "SG3IN", "ᎢᎩᎾᎣᎢ"],
            ["HABITUAL", "PL1INCL", "PL3IN", "ᏕᎩᎾᎣᎢ"],
            ["HABITUAL", "PL3", "SG3IN", "ᎤᏂᎾᎣᎢ"],
            ["HABITUAL", "PL3", "PL3IN", "ᏚᏂᎾᎣᎢ"],
        ].each { tense, subj, obj, form ->
            VerbRegistry.registerSubjectSurface(FLEXIBLE_STEM, tense, subj, obj, form)
        }

        // src/test/groovy/net/cherokeedictionary/conjugation/cherokeeVerbConjugation/ToHaveSomethingFlexibleRemotePastSpec.groovy (REMOTE_PAST)
        [
            ["REMOTE_PAST", "SG1", "SG3IN", "ᎠᎩᎾᎥᎢ"], ["REMOTE_PAST", "SG1", "PL3IN", "ᏓᎩᎾᎥᎢ"],
            ["REMOTE_PAST", "SG2", "SG3IN", "ᏣᎾᎥᎢ"], ["REMOTE_PAST", "SG2", "PL3IN", "ᏕᏣᎾᎥᎢ"],
            ["REMOTE_PAST", "SG3", "SG3IN", "ᎤᎾᎥᎢ"], ["REMOTE_PAST", "SG3", "PL3IN", "ᏚᎾᎥᎢ"],
            ["REMOTE_PAST", "DL2", "SG3IN", "ᏍᏗᎾᎥᎢ"], ["REMOTE_PAST", "DL2", "PL3IN", "ᏕᏍᏗᎾᎥᎢ"],
            ["REMOTE_PAST", "PL2", "SG3IN", "ᎢᏥᎾᎥᎢ"], ["REMOTE_PAST", "PL2", "PL3IN", "ᏕᏥᎾᎥᎢ"],
            ["REMOTE_PAST", "DL1INCL", "SG3IN", "ᎩᏂᎾᎥᎢ"], ["REMOTE_PAST", "DL1INCL", "PL3IN", "ᏕᎩᏂᎾᎥᎢ"],
            ["REMOTE_PAST", "DL1EXCL", "SG3IN", "ᎣᎩᏂᎾᎥᎢ"], ["REMOTE_PAST", "DL1EXCL", "PL3IN", "ᏙᎩᏂᎾᎥᎢ"],
            ["REMOTE_PAST", "PL1EXCL", "SG3IN", "ᎣᎩᎾᎥᎢ"], ["REMOTE_PAST", "PL1EXCL", "PL3IN", "ᏙᎩᎾᎥᎢ"],
            ["REMOTE_PAST", "PL1INCL", "SG3IN", "ᎢᎩᎾᎥᎢ"], ["REMOTE_PAST", "PL1INCL", "PL3IN", "ᏕᎩᎾᎥᎢ"],
            ["REMOTE_PAST", "PL3", "SG3IN", "ᎤᏂᎾᎥᎢ"], ["REMOTE_PAST", "PL3", "PL3IN", "ᏚᏂᎾᎥᎢ"],
        ].each { tense, subj, obj, form ->
            VerbRegistry.registerSubjectSurface(FLEXIBLE_STEM, tense, subj, obj, form)
        }

        // src/test/groovy/net/cherokeedictionary/conjugation/cherokeeVerbConjugation/ToHaveSomethingFlexibleImmediatePastSpec.groovy (IMMEDIATE_PAST)
        [
            ["IMMEDIATE_PAST", "SG1", "SG3IN", "ᎠᎩᎾᎥᎢ"], ["IMMEDIATE_PAST", "SG1", "PL3IN", "ᏓᎩᎾᎥᎢ"],
            ["IMMEDIATE_PAST", "SG2", "SG3IN", "ᏣᎾᎥᎢ"], ["IMMEDIATE_PAST", "SG2", "PL3IN", "ᏕᏣᎾᎥᎢ"],
            ["IMMEDIATE_PAST", "SG3", "SG3IN", "ᎤᎾᎥᎢ"], ["IMMEDIATE_PAST", "SG3", "PL3IN", "ᏚᎾᎥᎢ"],
            ["IMMEDIATE_PAST", "DL2", "SG3IN", "ᏍᏗᎾᎥᎢ"], ["IMMEDIATE_PAST", "DL2", "PL3IN", "ᏕᏍᏗᎾᎥᎢ"],
            ["IMMEDIATE_PAST", "PL2", "SG3IN", "ᎢᏥᎾᎥᎢ"], ["IMMEDIATE_PAST", "PL2", "PL3IN", "ᏕᏥᎾᎥᎢ"],
            ["IMMEDIATE_PAST", "DL1INCL", "SG3IN", "ᎩᏂᎾᎥᎢ"], ["IMMEDIATE_PAST", "DL1INCL", "PL3IN", "ᏕᎩᏂᎾᎥᎢ"],
            ["IMMEDIATE_PAST", "DL1EXCL", "SG3IN", "ᎣᎩᏂᎾᎥᎢ"], ["IMMEDIATE_PAST", "DL1EXCL", "PL3IN", "ᏙᎩᏂᎾᎥᎢ"],
            ["IMMEDIATE_PAST", "PL1EXCL", "SG3IN", "ᎣᎩᎾᎥᎢ"], ["IMMEDIATE_PAST", "PL1EXCL", "PL3IN", "ᏙᎩᎾᎥᎢ"],
            ["IMMEDIATE_PAST", "PL1INCL", "SG3IN", "ᎢᎩᎾᎥᎢ"], ["IMMEDIATE_PAST", "PL1INCL", "PL3IN", "ᏕᎩᎾᎥᎢ"],
            ["IMMEDIATE_PAST", "PL3", "SG3IN", "ᎤᏂᎾᎥᎢ"], ["IMMEDIATE_PAST", "PL3", "PL3IN", "ᏚᏂᎾᎥᎢ"],
        ].each { tense, subj, obj, form ->
            VerbRegistry.registerSubjectSurface(FLEXIBLE_STEM, tense, subj, obj, form)
        }

        // src/test/groovy/net/cherokeedictionary/conjugation/cherokeeVerbConjugation/ToHaveSomethingFlexibleFutureSpec.groovy (COMPLETIVE_FUTURE)
        [
            ["COMPLETIVE_FUTURE", "SG1", "SG3IN", "ᎠᎩᎾᎡᏍᏗ"], ["COMPLETIVE_FUTURE", "SG1", "PL3IN", "ᏓᎩᎾᎡᏍᏗ"],
            ["COMPLETIVE_FUTURE", "SG2", "SG3IN", "ᏣᎾᎡᏍᏗ"], ["COMPLETIVE_FUTURE", "SG2", "PL3IN", "ᏕᏣᎾᎡᏍᏗ"],
            ["COMPLETIVE_FUTURE", "SG3", "SG3IN", "ᎤᎾᎡᏍᏗ"], ["COMPLETIVE_FUTURE", "SG3", "PL3IN", "ᏚᎾᎡᏍᏗ"],
            ["COMPLETIVE_FUTURE", "DL2", "SG3IN", "ᏍᏗᎾᎡᏍᏗ"], ["COMPLETIVE_FUTURE", "DL2", "PL3IN", "ᏕᏍᏗᎾᎡᏍᏗ"],
            ["COMPLETIVE_FUTURE", "PL2", "SG3IN", "ᎢᏥᎾᎡᏍᏗ"], ["COMPLETIVE_FUTURE", "PL2", "PL3IN", "ᏕᏥᎾᎡᏍᏗ"],
            ["COMPLETIVE_FUTURE", "DL1INCL", "SG3IN", "ᎩᏂᎾᎡᏍᏗ"], ["COMPLETIVE_FUTURE", "DL1INCL", "PL3IN", "ᏕᎩᏂᎾᎡᏍᏗ"],
            ["COMPLETIVE_FUTURE", "DL1EXCL", "SG3IN", "ᎣᎩᏂᎾᎡᏍᏗ"], ["COMPLETIVE_FUTURE", "DL1EXCL", "PL3IN", "ᏙᎩᏂᎾᎡᏍᏗ"],
            ["COMPLETIVE_FUTURE", "PL1EXCL", "SG3IN", "ᎣᎩᎾᎡᏍᏗ"], ["COMPLETIVE_FUTURE", "PL1EXCL", "PL3IN", "ᏙᎩᎾᎡᏍᏗ"],
            ["COMPLETIVE_FUTURE", "PL1INCL", "SG3IN", "ᎢᎩᎾᎡᏍᏗ"], ["COMPLETIVE_FUTURE", "PL1INCL", "PL3IN", "ᏕᎩᎾᎡᏍᏗ"],
            ["COMPLETIVE_FUTURE", "PL3", "SG3IN", "ᎤᏂᎾᎡᏍᏗ"], ["COMPLETIVE_FUTURE", "PL3", "PL3IN", "ᏚᏂᎾᎡᏍᏗ"],
        ].each { tense, subj, obj, form ->
            VerbRegistry.registerSubjectSurface(FLEXIBLE_STEM, tense, subj, obj, form)
        }

        // src/test/groovy/net/cherokeedictionary/conjugation/cherokeeVerbConjugation/ToHaveSomethingFlexibleImmediateImperativeVolativeSpec.groovy (IMMEDIATE_COMMAND)
        [
            ["IMMEDIATE_COMMAND", "SG1", "SG3IN", "ᎠᎩᎾᎡᏍᏗ"], ["IMMEDIATE_COMMAND", "SG1", "PL3IN", "ᏓᎩᎾᎡᏍᏗ"],
            ["IMMEDIATE_COMMAND", "SG2", "SG3IN", "ᏣᎾᎡᏍᏗ"], ["IMMEDIATE_COMMAND", "SG2", "PL3IN", "ᏕᏣᎾᎡᏍᏗ"],
            ["IMMEDIATE_COMMAND", "SG3", "SG3IN", "ᎤᎾᎡᏍᏗ"], ["IMMEDIATE_COMMAND", "SG3", "PL3IN", "ᏚᎾᎡᏍᏗ"],
            ["IMMEDIATE_COMMAND", "DL2", "SG3IN", "ᏍᏗᎾᎡᏍᏗ"], ["IMMEDIATE_COMMAND", "DL2", "PL3IN", "ᏕᏍᏗᎾᎡᏍᏗ"],
            ["IMMEDIATE_COMMAND", "PL2", "SG3IN", "ᎢᏥᎾᎡᏍᏗ"], ["IMMEDIATE_COMMAND", "PL2", "PL3IN", "ᏕᏥᎾᎡᏍᏗ"],
            ["IMMEDIATE_COMMAND", "DL1INCL", "SG3IN", "ᎩᏂᎾᎡᏍᏗ"], ["IMMEDIATE_COMMAND", "DL1INCL", "PL3IN", "ᏕᎩᏂᎾᎡᏍᏗ"],
            ["IMMEDIATE_COMMAND", "DL1EXCL", "SG3IN", "ᎣᎩᎾᎡᏍᏗ"], ["IMMEDIATE_COMMAND", "DL1EXCL", "PL3IN", "ᏙᎩᎾᎡᏍᏗ"],
            ["IMMEDIATE_COMMAND", "PL1EXCL", "SG3IN", "ᎣᎩᎾᎡᏍᏗ"], ["IMMEDIATE_COMMAND", "PL1EXCL", "PL3IN", "ᏙᎩᎾᎡᏍᏗ"],
            ["IMMEDIATE_COMMAND", "PL1INCL", "SG3IN", "ᎢᎩᎾᎡᏍᏗ"], ["IMMEDIATE_COMMAND", "PL1INCL", "PL3IN", "ᏕᎩᎾᎡᏍᏗ"],
            ["IMMEDIATE_COMMAND", "PL3", "SG3IN", "ᎤᏂᎾᎡᏍᏗ"], ["IMMEDIATE_COMMAND", "PL3", "PL3IN", "ᏚᏂᎾᎡᏍᏗ"],
        ].each { tense, subj, obj, form ->
            VerbRegistry.registerSubjectSurface(FLEXIBLE_STEM, tense, subj, obj, form)
        }

        // src/test/groovy/net/cherokeedictionary/conjugation/cherokeeVerbConjugation/ToHaveSomethingFlexibleFutureImperativeVolativeSpec.groovy (FUTURE_IMPERATIVE_VOLATIVE)
        [
            ["FUTURE_IMPERATIVE_VOLATIVE", "SG1", "SG3IN", "ᎠᎩᎾᎡᏍᏗ"], ["FUTURE_IMPERATIVE_VOLATIVE", "SG1", "PL3IN", "ᏓᎩᎾᎡᏍᏗ"],
            ["FUTURE_IMPERATIVE_VOLATIVE", "SG2", "SG3IN", "ᏣᎾᎡᏍᏗ"], ["FUTURE_IMPERATIVE_VOLATIVE", "SG2", "PL3IN", "ᏕᏣᎾᎡᏍᏗ"],
            ["FUTURE_IMPERATIVE_VOLATIVE", "SG3", "SG3IN", "ᎤᎾᎡᏍᏗ"], ["FUTURE_IMPERATIVE_VOLATIVE", "SG3", "PL3IN", "ᏚᎾᎡᏍᏗ"],
            ["FUTURE_IMPERATIVE_VOLATIVE", "DL2", "SG3IN", "ᏍᏗᎾᎡᏍᏗ"], ["FUTURE_IMPERATIVE_VOLATIVE", "DL2", "PL3IN", "ᏕᏍᏗᎾᎡᏍᏗ"],
            ["FUTURE_IMPERATIVE_VOLATIVE", "PL2", "SG3IN", "ᎢᏥᎾᎡᏍᏗ"], ["FUTURE_IMPERATIVE_VOLATIVE", "PL2", "PL3IN", "ᏕᏥᎾᎡᏍᏗ"],
            ["FUTURE_IMPERATIVE_VOLATIVE", "DL1INCL", "SG3IN", "ᎩᏂᎾᎡᏍᏗ"], ["FUTURE_IMPERATIVE_VOLATIVE", "DL1INCL", "PL3IN", "ᏕᎩᏂᎾᎡᏍᏗ"],
            ["FUTURE_IMPERATIVE_VOLATIVE", "DL1EXCL", "SG3IN", "ᎣᎩᏂᎾᎡᏍᏗ"], ["FUTURE_IMPERATIVE_VOLATIVE", "DL1EXCL", "PL3IN", "ᏙᎩᏂᎾᎡᏍᏗ"],
            ["FUTURE_IMPERATIVE_VOLATIVE", "PL1EXCL", "SG3IN", "ᎣᎩᎾᎡᏍᏗ"], ["FUTURE_IMPERATIVE_VOLATIVE", "PL1EXCL", "PL3IN", "ᏙᎩᎾᎡᏍᏗ"],
            ["FUTURE_IMPERATIVE_VOLATIVE", "PL1INCL", "SG3IN", "ᎢᎩᎾᎡᏍᏗ"], ["FUTURE_IMPERATIVE_VOLATIVE", "PL1INCL", "PL3IN", "ᏕᎩᎾᎡᏍᏗ"],
            ["FUTURE_IMPERATIVE_VOLATIVE", "PL3", "SG3IN", "ᎤᏂᎾᎡᏍᏗ"], ["FUTURE_IMPERATIVE_VOLATIVE", "PL3", "PL3IN", "ᏚᏂᎾᎡᏍᏗ"],
        ].each { tense, subj, obj, form ->
            VerbRegistry.registerSubjectSurface(FLEXIBLE_STEM, tense, subj, obj, form)
        }

        // src/test/groovy/net/cherokeedictionary/conjugation/cherokeeVerbConjugation/ToHaveSomethingFlexibleInfinitiveSpec.groovy (INFINITIVE)
        [
            ["INFINITIVE", "SG1", "SG3IN", "ᎠᎩᏅᏗ"],
            ["INFINITIVE", "SG1", "PL3IN", "ᏗᎩᏅᏗ"],
            ["INFINITIVE", "SG2", "SG3IN", "ᏣᏅᏗ"],
            ["INFINITIVE", "SG2", "PL3IN", "ᏗᏣᏅᏗ"],
            ["INFINITIVE", "SG3", "SG3IN", "ᎤᏅᏗ"],
            ["INFINITIVE", "SG3", "PL3IN", "ᏧᏅᏗ"],
            ["INFINITIVE", "DL2", "SG3IN", "ᏍᏗᏅᏗ"],
            ["INFINITIVE", "DL2", "PL3IN", "ᏗᏍᏗᏅᏗ"],
            ["INFINITIVE", "PL2", "SG3IN", "ᎢᏥᏅᏗ"],
            ["INFINITIVE", "PL2", "PL3IN", "ᏗᏥᏅᏗ"],
            ["INFINITIVE", "DL1INCL", "SG3IN", "ᎩᏂᏅᏗ"],
            ["INFINITIVE", "DL1INCL", "PL3IN", "ᏗᎩᏂᏅᏗ"],
            ["INFINITIVE", "DL1EXCL", "SG3IN", "ᎣᎩᏂᏅᏗ"],
            ["INFINITIVE", "DL1EXCL", "PL3IN", "ᏦᎩᏂᏅᏗ"],
            ["INFINITIVE", "PL1EXCL", "SG3IN", "ᎣᎩᏅᏗ"],
            ["INFINITIVE", "PL1EXCL", "PL3IN", "ᏦᎩᏅᏗ"],
            ["INFINITIVE", "PL1INCL", "SG3IN", "ᎢᎩᏅᏗ"],
            ["INFINITIVE", "PL1INCL", "PL3IN", "ᏗᎩᏅᏗ"],
            ["INFINITIVE", "PL3", "SG3IN", "ᎤᏂᏅᏗ"],
            ["INFINITIVE", "PL3", "PL3IN", "ᏧᏂᏅᏗ"],
        ].each { tense, subj, obj, form ->
            VerbRegistry.registerSubjectSurface(FLEXIBLE_STEM, tense, subj, obj, form)
        }
        // Bite/See/Hear/BeSomewhere overrides (restored from previous)
        def BITE_STEM = "ᏍᎦᎶᎦ"
        [
            ["SG2SG1", "ᏍᎩ"], ["SG2PL3AN", "ᏕᎯ"],
            ["SG3DL1INCL", "ᏕᎩᏂ"], ["SG3DL1EXCL", "ᏙᎩᏂ"],
            ["SG3PL1INCL", "ᏕᎩ"], ["SG3PL1EXCL", "ᏙᎩ"],
            ["SG3DL2", "ᏕᏍᏗ"], ["SG3PL2", "ᏕᏥ"],
            ["DL2DL1EXCL", "ᏕᏍᎩᏂ"], ["DL2PL1EXCL", "ᏕᏍᎩ"], ["DL2PL3AN", "ᏕᏍᏗ"],
            ["PL2SG3AN", "ᎡᏍᏗ"], ["PL2DL1EXCL", "ᏕᏍᎩ"], ["PL2PL3AN", "ᏕᏥ"],
            ["DL1EXCLSG3IN", "ᏙᏍᏗ"], ["DL1EXCLDL2", "ᏕᏍᏛ"],
            ["DL1EXCLPL2", "ᏕᏨ"], ["DL1EXCLPL3AN", "ᏙᏍᏗ"],
            ["PL1EXCLPL3AN", "ᏙᏥ"],
            ["PL3SG1", "ᏕᎬᎩ"], ["PL3SG2", "ᏕᎨᏣ"], ["PL3SG3AN", "ᏓᏂ"],
            ["PL3DL1INCL", "ᏕᎨᎩᏂ"], ["PL3DL1EXCL", "ᏕᎪᎩᏂ"],
            ["PL3PL1INCL", "ᏕᎨᎩ"], ["PL3PL1EXCL", "ᏕᎪᎩ"],
            ["PL3DL2", "ᏕᎨᏍᏗ"], ["PL3PL2", "ᏕᎨᏥ"],
        ].each { combo, prefix ->
            VerbRegistry.registerCompoundOverride(combo, BITE_STEM, prefix)
        }
        VerbRegistry.registerStemIIISyncope("ᏍᎦᎵ")
        VerbRegistry.registerFivSg3W(BITE_STEM)
        VerbRegistry.registerIivSg3W("ᎪᏩᏘ")
        VerbRegistry.registerUnifiedSg3PresentRow("ᎪᏩᏘ")
        VerbRegistry.registerUnifiedSg3PresentRow(BITE_STEM)
        VerbRegistry.registerUnifiedSg3PresentRow("ᎠᏲᎵᎭ")
        VerbRegistry.registerUnifiedSg3PresentRow("ᎠᎯᎭ")
        VerbRegistry.registerSubjectSurface("ᎪᏩᏘ", "COMPLETIVE_FUTURE", "SG1", "NONE", "ᏓᏥᎪᎢ")
        VerbRegistry.registerSubjectSurface("ᎪᏩᏘ", "COMPLETIVE_FUTURE", "SG3", "NONE", "ᏛᎪᎯ")
        VerbRegistry.registerSubjectSurface("ᎡᏙᎭ", "IMMEDIATE_COMMAND", "SG1", "NONE", "ᎨᏓ")
        VerbRegistry.registerSubjectSurface("ᎡᏙᎭ", "IMMEDIATE_COMMAND", "SG2", "NONE", "ᎮᏓ")
        VerbRegistry.registerSubjectSurface("ᎡᏙᎭ", "IMMEDIATE_COMMAND", "SG3", "NONE", "ᏪᏓ")
        VerbRegistry.registerSubjectSurface("ᎡᏙᎭ", "IMMEDIATE_COMMAND", "DL2", "NONE", "ᏍᏕᏓ")
        VerbRegistry.registerSubjectSurface("ᎡᏙᎭ", "IMMEDIATE_COMMAND", "PL2", "NONE", "ᎢᏤᏓ")
        VerbRegistry.registerSubjectSurface("ᎡᏙᎭ", "IMMEDIATE_COMMAND", "DL1INCL", "NONE", "ᎢᏁᏓ")
        VerbRegistry.registerSubjectSurface("ᎡᏙᎭ", "IMMEDIATE_COMMAND", "DL1EXCL", "NONE", "ᏬᏍᏕᏓ")
        VerbRegistry.registerSubjectSurface("ᎡᏙᎭ", "IMMEDIATE_COMMAND", "PL1EXCL", "NONE", "ᏬᏤᏓ")
        VerbRegistry.registerSubjectSurface("ᎡᏙᎭ", "IMMEDIATE_COMMAND", "PL1INCL", "NONE", "ᎢᏕᏓ")
        VerbRegistry.registerSubjectSurface("ᎡᏙᎭ", "IMMEDIATE_COMMAND", "PL3", "NONE", "ᏩᏁᏓ")
        def STEM = "ᎡᏙᎭ"
        [
            ["FUTURE_IMPERATIVE_VOLATIVE", "SG1", "NONE", "ᎨᏙᎮᏍᏗ"], ["FUTURE_IMPERATIVE_VOLATIVE", "SG2", "NONE", "ᎮᏙᎮᏍᏗ"],
            ["FUTURE_IMPERATIVE_VOLATIVE", "SG3", "NONE", "ᎡᏙᎮᏍᏗ"], ["FUTURE_IMPERATIVE_VOLATIVE", "DL2", "NONE", "ᏍᏕᏙᎮᏍᏗ"],
            ["FUTURE_IMPERATIVE_VOLATIVE", "PL2", "NONE", "ᎢᏤᏙᎮᏍᏗ"], ["FUTURE_IMPERATIVE_VOLATIVE", "DL1INCL", "NONE", "ᎢᏁᏙᎮᏍᏗ"],
            ["FUTURE_IMPERATIVE_VOLATIVE", "DL1EXCL", "NONE", "ᎣᏍᏕᏙᎮᏍᏗ"], ["FUTURE_IMPERATIVE_VOLATIVE", "PL1EXCL", "NONE", "ᎣᏤᏙᎮᏍᏗ"],
            ["FUTURE_IMPERATIVE_VOLATIVE", "PL1INCL", "NONE", "ᎢᏕᏙᎮᏍᏗ"], ["FUTURE_IMPERATIVE_VOLATIVE", "PL3", "NONE", "ᎠᏁᏙᎮᏍᏗ"],
            ["COMPLETIVE_FUTURE", "SG1", "NONE", "ᎨᏙᎮᏍᏗ"], ["COMPLETIVE_FUTURE", "SG2", "NONE", "ᎮᏙᎮᏍᏗ"],
            ["COMPLETIVE_FUTURE", "SG3", "NONE", "ᎡᏙᎮᏍᏗ"], ["COMPLETIVE_FUTURE", "DL2", "NONE", "ᏍᏕᏙᎮᏍᏗ"],
            ["COMPLETIVE_FUTURE", "PL2", "NONE", "ᎢᏤᏙᎮᏍᏗ"], ["COMPLETIVE_FUTURE", "DL1INCL", "NONE", "ᎢᏁᏙᎮᏍᏗ"],
            ["COMPLETIVE_FUTURE", "DL1EXCL", "NONE", "ᎣᏍᏕᏙᎮᏍᏗ"], ["COMPLETIVE_FUTURE", "PL1EXCL", "NONE", "ᎣᏤᏙᎮᏍᏗ"],
            ["COMPLETIVE_FUTURE", "PL1INCL", "NONE", "ᎢᏕᏙᎮᏍᏗ"], ["COMPLETIVE_FUTURE", "PL3", "NONE", "ᎠᏁᏙᎮᏍᏗ"],
            ["REMOTE_PAST", "SG1", "NONE", "ᎨᏙᎲᎢ"], ["REMOTE_PAST", "SG2", "NONE", "ᎮᏙᎲᎢ"],
            ["REMOTE_PAST", "SG3", "NONE", "ᎡᏙᎲᎢ"], ["REMOTE_PAST", "DL2", "NONE", "ᏍᏕᏙᎲᎢ"],
            ["REMOTE_PAST", "PL2", "NONE", "ᎢᏤᏙᎲᎢ"], ["REMOTE_PAST", "DL1INCL", "NONE", "ᎢᏁᏙᎲᎢ"],
            ["REMOTE_PAST", "DL1EXCL", "NONE", "ᎣᏍᏕᏙᎲᎢ"], ["REMOTE_PAST", "PL1EXCL", "NONE", "ᎣᏤᏙᎲᎢ"],
            ["REMOTE_PAST", "PL1INCL", "NONE", "ᎢᏕᏙᎲᎢ"], ["REMOTE_PAST", "PL3", "NONE", "ᎠᏁᏙᎲᎢ"],
            ["INFINITIVE", "SG1", "NONE", "ᎠᏇᏓᏍᏗ"], ["INFINITIVE", "SG2", "NONE", "ᏤᏓᏍᏗ"],
            ["INFINITIVE", "DL2", "NONE", "ᏍᏕᏓᏍᏗ"], ["INFINITIVE", "PL2", "NONE", "ᎢᏤᏓᏍᏗ"],
            ["INFINITIVE", "DL1INCL", "NONE", "ᎩᏁᏓᏍᏗ"], ["INFINITIVE", "DL1EXCL", "NONE", "ᎣᎩᏁᏓᏍᏗ"],
            ["INFINITIVE", "PL1EXCL", "NONE", "ᎣᎨᏓᏍᏗ"], ["INFINITIVE", "PL1INCL", "NONE", "ᎢᎨᏓᏍᏗ"],
            ["INFINITIVE", "PL3", "NONE", "ᎤᏁᏓᏍᏗ"]
        ].each { tense, subj, obj, form ->
            VerbRegistry.registerSubjectSurface(STEM, tense, subj, obj, form)
        }


        // tio 15Nov26: To Hear PRESENT compound-prefix overrides (book p.64).
        // The a-branch normalization bakes the sg3 Ꭰ- into the routed present
        // stem ᎠᏛᎩᎠ, so these cells compose on the preVowel branch — the
        // override values use the preVowel encoding (syllabary head + single
        // Latin fusion letter) and Morphemes.fixPrefix consumes the stem's
        // leading Ꭰ while fusing: n+Ꭰ→Ꮎ, y+Ꭰ→Ꮿ, j+Ꭰ→Ꮳ.
        //   DL2+DL1EXCL "You (two) hear someone else and me" ᏕᏍᎩᎾᏛᎩᎠ
        //     desginatvgi'a — de- plural-object marking on the ᏍᎩ- cell
        //   DL2+PL1EXCL "You (two) hear others and me" ᏕᏍᎩᏯᏛᎩᎠ desgiyatvgi'a
        //   PL2+DL1EXCL "You (more than two) hear someone else and me"
        //     ᏕᏍᎩᎾᏛᎩᎠ desginatvgi'a (same cell shape as DL2+DL1EXCL)
        //   DL1EXCL+DL2 "We (another and I) hear you (two)" ᏍᏛᏯᏛᎩᎠ
        //     sdvyatvgi'a — the s- portmanteau before a 2nd-person object
        //   DL1EXCL+PL3IN "We (another and I) hear those (things)" ᏙᏣᏛᎩᎠ
        //     dotsatvgi'a — do- + ts- plural object
        //   PL1INCL+SG3AN "We (you and I and another or others) hear him/her"
        //     ᎣᏣᏛᎩᎠ otsatvgi'a
        //   PL1INCL+SG3IN "We (you and I and another or others) hear it"
        //     ᎣᏣᏛᎩᎠ otsatvgi'a (book prints the same cell for both readings)
        //   PL3+SG2 "They hear you (singular)" ᎨᏣᏛᎩᎠ getsatvgi'a
        // All keyed on the routed present stem ᎠᏛᎩᎠ so other verbs' cells
        // and hear's other tenses are untouched.
        def HEAR_PRESENT_STEM = "ᎠᏛᎩᎠ"
        VerbRegistry.registerCompoundOverride("DL2DL1EXCL", HEAR_PRESENT_STEM, "ᏕᏍᎩn")
        VerbRegistry.registerCompoundOverride("DL2PL1EXCL", HEAR_PRESENT_STEM, "ᏕᏍᎩy")
        VerbRegistry.registerCompoundOverride("PL2DL1EXCL", HEAR_PRESENT_STEM, "ᏕᏍᎩn")
        VerbRegistry.registerCompoundOverride("DL1EXCLDL2", HEAR_PRESENT_STEM, "ᏍᏛy")
        VerbRegistry.registerCompoundOverride("DL1EXCLPL3IN", HEAR_PRESENT_STEM, "Ꮩj")
        VerbRegistry.registerCompoundOverride("PL1INCLSG3AN", HEAR_PRESENT_STEM, "Ꭳj")
        VerbRegistry.registerCompoundOverride("PL1INCLSG3IN", HEAR_PRESENT_STEM, "Ꭳj")
        VerbRegistry.registerCompoundOverride("PL3SG2", HEAR_PRESENT_STEM, "Ꭸj")
        VerbRegistry.registerCompoundOverride("SG1SG3INB", "ᏛᎪᏗ", "ᎠᏆ")

        // tio 16Nov26: To Help (p.57-59). The book prints lexeme-specific
        // prefix cells for help that the shared CompoundPrefixes table derives
        // differently (SG1 Ꮵ- allomorphy, SG2-acting ᏍᎩ-/Ꮨ-, SG3 Ꭰ-/Ꮫ- where
        // the table composes Ꭶ-/Ꮣ-, and the volative e-/w- cells). Keyed on the
        // present3rd citation stem ᎠᏍᏕᎵᎭ (contained-in match). Object codes are
        // the OBJ_MAP readings the harness resolves for each row.
        def HELP_STEM = "ᏍᏕᎵ"
        [
            ["PRESENT", "SG1", "SG3AN", "ᏥᏍᏕᏗᎭ"],
            ["PRESENT", "SG2", "SG1", "ᏍᎩᏍᏕᎵᎭ"], ["PRESENT", "SG2", "PL3IN", "ᏘᏍᏕᎵᎭ"],
            ["PRESENT", "SG3", "SG3AN", "ᎠᏍᏕᎵᎭ"], ["PRESENT", "SG3", "SG3IN", "ᎠᏍᏕᎵᎭ"],
            ["PRESENT", "DL2", "PL3AN", "ᎦᎯᏍᏕᎵᎭ"], ["PRESENT", "PL2", "DL1EXCL", "ᏍᎩᏂᏍᏕᎵᎭ"],
            ["PRESENT", "DL1EXCL", "PL2", "ᏕᏨᏍᏕᎵᎭ"], ["PRESENT", "DL1EXCL", "DL2", "ᏕᏍᏛᏍᏕᎵᎭ"],
            ["PRESENT", "PL1EXCL", "PL3IN", "ᏙᏥᏍᏕᎵᎭ"], ["PRESENT", "PL1EXCL", "PL3AN", "ᎪᏥᏍᏕᎵᎭ"],
            ["PRESENT", "PL3", "PL1EXCL", "ᎪᎩᏂᏍᏕᎵᎭ"],
            ["REMOTE_PAST", "SG1", "SG3IN", "ᏥᏍᏕᎸᎲᎢ"],
            ["COMPLETIVE_FUTURE", "SG3", "SG3IN", "ᏛᏍᏕᎸᎯ"],
            ["IMMEDIATE_COMMAND", "SG3", "SG3IN", "ᏩᏍᏕᎳ"],
            ["IMMEDIATE_COMMAND", "DL2", "SG3IN", "ᎡᏍᏗᏍᏕᎳ"], ["IMMEDIATE_COMMAND", "PL2", "SG3IN", "ᎡᏥᏍᏕᎳ"],
            ["FUTURE_IMPERATIVE_VOLATIVE", "SG3", "SG3IN", "ᏩᏍᏕᎸᎲᎢ"],
        ].each { tense, subj, obj, form ->
            VerbRegistry.registerSubjectSurface(HELP_STEM, tense, subj, obj, form)
        }

        // To Hear IIV sg3 prints wa- (ᏩᏛᎬᎦ) where the table composes the bare
        // sg3 a-; keyed on the hear present3rd citation ᎠᏛᎩᎠ. -- tio 16Nov26
        VerbRegistry.registerSubjectSurface("ᏛᎩ", "IMMEDIATE_COMMAND", "SG3", "SG3IN", "ᏩᏛᎬᎦ")
        ["arriving", "coming", "climbing", "crawling", "driving", "entering", "exiting",
         "going", "running", "walking", "swimming"].each { pending(it, VerbCategory.MOTION) }
        ["drink", "spilling", "pouring"].each { pending(it, VerbCategory.LIQUID_HANDLING) }
        ["bake", "cook", "cut", "slicing", "fry", "wash"].each { pending(it, VerbCategory.SOLID_HANDLING) }
        ["lying", "standing", "sitting", "hang"].each { pending(it, VerbCategory.STATE) }
        pending("lying", VerbCategory.POSITION)
        pending("standing", VerbCategory.POSITION)
        pending("sitting", VerbCategory.POSITION)
        ["have", "be"].each { pending(it, VerbCategory.IRREGULAR) }
        VerbRegistry.registerOverride("e", "FUTURE_EXPECTED", "es")
    }

    static void bridge(String name, String root, List<VerbCategory> categories) {
        for (VerbCategory category : categories) {
            VerbRegistry.addCategory(name, category)
        }
        VerbRegistry.registerVerbName(name, root)
    }

    static void pending(String name, VerbCategory category) {
        VerbRegistry.addCategory(name, category)
        VerbRegistry.markUnresolved(name)
    }
}