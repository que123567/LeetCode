package medium;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 187. Repeated DNA Sequences
 * <p>
 * All DNA is composed of a series of nucleotides abbreviated as A, C, G, and T, for example: "ACGAATTCCG". When studying DNA, it is sometimes useful to identify repeated sequences within the DNA.
 * <p>
 * Write a function to find all the 10-letter-long sequences (substrings) that occur more than once in a DNA molecule.
 * <p>
 * Example:
 * <p>
 * Input: s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"
 * <p>
 * Output: ["AAAAACCCCC", "CCCCCAAAAA"]
 */
public class LeetCode187 {


    /**
     * solution1
     * 滑动窗口+HashSet去重版本
     *
     * @param s
     * @return
     */
    public static List<String> findRepeatedDnaSequences(String s) {
        Set<String> seen = new HashSet<>(), dulplicate = new HashSet<>();
        for (int i = 0; i + 9 < s.length(); i++) {
            String subStr = s.substring(i, i + 10);
            //seen集合添加失败,说明已经添加过
            if (!seen.add(subStr)) {
                dulplicate.add(subStr);
            }
        }
        return new ArrayList<>(dulplicate);
    }

    /**
     * Solution2
     * (String转int存储)
     *
     * @param s
     * @return
     */
    public static List<String> findRepeatedDnaSequences_2(String s) {
        Set<Integer> words = new HashSet<>();
        Set<Integer> douleWords = new HashSet<>();

        List<String> res = new ArrayList<>();
        char[] chars = new char[26];
        chars['C' - 'A'] = 1;
        chars['G' - 'A'] = 2;
        chars['T' - 'A'] = 3;
        for (int i = 0; i < s.length() - 9; i++) {
            int v = 0;
            for (int j = i; j < i + 10; j++) {
                v <<= 2;
                v |= chars[s.charAt(j) - 'A'];
            }
            if (!words.add(v) && douleWords.add(v)) {
                res.add(s.substring(i, i + 10));
            }
        }
        return res;
    }

    public static void main(String[] args) {
        List<String> res1 = findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT");
        List<String> res2 = findRepeatedDnaSequences_2("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT");
        for (String s : res1) {
            System.out.println(s);
        }
        System.out.println();

        for (String s : res2) {
            System.out.println(s);
        }
    }
}
