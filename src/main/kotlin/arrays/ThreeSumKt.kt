package arrays

class ThreeSumKt {
    fun threeSum(nums: IntArray): List<List<Int>> {
        var left: Int
        var right: Int
        var sum: Int

        val result: MutableList<List<Int>> = mutableListOf()

        nums.sort()

        for (i in 0 until nums.size - 2) {

            // 중복된 값 건너뛰기
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue
            }

            left = i + 1
            right = nums.size - 1

            while (left < right) {
                sum = nums[i] + nums[left] + nums[right]

                if (sum < 0) {
                    left++
                } else if (sum > 0) {
                    right--
                } else {
                    result.add(listOf(nums[i], nums[left], nums[right]))

                    while (left < right && nums[left] == nums[left + 1]) {
                        left++
                    }
                    while (right < right && nums[right] == nums[right + 1]) {
                        right++
                    }
                    left++
                    right--
                }
            }
        }
        return result
    }
}

fun main() {
    val nums = intArrayOf(-1, 0, 1, 2, -1, -4)
    val threeSum = ThreeSumKt()
    println(threeSum.threeSum(nums))
}
