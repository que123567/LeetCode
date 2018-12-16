import java.util.ArrayList;
import java.util.List;

/**
 * 491. Increasing Subsequences
 * <p>
 * Given an integer array, your task is to find all the different possible increasing subsequences of the given array, and the length of an increasing subsequence should be at least 2 .
 * <p>
 * Example:
 * <p>
 * Input: [4, 6, 7, 7]
 * Output: [[4, 6], [4, 7], [4, 6, 7], [4, 6, 7, 7], [6, 7], [6, 7, 7], [7,7], [4,7,7]]
 * Note:
 * <p>
 * The length of the given array will not exceed 15.
 * The range of integer in the given array is [-100,100].
 * The given array may contain duplicates, and two equal integers should also be considered as a special case of increasing sequence.
 */
public class LeetCode491 {
    public static List<List<Integer>> findSubsequences(int[] nums) {
        return null;

    }

    public static int[] splitInt(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= nums.length - 2; i++) {

        }
        return null;


    }

    public static boolean checkIncrasing(int[] res) {
        if (res.length == 1) {
            return false;
        }
        boolean increase = true;
        for (int i = 1; i < res.length; i++) {
            if (res[i] < res[i - 1]) {
                increase = false;
            }
        }
        return increase;
    }

    public static void main(String[] args) {

    }
}
