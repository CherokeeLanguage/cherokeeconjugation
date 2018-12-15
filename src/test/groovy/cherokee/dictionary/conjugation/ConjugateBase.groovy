package cherokee.dictionary.conjugation

import cherokee.dictionary.conjugation.affixes.processors.FinalSuffixProcessor
import cherokee.dictionary.conjugation.affixes.processors.PrefixProcessor
import cherokee.dictionary.conjugation.stem.DefinitionLine
import cherokee.dictionary.conjugation.cdpbook.Stemmer
import com.cobradoc.cherokee.SyllabaryUtil

/**
 * Created by torr on 8/28/2015.
 */
class ConjugateBase extends GroovyTestCase {
    static def su = new SyllabaryUtil();

    static def heWantsIt = new Stemmer()
    static def hiwoniha = new Stemmer()
    static def ganeneha = new Stemmer()
    static def tohave = new Stemmer()
    static def togreet = new Stemmer()
    static def tohear = new Stemmer()
    static def tofish = new Stemmer()
    static def toeatLiving = new Stemmer()
    static def takeABite = new Stemmer()
    static def tokill = new Stemmer()
    static def wearShoes = new Stemmer()

    static {
        heWantsIt.habitual = new DefinitionLine(syllabary: "ᎤᏚᎵᏍᎪᎢ")
        heWantsIt.imperative = new DefinitionLine(syllabary: "ᏣᏚᎳ")
        heWantsIt.infinitive = new DefinitionLine(syllabary: "ᎤᏚᎸᏗ")
        heWantsIt.present1st = new DefinitionLine(syllabary: "ᎠᏆᏚᎵᎭ")
        heWantsIt.present3rd = new DefinitionLine(syllabary: "ᎤᏚᎵᎭ")
        heWantsIt.remotepast = new DefinitionLine(syllabary: "ᎤᏚᎸᎲᎢ")

        hiwoniha.habitual = new DefinitionLine(syllabary: "ᎦᏬᏂᏍᎪᎢ")
        hiwoniha.imperative = new DefinitionLine(syllabary: "ᎯᏬᏂᎯ")
        hiwoniha.infinitive = new DefinitionLine(syllabary: "ᎤᏬᏂᎯᏍᏗ")
        hiwoniha.present1st = new DefinitionLine(syllabary:  "ᏥᏬᏂᎭ")
        hiwoniha.present3rd = new DefinitionLine(syllabary: "ᎦᏬᏂᎭ")
        hiwoniha.remotepast = new DefinitionLine(syllabary: "ᎤᏬᏂᏒᎢ")

        ganeneha.habitual = new DefinitionLine(syllabary: "ᎦᏁᏁᎰᎢ")
        ganeneha.imperative = new DefinitionLine(syllabary: "ᎯᏁᎥᏏ")
        ganeneha.infinitive = new DefinitionLine(syllabary: "ᎤᏁᏁᏗ")
        ganeneha.present1st = new DefinitionLine(syllabary:  "ᏥᏁᏁᎭ")
        ganeneha.present3rd = new DefinitionLine(syllabary: "ᎦᏁᏁᎭ")
        ganeneha.remotepast = new DefinitionLine(syllabary: "ᎤᏁᏁᎸᎢ")

        tohave.habitual = new DefinitionLine(syllabary: "ᎤᎰᎢ")
        tohave.imperative = new DefinitionLine(syllabary: "ᏣᎮᏍᏗ")
        tohave.infinitive = new DefinitionLine(syllabary: "")
        tohave.present1st = new DefinitionLine(syllabary:  "ᎠᎩᎭ")
        tohave.present3rd = new DefinitionLine(syllabary: "ᎤᎭ")
        tohave.remotepast = new DefinitionLine(syllabary: "ᎤᎲᎢ")

        togreet.habitual = new DefinitionLine(syllabary: "ᎠᏲᎵᎰᎢ")
        togreet.imperative = new DefinitionLine(syllabary: "ᎯᏲᎵᎦ")
        togreet.infinitive = new DefinitionLine(syllabary: "ᎤᏲᎵᏍᏗ")
        togreet.present1st = new DefinitionLine(syllabary:  "ᏥᏲᎵᎭ")
        togreet.present3rd = new DefinitionLine(syllabary: "ᎠᏲᎵᎭ")
        togreet.remotepast = new DefinitionLine(syllabary: "ᎤᏲᎵᎸᎢ")

        tohear.habitual = new DefinitionLine(syllabary: "ᎠᏛᎩᏍᎪᎢ")
        tohear.imperative = new DefinitionLine(syllabary: "ᎯᏯᏛᎬᎦ")
        tohear.infinitive = new DefinitionLine(syllabary: "ᎤᏛᎪᏗ")
        tohear.present1st = new DefinitionLine(syllabary:  "ᏥᏯᏛᎩᎠ")
        tohear.present3rd = new DefinitionLine(syllabary: "ᎠᏛᎩᎠ")
        tohear.remotepast = new DefinitionLine(syllabary: "ᎤᏛᎦᏅᎢ")

        tofish.habitual = new DefinitionLine(syllabary: "ᎠᏑᎲᏍᎪᎢ")
        tofish.imperative = new DefinitionLine(syllabary: "ᎭᏑᎲᎦ")
        tofish.infinitive = new DefinitionLine(syllabary: "ᎤᏑᏗ")
        tofish.present1st = new DefinitionLine(syllabary:  "ᎦᏑᎲᏍᎦ")
        tofish.present3rd = new DefinitionLine(syllabary: "ᎠᏑᎲᏍᎦ")
        tofish.remotepast = new DefinitionLine(syllabary: "ᎤᏑᏅᎢ")

        toeatLiving.habitual = new DefinitionLine(syllabary: "ᎦᏰᏍᎪᎢ")
        toeatLiving.imperative = new DefinitionLine(syllabary: "ᎯᏯᏯᎦ")
        toeatLiving.infinitive = new DefinitionLine(syllabary: "ᎤᏩᏰᏍᏗ")
        toeatLiving.present1st = new DefinitionLine(syllabary:  "ᏥᏯᏰᎠ")
        toeatLiving.present3rd = new DefinitionLine(syllabary: "ᎦᏰᎠ")
        toeatLiving.remotepast = new DefinitionLine(syllabary: "ᎤᏩᏯᎥᎢ")

        takeABite.habitual = new DefinitionLine(syllabary: "ᎠᏥᏍᏕᏍᎪᎢ")
        takeABite.imperative = new DefinitionLine(syllabary: "ᎭᏥᏍᏓᎩ")
        takeABite.infinitive = new DefinitionLine(syllabary: "ᎤᏥᏕᏍᎢ")
        takeABite.present1st = new DefinitionLine(syllabary:  "ᎦᏥᏍᏕᎠ")
        takeABite.present3rd = new DefinitionLine(syllabary: "ᎠᏥᏍᏕᎠ")
        takeABite.remotepast = new DefinitionLine(syllabary: "ᎤᏥᏍᏕᏒᎢ")

        tokill.habitual = new DefinitionLine(syllabary: "ᎠᎯᎰᎢ")
        tokill.imperative = new DefinitionLine(syllabary: "ᎯᎷᎦ")
        tokill.infinitive = new DefinitionLine(syllabary: "ᎤᎯᏍᏗ")
        tokill.present1st = new DefinitionLine(syllabary:  "ᏥᎢᎭ")
        tokill.present3rd = new DefinitionLine(syllabary: "ᎠᎯᎭ")
        tokill.remotepast = new DefinitionLine(syllabary: "ᎤᏢᎢ")

        wearShoes.habitual = new DefinitionLine(syllabary: "ᏚᎳᏑᏠᎢ")
        wearShoes.imperative = new DefinitionLine(syllabary: "ᏕᏣᎳᏑᏞᏍᏗ")
        wearShoes.infinitive = new DefinitionLine(syllabary: "")
        wearShoes.present1st = new DefinitionLine(syllabary:  "ᏓᏆᎳᏑᏝ")
        wearShoes.present3rd = new DefinitionLine(syllabary: "ᏚᎳᏒᏝ")
        wearShoes.remotepast = new DefinitionLine(syllabary: "ᏚᎳᏑᏢᎢ")
    }

    def conj(String subject, String object, Stemmer stemmer, String verbTense, String partofspeechc){
        Conjugate conjugate = new Conjugate()
        return conjugate.conjugate(subject, object, stemmer, verbTense, partofspeechc)
    }

    public void testNothing() {
        //removes warning
    }

    public static String processOriginal(original, assertion) {
        HolderWord hw = processHolderWord(original, assertion)
        def syllabary = hw.syllabary
        def nonFinalSuffix = hw.nonfinalEndingLatin
        def finalEndingLatin = hw.finalEndingLatin
        def prefixLatin = hw.pho.pronounPrefixLatin

        def sb = new StringBuilder()
        if (prefixLatin && prefixLatin != 'null') {
            sb << prefixLatin
        }

        sb << su.parseSyllabary(syllabary)

        if (nonFinalSuffix && finalEndingLatin) {
            sb << nonFinalSuffix
            sb << finalEndingLatin
        } else if (finalEndingLatin) {
            sb << finalEndingLatin
        }

        return sb.toString()
    }

    public static HolderWord processHolderWord(original, assertion) {
        HolderWord hw = new HolderWord()
        def su = new SyllabaryUtil()
        hw.syllabary = original
        FinalSuffixProcessor.removeFinalSuffix(hw)
        PrefixProcessor.removeAllPrefixes(hw)

        return hw;
    }

    public static void processRootForCompare(original, assertion) {
        HolderWord hw = processHolderWord(original, assertion)
        assertEquals("original did not match converted", hw.syllabary + hw.nonfinalEndingLatin, assertion)
    }

    public static void compareForAssertion(original, assertion) {

        assertEquals("original did not match converted", original, su.tsalagiToSyllabary(processOriginal(original, assertion)))
    }
}
