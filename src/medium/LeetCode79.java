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
     * 简洁版
     */
    public static class Solution2 {


        public static boolean exist(char[][] board, String word) {
            char[] words = word.toCharArray();
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[i].length; j++) {
                    if (dfs(board, words, i, j, 0)) {
                        return true;
                    }
                }
            }
            return false;
        }


        public static boolean dfs(char[][] board, char[] word, int i, int j, int index) {
            if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != word[index]) {
                return false;
            }
            if (index == word.length - 1) {
                return true;
            }
            char tmp = board[i][j];
            board[i][j] = '.';
            //注："||"逻辑运算符可短路，效率比|高。
            //此处用"|"超时；用"||"最高效时超过97% 的Java提交
            boolean res = dfs(board, word, i + 1, j, index + 1) || dfs(board, word, i - 1, j, index + 1) || dfs(board, word, i, j + 1, index + 1) || dfs(board, word, i, j - 1, index + 1);
            board[i][j] = tmp;
            return res;
        }


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
        System.out.println(Solution2.exist(board, "kf"));
        System.out.println(Solution2.exist(board, "kfc"));
        System.out.println(Solution2.exist(board, "abej"));
        System.out.println(Solution2.exist(board, "kfcb"));

        System.out.println(Solution2.exist(board, "kfcba"));
        System.out.println(Solution2.exist(board, "kfcbab"));
        System.out.println(Solution2.exist(board, "kfcbabe"));
        System.out.println(Solution2.exist(board, "kfcbabej"));
        System.out.println(Solution2.exist(board, "kfcbabejk"));
    }
}
