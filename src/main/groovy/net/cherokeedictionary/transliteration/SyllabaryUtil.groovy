/*
* Copyright cobradoc.com
* LGPL license
* You are free to use this software, sell it, trade it, burn it, or even use it to change the world...but we're not responsible for any badness.
* You must include this disclaimer in your usages along with the email of the original creator of this software: cobradoc@gmail.com
*
* Enjoy!  And don't do bad stuff.
*/
package net.cherokeedictionary.transliteration;

//TODO: move each letter itaration out to its own method - need to figure out a way to handle it so it will increment correctly
// the idea being that in the end the code will be almost identical for JS and Groovy
public class SyllabaryUtil {
    static def syllabaryMap = ["Ꭰ" : "a",
    "Ꭱ" : "e",
    "Ꭲ" : "i",
    "Ꭳ" : "o",
    "Ꭴ" : "u",
    "Ꭵ" : "v",
    "Ꭶ" : "ga",
    "Ꭷ" : "ka",
    "Ꭸ" : "ge",
    "Ꭹ" : "gi",
    "Ꭺ" : "go",
    "Ꭻ" : "gu",
    "Ꭼ" : "gv",
    "Ꭽ" : "ha",
    "Ꭾ" : "he",
    "Ꭿ" : "hi",
    "Ꮀ" : "ho",
    "Ꮁ" : "hu",
    "Ꮂ" : "hv",
    "Ꮃ" : "la",
    "Ꮄ" : "le",
    "Ꮅ" : "li",
    "Ꮆ" : "lo",
    "Ꮇ" : "lu",
    "Ꮈ" : "lv",
    "Ꮉ" : "ma",
    "Ꮊ" : "me",
    "Ꮋ" : "mi",
    "Ꮌ" : "mo",
    "Ꮍ" : "mu",
    "Ꮎ" : "na",
    "Ꮏ" : "hna",
    "Ꮐ" : "nah",
    "Ꮑ" : "ne",
    "Ꮒ" : "ni",
    "Ꮓ" : "no",
    "Ꮔ" : "nu",
    "Ꮕ" : "nv",
    "Ꮖ" : "qua",
    "Ꮗ" : "que",
    "Ꮘ" : "qui",
    "Ꮙ" : "quo",
    "Ꮚ" : "quu",
    "Ꮛ" : "quv",
    "Ꮜ" : "sa",
    "Ꮝ" : "s",
    "Ꮞ" : "se",
    "Ꮟ" : "si",
    "Ꮠ" : "so",
    "Ꮡ" : "su",
    "Ꮢ" : "sv",
    "Ꮣ" : "da",
    "Ꮤ" : "ta",
    "Ꮥ" : "de",
    "Ꮦ" : "te",
    "Ꮧ" : "di",
    "Ꮨ" : "ti",
    "Ꮩ" : "do",
//    "Ꮩ" : "to",
//    "Ꮪ" : "tu",
    "Ꮪ" : "du",
//    "Ꮫ" : "tv",
    "Ꮫ" : "dv",
    "Ꮬ" : "dla",
    "Ꮭ" : "tla",
    "Ꮮ" : "tle",
    "Ꮯ" : "tli",
    "Ꮰ" : "tlo",
    "Ꮱ" : "tlu",
    "Ꮲ" : "tlv",
    "Ꮳ" : "tsa",
    "Ꮴ" : "tse",
    "Ꮵ" : "tsi",
    "Ꮶ" : "tso",
    "Ꮷ" : "tsu",
    "Ꮸ" : "tsv",
    "Ꮹ" : "wa",
    "Ꮺ" : "we",
    "Ꮻ" : "wi",
    "Ꮼ" : "wo",
    "Ꮽ" : "wu",
    "Ꮾ" : "wv",
    "Ꮿ" : "ya",
    "Ᏸ" : "ye",
    "Ᏹ" : "yi",
    "Ᏺ" : "yo",
    "Ᏻ" : "yu",
    "Ᏼ" : "yv",
    " " : " "];

    static def syllabaryMap2 = ["a" : "Ꭰ",
    "e" : "Ꭱ",
    "i" : "Ꭲ",
    "o" : "Ꭳ",
    "u" : "Ꭴ",
    "v" : "Ꭵ",
    "ga" : "Ꭶ",
    "ka" : "Ꭷ",
    "ge" : "Ꭸ",
    "gi" : "Ꭹ",
    "go" : "Ꭺ",
    "gu" : "Ꭻ",
    "gv" : "Ꭼ",
    "ha" : "Ꭽ",
    "he" : "Ꭾ",
    "hi" : "Ꭿ",
    "ho" : "Ꮀ",
    "hu" : "Ꮁ",
    "hv" : "Ꮂ",
    "la" : "Ꮃ",
    "le" : "Ꮄ",
    "li" : "Ꮅ",
    "lo" : "Ꮆ",
    "lu" : "Ꮇ",
    "lv" : "Ꮈ",
    "ma" : "Ꮉ",
    "me" : "Ꮊ",
    "mi" : "Ꮋ",
    "mo" : "Ꮌ",
    "mu" : "Ꮍ",
    "na" : "Ꮎ",
    "hna" : "Ꮏ",
    "nah" : "Ꮐ",
    "ne" : "Ꮑ",
    "ni" : "Ꮒ",
    "no" : "Ꮓ",
    "nu" : "Ꮔ",
    "nv" : "Ꮕ",
    "qua" : "Ꮖ",
    "que" : "Ꮗ",
    "qui" : "Ꮘ",
    "quo" : "Ꮙ",
    "quu" : "Ꮚ",
    "quv" : "Ꮛ",
    "kwa" : "Ꮖ",
    "kwe" : "Ꮗ",
    "kwi" : "Ꮘ",
    "kwo" : "Ꮙ",
    "kwu" : "Ꮚ",
    "kwv" : "Ꮛ",
    "sa" : "Ꮜ",
    "s" : "Ꮝ",
    "se" : "Ꮞ",
    "si" : "Ꮟ",
    "so" : "Ꮠ",
    "su" : "Ꮡ",
    "sv" : "Ꮢ",
    "da" : "Ꮣ",
    "ta" : "Ꮤ",
    "de" : "Ꮥ",
    "te" : "Ꮦ",
    "di" : "Ꮧ",
    "ti" : "Ꮨ",
    "do" : "Ꮩ",
    "to" : "Ꮩ",
    "du" : "Ꮪ",
    "tu" : "Ꮪ",
    "dv" : "Ꮫ",
    "tv" : "Ꮫ",
    "dla" : "Ꮬ",
    "tla" : "Ꮭ",
    "tle" : "Ꮮ",
    "tli" : "Ꮯ",
    "tlo" : "Ꮰ",
    "tlu" : "Ꮱ",
    "tlv" : "Ꮲ",
    "tsa" : "Ꮳ",
    "tse" : "Ꮴ",
    "tsi" : "Ꮵ",
    "tso" : "Ꮶ",
    "tsu" : "Ꮷ",
    "tsv" : "Ꮸ",
    "wa" : "Ꮹ",
    "we" : "Ꮺ",
    "wi" : "Ꮻ",
    "wo" : "Ꮼ",
    "wu" : "Ꮽ",
    "wv" : "Ꮾ",
    "ya" : "Ꮿ",
    "ye" : "Ᏸ",
    "yi" : "Ᏹ",
    "yo" : "Ᏺ",
    "yu" : "Ᏻ",
    "yv" : "Ᏼ",
    " " : " "];

    //does not handle spaces - use parseSentence for spaces
    static def parseHyphen(value) {
        def returnValue = "";

        //split string by '-'s
        def values = value.split("-");
        for (def i = 0; i < values.size(); i++) {
            returnValue += syllabaryMap2[values[i]];
        }

        return returnValue;
    }

    //some entries in the dictionary contain slashes, commas, spaces, and (w) or (e)
    // these entries need to be processed as is to give an exact transliterated value
    static def cleanTsalagi(value) {
        def sb = new StringBuilder()
        
        // Set of allowed fallback characters for O(1) lookup
        def allowedChars = ['a', 'e', 'i', 'o', 'u', 'v', 'g', 'k', 'h', 
                            'l', 'm', 'n', 'q', 's', 'd', 't', 'w', 'y', 
                            '\'', '-', ' ', ',', '.', '!', '?', '[', ']', 
                            ':', ';', '~', '(', ')', '/', 
                            '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'] as Set
        
        for (int i = 0; i < value.length(); i++) {
            String valStr = value.charAt(i).toString()
            def mapped = syllabaryMap[valStr]
            
            if (mapped != null) {
                sb.append(mapped)
            } else if (allowedChars.contains(valStr)) {
                sb.append(valStr)
            }
            // Characters not in syllabaryMap and not in allowedChars are automatically stripped
        }
        
        def returnValue = sb.toString()
        returnValue = replace(returnValue, true)
        
        return returnValue
    }

    //some entries in the dictionary contain slashes, commas, spaces, and (w) or (e)
    // these entries need to be processed as is to give an exact transliterated value
    static def parseSyllabaryWithPunctuationAndLatin(value) {
        def returnValue = '';
        for (def i = 0; i < value.length(); i++) {
            def val = value.charAt(i);
            def tmp = syllabaryMap['' + val];
            if (tmp == null) {
                if (val=='a'||val=='e'||val=='i'||
                    val=='o'||val=='u'||val=='v'||
                    val=='g'||val=='k'||val=='h'||
                    val=='l'||val=='m'||val=='n'||
                    val=='q'||val=='s'||val=='d'||
                    val=='t'||val=='w'||val=='y'||
                    val=='\''||val=='-'||val==' '||
                    val==','||val=='.'||val=='!'||
                    val=='?'||val=='['||val=='];'||
                    val==':'||val==';'||val=='~'||
                    val=='('||val==')'||val==" " ||
                    val=="/" || val == "1" || val == "2" || val == "3" || val == "4" || val == "5" || val == "6" || val == "7" || val == "8" || val =="9" || val == "0" || "-") {
                    tmp = val;
                }
            }

            returnValue += tmp
        }

        returnValue = replace(returnValue, true);

        return returnValue;
    }

    // Takes a syllabary string, transliterates to Latin, and normalizes spelling variations (e.g. tsi -> ji, gwa -> qua)
    static def parseSyllabaryNormalized(String value) {
        def latin = parseSyllabary(value)
        return reverseReplace(latin)
    }

    // Takes any Latin Cherokee spelling variant (e.g. from older books/orthographies with kw/gw/tv/hwa/etc.),
    // maps it through Syllabary, and converts back to canonical Latin for fair, orthography-independent comparisons.
    static def normalizeLatin(String data) {
        if (!data) return ""
        def syllabary = tsalagiToSyllabary(data)
        return parseSyllabary(syllabary)
    }

    static def parseSyllabary(value) {
        if (!value) return ""
        def returnValue = new StringBuilder()
        for (def i = 0; i < value.length(); i++) {
            def c = '' + value.charAt(i)
            def mapped = syllabaryMap[c]
            returnValue.append(mapped != null ? mapped : c)
        }

        return replace(returnValue.toString());
    }

    static def reverseReplace(data) {
        data = data.replace('qua', 'gwa');
        data = data.replace('que', 'gwe');
        data = data.replace('qui', 'gwi');
        data = data.replace('quo', 'gwo');
        data = data.replace('quu', 'gwu');
        data = data.replace('quv', 'gwv');
        data = data.replace('tsa', 'ja');
        data = data.replace('tse', 'je');
        data = data.replace('tsi', 'ji');
        data = data.replace('tso', 'jo');
        data = data.replace('tsu', 'ju');
        data = data.replace('tsv', 'jv');
        data = data.replace('cha', 'ja');
        data = data.replace('che', 'je');
        data = data.replace('chi', 'ji');
        data = data.replace('cho', 'jo');
        data = data.replace('chu', 'ju');
        data = data.replace('chv', 'jv');
        data = data.replace('dle', 'tle');
        data = data.replace('dli', 'tli');
        data = data.replace('dlo', 'tlo');
        data = data.replace('dlu', 'tlu');
        data = data.replace('dlv', 'tlv');

//        data = data.replace('do', 'to');

        return data;
    }

    static def replace(data) {
        return replace(data, true);
    }

    static def replace(data, replaceHyphens) {
        data = data.replace('gwa', 'qua');
        data = data.replace('gwe', 'que');
        data = data.replace('gwi', 'qui');
        data = data.replace('gwo', 'quo');
        data = data.replace('gwu', 'quu');
        data = data.replace('kwv', 'quv');
        data = data.replace('kwa', 'qua');
        data = data.replace('kwe', 'que');
        data = data.replace('kwi', 'qui');
        data = data.replace('kwo', 'quo');
        data = data.replace('kwu', 'quu');
        data = data.replace('kwv', 'quv');

        data = data.replace('cha', 'tsa');
        data = data.replace('che', 'tse');
        data = data.replace('chi', 'tsi');
        data = data.replace('cho', 'tso');
        data = data.replace('chu', 'tsu');
        data = data.replace('chv', 'tsv');
        data = data.replace('ja', 'tsa');
        data = data.replace('je', 'tse');
        data = data.replace('ji', 'tsi');
        data = data.replace('jo', 'tso');
        data = data.replace('ju', 'tsu');
        data = data.replace('jv', 'tsv');
        data = data.replace('dle', 'tle');
        data = data.replace('dli', 'tli');
        data = data.replace('dlo', 'tlo');
        data = data.replace('dlu', 'tlu');
        data = data.replace('dlv', 'tlv');

        // Comprehensive Cherokee pre-aspiration and aspiration rules:
        // 1. hl- collapses to tl- (Durbin Feeling dictionary)
        data = data.replace('hla', 'tla');
        data = data.replace('hle', 'tle');
        data = data.replace('hli', 'tli');
        data = data.replace('hlo', 'tlo');
        data = data.replace('hlu', 'tlu');
        data = data.replace('hlv', 'tlv');

        // 2. Aspirated glides: hw- / wh- -> w-, and hy- -> y-
        data = data.replaceAll(/(?i)(hw|wh)([aeiouv])/, 'w$2')
        data = data.replaceAll(/(?i)hy([aeiouv])/, 'y$1')

        // 3. Aspirated n-: hne, hni, hno, hnu, hnv -> ne, ni, no, nu, nv
        // (Note: 'hna' is intentionally preserved because Cherokee has a dedicated syllabary character: Ꮏ)
        data = data.replaceAll(/(?i)hn([eiouv])/, 'n$1')

        // 4. Pre-aspirated stops, affricates, labiovelars, and sonorants:
        // ht, hd, hg, hk, hj, hts, hch, hqu, hgw, htl, hdl, hm
        // e.g. htv -> tv (which maps to Ꮫ), hda -> da, hgi -> gi, hta -> ta
        // tio 16Nov26: Feeling writes the yv-glyph Ᏼ as bare "yh" before a
        // consonant (agwadetiyhdi = ᎠᏆᏕᏘᏴᏗ) -- must fire BEFORE the h-drop
        // rule below, which would otherwise eat the h (dayhdi -> daydi)
        data = data.replaceAll(/(?i)yh([bcdfgjkmnprstz])/, 'yv$1')

        // 5. Colloquial vowel elision before 's':
        // 'ws' in words like 'adanawsdiha' is phonetic contraction of 'wvs' (ᏮᏍ)
        data = data.replace('ws', 'wvs');

        data = data.replace('ki', 'gi');
        data = data.replace("l ", 'li ');
        data = data.replace("d ", 'da ');

        //sometimes ks is gis sometimes it's gas
        //same with nh - could be nv or could be ne
//        data = data.replace('ks', 'gis');

//        data = data.replace('to', 'do');

        if (replaceHyphens) {
            while (data.indexOf("-") != -1) {
                data = data.replace('-', '');
            }
        }

        return data;
    }

    static def mixedTransliteration(String data) {
        def sb = []
        def words = data.split(" ")
        boolean hasCR = false;
        def crIndex = -1;
        words.each {
            if (it.contains("\n") || it.contains("\r")) {
                hasCR = true;
//                crIndex = it.indexOf("\n") != -1 ? it.indexOf("\n") : it.indexOf("\r")
                it = it.replace("\n", "111").replace("\r", "222")
            } else {
                crIndex = -1
            }

            /*if (hasCR) {
                it = it.replace("<br/>", "111")
            }*/

            if (!it.startsWith("<e>") && !it.contains("<e>")) {
                sb << tsalagiToSyllabary(it, false);
            } else {
                //temp fix for hybrid words thst start with cherokee and have english in them
                if (it.startsWith("<e>")) {
                    sb << it
                } else if (it.contains("<e>")) {
                    def word = it.split("<e>")
                    def sb2 = []
                    word.eachWithIndex {str, idx ->
                        if (idx == 0) {
                            sb2 << tsalagiToSyllabary(str, false)
                        } else {
                            sb2 << str
                        }
                    }

                    sb << sb2.join("")
                }
            }

            sb << " "
        }

        sb << "\n"

        //remove all of the <e> tags to clean up the latin texts
        sb = sb.join("");
        sb = sb.replaceAll("<e>", "").replaceAll("111", "\n").replaceAll("222", "\r");

        return sb
    }

    //takes the transliteration and replaces older transliterations with newer values
    static def tsalagiToSyllabaryNormalize(String data) {
        def dataLatin = tsalagiToSyllabary(data)
        reverseReplace(dataLatin)
    }

    static def tsalagiToSyllabary(String data) {
        def result = newTsalagiToSyllabary(data, true)
        // tio 16Nov26: plain-first, CED-conventions-only-as-rescue. The engine's
        // composed latin for CED-aligned vrb verbs carries onset clusters the
        // plain converter cannot map (agwvkew- family, DISCREPANCIES.md D9/D12);
        // wired compositions never produce invalid output, so the fallback is
        // invisible to them. A word that stays invalid under BOTH variants is
        // returned as-is (its invalid-letter rendering is documented behavior).
        if (result.contains("not a valid letter")) {
            def rescued = newTsalagiToSyllabary(data, true, false, true)
            if (!rescued.contains("not a valid letter")) {
                return rescued
            }
        }
        return result
    }

    // tio 16Nov26: vrb citation path -- applies the CED/VRB romanization
    // conventions (l+C->li, ks->gis epenthesis) scoped to the validation
    // data family; see DISCREPANCIES.md D9/D12
    static def tsalagiToSyllabaryCed(String data) {
        return newTsalagiToSyllabary(data, true, false, true);
    }

    @Deprecated
    //sometimes we don't want all hyphens replaced such as when those are delineating the beginning of lists
    static def tsalagiToSyllabary(String data, boolean replaceHyphens) {
        return newTsalagiToSyllabary(data, replaceHyphens)
    }


    //sometimes we don't want all hyphens replaced such as when those are delineating the beginning of lists
    static def newTsalagiToSyllabary(String data, boolean replaceHyphens=false, boolean includeAlpha=false, boolean cedConventions=false) {
        data = data.toLowerCase();

        data = replace(data, replaceHyphens);

        // tio 16Nov26: illicit consonant clusters -- the syllabary has no C+C
        // onsets, so an epenthetic /i/ breaks them (Cherokee orthographic
        // practice): kd->gid, tsd->tsid (akdisiyvi -> agidisiyvi,
        // tsdisiyvi -> tsidisiyvi). Feeling's voiceless-l "hl": hl+v -> lv
        // (Ꮈ), hl+consonant -> lo (Ꮆ, the same convention the verb-book
        // normalizeBookRomanization uses). Without these the leftover letters
        // hit the garbage sweep below and poison the word with
        // 'not a valid letter' (1,311 vrb validation cells).
        data = data.replaceAll("hlv", "lv")
        // tio 17Nov26: q added -- the 2012 book prints the Adehloqwa'a infinitive as
        // "agwadehlqwasdi" (hl = voiceless-l, q = the qu-series onset; ᎶᏆᏍᏗ). Without
        // q in the class the hlq cluster survives and poisons the word (D15).
        data = data.replaceAll("hl([bcdfghjkmnprstzq])", "lo\$1")
        data = data.replaceAll("kd", "gid")
        data = data.replaceAll("tsd", "tsid")
        // tio 16Nov26: the laryngeal h between two consonants surfaces as the
        // vowel a in the syllabary (Adansini "gadanhsini" -> ᎦᏓᎾᏏᏂ,
        // Adanhtehiloa "nht" -> ᎾᏖ); a vowel + h + consonant drops the h
        // (uhtv- -> utv-). The lookahead protects "hna" (-> Ꮏ) across
        // syllable boundaries like nah+hna+nah (ᏀᎿᏀ) -- see
        // DISCREPANCIES.md D5.
        // tio 17Nov26: the lookahead must include q -- replace() maps gwo->quo
        // BEFORE this rule, so pre-aspirated hgw arrives here as "hqu"
        // (uhnehgwojvi -> unehquotsvi); without q the h survives and poisons
        // the word ("unehquotsvi" -> ᎤᏁnot a valid letterᏉᏨᎢ, Kanegwoga/
        // Kanehgwoa vrb family, DISCREPANCIES.md D15).
        data = data.replaceAll("([bcdfgjklmnprstz])h(?!na)(?=[bcdfgjklmnprstzq])", "\$1a")
        data = data.replaceAll("([aeiouv])h(?=[bcdfgjklmnprstzq])", "\$1")
        // tio 17Nov26: bare k before e/o/u/v surfaces with the g-series glyphs --
        // the syllabary has no separate k-series except Ꭷ (ka), so ke/ko/ku/kv
        // are written Ꭸ/Ꭺ/Ꭻ/Ꭼ exactly like ge/go/gu/gv (Uwekaha p.83
        // infinitive "uwekohdi" -> ᎤᏪᎪᏗ). Mirrors the ki->gi rule that
        // pre-existed in replace(). ka is excluded: Ꭷ is a distinct glyph from
        // Ꭶ (Kanegwoga's kanequoga must keep Ꭷ). -- tio 17Nov26
        data = data.replaceAll("k(?=[eouvw])", "g")
        // tio 16Nov26: remaining illicit C+C onsets get the epenthetic /i/
        // (Cherokee syllabary has no C+C except s-coda + C and the dla/tla,
        // ts-, gw/kw/qu digraphs handled above): kt->git, td->tid, nd->nid...
        // (k surfaces as g -- the syllabary k-series has only ka; Ꭹ = gi; the
        // epenthesis class includes s -- "ks"+vowel -> "gis"+vowel, ᎩᏍ)
        // Also the CED/VRB romanization conventions (verified against the CED
        // syllabary column): w before a consonant is the we-glyph Ꮻ
        // (uwakewsga -> ᎤᏩᎨᏫᏍᎦ); "gw" before v is Ꮙ (agwvkewsga -> ᎠᏉ...);
        // n before s+vowel is nas (adansini -> ᎠᏓᎾᏏᏂ, CED id 72227); and
        // l before a consonant gets the epenthetic i (Ꮅ): atolsdiha ->
        // ᎠᏙᎵᏍᏗᎭ, alsdayvhvsga -> ᎠᎵᏍᏓᏴ..., nigalsda -> ᏂᎦᎵᏍᏓ (CED
        // utolstanei = ᎤᏙᎵᏍᏔᏁᎢ confirms li, NOT lv).
        if (cedConventions) {
            // tio 16Nov26: CED/VRB-only conventions -- these fire on romanized
            // sequences that also occur LEGALLY in the wired verb-book data, so
            // they are scoped to the vrb citation path (VerbBaseSpec.conjugateVerb)
            // and NOT global:
            //  - l before a consonant gets the epenthetic i (Ꮅ): atolsdiha ->
            //    ᎠᏙᎵᏍᏗᎭ, alsdayvhvsga -> ᎠᎵᏍᏓᏴ... (CED utolstanei =
            //    ᎤᏙᎵᏍᏔᏁᎢ confirms li, NOT lv)
            //  - illicit C+C onsets get the epenthetic /i/ with k->g (kt->git,
            //    ks->gis -- Ꭹ = gi since the k-series has only ka)
            data = data.replaceAll("l([bcdfgjkmnprstz])", "li\$1")
            data = data.replaceAll("qw([aeiouv])", "qu\$1")
            // Feeling writes the qu-series glyphs with gw/hgw (Ꮙ=gwo/hgwo, Ꮖ=gwa):
            // the gw->qu rewrite maps to the SAME glyphs as the qu-series map
            // (gwa->qua->Ꮖ, gwo->quo->Ꮙ), and hgw carries the voiceless-h
            data = data.replaceAll("hgw([aeiouv])", "qu\$1")
            data = data.replaceAll("gw([aeiouv])", "qu\$1")
            data = data.replaceAll("qw([aeiouv])", "qu\$1")
            // Feeling writes the yv-glyph Ᏼ as bare "yh" before a consonant
            data = data.replaceAll("qw([aeiouv])", "qu\$1")
            // (the gwv/wi-series rescue was attempted 2026-11-16 and reverted:
            // parse-back citation alignment, see VrbParseBackAlign history)
            // gwv->quo attempted and reverted 2026-11-16: "gwv" is ambiguous between
            // Ꮙ (quo) and Ꮚ (quv) across verbs -- only parse-back citation
            // alignment disambiguates (see VrbParseBackAlign history)
            // w+C->wi reverted 2026-11-16: over-fired on kw/gw digraph cells (Ulvkwdi/Uwanvga/Kdega families)
            data = data.replaceAll("k(?=[gkdtmnjs])", "g")
            // tio 17Nov26: NO global ns->nas rule -- the ns-epenthesis vowel is
            // lexeme-level: the 2012 book prints Adansini (p.67) with a-epenthesis
            // (gadanasini = ᎦᏓᎾᏏᏂ) but Gansane'a (p.29) with i-epenthesis
            // (jinasane'a, real stem-internal nsa). A global rule over-fired on the
            // GansaneaSpec family (20 cells). Adansini uses the
            // details.surfaceOverrides whole-form mechanism instead (D5 verdict). -- tio 17Nov26
            data = data.replaceAll("([gkdmnj])(?=[gkdtmnjs])", "\$1i")
            data = data.replaceAll("t(?=[gkdmnj])", "ti")
            // Feeling writes the ti-glyph Ꮨ as bare "t" before an s-coda:
            // "tsga" = ᏘᏍᎦ (t+i+s, i-elided) -- but ts+vowel stays the ts-digraph
            data = data.replaceAll("t(?=s[bcdfgjkmnprstz])", "ti")
        }

        data = data.replaceAll("dla", syllabaryMap2.dla)

        data = data.replaceAll("gwa", syllabaryMap2.qua)
        data = data.replaceAll("gwe", syllabaryMap2.que)
        data = data.replaceAll("gwi", syllabaryMap2.qui)
        data = data.replaceAll("gwo", syllabaryMap2.quo)
        data = data.replaceAll("gwu", syllabaryMap2.quu)
        data = data.replaceAll("gwv", syllabaryMap2.quv)

        data = data.replaceAll("hna", syllabaryMap2.hna)

        data = data.replaceAll("kwa", syllabaryMap2.qua)
        data = data.replaceAll("kwe", syllabaryMap2.que)
        data = data.replaceAll("kwi", syllabaryMap2.qui)
        data = data.replaceAll("kwo", syllabaryMap2.quo)
        data = data.replaceAll("kwu", syllabaryMap2.quu)
        data = data.replaceAll("kwv", syllabaryMap2.quv)

        data = data.replaceAll("qua", syllabaryMap2.qua)
        data = data.replaceAll("que", syllabaryMap2.que)
        data = data.replaceAll("qui", syllabaryMap2.qui)
        data = data.replaceAll("quo", syllabaryMap2.quo)
        data = data.replaceAll("quu", syllabaryMap2.quu)
        data = data.replaceAll("quv", syllabaryMap2.quv)

        data = data.replaceAll("tla", syllabaryMap2.tla)
        data = data.replaceAll("tle", syllabaryMap2.tle)
        data = data.replaceAll("tli", syllabaryMap2.tli)
        data = data.replaceAll("tlo", syllabaryMap2.tlo)
        data = data.replaceAll("tlu", syllabaryMap2.tlu)
        data = data.replaceAll("tlv", syllabaryMap2.tlv)

        data = data.replaceAll("tsa", syllabaryMap2.tsa)
        data = data.replaceAll("tse", syllabaryMap2.tse)
        data = data.replaceAll("tsi", syllabaryMap2.tsi)
        data = data.replaceAll("tso", syllabaryMap2.tso)
        data = data.replaceAll("tsu", syllabaryMap2.tsu)
        data = data.replaceAll("tsv", syllabaryMap2.tsv)

        data = data.replaceAll("da", syllabaryMap2.da)
        data = data.replaceAll("de", syllabaryMap2.de)
        data = data.replaceAll("di", syllabaryMap2.di)
        data = data.replaceAll("do", syllabaryMap2.do)
        data = data.replaceAll("du", syllabaryMap2.du)
        data = data.replaceAll("dv", syllabaryMap2.dv)

        data = data.replaceAll("ga", syllabaryMap2.ga)
        data = data.replaceAll("ge", syllabaryMap2.ge)
        data = data.replaceAll("gi", syllabaryMap2.gi)
        data = data.replaceAll("go", syllabaryMap2.go)
        data = data.replaceAll("gu", syllabaryMap2.gu)
        data = data.replaceAll("gv", syllabaryMap2.gv)

        data = data.replaceAll("ha", syllabaryMap2.ha)
        data = data.replaceAll("he", syllabaryMap2.he)
        data = data.replaceAll("hi", syllabaryMap2.hi)
        data = data.replaceAll("ho", syllabaryMap2.ho)
        data = data.replaceAll("hu", syllabaryMap2.hu)
        data = data.replaceAll("hv", syllabaryMap2.hv)

        data = data.replaceAll("ka", syllabaryMap2.ka)

        // lone 'k' (not part of ka/kw series, which are consumed above) still maps
        // to the ka syllabary; without this it falls to the garbage sweep below
        // and poisons words like "aktosdi" with 'not a valid letter'
        //data = data.replaceAll("k", syllabaryMap2.ka)

        data = data.replaceAll("la", syllabaryMap2.la)
        data = data.replaceAll("le", syllabaryMap2.le)
        data = data.replaceAll("li", syllabaryMap2.li)
        data = data.replaceAll("lo", syllabaryMap2.lo)
        data = data.replaceAll("lu", syllabaryMap2.lu)
        data = data.replaceAll("lv", syllabaryMap2.lv)

        data = data.replaceAll("ma", syllabaryMap2.ma)
        data = data.replaceAll("me", syllabaryMap2.me)
        data = data.replaceAll("mi", syllabaryMap2.mi)
        data = data.replaceAll("mo", syllabaryMap2.mo)
        data = data.replaceAll("mu", syllabaryMap2.mu)

        data = data.replaceAll("nah", syllabaryMap2.nah)
        data = data.replaceAll("na", syllabaryMap2.na)
        data = data.replaceAll("ne", syllabaryMap2.ne)
        data = data.replaceAll("ni", syllabaryMap2.ni)
        data = data.replaceAll("no", syllabaryMap2.no)
        data = data.replaceAll("nu", syllabaryMap2.nu)
        data = data.replaceAll("nv", syllabaryMap2.nv)

        data = data.replaceAll("sa", syllabaryMap2.sa)
        data = data.replaceAll("se", syllabaryMap2.se)
        data = data.replaceAll("si", syllabaryMap2.si)
        data = data.replaceAll("so", syllabaryMap2.so)
        data = data.replaceAll("su", syllabaryMap2.su)
        data = data.replaceAll("sv", syllabaryMap2.sv)


        data = data.replaceAll("wa", syllabaryMap2.wa)
        data = data.replaceAll("we", syllabaryMap2.we)
        data = data.replaceAll("wi", syllabaryMap2.wi)
        data = data.replaceAll("wo", syllabaryMap2.wo)
        data = data.replaceAll("wu", syllabaryMap2.wu)
        data = data.replaceAll("wv", syllabaryMap2.wv)

        data = data.replaceAll("ya", syllabaryMap2.ya)
        data = data.replaceAll("ye", syllabaryMap2.ye)
        data = data.replaceAll("yi", syllabaryMap2.yi)
        data = data.replaceAll("yo", syllabaryMap2.yo)
        data = data.replaceAll("yu", syllabaryMap2.yu)
        data = data.replaceAll("yv", syllabaryMap2.yv)

        data = data.replaceAll("ta", syllabaryMap2.ta)
        data = data.replaceAll("te", syllabaryMap2.te)
        data = data.replaceAll("ti", syllabaryMap2.ti)
        data = data.replaceAll("to", syllabaryMap2.to)
        data = data.replaceAll("tu", syllabaryMap2.tu)
        data = data.replaceAll("tv", syllabaryMap2.tv)

        data = data.replaceAll("uh", syllabaryMap2.u)

        data = data.replaceAll("a", syllabaryMap2.a)
        data = data.replaceAll("e", syllabaryMap2.e)
        data = data.replaceAll("i", syllabaryMap2.i)
        data = data.replaceAll("o", syllabaryMap2.o)
        data = data.replaceAll("u", syllabaryMap2.u)
        data = data.replaceAll("v", syllabaryMap2.v)
        data = data.replaceAll("s", syllabaryMap2.s)

        if (!includeAlpha) {
            data = data.replaceAll(/[a-zA-Z]/, "not a valid letter")
        }

        return data;
    }
}