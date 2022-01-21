package hard;

import java.util.ArrayList;
import java.util.List;

public class LeetCode51 {
    static List<List<String>> res = new ArrayList<>();

    public static List<List<String>> solveNQueens(int n) {
        List<String> board = new ArrayList<>(n);
        for (int i = 0; i <n ; i++) {
            board.add(".".repeat(n));
        }
        backTrack(board, 0);
        return res;
    }

    private static void backTrack(List<String> board, int row) {
        if (row == board.get(0).length()) {
            res.add(new ArrayList<>(board));
        } else {
            for (int col = 0; col < board.size(); col++) {
                if (!isValidQ(board, row, col)) {
                    continue;
                }
                board.set(row, replaceString(board.get(row), row, col, 'Q'));
                backTrack(board, row + 1);
                board.set(row, replaceString(board.get(row), row, col, '.'));
            }
        }
    }

    private static String replaceString(String a, int row, int col, char c) {
        StringBuilder sb = new StringBuilder(a);
        sb.setCharAt(col, c);
        return sb.toString();
    }

    private static boolean isValidQ(List<String> board, int row, int col) {
        //up
        for (int i = row - 1; i >= 0; i--) {
            if (board.get(i).charAt(col) == 'Q') {
                return false;
            }
        }
        //left up
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board.get(i).charAt(j) == 'Q') {
                return false;
            }
        }
        //right up
        for (int i = row - 1, j = col + 1; i >= 0 && j < board.size(); i--, j++) {
            if (board.get(i).charAt(j) == 'Q') {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        List<List<String>> res = solveNQueens(4);
        int i = 1;
    }
}
