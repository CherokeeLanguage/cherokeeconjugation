package net.cherokeedictionary.stemmer


import net.cherokeedictionary.stem.NormalizedVerbEntry
import net.cherokeedictionary.stem.StemEntry
import net.cherokeedictionary.stem.StemType
import net.cherokeedictionary.stem.Syllabary
import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import net.cherokeedictionary.verb.suffixes.Habitual
import net.cherokeedictionary.verb.suffixes.Imperative
import net.cherokeedictionary.verb.suffixes.Infinitive
import net.cherokeedictionary.verb.suffixes.Present
import net.cherokeedictionary.verb.suffixes.RemotePast
import org.apache.commons.lang3.StringUtils

/**
 * Created by torr on 8/16/2015.
 */
public class Stemmer {
    public DefinitionLine present3rd = null;
    public DefinitionLine present1st = null;
    public DefinitionLine remotepast = null;
    public DefinitionLine habitual = null;
    public DefinitionLine imperative = null;
    public DefinitionLine infinitive = null;

    String getRoot(Tense type) {
        return getRootWithEnding(type)[0]
    }

    String[] getRootWithEnding(Tense type) {
        String stem = SyllabaryUtil.parseSyllabary(getStem(type))
        String root = ""

        def suffix

        //TODO: finish breaking these apart by the rest of the conjugations and then checking for completeness.
        //      also decide what to do with the split and how to put it into the word
        switch (type) {
            case Tense.REMOTE_PAST:
                suffix = new RemotePast()
                break

            case Tense.HABITUAL:
                suffix = new Habitual()
                break
            case Tense.FUTURE_COMMAND:
                suffix = new Imperative()
                break
            case Tense.INFINITIVE:
                suffix = new Infinitive()
                break
            case Tense.PRESENT:
            default:
                suffix = new Present()
                break
        }

        def lastChar = null
        if (root.size() > 0) {
            // the word minus the ending
            root = stem.substring(0, stem.lastIndexOf(suffix.getFinalSuffix()))
            // get the last letter to determine which end of the word it is
            lastChar = String.valueOf(root.charAt(root.size() - 1))

            // see if the last character is in the value list
            if (suffix.getRootEndings().containsValue(lastChar)) {
                // if it is then the root is now minus the last character
                root = root.substring(0, root.size() - 1)

//            // printing the result so we know what the root plus the final root ending is before we add other parts to the verb
//            println "what it be " + root + lastChar
            }
        } else {
            root = null
        }

        return [root, lastChar]
    }

    String getStem(Tense tense) {
        def returnValue = ""
        getStems().each {
            if (compareTypeAndTense(it.stemtype, tense)) {
//            if (it.stemtype == type) {
                returnValue = it.syllabary
            }
        }

        return returnValue
    }

    //TODO: may have to revisit this for future tenses and stuff
    boolean compareTypeAndTense(StemType type, Tense tense) {
        return (type == StemType.PresentContinous && tense == Tense.PRESENT) || (type == StemType.RemotePast && tense == Tense.REMOTE_PAST) || (type == StemType.Immediate && tense == Tense.IMMEDIATE_COMMAND) || (type == StemType.Habitual && tense == Tense.HABITUAL)
    }

    List<StemEntry> getStems() {
        NormalizedVerbEntry e = new NormalizedVerbEntry();

        if (present3rd != null && present3rd.syllabary != null) {
            e.pres3 = StringUtils.strip(present3rd.syllabary);
            if (e.pres3.contains(",")) {
                e.pres3 = StringUtils.substringBefore(e.pres3, ",");
                e.pres3 = StringUtils.strip(e.pres3);
            }
        } else {
            e.pres3 = ""
        }
        if (present1st && present1st.syllabary) {
            e.pres1 = StringUtils.strip(present1st.syllabary);
            if (e.pres1.contains(",")) {
                e.pres1 = StringUtils.substringAfterLast(e.pres1, ",");
                e.pres1 = StringUtils.strip(e.pres1);
            }
        } else {
            e.pres1 = ""
        }

        if (remotepast && remotepast.syllabary) {
            e.past = StringUtils.strip(remotepast.syllabary);
            if (e.past.contains(",")) {
                e.past = StringUtils.substringBefore(e.past, ",");
                e.past = StringUtils.strip(e.past);
            }
        } else {
            e.past = ""
        }

        if (habitual && habitual.syllabary) {
            e.habit = StringUtils.strip(habitual.syllabary);
            if (e.habit.contains(",")) {
                e.habit = StringUtils.substringBefore(e.habit, ",");
                e.habit = StringUtils.strip(e.habit);
            }
        } else {
            e.habit = ""
        }

        if (imperative && imperative.syllabary) {
            e.imp = StringUtils.strip(imperative.syllabary);
            if (e.imp.contains(",")) {
                e.imp = StringUtils.substringAfterLast(e.imp, ",");
                e.imp = StringUtils.strip(e.imp);
            }
            e.imp = fixImperativeSuffix(e.imp);
        } else {
            e.imp = ""
        }

        if (infinitive && infinitive.syllabary) {
            e.inf = StringUtils.strip(infinitive?.syllabary);
            if (e?.inf?.contains(",")) {
                e.inf = StringUtils.substringBefore(e.inf, ",");
                e.inf = StringUtils.strip(e.inf);
            }
        }  else {
            e.inf = ""
        }

        /*
     * Strip direct object if easy to identify
     */
        NormalizedVerbEntry.removeDirectObject(e);
        /*
     * Strip ???- prefix if easy to identify
     */
        NormalizedVerbEntry.remove???prefix(e);
        /*
     * Strip ???- prefix if easy to identify
     */
        NormalizedVerbEntry.remove???prefix(e);
        /*
     * String ???- prefix if easy to identify
     */
        NormalizedVerbEntry.remove???prefix(e);
        /*
     * String ???- (again) prefix if easy to identify
     */
        NormalizedVerbEntry.remove???prefix(e);

        /*
		 * Convert animate to inanimate.
		 */
        reformatAsInanimate(e);

        List<StemEntry> a3rd = a3rd(e);
        if (a3rd) {
            return a3rd;
        }

        List<StemEntry> ga3rd = ga3rd(e);
        if (ga3rd) {
            return ga3rd;
        }

        List<StemEntry> ka3rd = ka3rd(e);
        if (ka3rd) {
            return ka3rd;
        }

//        println "e.pres3: ${e.pres3.substring(0, 1)} -- ${e.pres3}"
//        println "e.pres1: ${e.pres1.substring(0, 1)} -- ${e.pres1}"

        if (e.pres3.startsWith("???") && e.pres1.startsWith("??????")) {
//            println "starts with agw && u"
            return generateVowelStems("???", e);
        }
        if (e.pres3.startsWith("???") && e.past.startsWith("??????")) {
			e.past=discardPrefix(e.past);
			e.inf=discardPrefix(e.inf);
            return generateVowelStems("???", e);
        }
        if (e.pres3.startsWith("???") && e.past.startsWith("??????")) {
			e.past=discardPrefix(e.past);
			e.inf=discardPrefix(e.inf);
            return generateVowelStems("???", e);
        }
        if (e.pres3.startsWith("???") && e.pres1.startsWith("??????")) {
            return generateConsonentStems(e);
        }
        if (e.pres3.startsWith("???") && e.pres1.startsWith("??????")) {
            return generateVowelStems("???", e);
        }

        if (e.pres3.startsWith("??????") && e.pres1.startsWith("??????")) {

			e.pres3=discardPrefix(e.pres3);
			e.past=discardPrefix(e.past);
			e.habit=discardPrefix(e.habit);
			e.imp=discardPrefix(e.inf);
            return generateVowelStems("???", e);
        }
        if (e.pres3.startsWith("??????") && e.pres1.startsWith("??????")) {
			e.pres3=discardPrefix(e.pres3);
			e.past=discardPrefix(e.past);
			e.habit=discardPrefix(e.habit);
			e.imp=discardPrefix(e.inf);
			return generateVowelStems("???", e);
		}
		if (e.pres3.startsWith("??????") && e.pres1.startsWith("??????")) {
			e.pres3=discardPrefix(e.pres3);
			e.past=discardPrefix(e.past);
			e.habit=discardPrefix(e.habit);
			e.imp=discardPrefix(e.inf);
			return generateVowelStems("???", e);
		}
		if (e.pres3.startsWith("???") && e.pres1.startsWith("??????")) {
			e.pres3=discardPrefix(e.pres3);
			e.past=discardPrefix(e.past);
			e.habit=discardPrefix(e.habit);
			e.imp=discardPrefix(e.inf);
            return generateVowelStems("???", e);
        }

        if (e.pres3.startsWith("???") && e.past.startsWith("??????")) {
			e.past=discardPrefix(e.past);
			e.inf=discardPrefix(e.inf);
            return generateVowelStems("???", e);
        }

        if (e.pres3.startsWith("???") && e.past.startsWith("??????")) {
			e.past=discardPrefix(e.past);
			e.inf=discardPrefix(e.inf);
            return generateVowelStems("???", e);
        }

        if (e.pres3.startsWith("???") && e.past.startsWith("??????")) {
			e.past=discardPrefix(e.past);
			e.inf=discardPrefix(e.inf);
            return generateVowelStems("???", e);
        }

        if (e.pres3.startsWith("???") && e.past.startsWith("??????")) {
			e.past=discardPrefix(e.past);
			e.inf=discardPrefix(e.inf);
            return generateVowelStems("???", e);
        }
        if (e.pres3.startsWith("???") && e.imp.startsWith("???")) {
			e.past=discardPrefix(e.past);
			e.inf=discardPrefix(e.inf);
            return generateVowelStems("???", e);
        }
        /*
     * eh! "???-/???-" stemmed verbs don't parse nicely!
     */
        if (e.pres3.startsWith("???") && e.past.startsWith("??????")) {
            List<StemEntry> list = new ArrayList<StemEntry>();
            list.add(new StemEntry(newPrefix("???", e.pres3), StemType.PresentContinous));
			list.add(new StemEntry(newPrefix("???",discardPrefix(e.past)), StemType.RemotePast));
            list.add(new StemEntry(newPrefix("???", e.habit), StemType.Habitual));
            if (e.imp.startsWith("???")) {
                list.add(new StemEntry(newPrefix("???", e.imp), StemType.Immediate));
            } else {
                //App.err("Normalize Corner Case Needed: " + e.getEntries().toString());
            }
			list.add(new StemEntry(newPrefix("???",discardPrefix(e.inf)), StemType.Deverbal));
            return list;
        }

        if (e.pres3.startsWith("???") && !e.pres3.matches("^???[???-???].*")) {
            return generateConsonentStems(e);
        }

        if (e.pres3.startsWith("???") && !e.past.matches("^???[???-???].*")) {
            return generateConsonentStems(e);
        }

        /*
     * corner case for ????????? / ktoa and similar entries
     * (??? + ??? => ?????? and no 1st person or past entry)
     */
        if (e.pres3.startsWith("???") && e.imp.startsWith("???")) {
            return generateVowelStems("???", e);
        }
        /*
     * corner case for ?????? similar entries where they
     * have no past entry)
     */
        if (e.pres3.startsWith("???") && e.imp.startsWith("???")) {
            return generateVowelStems("???", e);
        }
        /*
     * "???" + !"??????" is an odd corner case and should always be processed
     * close to last...
     */
        if (e.pres3.startsWith("???") && e.past.startsWith("???")) {
            return generateVowelStems("???", e);
        }

        if (e.pres3.startsWith("??????") && e.pres1.startsWith("??????")) {
            e.pres3=discardPrefix(e.pres3);
            e.past=discardPrefix(e.past);
            e.habit=discardPrefix(e.habit);
            e.imp=discardPrefix(e.inf);
            return generateVowelStems("???", e);
        }


//        .info("No normalization method for: " + e.getEntries().toString());
        return new ArrayList<StemEntry>();
    }

    private void reformatAsInanimate(NormalizedVerbEntry e) {
        if (e.pres3.matches(".[??????????????????].*")){
            //a "y" consonent stem or vowel+"y" stem? abort ...
            return;
        }

        if (e.pres1.matches("???[??????????????????].*")){
            String yx = StringUtils.substring(e.pres1, 1, 2);
            yx = Syllabary.chr2lat(yx);
            yx=StringUtils.substring(yx, 1);
            yx = Syllabary.lat2chr("G"+yx);
            e.pres1=yx+StringUtils.substring(e.pres1, 2);
        }

        if (e.imp.matches("???[??????????????????].*")){
            String yx = StringUtils.substring(e.imp, 1, 2);
            yx = Syllabary.chr2lat(yx);
            yx=StringUtils.substring(yx, 1);
            yx = Syllabary.lat2chr("h"+yx);
            e.imp=yx+StringUtils.substring(e.pres1, 2);
        }
    }

    List<StemEntry> a3rd(e) {
        /*
         * ???
         */
//        a_3rd: {
            if (!e.pres3.startsWith("???")){
                return null;
            }
            if (!e.pres3.matches("???[??????????????????].*") && e.pres1.matches("???[??????????????????].*")){
                return generateVowelStems("???", e);
            }
            if (e.pres1.startsWith("???")) {
                return generateConsonentStems(e);
            }
            if (e.pres1.startsWith("???")) {
                return generateVowelStems("???", e);
            }
            if (!e.past.startsWith("??????")) {
                if (e.pres3.equals("????????????")){
//                    new JsonConverter().toJson(generateVowelStems("???", e));
                }
                return generateVowelStems("???", e);
            }
//        }
    }

     List<StemEntry> ga3rd(e) {
        /*
		 * ???
		 */
//        ga_3rd: {
            if (!e.pres3.startsWith("???")){
//                break ga_3rd;
//                ga3rd(e);
                return null;
            }
            if (!e.pres3.matches("???[??????????????????].*") && e.pres1.matches("???[??????????????????].*")){
                return generateVowelStems("???", e);
            }
            if (e.pres1.startsWith("???")) {
                return generateConsonentStems(e);
            }
            if (e.pres1.startsWith("???")) {
                return generateVowelStems("???", e);
            }
//        }
    }

    List<StemEntry> ka3rd(e) {
        if (!e.pres3.startsWith("???")) {
//            ka3rd(e);
            return null;
        }
        if (!e.pres3.matches("???[??????????????????].*") && e.pres1.matches("???[??????????????????].*")){
            return generateVowelStems("???", e);
        }
        if (e.pres1.startsWith("???")) {
            return generateConsonentStems(e);
        }
        if (e.pres1.startsWith("???")) {
            return generateVowelStems("???", e);
        }
        if (e.imp.startsWith("???")) {
            return generateConsonentStems(e);
        }

        if (e.past.startsWith("???") && !e.past.matches("^[???-???].*")) {
            return generateConsonentStems(e);
        }

        if (StringUtils.isEmpty(e.past)
                && StringUtils.isEmpty(e.imp) && StringUtils.isEmpty(e.inf)) {
            return generateConsonentStems(e);
        }
    }

    List<StemEntry> generateVowelStems(String vowel, NormalizedVerbEntry e) {
        if (e.imp.startsWith("???")) {
			e.imp=discardPrefix(e.imp);
        }
        List<StemEntry> list = new ArrayList<StemEntry>();
        list.add(new StemEntry(newPrefix(vowel, e.pres3), StemType.PresentContinous));
        list.add(new StemEntry(newPrefix(vowel, e.past), StemType.RemotePast));
        list.add(new StemEntry(newPrefix(vowel, e.habit), StemType.Habitual));
        list.add(new StemEntry(newPrefix(vowel, e.imp), StemType.Immediate));
        list.add(new StemEntry(newPrefix(vowel, e.inf), StemType.Deverbal));
        return list;
    }

    List<StemEntry> generateConsonentStems(NormalizedVerbEntry e) {
        if (e.imp.startsWith("???")) {
			e.imp=discardPrefix(e.imp);
        }
        List<StemEntry> list = new ArrayList<StemEntry>();
		list.add(new StemEntry(discardPrefix(e.pres3), StemType.PresentContinous));
		list.add(new StemEntry(discardPrefix(e.past), StemType.RemotePast));
		list.add(new StemEntry(discardPrefix(e.habit), StemType.Habitual));
		list.add(new StemEntry(discardPrefix(e.imp), StemType.Immediate));
		list.add(new StemEntry(discardPrefix(e.inf), StemType.Deverbal));
        return list;
    }

    private static String fixImperativeSuffix(String imp) {
        if (StringUtils.isBlank(imp)) {
            return "";
        }
        String suffix = StringUtils.right(imp, 1);
        /*
     * matches -??? !
     */
        if (StringUtils.containsAny("???????????????????????????????????????????????????", suffix)) {
            return imp;
        }
        /*
     * does not match -??? !
     */
        while (!StringUtils.containsAny("????????????????????????????????????????????????", suffix)) {
            char c = suffix.charAt(0);
            if (c < '???') {
                return imp;
            }
            c--;
            suffix = String.valueOf(c);
        }
        String recentPastForm = StringUtils.left(imp, imp.length() - 1)+suffix;
        return recentPastForm;
    }

	static String discardPrefix(String text) {
        return newPrefix("", text);
    }

    static String newPrefix(String prefix, String text) {
        if (StringUtils.isBlank(text)) {
            return "";
        }
        return prefix + StringUtils.substring(text, 1);
    }
}