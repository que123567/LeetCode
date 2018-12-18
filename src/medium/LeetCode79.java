package medium;

/**
 * 79.Word Search
 * .
 * Given a 2D board and a word, find if the word exists in the grid.
 * .
 * The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.
 * .
 * Example:
 * .
 * board =
 * [
 * ['A','B','C','E'],
 * ['S','F','C','S'],
 * ['A','D','E','E']
 * ]
 * .
 * Given word = "ABCCED", return true.
 * Given word = "SEE", return true.
 * Given word = "ABCB", return false.
 */
public class LeetCode79 {

    static boolean[][] visited;

    public static boolean exist(char[][] board, String word) {
        int row = board.length;
        int column = board[0].length;
        visited = new boolean[row][column];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if (isExist(i, j, word.substring(1), board)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /**
     * four directions recursive
     *
     * @param x
     * @param y
     * @param word
     * @param boards
     * @return
     */
    public static boolean isExist(int x, int y, String word, char[][] boards) {
        if (word.length() == 0) {
            return true;
        }
        visited[x][y] = true;
        boolean top = false, bottom = false, left = false, right = false;

        if (x - 1 >= 0 && boards[x - 1][y] == word.charAt(0) && !visited[x - 1][y]) {
            left = isExist(x - 1, y, word.substring(1), boards);
        }
        if (x + 1 < boards.length && boards[x + 1][y] == word.charAt(0) && !visited[x + 1][y]) {
            right = isExist(x + 1, y, word.substring(1), boards);
        }
        if (y - 1 >= 0 && boards[x][y - 1] == word.charAt(0) && !visited[x][y - 1]) {
            top = isExist(x, y - 1, word.substring(1), boards);
        }
        if (y + 1 < boards[x].length && boards[x][y + 1] == word.charAt(0) && !visited[x][y + 1]) {
            bottom = isExist(x, y + 1, word.substring(1), boards);
        }
        if (top || bottom || left || right) {
            return true;
        }
        visited[x][y] = false;
        return false;
    }


    /**
     * a,b,e,j
     * b,c,f,k
     * e,f,i,n
     *
     * @param args
     */
    public static void main(String[] args) {
        char[][] board = new char[3][4];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 4; j++) {
                board[i][j] = (char) ((i * i + j * j) + 'a');
            }
        }
        System.out.println(exist(board, "kf"));
        System.out.println(exist(board, "kfc"));
        System.out.println(exist(board, "abej"));
        System.out.println(exist(board, "kfcb"));

        System.out.println(exist(board, "kfcba"));
        System.out.println(exist(board, "kfcbab"));
        System.out.println(exist(board, "kfcbabe"));
        System.out.println(exist(board, "kfcbabej"));
        System.out.println(exist(board, "kfcbabejk"));
    }
}
