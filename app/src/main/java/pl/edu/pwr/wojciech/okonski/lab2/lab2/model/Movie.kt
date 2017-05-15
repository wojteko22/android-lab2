package pl.edu.pwr.wojciech.okonski.lab2.lab2.model

import pl.edu.pwr.wojciech.okonski.lab2.lab2.R
import java.util.*
import kotlin.collections.ArrayList

class Movie(val title: String, val genre: MovieGenre, val year: String, seen: Boolean = false) {
    val actors = actorBase.takeRandomly(3)
    val descriptionResource: Int = descriptionBase.takeRandomly(1)[0]
    val images = imagesBase.takeRandomly(6)

    var seen = seen
        private set

    fun changeSeen() {
        seen = !seen
    }
}

val actorBase = listOf(
        Actor("Paweł Kukiz", R.drawable.kukiz),
        Actor("Jarosław Kaczyński", R.drawable.kaczy),
        Actor("Donald Tusk", R.drawable.tusk),
        Actor("Ryszard Petru", R.drawable.petru),
        Actor("Janusz Palikot", R.drawable.palikot)
)

val imagesBase = listOf(
        R.drawable.a,
        R.drawable.b,
        R.drawable.c,
        R.drawable.d,
        R.drawable.e,
        R.drawable.f,
        R.drawable.g,
        R.drawable.h,
        R.drawable.i
)

val descriptionBase = listOf(R.string.description1, R.string.description2, R.string.description3)

fun <T> Collection<T>.takeRandomly(n: Int): List<T> {
    require(n <= size, { "collection has only $size elements" })
    val mutableList = this.toMutableList()
    val resultList: ArrayList<T> = ArrayList()
    val randomGenerator = Random()
    for (i in 0 until n) {
        val index = randomGenerator.nextInt(mutableList.size)
        resultList.add(mutableList[index])
        mutableList.removeAt(index)
    }
    return resultList
}