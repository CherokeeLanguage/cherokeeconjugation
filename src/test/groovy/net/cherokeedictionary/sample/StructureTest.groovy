package net.cherokeedictionary.sample

/**
 * This class should take an idea for a verb conjugation
 * the idea is that since every affix has an order (as defined by the DF CED)
 * then if those affixes are present for conjugation then they're added in a LinkedList
 * because the affixes are also a boolean value - we can verify they exist when making conversion changes
 * for exmaple: da- plus -i- becomes dv-;
 *              we can take da- and check if the first letter of the next item is an -i- and if so then remove one and add dv
 */

class StringHolder {
    String SH = ""
}

def idiot = new StringHolder(SH:"idiot")
def danat = new StringHolder(SH:"danat")

List<Morph> morphList = new LinkedList<Morph>()
List morphemes = []
morphList << new YiHa(active:true)
morphList << new YiDa(active:true)
morphList << new YiDo(active:true)

morphList.each {
    if (it.isActive()) {
        it.apply(idiot)
    }
}

println idiot.SH

morphList.each {
    if (it.isActive()) {
        it.apply(danat)
    }
}

println danat.SH