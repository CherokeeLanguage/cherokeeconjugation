package net.cherokeedictionary.verb.affixes.initialPrefixes

import net.cherokeedictionary.core.Verb
import net.cherokeedictionary.verb.affixes.Affix

/*
* p256 CED
* e-, distant imperative
form: e-; di- after de-, plural; cf. (128 -129) .
(128) a. sdi 2gowh2q 3ha . "You (dl) see it."
b. e 2sdi 23go 3hwah2ta. "You (dl) see it (facing the speaker)."
(129) a. de 2 sdi 3 gowh 2 t~ 3 ha. "You (dl) see them."
b. do 2 d~ 2 sdi 3 go 2 hwah 3 ta. "You (dl) see them (facing the speaker)."
function: e- is used with imperative forms when the person spoken to is facing
the speaker from a position some distance away.
comments: An alternative to considering e- and di-, position facing speaker, to
be two distinct prefixes is to analyze them as a single prefix di-, with a variant
form e- which occurs in imperative forms when not preceded by another prefix.

*/
class PrefixE implements Affix {
    String toSyllabary(String baseReturnValue, Verb word) {
        if (word.initialPrefixHolder.e) {
            def data = word.pronounReflexiveRoot
            def de = word.initialPrefixHolder.de

            if (de) {
                baseReturnValue = 'Ꮧ' + data;
            } else {
                baseReturnValue = 'Ꭱ' + data;
            }
        }

        return baseReturnValue;
    }

    String toEnglish(String baseReturnValue, Verb word) {
        return ""
    }

    String toString() {
        return e
    }
}
