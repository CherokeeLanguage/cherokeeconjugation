package cherokee.dictionary.conjugation.wordFormation

import cherokee.dictionary.conjugation.affixes.prefixes.*

class BaseVerb implements Verb {
//    y- j- w- n- de- da- di- i- ga- e- pronouns-
    PrefixYi yi;
    PrefixJi ji;
    PrefixWi wi;
    PrefixNi ni;
    PrefixDe de;
    PrefixDa da;
    PrefixDi di;
    PrefixI i;
    PrefixGa ga;
    PrefixE e;

    String baseVerbEntry;

    public void setYi(String yi) {
        yi = new PrefixYi(yi: yi)
    }

    public void setWi(String wy) {
        wi = new PrefixWi(wi: wy)
    }

    public void setJi(String jy) {
        ji = new PrefixJi(ji: jy)
    }

    public void setNi(String ni) {
        ni = new PrefixNi(ni: ni)
    }

    public void setDe(String de) {
        de = new PrefixDe(de: de)
    }

    public void setDa(String da) {
        da = new PrefixDa(da: da)
    }

    public void setDi(String di) {
        di = new PrefixDi(di:di)
    }

    public void setI(String i) {
        i = new PrefixI(i:i)
    }

    public void setGa(String ga) {
        ga = new PrefixGa(ga:ga)
    }

    public void setE(String e) {
        e = new PrefixDe(e:e)
    }
}