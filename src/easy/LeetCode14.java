package easy;

import java.util.Arrays;

/**
 * 14. Longest Common Prefix
 * <p>
 * Write a function to find the longest common prefix string amongst an array of strings.
 * <p>
 * If there is no common prefix, return an empty string "".
 * <p>
 * Example 1:
 * <p>
 * Input: ["flower","flow","flight"]
 * Output: "fl"
 * Example 2:
 * <p>
 * Input: ["dog","racecar","car"]
 * Output: ""
 * Explanation: There is no common prefix among the input strings.
 */
public class LeetCode14 {

    /**
     * <--稍做优化版-->
     * 时间复杂度：最坏的情况就是 n 个 长度为 m 的完全一样的字符串，假设 S 是所有字符的和，那么 S = m * n，时间复杂度就是O（S）       当然正常情况下并不需要比较所有字符串，最多比较 n * minLen 个字符就可以了。
     * <p>
     * 空间复杂度：O（1），常数个额外空间。
     *
     * @param strs
     */
    public static String longestCommonPrefix_2(String[] strs) {
        if (strs == null || strs.length == 0)
            return "";
        for (int i = 0; i < strs[0].length(); i++) {
            char c = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                /**
                 * i == strs[j].length() 表明当前行已经到达末尾
                 * strs[j].charAt(i) != c  当前行和第 0 行字符不相等
                 */
                if (i == strs[j].length() || strs[j].charAt(i) != c)
                    return strs[0].substring(0, i);
            }
        }
        return strs[0];
    }

    /**
     * 将字符串水平排列，第 0 个和第 1 个字符串找最长子串，结果为 leet，再把结果和第 2 个字符串比较，结果为 leet，再把结果和第        3个字符串比较，结果为 lee，即为最终结果。
     *
     * @param strs
     * @return
     */
    public static String longestCommonPrefix_3(String[] strs) {
        if (strs.length == 0)
            return "";
        String prefix = strs[0]; // 保存结果
        // 遍历每一个字符串
        for (int i = 1; i < strs.length; i++) {
            // 找到上次得到的结果 prefix 和当前字符串的最长子串
            int minLen = Math.min(prefix.length(), strs[i].length());
            int j;
            for (j = 0; j < minLen; j++) {
                if (prefix.charAt(j) != strs[i].charAt(j)) {
                    break;
                }
            }
            prefix = prefix.substring(0, j);
        }
        return prefix;
    }

    /**
     * 递归
     *
     * @param strs
     */

    public static String longestCommonPrefix_4(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        return longgestCommonPrefix(strs, 0, strs.length - 1);
    }

    public static String longgestCommonPrefix(String[] strs, int left, int right) {
        if (left == right) {
            return strs[left];
        }
        int middle = (left + right) / 2;
        String leftPart = longgestCommonPrefix(strs, left, middle);
        String rightPart = longgestCommonPrefix(strs, middle + 1, right);
        return CommonPrefic(leftPart, rightPart);

    }

    private static String CommonPrefic(String leftPart, String rightPart) {
        int minLength = Math.min(leftPart.length(), rightPart.length());
        for (int i = 0; i < minLength; i++) {
            if (leftPart.charAt(i) != rightPart.charAt(i)) {
                return leftPart.substring(0, i);
            }
        }
        return leftPart.substring(0, minLength);
    }

    static class Solution5 {
        public static String longestCommonPrefix(String[] strs) {
            if (strs.length == 0 || strs == null) {
                return "";
            }
            return longestCommonPrefix(strs, 0, strs.length);
        }

        public static String longestCommonPrefix(String[] strs, int left, int right) {
            if (left == right) {
                return strs[left];
            }
            int middle = (left + right) / 2;
            String leftStr = longestCommonPrefix(strs, left, middle);
            String rightStr = longestCommonPrefix(strs, middle + 1, right);
            return commonPrefix(leftStr, rightStr);
        }

        private static String commonPrefix(String leftStr, String rightStr) {
            int minLength = Math.min(leftStr.length(), rightStr.length());
            for (int i = 0; i < minLength; i++) {
                if (leftStr.charAt(i) != rightStr.charAt(i)) {
                    return leftStr.substring(0, i);
                }
            }
            return leftStr.substring(0, minLength);
        }
    }


    public static String longestCommonPrefix_1(String[] strs) {
        if (strs == null)
            return null;
        if (strs.length == 0)
            return "";

        Arrays.sort(strs);//mark
        char[] first = strs[0].toCharArray();
        char[] last = strs[strs.length - 1].toCharArray();

        int i = 0, len = Math.min(first.length, last.length);
        while (i < len && first[i] == last[i])
            i++;
        return strs[0].substring(0, i);
    }

    public static void main(String[] args) {
        String[] strings = new String[4];
        strings[0] = "flower";
        strings[1] = "flo";
        strings[2] = "faot";
        strings[3] = "flent";

        System.out.println(longestCommonPrefix_1(strings));
    }
}
