package easy;

import java.util.*;

/**
 * 387. First Unique Character in a String
 * .
 * Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.
 * .
 * Examples:
 * .
 * s = "leetcode"
 * return 0.
 * .
 * s = "loveleetcode",
 * return 2.
 * Note: You may assume the string contain only lowercase letters.
 * .
 * Accepted
 * 191,408
 * Submissions
 * 399,144
 */
public class LeetCode387 {
    /**
     * @param s
     * @return
     */
    public static int firstUniqChar(String s) {
        int[] freq = new int[26];
        for (int i = 0; i < s.length(); i++) {
            freq[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < s.length(); i++) {
            if (freq[s.charAt(i) - 'a'] == 1) {
                return i;
            }
        }
        return -1;
    }

    /**
     * @param s
     * @return
     */
    public static int firstUniqueChar_(String s) {
        Map<Character, Integer> countMap = new HashMap<>();
        Map<Character, Integer> indexMap = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            int count = countMap.getOrDefault(s.charAt(i), 0) + 1;
            countMap.put(s.charAt(i), count);
            indexMap.put(s.charAt(i), i);
        }
        int minIndx = Integer.MAX_VALUE;
        for (char c : countMap.keySet()) {
            if (countMap.get(c) == 1) {
                minIndx = Math.min(indexMap.get(c), minIndx);
            }
        }
        if (minIndx != Integer.MAX_VALUE) {
            return minIndx;
        }
        return -1;
    }

    /**
     * @param s
     * @return
     */
    public int firstUniqChar_2(String s) {
        Map<Character, Integer> map = new LinkedHashMap<>();
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            if (set.contains(s.charAt(i))) {
                if (map.get(s.charAt(i)) != null) {
                    map.remove(s.charAt(i));
                }
            } else {
                map.put(s.charAt(i), i);
                set.add(s.charAt(i));
            }
        }
        return map.size() == 0 ? -1 : map.entrySet().iterator().next().getValue();
    }

    public static void main(String[] args) {
        System.out.println(firstUniqueChar_("loveleetcode"));

    }

}
