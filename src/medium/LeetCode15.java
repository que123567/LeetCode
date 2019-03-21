package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 15. 3Sum
 * .
 * Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.
 * .
 * Note:
 * .
 * The solution set must not contain duplicate triplets.
 * .
 * Example:
 * .
 * Given array nums = [-1, 0, 1, 2, -1, -4],
 * .
 * A solution set is:
 * [
 * [-1, 0, 1],
 * [-1, -1, 2]
 * ]
 */
public class LeetCode15 {
    /**
     * The idea is to sort an input array and then run through all indices of a possible first element of a triplet.
     * For each possible first element we make a standard bi-directional 2Sum sweep of the remaining part of the array.
     * Also we want to skip equal elements to avoid duplicates in the answer without making a set or smth like that.
     *
     * @param nums
     * @return
     */

    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int lo = i + 1, hi = nums.length - 1, target = -nums[i];
            while (lo < hi) {
                if (nums[lo] + nums[hi] == target) {
                    res.add(Arrays.asList(nums[i], nums[lo], nums[hi]));
                    lo++;
                    hi--;
                    //skip same result
                    while (lo < hi && nums[lo] == nums[lo - 1])
                        lo++;
                    while (lo < hi && nums[hi] == nums[hi + 1])
                        hi--;
                } else if (nums[lo] + nums[hi] < target) {
                    lo++;
                } else {
                    hi--;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        List<List<Integer>> res = threeSum(new int[]{-2, 0, 1, 1, 2});
        for (List<Integer> list : res) {
            for (int i : list) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}