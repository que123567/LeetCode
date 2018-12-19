package medium;

import java.util.ArrayList;
import java.util.List;

/**
 * 78. Subsets
 * .
 * Given a set of distinct integers, nums, return all possible subsets (the power set).
 * .
 * Note: The solution set must not contain duplicate subsets.
 * .
 * Example:
 * .
 * Input: nums = [1,2,3]
 * Output:
 * [
 * [3],
 * [1],
 * [2],
 * [1,2,3],
 * [1,3],
 * [2,3],
 * [1,2],
 * []
 * ]
 */
public class LeetCode78 {

    /**
     * BackTrack version
     *
     * @param nums
     * @return
     */
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        backtrack(list, new ArrayList<>(), nums, 0);
        return list;
    }

    private static void backtrack(List<List<Integer>> list, List<Integer> tempList, int[] nums, int start) {
        list.add(new ArrayList<>(tempList));
        for (int i = start; i < nums.length; i++) {
            tempList.add(nums[i]);
            backtrack(list, tempList, nums, i + 1);
            System.out.println("now:" + tempList.size());
            tempList.remove(tempList.size() - 1);
        }
    }

    private void test(List<List<Integer>>list,List<Integer>tempList,int[]nums,int start) {
        list.add(new ArrayList<>(tempList));
        for (int i = start; i < nums.length; i++) {
            tempList.add(nums[i]);
            backtrack(list, tempList, nums, i + 1);
            tempList.remove(tempList.size() - 1);
        }
    }

    /**
     * Iterarion version
     * .
     * While iterating through all numbers, for each new number, we can either pick it or not pick it
     * 1, if pick, just add current number to every existing subset.
     * 2, if not pick, just leave all existing subsets as they are.
     * We just combine both into our result.
     * .
     * For example, {1,2,3} intially we have an emtpy set as result [ [ ] ]
     * Considering 1, if not use it, still [ ], if use 1, add it to [ ], so we have [1] now
     * Combine them, now we have [ [ ], [1] ] as all possible subset
     * /
     * Next considering 2, if not use it, we still have [ [ ], [1] ], if use 2, just add 2 to each previous subset, we have [2], [1,2]
     * Combine them, now we have [ [ ], [1], [2], [1,2] ]
     * .
     * Next considering 3, if not use it, we still have [ [ ], [1], [2], [1,2] ], if use 3, just add 3 to each previous subset, we have [ [3], [1,3], [2,3], [1,2,3] ]
     * Combine them, now we have [ [ ], [1], [2], [1,2], [3], [1,3], [2,3], [1,2,3] ]
     */
    static class Solution_2 {
        public static List<List<Integer>> subsets(int[] nums) {
            List<List<Integer>> res = new ArrayList<>();
            res.add(new ArrayList<>());
            for (int n : nums) {
                int size = res.size();
                for (int i = 0; i < size; i++) {
                    List<Integer> subSet = new ArrayList<>(res.get(i));
                    subSet.add(n);
                    res.add(subSet);
                }
            }
            return res;
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> res = subsets(new int[]{1, 2, 3});
        for (List<Integer> list : res) {
            for (int i : list) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
