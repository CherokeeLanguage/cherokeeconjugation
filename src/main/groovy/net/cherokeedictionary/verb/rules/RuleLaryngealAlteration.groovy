package net.cherokeedictionary.verb.rules

import net.cherokeedictionary.util.PrefixTableObject
import net.cherokeedictionary.util.PrefixTableSubject
import net.cherokeedictionary.util.Tense
import net.cherokeedictionary.util.VerbSet


/**
 * Created by torr on 8/30/2015.
 * Montgomery Anderson section 3.2 pp 31, 83, 207
 *
 * basically that some pronominal prefixes change the stem from /h-/ to /glottal stop/
 */
class RuleLaryngealAlteration implements PrefixRule {
    @Override
    def process(PrefixTableSubject pts,
                PrefixTableObject pto,
                String prefix,
                Tense tense,
                boolean isLiquid,
                String verbStem,
                VerbSet verbSet) {
//        //Montgomery-Anderson pp 208 -- 'No Set B prefixes trigger it [Laryngeal alternation].
//        if (verbSet == VerbSet.B) {
//            println "right here in verbset b"
//            return verbStem;
//        }

        def returnValue = ""

        if (verbStem != null) {
            //M-A pp 209 -- "In Oklahoma Cherokee all of the Set A animate object prefixes trigger the alternation."
            if (pto == PrefixTableObject.SG3AN && verbStem.startsWith("Ꭿ")) {

                if (pts == PrefixTableSubject.PL3) {
                    verbStem = "ᎯᎠ"
                } else {
                    verbStem = "Ꭲ" + verbStem.substring(1);
//            returnValue = returnPrefix + it
                }

                returnValue = prefix + verbStem
            } else if ((pto == PrefixTableObject.PL3AN || pto == PrefixTableObject.PL3IN) && verbStem.startsWith("Ꭿ")) {

                if ((pts == PrefixTableSubject.PL3 || pts == PrefixTableSubject.SG3)) {
                    verbStem = "ᎯᎠ"
                } else {
                    // timo 10Nov26: do NOT apply the h->glottal alteration for the
                    // remaining subjects with a plural object. The user's tests
                    // (ConjugatePresentTense.testKillPresent: SG1PL3AN ᎦᏥᎯᎭ,
                    // SG2PL3AN ᎦᎯᎯᎭ, DL1INCLPL3AN ᎨᏂᎯᎭ, DL1EXCLPL3AN ᎪᏍᏗᎯᎭ,
                    // PL1INCLPL3AN ᎨᏗᎯᎭ, PL1EXCLPL3AN ᎪᏥᎯᎭ, PL2PL3AN ᎨᏥᎯᎭ) keep
                    // the stem-initial Ꭿ — the old determineVerbSet forced-Set-B
                    // routing masked this branch (Set B skips laryngeal entirely),
                    // and its forced Ꭲ- rewrite produced ᎦᏥᎢᎭ/ᎪᏍᏗᎢᎭ. Return ""
                    // so processPrefixes falls through to the plain prefix+stem.
                    return ""
                }

                returnValue = prefix + verbStem
            }
        }

        return returnValue
    }
}
