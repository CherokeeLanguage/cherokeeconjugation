package cherokee.dictionary.verb.conjugation

import PrefixHolderObject

class HolderWord {
    //this is the root of the word in syllabary
    String syllabary

    //this is the ending of the word with the suffix removed but in latin script
    String nonfinalEndingLatin

    //the final ending syllabary
    String finalEndingSyllabary

    //the latin version of the final ending
    String finalEndingLatin

    String rootWord

    //holds all of the prefixes
    PrefixHolderObject pho = new PrefixHolderObject()

    @Override
    public String toString() {
        return "HolderWord{" +
                "syllabary='" + syllabary + '\'' +
                ", nonfinalEndingLatin='" + nonfinalEndingLatin + '\'' +
                ", finalEndingSyllabary='" + finalEndingSyllabary + '\'' +
                ", finalEndingLatin='" + finalEndingLatin + '\'' +
                ", rootWord='" + rootWord + '\'' +
                ", pho=" + pho +
                '}';
    }
}
