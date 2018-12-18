package easy;

/**
 * 821. Shortest Distance to a Character
 * .
 * Given a string S and a character C, return an array of integers representing the shortest distance from the character C in the string.
 * .
 * Example 1:
 * .
 * Input: S = "loveleetcode", C = 'e'
 * Output: [3, 2, 1, 0, 1, 0, 0, 1, 2, 2, 1, 0]
 */
public class LeetCode821 {
    /**
     * @param S
     * @param C
     * @return
     */
    public static int[] shortestToChar(String S, char C) {
        int n = S.length();
        int num = S.length() - S.replaceAll(String.valueOf(C), "").length();
        int indexInt[] = new int[num];

        int res[] = new int[S.length()];

        int index = 0;
        for (int i = 0; i < n; i++) {
            if (S.charAt(i) == C) {
                indexInt[index++] = i;
            }
        }

        for (int i = 0; i < S.length(); i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < indexInt.length; j++) {
                min = Math.min(Math.abs(indexInt[j] - i), min);
            }
            res[i] = min;
        }
        return res;
    }



    public static void main(String[] args) {
        String a = "loveleetcode";
        char b = 'e';
        int[] res = shortestToChar(a, b);
        for (int i = 0; i < res.length; i++) {
            System.out.println(res[i]);
        }

    }
}
