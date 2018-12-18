package medium;

import java.util.ArrayList;
import java.util.List;

/**
 * 442. Find All Duplicates in an Array
 * .
 * Given an array of integers, 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.
 * .
 * Find all the elements that appear twice in this array.
 * .
 * Could you do it without extra space and in O(n) runtime?
 * .
 * Example:
 * Input:
 * [4,3,2,7,8,2,3,1]
 * .
 * Output:
 * [2,3]
 */
public class LeetCode442 {
    /**
     * 根据条件1 ≤ a[i] ≤ n (n = size of array)可知,索引可利用起来
     *
     * @param nums
     * @return
     */
    public static List<Integer> findDuplicates(int[] nums) {
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]) - 1;

            if (nums[index] < 0) {
                list.add(Math.abs(nums[i]));
            }
            nums[index] = -nums[index];
        }
        return list;
    }

    public static void main(String[] args) {
        int[] a = new int[]{10, 2, 5, 10, 9, 1, 1, 4, 3, 7};
        List<Integer> res = findDuplicates(a);
        for (int i : res) {
            System.out.print(i + " ");
        }
    }
}
