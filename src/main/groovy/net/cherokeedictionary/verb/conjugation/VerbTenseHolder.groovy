package net.cherokeedictionary.verb.conjugation

import net.cherokeedictionary.stem.StemType
import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.StringUtility
import net.cherokeedictionary.util.Tense
import net.cherokeedictionary.verb.affixes.nonFinalSuffixes.NonFinalSuffixG


/**
 * Created by torr on 8/16/2015.
 */
class VerbTenseHolder {
    def present
    def remotePast
    def habitual
    def immediate
    def deverbal
    def infinitive

    def completiveFuture
    def futureCommand
    def futureExpected
    def progressivePast
    def progressiveFuture
    def immediateCommand
    // tio 15Nov26: IMMEDIATE_PAST's own stem. Some verbs compose the recent
    // past from a DIFFERENT stem than the imperative (To See: present-stem
    // ᏥᎪᏩᏘᎭ tsigowatiha vs imperative Stem IV ᎯᎪᏩᏔ higohwahta, book p.118),
    // while IMMEDIATE_COMMAND/RECENT_PAST_IMPERATIVE always build on the
    // imperative entry. Both citation rows land in StemType.Immediate, so
    // vth.immediate (last entry = imperative) cannot serve both tenses.
    def immediatePast

    def stemmer

    private boolean isDebug = false

    /**
     * TODO: do checks to make sure these have values before we start crapping things up -- timo 16Aug15
     */
    public void process() {
//        def su = SyllabaryUtil

        stemmer.getStems().each {
            if (isDebug) println "DEBUG: Stem type: ${it.stemtype}, syllabary: ${it.syllabary}"
            switch (it.stemtype) {
                case StemType.PresentContinous:
//                    present = su.parseSyllabary(it.syllabary)
                    present = it.syllabary
                    break;
                case StemType.Habitual:
//                    habitual = su.parseSyllabary(it.syllabary)
                    habitual = it.syllabary
                    break;
                case StemType.Immediate:
//                    immediate = su.parseSyllabary(it.syllabary)
                    immediate = it.syllabary
                    break;
                case StemType.Deverbal:
//                    deverbal = su.parseSyllabary(it.syllabary)
                    deverbal = it.syllabary
                    break;
                case StemType.RemotePast:
//                    remotePast = su.parseSyllabary(it.syllabary)
                    remotePast = it.syllabary
                    break;
            }
        }

        // tio 16Nov26: infinitive stem sourcing -- per-pattern guard resolving
        // the known conflict. Use the normalized Deverbal stem ONLY when the
        // raw infinitive entry is a 3rd-person vowel prefix + a consonant-
        // initial remainder whose onset is NOT w/y (the case where the raw
        // chop loses the normalized vowel and the preConsonant allomorphs
        // agi-/uni-/igi- are wrongly chosen over preVowel agw-/una-/iga-).
        // Verbs like To Be Somewhere (ᎤᏪᏓᏍᏗ: chop leaves ᏪᏓᏍᏗ, w-onset, and
        // SG3 composes the book's exact ᎤᏪᏓᏍᏗ from the chop) keep the chop --
        // the Deverbal stem triggers a UW-rule Ꮽ insertion there.
        def rawInfSyllabary = stemmer?.infinitive?.syllabary
        // tio 19Nov26: the open-spelled da- citation (ᏓᏳᎶᎯᏍᏗ "to be from")
        // chops TWO glyphs (da- + yu), not one like the fused Ꮪ spelling --
        // otherwise the chop leaves the bare yu- (ᏳᎶᎯᏍᏗ) and SG3 composes
        // ᎤᏳᎶᎯᏍᏗ -> ᏓᏳᏳᎶᎯᏍᏗ (duplicated Ᏻ).
        boolean openDaInf = stemmer?.normalizedDaInitialPrefix && rawInfSyllabary?.startsWith("ᏓᏳ")
        infinitive = rawInfSyllabary ? (openDaInf ? rawInfSyllabary.substring(2) : rawInfSyllabary.substring(1)) : ''
        if (deverbal && rawInfSyllabary && rawInfSyllabary.size() > 1) {
            String chopped = rawInfSyllabary.substring(1)
            char rawFirst = rawInfSyllabary.charAt(0)
            boolean thirdPersonVowelPrefix = StringUtility.startsWithVowelSyllabary(String.valueOf(rawFirst))
            boolean chopConsonantOnset = chopped && !StringUtility.startsWithVowelSyllabary(chopped)
            char onset = chopped.charAt(0)
            boolean wyOnset = ['Ꮺ', 'Ꮻ', 'Ꮼ', 'Ꮽ', 'Ꮾ', 'Ꮿ', 'Ᏺ', 'Ᏻ', 'Ᏼ'].contains(String.valueOf(onset))
            if (thirdPersonVowelPrefix && chopConsonantOnset && !wyOnset
                    && StringUtility.startsWithVowelSyllabary(deverbal)
                    && deverbal != chopped) {
                infinitive = deverbal
            }
        }
	//todo: -- review again -- timo 4Nov26
        // The verb book ("NB: the Future is usually Stem III", To Go): the Future is
        // Stem III + -i, i.e. the Remote Past form with the final suffix -v'i replaced
        // by -i (e.g. To Be Thankful Remote Past -alihelitsel-v'i -> Future
        // -alihelitsel-i). Derive completiveFuture from the Remote Past entry instead
        // of the present stem. Falls back to the old present-derived placeholder when
        // no Remote Past entry exists.
        //todo: -- review again -- timo 4Nov26 -- timo 10Nov26
        immediate = stemmer.getStem(Tense.IMMEDIATE_PAST)
        // tio 15Nov26: the IMMEDIATE_PAST-specific stem — the dictionary's
        // immediate-past citation (first StemType.Immediate entry) when the
        // entry carries one, else the imperative stem (same as vth.immediate).
        immediatePast = stemmer.getImmediatePastStem()
        if (remotePast != null) {
            String rp = SyllabaryUtil.parseSyllabary(remotePast)
            if (rp.size() > 2 && rp.endsWith("vi")) {
                completiveFuture = SyllabaryUtil.tsalagiToSyllabary(rp.substring(0, rp.size() - 2) + "i")
            }
        }
        if (completiveFuture == null && present != null) {
            completiveFuture = present.substring(0, present.size() - 1)
        }
        // FUTURE_COMMAND (Future Imperative/Volative) is Stem III + -v'i, per the verb
        // book's summaries — usually identical to the Remote Past row (e.g. To Bite
        // Remote Past -sgahlits-v'i = Future Imperative/Volative -sgahlits-v'i). The
        // minority whose FIV is Stem III + -esdi (e.g. To Be Somewhere edoh-esdi, To
        // Have (Long and Rigid) -vy-esdi) will need the FutureProgressive (-esdi) form
        // once verb-level data is available.
        //todo: -- review again -- timo 4Nov26 -- timo 10Nov26
        futureCommand = remotePast ?: completiveFuture
        futureExpected = habitual ?: completiveFuture

        // C6: the progressive tenses insert the non-final suffix -sg- before the
        // tense final suffix (grammar guide ex. 89/93):
        //   past progressive    stem + sg + v'i   -> ...-sgv'i (ᏍᎬᎢ)
        //   future progressive  stem + sg + esdi  -> ...-sgesdi (ᏍᎨᏍᏗ)
        // derived from the present stem (Stem I, the same stem both progressive
        // tenses build on). The present's -sg+a surfaces as -ha (s drops, g -> h),
        // so the stem-final -h- merges back: h + sg -> sg
        // (gawonih + sg + v'i -> gawonisgv'i ᎦᏬᏂᏍᎬᎢ). -- timo 10Nov26
        if (present != null) {
            def pr = stemmer?.getRootWithEnding(Tense.PRESENT)
            if (pr && pr[0] != null && pr[1]) {
                String pBase = NonFinalSuffixG.applyGLatin(pr[0] + pr[1])
                if (pBase) {
                    progressivePast = SyllabaryUtil.tsalagiToSyllabary(pBase + "vi")
                    progressiveFuture = SyllabaryUtil.tsalagiToSyllabary(pBase + "esdi")
                }
            }
        }
        if (progressivePast == null) {
            progressivePast = completiveFuture
        }
        if (progressiveFuture == null) {
            progressiveFuture = completiveFuture
        }
        immediateCommand = completiveFuture
    }
}
