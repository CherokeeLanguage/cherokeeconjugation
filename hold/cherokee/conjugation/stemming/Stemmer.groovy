package cherokee.conjugation.stemming

import RemotePast
import Tense
import net.cherokeedictionary.transliteration.SyllabaryUtil
import org.apache.commons.lang3.StringUtils

/**
 * Created by torr on 8/16/2015.
 */
class Stemmer {
    DefinitionLine present3rd = null
    DefinitionLine present1st = null
    DefinitionLine remotepast = null
    DefinitionLine habitual = null
    DefinitionLine imperative = null
    DefinitionLine infinitive = null

    public String getRoot(Tense type) {
        String stem = SyllabaryUtil.parseSyllabary(getStem(type))
        String root = ""

        if (type == Tense.REMOTE_PAST) {
            root = stem.substring(0, stem.indexOf("vi"))
            def lastChar = root.charAt(root.size()-1)
            if (RemotePast.ROOTENDINGS.contains(lastChar)) {
                root = root.substring(0, root.size() - 1)
                println lastChar + root
            }
        }

        return root
    }
    
    String getStem(Tense type) {
        def returnValue = ""
        getStems().each {
            if (it.stemtype == type) {
                returnValue = it.syllabary
            }
        }

        return returnValue
    }

    private String processStemEntry(item, element) {
        if (item != null && item.syllabary != null) {
            element = StringUtils.strip(item.syllabary)
            if (element.contains(",")) {
                eleement = StringUtils.substringBefore(element, ",")
                element = StringUtils.strip(element)
            }
        } else {
            element = ""
        }

        return element
    }

    List<StemEntry> getStems() {
        NormalizedVerbEntry e = new NormalizedVerbEntry()

        e.pres3 = processStemEntry(present3rd, e.pres3)
        e.pres1 = processStemEntry(present1st, e.pres1)
        e.past = processStemEntry(remotepast, e.past)
        e.habit = processStemEntry(habitual, e.habit)
        e.imp = processStemEntry(imperative, e.imp)
        e.inf = processStemEntry(infinitive, e.inf)

        /*
         * Strip direct object if easy to identify
         */
        NormalizedVerbEntry.removeDirectObject(e)
        /*
         * Strip Ꮻ- prefix if easy to identify
         */
        NormalizedVerbEntry.removeWiprefix(e)
        /*
         * Strip Ꮒ- prefix if easy to identify
         */
        NormalizedVerbEntry.removeNiprefix(e)
        /*
         * String Ꮥ- prefix if easy to identify
         */
        NormalizedVerbEntry.removeDeprefix(e)
        /*
         * String Ꭲ- (again) prefix if easy to identify
         */
        NormalizedVerbEntry.removeIprefix(e)

        /*
		 * Convert animate to inanimate.
		 */
        reformatAsInanimate(e)

        List<StemEntry> a3rd = a3rd(e)
        if (a3rd) {
            return a3rd
        }

        List<StemEntry> ga3rd = ga3rd(e)
        if (ga3rd) {
            return ga3rd
        }

        List<StemEntry> ka3rd = ka3rd(e)
        if (ka3rd) {
            return ka3rd
        }

        if (e.pres3.startsWith("Ꭴ") && e.pres1.startsWith("ᎠᏆ")) {
            println "starts with agw && u"
            return generateVowelStems("Ꭰ", e)
        }

        if (e.pres3.startsWith("Ꭼ") && e.past.startsWith("ᎤᏩ")) {
            e.past = discardPrefix(e.past)
            e.inf = discardPrefix(e.inf)
            return generateVowelStems("Ꭵ", e)
        }

        if (e.pres3.startsWith("Ꭶ") && e.past.startsWith("ᎤᏩ")) {
            e.past = discardPrefix(e.past)
            e.inf = discardPrefix(e.inf)
            return generateVowelStems("Ꭰ", e)
        }

        if (e.pres3.startsWith("Ꭴ") && e.pres1.startsWith("ᎠᎩ")) {
            return generateConsonentStems(e)
        }

        if (e.pres3.startsWith("Ꭴ") && e.pres1.startsWith("ᎠᎧ")) {
            return generateVowelStems("Ꭵ", e)
        }

        if (e.pres3.startsWith("ᎤᏮ") && e.pres1.startsWith("ᎠᏋ")) {

            e.pres3 = discardPrefix(e.pres3)
            e.past = discardPrefix(e.past)
            e.habit = discardPrefix(e.habit)
            e.imp = discardPrefix(e.inf)
            return generateVowelStems("Ꭵ", e)
        }

        if (e.pres3.startsWith("ᎤᏪ") && e.pres1.startsWith("ᎠᏇ")) {
            e.pres3 = discardPrefix(e.pres3)
            e.past = discardPrefix(e.past)
            e.habit = discardPrefix(e.habit)
            e.imp = discardPrefix(e.inf)
            return generateVowelStems("Ꭱ", e)
        }

        if (e.pres3.startsWith("ᎤᏬ") && e.pres1.startsWith("ᎠᏉ")) {
            e.pres3 = discardPrefix(e.pres3)
            e.past = discardPrefix(e.past)
            e.habit = discardPrefix(e.habit)
            e.imp = discardPrefix(e.inf)
            return generateVowelStems("Ꭳ", e)
        }

        if (e.pres3.startsWith("Ꮽ") && e.pres1.startsWith("ᏩᏆ")) {
            e.pres3 = discardPrefix(e.pres3)
            e.past = discardPrefix(e.past)
            e.habit = discardPrefix(e.habit)
            e.imp = discardPrefix(e.inf)
            return generateVowelStems("Ꭰ", e)
        }

        if (e.pres3.startsWith("Ꭸ") && e.past.startsWith("ᎤᏪ")) {
            e.past = discardPrefix(e.past)
            e.inf = discardPrefix(e.inf)
            return generateVowelStems("Ꭱ", e)
        }

        if (e.pres3.startsWith("Ꭺ") && e.past.startsWith("ᎤᏬ")) {
            e.past = discardPrefix(e.past)
            e.inf = discardPrefix(e.inf)
            return generateVowelStems("Ꭳ", e)
        }

        if (e.pres3.startsWith("Ꭻ") && e.past.startsWith("ᎤᏭ")) {
            e.past = discardPrefix(e.past)
            e.inf = discardPrefix(e.inf)
            return generateVowelStems("Ꭴ", e)
        }

        if (e.pres3.startsWith("Ꭼ") && e.past.startsWith("ᎤᏮ")) {
            e.past = discardPrefix(e.past)
            e.inf = discardPrefix(e.inf)
            return generateVowelStems("Ꭵ", e)
        }
        if (e.pres3.startsWith("Ꭱ") && e.imp.startsWith("Ꭾ")) {
            e.past = discardPrefix(e.past)
            e.inf = discardPrefix(e.inf)
            return generateVowelStems("Ꭱ", e)
        }
        /*
         * eh! "Ꭲ-/Ꭿ-" stemmed verbs don't parse nicely!
         */
        if (e.pres3.startsWith("Ꭹ") && e.past.startsWith("ᎤᏫ")) {
            List<StemEntry> list = new ArrayList<StemEntry>()
            list.add(new StemEntry(newPrefix("Ꭲ", e.pres3), Tense.PRESENT))
            list.add(new StemEntry(newPrefix("Ꭿ", discardPrefix(e.past)), Tense.REMOTE_PAST))
            list.add(new StemEntry(newPrefix("Ꭲ", e.habit), Tense.HABITUAL))

            if (e.imp.startsWith("Ꮂ")) {
                list.add(new StemEntry(newPrefix("Ꭵ", e.imp), Tense.IMMEDIATE_COMMAND))
            } else {
                //App.err("Normalize Corner Case Needed: " + e.getEntries().toString())
            }

            list.add(new StemEntry(newPrefix("Ꭿ", discardPrefix(e.inf)), Tense.DEVERBAL))
            return list
        }

        if (e.pres3.startsWith("Ꭴ") && !e.pres3.matches("^Ꭴ[Ꮹ-Ꮾ].*")) {
            return generateConsonentStems(e)
        }

        if (e.pres3.startsWith("Ꭶ") && !e.past.matches("^Ꭴ[Ꮹ-Ꮾ].*")) {
            return generateConsonentStems(e)
        }

        /*
         * corner case for ᎬᏙᎠ / ktoa and similar entries
         * (Ꭶ + Ꮩ => ᎬᏙ and no 1st person or past entry)
         */
        if (e.pres3.startsWith("Ꭼ") && e.imp.startsWith("Ꭽ")) {
            return generateVowelStems("Ꭰ", e)
        }

        /*
         * corner case for ᎬᎿ similar entries where they
         * have no past entry)
         */
        if (e.pres3.startsWith("Ꭼ") && e.imp.startsWith("Ꮂ")) {
            return generateVowelStems("Ꭵ", e)
        }

        /*
         * "Ꭼ" + !"ᎤᏮ" is an odd corner case and should always be processed
         * close to last...
         */
        if (e.pres3.startsWith("Ꭼ") && e.past.startsWith("Ꭴ")) {
            return generateVowelStems("Ꭵ", e)
        }

        if (e.pres3.startsWith("ᎤᏩ") && e.pres1.startsWith("ᎠᏋ")) {
            e.pres3 = discardPrefix(e.pres3)
            e.past = discardPrefix(e.past)
            e.habit = discardPrefix(e.habit)
            e.imp = discardPrefix(e.inf)
            return generateVowelStems("Ꭵ", e)
        }


//        .info("No normalization method for: " + e.getEntries().toString())
        return new ArrayList<StemEntry>()
    }

    private void reformatAsInanimate(NormalizedVerbEntry e) {
        if (e.pres3.matches(".[ᏯᏰᏱᏲᏳᏴ].*")) {
            //a "y" consonent stem or vowel+"y" stem? abort ...
            return
        }

        if (e.pres1.matches("Ꮵ[ᏯᏰᏱᏲᏳᏴ].*")) {
            String yx = StringUtils.substring(e.pres1, 1, 2)
            yx = SyllabaryUtil.parseSyllabary(yx)
            yx = StringUtils.substring(yx, 1)
            yx = SyllabaryUtil.tsalagiToSyllabary("G" + yx)
            e.pres1 = yx + StringUtils.substring(e.pres1, 2)
        }

        if (e.imp.matches("Ꭿ[ᏯᏰᏱᏲᏳᏴ].*")) {
            String yx = StringUtils.substring(e.imp, 1, 2)
            yx = SyllabaryUtil.parseSyllabary(yx)
            yx = StringUtils.substring(yx, 1)
            yx = SyllabaryUtil.tsalagiToSyllabary("h" + yx)
            e.imp = yx + StringUtils.substring(e.pres1, 2)
        }
    }

    List<StemEntry> a3rd(e) {
        /*
         * Ꭰ
         */
//        a_3rd: {
        if (!e.pres3.startsWith("Ꭰ")) {
            return null
        }

        if (!e.pres3.matches("Ꭰ[ᏯᏰᏱᏲᏳᏴ].*") && e.pres1.matches("Ꮵ[ᏯᏰᏱᏲᏳᏴ].*")) {
            return generateVowelStems("Ꭰ", e)
        }

        if (e.pres1.startsWith("Ꮵ")) {
            return generateConsonentStems(e)
        }

        if (e.pres1.startsWith("Ꭶ")) {
            return generateVowelStems("Ꭰ", e)
        }

        if (!e.past.startsWith("ᎤᏩ")) {
            if (e.pres3.equals("ᎠᎦᏍᎦ")) {
//                    new JsonConverter().toJson(generateVowelStems("Ꭰ", e))
            }

            return generateVowelStems("Ꭰ", e)
        }
//        }
    }

    List<StemEntry> ga3rd(e) {
        /*
		 * Ꭶ
		 */
//        ga_3rd: {
        if (!e.pres3.startsWith("Ꭶ")) {
//                break ga_3rd
//                ga3rd(e)
            return null
        }
        if (!e.pres3.matches("Ꭶ[ᏯᏰᏱᏲᏳᏴ].*") && e.pres1.matches("Ꮵ[ᏯᏰᏱᏲᏳᏴ].*")) {
            return generateVowelStems("Ꭰ", e)
        }
        if (e.pres1.startsWith("Ꮵ")) {
            return generateConsonentStems(e)
        }
        if (e.pres1.startsWith("Ꭶ")) {
            return generateVowelStems("Ꭰ", e)
        }
//        }
    }

    List<StemEntry> ka3rd(e) {
        if (!e.pres3.startsWith("Ꭷ")) {
//            ka3rd(e)
            return null
        }
        if (!e.pres3.matches("Ꭷ[ᏯᏰᏱᏲᏳᏴ].*") && e.pres1.matches("Ꮵ[ᏯᏰᏱᏲᏳᏴ].*")) {
            return generateVowelStems("Ꭰ", e)
        }
        if (e.pres1.startsWith("Ꮵ")) {
            return generateConsonentStems(e)
        }
        if (e.pres1.startsWith("Ꭶ")) {
            return generateVowelStems("Ꭰ", e)
        }
        if (e.imp.startsWith("Ꭿ")) {
            return generateConsonentStems(e)
        }

        if (e.past.startsWith("Ꭴ") && !e.past.matches("^[Ꮹ-Ꮾ].*")) {
            return generateConsonentStems(e)
        }

        if (StringUtils.isEmpty(e.past)
                && StringUtils.isEmpty(e.imp) && StringUtils.isEmpty(e.inf)) {
            return generateConsonentStems(e)
        }
    }

    List<StemEntry> generateVowelStems(String vowel, NormalizedVerbEntry e) {
        if (e.imp.startsWith("Ꮻ")) {
            e.imp = discardPrefix(e.imp)
        }

        List<StemEntry> list = new ArrayList<StemEntry>()
        list.add(new StemEntry(newPrefix(vowel, e.pres3), Tense.PRESENT))
        list.add(new StemEntry(newPrefix(vowel, e.past), Tense.REMOTE_PAST))
        list.add(new StemEntry(newPrefix(vowel, e.habit), Tense.HABITUAL))
        list.add(new StemEntry(newPrefix(vowel, e.imp), Tense.IMMEDIATE_COMMAND))
        list.add(new StemEntry(newPrefix(vowel, e.inf), Tense.DEVERBAL))
        return list
    }

    List<StemEntry> generateConsonentStems(NormalizedVerbEntry e) {
        if (e.imp.startsWith("Ꮻ")) {
            e.imp = discardPrefix(e.imp)
        }

        List<StemEntry> list = new ArrayList<StemEntry>()
        list.add(new StemEntry(discardPrefix(e.pres3), Tense.PRESENT))
        list.add(new StemEntry(discardPrefix(e.past), Tense.REMOTE_PAST))
        list.add(new StemEntry(discardPrefix(e.habit), Tense.HABITUAL))
        list.add(new StemEntry(discardPrefix(e.imp), Tense.IMMEDIATE_COMMAND))
        list.add(new StemEntry(discardPrefix(e.inf), Tense.DEVERBAL))
        return list
    }

    private String fixImperativeSuffix(String imp) {
        if (StringUtils.isBlank(imp)) {
            return ""
        }

        String suffix = StringUtils.right(imp, 1)

        /*
         * matches -Ꭷ !
         */
        if (StringUtils.containsAny("ᎠᎦᎧᎭᎳᎹᎾᎿᏆᏌᏓᏔᏜᏝᏣᏩᏯ", suffix)) {
            return imp
        }

        /*
         * does not match -Ꭷ !
         */
        while (!StringUtils.containsAny("ᎠᎦᎭᎳᎹᎾᎿᏆᏌᏓᏔᏜᏝᏣᏩᏯ", suffix)) {
            char c = suffix.charAt(0)
            if (c < 'Ꭰ') {
                return imp
            }
            c--
            suffix = String.valueOf(c)
        }

        String recentPastForm = StringUtils.left(imp, imp.length() - 1) + suffix
        return recentPastForm
    }

    static String discardPrefix(String text) {
        return newPrefix("", text)
    }

    static String newPrefix(String prefix, String text) {
        if (StringUtils.isBlank(text)) {
            return ""
        }
        return prefix + StringUtils.substring(text, 1)
    }
}