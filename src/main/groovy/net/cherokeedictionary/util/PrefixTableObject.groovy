package net.cherokeedictionary.util

public enum PrefixTableObject {
    SG1("First Singular"),
    SG2("Second Singular"),
    SG3AN("Third Singular (Animate)"),
    SG3IN("Third Singular (Inanimate)"),
    DL1INCL("First Dual Inclusive"),
    DL1EXCL("First Dual Exclusive"),
    PL1INCL("First Plural Inclusive"),
    PL1EXCL("First Plural Exclusive"),
    DL2("Second Dual"),
    PL2("Second Plural"),
    PL3AN("Third Plural (Animate)"),
    PL3IN("Third Plural (Inanimate)"),
    NONE("None");

    private final String readableName;

    PrefixTableObject(String readableName) {
        this.readableName = readableName;
    }

    public String getReadableName() {
        return readableName;
    }

    public static PrefixTableObject fromReadableName(String readableName) {
        return values().find { it.readableName == readableName }
    }
}
