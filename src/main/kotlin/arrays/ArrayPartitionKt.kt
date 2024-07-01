package arrays

class ArrayPartitionKt {
    fun arrayPairSum(nums: IntArray): Int {
        var res = 0

        nums.sort()

        for (i in nums.indices) {
            if (i % 2 == 0)
                res += nums[i]
        }
        return res
    }

    fun arrayPairSum2(nums: IntArray): Int {
        var sum = 0

        nums.sort()

        for ((i, n) in nums.withIndex()) {
            if (i % 2 == 0)
                sum += n
        }
        return sum
    }
}

fun main() {
    val nums = intArrayOf(6, 2, 6, 5, 1, 2)
    val array = ArrayPartitionKt()
    println(array.arrayPairSum(nums))
}
