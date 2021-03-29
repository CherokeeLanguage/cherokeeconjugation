package cherokee.dictionary.verb.conjugation

import NonFinalSuffixHolderObject
import PrefixHolderObject
import SuffixHolderObject
import Stemmer
import DefinitionLine

/**
 * This test is a complete verb generation test
 * It takes a verb and reduces it to a stem
 *   conjugate the verb
 *   remove the final ending to get the root
 *   write test where I've found roots from verb books like king
 *      and add to list to verify that this part is working across the board
 *   giving us root and a possible latin sound (h, g, s, etc)
 *   write prefix, non final, final suffix rule
 *      syll -> we have tense, de, ending -> encapsulated in an object
 *      tsal -> ?
 *      english -> approximate translation from ced
 */
class VerbGeneratorTest extends GroovyTestCase {
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

    public void testRemoveFinalEnding() {

    }
}
