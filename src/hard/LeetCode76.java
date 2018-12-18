package hard;

import java.util.HashMap;
import java.util.Map;

/**
 * 76. Minimum Window Substring
 * .
 * Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).
 * .
 * Example:
 * .
 * Input: S = "ADOBECODEBANC", T = "ABC"
 * Output: "BANC"
 */
public class LeetCode76 {

    public static String minWindow(String s, String t) {
        if (t.length() > s.length()) {
            return "";
        }
        Map<Character, Integer> map = new HashMap<>();
        for (char c : t.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int count = map.size();
        int begin = 0, end = 0;
        int len = Integer.MAX_VALUE;
        int head = 0;
        while (end < s.length()) {
            char endC = s.charAt(end);
            if (map.containsKey(endC)) {
                map.put(endC, map.get(endC) - 1);
                if (map.get(endC) == 0) {
                    count--;
                }
            }
            end++;
            while (count == 0) {
                char beginC = s.charAt(begin);
                if (map.containsKey(beginC)) {
                    map.put(beginC, map.get(beginC) + 1);
                    if (map.get(beginC) > 0) {
                        count++;
                    }
                }
                if (end - begin < len) {
                    len = end - begin;
                    head = begin;
                }
                begin++;
            }
        }
        if (len == Integer.MAX_VALUE) {
            return "";
        }
        return s.substring(head, head + len);
    }

    public static void main(String[] args) {
        System.out.println(minWindow("a", "a"));
        System.out.println(minWindow("ADOBECODEBANC", "ABC"));
    }
}
