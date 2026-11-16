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
            ["HABITUAL", "PL1INCL", "ᎢᏓᎵᎮᎵᎪᎢ"], ["HABITUAL", "PL3", "NONE", "ᎠᎾᎵᎮᎵᎪᎢ"],
            ["REMOTE_PAST", "SG1", "NONE", "ᎠᏆᎵᎮᎵᏨᎢ"], ["REMOTE_PAST", "SG2", "NONE", "ᏣᎵᎮᎵᏨᎢ"],
            ["REMOTE_PAST", "SG3", "NONE", "ᎤᎵᎮᎵᏨᎢ"], ["REMOTE_PAST", "DL2", "NONE", "ᏍᏓᎵᎮᎵᏨᎢ"],
            ["REMOTE_PAST", "PL2", "ᎢᏣᎵᎮᎵᏨᎢ"], ["REMOTE_PAST", "DL1INCL", "NONE", "ᎩᎾᎵᎮᎵᏨᎢ"],
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
            ["INFINITIVE", "SG1", "SG3AN", "ᎠᏆᏚᎸᏗ"], ["INFINITIVE", "SG2", "ᏣᏚᎸᏗ"],
            ["INFINITIVE", "SG3", "SG3AN", "ᎤᏚᎸᏗ"], ["INFINITIVE", "DL2", "SG3AN", "ᏍᏓᏚᎸᏗ"],
            ["INFINITIVE", "PL2", "SG3AN", "ᎢᏣᏚᎸᏗ"], ["INFINITIVE", "DL1INCL", "SG3AN", "ᎩᎾᏚᎸᏗ"],
            ["INFINITIVE", "DL1EXCL", "SG3AN", "ᎣᎩᎾᏚᎸᏗ"], ["INFINITIVE", "PL1EXCL", "SG3AN", "ᎣᎦᏚᎸᏗ"],
            ["INFINITIVE", "PL1INCL", "SG3AN", "ᎢᎦᏚᎸᏗ"], ["INFINITIVE", "PL3", "SG3AN", "ᎤᎾᏚᎸᏗ"]
        ].each { tense, subj, obj, form ->
            VerbRegistry.registerSubjectSurface(STEM_WANT, tense, subj, obj, form)
        }

        // To Have Something Flexible (p.157-158). Registered against stem "una".
        def FLEXIBLE_STEM = "una"
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