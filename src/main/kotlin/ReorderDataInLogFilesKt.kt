class ReorderDataInLogFilesKt {
    fun reorderLogFiles(logs: Array<String>): Array<String> {
        val digitList = ArrayList<String>()
        val letterList = ArrayList<String>()

        for (log in logs) {
            val str = log.split(" ", limit = 2)

            if (str[1][0].isDigit()) {
                digitList.add(log)
            } else {
                letterList.add(log)
            }
        }

        letterList.sortWith(compareBy({ it.split(" ", limit = 2)[1] }, { it.split(" ", limit = 2)[0] }))

        return (letterList + digitList).toTypedArray()
    }

}

fun main() {
    val o = ReorderDataInLogFilesKt()
    val logs = arrayOf("dig1 8 1 5 1", "let1 art can", "dig2 3 6", "let2 own kit dig", "let3 art zero")
    println(o.reorderLogFiles(logs).joinToString(" "))
}
