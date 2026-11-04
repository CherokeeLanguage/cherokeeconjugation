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

