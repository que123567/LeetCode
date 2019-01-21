package easy;

/**
 * 941. Valid Mountain Array
 * .
 * Given an array A of integers, return true if and only if it is a valid mountain array.
 * .
 * Recall that A is a mountain array if and only if:
 * .
 * A.length >= 3
 * There exists some i with 0 < i < A.length - 1 such that:
 * A[0] < A[1] < ... A[i-1] < A[i]
 * A[i] > A[i+1] > ... > A[B.length - 1]
 * .
 * .
 * Example 1:
 * .
 * Input: [2,1]
 * Output: false
 * Example 2:
 * .
 * Input: [3,5,5]
 * Output: false
 * Example 3:
 * .
 * Input: [0,3,2,1]
 * Output: true
 * .
 * .
 * Note:
 * .
 * 0 <= A.length <= 10000
 * 0 <= A[i] <= 10000
 */

public class LeetCode941 {

    public static void main(String[] args) {
        System.out.println(validMountainArray(new int[]{2, 1}));
        System.out.println(validMountainArray(new int[]{2, 3, 2}));
        System.out.println(validMountainArray(new int[]{3, 5, 5}));
        System.out.println(validMountainArray(new int[]{0, 3, 2, 1}));
    }

    /**
     * Two people climb from left and from right separately.
     * If they are climbing the same mountain,
     * they will meet at the same point.
     *
     * @param A
     * @return
     */
    public static boolean validMountainArray(int[] A) {
        int left = 0, right = A.length - 1;
        int boundary = A.length - 1;
        while (left < boundary && A[left] < A[left + 1]) {
            left++;
        }
        while (right > 0 && A[right - 1] > A[right]) {
            right--;
        }
        return left > 0 && left == right && right < boundary;
    }
}
