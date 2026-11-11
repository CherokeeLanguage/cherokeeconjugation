package net.cherokeedictionary.sample

abstract class Morph {
    boolean active = false
    boolean isActive() {
        return active
    }

    abstract void apply(compareString)
}
