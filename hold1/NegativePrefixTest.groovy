package cherokee.dictionary.verb.conjugation.hold

import cherokee.dictionary.conjugation.TransitiveVerb
import cherokee.dictionary.conjugation.cdpbook.Stemmer
import cherokee.dictionary.conjugation.stem.DefinitionLine

import java.util.regex.Matcher
import java.util.regex.Pattern

public class NegativePrefixTest extends GroovyTestCase {
    static def heSeesIt = new Stemmer()
    static {
        heSeesIt.habitual = new DefinitionLine(syllabary: "ᎠᎪᏩᏘᏍᎪᎢ")
        heSeesIt.imperative = new DefinitionLine(syllabary: "ᎯᎪᏩᏔ")
        heSeesIt.infinitive = new DefinitionLine(syllabary: "ᎤᎪᏩᏛᏗ")
        heSeesIt.present1st = new DefinitionLine(syllabary: "ᏥᎪᏩᏘᎭ")
        heSeesIt.present3rd = new DefinitionLine(syllabary: "ᎠᎪᏩᏘᎭ")
        heSeesIt.remotepast = new DefinitionLine(syllabary: "ᎤᎪᎲᎢ")
    }

    private static final yiString = /[ᏯᏰᏱᏲᏳᏴ]/
    private static final wiString = /[ᏩᏪᏫᏬᏭᏮ]/

    ////y- j- w- n- de- da- di- i- ga- e- pronouns-
    public void testNegative() {
        //y-,negative, conditional
        //form : v- before a vowel , yi- before a consonant, yu- before w-; cf. (1-3),
        def agowatiha = "ᎠᎪᏩᏘᎭ"//he sees it -- base SG3-SG3AN
        def yijigowatiha = "ᏱᏥᎪᏩᏘᎭ"//i don't see it SG1-SG3AN
        def yagowatiha = "ᏯᎪᏩᏘᎭ"// he doesn't see it SG3-SG3AN
        def yigowadi = "ᏱᎪᏩᏘ"//don't you see it -- questioning -- come back to later TODO:
        def yuwagowatiha = "ᏳᏩᎪᏩᏘᎭ"//He doesn't see it (with his back turned - yi-w-agotiha -- compound structure - will have to figure it out todo:
        def jijigowatiha = "ᏥᏥᎪᏩᏘᎭ" //that I saw in the past
        def jigowatiha = "ᏥᎪᏩᏘᎭ"
        def jiginigowatiha = "ᏥᎩᏂᎪᏩᏘᎭ"

        def nania = "ᎾᏂᎣᎢ"
        def gania = "ᎦᏂᎠ"

//        VerbFactory vf = new VerbFactory();
//        Verb v = vf.generateVerb(heSeesIt, Tense.PRESENT.toString(), "v.t.")

//        Conjugate conjugate = new Conjugate()
//        println conjugate.conjugate("SG1", "SG3AN", heSeesIt, Tense.PRESENT.toString(), "v.t.")
//        println conjugate.conjugate("SG3", "SG3AN", heSeesIt, Tense.PRESENT.toString(), "v.t.")

        TransitiveVerb tv = new TransitiveVerb();

        tryIt(yijigowatiha, tv)
        tryIt(yagowatiha, tv)
        tryIt(yigowadi, tv)
        tryIt(agowatiha, tv)
        tryIt(yuwagowatiha, tv)
        tryIt(jijigowatiha, tv)
        tryIt(jigowatiha, tv)
        tryIt(jiginigowatiha, tv)
        tryIt(nania, tv)
        tryIt(gania, tv)


//        m.appendTail(sb);

//        PrefixInterpreter.interpret(yijigowatiha)
    }

    private void tryIt(testWord, tv) {
        testYi(testWord, tv)
        if (tv.yi) {
            println tv.yi
            println tv.baseVerbEntry
        }

//        testJi(testWord, tv)
//        if (tv.ji) {
//            println tv.ji
//            println tv.baseVerbEntry
//        }
//
//        testW(testWord, tv)
//        if (tv.wi) {println tv.wi}
//
//        testN(testWord, tv)
//        if (tv.ni) {
//            println tv.ni
//        }

//        println tv.py
//        println tv.baseVerbEntry
//        println ""
    }

    private void testYi(testWord, TransitiveVerb tv) {
        String[] starr = testRegex(testWord, "^([ᏯᏰᏱᏲᏳᏴ]{1})(.*)")
        if (starr[1]) {
            tv.setYi(starr[1])
            tv.baseVerbEntry = starr[2]
        } else {
//            println testWord
//            println "Nothing found"
            tv.setYi("")
            tv.baseVerbEntry = testWord
        }
    }

    private void testJi(testWord, TransitiveVerb tv) {
        String[] starr = testRegex(testWord, "^([ᏣᏥᏤᏦᏧᏨ]{1})(.*)")
        Pattern pattern = Pattern.compile("^([ᏣᏥᏤᏦᏧᏨ]{2})(.*)")
        Matcher m = pattern.matcher(testWord);
        boolean dualJi = false;
        while(m.find()) {
            def one = m.group(1)
            if (one) {
                tv.setJi(one)
                tv.setBaseVerbEntry(m.group(2))
//                println "there are two instances of JI"
                dualJi = true;
            }
        }

        if (!dualJi) {
            tv.setJi(starr[1])
            tv.baseVerbEntry = starr[2]
        } else {
            tv.setJi("")
            tv.baseVerbEntry = testWord
        }
    }

    private void testW(testWord, tv) {
//        println "base verb entry " + tv.baseVerbEntry
        String[] starr = testRegex(tv.baseVerbEntry, "^([ᏩᏪᏫᏬᏭᏮ]{1})(.*)")
        if (starr[1]) {
            tv.setWi(starr[1])
            tv.baseVerbEntry = starr[2]
//            println "base verb entry 2 is ${starr[2]}"
            //todo: here is where wa is swapped for wa- - and a-
        } else {
            tv.setWi("")
            tv.baseVerbEntry = testWord
        }
    }

    private void testN(testWord, tv) {
        String[] starr = testRegex(testWord, "^([ᎾᏂᏁᏃᏄᏅ]{1})(.*)")
        if (starr[1]) {
            tv.setNi(starr[1])
            tv.baseVerbEntry = starr[2]
            println "found na"
        } else {
            tv.setNi("")
            tv.baseVerbEntry = testWord
        }
    }

    private String[] testRegex(testWord, regex) {
        Pattern pattern = Pattern.compile(regex);
        Matcher m = pattern.matcher(testWord);
        String groupZero = "";
        String groupOne = "";
        String groupTwo = "";

        while (m.find()) {
            groupZero = m.group(0);
            groupOne = m.group(1);
            groupTwo = m.group(2);
//            text = text.replaceAll("\\?", "")
//            m.appendReplacement(sb, Matcher.quoteReplacement(text));
        }

        if (groupZero == (groupOne + groupTwo)) {
//            println "all matches"
        }

        return [groupZero, groupOne, groupTwo] as String[]
    }
}