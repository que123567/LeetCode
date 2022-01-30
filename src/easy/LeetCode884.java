package easy;

import java.util.*;

/**
 * 884. Uncommon Words from Two Sentences
 * .
 * We are given two sentences A and B.  (A sentence is a string of space separated words.  Each word consists only of lowercase letters.)
 * .
 * A word is uncommon if it appears exactly once in one of the sentences, and does not appear in the other sentence.
 * .
 * Return a list of all uncommon words.
 * .
 * You may return the list in any order.
 * .
 * .
 * .
 * Example 1:
 * .
 * Input: A = "this apple is sweet", B = "this apple is sour"
 * Output: ["sweet","sour"]
 * Example 2:
 * .
 * Input: A = "apple apple", B = "banana"
 * Output: ["banana"]
 * .
 * .
 * Note:
 * .
 * 0 <= A.length <= 200
 * 0 <= B.length <= 200
 * A and B both contain only spaces and lowercase letters.
 */
public class LeetCode884 {

    /**
     * WARNIG!
     * JAVA8 Stream的执行效率不高
     */
    /**
     * @param A
     * @param B
     * @return
     */
    public static String[] uncommonFromSentences(String A, String B) {
        Map<String, Integer> map = new HashMap<>();
        String[] res = (A + " " + B).split("\\s");
        for (String s : res) {
            map.put(s, map.getOrDefault(s, 0) + 1);
        }
        return map.entrySet().stream().filter(e -> e.getValue() == 1).map(e -> e.getKey()).toArray(String[]::new);

    }

    /**
     * @param A
     * @param B
     * @return
     */
    public static String[] uncommonFromSentences_1(String A, String B) {
        Map<String, Integer> count = new HashMap<>();
        for (String s : (A + " " + B).split("\\s")) {
            count.put(s, count.getOrDefault(s, 0) + 1);
        }
        return count.entrySet().stream().filter(e -> e.getValue() == 1).map(e -> e.getKey()).toArray(String[]::new);
    }

    /**
     * @param A
     * @param B
     * @return
     */
    public static String[] uncommonFromSentences_2(String A, String B) {
        Set<String> distinct = new HashSet<>(), com = new HashSet<>();
        for (String s : (A + " " + B).split("\\s")) {
            if (com.contains(s) || !distinct.add(s)) {
                distinct.remove(s);
                com.add(s);
            }
        }
        return distinct.toArray(new String[0]);
    }

    /**
     * @param A
     * @param B
     * @return
     */
    public String[] uncommonFromSentences_3(String A, String B) {
        String C = A + " " + B;
        HashMap<String, Integer> map = new HashMap<>();
        for (String word : C.split(" "))
            map.put(word, map.getOrDefault(word, 0) + 1);
        Iterator<Map.Entry<String, Integer>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, Integer> entry = it.next();
            if (entry.getValue() > 1) {
                it.remove();
            }
        }
        return map.keySet().toArray(new String[0]);
    }

    public String[] uncommonFromSentences_4(String s1, String s2) {
        String[] splitStr = (s1 + " " + s2).split(" ");
        HashMap<String, Integer> map = new HashMap<>();
        for (String str : splitStr) {
            map.put(str, map.getOrDefault(str, 0) + 1);
        }
        List<String> res = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                res.add(entry.getKey());
            }
        }
        return res.toArray(new String[0]);
    }

    public static void main(String[] args) {
        String A = "this apple is sweet", B = "this apple is sour";
        String C = "apple apple", D = "banana";
        String E = "gw pk xy", F = "gw aje zqd";

        String[] a = uncommonFromSentences(E, F);
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }

    }
}
