package net.cherokeedictionary.util

public enum Tense {
    PRESENT("Present"),
    REMOTE_PAST("Remote Past"),
    FUTURE_COMMAND("Future Command"),
    COMPLETIVE_FUTURE("Completive Future"),
    COMPLETED_FUTURE("Completed Future"),
    HABITUAL("Habitual"),
    PROGRESSIVE_PAST("Progressive Past"),
    PROGRESSIVE_FUTURE("Progressive Future"),
    IMMEDIATE_COMMAND("Immediate Command"),
    IMMEDIATE_PAST("Immediate Past"),
    FUTURE_EXPECTED("Future Expected"),
    INFINITIVE("Infinitive"),
    RECENT_PAST_IMPERATIVE("Recent Past Imperative");

    private final String readableName;

    Tense(String readableName) {
        this.readableName = readableName;
    }

    public String getReadableName() {
        return readableName;
    }
}
