package easy;

/**
 * 832. Flipping an Image
 * .
 * Given a binary matrix A, we want to flip the image horizontally, then invert it, and return the resulting image.
 * .
 * To flip an image horizontally means that each row of the image is reversed.  For example, flipping [1, 1, 0] horizontally results in [0, 1, 1].
 * .
 * To invert an image means that each 0 is replaced by 1, and each 1 is replaced by 0. For example, inverting [0, 1, 1] results in [1, 0, 0].
 * .
 * Example 1:
 * .
 * Input: [[1,1,0],[1,0,1],[0,0,0]]
 * Output: [[1,0,0],[0,1,0],[1,1,1]]
 * Explanation: First reverse each row: [[0,1,1],[1,0,1],[0,0,0]].
 * Then, invert the image: [[1,0,0],[0,1,0],[1,1,1]]
 * Example 2:
 * .
 * Input: [[1,1,0,0],[1,0,0,1],[0,1,1,1],[1,0,1,0]]
 * Output: [[1,1,0,0],[0,1,1,0],[0,0,0,1],[1,0,1,0]]
 * Explanation: First reverse each row: [[0,0,1,1],[1,0,0,1],[1,1,1,0],[0,1,0,1]].
 * Then invert the image: [[1,1,0,0],[0,1,1,0],[0,0,0,1],[1,0,1,0]]
 * Notes:
 * .
 * 1 <= A.length = A[0].length <= 20
 * 0 <= A[i][j] <= 1
 */
public class LeetCode832 {


    public  static int[][] flipAndInvertImage(int[][] A) {
        for (int[] row : A) {
            revertAndInvert(row);
        }
        return A;
    }

    private static void revertAndInvert(int[] row) {
        for (int i = 0; i < row.length / 2; i++) {
            int temp = row[i];
            row[i] = row[row.length - i - 1];
            row[row.length - i - 1] = temp;
        }
        for (int i = 0; i < row.length; i++) {
            if (row[i] == 0) {
                row[i] = 1;
            } else {
                row[i] = 0;
            }
        }
    }

    public static void main(String[] args) {
        int[][] res = new int[][]{{1, 1, 0, 0}, {1, 0, 0, 1}, {0, 1, 1, 1}, {1, 0, 1, 0}};
        flipAndInvertImage(res);

        for (int i = 0; i < res[0].length; i++) {
            for (int j = 0; j < res.length; j++) {
                System.out.print(res[i][j]);
            }
            System.out.println();
        }
    }
}
