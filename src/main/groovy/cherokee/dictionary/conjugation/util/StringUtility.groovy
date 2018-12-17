package cherokee.dictionary.conjugation.util

class StringUtility {
    //does the syllabary string start with a vowel
    public static boolean startsWithVowelSyllabary(String syllabary) {
        if (syllabary.startsWith("Ꭰ")
                || syllabary.startsWith("Ꭱ")
                || syllabary.startsWith("Ꭲ")
                || syllabary.startsWith("Ꭳ")
                || syllabary.startsWith("Ꭴ")
                || syllabary.startsWith("Ꭵ")) {
            return true;
        } else {
            return false;
        }
    }

    //does a latin string start with a vowel
    public static boolean startsWithVowelLatin(String latin) {
        if (latin.startsWith("a")
                || latin.startsWith("e")
                || latin.startsWith("i")
                || latin.startsWith("o")
                || latin.startsWith("u")
                || latin.startsWith("v")) {
            return true;
        } else {
            return false;
        }
    }
}
