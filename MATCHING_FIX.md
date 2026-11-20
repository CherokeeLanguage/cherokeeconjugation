# MATCHING_FIX.md -- spellings that do not convert cleanly to syllabary

Re-scan Fri Nov 20 12:34:19 CST 2026 by a one-off pass over every vrb spec's details.conjugations rows
and where-table expectations. Each entry: file, line, the quoted string, and what
SyllabaryUtil.tsalagiToSyllabary made of it. Fix the spelling so it matches the CED
syllabary parse-back (see DISCREPANCIES.md D9/D12 for the conventions). -- tio 20Nov26

## AdisiyaaSpec.groovy

- line 19: "anidisaysgoi" -> ᎠᏂᏗᏌnot a valid letterᏍᎪᎢ

## AsganvgaSpec.groovy

- line 17: "aksganvysdi" -> Ꭰnot a valid letterᏍᎦᏅnot a valid letterᏍᏗ
- line 18: "tsganvysdi" -> not a valid letterᏍᎦᏅnot a valid letterᏍᏗ
- line 20: "unisganvysdi" -> ᎤᏂᏍᎦᏅnot a valid letterᏍᏗ
- line 21: "igisganvysdi" -> ᎢᎩᏍᎦᏅnot a valid letterᏍᏗ

## AsgwadiaSpec.groovy

- line 17: "tsgwadvi" -> not a valid letterᏍᏆᏛᎢ
- line 17: "tsgwadisdi" -> not a valid letterᏍᏆᏗᏍᏗ

## AsgwahleaSpec.groovy

- line 17: "tsgwahlesvi" -> not a valid letterᏍᏆᏞᏒᎢ
- line 17: "tsgwahlesdi" -> not a valid letterᏍᏆᏞᏍᏗ

## AsgwanigosgaSpec.groovy

- line 17: "tsgwanigosvi" -> not a valid letterᏍᏆᏂᎪᏒᎢ
- line 17: "tsgwanigohisdi" -> not a valid letterᏍᏆᏂᎪᎯᏍᏗ

## AtihnehaSpec.groovy

- line 14: "x" -> not a valid letter
- line 14: "x" -> not a valid letter

## DagachvsdihaSpec.groovy

- line 17: "dejachsvsdiha" -> ᏕᏣnot a valid letterᎠᏒᏍᏗᎭ

## EdoaSpec.groovy

- line 15: "head" -> ᎮᎠnot a valid letter

## GadeysdihaSpec.groovy

- line 17: "akdeystanvi" -> ᎠᎩᏕnot a valid letterᏍᏔᏅᎢ
- line 17: "akdeysdohdi" -> ᎠᎩᏕnot a valid letterᏍᏙᏗ
- line 18: "hideysdiha" -> ᎯᏕnot a valid letterᏍᏗᎭ
- line 18: "hideysdisgoi" -> ᎯᏕnot a valid letterᏍᏗᏍᎪᎢ
- line 18: "tsdeystanvi" -> ᏥᏕnot a valid letterᏍᏔᏅᎢ
- line 18: "hideysda" -> ᎯᏕnot a valid letterᏍᏓ
- line 18: "tsdeysdohdi" -> ᏥᏕnot a valid letterᏍᏙᏗ
- line 20: "anideysdiha" -> ᎠᏂᏕnot a valid letterᏍᏗᎭ
- line 20: "anideysdisgoi" -> ᎠᏂᏕnot a valid letterᏍᏗᏍᎪᎢ
- line 20: "unideystanvi" -> ᎤᏂᏕnot a valid letterᏍᏔᏅᎢ
- line 20: "anideysda" -> ᎠᏂᏕnot a valid letterᏍᏓ
- line 20: "unideysdohdi" -> ᎤᏂᏕnot a valid letterᏍᏙᏗ
- line 21: "idideysdiha" -> ᎢᏗᏕnot a valid letterᏍᏗᎭ
- line 21: "idideysdisgoi" -> ᎢᏗᏕnot a valid letterᏍᏗᏍᎪᎢ
- line 21: "igadeystanvi" -> ᎢᎦᏕnot a valid letterᏍᏔᏅᎢ
- line 21: "idideysda" -> ᎢᏗᏕnot a valid letterᏍᏓ
- line 21: "igideysdohdi" -> ᎢᎩᏕnot a valid letterᏍᏙᏗ

## GanatlaaSpec.groovy

- line 14: "x" -> not a valid letter

## UhnihaSpec.groovy

- line 17: "x" -> not a valid letter

## UlvkwdiSpec.groovy

- line 18: "agilvkwdi" -> ᎠᎩᎸnot a valid letternot a valid letterᏗ
- line 18: "agilvkwdoi" -> ᎠᎩᎸnot a valid letternot a valid letterᏙᎢ
- line 18: "agilvkwtanvi" -> ᎠᎩᎸnot a valid letternot a valid letterᏔᏅᎢ
- line 18: "jilvkwda" -> ᏥᎸnot a valid letternot a valid letterᏓ
- line 18: "agilvkwdohdi" -> ᎠᎩᎸnot a valid letternot a valid letterᏙᏗ
- line 20: "jalvkwdi" -> ᏣᎸnot a valid letternot a valid letterᏗ
- line 20: "jalvkwdoi" -> ᏣᎸnot a valid letternot a valid letterᏙᎢ
- line 20: "jalvkwtanvi" -> ᏣᎸnot a valid letternot a valid letterᏔᏅᎢ
- line 20: "hilvkwda" -> ᎯᎸnot a valid letternot a valid letterᏓ
- line 20: "jalvkwdohdi" -> ᏣᎸnot a valid letternot a valid letterᏙᏗ
- line 22: "unilvkwdi" -> ᎤᏂᎸnot a valid letternot a valid letterᏗ
- line 22: "unilvkwdoi" -> ᎤᏂᎸnot a valid letternot a valid letterᏙᎢ
- line 22: "unilvkwtanvi" -> ᎤᏂᎸnot a valid letternot a valid letterᏔᏅᎢ
- line 22: "unilvkwda" -> ᎤᏂᎸnot a valid letternot a valid letterᏓ
- line 22: "unilvkwdohdi" -> ᎤᏂᎸnot a valid letternot a valid letterᏙᏗ
- line 23: "igilvkwdi" -> ᎢᎩᎸnot a valid letternot a valid letterᏗ
- line 23: "igilvkwdoi" -> ᎢᎩᎸnot a valid letternot a valid letterᏙᎢ
- line 23: "igilvkwtanvi" -> ᎢᎩᎸnot a valid letternot a valid letterᏔᏅᎢ
- line 23: "igilvkwda" -> ᎢᎩᎸnot a valid letternot a valid letterᏓ
- line 23: "igilvkwdohdi" -> ᎢᎩᎸnot a valid letternot a valid letterᏙᏗ

## UnegujaSpec.groovy

- line 17: "x" -> not a valid letter

## VerbLexemeFlagMetaSpec.groovy

- line 28: "impersonal" -> Ꭲnot a valid letternot a valid letterᎡnot a valid letterᏐᎾnot a valid letter

## VrbStemCoverageMetaSpec.groovy

- line 38: "present" -> not a valid letternot a valid letterᎡᏎnot a valid letternot a valid letter
- line 39: "habitual" -> Ꭽnot a valid letterᎢᏚᎠnot a valid letter
- line 42: "infinitive" -> Ꭲnot a valid letternot a valid letterᎢᏂᏘᎥᎡ
- line 43: "imperative" -> Ꭲnot a valid letternot a valid letterᎡnot a valid letterᎠᏘᎥᎡ
- line 105: "x" -> not a valid letter

---

Checked 18005 quoted spellings; 61 flagged.
