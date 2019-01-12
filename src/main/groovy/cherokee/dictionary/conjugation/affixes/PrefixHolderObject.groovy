package cherokee.dictionary.conjugation.affixes

class PrefixHolderObject {
    def yi = false
    def ji = false
    def wi = false
    def ni = false
    def de = false
    def da = false
    def di = false
    def i = false
    def ga = false
    def e = false

    //pronounPrefixes can consist of syllabary alone or syllabary and a latin script - the sounds in cherokee since cherokee was oral for millennia before written 200 years ago
    // mean that the awkward computerization transliteration of ᎠᏂ before consonants and Ꭰn before vowels requires a split into ᎠᏂ for syllabary and nothing in latin
    // but Ꭰ for syllabary and n for latin - which will provide morphemes and at times ellison for some prefix rules

    @Override
    public String toString() {
        return "PrefixHolderObject{" +
                "yi=" + yi +
                ", ji=" + ji +
                ", wi=" + wi +
                ", ni=" + ni +
                ", de=" + de +
                ", da=" + da +
                ", di=" + di +
                ", i=" + i +
                ", ga=" + ga +
                ", e=" + e +
                '}';
    }
}
