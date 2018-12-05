import java.util.*;

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

    /**
     * @param s
     * @param t
     * @return
     */
    public static List<Integer> slidingWindowTemplateByHarryChaoyangHe(String s, String t) {
        //init a collection or int value to save the result according the question.
        List<Integer> result = new LinkedList<>();
        if (t.length() > s.length())
            return result;

        //create a hashmap to save the Characters of the target substring.
        //(K, V) = (Character, Frequence of the Characters)
        Map<Character, Integer> map = new HashMap<>();
        for (char c : t.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        //maintain a counter to check whether match the target string.
        int counter = map.size();//must be the map size, NOT the string size because the char may be duplicate.

        //Two Pointers: begin - left pointer of the window; end - right pointer of the window
        int begin = 0, end = 0;

        //the length of the substring which match the target string.
        int len = Integer.MAX_VALUE;

        //loop at the begining of the source string
        while (end < s.length()) {

            char c = s.charAt(end);//get a character

            if (map.containsKey(c)) {
                map.put(c, map.get(c) - 1);// plus or minus one
                if (map.get(c) == 0)
                    counter--;//modify the counter according the requirement(different condition).
            }
            end++;

            //increase begin pointer to make it invalid/valid again
            while (counter == 0 /* counter condition. different question may have different condition */) {

                char tempc = s.charAt(begin);//***be careful here: choose the char at begin pointer, NOT the end pointer
                if (map.containsKey(tempc)) {
                    map.put(tempc, map.get(tempc) + 1);//plus or minus one
                    if (map.get(tempc) > 0)
                        counter++;//modify the counter according the requirement(different condition).
                }

                /* save / update(min/max) the result if find a target*/
                // result collections or result int value
                if (end - begin == t.length()) {
                    result.add(begin);
                }
                begin++;
            }
        }
        return result;
    }


    /**
     * sliding window
     *
     * @param s
     * @param p
     * @return
     */
    public static List<Integer> findAnagrams__(String s, String p) {
        List<Integer> list = new ArrayList<>();
        if (s.length() < p.length()) {
            return list;
        }
        Map<Character, Integer> charCountMap = new HashMap<>();

        for (char c : p.toCharArray()) {
            charCountMap.put(c, charCountMap.getOrDefault(c, 0) + 1);
        }
        int count = charCountMap.size();

        int begin = 0, end = 0;

        while (end < s.length()) {
            char endC = s.charAt(end);
            if (charCountMap.containsKey(endC)) {
                charCountMap.put(endC, charCountMap.get(endC) - 1);
                if (charCountMap.get(endC) == 0) {
                    count--;
                }
            }
            end++;
            while (count == 0) {
                char beginC = s.charAt(begin);
                if (charCountMap.containsKey(beginC)) {
                    charCountMap.put(beginC, charCountMap.get(beginC) + 1);
                    if (charCountMap.get(beginC) > 0) {
                        count++;
                    }
                }
                if (end - begin == p.length()) {
                    list.add(begin);
                }
                begin++;
            }
        }
        return list;
    }

    public static void main(String[] args) {

        List<Integer> res = findAnagrams__("cbaebabacd", "abc");

        for (int i : res) {
            System.out.println(i);
        }
    }
}
