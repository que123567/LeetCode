package easy;

/**
 * Given a binary array, find the maximum number of consecutive 1s in this array.
 * .
 * Example 1:
 * Input: [1,1,0,1,1,1]
 * Output: 3
 * Explanation: The first two digits or the last three digits are consecutive 1s.
 * The maximum number of consecutive 1s is 3.
 * Note:
 * .
 * The input array will only contain 0 and 1.
 * The length of input array is a positive integer and will not exceed 10,000
 */
public class LeetCode485 {
    static class Solution {
        public static int findMaxConsecutiveOnes(int[] nums) {
            int resCount = 0;//暂存
            int tmpCount = 0;//结果
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] != 0) {
                    tmpCount++;
                } else {
                    tmpCount = 0;
                }
                if (tmpCount > resCount)
                    resCount = tmpCount;
            }
            return resCount;
        }
    }

    public static void main(String[] args) {
        System.out.println(Solution.findMaxConsecutiveOnes(new int[]{1,0,1,1,1,0,1,1}));
    }
}
