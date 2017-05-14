package pl.edu.pwr.wojciech.okonski.lab2.lab2.model

import java.util.*
import kotlin.collections.ArrayList

class Movie(val title: String, val genre: MovieGenre, val year: String,
            val description: String = loremIpsum, seen: Boolean = false) {
    val actors = actorBase.takeRandomly(3)

    var seen = seen
        private set

    fun changeSeen() {
        seen = !seen
    }
}

val loremIpsum = "Lorem ipsum dolor sit amet enim. Etiam ullamcorper. Suspendisse a pellentesque dui, non felis. Maecenas malesuada elit lectus felis, malesuada ultricies."

val actorBase = listOf(
        Actor("Paweł Kukiz"),
        Actor("Mateusz Kijowski"),
        Actor("Jarosław Kaczyński"),
        Actor("Donald Tusk"),
        Actor("Ryszard Petru"),
        Actor("Janusz Palikot")
)

fun <T> Collection<T>.takeRandomly(n: Int): List<T> {
    require(n <= size, { "collection has only $size elements" })
    val mutableList = this.toMutableList()
    val resultList: ArrayList<T> = ArrayList()
    val randomGenerator = Random()
    for (i in 0..n) {
        val index = randomGenerator.nextInt(mutableList.size)
        resultList.add(mutableList[index])
        mutableList.removeAt(index)
    }
    return resultList
}