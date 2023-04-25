package Algorithm;

public class KMP {
    static int KMP(String t, String p) {
        int i = 0;
        int j = 0;
//        int[] next = new int[]{-1, 0, 0, 1, 2, 3, 4, 0};
        int[] next = new int[t.length() + 1];
        getNext(t, next);
        while (i < t.length() && j < p.length()) {
            if (j == -1 || t.charAt(i) == p.charAt(j)) {
                i++;
                j++;
            } else
                j = next[j];
        }

        if (j == p.length())
            return i - j;
        else
            return -1;
    }


    static void getNext(String p, int[] next) {
        next[0] = -1;
        int i = 0, j = -1;
        while (i < p.length()) {
            if (j == -1 || p.charAt(i) == p.charAt(j)) {
                ++i;
                ++j;
                next[i] = j;
            } else {
                j = next[j];
            }
        }
    }


    public static void main(String[] args) {
        String a = "abababca";
        String b = "ababc";

        System.out.println(KMP(a, b));
    }
}
