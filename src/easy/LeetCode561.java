package easy;

import java.util.Arrays;

public class LeetCode561 {
    static class Solution {
        public static int arrayPairSum(int[] nums) {
            Arrays.sort(nums);
            int res = 0;
            for (int i = 0; i < nums.length; i += 2) {
                res += nums[i];
            }
            return res;
        }
    }


    public static void main(String[] args) {
        System.out.println(Solution.arrayPairSum(new int[]{1, 4, 3, 2}));
    }
}
