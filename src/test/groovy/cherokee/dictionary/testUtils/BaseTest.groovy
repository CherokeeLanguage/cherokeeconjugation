package cherokee.dictionary.testUtils

import cherokee.dictionary.processors.verb.VerbAffixFactory
import cherokee.dictionary.word.Verb

class BaseTest extends GroovyTestCase {
    public void testSuppressWarnings() {
        //literally does nothing except keep a warning from occurring
    }

    public static void basicAssertion(Verb word, assertion) {
        VerbAffixFactory.process(word)

        GroovyTestCase.assertEquals("does not match", assertion, word.getWholeWordSyllabary())
    }
}
