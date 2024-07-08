package arrays

class BestTimeToBuyAndSellStockKt {
    fun maxProfit(prices: IntArray): Int {
        var maxProfit = 0

        // 임시로 첫 번째 값을 지점으로 지정
        var minPrice = prices[0]

        for (price in prices) {

            // 지금까지 저점 계산
            minPrice = minPrice.coerceAtMost(price)

            // 현재 값과 저점의 차이가 최대 이익인 경우 교체
            maxProfit = maxProfit.coerceAtLeast(price - minPrice)
        }

        return maxProfit
    }
}

fun main() {
    val prices = intArrayOf(7, 1, 5, 3, 6, 4)
    val problem = BestTimeToBuyAndSellStockKt()
    println(problem.maxProfit(prices))
}
