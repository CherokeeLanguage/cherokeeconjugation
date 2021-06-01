import groovy.xml.MarkupBuilder

/*
1. Preface
Book title tsalagi gawonihisdi digohweli
ᏣᎳᎩ ᎦᏬᏂᎯᏍᏗ ᏗᎪᏪᎵ
Dedication
From The Author
2. Greetings
2.1. What You Will Learn
Greet Others
In this unit you will learn:
How to greet people
How to make short descriptive phrases
About definites and indefinites
Say "hello" and "good  bye"
Ask how someone is doing
Osiyo / Siyo Hi or Hello …
Osiyo / Siyo Hi or Hello (We Are Learning Cherokee (Final))
The following phrases are all ways to ask …
The following phrases are all ways to ask someone “how are you?”
2. Tohiju?
Osiju?
Osiju nijadvhnadega? (We Are Learning Cherokee (Final))

3. What is your name?
4. I'd like you to meet
5. I want.  I see
6. Where are you from?
7. Do you speak Cherokee?
8. Cardinal Numbers
9. Ordinal Numbers
10. On the Telephone
11. Address and Email
12. Profession
13. Dates, Months, and Days of Week
14. Time
15. Body Parts
16. Emotions
17. 5 senses
18. prepositions
19. conjunctions
20. interjections
21. negation
22. are you hungry
23. Seasons
24. This and That
25. Family
26. To Have and Have Not
27. Describing Others
28. Directions
29. Weather
30. Money
31. Clothes and Shopping
32. Animals
33. Colors
34. Food
35. On the farm
36. Visiting Friends
37. Verb Conjugation
38. Yours, Mine, Ours
39. Questions
40. Pronouns
41. At the doctor
42. Around the House
43. At the beach
44. Transporation
45. Festivals and Celebrations
46. At the airport
47. Articles and Conversion
48. advanced Verb
49. Clitics
50. Grammar Summary
51. Charts
52. Shapes

Publication bibliography
CherokeeAndDakotaLanguageLetters.
We Are Learning Cherokee (Final).
*/

def builder = new MarkupBuilder()
def book = builder.book {
    chapter {
        product(name: 'bob')
    }
//    chapter(title: "Preface") {
//        section(title: "bob")
//    }
//    chapter(title: "Greetings") {
//        section(title:"bob2")
//    }
}

def writer = new StringWriter()
book.print(new PrintWriter(writer))

println writer