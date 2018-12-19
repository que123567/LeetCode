package medium;

import java.util.ArrayList;
import java.util.List;

/**
 * 90. Subsets II
 *
 * Given a collection of integers that might contain duplicates, nums, return all possible subsets (the power set).
 *
 * Note: The solution set must not contain duplicate subsets.
 *
 * Example:
 *
 * Input: [1,2,2]
 * Output:
 * [
 *   [2],
 *   [1],
 *   [1,2,2],
 *   [2,2],
 *   [1,2],
 *   []
 * ]
 */
public class LeetCode90 {

    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        backTrack(lists, new ArrayList<>(), nums, 0);
        return lists;
    }

    public static void backTrack(List<List<Integer>> lists, List<Integer> tmpList, int[] nums, int start) {
        lists.add(new ArrayList<>(tmpList));
        for (int i = start; i < nums.length; i++) {
            tmpList.add(nums[i]);
            backTrack(lists, tmpList, nums, i + 1);
            tmpList.remove(tmpList.size() - 1);
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> res = subsetsWithDup(new int[]{1, 2, 3});
        for (List<Integer> list : res) {
            for (int i : list) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
     }
}
