package net.cherokeedictionary.verb.affixes

import groovy.transform.CompileStatic

/**
 * Result container for Yi prefix deconstruction
 */
@CompileStatic
class PrefixYiResult {
    String result
    boolean prefixRemoved
    String detectedPrefix
    String reason
    
    String getReason() {
        return reason ?: null
    }
}
