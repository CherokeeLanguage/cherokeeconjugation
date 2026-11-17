package net.cherokeedictionary.conjugation

import groovy.util.GroovyTestCase
import net.cherokeedictionary.transliteration.SyllabaryUtil

class TranslitProbeTest extends GroovyTestCase {
    void testProbe() {
        def sb = new StringBuilder()
        sb.append('ced(yhdi) = ').append(SyllabaryUtil.tsalagiToSyllabaryCed('yhdi')).append('\n')
        sb.append('ced(sdayhdi) = ').append(SyllabaryUtil.tsalagiToSyllabaryCed('sdayhdi')).append('\n')
        sb.append('ced(dayhdi) = ').append(SyllabaryUtil.tsalagiToSyllabaryCed('dayhdi')).append('\n')
        new File('build/probe13.txt').setText(sb.toString(), 'UTF-8')
        println "PROBE13 done"
    }
}
