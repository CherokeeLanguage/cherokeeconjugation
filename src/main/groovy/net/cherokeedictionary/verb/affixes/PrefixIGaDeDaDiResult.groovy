package net.cherokeedictionary.verb.affixes

import groovy.transform.CompileStatic

/**
 * Result container for I, Ga, De, Da, Di, E prefix deconstruction
 * (These share similar patterns)
 */
@CompileStatic
class PrefixIGaDeDaDiResult {
    String result
    boolean prefixRemoved
    String detectedPrefix
    String reason
    
    String getReason() {
        return reason ?: null
    }
}
