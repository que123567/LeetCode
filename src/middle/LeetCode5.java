package middle;

/**
 * 5. Longest Palindromic Substring
 * <p>
 * Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.
 * <p>
 * Example 1:
 * <p>
 * Input: "babad"
 * Output: "bab"
 * Note: "aba" is also a valid answer.
 * Example 2:
 * <p>
 * Input: "cbbd"
 * Output: "bb"
 */
public class LeetCode5 {
    /**
     * 暴力破解法T(N³)
     */
    static class Solution_1 {
        public static boolean isPalindromic(String s) {
            int len = s.length();
            for (int i = 0; i < len / 2; i++) {
                if (s.charAt(i) != s.charAt(len - i - 1)) {
                    return false;
                }
            }
            return true;
        }

        public static String longestPalindrome(String s) {
            int max = Integer.MIN_VALUE;
            String res = "";
            for (int i = 0; i < s.length(); i++) {
                //此处subString前闭后开,所以j<=s.length要加等号
                for (int j = i + 1; j <= s.length(); j++) {
                    String str = s.substring(i, j);
                    if (isPalindromic(str) && str.length() > max) {
                        res = s.substring(i, j);
                        max = Math.max((res.length()), max);
                    }
                }
            }
            return res;
        }
    }

    /**
     * LCS解法
     */
    static class Soluton_2 {

    }

    /**
     * 暴力破解改良T(N²),S(N²)
     */
    static class Solution_3 {
        public static String longestPalindrome(String s) {
            String res = "";
            int maxLength = 0;
            int length = s.length();
            boolean[][] P = new boolean[length][length];
            //expanding length
            for (int expandLen = 1; expandLen <= length; expandLen++) {
                for (int start = 0; start < length; start++) {
                    //the index of start position
                    int end = start + expandLen - 1;
                    if (end >= length) {
                        break;
                    }
                    P[start][end] = (expandLen == 1 || expandLen == 2 || P[start + 1][end - 1]) && s.charAt(start) == s.charAt(end);
                    if (P[start][end] && expandLen > maxLength) {
                        maxLength = expandLen;
                        res = s.substring(start, end + 1);
                    }
                }
            }
            return res;
        }
    }

    /**
     * 中心拓展法T(N²) S(N)
     */
    static class Solution_4 {
        public static String longestPalindrome(String s) {
            if (s == null || s.length() == 1 || s.trim().equals("")) {
                return s;
            }
            int start = 0, end = 0;
            for (int i = 0; i < s.length(); i++) {
                //中心可选的有两种,一种是字符,另一种是两个字符之间的空隙.
                int lengthOdd = getMaxLength(s, i, i);
                int lengthEven = getMaxLength(s, i, i + 1);
                int len = Math.max(lengthEven, lengthOdd);
                if (len > end - start) {
                    start = i - (len - 1) / 2;
                    end = i + len / 2;
                }
            }
            return s.substring(start, end + 1);
        }

        /**
         * 获取给定字符串的最大回文长度
         *
         * @param s
         * @return
         */
        private static int getMaxLength(String s, int left, int right) {
            int L = left, R = right;
            while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
                L--;
                R++;
            }
            return R - L - 1;
        }
    }

    /**
     * Manacher算法(略)
     */
    static class Solution_5 {

        public static String preProcess(String s) {
            int n = s.length();
            if (n == 0) {
                return "^$";
            }
            String ret = "^";
            for (int i = 0; i < n; i++)
                ret += "#" + s.charAt(i);
            ret += "#$";
            return ret;
        }

        public static String longestPalindrome(String s) {
            String T = preProcess(s);
            int n = T.length();
            int[] P = new int[n];
            int C = 0, R = 0;
            for (int i = 1; i < n - 1; i++) {
                int i_mirror = 2 * C - i;
                if (R > i) {
                    P[i] = Math.min(R - i, P[i_mirror]);// 防止超出 R
                } else {
                    P[i] = 0;// 等于 R 的情况
                }
                // 碰到之前讲的三种情况时候，需要继续扩展
                while (T.charAt(i + 1 + P[i]) == T.charAt(i - 1 - P[i])) {
                    P[i]++;
                }

                // 判断是否需要更新 R
                if (i + P[i] > R) {
                    C = i;
                    R = i + P[i];
                }
            }
            // 找出 P 的最大值
            int maxLen = 0;
            int centerIndex = 0;
            for (int i = 1; i < n - 1; i++) {
                if (P[i] > maxLen) {
                    maxLen = P[i];
                    centerIndex = i;
                }
            }
            int start = (centerIndex - maxLen) / 2; //最开始讲的
            return s.substring(start, start + maxLen);
        }
    }

    public static void main(String[] args) {
        //Solution_1 Test
        String a = "aabbcc";
        String b = "";
        String c = "a";
        String d = "abccba";
        String e = "abccbd";
        System.out.println(Solution_5.longestPalindrome(a));
        System.out.println(Solution_5.longestPalindrome(b));
        System.out.println(Solution_5.longestPalindrome(c));
        System.out.println(Solution_5.longestPalindrome(d));
        System.out.println(Solution_5.longestPalindrome(e));
    }

}
