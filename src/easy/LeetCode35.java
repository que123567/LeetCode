package easy;

import java.util.Arrays;

/**
 * Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.
 * <p>
 * You may assume no duplicates in the array.
 * <p>
 * Example 1:
 * <p>
 * Input: [1,3,5,6], 5
 * Output: 2
 * Example 2:
 * <p>
 * Input: [1,3,5,6], 2
 * Output: 1
 * Example 3:
 * <p>
 * Input: [1,3,5,6], 7
 * Output: 4
 * Example 4:
 * <p>
 * Input: [1,3,5,6], 0
 * Output: 0
 */
public class LeetCode35 {
    public static int searchInsert_me(int[] nums, int target) {
        int res = Arrays.binarySearch(nums, target);
        return res < 0 ? -res - 1 : res;

    }

    public static int searchInsert(int[] A, int target) {
        int low = 0, high = A.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (A[mid] == target)
                return mid;
            else if (A[mid] > target)
                high = mid - 1;
            else
                low = mid + 1;
        }
        return low;
    }

    public static int binarySearch(int[] A, int target) {
        int low = 0, high = A.length - 1;
        while (low < high) {
            int mid = (low + high) / 2;

        }
        return 0;
    }


    public static void main(String[] args) {
        int[] nums_1 = new int[]{1, 3, 5, 6};
        System.out.println(searchInsert_me(nums_1, 5));
        System.out.println(searchInsert_me(nums_1, 2));
        System.out.println(searchInsert_me(nums_1, 7));
        System.out.println(searchInsert_me(nums_1, 0));
    }

}
