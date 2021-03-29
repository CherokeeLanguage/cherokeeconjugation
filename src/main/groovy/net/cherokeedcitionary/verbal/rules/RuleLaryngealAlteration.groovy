package net.cherokeedcitionary.verbal.rules

import net.cherokeedcitionary.util.PrefixObject
import net.cherokeedcitionary.util.PrefixSubject
import net.cherokeedcitionary.util.Tense
import net.cherokeedcitionary.util.VerbSet

/**
 * Created by torr on 8/30/2015.
 * Montgomery Anderson section 3.2 pp 31, 83, 207
 *
 * basically that some pronominal prefixes change the stem from /h-/ to /glottal stop/
 */
class RuleLaryngealAlteration implements PrefixRule {
    @Override
    def process(PrefixSubject pts,
                PrefixObject pto,
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
            if (pto == PrefixObject.SG3AN && verbStem.startsWith("Ꭿ")) {

                if (pts == PrefixSubject.PL3) {
                    verbStem = "ᎯᎠ"
                } else {
                    verbStem = "Ꭲ" + verbStem.substring(1);
//            returnValue = returnPrefix + it
                }

                returnValue = prefix + verbStem
            } else if ((pto == PrefixObject.PL3AN || pto == PrefixObject.PL3IN) && verbStem.startsWith("Ꭿ")) {

                if ((pts == PrefixSubject.PL3 || pts == PrefixSubject.SG3)) {
                    verbStem = "ᎯᎠ"
                } else {
                    verbStem = "Ꭲ" + verbStem.substring(1);
                }

                returnValue = prefix + verbStem
            }
        }

        return returnValue
    }
}
