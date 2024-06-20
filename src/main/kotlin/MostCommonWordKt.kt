class MostCommonWordKt {
    fun mostCommonWord(paragraph: String, banned: Array<String>): String? {
        val words = paragraph.split("[\\s,]+".toRegex())

        val map = mutableMapOf<String, Int>()

        for (word in words) {
            val lowerCase = word.lowercase().replace("[^a-z]".toRegex(), "")

            if (lowerCase.isEmpty()) continue
            map[lowerCase] = map.getOrDefault(lowerCase, 1) + 1

        }

        for (word in banned) {
            map.remove(word.lowercase())
        }

//        var mostCommon: String? = null
//        var maxCount = 0
//        for ((key, value) in map) {
//            if (value > maxCount) {
//                mostCommon = key
//                maxCount = value
//            }
//        }
//
//        return mostCommon

        return map.maxByOrNull { it.value }!!.key
    }
}

fun main() {
    val paragraph = "Bob. hIt, baLl"
    val banned = arrayOf("bob", "hit")

    val mostCommonWord = MostCommonWordKt()
    println(mostCommonWord.mostCommonWord(paragraph, banned))
}
