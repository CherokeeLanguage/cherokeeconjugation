package cherokee.dictionary.conjugation.rules

import cherokee.dictionary.conjugation.conjugate.PrefixTableObject
import cherokee.dictionary.conjugation.conjugate.PrefixTableSubject
import cherokee.dictionary.conjugation.conjugate.Tense
import cherokee.dictionary.conjugation.conjugate.VerbSet

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

        def returnValue

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
                verbStem = "Ꭲ" + verbStem.substring(1);
            }

            returnValue = prefix + verbStem
        }

        return returnValue
    }
}
