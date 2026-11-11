package net.cherokeedictionary.verb.conjugation

import net.cherokeedictionary.stem.StemType
import net.cherokeedictionary.transliteration.SyllabaryUtil
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
    def progressivePast
    def progressiveFuture
    def immediateCommand

    def stemmer

    /**
     * TODO: do checks to make sure these have values before we start crapping things up -- timo 16Aug15
     */
    public void process() {
//        def su = SyllabaryUtil

//        infinitive = su.parseSyllabary(stemmer.infinitive.syllabary.substring(1))
//        println stemmer.infinitive.syllabary.substring(1)
        infinitive = stemmer?.infinitive?.syllabary ? stemmer?.infinitive?.syllabary?.substring(1) : ''

        stemmer.getStems().each {
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

        // The infinitive must use the normalized Deverbal stem (vowel/consonant
        // initial like the other stems) so preVowel/preConsonant prefix allomorphy
        // is selected correctly. Chopping the raw dictionary entry loses the
        // normalized initial vowel (e.g. ᎤᏓᏙᎵᏍᏙᏗ -> ᏓᏙᎵᏍᏙᏗ instead of ᎠᏓᏙᎵᏍᏙᏗ).
        //infinitive = deverbal ?: (stemmer?.infinitive?.syllabary ? stemmer.infinitive.syllabary.substring(1) : '')
	//todo: -- review again -- timo 4Nov26
        // The verb book ("NB: the Future is usually Stem III", To Go): the Future is
        // Stem III + -i, i.e. the Remote Past form with the final suffix -v'i replaced
        // by -i (e.g. To Be Thankful Remote Past -alihelitsel-v'i -> Future
        // -alihelitsel-i). Derive completiveFuture from the Remote Past entry instead
        // of the present stem. Falls back to the old present-derived placeholder when
        // no Remote Past entry exists.
        //todo: -- review again -- timo 4Nov26 -- timo 10Nov26
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
