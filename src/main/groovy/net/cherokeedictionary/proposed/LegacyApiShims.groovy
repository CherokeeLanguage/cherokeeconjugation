// tio 18Nov26: LEGACY PACKAGE SHIMS. The API classes moved to
// net.cherokeedictionary.conjugation (user decision: "move the classes to
// conjugation for now"). These deprecated shims keep any external caller
// (the dictionary app compiles against net.cherokeedictionary.proposed)
// compiling and behaving identically -- each extends the moved class, so
// behavior is inherited verbatim. All future work goes through the
// conjugation-package facade (user direction); these exist ONLY so existing
// callers don't break, and are safe to delete once consumers are migrated.
package net.cherokeedictionary.proposed

@Deprecated
class ConjugationRequest extends net.cherokeedictionary.conjugation.ConjugationRequest {}

@Deprecated
class ConjugationContext extends net.cherokeedictionary.conjugation.ConjugationContext {}

@Deprecated
interface ConjugationStep extends net.cherokeedictionary.conjugation.ConjugationStep {}

// NOTE: there is no ConjugationPipeline class to shim -- the ConjugationPipeline.groovy
// file only holds the StubInitialPrefixStep / StubRuleApplicationStep classes, which
// moved with the package and are referenced only from VerbConjugationFacade internally.

@Deprecated
class RobustStemmerService extends net.cherokeedictionary.conjugation.RobustStemmerService {}

@Deprecated
class VerbConjugationFacade extends net.cherokeedictionary.conjugation.VerbConjugationFacade {}
