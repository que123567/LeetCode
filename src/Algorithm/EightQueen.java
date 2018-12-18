package Algorithm;

/**
 * 8皇后问题
 */
public class EightQueen {

    /**
     * https://www.cnblogs.com/bigmoyan/p/4521683.html
     */
    static int n = 8;
    static int total = 0;
    static int[] c = new int[100];

    public static boolean isOK(int row) {
        for (int j = 0; j != row; j++) {
            if (c[row] == c[j] || row - c[row] == j - c[j] || row + c[row] == j + c[j])
                return false;
        }
        return true;
    }

    public static void queen(int row) {
        if (row == n) {
            total++;
        } else {
            for (int col = 0; col < n; col++) {
                c[row] = col;
                if (isOK(row)) {
                    queen(row + 1);
                }
            }
        }
    }

    /**
     *
     */

    public static void main(String[] args) {
        queen(0);
        System.out.println(total);
    }
}
