package easy;

/**
 * 953. Verifying an Alien Dictionary
 * <p>
 * In an alien language, surprisingly they also use english lowercase letters, but possibly in a different order. The order of the alphabet is some permutation of lowercase letters.
 * <p>
 * Given a sequence of words written in the alien language, and the order of the alphabet, return true if and only if the given words are sorted lexicographicaly in this alien language.
 * <p>
 * Example 1:
 * <p>
 * Input: words = ["hello","leetcode"], order = "hlabcdefgijkmnopqrstuvwxyz"
 * Output: true
 * Explanation: As 'h' comes before 'l' in this language, then the sequence is sorted.
 * Example 2:
 * <p>
 * Input: words = ["word","world","row"], order = "worldabcefghijkmnpqstuvxyz"
 * Output: false
 * Explanation: As 'd' comes after 'l' in this language, then words[0] > words[1], hence the sequence is unsorted.
 * Example 3:
 * <p>
 * Input: words = ["apple","app"], order = "abcdefghijklmnopqrstuvwxyz"
 * Output: false
 * Explanation: The first three characters "app" match, and the second string is shorter (in size.) According to lexicographical rules "apple" > "app", because 'l' > '∅', where '∅' is defined as the blank character which is less than any other character (More info).
 * <p>
 * <p>
 * Note:
 * <p>
 * 1 <= words.length <= 100
 * 1 <= words[i].length <= 20
 * order.length == 26
 * All characters in words[i] and order are english lowercase letters.
 */
public class LeetCode935 {

    /**
     * Discuss version
     */
    class Solution {
        int[] mapping = new int[26];

        public boolean isAlienSorted(String[] words, String order) {
            for (int i = 0; i < order.length(); i++) {
                mapping[order.charAt(i) - 'a'] = i;
            }

            for (int i = 1; i < words.length; i++) {
                if (compare(words[i - 1], words[i]) > 0) {
                    return false;
                }
            }
            return true;
        }

        public int compare(String s1, String s2) {
            int n = s1.length(), m = s2.length(), cmp = 0;
            for (int i = 0, j = 0; i < n && j < m && cmp == 0; i++, j++) {
                cmp = mapping[s1.charAt(i) - 'a'] - mapping[s2.charAt(i) - 'a'];
            }
            return cmp == 0 ? n - m : cmp;
        }
    }

    /**
     * Offcial version
     */
    static class Solution_Official {
        public boolean isAlienSorted(String[] words, String order) {
            int[] index = new int[26];
            for (int i = 0; i < order.length(); ++i)
                index[order.charAt(i) - 'a'] = i;

            search:
            for (int i = 0; i < words.length - 1; ++i) {
                String word1 = words[i];
                String word2 = words[i + 1];

                // Find the first difference word1[k] != word2[k].
                for (int k = 0; k < Math.min(word1.length(), word2.length()); ++k) {
                    if (word1.charAt(k) != word2.charAt(k)) {
                        // If they compare badly, it's not sorted.
                        if (index[word1.charAt(k) - 'a'] > index[word2.charAt(k) - 'a'])
                            return false;
                        continue search;
                    }
                }

                // If we didn't find a first difference, the
                // words are like ("app", "apple").
                if (word1.length() > word2.length())
                    return false;
            }
            return true;
        }
    }

    public static void main(String[] args) {
        Solution_Official solutionOfficial = new Solution_Official();
        System.out.println(solutionOfficial.isAlienSorted(new String[]{"leetcode", "hello"}, "hlabcdefgijkmnopqrstuvwxyz"));
    }
}
