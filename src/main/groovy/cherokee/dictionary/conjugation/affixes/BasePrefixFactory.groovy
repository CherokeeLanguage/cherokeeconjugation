package cherokee.dictionary.conjugation.affixes

class BasePrefixFactory {
    public String processPrefixes(data, PrefixHolderObject pho) {
        def baseReturnValue = "";

        def yi = pho.yi
        def ji = pho.ji
        def wi = pho.wi
        def ni = pho.ni
        def de = pho.de
        def da = pho.da
        def i = pho.i
        def ga = pho.ga
        def e = pho.e

        if (ga) {
            baseReturnValue = processGa(data);
        }

        if (i) {
            baseReturnValue = processI(baseReturnValue, data);
        }

        if (ni) {
            baseReturnValue = processNi(baseReturnValue, data);
        }

        if (wi) {
            baseReturnValue = processWi(baseReturnValue, data);
        }

        if (yi) {
            baseReturnValue = processYi(baseReturnValue, data);
        }

        if (baseReturnValue == '') {
            baseReturnValue = data;
        }

        return baseReturnValue
    }

    private String  processGa(data) {
        def charAtZero = data.charAt(0);
        def startsWithVowel = (charAtZero == 'Ꭰ' || charAtZero == 'Ꭱ' || charAtZero == 'Ꭲ' || charAtZero == 'Ꭳ' || charAtZero == 'Ꭴ' || charAtZero == 'Ꭵ')
        def baseReturnValue = "";

        if (startsWithVowel) {
            if (charAtZero == 'Ꭰ') {
                baseReturnValue = 'Ꭼ' + data.substring(1);
            } else if (charAtZero == 'Ꭱ') {
                baseReturnValue = 'ᎦᏰ' + data.substring(1);
            } else if (charAtZero == 'Ꭲ') {
                baseReturnValue = 'ᎦᏱ' + data.substring(1);
            } else if (charAtZero == 'Ꭳ') {
                baseReturnValue = 'ᎦᏲ' + data.substring(1);
            } else if (charAtZero == 'Ꭴ') {
                baseReturnValue = 'ᎦᏳ' + data.substring(1);
            } else if (charAtZero == 'Ꭵ') {
                baseReturnValue = 'ᎦᏴ' + data.substring(1);
            }
        } else {
            baseReturnValue =  'Ꭶ' + data;
        }

        return baseReturnValue;

    }

    private String processI(baseReturnValue, data) {
        def charAtZero = baseReturnValue != '' ? baseReturnValue.charAt(0) : data.charAt(0);
        def startsWithVowel = (charAtZero == 'Ꭰ' || charAtZero == 'Ꭱ' || charAtZero == 'Ꭲ' || charAtZero == 'Ꭳ' || charAtZero == 'Ꭴ' || charAtZero == 'Ꭵ')

        if (startsWithVowel) {
            if (charAtZero == 'Ꭰ') {
                baseReturnValue = 'Ꭲ' + (baseReturnValue != '' ? baseReturnValue.substring(1) : data.substring(1));
            } else if (charAtZero == 'Ꭱ') {
                baseReturnValue = 'Ꭲ' + (baseReturnValue != '' ? baseReturnValue.substring(1) : data.substring(1));
            } else if (charAtZero == 'Ꭲ') {
                baseReturnValue = 'Ꭲ' + (baseReturnValue != '' ? baseReturnValue.substring(1) : data.substring(1));
            } else if (charAtZero == 'Ꭳ') {
                baseReturnValue = 'Ꭲ' + (baseReturnValue != '' ? baseReturnValue.substring(1) : data.substring(1));
            } else if (charAtZero == 'Ꭴ') {
                baseReturnValue = 'Ꭲ' + (baseReturnValue != '' ? baseReturnValue.substring(1) : data.substring(1));
            } else if (charAtZero == 'Ꭵ') {
                baseReturnValue = 'Ꭲ' + (baseReturnValue != '' ? baseReturnValue.substring(1) : data.substring(1));
            }
        } else {
            if (charAtZero == 'Ꭶ' || $('#verbTense').find(":selected").val() == '${Tense.REMOTE_PAST}') {
                baseReturnValue = 'Ꭵ' + (baseReturnValue != '' ? baseReturnValue : data);
            } else {
                baseReturnValue = 'Ꭲ' + (baseReturnValue != '' ? baseReturnValue : data);
            }
        }

        return baseReturnValue;
    }

    private String processNi(baseReturnValue, data) {
        def charAtZero = baseReturnValue != '' ? baseReturnValue.charAt(0) : data.charAt(0);
        boolean isVowelBeginning = (charAtZero == 'Ꭰ' || charAtZero == 'Ꭱ' || charAtZero == 'Ꭲ' || charAtZero == 'Ꭳ' || charAtZero == 'Ꭴ' || charAtZero == 'Ꭵ')

        if (isVowelBeginning) {
            if (charAtZero == 'Ꭰ') {
                baseReturnValue = 'Ꮎ' + (baseReturnValue != '' ? baseReturnValue.substring(1) : data.substring(1));
            } else if (charAtZero == 'Ꭱ') {
                baseReturnValue = 'Ꮑ' + (baseReturnValue != '' ? baseReturnValue.substring(1) : data.substring(1));
            } else if (charAtZero == 'Ꭲ') {
                baseReturnValue = 'Ꮒ' + (baseReturnValue != '' ? baseReturnValue.substring(1) : data.substring(1));
            } else if (charAtZero == 'Ꭳ') {
                baseReturnValue = 'Ꮓ' + (baseReturnValue != '' ? baseReturnValue.substring(1) : data.substring(1));
            } else if (charAtZero == 'Ꭴ') {
                baseReturnValue = 'Ꮔ' + (baseReturnValue != '' ? baseReturnValue.substring(1) : data.substring(1));
            } else if (charAtZero == 'Ꭵ') {
                baseReturnValue = 'Ꮕ' + (baseReturnValue != '' ? baseReturnValue.substring(1) : data.substring(1));
            }
        } else {
            baseReturnValue =  "Ꮒ" + (baseReturnValue != '' ? baseReturnValue : data);
        }

        return baseReturnValue;
    }

    private String processWi(baseReturnValue, data) {
        def charAtZero = baseReturnValue != '' ? baseReturnValue.charAt(0) : data.charAt(0);
        boolean isVowelBeginning = (charAtZero == 'Ꭰ' || charAtZero == 'Ꭱ' || charAtZero == 'Ꭲ' || charAtZero == 'Ꭳ' || charAtZero == 'Ꭴ' || charAtZero == 'Ꭵ')

        if (isVowelBeginning) {
            if (charAtZero == 'Ꭰ') {
                baseReturnValue = 'Ꮹ' + (baseReturnValue != '' ? baseReturnValue.substring(1) : data.substring(1));
            } else if (charAtZero == 'Ꭱ') {
                baseReturnValue = 'Ꮺ' + (baseReturnValue != '' ? baseReturnValue.substring(1) : data.substring(1));
            } else if (charAtZero == 'Ꭲ') {
                baseReturnValue = 'Ꮻ' + (baseReturnValue != '' ? baseReturnValue.substring(1) : data.substring(1));
            } else if (charAtZero == 'Ꭳ') {
                baseReturnValue = 'Ꮼ' + (baseReturnValue != '' ? baseReturnValue.substring(1) : data.substring(1));
            } else if (charAtZero == 'Ꭴ') {
                baseReturnValue = 'Ꮽ' + (baseReturnValue != '' ? baseReturnValue.substring(1) : data.substring(1));
            } else if (charAtZero == 'Ꭵ') {
                baseReturnValue = 'Ꮾ' + (baseReturnValue != '' ? baseReturnValue.substring(1) : data.substring(1));
            }
        } else {
            baseReturnValue = "Ꮻ" + (baseReturnValue != '' ? baseReturnValue : data);
        }

        return baseReturnValue;
    }

    private String processYi(baseReturnValue, data) {
        def charAtZero = baseReturnValue != '' ? baseReturnValue.charAt(0) : data.charAt(0);
        boolean isVowelBeginning = (charAtZero == 'Ꭰ' || charAtZero == 'Ꭱ' || charAtZero == 'Ꭲ' || charAtZero == 'Ꭳ' || charAtZero == 'Ꭴ' || charAtZero == 'Ꭵ')

        if (isVowelBeginning) {
            if (charAtZero == 'Ꭰ') {
                baseReturnValue = 'Ꮿ' + (baseReturnValue != '' ? baseReturnValue.substring(1) : data.substring(1));
            } else if (charAtZero == 'Ꭱ') {
                baseReturnValue = 'Ᏸ' + (baseReturnValue != '' ? baseReturnValue.substring(1) : data.substring(1));
            } else if (charAtZero == 'Ꭲ') {
                baseReturnValue = 'Ᏹ' + (baseReturnValue != '' ? baseReturnValue.substring(1) : data.substring(1));
            } else if (charAtZero == 'Ꭳ') {
                baseReturnValue = 'Ᏺ' + (baseReturnValue != '' ? baseReturnValue.substring(1) : data.substring(1));
            } else if (charAtZero == 'Ꭴ') {
                baseReturnValue = 'Ᏻ' + (baseReturnValue != '' ? baseReturnValue.substring(1) : data.substring(1));
            } else if (charAtZero == 'Ꭵ') {
                baseReturnValue = 'Ᏼ' + (baseReturnValue != '' ? baseReturnValue.substring(1) : data.substring(1));
            }
        } else {
            if (charAtZero == 'Ꮹ' || charAtZero == 'Ꮺ' || charAtZero == 'Ꮻ' || charAtZero == 'Ꮼ' || charAtZero == 'Ꮽ' || charAtZero == 'Ꮾ') {
                baseReturnValue = "Ᏻ" + (baseReturnValue != '' ? baseReturnValue : data);
            } else {
                baseReturnValue = "Ᏹ" + (baseReturnValue != '' ? baseReturnValue : data);
            }
        }

        return baseReturnValue;
    }

    private String startWithVowel(charAtZero) {
        println "vowels are " + (charAtZero == 'Ꭰ' || charAtZero == 'Ꭱ' || charAtZero == 'Ꭲ' || charAtZero == 'Ꭳ' || charAtZero == 'Ꭴ' || charAtZero == 'Ꭵ')

        return charAtZero == 'Ꭰ' || charAtZero == 'Ꭱ' || charAtZero == 'Ꭲ' || charAtZero == 'Ꭳ' || charAtZero == 'Ꭴ' || charAtZero == 'Ꭵ'
    }
}
