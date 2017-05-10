package pl.edu.pwr.wojciech.okonski.lab2.lab2

class Movie(val title: String, val genre: MovieGenre, val year: String,
            val description: String = loremIpsum, seen: Boolean = false) {
    var seen = seen
        private set

    fun changeSeen() {
        seen = !seen
    }
}

val loremIpsum = "Lorem ipsum dolor sit amet enim. Etiam ullamcorper. Suspendisse a pellentesque dui, non felis. Maecenas malesuada elit lectus felis, malesuada ultricies."