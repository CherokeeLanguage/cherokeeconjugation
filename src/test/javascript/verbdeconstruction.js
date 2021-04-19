var verbTense;
const Tense = {
    PRESENT: "PRESENT",
    FUTURE_IMPERATIVE: "FUTURE_IMPERATIVE",
    INFINITIVE: "INFINITIVE",
    HABITUAL: "HABITUAL",
    PLUPERFECT: "PLUPERFECT",
    FUTURE_PROGRESSIVE: "FUTURE_PROGRESSIVE",
    REPORTATIVE: "REPORTATIVE",
    PAST: "PAST",
    FUTURE: "FUTURE",
    PRE_INCIPIENT: "PRE_INCIPIENT"
}

const VerbTense = new Map();
VerbTense.set("esdi" , Tense.FUTURE_PROGRESSIVE);
VerbTense.set("idi" , Tense.PRE_INCIPIENT);
VerbTense.set("vi" , Tense.FUTURE_IMPERATIVE);
// VerbTense.set("a" , Tense.PRESENT);
VerbTense.set("di" , Tense.INFINITIVE);
VerbTense.set("oi" , Tense.HABITUAL);
VerbTense.set("oi" , Tense.PLUPERFECT);
// VerbTense.set("esdi" , Tense.FUTURE_PROGRESSIVE);
VerbTense.set("ei" , Tense.REPORTATIVE);
VerbTense.set("vi" , Tense.PAST);
VerbTense.set("i" , Tense.FUTURE);
VerbTense.set("a" , Tense.PRESENT);
// VerbTense.set("idi" , Tense.PRE_INCIPIENT);

const FinalEndings = new Map();
FinalEndings.set("dv", "focus");
FinalEndings.set("dina", "concessiveImperative");
FinalEndings.set("isi", "orelse");
FinalEndings.set("hv", "but");
FinalEndings.set("na", "andWhatIf");
FinalEndings.set("ke", "orInterrogative");
FinalEndings.set("ju", "interrogative");
FinalEndings.set("sgo", "interrogative2");
FinalEndings.set("gwu", "onlyJustStill");

const NonFinalEndings = new Map();
NonFinalEndings.set("g", "progressive");
NonFinalEndings.set("ihl", "comeTo");
NonFinalEndings.set("e", "atIntervals");
NonFinalEndings.set("idol", "around");
NonFinalEndings.set("el", "dativeBenefactive");
NonFinalEndings.set("ohn", "completive");
NonFinalEndings.set("dohdan", "unintentional");
NonFinalEndings.set("dan", "instrumentalCausative");
NonFinalEndings.set("ilo", "repetitive");
NonFinalEndings.set("is", "duplicative/become");
NonFinalEndings.set("y", "reversive");
NonFinalEndings.set("e", "reversive");
NonFinalEndings.set("gi", "reversive");

verbTense = Tense.PRESENT;

// phonetic = value of item in explanation
// syllabary = syllabic representation if available
// type = suffix, prefix, root, non-final suffix, final suffix, initial prefix, proniminal prefix, reflexive prefix
// function = pronoun, like focus,
// meaning = focus etc
function createExplanation(phonetic, syllabary, type, purpose, meaning, name) {
    var explanation = {
        phonetic: phonetic,
        syllabary: syllabary,
        meaning: meaning,
        purpose: purpose,
        name: name
        // morpheme_romanized: "d",
        // morpheme_syllabary: "XX",
        // morpheme_name: "prefix",
        // morpheme_function: "plurality",
        // morpheme_meaning: "many",
    };

    return explanation;
}

function Prefix(preVowel, preConsonant, other) {
    return {
        preVowel: preVowel,
        preConsonant: preConsonant,
        other: other
    }
}

var PronominalPrefixes = new Map();
PronominalPrefixes.set("SG1SG2", Prefix('Ꭼy', 'Ꭼ', ''));
PronominalPrefixes.set("SG1SG3AN", Prefix('Ꮵy', 'Ꮵ', ''));
PronominalPrefixes.set("SG1SG3IN", Prefix('g', 'Ꮵ', ''));
PronominalPrefixes.set("SG1DL2", Prefix('ᏍᏛy', 'ᏍᏛ', ''));
PronominalPrefixes.set("SG1PL2", Prefix('ᎢᏨy', 'ᎢᏨ', ''));
PronominalPrefixes.set("SG1PL3AN", Prefix('ᎦᏥy', 'ᎦᏥ', ''));
PronominalPrefixes.set("SG1PL3IN", Prefix('Ꮥg', 'ᏕᏥ', ''));

PronominalPrefixes.set("SG2SG1", Prefix('Ꮝgw', 'ᏍᎩ', ''));
PronominalPrefixes.set("SG2SG3AN", Prefix('Ꭿy', 'Ꭿ', ''));
PronominalPrefixes.set("SG2SG3IN", Prefix('h', 'Ꭿ', ''));
PronominalPrefixes.set("SG2DL1INCL", Prefix('ᏍᎩn', 'ᏍᎩᏂ', ''));
PronominalPrefixes.set("SG2PL1EXCL", Prefix('ᎢᏍᎩy', 'ᎢᏍᎩ', ''));
PronominalPrefixes.set("SG2PL3AN", Prefix('ᎦᎯy', 'ᎦᎯ', ''));
PronominalPrefixes.set("SG2PL3IN", Prefix('Ꮥh', 'ᏕᎯ', ''));

PronominalPrefixes.set("SG3SG1", Prefix('Ꭰgw', 'ᎠᎩ', ''));
PronominalPrefixes.set("SG3SG2", Prefix('ts', 'Ꮵ', ''));
PronominalPrefixes.set("SG3SG3AN", Prefix('g', 'Ꭶ', 'a'));
PronominalPrefixes.set("SG3SG3IN", Prefix('g', 'Ꭶ', 'a'));
PronominalPrefixes.set("SG3DL1INCL", Prefix('Ꭹn', 'ᎩᏂ', ''));
PronominalPrefixes.set("SG3DL1EXCL", Prefix('ᎣᎩn', 'ᎣᎩᏂ', ''));
PronominalPrefixes.set("SG3PL1INCL", Prefix('Ꭲg', 'ᎢᎩ', ''));
PronominalPrefixes.set("SG3PL1EXCL", Prefix('Ꭳg', 'ᎣᎩ', ''));
PronominalPrefixes.set("SG3DL2", Prefix('Ꮝd', 'ᏍᏗ', ''));
PronominalPrefixes.set("SG3PL2", Prefix('Ꭲts', 'ᎢᏥ', ''));
PronominalPrefixes.set("SG3PL3AN", Prefix('Ꮥg', 'ᏕᎩ', ''));
PronominalPrefixes.set("SG3PL3IN", Prefix('Ꮥg', 'ᏕᎩ', ''));

PronominalPrefixes.set("DL1INCLSG3AN", Prefix('Ꭱn', 'ᎡᏂ', ''));
PronominalPrefixes.set("DL1INCLSG3IN", Prefix('Ꭲn', 'ᎢᏂ', ''));
PronominalPrefixes.set("DL1INCLPL3AN", Prefix('Ꭸn', 'ᎨᏂ', ''));
PronominalPrefixes.set("DL1INCLPL3IN", Prefix('Ꮥn', 'ᏕᏂ', ''));

PronominalPrefixes.set("DL1EXCLSG2", Prefix('ᏍᏛy', 'ᏍᏛ', ''));
PronominalPrefixes.set("DL1EXCLSG3AN", Prefix('ᎣᏍd', 'ᎣᏍᏗ', ''));
PronominalPrefixes.set("DL1EXCLSG3IN", Prefix('ᎣᏍd', 'ᎣᏍᏗ', ''));
PronominalPrefixes.set("DL1EXCLDL2", Prefix('ᏍᏛy', 'ᏍᏛ', ''));
PronominalPrefixes.set("DL1EXCLPL2", Prefix('Ꭲts', 'ᎢᏥ', ''));
PronominalPrefixes.set("DL1EXCLPL3AN", Prefix('ᎪᏍd', 'ᎪᏍᏗ', ''));
PronominalPrefixes.set("DL1EXCLPL3IN", Prefix('ᏙᏍd', 'ᏙᏍᏗ', ''));

PronominalPrefixes.set("PL1INCLSG3AN", Prefix('Ꭱd', 'ᎡᏗ', ''));
PronominalPrefixes.set("PL1INCLSG3IN", Prefix('Ꭲd', 'ᎢᏗ', ''));
PronominalPrefixes.set("PL1INCLPL3AN", Prefix('Ꭸd', 'ᎨᏗ', ''));
PronominalPrefixes.set("PL1INCLPL3IN", Prefix('Ꮥd', 'ᏕᏗ', ''));

PronominalPrefixes.set("PL1EXCLSG2", Prefix('ᎢᏨy', 'ᎢᏨ', ''));
PronominalPrefixes.set("PL1EXCLSG3AN", Prefix('Ꭳts', 'ᎣᏥ', ''));
PronominalPrefixes.set("PL1EXCLSG3IN", Prefix('Ꭳts', 'ᎣᏥ', ''));
PronominalPrefixes.set("PL1EXCLPL3AN", Prefix('Ꭺts', 'ᎪᏥ', ''));
PronominalPrefixes.set("PL1EXCLPL3IN", Prefix('Ꮩts', 'ᏙᏥ', ''));

PronominalPrefixes.set("DL2SG1", Prefix('ᏍᎩn', 'ᏍᎩᏂ', ''));
PronominalPrefixes.set("DL2SG3AN", Prefix('ᎡᏍd', 'ᎡᏍᏗ', ''));
PronominalPrefixes.set("DL2SG3IN", Prefix('Ꮝd', 'ᏍᏗ', ''));
PronominalPrefixes.set("DL2DL1EXCL", Prefix('ᏍᎩn', 'ᏍᎩᏂ', ''));
PronominalPrefixes.set("DL2PL1INCL", Prefix('', '', ''));
PronominalPrefixes.set("DL2PL1EXCL", Prefix('ᎢᏍᎩy', 'ᎢᏍᎩ', ''));
PronominalPrefixes.set("DL2PL3AN", Prefix('ᎨᏍd', 'ᎨᏍᏗ', ''));
PronominalPrefixes.set("DL2PL3IN", Prefix('ᏕᏍd', 'ᏕᏍᏗ', ''));

PronominalPrefixes.set("PL2SG1", Prefix('ᎢᏍᎩy', 'ᎢᏍᎩ', ''));
PronominalPrefixes.set("PL2SG3AN", Prefix('Ꭱts', 'ᎡᏥ', ''));
PronominalPrefixes.set("PL2SG3IN", Prefix('Ꭲts', 'ᎢᏥ', ''));
PronominalPrefixes.set("PL2DL1EXCL", Prefix('ᎢᏍᎩy', 'ᎢᏍᎩ', ''));
PronominalPrefixes.set("PL2PL3AN", Prefix('Ꭸts', 'ᎨᏥ', ''));
PronominalPrefixes.set("PL2PL3IN", Prefix('Ꮥts', 'ᏕᏥ', ''));

PronominalPrefixes.set("PL3SG1", Prefix('Ꭼgw', 'ᎬᎩ', ''));
PronominalPrefixes.set("PL3SG2", Prefix('Ꭸts', 'ᎨᏥ', ''));
PronominalPrefixes.set("PL3SG3AN", Prefix('Ꭰn', 'ᎠᏂ', ''));
PronominalPrefixes.set("PL3SG3IN", Prefix('Ꭰn', 'ᎠᏂ', ''));
PronominalPrefixes.set("PL3DL1INCL", Prefix('ᎨᎩn', 'ᎨᎩᏂ', ''));
PronominalPrefixes.set("PL3DL1EXCL", Prefix('ᎪᎩn', 'ᎪᎩᏂ', ''));
PronominalPrefixes.set("PL3PL1INCL", Prefix('Ꭸg', 'ᎨᎩ', ''));
PronominalPrefixes.set("PL3PL1EXCL", Prefix('Ꭺg', 'ᎪᎩ', ''));
PronominalPrefixes.set("PL3DL2", Prefix('ᎨᏍd', 'ᎨᏍᏗ', ''));
PronominalPrefixes.set("PL3PL2", Prefix('Ꭸts', 'ᎨᏥ', ''));
PronominalPrefixes.set("PL3PL3AN", Prefix('Ꮣn', 'ᏓᏂ', ''));
PronominalPrefixes.set("PL3PL3IN", Prefix('Ꮣn', 'ᏓᏂ', ''));

PronominalPrefixes.set("SG1SG3INB", Prefix('Ꭰgw', 'ᎠᎩ', ''));
PronominalPrefixes.set("SG2SG3INB", Prefix('ts', 'Ꮳ', ''));
PronominalPrefixes.set("SG3SG3INB", Prefix('Ꭴw', 'Ꭴ', ''));
PronominalPrefixes.set("DL1INCLSG3INB", Prefix('Ꭹn', 'ᎩᏂ', ''));
PronominalPrefixes.set("PL1INCLSG3INB", Prefix('Ꭲg', 'ᎢᎩ', ''));
PronominalPrefixes.set("DL1EXCLSG3INB", Prefix('ᎣᎩn', 'ᎣᎩᏂ', ''));
PronominalPrefixes.set("PL1EXCLSG3INB", Prefix('Ꭳg', 'ᎣᎩ', ''));
PronominalPrefixes.set("PL3SG3INB", Prefix('Ꭴn', 'ᎤᏂ', ''));

PronominalPrefixes.set("SG1PL3INB", Prefix('Ꮣgw', 'ᏓᎩ', ''));
PronominalPrefixes.set("SG2PL3INB", Prefix('Ꮪts', 'ᏕᏣ', ''));
PronominalPrefixes.set("SG3PL3INB", Prefix('Ꮪw', 'Ꮪ', ''));
PronominalPrefixes.set("DL1INCLPL3INB", Prefix('ᏚᎩn', 'ᏕᎩᏂ', ''));
PronominalPrefixes.set("PL1INCLPL3INB", Prefix('Ꮪg', 'ᏚᎩ', ''));
PronominalPrefixes.set("DL1EXCLPL3INB", Prefix('ᏙᎩn', 'ᏙᎩᏂ', ''));
PronominalPrefixes.set("PL1EXCLPL3INB", Prefix('Ꮩg', 'ᏙᎩ', ''));
PronominalPrefixes.set("PL3PL3INB", Prefix('Ꮪn', 'ᏚᏂ', ''));

var VowelPrefixes = new Map();
VowelPrefixes.set("gatsiy", "SG1PL3AN");
VowelPrefixes.set("dogin", "DL1EXCLPL3INB");
VowelPrefixes.set("dugin", "DL1INCLPL3INB");
VowelPrefixes.set("gahiy", "SG2PL3AN");
VowelPrefixes.set("gegin", "PL3DL1INCL");
VowelPrefixes.set("gogin", "PL3DL1EXCL");
VowelPrefixes.set("isgiy", "PL2DL1EXCL");
VowelPrefixes.set("itsvy", "PL1EXCLSG2");
VowelPrefixes.set("dagw", "SG1PL3INB");
VowelPrefixes.set("desd", "DL2PL3IN");
VowelPrefixes.set("dosd", "DL1EXCLPL3IN");
VowelPrefixes.set("gesd", "PL3DL2");
VowelPrefixes.set("gosd", "DL1EXCLPL3AN");
VowelPrefixes.set("gvgw", "PL3SG1");
VowelPrefixes.set("ogin", "DL1EXCLSG3INB");
VowelPrefixes.set("sdvy", "DL1EXCLDL2");
VowelPrefixes.set("sgin", "DL2DL1EXCL");
VowelPrefixes.set("tsiy", "SG1SG3AN");
VowelPrefixes.set("agw", "SG1SG3INB");
VowelPrefixes.set("dan", "PL3PL3IN");
VowelPrefixes.set("ded", "PL1INCLPL3IN");
VowelPrefixes.set("deg", "SG3PL3IN");
VowelPrefixes.set("deh", "SG2PL3IN");
VowelPrefixes.set("dej", "PL2PL3IN");
VowelPrefixes.set("den", "DL1INCLPL3IN");
VowelPrefixes.set("dog", "PL1EXCLPL3INB");
VowelPrefixes.set("doj", "PL1EXCLPL3IN");
VowelPrefixes.set("dug", "PL1INCLPL3INB");
VowelPrefixes.set("duj", "SG2PL3INB");
VowelPrefixes.set("dun", "PL3PL3INB");
VowelPrefixes.set("duw", "SG3PL3INB");
VowelPrefixes.set("esd", "DL2SG3AN");
VowelPrefixes.set("ged", "PL1INCLPL3AN");
VowelPrefixes.set("geg", "PL3PL1INCL");
VowelPrefixes.set("gej", "PL3PL2");
VowelPrefixes.set("gen", "DL1INCLPL3AN");
VowelPrefixes.set("gin", "DL1INCLSG3INB");
VowelPrefixes.set("gog", "PL3PL1EXCL");
VowelPrefixes.set("goj", "PL1EXCLPL3AN");
VowelPrefixes.set("gvy", "SG1SG2");
VowelPrefixes.set("hiy", "SG2SG3AN");
VowelPrefixes.set("osd", "DL1EXCLSG3IN");
VowelPrefixes.set("sgw", "SG2SG1");
VowelPrefixes.set("an", "PL3SG3IN");
VowelPrefixes.set("ed", "PL1INCLSG3AN");
VowelPrefixes.set("ej", "PL2SG3AN");
VowelPrefixes.set("en", "DL1INCLSG3AN");
VowelPrefixes.set("id", "PL1INCLSG3IN");
VowelPrefixes.set("ig", "PL1INCLSG3INB");
VowelPrefixes.set("ij", "PL2SG3IN");
VowelPrefixes.set("in", "DL1INCLSG3IN");
VowelPrefixes.set("og", "PL1EXCLSG3INB");
VowelPrefixes.set("oj", "PL1EXCLSG3IN");
VowelPrefixes.set("sd", "DL2SG3IN");
VowelPrefixes.set("un", "PL3SG3INB");
VowelPrefixes.set("uw", "SG3SG3INB");
VowelPrefixes.set("g", "SG3SG3IN");
VowelPrefixes.set("h", "SG2SG3IN");
VowelPrefixes.set("j", "SG2SG3INB");

var ConsonantPrefixes = new Map();
ConsonantPrefixes.set("degini", "DL1INCLPL3INB");
ConsonantPrefixes.set("dogini", "DL1EXCLPL3INB");
ConsonantPrefixes.set("gegini", "PL3DL1INCL");
ConsonantPrefixes.set("gogini", "PL3DL1EXCL");
ConsonantPrefixes.set("desdi", "DL2PL3IN");
ConsonantPrefixes.set("detsa", "SG2PL3INB");
ConsonantPrefixes.set("detsi", "PL2PL3IN");
ConsonantPrefixes.set("dosdi", "DL1EXCLPL3IN");
ConsonantPrefixes.set("dotsi", "PL1EXCLPL3IN");
ConsonantPrefixes.set("gatsi", "SG1PL3AN");
ConsonantPrefixes.set("gesdi", "PL3DL2");
ConsonantPrefixes.set("getsi", "PL3PL2");
ConsonantPrefixes.set("gosdi", "DL1EXCLPL3AN");
ConsonantPrefixes.set("gotsi", "PL1EXCLPL3AN");
ConsonantPrefixes.set("ogini", "DL1EXCLSG3INB");
ConsonantPrefixes.set("sgini", "DL2DL1EXCL");
ConsonantPrefixes.set("dagi", "SG1PL3INB");
ConsonantPrefixes.set("dani", "PL3PL3IN");
ConsonantPrefixes.set("dedi", "PL1INCLPL3IN");
ConsonantPrefixes.set("degi", "SG3PL3IN");
ConsonantPrefixes.set("dehi", "SG2PL3IN");
ConsonantPrefixes.set("deni", "DL1INCLPL3IN");
ConsonantPrefixes.set("dogi", "PL1EXCLPL3INB");
ConsonantPrefixes.set("dugi", "PL1INCLPL3INB");
ConsonantPrefixes.set("duni", "PL3PL3INB");
ConsonantPrefixes.set("esdi", "DL2SG3AN");
ConsonantPrefixes.set("etsi", "PL2SG3AN");
ConsonantPrefixes.set("gahi", "SG2PL3AN");
ConsonantPrefixes.set("gedi", "PL1INCLPL3AN");
ConsonantPrefixes.set("gegi", "PL3PL1INCL");
ConsonantPrefixes.set("geni", "DL1INCLPL3AN");
ConsonantPrefixes.set("gini", "DL1INCLSG3INB");
ConsonantPrefixes.set("gogi", "PL3PL1EXCL");
ConsonantPrefixes.set("gvgi", "PL3SG1");
ConsonantPrefixes.set("isgi", "PL2DL1EXCL");
ConsonantPrefixes.set("itsi", "PL2SG3IN");
ConsonantPrefixes.set("itsv", "PL1EXCLSG2");
ConsonantPrefixes.set("osdi", "DL1EXCLSG3IN");
ConsonantPrefixes.set("otsi", "PL1EXCLSG3IN");
ConsonantPrefixes.set("agi", "SG1SG3INB");
ConsonantPrefixes.set("ani", "PL3SG3IN");
ConsonantPrefixes.set("edi", "PL1INCLSG3AN");
ConsonantPrefixes.set("eni", "DL1INCLSG3AN");
ConsonantPrefixes.set("idi", "PL1INCLSG3IN");
ConsonantPrefixes.set("igi", "PL1INCLSG3INB");
ConsonantPrefixes.set("ini", "DL1INCLSG3IN");
ConsonantPrefixes.set("ogi", "PL1EXCLSG3INB");
ConsonantPrefixes.set("sdi", "DL2SG3IN");
ConsonantPrefixes.set("sdv", "DL1EXCLDL2");
ConsonantPrefixes.set("sgi", "SG2SG1");
ConsonantPrefixes.set("tsa", "SG2SG3INB");
ConsonantPrefixes.set("tsi", "SG3SG2");
ConsonantPrefixes.set("uni", "PL3SG3INB");
ConsonantPrefixes.set("du", "SG3PL3INB");
ConsonantPrefixes.set("ga", "SG3SG3IN");
ConsonantPrefixes.set("gv", "SG1SG2");
ConsonantPrefixes.set("hi", "SG2SG3IN");
ConsonantPrefixes.set("u", "SG3SG3INB");

function getFinalSuffixes(wholeWord) {
    //iterate over final endings to remove each one from top to bottom right to left
    var finalSuffixesList = [];
    var word = wholeWord.phonetic;
    for (const finalEnding of FinalEndings.keys()) {
        if (word.endsWith(finalEnding)) {
            var finalEndingItem = FinalEndings.get(finalEnding);
            finalSuffixesList.push(createExplanation(finalEnding, '', 'suffix', '', finalEndingItem, ''));
            word = word.substr(0, word.length - finalEnding.length);
        }
    }

    wholeWord.finalSuffixes = finalSuffixesList;
    //to get the substring of the prefix found to the end
    // the longest prefix found is possibly the correct answer
    // var pronSize = 0;
    // for (const pronominalPrefixListElement of pronominalPrefixList) {
    //     var tmp = PronominalPrefixes.get(pronominalPrefixListElement);
    //     console.log(tmp.preVowel);
    //     if (tmp.preVowel.length > pronSize) {
    //         pronSize = tmp.preVowel.length;
    //     }
    //
    //     if (tmp.preConsonant.length > pronSize) {
    //         pronSize = tmp.preConsonant.length;
    //     }
    // }

    console.log(" word is " + word);

    wholeWord.tmpParse = word;

    return wholeWord;
}

//TODO: what if there are multiples?  return both?
function getVerbTenseSuffixes(wholeWord) {
    var verbTenseSuffixesList = []
    var word = wholeWord.phonetic;
    for (const verbTense of VerbTense.keys()) {
        if (word.endsWith(verbTense)) {
            var verbTenseItem = VerbTense.get(verbTense);
            var explanation = createExplanation(verbTense, '', 'suffix', '', verbTenseItem, '');
            verbTenseSuffixesList.push(explanation);
            word = word.substr(0, word.length - verbTense.length);
        }
    }

    wholeWord.verbTenseSuffix = verbTenseSuffixesList;
    wholeWord.tmpParse = word;

    return wholeWord;
}

function getNonFinalSuffixes(wholeWord) {
    var word = wholeWord.tmpParse;

    var nonFinalSuffixesList = [];
    if (word.endsWith("ilo") || word.endsWith("iloj") || word.endsWith("ilos")) {
        // var finalEndingItem = FinalEndings.get(finalEnding);
        // finalSuffixesList.push(createExplanation(finalEnding, '', 'suffix', '', finalEndingItem, ''));
        nonFinalSuffixesList.push("reflexive");
        if (word.endsWith("ilo")) {
            wholeWord.tmpParse = wholeWord.tmpParse.substring(0, wholeWord.tmpParse.length - 3);
        } else {
            wholeWord.tmpParse = wholeWord.tmpParse.substring(0, wholeWord.tmpParse.length - 4);
        }

        wholeWord.nonFinalSuffixes = nonFinalSuffixesList;
    } else {
        for (let i = 0; i < NonFinalEndings.length; i++) {
            const nonFinalEnding = NonFinalEndings[i];
            console.log(nonFinalEnding);
        }
    }

    return wholeWord;
}


function getInitialPrefixes(wholeWord) {

    return wholeWord;
}

function getPronominalPrefixes(wholeWord) {
    // for (const pronominalPrefix of PronominalPrefixes.keys()) {
    //     var ppValue = PronominalPrefixes.get(pronominalPrefix);
    //     var preVowel = newTsalagiToSyllabary(ppValue.preVowel,false, true);
    //     var preConsonant = newTsalagiToSyllabary(ppValue.preConsonant,false, true);
    //     var tmp = wholeWord.tmpParse;
    //     if (tmp.startsWith(preConsonant) || tmp.startsWith(preVowel)) {
    //         console.log(pronominalPrefix + " " + preVowel + " " + preConsonant + " ");
    //     }
    // }

    var pronominalPrefixList = [];

    for (const vowelPrefix of VowelPrefixes.keys()) {
        if (wholeWord.tmpParse.startsWith(vowelPrefix)) {
            pronominalPrefixList.push(VowelPrefixes.get(vowelPrefix));
            console.log("vowel " + VowelPrefixes.get(vowelPrefix));
        }
    }

    for (const consonantPrefix of ConsonantPrefixes.keys()) {
        if (wholeWord.tmpParse.startsWith(consonantPrefix)) {
            pronominalPrefixList.push(ConsonantPrefixes.get(consonantPrefix));
            console.log("consonant " + ConsonantPrefixes.get(consonantPrefix));
        }
    }

    //to get the substring of the prefix found to the end
    // the longest prefix found is possibly the correct answer
    var pronSize = 0;
    for (const pronominalPrefixListElement of pronominalPrefixList) {
        var tmp = PronominalPrefixes.get(pronominalPrefixListElement);
        console.log(tmp.preVowel);
        if (tmp.preVowel.length > pronSize) {
            pronSize = tmp.preVowel.length;
        }

        if (tmp.preConsonant.length > pronSize) {
            pronSize = tmp.preConsonant.length;
        }
    }

    var tmp = wholeWord.tmpParse
    tmp = tmp.substring(pronSize);
    wholeWord.tmpParse = tmp;

    wholeWord.pronounPrefixes = pronominalPrefixList;


    return wholeWord;
}

function getReflexivePrefix(wholeWord) {

    return wholeWord;
}

//if processing phonetic then pass in isSyllabary as false
function process(word, isSyllabary=true) {
    var wholeWord = {
        syllabary: "",
        phonetic: "",
        tmpParse: "",
        initialPrefixes: [],
        pronounPrefixes: [],
        reflexivePrefix: false,
        nonFinalSuffixes: [],
        verbTenseSuffix: '',
        verbTenseType: Tense.PRESENT,
        finalSuffixes: []
    };

    if (isSyllabary) {
        wholeWord.syllabary = word;
        wholeWord.phonetic = parseSyllabary(word)
    } else {
        wholeWord.phonetic = word;
    }

    wholeWord = getFinalSuffixes(wholeWord);
    wholeWord = getVerbTenseSuffixes(wholeWord);

    for (const tmpElementElement of wholeWord.verbTenseSuffix) {
        wholeWord.verbTenseType = tmpElementElement.meaning;
        //TODO: also need to get verb tense ending here -- will need another map
    }

    wholeWord = getNonFinalSuffixes(wholeWord);

    // wholeWord = getInitialPrefixes(wholeWord);
    wholeWord = getPronominalPrefixes(wholeWord);
    console.log(wholeWord);
    // wholeWord = getReflexivePrefix(wholeWord);

    document.getElementById("display").innerText = JSON.stringify(wholeWord);
}