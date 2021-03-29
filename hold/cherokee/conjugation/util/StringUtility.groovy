package cherokee.conjugation.util

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

    public static int vowelByIndex(vowel) {
        switch(vowel) {
            case 'Ꭰ':
                return 0;
                break;
            case 'Ꭱ':
                return 1;
                break;
            case 'Ꭲ':
                return 2;
                break;
            case 'Ꭳ':
                return 3;
                break;
            case 'Ꭴ':
                return 4;
                break;
            case 'Ꭵ':
                return 5;
                break;
            default:
                return -1;
        }
    }

    public static String getOptionsByVowel(characterAtZero, baseReturnValue, lst) {
        def charAtZero = vowelByIndex(characterAtZero)

        return lst[charAtZero] + baseReturnValue.substring(1)
    }
}
