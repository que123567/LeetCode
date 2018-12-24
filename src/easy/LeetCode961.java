package easy;

/**
 * 961. N-Repeated Element in Size 2N Array
 * .
 * In a array A of size 2N, there are N+1 unique elements, and exactly one of these elements is repeated N times.
 * .
 * Return the element repeated N times.
 * .
 * .
 * .
 * Example 1:
 * .
 * Input: [1,2,3,3]
 * Output: 3
 * Example 2:
 * .
 * Input: [2,1,2,5,3,2]
 * Output: 2
 * Example 3:
 * .
 * Input: [5,1,5,2,5,3,5,4]
 * Output: 5
 * .
 * .
 * Note:
 * .
 * 4 <= A.length <= 10000
 * 0 <= A[i] < 10000
 * A.length is even
 */
public class LeetCode961 {

    /**
     * 数组统计
     *
     * @param A
     * @return
     */
    public static int repeatedNTimes(int[] A) {
        int[] map = new int[10001];
        for (int i : A) {
            if (++map[i] > 1) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 随机数
     *
     * @param A
     * @return
     */
    public static int repeatedNTimes_(int[] A) {
        int i = 0;
        int j = 0;
        int length = A.length;
        while (i == j || A[i] != A[j]) {
            i = (int) (Math.random() * length);
            j = (int) (Math.random() * length);
        }
        return A[i];
    }

    public static void main(String[] args) {
        System.out.println(repeatedNTimes_(new int[]{1, 2, 3, 3}));

    }
}
