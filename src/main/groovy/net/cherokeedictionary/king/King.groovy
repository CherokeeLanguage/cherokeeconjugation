package net.cherokeedictionary.king;

class King {
    String id
    String version
    String nounRoot
    String useCase
    String present
    String imperf
    String perfective
    String imperative
    String infintive
    String definition
    String firstPresSing
    String thirdPresSing
    String prepronomPrefix
    String notes


    @Override
    public String toString() {
        return "King{" +
                "id='" + id + '\'' +
                ", version='" + version + '\'' +
                ", nounRoot='" + nounRoot + '\'' +
                ", useCase='" + useCase + '\'' +
                ", present='" + present + '\'' +
                ", imperf='" + imperf + '\'' +
                ", perfective='" + perfective + '\'' +
                ", imperative='" + imperative + '\'' +
                ", infintive='" + infintive + '\'' +
                ", definition='" + definition + '\'' +
                ", firstPresSing='" + firstPresSing + '\'' +
                ", thirdPresSing='" + thirdPresSing + '\'' +
                ", prepronomPrefix='" + prepronomPrefix + '\'' +
                ", notes='" + notes + '\'' +
                '}';
    }
}