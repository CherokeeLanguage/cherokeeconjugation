package net.cherokeedictionary.conjugation.grammarGuide

import spock.lang.Specification
import spock.lang.Unroll

class GrammarGuideSpec2 extends Specification {

    @Unroll
    def "Breakdown Example: #syllabary (#phonetic) -> #translation"() {
        expect:
        syllabary != null && !syllabary.trim().isEmpty()
        phonetic != null && !phonetic.trim().isEmpty()
        translation != null && !translation.trim().isEmpty()

        where:
        syllabary                           | phonetic                                  | translation
        // Notes on Paradigm Eight & Summary of I-B
        "ᎠᎩᎸᏆᏗ"                             | "a¹gị²lv²³kwdi"                           | "I like it"
        "ᎠᎩᎪᎲᎢ"                             | "a¹gị²go²hv²³ʔi"                          | "I saw it."
        "ᎢᏂᏬᏂᎭ"                             | "i¹ni²wo³nị²ha"                           | "you and I are speaking"
        "ᎣᏍᏗᏬᏂᎭ"                            | "o¹sdi²wo³nị²ha"                          | "he and I are speaking"
        "ᎬᏃᏌᏍᎦ"                             | "gv²no²sạ³sga"                            | "he is sweeping"
        "ᎡᎦ"                               | "e³ga"                                    | "he is going."
        "ᎦᏬᏂᎭ"                             | "gạ²wo³nị²ha"                             | "he is speaking"
        "ᎠᎪᏩᏘᎭ"                             | "a¹gowh²tị³ha"                            | "he sees it."

        // I-C: Non-final Suffixes
        // -gi-, reversive
        "ᎬᏍᎦ."                              | "gv¹sga."                                 | "I'm weaving it."
        "ᎬᎩᎠ."                              | "gv²gi³ʔa."                               | "I'm unweaving it."
        "ᎬᏎᎭ."                              | "gv²sẹ³ha."                               | "He's weaving it for him."
        "ᎬᎩᎡᎭ."                             | "gv²gi³ʔe²ha."                            | "He's unweaving it for him."
        "ᎬᎩᏍᎬᎢ."                            | "gv²gi³sgv²³ʔi."                          | "He was unweaving it."
        "ᎬᎩᏍᏗᎭ."                            | "gv²gi³sdị²ha."                           | "He's using it to unweave it."
        "ᎬᎩᏍᏙᏗᎭ."                          | "gv²gi³sdoh²dị³ha."                       | "He's accidentally unweaving it."
        "ᏓᎬᎩᎢᎵ."                            | "dạ²gv²³gị³ʔe²li."                        | "He will unweave it for him."

        // -e-, reversive
        "ᏓᎿᏬᏍᎬᎢ."                          | "da¹hnạ²wo³sgv²³ʔi."                      | "He was dressing."
        "ᏓᎿᏪᏍᎬᎢ."                          | "da¹hnạ²we³sgv²³ʔi."                      | "He was undressing."

        // -y-, reversive
        "ᎠᏓᏠᎯᎭ."                            | "a¹da³dlo²hị³ha."                         | "He is putting on his belt."
        "ᎠᏓᏠᏱᎭ."                            | "a¹da³dlo²hyị³ha."                        | "He is taking off his belt."

        // -is-, duplicative
        "ᎦᏬᏂᏏᎵᎠ."                          | "gạ²wo³ni²si²³si³lọ²ʔa."                  | "He is making the same speech repeatedly."
        "ᎦᏬᏂᏍᎬᎢ."                          | "gạ²wo³ni²sgv²³ʔi."                       | "He was speaking."
        "ᎦᎣᏂᏏᏏᏍᎬᎢ."                        | "gạ²wo³ni²si²³si³sgv²³ʔi."                | "He was making the same speech."
        "ᎦᎣᏂᏏᏏᎭ."                          | "gạ²wo³ni²si²³sị³ha."                     | "He is making the same speech."
        "ᎤᏬᏂᏏᏌᏅᎢ."                         | "u¹wo³ni²si²³sạ³hnv²³ʔi."                 | "He made the same speech."
        "ᎯᏬᏂᏏᏌᏅᎢ."                         | "hị²wo³ni²si²³sạ³hnv²ʔi."                 | "Make the same speech later."
        "ᎤᏬᏂᎯᏍᏗ ᎤᏚᎵ."                      | "u²wo¹ni²³hị³sdi u¹du²li."                | "He wants him to speak."
        "ᎤᏬᏂᏏᏐᏗ ᎤᏚᎵ."                      | "u²wo¹ni²³si³soh²di u¹du²li."             | "He wants him to make the same speech again."

        // -is-, "become"
        "ᎤᏲᏏᏌᏁᎢ."                          | "u¹yo³si²sạ²hne³ʔi."                      | "He reportedly got hungry."
        "ᎤᏲᏏᏏᏍᎬᎢ."                         | "u¹yo³si²si²³sgv³ʔi."                     | "He was getting hungry."
        "ᎤᏲᏏᏏᎭ."                          | "u¹yo³si²sị³ha."                          | "He is getting hungry."
        "ᎤᏲᏏᏏᎶᏍᎪᎢ."                        | "u¹yo³si²si²³lo³²sgo³ʔi."                 | "He repeatedly gets hungry."
        "ᎤᏲᏏᏌᏁᎭ."                          | "u¹yo³si²sa³²nẹ²ha."                      | "He's getting hungry because of him."

        // -ilo-, repetitive
        "ᎤᏬᏂᏎᎢ."                            | "u¹wo³ni²se³ʔi."                          | "He reportedly spoke."
        "ᎤᏬᏂᏎᎶᎡᎢ."                          | "u¹wo³ni²se²³lọ³ʔe³i."                    | "He reportedly spoke over and over."
        "ᎦᏬᏂᏎᎶᏍᎬᎢ."                        | "gạ²wo³ni²si²³lo³²sgv²³ʔi."               | "He was speaking repeatedly."
        "ᎯᏬᏂᎯ."                            | "hị²wo¹ni²³hi."                           | "Speak."
        "ᎯᏬᏂᏏᎶᏣ."                          | "hị²wo¹ni²si²lo²³ja."                     | "Speak repeatedly."

        // -dan-, instrumental, causative
        "ᎤᏬᏂᎯᏍᏓᏁᎴᎢ."                      | "u¹wo³ni²hị²sda³²ne²le³ʔi."               | "He reportedly used it to speak with for him."
        "ᎦᏬᏂᎯᏍᏗᏍᎬᎢ."                      | "gạ²wo³ni²hị²sdi²³sgv³ʔi."                | "He was using it to speak with."
        "ᎦᏬᏂᎯᏍᏗᎭ."                        | "gạ²wo³ni²hị²sdị³ha."                     | "He's using it to speak with."
        "ᎤᏬᏂᎯᏍᏙᏗ ᎤᏚᎵ."                      | "u²wo¹ni²³hị³sdoh²di u¹du²li."            | "He wants to use it to speak with."
        "ᎯᏬᏂᎯᏍᏓ."                          | "hị²wo¹ni²hị²sda."                        | "Use it to speak with."
        "ᎠᎵᏍᎦᎠ."                            | "al¹sgi³ʔa."                              | "He's dancing."
        "ᎠᎵᏍᎩᏍᏗᎭ."                          | "al¹sgi³sdị²ha."                          | "He's making it dance."
        "ᎠᏗᏔᏍᏗᎭ."                          | "a¹di²tạ²sdị³ha."                         | "He's causing him to drink."

        // -dohdan-, unintentional
        "ᎠᎪᏩᏛᏙᎭ."                          | "a¹gowh²tvh²doh³dị³ha."                   | "He's seeing it accidentally."
        "ᎤᎪᏩᏛᏙᏗ ᎤᏚᎵ."                      | "u²gowh²tvh²doh³di u¹du²li."              | "He wants him to see it accidentally."
        "ᎯᏬᏂᎯᏍᏙᏓ."                          | "hị²wo¹ni²hị²sdoh²da."                    | "Speak unintentionally."

        // -ohn-, completive
        "ᎤᏬᏂᏐᏅᎢ."                          | "u¹wo³ni²sọ³hnv³ʔi."                      | "He finished speaking."
        "ᎦᏬᏂᏐᎯᏍᎦ."                         | "gạ²wo³ni²sọ³hṿ³sga."                     | "He's finishing speaking."
        "ᎤᏬᏂᏐᎯᏍᏗ ᎤᏚᎵ."                      | "u²wo¹ni²³sọ³hṿ²sdi u¹du²li."             | "He wants to finish speaking."
        "ᎦᏬᏂᏐᎿ."                            | "gạ²wo³ni²sọ³hna."                        | "He just finished speaking."
        "ᏓᎦᏬᏂᏐᏂ."                          | "dạ²gạ²wo³²ni²sọ³hni."                    | "He will finish speaking (at a specific point in time)."

        // -el-, dative-benefactive
        "ᏓᎦᏬᏂᏏ."                            | "dạ²gạ²wo³²ni²si."                        | "He will speak."
        "ᏓᎦᏬᏂᎯᏎᎵ."                         | "dạ²gạ²wo³²ni²hị²se²³li."                 | "He will speak for him."
        "ᎤᏬᏂᎯᏍᏗ. ᎤᏚᎵᎭ."                    | "u²wo¹ni²³hị³seh²di u¹du²lị³ha."          | "He wants to speak for him."
        "ᎦᏬᏂᎯᏎᎭ."                          | "gạ²wo³ni²hị²sẹ³ha."                      | "He is speaking for him."
        "ᎠᏁᎭ."                              | "a¹hnẹ³ha."                               | "He is giving it to him."
        "ᎠᏩᎯᏎᎭ."                            | "a¹hwạ²hị³sẹ²ha."                         | "He is buying it from him."
        "ᏚᏓᏲᏒᎢ."                            | "du¹da³yọ²sv²³ʔi."                        | "He surrendered."
        "ᏓᏓᏲᏍᎦ."                            | "da¹da³yọ²sga."                           | "He's surrendering."
        "ᏧᏓᏲᎯᏍᏗ ᎤᏚᎵᎭ."                    | "ju²da²yọ³hị³sdi u¹du²lị³ha."             | "He wants him to surrender."
        "ᏓᏓᏲᎯᏎᎭ."                          | "da¹da³yọ²hị²sẹ³ha."                      | "He's surrendering for him."

        // -idol-, "around"
        "ᎤᏬᏂᏒᎢ."                            | "u¹wo³ni²sv²³ʔi."                         | "He spoke."
        "ᎤᏬᏂᏏᏙᎸᎢ."                         | "u¹wo³ni²si²³do³²lv²³ʔi."                 | "He went around speaking."
        "ᎦᏬᏂᏏᏙᎲᎢ."                         | "gạ²wo³ni²si²³do³²hv²³ʔi."                | "He was going around speaking."
        "ᎤᏬᏂᏏᏓᏍᏗ ᎤᏚᎵ."                      | "u²wo¹ni²³si³da¹sdi u¹du²li."             | "He wants to go around speaking."
        "ᎯᏬᏂᏏᏓ."                            | "hị²wo¹ni²si²³da."                        | "Go around speaking."
        "ᎦᏬᏂᏏᏓ."                            | "gạ²wo³ni²si²³da."                        | "He just now went around speaking."
        "ᎦᏬᏂᏏᏙᎭ."                          | "gạ²wo³ni²si²³do³²ha."                    | "He is going around speaking."

        // -e-, "at intervals"
        "ᎤᏬᏂᏒᏒᎢ."                           | "u¹wo³ni²sv³sv²³ʔi."                      | "He spoke at intervals."
        "ᎤᏬᏂᏒᏍᏗ ᎤᏚᎵᎭ."                    | "u²wo¹ni²³sv³²sdi u¹du²lị³ha."            | "He wants to speak at intervals."
        "ᎦᏬᏂᏎᎬᎢ."                           | "gạ²wo³ni²se³gv²³ʔi."                     | "He was speaking at intervals."
        "ᏓᎦᏬᏂᏎᏏ."                          | "dạ²gạ²wo³²ni²se³si."                     | "He will speak at intervals."
        "ᎦᏬᏂᏑᎦ"                             | "gạ²wo³ni²su³²ga"                         | "he just now went to speak."
        "ᎠᎴᏫᏍᏔᏁᎦ."                          | "a¹le²hwị²stạ²ne³ga."                     | "He, it's stopping at intervals."
        "ᎦᏬᏂᏎᎦ."                            | "gạ²wo³ni²se³ga."                         | "He is going (to a certain location) in order to speak."

        // -ihl-, "come to"
        "ᏓᎦᏬᏂᏏᏟ."                           | "dạ²gạ²wo³²ni²si²³hli."                   | "He will come to speak."
        "ᎤᏬᏂᏏᎯᏍᏗ ᎤᏚᎵᎭ."                    | "u²wo¹ni²³si³hị²sdi u¹du²lị³ha."          | "He wants to come speak."
        "ᎦᏬᏂᏏᎯᎲᎢ."                         | "gạ²wo³ni²si²³hị³hv²³ʔi."                 | "He was coming to speak."
        "ᎦᏬᏂᏏᎦ."                            | "gạ²wo³ni²si²³ga."                        | "He just now came to speak."
        "ᎯᏬᏂᏏᎦ."                            | "hị²wo¹ni²si²³ga."                        | "Come to speak."

        // -g-, progressive
        "ᎦᏬᏂᏍᎨᏍᏗ."                         | "gạ²wo³ni²sge³sdi."                       | "He will be speaking."
        "ᎦᏬᏂᏏᏩᏙᎮᏍᏗ."                       | "gạ²wo³ni²si²³do³²he³sdi."                | "He will be going around speaking."
        "ᎦᏬᏂᏍᎪᎢ."                          | "gạ²wo³ni²sgo³ʔi."                        | "He speaks habitually."

        // I-D: Final Suffixes
        // -idi, pre-incipient
        "ᎤᏬᏂᏏᏗ."                            | "u¹wo³ni²si⁴di."                          | "He is about to speak."
        "ᎤᏪᏂᏏᏗᏒᎢ."                         | "u¹wo³ni²si²³di³²sv²³ʔi."                 | "He was about to speak."
        "ᎤᏬᏂᏏᏗᏎᎢ."                          | "u¹wo³ni²si²³di³²se³ʔi."                  | "He was reportedly about to speak."
        "ᎤᏬᏂᏏᏗᏎᏍᏗ."                        | "u¹wo³ni²si²³di³²se³sdi."                 | "He will be about to speak."
        "ᏄᏬᏂᏏᏗᏐᎢ."                         | "nu²³wo³²ni²si²³di³²so⁴ʔi."               | "He was already about to speak."
        "ᎤᏬᏂᏏᏗᏐᎢ."                         | "u¹wo³ni²si²³di³²so³ʔi."                  | "He is habitually about to speak."
        "ᎤᎦᎿᏂᏕᎾ."                          | "u²ga²hnạ²ni²de⁴na."                      | "It's about to rain. (immediately)"

        // -i, future
        "ᏓᎦᏬᏂᏏᏍᎦᎪ?"                        | "dạ²gạ²wo³²ni²sị³sgo?"                    | "Is he going to speak?"
        "ᏓᎦᏬᏂᏏᏒᎢ."                          | "dạ²gạ²wo³²ni²si³sv²³ʔi."                 | "He was going to speak."
        "ᏂᏗᎦᏬᏂᏏᏐᎢ."                        | "nị²dị²gạ³wo³ni²si³so⁴ʔi."                | "He was already going to speak."
        "ᏗᎦᏬᏂᏏᏐᎢ."                         | "dị²gạ²wo³²ni²si³so³ʔi."                  | "He always intends to speak."
        "ᏗᎦᏬᏂᏏᏎᏍᏗ."                        | "dị²gạ²wo³²ni²si³se³sdi."                 | "He will be going to speak."
        "ᏗᎦᏬᏂᏏᏎᎢ."                          | "dị²gạ²wo³²ni²si³se³ʔi."                  | "He was reportedly going to speak."

        // -vʔi, past
        "ᎯᏬᏂᏒᎢ."                            | "hị²wo³ni²sv²ʔi."                         | "Speak (later)."

        // -eʔi, reportative
        "ᎦᏬᏂᏍᎨᎢ."                          | "gạ²wo³ni²sge³ʔi."                        | "He was reportedly speaking."

        // -esdi, future progressive
        "ᎯᏬᏂᏍᎨᏍᏗ."                         | "hị²wo³ni²sge³sdi."                       | "Be speaking. (as in 'Be speaking when I get there.')"

        // -oʔi, pluperfect & habitual
        "ᏄᏬᏂᏐᎢ."                            | "nu²³wo³²ni²so⁴ʔi."                       | "He had already spoken. (prior to some other event)"
        "Ꮭ ᏱᎦᏬᏂᏍᎪᎢ."                       | "hla³ yị²gạ²wo³²ni²sgo³ʔi."               | "He doesn't speak habitually."
        "Ꮭ ᏳᏬᏂᏐᎢ."                         | "hla³ yu²³wo³²ni²so³ʔi."                  | "He never speaks. (although he could)"

        // -di, infinitive
        "ᎤᏬᏂᎯᏍᏗ ᎤᎵᎭ."                      | "u²wo¹ni²³hị³sdi u¹du²lị³ha."             | "He wants him to speak or He wants to speak."
        "ᎠᎩᏬᏂᎯᏍᏗ ᎤᏚᎵᎭ."                    | "ạ²gị²wo¹ni²³hị³sdi u¹du²lị³ha."          | "He wants me to speak."

        // -a, present, recent past, imperative, doubt, capability
        "ᏍᎯᎵ."                              | "a¹hịʔ³li."                               | "He's driving."
        "ᎠᎯᎵᏙᎭ."                            | "a¹hịʔ³li²³do³²ha."                       | "He's driving around."
        "ᎯᎯᎷᎦ."                             | "hị²hịʔ²lu¹ga."                           | "Drive."
        "ᎯᏬᏂᎯᏏ."                            | "hi²wo¹ni²hị²si."                         | "Speak for him."
        "ᏳᏬᏂᏌ."                             | "yụ³wo³ni²sa."                            | "He may have spoken."
        "ᏱᎦᏬᏂᎭ."                            | "yi²³gạ³wo³nị²ha."                        | "He may be speaking."
        "ᏱᏥᏬᏂᎯ."                            | "yị²jị²wo³ni²hi."                         | "I can speak."
        "ᏱᏥᏬᏂᏏᎶᏣ."                          | "yị²jị²wo³ni²si²³lo³ja."                  | "I can speak over and over."

        // -vʔi, future imperative
        "ᎯᏬᏂᏏᏙᎸᎢ."                         | "hị²wo³ni²si²³do³²lv²ʔi."                 | "Go around and speak later."

        // Discourse & interrogative suffixes (-gwu, -sgo, -ju, -ke, -na, -hv, -isi, -dina, -dv)
        "ᎦᏬᏂᎭᏊ."                            | "gạ²wo³nị²hạ³gwu."                        | "He's just speaking. or He's only speaking."
        "Ꮟ ᎦᏬᏂᎭᏊ."                         | "si³ gạ²wo³nị²hạ³gwu."                    | "He's still speaking."
        "ᎦᏬᏂᎭᏍᎪ?"                          | "gạ²wo³nị²hạ³sgo?"                        | "Is he speaking?"
        "ᎦᏬᏂᎭᏍ?"                           | "gạ²wo³nị²has³?"                          | "Is he speaking?"
        "ᎦᏬᏂᎭᏧ?"                           | "gạ²wo³nị²hạ³ju?"                         | "Is he speakingʔ"
        "ᎫᏘᎭᏧ?"                             | "gu²tị³hạ³ju?"                            | "Well, is it snowingʔ"
        "ᏕᎧᏃᎩᎠᏍ?"                           | "de²³kạ³no²gi³ʔas³?"                      | "Is he singingʔ"
        "ᎦᏬᏂᎭᏍ, ᏕᎧᏃᎩᎠᎨ?"                   | "gạ²wo³nị²has³, de²³kạ³no²gi³ʔạ³ke?"      | "Is he speaking or singing?"
        "ᏳᏬᏂᏌᎾ?"                            | "yu²³wo³²ni⁴sạ²na¹?"                      | "And what if he spokeʔ"
        "ᏂᎯᎾ?"                              | "nị²hi⁴na¹?"                              | "And what about you?"
        "ᎡᏓᏛᏓᏍᏓ."                          | "e²da³²tv²da³²sda."                       | "Let's you (pl) and I listen to him."
        "ᎦᏬᏂᎭᏍᎪᎲ?"                         | "gạ²wo³nị²hạ³sgo¹hv?"                     | "But is he speaking?"
        "ᎤᏬᏝᏍᎪᎲ?"                          | "u¹wo²³hlạ³sgo¹hv³?"                      | "But is he home?"
        "ᏣᎦᏎᏍᏕᏍᏗ, ᏘᏅᏥᏏ."                    | "jạ²ksẹ²sde³sdi, tị²nv³²ji³²si."          | "Be careful, or else you'll fall."
        "ᏙᏓᏣᎾᏒᏟᏙᎵᏏ."                        | "do²dạ³chạ³na³²sv²hli²³do³²li³²si."       | "Or else you're going to slide around."
        "ᎯᏬᏂᎯᏗᎾ."                          | "hị²wo¹ni²³hị³di³na."                     | "Speak, then."
        "ᎫᏘᎭᏍ ᎠᎦᏍᎦᎨ?"                      | "gu²tị³has³ a¹ga²sgạ³ke?"                 | "Is it snowing or raining?"
        "ᎠᎦᏍᎦᏛ."                            | "a¹ga²sgạ³dv³."                           | "It's raining."
        "ᎤᏬᏂᏎᎢᏍ?"                           | "u¹wo³ni²se³ʔis³?"                        | "Did he speak?"
        "ᎤᏬᏂᏎᏍ?"                            | "u¹wo³ni²ses³?"                           | "Did he speak?"

        // Multi-suffix formations of "to speak"
        "ᎤᏬᏏᏏᏗ."                            | "u¹wo³ni²si²³si⁴di."                      | "He's about to make the same speech again."
        "ᎤᏬᏂᏏᏏᏗᏒᎢ."                         | "u¹wo³ni²si²³si³di¹sv²³ʔi."               | "He was about to make the same speech again."
        "ᏓᎦᏬᏂᏏᏏᎶᎢ."                         | "dạ²gạ²wo³²ni²si²³si³lọ²ʔi."              | "He will make the same speech repeatedly."
        "ᏓᎦᏬᏂᏏᏏᎶᎢᏏ."                       | "dạ²gạ²wo³²ni²si²³si³lọ²ʔi³²si."          | "Or else he'll make the same speech repeatedly."
        "ᎦᏬᏂᎯᏍᏔᏃᎲᏍᎦ."                       | "gạ²wo³ni²hị²stạ²nọ³hṿ³sga."              | "He's finishing using it to speak with."
        "ᏄᏬᏂᏏᏗᏎᎢ."                          | "nu²³wo³²ni²si²³di³²se⁴ʔi."               | "He had already been about to speak."
        "ᎦᏬᏂᏏᎶᏍᏗᎭ."                         | "gạ²wo³ni²si²³lo³²sdị²ha."                | "He's using it to speak with repeatedly."
        "ᎦᏬᏂᏏᎶᎥᏍᎦ."                         | "gạ²wo³ni²si²³lọ³ʔṿ²sga."                 | "He's finishing speaking repeatedly."
        "ᎦᏬᏂᏏᎶᎡᎦ."                          | "gạ²wo³ni²si²³lọ³ʔe¹ga."                  | "He's going there to speak repeatedly."
        "ᎦᏬᏂᎯᏎᎴᎦ."                          | "gạ²wo³ni²hị²se²³le³²ga."                 | "He's going there to speak for him."
        "ᎦᏬᏂᏏᏙᎰᎢ."                          | "gạ²wo³ni²si²³do³²ho³ʔi."                 | "He habitually goes around speaking."
        "ᎦᏬᏂᏏᎶᎢᎯᎭ."                         | "gạ²wo³ni²si²³lọ³ʔi²hị³ha."               | "He is coming to speak repeatedly."
        "ᎦᏬᏂᏏᏏᎶᎡᎦ."                         | "gạ²wo³ni²si²³si³lọ²ʔe¹ga."               | "He's going there to make the same speech repeatedly."
        "ᎦᏬᏂᏏᏏᎶᎡᎴᎦ."                        | "gạ²wo³ni²si²³si³lọ²ʔe²le³ga."            | "He's going there to make the same speech repeatedly for him."
        "ᎦᏬᏂᏏᏏᎶᎡᎴᎦᏍᎪᎲ?"                    | "gạ²wo³ni²si²³si³lọ²ʔe²le³gạ³sgo¹hv³?"    | "But is he going there to make the same speech for him repeatedly?"

        // I-E: Reflexive, Reciprocal, Passive, Classificatory
        "ᎠᏓᏛᏂᎭ."                            | "a¹da²dv²hnị³ha."                         | "He's hitting himself."
        "ᎠᏓᏢᎢᎭ."                            | "a¹da²hlv³ʔị²ha."                         | "He's tying himself up."
        "ᎠᏓᎪᏩᏘᎭ."                           | "a¹da²gowh²tị³ha."                        | "He sees himself."
        "ᎤᏩᏂᎸᎢ."                            | "u¹wa²hnị³lv³ʔi."                         | "He hit it."
        "ᎤᏓᏛᏂᎸᎢ."                          | "u¹da²dv²hnị³lv³ʔi."                      | "He hit himself."
        "ᏓᎾᏓᏛᏂᎭ."                          | "da¹nạ²da²dv²hnị³ha."                     | "They are hitting each other."
        "ᏓᎾᏓᏢᎢᎭ."                          | "da¹nạ²da²hlv³ʔị²ha."                     | "They are tying each other up, They are tying themselves up. (plural acts of tying)"
        "ᎠᎾᏓᏢᎢᎭ."                          | "a¹nạ²da²hlv³ʔị²ha."                      | "They are tying themselves. (a single act of tying)"
        "ᎠᏍᎦᏯ ᎠᎪᏩᏘᎭ."                      | "ạ²sgạ²ya a¹gowh²tị³ha."                  | "He sees a man."
        "ᎠᏓᎪᏩᏘᎭ."                           | "a¹da²gowh²tị³ha."                        | "He sees (him)."
        "ᎯᎪᏩᏘᏍᎪᎢᏍ?"                        | "hi²gowh¹ti²³sgo³ʔis³?"                   | "Do you (habitually) see him?"
        "Ali ᎤᏍᏉᏟ ᎬᏂᎦ Foreman."             | "Ali u²sgwo²hli gvnh²ga Foreman."         | "Foreman just hit Ali in the stomach. (immediate past)"
        "AliᏛ ᎥᎠᏓᏛᏂᎦ."                      | "Alihnv ṿ³ʔạ²da²dvnh²ga."                 | "And Ali just hit back."
        "ᎠᏓᎯᎯ"                              | "ạ²da²³hị²hi"                             | "killer (inanimate)"
        "ᏗᏓᎯᎯ"                              | "di²da²³hị²hi"                            | "killer (animate)"
        "ᎩᏓ ᏗᎯᎯ"                            | "gi²hli di²³hị²hi"                        | "dog killer (animate or inanimate)"
        "ᎠᏓᎪᏩᏘᎭᏍ?"                          | "a¹da²gowh²tị³has³?"                      | "Does he see (him)?"
        "ᎠᎪᏩᏘᎭᏍ?"                          | "a¹gowh²tị³has³?"                         | "Does he see him?"
        "ᎠᏍᎦᏯ ᎠᏥᎪᏩᏘᎭ."                      | "ạ²sgạ²ya a¹jị²gowh¹tị³ha."               | "A man is being seen."
        "ᎠᎨᏯ ᎠᎪᏩᏘᎭ ᎠᏍᎦᏯ."                  | "ạ²ge²³hya a¹gowh²tị³ha ạ²sgạ²ya."       | "A man sees a woman."
        "ᎠᏍᎦᏯ ᎤᎪᏩᏘᎭ ᎠᎨᏯ."                  | "ạ²sgạ²ya u¹gowh²tị³ha ạ¹ge²³hya."       | "A woman is being seen by a man."
        "ᎠᎨᏯ ᎤᎪᏩᏘᎭ ᎠᏍᎦᏯ."                  | "ạ²ge²³hya u¹gowh²tv²hv²³ʔi ạ²sgạ²ya."   | "A man saw a woman."
        "ᎠᎦᏍᎦ."                             | "a¹ga²sga."                               | "It's raining ."
        "ᎤᎦᏍᎦ."                             | "u¹ga²sga."                               | "It's raining on him."
        "ᎠᏍᎦᏯ ᎤᎪᏩᏘᎭ ᎩᏟ."                   | "ạ²sgạ²ya u¹gowh²tị³ha gi²hli."           | "A dog is being seen by a man."
        "ᎠᏍᎦᏯ ᎤᏂᎪᏩᏘᎭ ᎩᏟ."                  | "ạ²sgạ²ya u¹ni²gowh²tị³ha² gi²hli."       | "Dogs are being seen by a man."
        "ᎠᏂᏍᎦᏯ ᎬᏩᎪᏩᏘᎭ ᎩᏟ."                 | "ạ²ni²sgạ²ya gv²wạ²gowh²tị³ha gi²hli."    | "A dog is being seen by men."
        "ᎠᏂᏍᎦᏯ ᎬᏩᏂᎪᏩᏘᎭ ᎩᏟ."                | "ạ²ni²sgạ²ya gv²wạ²ni²gowh²tị³ha gi²hli." | "Dogs are being seen by men."
        "ᎠᏍᎦᏯ ᎤᏩᏂ ᎩᏟ."                      | "ạ²sgạ²ya u¹wa²hni gi²hli."               | "A dog is being hit by a man."
        "ᎠᏍᎦᏯ ᏚᏅᏂ ᎩᏟ."                      | "ạ²sgạ²ya du¹nv²hni gi²hli."              | "Dogs are being hit by a man."
        "ᎠᏂᏍᎦᏯ ᏕᎬᏩᏂ ᎩᏟ."                    | "ạ²ni²sgạ²ya de²gv³wa²hni gi²hli."        | "A dog is being hit by men."
        "ᎠᏂᏍᎦᏯ ᏕᎬᏩᏅᏂ ᎩᏟ."                   | "ạ²ni²sgạ²ya de²gv³wạ²nv²hni gi²hli."     | "Dogs are being hit by men."
        "ᎪᏪᎵᎠ."                            | "go²hwe²³lị³ʔa."                          | "He's writing it."
        "ᎠᏩᏙᏪᎵᎠ."                          | "a¹do²hwe²³lị³ʔa."                        | "It's being written."
        "ᎠᏍᎪᎸᏗᎠ."                          | "a¹sgo²³lv³dị²ʔa."                        | "He's erasing it."
        "ᎠᎵᏍᎪᎸᏗᎠ."                          | "al¹sgo²³lv³dị²ʔa."                       | "It's erasing itself."
        "ᎠᎬᎭᎵᎭ."                            | "a¹gv²hạ²lị³ha."                          | "He's cutting it out."
        "ᎠᎵᎬᎭᎵᎭ."                          | "a¹lị²gv²hạ²lị³ha."                       | "It's cutting itself out."
        "ᎠᏑᏫᏍᎦ."                            | "a¹su²³hwị³sga."                          | "He's painting it."
        "ᎠᎵᏑᏫᏍᎦ."                          | "al¹su²³hwị³sga."                         | "It's being painted. or It's painting itself."
        "ᎣᏍᏗᏍ ᎠᎵᏑᏫᏍᎦ?"                      | "o⁴sdas al¹su²³hwị³sga?"                  | "Is the painting going well?"
        "ᎦᎧᎯᏯᎠ."                            | "ga²kạ²hi²yạ³ʔa."                         | "He's leaving a living thing behind."
        "ᎦᏁᎯᏯᎠ."                            | "gạ²ne²hi²yạ³ʔa."                         | "He's leaving a container of liquid behind."
        "ᎠᏗᏏᏯᎠ."                            | "a¹di³²si²yạ³ʔa."                         | "He's leaving a long object behind."
        "ᎦᏂᏯᎠ."                             | "gạʔ³ni²yạ³ʔa."                           | "He's leaving a flexible object behind."
        "ᎠᎯᏯᎠ."                             | "a¹hi²yạ³ʔa."                             | "He's leaving it behind. (an object not belonging to any of the shape catagories of (40-43)"
        "ᎦᏅᎦ."                              | "ganh²ga."                                | "A living thing is lying."
        "ᎦᏁᎭ."                              | "gạ²nẹ³ha."                               | "A container of liquid is lying."
        "ᏥᏯ."                               | "ji²³ya."                                 | "A long object is lying."
        "ᎦᎾᎠ."                              | "gạ²nạ³ʔa."                               | "A flexible object is lying."
        "ᎠᎭ."                               | "a¹ha."                                   | "It's lying. (an object not belonging to any of the preceding shape categories)"
    }

    @Unroll
    def "Full Paradigm Forms: #syllabary (#phonetic) -> #translation"() {
        expect:
        syllabary != null && !syllabary.trim().isEmpty()
        phonetic != null && !phonetic.trim().isEmpty()
        translation != null && !translation.trim().isEmpty()
        notes != null

        where:
        syllabary           | phonetic                  | translation                           | notes
        // =========================================================================
        // I-E: Reflexive Paradigm One: "to see oneself" (Set A stem with consonant)
        // =========================================================================
        "ᎦᏓᎪᏩᏘᎭ."         | "gạ²da²gowh¹tị³ha."       | "I see myself."                       | "Set A, 1st person singular reflexive"
        "ᎭᏓᎪᏩᏘᎭ."         | "hạ²da²gowh²tị³ha."       | "You see yourself."                   | "Set A, 2nd person singular reflexive"
        "ᎠᏓᎪᏩᏘᎭ."         | "a¹da²gowh²tị³ha."        | "He sees himself."                    | "Set A, 3rd person singular reflexive"
        "ᎢᎾᏓᎪᏩᏘᎭ."        | "i¹nạ²da²gowh²tị³ha."      | "You and I see ourselves."            | "Set A, 1st person dual inclusive reflexive"
        "ᎢᏓᏓᎪᏩᏘᎭ."        | "i¹dạ²da²gowh²tị³ha."      | "You (pl) and I see ourselves."       | "Set A, 1st person plural inclusive reflexive"
        "ᎣᏍᏓᏓᎪᏩᏘᎭ."       | "o¹sdạ²da²gowh²tị³ha."     | "He and I see ourselves."             | "Set A, 1st person dual exclusive reflexive"
        "ᎣᏣᏓᎪᏩᏘᎭ."        | "o¹jạ²da²gowh²tị³ha."      | "They and I see ourselves."           | "Set A, 1st person plural exclusive reflexive"
        "ᏍᏓᏓᎪᏩᏘᎭ."        | "sdạ²da²gowh²tị³ha."      | "You (dl) see yourselves."            | "Set A, 2nd person dual reflexive"
        "ᎢᏣᏓᎪᏩᏘᎭ."        | "i¹jạ²da²gowh²tị³ha."      | "You (pl) see yourselves."            | "Set A, 2nd person plural reflexive"
        "ᎠᎾᏓᎪᏩᏘᎭ."        | "a¹nạ²da²gowh²tị³ha."      | "They see themselves."                | "Set A, 3rd person plural reflexive"

        // =========================================================================
        // I-E: Reflexive Paradigm Two: "to see oneself," past tense (Set B prefixes)
        // =========================================================================
        "ᎠᏆᏓᎪᎲᎢ."         | "a¹gwạ²da²go²hv²³ʔi."     | "I saw myself."                       | "Set B, 1st person singular past reflexive"
        "ᏣᏓᎪᎲᎢ."          | "jạ²da²go²hv²³ʔi."        | "You saw yourself."                   | "Set B, 2nd person singular past reflexive"
        "ᎤᏓᎪᎲᎢ."          | "u¹da²go²hv²³ʔi."         | "He saw himself."                     | "Set B, 3rd person singular past reflexive"
        "ᎦᎾᏓᎪᎲᎢ."         | "gị²nạ²da²go²hv²³ʔi."     | "You and I saw ourselves."            | "Set B, 1st person dual inclusive past reflexive"
        "ᎢᎦᏓᎪᎲᎢ."         | "i¹gạ²da²go²hv²³ʔi."      | "You (pl) and I saw ourselves."       | "Set B, 1st person plural inclusive past reflexive"
        "ᎣᎩᎾᏓᎪᎲᎢ."        | "o¹gị²nạ²da²go²hv²³ʔi."   | "He and I saw ourselves."             | "Set B, 1st person dual exclusive past reflexive"
        "ᎣᎦᏓᎪᎲᎢ."         | "o¹gạ²da²go²hv²³ʔi."      | "They and I saw ourselves."           | "Set B, 1st person plural exclusive past reflexive"
        "ᏍᏓᏓᎪᎲᎢ."         | "sdạ²da²go²hv²³ʔi."       | "You (dl) saw yourselves."            | "Set B, 2nd person dual past reflexive"
        "ᎢᏣᏓᎪᎲᎢ."         | "i¹jạ²da²go²hv²³ʔi."      | "You (pl) saw yourselves."            | "Set B, 2nd person plural past reflexive"
        "ᎤᎾᏓᎪᎲᎢ."         | "u¹nạ²da²go²hv²³ʔi."      | "They saw themselves."                | "Set B, 3rd person plural past reflexive"

        // =========================================================================
        // I-E: Reflexive Paradigm Three: "to hit oneself" (Vowel-initial stem)
        // =========================================================================
        "ᎦᏓᏛᏂᎭ."         | "gạ²da²dv¹nị³ha."         | "I am hitting myself."                | "Set A, 1st person singular reflexive before vowel stem"
        "ᎭᏓᏛᏂᎭ."         | "hạ²da²dv²hnị³ha."        | "You are hitting yourself."           | "Set A, 2nd person singular reflexive before vowel stem"
        "ᎠᏓᏛᏂᎭ."         | "a¹da²dv²hnị³ha."         | "He's hitting himself."               | "Set A, 3rd person singular reflexive before vowel stem"
        "ᎢᎾᏓᏛᏂᎭ."        | "i¹nạ²da²dv²hnị³ha."      | "You and I are hitting ourselves."    | "Set A, 1st person dual inclusive reflexive"
        "ᎢᏓᏓᏛᏂᎭ."        | "i¹dạ²da²dv²hnị³ha."      | "You (pl) and I are hitting ourselves." | "Set A, 1st person plural inclusive reflexive"
        "ᎣᏍᏓᏓᏛᏂᎭ."       | "o¹sdạ²da²dv²hnị³ha."     | "He and I are hitting ourselves."     | "Set A, 1st person dual exclusive reflexive"
        "ᎣᏣᏓᏛᏂᎭ."        | "o¹jạ²da²dv²hnị³ha."      | "They and I are hitting ourselves."   | "Set A, 1st person plural exclusive reflexive"
        "ᏍᏓᏓᏛᏂᎭ."        | "sdạ²da²dv²hnị³ha."       | "You (dl) are hitting yourselves."    | "Set A, 2nd person dual reflexive"
        "ᎢᏣᏓᏛᏂᎭ."        | "i¹jạ²da²dv²hnị³ha."      | "You (pl) are hitting yourselves."    | "Set A, 2nd person plural reflexive"
        "ᎠᎾᏓᏛᏂᎭ."        | "a¹nạ²da²dv²hnị³ha."      | "They are hitting themselves."        | "Set A, 3rd person plural reflexive"

        // =========================================================================
        // I-E: Reflexive Paradigm Four: "to hit oneself," past tense (Set B)
        // =========================================================================
        "ᎠᏆᏓᏛᏂᎸᎢ."        | "a¹gwạ²da²dv²hnị³lv³ʔi."  | "I hit myself."                       | "Set B, 1st person singular past reflexive before vowel stem"
        "ᏣᏓᏛᏂᎸᎢ."         | "jạ²da²dv²hnị³lv³ʔi."     | "You hit yourself."                   | "Set B, 2nd person singular past reflexive"
        "ᎤᏓᏛᏂᎸᎢ."         | "u¹da²dv²hnị³lv³ʔi."      | "He hit himself."                     | "Set B, 3rd person singular past reflexive"
        "ᎦᎾᏓᏛᏂᎸᎢ."        | "gị²nạ²da²dv²hnị³lv³ʔi."  | "You and I hit ourselves."            | "Set B, 1st person dual inclusive past reflexive"
        "ᎢᎦᏓᏛᏂᎸᎢ."        | "i¹gạ²da²dv²hnị³lv³ʔi."   | "You (pl) and I hit ourselves."       | "Set B, 1st person plural inclusive past reflexive"
        "ᎣᎩᎾᏓᏛᏂᎸᎢ."       | "o¹gị²nạ²da²dv²hnị³lv³ʔi."| "He and I hit ourselves."             | "Set B, 1st person dual exclusive past reflexive"
        "ᎣᎦᏓᏛᏂᎸᎢ."        | "o¹gạ²da²dv²hnị³lv³ʔi."   | "They and I hit ourselves."           | "Set B, 1st person plural exclusive past reflexive"
        "ᏍᏓᏓᏛᏂᎸᎢ."        | "sdạ²da²dv²hnị³lv³ʔi."    | "You (dl) hit yourselves."            | "Set B, 2nd person dual past reflexive"
        "ᎢᏣᏓᏛᏂᎸᎢ."        | "i¹jạ²da²dv²hnị³lv³ʔi."   | "You (pl) hit yourselves."            | "Set B, 2nd person plural past reflexive"
        "ᎤᎾᏓᏛᏂᎸᎢ."        | "u¹nạ²da²dv²hnị³lv³ʔi."   | "They hit themselves."                | "Set B, 3rd person plural past reflexive"

        // =========================================================================
        // I-E: Reflexive Paradigm Five: "to forget oneself" (Present tense Set A)
        // =========================================================================
        "ᎦᏓᏛᎨᏫᏍᎦ."        | "gạ²da²dv¹kew²sga."       | "I am forgetting myself."             | "Set A, 1st person singular reflexive with 'forget'"
        "ᎭᏓᏛᎨᏫᏍᎦ."        | "hạ²da²dv²kew²sga."       | "You are forgetting yourself."        | "Set A, 2nd person singular reflexive with 'forget'"
        "ᎠᏓᏛᎨᏫᏍᎦ."        | "a¹da²dv²kew²sga."        | "He is forgetting himself."           | "Set A, 3rd person singular reflexive with 'forget'"
        "ᎢᎾᏗᏛᎨᏫᏍᎦ."       | "i¹nạ²da²dv²kew²sga."     | "You and I are forgetting ourselves." | "Set A, 1st person dual inclusive reflexive with 'forget'"
        "ᎢᏓᏓᏛᎨᏫᏍᎦ."       | "i¹dạ²da²dv²kew²sga."     | "You (pl) and I are forgetting ourselves." | "Set A, 1st person plural inclusive reflexive with 'forget'"
        "ᏍᏓᏓᏛᎨᏫᏍᎦ."       | "sdạ²da²dv²kew²sga."      | "You (dl) are forgetting youselves."  | "Set A, 2nd person dual reflexive with 'forget'"
        "ᎢᏣᏓᏛᎨᏫᏍᎦ."       | "i¹jạ²da²dv²kew²sga."     | "You (pl) are forgetting yourselves." | "Set A, 2nd person plural reflexive with 'forget'"
        "ᎠᎾᏓᏛᎨᏫᏍᎦ."       | "a¹nạ²da²dv²kew²sga."     | "They are forgetting themselves."     | "Set A, 3rd person plural reflexive with 'forget'"

        // =========================================================================
        // I-E: Reflexive Paradigm Six: "to forget oneself," past tense (Set B)
        // =========================================================================
        "ᎠᏆᏓᏛᎨᏫᏒᎢ."       | "a¹gwạ²da²dv²kew²sv²³ʔi." | "I forgot myself."                    | "Set B, 1st person singular past reflexive with 'forget'"
        "ᏣᏓᏛᎨᏫᏒᎢ."        | "jạ²da²dv²kew²sv²³ʔi."    | "You forgot yourself."                | "Set B, 2nd person singular past reflexive with 'forget'"
        "ᎤᏓᏛᎨᏫᏒᎢ."        | "u¹da²dv²kew²sv²³ʔi."     | "He forgot himself."                  | "Set B, 3rd person singular past reflexive with 'forget'"
        "ᎩᎾᏓᏛᎨᏫᏒᎢ."       | "gị²nạ²da²dv²kew²sv²³ʔi." | "You and I forgot ourselves."         | "Set B, 1st person dual inclusive past reflexive with 'forget'"
        "ᎢᎦᏓᏛᎨᏫᏒᎢ."       | "i¹gạ²da²dv²kew²sv²³ʔi."  | "You (pl) and I forgot ourselves."    | "Set B, 1st person plural inclusive past reflexive with 'forget'"
        "ᏍᏓᏓᏛᎨᏫᏒᎢ."       | "sdạ²da²dv²kew²sv²³ʔi."   | "You (dl) forgot yourselves."         | "Set B, 2nd person dual past reflexive with 'forget'"
        "ᎢᏣᏓᏛᎨᏫᏒᎢ."       | "i¹jạ²da²dv²kew²sv²³ʔi."  | "You (pl) forgot yourselves."         | "Set B, 2nd person plural past reflexive with 'forget'"
        "ᎤᎾᏓᏛᎨᏒᎢ."        | "u¹nạ²da²dv²kew²sv²³ʔi."  | "They forgot themselves."             | "Set B, 3rd person plural past reflexive with 'forget'"

        // =========================================================================
        // I-E: Passive Paradigm Five: "to be seen" (Unspecified actor)
        // =========================================================================
        "ᎥᎩᎪᏩᏘᎭ."         | "v¹gị²gowh²tị³ha."        | "I am being seen."                    | "Passive, 1st person singular before consonant"
        "ᎡᏣᎪᏩᏘᎭ."         | "e¹jạ²gowh²tị³ha."        | "You are being seen."                 | "Passive, 2nd person singular before consonant"
        "ᎠᏥᎪᏩᏘᎭ."         | "a¹jị²gowh¹tị³ha."        | "He's being seen."                    | "Passive, 3rd person singular before consonant"
        "ᎡᎩᏂᏆᏩᏘᎭ."        | "e¹gị²ni²gowh¹tị³ha."     | "You and I are being seen."           | "Passive, 1st person dual inclusive before consonant"
        "ᎡᎩᎪᏩᏘᎭ."         | "e¹gi²gowh¹tị³ha."        | "You (pl) and I are being seen."      | "Passive, 1st person plural inclusive before consonant"
        "ᎡᏍᏗᎪᏩᏘᎭ."        | "e¹sdi²gowh¹tị³ha."       | "You (dl) are being seen."            | "Passive, 2nd person dual before consonant"
        "ᎡᏥᎪᏩᏘᎭ."         | "e¹ji²gowh¹tị³ha."        | "You (pl) are being seen."            | "Passive, 2nd person plural before consonant"
        "ᎨᏥᎪᏩᏘᎭ."         | "ge²jị²gowh¹tị³ha."       | "They are being seen."                | "Passive, 3rd person plural before consonant"

        // =========================================================================
        // I-E: Passive Paradigm Six: "to be hit" (Unspecified actor)
        // =========================================================================
        "ᎥᏋᏂᎭ."          | "v¹gwv²hnị³ha."           | "I am being hit."                     | "Passive, 1st person singular before vowel"
        "ᎡᏨᏂᎭ."          | "e¹jv²hnị³ha."            | "You are being hit."                  | "Passive, 2nd person singular before vowel"
        "ᎠᎬᏂᎭ."          | "a¹gv¹nị³ha."             | "He's being hit."                     | "Passive, 3rd person singular before vowel"
        "ᎡᎩᏅᏂᎭ."         | "e¹gị²nv¹nị³ha."          | "You and I are being hit."            | "Passive, 1st person dual inclusive before vowel"
        "ᎡᎬᏂᎭ."          | "e¹gv¹nị³ha."             | "You (pl) and I are being hit."       | "Passive, 1st person plural inclusive before vowel"
        "ᎡᏍᏛᏂᎭ."         | "e¹sdv¹nị³ha."            | "You (dl) are being hit."             | "Passive, 2nd person dual before vowel"
        "ᎡᏨᏂᎭ."          | "e¹jv¹nị³ha."             | "You (pl) are being hit."             | "Passive, 2nd person plural before vowel"
        "ᎨᎬᏂᎭ."          | "ge²gv¹nị³ha."            | "They are being hit."                 | "Passive, 3rd person plural before vowel"
    }
}