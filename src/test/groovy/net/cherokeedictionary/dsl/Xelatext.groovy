package net.cherokeedictionary.dsl



import groovy.xml.*

def writer = new StringWriter()
def html = new MarkupBuilder(writer)
html.html {
    head {
        title 'Simple document'
    }
    body(id: 'main') {
        h1 'Building HTML the Groovy Way'
        p {
            mkp.yield 'Mixing text with '
            strong 'bold'
            mkp.yield ' elements.'
        }
        a href: 'more.html', 'Read more...'
    }
}
println writer