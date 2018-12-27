package easy;

/**
 * 242. Valid Anagram
 * .
 * Given two strings s and t , write a function to determine if t is an anagram of s.
 * .
 * Example 1:
 * .
 * Input: s = "anagram", t = "nagaram"
 * Output: true
 * Example 2:
 * .
 * Input: s = "rat", t = "car"
 * Output: false
 * Note:
 * You may assume the string contains only lowercase alphabets.
 * .
 * Follow up:
 * What if the inputs contain unicode characters? How would you adapt your solution to such case?
 */
public class LeetCode242 {

    /**
     * My version
     *
     * @param s
     * @param t
     * @return
     */
    public static boolean isAnagram(String s, String t) {
        if (s == null || t == null || s.length() != t.length()) {
            return false;
        }
        int[] map1 = new int[26];
        int[] map2 = new int[26];
        for (int i = 0; i < s.length(); i++) {
            map1[s.charAt(i) - 'a']++;
            map2[t.charAt(i) - 'a']++;
        }
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map1[c - 'a'] != map2[c - 'a']) {
                return false;
            }
        }
        return true;
    }

    /**
     * simplyfied version
     * @param s
     * @param t
     * @return
     */
    public static boolean isAnagram_(String s, String t) {
        int[] alphabet = new int[26];
        for (int i = 0; i < s.length(); i++)alphabet[s.charAt(i) - 'a']++;
        for (int i = 0; i < t.length(); i++)alphabet[t.charAt(i) - 'a']--;
        for (int i : alphabet)
            if (i != 0)
                return false;
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isAnagram("anagram", "nagaram"));
    }
}
