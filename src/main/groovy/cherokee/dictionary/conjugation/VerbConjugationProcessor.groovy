package cherokee.dictionary.conjugation
import cherokee.dictionary.conjugation.conjugate.CompoundPrefix
import cherokee.dictionary.conjugation.conjugate.CompoundPrefixes
import cherokee.dictionary.conjugation.conjugate.Morphemes
import cherokee.dictionary.conjugation.conjugate.Prefix
import cherokee.dictionary.conjugation.conjugate.PrefixTableObject
import cherokee.dictionary.conjugation.conjugate.PrefixTableSubject
import cherokee.dictionary.conjugation.conjugate.Tense
import cherokee.dictionary.conjugation.conjugate.VerbSet
import cherokee.dictionary.conjugation.conjugate.VerbType
import cherokee.dictionary.conjugation.rules.RulesProcessor
import cherokee.dictionary.conjugation.stem.Stemmer
import cherokee.dictionary.conjugation.stem.VerbTenseHolder

/**
 * Created by torr on 8/23/2015.
 */
class VerbConjugationProcessor {
    public void log(prints) {
        boolean isDebug = false;
        if (isDebug) {
            println prints
        }
    }

    def processPrefixes(//final PronominalPrefix pref,
                            final CompoundPrefix pref,
                            final VerbSet verbset,
                            String it ) {
        def returnPrefix = "";

        def vs = verbset == VerbSet.A ? "" : "B"
        def verbPrefix = pref?.prefix2 ? "${pref?.prefix1}${pref?.prefix2}${vs}" as String : "${pref?.prefix1}${vs}" as String;

        if (it.startsWith("Ꭰ")
            || it.startsWith("Ꭱ")
            || it.startsWith("Ꭲ")
            || it.startsWith("Ꭳ")
            || it.startsWith("Ꭴ")
            || it.startsWith("Ꭵ")) {

            //get the prefix from the table
            def tmpReturnPrefix = ((Prefix) CompoundPrefixes.prefixes.get(verbPrefix))

            if (!tmpReturnPrefix) {
                tmpReturnPrefix = ((Prefix) CompoundPrefixes.prefixes.get(verbPrefix.substring(0, verbPrefix.size() - 1)))
            }

            tmpReturnPrefix = tmpReturnPrefix?.preVowel

            if (tmpReturnPrefix) {
                //determine if last 1 or 2 characters need to be included in the conversion
                //if ends with gw then 2 - otherwise only 1
                def backspace = 1 //this is the count back that we need to get to the latin characters of the prefix
                if (tmpReturnPrefix.endsWith("gw")) {
                    backspace = 2
                }

                def prefixStart = tmpReturnPrefix.substring(0, tmpReturnPrefix.size() - backspace)
                log prefixStart

                def prefixEnd = tmpReturnPrefix.substring(tmpReturnPrefix.size() - backspace)
                log prefixEnd

                def fixedPrefix = Morphemes.fixPrefix(it.substring(0, 1), prefixEnd, it)
                log(fixedPrefix)

                returnPrefix = prefixStart + fixedPrefix[0]
                it = fixedPrefix[1]
            }
        } else {
            returnPrefix = ((Prefix) CompoundPrefixes.prefixes.get(verbPrefix))?.preConsonant

            if (!returnPrefix) {
                //remove the 'B'? why is this here?
                verbPrefix = verbPrefix.substring(0, verbPrefix.size() - 1)

                returnPrefix = ((Prefix) CompoundPrefixes.prefixes.get(verbPrefix))?.preConsonant
            }
        }

        if (!returnPrefix) {
            it = ""
        }

        return returnPrefix + it
    }

    def process(final String subject,
                String object,
                final Stemmer stemmer,
                final String tense,
                final VerbType verbType) {
        VerbTenseHolder vth = new VerbTenseHolder(stemmer: stemmer)
        vth.process()

        //this column matches - so intransitive specific code was removed in favor of using existing code and keys
        if (verbType == VerbType.INTRANSITIVE) {
            object = "SG3IN"
        }

        def combinedSubjectObject = "${subject}${object}"//object ? "${subject}${object}" : "${subject}"

        if (combinedSubjectObject == "SG3SG3AN") {
            return stemmer.present3rd.syllabary;
        }

        def verbTense = Tense.valueOf(tense);

        def verbset = VerbSet.A

        //if du,nu,u,wu in 3rd sing present then set b rest are a
        def tempPresent3rd = stemmer.present3rd.syllabary
        if (tempPresent3rd.startsWith("Ꮪ")
                || tempPresent3rd.startsWith("Ꮔ")
                || tempPresent3rd.startsWith("Ꭴ")
                || tempPresent3rd.startsWith("Ꮽ")) {
            verbset = VerbSet.B
        }

        String verbToConjugate = ""

        switch (verbTense) {
            case Tense.PRESENT:
                verbToConjugate = vth.present;
                break;
            case Tense.REMOTE_PAST:
                verbToConjugate = vth.remotePast
                //remote past always starts with B - Durbin Feeling book pp21
                verbset = VerbSet.B
                break;
            case Tense.FUTURE_COMMAND:
                verbToConjugate = vth.futureCommand
                break;
            case Tense.HABITUAL:
                verbToConjugate = vth.habitual
                break;
            case Tense.INFINITIVE:
                verbToConjugate = vth.infinitive
                break;
        }

        def compoundPrefix

        try {
            if (verbset == VerbSet.B) {
                try {
                    compoundPrefix = CompoundPrefixes."${combinedSubjectObject}B"
                } catch (Exception e) {
                    compoundPrefix = CompoundPrefixes."${combinedSubjectObject}"
                }
            } else {
                compoundPrefix = CompoundPrefixes."${combinedSubjectObject}"
            }
        } catch (Exception e) {
            //todo: need to throw this exception back out if anything goes wrong
            //todo: create new exception class to be thrown so we get the message back out
            compoundPrefix = null;
            throw e;
        }

        if (!compoundPrefix) {
            return null;
        }

        def returnValue = ""
        def presentTense = processPrefixes(compoundPrefix, verbset, verbToConjugate)

        //is this only run when the verb is Transitive?
        if (verbType == VerbType.TRANSITIVE) {
            presentTense = new RulesProcessor().processRules(null, null, PrefixTableSubject.valueOf(subject), PrefixTableObject.valueOf(object), Tense.valueOf(tense), false, presentTense, verbset)
        }

        if (presentTense) {
            returnValue = presentTense
        }

        return returnValue
    }
}