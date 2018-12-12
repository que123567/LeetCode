package middle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 890. Find and Replace Pattern
 * <p>
 * You have a list of words and a pattern, and you want to know which words in words matches the pattern.
 * <p>
 * A word matches the pattern if there exists a permutation of letters p so that after replacing every letter x in the pattern with p(x), we get the desired word.
 * <p>
 * (Recall that a permutation of letters is a bijection from letters to letters: every letter maps to another letter, and no two letters map to the same letter.)
 * <p>
 * Return a list of the words in words that match the given pattern.
 * <p>
 * You may return the answer in any order.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: words = ["abc","deq","mee","aqq","dkd","ccc"], pattern = "abb"
 * Output: ["mee","aqq"]
 * Explanation: "mee" matches the pattern because there is a permutation {a -> m, b -> e, ...}.
 * "ccc" does not match the pattern because {a -> c, b -> c, ...} is not a permutation,
 * since a and b map to the same letter.
 * <p>
 * <p>
 * Note:
 * <p>
 * 1 <= words.length <= 50
 * 1 <= pattern.length = words[i].length <= 20
 */
public class LeetCode890 {

    public static List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> list = new ArrayList<>();
        for (String word : words) {
            if (isMatch(word, pattern)) {
                list.add(word);
            }
        }
        return list;
    }

    /**
     * "abb"->"122"
     *
     * @param a
     * @param b
     * @return
     */
    public static boolean isMatch(String a, String b) {
        if (a.length() != b.length())
            return false;
        Map<Character, Character> map1 = new HashMap<>();
        Map<Character, Character> map2 = new HashMap<>();
        for (int i = 0; i < a.length(); i++) {
            char charA = a.charAt(i);
            char charB = b.charAt(i);
            if (!map1.containsKey(charA)) {
                map1.put(charA, charB);
            }
            if (!map2.containsKey(charB)) {
                map2.put(charB, charA);
            }
            if (map1.get(charA) != charB || map2.get(charB) != charA) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String[] a = new String[]{"abc", "deq", "mee", "aqq", "dkd", "ccc"};
        List<String> res = findAndReplacePattern(a, "122");
        for (String str : res) {
            System.out.print(str + " ");
        }
    }
}
