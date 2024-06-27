package arrays

class TrappingRainWaterKt {
    fun trap(height: IntArray): Int {
        val stack = ArrayDeque<Int>()

        var water = 0

        for (i in height.indices) {

            while(!stack.isEmpty() && height[i] > height[stack.last()]) {
                val top = stack.removeLast()
                if(stack.isEmpty()) {
                    break
                }

                val distance = i - stack.last() - 1
                val waters = height[i].coerceAtMost(height[stack.last()]) - height[top]
                water += distance * waters
            }
            stack.add(i)
        }

        return water
    }

}

fun main() {
    val height = intArrayOf(4, 2, 0, 3, 2, 5)
    val trappingRainWaterKt = TrappingRainWaterKt()
    println(trappingRainWaterKt.trap(height))
}
