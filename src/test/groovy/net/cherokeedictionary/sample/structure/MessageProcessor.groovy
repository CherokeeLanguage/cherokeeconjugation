package net.cherokeedictionary.sample.structure

class MessageProcessor {
    private final static AbstractMessage[] messages = {
        new TempMessage()
    }

    private static TempMessage[] tmpMessages = [
        new TempMessageFromInterface()
    ] as TempMessage[]

    public void process() {
        for (AbstractMessage processor : messages) {
            //would pass in this object which would have other additional information that could be used
            // but for this, we're going to pass in a String to test with.
            processor.process("string here");
        }

        for (TempMessage message : tmpMessages) {
            message.process("new String Here")
        }
    }
}
