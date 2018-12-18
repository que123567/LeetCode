package easy;

/**
 * 922. Sort Array By Parity II
 * .
 * Given an array A of non-negative integers, half of the integers in A are odd, and half of the integers are even.
 * .
 * Sort the array so that whenever A[i] is odd, i is odd; and whenever A[i] is even, i is even.
 * .
 * You may return any answer array that satisfies this condition.
 * .
 * .
 * .
 * Example 1:
 * .
 * Input: [4,2,5,7]
 * Output: [4,5,2,7]
 * Explanation: [4,7,2,5], [2,5,4,7], [2,7,4,5] would also have been accepted.
 * .
 * .
 * Note:
 * .
 * 2 <= A.length <= 20000
 * A.length % 2 == 0
 * 0 <= A[i] <= 1000
 */
public class LeetCode922 {

    public static int[] sortArrayByParityII(int[] A) {

        return new int[]{1};
    }

    /**
     * @param A
     * @return
     */
    public int[] sortArrayByParityII_(int[] A) {
        int i = 0, j = 1, n = A.length;
        while (i < n && j < n) {
            //偶
            while (i < n && A[i] % 2 == 0) {
                i += 2;
            }
            //奇
            while (j < n && A[j] % 2 == 1) {
                j += 2;
            }
            if (i < n && j < n) {
                swap(A, i, j);
            }
        }
        return A;
    }

    public static int[] sortArrayByParityII_2(int[] A) {
        int i = 0, j = 1;
        while (i < A.length && j < A.length) {
            if (A[i] % 2 == 0 && i < A.length) {
                i += 2;
            }
            if (A[j] % 2 == 1 && j < A.length) {
                j += 2;
            }
            swap(A, i, j);
        }
        return A;
    }

    private static void swap(int[] A, int i, int j) {
        if (i >= A.length || j >= A.length) {
            return;
        }
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }


    public  static int[] sortArrayByParityII_3(int[] A) {
        for (int i = 0, j = 1; i < A.length; i += 2) {
            while (j < A.length && A[j] % 2 == 1) { j += 2; }
            if (A[i] % 2 == 1) {
                int t = A[i];
                A[i] = A[j];
                A[j] = t;
                j += 2;
            }
        }
        return A;
    }

    public static void main(String[] args) {
        int[] res = sortArrayByParityII_2(new int[]{4, 2, 5, 7});
        for (int i = 0; i < res.length; i++) {
            System.out.println(res[i]);
        }
    }
}
