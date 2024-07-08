package arrays;

public class BestTimeToBuyAndSellStock {

    public int maxProfit(int[] prices) {
        int maxProfit = 0;

        int minPrice = prices[0];

        for (int i = 1; i < prices.length; i++) {

            int price = prices[i] - minPrice;

            if (price > maxProfit) {
                maxProfit = price;
            }

            if (prices[i] < minPrice) {
                minPrice = prices[i];
            }
        }

        return maxProfit;
    }

    public int maxProfit2(int[] prices) {
        int maxProfit = 0;

        // 구매 시점 순회, 처음부터 끝까지 차례대로 반복한다.
        for (int i = 0; i < prices.length; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                maxProfit = Math.max(maxProfit, prices[j] - prices[i]);
            }
        }

        return maxProfit;
    }

    public int maxProfit3(int[] prices) {
        int maxProfit = 0;
        int minPrice = prices[0];

        // 현재 값을 우측으로 차례대로 이동하면서 계산
        for (int price : prices) {
            // 지금까지 지점 계산
            minPrice = Math.min(minPrice, price);

            // 현재 값과 지점의 차이가 최대 이익인 경우 교체
            maxProfit = Math.max(maxProfit, price - minPrice);
        }

        return maxProfit;
    }

    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};
        BestTimeToBuyAndSellStock problem = new BestTimeToBuyAndSellStock();
        System.out.println(problem.maxProfit3(prices));
    }
}
