package medium;

import java.util.Arrays;

/**
 * 322. Coin Change
 * .
 * You are given coins of different denominations and a total amount of money amount. Write a function to compute the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.
 * .
 * Example 1:
 * .
 * Input: coins = [1, 2, 5], amount = 11
 * Output: 3
 * Explanation: 11 = 5 + 5 + 1
 * Example 2:
 * .
 * Input: coins = [2], amount = 3
 * Output: -1
 * Note:
 * You may assume that you have an infinite number of each kind of coin.
 */
public class LeetCode322 {

    /**
     * version_1
     */
//    static class Solution {
//        public static int coinChange(int[] coins, int amount) {
//            if (amount == 0)
//                return 0;
//            int n = amount + 1;
//            for (int coin : coins) {
//                int curr = 0;
//                if (coin <= amount) {
//                    int next = coinChange(coins, amount - coin);
//                    if (next >= 0)
//                        curr = 1 + next;
//                }
//                if (curr > 0)
//                    n = Math.min(n, curr);
//            }
//            int finalCount = (n == amount + 1) ? -1 : n;
//            return finalCount;
//        }
//    }
//
//    static class Solution2 {
//            public static int coinChange(int[] coins, int amount) {
//                int[] dp = new int[amount + 1];
//                Arrays.fill(dp, Integer.MAX_VALUE);
//                dp[0] = 0;
//                for (int i = 0; i < coins.length; i++) {
//                    for (int j = 0; j <= amount; j++) {
//                        int pre = j - coins[i];
//                        if (pre >= 0 && dp[pre] < Integer.MAX_VALUE) {
//                            dp[j] = Math.min(dp[j], dp[pre] + 1);
//                        }
//                    }
//                }
//                if (dp[amount] == Integer.MAX_VALUE) {
//                    return -1;
//                }
//                return dp[amount];
//            }
//    }

    public static void main(String[] args) {
//        Solution2.coinChange(new int[]{1, 2, 5}, 11);
    }
}
