package medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 46.Permutations
 * .
 * Given a collection of distinct integers, return all possible permutations.
 * .
 * Example:
 * .
 * Input: [1,2,3]
 * Output:
 * [
 * [1,2,3],
 * [1,3,2],
 * [2,1,3],
 * [2,3,1],
 * [3,1,2],
 * [3,2,1]
 * ]
 */
public class LeetCode46 {

    static class Solution1 {
        List<List<Integer>> res = new ArrayList<>();

        public List<List<Integer>> permute(int[] nums) {
            backTrack(new LinkedList<>(), nums);
            return res;
        }

        private void backTrack(LinkedList<Integer> trackList, int[] nums) {
            if (trackList.size() == nums.length) {
                res.add(new ArrayList<>(trackList));
            } else {
                for (int num : nums) {
                    if (trackList.contains(num)) {
                        continue;
                    }
                    trackList.add(num);
                    backTrack(trackList, nums);
                    trackList.removeLast();
                }
            }
        }
    }

    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();
        List<List<Integer>> res = solution1.permute(new int[]{1, 2, 3});
        for (List<Integer> list : res) {
            for (int i : list) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
