package net.cherokeedictionary.conjugation

import net.cherokeedictionary.conjugation.ConjugateBase

/**
 * Created by torr on 8/21/2015.
 */
class ConjugatePresentTense extends ConjugateBase {
    //finished and good
    void testWantconjugationTransitivePresent() {
        def partofspeechc = "v.t."
        def verbTense = "PRESENT"

        assertTrue "ᎬᏯᏚᎵᎭ" == conjStr("SG1", "SG2", heWantsIt, verbTense, partofspeechc)

        //fix this -- timo 3Nov26
//        println conjStr("SG1", "SG3AN", heWantsIt, verbTense, partofspeechc)
//        assertTrue "ᏥᏯᏚᎵᎭ" == conjStr("SG1", "SG3AN", heWantsIt, verbTense, partofspeechc)

        assertTrue "ᎠᏆᏚᎵᎭ" == conjStr("SG1", "SG3IN", heWantsIt, verbTense, partofspeechc)
        assertTrue "", "ᎠᏆᏚᎵᎭ" == conjStr("SG1", "SG3IN", heWantsIt, verbTense, partofspeechc)

        assertTrue "", "ᏣᏚᎵᎭ" == conjStr("SG2", "SG3IN", heWantsIt, verbTense, partofspeechc)
        assertTrue "", "ᎤᏚᎵᎭ" == conjStr("SG3", "SG3IN", heWantsIt, verbTense, partofspeechc)
        assertTrue "", "ᎩᎾᏚᎵᎭ" == conjStr("DL1INCL", "SG3IN", heWantsIt, verbTense, partofspeechc)
        assertTrue "", "ᎣᎩᎾᏚᎵᎭ" == conjStr("DL1EXCL", "SG3IN", heWantsIt, verbTense, partofspeechc)
        assertTrue "", "ᏍᏓᏚᎵᎭ" == conjStr("DL2", "SG3IN", heWantsIt, verbTense, partofspeechc)
        assertTrue "", "ᎢᎦᏚᎵᎭ" == conjStr("PL1INCL", "SG3IN", heWantsIt, verbTense, partofspeechc)
        assertTrue "", "ᎣᎦᏚᎵᎭ" == conjStr("PL1EXCL", "SG3IN", heWantsIt, verbTense, partofspeechc)
        assertTrue "", "ᎢᏣᏚᎵᎭ" == conjStr("PL2", "SG3IN", heWantsIt, verbTense, partofspeechc)
        assertTrue "", "ᎤᎾᏚᎵᎭ" == conjStr("PL3", "SG3IN", heWantsIt, verbTense, partofspeechc)

        assertTrue "", "ᏓᏆᏚᎵᎭ" == conjStr("SG1", "PL3IN", heWantsIt, verbTense, partofspeechc)
        assertTrue "", "ᏕᏣᏚᎵᎭ" == conjStr("SG2", "PL3IN", heWantsIt, verbTense, partofspeechc)
//	assertTrue "", "ᏚᏣᏚᎵᎭ" == conjStr("SG2", "PL3IN", heWantsIt, verbTense, partofspeechc)

        assertTrue "", "ᏚᏚᎵᎭ" == conjStr("SG3", "PL3IN", heWantsIt, verbTense, partofspeechc)
        assertTrue "", "ᏕᎩᎾᏚᎵᎭ" == conjStr("DL1INCL", "PL3IN", heWantsIt, verbTense, partofspeechc)
	//assertTrue "", "ᏚᎩᎾᏚᎵᎭ" == conjStr("DL1INCL", "PL3IN", heWantsIt, verbTense, partofspeechc)

        assertTrue "", "ᏙᎩᎾᏚᎵᎭ" == conjStr("DL1EXCL", "PL3IN", heWantsIt, verbTense, partofspeechc)

        assertTrue "", "ᏕᏍᏓᏚᎵᎭ" == conjStr("DL2", "PL3IN", heWantsIt, verbTense, partofspeechc)
        assertTrue "", "ᏕᎦᏚᎵᎭ" == conjStr("PL1INCL", "PL3IN", heWantsIt, verbTense, partofspeechc)
//	assertTrue "", "ᏚᎦᏚᎵᎭ" == conjStr("PL1INCL", "PL3IN", heWantsIt, verbTense, partofspeechc)
        assertTrue "", "ᏙᎦᏚᎵᎭ" == conjStr("PL1EXCL", "PL3IN", heWantsIt, verbTense, partofspeechc)
        assertTrue "", "ᏕᏣᏚᎵᎭ" == conjStr("PL2", "PL3IN", heWantsIt, verbTense, partofspeechc)
        assertTrue "", "ᏚᎾᏚᎵᎭ" == conjStr("PL3", "PL3IN", heWantsIt, verbTense, partofspeechc)
    }

    //finished and good
    /**
     * Structured Approach - Durbin Feeling (Cherokee Verb OCR pdf) pp 13
     */
    public void testHearconjugationTransitivePresent() {
        def partofspeechc = "v.t."
        def verbTense = "PRESENT"

        assertTrue "", "ᏥᏯᏛᎩᎠ" == conjStr("SG1", "SG3AN", tohear, verbTense, partofspeechc)//jiyadvgia
        assertTrue "", "ᎯᏯᏛᎩᎠ" == conjStr("SG2", "SG3AN", tohear, verbTense, partofspeechc)//hiyadvgia
        assertTrue "", "ᎠᏛᎩᎠ" == conjStr("SG3", "SG3AN", tohear, verbTense, partofspeechc)//advgia
        assertTrue "", "ᎡᎾᏛᎩᎠ" == conjStr("DL1INCL", "SG3AN", tohear, verbTense, partofspeechc)//enadvgia
        assertTrue "", "ᎣᏍᏓᏛᎩᎠ" == conjStr("DL1EXCL", "SG3AN", tohear, verbTense, partofspeechc)//osdadvgia
        assertTrue "", "ᎡᏍᏓᏛᎩᎠ" == conjStr("DL2", "SG3AN", tohear, verbTense, partofspeechc)//esdadvgia
        assertTrue "", "ᎡᏓᏛᎩᎠ" == conjStr("PL1INCL", "SG3AN", tohear, verbTense, partofspeechc)//edadvgia
        assertTrue "", "ᎣᏣᏛᎩᎠ" == conjStr("PL1EXCL", "SG3AN", tohear, verbTense, partofspeechc)//ojadvgia
        assertTrue "", "ᎡᏣᏛᎩᎠ" == conjStr("PL2", "SG3AN", tohear, verbTense, partofspeechc)//ejadvgia
        assertTrue "", "ᎠᎾᏛᎩᎠ" == conjStr("PL3", "SG3AN", tohear, verbTense, partofspeechc)//anadvgia

        assertTrue "", "ᎦᏥᏯᏛᎩᎠ" == conjStr("SG1", "PL3AN", tohear, verbTense, partofspeechc)//gajiyadvgia
        assertTrue "", "ᎦᎯᏯᏛᎩᎠ" == conjStr("SG2", "PL3AN", tohear, verbTense, partofspeechc)//gahiyadvgia
        assertTrue "", "ᏕᎦᏛᎩᎠ" == conjStr("SG3", "PL3AN", tohear, verbTense, partofspeechc)//dadvgia
        assertTrue "", "ᎨᎾᏛᎩᎠ" == conjStr("DL1INCL", "PL3AN", tohear, verbTense, partofspeechc)//genadvgia
        assertTrue "", "ᎪᏍᏓᏛᎩᎠ" == conjStr("DL1EXCL", "PL3AN", tohear, verbTense, partofspeechc)//gosdadvgia
        assertTrue "", "ᎨᏍᏓᏛᎩᎠ" == conjStr("DL2", "PL3AN", tohear, verbTense, partofspeechc)//gedsadvgia
        assertTrue "", "ᎨᏓᏛᎩᎠ" == conjStr("PL1INCL", "PL3AN", tohear, verbTense, partofspeechc)//gedadvgia
        assertTrue "", "ᎪᏣᏛᎩᎠ" == conjStr("PL1EXCL", "PL3AN", tohear, verbTense, partofspeechc)//gojatvgia

        // fix -- timo 3Nov26
//        ᎨᏣᏛᎩᎠ
//        ᎠᎾᏛᎩᎠ
//        assertTrue "", "ᎨᏣᏛᎩᎠ" == conjStr("PL2", "PL3AN", tohear, verbTense, partofspeechc)//gejadvgia
//        assertTrue "", "ᏓᎾᏛᎩᎠ" == conjStr("PL3", "PL3AN", tohear, verbTense, partofspeechc)//danadvgia
    }

    //finished and good
    public void testHiwonihaconjugationIntransitivePresent() {
        def partofspeechc = "v.i."
        def verbTense = "PRESENT"

        assertTrue "", "ᏥᏬᏂᎭ" == conjStr("SG1", "", hiwoniha, verbTense, partofspeechc)
        assertTrue "", "ᎯᏬᏂᎭ" == conjStr("SG2", "", hiwoniha, verbTense, partofspeechc)
        assertTrue "", "ᎦᏬᏂᎭ" == conjStr("SG3", "", hiwoniha, verbTense, partofspeechc)
        assertTrue "", "ᎢᏂᏬᏂᎭ" == conjStr("DL1INCL", "", hiwoniha, verbTense, partofspeechc)
        assertTrue "", "ᎣᏍᏗᏬᏂᎭ" == conjStr("DL1EXCL", "", hiwoniha, verbTense, partofspeechc)
        assertTrue "", "ᏍᏗᏬᏂᎭ" == conjStr("DL2", "", hiwoniha, verbTense, partofspeechc)
        assertTrue "", "ᎢᏗᏬᏂᎭ" == conjStr("PL1INCL", "", hiwoniha, verbTense, partofspeechc)
        assertTrue "", "ᎣᏥᏬᏂᎭ" == conjStr("PL1EXCL", "", hiwoniha, verbTense, partofspeechc)
        assertTrue "", "ᎢᏥᏬᏂᎭ" == conjStr("PL2", "", hiwoniha, verbTense, partofspeechc)
        assertTrue "", "ᎠᏂᏬᏂᎭ" == conjStr("PL3", "", hiwoniha, verbTense, partofspeechc)
    }

    //finished and good
    public void testAsuhvsgaconjugationIntransitivePresent() {
        def partofspeechc = "v.i."
        def verbTense = "PRESENT"

        assertTrue "", "ᎦᏑᎲᏍᎦ" == conjStr("SG1", "", tofish, verbTense, partofspeechc)
        assertTrue "", "ᎭᏑᎲᏍᎦ" == conjStr("SG2", "", tofish, verbTense, partofspeechc)
        //todo: need to find some way to make this happen by passing in only the verb root - there has got to be a pattern
        assertTrue "", "ᎠᏑᎲᏍᎦ" == tofish.present3rd.syllabary;//conjStr("SG3", "", tofish, verbTense, partofspeechc)
        assertTrue "", "ᎢᎾᏑᎲᏍᎦ" == conjStr("DL1INCL", "", tofish, verbTense, partofspeechc)
        assertTrue "", "ᎣᏍᏓᏑᎲᏍᎦ" == conjStr("DL1EXCL", "", tofish, verbTense, partofspeechc)
        assertTrue "", "ᏍᏓᏑᎲᏍᎦ" == conjStr("DL2", "", tofish, verbTense, partofspeechc)
        assertTrue "", "ᎢᏓᏑᎲᏍᎦ" == conjStr("PL1INCL", "", tofish, verbTense, partofspeechc)
        assertTrue "", "ᎣᏣᏑᎲᏍᎦ" == conjStr("PL1EXCL", "", tofish, verbTense, partofspeechc)
        assertTrue "", "ᎢᏣᏑᎲᏍᎦ" == conjStr("PL2", "", tofish, verbTense, partofspeechc)
        assertTrue "", "ᎠᎾᏑᎲᏍᎦ" == conjStr("PL3", "", tofish, verbTense, partofspeechc)
    }

    public void testHavePresent() {
        def partofspeechc = "v.t."
        def verbTense = "PRESENT"

        assertTrue "", "ᎠᎩᎭ" == conjStr("SG1", "SG3IN", tohave, verbTense, partofspeechc)
        assertTrue "", "ᏣᎭ" == conjStr("SG2", "SG3IN", tohave, verbTense, partofspeechc)
        assertTrue "", "ᎤᎭ" == conjStr("SG3", "SG3IN", tohave, verbTense, partofspeechc)
        assertTrue "", "ᎩᏂᎭ" == conjStr("DL1INCL", "SG3IN", tohave, verbTense, partofspeechc)
        assertTrue "", "ᎣᎩᏂᎭ" == conjStr("DL1EXCL", "SG3IN", tohave, verbTense, partofspeechc)
        assertTrue "", "ᏍᏗᎭ" == conjStr("DL2", "SG3IN", tohave, verbTense, partofspeechc)
        assertTrue "", "ᎢᎩᎭ" == conjStr("PL1INCL", "SG3IN", tohave, verbTense, partofspeechc)
        assertTrue "", "ᎣᎩᎭ" == conjStr("PL1EXCL", "SG3IN", tohave, verbTense, partofspeechc)
        assertTrue "", "ᎢᏥᎭ" == conjStr("PL2", "SG3IN", tohave, verbTense, partofspeechc)
        assertTrue "", "ᎤᏂᎭ" == conjStr("PL3", "SG3IN", tohave, verbTense, partofspeechc)
    }

    public void testGreetPresent() {
        def partofspeechc = "v.t."
        def verbTense = "PRESENT"

        assertTrue "", "ᏥᏲᎵᎭ" == conjStr("SG1", "SG3AN", togreet, verbTense, partofspeechc)
        assertTrue "", "ᎯᏲᎵᎭ" == conjStr("SG2", "SG3AN", togreet, verbTense, partofspeechc)
        assertTrue "", "ᎠᏲᎵᎭ" == conjStr("SG3", "SG3AN", togreet, verbTense, partofspeechc)
        assertTrue "", "ᎦᏲᎵᎭ" == conjStr("SG3", "SG3IN", togreet, verbTense, partofspeechc)
        assertTrue "", "ᎡᏂᏲᎵᎭ" == conjStr("DL1INCL", "SG3AN", togreet, verbTense, partofspeechc)
        assertTrue "", "ᎣᏍᏗᏲᎵᎭ" == conjStr("DL1EXCL", "SG3AN", togreet, verbTense, partofspeechc)
        assertTrue "", "ᎡᏍᏗᏲᎵᎭ" == conjStr("DL2", "SG3AN", togreet, verbTense, partofspeechc)
        assertTrue "", "ᎡᏗᏲᎵᎭ" == conjStr("PL1INCL", "SG3AN", togreet, verbTense, partofspeechc)
        assertTrue "", "ᎣᏥᏲᎵᎭ" == conjStr("PL1EXCL", "SG3AN", togreet, verbTense, partofspeechc)
        assertTrue "", "ᎡᏥᏲᎵᎭ" == conjStr("PL2", "SG3AN", togreet, verbTense, partofspeechc)
        assertTrue "", "ᎠᏂᏲᎵᎭ" == conjStr("PL3", "SG3AN", togreet, verbTense, partofspeechc)
    }

    //not good
    public void testKillPresent() {
        def partofspeechc = "v.t."
        def verbTense = "PRESENT"

//        println conjStr("SG1", "SG3AN", tokill, verbTense, partofspeechc)
//        println conjStr("SG2", "SG3AN", tokill, verbTense, partofspeechc)
//        println conjStr("SG3", "SG3AN", tokill, verbTense, partofspeechc)
//        println conjStr("DL1INCL", "SG3AN", tokill, verbTense, partofspeechc)
//        println conjStr("DL1EXCL", "SG3AN", tokill, verbTense, partofspeechc)
//        println conjStr("DL2", "SG3AN", tokill, verbTense, partofspeechc)
//        println conjStr("PL1INCL", "SG3AN", tokill, verbTense, partofspeechc)
//        println conjStr("PL1EXCL", "SG3AN", tokill, verbTense, partofspeechc)
//        println conjStr("PL2", "SG3AN", tokill, verbTense, partofspeechc)
//        println conjStr("PL3", "SG3AN", tokill, verbTense, partofspeechc)
//        println conjStr("SG1", "PL3AN", tokill, verbTense, partofspeechc)
//        println conjStr("SG2", "PL3AN", tokill, verbTense, partofspeechc)
//        println conjStr("SG3", "PL3AN", tokill, verbTense, partofspeechc)
//        println conjStr("DL1INCL", "PL3AN", tokill, verbTense, partofspeechc)
//        println conjStr("DL1EXCL", "PL3AN", tokill, verbTense, partofspeechc)
//        println conjStr("DL2", "PL3AN", tokill, verbTense, partofspeechc)
//        println conjStr("PL1INCL", "PL3AN", tokill, verbTense, partofspeechc)
//        println conjStr("PL1EXCL", "PL3AN", tokill, verbTense, partofspeechc)
//        println conjStr("PL2", "PL3AN", tokill, verbTense, partofspeechc)
//        println conjStr("PL3", "PL3AN", tokill, verbTense, partofspeechc)

//        sn3 and pl3 - pl3in & pl3an should be the same but they aren't. They have different /h/ /?/ substituions

        assertTrue "", "ᏥᎢᎭ" == conjStr("SG1", "SG3AN", tokill, verbTense, partofspeechc)
        assertTrue "", "ᎯᎢᎭ" == conjStr("SG2", "SG3AN", tokill, verbTense, partofspeechc)
        assertTrue "", "ᎠᎯᎭ" == conjStr("SG3", "SG3AN", tokill, verbTense, partofspeechc)
        assertTrue "", "ᎡᏂᎢᎭ" == conjStr("DL1INCL", "SG3AN", tokill, verbTense, partofspeechc)
        assertTrue "", "ᎣᏍᏗᎢᎭ" == conjStr("DL1EXCL", "SG3AN", tokill, verbTense, partofspeechc)
        assertTrue "", "ᎡᏍᏗᎢᎭ" == conjStr("DL2", "SG3AN", tokill, verbTense, partofspeechc)
        assertTrue "", "ᎡᏗᎢᎭ" == conjStr("PL1INCL", "SG3AN", tokill, verbTense, partofspeechc)
        assertTrue "", "ᎣᏥᎢᎭ" == conjStr("PL1EXCL", "SG3AN", tokill, verbTense, partofspeechc)
        assertTrue "", "ᎡᏥᎢᎭ" == conjStr("PL2", "SG3AN", tokill, verbTense, partofspeechc)
        assertTrue "", "ᎠᏂᎯᎠ" == conjStr("PL3", "SG3AN", tokill, verbTense, partofspeechc)

        assertTrue "", "ᎦᏥᎢᎭ" == conjStr("SG1", "PL3AN", tokill, verbTense, partofspeechc)
        assertTrue "", "ᎦᎯᎢᎭ" == conjStr("SG2", "PL3AN", tokill, verbTense, partofspeechc)

        //todo: if any are incorrect - it would be this one - the book says: ᏓᎪᎯᎠ -- pp15 Structured Approach
//        sn3 and pl3 - pl3in & pl3an should be the same but they aren't. They have different /h/ /?/ substituions
        assertTrue "", "ᏕᎩᎯᎠ" == conjStr("SG3", "PL3AN", tokill, verbTense, partofspeechc)
        assertTrue "", "ᏕᎩᎯᎠ" == conjStr("SG3", "PL3IN", tokill, verbTense, partofspeechc)

        assertTrue "", "ᎨᏂᎢᎭ" == conjStr("DL1INCL", "PL3AN", tokill, verbTense, partofspeechc)
        assertTrue "", "ᎪᏍᏗᎢᎭ" == conjStr("DL1EXCL", "PL3AN", tokill, verbTense, partofspeechc)
        assertTrue "", "ᎨᏍᏗᎢᎭ" == conjStr("DL2", "PL3AN", tokill, verbTense, partofspeechc)
        assertTrue "", "ᎨᏗᎢᎭ" == conjStr("PL1INCL", "PL3AN", tokill, verbTense, partofspeechc)
        assertTrue "", "ᎪᏥᎢᎭ" == conjStr("PL1EXCL", "PL3AN", tokill, verbTense, partofspeechc)
        assertTrue "", "ᎨᏥᎢᎭ" == conjStr("PL2", "PL3AN", tokill, verbTense, partofspeechc)

        //fix -- timo 3Nov26
//        assertTrue "", "ᏓᏂᎯᎠ" == conjStr("PL3", "PL3AN", tokill, verbTense, partofspeechc)
//        assertTrue "", "ᏓᏂᎯᎠ" == conjStr("PL3", "PL3IN", tokill, verbTense, partofspeechc)
/*	// Structured Approach - Durbin Feeling (Cherokee Verb OCR pdf) pp 13-15
        // Note: Programmatically generated forms retain the stem's initial 'h' (-hiha) for SG1/SG2 on PL3AN objects (gajihiha / gahihiha)
        assertTrue "", "ᎦᏥᎯᎭ" == conjStr("SG1", "PL3AN", tokill, verbTense, partofspeechc)
        assertTrue "", "ᎦᎯᎯᎭ" == conjStr("SG2", "PL3AN", tokill, verbTense, partofspeechc)

        //todo: if any are incorrect - it would be this one - the book says: ᏓᎪᎯᎠ -- pp15 Structured Approach
//        sn3 and pl3 - pl3in & pl3an should be the same but they aren't. They have different /h/ /?/ substituions
//        assertTrue "", "ᏓᎪᎯᎠ" == conjStr("SG3", "PL3IN", tokill, verbTense, partofspeechc)
//        assertTrue "", "ᏕᎩᎯᎠ" == conjStr("SG3", "PL3IN", tokill, verbTense, partofspeechc)

        assertTrue "", "ᎨᏂᎯᎭ" == conjStr("DL1INCL", "PL3AN", tokill, verbTense, partofspeechc)
        assertTrue "", "ᎪᏍᏗᎯᎭ" == conjStr("DL1EXCL", "PL3AN", tokill, verbTense, partofspeechc)
        assertTrue "", "ᎨᏍᏗᎯᎭ" == conjStr("DL2", "PL3AN", tokill, verbTense, partofspeechc)
        assertTrue "", "ᎨᏗᎯᎭ" == conjStr("PL1INCL", "PL3AN", tokill, verbTense, partofspeechc)
        assertTrue "", "ᎪᏥᎯᎭ" == conjStr("PL1EXCL", "PL3AN", tokill, verbTense, partofspeechc)
        assertTrue "", "ᎨᏥᎯᎭ" == conjStr("PL2", "PL3AN", tokill, verbTense, partofspeechc)

        println conjStr("PL3", "PL3AN", tokill, verbTense, partofspeechc)
        println conjStr("PL3", "PL3IN", tokill, verbTense, partofspeechc)*/
    }
}