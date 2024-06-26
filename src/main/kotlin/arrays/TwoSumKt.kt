package arrays

class TwoSumKt {
    fun twoSum(nums: IntArray, target: Int): IntArray? {
        val map = mutableMapOf<Int, Int>()

        for ((i, num) in nums.withIndex()) {
            if (map.containsKey(target - num)) {
                return intArrayOf(i, map.getValue(target - num))
            }

            map[num] = i
        }
        return null
    }

    fun twoSum2(nums: IntArray, target: Int): IntArray {
        val map = mutableMapOf<Int, Int>()

        for ((i, num) in nums.withIndex()) {
            if (map.containsKey(target - num)) {
                return intArrayOf(map.getValue(target - num) ?:0, i)
            }

            map[num] = i
        }
        return intArrayOf(0, 0)
    }
}

fun main() {
    val twoSum = TwoSumKt()
    val nums = intArrayOf(2, 7, 11, 15)
    val target = 9
    println(twoSum.twoSum2(nums, target).contentToString())
}
