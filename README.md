# Cherokee Conjugation Engine

This project is for conjugating Cherokee Verbs.  It is not a standalone library.

The best way to build this project is to go to https://github.com/CherokeeLanguage/cedproject and clone the repository

Once cloned, open up buildMain.sh file
line 204 - do you want to check out with http or git? comment, or uncomment, which one you wish to use
above 204 are two methods for cloneHttp or cloneGit you can comment out any of the lines you don't want.  For this repository it does require the transliteration and the utilities.

go to the CLI and run `./build.sh gitClone`

Once that's completed, you can run:
`./build.sh buildTransliteration`
`./build.sh buildUtilities`
`./build.sh buildConjugation` 


and the conjugation engine will build and place the subsequent jar in your local Maven and Gradle repositories


## Project documents

- [CHANGELOG.md](CHANGELOG.md) — dated record of engine/validation work (comments tagged `-- tio <DDMMMYY>` trace to it)
- [DISCREPANCIES.md](DISCREPANCIES.md) — D1–D18 discrepancy ledger, each with a citation and verdict
- [GAP.md](GAP.md) — the 45 book-unattested stem gaps tracked by VrbStemCoverageMetaSpec (gap classes + closing protocol)
- Validation: `./gradlew test` (default suite) · `./gradlew test -PincludeVrb` (adds the 405-spec vrb package + the composition gate)
- Public API: `net.cherokeedictionary.conjugation.VerbConjugationFacade` — one-in-one-out (`conjugate(ConjugationRequest) -> Verb`); syllabary-only contract for stems (roman tolerated via the `VerbInputNormalizer` input gate); per-lexeme flags in `src/main/resources/data/verbLexemes.json` applied via `ConjugationRequest.lexeme`
