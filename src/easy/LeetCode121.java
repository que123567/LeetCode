package easy;

/**
 * Best Time to Buy and Sell Stock
 * 
 * You are given an array prices where prices[i] is the price of a given stock on the ith day.
 * 
 * You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.
 * 
 * Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.
 * 
 *  
 * 
 * Example 1:
 * 
 * Input: prices = [7,1,5,3,6,4]
 * Output: 5
 * Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
 * Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.
 * Example 2:
 * 
 * Input: prices = [7,6,4,3,1]
 * Output: 0
 * Explanation: In this case, no transactions are done and the max profit = 0.
 *  
 * 
 * Constraints:
 * 
 * 1 <= prices.length <= 105
 * 0 <= prices[i] <= 104
 * 
 * 
 */
public class LeetCode121 {


    public static int maxProfit(int[] prices) {
        //最大利润
        int maxProfit = Integer.MIN_VALUE;
        //局部最低价
        int curMinPrice = Integer.MAX_VALUE;
        for (int price : prices) {
            if (price < curMinPrice) {
                curMinPrice = price;
            }
            if (maxProfit < price - curMinPrice) {
                maxProfit = price - curMinPrice;
            }
        }
        return maxProfit;
    }


    public static void main(String[] args) {
        int[] test_1 = new int[]{7, 1, 5, 3, 6, 4};
        int[] test_2 = new int[]{10, 2, 20, 1, 3};
        int res_1 = maxProfit(test_1);
        System.out.println(res_1);
    }
}
