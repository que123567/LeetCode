package easy;

/**
 * 896. Monotonic Array
 * .
 * An array is monotonic if it is either monotone increasing or monotone decreasing.
 * .
 * An array A is monotone increasing if for all i <= j, A[i] <= A[j].  An array A is monotone decreasing if for all i <= j, A[i] >= A[j].
 * .
 * Return true if and only if the given array A is monotonic.
 * .
 * .
 * .
 * Example 1:
 * .
 * Input: [1,2,2,3]
 * Output: true
 * Example 2:
 * .
 * Input: [6,5,4,4]
 * Output: true
 * Example 3:
 * .
 * Input: [1,3,2]
 * Output: false
 * Example 4:
 * .
 * Input: [1,2,4,5]
 * Output: true
 * Example 5:
 * .
 * Input: [1,1,1]
 * Output: true
 * .
 * .
 * Note:
 * .
 * 1 <= A.length <= 50000
 * -100000 <= A[i] <= 100000
 */
public class LeetCode896 {
    public static boolean isMonotonic(int[] A) {
        boolean dec = true, inc = true;
        for (int i = 1; i < A.length; i++) {
            inc &= A[i - 1] <= A[i];
            dec &= A[i - 1] >= A[i];
        }
        return inc || dec;
    }

    public static boolean isMonotonic_(int[] A) {
        boolean isDec = true, isInc = true;
        for (int i = 1; i < A.length; i++) {
            if (A[i] > A[i - 1]) {
                isDec = false;
            }
            if (A[i] < A[i - 1]) {
                isInc = false;
            }
        }
        return isDec || isInc;
    }

    public static void main(String[] args) {
        System.out.println(isMonotonic_(new int[]{1, 2, 3, 4, 5}));
        System.out.println(isMonotonic_(new int[]{1, 2, 2, 3}));
        System.out.println(isMonotonic_(new int[]{1, 2, 3, 1, 5}));

    }
}
