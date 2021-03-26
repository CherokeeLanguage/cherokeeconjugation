package cherokee.dictionary.verb.conjugation.originalconjugation

import cherokee.conjugation.verbal.enums.Tense

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
        infinitive = stemmer?.infinitive?.syllabary ? stemmer?.infinitive?.syllabary?.substring(1) : ''

        stemmer.getStems().each {
            switch (it.stemtype) {
                case Tense.PRESENT:
                    present = it.syllabary
                    break;
                case Tense.HABITUAL:
                    habitual = it.syllabary
                    break;
                case Tense.IMMEDIATE_COMMAND:
                    immediate = it.syllabary
                    break;
                case Tense.DEVERBAL:
                    deverbal = it.syllabary
                    break;
                case Tense.REMOTE_PAST:
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
