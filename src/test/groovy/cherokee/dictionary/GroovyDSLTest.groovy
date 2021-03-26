package cherokee.dictionary

def show = { println it }
def square_root = { Math.sqrt(it) }

def please(action) {
    [the: { what ->
        [of: { n -> action(what(n)) }]
    }]
}

please show the square_root of 100


