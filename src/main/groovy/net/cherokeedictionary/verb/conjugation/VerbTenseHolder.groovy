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

        if (present != null) {
            completiveFuture = present.substring(0, present.size() - 1)
        }
        futureCommand = completiveFuture
        progressivePast = completiveFuture
        progressiveFuture = completiveFuture
        immediateCommand = completiveFuture
    }
}
