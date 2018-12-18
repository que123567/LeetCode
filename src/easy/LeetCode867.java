package easy;

/**
 * 867. Transpose Matrix
 * .
 * Given a matrix A, return the transpose of A.
 * .
 * The transpose of a matrix is the matrix flipped over it's main diagonal, switching the row and column indices of the matrix.
 * .
 * .
 * .
 * Example 1:
 * .
 * Input: [[1,2,3],[4,5,6],[7,8,9]]
 * Output: [[1,4,7],[2,5,8],[3,6,9]]
 * Example 2:
 * .
 * Input: [[1,2,3],[4,5,6]]
 * Output: [[1,4],[2,5],[3,6]]
 */
public class LeetCode867 {

    /**
     * @param A
     * @return
     */
    public static int[][] transpose(int[][] A) {
        int row = A.length;
        int column = A[0].length;
        int[][] B = new int[column][row];

        for (int i = 0; i < column; i++) {
            for (int j = 0; j < row; j++) {
                B[i][j] = A[j][i];
            }
        }
        return B;
    }

    public static void main(String[] args) {
        int[][] A = new int[][]{{1, 2, 3}, {3, 4, 5}};
        int[][] res = transpose(A);
        for (int[] array : res) {
            for (int i : array) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
