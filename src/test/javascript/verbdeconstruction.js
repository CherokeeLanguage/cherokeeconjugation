var verbTense;

function getFinalSuffixes(wholeWord) {
    //iterate over final endings to remove each one from top to bottom right to left
    var finalSuffixesList = [];
    var word = wholeWord.phonetic;

    var foundAResult = true;
    while(foundAResult) {
        foundAResult = false;
        for (const finalEnding of FinalEndings.keys()) {
            var tmpEnding = FinalEndings.get(finalEnding);
            if (word.endsWith(finalEnding)) {
                foundAResult = true;
                finalSuffixesList.push(createExplanation(finalEnding, '', 'suffix', '', tmpEnding, ''));
                word = word.substr(0, word.length - finalEnding.length);
            }
        }
    }

    wholeWord.finalSuffixes = finalSuffixesList;

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

    var foundAResult = true;
    while(foundAResult) {
        foundAResult = false;
        for (const nonFinalEnding of NonFinalEndings.keys()) {
            if (word.endsWith(nonFinalEnding)) {
                foundAResult = true;
                word = word.substring(0, word.length - nonFinalEnding.length);
                nonFinalSuffixesList.push(NonFinalEndings.get(nonFinalEnding));
            }
        }
    }

    // word = wholeWord.tmpParse;

    // if (word.endsWith("ilo") || word.endsWith("ilots") || word.endsWith("ilos")) {
    //     nonFinalSuffixesList.push("reflexive");
    //     if (word.endsWith("ilots")) {
    //         wholeWord.tmpParse = wholeWord.tmpParse.substring(0, word.length - 5);
    //     } else if (word.endsWith("ilos")) {
    //         wholeWord.tmpParse = wholeWord.tmpParse.substring(0, word.length - 4);
    //     } else if (word.endsWith("ilo")) {
    //         wholeWord.tmpParse = wholeWord.tmpParse.substring(0, word.length - 3);
    //     } else {
    //         console.log("this is here");
    //     }
    //
    //     //ᎦᏬᏂᏎᎶᏍᎬᎢ
    //
    //     wholeWord.nonFinalSuffixes = nonFinalSuffixesList;
    // }

    wholeWord.tmpParse = word;

    wholeWord.nonFinalSuffixes = nonFinalSuffixesList;

    return wholeWord;
}

function getInitialPrefixes(wholeWord) {
    return wholeWord;
}

function getPronominalPrefixes(wholeWord) {
    var pronominalPrefixList = [];

    var pronSize = 0;
    var tmp = wholeWord.tmpParse;

    for (const consonantPrefix of ConsonantPrefixes.keys()) {
        if (tmp.startsWith(consonantPrefix)) {
            if (consonantPrefix.length > pronSize) {
                pronSize = consonantPrefix.length;
            }

            pronominalPrefixList.push(ConsonantPrefixes.get(consonantPrefix));
        }
    }

    tmp = tmp.substring(pronSize);
    if (pronSize > 0 ) {
        for (const vowelPrefix of VowelPrefixes.keys()) {
            if (tmp.startsWith(vowelPrefix)) {
                if (vowelPrefix.length > pronSize) {
                    pronSize = vowelPrefix.length;
                }

                pronominalPrefixList.push(VowelPrefixes.get(vowelPrefix));
            }
        }
    }

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
    // wholeWord = getReflexivePrefix(wholeWord);

    document.getElementById("display").innerText = JSON.stringify(wholeWord);
}
