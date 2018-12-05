import java.util.ArrayList;
import java.util.List;

/**
 * 438. Find All Anagrams in a String
 * <p>
 * Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.
 * <p>
 * Strings consists of lowercase English letters only and the length of both strings s and p will not be larger than 20,100.
 * <p>
 * The order of output does not matter.
 * <p>
 * Example 1:
 * <p>
 * Input:
 * s: "cbaebabacd" p: "abc"
 * <p>
 * Output:
 * [0, 6]
 * <p>
 * Explanation:
 * The substring with start index = 0 is "cba", which is an anagram of "abc".
 * The substring with start index = 6 is "bac", which is an anagram of "abc".
 * Example 2:
 * <p>
 * Input:
 * s: "abab" p: "ab"
 * <p>
 * Output:
 * [0, 1, 2]
 * <p>
 * Explanation:
 * The substring with start index = 0 is "ab", which is an anagram of "ab".
 * The substring with start index = 1 is "ba", which is an anagram of "ab".
 * The substring with start index = 2 is "ab", which is an anagram of "ab".
 */
public class LeetCode438 {

    /**
     * sliding window
     *
     * @param s
     * @param p
     * @return
     */
    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();

        return res;
    }


    /**
     * 暴力解法
     * T(M*N)
     *
     * @param s
     * @param p
     * @return
     */
    public static List<Integer> findAnagrams_(String s, String p) {
        List<Integer> res = new ArrayList<>();
        if (s == null || p == null || s.length() < p.length()) {
            return res;
        }
        for (int i = 0; i < s.length() - p.length() + 1; i++) {
            String str = s.substring(i, i + p.length());
            if (isChaosWord(str, p)) {
                res.add(i);
            }
        }
        return res;
    }

    public static boolean isChaosWord(String a, String b) {
        if (a == null || b == null || a.length() != b.length()) {
            return false;
        }
        int[] dics = new int[26];
        //store char appear times
        for (int i = 0; i < a.length(); i++) {
            dics[a.charAt(i) - 'a']++;
        }
        for (int i = 0; i < b.length(); i++) {
            dics[b.charAt(i) - 'a']--;
            if (dics[b.charAt(i) - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {


    }
}
