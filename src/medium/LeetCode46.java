package medium;

import java.util.ArrayList;
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
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        backTrack(lists, new ArrayList<>(), nums);
        return lists;
    }

    public static void backTrack(List<List<Integer>> lists, List<Integer> tmpList, int[] nums) {
        if (tmpList.size() == nums.length)
            lists.add(new ArrayList<>(tmpList));
        for (int num : nums) {
            if (tmpList.contains(num))
                continue;
            tmpList.add(num);
            backTrack(lists, tmpList, nums);
            tmpList.remove(tmpList.size() - 1);
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> res = permute(new int[]{1, 2, 3});
        for (List<Integer> list : res) {
            for (int i : list) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
