package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec
import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import groovy.util.GroovyTestCase

class AyAnPrintSpec extends GroovyTestCase {
    void testPrint() {
        // tio 19Nov26: print the engine's canonical parse-back roman for the
        // SG1/SG2/PL1INCL SG3AN completive/infinitive cells of the Ay* specs
        def specs = [
            [name:"Ayega",        stem3:"ᎠᏰᎦ",        row1p:"ᏥᏯᏰᎦ",        detail:[SG1:[PRE:"jiyegaha"], SG2:[PRE:"hiyegaha"], PL1INCL:[PRE:"idiyegaha"]]],
        ]
        def detail = { String verb ->
            def d = VerbBaseSpec.getDefinition(verb) ?: null
            return d
        }
        // simpler: reuse the harness verbs' citation rows from the spec files via reflection is heavy;
        // instead conjugate the known citation data inline
        def data = [
            [n:"Ayega",        p3:"ᎠᏰᎦ",        p1:"ᏥᏯᏰᎦ",        h3:"ᎠᏰᎦᎰᎢ"],
            [n:"Ayhwidiha",    p3:"ᎠᏲᏪᏗᎭ",     p1:"ᏥᏯᏲᏪᏗᎭ"],
            [n:"Ayiha",        p3:"ᎠᏲᎭ",        p1:"ᏥᏯᏲᎭ"],
            [n:"Ayohiha",      p3:"ᎠᏲᎯᎭ",       p1:"ᏥᏯᏲᎯᎭ"],
            [n:"Ayosdi",       p3:"ᎠᏲᏍᏗᎭ",      p1:"ᏥᏲᏍᏗᎭ"],
            [n:"Ayostanohvsga",p3:"ᎠᏲᏍᏓᏃᎲᎦ",   p1:"ᏥᏯᏲᏍᏓᏃᎲᎦ"],
            [n:"Ayvhiha",      p3:"ᎠᏴᎯᎭ",       p1:"ᏥᏯᏴᎯᎭ"],
            [n:"Ayvhwahtiha",  p3:"ᎠᏴᏩᏘᎭ",     p1:"ᏥᏯᏴᏩᏘᎭ"],
        ]
        data.each { v ->
            println v.n + " present1st=" + v.p1
        }
    }
}
