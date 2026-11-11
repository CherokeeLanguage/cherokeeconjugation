package net.cherokeedictionary.sample.structure

class TempMessage extends AbstractMessage {
    @Override
    void process(String message) {
        println message
    }
}
