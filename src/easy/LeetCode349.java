package easy;

import java.util.HashSet;
import java.util.Set;

/**
 * Given two arrays, write a function to compute their intersection.
 * <p>
 * Example:
 * Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2].
 * <p>
 * Note:
 * Each element in the result must be unique.
 * The result can be in any order.
 */
public class LeetCode349 {
    static class Solution {
        public static int[] intersection(int[] nums1, int[] nums2) {
            Set<Integer> set = new HashSet<>();
            Set<Integer> interSectionSet = new HashSet<>();
            for (int i = 0; i < nums1.length; i++) {
                set.add(nums1[i]);
            }
            for (int i = 0; i < nums2.length; i++) {
                if (set.contains(nums2[i]))
                    interSectionSet.add(nums2[i]);
            }
            int[] resNums = new int[interSectionSet.size()];
            int i = 0;
            for (Integer res : interSectionSet) {
                resNums[i++] = res;
            }
            return resNums;
        }
    }

    public static void main(String[] args) {
        int[] a = new int[]{1, 2, 3, 2, 3, 10};
        int[] b = new int[]{1, 2, 4, 10};
        System.out.println(Solution.intersection(a, b).length);

    }
}
