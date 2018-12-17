package easy;

import java.util.Arrays;

/**
 * Given a non-empty integer array of size n, find the minimum number of moves required to make all array elements equal,
 * where a move is incrementing n - 1 elements by 1.
 * <p>
 * Example:
 * <p>
 * Input:
 * [1,2,3]
 * <p>
 * Output:
 * 3
 * <p>
 * Explanation:
 * Only three moves are needed (remember each move increments two elements):
 * <p>
 * [1,2,3]  =>  [2,3,3]  =>  [3,4,3]  =>  [4,4,4]
 */

public class LeetCode453 {
    public static void main(String[] args) {
        System.out.println(Solution.minMoves(new int[]{1, 2, 3}));

    }

    static class Solution {//wrong answer
        public static int minMoves(int[] nums) {
            int maxVal = 0;
            int totalVal = 0;
            Arrays.sort(nums);
            maxVal = nums[nums.length - 1];//存最大值
            for (int i = 0; i < nums.length; i++) {
                totalVal += nums[i];
            }
            return (((maxVal+1) * nums.length - totalVal) / 2);
        }
    }
}
