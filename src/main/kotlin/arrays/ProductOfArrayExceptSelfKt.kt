package arrays

class ProductOfArrayExceptSelfKt {
    fun productExceptSelf(nums: IntArray): IntArray {
        val result = IntArray(nums.size)

        var num = 1;
        for (i in nums.indices) {
            result[i] = num
            num *= nums[i]
        }

        num = 1
        for (i in nums.indices.reversed()) {
            result[i] *= num
            num *= nums[i]
        }

        return result
    }
}

fun main() {
    val nums = intArrayOf(1, 2, 3, 4)
    val productOfArrayExceptSelf = ProductOfArrayExceptSelfKt()
    println(productOfArrayExceptSelf.productExceptSelf(nums).contentToString())
}
