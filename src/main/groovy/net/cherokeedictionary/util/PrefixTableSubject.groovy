package net.cherokeedictionary.util

public enum PrefixTableSubject {
    SG1("First Singular"),
    SG2("Second Singular"),
    SG3("Third Singular"),
    DL1INCL("First Dual Inclusive"),
    DL1EXCL("First Dual Exclusive"),
    PL1INCL("First Plural Inclusive"),
    PL1EXCL("First Plural Exclusive"),
    DL2("Second Dual"),
    PL2("Second Plural"),
    PL3("Third Plural"),
    DL2INCL("Second Dual Inclusive"),
    DL2EXCL("Second Dual Exclusive"),
    PL2INCL("Second Plural Inclusive"),
    PL2EXCL("Second Plural Exclusive"),
    DL3INCL("Third Dual Inclusive"),
    DL3EXCL("Third Dual Exclusive"),
    PL3INCL("Third Plural Inclusive"),
    PL3EXCL("Third Plural Exclusive");

    private final String readableName;

    PrefixTableSubject(String readableName) {
        this.readableName = readableName;
    }

    public String getReadableName() {
        return readableName;
    }

    public static PrefixTableSubject fromReadableName(String readableName) {
        return values().find { it.readableName == readableName }
    }
}
