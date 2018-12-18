package easy;

import java.util.HashMap;
import java.util.Map;

/**
 * 383. Ransom Note
 * .
 * Given an arbitrary ransom note string and another string containing letters from all the magazines, write a function that will return true if the ransom note can be constructed from the magazines ; otherwise, it will return false.
 * .
 * Each letter in the magazine string can only be used once in your ransom note.
 * .
 * Note:
 * You may assume that both strings contain only lowercase letters.
 * .
 * canConstruct("a", "b") -> false
 * canConstruct("aa", "ab") -> false
 * canConstruct("aa", "aab") -> true
 */
public class LeetCode383 {

    /**
     * solution1
     *
     * @param ransomNote
     * @param magazine
     * @return
     */
    public static boolean canConstruct(String ransomNote, String magazine) {
        int[] chars = new int[26];
        for (int i = 0; i < magazine.length(); i++) {
            chars[magazine.charAt(i) - 'a']++;
        }
        for (int i = 0; i < ransomNote.length(); i++) {
            if (--chars[ransomNote.charAt(i) - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * solution2
     * map
     *
     * @param ransomNote
     * @param magazine
     * @return
     */
    public static boolean canConstruct_2(String ransomNote, String magazine) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : magazine.toCharArray()) {
            int count = map.getOrDefault(c, 0) + 1;
            map.put(c, count);
        }
        for (char c : ransomNote.toCharArray()) {
            int count = map.getOrDefault(c, 0) - 1;
            map.put(c, count);
            if (count < 0) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        String a = "aa";
        String b = "aab";

        String c = "a";
        String d = "b";

        String e = "aa";
        String f = "bb";

        System.out.println(canConstruct_2(a, b));
        System.out.println(canConstruct_2(c, d));
        System.out.println(canConstruct_2(e, f));
    }
}
