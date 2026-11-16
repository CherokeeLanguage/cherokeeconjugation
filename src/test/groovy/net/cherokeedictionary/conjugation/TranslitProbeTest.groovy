package net.cherokeedictionary.conjugation

import groovy.util.GroovyTestCase
import net.cherokeedictionary.transliteration.SyllabaryUtil

class TranslitProbeTest extends GroovyTestCase {
    void testProbe() {
        def sb = new StringBuilder()
        [['Ꮅ','l-glyph'],['Ꮆ','hlo'],['Ꮈ','hlv'],['Ꮬ','dla'],['Ꮭ','tla']].each { g ->
            sb.append(g[1]).append(' parse=').append(SyllabaryUtil.parseSyllabary(g[0])).append('\n')
        }
        sb.append('tsalagi("gadehloqwaa") = ').append(SyllabaryUtil.tsalagiToSyllabary('gadehloqwaa')).append('\n')
        sb.append('tsalagi("gadeloqwaa") = ').append(SyllabaryUtil.tsalagiToSyllabary('gadeloqwaa')).append('\n')
        new File('build/probe9.txt').setText(sb.toString(), 'UTF-8')
        println "PROBE9 done"
    }
}
