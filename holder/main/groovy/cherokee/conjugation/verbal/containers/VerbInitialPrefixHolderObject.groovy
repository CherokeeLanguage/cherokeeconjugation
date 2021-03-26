package cherokee.conjugation.verbal.containers
//todo: can I add a listener annotation that will determine if a field is update and if it is then update a map?
class VerbInitialPrefixHolderObject extends HolderObjectBase {
    public VerbInitialPrefixHolderObject(Closure closure) {
        setMap(["yi":yi, "ji":ji, "wi": wi, "ni":ni, "de":de, "da":da, "di":di, "i":i, "ga":ga, "e":e])
    }

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

    public boolean allFalse() {
        if (!yi && !ji &&!wi && !ni && !de && !da && !di && !i && !ga && !e) {
            return true
        }
    }

    @Override
    public String toString() {
        return "VerbInitialPrefixHolderObject{" +
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