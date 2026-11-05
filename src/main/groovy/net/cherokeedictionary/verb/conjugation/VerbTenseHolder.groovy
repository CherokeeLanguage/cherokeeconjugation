package net.cherokeedictionary.verb.conjugation

import net.cherokeedictionary.stem.StemType


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
        if (present != null) {
            completiveFuture = present.substring(0, present.size() - 1)
        }
        // FUTURE_COMMAND is sourced from the imperative entry (the verb's command form,
        // e.g. adadolisda -> ᎠᏓᏙᎵᏍᏓ). Stemmer.getRootWithEnding already maps
        // Tense.FUTURE_COMMAND -> Imperative suffix, so the Immediate stem (built from
        // stemmer.imperative) is the intended base. Fall back to completiveFuture
        // (present minus final syllable) when the imperative entry is missing.
        //futureCommand = immediate ?: completiveFuture
	//todo: -- review again -- timo 4Nov26
        futureCommand = completiveFuture
        progressivePast = completiveFuture
        progressiveFuture = completiveFuture
        immediateCommand = completiveFuture
    }
}
