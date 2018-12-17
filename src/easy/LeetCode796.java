package easy;

/**
 * We are given two strings, A and B.
 * <p>
 * A shift on A consists of taking string A and moving the leftmost character to the rightmost position. For example, if A = 'abcde', then it will be 'bcdea' after one shift on A. Return True if and only if A can become B after some number of shifts on A.
 * <p>
 * Example 1:
 * Input: A = 'abcde', B = 'cdeab'
 * Output: true
 * <p>
 * Example 2:
 * Input: A = 'abcde', B = 'abced'
 * Output: false
 */
public class LeetCode796 {
    /**
     * @param A
     * @param B
     * @return
     */
    public static boolean rotateString(String A, String B) {
        return A.length() == B.length() && (A + A).contains(B);
    }

    /**
     * @param A
     * @param B
     * @return
     */
    public static boolean rorateString_(String A, String B) {
        if (A == null || B == null || A.length() != B.length())
            return false;
        if (A.length() == 0)
            return true;

        char start = A.charAt(0);

        for (int i = 0; i < B.length(); i++) {

            int j = i;
            while (j < B.length() && B.charAt(j) != start)
                j++;

            if (j >= B.length())
                return false;

            for (int n = 0; n < B.length(); n++) {
                if (A.charAt(n) != B.charAt((n + j) % B.length()))
                    break;
                if (n == B.length() - 1)
                    return true;
            }
            i = j;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(rorateString_("abcde", "cdeab"));
    }
}
