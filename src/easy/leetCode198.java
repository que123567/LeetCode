package easy;

/**
 * You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security system connected and it will automatically contact the police if two adjacent houses were broken into on the same night.
 * <p>
 * Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob tonight without alerting the police.
 * <p>
 * Credits:
 * Special thanks to @ifanchu for adding this problem and creating all test cases. Also thanks to @ts for adding additional test cases.
 */
//dynamic planning
public class leetCode198 {
    static class Solution {
        public static int rob(int[] nums) {
            int rob = 0; //max monney can get if rob current house
            int notrob = 0; //max money can get if not rob current house
            for (int i = 0; i < nums.length; i++) {
                int currob = notrob + nums[i]; //if rob current value, previous house must not be robbed
                notrob = Math.max(notrob, rob); //if not rob ith house, take the max value of robbed (i-1)th house and not rob (i-1)th house
                rob = currob;
            }
            return Math.max(rob, notrob);
        }

        public static void main(String[] args) {
            System.out.println(rob(new int[]{5, -3, 4, 2, 8}));
        }
    }
}
