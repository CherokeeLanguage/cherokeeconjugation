package net.cherokeedictionary.sample.structure

class TempMessageFromInterface implements MessageInterface {
    @Override
    void process(String message) {
        println message
    }
}
