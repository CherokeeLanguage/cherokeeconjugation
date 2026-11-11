package net.cherokeedictionary.util

public enum Tense {
    PRESENT,
    REMOTE_PAST,
    FUTURE_COMMAND,// Future Imperative/Volative (verb book): command for "sometime in the future, but not right now"
    COMPLETIVE_FUTURE,//not so sure that this and COMPLETED_FUTURE aren't the same
    COMPLETED_FUTURE,
    HABITUAL,// Present Habitual (verb book): "-o'i", regular/recurring action
    PROGRESSIVE_PAST,// grammar guide: -g- + -v'i, "was doing" (no verb-book section)
    PROGRESSIVE_FUTURE,// grammar guide: -esdi, "will be doing" (no verb-book section)
    IMMEDIATE_COMMAND,//IMPERATIVE - the "right now!" command; grammar guide "-a, present, recent past imperative"
    IMMEDIATE_PAST,// verb book Immediate Past (Stem IV): recent past, "-i" as printed (with "-a" variants)
    FUTURE_EXPECTED,// verb book Future (Expected): To Go only, future "-i" built from Stem II with the de- prefix
    INFINITIVE,
    RECENT_PAST_IMPERATIVE// grammar guide: "-a, present, recent past imperative"; the "-i" imperative is a variant of "-a"


}


//TODO: same as Habitual? - timo 10Nov26