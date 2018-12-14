package cherokee.dictionary.conjugation.hold

//takes a verb and determines what prefixes are on a verb
class PrefixInterpreter {
    private static final yiString = /ᏯᏰᏱᏲᏳᏴ/
    private static final wiString = /ᏩᏪᏫᏬᏭᏮ/

    public static interpret(String word) {
        if (word.contains(" ")) {
            //this is a sentence and more work needs to be done//TODO: later
        }

        println word.startsWith(yiString)

    }
}
