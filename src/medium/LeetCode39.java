package medium;

import java.util.ArrayList;
import java.util.List;

/**
 * 39. Combination Sum
 * .
 * Given a set of candidate numbers (candidates) (without duplicates) and a target number (target), find all unique combinations in candidates where the candidate numbers sums to target.
 * .
 * The same repeated number may be chosen from candidates unlimited number of times.
 * .
 * Note:
 * .
 * All numbers (including target) will be positive integers.
 * The solution set must not contain duplicate combinations.
 * Example 1:
 * .
 * Input: candidates = [2,3,6,7], target = 7,
 * A solution set is:
 * [
 * [7],
 * [2,2,3]
 * ]
 * Example 2:
 * .
 * Input: candidates = [2,3,5], target = 8,
 * A solution set is:
 * [
 * [2,2,2,2],
 * [2,3,3],
 * [3,5]
 * ]
 */
public class LeetCode39 {
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
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
                backTrack(lists, tempList, nums, remain - nums[i], i);//not i + 1 because we can reuse same elements
                tempList.remove(tempList.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> res = combinationSum(new int[]{2, 3, 6, 7}, 7);
        for (List<Integer> list : res) {
            for (int i : list) {
                System.out.print(i + " ");
            }
            System.out.println();
        }

    }
}
