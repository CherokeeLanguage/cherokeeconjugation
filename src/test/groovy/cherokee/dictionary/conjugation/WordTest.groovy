package cherokee.dictionary.conjugation

import cherokee.dictionary.conjugation.affixes.processors.AffixProcessor
import cherokee.dictionary.conjugation.affixes.NonFinalSuffixHolderObject
import cherokee.dictionary.conjugation.affixes.PrefixHolderObject
import cherokee.dictionary.conjugation.affixes.processors.PrefixProcessor
import cherokee.dictionary.conjugation.affixes.SuffixHolderObject
import cherokee.dictionary.conjugation.cdpbook.Stemmer
import cherokee.dictionary.conjugation.conjugate.Tense
import cherokee.dictionary.conjugation.stem.DefinitionLine
import com.cobradoc.cherokee.SyllabaryUtil

class WordTest extends GroovyTestCase {
    static def heSeesIt = new Stemmer()
    static def bleed = new Stemmer()
    static def speak = new Stemmer()
    PrefixHolderObject pho = new PrefixHolderObject()
    SuffixHolderObject sho = new SuffixHolderObject()
    NonFinalSuffixHolderObject nfo = new NonFinalSuffixHolderObject()
    Conjugate conjugate = new Conjugate()
    
    static def DNM = "FAILURE DID NOT MATCH"
    static {
        heSeesIt.habitual = new DefinitionLine(syllabary: "ᎠᎪᏩᏘᏍᎪᎢ")
        heSeesIt.imperative = new DefinitionLine(syllabary: "ᎯᎪᏩᏔ")
        heSeesIt.infinitive = new DefinitionLine(syllabary: "ᎤᎪᏩᏛᏗ")
        heSeesIt.present1st = new DefinitionLine(syllabary: "ᏥᎪᏩᏘᎭ")
        heSeesIt.present3rd = new DefinitionLine(syllabary: "ᎠᎪᏩᏘᎭ")
        heSeesIt.remotepast = new DefinitionLine(syllabary: "ᎤᎪᎲᎢ")

        bleed.habitual = new DefinitionLine(syllabary: "ᎠᏔᏍᎩᏍᎪᎢ")
        bleed.imperative = new DefinitionLine(syllabary: "ᎭᏔᏍᎩ")
        bleed.infinitive = new DefinitionLine(syllabary: "ᎤᏔᏍᎩᏍᏗ")
        bleed.present1st = new DefinitionLine(syllabary: "ᎦᏔᏍᎩᎠ")
        bleed.present3rd = new DefinitionLine(syllabary: "ᎠᏔᏍᎩᎠ")
        bleed.remotepast = new DefinitionLine(syllabary: "ᎤᏔᏍᎩᏒᎢ")

        speak.habitual = new DefinitionLine(syllabary: "ᎦᏬᏂᏍᎪᎢ")
        speak.imperative = new DefinitionLine(syllabary: "ᎯᏬᏂᎯ")
        speak.infinitive = new DefinitionLine(syllabary: "ᎤᏬᏂᎯᏍᏗ")
        speak.present1st = new DefinitionLine(syllabary:  "ᏥᏬᏂᎭ")
        speak.present3rd = new DefinitionLine(syllabary: "ᎦᏬᏂᎭ")
        speak.remotepast = new DefinitionLine(syllabary: "ᎤᏬᏂᏒᎢ")
    }

    public void testPrefixes() {
        def SG1SG3AN = conjugate.conjugate("SG1", "SG3AN", heSeesIt, Tense.PRESENT.toString(), "v.t.")
        def SG3SG3AN = conjugate.conjugate("SG3", "SG3AN", heSeesIt, Tense.PRESENT.toString(), "v.t.")
        def SG2SG3AN = conjugate.conjugate("SG2", "SG3AN", heSeesIt, Tense.PRESENT.toString(), "v.t.")

        assertEquals(DNM, "ᏥᎪᏩᏘᎭ" , AffixProcessor.processWordAdd(SG1SG3AN, pho, nfo, sho, Tense.PRESENT))
        assertEquals(DNM, "ᎠᎪᏩᏘᎭ" , AffixProcessor.processWordAdd(SG3SG3AN, pho, nfo, sho, Tense.PRESENT))
        assertEquals(DNM, "ᎯᎪᏩᏘᎭ" , AffixProcessor.processWordAdd(SG2SG3AN, pho, nfo, sho, Tense.PRESENT))

        pho.yi = true;
        assertEquals(DNM, "ᏱᏥᎪᏩᏘᎭ" , AffixProcessor.processWordAdd(SG1SG3AN, pho, nfo, sho, Tense.PRESENT))
        assertEquals(DNM, "ᏯᎪᏩᏘᎭ" , AffixProcessor.processWordAdd(SG3SG3AN, pho, nfo, sho, Tense.PRESENT))
        assertEquals(DNM, "ᏱᎯᎪᏩᏘᎭ" , AffixProcessor.processWordAdd(SG2SG3AN, pho, nfo, sho, Tense.PRESENT))

        pho.ga = true;
        assertEquals(DNM, "ᏱᎦᏥᎪᏩᏘᎭ" , AffixProcessor.processWordAdd(SG1SG3AN, pho, nfo, sho, Tense.PRESENT))
        assertEquals(DNM, "ᏱᎬᎪᏩᏘᎭ" , AffixProcessor.processWordAdd(SG3SG3AN, pho, nfo, sho, Tense.PRESENT))
        assertEquals(DNM, "ᏱᎦᎯᎪᏩᏘᎭ" , AffixProcessor.processWordAdd(SG2SG3AN, pho, nfo, sho, Tense.PRESENT))

        pho.ga = false;
        pho.ni = true;
        assertEquals(DNM, "ᏱᏂᏥᎪᏩᏘᎭ" , AffixProcessor.processWordAdd(SG1SG3AN, pho, nfo, sho, Tense.PRESENT))
        assertEquals(DNM, "ᏱᎾᎪᏩᏘᎭ" , AffixProcessor.processWordAdd(SG3SG3AN, pho, nfo, sho, Tense.PRESENT))
        assertEquals(DNM, "ᏱᏂᎯᎪᏩᏘᎭ" , AffixProcessor.processWordAdd(SG2SG3AN, pho, nfo, sho, Tense.PRESENT))

        pho.yi = false;
        pho.ga = false;
        pho.ni = false;
        pho.wi = true;
        assertEquals(DNM, "ᏫᏥᎪᏩᏘᎭ" , AffixProcessor.processWordAdd(SG1SG3AN, pho, nfo, sho, Tense.PRESENT))
        assertEquals(DNM, "ᏩᎪᏩᏘᎭ" , AffixProcessor.processWordAdd(SG3SG3AN, pho, nfo, sho, Tense.PRESENT))
        assertEquals(DNM, "ᏫᎯᎪᏩᏘᎭ" , AffixProcessor.processWordAdd(SG2SG3AN, pho, nfo, sho, Tense.PRESENT))

        pho.yi = true;
        pho.ga = false;
        pho.ni = false;
        pho.wi = true;
        assertEquals(DNM, "ᏳᏫᏥᎪᏩᏘᎭ" , AffixProcessor.processWordAdd(SG1SG3AN, pho, nfo, sho, Tense.PRESENT))
        assertEquals(DNM, "ᏳᏩᎪᏩᏘᎭ" , AffixProcessor.processWordAdd(SG3SG3AN, pho, nfo, sho, Tense.PRESENT))
        assertEquals(DNM, "ᏳᏫᎯᎪᏩᏘᎭ" , AffixProcessor.processWordAdd(SG2SG3AN, pho, nfo, sho, Tense.PRESENT))

        pho.yi = true;
        pho.ga = true;
        pho.ni = true;
        pho.wi = true;
        assertEquals(DNM, "ᏳᏫᏂᎦᏥᎪᏩᏘᎭ" , AffixProcessor.processWordAdd(SG1SG3AN, pho, nfo, sho, Tense.PRESENT))
        assertEquals(DNM, "ᏳᏫᏂᎬᎪᏩᏘᎭ" , AffixProcessor.processWordAdd(SG3SG3AN, pho, nfo, sho, Tense.PRESENT))
        assertEquals(DNM, "ᏳᏫᏂᎦᎯᎪᏩᏘᎭ" , AffixProcessor.processWordAdd(SG2SG3AN, pho, nfo, sho, Tense.PRESENT))


        pho = new PrefixHolderObject()
        def bleedSG1 = conjugate.conjugate("SG1", "SG3IN", bleed, Tense.PRESENT.toString(), "v.i.")
        def bleedSG2_FUTURE_IMPERATIVE = conjugate.conjugate("SG2", "SG3IN", bleed, Tense.FUTURE_COMMAND.toString(), "v.i.")
        def bleedSG3_PAST = conjugate.conjugate("SG3", "SG3IN", bleed, Tense.REMOTE_PAST.toString(), "v.i.")

        assertEquals(DNM, "ᎦᏔᏍᎩᎠ", AffixProcessor.processWordAdd(bleedSG1, pho, nfo, sho, Tense.PRESENT))
        assertEquals(DNM, "ᎭᏔᏍᎩ", AffixProcessor.processWordAdd(bleedSG2_FUTURE_IMPERATIVE, pho, nfo, sho, Tense.FUTURE_COMMAND))
        assertEquals(DNM, "ᎤᏔᏍᎩᏒᎢ", AffixProcessor.processWordAdd(bleedSG3_PAST, pho, nfo, sho, Tense.REMOTE_PAST))


        pho.yi = true
        assertEquals(DNM, "ᏱᎦᏔᏍᎩᎠ", AffixProcessor.processWordAdd(bleedSG1, pho, nfo, sho, Tense.PRESENT))

        pho.yi = false
        pho.wi = true
        assertEquals(DNM, "ᏫᎦᏔᏍᎩᎠ", AffixProcessor.processWordAdd(bleedSG1, pho, nfo, sho, Tense.PRESENT))

        pho.yi = false
        pho.wi = false
        pho.ni = true
        assertEquals(DNM, "ᏂᎦᏔᏍᎩᎠ", AffixProcessor.processWordAdd(bleedSG1, pho, nfo, sho, Tense.PRESENT))

        pho.yi = false
        pho.wi = false
        pho.ni = false
        pho.i = true
        assertEquals(DNM, "ᎥᎦᏔᏍᎩᎠ", AffixProcessor.processWordAdd(bleedSG1, pho, nfo, sho, Tense.PRESENT))
        assertEquals(DNM, "ᎢᏥᎪᏩᏘᎭ" , AffixProcessor.processWordAdd(SG1SG3AN, pho, nfo, sho, Tense.PRESENT))
        assertEquals(DNM, "ᎥᎦᏔᏍᎩᎠ", AffixProcessor.processWordAdd(bleedSG1, pho, nfo, sho, Tense.REMOTE_PAST))
        assertEquals(DNM, "ᎥᏥᎪᏩᏘᎭ" , AffixProcessor.processWordAdd(SG1SG3AN, pho, nfo, sho, Tense.REMOTE_PAST))

        pho.de = true
        assertEquals(DNM, "ᏙᎦᏔᏍᎩᎠ", AffixProcessor.processWordAdd(bleedSG1, pho, nfo, sho, Tense.PRESENT))
        assertEquals(DNM, "ᏙᏥᎪᏩᏘᎭ" , AffixProcessor.processWordAdd(SG1SG3AN, pho, nfo, sho, Tense.PRESENT))

        pho.i = false
        pho.e = true
        assertEquals(DNM, "ᏙᏗᎦᏔᏍᎩᎠ", AffixProcessor.processWordAdd(bleedSG1, pho, nfo, sho, Tense.PRESENT))

        pho.de = false
        assertEquals(DNM, "ᎡᎦᏔᏍᎩᎠ", AffixProcessor.processWordAdd(bleedSG1, pho, nfo, sho, Tense.PRESENT))

        def seeSG3DL2 = conjugate.conjugate("SG3", "DL2", heSeesIt, Tense.PRESENT.toString(), "v.t.")
        def seeSG3DL2FC = conjugate.conjugate("SG3", "DL2", heSeesIt, Tense.FUTURE_COMMAND.toString(), "v.t.")

        pho = new PrefixHolderObject()
        assertEquals(DNM, "ᏍᏗᎪᏩᏘᎭ", AffixProcessor.processWordAdd(seeSG3DL2, pho, nfo, sho, Tense.PRESENT))
        assertEquals(DNM, "ᏍᏗᎪᏩᏘ", AffixProcessor.processWordAdd(seeSG3DL2FC, pho, nfo, sho, Tense.FUTURE_COMMAND))

        pho.e = true
        assertEquals(DNM, "ᎡᏍᏗᎪᏩᏘᎭ", AffixProcessor.processWordAdd(seeSG3DL2, pho, nfo, sho, Tense.PRESENT))
        assertEquals(DNM, "ᎡᏍᏗᎪᏩᏘ", AffixProcessor.processWordAdd(seeSG3DL2FC, pho, nfo, sho, Tense.FUTURE_COMMAND))

        pho.de = true
        assertEquals(DNM, "ᏙᏗᏍᏗᎪᏩᏘᎭ", AffixProcessor.processWordAdd(seeSG3DL2, pho, nfo, sho, Tense.PRESENT))
        assertEquals(DNM, "ᏙᏗᏍᏗᎪᏩᏘ", AffixProcessor.processWordAdd(seeSG3DL2FC, pho, nfo, sho, Tense.FUTURE_COMMAND))

        def seeDL2SG3AN = conjugate.conjugate("DL2", "SG3AN", heSeesIt, Tense.PRESENT.toString(), "v.t.")
        def seeDL2SG3ANFC = conjugate.conjugate("DL2", "SG3AN", heSeesIt, Tense.FUTURE_COMMAND.toString(), "v.t.")

//        pho = new PrefixHolderObject()
//        assertEquals(DNM, "ᎡᏍᏗᎪᏩᏘᎭ", AffixProcessor.processWordAdd(seeDL2SG3AN, pho, nfo, sho, Tense.PRESENT))
//        assertEquals(DNM, "ᎡᏍᏗᎪᏩᏘ", AffixProcessor.processWordAdd(seeDL2SG3AN, pho, Tense.FUTURE_COMMAND))
    }

    public void testDiPrefix() {
        Conjugate conjugate = new Conjugate()
        def bpf = new PrefixProcessor()
        def pho = new PrefixHolderObject()
        SuffixHolderObject sho = new SuffixHolderObject()
        NonFinalSuffixHolderObject nfo = new NonFinalSuffixHolderObject()
        def su = new SyllabaryUtil()

        def speakSG3SG3IN = conjugate.conjugate("SG3", "SG3IN", heSeesIt, Tense.PRESENT.toString(), "v.t.")
        def speakSG3SG3IN_PAST = conjugate.conjugate("SG3", "SG3IN", heSeesIt, Tense.REMOTE_PAST.toString(), "v.t.")
        def speakSG3SG3AN = conjugate.conjugate("SG3", "SG3AN", heSeesIt, Tense.PRESENT.toString(), "v.t.")
        def speak1PLEXCLSG3AN = conjugate.conjugate("SG3", "PL2", heSeesIt, Tense.PRESENT.toString(), "v.t.")


        assertEquals(DNM, "ᎦᎪᏩᏘᎭ", AffixProcessor.processWordAdd(speakSG3SG3IN, pho, nfo, sho, Tense.PRESENT))
        pho.di = true;
        assertEquals(DNM, "ᏗᎦᎪᏩᏘᎭ", AffixProcessor.processWordAdd(speakSG3SG3IN, pho, nfo, sho, Tense.PRESENT))
        pho.di = false;
        assertEquals(DNM, "ᎤᎪᎲᎢ", AffixProcessor.processWordAdd(speakSG3SG3IN_PAST, pho, nfo, sho, Tense.REMOTE_PAST))
        pho.di = true;
        assertEquals(DNM, "ᏓᏳᎪᎲᎢ", AffixProcessor.processWordAdd(speakSG3SG3IN_PAST, pho, nfo, sho, Tense.REMOTE_PAST))
        pho.di = false;
        assertEquals(DNM, "ᎠᎪᏩᏘᎭ", AffixProcessor.processWordAdd(speakSG3SG3AN, pho, nfo, sho, Tense.PRESENT))
        pho.di = true;
        assertEquals(DNM, "ᏗᎪᏩᏘᎭ", AffixProcessor.processWordAdd(speakSG3SG3AN, pho, nfo, sho, Tense.PRESENT))
        pho.di = false;
        assertEquals(DNM, "ᎢᏥᎪᏩᏘᎭ", AffixProcessor.processWordAdd(speak1PLEXCLSG3AN, pho, nfo, sho, Tense.PRESENT))
        pho.di = true;
        assertEquals(DNM, "ᏗᏥᎪᏩᏘᎭ", AffixProcessor.processWordAdd(speak1PLEXCLSG3AN, pho, nfo, sho, Tense.PRESENT))


        def seeSG1SG3IN = conjugate.conjugate("SG3", "SG3IN", heSeesIt, Tense.REMOTE_PAST.toString(), "v.t.")
        def seeDL2SG3ANFC = conjugate.conjugate("DL2", "SG3AN", heSeesIt, Tense.REMOTE_PAST.toString(), "v.t.")


        pho.di = false;
        assertEquals(DNM, "ᎤᎪᎲᎢ", AffixProcessor.processWordAdd(seeSG1SG3IN, pho, nfo, sho, Tense.REMOTE_PAST))
        pho.di = true;
        assertEquals(DNM, "ᏓᏳᎪᎲᎢ", AffixProcessor.processWordAdd(seeSG1SG3IN, pho, nfo, sho, Tense.REMOTE_PAST))
        assertEquals(DNM, "ᏓᏥᎪᏩᏘᏍᎬᎢ", AffixProcessor.processWordAdd("ᏥᎪᏩᏘᏍᎬᎢ", pho, nfo, sho, Tense.REMOTE_PAST))

        //fix these progressive past
//        assertEquals(DNM, "ᏛᎪᏩᏘᏍᎬᎢ", AffixProcessor.processWordAdd("ᎠᎪᏩᏘᏍᎬᎢ", pho, nfo, sho, Tense.REMOTE_PAST))
//        assertEquals(DNM, "ᏓᏂᎪᏩᏘᏍᎬᎢ", AffixProcessor.processWordAdd("ᎢᏂᎪᏩᏘᏍᎬᎢ", pho, nfo, sho, Tense.REMOTE_PAST))
//        assertEquals(DNM, "ᏂᏓᏳᎪᏩᏛᏗ", AffixProcessor.processWordAdd("ᎤᎪᏩᏛᏗ", pho, nfo, sho, Tense.REMOTE_PAST))
//        println su.tsalagiToSyllabary("ugowatvdi")
//        println su.tsalagiToSyllabary("nidayugowatvdi")




//        When di- appears in a verb form ending in the past tense suffix -vʔi,
// it changes to da- before consonants and vowels, with a -y- inserted before vowels other than -a-; a following -a- is deleted; cf. (103-105).
// These changes occur in both progressive and non-progressive past tense forms with -vʔi, but not with -eʔi; see(100) .

//
//        (105) a. a1gowh2ti23sgv3ʔi . "He was seeing it."
//
//        b. dv2gowh3ti2sgv23ʔi. "He was seeing it (facing the speaker).
//
//        An -i- is deleted after da-; see (106).
//
//                (106) a. i1ni2gowh2ti23sgv3ʔi. "You and I were seeing it."
//
//        b. dalni23gowh3ti2sgv23ʔ. "You and I were seeing it(facing the speaker)."
//
//        The changes noted above in (103-105) also take place in infinitive forms; in
//
//        addition, any infinitive form with di- must be preceded by ni-. Note(107), in which di- changes to da- with -y- inserted before a vowel, and in which ni- is added to the infinitive form.
//
//        (107) a. u2gowh2tvh3di uldu21i. "He wants him to see it."
//
//        b. nị2dạ2yu3gowh2tvh3di uldu21i. "He wants him to see it (facing the speaker)."
//
//        While ni- is also inserted before da-, motion toward speaker, in infinitive forms,the forms of da- remain the same; i.e., the forms of da- which occur
// following ni- in infinitives are those illustrated by (88-91).
//
//                function: di- is employed with non-motion verbs to indicate that the subject of the verb is facing the speaker. It also occurs with verbs such as the "to fight,"
// which involve motion which does not take place in a straight line; i.e., although there is obviously motion involved in fighting,
// the motion is essentially non-directional. Transitive motion verbs such as "to bring" also take di-; in forms in like (108),
// it is understood that the subject of the verb is bringing the object in question to a position adjacent to the speaker. With a few verbs,
// such as "to fight," di- simply indicates that the subject of the verb is in a distant view from the speaker. This function of di- seems to be
// limited to verbs such as "to fight" in which the nature of the action indicated by the verb involves nondirectional motion.

//        (108) di2hyo3hị2ha. "He is bringing it (to a position adjacent to the speaker)."
//
//        comments: As indicated in Figure Two, da-, future, da- motion toward speaker, and di- are mutually exclusive. Further study may indicate that da-,
// motion toward speaker, and di- position facing speaker or motion toward speaker, should be ana1yzed as a single prefix. Such an analysis would require fairly
// detailed rules to provide the correct form of the prefix in the various contexts described above.
    }


}