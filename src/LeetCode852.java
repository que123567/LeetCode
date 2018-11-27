import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 852. Peak Index in a Mountain Array
 * <p>
 * Let's call an array A a mountain if the following properties hold:
 * <p>
 * A.length >= 3
 * There exists some 0 < i < A.length - 1 such that A[0] < A[1] < ... A[i-1] < A[i] > A[i+1] > ... > A[A.length - 1]
 * Given an array that is definitely a mountain, return any i such that A[0] < A[1] < ... A[i-1] < A[i] > A[i+1] > ... > A[A.length - 1].
 * <p>
 * Example 1:
 * <p>
 * Input: [0,1,0]
 * Output: 1
 * Example 2:
 * <p>
 * Input: [0,2,1,0]
 * Output: 1
 * Note:
 * <p>
 * 3 <= A.length <= 10000
 * 0 <= A[i] <= 10^6
 * A is a mountain, as defined above.
 */
public class LeetCode852 {
    /**
     * ....
     * O(N)
     *
     * @param A
     * @return
     */
    public static int peakIndexInMountainArray(int[] A) {
        int[] B = new int[A.length];
        for (int i = 0; i < B.length; i++) {
            B[i] = A[i];
        }
        Arrays.sort(B);
        int res = 0;
        for (int i = 0; i < B.length; i++) {
            if (A[i] == B[B.length - 1]) {
                res = i;
            }
        }
        return res;
    }

    /**
     * O(N)
     *
     * @param A
     * @return
     */
    public static int peakIndexInMountainArray_2(int[] A) {
        Map<Integer, Integer> indexMap = new HashMap<>();
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < A.length; i++) {
            indexMap.put(A[i], i);
            if (max < A[i]) {
                max = A[i];
            }
        }
        return indexMap.get(max);
    }

    /**
     * @param A
     * @return
     */
    public static int peakIndexInMountainArray_3(int[] A) {
        for (int i = 1; i + 1 < A.length; ++i)
            if (A[i] > A[i + 1])
                return i;
        return 0;
    }

    /**
     * @param A
     * @return
     */
    public static int peakIndexInMountainArray_4(int[] A) {
        int lo = 0;
        int hi = A.length - 1;
        while (lo < hi) {
            int mid = (lo + hi) / 2;
            if (A[mid] < A[mid + 1]) { lo = mid + 1; }
            else { hi = mid; }
        }
        return lo;
    }

    public static void main(String[] args) {
        System.out.println(peakIndexInMountainArray_4(new int[]{0, 1, 0}));
        System.out.println(peakIndexInMountainArray_4(new int[]{0, 2, 1, 0}));
    }
}
