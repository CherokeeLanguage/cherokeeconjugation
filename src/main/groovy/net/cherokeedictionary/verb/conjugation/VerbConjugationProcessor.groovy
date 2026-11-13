package net.cherokeedictionary.verb.conjugation

import net.cherokeedictionary.core.Verb
import net.cherokeedictionary.stemmer.Stemmer
import net.cherokeedictionary.util.CompoundPrefix
import net.cherokeedictionary.util.CompoundPrefixes
import net.cherokeedictionary.util.Morphemes
import net.cherokeedictionary.util.PartOfSpeech
import net.cherokeedictionary.util.Prefix
import net.cherokeedictionary.util.PrefixTableObject
import net.cherokeedictionary.util.PrefixTableSubject
import net.cherokeedictionary.util.StringUtility
import net.cherokeedictionary.util.Tense
import net.cherokeedictionary.util.VerbSet
import net.cherokeedictionary.verb.metadata.VerbRegistry
import net.cherokeedictionary.verb.affixes.ReflexivePrefix
import net.cherokeedictionary.verb.rules.RuleLaryngealAlteration
import net.cherokeedictionary.verb.rules.RuleUW
import net.cherokeedictionary.verb.rules.RuleVtoA

/**
 * Created by torr on 8/23/2015.
 */
class VerbConjugationProcessor {
    static void log(prints) {
        boolean isDebug = true;
        if (isDebug) {
            println prints
        }
    }

    static def processPrefixes(//final PronominalPrefix pref,
                               final Verb verb,
                               String it ) {
        println "DEBUG: it=${it}"
        def returnPrefix = "";

        final CompoundPrefix pref = verb.compoundPrefix
        final VerbSet verbset = verb.verbset
        final Tense tense = verb.tense

        // tio 12Nov26: Stem III i-syncope, REGISTRY-GATED. The -its- class stems
        // lose their i before the ts+v'i/ts+i tail in composed past/future forms:
        // book p.29 To Bite prints remote SG1 "tsisgahltsv'i" ᏥᏍᎦᎶᏨᎢ (not
        // *ᏥᏍᎦᎵᏨᎢ), future "datsisgaltsi" ᏓᏥᏍᎦᎶᏥ, FIV "hisgaltsv'i" ᎯᏍᎦᎶᏨᎢ.
        // This is LEXEME-level allomorphy, not a global rule: "to be happy"
        // Aliheliga keeps its stem-final li (remote "agwalihelijvi" ᎠᏆᎵᎮᎵᏨᎢ) with
        // a surface-identical ᎵᏨᎢ tail, and the guide explicitly disclaims the
        // rule ("Further study of the language is needed to determine the
        // precise nature of the rules which govern the dropping of vowels",
        // hold1.txt preface). So syncope fires only for verbs whose
        // -its/-is-class stems are registered in VerbRegistry (by routed stem
        // prefix), and NEVER on the sg3 + sg3-object REMOTE_PAST row — the
        // dictionary citation form keeps the i (ᎤᏍᎦᎵᏨᎢ) even for registered
        // verbs, while every other composed row elides it. Glyph-level:
        // Ꮅ (li) -> Ꮆ (l) when directly followed by Ꮸ (tsv) or Ꮵ (tsi).
        if ((tense == Tense.REMOTE_PAST
                || tense == Tense.COMPLETIVE_FUTURE
                || tense == Tense.FUTURE_COMMAND)
                && !(tense == Tense.REMOTE_PAST
                     && pref?.prefix1 == PrefixTableSubject.SG3
                     && (pref?.prefix2 == PrefixTableObject.SG3AN
                         || pref?.prefix2 == PrefixTableObject.SG3IN))
                && VerbRegistry.isStemIIISyncopeStem(it)) {
            it = it.replaceAll("Ꮅ(?=[ᏨᏥ])", "Ꮆ")
        }

        def vs = verbset == VerbSet.A ? "" : "B"
        def verbPrefix = pref?.prefix2 ? "${pref?.prefix1}${pref?.prefix2}${vs}" as String : "${pref?.prefix1}${vs}" as String;

        // B4 (Feeling P4 notes): Set B + 3rd person subject + inanimate object +
        // v-initial stem: stem-initial Ꭵ surfaces as Ꭰ before the prefix merge
        // (ᎤᏩᎨᏩᏍᎦ uwakewsga "he's forgetting it", vs ᎬᎨᏩᏍᎦ gv-kewsga "him").
        // P4(6) notes "-w- is inserted between u- and a following vowel" for these
        // forms, so the uw+a -> u contraction (RuleUW, e.g. ᎤᏚᎵᎭ for want) does
        // NOT apply when the a came from the changed -v-. timo 10Nov26
        def vtoAStem = RuleVtoA.apply(pref?.prefix1, pref?.prefix2, verbset, it)
        boolean stemWasVtoA = (vtoAStem != null)
        if (stemWasVtoA) {
            it = vtoAStem
        }

        def returnValue

        if (it != null && StringUtility.startsWithVowelSyllabary(it)) {
            //get the prefix from the table
            def tmpReturnPrefix = ((Prefix) CompoundPrefixes.prefixes.get(verbPrefix))

            // timo 10Nov26: key-absent vs declared-empty are now distinguished.
            // A key absent from the map (either set) surfaces as MISSING_ENTRY so
            // the gap is visible during conjugation; the old Set A
            // fall-down-to-Set-A fallback is gone (it masked Set B gaps, and the
            // Set A allomorphs are wrong for Set B in the 3sg/3pl-object columns
            // — Feeling guide P8). Old fallback, commented out:
            //tmpReturnPrefix = ((Prefix) CompoundPrefixes.prefixes.get(verbPrefix.substring(0, verbPrefix.size() - 1)))
            if (!tmpReturnPrefix) {
                return "MISSING_ENTRY" + it
            }

            tmpReturnPrefix = tmpReturnPrefix?.preVowel

            if (tmpReturnPrefix) {
                //timo 10Nov26: Grammar guide (Feeling 1975): -y- is inserted only
                //between the prefix and a stem-initial vowel — "the insertion of -y-
                //between the final vowel of the prefix and the initial vowel of the
                //stem does not take place" before consonant-initial stems (P3 "to see";
                //same rule in P5 "to like"). The marker rule below (processY etc.) is
                //applied to the first syllable of the routed form, so it is guide-correct
                //only when that form is the normalized stem: vowel-initial stems keep a
                //leading vowel syllable (Stemmer.generateVowelStems) and consonant-initial
                //stems are prefix-less (Stemmer.generateConsonentStems), so they take the
                //preConsonant branch with no -y-. Un-normalized forms (e.g. the raw
                //dictionary entry with its baked 3sg prefix, ᎤᎪᎲᎢ) must never reach this
                //branch, and Set A entries must never stand in for Set B lookups.
                //determine if last 1 or 2 characters need to be included in the conversion
                //if ends with gw then 2 - otherwise only 1
                def backspace = 1 //this is the count back that we need to get to the latin characters of the prefix
                if (tmpReturnPrefix.endsWith("gw")) {
                    backspace = 2
                }

                def prefixStart = tmpReturnPrefix.substring(0, tmpReturnPrefix.size() - backspace)
//                log prefixStart

                def prefixEnd = tmpReturnPrefix.substring(tmpReturnPrefix.size() - backspace)
//                log prefixEnd

                def fixedPrefix = Morphemes.fixPrefix(it.substring(0, 1), prefixEnd, it)
//                log(fixedPrefix)

                returnPrefix = prefixStart + fixedPrefix[0]
                it = fixedPrefix[1]
            }

            returnValue = new RuleUW().process(pref.prefix1, pref.prefix2, returnPrefix, tense, false, it, verbset)

            // B4: v->a stems keep the inserted -w- (P4(6) ᎤᏩᎨᏩᏍᎦ), so the
            // uw+a -> u contraction above must not fire for them.
            if (stemWasVtoA) {
                returnValue = null
            }

            if (!returnValue) {
                returnValue = returnPrefix + it
            }
        } else {
            // Handle prefixes based on da- and de- flags
            // Prioritize da- if explicitly set, otherwise use de-
            // (C8: the da-/de- surface work lives in PrefixProcessor; the
            // pronominal preConsonant lookup below is unchanged.)
            // timo 10Nov26: preConsonant twin of the preVowel change above — an
            // empty preConsonant (declared empty B twin) now yields a prefix-less
            // bare stem instead of falling into MISSING_ENTRY, and an absent key
            // (either set) surfaces as MISSING_ENTRY:
            //returnPrefix = ((Prefix) CompoundPrefixes.prefixes.get(verbPrefix))?.preConsonant
            def entry = ((Prefix) CompoundPrefixes.prefixes.get(verbPrefix))
            returnPrefix = entry?.preConsonant
            if (!entry) {
                return "MISSING_ENTRY" + (it ?: "")
            }

            // tio 12Nov26: per-verb compound-prefix override (VerbRegistry).
            // The verb book prints verb-specific prefix cells for some person
            // combos — To Bite p.29 exercises the dA-/dE-/dO- distributive
            // variant the guide paradigms omit, and differs outright on a few
            // cells (SG2->SG1 ᏍᎩ, PL2->SG3AN ᎡᏍᏗ). Keyed by (combo, routed
            // stem) so To See's guide-cited cells are untouched.
            def compoundOverride = VerbRegistry.getCompoundOverride(verbPrefix, it)
            if (compoundOverride != null) {
                returnPrefix = compoundOverride
            }

            // timo 10Nov26: FUTURE_COMMAND (Future Imperative/Volative) with a 3rd
            // person singular subject takes a- before consonant-initial Stem III
            // forms (Set A): verb book p.119 "Let him/her see it!" ᎠᎪᎲᎢ agohv'i
            // (a-, NOT the ga- of the present-tense table), p.29 "let him/her
            // hear..." ᎠᏛᎦᏅᎢ atvganv'i. Tense-scoped: PRESENT sg3 cells are
            // short-circuited from raw present3rd upstream, and vowel-initial
            // stems already surface a- via the stem's own leading vowel (empty
            // preVowel branch). tio 12Nov26: a registered compound override
            // wins — bite's FIV sg3 is wa- (ᏩᏍᎦᎶᏨᎢ wasgaltsv'i, p.29), a
            // verb-level variance no table entry expresses.
            if (tense == Tense.FUTURE_COMMAND
                    && verbset == VerbSet.A
                    && pref?.prefix1 == PrefixTableSubject.SG3
                    && (pref?.prefix2 == PrefixTableObject.SG3AN
                        || pref?.prefix2 == PrefixTableObject.SG3IN)
                    && compoundOverride == null
                    // tio 12Nov26: scoped to A-allomorph verbs — To Fall
                    // (G-allomorph, present3rd ᎦᏅᎦ) composes its FIV sg3
                    // from the table's G-allomorph ga- (ᎦᏅᏨᎢ ganvtsv'i,
                    // p.32), not a-; only A-allomorph verbs print Ꭰ here.
                    && verb.stemmer?.sg3Allomorph() == Stemmer.SG3_ALLOMORPH_A) {
                returnPrefix = 'Ꭰ'
            }

            //Montgomery-Anderson pp 208 -- 'No Set B prefixes trigger it [Laryngeal alternation].
            if (verbset != VerbSet.B) {
                //this will return something if it can - if not then the returnValue will be null and should be checked against
                returnValue = new RuleLaryngealAlteration().process(pref.prefix1, pref.prefix2, returnPrefix, tense, false, it, verbset)
            }

            // tio 12Nov26: declarative future, sg3 subject + sg3 object: A-allomorph
            // verbs compose the future from the BARE stem — the book's future
            // column is da- + Stem III with no sg3 pronominal (bite Stem III
            // -sgahlits- is consonant-initial: da prepends Ꮣ, book p.29 SG1
            // ᏓᏥᏍᎦᎶᏥ / SG3 ᏓᏍᎦᎶᏥ), while vowel-initial stems merge under the
            // D-map (To Hear p.64 ᏛᏛᎦᏂ dvtvgani = da+atvgan -> dv). Composing
            // the sg3 Ꭰ- pronominal and dropping it in the D-map gave the same
            // ᏓᏍᎦᎶᏥ for consonant stems but would break vowel-stem cells (and
            // conflicts with PL3 ani -> ᏛᏂ, whose Ꭰ DOES merge). G-allomorph
            // verbs keep the table's generic Ꭶ- under the da- (guide ex. 74b
            // ᏓᎦᏬᏂᏏ dagawonisi "he will speak"; To Fall SG3 ᏓᎦᏅᏥ). Tense- and
            // allomorph-scoped so the present-tense table cells are untouched.
            if (tense == Tense.COMPLETIVE_FUTURE
                    && verbset == VerbSet.A
                    && pref?.prefix1 == PrefixTableSubject.SG3
                    && (pref?.prefix2 == PrefixTableObject.SG3AN
                        || pref?.prefix2 == PrefixTableObject.SG3IN)
                    && verb.stemmer?.sg3Allomorph() == Stemmer.SG3_ALLOMORPH_A) {
                returnPrefix = ''
            }

            if (!returnValue && returnPrefix != null && it != null) {
                verb.pronominalHolder = returnPrefix
                verb.root = it
                returnValue = returnPrefix + it;
            }
        }

        if (!returnPrefix) {
            // timo 10Nov26: legacy guard. A declared-empty twin (empty preVowel or
            // preConsonant) now means "no prefix" and the branches above already
            // computed the prefix-less bare stem — keep it. Only blank the result
            // when nothing was computed at all.
            if (!returnValue) {
                returnValue = ""
            }
        }

        println "DEBUG: fallthrough with returnValue=${returnValue}"
        return returnValue
    }

    static def process(Verb verb) {
        VerbTenseHolder vth = new VerbTenseHolder(stemmer: verb.stemmer)
        vth.process()

        // timo 12Nov26: WI-35 — dative-benefactive PRESENT (el flag). When the
        // verb carries a printed dative surface (Stemmer.dativePresent), the
        // applicative morphology is baked into it (M-A Table 14.1: APL attaches
        // to the Completive stem, Present Continuous -eéha — the -ᏁᎭ is the
        // Completive stem's final -n plus the APL vowel, not insertable), so the
        // sg3 present IS that form. PL3-object cells route through holder.de so
        // PrefixDe glues the plural-object prefix with its own allomorphy
        // (Ꮥ normally; Ꮧ after w-: guide ex. 35a ᏕᎪᏪᎳᏁᎭ, 35b ᏫᏗᎪᏪᎳᏁᎭ).
        // Non-reflexive only, and only when the dative surface exists — verbs
        // without it keep the generic NonFinalSuffixEl machinery. This block
        // precedes the plain sg3 PRESENT short-circuit below, which would
        // otherwise shadow the dative form with present3rd.
        if (verb.nonFinalSuffixHolder?.el
                && verb.tense == Tense.PRESENT
                && verb.stemmer?.dativePresent?.syllabary
                && !verb.reflexiveHolderObject.isReflexive()) {
            if (verb.compoundPrefix == CompoundPrefixes.SG3PL3AN
                    || verb.compoundPrefix == CompoundPrefixes.SG3PL3IN) {
                verb.initialPrefixHolder.de = true
                return verb.stemmer.dativePresent.syllabary;
            }
            if (verb.compoundPrefix == CompoundPrefixes.SG3SG3AN
                    || verb.compoundPrefix == CompoundPrefixes.SG3SG3IN) {
                return verb.stemmer.dativePresent.syllabary;
            }
        }

        // timo 12Nov26: merged SG3SG3AN + SG3SG3IN PRESENT short-circuit. The sg3
        // singular form is lexically allomorphic and the book prints ONE sg3 row
        // covering both object readings (To See p.118: "He/she sees him/her" AND
        // "He/she sees it" are both agowtiha), so for both compound prefixes the
        // printed present3rd IS the form. The old transitive SG3SG3IN path composed
        // the table's generic Ꭶ- allomorph, producing ga- for A-class verbs.
        // Non-reflexive only, and skipped when the verb has no present stem
        // (empty stemmer entry) so composition still applies elsewhere.
        if ((verb.compoundPrefix == CompoundPrefixes.SG3SG3AN
                || verb.compoundPrefix == CompoundPrefixes.SG3SG3IN)
                && !verb.reflexiveHolderObject.isReflexive()
                && verb.tense == Tense.PRESENT
                && verb.stemmer?.present3rd?.syllabary) {
            return verb.stemmer.present3rd.syllabary;
        }

        // timo 10Nov26: HABITUAL sg3 short-circuit, mirroring the PRESENT one above.
        // The sg3 habitual is lexically allomorphic like the present (see Ꭰ- agowtisgo'i
        // book p.120, kill Ꭰ- ᎠᎯᎰᎢ, want Ꭴ- ᎤᏚᎵᏍᎪᎢ, wear shoes Ꮪ- ᏚᎳᏑᏠᎢ), so composing
        // the stem from the table preConsonant (ga- for see) produces the wrong row.
        // The dictionary's raw habitual DefinitionLine IS the printed sg3 form for
        // every verb, so return it directly for both SG3AN and SG3IN object readings —
        // the book prints one sg3 habitual row covering both (p.120 "He/she sees it
        // (habitually)"). Non-reflexive only, and skipped when the verb has no
        // habitual row (empty stem) so composition still applies elsewhere.
        if ((verb.compoundPrefix == CompoundPrefixes.SG3SG3AN
                || verb.compoundPrefix == CompoundPrefixes.SG3SG3IN)
                && !verb.reflexiveHolderObject.isReflexive()
                && verb.tense == Tense.HABITUAL
                && verb.stemmer?.habitual?.syllabary) {
            return verb.stemmer.habitual.syllabary;
        }

        // timo 10Nov26: HABITUAL sg3 short-circuit, mirroring the PRESENT one above.
        // The sg3 habitual is lexically allomorphic like the present (see Ꭰ- agowtisgo'i
        // book p.120, kill Ꭰ- ᎠᎯᎰᎢ, want Ꭴ- ᎤᏚᎵᏍᎪᎢ, wear shoes Ꮪ- ᏚᎳᏑᏠᎢ), so composing
        // the stem from the table preConsonant (ga- for see) produces the wrong row.
        // The dictionary's raw habitual DefinitionLine IS the printed sg3 form for
        // every verb, so return it directly for both SG3AN and SG3IN object readings —
        // the book prints one sg3 habitual row covering both (p.120 "He/she sees it
        // (habitually)"). Non-reflexive only, and skipped when the verb has no
        // habitual row (empty stem) so composition still applies elsewhere.
        if ((verb.compoundPrefix == CompoundPrefixes.SG3SG3AN
                || verb.compoundPrefix == CompoundPrefixes.SG3SG3IN)
                && !verb.reflexiveHolderObject.isReflexive()
                && verb.tense == Tense.HABITUAL
                && verb.stemmer?.habitual?.syllabary) {
            return verb.stemmer.habitual.syllabary;
        }

        // tio 12Nov26: IMMEDIATE_PAST sg3 short-circuit, mirroring the PRESENT/
        // HABITUAL ones above. The sg3 immediate-past row is lexically allomorphic
        // and the book prints ONE sg3 row covering both object readings (book
        // p.29 To Bite: "S/he bit it, just now" ᎠᏍᎦᎳ asgala -- the sg3 a- allomorph,
        // vs the table's generic SG3SG3IN preConsonant Ꭶ- which composed ᎦᏍᎦᎳ).
        // Non-reflexive only, and skipped when the verb has no immediate-past row
        // (empty stemmer entry) so composition still applies elsewhere.
        if ((verb.compoundPrefix == CompoundPrefixes.SG3SG3AN
                || verb.compoundPrefix == CompoundPrefixes.SG3SG3IN)
                && !verb.reflexiveHolderObject.isReflexive()
                && verb.tense == Tense.IMMEDIATE_PAST
                && verb.stemmer?.immediatepast?.syllabary) {
            return verb.stemmer.immediatepast.syllabary;
        }

        // tio 12Nov26: REMOVED REMOTE_PAST sg3 short-circuit. The composed form
        // already matches the book's citation row (bite ᎤᏍᎦᎵᏨᎢ: Set B sg3 cell
        // Ꭴ- + full stem with its Stem III i kept, since syncope excludes the
        // citation row). Echoing the raw lexicon row instead broke verbs whose
        // raw sg3 remote row carries a baked initial prefix the composed form
        // correctly drops (Duksesdi/Dulvwisdaneha/Duyawega ᏓᏚ… vs Ꮪ…).

        // timo 10Nov26: PRESENT sg3-subject + plural-object (PL3AN/PL3IN) cells.
        // The plural-object prefix fuses with the verb's OWN sg3 subject allomorph —
        // guide P3(24) for To See: "da- 'he--them': d-, plural object; -a-, 3rd
        // person"; P1(45) for To Tie: "deg- 'he--them (an or in)': de-, plural
        // object; -g-, 3rd person". So verbs whose sg3 allomorph is A-class (present3rd
        // begins with Ꭰ) take da-, while G-class verbs (tie-type) take deg- via
        // ordinary composition. Book-verified da- rows: To See p.118 ᏓᎪᏩᏘᎭ,
        // To Hear ᏓᏛᎩᎠ, To Kill p.87 ᏓᎯᎭ.
        if ((verb.compoundPrefix == CompoundPrefixes.SG3PL3AN
                || verb.compoundPrefix == CompoundPrefixes.SG3PL3IN)
                && !verb.reflexiveHolderObject.isReflexive()
                && verb.tense == Tense.PRESENT
                && verb.stemmer?.present3rd?.syllabary) {
            if (verb.stemmer?.sg3Allomorph() == Stemmer.SG3_ALLOMORPH_A) {
                return 'Ꮣ' + verb.stemmer.present3rd.syllabary.substring(1);
            }
            // timo 12Nov26: WI-35 — g-initial present3rd (Ꭺ/Ꭶ/Ꭷ) is the verb's
            // OWN sg3 subject g- (write ᎪᏪᎵᎠ = g + ohweli'a, speak ᎦᏬᏂᎭ = ga +
            // woniha), so the plural-object prefix glues onto the FULL sg3 form:
            // guide P1(45) "deg- 'he--them (an or in)': de-, plural object;
            // -g-, 3rd person". Guide ex. 34 ᏕᎪᏪᎵᎠ = de + gohweli'a. (The old
            // table's ᏕᎩ- entry double-marked these cells ᏕᎩᎪᏪᎵᎠ.)
            String s3 = verb.stemmer.present3rd.syllabary
            if (s3.startsWith('Ꭺ') || s3.startsWith('Ꭶ') || s3.startsWith('Ꭷ')) {
                return 'Ꮥ' + s3;
            }
        }

        // Rules 70-73 from Grammar Guide: Inherent and Plural Distributive prefixes
//        if (verb.stemmer?.isDistributive) {
//            verb.initialPrefixHolder.de = true
//        }

//        if (verb.stemmer?.isPluralDistributive) {
//            def s = verb.subject.toString()
//            if (s.startsWith("PL") || s.startsWith("DL")) {
//                verb.initialPrefixHolder.de = true
//            }
//        }

        // Compositional Object de- trigger:
        // Any PL3AN/PL3IN object triggers the distributive/plural-object 'de-' prefix.
/*        if (verb.object == PrefixTableObject.PL3AN
                || verb.object == PrefixTableObject.PL3IN) {
            // Plural objects with PL3 subject use the plural distributive prefix 'da-' instead of 'de-'
            if (verb.subject == PrefixTableSubject.PL3) {
                verb.initialPrefixHolder.da = true
                verb.initialPrefixHolder.de = false
            } else {
                // For other subjects with PL3AN/PL3IN objects, 'de-' is used.
                // However, da- also needs to be considered for these cases.
                verb.initialPrefixHolder.de = true
                // If 'da-' is also explicitly requested (e.g., from test flags), prioritize it.
                if (verb.initialPrefixHolder.da) {
                    verb.initialPrefixHolder.de = false
                }
            }
        }*/

        // C8: REMOVED -- timo 10Nov26. The old auto-apply of the da- initial prefix
        // for FUTURE_COMMAND + SG3IN/PL3IN objects (claiming the verb book prints
        // ᏓᎦᎪᎲᎢ for To See) was a misreading: book p.119's Future Imperative/Volative
        // section for To See prints exactly four rows — ᎯᎪᎲᎢ, ᏍᏗᎪᎲᎢ, ᎢᏥᎪᎲᎢ,
        // ᎠᎪᎲᎢ "Let him/her see it!" — no da- anywhere. The FUTURE_COMMAND sg3
        // handling now lives in processPrefixes (tense-scoped a- override).

        // tio 12Nov26: da- is THE future initial prefix (guide "da-, future":
        // "da- is prefixed to a verb form to indicate that the action of the
        // verb will take place in the future; da- occurs together with the
        // future tense suffix -i"). Set it for the declarative future so
        // PrefixDa composes: consonant-initial composed base -> Ꮣ+ (book p.29
        // bite SG1 ᏓᏥᏍᎦᎶᏥ datsisgaltsi), a-initial base -> D-map merge that
        // drops the sg3 a- (book SG3 ᏓᏍᎦᎶᏥ dasgaltsi), g-initial base keeps
        // its g (guide ex. 74b ᏓᎦᏬᏂᏏ dagawonisi "he will speak"). NOT set for
        // FUTURE_COMMAND — the book's Future Imperative/Volative sections print
        // no da- anywhere (C8 note below). The sg3 REMOTE_PAST echo above is
        // untouched: remote past is NOT the future.
        if (verb.tense == Tense.COMPLETIVE_FUTURE) {
            verb.initialPrefixHolder.da = true
        }

        // check for overrides first
        String override = VerbRegistry.getOverride(verb.root, verb.tense.name())
        if (override) {
            return override
        }

        // proceed with standard logic
        String verbToConjugate = ""

        switch (verb.tense) {
            case Tense.PRESENT:
                verbToConjugate = vth.present;
                break;
            case Tense.REMOTE_PAST:
                verbToConjugate = vth.remotePast
                break;
            case Tense.FUTURE_COMMAND:
                // Future Imperative/Volative = Stem III + -v'i (verb book summaries),
                // usually identical to the Remote Past row; futureCommand is the Remote
                // Past entry (falls back to completiveFuture when missing)
                verbToConjugate = vth.futureCommand
                break;
            case Tense.COMPLETIVE_FUTURE:
            case Tense.COMPLETED_FUTURE:
                // declarative Future "-i": the verb book derives it from Stem III
                // ("NB: the Future is usually Stem III") — completiveFuture is the
                // Remote Past form with -v'i replaced by -i (VerbTenseHolder)
                verbToConjugate = vth.completiveFuture
                break;
            case Tense.FUTURE_EXPECTED:
                // verb book: To Go only, Future (Expected) = Stem II (-e-s-) + -i with
                // the de-/da- (es-) initial prefix: dagesi, tesi, dayesi. To Go's
                // habitual entry is Stem I (-e-g-), so the correct Stem II base is not
                // available from the dictionary; the Stem III-derived future form is
                // used as a placeholder until verb-level Stem II data exists. -- timo 10Nov26
                verbToConjugate = vth.completiveFuture
                break;
            case Tense.PROGRESSIVE_PAST:
                verbToConjugate = vth.progressivePast
                break;
            case Tense.PROGRESSIVE_FUTURE:
                verbToConjugate = vth.progressiveFuture
                break;
            case Tense.IMMEDIATE_PAST:
            case Tense.RECENT_PAST_IMPERATIVE:
            case Tense.IMMEDIATE_COMMAND:
                // immediate/recent-past forms build on the imperative entry (Stem IV);
                // IMMEDIATE_COMMAND also uses the imperative stem
                verbToConjugate = vth.immediate ?: vth.immediateCommand
                break;
            case Tense.HABITUAL:
                verbToConjugate = vth.habitual
                break;
            case Tense.INFINITIVE:
                // For infinitive, if 'de-' prefix is present, use deverbal stem, else use infinitive stem
                // The Stemmer generates Deverbal stems. We need to access the correct one from the StemEntry list.
                verbToConjugate = vth.infinitive
                break;
        }

        def returnValue = ""

        // E: surface stemmer failures — a tense with no normalized stem must not
        // silently produce a garbage "null"-concatenation (processPrefixes(null)).
        // MISSING_STEM_<TENSE> keeps the gap visible at the whole-word level, in
        // the same spirit as the MISSING_ENTRY prefix-table sentinel.
        if (!verbToConjugate) {
            return "MISSING_STEM_" + verb.tense
        }

        verbToConjugate = new ReflexivePrefix().toSyllabary(verbToConjugate, verb)
        if (!verb.reflexiveHolderObject.isReflexive()) {
            verbToConjugate = processPrefixes(verb, verbToConjugate)
            def lst = verb.stemmer.getRootWithEnding(verb.tense)
            //TODO: write more tests to cover this and make sure the values are correct
            verb.root = lst[0]
            verb.rootEnding = lst[1]
        }

        if (verbToConjugate) {
            returnValue = verbToConjugate
        }

        // apply categorical rules (mixin approach) -- tio 11Nov26
        returnValue = VerbRegistry.applyCategoricalRules(verb, returnValue, verb.tense)

        println "DEBUG: fallthrough with returnValue=${returnValue}"
        return returnValue
    }
}
