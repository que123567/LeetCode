package medium;

import java.util.ArrayList;
import java.util.List;

/**
 * 40. Combination Sum II
 * .
 * Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates where the candidate numbers sums to target.
 * .
 * Each number in candidates may only be used once in the combination.
 * .
 * Note:
 * .
 * All numbers (including target) will be positive integers.
 * The solution set must not contain duplicate combinations.
 * Example 1:
 * .
 * Input: candidates = [10,1,2,7,6,1,5], target = 8,
 * A solution set is:
 * [
 * [1, 7],
 * [1, 2, 5],
 * [2, 6],
 * [1, 1, 6]
 * ]
 * Example 2:
 * .
 * Input: candidates = [2,5,2,1,2], target = 5,
 * A solution set is:
 * [
 * [1,2,2],
 * [5]
 * ]
 */
public class LeetCode40 {
    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> lists = new ArrayList<>();
        backTrack(lists, new ArrayList<>(), candidates, target, 0);
        return lists;
    }

    public static void backTrack(List<List<Integer>> lists, List<Integer> tempList, int[] nums, int remain, int start) {
        if (remain < 0) {

        } else if (remain == 0) {
            lists.add(new ArrayList<>(tempList));
        } else {
            for (int i = start; i < nums.length; i++) {
                if (i != start && nums[i - 1] == nums[i]) {
                    continue;
                }
                tempList.add(nums[i]);
                backTrack(lists, tempList, nums, remain - nums[i], i);
                tempList.remove(tempList.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> res = combinationSum2(new int[]{2,5,2,1,2}, 5);
        for (List<Integer> list : res) {
            for (int i : list) {
                System.out.print(i + " ");
            }
            System.out.println();
        }

    }
}
