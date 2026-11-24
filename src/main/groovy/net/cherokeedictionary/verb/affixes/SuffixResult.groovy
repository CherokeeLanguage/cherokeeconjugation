package net.cherokeedictionary.verb.affixes

import groovy.transform.CompileStatic

/**
 * Result container for suffix deconstruction
 */
@CompileStatic
class SuffixResult {
    String result           // Remaining stem after removal
    boolean suffixRemoved   // Whether suffix was successfully removed
    String detectedSuffix  // The suffix glyph found (e.g., "Ꭲ", "ᏳᏍᏗ")
    String type            // Semantic type (HABITUAL, PAST, FUTURE, etc.)
    
    SuffixResult() {
        this.result = ""
        this.suffixRemoved = false
        this.detectedSuffix = null
        this.type = null
    }
}
