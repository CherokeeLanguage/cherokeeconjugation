package cherokee.dictionary.verb.conjugation.originalconjugation

import cherokee.conjugation.constants.Tense

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
                case Tense.PRESENT:
//                    present = su.parseSyllabary(it.syllabary)
                    present = it.syllabary
                    break;
                case Tense.HABITUAL:
//                    habitual = su.parseSyllabary(it.syllabary)
                    habitual = it.syllabary
                    break;
                case Tense.IMMEDIATE_COMMAND:
//                    immediate = su.parseSyllabary(it.syllabary)
                    immediate = it.syllabary
                    break;
                case Tense.DEVERBAL:
//                    deverbal = su.parseSyllabary(it.syllabary)
                    deverbal = it.syllabary
                    break;
                case Tense.REMOTE_PAST:
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
