package net.cherokeedictionary.conjugation.grammarGuide

import spock.lang.Specification
import spock.lang.Unroll

class GrammarGuideSpec3 extends Specification {

    @Unroll
    def "Example Sentence / Verbal Form: #syllabary (#phonetic) -> #translation"() {
        expect:
        syllabary != null && !syllabary.trim().isEmpty()
        phonetic != null && !phonetic.trim().isEmpty()
        translation != null && !translation.trim().isEmpty()

        where:
        syllabary                       | phonetic                          | translation
        // -------------------------------------------------------------------------
        // A Second Passive Construction: Active vs. Passive Contrasts
        // -------------------------------------------------------------------------
        "ᎠᎨᏯ ᎠᎪᏩᏘᎭ ᎠᏍᎦᏯ."               | "ạ²ge²³hya a¹gowh²tị³ha ạ²sgạ²ya."               | "A man sees a woman."
        "ᎠᏍᎦᏯ ᎤᎪᏩᏘᎭ ᎠᎨᏯ."               | "ạ²sgạ²ya u¹gowh²tị³ha ạ¹ge²³hya."               | "A woman is being seen by a man."
        "ᎠᎨᏯ ᎤᎪᏩᏘᎭ ᎠᏍᎦᏯ."               | "ạ²ge²³hya u¹gowh²tv²hv²³ʔi ạ²sgạ²ya."           | "A man saw a woman."
        
        // Impersonal / Inanimate Agent Variations
        "ᎠᎦᏍᎦ."                         | "a¹ga²sga."                                      | "It's raining ."
        "ᎤᎦᏍᎦ."                         | "u¹ga²sga."                                      | "It's raining on him."

        // Four Third-Person Combinations (Stem-initial consonant)
        "ᎠᏍᎦᏯ ᎤᎪᏩᏘᎭ ᎩᏟ."               | "ạ²sgạ²ya u¹gowh²tị³ha gi²hli."                   | "A dog is being seen by a man."
        "ᎠᏍᎦᏯ ᎤᏂᎪᏩᏘᎭ ᎩᏟ."              | "ạ²sgạ²ya u¹ni²gowh²tị³ha² gi²hli."               | "Dogs are being seen by a man."
        "ᎠᏂᏍᎦᏯ ᎬᏩᎪᏩᏘᎭ ᎩᏟ."             | "ạ²ni²sgạ²ya gv²wạ²gowh²tị³ha gi²hli."            | "A dog is being seen by men."
        "ᎠᏂᏍᎦᏯ ᎬᏩᏂᎪᏩᏘᎭ ᎩᏟ."            | "ạ²ni²sgạ²ya gv²wạ²ni²gowh²tị³ha gi²hli."         | "Dogs are being seen by men."

        // Four Third-Person Combinations (Stem-initial vowel with plural acts)
        "ᎠᏍᎦᏯ ᎤᏩᏂ ᎩᏟ."                   | "ạ²sgạ²ya u¹wa²hni gi²hli."                       | "A dog is being hit by a man."
        "ᎠᏍᎦᏯ ᏚᏅᏂ ᎩᏟ."                   | "ạ²sgạ²ya du¹nv²hni gi²hli."                      | "Dogs are being hit by a man."
        "ᎠᏂᏍᎦᏯ ᏕᎬᏩᏂ ᎩᏟ."                 | "ạ²ni²sgạ²ya de²gv³wa²hni gi²hli."                | "A dog is being hit by men."
        "ᎠᏂᏍᎦᏯ ᏕᎬᏩᏅᏂ ᎩᏟ."                | "ạ²ni²sgạ²ya de²gv³wạ²nv²hni gi²hli."             | "Dogs are being hit by men."

        // -------------------------------------------------------------------------
        // A Third Passive Construction (Without Human Agent / Mediopassive)
        // -------------------------------------------------------------------------
        "ᎪᏪᎵᎠ."                        | "go²hwe²³lị³ʔa."                                  | "He's writing it."
        "ᎠᏩᏙᏪᎵᎠ."                      | "a¹do²hwe²³lị³ʔa."                                | "It's being written."
        "ᎠᏍᎪᎸᏗᎠ."                      | "a¹sgo²³lv³dị²ʔa."                                | "He's erasing it."
        "ᎠᎵᏍᎪᎸᏗᎠ."                      | "al¹sgo²³lv³dị²ʔa."                               | "It's erasing itself."
        "ᎠᎬᎭᎵᎭ."                        | "a¹gv²hạ²lị³ha."                                  | "He's cutting it out."
        "ᎠᎵᎬᎭᎵᎭ."                      | "a¹lị²gv²hạ²lị³ha."                               | "It's cutting itself out."
        "ᎠᏑᏫᏍᎦ."                        | "a¹su²³hwị³sga."                                  | "He's painting it."
        "ᎠᎵᏑᏫᏍᎦ."                      | "al¹su²³hwị³sga."                                 | "It's being painted. or It's painting itself."
        "ᎣᏍᏗᏍ ᎠᎵᏑᏫᏍᎦ?"                  | "o⁴sdas al¹su²³hwị³sga?"                          | "Is the painting going well?"

        // -------------------------------------------------------------------------
        // Classificatory Verbs (Object / Subject Shape Classes)
        // -------------------------------------------------------------------------
        // "Leaving behind"
        "ᎦᎧᎯᏯᎠ."                        | "ga²kạ²hi²yạ³ʔa."                                 | "He's leaving a living thing behind."
        "ᎦᏁᎯᏯᎠ."                        | "gạ²ne²hi²yạ³ʔa."                                 | "He's leaving a container of liquid behind."
        "ᎠᏗᏏᏯᎠ."                        | "a¹di³²si²yạ³ʔa."                                 | "He's leaving a long object behind."
        "ᎦᏂᏯᎠ."                         | "gạʔ³ni²yạ³ʔa."                                   | "He's leaving a flexible object behind."
        "ᎠᎯᏯᎠ."                         | "a¹hi²yạ³ʔa."                                     | "He's leaving it behind."

        // "Lying"
        "ᎦᏅᎦ."                          | "ganh²ga."                                        | "A living thing is lying."
        "ᎦᏁᎭ."                          | "gạ²nẹ³ha."                                       | "A container of liquid is lying."
        "ᏥᏯ."                           | "ji²³ya."                                         | "A long object is lying."
        "ᎦᎾᎠ."                          | "gạ²nạ³ʔa."                                       | "A flexible object is lying."
        "ᎠᎭ."                           | "a¹ha."                                           | "It's lying."
    }

    @Unroll
    def "Prefix Morphological Matrix: #person (#number) -> #vowelBefore / #consonantBefore"() {
        expect:
        person != null
        number != null
        vowelBefore != null
        consonantBefore != null

        where:
        person         | number                     | vowelBefore | consonantBefore
        // Section I-E, Figure 1: Passive Prefixes with Unspecified Actor
        "1st person"   | "singular"                 | "vgw-"      | "vgi-"
        "1st person"   | "dual inclusive"           | "egin-"     | "egini-"
        "1st person"   | "dual exclusive"           | "ogin-"     | "ogini-"
        "1st person"   | "plural inclusive"         | "eg-"       | "egi-"
        "1st person"   | "plural exclusive"         | "og-"       | "ogi-"
        "2nd person"   | "singular"                 | "ej-"       | "eja-"
        "2nd person"   | "dual"                     | "esd-"      | "esdi-"
        "2nd person"   | "plural"                   | "ej-"       | "eji-"
        "3rd person"   | "singular"                 | "ag-"       | "aji-"
        "3rd person"   | "plural"                   | "geg-"      | "geji-"
    }
}