package medium;

import com.sun.org.apache.regexp.internal.RE;

import java.util.ArrayList;
import java.util.List;

/**
 * 54. Spiral Matrix
 * .
 * Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.
 * .
 * Example 1:
 * .
 * Input:
 * [
 * [ 1, 2, 3 ],
 * [ 4, 5, 6 ],
 * [ 7, 8, 9 ]
 * ]
 * Output: [1,2,3,6,9,8,7,4,5]
 * Example 2:
 * .
 * Input:
 * [
 * [1, 2, 3, 4],
 * [5, 6, 7, 8],
 * [9,10,11,12]
 * ]
 * Output: [1,2,3,4,8,12,11,10,9,5,6,7]
 */
public class LeetCode54 {

    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        if (matrix.length == 0) {
            return list;
        }
        int rowBegin = 0;
        int rowEnd = matrix.length - 1;
        int columBegin = 0;
        int columEnd = matrix[0].length - 1;
        while (rowBegin <= rowEnd && columBegin <= columEnd) {
            //right
            for (int i = columBegin; i <= columEnd; i++) {
                list.add(matrix[rowBegin][i]);
            }
            //down

            rowBegin++;
            for (int i = rowBegin; i <= rowEnd; i++) {
                list.add(matrix[i][columEnd]);
            }
            columEnd--;

            //left
            for (int i = columEnd; i >= columBegin; i--) {
                if (rowBegin <= rowEnd) {
                    list.add(matrix[rowEnd][i]);
                }
            }
            rowEnd--;
            //up
            for (int i = rowEnd; i >= rowBegin; i--) {
                if (columBegin <= columEnd) {
                    list.add(matrix[i][columBegin]);
                }
            }
            columBegin++;
        }
        return list;
    }

    public static void main(String[] args) {
        int[][] res = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        List<Integer> list = spiralOrder(res);
        for (int i : list) {
            System.out.print(i + " ");
        }

    }
}
