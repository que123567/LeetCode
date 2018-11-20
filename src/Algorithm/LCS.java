package Algorithm;

/**
 * Longest common substring
 * https://blog.csdn.net/u010397369/article/details/38979077
 */
public class LCS {

    public static int LCS(String str1, String str2) {
        int row = str1.length();
        int column = str2.length();
        if (row == 0 || column == 0) {
            return 0;
        }

        int temp[][] = new int[row][column];
        int maxLength = 0;

        //init first row
        for (int i = 0; i < row; i++) {
            if (str1.charAt(i) == str2.charAt(0)) {
                temp[i][0] = 1;
                maxLength = 1;
            }
        }
        //init first column
        for (int i = 0; i < column; i++) {
            if (str1.charAt(0) == str2.charAt(i)) {
                temp[0][i] = 1;
                maxLength = 1;
            }
        }

        for (int i = 1; i < row; i++) {
            for (int j = 1; j < column; j++) {
                if (str1.charAt(i) == str2.charAt(j)) {
                    temp[i][j] = temp[i - 1][j - 1] + 1;
                    maxLength = Math.max(maxLength, temp[i][j]);
                } else {
                    temp[i][j] = 0;
                }
            }
        }
        return maxLength;
    }

    public static void main(String[] args) {
        System.out.println(LCS("abcd", "oabcdefg"));
        System.out.println(LCS("", "oabcdefg"));
        System.out.println(LCS("", ""));
        System.out.println(LCS("abcd", "[ab]"));
        System.out.println(LCS("abcd", "[ac]"));
    }
}
