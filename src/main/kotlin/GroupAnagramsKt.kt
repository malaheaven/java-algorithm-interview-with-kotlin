import java.util.*

class GroupAnagramsKt {
    fun groupAnagrams(strs: Array<String>): List<List<String>> {
        val map = mutableMapOf<String, List<String>>()

        strs.forEach {
            val sorted = it.toCharArray().sorted().joinToString("")

            if (map.containsKey(sorted)) {
                map[sorted] = map[sorted]!!.plus(it)

            } else {
                map[sorted] = mutableListOf(it)
            }
        }

        return map.values.toList()
    }
}

fun main() {
    val strs = arrayOf("eat", "tea", "tan", "ate", "nat", "bat")
    val g = GroupAnagramsKt()
    println(g.groupAnagrams(strs))
}
