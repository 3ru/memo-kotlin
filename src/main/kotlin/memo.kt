import kotlin.random.Random

fun <T> Collection<T>.getRandom(n: Int): List<T> {
    require(n <= size) { "Argument $n must be smaller than receiver size $size" }

    val taken = mutableListOf<T>()
    val remaining = toMutableList()

    repeat(n) {
        val lastIndex = remaining.size - 1
        val index = Random.nextInt(lastIndex + 1)

        taken.add(remaining[index])
        remaining.removeAt(lastIndex).let { if (index < lastIndex) remaining[index] = it }
    }

    return taken
}
