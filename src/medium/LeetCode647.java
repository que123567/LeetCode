package medium;

/**
 * 647. Palindromic Substrings
 * .
 * Given a string, your task is to count how many palindromic substrings in this string.
 * .
 * The substrings with different start indexes or end indexes are counted as different substrings even they consist of same characters.
 * .
 * Example 1:
 * Input: "abc"
 * Output: 3
 * Explanation: Three palindromic strings: "a", "b", "c".
 * Example 2:
 * Input: "aaa"
 * Output: 6
 * Explanation: Six palindromic strings: "a", "a", "a", "aa", "aa", "aaa".
 * Note:
 * The input string length won't exceed 1000.
 */
public class LeetCode647 {

    public static int count = 0;

    /**
     * recursion
     *
     * @param s
     * @return
     */
    public static int countSubstrings(String s) {
        if (s.length() == 0) {
            return 0;
        }
        for (int i = 0; i < s.length(); i++) {
            checkPalindrome(i, i, s);//odd
            checkPalindrome(i, i + 1, s);//even
        }
        return count;
    }

    public static void checkPalindrome(int L, int R, String s) {
        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            count++;
            L--;
            R++;
        }
    }

    /**
     * @param s
     * @return
     */
    public static int countSubstrings_(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        int res = 0;

        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j >= 0; j--) {
                dp[i][j] = (s.charAt(i) == s.charAt(j)) && ((i - j < 3) || dp[i - 1][j + 1]);
                if (dp[i][j]) {
                    res++;
                }
            }
        }
        return res;
    }

    /**
     * @param s
     * @return
     */
    public static int countSubStringS_2(String s) {
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(countSubstrings_("aaa"));
        System.out.println(countSubstrings_("abc"));
    }
}
