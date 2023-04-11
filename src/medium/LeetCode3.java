package medium;

import java.util.HashSet;
import java.util.Set;

/**
 * 3. Longest Substring Without Repeating Characters
 * 
 * Given a string, find the length of the longest substring without repeating characters.
 * 
 * Example 1:
 * 
 * Input: "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 * Example 2
 * 
 * Input: "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 * Example 3:
 * 
 * Input: "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3.
 * Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 */
public class LeetCode3 {


    /**
     * 暴力解法：遍历数组的所有的区间，然后找到最长没有重复字符的区间
     * 时间复杂度：O(n^3)
     * 空间复杂度：O(n)
     * 会超时
     */
    public static int lengthOfLongestSubstring_2(String s) {
        int tempMaxLength = 1;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j < s.length(); j++) {
                if (isAllUnique(s, i, j)) {
                    tempMaxLength = Math.max(tempMaxLength, j - i + 1);
                }
            }
        }
        return tempMaxLength;
    }

    public static boolean isAllUnique(String s, int start, int end) {
        Set<Character> set = new HashSet<>();
        for (int i = start; i <= end; i++) {
            if (set.contains(s.charAt(i))) {
                return false;
            }
            set.add(s.charAt(i));
        }
        return true;
    }


    /**
     * 2. 滑动窗口
     * 时间复杂度：O(2n) = O(n)，最坏的情况是 left 和 right 都遍历了一遍字符串
     * 空间复杂度：O(n)
     */
    public static int lengthOfLongestSubstring2(String s) {
        int length = s.length();
        if (length <= 1) {
            return length;
        }
        int maxLen = 1;
        int left = 0, right = 0;
        Set<Character> window = new HashSet<>();
        while (right < length) {
            char rightChar = s.charAt(right);
            while (window.contains(rightChar)) {
                window.remove(s.charAt(left));
                left++;
            }
            window.add(rightChar);
            maxLen = Math.max(maxLen, right - left + 1);
            right++;
        }
        return maxLen;
    }


    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring2(""));
        System.out.println(lengthOfLongestSubstring2("a"));
        System.out.println(lengthOfLongestSubstring2("aaa"));
        System.out.println(lengthOfLongestSubstring2("abcabc"));
        System.out.println(lengthOfLongestSubstring2("abcabcd"));
    }
}
