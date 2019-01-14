package cherokee.dictionary.prefixes

import cherokee.dictionary.conjugation.conjugate.PartOfSpeech
import cherokee.dictionary.conjugation.conjugate.Tense
import cherokee.dictionary.conjugation.processors.VerbPrefixFactory
import cherokee.dictionary.conjugation.wordFormation.Word
import com.cobradoc.cherokee.SyllabaryUtil

class DePrefixTest extends GroovyTestCase {
    //de- consonants d- vowels except -i-
    public void testNormal() {
        Word word = new Word()
        word.partOfSpeech = PartOfSpeech.VERB_INTRANSITIVE
        word.rootLatin = "jigowatiha"
        word.tense = Tense.PRESENT
        word.subject = "SG1"
        word.rootSyllabary = new SyllabaryUtil().tsalagiToSyllabary(word.rootLatin)
        word.prefixHolderObject.with {
            de = true
        }

        VerbPrefixFactory.process(word)

        assertEquals("does not match", "ᏕᏥᎪᏩᏘᎭ", word.rootSyllabary)

        word.rootLatin = "agowatiha"
        word.rootSyllabary = new SyllabaryUtil().tsalagiToSyllabary(word.rootLatin)
        VerbPrefixFactory.process(word)
        assertEquals("does not match", "ᏓᎪᏩᏘᎭ", word.rootSyllabary)
    }

    //de- + -i- = de-
    public void testDeFollowedByI() {
        Word word = new Word()
        word.partOfSpeech = PartOfSpeech.VERB_INTRANSITIVE
        word.tense = Tense.PRESENT
        word.rootLatin = "inigowatiha"
        word.rootSyllabary = new SyllabaryUtil().tsalagiToSyllabary(word.rootLatin)
        word.subject = "SG1"

        word.prefixHolderObject.with {
            de = true
        }

        VerbPrefixFactory.process(word)

        assertEquals("does not match", "ᏕᏂᎪᏩᏘᎭ", word.rootSyllabary)
    }

    //after y-, w-, n- de = di unless followed by a vowel
    public void testDeAfterYWNBeforeConsonant() {
        Word word = new Word()
        word.partOfSpeech = PartOfSpeech.VERB_INTRANSITIVE
        word.tense = Tense.PRESENT
        word.subject = "SG1"
        word.prefixHolderObject.with {
            de = true
            yi = true
        }

        word.rootLatin = "jigowatiha"
        word.rootSyllabary = new SyllabaryUtil().tsalagiToSyllabary(word.rootLatin)
        VerbPrefixFactory.process(word)
        assertEquals("does not match", "ᏱᏗᏥᎪᏩᏘᎭ", word.rootSyllabary)

        word.prefixHolderObject.with {
            de = true
            wi = true
            yi = false
        }

        word.rootLatin = "sdigowatiha"
        word.rootSyllabary = new SyllabaryUtil().tsalagiToSyllabary(word.rootLatin)
        VerbPrefixFactory.process(word)
        assertEquals("does not match", "ᏫᏗᏍᏗᎪᏩᏘᎭ", word.rootSyllabary)

        word.prefixHolderObject.with {
            de = true
            wi = false
            yi = false
            ni = true
        }

        word.rootLatin = "sdigowatiha"
        word.rootSyllabary = new SyllabaryUtil().tsalagiToSyllabary(word.rootLatin)
        VerbPrefixFactory.process(word)
        assertEquals("does not match", "ᏂᏗᏍᏗᎪᏩᏘᎭ", word.rootSyllabary)

        word.prefixHolderObject.with {
            de = true
            wi = true
            yi = false
            ni = false
        }

        word.tense = Tense.REMOTE_PAST
        word.rootLatin = "jigowatisgvi"
        word.rootSyllabary = new SyllabaryUtil().tsalagiToSyllabary(word.rootLatin)
        VerbPrefixFactory.process(word)
        assertEquals("does not match", "ᏫᏕᏥᎪᏩᏘᏍᎬᎢ", word.rootSyllabary)
    }

    public void testInfinitiveImperative() {
        Word word = new Word()
        word.partOfSpeech = PartOfSpeech.VERB_INTRANSITIVE
        word.tense = Tense.INFINITIVE
        word.subject = "SG1"
        word.prefixHolderObject.with {
            de = true
            yi = false
        }

        word.rootLatin = "sdigowatvdi"
        word.rootSyllabary = new SyllabaryUtil().tsalagiToSyllabary(word.rootLatin)
        VerbPrefixFactory.process(word)
        assertEquals("does not match", "ᏗᏍᏗᎪᏩᏛᏗ", word.rootSyllabary)

        word.tense = Tense.FUTURE_COMMAND
        word.prefixHolderObject.with {
            de = true
            yi = false
        }

        word.rootLatin = "jaduga"
        word.rootSyllabary = new SyllabaryUtil().tsalagiToSyllabary(word.rootLatin)
        VerbPrefixFactory.process(word)
        assertEquals("does not match", "ᏗᏣᏚᎦ", word.rootSyllabary)
    }

    public void testDtoJ() {
        Word word = new Word()
        word.partOfSpeech = PartOfSpeech.VERB_INTRANSITIVE
        word.tense = Tense.INFINITIVE
        word.subject = "SG1"
        word.prefixHolderObject.with {
            de = true
            yi = false
        }

        word.rootLatin = "ugowatvdi"
        word.rootSyllabary = new SyllabaryUtil().tsalagiToSyllabary(word.rootLatin)
        VerbPrefixFactory.process(word)
        assertEquals("does not match", "ᏧᎪᏩᏛᏗ", word.rootSyllabary)

        word.rootLatin = "enadinvsi"
        word.rootSyllabary = new SyllabaryUtil().tsalagiToSyllabary(word.rootLatin)
        VerbPrefixFactory.process(word)
        assertEquals("does not match", "ᏤᎾᏗᏅᏏ", word.rootSyllabary)

        word.rootLatin = "agigowatvdi"
        word.rootSyllabary = new SyllabaryUtil().tsalagiToSyllabary(word.rootLatin)
        VerbPrefixFactory.process(word)
        assertEquals("does not match", "ᏗᎩᎪᏩᏛᏗ", word.rootSyllabary)
    }

    public void testDetoDibeforeHtoTi() {
        Word word = new Word()
        word.partOfSpeech = PartOfSpeech.VERB_INTRANSITIVE
        word.tense = Tense.PRESENT
        word.subject = "SG1"
        word.prefixHolderObject.with {
            de = true
            wi = true
        }

        word.rootLatin = "higowatiha"
        word.rootSyllabary = new SyllabaryUtil().tsalagiToSyllabary(word.rootLatin)
        VerbPrefixFactory.process(word)
        assertEquals("does not match", "ᏫᏘᎪᏩᏘᎭ", word.rootSyllabary)
    }

    public void testDetoDobeforeDa() {
        Word word = new Word()
        word.partOfSpeech = PartOfSpeech.VERB_INTRANSITIVE
        word.tense = Tense.PRESENT
        word.subject = "SG1"
        word.prefixHolderObject.with {
            da = true
            de = true
        }

        word.rootLatin = "jigoi"
        word.rootSyllabary = new SyllabaryUtil().tsalagiToSyllabary(word.rootLatin)
        VerbPrefixFactory.process(word)
        assertEquals("does not match", "ᏙᏓᏥᎪᎢ", word.rootSyllabary)

        word.prefixHolderObject.with {
            da = true
            di = false
            de = true
        }

        word.rootLatin = "atli"
        word.rootSyllabary = new SyllabaryUtil().tsalagiToSyllabary(word.rootLatin)
        VerbPrefixFactory.process(word)
        assertEquals("does not match", "ᏙᏛᏟ", word.rootSyllabary)
    }

    public void testInanimateDiDo() {
        Word word = new Word()
        word.partOfSpeech = PartOfSpeech.VERB_INTRANSITIVE
        word.tense = Tense.PRESENT
        word.subject = "SG1"
        word.prefixHolderObject.with {
            di = true
            de = true
        }

        word.rootLatin = "gowatiha"
        word.rootSyllabary = new SyllabaryUtil().tsalagiToSyllabary(word.rootLatin)
        VerbPrefixFactory.process(word)
        assertEquals("does not match", "ᏙᏗᎪᏩᏘᎭ", word.rootSyllabary)
    }

    public void testInanimateDe() {
        Word word = new Word()
        word.partOfSpeech = PartOfSpeech.VERB_INTRANSITIVE
        word.tense = Tense.PRESENT
        word.subject = "SG1"
        word.prefixHolderObject.with {
            de = true
        }

        word.rootLatin = "jigowatiha"
        word.rootSyllabary = new SyllabaryUtil().tsalagiToSyllabary(word.rootLatin)
        VerbPrefixFactory.process(word)
        assertEquals("does not match", "ᏕᏥᎪᏩᏘᎭ", word.rootSyllabary)
    }

    public void testInanimateDeGa() {
        Word word = new Word()
        word.partOfSpeech = PartOfSpeech.VERB_INTRANSITIVE
        word.tense = Tense.PRESENT
        word.subject = "SG1"
        word.prefixHolderObject.with {
            de = true
            ga = true
        }

        word.rootLatin = "jiyalviha"
        word.rootSyllabary = new SyllabaryUtil().tsalagiToSyllabary(word.rootLatin)
        VerbPrefixFactory.process(word)
        assertEquals("does not match", "ᏕᎦᏥᏯᎸᎢᎭ", word.rootSyllabary)
    }

    public void testInanimateDePlural() {
        Word word = new Word()
        word.partOfSpeech = PartOfSpeech.VERB_INTRANSITIVE
        word.tense = Tense.PRESENT
        word.subject = "SG1"
        word.prefixHolderObject.with {
            de = true
        }

        word.rootLatin = "uniyosiha"//niplural
        word.rootSyllabary = new SyllabaryUtil().tsalagiToSyllabary(word.rootLatin)
        VerbPrefixFactory.process(word)
        assertEquals("does not match", "ᏚᏂᏲᏏᎭ", word.rootSyllabary)
    }
}
