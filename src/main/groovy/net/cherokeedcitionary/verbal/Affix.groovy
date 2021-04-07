package net.cherokeedcitionary.verbal

import net.cherokeedcitionary.core.Verb


interface Affix {
    String toSyllabary(String baseReturnValue, Verb word)
    String toEnglish(String baseReturnValue, Verb word)
}