package easy;

/**
 * 541. Reverse String II
 * <p>
 * Given a string and an integer k, you need to reverse the first k characters for every 2k characters counting from the start of the string. If there are less than k characters left, reverse all of them. If there are less than 2k but greater than or equal to k characters, then reverse the first k characters and left the other as original.
 * Example:
 * Input: s = "abcdefg", k = 2
 * Output: "bacdfeg"
 * Restrictions:
 * The string consists of lower English letters only.
 * Length of the given string and k will in the range [1, 10000]
 */
public class LeetCode541 {
    /**
     * 0            k           2k          3k
     * |-----------|-----------|-----------|---
     * +--reverse--+           +--reverse--+
     */
    public static String reverseStr(String s, int k) {
        char[] chars = s.toCharArray();
        for (int left = 0; left < s.length(); left = left + 2 * k) {
            for (int i = left, j = Math.min(s.length() - 1, left + k - 1); i < j; i++, j--) {
                char tempChar = s.charAt(i);
                chars[i] = chars[j];
                chars[j] = tempChar;
            }
        }
        return new String(chars);
    }

    public static void main(String[] args) {
        System.out.println(reverseStr("abcdefg", 2));
    }
}
