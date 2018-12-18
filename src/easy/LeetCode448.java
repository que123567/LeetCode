package easy;

import java.util.ArrayList;
import java.util.List;

/**
 * Calculate the sum of two integers a and b, but you are not allowed to use the operator + and -.
 * .
 * Example:
 * Given a = 1 and b = 2, return 3.
 * .
 * Credits:
 * Special thanks to @fujiaozhu for adding this problem and creating all test cases.
 */
//把nums的值作为索引，将nums[nums[i]-1]置为负。之后遍历一边，正数即是未遍历(出现)过的.
public class LeetCode448 {
    static class Solution {
        public static List<Integer> findDisappearedNumbers(int[] nums) {
            List<Integer> resList = new ArrayList<>();
            for (int i = 0; i < nums.length; i++) {
                System.out.println(nums[i]);
                int val = Math.abs(nums[i]) - 1;//
                if (nums[val] > 0) {
                    nums[val] = -nums[val];
                }
            }
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] > 0)
                    resList.add(i + 1);
            }
            return resList;
        }


    }

    public static void main(String[] args) {
        System.out.println(Solution.findDisappearedNumbers(new int[]{4, 3, 2, 7, 8, 3, 1,9,1}));
    }
}
