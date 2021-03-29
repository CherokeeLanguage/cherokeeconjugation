package cherokee.old.util

import cherokee.dictionary.utils.Morphemes

class MorphemeTest extends GroovyTestCase {
    public void testMorphemeG() {
        assertEquals("Ꭶ", Morphemes.processG("Ꭰ"))
        assertEquals("Ꭸ", Morphemes.processG("Ꭱ"))
        assertEquals("Ꭹ", Morphemes.processG("Ꭲ"))
        assertEquals("Ꭺ", Morphemes.processG("Ꭳ"))
        assertEquals("Ꭻ", Morphemes.processG("Ꭴ"))
        assertEquals("Ꭼ", Morphemes.processG("Ꭵ"))
    }

    public void testMorphemeD() {
        assertEquals("Ꮣ", Morphemes.processD("Ꭰ"))
        assertEquals("Ꮥ", Morphemes.processD("Ꭱ"))
        assertEquals("Ꮧ", Morphemes.processD("Ꭲ"))
        assertEquals("Ꮩ", Morphemes.processD("Ꭳ"))
        assertEquals("Ꮪ", Morphemes.processD("Ꭴ"))
        assertEquals("Ꮫ", Morphemes.processD("Ꭵ"))
    }

    public void testMorphemeY() {
        assertEquals("Ꮿ", Morphemes.processY("Ꭰ"))
        assertEquals("Ᏸ", Morphemes.processY("Ꭱ"))
        assertEquals("Ᏹ", Morphemes.processY("Ꭲ"))
        assertEquals("Ᏺ", Morphemes.processY("Ꭳ"))
        assertEquals("Ᏻ", Morphemes.processY("Ꭴ"))
        assertEquals("Ᏼ", Morphemes.processY("Ꭵ"))
    }

    public void testMorphemeN() {
        assertEquals("Ꮎ", Morphemes.processN("Ꭰ"))
        assertEquals("Ꮑ", Morphemes.processN("Ꭱ"))
        assertEquals("Ꮒ", Morphemes.processN("Ꭲ"))
        assertEquals("Ꮓ", Morphemes.processN("Ꭳ"))
        assertEquals("Ꮔ", Morphemes.processN("Ꭴ"))
        assertEquals("Ꮕ", Morphemes.processN("Ꭵ"))
    }

    public void testMorphemeGW() {
        assertEquals("Ꮖ", Morphemes.processGW("Ꭰ"))
        assertEquals("Ꮗ", Morphemes.processGW("Ꭱ"))
        assertEquals("Ꮘ", Morphemes.processGW("Ꭲ"))
        assertEquals("Ꮙ", Morphemes.processGW("Ꭳ"))
        assertEquals("Ꮚ", Morphemes.processGW("Ꭴ"))
        assertEquals("Ꮛ", Morphemes.processGW("Ꭵ"))
    }

    public void testMorphemeH() {
        assertEquals("Ꭽ", Morphemes.processH("Ꭰ"))
        assertEquals("Ꭾ", Morphemes.processH("Ꭱ"))
        assertEquals("Ꭿ", Morphemes.processH("Ꭲ"))
        assertEquals("Ꮀ", Morphemes.processH("Ꭳ"))
        assertEquals("Ꮁ", Morphemes.processH("Ꭴ"))
        assertEquals("Ꮂ", Morphemes.processH("Ꭵ"))
    }

    public void testMorphemeJ() {
        assertEquals("Ꮳ", Morphemes.processJ("Ꭰ"))
        assertEquals("Ꮴ", Morphemes.processJ("Ꭱ"))
        assertEquals("Ꮵ", Morphemes.processJ("Ꭲ"))
        assertEquals("Ꮶ", Morphemes.processJ("Ꭳ"))
        assertEquals("Ꮷ", Morphemes.processJ("Ꭴ"))
        assertEquals("Ꮸ", Morphemes.processJ("Ꭵ"))
    }

    public void testMorphemeW() {
        assertEquals("Ꮹ", Morphemes.processW("Ꭰ"))
        assertEquals("Ꮺ", Morphemes.processW("Ꭱ"))
        assertEquals("Ꮻ", Morphemes.processW("Ꭲ"))
        assertEquals("Ꮼ", Morphemes.processW("Ꭳ"))
        assertEquals("Ꮽ", Morphemes.processW("Ꭴ"))
        assertEquals("Ꮾ", Morphemes.processW("Ꭵ"))
    }
    /*
    public void testMorphemes() {
        Morphemes.D.each {
            println "assertEquals(\"${it.value}\", Morphemes.processD(\"${it.key}\"))"
        }

        Morphemes.Y.each {
            println "assertEquals(\"${it.value}\", Morphemes.processY(\"${it.key}\"))"
        }

        Morphemes.N.each {
            println "assertEquals(\"${it.value}\", Morphemes.processN(\"${it.key}\"))"
        }

        Morphemes.GW.each {
            println "assertEquals(\"${it.value}\", Morphemes.processGW(\"${it.key}\"))"
        }

        Morphemes.H.each {
            println "assertEquals(\"${it.value}\", Morphemes.processH(\"${it.key}\"))"
        }

        Morphemes.J.each {
            println "assertEquals(\"${it.value}\", Morphemes.processJ(\"${it.key}\"))"
        }

        Morphemes.W.each {
            println "assertEquals(\"${it.value}\", Morphemes.processW(\"${it.key}\"))"
        }
    }*/
}
