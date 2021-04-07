package net.cherokeedcitionary.verbal.containers;

abstract class HolderObjectBase {
    def map = [:]
    public boolean allFalse() {
        map.each {it ->
            if (it.value) {
                return false
            }
        }
    }

    //TODO: should there be more than one returned
    public List getTrueValues() {
        List<String> returnValue = []
        map.each {it ->
            if (it.value) {
                returnValue << it.key
            }
        }

        return returnValue
    }

//        @Override
//    void setProperty(String name, Object value) {
////        if (map.size() == 0) {
////            println "mapsize si 0"
////            setMap(["yi":false, "ji":false, "wi": false, "ni":false, "de":false, "da":false, "di":false, "i":false, "ga":false, "e":false])
////        }
//
//
//
//        if (map.containsKey(name)) {
//            setValue(name, value)
//        }
//    }

//    abstract void setValue(key, value)
}