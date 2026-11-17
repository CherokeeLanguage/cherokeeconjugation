package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class GanesoysgaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Hailing (It is)",
        // tio 17Nov26: Feeling's glide-y orthography -- the book (p.78) writes "ganesoysga" /
        // "unesoysv'i" where CED's convention (Ayogi "uyosdi" = ᎤᏲᏍᏗ) drops the y before the
        // s-onset: canonical ganesosga / ganesosgoi / unesosvi (ᎦᏁᏐᏍᎦ...). The book marks the
        // infinitive x (unattested). -- tio 17Nov26
        // tio 17Nov26: IMPERSONAL verb -- no imperative exists (no agent to command; the book
        // box has no imperative column because the form is impermissible, not unattested).
        impersonal: true,
        part_of_speech: "v.i.",
        conjugations: [
            // tio 17Nov26: the "daganesoysi" the yaml carried as imperative is the book's FUTURE
            // column (p.78) -- the box has no imperative for this impersonal verb; the future form
            // is da-ganeso-si with the same glide-y drop. -- tio 17Nov26
            [subject: 'SG3', object: '', present: 'ganesosga', habitual: 'ganesosgoi', remote_past: 'unesosvi', imperative: '----', infinitive: '----']
        ]
    ]

    @Unroll
    def "conjugating Ganesoysga (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Ganesoysga", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG3" | "" | Tense.PRESENT         | "ganesosga"
        "SG3" | "" | Tense.HABITUAL        | "ganesosgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "unesosvi"
        // "SG3" | "" | Tense.FUTURE_COMMAND      | "unesoysvi"  // unattested -- the 2012 book (p.78) has no imperative column for weather verbs
        // "SG3" | "" | Tense.INFINITIVE      | "unesoysdi"  // tio 17Nov26: unattested -- the book prints x in the infinitive column
    }
}
