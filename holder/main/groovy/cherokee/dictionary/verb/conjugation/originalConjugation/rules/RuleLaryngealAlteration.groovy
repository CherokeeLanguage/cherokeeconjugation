package cherokee.dictionary.verb.conjugation.originalconjugation.rules

import cherokee.conjugation.verbal.containers.VerbPrefixTableObject
import cherokee.conjugation.verbal.containers.VerbPrefixTableSubject
import cherokee.conjugation.verbal.enums.Tense
import cherokee.conjugation.verbal.enums.VerbSet

/**
 * Created by torr on 8/30/2015.
 * Montgomery Anderson section 3.2 pp 31, 83, 207
 *
 * basically that some pronominal prefixes change the stem from /h-/ to /glottal stop/
 */
class RuleLaryngealAlteration implements PrefixRule {
    @Override
    def process(VerbPrefixTableSubject pts,
                VerbPrefixTableObject pto,
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
            if (pto == VerbPrefixTableObject.SG3AN && verbStem.startsWith("Ꭿ")) {

                if (pts == VerbPrefixTableSubject.PL3) {
                    verbStem = "ᎯᎠ"
                } else {
                    verbStem = "Ꭲ" + verbStem.substring(1);
//            returnValue = returnPrefix + it
                }

                returnValue = prefix + verbStem
            } else if ((pto == VerbPrefixTableObject.PL3AN || pto == VerbPrefixTableObject.PL3IN) && verbStem.startsWith("Ꭿ")) {

                if ((pts == VerbPrefixTableSubject.PL3 || pts == VerbPrefixTableSubject.SG3)) {
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
